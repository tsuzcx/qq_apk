package com.tencent.av.smallscreen;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import azmj;
import bdee;
import bdiv;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import lhe;
import lid;
import lie;
import lif;
import mbo;
import mbq;
import mbr;
import mbs;
import mbt;
import mbw;
import mcb;
import mlm;
import mls;

public class SmallScreenService
  extends BaseSmallScreenService
  implements mbo
{
  public static boolean g;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new mbq(this);
  WindowManager jdField_a_of_type_AndroidViewWindowManager = null;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  public SmallScreenService.OnSelectMemberActivityIsResumeChangedRunnable a;
  private lhe jdField_a_of_type_Lhe = new mbr(this);
  mbw jdField_a_of_type_Mbw = null;
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
          lid locallid = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
          if (locallid.jdField_d_of_type_Int != 1)
          {
            i = j;
            if (locallid.jdField_d_of_type_Int != 3) {}
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
    boolean bool10;
    boolean bool5;
    boolean bool6;
    label52:
    boolean bool7;
    label75:
    boolean bool2;
    label121:
    int k;
    Object localObject1;
    int i;
    label167:
    label182:
    boolean bool8;
    label204:
    boolean bool3;
    label225:
    boolean bool11;
    label260:
    label277:
    int j;
    Object localObject2;
    if (!this.jdField_d_of_type_Boolean)
    {
      bool10 = this.jdField_a_of_type_Mbw.a.i();
      if (this.m <= 0) {
        break label1285;
      }
      bool5 = true;
      if ((this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getVisibility() != 0) || (!this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a())) {
        break label1291;
      }
      bool6 = true;
      if ((this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getVisibility() != 0) || (!this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a())) {
        break label1297;
      }
      bool7 = true;
      bool2 = false;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
      {
        bool2 = mbt.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
        if ((Build.VERSION.SDK_INT < 21) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().c())) {
          break label1303;
        }
        boolean bool1 = true;
        k = 0;
        localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
        i = k;
        if (((lid)localObject1).J)
        {
          i = k;
          if (((lid)localObject1).jdField_g_of_type_Int == 15) {
            i = 1;
          }
        }
        if (bool1) {
          break label1309;
        }
        bool1 = true;
        if ((!(bool1 & bool2)) || (i != 0)) {
          break label1315;
        }
        bool2 = true;
      }
      this.jdField_f_of_type_Boolean = a();
      if ((!bool5) || (!mbt.g())) {
        break label1321;
      }
      bool8 = true;
      if ((bool5) || (!mbt.h()) || (!this.jdField_f_of_type_Boolean)) {
        break label1327;
      }
      bool3 = true;
      bool11 = this.jdField_a_of_type_ComTencentAvVideoController.p();
      if ((this.jdField_h_of_type_Boolean) || (!bool2) || (bool11) || (this.jdField_c_of_type_Boolean)) {
        break label1333;
      }
      i = 1;
      if ((i == 0) || ((!bool8) && (!bool3))) {
        break label1338;
      }
      bool4 = true;
      localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
      j = ((lid)localObject1).jdField_d_of_type_Int;
      k = ((lid)localObject1).E;
      localObject2 = ((lid)localObject1).c;
      if ((localObject2 == null) || (!((String)localObject2).startsWith("10-")) || (((lid)localObject1).J)) {
        break label1344;
      }
      i = 1;
      label332:
      if ((k != 10) && (i == 0)) {
        break label1838;
      }
      bool3 = false;
    }
    boolean bool9;
    for (boolean bool4 = false;; bool4 = bool9)
    {
      label364:
      Object localObject3;
      if ((j == 1) || (j == 2))
      {
        bool9 = true;
        if (QLog.isColorLevel()) {
          QLog.w("SmallScreenService", 1, "showHideToast, hasVideo[" + bool5 + "], mIsInCall[" + this.jdField_h_of_type_Boolean + "], isOpEnable[" + bool2 + "], isVideoVisible[" + bool6 + "], isAudioVisible[" + bool7 + "], isVideoToastCanShow[" + bool8 + "], isAudioToastCanShow[" + bool4 + "], isToastShow[" + bool3 + "], mIsLock[" + this.jdField_c_of_type_Boolean + "], mIsInit[" + this.jdField_a_of_type_Boolean + "], mIsAppOnForeground[" + this.jdField_f_of_type_Boolean + "], SessionType[" + j + "], relationType[" + k + "], isC2c[" + bool9 + "], isSelectMemberActivityIsResume[" + bool11 + "], mSmallScreenStateBroadcast[" + this.o + "], seq[" + paramLong + "]");
        }
        if ((bool5) && (this.jdField_a_of_type_Boolean)) {
          this.jdField_a_of_type_Boolean = false;
        }
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        localObject3 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        j = 0;
        i = j;
        if (this.jdField_a_of_type_ComTencentAvVideoController.l())
        {
          i = j;
          if (((lid)localObject1).jdField_a_of_type_Lif != null)
          {
            i = j;
            if (((lid)localObject1).jdField_a_of_type_Lif.a != null)
            {
              i = j;
              if (((lid)localObject1).jdField_a_of_type_Lif.a.equals("1")) {
                i = 1;
              }
            }
          }
        }
        if (!this.jdField_f_of_type_Boolean) {
          break label1368;
        }
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
        if (i == 0) {
          break label1355;
        }
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130841908);
        label710:
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
        if (!bool10) {
          break label1486;
        }
        i = mlm.b(this.jdField_a_of_type_Int);
        this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_a_of_type_Int, i);
        label832:
        this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.f();
        if (((!bool8) || (!bool3)) && (bool6)) {
          this.n = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
        }
        if (((!bool4) || (!bool3) || (this.jdField_a_of_type_Boolean)) && (bool7)) {
          this.n = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
        }
        if ((!bool8) || (!bool3)) {
          break label1565;
        }
        if (!this.jdField_b_of_type_Mbs.b())
        {
          localObject1 = this.jdField_b_of_type_Mbs.a();
          if (this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getRotation() % 2 != 0) {
            break label1504;
          }
          ((WindowManager.LayoutParams)localObject1).width = this.jdField_a_of_type_Int;
          ((WindowManager.LayoutParams)localObject1).height = this.jdField_b_of_type_Int;
          label962:
          localObject2 = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a(this.n);
          ((WindowManager.LayoutParams)localObject1).x = ((Point)localObject2).x;
          ((WindowManager.LayoutParams)localObject1).y = ((Point)localObject2).y;
          a();
        }
        if (bool6) {
          break label1829;
        }
        this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(this.n);
        this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.d();
        if (QLog.isDevelopLevel()) {
          QLog.w("SmallScreenService", 1, "showHideToast, show mVideoToastView, seq[" + paramLong + "]");
        }
        localObject3 = "0X80057E6";
        localObject2 = localObject3;
        if (!bool7) {
          break label1627;
        }
        if (!bool9) {
          break label1525;
        }
        localObject1 = "0X8005A4A";
        localObject2 = localObject3;
      }
      for (;;)
      {
        label1087:
        if ((bool4) && (bool3) && (!this.jdField_a_of_type_Boolean))
        {
          if (!this.jdField_a_of_type_Mbs.b()) {
            b();
          }
          if (bool7) {
            break label1710;
          }
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(this.n);
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.d();
          if (QLog.isDevelopLevel()) {
            QLog.w("SmallScreenService", 1, "showHideToast, show mAudioToastView, seq[" + paramLong + "]");
          }
          if (!bool6) {
            break label1710;
          }
          if (bool9)
          {
            localObject1 = "0X8005A4D";
            if (!bool3) {
              break label1713;
            }
            if (this.o != 3) {
              a(paramLong, 3);
            }
          }
        }
        for (;;)
        {
          label1193:
          if (localObject2 != null) {
            azmj.b(null, "CliOper", "", "", (String)localObject2, (String)localObject2, 0, 0, "", "", "", "");
          }
          if (localObject1 != null) {
            azmj.b(null, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
          }
          return;
          label1285:
          bool5 = false;
          break;
          label1291:
          bool6 = false;
          break label52;
          label1297:
          bool7 = false;
          break label75;
          label1303:
          j = 0;
          break label121;
          label1309:
          j = 0;
          break label167;
          label1315:
          bool2 = false;
          break label182;
          label1321:
          bool8 = false;
          break label204;
          label1327:
          bool3 = false;
          break label225;
          label1333:
          i = 0;
          break label260;
          label1338:
          bool4 = false;
          break label277;
          label1344:
          i = 0;
          break label332;
          bool9 = false;
          break label364;
          label1355:
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130841905);
          break label710;
          label1368:
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
          if (i != 0) {
            this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130841909);
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
            this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130841907);
          }
          label1486:
          this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          break label832;
          label1504:
          ((WindowManager.LayoutParams)localObject1).width = this.jdField_b_of_type_Int;
          ((WindowManager.LayoutParams)localObject1).height = this.jdField_a_of_type_Int;
          break label962;
          label1525:
          if (k == 1)
          {
            localObject1 = "0X8005A4C";
            localObject2 = localObject3;
            break label1087;
          }
          localObject2 = localObject3;
          if (k == 2)
          {
            localObject1 = "0X8005A4B";
            localObject2 = localObject3;
            break label1087;
            label1565:
            if (!bool6) {
              break label1829;
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
          label1627:
          localObject1 = null;
          break label1087;
          if (k == 1)
          {
            localObject1 = "0X8005A4F";
            break label1193;
          }
          if (k == 2)
          {
            localObject1 = "0X8005A4E";
            break label1193;
            if (bool7)
            {
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.e();
              if (QLog.isDevelopLevel()) {
                QLog.w("SmallScreenService", 1, "showHideToast, hide mAudioToastView, seq[" + paramLong + "]");
              }
            }
          }
          label1710:
          break label1193;
          label1713:
          if ((!bool11) && (!this.jdField_c_of_type_Boolean) && (this.jdField_f_of_type_Boolean) && (this.o != 2)) {
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
        label1829:
        localObject1 = null;
        localObject2 = null;
      }
      label1838:
      bool9 = bool3;
      bool3 = bool4;
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    jdField_g_of_type_Boolean = false;
    if (this.jdField_c_of_type_JavaLangRunnable != null) {
      a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    }
    if (mbt.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt)) {
      this.o = paramInt;
    }
  }
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    this.jdField_a_of_type_Mbw.c();
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
    this.jdField_a_of_type_Mbw.b();
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
      azmj.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      if (this.m > 0) {
        if (!this.jdField_e_of_type_Boolean) {
          break label153;
        }
      }
    }
    label153:
    for (String str = "0X80057DA";; str = "0X80057DC")
    {
      azmj.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
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
      lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (locallid != null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("SmallScreenService", 1, "InitRunnable, SessionType[" + locallid.jdField_d_of_type_Int + "], matchStatus[" + locallid.jdField_a_of_type_Lie.jdField_b_of_type_Int + "]");
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) {
          locallid.a(l, "doInitRunnable", 1);
        }
        if ((locallid.jdField_d_of_type_Int == 1) || (locallid.jdField_d_of_type_Int == 3) || (locallid.jdField_a_of_type_Lie.jdField_b_of_type_Int > 0))
        {
          this.jdField_a_of_type_Boolean = false;
          a(l);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.w("SmallScreenService", 1, "doInitRunnable, end, seq[" + l + "]");
        return;
        if (locallid.jdField_d_of_type_Int == 4)
        {
          if ((!bdee.h(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())) && (!locallid.ap))
          {
            this.jdField_a_of_type_Boolean = false;
            a(l);
          }
        }
        else if ((locallid.jdField_d_of_type_Int == 0) && (locallid.jdField_e_of_type_Boolean) && ((locallid.jdField_g_of_type_Int == 1) || (locallid.jdField_g_of_type_Int == 2)))
        {
          int i = locallid.jdField_f_of_type_Int;
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
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lhe);
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    a(l, 1);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)getSystemService("window"));
    SharedPreferences localSharedPreferences = bdiv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
    if (this.jdField_a_of_type_ComTencentAvVideoController.b()) {}
    for (this.n = localSharedPreferences.getInt("small_window_position_land", 12);; this.n = ((lid)localObject).K)
    {
      ((lid)localObject).K = this.n;
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
      this.jdField_a_of_type_Mbw = new mbw(this);
      this.jdField_a_of_type_Mbw.a(this.app);
      this.jdField_a_of_type_Mbw.e();
      this.jdField_a_of_type_Mbw.f();
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
    for (this.jdField_a_of_type_ComTencentAvVideoController.a().K = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();; this.jdField_a_of_type_ComTencentAvVideoController.a().K = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a())
    {
      g();
      super.onDestroy();
      a(l, 0);
      this.jdField_c_of_type_JavaLangRunnable = null;
      this.jdField_a_of_type_Mbw.g();
      this.jdField_a_of_type_Mbw.h();
      this.jdField_a_of_type_Mbw.a(l);
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lhe);
      this.jdField_a_of_type_Lhe = null;
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable = null;
      this.jdField_b_of_type_Mbs.b();
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.c();
      this.jdField_b_of_type_Mbs = null;
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = null;
      this.jdField_a_of_type_Mbw = null;
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenService", 2, "onDestroy end");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenService
 * JD-Core Version:    0.7.0.1
 */