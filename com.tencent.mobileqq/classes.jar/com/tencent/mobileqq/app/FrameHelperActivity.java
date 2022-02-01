package com.tencent.mobileqq.app;

import alfq;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
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
import anun;
import anuq;
import anur;
import anus;
import anut;
import anuu;
import anuv;
import anuw;
import anux;
import anuy;
import anuz;
import anva;
import anvb;
import anvc;
import anvd;
import anve;
import anvf;
import anvg;
import anvh;
import aoay;
import aoba;
import aogw;
import aoyj;
import auly;
import aymd;
import ayzg;
import azab;
import azbd;
import azbj;
import azbm;
import bbbq;
import bdla;
import bdxj;
import bgvx;
import bgyd;
import bhai;
import bhdj;
import bkxw;
import blgc;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import tem;

public class FrameHelperActivity
  extends FrameFragment
  implements View.OnClickListener, Animation.AnimationListener
{
  public static WeakReference<DrawerFrame> a;
  public static boolean i;
  private int jdField_a_of_type_Int = 3;
  alfq jdField_a_of_type_Alfq = new anuq(this);
  private Dialog jdField_a_of_type_AndroidAppDialog;
  public Handler a;
  public ViewGroup a;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  public ImageView a;
  public RelativeLayout a;
  private anvd jdField_a_of_type_Anvd;
  public anvf a;
  private anvh jdField_a_of_type_Anvh;
  public aoba a;
  public auly a;
  public ayzg a;
  private azab jdField_a_of_type_Azab = new anux(this);
  public azbd a;
  private azbm jdField_a_of_type_Azbm;
  public DrawerFrame a;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  public RedTouch a;
  private VasQuickUpdateManager.CallBacker jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker;
  private boolean jdField_a_of_type_Boolean;
  public alfq[] a;
  public View b;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  public ImageView b;
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
    this.jdField_a_of_type_ArrayOfAlfq = new alfq[] { null, null, null, null };
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new anvb(this);
    this.jdField_a_of_type_Aoba = new anuu(this);
    this.jdField_a_of_type_Auly = new anuv(this);
    this.jdField_a_of_type_Azbd = new anuw(this);
  }
  
  private void A()
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
    localAnimationSet.setAnimationListener(new anut(this, (View)localObject));
    ((View)localObject).startAnimation(localAnimationSet);
  }
  
  private void B()
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
  
  private void C()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.app == null)) {
      QLog.d("Q.recent", 1, "checkLocationPermission, activity or app is null");
    }
    int m;
    label128:
    label134:
    do
    {
      AppRuntime.Status localStatus;
      long l;
      do
      {
        return;
        localStatus = localFragmentActivity.app.getOnlineStatusNonSync();
        l = azbj.a().a(localFragmentActivity.app);
      } while ((localStatus != AppRuntime.Status.online) || ((l != 1030L) && (l <= 40000L)));
      int j;
      if (l == 1030L)
      {
        j = 2131698141;
        if (l != 1030L) {
          break label128;
        }
      }
      for (int k = 2131698139;; k = 2131698142)
      {
        m = localFragmentActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION");
        if (m == 0) {
          break label134;
        }
        bhdj.a(localFragmentActivity, k, j);
        return;
        j = 2131698144;
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OnlineStatus", 2, new Object[] { "granted:", Integer.valueOf(m) });
  }
  
  private void D()
  {
    if ((this.jdField_a_of_type_Ayzg != null) && (this.jdField_a_of_type_Ayzg.isShowing())) {
      this.jdField_a_of_type_Ayzg.b(false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "closeAccountPanel");
    }
  }
  
  public static FrameHelperActivity a(BaseActivity paramBaseActivity)
  {
    paramBaseActivity = ((FragmentActivity)paramBaseActivity).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (paramBaseActivity != null) {
      return (FrameHelperActivity)paramBaseActivity;
    }
    return null;
  }
  
  private void a()
  {
    ThreadManager.post(new FrameHelperActivity.3(this), 5, null, true);
  }
  
  private void a(Message paramMessage)
  {
    if (!this.d) {
      w();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "FrameHelperActivity, updateSelfFace now");
    }
    Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    if ((localDrawable != null) && ((localDrawable instanceof FaceDrawable))) {
      ((FaceDrawable)localDrawable).cancel();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)paramMessage.obj);
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (!ThemeUtil.isNowThemeIsDefault(getActivity().getAppInterface(), true, null)) {
      return;
    }
    paramQQAppInterface.execute(new FrameHelperActivity.7(this, paramQQAppInterface));
  }
  
  private void a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.lQQMasterLogindays > 0L)
      {
        FriendProfileCardActivity.a = this.jdField_a_of_type_ComTencentMobileqqDataCard.lQQMasterLogindays;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays != 1L) && ((this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays <= 1L) || (this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays >= FriendProfileCardActivity.a))) {
          break label157;
        }
        localObject = String.format(getString(2131693738), new Object[] { Integer.valueOf((int)(FriendProfileCardActivity.a - this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays)) });
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null) {
        break label225;
      }
      paramQQAppInterface = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365644);
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
      label157:
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays >= FriendProfileCardActivity.a)
      {
        localObject = String.format(getString(2131693739), new Object[] { Integer.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays) });
      }
      else
      {
        localObject = getString(2131693740);
        continue;
        localObject = getString(2131693740);
      }
    }
    label225:
    this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(paramFragmentActivity, 2131755829);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559019);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365648);
    if (localTextView != null) {
      localTextView.setText(getString(2131693736));
    }
    localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365644);
    if (localTextView != null)
    {
      localTextView.requestFocus();
      localTextView.setText((CharSequence)localObject);
      localTextView.setContentDescription((CharSequence)localObject);
    }
    Object localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365633);
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131690697);
      ((TextView)localObject).setOnClickListener(new anuy(this, paramQQAppInterface));
    }
    localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365639);
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131693737);
      ((TextView)localObject).setOnClickListener(new anuz(this, paramQQAppInterface, paramFragmentActivity));
    }
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new anva(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private int b()
  {
    anun localanun = b();
    if ((localanun instanceof Conversation)) {}
    do
    {
      return 1;
      if ((localanun instanceof Contacts)) {
        return 3;
      }
    } while (!(localanun instanceof Leba));
    return 4;
  }
  
  private void b(Message paramMessage)
  {
    if (paramMessage.arg1 == 0)
    {
      ThreadManager.getSubThreadHandler().post(new FrameHelperActivity.8(this));
      paramMessage = Message.obtain();
      paramMessage.what = 2;
      paramMessage.arg1 = 1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 20000L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "frameHelper_infalter time out, need do in UI thread ");
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
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
      if (this.jdField_a_of_type_Anvd != null) {
        this.jdField_a_of_type_Anvd.g(true);
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Anvh == null)
      {
        localObject = (Conversation)a(Conversation.class);
        if (localObject != null) {
          ((Conversation)localObject).r();
        }
      }
      if (!this.e) {
        q();
      }
      Object localObject = (ViewGroup)getActivity().findViewById(2131365160);
      try
      {
        if (this.jdField_a_of_type_Anvh != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame = new DrawerFrame(getActivity(), (ViewGroup)localObject, this.jdField_a_of_type_Anvh.a(), null, this.jdField_a_of_type_AndroidViewViewGroup, this);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) {
          continue;
        }
        if (this.jdField_a_of_type_Anvd != null) {
          this.jdField_a_of_type_Anvd.g(true);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.setDrawerCallbacks(this.jdField_a_of_type_Alfq);
        s();
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
    if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
    {
      localaoay = (aoay)getActivity().app.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER);
      localArrayList = localaoay.b();
      if ((localArrayList.size() > 0) && (aoyj.a(getActivity(), localArrayList))) {
        localaoay.a(localArrayList);
      }
    }
    while (!QLog.isColorLevel())
    {
      aoay localaoay;
      ArrayList localArrayList;
      return;
    }
    QLog.e("QIMNewFriend", 2, "showDialog|mIsForeground = " + this.jdField_b_of_type_Boolean + ",isDrawerOpen = " + this.jdField_a_of_type_Boolean);
  }
  
  private void f()
  {
    if (!this.d) {
      w();
    }
    if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -getResources().getDimension(2131299081), 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(150L);
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
    this.jdField_c_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
  }
  
  private void f(boolean paramBoolean)
  {
    RandomCoverView localRandomCoverView;
    ImageView localImageView1;
    ImageView localImageView2;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localRandomCoverView = (RandomCoverView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379220);
      localImageView1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363696);
      localImageView2 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380504);
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
    localImageView2.setImageResource(2130844918);
    localImageView2.setVisibility(0);
  }
  
  private void g()
  {
    if (!this.d) {
      w();
    }
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -getResources().getDimension(2131299081));
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(150L);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
    this.jdField_c_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    d();
    y();
  }
  
  private void j()
  {
    s();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "[setDrawerBg(app)]from MSG_SET_DIYBG, drawerOpened?" + this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b());
      }
      bkxw.b();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(14);
    }
  }
  
  private void k()
  {
    if (!this.d) {
      w();
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_Anvh != null) {
      this.jdField_a_of_type_Anvh.a(getActivity().app);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "start updateOnlineStatus");
    }
    b("AccountChange");
    bdxj.c(getActivity().app, true);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) {
      d();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.e();
    }
  }
  
  public static void t()
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
  
  public static void u()
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
  
  private void w()
  {
    this.d = true;
    this.jdField_c_of_type_AndroidViewView = getActivity().findViewById(2131369858);
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)getActivity().findViewById(2131365225));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)getActivity().findViewById(2131372218));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = getActivity().findViewById(2131365227);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    x();
    r();
    b("initNecessaryUI");
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_Azbm == null)
    {
      anvc localanvc = new anvc(this);
      this.jdField_a_of_type_Azbm = new azbm(getActivity(), localanvc);
    }
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_Ayzg != null) {
      return;
    }
    bdxj.c(getActivity().app, true);
    this.jdField_a_of_type_Ayzg = new ayzg(getActivity());
    this.jdField_a_of_type_Ayzg.a(this.jdField_a_of_type_Azab);
    this.jdField_a_of_type_Ayzg.a(new anvg(this));
    this.jdField_b_of_type_AndroidViewView.setHapticFeedbackEnabled(false);
    this.jdField_b_of_type_AndroidViewView.setOnLongClickListener(new anur(this));
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new anus(this));
    bgyd.b(this.jdField_b_of_type_AndroidViewView, Button.class.getName());
  }
  
  private void z()
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
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Ayzg != null) {
      this.jdField_a_of_type_Ayzg.a(paramInt1, paramInt2, paramIntent);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_Anvh != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b()))
    {
      this.jdField_a_of_type_Anvh.a(paramInt1, paramInt2, paramIntent);
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
          break label78;
        }
      }
      label78:
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
        bdla.b(getActivity().app, "CliOper", "", "", (String)localObject1, (String)localObject1, paramInt2, 0, "", "", "", "");
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("Q.recent", 4, "doDrawerActionReport, actionFlag: " + paramInt1 + ", tag = " + (String)localObject1);
      return;
      if (paramBoolean)
      {
        localObject1 = getActivity().app;
        localObject2 = getActivity().app.getCurrentUin();
        if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) && (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.c())) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          int j = aogw.a((QQAppInterface)localObject1, (String)localObject2, paramBoolean);
          bdla.b(getActivity().app, "dc00898", "", "", "0X800ABB1", "0X800ABB1", j, 0, "0", "0", "", "");
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
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    localIntent.putExtra("tab_index", MainFragment.b);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.b();
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("unreadcount", 4).edit();
    localEditor.putInt("unread", 0);
    localEditor.apply();
    paramQQAppInterface.logout(true);
    if (BaseApplicationImpl.sImageCache != null) {
      BaseApplicationImpl.sImageCache.evictAll();
    }
    int j = bhai.a(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    bhai.a(paramActivity, paramQQAppInterface.getCurrentAccountUin(), j + 1);
    paramActivity.startActivity(localIntent);
    if (QQPlayerService.a())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast(paramQQAppInterface);
    }
    paramActivity.finish();
  }
  
  public void a(anvd paramanvd)
  {
    this.jdField_a_of_type_Anvd = paramanvd;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (paramanvd != null)) {
      paramanvd.g(true);
    }
  }
  
  public void a(anvh paramanvh)
  {
    this.jdField_a_of_type_Anvh = paramanvh;
  }
  
  public void a(Card paramCard)
  {
    Object localObject = getActivity();
    if ((localObject == null) || (((FragmentActivity)localObject).getAppInterface() == null) || (!ThemeUtil.isNowThemeIsDefault(getActivity().getAppInterface(), true, null)) || (paramCard == null) || (this.jdField_a_of_type_Anvh == null)) {
      return;
    }
    localObject = ((FragmentActivity)localObject).app;
    RandomCoverView localRandomCoverView = (RandomCoverView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379220);
    String str = (String)paramCard.getCoverData(0)[0];
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "[getCoverData] getCovertUrl from net,url:" + str);
    }
    if ((!TextUtils.isEmpty(str)) && (!bkxw.b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "card.isNoCover()=" + paramCard.isNoCover());
      }
      if ((!bkxw.a((QQAppInterface)localObject, paramCard)) && (paramCard.isNoCover()))
      {
        this.jdField_a_of_type_Anvh.a(false);
        ThreadManager.getUIHandler().post(new FrameHelperActivity.5(this, localRandomCoverView));
        return;
      }
      this.jdField_a_of_type_Anvh.a(true);
      ThreadManager.getUIHandler().post(new FrameHelperActivity.6(this, localRandomCoverView));
      this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = bkxw.a(getActivity(), (QQAppInterface)localObject, paramCard, localRandomCoverView, str, this.jdField_a_of_type_Anvh, this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a());
      return;
    }
    if (bkxw.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "account has logouted,restart to fetch coverUrl");
      }
      bkxw.c();
      this.jdField_a_of_type_Int = 3;
    }
    a((QQAppInterface)localObject);
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if (this.jdField_a_of_type_Azbm != null) {
      this.jdField_a_of_type_Azbm.a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a(paramBoolean);
    }
  }
  
  public boolean a(Message paramMessage)
  {
    if ((this.jdField_c_of_type_Boolean) || (getActivity() == null)) {
      return false;
    }
    switch (paramMessage.what)
    {
    case 7: 
    case 8: 
    case 15: 
    case 16: 
    default: 
      return false;
    case 1: 
      k();
      return false;
    case 6: 
      m();
      return false;
    case 4: 
      l();
      return false;
    case 2: 
      b(paramMessage);
      return false;
    case 3: 
      r();
      return false;
    case 5: 
      j();
      return false;
    case 9: 
      h();
      return false;
    case 10: 
      g();
      return false;
    case 11: 
      f();
      return false;
    case 12: 
      a(paramMessage);
      return false;
    case 13: 
      A();
      return false;
    case 14: 
      a(getActivity().app);
      return false;
    case 17: 
      e();
      return false;
    }
    C();
    return false;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(paramInt);
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Azbm != null) {
      this.jdField_a_of_type_Azbm.a(paramString);
    }
  }
  
  public anun c()
  {
    return b();
  }
  
  public void d(boolean paramBoolean)
  {
    i = paramBoolean;
    if (i) {
      tem.a().a(false);
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
        int j = AIOUtils.dp2px(37.0F, getResources());
        int k = AIOUtils.dp2px(60.0F, getResources());
        int m = AIOUtils.dp2px(12.0F, getResources());
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
        ((RelativeLayout)localObject).setBackgroundDrawable(this.jdField_c_of_type_AndroidViewView.getResources().getDrawable(2130840544));
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
  
  public void i()
  {
    f(true);
    z();
    s();
    if (this.jdField_a_of_type_Ayzg != null) {
      this.jdField_a_of_type_Ayzg.a();
    }
  }
  
  public void n() {}
  
  protected void o() {}
  
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
      bdla.b(getActivity().app, "CliOper", "", "", "Setting_tab", "My_settab", b(), 0, "", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) || (!this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.c())) {
        break label559;
      }
      bool2 = true;
      bool1 = bool2;
      if (bgvx.a(getActivity().app)) {
        bdla.b(getActivity().app, "CliOper", "", "", "0X8004DAF", "0X8004DAF", b(), 0, "", "", bgvx.a(), "");
      }
    }
    label559:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Object localObject = getActivity().app;
      int j;
      if (bool1)
      {
        j = 1;
        bdla.b((QQAppInterface)localObject, "dc00898", "", "", "0X800A980", "0X800A980", j, 0, "0", "0", "", "");
        j = aogw.a(getActivity().app, getActivity().app.getCurrentUin(), bool1);
        bdla.b(getActivity().app, "dc00898", "", "", "0X800ABB0", "0X800ABB0", j, 0, "0", "0", "", "");
        getActivity().getAppInterface().reportClickEvent("CliOper", "0X80072D5");
        if (bool1)
        {
          localObject = (bbbq)getActivity().app.getManager(QQManagerFactory.MGR_RED_TOUCH);
          if (localObject != null) {
            ((bbbq)localObject).b(1, 31);
          }
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        j = 2;
        break;
        if (paramView.getId() == 2131372218)
        {
          if ((this.jdField_a_of_type_Ayzg != null) && (!this.jdField_a_of_type_Ayzg.isShowing()))
          {
            if ((getActivity().app != null) && (getActivity().app.getApp() != null))
            {
              localObject = (Vibrator)getActivity().app.getApp().getSystemService("vibrator");
              if (localObject != null) {
                ((Vibrator)localObject).vibrate(new long[] { 0L, 1L, 20L, 21L }, -1);
              }
            }
            this.jdField_a_of_type_Ayzg.show();
            p();
            bdla.b(getActivity().app, "dc00898", "", "", "0X800A999", "0X800A999", 2, 0, "", "", "", "");
            bdla.b(getActivity().app, "dc00898", "", "", "0X8009E83", "0X8009E83", 0, 0, "", "", "", "");
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "click online status icon");
          }
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_Anvh != null) {
      this.jdField_a_of_type_Anvh.a(paramConfiguration);
    }
    D();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new anve(this));
    this.jdField_c_of_type_Boolean = false;
    a();
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    this.jdField_c_of_type_Boolean = true;
    super.onDestroy();
    if (this.jdField_a_of_type_Anvh != null) {
      this.jdField_a_of_type_Anvh.c();
    }
    Object localObject = (VasQuickUpdateManager)getActivity().app.getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER);
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker != null) {
      ((VasQuickUpdateManager)localObject).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Ayzg != null)
    {
      this.jdField_a_of_type_Ayzg.f();
      this.jdField_a_of_type_Ayzg = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof FaceDrawable))) {
        ((FaceDrawable)localObject).cancel();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_Anvh != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b()))
    {
      this.jdField_a_of_type_Anvh.b();
      blgc localblgc = this.jdField_a_of_type_Anvh.a(bkxw.a);
      if (localblgc == null) {
        break label169;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "[QQSetting onPause] delay one second  and stop UpSideDown Animation");
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FrameHelperActivity.4(this, localblgc), 1000L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ayzg != null) {
        this.jdField_a_of_type_Ayzg.g();
      }
      ((aymd)getActivity().app.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).c(1);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_Anvh != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b()))
    {
      this.jdField_a_of_type_Anvh.a();
      r();
      blgc localblgc = this.jdField_a_of_type_Anvh.a(bkxw.a);
      if (localblgc == null) {
        break label170;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "[QQSetting onResume] p UpSideDown Animation");
      }
      localblgc.a();
    }
    for (;;)
    {
      ApngImage.pauseAll();
      ApngImage.playByTag(1);
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(17)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(17);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(17, 200L);
      b("onResume");
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "[QQSetting onResume] updateOnlineStatus");
      }
      if (this.jdField_a_of_type_Ayzg == null) {
        break;
      }
      this.jdField_a_of_type_Ayzg.h();
      return;
      label170:
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
    if ((SplashActivity.jdField_a_of_type_Int != 1) && (!this.g)) {}
  }
  
  public void onTabChanged(String paramString)
  {
    super.onTabChanged(paramString);
    if (paramString.equals(Conversation.class.getName()))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void p() {}
  
  void q()
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
          this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((LayoutInflater)localObject1).inflate(2131561499, null));
          this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363495));
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "frameHelper_inflateUI|mDrawerBgView= " + this.jdField_a_of_type_AndroidViewViewGroup);
          }
          this.e = true;
        }
        catch (Exception localException2)
        {
          if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            break label313;
          }
        }
        localObject1 = "in main thread ";
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, (String)localObject1 + localException2.toString());
        }
        try
        {
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("device_mode", DeviceInfoUtil.getDeviceModel());
          ((HashMap)localObject1).put("manufacturer", Build.MANUFACTURER);
          StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplicationImpl.getContext());
          String str2 = getActivity().app.getCurrentAccountUin();
          if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            break label330;
          }
          localStatisticCollector.collectPerformance(str2, "actFrameHelperSubInflate", false, l, 0L, (HashMap)localObject1, "");
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
      label313:
      this.jdField_a_of_type_AndroidViewViewGroup = null;
      this.e = false;
      continue;
      label330:
      l = 1L;
    }
  }
  
  public void r()
  {
    Object localObject1 = getActivity();
    if ((this.jdField_c_of_type_Boolean) || (localObject1 == null) || (((FragmentActivity)localObject1).app == null)) {
      return;
    }
    Object localObject2 = getActivity().app.getCurrentAccountUin();
    Drawable localDrawable = FaceDrawable.getDefaultDrawable(1, 3);
    localObject1 = FaceDrawable.getFaceDrawable(((FragmentActivity)localObject1).app, 1, (String)localObject2, 3, localDrawable, localDrawable, null);
    a(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(12, localObject1));
    localObject2 = new StringBuilder().append("FrameHelperActivity, updateSelfFace:");
    if (localObject1 != null) {}
    for (localObject1 = ((FaceDrawable)localObject1).getLoadedBitmap();; localObject1 = "")
    {
      QLog.i("Q.qqhead.freq", 1, localObject1);
      return;
    }
  }
  
  void s()
  {
    ThemeBackground.applyThemeBg(super.getActivity().app, this.jdField_c_of_type_AndroidWidgetImageView, 0, 0, "-conversation-");
  }
  
  public void v()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity
 * JD-Core Version:    0.7.0.1
 */