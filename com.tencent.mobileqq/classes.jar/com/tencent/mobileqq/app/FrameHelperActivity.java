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
import androidx.fragment.app.FragmentManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.image.URLImageView;
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
import com.tencent.mobileqq.onlinestatus.IAccountPanel;
import com.tencent.mobileqq.onlinestatus.IAccountPanel.OnlineStatusChangedListener;
import com.tencent.mobileqq.onlinestatus.IOnLineStatusPresenter;
import com.tencent.mobileqq.onlinestatus.OnBatteryChangeObserver;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.profilecard.utils.QQDarenUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
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
import mqq.app.Foreground;
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
  protected QIMNewFriendManager.IQIMNotifyNewFriendListener a;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard = null;
  protected FlashChatObserver a;
  private IAccountPanel.OnlineStatusChangedListener jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel$OnlineStatusChangedListener = new FrameHelperActivity.16(this);
  public IAccountPanel a;
  private IOnLineStatusPresenter jdField_a_of_type_ComTencentMobileqqOnlinestatusIOnLineStatusPresenter;
  protected OnBatteryChangeObserver a;
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
    FrameHelperActivity.QQSettingMeListener localQQSettingMeListener = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener;
    if (localQQSettingMeListener != null) {
      localQQSettingMeListener.a((QQAppInterface)a().getAppRuntime());
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "start updateOnlineStatus");
    }
    a("AccountChange");
    ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).isHeadIconLongClickFunc((QQAppInterface)a().getAppRuntime(), true);
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) {
      d();
    }
    DrawerFrame localDrawerFrame = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame;
    if ((localDrawerFrame != null) && (localDrawerFrame.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.e();
    }
  }
  
  private void C()
  {
    this.p = true;
    this.jdField_c_of_type_AndroidViewView = a().findViewById(2131369800);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && ((this.jdField_c_of_type_AndroidViewView.getLayoutParams() instanceof FrameLayout.LayoutParams)))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(a()), 0, 0);
      this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
    if (!this.n)
    {
      this.n = true;
      this.jdField_c_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a().findViewById(2131365227));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a().findViewById(2131372105));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = a().findViewById(2131365229);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    D();
    u();
    a("initNecessaryUI");
  }
  
  private void D()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIOnLineStatusPresenter == null)
    {
      FrameHelperActivity.9 local9 = new FrameHelperActivity.9(this);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIOnLineStatusPresenter = ((IOnlineStatusService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).newPresenter(a(), local9);
    }
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel != null) {
      return;
    }
    ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).isHeadIconLongClickFunc((QQAppInterface)a().getAppRuntime(), true);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel = ((IOnlineStatusService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).newAccountPanel(a());
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel$OnlineStatusChangedListener);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel.a(new FrameHelperActivity.OnAccountExitListener(this));
    this.jdField_b_of_type_AndroidViewView.setHapticFeedbackEnabled(false);
    this.jdField_b_of_type_AndroidViewView.setOnLongClickListener(new FrameHelperActivity.10(this));
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new FrameHelperActivity.11(this));
    AccessibilityUtil.b(this.jdField_b_of_type_AndroidViewView, Button.class.getName());
  }
  
  private void F()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null)
    {
      if (ThemeUtil.isDefaultOrDIYTheme(false))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b())
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b();
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.setDrawerShadowFlag(true);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a();
    }
  }
  
  private void G()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject == null) {
        localObject = null;
      }
    }
    if (localObject == null) {
      return;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject == null) {
        localObject = null;
      }
    }
    if (localObject != null)
    {
      if (((View)localObject).getAnimation() == null) {
        return;
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
  }
  
  private void I()
  {
    QBaseActivity localQBaseActivity = a();
    if ((localQBaseActivity != null) && (localQBaseActivity.getAppRuntime() != null))
    {
      AppRuntime.Status localStatus = ((IOnlineStatusService)localQBaseActivity.getAppRuntime().getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
      long l = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getSelfExtOnlineStatus(localQBaseActivity.getAppRuntime());
      if ((localStatus == AppRuntime.Status.online) && ((l == 1030L) || (l > 40000L)))
      {
        int i;
        if (l == 1030L) {
          i = 2131698483;
        } else {
          i = 2131698486;
        }
        int j;
        if (l == 1030L) {
          j = 2131698481;
        } else {
          j = 2131698484;
        }
        int k = localQBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION");
        if (k != 0)
        {
          DialogUtil.a(localQBaseActivity, j, i);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatus", 2, new Object[] { "granted:", Integer.valueOf(k) });
        }
      }
      return;
    }
    QLog.d("Q.recent", 1, "checkLocationPermission, activity or app is null");
  }
  
  private void J()
  {
    IAccountPanel localIAccountPanel = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel;
    if ((localIAccountPanel != null) && (localIAccountPanel.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel.a(false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "closeAccountPanel");
    }
  }
  
  public static FrameHelperActivity a(BaseActivity paramBaseActivity)
  {
    paramBaseActivity = (QBaseFragment)paramBaseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
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
    if (!ThemeUtil.isNowThemeIsDefault(a().getAppRuntime(), true, null)) {
      return;
    }
    paramQQAppInterface.execute(new FrameHelperActivity.7(this, paramQQAppInterface));
  }
  
  private void a(QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataCard;
    if (localObject1 != null)
    {
      if (((Card)localObject1).lQQMasterLogindays > 0L) {
        QQDarenUtils.sQQDarenLoginDays = this.jdField_a_of_type_ComTencentMobileqqDataCard.lQQMasterLogindays;
      } else {
        QQDarenUtils.sQQDarenLoginDays = 30L;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays != 1L) && ((this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays <= 1L) || (this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays >= QQDarenUtils.sQQDarenLoginDays)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays >= QQDarenUtils.sQQDarenLoginDays) {
          localObject1 = String.format(getString(2131693864), new Object[] { Integer.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays) });
        } else {
          localObject1 = getString(2131693865);
        }
      }
      else {
        localObject1 = String.format(getString(2131693863), new Object[] { Integer.valueOf((int)(QQDarenUtils.sQQDarenLoginDays - this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays)) });
      }
    }
    else
    {
      localObject1 = getString(2131693865);
    }
    Object localObject2 = this.jdField_a_of_type_AndroidAppDialog;
    if (localObject2 != null)
    {
      paramQQAppInterface = (TextView)((Dialog)localObject2).findViewById(2131365644);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.requestFocus();
        paramQQAppInterface.setText((CharSequence)localObject1);
        paramQQAppInterface.setContentDescription((CharSequence)localObject1);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(paramQBaseActivity, 2131756189);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558954);
    localObject2 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365648);
    if (localObject2 != null) {
      ((TextView)localObject2).setText(getString(2131693861));
    }
    localObject2 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365644);
    if (localObject2 != null)
    {
      ((TextView)localObject2).requestFocus();
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
    }
    localObject1 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365633);
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText(2131690728);
      ((TextView)localObject1).setOnClickListener(new FrameHelperActivity.17(this, paramQQAppInterface));
    }
    localObject1 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365639);
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText(2131693862);
      ((TextView)localObject1).setOnClickListener(new FrameHelperActivity.18(this, paramQQAppInterface, paramQBaseActivity));
    }
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new FrameHelperActivity.19(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public static void a(boolean paramBoolean)
  {
    Object localObject = jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null) {
      localObject = (DrawerFrame)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      ((DrawerFrame)localObject).jdField_b_of_type_Boolean = paramBoolean;
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setDrawerFrameTouchable, ");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.i("Q.recent", 4, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private int b()
  {
    Frame localFrame = a();
    boolean bool = localFrame instanceof Conversation;
    int i = 1;
    if (bool) {
      return 1;
    }
    if ((localFrame instanceof Contacts)) {
      return 3;
    }
    if (((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).isLebaFrame(localFrame)) {
      i = 4;
    }
    return i;
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
  
  public static void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, new Object[] { "[foreground] closeAccountPanelRecursive: invoked. ", " reason: ", paramString });
    }
    paramString = Foreground.getTopActivity();
    if ((paramString != null) && ((paramString instanceof BaseActivity)))
    {
      paramString = a((BaseActivity)paramString);
      if (paramString != null)
      {
        paramString = paramString.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel;
        if ((paramString != null) && (paramString.isShowing())) {
          paramString.d();
        }
      }
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    Object localObject = jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null) {
      localObject = (DrawerFrame)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      ((DrawerFrame)localObject).setDrawerEnabled(paramBoolean);
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setDrawerFrameEnable, ");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.i("Q.recent", 4, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public static boolean b()
  {
    Object localObject = jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null) {
      localObject = (DrawerFrame)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    if ((((DrawerFrame)localObject).b()) || (((DrawerFrame)localObject).c())) {
      bool = true;
    }
    return bool;
  }
  
  private void d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("frameHelper_initDrawerFrame: mDrawerFrame=  ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
    ((StringBuilder)localObject).append("mDrawerBg= ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidViewViewGroup);
    ((StringBuilder)localObject).append("mIsInflated = ");
    ((StringBuilder)localObject).append(this.q);
    QLog.i("Q.recent", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$DrawerListener;
      if (localObject != null) {
        ((FrameHelperActivity.DrawerListener)localObject).g(true);
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener == null)
    {
      localObject = (Conversation)a(Conversation.class);
      if (localObject != null) {
        ((Conversation)localObject).s();
      }
    }
    if (!this.q) {
      t();
    }
    localObject = (ViewGroup)a().findViewById(2131365172);
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame = new DrawerFrame(a(), (ViewGroup)localObject, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(), null, this.jdField_a_of_type_AndroidViewViewGroup, this);
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("frameHelper_initDrawerFrame exception, ");
      localStringBuilder.append(localException.toString());
      QLog.i("Q.recent", 1, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) {
      return;
    }
    FrameHelperActivity.DrawerListener localDrawerListener = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$DrawerListener;
    if (localDrawerListener != null) {
      localDrawerListener.g(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.setDrawerCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks);
    v();
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
  }
  
  private void e()
  {
    Object localObject;
    if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
    {
      localObject = (QIMNewFriendManager)a().getAppRuntime().getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER);
      ArrayList localArrayList = ((QIMNewFriendManager)localObject).b();
      if ((localArrayList.size() > 0) && (QIMNewFriend.a(a(), localArrayList))) {
        ((QIMNewFriendManager)localObject).a(localArrayList);
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showDialog|mIsForeground = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append(",isDrawerOpen = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.e("QIMNewFriend", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void e(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject != null)
    {
      localObject = (RandomCoverView)((ViewGroup)localObject).findViewById(2131378997);
      ImageView localImageView1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363719);
      ImageView localImageView2 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380213);
      if (ThemeUtil.isNowThemeIsDefault(a().getAppRuntime(), paramBoolean, null))
      {
        try
        {
          ((RandomCoverView)localObject).setVisibility(0);
          if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(14)) {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(14);
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          ((RandomCoverView)localObject).setVisibility(8);
          localOutOfMemoryError.printStackTrace();
        }
        localImageView1.setVisibility(0);
        localImageView2.setVisibility(8);
        return;
      }
      localImageView1.setVisibility(8);
      ((RandomCoverView)localObject).a().setImageDrawable(null);
      ((RandomCoverView)localObject).setVisibility(8);
      localImageView2.setImageResource(2130844955);
      localImageView2.setVisibility(0);
    }
  }
  
  private void f()
  {
    if (!this.p) {
      C();
    }
    if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -getResources().getDimension(2131299169), 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(150L);
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
    this.jdField_c_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
  }
  
  private void g()
  {
    if (!this.p) {
      C();
    }
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -getResources().getDimension(2131299169));
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame;
    if ((localObject != null) && (((DrawerFrame)localObject).b()))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[setDrawerBg(app)]from MSG_SET_DIYBG, drawerOpened?");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b());
        QLog.d("Q.profilecard.", 2, ((StringBuilder)localObject).toString());
      }
      DrawerCoverUtil.b();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(14);
    }
  }
  
  public static void w()
  {
    Object localObject = jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null) {
      localObject = (DrawerFrame)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((DrawerFrame)localObject).i();
    }
  }
  
  public static void x()
  {
    Object localObject = jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null) {
      localObject = (DrawerFrame)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((DrawerFrame)localObject).b())) {
      ((DrawerFrame)localObject).h();
    }
  }
  
  private void z()
  {
    if (!this.p) {
      C();
    }
  }
  
  protected void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel;
    if (localObject != null) {
      ((IAccountPanel)localObject).a(paramInt1, paramInt2, paramIntent);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener != null) && (((DrawerFrame)localObject).b()))
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
    Object localObject3 = a();
    Object localObject1 = null;
    Object localObject2 = null;
    if ((localObject3 != null) && (a().getAppRuntime() != null))
    {
      boolean bool = true;
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {
          if (paramInt1 != 3) {
            if (paramInt1 != 4) {
              localObject1 = localObject2;
            }
          }
        }
        for (;;)
        {
          break;
          localObject1 = "0X8004031";
          continue;
          localObject1 = "0X8004030";
          continue;
          localObject1 = "0X8004032";
        }
      }
      if (paramBoolean)
      {
        localObject1 = (QQAppInterface)a().getAppRuntime();
        localObject2 = a().getAppRuntime().getCurrentUin();
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
        if ((localObject3 != null) && (((RedTouch)localObject3).c())) {
          paramBoolean = bool;
        } else {
          paramBoolean = false;
        }
        int i = VipInfoHandler.a((QQAppInterface)localObject1, (String)localObject2, paramBoolean);
        ReportController.b(a().getAppRuntime(), "dc00898", "", "", "0X800ABB1", "0X800ABB1", i, 0, "0", "0", "", "");
        localObject1 = "0X800402E";
      }
      else
      {
        localObject1 = "0X800402F";
      }
      if (localObject1 != null) {
        ReportController.b(a().getAppRuntime(), "CliOper", "", "", (String)localObject1, (String)localObject1, paramInt2, 0, "", "", "", "");
      }
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("doDrawerActionReport, actionFlag: ");
        ((StringBuilder)localObject2).append(paramInt1);
        ((StringBuilder)localObject2).append(", tag = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("Q.recent", 4, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doDrawerActionReport, getActivity =  ");
      ((StringBuilder)localObject2).append(a());
      ((StringBuilder)localObject2).append(" app = ");
      if (a() != null) {
        localObject1 = a().getAppRuntime();
      }
      ((StringBuilder)localObject2).append(localObject1);
      QLog.i("Q.recent", 2, ((StringBuilder)localObject2).toString());
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
    Object localObject1 = a();
    if ((localObject1 != null) && (((QBaseActivity)localObject1).getAppRuntime() != null) && (ThemeUtil.isNowThemeIsDefault(a().getAppRuntime(), true, null)) && (paramCard != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener == null) {
        return;
      }
      localObject1 = (QQAppInterface)((QBaseActivity)localObject1).getAppRuntime();
      RandomCoverView localRandomCoverView = (RandomCoverView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378997);
      String str = (String)paramCard.getCoverData(0)[0];
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[getCoverData] getCovertUrl from net,url:");
        ((StringBuilder)localObject2).append(str);
        QLog.d("Q.profilecard.", 2, ((StringBuilder)localObject2).toString());
      }
      if ((!TextUtils.isEmpty(str)) && (!DrawerCoverUtil.b()))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("card.isNoCover()=");
          ((StringBuilder)localObject2).append(paramCard.isNoCover());
          QLog.d("Q.recent", 2, ((StringBuilder)localObject2).toString());
        }
        if ((!DrawerCoverUtil.a((QQAppInterface)localObject1, paramCard)) && (paramCard.isNoCover()))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(false);
          ThreadManager.getUIHandler().post(new FrameHelperActivity.5(this, localRandomCoverView));
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(true);
        ThreadManager.getUIHandler().post(new FrameHelperActivity.6(this, localRandomCoverView));
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) && (QLog.isColorLevel())) {
          QLog.d("Q.recent", 2, new Object[] { "setDrawerBg: mDrawerFrame=null, card", paramCard });
        }
        localObject2 = a();
        FrameHelperActivity.QQSettingMeListener localQQSettingMeListener = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener;
        DrawerFrame localDrawerFrame = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame;
        boolean bool;
        if ((localDrawerFrame != null) && (localDrawerFrame.a())) {
          bool = true;
        } else {
          bool = false;
        }
        this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker = DrawerCoverUtil.a((QBaseActivity)localObject2, (QQAppInterface)localObject1, paramCard, localRandomCoverView, str, localQQSettingMeListener, bool);
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
      a((QQAppInterface)localObject1);
    }
  }
  
  public void a(String paramString)
  {
    IOnLineStatusPresenter localIOnLineStatusPresenter = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIOnLineStatusPresenter;
    if (localIOnLineStatusPresenter != null) {
      localIOnLineStatusPresenter.a(paramString);
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    paramLogoutReason = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIOnLineStatusPresenter;
    if (paramLogoutReason != null) {
      paramLogoutReason.a();
    }
  }
  
  public boolean a(Message paramMessage)
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      if (a() == null) {
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
      case 18: 
        I();
        return false;
      case 17: 
        e();
        return false;
      case 14: 
        a((QQAppInterface)a().getAppRuntime());
        return false;
      case 13: 
        G();
        return false;
      case 12: 
        a(paramMessage);
        return false;
      case 11: 
        f();
        return false;
      case 10: 
        g();
        return false;
      case 9: 
        i();
        return false;
      case 6: 
        B();
        return false;
      case 5: 
        j();
        return false;
      case 4: 
        A();
        return false;
      case 3: 
        u();
        return false;
      case 2: 
        b(paramMessage);
        return false;
      }
      z();
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    o = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_AndroidViewView == null) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showHeadMask, show:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Q.profilecard.", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "create new mask");
        }
        localObject = this.jdField_c_of_type_AndroidViewView.getContext();
        if (localObject == null) {
          return;
        }
        int j = AIOUtils.b(37.0F, getResources());
        int k = AIOUtils.b(60.0F, getResources());
        int i = AIOUtils.b(12.0F, getResources());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout((Context)localObject);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, k);
        localLayoutParams.addRule(9, -1);
        localLayoutParams.addRule(15, -1);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
        localObject = new RelativeLayout((Context)localObject);
        j += 2;
        localLayoutParams = new RelativeLayout.LayoutParams(j, j);
        localLayoutParams.addRule(9, -1);
        localLayoutParams.addRule(15, -1);
        localLayoutParams.leftMargin = (i - 1);
        ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
        ((RelativeLayout)localObject).setBackgroundDrawable(this.jdField_c_of_type_AndroidViewView.getResources().getDrawable(2130840556));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
        localObject = this.jdField_c_of_type_AndroidViewView;
        if ((localObject instanceof ViewGroup))
        {
          ((ViewGroup)localObject).addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "addview error");
        }
      }
    }
    else if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "remove mask");
      }
      localObject = this.jdField_c_of_type_AndroidViewView;
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      } else if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "removeview error");
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    }
  }
  
  public void h()
  {
    e(true);
    F();
    v();
    IAccountPanel localIAccountPanel = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel;
    if (localIAccountPanel != null) {
      localIAccountPanel.c();
    }
    super.h();
  }
  
  protected void k() {}
  
  protected void l() {}
  
  protected void m() {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    paramAnimation = this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if ((paramView == localObject) && (localObject != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame == null) {
        d();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame;
      if ((localObject != null) && (((DrawerFrame)localObject).a())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.d();
      }
      ReportController.b(a().getAppRuntime(), "CliOper", "", "", "Setting_tab", "My_settab", b(), 0, "", "", "", "");
      boolean bool2 = false;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((RedTouch)localObject).c())
        {
          if (UpgradeController.a((QQAppInterface)a().getAppRuntime())) {
            ReportController.b(a().getAppRuntime(), "CliOper", "", "", "0X8004DAF", "0X8004DAF", b(), 0, "", "", UpgradeController.a(), "");
          }
          bool1 = true;
        }
      }
      localObject = a().getAppRuntime();
      if (bool1) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800A980", "0X800A980", i, 0, "0", "0", "", "");
      int i = VipInfoHandler.a((QQAppInterface)a().getAppRuntime(), a().getAppRuntime().getCurrentUin(), bool1);
      ReportController.b(a().getAppRuntime(), "dc00898", "", "", "0X800ABB0", "0X800ABB0", i, 0, "0", "0", "", "");
      ReportController.b(a().getAppRuntime(), "CliOper", "", "", "0X80072D5", "0X80072D5", 0, 0, "", "", "", "");
      if (bool1) {
        ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).reportLevelZeroRedInfo(1, 31);
      }
    }
    else if (paramView.getId() == 2131372105)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel;
      if ((localObject != null) && (!((IAccountPanel)localObject).isShowing()))
      {
        if ((a().getAppRuntime() != null) && (a().getAppRuntime().getApp() != null))
        {
          localObject = (Vibrator)a().getAppRuntime().getApp().getSystemService("vibrator");
          if (localObject != null) {
            ((Vibrator)localObject).vibrate(new long[] { 0L, 1L, 20L, 21L }, -1);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel.show();
        m();
        ReportController.b(a().getAppRuntime(), "dc00898", "", "", "0X800A999", "0X800A999", 2, 0, "", "", "", "");
        ReportController.b(a().getAppRuntime(), "dc00898", "", "", "0X8009E83", "0X8009E83", 0, 0, "", "", "", "");
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "click online status icon");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    FrameHelperActivity.QQSettingMeListener localQQSettingMeListener = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener;
    if (localQQSettingMeListener != null) {
      localQQSettingMeListener.a(paramConfiguration);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener;
    if (localObject != null) {
      ((FrameHelperActivity.QQSettingMeListener)localObject).c();
    }
    localObject = (IVasQuickUpdateService)a().getAppRuntime().getRuntimeService(IVasQuickUpdateService.class, "");
    if (localObject != null)
    {
      CallBacker localCallBacker = this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker;
      if (localCallBacker != null) {
        ((IVasQuickUpdateService)localObject).removeCallBacker(localCallBacker);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel;
    if (localObject != null)
    {
      ((IAccountPanel)localObject).aK_();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel = null;
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null)
    {
      localObject = ((ImageView)localObject).getDrawable();
      if ((localObject != null) && ((localObject instanceof FaceDrawable))) {
        ((FaceDrawable)localObject).cancel();
      }
    }
    localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject != null)
    {
      ((View)localObject).setOnClickListener(null);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(null);
    }
    if ((this.n) && (this.jdField_c_of_type_AndroidViewView != null))
    {
      if (Build.VERSION.SDK_INT < 16)
      {
        this.jdField_c_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
        return;
      }
      this.jdField_c_of_type_AndroidViewView.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    DrawerFrame localDrawerFrame = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame;
    if (localDrawerFrame != null) {
      localDrawerFrame.a(paramBoolean);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((SplashActivity.currentFragment != 1) && (!this.l)) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame;
    if ((localObject != null) && (((DrawerFrame)localObject).c())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener != null) && (((DrawerFrame)localObject).b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.b();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(DrawerCoverUtil.a);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "[QQSetting onPause] delay one second  and stop UpSideDown Animation");
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FrameHelperActivity.4(this, (UpSideDownDrawable)localObject), 1000L);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.", 2, "[QQSetting onPause] dynamicDrawable is null");
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel;
    if (localObject != null) {
      ((IAccountPanel)localObject).g();
    }
    ((LocalRedTouchManager)a().getAppRuntime().getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).c(1);
  }
  
  public void onResume()
  {
    super.onResume();
    if (SplashActivity.currentFragment != 1) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener != null) && (((DrawerFrame)localObject).b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a();
      u();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(DrawerCoverUtil.a);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "[QQSetting onResume] p UpSideDown Animation");
        }
        ((UpSideDownDrawable)localObject).start();
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.", 2, "[QQSetting onResume] dynamicDrawable is null");
      }
      ApngImage.pauseAll();
      ApngImage.playByTag(1);
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(17)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(17);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(17, 200L);
    a("onResume");
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "[QQSetting onResume] updateOnlineStatus");
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel;
    if (localObject != null) {
      ((IAccountPanel)localObject).h();
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
    for (;;)
    {
      try
      {
        Object localObject1;
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("frameHelper_inflateUI, ");
          ((StringBuilder)localObject1).append(this.q);
          ((StringBuilder)localObject1).append("mDrawerBgView=");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidViewViewGroup);
          QLog.i("Q.recent", 4, ((StringBuilder)localObject1).toString());
        }
        if ((!this.q) && (a() != null))
        {
          localObject1 = LayoutInflater.from(a());
          Object localObject3;
          try
          {
            this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((LayoutInflater)localObject1).inflate(2131561453, null));
            this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363505));
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("frameHelper_inflateUI|mDrawerBgView= ");
              ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidViewViewGroup);
              QLog.d("Q.recent", 2, ((StringBuilder)localObject1).toString());
            }
            this.q = true;
          }
          catch (Exception localException2)
          {
            if (Thread.currentThread() == Looper.getMainLooper().getThread())
            {
              localObject1 = "in main thread ";
            }
            else
            {
              localObject1 = "not in main thread ";
              this.jdField_a_of_type_AndroidViewViewGroup = null;
              this.q = false;
            }
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append((String)localObject1);
              ((StringBuilder)localObject3).append(localException2.toString());
              QLog.i("Q.recent", 2, ((StringBuilder)localObject3).toString());
            }
          }
          try
          {
            localObject1 = new HashMap();
            ((HashMap)localObject1).put("device_mode", DeviceInfoUtil.d());
            ((HashMap)localObject1).put("manufacturer", Build.MANUFACTURER);
            StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplicationImpl.getContext());
            localObject3 = a().getAppRuntime().getCurrentAccountUin();
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
              break label359;
            }
            l = 0L;
            localStatisticCollector.collectPerformance((String)localObject3, "actFrameHelperSubInflate", false, l, 0L, (HashMap)localObject1, "");
          }
          catch (Exception localException1)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.recent", 2, localException1.toString());
            }
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      label359:
      long l = 1L;
    }
  }
  
  public void u()
  {
    Object localObject1 = a();
    if ((!this.jdField_c_of_type_Boolean) && (localObject1 != null))
    {
      if (((QBaseActivity)localObject1).getAppRuntime() == null) {
        return;
      }
      Object localObject2 = a().getAppRuntime().getCurrentAccountUin();
      Drawable localDrawable = FaceDrawable.getDefaultDrawable(1, 3);
      localObject1 = FaceDrawable.getFaceDrawable((AppInterface)((QBaseActivity)localObject1).getAppRuntime(), 1, (String)localObject2, 3, localDrawable, localDrawable, null);
      a(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(12, localObject1));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("FrameHelperActivity, updateSelfFace:");
      if (localObject1 != null) {
        localObject1 = ((FaceDrawable)localObject1).getLoadedBitmap();
      } else {
        localObject1 = "";
      }
      ((StringBuilder)localObject2).append(localObject1);
      QLog.i("Q.qqhead.freq", 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  void v()
  {
    ThemeBackground.a(super.a().getAppRuntime(), this.jdField_c_of_type_AndroidWidgetImageView, 0, 0, "-conversation-");
  }
  
  public void y()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(11);
    Object localObject = this.jdField_c_of_type_AndroidViewView;
    if (localObject != null)
    {
      localObject = ((View)localObject).getAnimation();
      if (localObject != null) {
        ((Animation)localObject).setAnimationListener(null);
      }
      this.jdField_c_of_type_AndroidViewView.clearAnimation();
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity
 * JD-Core Version:    0.7.0.1
 */