package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.account_folder.recommend_banner.TopRecommendListView;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelPresenter;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ServiceAccountFolderActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, DragFrameLayout.OnDragModeChangedListener, SwipListView.RightIconMenuListener
{
  private long jdField_a_of_type_Long = 0L;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ServiceAccountFolderFeedAdapter jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter;
  private TopRecommendListView jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView;
  private TopPanelPresenter jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelPresenter;
  private TopPanelView jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<ServiceAccountFolderFeed> jdField_a_of_type_JavaUtilList;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private TextView c;
  private TextView d;
  
  private void b()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null) {
      return;
    }
    try
    {
      Field localField = localInputMethodManager.getClass().getDeclaredField("mLastSrvView");
      if (!localField.isAccessible()) {
        localField.setAccessible(true);
      }
      localField.set(localInputMethodManager, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      QZLog.w("ServiceAccountFolderActivity", "[onDestroy]", localThrowable);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131377842);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369534));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369487));
    this.d = ((TextView)findViewById(2131369525));
    this.c = ((TextView)super.findViewById(2131380148));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView = ((TopRecommendListView)super.findViewById(2131377849));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView = new TopPanelView(this);
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelPresenter = new TopPanelPresenter(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.addHeaderView(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369878));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131695269);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131377844);
    ((TextView)findViewById(2131377843)).setText("暂无" + PublicAccountConfigUtilImpl.getServiceAccountTitle() + "消息");
  }
  
  private void c(boolean paramBoolean)
  {
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderActivity", 2, "enableFlingRight->enable:" + paramBoolean);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ServiceAccountFolderManager.a(this.app));
    if (this.leftView != null) {
      this.leftView.setContentDescription(HardCodeUtil.a(2131713783));
    }
    Object localObject;
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.c != null)
      {
        this.c.setVisibility(8);
        localObject = this.c.getLayoutParams();
        if ((localObject instanceof ViewGroup.MarginLayoutParams))
        {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(32.0F, getResources());
          this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      if (this.d != null) {
        this.d.setVisibility(8);
      }
      if (this.rightViewText != null)
      {
        if (!PublicAccountConfigUtilImpl.isSwitchToCertifiedAccount()) {
          break label320;
        }
        this.rightViewText.setVisibility(0);
        this.rightViewText.setText(HardCodeUtil.a(2131719642));
        this.rightViewText.setOnClickListener(this);
      }
    }
    for (;;)
    {
      g();
      return;
      if (this.d != null)
      {
        localObject = this.d.getBackground();
        if ((localObject != null) && ((localObject instanceof GradientDrawable)))
        {
          GradientDrawable localGradientDrawable = (GradientDrawable)((Drawable)localObject).mutate();
          localGradientDrawable.setColor(getResources().getColorStateList(2131167030).getDefaultColor());
          ((Drawable)localObject).setAlpha(46);
          this.d.setBackgroundDrawable(localGradientDrawable);
        }
        if (ThemeUtil.isInNightMode(this.app))
        {
          localObject = this.d.getLayoutParams();
          if ((localObject instanceof ViewGroup.MarginLayoutParams))
          {
            ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(40.0F, getResources());
            this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
        this.d.setTextColor(getResources().getColor(2131167030));
        this.d.setVisibility(8);
      }
      if (this.c == null) {
        break;
      }
      this.c.setVisibility(8);
      break;
      label320:
      this.rightViewText.setVisibility(8);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setRightIconMenuListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setContentBackground(getResources().getDrawable(2130838980), false);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setBackgroundResource(2130838980);
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter = new ServiceAccountFolderFeedAdapter(this.app, this, this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView);
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_JavaUtilList = ServiceAccountFolderManager.a().a();
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter);
  }
  
  private void f()
  {
    View localView = super.findViewById(2131377159);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = super.findViewById(2131379451);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = super.findViewById(2131369487);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
  }
  
  private void g()
  {
    if (this.jdField_b_of_type_Boolean) {}
    for (TextView localTextView = this.c;; localTextView = this.d)
    {
      if ((localTextView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.sourceType == 9004)) {
        ThreadManager.executeOnSubThread(new ServiceAccountFolderActivity.3(this, localTextView));
      }
      return;
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    label30:
    ServiceAccountFolderFeed localServiceAccountFolderFeed;
    Object localObject1;
    while (localIterator.hasNext())
    {
      localServiceAccountFolderFeed = (ServiceAccountFolderFeed)localIterator.next();
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
        localObject2 = "";
        localObject1 = localObject2;
        if (localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
        {
          localObject1 = localObject2;
          if (localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject != null) {
            localObject1 = localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");
          }
        }
        localObject2 = localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if (localObject2 == null) {
          break label274;
        }
      }
    }
    label274:
    for (Object localObject2 = PublicAccountEventReport.a(localServiceAccountFolderFeed.b + "", ((MessageRecord)localObject2).msgseq + "", ((MessageRecord)localObject2).msgBackupMsgRandom + "");; localObject2 = "")
    {
      PublicAccountEventReport.a(this.app, localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, localServiceAccountFolderFeed.jdField_a_of_type_Int, localServiceAccountFolderFeed.b, localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence.toString(), (String)localObject1, (String)localObject2, this.jdField_a_of_type_JavaUtilList.indexOf(localServiceAccountFolderFeed) + "");
      break label30;
      break;
    }
  }
  
  private void i()
  {
    Manager localManager = this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
    if ((localManager instanceof RedTouchManager))
    {
      ((RedTouchManager)localManager).a(104000, "104000.104001");
      QLog.d("ServiceAccountFolderActivity", 2, "uin:" + this.app.getCurrentUin() + "   exposurePublicAccountMessagePopRedDot");
    }
  }
  
  protected TopGestureLayout a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null)
    {
      this.jdField_a_of_type_Boolean = true;
      localTopGestureLayout.setInterceptTouchEventListener(new ServiceAccountFolderActivity.5(this));
      return;
    }
    QLog.e("ServiceAccountFolderActivity", 2, "processTopPanelTouchEvent failed! topGestureLayout return null!");
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setVisibility(8);
      if (ThemeUtil.isInNightMode(this.app))
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838980);
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          Rect localRect = new Rect();
          getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
          int i = localRect.height();
          int j = View.MeasureSpec.makeMeasureSpec(0, 0);
          int k = View.MeasureSpec.makeMeasureSpec(0, 0);
          this.jdField_b_of_type_AndroidViewView.measure(j, k);
          i = (i - this.jdField_b_of_type_AndroidViewView.getMeasuredHeight()) / 2;
          j = (int)getResources().getDimension(2131299166);
          ((ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).topMargin = (i - j);
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderActivity", 2, "showEmptyView->show:" + paramBoolean);
      }
      return;
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#f5f5f5"));
      break;
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setVisibility(0);
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    ServiceAccountFolderFeed localServiceAccountFolderFeed;
    long l;
    QQAppInterface localQQAppInterface;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131380944))
    {
      paramInt = ((Integer)paramDragFrameLayout.a().getTag()).intValue();
      localServiceAccountFolderFeed = (ServiceAccountFolderFeed)this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter.getItem(paramInt);
      if (localServiceAccountFolderFeed != null)
      {
        l = ServiceAccountFolderManager.a().a(localServiceAccountFolderFeed);
        localQQAppInterface = this.app;
        if (!localServiceAccountFolderFeed.a()) {
          break label255;
        }
      }
    }
    label255:
    for (paramDragFrameLayout = "0";; paramDragFrameLayout = "1")
    {
      ReportController.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", "", "0X800687D", "0X800687D", 0, 0, paramDragFrameLayout, "" + localServiceAccountFolderFeed.b, "" + (paramInt + 1), "" + l);
      ServiceAccountFolderManager.a().b(this.app, localServiceAccountFolderFeed, true);
      VSReporter.a(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, "auth_page", "ignore", 0, 0, new String[0]);
      g();
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderActivity", 2, "onChange->drag red dot:" + localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        break label80;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new ServiceAccountFolderActivity.4(this), 5000L);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderActivity", 2, "showProgressBar->show:" + paramBoolean);
      }
      return;
      label80:
      if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
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
    if ((QzoneConfig.getInstance().getConfig("qqsubscribe", "JumpToNewServiceAccount", 1) <= 0) || (!PublicAccountConfigUtilImpl.isSwitchToCertifiedAccount())) {}
    for (;;)
    {
      super.doOnCreate(paramBundle);
      super.setContentView(2131559758);
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = ((ExtraTypeInfo)getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info"));
      this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      this.jdField_b_of_type_Boolean = ThemeUtil.isDefaultOrDIYTheme(false);
      c();
      d();
      e();
      f();
      ServiceAccountFolderManager.a().a(this.app, NetConnInfoCenter.getServerTime());
      paramBundle = (IWebProcessManagerService)this.app.getRuntimeService(IWebProcessManagerService.class, "");
      if (paramBundle != null) {
        paramBundle.startWebProcess(-1, null);
      }
      i();
      return true;
      Intent localIntent = new Intent();
      Bundle localBundle = getIntent().getExtras();
      if (localBundle != null) {
        localIntent.putExtras(localBundle);
      }
      localIntent.setClass(this, ServiceAccountFolderActivityNew.class);
      startActivity(localIntent);
      finish();
    }
  }
  
  public void doOnDestroy()
  {
    ServiceAccountFolderManager.a().a(this.app, NetConnInfoCenter.getServerTime());
    VSReporter.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "auth_page", "exp", 0, 0, new String[] { "", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    this.app.removeHandler(getClass());
    if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.removeHeaderView(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView);
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelPresenter != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelPresenter.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchEventListener(null);
    }
    b();
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
    ServiceAccountFolderManager.a().a(this.app, NetConnInfoCenter.getServerTime());
    PublicAccountEventReport.a(this.app, "9953", 1, 1, System.currentTimeMillis() - this.jdField_a_of_type_Long);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a();
    ThreadManager.executeOnSubThread(new ServiceAccountFolderActivity.2(this, ServiceAccountFolderManager.a()));
    PublicTracker.a("SERVICE_FOLDER_COST", null);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(100);
      ThreadManager.executeOnSubThread(new ServiceAccountFolderActivity.1(this));
    }
    do
    {
      return true;
      if (paramMessage.what == 101)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_JavaUtilList);
        if (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter.getCount() == 0) {}
        for (boolean bool = true;; bool = false)
        {
          a(bool);
          g();
          h();
          return true;
        }
      }
    } while (paramMessage.what != 102);
    g();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      finish();
      continue;
      String str = QzoneConfig.getInstance().getConfig("qqminiapp", "publicAcuntDiscoverPageSchema", "mqqapi://miniapp/open?_atype=0&_mappid=1109786902&_mvid=&_vt=3&_sig=f945854d8893417d87b3599d8dce7bdde77f409be5548044ed67383266b1fbf4");
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this, str, 2016, null, null);
      QZoneHelper.prepareForQQPublicAccountPublishPage();
      ReportController.b(this.app, "dc00898", "", "", "auth_page", "clk_find", 0, 0, "", "", "", "");
      continue;
      SubscribeLaucher.a("https://h5.qzone.qq.com/subscription/followlist?_proxy=1_wv=3");
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onRightIconMenuHide(View paramView)
  {
    c(true);
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    c(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity
 * JD-Core Version:    0.7.0.1
 */