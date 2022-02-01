package com.tencent.mobileqq.activity;

import Override;
import aert;
import aeru;
import aerv;
import aerw;
import aery;
import aerz;
import aesa;
import aesb;
import aesc;
import aesd;
import aese;
import aesf;
import aesg;
import aesh;
import aesj;
import afnr;
import agej;
import aguy;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anxh;
import anzj;
import aobf;
import ares;
import axje;
import bbav;
import bdfv;
import bdgb;
import bdll;
import bdum;
import bdun;
import bdup;
import bduq;
import bdus;
import bduy;
import behm;
import bhlq;
import bhpc;
import bjbs;
import bnkk;
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
import com.tencent.mobileqq.studymode.ModeRadioGroup;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class GeneralSettingActivity
  extends IphoneTitleBarActivity
  implements bdun, bduq, URLDrawable.URLDrawableListener2
{
  public afnr a;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aert(this);
  public View a;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new aerw(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bdfv jdField_a_of_type_Bdfv;
  bhpc jdField_a_of_type_Bhpc;
  public bjbs a;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  ModeRadioGroup jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup;
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
    this.jdField_a_of_type_Afnr = new afnr();
    this.jdField_a_of_type_AndroidOsHandler = new aerz(this);
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
    this.jdField_a_of_type_Afnr.a(paramInt, paramBoolean);
    this.jdField_a_of_type_AndroidViewView.setTag(Boolean.valueOf(paramBoolean));
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      e(2131694008, 1);
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
    Object localObject = new GeneralSettingActivity.13(this, paramBoolean2, paramInt, paramCompoundButton, paramBoolean1);
    if (paramBoolean1)
    {
      SharedPreferences localSharedPreferences = ThemeUtil.getUinThemePreferences(this.app);
      if (localSharedPreferences.getBoolean("key_simple_should_show_switch_dialog", true))
      {
        localSharedPreferences.edit().putBoolean("key_simple_should_show_switch_dialog", false).apply();
        localObject = new aery(this, (Runnable)localObject);
        this.jdField_a_of_type_Bhpc = bhlq.a(this, getString(2131717982), 0, 2131717980, (DialogInterface.OnClickListener)localObject, null);
        this.jdField_a_of_type_Bhpc.setOnDismissListener(new aesj(this, paramCompoundButton));
        this.jdField_a_of_type_Bhpc.show();
        if (!paramBoolean1) {
          break label242;
        }
      }
    }
    label242:
    for (paramCompoundButton = "0X800A0FC";; paramCompoundButton = "0X800A0FD")
    {
      bdll.b(this.app, "dc00898", "", "", paramCompoundButton, paramCompoundButton, bdgb.c(), 0, "0", "0", "", "");
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
      localDrawable = getResources().getDrawable(2130839414);
      paramFormSwitchSimpleItem.setTag(localDrawable);
      int i = agej.a(19.0F, getResources());
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
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "handleModeSelectRadioByRequest");
    }
    if ((bduy.b()) && (this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup != null))
    {
      int i = bdum.a(paramBoolean1, paramBoolean2);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(i, false, false);
    }
    a(paramBoolean1, bdgb.c());
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
      bbav localbbav = (bbav)this.app.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localbbav.a("100190.100194");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      localbbav.a(localAppInfo);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)super.findViewById(2131377747));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131377746);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)super.findViewById(2131361792));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365267));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131366074));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131371976));
    a(2131374532, 2131698356, 0, 2130839440);
    super.findViewById(2131364478).setOnClickListener(new aesa(this));
    super.findViewById(2131363067).setOnClickListener(new aesb(this));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131366980);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.c = super.findViewById(2131371453);
    if (axje.a()) {
      this.c.setVisibility(0);
    }
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.fontCfg.name(), "-1");
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "current fontSetting dpcValue=" + (String)localObject);
    }
    if (("1".equals(localObject)) && (anxh.b()))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (ares.a())
      {
        aobf.a("GeneralSettingActivity, entrance1:false, entrance2:" + aobf.jdField_a_of_type_Boolean);
        View localView2 = findViewById(2131374531);
        if (localView2 != null)
        {
          localView2.setVisibility(0);
          if ((this.jdField_b_of_type_AndroidViewView instanceof FormSimpleItem)) {
            ((FormSimpleItem)this.jdField_b_of_type_AndroidViewView).setBgType(1);
          }
          ((TextView)localView2.findViewById(2131374546)).setText(getResources().getString(2131717930));
          View localView1 = localView2.findViewById(2131374547);
          localObject = localView1;
          if (localView1 == null) {
            localObject = ((ViewStub)localView2.findViewById(2131374548)).inflate();
          }
          ((View)localObject).setVisibility(0);
          localObject = (TextView)((View)localObject).findViewById(2131377813);
          ((TextView)localObject).setVisibility(0);
          ((TextView)localObject).setTextSize(0, getResources().getDimensionPixelSize(2131296717));
          ((TextView)localObject).setTypeface(Typeface.DEFAULT);
          ((TextView)localObject).setText(aobf.a(aobf.a()));
          localView2.setOnClickListener(new aesc(this));
        }
      }
      boolean bool = SettingCloneUtil.readValue(this, null, getString(2131694428), "qqsetting_enter_sendmsg_key", false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aesd(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131717971), "qqsetting_notify_icon_key", false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aese(this));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new aesf(this));
      this.c.setOnClickListener(new aesg(this));
      if (!behm.a()) {
        break label745;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setChecked(behm.c());
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setOnCheckedChangeListener(new aesh(this));
    }
    for (;;)
    {
      if (AppSetting.c)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anzj.a(2131704138));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("系统通知栏显示QQ图标");
        this.c.setContentDescription(getActivity().getResources().getString(2131717965));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getActivity().getResources().getString(2131717960));
      }
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup = ((ModeRadioGroup)super.findViewById(2131367597));
      e();
      return;
      if ("0".equals(localObject))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        anxh.b(this);
        break;
      }
      if (anxh.a())
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        break;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      anxh.b(this);
      break;
      label745:
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void e()
  {
    bdup localbdup = (bdup)this.app.getManager(361);
    localbdup.a(this);
    Object localObject2 = (TextView)findViewById(2131377749);
    TextView localTextView = (TextView)findViewById(2131371337);
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365632);
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131364689);
    if (bduy.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
      localTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.setOnCheckChangeListener(this);
      localView.setVisibility(8);
      ((View)localObject1).setPadding(0, 0, 0, 0);
      localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).height -= agej.a(20.0F, getResources());
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)
      {
        localObject1 = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).topMargin = agej.a(14.0F, getResources());
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    boolean bool;
    for (;;)
    {
      bool = bdgb.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.b().setVisibility(8);
      this.jdField_a_of_type_Afnr.a(this.jdField_a_of_type_AndroidViewView, this);
      a(bool, bdgb.c());
      if ((!bduy.b()) || (!localbdup.a())) {
        break label381;
      }
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(false);
      this.jdField_a_of_type_Afnr.a(false);
      if ((bdum.a() != 1) || (localbdup.a() != 1)) {
        break;
      }
      this.jdField_a_of_type_Afnr.b(localbdup.b(), true);
      this.jdField_a_of_type_AndroidViewView.setTag(Boolean.valueOf(true));
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(localbdup.a(), false, false);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(0);
      ((TextView)localObject2).setVisibility(0);
      localTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.setVisibility(8);
      localView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(localbdup.a(), false, true);
    return;
    label381:
    ((bdfv)this.app.a(154)).a();
    if (bduy.b())
    {
      int i = bdum.a();
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(i, false, false);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a(), bool);
  }
  
  private void f()
  {
    ThreadManager.getUIHandler().post(new GeneralSettingActivity.16(this));
  }
  
  private void f(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, true, false);
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
    localTopGestureLayout.setInterceptTouchEventListener(new aerv(this));
  }
  
  public void a(int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      e(2131694008, 1);
      QQToast.a(BaseApplication.getContext(), 1, 2131694008, 0).b(getTitleBarHeight());
    }
    while (a()) {
      return;
    }
    if (bduy.b()) {
      a(1, paramInt, false, true);
    }
    for (;;)
    {
      bdll.b(this.app, "dc00898", "", "", "0X800A3D6", "0X800A3D6", paramInt + 1, 0, "0", "0", "", "");
      return;
      if (!((bdfv)this.app.a(154)).a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a().isChecked(), paramInt, false)) {
        e(2131717987, 0);
      } else {
        a(paramInt, true);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "onModeCheckedChanged curType : " + paramInt1 + ", oldType : " + paramInt2);
    }
    int i;
    label84:
    int j;
    if (paramInt1 == 2)
    {
      bdll.b(this.app, "dc00898", "", "", "0X800AD6B", "0X800AD6B", 0, 0, "", "", "", "");
      if (paramInt1 != 1) {
        break label221;
      }
      i = 1;
      boolean bool = ThemeUtil.isNowThemeIsNight(this.app, false, null);
      j = bdgb.c();
      paramInt2 = j;
      if (i != 0)
      {
        if (!bool) {
          break label226;
        }
        paramInt2 = bdgb.c;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label252;
      }
      if (!behm.a(this, bdgb.a(paramInt2), new aeru(this, paramInt1, paramInt2))) {
        f(paramInt1, paramInt2);
      }
      return;
      if (paramInt1 == 1)
      {
        bdll.b(this.app, "dc00898", "", "", "0X800A0FC", "0X800A0FC", bdgb.c(), 0, "0", "0", "", "");
        break;
      }
      if (paramInt1 != 0) {
        break;
      }
      bdll.b(this.app, "dc00898", "", "", "0X800A0FD", "0X800A0FD", bdgb.c(), 0, "0", "0", "", "");
      break;
      label221:
      i = 0;
      break label84;
      label226:
      paramInt2 = j;
      if (ThemeUtil.isNowThemeIsNight(this.app, false, bdgb.a(j))) {
        paramInt2 = bdgb.d();
      }
    }
    label252:
    f(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView2 = findViewById(paramInt1);
    if (localView2 == null) {}
    for (;;)
    {
      return;
      TextView localTextView = (TextView)localView2.findViewById(2131374546);
      localTextView.setText(paramInt2);
      View localView1 = localView2.findViewById(2131374547);
      Object localObject = localView1;
      if (localView1 == null) {
        localObject = ((ViewStub)localView2.findViewById(2131374548)).inflate();
      }
      ((View)localObject).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131377813);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setTextSize(0, getResources().getDimensionPixelSize(2131296717));
      ((TextView)localObject).setTypeface(Typeface.DEFAULT);
      ((TextView)localObject).setText(anzj.a(2131704142));
      if (AppSetting.c) {
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
        if (paramInt4 != 2130839456) {
          break label246;
        }
        ((FormItemRelativeLayout)localObject).setBGType(1);
      }
      while (paramInt1 == 2131374532)
      {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, localView2).c(30).a();
        c();
        return;
        label246:
        if (paramInt4 == 2130839450) {
          ((FormItemRelativeLayout)localObject).setBGType(2);
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = (bdup)this.app.getManager(361);
    boolean bool = ((bdup)localObject).a();
    localObject = ((bdup)localObject).a(this, paramInt1, paramInt2, paramBoolean1);
    if (((bdus)localObject).a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("GeneralSettingActivity", 2, "changeMode switchingStatus.isSwitching : true , mode : " + ((bdus)localObject).a());
      }
      if (paramBoolean2)
      {
        a(paramInt2, true);
        this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(false);
        this.jdField_a_of_type_Afnr.a(false);
      }
      ModeRadioGroup localModeRadioGroup = this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup;
      paramInt1 = ((bdus)localObject).a();
      if (!paramBoolean2) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        localModeRadioGroup.a(paramInt1, false, paramBoolean1);
        if (bool) {
          QQToast.a(BaseApplication.getContext(), 0, 2131717987, 0).a();
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "changeMode switchingStatus.isSwitching : false , mode : " + ((bdus)localObject).b());
    }
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(((bdus)localObject).b(), false, false);
  }
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  void a(String paramString, int paramInt)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).b(getTitleBarHeight());
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
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramBoolean)
      {
        i = 2;
        QQToast.a(this, i, paramString, 0).a();
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("GeneralSettingActivity", 2, "onModeChangeComplete isSuccess : " + paramBoolean + ", curType : " + paramInt1 + ", oldType : " + paramInt2);
      }
      this.jdField_a_of_type_Afnr.a(true);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(true);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt1);
      if (!paramBoolean) {
        break label156;
      }
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt1, false, false);
      if (paramInt1 != 1) {
        break label151;
      }
    }
    label151:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      a(paramBoolean, bdgb.c());
      bnkk.a();
      return;
      i = 1;
      break;
    }
    label156:
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt2, false, false);
    if (paramInt2 == 1) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      a(paramBoolean, bdgb.c());
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s onSwitchSimpleUICallback suc=%b bSwitchElsePref=%b hasChange=%b statusCode=%d", new Object[] { "SimpleUILog", Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) }));
    }
    Object localObject;
    label159:
    String str;
    if (paramBoolean3)
    {
      paramBoolean2 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a().isChecked();
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          a(getString(2131717984, new Object[] { anzj.a(2131704141) }), 2);
        }
        a(false, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem);
        a(bdgb.b(), bdgb.c());
        if (paramBoolean1) {
          bnkk.a();
        }
        return;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a(), bdgb.b());
      if (paramBoolean2)
      {
        localObject = anzj.a(2131704139);
        str = getString(2131717983, new Object[] { localObject });
        if (1 != paramInt) {
          break label239;
        }
        localObject = anzj.a(2131704136) + (String)localObject + anzj.a(2131704137);
      }
    }
    for (;;)
    {
      a((String)localObject, 1);
      break;
      localObject = anzj.a(2131704140);
      break label159;
      label239:
      if (6 == paramInt)
      {
        localObject = str + anzj.a(2131704135);
        continue;
        if (paramBoolean1) {
          break;
        }
        e(2131717981, 1);
        break;
      }
      localObject = str;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, @Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s onReqGetSimpleUISwitch suc=%b [%b,%d]", new Object[] { "SimpleUILog", Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) }));
    }
    if ((!paramBoolean1) || (!this.app.getCurrentAccountUin().equals(paramString))) {}
    while ((a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem)) || (a())) {
      return;
    }
    a(paramBoolean2, paramBoolean3);
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    return ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue());
  }
  
  public void b()
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setChecked(behm.c());
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "onModeChangeStart curType : " + paramInt1 + ", oldType : " + paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(false);
    this.jdField_a_of_type_Afnr.a(false);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "onSelectModeRecover curType : " + paramInt1 + ", oldType : " + paramInt2);
    }
    this.jdField_a_of_type_Afnr.a(true);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(true);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt2, false, false);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt1);
    if (paramInt2 == 1) {}
    for (;;)
    {
      a(bool, bdgb.c());
      return;
      bool = false;
    }
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "onModeSwitching curType : " + paramInt1 + ", oldType : " + paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt1, false, true);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(false);
    this.jdField_a_of_type_Afnr.a(false);
    if (paramInt2 == 1) {}
    for (;;)
    {
      a(bool, bdgb.c());
      return;
      bool = false;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      ((bdfv)this.app.a(154)).b();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561550);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      super.finish();
      return false;
    }
    super.setTitle(2131698339);
    this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    super.setVolumeControlStream(3);
    d();
    this.jdField_a_of_type_Bdfv = ((bdfv)this.app.a(154));
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
      super.dismissDialog(1);
    }
    if (this.jdField_a_of_type_Bhpc != null)
    {
      this.jdField_a_of_type_Bhpc.setOnDismissListener(null);
      if (this.jdField_a_of_type_Bhpc.isShowing()) {
        this.jdField_a_of_type_Bhpc.cancel();
      }
    }
    if (this.jdField_a_of_type_Afnr != null) {
      this.jdField_a_of_type_Afnr.b();
    }
    if (this.jdField_a_of_type_Bdfv != null) {
      this.jdField_a_of_type_Bdfv.onDestroy();
    }
    super.doOnDestroy();
    Object localObject = a();
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchEventListener(null);
    }
    localObject = (bdup)this.app.getManager(361);
    ((bdup)localObject).b(this);
    ((bdup)localObject).a();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a();
  }
  
  void e(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  public boolean onBackEvent()
  {
    aguy.b(this, QQSettingSettingActivity.class);
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
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    this.jdField_a_of_type_Bjbs = null;
    this.jdField_a_of_type_Bjbs = new bjbs(this, super.getTitleBarHeight());
    this.jdField_a_of_type_Bjbs.a(getString(2131690711));
    this.jdField_a_of_type_Bjbs.c(true);
    this.jdField_a_of_type_Bjbs.a(false);
    this.jdField_a_of_type_Bjbs.b(true);
    return this.jdField_a_of_type_Bjbs;
  }
  
  public void onFileDownloaded(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s urldrawable onFileDownloaded", new Object[] { "SimpleUILog" }));
    }
    f();
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
    f();
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
    return super.getString(2131694406);
  }
  
  public boolean showPreview()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      super.getWindow().addFlags(67108864);
    }
    return super.showPreview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity
 * JD-Core Version:    0.7.0.1
 */