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
import awqx;
import badq;
import baig;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import kur;
import kvq;
import kvr;
import kvs;
import lom;
import loo;
import lop;
import loq;
import lor;
import lou;
import loz;
import lyg;

public class SmallScreenService
  extends BaseSmallScreenService
  implements lom
{
  public static boolean g;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new loo(this);
  WindowManager jdField_a_of_type_AndroidViewWindowManager = null;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  public SmallScreenService.OnSelectMemberActivityIsResumeChangedRunnable a;
  private kur jdField_a_of_type_Kur = new lop(this);
  lou jdField_a_of_type_Lou = null;
  Runnable c;
  boolean h;
  
  public SmallScreenService()
  {
    this.jdField_h_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable = null;
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
          kvq localkvq = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
          if (localkvq.jdField_d_of_type_Int != 1)
          {
            i = j;
            if (localkvq.jdField_d_of_type_Int != 3) {}
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
  
  public void a(int paramInt)
  {
    long l = AudioHelper.b();
    if (QLog.isDevelopLevel()) {
      QLog.w("SmallScreenService", 1, "onVideoNumChanged, videoViewCount[" + this.m + "->" + paramInt + "], seq[" + l + "]");
    }
    this.m = paramInt;
    a(l);
  }
  
  void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenService", 1, "doPhoneStateChange, state[" + paramInt + "], incomingNumber[" + paramString + "], mIsInCall[" + this.jdField_h_of_type_Boolean + "], seq[" + l + "]");
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      a(l);
      return;
      this.jdField_h_of_type_Boolean = false;
      continue;
      this.jdField_h_of_type_Boolean = true;
      continue;
      this.jdField_h_of_type_Boolean = true;
    }
  }
  
  public void a(long paramLong)
  {
    boolean bool9;
    boolean bool3;
    boolean bool4;
    label52:
    boolean bool5;
    label75:
    boolean bool6;
    boolean bool7;
    label119:
    boolean bool1;
    label140:
    boolean bool10;
    int i;
    label175:
    label192:
    Object localObject1;
    int j;
    int k;
    Object localObject2;
    if (!this.jdField_d_of_type_Boolean)
    {
      bool9 = this.jdField_a_of_type_Lou.a.i();
      if (this.m <= 0) {
        break label1200;
      }
      bool3 = true;
      if ((this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getVisibility() != 0) || (!this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a())) {
        break label1206;
      }
      bool4 = true;
      if ((this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getVisibility() != 0) || (!this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a())) {
        break label1212;
      }
      bool5 = true;
      bool6 = false;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        bool6 = lor.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
      }
      this.jdField_f_of_type_Boolean = a();
      if ((!bool3) || (!lor.g())) {
        break label1218;
      }
      bool7 = true;
      if ((bool3) || (!lor.h()) || (!this.jdField_f_of_type_Boolean)) {
        break label1224;
      }
      bool1 = true;
      bool10 = this.jdField_a_of_type_ComTencentAvVideoController.p();
      if ((this.jdField_h_of_type_Boolean) || (!bool6) || (bool10) || (this.jdField_c_of_type_Boolean)) {
        break label1230;
      }
      i = 1;
      if ((i == 0) || ((!bool7) && (!bool1))) {
        break label1235;
      }
      bool2 = true;
      localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
      j = ((kvq)localObject1).jdField_d_of_type_Int;
      k = ((kvq)localObject1).C;
      localObject2 = ((kvq)localObject1).c;
      if ((localObject2 == null) || (!((String)localObject2).startsWith("10-")) || (((kvq)localObject1).jdField_I_of_type_Boolean)) {
        break label1241;
      }
      i = 1;
      label247:
      if ((k != 10) && (i == 0)) {
        break label1735;
      }
      bool1 = false;
    }
    boolean bool8;
    for (boolean bool2 = false;; bool2 = bool8)
    {
      label279:
      Object localObject3;
      if ((j == 1) || (j == 2))
      {
        bool8 = true;
        if (QLog.isColorLevel()) {
          QLog.w("SmallScreenService", 1, "showHideToast, hasVideo[" + bool3 + "], mIsInCall[" + this.jdField_h_of_type_Boolean + "], isOpEnable[" + bool6 + "], isVideoVisible[" + bool4 + "], isAudioVisible[" + bool5 + "], isVideoToastCanShow[" + bool7 + "], isAudioToastCanShow[" + bool2 + "], isToastShow[" + bool1 + "], mIsLock[" + this.jdField_c_of_type_Boolean + "], mIsInit[" + this.jdField_a_of_type_Boolean + "], mIsAppOnForeground[" + this.jdField_f_of_type_Boolean + "], SessionType[" + j + "], relationType[" + k + "], isC2c[" + bool8 + "], isSelectMemberActivityIsResume[" + bool10 + "], mSmallScreenStateBroadcast[" + this.o + "], seq[" + paramLong + "]");
        }
        if ((bool3) && (this.jdField_a_of_type_Boolean)) {
          this.jdField_a_of_type_Boolean = false;
        }
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        localObject3 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        j = 0;
        i = j;
        if (this.jdField_a_of_type_ComTencentAvVideoController.l())
        {
          i = j;
          if (((kvq)localObject1).jdField_a_of_type_Kvs != null)
          {
            i = j;
            if (((kvq)localObject1).jdField_a_of_type_Kvs.a != null)
            {
              i = j;
              if (((kvq)localObject1).jdField_a_of_type_Kvs.a.equals("1")) {
                i = 1;
              }
            }
          }
        }
        if (!this.jdField_f_of_type_Boolean) {
          break label1265;
        }
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
        if (i == 0) {
          break label1252;
        }
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130841663);
        label625:
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = this.jdField_g_of_type_Int;
        ((RelativeLayout.LayoutParams)localObject2).topMargin = this.jdField_h_of_type_Int;
        ((RelativeLayout.LayoutParams)localObject3).bottomMargin = this.k;
        if (QLog.isDevelopLevel()) {
          QLog.w("SmallScreenService", 1, "showHideToast, show mTitleView, seq[" + paramLong + "]");
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.f();
        if (!bool9) {
          break label1383;
        }
        i = lyg.b(this.jdField_a_of_type_Int);
        this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_a_of_type_Int, i);
        label747:
        this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.f();
        if (((!bool7) || (!bool1)) && (bool4)) {
          this.n = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
        }
        if (((!bool2) || (!bool1) || (this.jdField_a_of_type_Boolean)) && (bool5)) {
          this.n = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
        }
        if ((!bool7) || (!bool1)) {
          break label1462;
        }
        if (!this.jdField_b_of_type_Loq.b())
        {
          localObject1 = this.jdField_b_of_type_Loq.a();
          if (this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getRotation() % 2 != 0) {
            break label1401;
          }
          ((WindowManager.LayoutParams)localObject1).width = this.jdField_a_of_type_Int;
          ((WindowManager.LayoutParams)localObject1).height = this.jdField_b_of_type_Int;
          label877:
          localObject2 = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a(this.n);
          ((WindowManager.LayoutParams)localObject1).x = ((Point)localObject2).x;
          ((WindowManager.LayoutParams)localObject1).y = ((Point)localObject2).y;
          a();
        }
        if (bool4) {
          break label1726;
        }
        this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(this.n);
        this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.d();
        if (QLog.isDevelopLevel()) {
          QLog.w("SmallScreenService", 1, "showHideToast, show mVideoToastView, seq[" + paramLong + "]");
        }
        localObject3 = "0X80057E6";
        localObject2 = localObject3;
        if (!bool5) {
          break label1524;
        }
        if (!bool8) {
          break label1422;
        }
        localObject1 = "0X8005A4A";
        localObject2 = localObject3;
      }
      for (;;)
      {
        label1002:
        if ((bool2) && (bool1) && (!this.jdField_a_of_type_Boolean))
        {
          if (!this.jdField_a_of_type_Loq.b()) {
            b();
          }
          if (bool5) {
            break label1607;
          }
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(this.n);
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.d();
          if (QLog.isDevelopLevel()) {
            QLog.w("SmallScreenService", 1, "showHideToast, show mAudioToastView, seq[" + paramLong + "]");
          }
          if (!bool4) {
            break label1607;
          }
          if (bool8)
          {
            localObject1 = "0X8005A4D";
            if (!bool1) {
              break label1610;
            }
            if (this.o != 3) {
              a(paramLong, 3);
            }
          }
        }
        for (;;)
        {
          label1108:
          if (localObject2 != null) {
            awqx.b(null, "CliOper", "", "", (String)localObject2, (String)localObject2, 0, 0, "", "", "", "");
          }
          if (localObject1 != null) {
            awqx.b(null, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
          }
          return;
          label1200:
          bool3 = false;
          break;
          label1206:
          bool4 = false;
          break label52;
          label1212:
          bool5 = false;
          break label75;
          label1218:
          bool7 = false;
          break label119;
          label1224:
          bool1 = false;
          break label140;
          label1230:
          i = 0;
          break label175;
          label1235:
          bool2 = false;
          break label192;
          label1241:
          i = 0;
          break label247;
          bool8 = false;
          break label279;
          label1252:
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130841660);
          break label625;
          label1265:
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
          if (i != 0) {
            this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130841664);
          }
          for (;;)
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            ((RelativeLayout.LayoutParams)localObject2).leftMargin = this.i;
            ((RelativeLayout.LayoutParams)localObject2).topMargin = this.j;
            ((RelativeLayout.LayoutParams)localObject3).bottomMargin = this.l;
            if (!QLog.isDevelopLevel()) {
              break;
            }
            QLog.w("SmallScreenService", 1, "showHideToast, hide mTitleView, seq[" + paramLong + "]");
            break;
            this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130841662);
          }
          label1383:
          this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          break label747;
          label1401:
          ((WindowManager.LayoutParams)localObject1).width = this.jdField_b_of_type_Int;
          ((WindowManager.LayoutParams)localObject1).height = this.jdField_a_of_type_Int;
          break label877;
          label1422:
          if (k == 1)
          {
            localObject1 = "0X8005A4C";
            localObject2 = localObject3;
            break label1002;
          }
          localObject2 = localObject3;
          if (k == 2)
          {
            localObject1 = "0X8005A4B";
            localObject2 = localObject3;
            break label1002;
            label1462:
            if (!bool4) {
              break label1726;
            }
            this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.e();
            localObject1 = "0X80057E5";
            localObject2 = localObject1;
            if (QLog.isDevelopLevel())
            {
              QLog.w("SmallScreenService", 1, "showHideToast, hide mVideoToastView, seq[" + paramLong + "]");
              localObject2 = localObject1;
            }
          }
          label1524:
          localObject1 = null;
          break label1002;
          if (k == 1)
          {
            localObject1 = "0X8005A4F";
            break label1108;
          }
          if (k == 2)
          {
            localObject1 = "0X8005A4E";
            break label1108;
            if (bool5)
            {
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.e();
              if (QLog.isDevelopLevel()) {
                QLog.w("SmallScreenService", 1, "showHideToast, hide mAudioToastView, seq[" + paramLong + "]");
              }
            }
          }
          label1607:
          break label1108;
          label1610:
          if ((!bool10) && (!this.jdField_c_of_type_Boolean) && (this.jdField_f_of_type_Boolean) && (this.o != 2)) {
            if (this.o == 1)
            {
              if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null))
              {
                if (this.jdField_c_of_type_JavaLangRunnable == null) {
                  this.jdField_c_of_type_JavaLangRunnable = new SmallScreenService.4(this, paramLong);
                }
                a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
                jdField_g_of_type_Boolean = true;
                a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, a());
              }
            }
            else {
              a(paramLong, 2);
            }
          }
        }
        label1726:
        localObject1 = null;
        localObject2 = null;
      }
      label1735:
      bool8 = bool1;
      bool1 = bool2;
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    jdField_g_of_type_Boolean = false;
    if (this.jdField_c_of_type_JavaLangRunnable != null) {
      a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    }
    if (lor.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt)) {
      this.o = paramInt;
    }
  }
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    this.jdField_a_of_type_Lou.c();
  }
  
  protected boolean a()
  {
    boolean bool2 = true;
    boolean bool3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
    boolean bool1;
    if ((!bool3) || (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenService", 2, "isAppOnForeground result = " + bool1 + ", isQQPaused = " + bool3 + ", isAVPaused = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Pause);
      }
      if (!bool1) {
        break label108;
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
        label108:
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
    this.jdField_a_of_type_Lou.b();
    return true;
  }
  
  void e()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenService", 1, "onOpChanged, mIsOpEnable[" + this.jdField_e_of_type_Boolean + "], seq[" + l + "]");
    }
    a(l);
    if (this.jdField_e_of_type_Boolean)
    {
      str = "0X80057D9";
      awqx.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      if (this.m > 0) {
        if (!this.jdField_e_of_type_Boolean) {
          break label153;
        }
      }
    }
    label153:
    for (String str = "0X80057DA";; str = "0X80057DC")
    {
      awqx.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      return;
      str = "0X80057DB";
      break;
    }
  }
  
  void f()
  {
    super.f();
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenService", 1, "doInitRunnable, start, seq[" + l + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.o()) {
        QLog.w("SmallScreenService", 1, "doInitRunnable, AvActivityIsResume, seq[" + l + "]");
      }
    }
    for (;;)
    {
      return;
      kvq localkvq = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localkvq != null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("SmallScreenService", 1, "InitRunnable, SessionType[" + localkvq.jdField_d_of_type_Int + "], matchStatus[" + localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_Int + "]");
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) {
          localkvq.a(l, "doInitRunnable", 1);
        }
        if ((localkvq.jdField_d_of_type_Int == 1) || (localkvq.jdField_d_of_type_Int == 3) || (localkvq.jdField_a_of_type_Kvr.jdField_b_of_type_Int > 0))
        {
          this.jdField_a_of_type_Boolean = false;
          a(l);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.w("SmallScreenService", 1, "doInitRunnable, end, seq[" + l + "]");
        return;
        if (localkvq.jdField_d_of_type_Int == 4)
        {
          if ((!badq.h(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())) && (!localkvq.ao))
          {
            this.jdField_a_of_type_Boolean = false;
            a(l);
          }
        }
        else if ((localkvq.jdField_d_of_type_Int == 0) && (localkvq.jdField_e_of_type_Boolean) && ((localkvq.jdField_g_of_type_Int == 1) || (localkvq.jdField_g_of_type_Int == 2)))
        {
          int i = localkvq.jdField_f_of_type_Int;
          if ((i == 1) || (i == 2))
          {
            QLog.w("SmallScreenService", 1, "doInitRunnable, sessionInfo.BeginSessionType,[" + i + "]");
            this.jdField_a_of_type_Boolean = false;
            a(l);
            continue;
            if (QLog.isColorLevel())
            {
              QLog.w("SmallScreenService", 1, "doInitRunnable, sessionInfo为空, seq[" + l + "]");
              continue;
              if (QLog.isColorLevel()) {
                QLog.w("SmallScreenService", 1, "doInitRunnable, VideoController为空, seq[" + l + "]");
              }
            }
          }
        }
      }
    }
  }
  
  void g()
  {
    ThreadManager.post(new SmallScreenService.3(this), 10, null, true);
  }
  
  public void onCreate()
  {
    long l = AudioHelper.b();
    QLog.w("SmallScreenService", 1, "avideo onCreate start, seq[" + l + "]");
    super.onCreate();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)this.app);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Kur);
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    a(l, 1);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)getSystemService("window"));
    SharedPreferences localSharedPreferences = baig.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
    if (this.jdField_a_of_type_ComTencentAvVideoController.a()) {}
    for (this.n = localSharedPreferences.getInt("small_window_position_land", 12);; this.n = ((kvq)localObject).jdField_I_of_type_Int)
    {
      ((kvq)localObject).jdField_I_of_type_Int = this.n;
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(this.n);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(this.n);
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable == null)
      {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable = new SmallScreenService.OnSelectMemberActivityIsResumeChangedRunnable(this);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable.a = l;
      }
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.intent.action.NEW_OUTGOING_CALL");
      ((IntentFilter)localObject).addAction("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      this.jdField_h_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c();
      this.jdField_a_of_type_Lou = new lou(this);
      this.jdField_a_of_type_Lou.a(this.app);
      this.jdField_a_of_type_Lou.e();
      this.jdField_a_of_type_Lou.f();
      a(l);
      QLog.d("SmallScreenService", 1, "onCreate end");
      return;
    }
  }
  
  public void onDestroy()
  {
    long l = AudioHelper.b();
    QLog.w("SmallScreenService", 1, "avideo onDestroy start, seq[" + l + "]");
    if (this.m > 0) {}
    for (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_I_of_type_Int = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();; this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_I_of_type_Int = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a())
    {
      g();
      super.onDestroy();
      a(l, 0);
      this.jdField_c_of_type_JavaLangRunnable = null;
      this.jdField_a_of_type_Lou.g();
      this.jdField_a_of_type_Lou.h();
      this.jdField_a_of_type_Lou.a(l);
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Kur);
      this.jdField_a_of_type_Kur = null;
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable = null;
      this.jdField_b_of_type_Loq.b();
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.c();
      this.jdField_b_of_type_Loq = null;
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = null;
      this.jdField_a_of_type_Lou = null;
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenService", 2, "onDestroy end");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenService
 * JD-Core Version:    0.7.0.1
 */