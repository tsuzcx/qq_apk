package com.tencent.mobileqq.app;

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
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.KandianAppInPush;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.DrawerFrame.IDrawerCallbacks;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.qim.QIMNewFriend;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.flashchat.FlashChatObserver;
import com.tencent.mobileqq.leba.ILebaFrameApi;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.onlinestatus.AccountPanel;
import com.tencent.mobileqq.onlinestatus.AccountPanel.OnlineStatusChangedListener;
import com.tencent.mobileqq.onlinestatus.OnBatteryChangeObserver;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnLineStatusPresenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.DrawerCoverUtil;
import com.tencent.widget.UpSideDownDrawable;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;

public class FrameHelperActivity
  extends FrameFragment
  implements View.OnClickListener, Animation.AnimationListener
{
  public static WeakReference<DrawerFrame> a;
  public static boolean o = false;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  public ViewGroup a;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  public ImageView a;
  public RelativeLayout a;
  DrawerFrame.IDrawerCallbacks jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks = new FrameHelperActivity.1(this);
  public DrawerFrame a;
  private FrameHelperActivity.DrawerListener jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$DrawerListener;
  public FrameHelperActivity.HeadViewLongClick a;
  private FrameHelperActivity.QQSettingMeListener jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener;
  public QIMNewFriendManager.IQIMNotifyNewFriendListener a;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard = null;
  public FlashChatObserver a;
  private AccountPanel.OnlineStatusChangedListener jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$OnlineStatusChangedListener = new FrameHelperActivity.16(this);
  public AccountPanel a;
  public OnBatteryChangeObserver a;
  private OnLineStatusPresenter jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusPresenter;
  protected RedTouch a;
  private CallBacker jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker;
  private boolean jdField_a_of_type_Boolean = false;
  public DrawerFrame.IDrawerCallbacks[] a;
  private int jdField_b_of_type_Int = 3;
  public View b;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  public ImageView b;
  private boolean jdField_b_of_type_Boolean = true;
  public View c;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean = false;
  protected boolean n = false;
  private boolean p;
  private boolean q;
  private boolean r = true;
  
  public FrameHelperActivity()
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks = new DrawerFrame.IDrawerCallbacks[] { null, null, null, null };
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new FrameHelperActivity.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager$IQIMNotifyNewFriendListener = new FrameHelperActivity.13(this);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver = new FrameHelperActivity.14(this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnBatteryChangeObserver = new FrameHelperActivity.15(this);
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(getActivity().app);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "start updateOnlineStatus");
    }
    a("AccountChange");
    SubAccountControll.c(getActivity().app, true);
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) {
      d();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.e();
    }
  }
  
  private void C()
  {
    this.p = true;
    this.jdField_c_of_type_AndroidViewView = getActivity().findViewById(2131370129);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && ((this.jdField_c_of_type_AndroidViewView.getLayoutParams() instanceof FrameLayout.LayoutParams)))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
      this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
    if (!this.n)
    {
      this.n = true;
      this.jdField_c_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)getActivity().findViewById(2131365363));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)getActivity().findViewById(2131372520));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = getActivity().findViewById(2131365365);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    D();
    u();
    a("initNecessaryUI");
  }
  
  private void D()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusPresenter == null)
    {
      FrameHelperActivity.9 local9 = new FrameHelperActivity.9(this);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusPresenter = new OnLineStatusPresenter(getActivity(), local9);
    }
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel != null) {
      return;
    }
    SubAccountControll.c(getActivity().app, true);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel = new AccountPanel(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel$OnlineStatusChangedListener);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel.a(new FrameHelperActivity.OnAccountExitListener(this));
    this.jdField_b_of_type_AndroidViewView.setHapticFeedbackEnabled(false);
    this.jdField_b_of_type_AndroidViewView.setOnLongClickListener(new FrameHelperActivity.10(this));
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new FrameHelperActivity.11(this));
    AccessibilityUtil.b(this.jdField_b_of_type_AndroidViewView, Button.class.getName());
  }
  
  private void F()
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
  
  private void G()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
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
    localAnimationSet.setAnimationListener(new FrameHelperActivity.12(this, (View)localObject));
    ((View)localObject).startAnimation(localAnimationSet);
  }
  
  private void H()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
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
  
  private void I()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.app == null)) {
      QLog.d("Q.recent", 1, "checkLocationPermission, activity or app is null");
    }
    int k;
    label133:
    label140:
    do
    {
      AppRuntime.Status localStatus;
      long l;
      do
      {
        return;
        localStatus = localFragmentActivity.app.getOnlineStatusNonSync();
        l = OnLineStatusHelper.a().a(localFragmentActivity.app);
      } while ((localStatus != AppRuntime.Status.online) || ((l != 1030L) && (l <= 40000L)));
      int i;
      if (l == 1030L)
      {
        i = 2131698417;
        if (l != 1030L) {
          break label133;
        }
      }
      for (int j = 2131698415;; j = 2131698418)
      {
        k = localFragmentActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION");
        if (k == 0) {
          break label140;
        }
        DialogUtil.a(localFragmentActivity, j, i);
        return;
        i = 2131698420;
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OnlineStatus", 2, new Object[] { "granted:", Integer.valueOf(k) });
  }
  
  private void J()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel.b(false);
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
    if (!this.p) {
      C();
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
        localObject = String.format(getString(2131693909), new Object[] { Integer.valueOf((int)(FriendProfileCardActivity.a - this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays)) });
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null) {
        break label225;
      }
      paramQQAppInterface = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365807);
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
        localObject = String.format(getString(2131693910), new Object[] { Integer.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays) });
      }
      else
      {
        localObject = getString(2131693911);
        continue;
        localObject = getString(2131693911);
      }
    }
    label225:
    this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(paramFragmentActivity, 2131755842);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559060);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365811);
    if (localTextView != null) {
      localTextView.setText(getString(2131693907));
    }
    localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365807);
    if (localTextView != null)
    {
      localTextView.requestFocus();
      localTextView.setText((CharSequence)localObject);
      localTextView.setContentDescription((CharSequence)localObject);
    }
    Object localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365796);
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131690800);
      ((TextView)localObject).setOnClickListener(new FrameHelperActivity.17(this, paramQQAppInterface));
    }
    localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365802);
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131693908);
      ((TextView)localObject).setOnClickListener(new FrameHelperActivity.18(this, paramQQAppInterface, paramFragmentActivity));
    }
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new FrameHelperActivity.19(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private int b()
  {
    Frame localFrame = a();
    if ((localFrame instanceof Conversation)) {
      return 1;
    }
    if ((localFrame instanceof Contacts)) {
      return 3;
    }
    if (((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).isLebaFrame(localFrame)) {
      return 4;
    }
    return 1;
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
    QLog.i("Q.recent", 1, "frameHelper_initDrawerFrame: mDrawerFrame=  " + this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame + "mDrawerBg= " + this.jdField_a_of_type_AndroidViewViewGroup + "mIsInflated = " + this.q);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$DrawerListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$DrawerListener.g(true);
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener == null)
      {
        localObject = (Conversation)a(Conversation.class);
        if (localObject != null) {
          ((Conversation)localObject).t();
        }
      }
      if (!this.q) {
        t();
      }
      Object localObject = (ViewGroup)getActivity().findViewById(2131365297);
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame = new DrawerFrame(getActivity(), (ViewGroup)localObject, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(), null, this.jdField_a_of_type_AndroidViewViewGroup, this);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) {
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$DrawerListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$DrawerListener.g(true);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.setDrawerCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks);
        v();
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
      localQIMNewFriendManager = (QIMNewFriendManager)getActivity().app.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER);
      localArrayList = localQIMNewFriendManager.b();
      if ((localArrayList.size() > 0) && (QIMNewFriend.a(getActivity(), localArrayList))) {
        localQIMNewFriendManager.a(localArrayList);
      }
    }
    while (!QLog.isColorLevel())
    {
      QIMNewFriendManager localQIMNewFriendManager;
      ArrayList localArrayList;
      return;
    }
    QLog.e("QIMNewFriend", 2, "showDialog|mIsForeground = " + this.jdField_b_of_type_Boolean + ",isDrawerOpen = " + this.jdField_a_of_type_Boolean);
  }
  
  private void f()
  {
    if (!this.p) {
      C();
    }
    if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -getResources().getDimension(2131299167), 0.0F);
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
      localRandomCoverView = (RandomCoverView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379654);
      localImageView1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363789);
      localImageView2 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380947);
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
    localImageView2.setImageResource(2130845078);
    localImageView2.setVisibility(0);
  }
  
  private void g()
  {
    if (!this.p) {
      C();
    }
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -getResources().getDimension(2131299167));
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(150L);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
    this.jdField_c_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    d();
    E();
  }
  
  private void j()
  {
    v();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "[setDrawerBg(app)]from MSG_SET_DIYBG, drawerOpened?" + this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b());
      }
      DrawerCoverUtil.b();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(14);
    }
  }
  
  public static void w()
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
  
  public static void x()
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
  
  private void z()
  {
    if (!this.p) {
      C();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel.a(paramInt1, paramInt2, paramIntent);
    }
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
  
  protected void a(int paramInt1, boolean paramBoolean, int paramInt2)
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
        ReportController.b(getActivity().app, "CliOper", "", "", (String)localObject1, (String)localObject1, paramInt2, 0, "", "", "", "");
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
        if ((this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null) && (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.c())) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          int i = VipInfoHandler.a((QQAppInterface)localObject1, (String)localObject2, paramBoolean);
          ReportController.b(getActivity().app, "dc00898", "", "", "0X800ABB1", "0X800ABB1", i, 0, "0", "0", "", "");
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
    localIntent.putExtra("logout_intent", true);
    localIntent.putExtra("tab_index", FrameControllerUtil.a);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.b();
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("unreadcount", 4).edit();
    localEditor.putInt("unread", 0);
    localEditor.apply();
    paramQQAppInterface.logout(true);
    if (GlobalImageCache.a != null) {
      GlobalImageCache.a.evictAll();
    }
    int i = QQSettingUtil.a(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    QQSettingUtil.a(paramActivity, paramQQAppInterface.getCurrentAccountUin(), i + 1);
    RouteUtils.a(paramActivity, localIntent, "/base/login");
    if (QQPlayerService.a())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast(paramQQAppInterface);
    }
    paramActivity.finish();
  }
  
  public void a(FrameHelperActivity.DrawerListener paramDrawerListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$DrawerListener = paramDrawerListener;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (paramDrawerListener != null)) {
      paramDrawerListener.g(true);
    }
  }
  
  public void a(FrameHelperActivity.QQSettingMeListener paramQQSettingMeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener = paramQQSettingMeListener;
  }
  
  public void a(Card paramCard)
  {
    Object localObject = getActivity();
    if ((localObject == null) || (((FragmentActivity)localObject).getAppInterface() == null) || (!ThemeUtil.isNowThemeIsDefault(getActivity().getAppInterface(), true, null)) || (paramCard == null) || (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener == null)) {
      return;
    }
    localObject = ((FragmentActivity)localObject).app;
    RandomCoverView localRandomCoverView = (RandomCoverView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379654);
    String str = (String)paramCard.getCoverData(0)[0];
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "[getCoverData] getCovertUrl from net,url:" + str);
    }
    if ((!TextUtils.isEmpty(str)) && (!DrawerCoverUtil.b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "card.isNoCover()=" + paramCard.isNoCover());
      }
      if ((!DrawerCoverUtil.a((QQAppInterface)localObject, paramCard)) && (paramCard.isNoCover()))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(false);
        ThreadManager.getUIHandler().post(new FrameHelperActivity.5(this, localRandomCoverView));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(true);
      ThreadManager.getUIHandler().post(new FrameHelperActivity.6(this, localRandomCoverView));
      this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker = DrawerCoverUtil.a(getActivity(), (QQAppInterface)localObject, paramCard, localRandomCoverView, str, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener, this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a());
      return;
    }
    if (DrawerCoverUtil.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "account has logouted,restart to fetch coverUrl");
      }
      DrawerCoverUtil.c();
      this.jdField_b_of_type_Int = 3;
    }
    a((QQAppInterface)localObject);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusPresenter.a(paramString);
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusPresenter.a();
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
      z();
      return false;
    case 6: 
      B();
      return false;
    case 4: 
      A();
      return false;
    case 2: 
      b(paramMessage);
      return false;
    case 3: 
      u();
      return false;
    case 5: 
      j();
      return false;
    case 9: 
      i();
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
      G();
      return false;
    case 14: 
      a(getActivity().app);
      return false;
    case 17: 
      e();
      return false;
    }
    I();
    return false;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(paramInt);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    o = paramBoolean;
    if (o) {
      KandianAppInPush.a().a(false);
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
        int i = AIOUtils.a(37.0F, getResources());
        int j = AIOUtils.a(60.0F, getResources());
        int k = AIOUtils.a(12.0F, getResources());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout((Context)localObject);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j, j);
        localLayoutParams.addRule(9, -1);
        localLayoutParams.addRule(15, -1);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
        Object localObject = new RelativeLayout((Context)localObject);
        localLayoutParams = new RelativeLayout.LayoutParams(i + 2, i + 2);
        localLayoutParams.addRule(9, -1);
        localLayoutParams.addRule(15, -1);
        localLayoutParams.leftMargin = (k - 1);
        ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
        ((RelativeLayout)localObject).setBackgroundDrawable(this.jdField_c_of_type_AndroidViewView.getResources().getDrawable(2130840681));
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
    F();
    v();
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel.a();
    }
    super.h();
  }
  
  protected void k() {}
  
  protected void l() {}
  
  protected void m() {}
  
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
      ReportController.b(getActivity().app, "CliOper", "", "", "Setting_tab", "My_settab", b(), 0, "", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch == null) || (!this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.c())) {
        break label581;
      }
      bool2 = true;
      bool1 = bool2;
      if (UpgradeController.a(getActivity().app)) {
        ReportController.b(getActivity().app, "CliOper", "", "", "0X8004DAF", "0X8004DAF", b(), 0, "", "", UpgradeController.a(), "");
      }
    }
    label581:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Object localObject = getActivity().app;
      int i;
      if (bool1)
      {
        i = 1;
        ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800A980", "0X800A980", i, 0, "0", "0", "", "");
        i = VipInfoHandler.a(getActivity().app, getActivity().app.getCurrentUin(), bool1);
        ReportController.b(getActivity().app, "dc00898", "", "", "0X800ABB0", "0X800ABB0", i, 0, "0", "0", "", "");
        ReportController.b(getActivity().app, "CliOper", "", "", "0X80072D5", "0X80072D5", 0, 0, "", "", "", "");
        if (bool1)
        {
          localObject = (RedTouchManager)getActivity().app.getManager(QQManagerFactory.MGR_RED_TOUCH);
          if (localObject != null) {
            ((RedTouchManager)localObject).b(1, 31);
          }
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        i = 2;
        break;
        if (paramView.getId() == 2131372520)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel != null) && (!this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel.isShowing()))
          {
            if ((getActivity().app != null) && (getActivity().app.getApp() != null))
            {
              localObject = (Vibrator)getActivity().app.getApp().getSystemService("vibrator");
              if (localObject != null) {
                ((Vibrator)localObject).vibrate(new long[] { 0L, 1L, 20L, 21L }, -1);
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel.show();
            m();
            ReportController.b(getActivity().app, "dc00898", "", "", "0X800A999", "0X800A999", 2, 0, "", "", "", "");
            ReportController.b(getActivity().app, "dc00898", "", "", "0X8009E83", "0X8009E83", 0, 0, "", "", "", "");
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(paramConfiguration);
    }
    J();
    w();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new FrameHelperActivity.HandlerCallback(this));
    this.jdField_c_of_type_Boolean = false;
    a();
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    this.jdField_c_of_type_Boolean = true;
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.c();
    }
    Object localObject = (IVasQuickUpdateService)getActivity().app.getRuntimeService(IVasQuickUpdateService.class, "");
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker != null)) {
      ((IVasQuickUpdateService)localObject).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel.az_();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel = null;
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
    if ((this.n) && (this.jdField_c_of_type_AndroidViewView != null))
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
    if ((SplashActivity.currentFragment != 1) && (!this.l)) {
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
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FrameHelperActivity.4(this, localUpSideDownDrawable), 1000L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel.g();
      }
      ((LocalRedTouchManager)getActivity().app.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).c(1);
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
    if (SplashActivity.currentFragment != 1) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a();
      u();
      UpSideDownDrawable localUpSideDownDrawable = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(DrawerCoverUtil.a);
      if (localUpSideDownDrawable == null) {
        break label170;
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
      a("onResume");
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "[QQSetting onResume] updateOnlineStatus");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel.h();
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
    if (SplashActivity.currentFragment != 1) {}
  }
  
  public void onStop()
  {
    super.onStop();
    if ((SplashActivity.currentFragment != 1) && (!this.l)) {}
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
  
  void t()
  {
    long l = 0L;
    for (;;)
    {
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "frameHelper_inflateUI, " + this.q + "mDrawerBgView=" + this.jdField_a_of_type_AndroidViewViewGroup);
        }
        if (!this.q)
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
          this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((LayoutInflater)localObject1).inflate(2131561610, null));
          this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363582));
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "frameHelper_inflateUI|mDrawerBgView= " + this.jdField_a_of_type_AndroidViewViewGroup);
          }
          this.q = true;
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
          ((HashMap)localObject1).put("device_mode", DeviceInfoUtil.d());
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
      this.q = false;
      continue;
      label330:
      l = 1L;
    }
  }
  
  public void u()
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
  
  void v()
  {
    ThemeBackground.applyThemeBg(super.getActivity().app, this.jdField_c_of_type_AndroidWidgetImageView, 0, 0, "-conversation-");
  }
  
  public void y()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity
 * JD-Core Version:    0.7.0.1
 */