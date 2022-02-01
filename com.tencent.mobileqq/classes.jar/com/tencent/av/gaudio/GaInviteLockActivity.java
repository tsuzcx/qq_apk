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
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MutiMemberThumbList;
import com.tencent.av.ui.QavInOutAnimation;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.utils.AVUtil;
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
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private InviteMemberObserverWithoutCache jdField_a_of_type_ComTencentAvAppInviteMemberObserverWithoutCache = new GaInviteLockActivity.1(this);
  private QavUpdateAvatarViewHelper jdField_a_of_type_ComTencentAvAvatarQavUpdateAvatarViewHelper = null;
  private AVCallCompactJob jdField_a_of_type_ComTencentAvCompatAVCallCompactJob = new AVCallCompactJob();
  private final GaInviteLockActivity.MainThreadRunnableTask jdField_a_of_type_ComTencentAvGaudioGaInviteLockActivity$MainThreadRunnableTask = new GaInviteLockActivity.MainThreadRunnableTask(this);
  MutiMemberThumbList jdField_a_of_type_ComTencentAvUiMutiMemberThumbList = null;
  QavInOutAnimation jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
  QavPanel jdField_a_of_type_ComTencentAvUiQavPanel = null;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GaInviteLockActivity.2(this);
  private ArrayList<Memberinfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new GaInviteLockActivity.4(this);
  private GAudioUIObserver jdField_b_of_type_ComTencentAvAppGAudioUIObserver = new GaInviteLockActivity.3(this);
  private final Runnable jdField_b_of_type_JavaLangRunnable = new GaInviteLockActivity.11(this);
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  TextView c = null;
  private long d;
  private boolean h = false;
  
  public GaInviteLockActivity()
  {
    this.jdField_d_of_type_Long = 0L;
  }
  
  private CharSequence a(String paramString)
  {
    String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695624);
    String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695623);
    String str3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695625);
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
  
  private void a(long paramLong, ArrayList<VideoController.GAudioFriends> paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "handleMemberListUpdate");
    }
    if ((paramLong == this.jdField_a_of_type_Long) && ((paramInt == 10) || (paramInt == 1)))
    {
      this.h = true;
      b("handleMemberListUpdate");
    }
  }
  
  private void b(int paramInt)
  {
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, paramInt);
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGAudioRoomMemList ");
      localStringBuilder.append(bool);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (!bool)
    {
      QQToast.a(this, HardCodeUtil.a(2131705094), 1).b(getResources().getDimensionPixelSize(2131299168));
      finish();
    }
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("notifyDataChange mHasCallFromMemberList:=");
      ((StringBuilder)localObject2).append(this.h);
      ((StringBuilder)localObject2).append(":from=");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    i();
    Object localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.e();
    paramString = new ArrayList();
    Object localObject1 = new HashSet();
    localObject2 = ((ArrayList)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (VideoController.GAudioFriends)((Iterator)localObject2).next();
      if (((VideoController.GAudioFriends)localObject3).jdField_a_of_type_Long != this.jdField_b_of_type_Long) {
        paramString.add(localObject3);
      }
      ((Set)localObject1).add(Long.valueOf(((VideoController.GAudioFriends)localObject3).jdField_a_of_type_Long));
    }
    int i = paramString.size();
    localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Memberinfo)((Iterator)localObject2).next();
      if (!((Set)localObject1).contains(Long.valueOf(((Memberinfo)localObject3).jdField_a_of_type_Long)))
      {
        VideoController.GAudioFriends localGAudioFriends = new VideoController.GAudioFriends();
        localGAudioFriends.jdField_a_of_type_Long = ((Memberinfo)localObject3).jdField_a_of_type_Long;
        localGAudioFriends.e = ((Memberinfo)localObject3).jdField_b_of_type_Long;
        if (((Memberinfo)localObject3).jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin())
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
  
  private void c(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (QAVNotificationUtil.a(paramIntent)) {
      ReportController.b(null, "dc00898", "", "", "0X800A2C5", "0X800A2C5", 0, 0, "", "", "", "");
    }
    long l = QQAudioHelper.b();
    String str1 = paramIntent.getAction();
    Object localObject;
    if ("com.tencent.qav.notify.accept".equals(str1))
    {
      localObject = paramIntent.getStringExtra("session_id");
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null) {
        paramIntent = null;
      } else {
        paramIntent = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString;
      }
      if (TextUtils.equals((CharSequence)localObject, paramIntent))
      {
        if (!e())
        {
          d();
          this.jdField_d_of_type_Boolean = true;
        }
        else if (QLog.isColorLevel())
        {
          QLog.i(this.jdField_b_of_type_JavaLangString, 2, "checkParamAndDoAction onPhoneCalling");
        }
      }
      else if (QLog.isColorLevel())
      {
        String str2 = this.jdField_b_of_type_JavaLangString;
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
      TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      super.a(l);
      this.jdField_d_of_type_Boolean = true;
    }
    if (QLog.isColorLevel())
    {
      paramIntent = this.jdField_b_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkParamAndDoAction action[");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("], silent[");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
      ((StringBuilder)localObject).append("]");
      QLog.i(paramIntent, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b())
    {
      DataReport.e(false, true);
      DialogUtil.b(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695447), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695445), null, new GaInviteLockActivity.6(this), null);
      return true;
    }
    return false;
  }
  
  private boolean e()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b())
    {
      DataReport.e(false, true);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "startVideo phone is calling!");
      }
      String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695445);
      DialogUtil.b(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695447), str, null, new GaInviteLockActivity.9(this), null);
      return true;
    }
    return false;
  }
  
  private void i()
  {
    MqqHandler localMqqHandler = this.jdField_b_of_type_MqqOsMqqHandler;
    if (localMqqHandler != null)
    {
      localMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
    }
  }
  
  private void j()
  {
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "doAsyncGetHeadImgAndNickName");
    boolean bool = a(null, 1);
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      localObject = Long.toString(this.jdField_b_of_type_Long);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    else
    {
      bool = false;
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "doAsyncGetHeadImgAndNickName[], mCallersName为空");
    }
    Object localObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if ((localObject != null) && (bool))
    {
      ((MqqHandler)localObject).removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_b_of_type_JavaLangRunnable);
    }
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
    case 2131373510: 
    case 2131373511: 
      ReportController.b(null, "CliOper", "", "", "0X8009E93", "0X8009E93", 0, 0, str, "", "", "");
      c(-1037L);
      return;
    }
    if (e()) {
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8009E94", "0X8009E94", 0, 0, str, "", "", "");
    d();
  }
  
  protected void c()
  {
    h();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131373414));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131373401));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131373417));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BitmapTools.a(super.getApplicationContext(), 2130842183);
    Object localObject = super.findViewById(2131373418);
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      ((View)localObject).setBackgroundDrawable(localDrawable);
    } else {
      ((View)localObject).setBackgroundResource(2130842183);
    }
    this.c = ((TextView)super.findViewById(2131373426));
    if ((!NetworkUtil.isWifiConnected(super.getApplicationContext())) && ((NetworkUtil.is3Gor4G(super.getApplicationContext())) || (NetworkUtil.isMobileNetWork(super.getApplicationContext()))))
    {
      this.c.setVisibility(0);
      this.c.setText(2131695951);
    }
    this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList = ((MutiMemberThumbList)findViewById(2131373539));
    localObject = this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList;
    if (localObject != null)
    {
      ((MutiMemberThumbList)localObject).setRelationShipInfo(this.jdField_a_of_type_Long, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setBitMapFetcher(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
      this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setMoreInfoDrawableColor("#4C000000");
      this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setDisPlayList(null);
      int j = this.jdField_b_of_type_Int;
      int i = 1;
      if (j == 1) {
        i = 10;
      }
      this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_b_of_type_Int, i, this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentAvVideoController.a.a(this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, true);
      b(i);
    }
    localObject = findViewById(2131362697);
    super.c();
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = new QavInOutAnimation(this, this.jdField_a_of_type_ComTencentAvVideoController, 1, this.jdField_a_of_type_ComTencentAvUiQavPanel, null, null, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetTextView, (View)localObject, null);
    localObject = this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation;
    if (localObject != null) {
      ((QavInOutAnimation)localObject).a();
    }
  }
  
  public void c(long paramLong)
  {
    if (SmallScreenUtils.f(this))
    {
      QavInOutAnimation localQavInOutAnimation = this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation;
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
  
  void f()
  {
    boolean bool = VideoController.a(this);
    if ((SmallScreenUtils.f(this)) && (!bool))
    {
      QavInOutAnimation localQavInOutAnimation = this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation;
      if (localQavInOutAnimation != null)
      {
        localQavInOutAnimation.a(new GaInviteLockActivity.10(this));
        return;
      }
    }
    super.f();
  }
  
  void h()
  {
    boolean bool = VideoController.a(this);
    Object localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
    int j = 8;
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)super.findViewById(2131373554));
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131559746);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(new GaInviteLockActivity.5(this));
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel.findViewById(2131373421);
    View localView = this.jdField_a_of_type_ComTencentAvUiQavPanel.findViewById(2131373419);
    if (bool) {
      i = 8;
    } else {
      i = 0;
    }
    ((View)localObject).setVisibility(i);
    int i = j;
    if (bool) {
      i = 0;
    }
    localView.setVisibility(i);
    if ((ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) && (!bool)) {
      super.findViewById(2131373551).setVisibility(0);
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
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onCreate");
    }
    AVActivity.a(getWindow(), true);
    if ((!Build.MODEL.equalsIgnoreCase("vivo X9i")) && (!Build.MODEL.equalsIgnoreCase("vivo y55l"))) {
      ImmersiveUtils.setStatusTextColor(true, getWindow());
    } else {
      ImmersiveUtils.setStatusTextColor(false, getWindow());
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
    this.jdField_b_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
    super.setContentView(2131559696);
    super.onCreate(paramBundle);
    j();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppInviteMemberObserverWithoutCache);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_ComTencentAvAppGAudioUIObserver);
    registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, new IntentFilter("tencent.video.q2v.GvideoMemInviteUpdate"));
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new GaInviteLockActivity.HomeKeyReceiver(this);
    super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(2097152);
    paramBundle = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (paramBundle != null) {
      paramBundle.a(getClass().getName(), getIntent());
    }
    c(getIntent());
    if (AVUtil.b())
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.jdField_a_of_type_AndroidContentBroadcastReceiver;
    if (localObject != null)
    {
      super.unregisterReceiver((BroadcastReceiver)localObject);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
    localObject = this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList;
    if (localObject != null)
    {
      ((MutiMemberThumbList)localObject).a();
      this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList = null;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppInviteMemberObserverWithoutCache);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_b_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    localObject = this.jdField_a_of_type_ComTencentAvUiQavPanel;
    if (localObject != null)
    {
      ((QavPanel)localObject).a(-1044L);
      this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation;
    if (localObject != null)
    {
      ((QavInOutAnimation)localObject).b();
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
    }
    localObject = this.jdField_b_of_type_MqqOsMqqHandler;
    if (localObject != null)
    {
      ((MqqHandler)localObject).removeCallbacks(this.jdField_a_of_type_ComTencentAvGaudioGaInviteLockActivity$MainThreadRunnableTask);
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_b_of_type_MqqOsMqqHandler = null;
    }
    localObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localObject != null)
    {
      ((MqqHandler)localObject).removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler = null;
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
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onNewIntent()");
    c(paramIntent);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentAvCompatAVCallCompactJob.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvVideoController);
    if (!this.f) {
      ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 50, 1);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplicationImpl.getContext(), 50, 0);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 50, 1);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplicationImpl.getContext(), 50, 2);
    h();
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(GaInviteLockActivity.class);
    }
    this.jdField_a_of_type_ComTencentAvCompatAVCallCompactJob.a(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvVideoController);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity
 * JD-Core Version:    0.7.0.1
 */