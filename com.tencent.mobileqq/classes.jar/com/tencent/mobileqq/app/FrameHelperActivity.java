package com.tencent.mobileqq.app;

import aepi;
import ajih;
import alsn;
import alsq;
import alsr;
import alss;
import alst;
import alsu;
import alsv;
import alsw;
import alsx;
import alsy;
import alsz;
import alta;
import altb;
import altc;
import altd;
import alte;
import altf;
import altg;
import alth;
import alud;
import alzu;
import alzw;
import amfs;
import amoj;
import amqe;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import arwe;
import avsm;
import awcx;
import awdo;
import awen;
import aweo;
import azqs;
import azri;
import bacu;
import bczz;
import bdbk;
import bddn;
import bdgk;
import bhsg;
import bicb;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import rya;

public class FrameHelperActivity
  extends FrameFragment
  implements View.OnClickListener, Animation.AnimationListener
{
  public static WeakReference<DrawerFrame> a;
  public static boolean i;
  private int jdField_a_of_type_Int = 3;
  private altc jdField_a_of_type_Altc;
  public altf a;
  private alth jdField_a_of_type_Alth;
  public alzw a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  public Handler a;
  public ViewGroup a;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  public ImageView a;
  public RelativeLayout a;
  public arwe a;
  public awcx a;
  private awdo jdField_a_of_type_Awdo = new alsw(this);
  public awen a;
  public DrawerFrame a;
  private BatteryBroadcastReceiver jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  public RedTouch a;
  private VasQuickUpdateManager.CallBacker jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker;
  private boolean jdField_a_of_type_Boolean;
  public ajih[] a;
  private int jdField_b_of_type_Int = 0;
  public View b;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean = true;
  public View c;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f = true;
  protected boolean h;
  
  public FrameHelperActivity()
  {
    this.jdField_a_of_type_ArrayOfAjih = new ajih[] { null, null, null, null };
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new alsq(this);
    this.jdField_a_of_type_Alzw = new alst(this);
    this.jdField_a_of_type_Arwe = new alsu(this);
    this.jdField_a_of_type_Awen = new alsv(this);
  }
  
  public static FrameHelperActivity a(BaseActivity paramBaseActivity)
  {
    paramBaseActivity = ((FragmentActivity)paramBaseActivity).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (paramBaseActivity != null) {
      return (FrameHelperActivity)paramBaseActivity;
    }
    return null;
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (!ThemeUtil.isNowThemeIsDefault(getActivity().getAppInterface(), true, null)) {
      return;
    }
    paramQQAppInterface.a(new FrameHelperActivity.6(this, paramQQAppInterface));
  }
  
  private void a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.lQQMasterLogindays > 0L)
      {
        FriendProfileCardActivity.a = this.jdField_a_of_type_ComTencentMobileqqDataCard.lQQMasterLogindays;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays != 1L) && ((this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays <= 1L) || (this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays >= FriendProfileCardActivity.a))) {
          break label155;
        }
        localObject = String.format(getString(2131694172), new Object[] { Integer.valueOf((int)(FriendProfileCardActivity.a - this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays)) });
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null) {
        break label220;
      }
      paramQQAppInterface = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365233);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.requestFocus();
        paramQQAppInterface.setText((CharSequence)localObject);
        paramQQAppInterface.setContentDescription((CharSequence)localObject);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
      FriendProfileCardActivity.a = 30L;
      break;
      label155:
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays >= FriendProfileCardActivity.a)
      {
        localObject = String.format(getString(2131694173), new Object[] { Integer.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays) });
      }
      else
      {
        localObject = getString(2131694174);
        continue;
        localObject = getString(2131694174);
      }
    }
    label220:
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(paramFragmentActivity, 2131755801);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558919);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365237);
    if (localTextView != null) {
      localTextView.setText(getString(2131694169));
    }
    localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365233);
    if (localTextView != null)
    {
      localTextView.requestFocus();
      localTextView.setText((CharSequence)localObject);
      localTextView.setContentDescription((CharSequence)localObject);
    }
    Object localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365222);
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131690648);
      ((TextView)localObject).setOnClickListener(new alsx(this, paramQQAppInterface));
    }
    localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365228);
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131694171);
      ((TextView)localObject).setOnClickListener(new alsy(this, paramQQAppInterface, paramFragmentActivity));
    }
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new alsz(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public static int b()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      int j = ((BatteryManager)BaseApplication.getContext().getSystemService("batterymanager")).getIntProperty(4);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, new Object[] { "BatterManager ", Integer.valueOf(j) });
      }
      return j;
    }
    return 0;
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "registerBatteryBroadcastReceiver start");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver == null)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver = new BatteryBroadcastReceiver(paramQQAppInterface);
        BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver, localIntentFilter);
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "registerBatteryBroadcastReceiver success");
        }
      }
      paramQQAppInterface.K();
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("Q.recent", 1, paramQQAppInterface, new Object[] { "registerBatteryBroadcastReceiver fail" });
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)jdField_a_of_type_JavaLangRefWeakReference.get();; localDrawerFrame = null)
    {
      if (localDrawerFrame != null)
      {
        localDrawerFrame.jdField_b_of_type_Boolean = paramBoolean;
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "setDrawerFrameTouchable, " + paramBoolean);
        }
      }
      return;
    }
  }
  
  public static boolean b()
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)jdField_a_of_type_JavaLangRefWeakReference.get(); localDrawerFrame == null; localDrawerFrame = null) {
      return false;
    }
    if ((localDrawerFrame.b()) || (localDrawerFrame.c())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private int c()
  {
    alsn localalsn = b();
    if ((localalsn instanceof Conversation)) {}
    do
    {
      return 1;
      if ((localalsn instanceof Contacts)) {
        return 3;
      }
    } while (!(localalsn instanceof Leba));
    return 4;
  }
  
  private void c()
  {
    ThreadManager.post(new FrameHelperActivity.2(this), 5, null, true);
  }
  
  public static void c(boolean paramBoolean)
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)jdField_a_of_type_JavaLangRefWeakReference.get();; localDrawerFrame = null)
    {
      if (localDrawerFrame != null)
      {
        localDrawerFrame.setDrawerEnabled(paramBoolean);
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "setDrawerFrameEnable, " + paramBoolean);
        }
      }
      return;
    }
  }
  
  private void d()
  {
    QLog.i("Q.recent", 1, "frameHelper_initDrawerFrame: mDrawerFrame=  " + this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame + "mDrawerBg= " + this.jdField_a_of_type_AndroidViewViewGroup + "mIsInflated = " + this.e);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) {
      if (this.jdField_a_of_type_Altc != null) {
        this.jdField_a_of_type_Altc.g(true);
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Alth == null)
      {
        localObject = (Conversation)a(Conversation.class);
        if (localObject != null) {
          ((Conversation)localObject).r();
        }
      }
      if (!this.e) {
        p();
      }
      Object localObject = (ViewGroup)getActivity().findViewById(2131364774);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame = new DrawerFrame(getActivity(), (ViewGroup)localObject, this.jdField_a_of_type_Alth.a(), null, this.jdField_a_of_type_AndroidViewViewGroup, this);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) {
          continue;
        }
        if (this.jdField_a_of_type_Altc != null) {
          this.jdField_a_of_type_Altc.g(true);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.setDrawerCallbacks(new alta(this));
        r();
        jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.i("Q.recent", 1, "frameHelper_initDrawerFrame exception, " + localException.toString());
        }
      }
    }
  }
  
  private void e()
  {
    this.d = true;
    this.jdField_c_of_type_AndroidViewView = getActivity().findViewById(2131369215);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && ((this.jdField_c_of_type_AndroidViewView.getLayoutParams() instanceof FrameLayout.LayoutParams)))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
      this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
    if (!this.h)
    {
      this.h = true;
      this.jdField_c_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)getActivity().findViewById(2131364834));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)getActivity().findViewById(2131371378));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = getActivity().findViewById(2131364836);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    q();
    v();
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Awcx != null) {
      return;
    }
    bacu.c(getActivity().app, true);
    this.jdField_a_of_type_Awcx = new awcx(getActivity());
    this.jdField_a_of_type_Awcx.a(this.jdField_a_of_type_Awdo);
    this.jdField_a_of_type_Awcx.a(new altg(this));
    this.jdField_b_of_type_AndroidViewView.setHapticFeedbackEnabled(false);
    this.jdField_b_of_type_AndroidViewView.setOnLongClickListener(new altb(this));
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new alsr(this));
    bczz.b(this.jdField_b_of_type_AndroidViewView, Button.class.getName());
  }
  
  private void f(boolean paramBoolean)
  {
    RandomCoverView localRandomCoverView;
    ImageView localImageView1;
    ImageView localImageView2;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localRandomCoverView = (RandomCoverView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378146);
      localImageView1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363381);
      localImageView2 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379334);
      if (!ThemeUtil.isNowThemeIsDefault(getActivity().app, paramBoolean, null)) {}
    }
    else
    {
      try
      {
        localRandomCoverView.setVisibility(0);
        if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(14)) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(14);
        }
        localImageView1.setVisibility(0);
        localImageView2.setVisibility(8);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localRandomCoverView.setVisibility(8);
          localOutOfMemoryError.printStackTrace();
        }
      }
    }
    localImageView1.setVisibility(8);
    localRandomCoverView.a().setImageDrawable(null);
    localRandomCoverView.setVisibility(8);
    localImageView2.setImageResource(2130844554);
    localImageView2.setVisibility(0);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null)
    {
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        break label41;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b();
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.setDrawerShadowFlag(true);
    return;
    label41:
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a();
  }
  
  private void i()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
    }
    while (localObject == null)
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      } else {
        localObject = null;
      }
    }
    AnimationSet localAnimationSet = new AnimationSet(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.3F, 1.0F, 1.3F, 1, 0.5F, 1, 0.5F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.6F);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setDuration(120L);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new alss(this, (View)localObject));
    ((View)localObject).startAnimation(localAnimationSet);
  }
  
  private void j()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
    }
    while ((localObject == null) || (((View)localObject).getAnimation() == null))
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      } else {
        localObject = null;
      }
    }
    AnimationSet localAnimationSet = new AnimationSet(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.2F, 1.0F, 1.2F, 1.0F, 1, 0.5F, 1, 0.5F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.5F, 1.0F);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setDuration(100L);
    localAnimationSet.setFillAfter(false);
    ((View)localObject).startAnimation(localAnimationSet);
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_Awcx != null) && (this.jdField_a_of_type_Awcx.isShowing())) {
      this.jdField_a_of_type_Awcx.a(false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "closeAccountPanel");
    }
  }
  
  public static void s()
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)jdField_a_of_type_JavaLangRefWeakReference.get();; localDrawerFrame = null)
    {
      if (localDrawerFrame != null) {
        localDrawerFrame.i();
      }
      return;
    }
  }
  
  public static void t()
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (DrawerFrame localDrawerFrame = (DrawerFrame)jdField_a_of_type_JavaLangRefWeakReference.get();; localDrawerFrame = null)
    {
      if ((localDrawerFrame != null) && (localDrawerFrame.b())) {
        localDrawerFrame.h();
      }
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_Alth != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b()))
    {
      this.jdField_a_of_type_Alth.a(paramInt1, paramInt2, paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "[setDrawerBg(app)]from doOnActivityResult");
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(14);
      return;
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject2;
    if ((getActivity() == null) || (getActivity().app == null))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("doDrawerActionReport, getActivity =  ").append(getActivity()).append(" app = ");
        if (getActivity() != null) {
          break label79;
        }
      }
      label79:
      for (localObject1 = null;; localObject1 = getActivity().app)
      {
        QLog.i("Q.recent", 2, localObject1);
        return;
      }
    }
    Object localObject1 = null;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (localObject1 != null) {
        azqs.b(getActivity().app, "CliOper", "", "", (String)localObject1, (String)localObject1, paramInt2, 0, "", "", "", "");
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("Q.recent", 4, "doDrawerActionReport, actionFlag: " + paramInt1 + ", tag = " + (String)localObject1);
      return;
      if (paramBoolean)
      {
        localObject1 = getActivity().app;
        localObject2 = getActivity().app.c();
        if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) && (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b())) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          int j = amfs.a((QQAppInterface)localObject1, (String)localObject2, paramBoolean);
          azqs.b(getActivity().app, "dc00898", "", "", "0X800ABB1", "0X800ABB1", j, 0, "0", "0", "", "");
          localObject1 = "0X800402E";
          break;
        }
      }
      localObject1 = "0X800402F";
      continue;
      localObject1 = "0X8004032";
      continue;
      localObject1 = "0X8004030";
      continue;
      localObject1 = "0X8004031";
    }
  }
  
  public void a(altc paramaltc)
  {
    this.jdField_a_of_type_Altc = paramaltc;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (paramaltc != null)) {
      paramaltc.g(true);
    }
  }
  
  public void a(alth paramalth)
  {
    this.jdField_a_of_type_Alth = paramalth;
  }
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.b();
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("unreadcount", 4).edit();
    localEditor.putInt("unread", 0);
    localEditor.apply();
    paramQQAppInterface.logout(true);
    if (BaseApplicationImpl.sImageCache != null) {
      BaseApplicationImpl.sImageCache.evictAll();
    }
    int j = bddn.a(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    bddn.a(paramActivity, paramQQAppInterface.getCurrentAccountUin(), j + 1);
    paramActivity.startActivity(localIntent);
    if (QQPlayerService.a())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast(paramQQAppInterface);
    }
    paramActivity.finish();
  }
  
  public void a(QQAppInterface paramQQAppInterface, AppRuntime.Status paramStatus, long paramLong)
  {
    if (paramQQAppInterface != null)
    {
      if (b() <= 0) {
        break label52;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "handleBatteryChangeBroadcastReceiver LocalBattery correct");
      }
      if ((paramStatus != AppRuntime.Status.online) || (paramLong != 1000L)) {
        break label47;
      }
      b(paramQQAppInterface);
    }
    label47:
    label52:
    do
    {
      return;
      w();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "handleBatteryChangeBroadcastReceiver LocalBattery wrong");
      }
      if (this.jdField_b_of_type_Int == 0)
      {
        b(paramQQAppInterface);
        return;
      }
      if (this.jdField_b_of_type_Int == 1)
      {
        if ((paramStatus == AppRuntime.Status.online) && (paramLong == 1000L))
        {
          b(paramQQAppInterface);
          return;
        }
        w();
        return;
      }
    } while (this.jdField_b_of_type_Int != 2);
    w();
  }
  
  public void a(Card paramCard)
  {
    Object localObject = getActivity();
    if ((localObject == null) || (((FragmentActivity)localObject).getAppInterface() == null) || (!ThemeUtil.isNowThemeIsDefault(getActivity().getAppInterface(), true, null)) || (paramCard == null) || (this.jdField_a_of_type_Alth == null)) {
      return;
    }
    localObject = ((FragmentActivity)localObject).app;
    RandomCoverView localRandomCoverView = (RandomCoverView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378146);
    String str = (String)paramCard.getCoverData(0)[0];
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "[getCoverData] getCovertUrl from net,url:" + str);
    }
    if ((!TextUtils.isEmpty(str)) && (!bhsg.b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "card.isNoCover()=" + paramCard.isNoCover());
      }
      if ((!bhsg.a((QQAppInterface)localObject, paramCard)) && (paramCard.isNoCover()))
      {
        this.jdField_a_of_type_Alth.a(false);
        ThreadManager.getUIHandler().post(new FrameHelperActivity.4(this, localRandomCoverView));
        return;
      }
      this.jdField_a_of_type_Alth.a(true);
      ThreadManager.getUIHandler().post(new FrameHelperActivity.5(this, localRandomCoverView));
      this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = bhsg.a(getActivity(), (QQAppInterface)localObject, paramCard, localRandomCoverView, str, this.jdField_a_of_type_Alth, this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a());
      return;
    }
    if (bhsg.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "account has logouted,restart to fetch coverUrl");
      }
      bhsg.c();
      this.jdField_a_of_type_Int = 3;
    }
    a((QQAppInterface)localObject);
  }
  
  protected void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    w();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a(paramBoolean);
    }
  }
  
  public boolean a(Message paramMessage)
  {
    if ((this.jdField_c_of_type_Boolean) || (getActivity() == null)) {}
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              switch (paramMessage.what)
              {
              case 7: 
              case 8: 
              case 15: 
              case 16: 
              default: 
                return false;
              }
            } while (this.d);
            e();
            return false;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) {
              d();
            }
          } while ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a()));
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.e();
          return false;
          if (this.jdField_a_of_type_Alth != null) {
            this.jdField_a_of_type_Alth.a(getActivity().app);
          }
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "start updateOnlineStatus");
          }
          v();
          bacu.c(getActivity().app, true);
          return false;
          if (paramMessage.arg1 == 0)
          {
            ThreadManager.getSubThreadHandler().post(new FrameHelperActivity.8(this));
            paramMessage = Message.obtain();
            paramMessage.what = 2;
            paramMessage.arg1 = 1;
            this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 20000L);
            return false;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.recent", 2, "frameHelper_infalter time out, need do in UI thread ");
          }
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
          return false;
          q();
          return false;
          r();
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b()));
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "[setDrawerBg(app)]from MSG_SET_DIYBG, drawerOpened?" + this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b());
        }
        bhsg.b();
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(14);
        return false;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        d();
        f();
        return false;
        if (!this.d) {
          e();
        }
        if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null)
        {
          this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -getResources().getDimension(2131298915));
          this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(150L);
          this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
        }
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
        this.jdField_c_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
        return false;
        if (!this.d) {
          e();
        }
        if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == null)
        {
          this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -getResources().getDimension(2131298915), 0.0F);
          this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(150L);
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
        this.jdField_c_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
        return false;
        if (!this.d) {
          e();
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, "FrameHelperActivity, updateSelfFace now");
        }
        localObject = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
        if ((localObject != null) && ((localObject instanceof bdbk))) {
          ((bdbk)localObject).a();
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)paramMessage.obj);
        return false;
        i();
        return false;
        a(getActivity().app);
        return false;
        if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
          break;
        }
        paramMessage = (alzu)getActivity().app.getManager(257);
        localObject = paramMessage.b();
      } while ((((ArrayList)localObject).size() <= 0) || (!amoj.a(getActivity(), (ArrayList)localObject)));
      paramMessage.a((ArrayList)localObject);
      return false;
    } while (!QLog.isColorLevel());
    QLog.e("QIMNewFriend", 2, "showDialog|mIsForeground = " + this.jdField_b_of_type_Boolean + ",isDrawerOpen = " + this.jdField_a_of_type_Boolean);
    return false;
    v();
    return false;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(paramInt);
    }
  }
  
  public alsn c()
  {
    return b();
  }
  
  public void d(boolean paramBoolean)
  {
    i = paramBoolean;
    if (i) {
      rya.a().a(false);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_AndroidViewView == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.", 2, "showHeadMask, show:" + paramBoolean);
            }
            if (!paramBoolean) {
              break;
            }
          } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null);
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.", 2, "create new mask");
          }
          localObject = this.jdField_c_of_type_AndroidViewView.getContext();
        } while (localObject == null);
        int j = aepi.a(37.0F, getResources());
        int k = aepi.a(60.0F, getResources());
        int m = aepi.a(12.0F, getResources());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout((Context)localObject);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, k);
        localLayoutParams.addRule(9, -1);
        localLayoutParams.addRule(15, -1);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
        Object localObject = new RelativeLayout((Context)localObject);
        localLayoutParams = new RelativeLayout.LayoutParams(j + 2, j + 2);
        localLayoutParams.addRule(9, -1);
        localLayoutParams.addRule(15, -1);
        localLayoutParams.leftMargin = (m - 1);
        ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
        ((RelativeLayout)localObject).setBackgroundDrawable(this.jdField_c_of_type_AndroidViewView.getResources().getDrawable(2130840275));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
        if ((this.jdField_c_of_type_AndroidViewView instanceof ViewGroup))
        {
          ((ViewGroup)this.jdField_c_of_type_AndroidViewView).addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.profilecard.", 2, "addview error");
      return;
    } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "remove mask");
    }
    if ((this.jdField_c_of_type_AndroidViewView instanceof ViewGroup)) {
      ((ViewGroup)this.jdField_c_of_type_AndroidViewView).removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "removeview error");
      }
    }
  }
  
  public void h()
  {
    f(true);
    g();
    r();
  }
  
  public void m() {}
  
  protected void n() {}
  
  public void o() {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    while (paramAnimation != this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation) {
      return;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    boolean bool2;
    if ((paramView == this.jdField_b_of_type_AndroidViewView) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) {
        d();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.d();
      }
      azqs.b(getActivity().app, "CliOper", "", "", "Setting_tab", "My_settab", c(), 0, "", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) || (!this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b())) {
        break label436;
      }
      bool2 = true;
      bool1 = bool2;
      if (amqe.a(getActivity().app)) {
        azqs.b(getActivity().app, "CliOper", "", "", "0X8004DAF", "0X8004DAF", c(), 0, "", "", amqe.a(), "");
      }
    }
    label436:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramView = getActivity().app;
      int j;
      if (bool1)
      {
        j = 1;
        azqs.b(paramView, "dc00898", "", "", "0X800A980", "0X800A980", j, 0, "0", "0", "", "");
        j = amfs.a(getActivity().app, getActivity().app.c(), bool1);
        azqs.b(getActivity().app, "dc00898", "", "", "0X800ABB0", "0X800ABB0", j, 0, "0", "0", "", "");
        getActivity().getAppInterface().reportClickEvent("CliOper", "0X80072D5");
      }
      do
      {
        do
        {
          return;
          j = 2;
          break;
        } while (paramView.getId() != 2131371378);
        if ((this.jdField_a_of_type_Awcx != null) && (!this.jdField_a_of_type_Awcx.isShowing()))
        {
          this.jdField_a_of_type_Awcx.show();
          o();
          azqs.b(getActivity().app, "dc00898", "", "", "0X800A999", "0X800A999", 2, 0, "", "", "", "");
          azqs.b(getActivity().app, "dc00898", "", "", "0X8009E83", "0X8009E83", 0, 0, "", "", "", "");
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.recent", 2, "click online status icon");
      return;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_Alth != null) {
      this.jdField_a_of_type_Alth.a(paramConfiguration);
    }
    k();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new alte(this));
    this.jdField_c_of_type_Boolean = false;
    c();
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    this.jdField_c_of_type_Boolean = true;
    super.onDestroy();
    if (this.jdField_a_of_type_Alth != null) {
      this.jdField_a_of_type_Alth.c();
    }
    Object localObject = (VasQuickUpdateManager)getActivity().app.getManager(184);
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker != null) {
      ((VasQuickUpdateManager)localObject).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Awcx != null)
    {
      this.jdField_a_of_type_Awcx.a();
      this.jdField_a_of_type_Awcx = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof bdbk))) {
        ((bdbk)localObject).a();
      }
    }
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(null);
    }
    if ((this.h) && (this.jdField_c_of_type_AndroidViewView != null))
    {
      if (Build.VERSION.SDK_INT < 16) {
        this.jdField_c_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
    }
    else {
      return;
    }
    this.jdField_c_of_type_AndroidViewView.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  public void onPause()
  {
    super.onPause();
    if ((SplashActivity.jdField_a_of_type_Int != 1) && (!this.g)) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.c())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.c();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_Alth != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b()))
    {
      this.jdField_a_of_type_Alth.b();
      bicb localbicb = this.jdField_a_of_type_Alth.a(bhsg.a);
      if (localbicb == null) {
        break label169;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "[QQSetting onPause] delay one second  and stop UpSideDown Animation");
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FrameHelperActivity.3(this, localbicb), 1000L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Awcx != null) {
        this.jdField_a_of_type_Awcx.b();
      }
      ((avsm)getActivity().app.getManager(160)).c(1);
      return;
      label169:
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "[QQSetting onPause] dynamicDrawable is null");
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (SplashActivity.jdField_a_of_type_Int != 1) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_Alth != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b()))
    {
      this.jdField_a_of_type_Alth.a();
      q();
      bicb localbicb = this.jdField_a_of_type_Alth.a(bhsg.a);
      if (localbicb == null) {
        break label167;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "[QQSetting onResume] p UpSideDown Animation");
      }
      localbicb.a();
    }
    for (;;)
    {
      ApngImage.pauseAll();
      ApngImage.playByTag(1);
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(17)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(17);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(17, 200L);
      v();
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "[QQSetting onResume] updateOnlineStatus");
      }
      if (this.jdField_a_of_type_Awcx == null) {
        break;
      }
      this.jdField_a_of_type_Awcx.c();
      return;
      label167:
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "[QQSetting onResume] dynamicDrawable is null");
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (SplashActivity.jdField_a_of_type_Int != 1) {}
  }
  
  public void onStop()
  {
    super.onStop();
    if ((SplashActivity.jdField_a_of_type_Int != 1) && (!this.g)) {
      return;
    }
    k();
  }
  
  void p()
  {
    long l = 0L;
    for (;;)
    {
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "frameHelper_inflateUI, " + this.e + "mDrawerBgView=" + this.jdField_a_of_type_AndroidViewViewGroup);
        }
        if (!this.e)
        {
          localObject1 = getActivity();
          if (localObject1 != null) {}
        }
        else
        {
          return;
        }
        Object localObject1 = LayoutInflater.from(getActivity());
        try
        {
          this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((LayoutInflater)localObject1).inflate(2131561287, null));
          this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363187));
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "frameHelper_inflateUI|mDrawerBgView= " + this.jdField_a_of_type_AndroidViewViewGroup);
          }
          this.e = true;
        }
        catch (Exception localException2)
        {
          if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            break label317;
          }
        }
        localObject1 = "in main thread ";
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, (String)localObject1 + localException2.toString());
        }
        try
        {
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("device_mode", bdgk.d());
          ((HashMap)localObject1).put("manufacturer", Build.MANUFACTURER);
          azri localazri = azri.a(BaseApplicationImpl.getContext());
          String str2 = getActivity().app.getCurrentAccountUin();
          if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            break label334;
          }
          localazri.a(str2, "actFrameHelperSubInflate", false, l, 0L, (HashMap)localObject1, "");
        }
        catch (Exception localException1) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.recent", 2, localException1.toString());
        continue;
        String str1 = "not in main thread ";
      }
      finally {}
      label317:
      this.jdField_a_of_type_AndroidViewViewGroup = null;
      this.e = false;
      continue;
      label334:
      l = 1L;
    }
  }
  
  public void q()
  {
    Object localObject1 = getActivity();
    if ((this.jdField_c_of_type_Boolean) || (localObject1 == null) || (((FragmentActivity)localObject1).app == null)) {
      return;
    }
    Object localObject2 = getActivity().app.getCurrentAccountUin();
    Drawable localDrawable = bdbk.a(1, 3);
    localObject1 = bdbk.a(((FragmentActivity)localObject1).app, 1, (String)localObject2, 3, localDrawable, localDrawable, null);
    a(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(12, localObject1));
    localObject2 = new StringBuilder().append("FrameHelperActivity, updateSelfFace:");
    if (localObject1 != null) {}
    for (localObject1 = ((bdbk)localObject1).a();; localObject1 = "")
    {
      QLog.i("Q.qqhead.freq", 1, localObject1);
      return;
    }
  }
  
  void r()
  {
    ThemeBackground.applyThemeBg(super.getActivity().app, this.jdField_c_of_type_AndroidWidgetImageView, 0, 0, "-conversation-");
  }
  
  public void u()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(11);
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      Animation localAnimation = this.jdField_c_of_type_AndroidViewView.getAnimation();
      if (localAnimation != null) {
        localAnimation.setAnimationListener(null);
      }
      this.jdField_c_of_type_AndroidViewView.clearAnimation();
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.invalidate();
    }
  }
  
  public void v()
  {
    Object localObject = getActivity();
    if ((localObject == null) || (((BaseActivity)localObject).app == null)) {
      QLog.d("Q.recent", 1, "updateOnlineStatus, activity or app is null");
    }
    AppRuntime.Status localStatus;
    label224:
    do
    {
      do
      {
        return;
        if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.recent", 2, "mOnlineStatusIcon null");
      return;
      localStatus = ((BaseActivity)localObject).app.getOnlineStatusNonSync();
      long l = aweo.a().a(((BaseActivity)localObject).app);
      a(((BaseActivity)localObject).app, localStatus, l);
      if ((localStatus == AppRuntime.Status.online) && (l == 1000L)) {
        ((BaseActivity)localObject).app.q();
      }
      localObject = aweo.a().a(l, localStatus, 0);
      if (localObject == null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      for (;;)
      {
        localObject = (altd)this.jdField_b_of_type_AndroidWidgetImageView.getTag();
        if ((localObject == null) || (altd.a((altd)localObject) != localStatus) || (altd.a((altd)localObject) != l)) {
          break label224;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.recent", 2, "updateOnlineStatus, but is same status: " + localStatus);
        return;
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setTag(new altd(localStatus, l, null));
      localObject = alud.a(2131705254) + aweo.a().a(l, localStatus);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject);
    } while (!QLog.isColorLevel());
    QLog.d("Q.recent", 2, "user head updateOnlineStatus: " + localStatus);
  }
  
  public void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "unRegisterBatteryBroadcastReceiver start");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver != null)
      {
        BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver);
        this.jdField_a_of_type_ComTencentMobileqqAppBatteryBroadcastReceiver = null;
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "unRegisterBatteryBroadcastReceiver success");
        }
      }
      FragmentActivity localFragmentActivity = getActivity();
      if ((localFragmentActivity != null) && (localFragmentActivity.app != null)) {
        localFragmentActivity.app.L();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("Q.recent", 1, localThrowable, new Object[] { "unRegisterBatteryBroadcastReceiver fail" });
    }
  }
  
  public void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onAfterAddObservers");
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(18);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity
 * JD-Core Version:    0.7.0.1
 */