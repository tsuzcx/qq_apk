package com.tencent.mobileqq.activity;

import abhd;
import abhe;
import abhf;
import abhh;
import abhi;
import abhj;
import abhk;
import abhl;
import abhm;
import abhn;
import abho;
import abhp;
import abhq;
import abhr;
import abht;
import accg;
import actj;
import adic;
import ajwc;
import ajya;
import ajzt;
import amss;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import asoa;
import avps;
import axmr;
import axmu;
import axmv;
import axqy;
import aylh;
import bbdj;
import bbgu;
import bcqf;
import bcql;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.os.MqqHandler;

public class GeneralSettingActivity
  extends IphoneTitleBarActivity
  implements URLDrawable.URLDrawableListener2
{
  public accg a;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new abhd(this);
  public View a;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new abhf(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  axmu jdField_a_of_type_Axmu = new abhj(this);
  bbgu jdField_a_of_type_Bbgu;
  public bcqf a;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public FormSwitchSimpleItem a;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  FormSwitchSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem;
  private View c;
  
  public GeneralSettingActivity()
  {
    this.jdField_a_of_type_Accg = new accg();
    this.jdField_a_of_type_AndroidOsHandler = new abhi(this);
  }
  
  private TopGestureLayout a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      Object localObject = (ViewGroup)getWindow().getDecorView();
      View localView = ((ViewGroup)localObject).getChildAt(0);
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Accg.a(paramInt, paramBoolean);
    this.jdField_a_of_type_AndroidViewView.setTag(Boolean.valueOf(paramBoolean));
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      a(2131694673, 1);
      if (!paramBoolean1)
      {
        paramBoolean1 = true;
        a(paramCompoundButton, paramBoolean1);
      }
    }
    while (paramCompoundButton != this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a()) {
      for (;;)
      {
        return;
        paramBoolean1 = false;
      }
    }
    if (a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem))
    {
      if (!paramBoolean1) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        a(paramCompoundButton, paramBoolean1);
        return;
      }
    }
    Object localObject = new GeneralSettingActivity.12(this, paramBoolean2, paramInt, paramCompoundButton, paramBoolean1);
    if (paramBoolean1)
    {
      SharedPreferences localSharedPreferences = ThemeUtil.getUinThemePreferences(this.app);
      if (localSharedPreferences.getBoolean("key_simple_should_show_switch_dialog", true))
      {
        localSharedPreferences.edit().putBoolean("key_simple_should_show_switch_dialog", false).apply();
        localObject = new abhh(this, (Runnable)localObject);
        this.jdField_a_of_type_Bbgu = bbdj.a(this, getString(2131719405), 0, 2131719403, (DialogInterface.OnClickListener)localObject, null);
        this.jdField_a_of_type_Bbgu.setOnDismissListener(new abht(this, paramCompoundButton));
        this.jdField_a_of_type_Bbgu.show();
        if (!paramBoolean1) {
          break label242;
        }
      }
    }
    label242:
    for (paramCompoundButton = "0X800A0FC";; paramCompoundButton = "0X800A0FD")
    {
      axqy.b(this.app, "dc00898", "", "", paramCompoundButton, paramCompoundButton, axmv.c(), 0, "0", "0", "", "");
      return;
      ((Runnable)localObject).run();
      break;
      ((Runnable)localObject).run();
      break;
    }
  }
  
  private void a(boolean paramBoolean, FormSwitchSimpleItem paramFormSwitchSimpleItem)
  {
    paramFormSwitchSimpleItem = paramFormSwitchSimpleItem.b();
    if (paramFormSwitchSimpleItem == null) {
      return;
    }
    Drawable localDrawable;
    if (paramBoolean)
    {
      paramFormSwitchSimpleItem.setVisibility(0);
      localDrawable = getResources().getDrawable(2130839144);
      paramFormSwitchSimpleItem.setTag(localDrawable);
      int i = actj.a(19.0F, getResources());
      localDrawable.setBounds(0, 0, i, i);
      paramFormSwitchSimpleItem.setCompoundDrawables(null, null, localDrawable, null);
      ((Animatable)localDrawable).start();
      paramFormSwitchSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a();
      if (paramBoolean) {
        break label143;
      }
    }
    label143:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramFormSwitchSimpleItem.setEnabled(paramBoolean);
      return;
      localDrawable = (Drawable)paramFormSwitchSimpleItem.getTag();
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).stop();
      }
      paramFormSwitchSimpleItem.setTag(null);
      paramFormSwitchSimpleItem.setVisibility(8);
      paramFormSwitchSimpleItem.setCompoundDrawables(null, null, null, null);
      break;
    }
  }
  
  private boolean a(FormSwitchSimpleItem paramFormSwitchSimpleItem)
  {
    paramFormSwitchSimpleItem = paramFormSwitchSimpleItem.b();
    if (paramFormSwitchSimpleItem == null) {}
    while (!(paramFormSwitchSimpleItem.getTag() instanceof Animatable)) {
      return false;
    }
    return true;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      avps localavps = (avps)this.app.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localavps.a("100190.100194");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      localavps.a(localAppInfo);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)super.findViewById(2131376226));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131376225);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)super.findViewById(2131361792));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364898));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131365698));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131370966));
    a(2131373192, 2131699421, 0, 2130839169);
    super.findViewById(2131364163).setOnClickListener(new abhk(this));
    super.findViewById(2131362898).setOnClickListener(new abhl(this));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131366542);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.c = super.findViewById(2131370460);
    if (asoa.e()) {
      this.c.setVisibility(0);
    }
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.fontCfg.name(), "-1");
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "current fontSetting dpcValue=" + (String)localObject);
    }
    if (("1".equals(localObject)) && (ajwc.b()))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (amss.e())
      {
        ajzt.a("GeneralSettingActivity, entrance1:false, entrance2:" + ajzt.jdField_a_of_type_Boolean);
        View localView2 = findViewById(2131373191);
        if (localView2 != null)
        {
          localView2.setVisibility(0);
          if ((this.jdField_b_of_type_AndroidViewView instanceof FormSimpleItem)) {
            ((FormSimpleItem)this.jdField_b_of_type_AndroidViewView).setBgType(1);
          }
          ((TextView)localView2.findViewById(2131373206)).setText(getResources().getString(2131719330));
          View localView1 = localView2.findViewById(2131373207);
          localObject = localView1;
          if (localView1 == null) {
            localObject = ((ViewStub)localView2.findViewById(2131373208)).inflate();
          }
          ((View)localObject).setVisibility(0);
          localObject = (TextView)((View)localObject).findViewById(2131376295);
          ((TextView)localObject).setVisibility(0);
          ((TextView)localObject).setTextSize(0, getResources().getDimensionPixelSize(2131296646));
          ((TextView)localObject).setTypeface(Typeface.DEFAULT);
          ((TextView)localObject).setText(ajzt.a(ajzt.a()));
          localView2.setOnClickListener(new abhm(this));
        }
      }
      boolean bool = axmv.b();
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a(), bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.b().setVisibility(8);
      this.jdField_a_of_type_Accg.a(this.jdField_a_of_type_AndroidViewView, this);
      a(bool, axmv.c());
      ((axmr)this.app.a(154)).a();
      bool = SettingCloneUtil.readValue(this, null, getString(2131695277), "qqsetting_enter_sendmsg_key", false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new abhn(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131719392), "qqsetting_notify_icon_key", false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new abho(this));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new abhp(this));
      this.c.setOnClickListener(new abhq(this));
      if (!aylh.a()) {
        break label791;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setChecked(aylh.c());
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setOnCheckedChangeListener(new abhr(this));
    }
    for (;;)
    {
      if (AppSetting.d)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(ajya.a(2131705251));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("系统通知栏显示QQ图标");
        this.c.setContentDescription(getActivity().getResources().getString(2131719385));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getActivity().getResources().getString(2131719378));
      }
      return;
      if ("0".equals(localObject))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        ajwc.b(this);
        break;
      }
      if (ajwc.a())
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        break;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      ajwc.b(this);
      break;
      label791:
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void e()
  {
    ThreadManager.getUIHandler().post(new GeneralSettingActivity.16(this));
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout == null)
    {
      QLog.e("GeneralSettingActivity", 2, "processRvTouchEvent failed! topGestureLayout return null!");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    localTopGestureLayout.setInterceptTouchEventListener(new abhe(this));
  }
  
  public void a(int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      a(2131694673, 1);
      bcql.a(BaseApplication.getContext(), 1, 2131694673, 0).b(getTitleBarHeight());
    }
    while (a()) {
      return;
    }
    if (!((axmr)this.app.a(154)).a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a().isChecked(), paramInt, false)) {
      a(2131719410, 0);
    }
    for (;;)
    {
      axqy.b(this.app, "dc00898", "", "", "0X800A3D6", "0X800A3D6", axmq.b[paramInt] + 1, 0, "0", "0", "", "");
      return;
      a(paramInt, true);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    bcql.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView2 = findViewById(paramInt1);
    if (localView2 == null) {}
    for (;;)
    {
      return;
      TextView localTextView = (TextView)localView2.findViewById(2131373206);
      localTextView.setText(paramInt2);
      View localView1 = localView2.findViewById(2131373207);
      Object localObject = localView1;
      if (localView1 == null) {
        localObject = ((ViewStub)localView2.findViewById(2131373208)).inflate();
      }
      ((View)localObject).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131376295);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setTextSize(0, getResources().getDimensionPixelSize(2131296646));
      ((TextView)localObject).setTypeface(Typeface.DEFAULT);
      ((TextView)localObject).setText(ajya.a(2131705255));
      if (AppSetting.d) {
        localTextView.setContentDescription(getString(paramInt2));
      }
      if (paramInt3 > 0) {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(paramInt3), null, null, null);
      }
      localView2.setBackgroundResource(paramInt4);
      localView2.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((localView2 instanceof FormItemRelativeLayout))
      {
        localObject = (FormItemRelativeLayout)localView2;
        if (paramInt4 != 2130839185) {
          break label246;
        }
        ((FormItemRelativeLayout)localObject).setBGType(1);
      }
      while (paramInt1 == 2131373192)
      {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, localView2).c(30).a();
        c();
        return;
        label246:
        if (paramInt4 == 2130839179) {
          ((FormItemRelativeLayout)localObject).setBGType(2);
        }
      }
    }
  }
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  public void a(String paramString, int paramInt)
  {
    bcql.a(BaseApplication.getContext(), paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      a(paramInt, false);
      return;
    }
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    return ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue());
  }
  
  public void b()
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setChecked(aylh.c());
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561073);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      super.finish();
      return false;
    }
    super.setTitle(2131699400);
    this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    super.setVolumeControlStream(3);
    d();
    this.app.addObserver(this.jdField_a_of_type_Axmu);
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
      super.dismissDialog(1);
    }
    if (this.jdField_a_of_type_Bbgu != null)
    {
      this.jdField_a_of_type_Bbgu.setOnDismissListener(null);
      if (this.jdField_a_of_type_Bbgu.isShowing()) {
        this.jdField_a_of_type_Bbgu.cancel();
      }
    }
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Axmu);
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchEventListener(null);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a();
  }
  
  public boolean onBackEvent()
  {
    adic.b(this, QQSettingSettingActivity.class);
    return super.onBackEvent();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    this.jdField_a_of_type_Bcqf = null;
    this.jdField_a_of_type_Bcqf = new bcqf(this, super.getTitleBarHeight());
    this.jdField_a_of_type_Bcqf.a(getString(2131690811));
    this.jdField_a_of_type_Bcqf.c(true);
    this.jdField_a_of_type_Bcqf.a(false);
    this.jdField_a_of_type_Bcqf.b(true);
    return this.jdField_a_of_type_Bcqf;
  }
  
  public void onFileDownloaded(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s urldrawable onFileDownloaded", new Object[] { "SimpleUILog" }));
    }
    e();
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s urldrawable onLoadCanceled", new Object[] { "SimpleUILog" }));
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s urldrawable onLoadFialed", new Object[] { "SimpleUILog" }));
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s urldrawable onLoadCanceled", new Object[] { "SimpleUILog" }));
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s urldrawable onLoadSuccessed", new Object[] { "SimpleUILog" }));
    }
    e();
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s onPostThemeChanged", new Object[] { "SimpleUILog" }));
    }
  }
  
  public String setLastActivityName()
  {
    return super.getString(2131695240);
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