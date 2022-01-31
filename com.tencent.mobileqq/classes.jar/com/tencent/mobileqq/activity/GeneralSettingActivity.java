package com.tencent.mobileqq.activity;

import acyd;
import acye;
import acyf;
import acyg;
import acyi;
import acyj;
import acyk;
import acyl;
import acym;
import acyn;
import acyo;
import acyp;
import acyq;
import acyr;
import acyt;
import adto;
import aekt;
import afai;
import alnq;
import alpo;
import alrh;
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
import android.text.TextUtils;
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
import aoju;
import auez;
import axho;
import azhx;
import azib;
import azmj;
import azwi;
import azwj;
import azwl;
import azwm;
import azwo;
import azwu;
import bajd;
import bdcd;
import bdfq;
import bepp;
import bjqq;
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
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class GeneralSettingActivity
  extends IphoneTitleBarActivity
  implements azwj, azwm, URLDrawable.URLDrawableListener2
{
  public adto a;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new acyd(this);
  public View a;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new acyg(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bdfq jdField_a_of_type_Bdfq;
  public bepp a;
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
    this.jdField_a_of_type_Adto = new adto();
    this.jdField_a_of_type_AndroidOsHandler = new acyj(this);
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
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = (azwl)this.app.getManager(361);
    boolean bool = ((azwl)localObject).a();
    localObject = ((azwl)localObject).a(this, paramInt1, paramInt2, paramBoolean1);
    if (((azwo)localObject).a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("GeneralSettingActivity", 2, "changeMode switchingStatus.isSwitching : true , mode : " + ((azwo)localObject).a());
      }
      if (paramBoolean2) {
        a(paramInt2, true);
      }
      ModeRadioGroup localModeRadioGroup = this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup;
      paramInt1 = ((azwo)localObject).a();
      if (!paramBoolean2) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        localModeRadioGroup.a(paramInt1, false, paramBoolean1);
        if (bool) {
          QQToast.a(BaseApplication.getContext(), 0, 2131719896, 0).a();
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "changeMode switchingStatus.isSwitching : false , mode : " + ((azwo)localObject).b());
    }
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(((azwo)localObject).b(), false, false);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Adto.a(paramInt, paramBoolean);
    this.jdField_a_of_type_AndroidViewView.setTag(Boolean.valueOf(paramBoolean));
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      e(2131694829, 1);
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
        localObject = new acyi(this, (Runnable)localObject);
        this.jdField_a_of_type_Bdfq = bdcd.a(this, getString(2131719891), 0, 2131719889, (DialogInterface.OnClickListener)localObject, null);
        this.jdField_a_of_type_Bdfq.setOnDismissListener(new acyt(this, paramCompoundButton));
        this.jdField_a_of_type_Bdfq.show();
        if (!paramBoolean1) {
          break label246;
        }
      }
    }
    label246:
    for (paramCompoundButton = "0X800A0FC";; paramCompoundButton = "0X800A0FD")
    {
      azmj.b(this.app, "dc00898", "", "", paramCompoundButton, paramCompoundButton, azib.c(), 0, "0", "0", "", "");
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
      localDrawable = getResources().getDrawable(2130839228);
      paramFormSwitchSimpleItem.setTag(localDrawable);
      int i = aekt.a(19.0F, getResources());
      localDrawable.setBounds(0, 0, i, i);
      paramFormSwitchSimpleItem.setCompoundDrawables(null, null, localDrawable, null);
      ((Animatable)localDrawable).start();
      paramFormSwitchSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a();
      if (paramBoolean) {
        break label145;
      }
    }
    label145:
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
    if ((azwu.b()) && (this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup != null))
    {
      int i = azwi.a(paramBoolean1, paramBoolean2);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(i, false, false);
    }
    a(paramBoolean1, azib.c());
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
      axho localaxho = (axho)this.app.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localaxho.a("100190.100194");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      localaxho.a(localAppInfo);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)super.findViewById(2131376728));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131376727);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)super.findViewById(2131361792));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364985));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131365782));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131371277));
    a(2131373641, 2131699772, 0, 2130839253);
    super.findViewById(2131364225).setOnClickListener(new acyk(this));
    super.findViewById(2131362933).setOnClickListener(new acyl(this));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131366650);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.c = super.findViewById(2131370766);
    if (auez.e()) {
      this.c.setVisibility(0);
    }
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.fontCfg.name(), "-1");
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "current fontSetting dpcValue=" + (String)localObject);
    }
    if (("1".equals(localObject)) && (alnq.b()))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (aoju.e())
      {
        alrh.a("GeneralSettingActivity, entrance1:false, entrance2:" + alrh.jdField_a_of_type_Boolean);
        View localView2 = findViewById(2131373640);
        if (localView2 != null)
        {
          localView2.setVisibility(0);
          if ((this.jdField_b_of_type_AndroidViewView instanceof FormSimpleItem)) {
            ((FormSimpleItem)this.jdField_b_of_type_AndroidViewView).setBgType(1);
          }
          ((TextView)localView2.findViewById(2131373655)).setText(getResources().getString(2131719814));
          View localView1 = localView2.findViewById(2131373656);
          localObject = localView1;
          if (localView1 == null) {
            localObject = ((ViewStub)localView2.findViewById(2131373657)).inflate();
          }
          ((View)localObject).setVisibility(0);
          localObject = (TextView)((View)localObject).findViewById(2131376798);
          ((TextView)localObject).setVisibility(0);
          ((TextView)localObject).setTextSize(0, getResources().getDimensionPixelSize(2131296662));
          ((TextView)localObject).setTypeface(Typeface.DEFAULT);
          ((TextView)localObject).setText(alrh.a(alrh.a()));
          localView2.setOnClickListener(new acym(this));
        }
      }
      boolean bool = SettingCloneUtil.readValue(this, null, getString(2131695435), "qqsetting_enter_sendmsg_key", false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new acyn(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131719878), "qqsetting_notify_icon_key", false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new acyo(this));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new acyp(this));
      this.c.setOnClickListener(new acyq(this));
      if (!bajd.a()) {
        break label745;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setChecked(bajd.c());
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setOnCheckedChangeListener(new acyr(this));
    }
    for (;;)
    {
      if (AppSetting.c)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(alpo.a(2131705623));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("系统通知栏显示QQ图标");
        this.c.setContentDescription(getActivity().getResources().getString(2131719871));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getActivity().getResources().getString(2131719862));
      }
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup = ((ModeRadioGroup)super.findViewById(2131367232));
      e();
      return;
      if ("0".equals(localObject))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        alnq.b(this);
        break;
      }
      if (alnq.a())
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        break;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      alnq.b(this);
      break;
      label745:
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void e()
  {
    azwl localazwl = (azwl)this.app.getManager(361);
    localazwl.a(this);
    Object localObject2 = (TextView)findViewById(2131376730);
    TextView localTextView = (TextView)findViewById(2131370656);
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365353);
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131364435);
    if (azwu.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
      localTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.setOnCheckChangeListener(this);
      localView.setVisibility(8);
      ((View)localObject1).setPadding(0, 0, 0, 0);
      localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).height -= aekt.a(20.0F, getResources());
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)
      {
        localObject1 = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).topMargin = aekt.a(14.0F, getResources());
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    boolean bool;
    for (;;)
    {
      bool = azib.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.b().setVisibility(8);
      this.jdField_a_of_type_Adto.a(this.jdField_a_of_type_AndroidViewView, this);
      a(bool, azib.c());
      if ((!azwu.b()) || (!localazwl.a())) {
        break label381;
      }
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(false);
      this.jdField_a_of_type_Adto.a(false);
      if ((azwi.a() != 1) || (localazwl.a() != 1)) {
        break;
      }
      this.jdField_a_of_type_Adto.b(localazwl.b(), true);
      this.jdField_a_of_type_AndroidViewView.setTag(Boolean.valueOf(true));
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(localazwl.a(), false, false);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(0);
      ((TextView)localObject2).setVisibility(0);
      localTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.setVisibility(8);
      localView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(localazwl.a(), false, true);
    return;
    label381:
    ((azhx)this.app.a(154)).a();
    if (azwu.b())
    {
      int i = azwi.a();
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
    localTopGestureLayout.setInterceptTouchEventListener(new acyf(this));
  }
  
  public void a(int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      e(2131694829, 1);
      QQToast.a(BaseApplication.getContext(), 1, 2131694829, 0).b(getTitleBarHeight());
    }
    while (a()) {
      return;
    }
    if (azwu.b()) {
      a(1, paramInt, false, true);
    }
    for (;;)
    {
      azmj.b(this.app, "dc00898", "", "", "0X800A3D6", "0X800A3D6", azhw.jdField_b_of_type_ArrayOfInt[paramInt] + 1, 0, "0", "0", "", "");
      return;
      if (!((azhx)this.app.a(154)).a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a().isChecked(), paramInt, false)) {
        e(2131719896, 0);
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
      azmj.b(this.app, "dc00898", "", "", "0X800AD6B", "0X800AD6B", 0, 0, "", "", "", "");
      if (paramInt1 != 1) {
        break label232;
      }
      i = 1;
      boolean bool = ThemeUtil.isNowThemeIsNight(this.app, false, null);
      j = azib.c();
      paramInt2 = j;
      if (i != 0)
      {
        if (!bool) {
          break label237;
        }
        paramInt2 = azib.b;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label264;
      }
      if (!bajd.a(this, azhw.jdField_b_of_type_ArrayOfJavaLangString[paramInt2], new acye(this, paramInt1, paramInt2))) {
        f(paramInt1, paramInt2);
      }
      return;
      if (paramInt1 == 1)
      {
        azmj.b(this.app, "dc00898", "", "", "0X800A0FC", "0X800A0FC", azib.c(), 0, "0", "0", "", "");
        break;
      }
      if (paramInt1 != 0) {
        break;
      }
      azmj.b(this.app, "dc00898", "", "", "0X800A0FD", "0X800A0FD", azib.c(), 0, "0", "0", "", "");
      break;
      label232:
      i = 0;
      break label84;
      label237:
      paramInt2 = j;
      if (ThemeUtil.isNowThemeIsNight(this.app, false, azhw.jdField_b_of_type_ArrayOfJavaLangString[j])) {
        paramInt2 = azib.d();
      }
    }
    label264:
    f(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView2 = findViewById(paramInt1);
    if (localView2 == null) {}
    for (;;)
    {
      return;
      TextView localTextView = (TextView)localView2.findViewById(2131373655);
      localTextView.setText(paramInt2);
      View localView1 = localView2.findViewById(2131373656);
      Object localObject = localView1;
      if (localView1 == null) {
        localObject = ((ViewStub)localView2.findViewById(2131373657)).inflate();
      }
      ((View)localObject).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131376798);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setTextSize(0, getResources().getDimensionPixelSize(2131296662));
      ((TextView)localObject).setTypeface(Typeface.DEFAULT);
      ((TextView)localObject).setText(alpo.a(2131705627));
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
        if (paramInt4 != 2130839269) {
          break label246;
        }
        ((FormItemRelativeLayout)localObject).setBGType(1);
      }
      while (paramInt1 == 2131373641)
      {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, localView2).c(30).a();
        c();
        return;
        label246:
        if (paramInt4 == 2130839263) {
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
      this.jdField_a_of_type_Adto.a(true);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(true);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt1);
      if (!paramBoolean) {
        break label155;
      }
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt1, false, false);
      if (paramInt1 != 1) {
        break label150;
      }
    }
    label150:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      a(paramBoolean, azib.c());
      bjqq.a();
      return;
      i = 1;
      break;
    }
    label155:
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt2, false, false);
    if (paramInt2 == 1) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      a(paramBoolean, azib.c());
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s onSwitchSimpleUICallback suc=%b bSwitchElsePref=%b hasChange=%b statusCode=%d", new Object[] { "SimpleUILog", Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) }));
    }
    Object localObject;
    label158:
    String str;
    if (paramBoolean3)
    {
      paramBoolean2 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a().isChecked();
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          a(getString(2131719893, new Object[] { alpo.a(2131705626) }), 2);
        }
        a(false, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem);
        a(azib.b(), azib.c());
        if (paramBoolean1) {
          bjqq.a();
        }
        return;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a(), azib.b());
      if (paramBoolean2)
      {
        localObject = alpo.a(2131705624);
        str = getString(2131719892, new Object[] { localObject });
        if (1 != paramInt) {
          break label238;
        }
        localObject = alpo.a(2131705621) + (String)localObject + alpo.a(2131705622);
      }
    }
    for (;;)
    {
      a((String)localObject, 1);
      break;
      localObject = alpo.a(2131705625);
      break label158;
      label238:
      if (6 == paramInt)
      {
        localObject = str + alpo.a(2131705620);
        continue;
        if (paramBoolean1) {
          break;
        }
        e(2131719890, 1);
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
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setChecked(bajd.c());
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "onModeChangeStart curType : " + paramInt1 + ", oldType : " + paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(false);
    this.jdField_a_of_type_Adto.a(false);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "onSelectModeRecover curType : " + paramInt1 + ", oldType : " + paramInt2);
    }
    this.jdField_a_of_type_Adto.a(true);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(true);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt2, false, false);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt1);
    if (paramInt2 == 1) {}
    for (;;)
    {
      a(bool, azib.c());
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
    this.jdField_a_of_type_Adto.a(false);
    if (paramInt2 == 1) {}
    for (;;)
    {
      a(bool, azib.c());
      return;
      bool = false;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561260);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      super.finish();
      return false;
    }
    super.setTitle(2131699751);
    this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    super.setVolumeControlStream(3);
    d();
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {
      super.dismissDialog(1);
    }
    if (this.jdField_a_of_type_Bdfq != null)
    {
      this.jdField_a_of_type_Bdfq.setOnDismissListener(null);
      if (this.jdField_a_of_type_Bdfq.isShowing()) {
        this.jdField_a_of_type_Bdfq.cancel();
      }
    }
    super.doOnDestroy();
    Object localObject = a();
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchEventListener(null);
    }
    localObject = (azwl)this.app.getManager(361);
    ((azwl)localObject).b(this);
    ((azwl)localObject).a();
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
    afai.b(this, QQSettingSettingActivity.class);
    return super.onBackEvent();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    this.jdField_a_of_type_Bepp = null;
    this.jdField_a_of_type_Bepp = new bepp(this, super.getTitleBarHeight());
    this.jdField_a_of_type_Bepp.a(getString(2131690863));
    this.jdField_a_of_type_Bepp.c(true);
    this.jdField_a_of_type_Bepp.a(false);
    this.jdField_a_of_type_Bepp.b(true);
    return this.jdField_a_of_type_Bepp;
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
    return super.getString(2131695398);
  }
  
  public boolean showPreview()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      super.getWindow().addFlags(67108864);
    }
    return super.showPreview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity
 * JD-Core Version:    0.7.0.1
 */