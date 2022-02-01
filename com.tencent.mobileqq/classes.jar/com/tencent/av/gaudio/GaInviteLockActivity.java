package com.tencent.av.gaudio;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.QavChannelProxy;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.InviteMemberObserverWithoutCache;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.avatar.QavUpdateAvatarViewHelper;
import com.tencent.av.compat.AVCallCompactHelper;
import com.tencent.av.compat.AVCallCompactJob;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MutiMemberThumbList;
import com.tencent.av.ui.QavInOutAnimation;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.BitmapTools;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.QAVNotificationUtil;
import com.tencent.av.utils.TraeHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mqq.os.MqqHandler;

public class GaInviteLockActivity
  extends GaInviteActivity
{
  Drawable I = null;
  BroadcastReceiver J = null;
  TextView K = null;
  QavPanel L = null;
  QavInOutAnimation M = null;
  MutiMemberThumbList N = null;
  private long O = 0L;
  private MqqHandler P;
  private MqqHandler Q;
  private ArrayList<Memberinfo> R = new ArrayList();
  private AVCallCompactJob S = new AVCallCompactJob();
  private QavUpdateAvatarViewHelper T = null;
  private SmallScreenActivityPlugin U = null;
  private boolean V = false;
  private InviteMemberObserverWithoutCache W = new GaInviteLockActivity.1(this);
  private Runnable X = new GaInviteLockActivity.2(this);
  private GAudioUIObserver Y = new GaInviteLockActivity.3(this);
  private BroadcastReceiver Z = new GaInviteLockActivity.4(this);
  private boolean aa = false;
  private final Runnable ab = new GaInviteLockActivity.11(this);
  private final GaInviteLockActivity.MainThreadRunnableTask ac = new GaInviteLockActivity.MainThreadRunnableTask(this);
  
  private void a(long paramLong, ArrayList<VideoController.GAudioFriends> paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.l, 2, "handleMemberListUpdate");
    }
    if ((paramLong == this.b) && ((paramInt == 10) || (paramInt == 1)))
    {
      this.aa = true;
      b("handleMemberListUpdate");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.l;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendIsResumeBroadcast isResume = ");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.l;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("notifyDataChange mHasCallFromMemberList:=");
      ((StringBuilder)localObject2).append(this.aa);
      ((StringBuilder)localObject2).append(":from=");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    m();
    Object localObject2 = this.f.W();
    paramString = new ArrayList();
    Object localObject1 = new HashSet();
    localObject2 = ((ArrayList)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (VideoController.GAudioFriends)((Iterator)localObject2).next();
      if (((VideoController.GAudioFriends)localObject3).a != this.c) {
        paramString.add(localObject3);
      }
      ((Set)localObject1).add(Long.valueOf(((VideoController.GAudioFriends)localObject3).a));
    }
    int i = paramString.size();
    localObject2 = this.R.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Memberinfo)((Iterator)localObject2).next();
      if (!((Set)localObject1).contains(Long.valueOf(((Memberinfo)localObject3).a)))
      {
        VideoController.GAudioFriends localGAudioFriends = new VideoController.GAudioFriends();
        localGAudioFriends.a = ((Memberinfo)localObject3).a;
        localGAudioFriends.x = ((Memberinfo)localObject3).b;
        if (((Memberinfo)localObject3).a == this.e.getLongAccountUin())
        {
          paramString.add(0, localGAudioFriends);
          i += 1;
        }
        else
        {
          paramString.add(localGAudioFriends);
        }
      }
    }
    ThreadManager.getSubThreadHandler().post(new GaInviteLockActivity.7(this, i, paramString));
  }
  
  private CharSequence c(String paramString)
  {
    String str1 = this.e.getApp().getString(2131893383);
    String str2 = this.e.getApp().getString(2131893382);
    String str3 = this.e.getApp().getString(2131893384);
    int j;
    if (paramString.startsWith(str1)) {
      j = str1.length();
    } else {
      j = -1;
    }
    int i;
    if (paramString.endsWith(str2)) {
      i = paramString.indexOf(str2);
    } else {
      i = -1;
    }
    if (paramString.endsWith(str3)) {
      i = paramString.indexOf(str3);
    }
    if ((j != -1) && (i != -1))
    {
      paramString = new SpannableString(paramString);
      paramString.setSpan(new ForegroundColorSpan(Color.rgb(0, 202, 252)), j, i, 33);
      return paramString;
    }
    return paramString;
  }
  
  private void c(int paramInt)
  {
    boolean bool = this.f.b(this.d, this.b, paramInt);
    if (QLog.isColorLevel())
    {
      String str = this.l;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGAudioRoomMemList ");
      localStringBuilder.append(bool);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (!bool)
    {
      QQToast.makeText(this, HardCodeUtil.a(2131902984), 1).show(getResources().getDimensionPixelSize(2131299920));
      finish();
    }
  }
  
  private void d(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (QAVNotificationUtil.a(paramIntent)) {
      ReportController.b(null, "dc00898", "", "", "0X800A2C5", "0X800A2C5", 0, 0, "", "", "", "");
    }
    long l = QQAudioHelper.d();
    String str1 = paramIntent.getAction();
    Object localObject;
    if ("com.tencent.qav.notify.accept".equals(str1))
    {
      localObject = paramIntent.getStringExtra("session_id");
      if (this.v == null) {
        paramIntent = null;
      } else {
        paramIntent = this.v.f;
      }
      if (TextUtils.equals((CharSequence)localObject, paramIntent))
      {
        if (!o())
        {
          g();
          this.z = true;
        }
        else if (QLog.isColorLevel())
        {
          QLog.i(this.l, 2, "checkParamAndDoAction onPhoneCalling");
        }
      }
      else if (QLog.isColorLevel())
      {
        String str2 = this.l;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkParamAndDoAction not same , coming[");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("], cur[");
        localStringBuilder.append(paramIntent);
        localStringBuilder.append("]");
        QLog.i(str2, 2, localStringBuilder.toString());
      }
      ReportController.b(null, "dc00898", "", "", "0X800A2C6", "0X800A2C6", 0, 0, "", "", "", "");
    }
    else if ("com.tencent.qav.notify.refuse".equals(str1))
    {
      TraeHelper.b(this.e);
      super.a(l);
      this.z = true;
    }
    if (QLog.isColorLevel())
    {
      paramIntent = this.l;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkParamAndDoAction action[");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("], silent[");
      ((StringBuilder)localObject).append(this.z);
      ((StringBuilder)localObject).append("]");
      QLog.i(paramIntent, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean l()
  {
    if (this.e.m())
    {
      DataReport.e(false, true);
      DialogUtil.b(this, this.e.getApp().getString(2131893195), this.e.getApp().getString(2131893193), null, new GaInviteLockActivity.6(this), null);
      return true;
    }
    return false;
  }
  
  private void m()
  {
    MqqHandler localMqqHandler = this.Q;
    if (localMqqHandler != null)
    {
      localMqqHandler.removeCallbacks(this.X);
      this.Q.postDelayed(this.X, 10000L);
    }
  }
  
  private void n()
  {
    QLog.w(this.l, 1, "doAsyncGetHeadImgAndNickName");
    boolean bool = a(null, 1);
    if (this.k != null)
    {
      localObject = Long.toString(this.c);
      this.k.setText((CharSequence)localObject);
    }
    else
    {
      bool = false;
      QLog.w(this.l, 1, "doAsyncGetHeadImgAndNickName[], mCallersName为空");
    }
    Object localObject = this.P;
    if ((localObject != null) && (bool))
    {
      ((MqqHandler)localObject).removeCallbacks(this.ab);
      this.P.post(this.ab);
    }
  }
  
  private boolean o()
  {
    if (this.e.m())
    {
      DataReport.e(false, true);
      if (QLog.isColorLevel()) {
        QLog.d(this.l, 2, "startVideo phone is calling!");
      }
      String str = this.e.getApp().getString(2131893193);
      DialogUtil.b(this, this.e.getApp().getString(2131893195), str, null, new GaInviteLockActivity.9(this), null);
      return true;
    }
    return false;
  }
  
  public void BtnOnClick(View paramView)
  {
    String str;
    if (VideoController.a(this)) {
      str = "1";
    } else {
      str = "2";
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131441182: 
    case 2131441183: 
      ReportController.b(null, "CliOper", "", "", "0X8009E93", "0X8009E93", 0, 0, str, "", "", "");
      this.V = false;
      c(-1037L);
      return;
    case 2131441020: 
      if (QLog.isColorLevel()) {
        QLog.d(this.l, 2, "HIDE");
      }
      onBackPressed();
      return;
    }
    if (o()) {
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8009E94", "0X8009E94", 0, 0, str, "", "", "");
    this.V = true;
    g();
  }
  
  public void c(long paramLong)
  {
    if (SmallScreenUtils.f(this))
    {
      QavInOutAnimation localQavInOutAnimation = this.M;
      if (localQavInOutAnimation != null)
      {
        localQavInOutAnimation.a(new GaInviteLockActivity.8(this, paramLong));
        return;
      }
    }
    super.a(paramLong);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void f()
  {
    k();
    this.j = ((ImageView)super.findViewById(2131441088));
    this.k = ((TextView)super.findViewById(2131441075));
    this.h = ((TextView)super.findViewById(2131441091));
    this.I = BitmapTools.a(super.getApplicationContext(), 2130843118);
    Object localObject = super.findViewById(2131441092);
    Drawable localDrawable = this.I;
    if (localDrawable != null) {
      ((View)localObject).setBackgroundDrawable(localDrawable);
    } else {
      ((View)localObject).setBackgroundResource(2130843118);
    }
    this.K = ((TextView)super.findViewById(2131441100));
    localObject = super.findViewById(2131441291);
    if ((!NetworkUtil.isWifiConnected(super.getApplicationContext())) && ((NetworkUtil.is3Gor4G(super.getApplicationContext())) || (NetworkUtil.isMobileNetWork(super.getApplicationContext()))))
    {
      this.K.setVisibility(0);
      ((View)localObject).setVisibility(0);
      this.K.setText(2131893713);
    }
    this.N = ((MutiMemberThumbList)findViewById(2131441212));
    localObject = this.N;
    if (localObject != null)
    {
      ((MutiMemberThumbList)localObject).setRelationShipInfo(this.b, this.d);
      this.N.setBitMapFetcher(this.e.b());
      this.N.setMoreInfoDrawableColor("#4C000000");
      this.N.setDisPlayList(null);
      int j = this.d;
      int i = 1;
      if (j == 1) {
        i = 10;
      }
      this.O = this.f.a(this.d, i, this.b);
      this.f.n.a(this.b, this.O, true);
      c(i);
    }
    localObject = findViewById(2131428369);
    super.f();
    this.M = new QavInOutAnimation(this, this.f, 1, this.L, null, null, this.j, this.k, (View)localObject, null);
    localObject = this.M;
    if (localObject != null) {
      ((QavInOutAnimation)localObject).a();
    }
  }
  
  void i()
  {
    GInviteTimeOutHelper.a().b();
    boolean bool = VideoController.a(this);
    if ((SmallScreenUtils.f(this)) && (!bool))
    {
      QavInOutAnimation localQavInOutAnimation = this.M;
      if (localQavInOutAnimation != null)
      {
        localQavInOutAnimation.a(new GaInviteLockActivity.10(this));
        return;
      }
    }
    super.i();
  }
  
  void k()
  {
    boolean bool = VideoController.a(this);
    Object localObject1 = this.L;
    int j = 8;
    if (localObject1 == null)
    {
      this.L = ((QavPanel)super.findViewById(2131441227));
      this.L.a(2131625788);
      this.L.setWaveVisibility(8);
      this.L.a(new GaInviteLockActivity.5(this));
    }
    localObject1 = this.L.findViewById(2131441095);
    Object localObject2 = this.L.findViewById(2131441093);
    int i;
    if (bool) {
      i = 8;
    } else {
      i = 0;
    }
    ((View)localObject1).setVisibility(i);
    if (bool) {
      i = 0;
    } else {
      i = 8;
    }
    ((View)localObject2).setVisibility(i);
    localObject1 = findViewById(2131441020);
    if (bool) {
      i = j;
    } else {
      i = 0;
    }
    ((View)localObject1).setVisibility(i);
    localObject1 = findViewById(2131441088);
    localObject2 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
    float f;
    if (bool) {
      f = 88.0F;
    } else {
      f = 46.0F;
    }
    ((ViewGroup.MarginLayoutParams)localObject2).setMargins(0, ViewUtils.dip2px(f), 0, 0);
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    if ((ThemeUtil.isInNightMode(this.e)) && (!bool)) {
      super.findViewById(2131441224).setVisibility(0);
    }
  }
  
  public void onBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.l, 2, "onBackPressed");
    }
    if (!this.V)
    {
      this.f.p();
      this.f.a(true);
      this.f.h(false);
      SmallScreenActivityPlugin localSmallScreenActivityPlugin = this.U;
      if (localSmallScreenActivityPlugin != null)
      {
        localSmallScreenActivityPlugin.a();
        this.U.a(AudioHelper.c(), false);
      }
      finish();
      overridePendingTransition(0, SmallScreenUtils.a(this.f.k().bB));
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.l, 2, "onCreate");
    }
    AVActivity.a(getWindow(), true);
    if ((!Build.MODEL.equalsIgnoreCase("vivo X9i")) && (!Build.MODEL.equalsIgnoreCase("vivo y55l"))) {
      ImmersiveUtils.setStatusTextColor(true, getWindow());
    } else {
      ImmersiveUtils.setStatusTextColor(false, getWindow());
    }
    this.u = false;
    this.P = ThreadManager.getSubThreadHandler();
    this.Q = ThreadManager.getUIHandler();
    super.setContentView(2131625737);
    super.onCreate(paramBundle);
    if ("onGAudioInvite".equals(a(getIntent()))) {
      GInviteTimeOutHelper.a().a(60000L, this.d, this.b);
    }
    super.overridePendingTransition(2130772286, 0);
    n();
    this.e.a(this.W);
    this.e.a(this.Y);
    registerReceiver(this.Z, new IntentFilter("tencent.video.q2v.GvideoMemInviteUpdate"));
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    this.J = new GaInviteLockActivity.HomeKeyReceiver(this);
    super.registerReceiver(this.J, paramBundle);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(2097152);
    paramBundle = this.f.az();
    if (paramBundle != null) {
      paramBundle.a(getClass().getName(), getIntent());
    }
    d(getIntent());
    if (AVUtil.b())
    {
      if (this.s == null) {
        this.s = QAVNotification.a(this.e);
      }
      this.s.a(this.v.f);
    }
    this.U = SmallScreenActivityPlugin.a(this.e);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.J;
    if (localObject != null)
    {
      super.unregisterReceiver((BroadcastReceiver)localObject);
      this.J = null;
    }
    unregisterReceiver(this.Z);
    localObject = this.N;
    if (localObject != null)
    {
      ((MutiMemberThumbList)localObject).a();
      this.N = null;
    }
    this.e.b(this.W);
    this.e.b(this.Y);
    this.R.clear();
    localObject = this.L;
    if (localObject != null)
    {
      ((QavPanel)localObject).a(-1044L);
      this.L = null;
    }
    localObject = this.M;
    if (localObject != null)
    {
      ((QavInOutAnimation)localObject).b();
      this.M = null;
    }
    localObject = this.Q;
    if (localObject != null)
    {
      ((MqqHandler)localObject).removeCallbacks(this.ac);
      this.Q.removeCallbacks(this.X);
      this.Q = null;
    }
    localObject = this.P;
    if (localObject != null)
    {
      ((MqqHandler)localObject).removeCallbacks(this.ab);
      this.P = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      ReportController.b(null, "CliOper", "", "", "0X800420F", "0X800420F", 0, 0, "", "", "", "");
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    QLog.d(this.l, 1, "onNewIntent()");
    d(paramIntent);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.S.a(this.e, this.f);
    a(false);
    if (!this.C) {
      ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 50, 1);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplicationImpl.getContext(), 50, 0);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 50, 1);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplicationImpl.getContext(), 50, 2);
    a(true);
    k();
    if (this.v != null) {
      this.f.a(GaInviteLockActivity.class);
    }
    this.S.a(this, this.e, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity
 * JD-Core Version:    0.7.0.1
 */