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
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131377268);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369249));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369202));
    this.d = ((TextView)findViewById(2131369240));
    this.c = ((TextView)super.findViewById(2131379476));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView = ((TopRecommendListView)super.findViewById(2131377275));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView = new TopPanelView(this);
    Object localObject = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelPresenter = new TopPanelPresenter(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.addHeaderView(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369563));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131695272);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131377270);
    localObject = (TextView)findViewById(2131377269);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("暂无");
    localStringBuilder.append(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountTitle());
    localStringBuilder.append("消息");
    ((TextView)localObject).setText(localStringBuilder.toString());
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = a();
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enableFlingRight->enable:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ServiceAccountFolderActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ServiceAccountFolderManager.a(this.app));
    if (this.leftView != null) {
      this.leftView.setContentDescription(HardCodeUtil.a(2131713711));
    }
    Object localObject;
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = this.c;
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(8);
        localObject = this.c.getLayoutParams();
        if ((localObject instanceof ViewGroup.MarginLayoutParams))
        {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(32.0F, getResources());
          this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      localObject = this.d;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    else
    {
      localObject = this.d;
      if (localObject != null)
      {
        localObject = ((TextView)localObject).getBackground();
        if ((localObject != null) && ((localObject instanceof GradientDrawable)))
        {
          GradientDrawable localGradientDrawable = (GradientDrawable)((Drawable)localObject).mutate();
          localGradientDrawable.setColor(getResources().getColorStateList(2131167053).getDefaultColor());
          ((Drawable)localObject).setAlpha(46);
          this.d.setBackgroundDrawable(localGradientDrawable);
        }
        if (ThemeUtil.isInNightMode(this.app))
        {
          localObject = this.d.getLayoutParams();
          if ((localObject instanceof ViewGroup.MarginLayoutParams))
          {
            ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(40.0F, getResources());
            this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
        this.d.setTextColor(getResources().getColor(2131167053));
        this.d.setVisibility(8);
      }
      localObject = this.c;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    if (this.rightViewText != null) {
      if (((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isSwitchToCertifiedAccount())
      {
        this.rightViewText.setVisibility(0);
        this.rightViewText.setText(HardCodeUtil.a(2131719361));
        this.rightViewText.setOnClickListener(this);
      }
      else
      {
        this.rightViewText.setVisibility(8);
      }
    }
    g();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setRightIconMenuListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setContentBackground(getResources().getDrawable(2130838740), false);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setBackgroundResource(2130838740);
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter = new ServiceAccountFolderFeedAdapter(this.app, this, this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView);
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_JavaUtilList = ServiceAccountFolderManager.a().a();
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter);
  }
  
  private void f()
  {
    View localView = super.findViewById(2131376636);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = super.findViewById(2131378803);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = super.findViewById(2131369202);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
  }
  
  private void g()
  {
    TextView localTextView;
    if (this.jdField_b_of_type_Boolean) {
      localTextView = this.c;
    } else {
      localTextView = this.d;
    }
    if (localTextView != null)
    {
      ExtraTypeInfo localExtraTypeInfo = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
      if ((localExtraTypeInfo != null) && (localExtraTypeInfo.sourceType == 9004)) {
        ThreadManager.executeOnSubThread(new ServiceAccountFolderActivity.3(this, localTextView));
      }
    }
  }
  
  private void h()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    if (localObject1 != null)
    {
      if (((List)localObject1).size() == 0) {
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)localIterator.next();
        if (!this.jdField_a_of_type_JavaUtilArrayList.contains(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
          if ((localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject != null)) {
            localObject1 = localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");
          } else {
            localObject1 = "";
          }
          Object localObject2 = localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          if (localObject2 != null)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(localServiceAccountFolderFeed.b);
            ((StringBuilder)localObject3).append("");
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(((MessageRecord)localObject2).msgseq);
            ((StringBuilder)localObject4).append("");
            localObject4 = ((StringBuilder)localObject4).toString();
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append(((MessageRecord)localObject2).msgBackupMsgRandom);
            ((StringBuilder)localObject5).append("");
            localObject2 = PublicAccountEventReport.a((String)localObject3, (String)localObject4, ((StringBuilder)localObject5).toString());
          }
          else
          {
            localObject2 = "";
          }
          Object localObject3 = this.app;
          Object localObject4 = localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString;
          int i = localServiceAccountFolderFeed.jdField_a_of_type_Int;
          int j = localServiceAccountFolderFeed.b;
          Object localObject5 = localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence.toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.indexOf(localServiceAccountFolderFeed));
          localStringBuilder.append("");
          PublicAccountEventReport.a((QQAppInterface)localObject3, (String)localObject4, i, j, (String)localObject5, (String)localObject1, (String)localObject2, localStringBuilder.toString());
        }
      }
    }
  }
  
  private void i()
  {
    ((IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "")).onReportNumRedPoint(104000, "104000.104001");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin:");
    localStringBuilder.append(this.app.getCurrentUin());
    localStringBuilder.append("   exposurePublicAccountMessagePopRedDot");
    QLog.d("ServiceAccountFolderActivity", 2, localStringBuilder.toString());
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
    Object localObject;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setVisibility(8);
      if (ThemeUtil.isInNightMode(this.app)) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838740);
      } else {
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#f5f5f5"));
      }
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        localObject = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
        int i = ((Rect)localObject).height();
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        int k = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.jdField_b_of_type_AndroidViewView.measure(j, k);
        i = (i - this.jdField_b_of_type_AndroidViewView.getMeasuredHeight()) / 2;
        j = (int)getResources().getDimension(2131299168);
        ((ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).topMargin = (i - j);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setVisibility(0);
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showEmptyView->show:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ServiceAccountFolderActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localObject != null) {
      if ((paramBoolean) && (!((QQProgressDialog)localObject).isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new ServiceAccountFolderActivity.4(this), 5000L);
      }
      else if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showProgressBar->show:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ServiceAccountFolderActivity", 2, ((StringBuilder)localObject).toString());
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if ((QzoneConfig.getInstance().getConfig("qqsubscribe", "JumpToNewServiceAccount", 1) > 0) && (((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isSwitchToCertifiedAccount()))
    {
      Intent localIntent = new Intent();
      Bundle localBundle = getIntent().getExtras();
      if (localBundle != null) {
        localIntent.putExtras(localBundle);
      }
      localIntent.setClass(this, ServiceAccountFolderActivityNew.class);
      startActivity(localIntent);
      finish();
    }
    super.doOnCreate(paramBundle);
    super.setContentView(2131559634);
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
  }
  
  protected void doOnDestroy()
  {
    ServiceAccountFolderManager.a().a(this.app, NetConnInfoCenter.getServerTime());
    VSReporter.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "auth_page", "exp", 0, 0, new String[] { "", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
    Object localObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
    }
    this.app.removeHandler(getClass());
    localObject = this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView;
    if (localObject != null)
    {
      ((TopRecommendListView)localObject).removeHeaderView(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView);
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setAdapter(null);
    }
    localObject = this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelPresenter;
    if (localObject != null) {
      ((TopPanelPresenter)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter;
    if (localObject != null) {
      ((ServiceAccountFolderFeedAdapter)localObject).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localObject != null) {
      ((QQProgressDialog)localObject).dismiss();
    }
    localObject = a();
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchEventListener(null);
    }
    b();
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    DragFrameLayout localDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if (localDragFrameLayout != null) {
      localDragFrameLayout.a();
    }
    ServiceAccountFolderManager.a().a(this.app, NetConnInfoCenter.getServerTime());
    PublicAccountEventReport.a(this.app, "9953", 1, 1, System.currentTimeMillis() - this.jdField_a_of_type_Long);
  }
  
  protected void doOnResume()
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
      return true;
    }
    if (paramMessage.what == 101)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_JavaUtilList);
      boolean bool;
      if (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter.getCount() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      a(bool);
      g();
      h();
      return true;
    }
    if (paramMessage.what == 102) {
      g();
    }
    return true;
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131380210))
    {
      paramInt = ((Integer)paramDragFrameLayout.a().getTag()).intValue();
      ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter.getItem(paramInt);
      if (localServiceAccountFolderFeed != null)
      {
        long l = ServiceAccountFolderManager.a().a(localServiceAccountFolderFeed);
        QQAppInterface localQQAppInterface = this.app;
        if (localServiceAccountFolderFeed.a()) {
          paramDragFrameLayout = "0";
        } else {
          paramDragFrameLayout = "1";
        }
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(localServiceAccountFolderFeed.b);
        localObject1 = ((StringBuilder)localObject1).toString();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(paramInt + 1);
        localObject2 = ((StringBuilder)localObject2).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(l);
        ReportController.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", "", "0X800687D", "0X800687D", 0, 0, paramDragFrameLayout, (String)localObject1, (String)localObject2, localStringBuilder.toString());
        ServiceAccountFolderManager.a().b(this.app, localServiceAccountFolderFeed, true);
        VSReporter.a(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, "auth_page", "ignore", 0, 0, new String[0]);
        g();
        if (QLog.isColorLevel())
        {
          paramDragFrameLayout = new StringBuilder();
          paramDragFrameLayout.append("onChange->drag red dot:");
          paramDragFrameLayout.append(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
          QLog.d("ServiceAccountFolderActivity", 2, paramDragFrameLayout.toString());
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131369233: 
      SubscribeLaucher.a("https://h5.qzone.qq.com/subscription/followlist?_proxy=1_wv=3");
      break;
    case 2131369216: 
      String str = QzoneConfig.getInstance().getConfig("qqminiapp", "publicAcuntDiscoverPageSchema", "mqqapi://miniapp/open?_atype=0&_mappid=1109786902&_mvid=&_vt=3&_sig=f945854d8893417d87b3599d8dce7bdde77f409be5548044ed67383266b1fbf4");
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this, str, 2016, null, null);
      QZoneHelper.prepareForQQPublicAccountPublishPage();
      ReportController.b(this.app, "dc00898", "", "", "auth_page", "clk_find", 0, 0, "", "", "", "");
      break;
    case 2131369202: 
    case 2131369563: 
      finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity
 * JD-Core Version:    0.7.0.1
 */