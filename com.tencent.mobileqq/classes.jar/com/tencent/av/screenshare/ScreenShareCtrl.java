package com.tencent.av.screenshare;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import bcef;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.utils.PopupDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import lbu;
import lcv;
import lez;
import lvo;
import lvp;
import lvq;
import lvs;
import miz;
import mqq.util.WeakReference;
import mwf;

public class ScreenShareCtrl
{
  private int jdField_a_of_type_Int;
  private final VideoController jdField_a_of_type_ComTencentAvVideoController;
  private ScreenShareCtrl.DoubleMeetingInviteTimeOutTask jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask;
  private ScreenShareCtrl.ShareOpsTimeOutTask jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private lvq jdField_a_of_type_Lvq;
  private WeakReference<AVActivity> jdField_a_of_type_MqqUtilWeakReference;
  private final mwf jdField_a_of_type_Mwf = new mwf();
  private int b;
  
  public ScreenShareCtrl(VideoController paramVideoController)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
  }
  
  private int a(lez paramlez, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvVideoController.a;
    if ((localQQGAudioCtrl == null) || (localVideoAppInterface == null)) {
      return 0;
    }
    if (paramInt1 == 1) {
      paramlez.a("executeShareScreenOps", 1, paramInt2);
    }
    for (;;)
    {
      if (paramInt1 == 2) {
        bool = true;
      }
      if (localQQGAudioCtrl.startOrStopShareSend(bool, paramInt2)) {
        break label112;
      }
      if (paramInt1 != 1) {
        break;
      }
      paramlez.a("executeShareScreenOps", 3, paramInt2);
      return 4;
      if (paramInt1 == 2) {
        paramlez.a("executeShareScreenOps", 4, paramInt2);
      }
    }
    if (paramInt1 == 2)
    {
      paramlez.a("executeShareScreenOps", 6, paramInt2);
      return 4;
      label112:
      if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask != null)
      {
        localVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask);
        this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask = null;
      }
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask = new ScreenShareCtrl.ShareOpsTimeOutTask(this.jdField_a_of_type_ComTencentAvVideoController, paramlez, paramInt1, paramInt2);
      localVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask, 30000L);
      return 1;
    }
    return 4;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaLangRunnable == null)
    {
      this.jdField_a_of_type_JavaLangRunnable = new ScreenShareCtrl.3(this);
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
      localObject = localResources.getString(2131695379);
      continue;
      localObject = localResources.getString(2131695377);
      continue;
      localObject = localResources.getString(2131695380);
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
      lez locallez = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((locallez.ae == 2) || (locallez.ae == 1))
      {
        a(localAVActivity, 1L);
        if (localAVActivity != null) {
          localAVActivity.runOnUiThread(new ScreenShareCtrl.4(this, localAVActivity, locallez));
        }
      }
      return;
    }
  }
  
  public int a(int paramInt)
  {
    int i = 1;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a() == null)
    {
      i = 2;
      return i;
    }
    lez locallez = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "requestShareScreenOps, emShareOps[" + paramInt + "], cur[" + locallez.ae + "," + locallez.af + "]");
    }
    if ((locallez.af != 1) && (locallez.af != 0)) {
      return 3;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      switch (locallez.ae)
      {
      case 1: 
      case 2: 
      default: 
        break;
      case 0: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
        return a(locallez, paramInt, 1);
        switch (locallez.ae)
        {
        }
        break;
      }
    }
    return a(locallez, paramInt, 1);
  }
  
  public lvq a()
  {
    if (this.jdField_a_of_type_Lvq == null) {
      this.jdField_a_of_type_Lvq = new lvq(this);
    }
    return this.jdField_a_of_type_Lvq;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5)
  {
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvVideoController.a;
    if (localVideoAppInterface == null) {
      return;
    }
    lez locallez = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((locallez.F != paramInt3) || (locallez.jdField_g_of_type_Long != paramLong))
    {
      QLog.i("AVShare", 1, "onShareOpsCallback, error session, session[" + locallez + "], [" + paramInt3 + "," + paramLong + "," + paramInt4 + "," + paramInt5 + "], actionResult[" + paramInt1 + "], shareType[" + paramInt2 + "]");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "onShareOpsCallback, session[" + locallez + "], [" + paramInt3 + "," + paramLong + "," + paramInt4 + "," + paramInt5 + "], actionResult[" + paramInt1 + "], shareType[" + paramInt2 + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask != null)
    {
      localVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask);
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask = null;
    }
    paramInt5 = locallez.ae;
    switch (paramInt1)
    {
    default: 
      paramInt1 = paramInt5;
    }
    while (paramInt1 != locallez.ae)
    {
      locallez.a("onShareOpsCallback", paramInt1, paramInt2);
      localVideoAppInterface.a(new Object[] { Integer.valueOf(519), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong), Integer.valueOf(paramInt4) });
      return;
      paramInt1 = paramInt5;
      if (locallez.ae == 1)
      {
        paramInt1 = 2;
        continue;
        paramInt1 = paramInt5;
        if (locallez.ae == 1)
        {
          paramInt1 = 3;
          continue;
          paramInt1 = paramInt5;
          if (locallez.ae == 4)
          {
            paramInt1 = 5;
            continue;
            paramInt1 = paramInt5;
            if (locallez.ae == 4) {
              paramInt1 = 6;
            }
          }
        }
      }
    }
  }
  
  @TargetApi(21)
  public void a(int paramInt, long paramLong, mwf parammwf)
  {
    if (parammwf == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
        } while ((((lez)localObject).F != paramInt) || (((lez)localObject).jdField_g_of_type_Long != paramLong));
        if (QLog.isColorLevel()) {
          QLog.i("AVShare", 2, "onRecSharePushEncParam, param[" + parammwf + "], session[" + localObject + "]");
        }
      } while (((lez)localObject).ae != 2);
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (localObject == null);
    ((miz)localObject).a(parammwf.jdField_a_of_type_Int, parammwf.b, parammwf.c);
  }
  
  public void a(long paramLong)
  {
    lez locallez1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l2;
    int i;
    lez locallez2;
    try
    {
      l1 = Long.parseLong(locallez1.jdField_d_of_type_JavaLangString);
      l2 = l1;
      if (l1 == 0L)
      {
        l2 = l1;
        if (locallez1.jdField_g_of_type_Long != 0L) {
          l2 = locallez1.jdField_g_of_type_Long;
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
        QLog.i("normal_2_meeting", 2, "switchToDoubleMeeting, session[" + locallez1 + "]");
      }
      lbu locallbu = lbu.a();
      i = locallez1.jdField_d_of_type_Int;
      String str1 = locallez1.c;
      String str2 = lbu.a(100, String.valueOf(l2), new int[0]);
      locallez2 = locallbu.a(str2, false);
      locallez2.a(paramLong, locallez1.jdField_j_of_type_Boolean);
      locallez2.jdField_g_of_type_Boolean = locallez1.jdField_g_of_type_Boolean;
      locallez2.aG = locallez1.jdField_j_of_type_Boolean;
      locallez2.b("switchToDoubleMeeting", locallez1.P);
      locallez2.b("switchToDoubleMeeting", locallez1.q);
      locallez2.jdField_d_of_type_JavaLangString = locallez1.jdField_d_of_type_JavaLangString;
      if (TextUtils.isEmpty(locallez2.jdField_d_of_type_JavaLangString)) {
        locallez2.jdField_d_of_type_JavaLangString = String.valueOf(l2);
      }
      locallez2.jdField_e_of_type_JavaLangString = locallez1.jdField_e_of_type_JavaLangString;
      locallez2.D = 8;
      locallez2.aE = true;
      locallez2.F = 3;
      locallez2.jdField_g_of_type_Long = l2;
      locallez2.jdField_j_of_type_Int = 0;
      locallez2.f("switchToDoubleMeeting", true);
      locallez2.b(locallez1.c());
      locallez2.c(locallez1.d());
      locallez2.ad = 5;
      this.jdField_a_of_type_ComTencentAvVideoController.n(true);
      this.jdField_a_of_type_ComTencentAvVideoController.a(locallez1.jdField_d_of_type_JavaLangString, 8);
      this.jdField_a_of_type_ComTencentAvVideoController.b(262);
      this.jdField_a_of_type_ComTencentAvVideoController.b(locallez1.jdField_d_of_type_JavaLangString, 72);
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Int = 3;
      if (locallbu.a(str1))
      {
        boolean bool = locallbu.a(paramLong, str1);
        QLog.i("AVShare", 2, "switchToDoubleMeeting, need double remove. ret[" + bool + "]");
      }
      if (locallbu.a() != locallez2) {
        locallbu.b(str2);
      }
      if (QLog.isColorLevel()) {
        QLog.i("normal_2_meeting", 2, "switchToDoubleMeeting, after close pre one. cur[" + this.jdField_a_of_type_ComTencentAvVideoController.a() + "]");
      }
      locallez2.z = -1;
      if (i != 1) {
        break label571;
      }
    }
    locallez2.a(paramLong, "switchToDoubleMeeting.1", 3);
    for (;;)
    {
      locallez2.jdField_j_of_type_Int = 0;
      locallez2.jdField_g_of_type_Long = l2;
      locallez2.c("switchToDoubleMeeting", 0);
      this.jdField_a_of_type_ComTencentAvVideoController.a.a(new Object[] { Integer.valueOf(174), Long.valueOf(paramLong) });
      return;
      label571:
      if (i == 2) {
        locallez2.a(paramLong, "switchToDoubleMeeting.2", 4);
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
    lez locallez = this.jdField_a_of_type_ComTencentAvVideoController.a();
    localObject = lbu.a().c((String)localObject);
    ((lez)localObject).S = true;
    ((lez)localObject).jdField_f_of_type_Int = 2;
    ((lez)localObject).jdField_f_of_type_JavaLangString = null;
    ((lez)localObject).jdField_e_of_type_Boolean = true;
    ((lez)localObject).s = String.valueOf(paramLong2);
    ((lez)localObject).jdField_d_of_type_JavaLangString = locallez.jdField_d_of_type_JavaLangString;
    ((lez)localObject).jdField_e_of_type_JavaLangString = locallez.jdField_e_of_type_JavaLangString;
    ((lez)localObject).aG = locallez.jdField_j_of_type_Boolean;
    ((lez)localObject).a(paramLong1, false);
    ((lez)localObject).jdField_g_of_type_Boolean = locallez.jdField_g_of_type_Boolean;
    ((lez)localObject).b("onSwitch2DoubleMeeting", locallez.P);
    ((lez)localObject).b("onSwitch2DoubleMeeting", locallez.q);
    ((lez)localObject).aE = true;
    if (locallez.jdField_d_of_type_Int == 1)
    {
      ((lez)localObject).a(paramLong1, "onSwitch2DoubleMeeting.1", 3);
      ((lez)localObject).jdField_j_of_type_Int = locallez.jdField_j_of_type_Int;
      ((lez)localObject).jdField_g_of_type_Long = paramLong2;
      ((lez)localObject).F = 3;
      ((lez)localObject).D = 8;
      ((lez)localObject).e("onSwitch2DoubleMeeting", true);
      ((lez)localObject).f("onSwitch2DoubleMeeting", true);
      ((lez)localObject).a(5, 17);
      ((lez)localObject).a("onSwitch2DoubleMeeting", 2);
      lbu locallbu = lbu.a();
      lcv locallcv = this.jdField_a_of_type_ComTencentAvVideoController.a.a();
      if (locallcv != null) {
        locallcv.a(262);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.b(locallez.jdField_d_of_type_JavaLangString, 72);
      if ((!TextUtils.isEmpty(locallez.c)) && (locallbu.a(locallez.c)))
      {
        boolean bool = locallbu.a(paramLong1, locallez.c);
        if (QLog.isColorLevel()) {
          QLog.i("AVShare", 2, "onSwitch2DoubleMeeting, need double remove ret[" + bool + "]");
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a() != localObject)
      {
        locallbu.b(((lez)localObject).c);
        if (QLog.isColorLevel()) {
          QLog.i("AVShare", 2, "onSwitch2DoubleMeeting, need double set main session. ");
        }
      }
      ((lez)localObject).c("onSwitch2DoubleMeeting", 1);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a.a() <= 0) {
        break label570;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a.a(new Object[] { Integer.valueOf(174), Long.valueOf(paramLong1) });
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(((lez)localObject).c, ((lez)localObject).jdField_d_of_type_Int, false, false, true);
      return;
      ((lez)localObject).a(paramLong1, "onSwitch2DoubleMeeting.2", 4);
      break;
      label570:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a.isBackgroundStop) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong1, 3, paramLong2, new long[] { paramLong2 }, false);
      }
    }
  }
  
  public void a(Bitmap paramBitmap, mwf parammwf)
  {
    if (parammwf == null) {}
    QQGAudioCtrl localQQGAudioCtrl;
    do
    {
      return;
      localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localQQGAudioCtrl == null) {
        break;
      }
      if (!this.jdField_a_of_type_Mwf.equals(parammwf))
      {
        this.jdField_a_of_type_Mwf.a(parammwf);
        localQQGAudioCtrl.setShareEncParam(this.jdField_a_of_type_Mwf, this.jdField_a_of_type_Int, this.b, 1);
      }
    } while (localQQGAudioCtrl.sendShareFrame(paramBitmap, parammwf.jdField_a_of_type_Int, parammwf.b) == 0);
    b(1);
    return;
    b(2);
  }
  
  @TargetApi(21)
  public void a(AVActivity paramAVActivity, long paramLong)
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAVActivity);
      lez locallez = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (QLog.isColorLevel()) {
        QLog.i("AVShare", 2, "startOrStopScreenShare, seq[" + paramLong + "]");
      }
      int i;
      if ((locallez.ae == 2) || (locallez.ae == 1))
      {
        if (a(2) == 1)
        {
          i = 2;
          a(i);
          if (paramAVActivity != null) {
            break label124;
          }
        }
        label124:
        for (paramAVActivity = null;; paramAVActivity = paramAVActivity.a())
        {
          if (paramAVActivity == null) {
            break label130;
          }
          paramAVActivity.a(1);
          return;
          i = 3;
          break;
        }
      }
      else
      {
        label130:
        if (locallez.a(this.jdField_a_of_type_ComTencentAvVideoController.a.getCurrentAccountUin()))
        {
          a(1);
          return;
        }
        if (locallez.y())
        {
          a(8);
          return;
        }
        if ((lvs.a() == 1) || (lvs.a() == 2))
        {
          i = lvs.a();
          PopupDialog.a(paramAVActivity, 230, null, lvs.a(), 2131690620, 2131694201, new lvo(this, i), new lvp(this, i));
          bcef.b(null, "dc00898", "", "", "0X800B48D", "0X800B48D", i, 0, "", "", "", "");
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
  
  public void a(lez paramlez)
  {
    if (paramlez == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "startDoubleMeetingTimeOutTask, info[" + paramlez + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask);
    }
    this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask = new ScreenShareCtrl.DoubleMeetingInviteTimeOutTask(this.jdField_a_of_type_ComTencentAvVideoController, paramlez);
    this.jdField_a_of_type_ComTencentAvVideoController.a.a().postDelayed(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask, 15000L);
  }
  
  public void a(mwf parammwf, int paramInt1, int paramInt2)
  {
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((localQQGAudioCtrl == null) || (parammwf == null)) {
      return;
    }
    this.jdField_a_of_type_Mwf.a(parammwf);
    if (paramInt1 != 0) {
      this.jdField_a_of_type_Int = paramInt1;
    }
    if (paramInt2 != 0) {
      this.b = paramInt2;
    }
    localQQGAudioCtrl.setShareEncParam(this.jdField_a_of_type_Mwf, this.jdField_a_of_type_Int, this.b, 0);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, mwf parammwf)
  {
    if (parammwf == null) {}
    QQGAudioCtrl localQQGAudioCtrl;
    do
    {
      return;
      localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localQQGAudioCtrl == null) {
        break;
      }
      if (!this.jdField_a_of_type_Mwf.equals(parammwf))
      {
        this.jdField_a_of_type_Mwf.a(parammwf);
        localQQGAudioCtrl.setShareEncParam(this.jdField_a_of_type_Mwf, this.jdField_a_of_type_Int, this.b, 1);
      }
    } while (localQQGAudioCtrl.sendShareFrame(paramArrayOfByte, paramInt1, parammwf.jdField_a_of_type_Int, parammwf.b, paramInt2) == 0);
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