package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.business.LocaleConfProcessor;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msgbackup.util.MsgBackupConfigProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.KidModeServlet;
import com.tencent.mobileqq.studymode.ModeChoiceViewContainer;
import com.tencent.mobileqq.studymode.ModeChoiceViewContainer.DarkModeUpdateListener;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

public class GeneralSettingActivity
  extends IphoneTitleBarActivity
  implements ModeChoiceViewContainer.DarkModeUpdateListener
{
  FormSwitchItem a;
  FormSwitchItem b;
  FormSimpleItem c;
  QQProgressDialog d;
  FormSwitchSimpleItem e;
  TextView f;
  SimpleUIHandler g;
  View.OnClickListener h = new GeneralSettingActivity.1(this);
  Handler i = new GeneralSettingActivity.12(this);
  private RedTouch j;
  private View k;
  private TopGestureLayout l;
  private boolean m;
  private String n = "";
  private View o;
  private ModeChoiceViewContainer p;
  private SecSvcObserver q = new GeneralSettingActivity.13(this);
  
  private void c()
  {
    SecSvcHandler localSecSvcHandler = (SecSvcHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
    if (localSecSvcHandler != null) {
      localSecSvcHandler.a(3);
    }
    KidModeServlet.a(this.app);
  }
  
  private void d()
  {
    if (this.j != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath("100190.100194");
      this.j.a(localAppInfo);
      localIRedTouchManager.onReportRedPointExposure(localAppInfo);
    }
  }
  
  private void e()
  {
    this.e = ((FormSwitchSimpleItem)super.findViewById(2131427332));
    this.f = ((TextView)super.findViewById(2131431580));
    a(2131442615, 2131897255, 0, 2130839622);
    super.findViewById(2131430642).setOnClickListener(new GeneralSettingActivity.2(this));
    j();
    this.k = super.findViewById(2131433539);
    this.k.setVisibility(8);
    this.o = super.findViewById(2131438916);
    if (MsgBackupConfigProcessor.a()) {
      this.o.setVisibility(0);
    }
    Object localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.fontCfg.name(), "-1");
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("current fontSetting dpcValue=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("GeneralSettingActivity", 2, ((StringBuilder)localObject2).toString());
    }
    if (("1".equals(localObject1)) && (FontSettingManager.isDisplayMetricNoAnswer()))
    {
      this.k.setVisibility(0);
    }
    else if ("0".equals(localObject1))
    {
      this.k.setVisibility(8);
      FontSettingManager.revert2SystemDensity(this);
    }
    else if (FontSettingManager.isSupportDevice())
    {
      this.k.setVisibility(0);
    }
    else
    {
      this.k.setVisibility(8);
      FontSettingManager.revert2SystemDensity(this);
    }
    if (LocaleConfProcessor.a())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("GeneralSettingActivity, entrance1:false, entrance2:");
      ((StringBuilder)localObject1).append(LocaleManager.a);
      LocaleManager.a(((StringBuilder)localObject1).toString());
      View localView = findViewById(2131442614);
      if (localView != null)
      {
        localView.setVisibility(0);
        localObject1 = this.k;
        if ((localObject1 instanceof FormSimpleItem)) {
          ((FormSimpleItem)localObject1).setBgType(1);
        }
        ((TextView)localView.findViewById(2131442629)).setText(getResources().getString(2131916303));
        localObject2 = localView.findViewById(2131442630);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = ((ViewStub)localView.findViewById(2131442631)).inflate();
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = (TextView)((View)localObject1).findViewById(2131446104);
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setTextSize(0, getResources().getDimensionPixelSize(2131297104));
        ((TextView)localObject1).setTypeface(Typeface.DEFAULT);
        ((TextView)localObject1).setText(LocaleManager.a(LocaleManager.d()));
        localView.setOnClickListener(new GeneralSettingActivity.3(this));
      }
    }
    h();
    i();
    this.k.setOnClickListener(new GeneralSettingActivity.4(this));
    this.o.setOnClickListener(new GeneralSettingActivity.5(this));
    if (DarkModeManager.a())
    {
      this.e.setVisibility(0);
      this.f.setVisibility(0);
      this.e.setChecked(DarkModeManager.c());
      this.e.setOnCheckedChangeListener(new GeneralSettingActivity.6(this));
      ReportController.a(this.app, "0X800B80A");
    }
    else
    {
      if (this.k.getVisibility() == 0)
      {
        localObject1 = (LinearLayout.LayoutParams)this.k.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.b(13.0F, getResources());
        this.k.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.e.setVisibility(8);
      this.f.setVisibility(8);
    }
    k();
    if (AppSetting.e)
    {
      this.a.setContentDescription(HardCodeUtil.a(2131903220));
      this.b.setContentDescription("系统通知栏显示QQ图标");
      this.o.setContentDescription(getActivity().getResources().getString(2131916363));
      this.e.setContentDescription(getActivity().getResources().getString(2131916336));
    }
    f();
    g();
  }
  
  private void f()
  {
    if (ModeChoiceViewContainer.a(this.app)) {
      return;
    }
    this.p = new ModeChoiceViewContainer(this.app, this);
    this.p.a(this);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131445715);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = ViewUtils.dpToPx(10.0F);
    localLinearLayout.addView(this.p.h(), 0, localLayoutParams);
  }
  
  private void g()
  {
    ReportController.a(this.app, "0X800B80C");
    ReportController.a(this.app, "0X800B80B");
    ReportController.a(this.app, "0X800B810");
    ReportController.a(this.app, "0X800B80F");
    ReportController.a(this.app, "0X800B80E");
    ReportController.a(this.app, "0X800B80D");
  }
  
  private void h()
  {
    this.a = ((FormSwitchItem)findViewById(2131432561));
    boolean bool = SettingCloneUtil.readValue(this, null, getString(2131892698), "qqsetting_enter_sendmsg_key", false);
    this.a.setChecked(bool);
    this.a.setOnCheckedChangeListener(new GeneralSettingActivity.7(this));
  }
  
  private void i()
  {
    boolean bool = SettingCloneUtil.readValue(this, null, getString(2131916372), "qqsetting_notify_icon_key", false);
    this.b = ((FormSwitchItem)findViewById(2131439476));
    this.b.setChecked(bool);
    this.b.setOnCheckedChangeListener(new GeneralSettingActivity.8(this));
  }
  
  private void j()
  {
    super.findViewById(2131428933).setOnClickListener(new GeneralSettingActivity.9(this));
  }
  
  private void k()
  {
    this.c = ((FormSimpleItem)findViewById(2131430560));
    this.o.setVisibility(8);
    findViewById(2131430642).setVisibility(8);
    this.c.setVisibility(0);
    this.c.setContentDescription(getResources().getString(2131887737));
    this.c.setOnClickListener(new GeneralSettingActivity.10(this));
  }
  
  private TopGestureLayout l()
  {
    if (this.l == null)
    {
      Object localObject = (ViewGroup)getWindow().getDecorView();
      View localView = ((ViewGroup)localObject).getChildAt(0);
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.l = ((TopGestureLayout)localObject);
      }
    }
    return this.l;
  }
  
  protected void a()
  {
    if ((this.m) && (ModeChoiceViewContainer.a(this.app))) {
      return;
    }
    TopGestureLayout localTopGestureLayout = l();
    if (localTopGestureLayout == null)
    {
      QLog.e("GeneralSettingActivity", 2, "processRvTouchEvent failed! topGestureLayout return null!");
      return;
    }
    this.m = true;
    localTopGestureLayout.setInterceptTouchEventListener(new GeneralSettingActivity.11(this));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView2 = findViewById(paramInt1);
    if (localView2 == null) {
      return;
    }
    TextView localTextView = (TextView)localView2.findViewById(2131442629);
    localTextView.setText(paramInt2);
    View localView1 = localView2.findViewById(2131442630);
    Object localObject = localView1;
    if (localView1 == null) {
      localObject = ((ViewStub)localView2.findViewById(2131442631)).inflate();
    }
    ((View)localObject).setVisibility(0);
    localObject = (TextView)((View)localObject).findViewById(2131446104);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setTextSize(0, getResources().getDimensionPixelSize(2131297104));
    ((TextView)localObject).setTypeface(Typeface.DEFAULT);
    ((TextView)localObject).setText(HardCodeUtil.a(2131903224));
    if (AppSetting.e) {
      localTextView.setContentDescription(getString(paramInt2));
    }
    if (paramInt3 > 0) {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(paramInt3), null, null, null);
    }
    localView2.setBackgroundResource(paramInt4);
    localView2.setOnClickListener(this.h);
    if ((localView2 instanceof FormItemRelativeLayout))
    {
      localObject = (FormItemRelativeLayout)localView2;
      if (paramInt4 == 2130839638) {
        ((FormItemRelativeLayout)localObject).setBGType(1);
      } else if (paramInt4 == 2130839632) {
        ((FormItemRelativeLayout)localObject).setBGType(2);
      }
    }
    if (paramInt1 == 2131442615)
    {
      this.j = new RedTouch(this, localView2).b(30.0F).a();
      d();
    }
  }
  
  public void b()
  {
    FormSwitchSimpleItem localFormSwitchSimpleItem = this.e;
    if (localFormSwitchSimpleItem != null) {
      localFormSwitchSimpleItem.setChecked(DarkModeManager.c());
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      ((SimpleUIHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).b();
    }
    ModeChoiceViewContainer localModeChoiceViewContainer = this.p;
    if (localModeChoiceViewContainer != null) {
      localModeChoiceViewContainer.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131627799);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.addFlags(262144);
      RouteUtils.a(this, paramBundle, "/base/login");
      super.finish();
      return false;
    }
    super.setTitle(2131897238);
    this.n = this.app.getCurrentAccountUin();
    super.setVolumeControlStream(3);
    addObserver(this.q);
    this.g = ((SimpleUIHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER));
    e();
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      super.dismissDialog(1);
    }
    localObject = this.g;
    if (localObject != null) {
      ((SimpleUIHandler)localObject).onDestroy();
    }
    super.doOnDestroy();
    localObject = l();
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchEventListener(null);
    }
    removeObserver(this.q);
    localObject = this.p;
    if (localObject != null) {
      ((ModeChoiceViewContainer)localObject).c();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a();
  }
  
  protected boolean onBackEvent()
  {
    HiddenChatHelper.b(this, QQSettingSettingActivity.class);
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    if (paramInt != 1) {
      return super.onCreateDialog(paramInt);
    }
    this.d = null;
    this.d = new QQProgressDialog(this, super.getTitleBarHeight());
    this.d.a(getString(2131887798));
    this.d.c(true);
    this.d.a(false);
    this.d.b(true);
    return this.d;
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s onPostThemeChanged", new Object[] { "SimpleUILog" }));
    }
    ModeChoiceViewContainer localModeChoiceViewContainer = this.p;
    if (localModeChoiceViewContainer != null) {
      localModeChoiceViewContainer.d();
    }
  }
  
  protected String setLastActivityName()
  {
    return super.getString(2131892676);
  }
  
  public boolean showPreview()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      super.getWindow().addFlags(67108864);
    }
    return super.showPreview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity
 * JD-Core Version:    0.7.0.1
 */