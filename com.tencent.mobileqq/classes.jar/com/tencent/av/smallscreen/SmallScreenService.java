package com.tencent.av.smallscreen;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.SessionInfo.GuildInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.ScreenLayoutDoubleScreen;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import jqq;
import jqr;
import jqs;
import jqt;
import jqu;

public class SmallScreenService
  extends BaseSmallScreenService
  implements SmallScreenRelativeLayout.FloatListener
{
  public static boolean g;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new jqq(this);
  WindowManager jdField_a_of_type_AndroidViewWindowManager = null;
  public VideoController a;
  private GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new jqr(this);
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  SmallScreenVideoController jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController = null;
  Runnable c;
  public Runnable d;
  boolean h;
  
  public SmallScreenService()
  {
    this.jdField_h_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_d_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
  }
  
  int a()
  {
    int j = 1000;
    int i = j;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a() != null)
        {
          SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
          if (localSessionInfo.jdField_d_of_type_Int != 1)
          {
            i = j;
            if (localSessionInfo.jdField_d_of_type_Int != 3) {}
          }
          else
          {
            i = 0;
          }
        }
      }
    }
    return i;
  }
  
  void a(int paramInt)
  {
    this.m = paramInt;
    f();
  }
  
  void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    if (QLog.isColorLevel())
    {
      QLog.d("SmallScreenService", 2, "onCallStateChanged state = " + paramInt);
      QLog.d("SmallScreenService", 2, "onCallStateChanged incomingNumber = " + paramString);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      f();
      return;
      this.jdField_h_of_type_Boolean = false;
      continue;
      this.jdField_h_of_type_Boolean = true;
      continue;
      this.jdField_h_of_type_Boolean = true;
    }
  }
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.c();
  }
  
  protected boolean a()
  {
    boolean bool2 = true;
    boolean bool3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c();
    boolean bool1;
    if ((!bool3) || (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenService", 2, "isAppOnForeground isQQPaused = " + bool3 + ", isAVPaused = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause);
      }
      if (!bool1) {
        break label96;
      }
    }
    for (;;)
    {
      try
      {
        bool3 = GesturePWDUtils.isAppOnForegroundByTasks(this);
        if (!bool3) {
          continue;
        }
        bool1 = bool2;
        bool2 = bool1;
      }
      catch (Exception localException)
      {
        label96:
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SmallScreenService", 2, "isAppOnForeground e = " + localException);
      }
      return bool2;
      bool1 = false;
      break;
      bool1 = false;
    }
    return bool1;
  }
  
  public boolean a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.b();
    return true;
  }
  
  public void b(int paramInt)
  {
    jdField_g_of_type_Boolean = false;
    if (this.jdField_c_of_type_JavaLangRunnable != null) {
      a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    }
    if (SmallScreenUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt)) {
      this.o = paramInt;
    }
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenService", 2, "OnOpChanged mIsOpEnable = " + this.jdField_e_of_type_Boolean);
    }
    f();
    if (this.jdField_e_of_type_Boolean)
    {
      str = "0X80057D9";
      ReportController.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      if (this.m > 0) {
        if (!this.jdField_e_of_type_Boolean) {
          break label116;
        }
      }
    }
    label116:
    for (String str = "0X80057DA";; str = "0X80057DC")
    {
      ReportController.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      return;
      str = "0X80057DB";
      break;
    }
  }
  
  public void f()
  {
    boolean bool8;
    boolean bool3;
    boolean bool4;
    label52:
    boolean bool5;
    label75:
    boolean bool9;
    boolean bool6;
    label95:
    boolean bool1;
    label116:
    boolean bool10;
    int i;
    label151:
    label168:
    Object localObject1;
    int j;
    int k;
    Object localObject2;
    if (!this.jdField_d_of_type_Boolean)
    {
      bool8 = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.a.d();
      if (this.m <= 0) {
        break label1017;
      }
      bool3 = true;
      if ((this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getVisibility() != 0) || (!this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a())) {
        break label1023;
      }
      bool4 = true;
      if ((this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getVisibility() != 0) || (!this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a())) {
        break label1029;
      }
      bool5 = true;
      bool9 = SmallScreenUtils.c(this);
      if ((!bool3) || (!SmallScreenUtils.c())) {
        break label1035;
      }
      bool6 = true;
      if ((bool3) || (!SmallScreenUtils.d()) || (!this.jdField_f_of_type_Boolean)) {
        break label1041;
      }
      bool1 = true;
      bool10 = this.jdField_a_of_type_ComTencentAvVideoController.o();
      if ((this.jdField_h_of_type_Boolean) || (!bool9) || (bool10) || (this.jdField_c_of_type_Boolean)) {
        break label1047;
      }
      i = 1;
      if ((i == 0) || ((!bool6) && (!bool1))) {
        break label1052;
      }
      bool2 = true;
      localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
      j = ((SessionInfo)localObject1).jdField_d_of_type_Int;
      k = ((SessionInfo)localObject1).F;
      localObject2 = ((SessionInfo)localObject1).b;
      if ((localObject2 == null) || (!((String)localObject2).startsWith("10-")) || (((SessionInfo)localObject1).G)) {
        break label1058;
      }
      i = 1;
      label221:
      if ((k != 10) && (i == 0)) {
        break label1421;
      }
      bool1 = false;
    }
    boolean bool7;
    for (boolean bool2 = false;; bool2 = bool7)
    {
      label250:
      RelativeLayout.LayoutParams localLayoutParams;
      if ((j == 1) || (j == 2))
      {
        bool7 = true;
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenService", 2, "showHideToast hasVideo = " + bool3 + ", mIsInCall = " + this.jdField_h_of_type_Boolean + ", isOpEnable = " + bool9 + ", isVideoVisible = " + bool4 + ", isAudioVisible = " + bool5 + ", isSelectMemberActivityIsResume = " + bool10 + ", mIsLock = " + this.jdField_c_of_type_Boolean + ", mIsInit = " + this.jdField_a_of_type_Boolean + ", isAppOnForeground = " + this.jdField_f_of_type_Boolean + ", isVideoToastCanShow = " + bool6 + ", isAudioToastCanShow = " + bool2 + ", isToastShow = " + bool1 + ", SessionType = " + j + ", relationType = " + k + ", isC2c = " + bool7);
        }
        if ((bool3) && (this.jdField_a_of_type_Boolean)) {
          this.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.n = bool1;
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        j = 0;
        i = j;
        if (this.jdField_a_of_type_ComTencentAvVideoController.l())
        {
          i = j;
          if (((SessionInfo)localObject1).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo != null)
          {
            i = j;
            if (((SessionInfo)localObject1).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m != null)
            {
              i = j;
              if (((SessionInfo)localObject1).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m.equals("1")) {
                i = 1;
              }
            }
          }
        }
        if (!this.jdField_f_of_type_Boolean) {
          break label1082;
        }
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
        if (i == 0) {
          break label1069;
        }
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130840341);
        label576:
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = this.jdField_g_of_type_Int;
        ((RelativeLayout.LayoutParams)localObject2).topMargin = this.jdField_h_of_type_Int;
        localLayoutParams.bottomMargin = this.k;
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.f();
        if (!bool8) {
          break label1163;
        }
        i = ScreenLayoutDoubleScreen.b(this.jdField_a_of_type_Int);
        this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_a_of_type_Int, i);
        label661:
        this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.f();
        if (((!bool6) || (!bool1)) && (bool4)) {
          this.n = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
        }
        if (((!bool2) || (!bool1) || (this.jdField_a_of_type_Boolean)) && (bool5)) {
          this.n = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
        }
        if ((!bool6) || (!bool1)) {
          break label1228;
        }
        if (!this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast.b())
        {
          localObject1 = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast.a();
          if (this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getRotation() % 2 != 0) {
            break label1181;
          }
          ((WindowManager.LayoutParams)localObject1).width = this.jdField_a_of_type_Int;
          ((WindowManager.LayoutParams)localObject1).height = this.jdField_b_of_type_Int;
          label791:
          localObject2 = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a(this.n);
          ((WindowManager.LayoutParams)localObject1).x = ((Point)localObject2).x;
          ((WindowManager.LayoutParams)localObject1).y = ((Point)localObject2).y;
          a();
        }
        if (bool4) {
          break label1406;
        }
        this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(this.n);
        this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.d();
        localObject2 = "0X80057E6";
        if (!bool5) {
          break label1415;
        }
        if (!bool7) {
          break label1202;
        }
        localObject1 = "0X8005A4A";
      }
      for (;;)
      {
        label871:
        if ((bool2) && (bool1) && (!this.jdField_a_of_type_Boolean))
        {
          if (!this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.b()) {
            b();
          }
          if (bool5) {
            break label1289;
          }
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(this.n);
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.d();
          if (!bool4) {
            break label1289;
          }
          if (bool7)
          {
            localObject1 = "0X8005A4D";
            if (!bool1) {
              break label1292;
            }
            if (this.o != 3) {
              b(3);
            }
          }
        }
        for (;;)
        {
          label940:
          if (localObject2 != null) {
            ReportController.b(null, "CliOper", "", "", (String)localObject2, (String)localObject2, 0, 0, "", "", "", "");
          }
          if (localObject1 != null) {
            ReportController.b(null, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
          }
          return;
          label1017:
          bool3 = false;
          break;
          label1023:
          bool4 = false;
          break label52;
          label1029:
          bool5 = false;
          break label75;
          label1035:
          bool6 = false;
          break label95;
          label1041:
          bool1 = false;
          break label116;
          label1047:
          i = 0;
          break label151;
          label1052:
          bool2 = false;
          break label168;
          label1058:
          i = 0;
          break label221;
          bool7 = false;
          break label250;
          label1069:
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130840338);
          break label576;
          label1082:
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
          if (i != 0) {
            this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130840342);
          }
          for (;;)
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            ((RelativeLayout.LayoutParams)localObject2).leftMargin = this.i;
            ((RelativeLayout.LayoutParams)localObject2).topMargin = this.j;
            localLayoutParams.bottomMargin = this.l;
            break;
            this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130840340);
          }
          label1163:
          this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          break label661;
          label1181:
          ((WindowManager.LayoutParams)localObject1).width = this.jdField_b_of_type_Int;
          ((WindowManager.LayoutParams)localObject1).height = this.jdField_a_of_type_Int;
          break label791;
          label1202:
          if (k == 1)
          {
            localObject1 = "0X8005A4C";
            break label871;
          }
          if (k != 2) {
            break label1415;
          }
          localObject1 = "0X8005A4B";
          break label871;
          label1228:
          if (!bool4) {
            break label1406;
          }
          this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.e();
          localObject2 = "0X80057E5";
          localObject1 = null;
          break label871;
          if (k == 1)
          {
            localObject1 = "0X8005A4F";
            break label940;
          }
          if (k == 2)
          {
            localObject1 = "0X8005A4E";
            break label940;
            if (bool5) {
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.e();
            }
          }
          label1289:
          break label940;
          label1292:
          if ((!bool10) && (!this.jdField_c_of_type_Boolean) && (this.jdField_f_of_type_Boolean) && (this.o != 2)) {
            if (this.o == 1)
            {
              if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null))
              {
                if (this.jdField_c_of_type_JavaLangRunnable == null) {
                  this.jdField_c_of_type_JavaLangRunnable = new jqt(this);
                }
                a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
                jdField_g_of_type_Boolean = true;
                a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, a());
              }
            }
            else {
              b(2);
            }
          }
        }
        label1406:
        localObject1 = null;
        localObject2 = null;
        continue;
        label1415:
        localObject1 = null;
      }
      label1421:
      bool7 = bool1;
      bool1 = bool2;
    }
  }
  
  void g()
  {
    super.g();
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenService", 2, "InitRunnable.run start");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.n()) {}
    }
    for (;;)
    {
      return;
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localSessionInfo != null)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("SmallScreenService", 2, "InitRunnable.run sessionInfo.SessionType = " + localSessionInfo.jdField_d_of_type_Int);
          QLog.d("SmallScreenService", 2, "InitRunnable.run sessionInfo.mAnychat_Info.matchStatus = " + localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int);
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) {
          localSessionInfo.jdField_d_of_type_Int = 1;
        }
        if ((localSessionInfo.jdField_d_of_type_Int == 1) || (localSessionInfo.jdField_d_of_type_Int == 3) || (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0))
        {
          this.jdField_a_of_type_Boolean = false;
          f();
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("SmallScreenService", 2, "InitRunnable.run end");
        return;
        if ((localSessionInfo.jdField_d_of_type_Int == 4) && (!NetworkUtil.h(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())) && (!localSessionInfo.as))
        {
          this.jdField_a_of_type_Boolean = false;
          f();
          continue;
          if (QLog.isColorLevel())
          {
            QLog.d("SmallScreenService", 2, "InitRunnable.run sessionInfo = null");
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("SmallScreenService", 2, "InitRunnable.run mVideoController = null");
            }
          }
        }
      }
    }
  }
  
  void h()
  {
    ThreadManager.post(new jqs(this), 10, null, true);
  }
  
  public void onCreate()
  {
    QLog.d("SmallScreenService", 1, "avideo onCreate start");
    super.onCreate();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)this.app);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    b(1);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)getSystemService("window"));
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getSharedPreferences("qav_SP", 0);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a()) {}
    for (this.n = localSharedPreferences.getInt("small_window_position_land", 12);; this.n = ((SessionInfo)localObject).J)
    {
      ((SessionInfo)localObject).J = this.n;
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(this.n);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(this.n);
      if (this.jdField_d_of_type_JavaLangRunnable == null) {
        this.jdField_d_of_type_JavaLangRunnable = new jqu(this);
      }
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.intent.action.NEW_OUTGOING_CALL");
      ((IntentFilter)localObject).addAction("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      this.jdField_h_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d();
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController = new SmallScreenVideoController(this);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.a(this.app);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.e();
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.f();
      f();
      QLog.d("SmallScreenService", 1, "onCreate end");
      return;
    }
  }
  
  public void onDestroy()
  {
    QLog.d("SmallScreenService", 1, "avideo [random room owner] onDestroy start");
    if (this.m > 0) {}
    for (this.jdField_a_of_type_ComTencentAvVideoController.a().J = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();; this.jdField_a_of_type_ComTencentAvVideoController.a().J = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a())
    {
      h();
      super.onDestroy();
      b(0);
      this.jdField_c_of_type_JavaLangRunnable = null;
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.g();
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.h();
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.i();
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (this.jdField_d_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver = null;
      this.jdField_d_of_type_JavaLangRunnable = null;
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast.b();
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.c();
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast = null;
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = null;
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController = null;
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenService", 2, "onDestroy end");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenService
 * JD-Core Version:    0.7.0.1
 */