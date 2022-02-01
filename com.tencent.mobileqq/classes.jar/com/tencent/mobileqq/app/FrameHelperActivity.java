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
import android.view.ViewGroup.LayoutParams;
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
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.qim.QIMNewFriend;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
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
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.mobileqq.widget.imageview.CircleBoarderImageView;
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
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.LogoutReason;
import mqq.app.Foreground;
import mqq.os.MqqHandler;

public class FrameHelperActivity
  extends FrameFragment
  implements View.OnClickListener, Animation.AnimationListener
{
  public static WeakReference<DrawerFrame> aq;
  public static boolean ar = false;
  private ImageView a;
  public ImageView ab;
  public CircleBoarderImageView ac;
  protected RedTouch ad;
  public View ae;
  public View af;
  public RelativeLayout ag;
  public DrawerFrame ah;
  public ViewGroup ai;
  public IAccountPanel aj;
  public DrawerFrame.IDrawerCallbacks[] ak = { null, null, null, null };
  public FrameHelperActivity.HeadViewLongClick al;
  DrawerFrame.IDrawerCallbacks am = new FrameHelperActivity.1(this);
  protected boolean an = false;
  protected ViewTreeObserver.OnGlobalLayoutListener ao = new FrameHelperActivity.2(this);
  public boolean ap = false;
  protected QIMNewFriendManager.IQIMNotifyNewFriendListener as = new FrameHelperActivity.13(this);
  protected FlashChatObserver at = new FrameHelperActivity.14(this);
  protected OnBatteryChangeObserver au = new FrameHelperActivity.15(this);
  private int av = 3;
  private boolean aw = true;
  private FrameHelperActivity.DrawerListener ax;
  private IAccountPanel.OnlineStatusChangedListener ay = new FrameHelperActivity.16(this);
  private IOnLineStatusPresenter b;
  private TranslateAnimation c;
  private TranslateAnimation d;
  private Dialog e;
  private Card f = null;
  private boolean g = true;
  private boolean h = false;
  private boolean i;
  private boolean j;
  private CallBacker k;
  private FrameHelperActivity.QQSettingMeListener l;
  
  public static boolean G()
  {
    Object localObject = aq;
    if (localObject != null) {
      localObject = (DrawerFrame)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    if ((((DrawerFrame)localObject).j()) || (((DrawerFrame)localObject).k())) {
      bool = true;
    }
    return bool;
  }
  
  public static void H()
  {
    Object localObject = aq;
    if (localObject != null) {
      localObject = (DrawerFrame)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((DrawerFrame)localObject).i();
    }
  }
  
  public static void I()
  {
    Object localObject = aq;
    if (localObject != null) {
      localObject = (DrawerFrame)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((DrawerFrame)localObject).j())) {
      ((DrawerFrame)localObject).h();
    }
  }
  
  private void L()
  {
    this.i = true;
    this.af = C().findViewById(2131436932);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && ((this.af.getLayoutParams() instanceof FrameLayout.LayoutParams)))
    {
      localObject = (FrameLayout.LayoutParams)this.af.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).setMargins(0, ImmersiveUtils.getStatusBarHeight(C()), 0, 0);
      this.af.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (!this.an)
    {
      this.an = true;
      this.af.getViewTreeObserver().addOnGlobalLayoutListener(this.ao);
    }
    Object localObject = C();
    int m = 2131431393;
    this.ab = ((ImageView)((QBaseActivity)localObject).findViewById(2131431393));
    this.ac = ((CircleBoarderImageView)C().findViewById(2131439575));
    this.ac.setOnClickListener(this);
    localObject = this.ac;
    RedTouch localRedTouch = this.ad;
    if (localRedTouch != null) {
      m = localRedTouch.getId();
    }
    a((CircleBoarderImageView)localObject, m);
    this.ae = C().findViewById(2131431395);
    this.ae.setOnClickListener(this);
    M();
    E();
    b("initNecessaryUI");
  }
  
  private void M()
  {
    if (this.b == null)
    {
      FrameHelperActivity.9 local9 = new FrameHelperActivity.9(this);
      this.b = ((IOnlineStatusService)this.A.getRuntimeService(IOnlineStatusService.class, "")).newPresenter(C(), local9);
    }
  }
  
  private void N()
  {
    if (this.aj != null) {
      return;
    }
    ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).isHeadIconLongClickFunc((QQAppInterface)C().getAppRuntime(), true);
    this.aj = ((IOnlineStatusService)this.A.getRuntimeService(IOnlineStatusService.class, "")).newAccountPanel(C());
    this.aj.a(this.ay);
    this.aj.a(new FrameHelperActivity.OnAccountExitListener(this));
    this.ae.setHapticFeedbackEnabled(false);
    this.ae.setOnLongClickListener(new FrameHelperActivity.10(this));
    this.ae.setOnTouchListener(new FrameHelperActivity.11(this));
    AccessibilityUtil.b(this.ae, Button.class.getName());
  }
  
  private int O()
  {
    Frame localFrame = v();
    boolean bool = localFrame instanceof Conversation;
    int m = 1;
    if (bool) {
      return 1;
    }
    if ((localFrame instanceof Contacts)) {
      return 3;
    }
    if (((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).isLebaFrame(localFrame)) {
      m = 4;
    }
    return m;
  }
  
  private void P()
  {
    DrawerFrame localDrawerFrame = this.ah;
    if (localDrawerFrame != null)
    {
      if (localDrawerFrame.j())
      {
        this.ah.a();
        return;
      }
      this.ah.setDrawerShadowFlag(true);
    }
  }
  
  private void Q()
  {
    Object localObject = this.ad;
    if (localObject == null)
    {
      localObject = this.ab;
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
  
  private void R()
  {
    Object localObject = this.ad;
    if (localObject == null)
    {
      localObject = this.ab;
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
  
  private void S()
  {
    QBaseActivity localQBaseActivity = C();
    if ((localQBaseActivity != null) && (localQBaseActivity.getAppRuntime() != null))
    {
      AppRuntime.Status localStatus = ((IOnlineStatusService)localQBaseActivity.getAppRuntime().getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
      long l1 = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getSelfExtOnlineStatus(localQBaseActivity.getAppRuntime());
      if ((localStatus == AppRuntime.Status.online) && ((l1 == 1030L) || (l1 > 40000L)))
      {
        int m;
        if (l1 == 1030L) {
          m = 2131896423;
        } else {
          m = 2131896426;
        }
        int n;
        if (l1 == 1030L) {
          n = 2131896421;
        } else {
          n = 2131896424;
        }
        int i1 = localQBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION");
        if (i1 != 0)
        {
          DialogUtil.a(localQBaseActivity, n, m);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatus", 2, new Object[] { "granted:", Integer.valueOf(i1) });
        }
      }
      return;
    }
    QLog.d("Q.recent", 1, "checkLocationPermission, activity or app is null");
  }
  
  private void T()
  {
    IAccountPanel localIAccountPanel = this.aj;
    if ((localIAccountPanel != null) && (localIAccountPanel.isShowing())) {
      this.aj.a(false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "closeAccountPanel");
    }
  }
  
  private void U()
  {
    IOnLineStatusPresenter localIOnLineStatusPresenter = this.b;
    if (localIOnLineStatusPresenter != null) {
      localIOnLineStatusPresenter.a("OlympicMedalEventUpdate");
    }
  }
  
  private static int a(float paramFloat)
  {
    return ViewUtils.dip2px(paramFloat);
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
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (!ThemeUtil.isNowThemeIsDefault(C().getAppRuntime(), true, null)) {
      return;
    }
    paramQQAppInterface.execute(new FrameHelperActivity.7(this, paramQQAppInterface));
  }
  
  private void a(QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    Object localObject1 = this.f;
    if (localObject1 != null)
    {
      if (((Card)localObject1).lQQMasterLogindays > 0L) {
        QQDarenUtils.sQQDarenLoginDays = this.f.lQQMasterLogindays;
      } else {
        QQDarenUtils.sQQDarenLoginDays = 30L;
      }
      if ((this.f.lLoginDays != 1L) && ((this.f.lLoginDays <= 1L) || (this.f.lLoginDays >= QQDarenUtils.sQQDarenLoginDays)))
      {
        if (this.f.lLoginDays >= QQDarenUtils.sQQDarenLoginDays) {
          localObject1 = String.format(getString(2131891445), new Object[] { Integer.valueOf((int)this.f.lLoginDays) });
        } else {
          localObject1 = getString(2131891446);
        }
      }
      else {
        localObject1 = String.format(getString(2131891444), new Object[] { Integer.valueOf((int)(QQDarenUtils.sQQDarenLoginDays - this.f.lLoginDays)) });
      }
    }
    else
    {
      localObject1 = getString(2131891446);
    }
    Object localObject2 = this.e;
    if (localObject2 != null)
    {
      paramQQAppInterface = (TextView)((Dialog)localObject2).findViewById(2131431876);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.requestFocus();
        paramQQAppInterface.setText((CharSequence)localObject1);
        paramQQAppInterface.setContentDescription((CharSequence)localObject1);
      }
      this.e.show();
      return;
    }
    this.e = new ReportDialog(paramQBaseActivity, 2131953338);
    this.e.setContentView(2131624587);
    localObject2 = (TextView)this.e.findViewById(2131431880);
    if (localObject2 != null) {
      ((TextView)localObject2).setText(getString(2131891442));
    }
    localObject2 = (TextView)this.e.findViewById(2131431876);
    if (localObject2 != null)
    {
      ((TextView)localObject2).requestFocus();
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
    }
    localObject1 = (TextView)this.e.findViewById(2131431864);
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText(2131887648);
      ((TextView)localObject1).setOnClickListener(new FrameHelperActivity.17(this, paramQQAppInterface));
    }
    localObject1 = (TextView)this.e.findViewById(2131431870);
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText(2131891443);
      ((TextView)localObject1).setOnClickListener(new FrameHelperActivity.18(this, paramQQAppInterface, paramQBaseActivity));
    }
    this.e.setOnDismissListener(new FrameHelperActivity.19(this));
    this.e.show();
  }
  
  private void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("frameHelper_initDrawerFrame: mDrawerFrame=  ");
    ((StringBuilder)localObject).append(this.ah);
    ((StringBuilder)localObject).append("mDrawerBg= ");
    ((StringBuilder)localObject).append(this.ai);
    ((StringBuilder)localObject).append("mIsInflated = ");
    ((StringBuilder)localObject).append(this.j);
    QLog.i("Q.recent", 1, ((StringBuilder)localObject).toString());
    if (this.ah != null)
    {
      localObject = this.ax;
      if (localObject != null) {
        ((FrameHelperActivity.DrawerListener)localObject).g(true);
      }
      return;
    }
    if (this.l == null)
    {
      localObject = (Conversation)a(Conversation.class);
      if (localObject != null) {
        ((Conversation)localObject).x();
      }
    }
    if (!this.j) {
      D();
    }
    localObject = (ViewGroup)C().findViewById(2131431325);
    try
    {
      if (this.l != null) {
        this.ah = new DrawerFrame(C(), (ViewGroup)localObject, this.l.d(), null, this.ai, this);
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("frameHelper_initDrawerFrame exception, ");
      localStringBuilder.append(localException.toString());
      QLog.i("Q.recent", 1, localStringBuilder.toString());
    }
    if (this.ah == null) {
      return;
    }
    FrameHelperActivity.DrawerListener localDrawerListener = this.ax;
    if (localDrawerListener != null) {
      localDrawerListener.g(true);
    }
    this.ah.setDrawerCallbacks(this.am);
    F();
    aq = new WeakReference(this.ah);
    a(true);
  }
  
  private void b(Message paramMessage)
  {
    if (!this.i) {
      L();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "FrameHelperActivity, updateSelfFace now");
    }
    Drawable localDrawable = this.ab.getDrawable();
    if ((localDrawable != null) && ((localDrawable instanceof FaceDrawable))) {
      ((FaceDrawable)localDrawable).cancel();
    }
    this.ab.setImageDrawable((Drawable)paramMessage.obj);
  }
  
  public static void b(boolean paramBoolean)
  {
    Object localObject = aq;
    if (localObject != null) {
      localObject = (DrawerFrame)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      ((DrawerFrame)localObject).c = paramBoolean;
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setDrawerFrameTouchable, ");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.i("Q.recent", 4, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void c()
  {
    Object localObject;
    if ((this.g) && (!this.ap))
    {
      localObject = (QIMNewFriendManager)C().getAppRuntime().getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER);
      ArrayList localArrayList = ((QIMNewFriendManager)localObject).c();
      if ((localArrayList.size() > 0) && (QIMNewFriend.a(C(), localArrayList))) {
        ((QIMNewFriendManager)localObject).a(localArrayList);
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showDialog|mIsForeground = ");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append(",isDrawerOpen = ");
      ((StringBuilder)localObject).append(this.ap);
      QLog.e("QIMNewFriend", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void c(Message paramMessage)
  {
    if (paramMessage.arg1 == 0)
    {
      ThreadManager.getSubThreadHandler().post(new FrameHelperActivity.8(this));
      paramMessage = Message.obtain();
      paramMessage.what = 2;
      paramMessage.arg1 = 1;
      this.q.sendMessageDelayed(paramMessage, 20000L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "frameHelper_infalter time out, need do in UI thread ");
    }
    this.q.sendEmptyMessage(9);
  }
  
  public static void c(String paramString)
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
        paramString = paramString.aj;
        if ((paramString != null) && (paramString.isShowing())) {
          paramString.f();
        }
      }
    }
  }
  
  public static void c(boolean paramBoolean)
  {
    Object localObject = aq;
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
  
  private void f()
  {
    if (!this.i) {
      L();
    }
    if (this.d == null)
    {
      this.d = new TranslateAnimation(0.0F, 0.0F, -getResources().getDimension(2131299921), 0.0F);
      this.d.setDuration(150L);
    }
    this.af.setVisibility(0);
    this.d.setAnimationListener(this);
    this.af.startAnimation(this.d);
  }
  
  private void f(boolean paramBoolean)
  {
    Object localObject = this.ai;
    if (localObject != null)
    {
      localObject = (RandomCoverView)((ViewGroup)localObject).findViewById(2131447715);
      ImageView localImageView1 = (ImageView)this.ai.findViewById(2131429642);
      ImageView localImageView2 = (ImageView)this.ai.findViewById(2131449131);
      if (ThemeUtil.isNowThemeIsDefault(C().getAppRuntime(), paramBoolean, null))
      {
        try
        {
          ((RandomCoverView)localObject).setVisibility(0);
          if (!this.q.hasMessages(14)) {
            this.q.sendEmptyMessage(14);
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
      ((RandomCoverView)localObject).getCoverView().setImageDrawable(null);
      ((RandomCoverView)localObject).setVisibility(8);
      localImageView2.setImageResource(2130846391);
      localImageView2.setVisibility(0);
    }
  }
  
  private void g()
  {
    if (!this.i) {
      L();
    }
    if (this.c == null)
    {
      this.c = new TranslateAnimation(0.0F, 0.0F, 0.0F, -getResources().getDimension(2131299921));
      this.c.setDuration(150L);
      this.c.setFillAfter(true);
    }
    this.c.setAnimationListener(this);
    this.af.startAnimation(this.c);
  }
  
  private void h()
  {
    this.q.removeMessages(2);
    b();
    N();
  }
  
  private void i()
  {
    F();
    Object localObject = this.ah;
    if ((localObject != null) && (((DrawerFrame)localObject).j()))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[setDrawerBg(app)]from MSG_SET_DIYBG, drawerOpened?");
        ((StringBuilder)localObject).append(this.ah.j());
        QLog.d("Q.profilecard.", 2, ((StringBuilder)localObject).toString());
      }
      DrawerCoverUtil.d();
      this.q.sendEmptyMessage(14);
    }
  }
  
  private void j()
  {
    if (!this.i) {
      L();
    }
  }
  
  private void m()
  {
    FrameHelperActivity.QQSettingMeListener localQQSettingMeListener = this.l;
    if (localQQSettingMeListener != null) {
      localQQSettingMeListener.a((QQAppInterface)C().getAppRuntime());
    }
    this.q.sendEmptyMessage(3);
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "start updateOnlineStatus");
    }
    b("AccountChange");
    ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).isHeadIconLongClickFunc((QQAppInterface)C().getAppRuntime(), true);
  }
  
  private void n()
  {
    if (this.ah == null) {
      b();
    }
    DrawerFrame localDrawerFrame = this.ah;
    if ((localDrawerFrame != null) && (localDrawerFrame.b())) {
      this.ah.e();
    }
  }
  
  void D()
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
          ((StringBuilder)localObject1).append(this.j);
          ((StringBuilder)localObject1).append("mDrawerBgView=");
          ((StringBuilder)localObject1).append(this.ai);
          QLog.i("Q.recent", 4, ((StringBuilder)localObject1).toString());
        }
        if ((!this.j) && (C() != null))
        {
          localObject1 = LayoutInflater.from(C());
          Object localObject3;
          try
          {
            this.ai = ((ViewGroup)((LayoutInflater)localObject1).inflate(2131627809, null));
            this.a = ((ImageView)this.ai.findViewById(2131429407));
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("frameHelper_inflateUI|mDrawerBgView= ");
              ((StringBuilder)localObject1).append(this.ai);
              QLog.d("Q.recent", 2, ((StringBuilder)localObject1).toString());
            }
            this.j = true;
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
              this.ai = null;
              this.j = false;
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
            ((HashMap)localObject1).put("device_mode", DeviceInfoUtil.f());
            ((HashMap)localObject1).put("manufacturer", Build.MANUFACTURER);
            StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplicationImpl.getContext());
            localObject3 = C().getAppRuntime().getCurrentAccountUin();
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
              break label363;
            }
            l1 = 0L;
            localStatisticCollector.collectPerformance((String)localObject3, "actFrameHelperSubInflate", false, l1, 0L, (HashMap)localObject1, "");
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
      label363:
      long l1 = 1L;
    }
  }
  
  public void E()
  {
    Object localObject1 = C();
    if ((!this.h) && (localObject1 != null))
    {
      if (((QBaseActivity)localObject1).getAppRuntime() == null) {
        return;
      }
      Object localObject2 = C().getAppRuntime().getCurrentAccountUin();
      Drawable localDrawable = FaceDrawable.getDefaultDrawable(1, 3);
      localObject1 = FaceDrawable.getFaceDrawable((AppInterface)((QBaseActivity)localObject1).getAppRuntime(), 1, (String)localObject2, 3, localDrawable, localDrawable, null);
      a(this.q.obtainMessage(12, localObject1));
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
  
  void F()
  {
    ThemeBackground.a(super.C().getAppRuntime(), this.a, 0, 0, "-conversation-");
  }
  
  public void J()
  {
    this.q.removeMessages(10);
    this.q.removeMessages(11);
    Object localObject = this.af;
    if (localObject != null)
    {
      localObject = ((View)localObject).getAnimation();
      if (localObject != null) {
        ((Animation)localObject).setAnimationListener(null);
      }
      this.af.clearAnimation();
      this.af.setVisibility(0);
      this.af.invalidate();
    }
  }
  
  public void K()
  {
    if (((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getSelfExtOnlineStatus(this.A) == 1080L) {
      ThreadManager.getSubThreadHandler().post(new FrameHelperActivity.20(this));
    }
  }
  
  protected void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = this.aj;
    if (localObject != null) {
      ((IAccountPanel)localObject).a(paramInt1, paramInt2, paramIntent);
    }
    localObject = this.ah;
    if ((localObject != null) && (this.l != null) && (((DrawerFrame)localObject).j()))
    {
      this.l.a(paramInt1, paramInt2, paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "[setDrawerBg(app)]from doOnActivityResult");
      }
      this.q.sendEmptyMessage(14);
      return;
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject3 = C();
    Object localObject1 = null;
    Object localObject2 = null;
    if ((localObject3 != null) && (C().getAppRuntime() != null))
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
        localObject1 = (QQAppInterface)C().getAppRuntime();
        localObject2 = C().getAppRuntime().getCurrentUin();
        localObject3 = this.ad;
        if ((localObject3 != null) && (((RedTouch)localObject3).h())) {
          paramBoolean = bool;
        } else {
          paramBoolean = false;
        }
        int m = VipInfoHandler.a((QQAppInterface)localObject1, (String)localObject2, paramBoolean);
        ReportController.b(C().getAppRuntime(), "dc00898", "", "", "0X800ABB1", "0X800ABB1", m, 0, "0", "0", "", "");
        localObject1 = "0X800402E";
      }
      else
      {
        localObject1 = "0X800402F";
      }
      if (localObject1 != null) {
        ReportController.b(C().getAppRuntime(), "CliOper", "", "", (String)localObject1, (String)localObject1, paramInt2, 0, "", "", "", "");
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
      ((StringBuilder)localObject2).append(C());
      ((StringBuilder)localObject2).append(" app = ");
      if (C() != null) {
        localObject1 = C().getAppRuntime();
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
    ChatBackgroundManager.j();
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("unreadcount", 4).edit();
    localEditor.putInt("unread", 0);
    localEditor.apply();
    paramQQAppInterface.logout(true);
    if (GlobalImageCache.a != null) {
      GlobalImageCache.a.evictAll();
    }
    int m = QQSettingUtil.a(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    QQSettingUtil.a(paramActivity, paramQQAppInterface.getCurrentAccountUin(), m + 1);
    RouteUtils.a(paramActivity, localIntent, "/base/login");
    if (QQPlayerService.b())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast(paramQQAppInterface);
    }
    paramActivity.finish();
  }
  
  public void a(FrameHelperActivity.DrawerListener paramDrawerListener)
  {
    this.ax = paramDrawerListener;
    if ((this.ah != null) && (paramDrawerListener != null)) {
      paramDrawerListener.g(true);
    }
  }
  
  public void a(FrameHelperActivity.QQSettingMeListener paramQQSettingMeListener)
  {
    this.l = paramQQSettingMeListener;
  }
  
  public void a(Card paramCard)
  {
    Object localObject1 = C();
    if ((localObject1 != null) && (((QBaseActivity)localObject1).getAppRuntime() != null) && (ThemeUtil.isNowThemeIsDefault(C().getAppRuntime(), true, null)) && (paramCard != null))
    {
      if (this.l == null) {
        return;
      }
      localObject1 = (QQAppInterface)((QBaseActivity)localObject1).getAppRuntime();
      RandomCoverView localRandomCoverView = (RandomCoverView)this.ai.findViewById(2131447715);
      String str = (String)paramCard.getCoverData(0)[0];
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[getCoverData] getCovertUrl from net,url:");
        ((StringBuilder)localObject2).append(str);
        QLog.d("Q.profilecard.", 2, ((StringBuilder)localObject2).toString());
      }
      if ((!TextUtils.isEmpty(str)) && (!DrawerCoverUtil.c()))
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
          this.l.a(false);
          ThreadManager.getUIHandler().post(new FrameHelperActivity.5(this, localRandomCoverView));
          return;
        }
        this.l.a(true);
        ThreadManager.getUIHandler().post(new FrameHelperActivity.6(this, localRandomCoverView));
        if ((this.ah == null) && (QLog.isColorLevel())) {
          QLog.d("Q.recent", 2, new Object[] { "setDrawerBg: mDrawerFrame=null, card", paramCard });
        }
        localObject2 = C();
        FrameHelperActivity.QQSettingMeListener localQQSettingMeListener = this.l;
        DrawerFrame localDrawerFrame = this.ah;
        boolean bool;
        if ((localDrawerFrame != null) && (localDrawerFrame.b())) {
          bool = true;
        } else {
          bool = false;
        }
        this.k = DrawerCoverUtil.a((QBaseActivity)localObject2, (QQAppInterface)localObject1, paramCard, localRandomCoverView, str, localQQSettingMeListener, bool);
        return;
      }
      if (DrawerCoverUtil.c())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "account has logouted,restart to fetch coverUrl");
        }
        DrawerCoverUtil.e();
        this.av = 3;
      }
      a((QQAppInterface)localObject1);
    }
  }
  
  public void a(CircleBoarderImageView paramCircleBoarderImageView, int paramInt)
  {
    if (paramCircleBoarderImageView != null)
    {
      if (!(paramCircleBoarderImageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
        return;
      }
      if (QQTheme.isNowSimpleUI())
      {
        paramCircleBoarderImageView.setBorderWidth(a(1.1F));
        int m = getResources().getColor(2131168092);
        paramCircleBoarderImageView.setBorderColor(m);
        paramCircleBoarderImageView.setFillColor(m);
        localLayoutParams = (RelativeLayout.LayoutParams)paramCircleBoarderImageView.getLayoutParams();
        localLayoutParams.width = a(34.0F);
        localLayoutParams.height = a(19.0F);
        localLayoutParams.rightMargin = a(-21.1F);
        localLayoutParams.bottomMargin = a(-6.1F);
        localLayoutParams.removeRule(1);
        localLayoutParams.addRule(7, paramInt);
        paramCircleBoarderImageView.setLayoutParams(localLayoutParams);
        paramCircleBoarderImageView.setPadding(a(2.0F), a(2.0F), a(20.0F), a(5.0F));
        return;
      }
      paramCircleBoarderImageView.setBorderWidth(0);
      paramCircleBoarderImageView.setFillColor(0);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramCircleBoarderImageView.getLayoutParams();
      localLayoutParams.width = a(24.0F);
      localLayoutParams.height = a(18.0F);
      localLayoutParams.rightMargin = 0;
      localLayoutParams.bottomMargin = a(-2.0F);
      localLayoutParams.removeRule(7);
      localLayoutParams.addRule(1, paramInt);
      paramCircleBoarderImageView.setLayoutParams(localLayoutParams);
      paramCircleBoarderImageView.setPadding(a(2.0F), a(4.0F), a(10.0F), a(2.0F));
    }
  }
  
  public void a(List<RecentBaseData> paramList)
  {
    Object localObject = (FriendsManager)this.A.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Friends localFriends = ((FriendsManager)localObject).m(((RecentBaseData)localIterator.next()).getRecentUserUin());
      if ((localFriends != null) && (localFriends.uExtOnlineStatus == 1080L))
      {
        bool = true;
        break label75;
      }
    }
    boolean bool = false;
    label75:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isNeedGetMedalEvent=");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append(" size=");
    ((StringBuilder)localObject).append(paramList.size());
    QLog.d("Q.recent", 1, ((StringBuilder)localObject).toString());
    if (bool) {
      ((IOnlineStatusService)this.A.getRuntimeService(IOnlineStatusService.class, "")).getOlympicMedalEventReq(false, false);
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    paramLogoutReason = this.b;
    if (paramLogoutReason != null) {
      paramLogoutReason.a();
    }
  }
  
  protected void a(boolean paramBoolean) {}
  
  public boolean a(Message paramMessage)
  {
    if (!this.h)
    {
      if (C() == null) {
        return false;
      }
      switch (paramMessage.what)
      {
      case 7: 
      case 8: 
      case 15: 
      case 16: 
      case 18: 
      default: 
        return false;
      case 19: 
        U();
        return false;
      case 17: 
        c();
        return false;
      case 14: 
        a((QQAppInterface)C().getAppRuntime());
        return false;
      case 13: 
        Q();
        return false;
      case 12: 
        b(paramMessage);
        return false;
      case 11: 
        f();
        return false;
      case 10: 
        g();
        return false;
      case 9: 
        h();
        return false;
      case 6: 
        n();
        return false;
      case 5: 
        i();
        return false;
      case 4: 
        m();
        return false;
      case 3: 
        E();
        return false;
      case 2: 
        c(paramMessage);
        return false;
      }
      j();
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    View localView = this.af;
    if (localView != null) {
      localView.setVisibility(paramInt);
    }
  }
  
  public void b(String paramString)
  {
    IOnLineStatusPresenter localIOnLineStatusPresenter = this.b;
    if (localIOnLineStatusPresenter != null) {
      localIOnLineStatusPresenter.a(paramString);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    ar = paramBoolean;
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.af == null) {
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
      if (this.ag == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "create new mask");
        }
        localObject = this.af.getContext();
        if (localObject == null) {
          return;
        }
        int n = AIOUtils.b(37.0F, getResources());
        int i1 = AIOUtils.b(60.0F, getResources());
        int m = AIOUtils.b(12.0F, getResources());
        this.ag = new RelativeLayout((Context)localObject);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i1, i1);
        localLayoutParams.addRule(9, -1);
        localLayoutParams.addRule(15, -1);
        this.ag.setLayoutParams(localLayoutParams);
        this.ag.setBackgroundColor(0);
        this.ag.setClickable(true);
        localObject = new RelativeLayout((Context)localObject);
        n += 2;
        localLayoutParams = new RelativeLayout.LayoutParams(n, n);
        localLayoutParams.addRule(9, -1);
        localLayoutParams.addRule(15, -1);
        localLayoutParams.leftMargin = (m - 1);
        ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
        ((RelativeLayout)localObject).setBackgroundDrawable(this.af.getResources().getDrawable(2130841322));
        this.ag.removeAllViews();
        this.ag.addView((View)localObject);
        localObject = this.af;
        if ((localObject instanceof ViewGroup))
        {
          ((ViewGroup)localObject).addView(this.ag);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "addview error");
        }
      }
    }
    else if (this.ag != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "remove mask");
      }
      localObject = this.af;
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.ag);
      } else if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "removeview error");
      }
      this.ag = null;
    }
  }
  
  public void k()
  {
    f(true);
    P();
    F();
    Object localObject = this.ac;
    RedTouch localRedTouch = this.ad;
    int m;
    if (localRedTouch == null) {
      m = 2131431393;
    } else {
      m = localRedTouch.getId();
    }
    a((CircleBoarderImageView)localObject, m);
    localObject = this.aj;
    if (localObject != null) {
      ((IAccountPanel)localObject).c();
    }
    this.t = SimpleModeHelper.a(this.s, this.t);
    super.k();
  }
  
  protected void o() {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.c)
    {
      this.af.setVisibility(8);
      return;
    }
    paramAnimation = this.d;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.ae;
    boolean bool2 = false;
    if ((paramView == localObject) && (localObject != null))
    {
      if (this.ah == null) {
        b();
      }
      localObject = this.ah;
      if ((localObject != null) && (((DrawerFrame)localObject).b())) {
        this.ah.d();
      }
      ReportController.b(C().getAppRuntime(), "CliOper", "", "", "Setting_tab", "My_settab", O(), 0, "", "", "", "");
      localObject = this.ad;
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((RedTouch)localObject).h())
        {
          if (UpgradeController.b((QQAppInterface)C().getAppRuntime())) {
            ReportController.b(C().getAppRuntime(), "CliOper", "", "", "0X8004DAF", "0X8004DAF", O(), 0, "", "", UpgradeController.k(), "");
          }
          bool1 = true;
        }
      }
      localObject = C().getAppRuntime();
      if (bool1) {
        m = 1;
      } else {
        m = 2;
      }
      ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800A980", "0X800A980", m, 0, "0", "0", "", "");
      int m = VipInfoHandler.a((QQAppInterface)C().getAppRuntime(), C().getAppRuntime().getCurrentUin(), bool1);
      ReportController.b(C().getAppRuntime(), "dc00898", "", "", "0X800ABB0", "0X800ABB0", m, 0, "0", "0", "", "");
      ReportController.b(C().getAppRuntime(), "CliOper", "", "", "0X80072D5", "0X80072D5", 0, 0, "", "", "", "");
      if (bool1) {
        ((IRedTouchManager)this.A.getRuntimeService(IRedTouchManager.class, "")).reportLevelZeroRedInfo(1, 31);
      }
    }
    else if (paramView.getId() == 2131439575)
    {
      localObject = this.aj;
      if ((localObject != null) && (!((IAccountPanel)localObject).isShowing()))
      {
        if ((C().getAppRuntime() != null) && (C().getAppRuntime().getApp() != null))
        {
          localObject = (Vibrator)C().getAppRuntime().getApp().getSystemService("vibrator");
          if (localObject != null) {
            ((Vibrator)localObject).vibrate(new long[] { 0L, 1L, 20L, 21L }, -1);
          }
        }
        ((IOnlineStatusService)this.A.getRuntimeService(IOnlineStatusService.class, "")).getOlympicMedalEventReq(false, true);
        this.aj.show();
        q();
        S();
        ReportController.b(C().getAppRuntime(), "dc00898", "", "", "0X800A999", "0X800A999", 2, 0, "", "", "", "");
        ReportController.b(C().getAppRuntime(), "dc00898", "", "", "0X8009E83", "0X8009E83", 0, 0, "", "", "", "");
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
    FrameHelperActivity.QQSettingMeListener localQQSettingMeListener = this.l;
    if (localQQSettingMeListener != null) {
      localQQSettingMeListener.a(paramConfiguration);
    }
    T();
    H();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.q = new Handler(Looper.getMainLooper(), new FrameHelperActivity.HandlerCallback(this));
    this.h = false;
    a();
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    this.h = true;
    super.onDestroy();
    Object localObject = this.l;
    if (localObject != null) {
      ((FrameHelperActivity.QQSettingMeListener)localObject).c();
    }
    localObject = (IVasQuickUpdateService)C().getAppRuntime().getRuntimeService(IVasQuickUpdateService.class, "");
    if (localObject != null)
    {
      CallBacker localCallBacker = this.k;
      if (localCallBacker != null) {
        ((IVasQuickUpdateService)localObject).removeCallBacker(localCallBacker);
      }
    }
    this.q.removeCallbacksAndMessages(null);
    localObject = this.aj;
    if (localObject != null)
    {
      ((IAccountPanel)localObject).h();
      this.aj = null;
    }
    localObject = this.ab;
    if (localObject != null)
    {
      localObject = ((ImageView)localObject).getDrawable();
      if ((localObject != null) && ((localObject instanceof FaceDrawable))) {
        ((FaceDrawable)localObject).cancel();
      }
    }
    localObject = this.ae;
    if (localObject != null)
    {
      ((View)localObject).setOnClickListener(null);
      this.ae.setOnClickListener(null);
      this.ae.setOnTouchListener(null);
    }
    if ((this.an) && (this.af != null))
    {
      if (Build.VERSION.SDK_INT < 16)
      {
        this.af.getViewTreeObserver().removeGlobalOnLayoutListener(this.ao);
        return;
      }
      this.af.getViewTreeObserver().removeOnGlobalLayoutListener(this.ao);
    }
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    DrawerFrame localDrawerFrame = this.ah;
    if (localDrawerFrame != null) {
      localDrawerFrame.a(paramBoolean);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((SplashActivity.currentFragment != 1) && (!this.X)) {
      return;
    }
    this.g = false;
    Object localObject = this.ah;
    if ((localObject != null) && (((DrawerFrame)localObject).k())) {
      this.ah.c();
    }
    localObject = this.ah;
    if ((localObject != null) && (this.l != null) && (((DrawerFrame)localObject).j()))
    {
      this.l.b();
      localObject = this.l.a(DrawerCoverUtil.a);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "[QQSetting onPause] delay one second  and stop UpSideDown Animation");
        }
        this.q.postDelayed(new FrameHelperActivity.4(this, (UpSideDownDrawable)localObject), 1000L);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.", 2, "[QQSetting onPause] dynamicDrawable is null");
      }
    }
    localObject = this.aj;
    if (localObject != null) {
      ((IAccountPanel)localObject).i();
    }
    ((LocalRedTouchManager)C().getAppRuntime().getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).d(1);
  }
  
  public void onResume()
  {
    super.onResume();
    if (SplashActivity.currentFragment != 1) {
      return;
    }
    this.g = true;
    Object localObject = this.ah;
    if ((localObject != null) && (this.l != null) && (((DrawerFrame)localObject).j()))
    {
      this.l.a();
      E();
      localObject = this.l.a(DrawerCoverUtil.a);
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
    if (this.q.hasMessages(17)) {
      this.q.removeMessages(17);
    }
    this.q.sendEmptyMessageDelayed(17, 200L);
    b("onResume");
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "[QQSetting onResume] updateOnlineStatus");
    }
    localObject = this.aj;
    if (localObject != null) {
      ((IAccountPanel)localObject).j();
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
    if ((SplashActivity.currentFragment != 1) && (!this.X)) {}
  }
  
  public void onTabChanged(String paramString)
  {
    super.onTabChanged(paramString);
    if (paramString.equals(Conversation.class.getName()))
    {
      this.ac.setVisibility(8);
      return;
    }
    this.ac.setVisibility(0);
  }
  
  protected void p() {}
  
  protected void q() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity
 * JD-Core Version:    0.7.0.1
 */