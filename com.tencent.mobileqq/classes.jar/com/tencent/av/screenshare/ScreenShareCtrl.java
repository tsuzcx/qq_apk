package com.tencent.av.screenshare;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.VideoConstants.EmShareOps;
import com.tencent.av.VideoConstants.EmShareOpsRet;
import com.tencent.av.VideoConstants.EmShareState;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.ui.AVActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import lbu;
import lcu;
import ley;
import lvj;
import lvl;
import miu;
import mqq.util.WeakReference;

public class ScreenShareCtrl
{
  private int jdField_a_of_type_Int;
  private final VideoController jdField_a_of_type_ComTencentAvVideoController;
  private ScreenShareCtrl.DoubleMeetingInviteTimeOutTask jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask;
  private ScreenShareCtrl.ShareOpsTimeOutTask jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private final lvj jdField_a_of_type_Lvj = new lvj();
  private lvl jdField_a_of_type_Lvl;
  private WeakReference<AVActivity> jdField_a_of_type_MqqUtilWeakReference;
  private int b;
  
  public ScreenShareCtrl(VideoController paramVideoController)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
  }
  
  private VideoConstants.EmShareOpsRet a(ley paramley, VideoConstants.EmShareOps paramEmShareOps, int paramInt)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a;
    if ((localObject2 == null) || (localObject1 == null)) {
      localObject1 = VideoConstants.EmShareOpsRet.UNKNOWN;
    }
    label124:
    do
    {
      return localObject1;
      VideoConstants.EmShareOpsRet localEmShareOpsRet = VideoConstants.EmShareOpsRet.UNKNOWN;
      if (paramEmShareOps == VideoConstants.EmShareOps.START)
      {
        paramley.a("executeShareScreenOps", VideoConstants.EmShareState.REQUESTING_START, paramInt);
        if (paramEmShareOps != VideoConstants.EmShareOps.STOP) {
          break label124;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if (((QQGAudioCtrl)localObject2).startOrStopShareSend(bool, paramInt)) {
          break label154;
        }
        localObject2 = VideoConstants.EmShareOpsRet.REQUESTING_FAIL;
        if (paramEmShareOps != VideoConstants.EmShareOps.START) {
          break label130;
        }
        paramley.a("executeShareScreenOps", VideoConstants.EmShareState.START_FAIL, paramInt);
        return localObject2;
        if (paramEmShareOps != VideoConstants.EmShareOps.STOP) {
          break;
        }
        paramley.a("executeShareScreenOps", VideoConstants.EmShareState.REQUESTING_STOP, paramInt);
        break;
      }
      localObject1 = localObject2;
    } while (paramEmShareOps != VideoConstants.EmShareOps.STOP);
    label130:
    paramley.a("executeShareScreenOps", VideoConstants.EmShareState.STOP_FAIL, paramInt);
    return localObject2;
    label154:
    localObject2 = VideoConstants.EmShareOpsRet.SUC;
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask != null)
    {
      ((VideoAppInterface)localObject1).a().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask);
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask = null;
    }
    this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask = new ScreenShareCtrl.ShareOpsTimeOutTask(this.jdField_a_of_type_ComTencentAvVideoController, paramley, paramEmShareOps, paramInt);
    ((VideoAppInterface)localObject1).a().postDelayed(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask, 30000L);
    return localObject2;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaLangRunnable == null)
    {
      this.jdField_a_of_type_JavaLangRunnable = new ScreenShareCtrl.1(this);
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a != null) && (this.jdField_a_of_type_JavaLangRunnable != null)) {
        this.jdField_a_of_type_ComTencentAvVideoController.a.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 20000L);
      }
    }
  }
  
  public static void a(int paramInt)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Resources localResources = localBaseApplication.getResources();
    Object localObject = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        QQToast.a(localBaseApplication, -1, (CharSequence)localObject, 0).a();
      }
      return;
      localObject = localResources.getString(2131695197);
      continue;
      localObject = localResources.getString(2131695195);
      continue;
      localObject = localResources.getString(2131695198);
    }
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "stopShareScreen, from[" + paramInt + "]");
    }
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {}
    for (AVActivity localAVActivity = null;; localAVActivity = (AVActivity)this.jdField_a_of_type_MqqUtilWeakReference.get())
    {
      ley localley = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((localley.a == VideoConstants.EmShareState.START_SUC) || (localley.a == VideoConstants.EmShareState.REQUESTING_START))
      {
        a(localAVActivity, 1L);
        if (localAVActivity != null) {
          localAVActivity.runOnUiThread(new ScreenShareCtrl.2(this));
        }
      }
      return;
    }
  }
  
  public VideoConstants.EmShareOpsRet a(VideoConstants.EmShareOps paramEmShareOps)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a() == null) {
      return VideoConstants.EmShareOpsRet.CTRL_NULL;
    }
    ley localley = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "requestShareScreenOps, emShareOps[" + paramEmShareOps + "], cur[" + localley.a + "," + localley.ae + "]");
    }
    if ((localley.ae != 1) && (localley.ae != 0)) {
      return VideoConstants.EmShareOpsRet.INVALID_SHARE_TYPE;
    }
    VideoConstants.EmShareOpsRet localEmShareOpsRet = VideoConstants.EmShareOpsRet.UNKNOWN;
    switch (lvk.b[paramEmShareOps.ordinal()])
    {
    default: 
      return localEmShareOpsRet;
    case 1: 
      switch (lvk.a[localley.a.ordinal()])
      {
      default: 
        return localEmShareOpsRet;
      case 1: 
      case 2: 
        return VideoConstants.EmShareOpsRet.SUC;
      }
      return a(localley, paramEmShareOps, 1);
    }
    switch (lvk.a[localley.a.ordinal()])
    {
    default: 
      return localEmShareOpsRet;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
      return a(localley, paramEmShareOps, 1);
    }
    return VideoConstants.EmShareOpsRet.SUC;
  }
  
  public lvl a()
  {
    if (this.jdField_a_of_type_Lvl == null) {
      this.jdField_a_of_type_Lvl = new lvl(this);
    }
    return this.jdField_a_of_type_Lvl;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5)
  {
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvVideoController.a;
    if (localVideoAppInterface == null) {}
    for (;;)
    {
      return;
      ley localley = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((localley.F != paramInt3) || (localley.jdField_g_of_type_Long != paramLong))
      {
        QLog.i("AVShare", 1, "onShareOpsCallback, error session, session[" + localley + "], [" + paramInt3 + "," + paramLong + "," + paramInt4 + "," + paramInt5 + "], actionResult[" + paramInt1 + "], shareType[" + paramInt2 + "]");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AVShare", 2, "onShareOpsCallback, session[" + localley + "], [" + paramInt3 + "," + paramLong + "," + paramInt4 + "," + paramInt5 + "], actionResult[" + paramInt1 + "], shareType[" + paramInt2 + "]");
      }
      if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask != null)
      {
        localVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask);
        this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask = null;
      }
      VideoConstants.EmShareState localEmShareState = localley.a;
      switch (paramInt1)
      {
      }
      while (localEmShareState != localley.a)
      {
        localley.a("onShareOpsCallback", localEmShareState, paramInt2);
        localVideoAppInterface.a(new Object[] { Integer.valueOf(519), localEmShareState, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong), Integer.valueOf(paramInt4) });
        return;
        if (localley.a == VideoConstants.EmShareState.REQUESTING_START)
        {
          localEmShareState = VideoConstants.EmShareState.START_SUC;
          continue;
          if (localley.a == VideoConstants.EmShareState.REQUESTING_START)
          {
            localEmShareState = VideoConstants.EmShareState.START_FAIL;
            continue;
            if (localley.a == VideoConstants.EmShareState.REQUESTING_STOP)
            {
              localEmShareState = VideoConstants.EmShareState.STOP_SUC;
              continue;
              if (localley.a == VideoConstants.EmShareState.REQUESTING_STOP) {
                localEmShareState = VideoConstants.EmShareState.STOP_FAIL;
              }
            }
          }
        }
      }
    }
  }
  
  @TargetApi(21)
  public void a(int paramInt, long paramLong, lvj paramlvj)
  {
    if (paramlvj == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
        } while ((((ley)localObject).F != paramInt) || (((ley)localObject).jdField_g_of_type_Long != paramLong));
        if (QLog.isColorLevel()) {
          QLog.i("AVShare", 2, "onRecSharePushEncParam, param[" + paramlvj + "], session[" + localObject + "]");
        }
      } while (((ley)localObject).a != VideoConstants.EmShareState.START_SUC);
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (localObject == null);
    ((miu)localObject).a(paramlvj.jdField_a_of_type_Int, paramlvj.b, paramlvj.c);
  }
  
  public void a(long paramLong)
  {
    ley localley1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l2;
    int i;
    ley localley2;
    try
    {
      l1 = Long.parseLong(localley1.jdField_d_of_type_JavaLangString);
      l2 = l1;
      if (l1 == 0L)
      {
        l2 = l1;
        if (localley1.jdField_g_of_type_Long != 0L) {
          l2 = localley1.jdField_g_of_type_Long;
        }
      }
      if (l2 == 0L)
      {
        QLog.i("normal_2_meeting", 1, "switchToDoubleMeeting relationId illegal.");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        long l1 = 0L;
      }
      if (QLog.isColorLevel()) {
        QLog.i("normal_2_meeting", 2, "switchToDoubleMeeting, session[" + localley1 + "]");
      }
      lbu locallbu = lbu.a();
      i = localley1.jdField_d_of_type_Int;
      String str1 = localley1.c;
      String str2 = lbu.a(100, String.valueOf(l2), new int[0]);
      localley2 = locallbu.a(str2, false);
      localley2.a(paramLong, localley1.jdField_j_of_type_Boolean);
      localley2.jdField_g_of_type_Boolean = localley1.jdField_g_of_type_Boolean;
      localley2.aG = localley1.jdField_j_of_type_Boolean;
      localley2.b("switchToDoubleMeeting", localley1.P);
      localley2.b("switchToDoubleMeeting", localley1.q);
      localley2.jdField_d_of_type_JavaLangString = localley1.jdField_d_of_type_JavaLangString;
      if (TextUtils.isEmpty(localley2.jdField_d_of_type_JavaLangString)) {
        localley2.jdField_d_of_type_JavaLangString = String.valueOf(l2);
      }
      localley2.jdField_e_of_type_JavaLangString = localley1.jdField_e_of_type_JavaLangString;
      localley2.D = 8;
      localley2.aE = true;
      localley2.F = 3;
      localley2.jdField_g_of_type_Long = l2;
      localley2.jdField_j_of_type_Int = 0;
      localley2.f("switchToDoubleMeeting", true);
      localley2.b(localley1.c());
      localley2.c(localley1.d());
      localley2.ad = 5;
      this.jdField_a_of_type_ComTencentAvVideoController.n(true);
      this.jdField_a_of_type_ComTencentAvVideoController.a(localley1.jdField_d_of_type_JavaLangString, 8);
      this.jdField_a_of_type_ComTencentAvVideoController.b(262);
      this.jdField_a_of_type_ComTencentAvVideoController.b(localley1.jdField_d_of_type_JavaLangString, 72);
      this.jdField_a_of_type_ComTencentAvVideoController.e = 3;
      if (locallbu.a(str1))
      {
        boolean bool = locallbu.a(paramLong, str1);
        QLog.i("AVShare", 2, "switchToDoubleMeeting, need double remove. ret[" + bool + "]");
      }
      if (locallbu.a() != localley2) {
        locallbu.b(str2);
      }
      if (QLog.isColorLevel()) {
        QLog.i("normal_2_meeting", 2, "switchToDoubleMeeting, after close pre one. cur[" + this.jdField_a_of_type_ComTencentAvVideoController.a() + "]");
      }
      localley2.z = -1;
      if (i != 1) {
        break label571;
      }
    }
    localley2.a(paramLong, "switchToDoubleMeeting.1", 3);
    for (;;)
    {
      localley2.jdField_j_of_type_Int = 0;
      localley2.jdField_g_of_type_Long = l2;
      localley2.c("switchToDoubleMeeting", 0);
      this.jdField_a_of_type_ComTencentAvVideoController.a.a(new Object[] { Integer.valueOf(174), Long.valueOf(paramLong) });
      return;
      label571:
      if (i == 2) {
        localley2.a(paramLong, "switchToDoubleMeeting.2", 4);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("normal_2_meeting", 2, "onSwitch2DoubleMeeting, seq[" + paramLong1 + "], uin[" + paramLong2 + "], avtype[" + paramInt1 + "], subType[" + paramInt2 + "]");
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    Object localObject = lbu.a(100, String.valueOf(paramLong2), new int[0]);
    ley localley = this.jdField_a_of_type_ComTencentAvVideoController.a();
    localObject = lbu.a().c((String)localObject);
    ((ley)localObject).S = true;
    ((ley)localObject).jdField_f_of_type_Int = 2;
    ((ley)localObject).jdField_f_of_type_JavaLangString = null;
    ((ley)localObject).jdField_e_of_type_Boolean = true;
    ((ley)localObject).s = String.valueOf(paramLong2);
    ((ley)localObject).jdField_d_of_type_JavaLangString = localley.jdField_d_of_type_JavaLangString;
    ((ley)localObject).jdField_e_of_type_JavaLangString = localley.jdField_e_of_type_JavaLangString;
    ((ley)localObject).aG = localley.jdField_j_of_type_Boolean;
    ((ley)localObject).a(paramLong1, false);
    ((ley)localObject).jdField_g_of_type_Boolean = localley.jdField_g_of_type_Boolean;
    ((ley)localObject).b("onSwitch2DoubleMeeting", localley.P);
    ((ley)localObject).b("onSwitch2DoubleMeeting", localley.q);
    ((ley)localObject).aE = true;
    if (localley.jdField_d_of_type_Int == 1)
    {
      ((ley)localObject).a(paramLong1, "onSwitch2DoubleMeeting.1", 3);
      ((ley)localObject).jdField_j_of_type_Int = localley.jdField_j_of_type_Int;
      ((ley)localObject).jdField_g_of_type_Long = paramLong2;
      ((ley)localObject).F = 3;
      ((ley)localObject).D = 8;
      ((ley)localObject).e("onSwitch2DoubleMeeting", true);
      ((ley)localObject).f("onSwitch2DoubleMeeting", true);
      ((ley)localObject).a(5, 17);
      ((ley)localObject).a("onSwitch2DoubleMeeting", 2);
      lbu locallbu = lbu.a();
      lcu locallcu = this.jdField_a_of_type_ComTencentAvVideoController.a.a();
      if (locallcu != null) {
        locallcu.a(262);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.b(localley.jdField_d_of_type_JavaLangString, 72);
      if ((!TextUtils.isEmpty(localley.c)) && (locallbu.a(localley.c)))
      {
        boolean bool = locallbu.a(paramLong1, localley.c);
        if (QLog.isColorLevel()) {
          QLog.i("AVShare", 2, "onSwitch2DoubleMeeting, need double remove ret[" + bool + "]");
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a() != localObject)
      {
        locallbu.b(((ley)localObject).c);
        if (QLog.isColorLevel()) {
          QLog.i("AVShare", 2, "onSwitch2DoubleMeeting, need double set main session. ");
        }
      }
      ((ley)localObject).c("onSwitch2DoubleMeeting", 1);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a.a() <= 0) {
        break label570;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a.a(new Object[] { Integer.valueOf(174), Long.valueOf(paramLong1) });
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(((ley)localObject).c, ((ley)localObject).jdField_d_of_type_Int, false, false, true);
      return;
      ((ley)localObject).a(paramLong1, "onSwitch2DoubleMeeting.2", 4);
      break;
      label570:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a.isBackground_Stop) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong1, 3, paramLong2, new long[] { paramLong2 }, false);
      }
    }
  }
  
  public void a(Bitmap paramBitmap, lvj paramlvj)
  {
    if (paramlvj == null) {}
    QQGAudioCtrl localQQGAudioCtrl;
    do
    {
      return;
      localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localQQGAudioCtrl == null) {
        break;
      }
      if (!this.jdField_a_of_type_Lvj.equals(paramlvj))
      {
        this.jdField_a_of_type_Lvj.a(paramlvj);
        localQQGAudioCtrl.setShareEncParam(this.jdField_a_of_type_Lvj, this.jdField_a_of_type_Int, this.b, 1);
      }
    } while (localQQGAudioCtrl.sendShareFrame(paramBitmap, paramlvj.jdField_a_of_type_Int, paramlvj.b) == 0);
    b(1);
    return;
    b(2);
  }
  
  @TargetApi(21)
  public void a(AVActivity paramAVActivity, long paramLong)
  {
    Object localObject = null;
    int i = 2;
    if (Build.VERSION.SDK_INT < 21) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAVActivity);
      ley localley = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (QLog.isColorLevel()) {
        QLog.i("AVShare", 2, "startOrStopScreenShare, seq[" + paramLong + "]");
      }
      if ((localley.a == VideoConstants.EmShareState.START_SUC) || (localley.a == VideoConstants.EmShareState.REQUESTING_START))
      {
        if (a(VideoConstants.EmShareOps.STOP) == VideoConstants.EmShareOpsRet.SUC)
        {
          a(i);
          if (paramAVActivity != null) {
            break label136;
          }
        }
        label136:
        for (paramAVActivity = localObject;; paramAVActivity = paramAVActivity.a())
        {
          if (paramAVActivity == null) {
            break label142;
          }
          paramAVActivity.a(1);
          return;
          i = 3;
          break;
        }
      }
      else
      {
        label142:
        if (localley.a(this.jdField_a_of_type_ComTencentAvVideoController.a.getCurrentAccountUin()))
        {
          a(1);
          return;
        }
        if (localley.y())
        {
          a(8);
          return;
        }
        if (paramAVActivity == null) {}
        for (paramAVActivity = null; paramAVActivity != null; paramAVActivity = paramAVActivity.a())
        {
          paramAVActivity.a(a());
          paramAVActivity.a(a());
          paramAVActivity.a();
          return;
        }
      }
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    long l = AudioHelper.b();
    paramArrayOfByte = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel()) {
      QLog.w("normal_2_meeting", 2, "onSwitchMeeting, fromUin[" + paramString + "], flag[" + paramLong + "], session[" + paramArrayOfByte + "], seq[" + l + "]");
    }
    if (paramArrayOfByte.J) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(paramArrayOfByte.jdField_d_of_type_JavaLangString))) {
      return;
    }
    paramArrayOfByte.f("onSwitchMeeting", true);
    paramArrayOfByte.jdField_g_of_type_Long = 0L;
    paramArrayOfByte.a(6, 16);
    this.jdField_a_of_type_ComTencentAvVideoController.a.a(new Object[] { Integer.valueOf(174), Long.valueOf(l) });
    a();
  }
  
  public void a(ley paramley)
  {
    if (paramley == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "startDoubleMeetingTimeOutTask, info[" + paramley + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask);
    }
    this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask = new ScreenShareCtrl.DoubleMeetingInviteTimeOutTask(this.jdField_a_of_type_ComTencentAvVideoController, paramley);
    this.jdField_a_of_type_ComTencentAvVideoController.a.a().postDelayed(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask, 15000L);
  }
  
  public void a(lvj paramlvj, int paramInt1, int paramInt2)
  {
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((localQQGAudioCtrl == null) || (paramlvj == null)) {
      return;
    }
    this.jdField_a_of_type_Lvj.a(paramlvj);
    if (paramInt1 != 0) {
      this.jdField_a_of_type_Int = paramInt1;
    }
    if (paramInt2 != 0) {
      this.b = paramInt2;
    }
    localQQGAudioCtrl.setShareEncParam(this.jdField_a_of_type_Lvj, this.jdField_a_of_type_Int, this.b, 0);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, lvj paramlvj)
  {
    if (paramlvj == null) {}
    QQGAudioCtrl localQQGAudioCtrl;
    do
    {
      return;
      localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localQQGAudioCtrl == null) {
        break;
      }
      if (!this.jdField_a_of_type_Lvj.equals(paramlvj))
      {
        this.jdField_a_of_type_Lvj.a(paramlvj);
        localQQGAudioCtrl.setShareEncParam(this.jdField_a_of_type_Lvj, this.jdField_a_of_type_Int, this.b, 1);
      }
    } while (localQQGAudioCtrl.sendShareFrame(paramArrayOfByte, paramInt1, paramlvj.jdField_a_of_type_Int, paramlvj.b, paramInt2) == 0);
    b(3);
    return;
    b(4);
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "removeDoubleMeetingTimeOutTask, info[" + paramLong + "]");
    }
    if ((this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask != null) && (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask.a.jdField_g_of_type_Long == paramLong))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask);
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl
 * JD-Core Version:    0.7.0.1
 */