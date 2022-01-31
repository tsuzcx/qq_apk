package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.KandianAppInPush;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.DrawerFrame.IDrawerCallbacks;
import com.tencent.mobileqq.app.qim.QIMNewFriend;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.flashchat.FlashChatObserver;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.AssociatedAccountOptPopBar;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.DrawerCoverUtil;
import com.tencent.widget.UpSideDownDrawable;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;
import zdg;
import zdh;
import zdi;
import zdj;
import zdk;
import zdm;
import zdo;
import zdp;
import zdq;
import zdr;
import zds;
import zdt;

public class FrameHelperActivity
  extends FrameFragment
  implements Handler.Callback, View.OnClickListener, Animation.AnimationListener
{
  public static WeakReference a;
  public static boolean f;
  private int jdField_a_of_type_Int = 3;
  public Handler a;
  public ViewGroup a;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  public ImageView a;
  public DrawerFrame a;
  private FrameHelperActivity.DrawerListener jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$DrawerListener;
  public FrameHelperActivity.HeadViewLongClick a;
  private FrameHelperActivity.QQSettingMeListener jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener;
  public QIMNewFriendManager.IQIMNotifyNewFriendListener a;
  public FlashChatObserver a;
  public RedTouch a;
  public AssociatedAccountOptPopBar a;
  private boolean jdField_a_of_type_Boolean;
  public DrawerFrame.IDrawerCallbacks[] a;
  public View b;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean = true;
  public View c;
  private boolean c;
  private boolean d;
  private boolean g;
  
  public FrameHelperActivity()
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks = new DrawerFrame.IDrawerCallbacks[] { null, null, null, null };
    this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager$IQIMNotifyNewFriendListener = new zdi(this);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver = new zdj(this);
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
    paramQQAppInterface.a(new zdk(this, paramQQAppInterface));
  }
  
  public static void a(boolean paramBoolean)
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
  
  public static boolean a()
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
  
  private int b()
  {
    Frame localFrame = b();
    if ((localFrame instanceof Conversation)) {}
    do
    {
      return 1;
      if ((localFrame instanceof Contacts)) {
        return 3;
      }
    } while (!(localFrame instanceof Leba));
    return 4;
  }
  
  public static void b(boolean paramBoolean)
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
  
  private void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "frameHelper_initDrawerFrame: mDrawerFrame=  " + this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame + "mDrawerBg= " + this.jdField_a_of_type_AndroidViewViewGroup + "mIsInflated = " + this.g);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener == null)
      {
        localObject = (Conversation)a(Conversation.class);
        if (localObject != null) {
          ((Conversation)localObject).n();
        }
      }
      if (!this.g) {
        l();
      }
      Object localObject = (ViewGroup)getActivity().findViewById(2131364934);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame = new DrawerFrame(getActivity(), (ViewGroup)localObject, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(), null, this.jdField_a_of_type_AndroidViewViewGroup, this);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.setDrawerCallbacks(new zdm(this));
        n();
        jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
        if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$DrawerListener == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$DrawerListener.e(true);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "frameHelper_initDrawerFrame exception, " + localException.toString());
          }
        }
      }
    }
  }
  
  private void d()
  {
    this.d = true;
    this.jdField_c_of_type_AndroidViewView = getActivity().findViewById(2131364935);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && ((this.jdField_c_of_type_AndroidViewView.getLayoutParams() instanceof FrameLayout.LayoutParams)))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.setMargins(0, ImmersiveUtils.a(getActivity()), 0, 0);
      this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)getActivity().findViewById(2131369996));
    this.jdField_b_of_type_AndroidViewView = getActivity().findViewById(2131369997);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    SubAccountControll.c(getActivity().app, true);
    this.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar = new AssociatedAccountOptPopBar(getActivity());
    this.jdField_b_of_type_AndroidViewView.setHapticFeedbackEnabled(false);
    this.jdField_b_of_type_AndroidViewView.setOnLongClickListener(new zdq(this));
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new zdr(this));
    AccessibilityUtil.b(this.jdField_b_of_type_AndroidViewView, Button.class.getName());
    m();
  }
  
  private void d(boolean paramBoolean)
  {
    RandomCoverView localRandomCoverView;
    ImageView localImageView1;
    ImageView localImageView2;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localRandomCoverView = (RandomCoverView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371362);
      localImageView1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367094);
      localImageView2 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369232);
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
    localRandomCoverView.setVisibility(8);
    localImageView2.setImageResource(2130842369);
    localImageView2.setVisibility(0);
  }
  
  private void e()
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
  
  private void f()
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
    localAnimationSet.setAnimationListener(new zdh(this, (View)localObject));
    ((View)localObject).startAnimation(localAnimationSet);
  }
  
  private void g()
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
  
  public static void o()
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
  
  public static void p()
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
  
  public TranslateAnimation a()
  {
    if (!this.d) {
      d();
    }
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -getResources().getDimension(2131558451));
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(150L);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
    this.jdField_c_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    return this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(paramInt1, paramInt2, paramIntent);
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
    Object localObject = null;
    if ((getActivity() == null) || (getActivity().app == null))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("doDrawerActionReport, getActivity =  ").append(getActivity()).append(" app = ");
        if (getActivity() != null) {
          break label78;
        }
      }
      for (;;)
      {
        QLog.i("Q.recent", 2, localObject);
        return;
        label78:
        localObject = getActivity().app;
      }
    }
    switch (paramInt1)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        ReportController.b(getActivity().app, "CliOper", "", "", (String)localObject, (String)localObject, paramInt2, 0, "", "", "", "");
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("Q.recent", 4, "doDrawerActionReport, actionFlag: " + paramInt1 + ", tag = " + (String)localObject);
      return;
      if (paramBoolean)
      {
        localObject = "0X800402E";
      }
      else
      {
        localObject = "0X800402F";
        continue;
        localObject = "0X8004032";
        continue;
        localObject = "0X8004030";
        continue;
        localObject = "0X8004031";
      }
    }
  }
  
  public void a(FrameHelperActivity.DrawerListener paramDrawerListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$DrawerListener = paramDrawerListener;
  }
  
  public void a(FrameHelperActivity.QQSettingMeListener paramQQSettingMeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener = paramQQSettingMeListener;
  }
  
  public void a(Card paramCard)
  {
    Object localObject = getActivity();
    if ((localObject == null) || (((FragmentActivity)localObject).getAppInterface() == null) || (!ThemeUtil.isNowThemeIsDefault(getActivity().getAppInterface(), true, null)) || (paramCard == null)) {
      return;
    }
    localObject = ((FragmentActivity)localObject).app;
    RandomCoverView localRandomCoverView = (RandomCoverView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371362);
    String str = (String)paramCard.getCoverData(0)[0];
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "[getCoverData] getCovertUrl from net,url:" + str);
    }
    if ((!TextUtils.isEmpty(str)) && (!DrawerCoverUtil.b()))
    {
      DrawerCoverUtil.a(getActivity(), (QQAppInterface)localObject, paramCard, localRandomCoverView, str, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener, this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a());
      return;
    }
    if (DrawerCoverUtil.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "account has logouted,restart to fetch coverUrl");
      }
      DrawerCoverUtil.c();
      this.jdField_a_of_type_Int = 3;
    }
    a((QQAppInterface)localObject);
  }
  
  public TranslateAnimation b()
  {
    if (!this.d) {
      d();
    }
    if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -getResources().getDimension(2131558451), 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(150L);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
    this.jdField_c_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    return this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(paramInt);
    }
  }
  
  public Frame c()
  {
    return b();
  }
  
  public void c(boolean paramBoolean)
  {
    f = paramBoolean;
    if (f) {
      KandianAppInPush.a().a(false);
    }
  }
  
  public void h()
  {
    d(true);
    e();
    n();
  }
  
  public boolean handleMessage(Message paramMessage)
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
                      default: 
                        return false;
                      }
                    } while (this.d);
                    d();
                    return false;
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) {
                      c();
                    }
                  } while ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a()));
                  this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.e();
                  return false;
                  if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener != null) {
                    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(getActivity().app);
                  }
                  this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
                  SubAccountControll.c(getActivity().app, true);
                  return false;
                  if (paramMessage.arg1 == 0)
                  {
                    ThreadManager.getSubThreadHandler().post(new zdo(this));
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
                  m();
                  return false;
                  n();
                } while ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b()));
                if (QLog.isColorLevel()) {
                  QLog.d("Q.profilecard.", 2, "[setDrawerBg(app)]from MSG_SET_DIYBG, drawerOpened?" + this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b());
                }
                DrawerCoverUtil.b();
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(14);
                return false;
              } while ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (!(paramMessage.obj instanceof ThemeBackground)));
              paramMessage = (ThemeBackground)paramMessage.obj;
              if ((!TextUtils.isEmpty(paramMessage.path)) && (!"null".equals(paramMessage.path)) && (paramMessage.img != null)) {
                break;
              }
            } while (this.jdField_b_of_type_AndroidWidgetImageView == null);
            this.jdField_b_of_type_AndroidWidgetImageView.setTag(null);
            this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_b_of_type_AndroidWidgetImageView);
            return false;
            if (this.jdField_b_of_type_AndroidWidgetImageView == null)
            {
              this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
              this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            if (this.jdField_b_of_type_AndroidWidgetImageView.getParent() == null)
            {
              localObject = new RelativeLayout.LayoutParams(-1, -1);
              this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
            }
            if (paramMessage.isAnimateBg) {
              this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
            }
            for (;;)
            {
              this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramMessage.img);
              this.jdField_b_of_type_AndroidWidgetImageView.setTag(paramMessage);
              return false;
              this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844231);
            }
          } while (!(paramMessage.obj instanceof Boolean));
          boolean bool = ((Boolean)paramMessage.obj).booleanValue();
          if (QLog.isColorLevel()) {
            QLog.i("Q.recent", 2, "MSG_TO_AFTER_JUDGE_IS_ANIMATE_THEME isAllowed = " + bool);
          }
          if (!bool) {
            break;
          }
        } while (this.jdField_b_of_type_AndroidWidgetImageView == null);
        this.jdField_b_of_type_AndroidWidgetImageView.setTag(null);
        this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_b_of_type_AndroidWidgetImageView);
        return false;
        ThreadManager.post(new zdp(this, super.getActivity().app), 8, null, true);
        return false;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        c();
        return false;
        if (!this.d) {
          d();
        }
        if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null)
        {
          this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -getResources().getDimension(2131558451));
          this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(150L);
          this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
        }
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
        this.jdField_c_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
        return false;
        if (!this.d) {
          d();
        }
        if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == null)
        {
          this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -getResources().getDimension(2131558451), 0.0F);
          this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(150L);
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
        this.jdField_c_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
        return false;
        if (!this.d) {
          d();
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, "FrameHelperActivity, updateSelfFace now");
        }
        localObject = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
        if ((localObject != null) && ((localObject instanceof FaceDrawable))) {
          ((FaceDrawable)localObject).a();
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)paramMessage.obj);
        return false;
        f();
        return false;
        a(getActivity().app);
        return false;
        if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
          break;
        }
        paramMessage = (QIMNewFriendManager)getActivity().app.getManager(256);
        localObject = paramMessage.b();
      } while ((((ArrayList)localObject).size() <= 0) || (!QIMNewFriend.a(getActivity(), (ArrayList)localObject)));
      paramMessage.a((ArrayList)localObject);
      return false;
    } while (!QLog.isColorLevel());
    QLog.e("QIMNewFriend", 2, "showDialog|mIsForeground = " + this.jdField_b_of_type_Boolean + ",isDrawerOpen = " + this.jdField_a_of_type_Boolean);
    return false;
  }
  
  public void l()
  {
    long l = 0L;
    for (;;)
    {
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "frameHelper_inflateUI, " + this.g + "mDrawerBgView=" + this.jdField_a_of_type_AndroidViewViewGroup);
        }
        if (!this.g)
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
          this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((LayoutInflater)localObject1).inflate(2130970609, null));
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "frameHelper_inflateUI|mDrawerBgView= " + this.jdField_a_of_type_AndroidViewViewGroup);
          }
          this.g = true;
        }
        catch (Exception localException2)
        {
          if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            break label296;
          }
        }
        localObject1 = "in main thread ";
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, (String)localObject1 + localException2.toString());
        }
        try
        {
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("device_mode", DeviceInfoUtil.e());
          ((HashMap)localObject1).put("manufacturer", Build.MANUFACTURER);
          StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplicationImpl.getContext());
          String str2 = getActivity().app.getCurrentAccountUin();
          if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            break label313;
          }
          localStatisticCollector.a(str2, "actFrameHelperSubInflate", false, l, 0L, (HashMap)localObject1, "");
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
      label296:
      this.jdField_a_of_type_AndroidViewViewGroup = null;
      this.g = false;
      continue;
      label313:
      l = 1L;
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "updateSelfFace");
    }
    ThreadManager.getSubThreadHandler().postAtFrontOfQueue(new zds(this));
  }
  
  void n()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "setThemeDiyBgSetting");
    }
    if ((!this.g) || (this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_AndroidOsHandler == null))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("FrameHelperActivity.setThemeDiyBgSetting,mIsInflated=").append(this.g).append("mDrawerBgView=");
        if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
          break label93;
        }
      }
      for (;;)
      {
        QLog.i("Q.recent", 2, bool);
        return;
        label93:
        bool = false;
      }
    }
    ThreadManager.post(new zdt(this), 8, null, true);
  }
  
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
    if ((paramView == this.jdField_b_of_type_AndroidViewView) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) {
        c();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.d();
      }
      ReportController.b(getActivity().app, "CliOper", "", "", "Setting_tab", "My_settab", b(), 0, "", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) && (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a()) && (UpgradeController.a(getActivity().app))) {
        ReportController.b(getActivity().app, "CliOper", "", "", "0X8004DAF", "0X8004DAF", b(), 0, "", "", UpgradeController.a(), "");
      }
      getActivity().getAppInterface().reportClickEvent("CliOper", "0X80072D5");
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(paramConfiguration);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar != null) && (this.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar.a())) {
      this.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar.a(false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_c_of_type_Boolean = false;
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    this.jdField_c_of_type_Boolean = true;
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.c();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar.c();
      this.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
      if ((localDrawable != null) && ((localDrawable instanceof FaceDrawable))) {
        ((FaceDrawable)localDrawable).a();
      }
    }
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(null);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((SplashActivity.jdField_a_of_type_Int != 1) && (!this.e)) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.c())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.c();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.b();
      UpSideDownDrawable localUpSideDownDrawable = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(DrawerCoverUtil.a);
      if (localUpSideDownDrawable == null) {
        break label169;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "[QQSetting onPause] delay one second  and stop UpSideDown Animation");
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new zdg(this, localUpSideDownDrawable), 1000L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar != null) {
        this.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar.b();
      }
      ((LocalRedTouchManager)getActivity().app.getManager(159)).c(1);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a();
      m();
      UpSideDownDrawable localUpSideDownDrawable = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(DrawerCoverUtil.a);
      if (localUpSideDownDrawable == null) {
        break label133;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "[QQSetting onResume] p UpSideDown Animation");
      }
      localUpSideDownDrawable.a();
    }
    for (;;)
    {
      ApngImage.pauseAll();
      ApngImage.playByTag(1);
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(17)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(17);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(17, 200L);
      return;
      label133:
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
    if ((SplashActivity.jdField_a_of_type_Int != 1) && (!this.e)) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar == null) || (!this.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar.a())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountOptPopBar.a(true);
  }
  
  public void q()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity
 * JD-Core Version:    0.7.0.1
 */