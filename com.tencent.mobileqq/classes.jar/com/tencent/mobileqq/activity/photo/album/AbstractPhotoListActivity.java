package com.tencent.mobileqq.activity.photo.album;

import Override;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.queryMedia.MediaQueryHelper;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.PhotoGridView;
import com.tencent.widget.PhotoGridView.OnSelectListener;
import com.tencent.widget.TriangleView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public abstract class AbstractPhotoListActivity
  extends PeakFragmentActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AbstractAlbumListFragment.IAlbumListChoose
{
  static final int COLUMN_COUNT = 3;
  static final String SHARE_PREFERENCE_NAME = "share";
  public static final String TAG = "PhotoListActivity";
  public FrameLayout albumListContainer;
  public AbstractAlbumListFragment albumListFragment;
  public View bottomBar;
  public GridLayoutManager gridLayoutManager;
  int mEdgePadding;
  public PhotoGridView mGridView;
  int mHorizontalSpacing;
  public int mImageHeight;
  public int mImageWidth;
  int mItemPadding;
  PhotoGridView.OnSelectListener mOnSelectChangeListener = new AbstractPhotoListActivity.1(this);
  public PhotoListBaseData mPhotoListData;
  public PhotoListLogicBase mPhotoListLogic;
  public int mTitleBarHeight;
  int mVerticalSpacing;
  Dialog pd;
  public AbstractPhotoListActivity.PhotoListAdapter photoListAdapter = null;
  SharedPreferences pref;
  public Button previewBtn;
  public AsyncTask<Object, Object, List<LocalMediaInfo>> queryPhotoTask;
  public Button sendBtn;
  public TriangleView titleImage;
  public LinearLayout titleLayout;
  public TextView titleLeftBtn;
  public TextView titleText;
  
  public static String formatTimeToString(long paramLong)
  {
    paramLong /= 1000L;
    int i = (int)paramLong % 60;
    int j = (int)paramLong / 60;
    String str1;
    if (i > 9)
    {
      str1 = String.valueOf(i);
      if (j <= 9) {
        break label102;
      }
    }
    label102:
    for (String str2 = String.valueOf(j);; str2 = "0" + String.valueOf(j))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2).append(":").append(str1);
      return localStringBuilder.toString();
      str1 = "0" + String.valueOf(i);
      break;
    }
  }
  
  public static void rotate180Degrees(View paramView, boolean paramBoolean)
  {
    float f2 = 180.0F;
    if (paramBoolean) {}
    for (float f1 = 180.0F;; f1 = 0.0F)
    {
      if (paramBoolean) {
        f2 = 360.0F;
      }
      RotateAnimation localRotateAnimation = new RotateAnimation(f1, f2, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(300L);
      localRotateAnimation.setFillAfter(true);
      paramView.startAnimation(localRotateAnimation);
      return;
    }
  }
  
  public void cancleProgressDailog()
  {
    if (this.pd != null) {}
    try
    {
      this.pd.cancel();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PhotoListActivity", 2, "cancel dialog error", localIllegalArgumentException);
    }
  }
  
  @TargetApi(8)
  File createImageFile()
  {
    Object localObject = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String str = "JPEG_" + (String)localObject + "_";
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      boolean bool = false;
      if (Build.VERSION.SDK_INT > 7)
      {
        localObject = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        bool = true;
      }
      while (bool)
      {
        localObject = File.createTempFile(str, ".jpg", (File)localObject);
        this.mPhotoListData.currentPhotoPath = ((File)localObject).getAbsolutePath();
        return localObject;
        File localFile = new File(Environment.getExternalStorageDirectory(), "DCIM");
        localObject = localFile;
        if (!localFile.exists())
        {
          bool = localFile.mkdirs();
          localObject = localFile;
        }
      }
    }
    return null;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.mPhotoListLogic.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity onCreate(),extra is:" + paramBundle.getExtras());
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity,hashCode is:" + System.identityHashCode(this));
    }
    getWindow().setBackgroundDrawable(null);
    super.adjustStatusBar();
    try
    {
      super.setContentView(2131561336);
      getWindow().setBackgroundDrawable(null);
      this.mPhotoListLogic = ((PhotoListLogicBase)generateLogic());
      this.mPhotoListData = this.mPhotoListLogic.mPhotoListData;
      this.pref = BaseApplication.getContext().getSharedPreferences("share", 4);
      Resources localResources = getResources();
      int i = localResources.getDisplayMetrics().widthPixels;
      this.mEdgePadding = localResources.getDimensionPixelSize(2131297430);
      this.mImageWidth = ((i - this.mEdgePadding * 2) / 3);
      this.mImageHeight = this.mImageWidth;
      this.mPhotoListLogic.initData(paramBundle);
      initUI();
      return true;
    }
    catch (Throwable paramBundle)
    {
      super.finish();
    }
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.mPhotoListLogic.doOnDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent.putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivity onNewIntent() is called,extra is:" + paramIntent.getExtras());
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, "PhotoListActivityhashCode is:" + System.identityHashCode(this));
    }
    QLog.d("PhotoListActivity", 2, "onNewIntent()");
    processNewIntent(paramIntent);
    if (this.mPhotoListLogic.mPhotoCommonData.albumName != null) {
      paramIntent = this.mPhotoListLogic.mPhotoCommonData.albumName;
    }
    for (;;)
    {
      setTitle(paramIntent);
      return;
      if (this.mPhotoListLogic.mPhotoCommonData.showMediaType == 2) {
        paramIntent = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;
      } else {
        paramIntent = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.queryPhotoTask = null;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.mPhotoListLogic.doOnResume();
  }
  
  public void excuteAddPhotoTask()
  {
    if (!this.mPhotoListLogic.mPhotoCommonData.mMediaQueryHelper.mTraversalDone) {
      new AbstractPhotoListActivity.QueryNextTask(this.mPhotoListLogic).execute(new Object[0]);
    }
  }
  
  public void excuteQueryPhotoTask(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mPhotoListLogic.mPhotoCommonData.mMediaQueryHelper != null))
    {
      this.mPhotoListLogic.mPhotoCommonData.mMediaQueryHelper.close();
      this.mPhotoListLogic.mPhotoCommonData.mMediaQueryHelper = null;
    }
    this.queryPhotoTask = new AbstractPhotoListActivity.QueryPhotoTask(this.mPhotoListLogic);
    this.queryPhotoTask.execute(new Object[0]);
  }
  
  public void finish()
  {
    super.finish();
  }
  
  protected PhotoListLogic generateLogic()
  {
    return new PhotoListLogicBase(this);
  }
  
  public abstract AbstractAlbumListFragment getAlbumListFragment();
  
  protected Dialog getDialog()
  {
    return new ReportDialog(this);
  }
  
  public abstract Class getJumpActivity();
  
  protected void initUI()
  {
    this.albumListContainer = ((FrameLayout)findViewById(2131362588));
    this.titleLeftBtn = ((TextView)findViewById(2131369231));
    this.titleLeftBtn.setVisibility(0);
    this.titleLeftBtn.setOnClickListener(this);
    this.titleText = ((TextView)findViewById(2131369278));
    String str;
    if (this.mPhotoListLogic.mPhotoCommonData.albumName != null) {
      str = this.mPhotoListLogic.mPhotoCommonData.albumName;
    }
    for (;;)
    {
      setTitle(str);
      this.titleImage = ((TriangleView)findViewById(2131369274));
      this.titleImage.setColor(this.titleText.getCurrentTextColor());
      this.titleLayout = ((LinearLayout)findViewById(2131369225));
      this.titleLayout.setOnClickListener(this);
      this.previewBtn = ((Button)findViewById(2131373132));
      this.sendBtn = ((Button)findViewById(2131377349));
      this.bottomBar = findViewById(2131379207);
      this.mGridView = ((PhotoGridView)findViewById(2131372696));
      this.mGridView.setScrollBarStyle(0);
      this.gridLayoutManager = new GridLayoutManager(this, 3);
      this.mGridView.setLayoutManager(this.gridLayoutManager);
      this.photoListAdapter = new AbstractPhotoListActivity.PhotoListAdapter(this);
      this.mGridView.setAdapter(this.photoListAdapter);
      this.mGridView.setOnIndexChangedListener(this.mOnSelectChangeListener);
      this.mGridView.addOnScrollListener(new AbstractPhotoListActivity.2(this));
      this.mPhotoListLogic.postInitUI();
      return;
      if (this.mPhotoListLogic.mPhotoCommonData.showMediaType == 2) {
        str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;
      } else {
        str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
      }
    }
  }
  
  public boolean isGif(LocalMediaInfo paramLocalMediaInfo)
  {
    return (paramLocalMediaInfo != null) && ("image/gif".equals(paramLocalMediaInfo.mMimeType));
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAlbumListChoose(QQAlbumInfo paramQQAlbumInfo, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.mPhotoListLogic.mPhotoCommonData.albumName == null) {
        break label70;
      }
    }
    label70:
    for (paramQQAlbumInfo = this.mPhotoListLogic.mPhotoCommonData.albumName;; paramQQAlbumInfo = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME)
    {
      setTitle(paramQQAlbumInfo);
      this.mPhotoListData.firstResume = true;
      this.mPhotoListLogic.mPhotoCommonData.createMediaQueryHelper(this);
      runOnUiThread(new AbstractPhotoListActivity.3(this));
      transAlbumList(false);
      return;
    }
  }
  
  public void onBackPressed()
  {
    if ((this.albumListFragment == null) || (this.albumListFragment.isHidden())) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.mPhotoListLogic.onBackPressed();
      return;
    }
    transAlbumList(false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getId() == 2131374832) {
      this.mPhotoListLogic.onQualityBtnClick(paramCompoundButton, paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131369231) {
      this.mPhotoListLogic.onTitleBtnCancelClick(paramView);
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (i == 2131373132)
        {
          this.mPhotoListLogic.onPreviewBtnClick(paramView);
        }
        else
        {
          if (i != 2131377349) {
            break;
          }
          this.mPhotoListLogic.onSendBtnClick(paramView);
        }
      }
    } while (i != 2131369225);
    if ((this.albumListFragment == null) || (!this.albumListFragment.isAdded()) || (this.albumListFragment.isHidden())) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.mPhotoListLogic.enterAlbumListFragment(getIntent());
      }
      transAlbumList(bool);
      break;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  void processNewIntent(Intent paramIntent)
  {
    setIntent(paramIntent);
    this.mPhotoListLogic.initData(paramIntent);
  }
  
  public void recordLastPos(String paramString)
  {
    if (this.mPhotoListData.isRecodeLastAlbumPath)
    {
      QAlbumUtil.sLastAlbumRecordTime = System.currentTimeMillis();
      QAlbumUtil.sLastAlbumPhotoCountMap.put(this.mPhotoListLogic.mPhotoCommonData.albumId, Integer.valueOf(this.photoListAdapter.getItemCount()));
      if (!TextUtils.isEmpty(paramString))
      {
        QAlbumUtil.sLastAlbumPath = paramString;
        HashMap localHashMap = QAlbumUtil.sSelectItemAlbum;
        if (localHashMap.containsKey(paramString))
        {
          paramString = (Pair)localHashMap.get(paramString);
          QAlbumUtil.sLastAlbumId = (String)paramString.first;
          QAlbumUtil.sLastAlbumName = (String)paramString.second;
          QAlbumUtil.putLastAlbumInfo(this, QAlbumUtil.sLastAlbumId, QAlbumUtil.sLastAlbumName);
        }
      }
    }
    QAlbumUtil.clearSelectItemInfo();
  }
  
  public void selectLimitRemind(boolean paramBoolean)
  {
    int i = this.mPhotoListLogic.mPhotoCommonData.selectedPhotoList.size();
    int j;
    if (((i == this.mPhotoListLogic.mPhotoCommonData.maxSelectNum) && (!paramBoolean)) || ((i == this.mPhotoListLogic.mPhotoCommonData.maxSelectNum - 1) && (paramBoolean)))
    {
      i = 1;
      if (i == 0) {
        return;
      }
      j = this.gridLayoutManager.findFirstVisibleItemPosition();
      int k = this.gridLayoutManager.findLastVisibleItemPosition();
      i = j;
      label77:
      if (i > k) {
        return;
      }
      if (this.photoListAdapter.getItemViewType(i) != 2) {
        break label107;
      }
    }
    for (;;)
    {
      i += 1;
      break label77;
      i = 0;
      break;
      label107:
      Object localObject = this.mGridView.getChildAt(i - j);
      LocalMediaInfo localLocalMediaInfo = this.photoListAdapter.getItem(i);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "updateCheckbox view = null at " + i);
        }
      }
      else if (localLocalMediaInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "updateCheckbox info = null at " + i);
        }
      }
      else
      {
        localObject = (AbstractPhotoListActivity.Holder)((View)localObject).getTag();
        if ((paramBoolean) || (localLocalMediaInfo.selectStatus == 1)) {
          ((AbstractPhotoListActivity.Holder)localObject).mImageView.setAlpha(1.0F);
        } else {
          ((AbstractPhotoListActivity.Holder)localObject).mImageView.setAlpha(0.3F);
        }
      }
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    this.titleText.setText(paramCharSequence);
  }
  
  public void showProgressDialog()
  {
    try
    {
      if (this.pd != null) {
        cancleProgressDailog();
      }
      while (!this.pd.isShowing())
      {
        this.pd.show();
        return;
        this.pd = getDialog();
        this.pd.setCancelable(true);
        this.pd.show();
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoListActivity", 2, "show dialog error", localException);
      }
      this.pd = null;
    }
  }
  
  public void transAlbumList(boolean paramBoolean)
  {
    FragmentTransaction localFragmentTransaction;
    ObjectAnimator localObjectAnimator;
    if (this.albumListFragment == null)
    {
      if (paramBoolean) {
        this.albumListFragment = getAlbumListFragment();
      }
    }
    else
    {
      FragmentManager localFragmentManager = getSupportFragmentManager();
      localFragmentTransaction = localFragmentManager.beginTransaction();
      localFragmentTransaction.setTransition(4097);
      if (!paramBoolean) {
        break label203;
      }
      localObjectAnimator = ObjectAnimator.ofInt(this.albumListContainer, "backgroundColor", new int[] { getResources().getColor(2131165498), getResources().getColor(2131165509) });
      rotate180Degrees(this.titleImage, false);
      if ((this.albumListFragment.isAdded()) || (localFragmentManager.findFragmentByTag(this.albumListFragment.toString()) != null)) {
        break label191;
      }
    }
    for (;;)
    {
      try
      {
        localFragmentTransaction.add(2131362588, this.albumListFragment, this.albumListFragment.toString());
        localFragmentTransaction.commit();
        localObjectAnimator.setDuration(300L);
        localObjectAnimator.setEvaluator(new ArgbEvaluator());
        localObjectAnimator.setRepeatMode(2);
        localObjectAnimator.start();
        this.mPhotoListLogic.onAlbumListShown(paramBoolean);
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        localFragmentTransaction.show(this.albumListFragment);
        continue;
      }
      label191:
      localFragmentTransaction.show(this.albumListFragment);
      continue;
      label203:
      localObjectAnimator = ObjectAnimator.ofInt(this.albumListContainer, "backgroundColor", new int[] { getResources().getColor(2131165509), getResources().getColor(2131165498) });
      rotate180Degrees(this.titleImage, true);
      localFragmentTransaction.hide(this.albumListFragment);
    }
  }
  
  public void updateCheckbox(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = this.mPhotoListLogic.mPhotoCommonData.selectedPhotoList;
    int j = this.gridLayoutManager.findFirstVisibleItemPosition();
    int k = this.gridLayoutManager.findLastVisibleItemPosition();
    int i = j;
    if (i <= k)
    {
      if ((paramBoolean) && (paramInt != i)) {}
      label404:
      for (;;)
      {
        i += 1;
        break;
        Object localObject = this.mGridView.getChildAt(i - j);
        LocalMediaInfo localLocalMediaInfo = this.photoListAdapter.getItem(i);
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "updateCheckbox view = null at " + i);
          }
        }
        else if (localLocalMediaInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "updateCheckbox info = null at " + i);
          }
        }
        else
        {
          int m;
          AbstractPhotoListActivity.Holder localHolder;
          if (paramInt != i)
          {
            m = localArrayList.indexOf(localLocalMediaInfo.path);
            if (m >= 0)
            {
              localHolder = (AbstractPhotoListActivity.Holder)((View)localObject).getTag();
              if ((localHolder != null) && (localHolder.mCheckBox != null)) {
                localHolder.mCheckBox.setCheckedNumber(m + 1);
              }
            }
          }
          else
          {
            m = QAlbumUtil.getMediaType(localLocalMediaInfo);
            if ((m == 0) || (m == 1))
            {
              localHolder = (AbstractPhotoListActivity.Holder)((View)localObject).getTag();
              int n = localLocalMediaInfo.selectStatus;
              if (n == 1)
              {
                if (localHolder.mCheckBox != null) {
                  localHolder.mCheckBox.setCheckedNumber(localArrayList.indexOf(localLocalMediaInfo.path) + 1);
                }
                if (((View)localObject).getBackground() != null) {
                  ((View)localObject).setBackgroundDrawable(null);
                }
              }
              for (;;)
              {
                if ((!AppSetting.c) || (localHolder.mCheckBox == null)) {
                  break label404;
                }
                localObject = QAlbumUtil.createContentDescriptionWithCheckBox(m, localLocalMediaInfo, i, localHolder.mCheckBox.isChecked());
                localHolder.mCheckBox.setContentDescription((CharSequence)localObject);
                break;
                if (n == 3)
                {
                  if (localHolder.mCheckBox != null) {
                    localHolder.mCheckBox.setChecked(false);
                  }
                }
                else
                {
                  if (localHolder.mCheckBox != null) {
                    localHolder.mCheckBox.setChecked(false);
                  }
                  if (((View)localObject).getBackground() != null) {
                    ((View)localObject).setBackgroundDrawable(null);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void updateCheckboxForDelete()
  {
    int j = this.gridLayoutManager.findFirstVisibleItemPosition();
    int k = this.gridLayoutManager.findLastVisibleItemPosition();
    int i = j;
    if (i <= k)
    {
      Object localObject = this.mGridView.getChildAt(i - j);
      LocalMediaInfo localLocalMediaInfo = this.photoListAdapter.getItem(i);
      if (localObject == null) {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "updateCheckbox view = null at " + i);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (localLocalMediaInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "updateCheckbox info = null at " + i);
          }
        }
        else
        {
          int m = this.mPhotoListLogic.mPhotoCommonData.selectedPhotoList.indexOf(localLocalMediaInfo.path);
          if (m >= 0)
          {
            localObject = (AbstractPhotoListActivity.Holder)((View)localObject).getTag();
            if ((localObject != null) && (((AbstractPhotoListActivity.Holder)localObject).mCheckBox != null)) {
              ((AbstractPhotoListActivity.Holder)localObject).mCheckBox.setCheckedNumber(m + 1);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity
 * JD-Core Version:    0.7.0.1
 */