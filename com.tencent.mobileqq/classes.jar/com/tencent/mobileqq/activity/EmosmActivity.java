package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.emosm.view.DragSortController;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.emosm.view.DragSortListView.DropListener;
import com.tencent.mobileqq.emosm.view.DragSortListView.RemoveListener;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

@RoutePage(desc="表情管理页", path="/base/activity/EmosmActivity")
public class EmosmActivity
  extends QIphoneTitleBarActivity
  implements View.OnClickListener
{
  static final String TAG = "EmosmActivity";
  BaseQQAppInterface app;
  EmoticonObserver emosObserver = new EmosmActivity.1(this);
  View emosmCameraCon;
  View emosmCameraIcon;
  View emosmCameraName;
  View emosmFavCon;
  View emosmFavIcon;
  TextView emosmFavName;
  View emosmMagicCon;
  View emosmMagicIcon;
  View emosmMagicName;
  boolean hasMagic = false;
  View headerView;
  WeakReference<Activity> mActivity = new WeakReference(this);
  DragSortAdapter<EmoticonPackage> mAdapter;
  private QQBlurView mBottomBlurView;
  IEmoticonManagerService mDBManager;
  Button mDeleteButton;
  EmoticonPackageChangedListener mEPChangeListener;
  ArrayList<EmoticonPackage> mEPDatas = new ArrayList();
  EmoticonPackageDownloadListener mEPDownloadListener;
  boolean mIsChange;
  boolean mIsEdited;
  int mLaunchMode;
  int mLaunchSource;
  DragSortListView mListView;
  boolean mRedirect;
  Runnable mRefreshTask;
  private View mSpaceLine;
  TextView mTipFinish;
  TextView mTitleRight;
  DragSortListView.DropListener onDrop = new EmosmActivity.12(this);
  DragSortListView.RemoveListener onRemove = new EmosmActivity.13(this);
  public QQProgressDialog progressDialog;
  
  private void initBlur()
  {
    this.mBottomBlurView = ((QQBlurView)findViewById(2131429645));
    this.mBottomBlurView = ((QQBlurView)findViewById(2131429645));
    this.mSpaceLine = findViewById(2131446193);
    this.mSpaceLine.setBackgroundColor(getResources().getColor(2131166013));
    this.mBottomBlurView.a(findViewById(2131432459));
    Object localObject = this.mBottomBlurView;
    ((QQBlurView)localObject).b((View)localObject);
    localObject = getResources().getDrawable(2130852507);
    ((Drawable)localObject).setAlpha(235);
    this.mBottomBlurView.a((Drawable)localObject);
    this.mBottomBlurView.b(0);
    this.mBottomBlurView.a(8.0F);
    this.mBottomBlurView.a(4);
    this.mBottomBlurView.d();
  }
  
  private void reportEmoticonOperateMonitor(EmoticonResp paramEmoticonResp)
  {
    if (paramEmoticonResp != null)
    {
      int i = 0;
      while (i < this.mAdapter.getCount())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.mAdapter.getItem(i);
        String str = localEmoticonPackage.epId;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramEmoticonResp.delEpId);
        localStringBuilder.append("");
        if (str.equals(localStringBuilder.toString()))
        {
          if (localEmoticonPackage.type == 1) {
            i = 5;
          } else {
            i = 4;
          }
          EmoticonOperateReport.reportEmoticonOperateMonitorDeleteStatus(String.valueOf(paramEmoticonResp.resultcode), i);
          return;
        }
        i += 1;
      }
    }
  }
  
  public DragSortController buildController(DragSortListView paramDragSortListView)
  {
    paramDragSortListView = new DragSortController(paramDragSortListView);
    paramDragSortListView.d(2131432152);
    paramDragSortListView.e(2131430779);
    paramDragSortListView.b(true);
    paramDragSortListView.a(true);
    paramDragSortListView.a(0);
    paramDragSortListView.b(0);
    paramDragSortListView.c(2);
    return paramDragSortListView;
  }
  
  void changeMagicHeaderVisibility()
  {
    if (this.hasMagic) {
      return;
    }
    this.mDBManager.asyncGetTabEmoticonPackages(0, new EmosmActivity.9(this));
  }
  
  void dismissDialog()
  {
    if (this.mIsEdited) {
      setTitle(String.format(getResources().getString(2131889109), new Object[] { Integer.valueOf(0) }));
    }
    this.progressDialog.dismiss();
    if ((this.mLaunchMode == 2) && (this.mAdapter.getCount() == 0)) {
      ReportController.b(MobileQQ.sMobileQQ.waitAppRuntime(null), "CliOper", "", "", "0X80060AA", "0X80060AA", 0, 0, "", "", "", "");
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131627950);
    super.setContentBackgroundResource(2130838958);
    super.setTitle(2131889117);
    this.app = ((BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    parseOptions();
    this.mTitleRight = this.rightViewText;
    this.mTitleRight.setVisibility(0);
    this.mTitleRight.setText(2131889108);
    this.mTitleRight.setOnClickListener(new EmosmActivity.3(this));
    this.mDeleteButton = ((Button)findViewById(2131430150));
    this.mDeleteButton.setOnClickListener(this);
    this.mTipFinish = ((TextView)findViewById(2131432710));
    this.mTipFinish.setOnClickListener(new EmosmActivity.4(this));
    try
    {
      this.mListView = ((DragSortListView)findViewById(16908298));
      paramBundle = buildController(this.mListView);
      this.mListView.setFloatViewManager(paramBundle);
      this.mListView.setOnTouchListener(paramBundle);
      this.mListView.setDragEnabled(false);
      this.mListView.setDelImmediately(false);
      this.headerView = View.inflate(this.mListView.getContext(), 2131627951, null);
      this.emosmFavCon = this.headerView.findViewById(2131432448);
      this.emosmFavIcon = this.headerView.findViewById(2131432449);
      this.emosmFavName = ((TextView)this.headerView.findViewById(2131432450));
      this.emosmFavCon.setOnClickListener(this);
      this.emosmFavCon.setBackgroundDrawable(getResources().getDrawable(2130840100));
      this.emosmCameraCon = this.headerView.findViewById(2131432444);
      this.emosmCameraIcon = this.headerView.findViewById(2131432445);
      this.emosmCameraName = this.headerView.findViewById(2131432446);
      this.emosmCameraCon.setOnClickListener(this);
      this.emosmCameraCon.setBackgroundDrawable(getResources().getDrawable(2130840100));
      this.emosmMagicCon = this.headerView.findViewById(2131432461);
      this.emosmMagicIcon = this.headerView.findViewById(2131432462);
      this.emosmMagicName = this.headerView.findViewById(2131432463);
      this.emosmMagicCon.setBackgroundResource(2130840100);
      this.emosmMagicCon.setOnClickListener(this);
      this.mListView.addHeaderView(this.headerView);
      this.mDBManager = ((IEmoticonManagerService)this.app.getRuntimeService(IEmoticonManagerService.class));
      paramBundle = getIntent();
      this.mLaunchMode = paramBundle.getIntExtra("extra_launch_mode", 1);
      this.mRefreshTask = new EmosmActivity.5(this);
      this.mRefreshTask.run();
      this.mAdapter = new DragSortAdapter(this, this.mEPDatas);
      DragSortAdapter localDragSortAdapter = this.mAdapter;
      localDragSortAdapter.e = -16745986;
      this.mListView.setAdapter(localDragSortAdapter);
      this.mListView.setDropListener(this.onDrop);
      this.mListView.setRemoveListener(this.onRemove);
      this.mListView.setOnItemClickListener(new EmosmActivity.6(this));
      this.mRedirect = false;
      this.mEPChangeListener = new EmosmActivity.7(this);
      EmojiListenerManager.a().a(this.mEPChangeListener);
      this.mEPDownloadListener = new EmosmActivity.8(this);
      EmojiListenerManager.a().addEmoticonPackageDownloadListener(this.mEPDownloadListener);
      this.mLaunchSource = paramBundle.getIntExtra("extra_launch_source", 2);
      int i = this.mLaunchSource;
      if ((i == 2) || (i == 1))
      {
        this.mDeleteButton.setVisibility(8);
        this.mIsEdited = false;
        this.mTitleRight.setText(2131889108);
        this.mListView.setDragEnabled(false);
        this.mAdapter.a(false);
        this.mAdapter.notifyDataSetChanged();
      }
      initBlur();
      onChangeLaunchMode(1);
      this.progressDialog = new QQProgressDialog(this);
      super.addObserver(this.emosObserver);
      ReportController.b(this.app, "CliOper", "", "", "ep_mall", "View_mine", 0, 0, "", "", "", "");
      return true;
    }
    catch (OutOfMemoryError paramBundle)
    {
      this.mListView = null;
      if (QLog.isColorLevel()) {
        QLog.e("EmosmActivity", 2, paramBundle.getMessage());
      }
    }
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.emosObserver);
    EmojiListenerManager.a().b(this.mEPChangeListener);
    EmojiListenerManager.a().removeEmoticonPackageDownloadListener(this.mEPDownloadListener);
    QQBlurView localQQBlurView = this.mBottomBlurView;
    if (localQQBlurView != null) {
      localQQBlurView.c();
    }
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmosmActivity", 2, "emosm activity ..............onPause");
    }
    super.doOnPause();
    QQBlurView localQQBlurView = this.mBottomBlurView;
    if (localQQBlurView != null) {
      localQQBlurView.b();
    }
  }
  
  protected void doOnResume()
  {
    this.mRedirect = false;
    if (QLog.isColorLevel()) {
      QLog.d("EmosmActivity", 2, "emosm activity ..............onResume");
    }
    ((EmoticonHandler)this.app.getBusinessHandler(EmoticonHandler.a)).a(0, 0);
    QQBlurView localQQBlurView = this.mBottomBlurView;
    if (localQQBlurView != null) {
      localQQBlurView.a();
    }
    super.doOnResume();
  }
  
  void editChange(boolean paramBoolean)
  {
    Object localObject = this.emosmFavIcon;
    float f2 = 0.5F;
    float f1;
    if (paramBoolean) {
      f1 = 0.5F;
    } else {
      f1 = 1.0F;
    }
    ((View)localObject).setAlpha(f1);
    localObject = this.emosmFavName;
    if (paramBoolean) {
      f1 = 0.5F;
    } else {
      f1 = 1.0F;
    }
    ((TextView)localObject).setAlpha(f1);
    localObject = this.emosmCameraIcon;
    if (paramBoolean) {
      f1 = 0.5F;
    } else {
      f1 = 1.0F;
    }
    ((View)localObject).setAlpha(f1);
    localObject = this.emosmCameraName;
    if (paramBoolean) {
      f1 = 0.5F;
    } else {
      f1 = 1.0F;
    }
    ((View)localObject).setAlpha(f1);
    localObject = this.emosmMagicIcon;
    if (paramBoolean) {
      f1 = 0.5F;
    } else {
      f1 = 1.0F;
    }
    ((View)localObject).setAlpha(f1);
    localObject = this.emosmMagicName;
    if (paramBoolean) {
      f1 = f2;
    } else {
      f1 = 1.0F;
    }
    ((View)localObject).setAlpha(f1);
    this.emosmFavCon.setEnabled(paramBoolean ^ true);
    this.emosmCameraCon.setEnabled(paramBoolean ^ true);
    this.emosmMagicCon.setEnabled(paramBoolean ^ true);
  }
  
  void fillData()
  {
    Button localButton = this.mDeleteButton;
    if ((localButton != null) && (localButton.getVisibility() == 0)) {
      this.mDeleteButton.setEnabled(false);
    }
    this.mDBManager.asyncGetTabEmoticonPackages(0, new EmosmActivity.10(this));
  }
  
  public void finish()
  {
    EmojiListenerManager.a().b(this.mEPChangeListener);
    EmojiListenerManager.a().removeEmoticonPackageDownloadListener(this.mEPDownloadListener);
    this.mAdapter.c();
    super.finish();
  }
  
  protected boolean onBackEvent()
  {
    if (this.mLaunchMode != 1)
    {
      if (this.mIsEdited)
      {
        this.mTitleRight.setText(2131889108);
        this.mListView.setDragEnabled(false);
        this.mAdapter.a(false);
        this.mIsEdited = false;
        this.mDeleteButton.setVisibility(8);
        editChange(this.mIsEdited);
      }
      onChangeLaunchMode(1);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onChangeLaunchMode(int paramInt)
  {
    if (this.mLaunchMode == paramInt) {
      return;
    }
    this.mLaunchMode = paramInt;
    this.mIsChange = false;
    runOnUiThread(this.mRefreshTask);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject1;
    if (i == 2131430150)
    {
      if (!NetworkUtil.isNetSupport(this))
      {
        localObject1 = new QQToast(this);
        ((QQToast)localObject1).setToastIcon(2130839752);
        ((QQToast)localObject1).setDuration(1500);
        ((QQToast)localObject1).setToastMsg(HardCodeUtil.a(2131902072));
        ((QQToast)localObject1).show(0);
      }
      else
      {
        this.progressDialog.a(getString(2131888895));
        this.progressDialog.show();
        Object localObject3 = this.mAdapter.a();
        if (((List)localObject3).size() > 0)
        {
          URLDrawable.clearMemoryCache();
          Object localObject2 = (EmoticonHandler)this.app.getBusinessHandler(EmoticonHandler.a);
          localObject1 = new ArrayList();
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((ArrayList)localObject1).add(Integer.valueOf(Integer.parseInt(((EmoticonPackage)((Iterator)localObject3).next()).epId)));
          }
          ((EmoticonHandler)localObject2).a((ArrayList)localObject1);
          this.mDeleteButton.setEnabled(false);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("delete packages:");
            ((StringBuilder)localObject2).append(((ArrayList)localObject1).toString());
            QLog.d("EmosmActivity", 2, ((StringBuilder)localObject2).toString());
          }
          ReportController.b(this.app, "CliOper", "", "", "EmosSetting", "EpDelete", 0, 0, "", "", "", "");
          if (this.mLaunchMode == 1) {
            ReportController.b(this.app, "dc00898", "", "", "0X800AB12", "0X800AB12", ((ArrayList)localObject1).size(), 0, "", "", "", "");
          } else {
            ReportController.b(this.app, "dc00898", "", "", "0X800AB19", "0X800AB19", ((ArrayList)localObject1).size(), 0, "", "", "", "");
          }
        }
      }
    }
    else if (i == 2131432448)
    {
      startActivity(new Intent(this, FavEmosmManageActivity.class));
      ReportController.b(this.app, "dc00898", "", "", "0X800AB0B", "0X800AB0B", 0, 0, "", "", "", "");
    }
    else if (i == 2131432444)
    {
      localObject1 = new Intent(this, FavEmosmManageActivity.class);
      ((Intent)localObject1).putExtra("camera_emo_mode", 1);
      startActivity((Intent)localObject1);
      ReportController.b(this.app, "dc00898", "", "", "0X800AB0C", "0X800AB0C", 0, 0, "", "", "", "");
    }
    else if (i == 2131432461)
    {
      onChangeLaunchMode(2);
      ReportController.b(this.app, "dc00898", "", "", "0X800AB0D", "0X800AB0D", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onRestart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "emosm activity ..............onRestart");
    }
    super.onRestart();
  }
  
  void parseOptions()
  {
    String str = getIntent().getStringExtra("options");
    try
    {
      if (TextUtils.isEmpty(str))
      {
        this.leftView.setText(2131888883);
        return;
      }
      str = new JSONObject(str).optString("leftText", getString(2131888883));
      this.leftView.setText(str);
      return;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmosmActivity", 2, localJSONException.getMessage());
      }
    }
  }
  
  public void saveChangeToDB()
  {
    if (this.mIsChange) {
      this.mDBManager.asyncGetTabEmoticonPackages(0, new EmosmActivity.11(this));
    }
  }
  
  void showAuthErrorTips()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.setToastIcon(2130839752);
    localQQToast.setDuration(1500);
    localQQToast.setToastMsg(HardCodeUtil.a(2131902073));
    localQQToast.show(0);
  }
  
  void updatePackageStatus(int paramInt)
  {
    this.mAdapter.b(true);
    int i = 0;
    while (i < this.mAdapter.getCount())
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.mAdapter.getItem(i);
      String str = localEmoticonPackage.epId;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      if (str.equals(localStringBuilder.toString()))
      {
        this.mAdapter.a(localEmoticonPackage);
        if (localEmoticonPackage.type == 1) {
          paramInt = 5;
        } else {
          paramInt = 4;
        }
        EmoticonOperateReport.reportEmoticonOperateMonitorDeleteStatus("0", paramInt);
        str = localEmoticonPackage.epId;
        if ((3 != localEmoticonPackage.jobType) && (1 != localEmoticonPackage.jobType) && (5 != localEmoticonPackage.jobType)) {
          ThreadManager.getFileThreadHandler().post(new EmosmActivity.2(this, str));
        }
        if (3 != localEmoticonPackage.jobType) {
          break;
        }
        ReportController.b(MobileQQ.sMobileQQ.waitAppRuntime(null), "CliOper", "", "", "MbGuanli", "MbDianjiShanchu", 0, 0, "", "", "", "");
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity
 * JD-Core Version:    0.7.0.1
 */