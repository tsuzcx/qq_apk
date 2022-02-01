package com.tencent.av.screenshare;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import bdla;
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
import lbz;
import lda;
import lfe;
import lwb;
import lwc;
import lwd;
import lwf;
import mjw;
import mqq.util.WeakReference;
import nbs;

public class ScreenShareCtrl
{
  private int jdField_a_of_type_Int;
  private final VideoController jdField_a_of_type_ComTencentAvVideoController;
  private ScreenShareCtrl.DoubleMeetingInviteTimeOutTask jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask;
  private ScreenShareCtrl.ShareOpsTimeOutTask jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private lwd jdField_a_of_type_Lwd;
  private WeakReference<AVActivity> jdField_a_of_type_MqqUtilWeakReference;
  private final nbs jdField_a_of_type_Nbs = new nbs();
  private int b;
  
  public ScreenShareCtrl(VideoController paramVideoController)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
  }
  
  private int a(lfe paramlfe, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvVideoController.a;
    if ((localQQGAudioCtrl == null) || (localVideoAppInterface == null)) {
      return 0;
    }
    if (paramInt1 == 1) {
      paramlfe.a("executeShareScreenOps", 1, paramInt2);
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
      paramlfe.a("executeShareScreenOps", 3, paramInt2);
      return 4;
      if (paramInt1 == 2) {
        paramlfe.a("executeShareScreenOps", 4, paramInt2);
      }
    }
    if (paramInt1 == 2)
    {
      paramlfe.a("executeShareScreenOps", 6, paramInt2);
      return 4;
      label112:
      if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask != null)
      {
        localVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask);
        this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask = null;
      }
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask = new ScreenShareCtrl.ShareOpsTimeOutTask(this.jdField_a_of_type_ComTencentAvVideoController, paramlfe, paramInt1, paramInt2);
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
      localObject = localResources.getString(2131695596);
      continue;
      localObject = localResources.getString(2131695594);
      continue;
      localObject = localResources.getString(2131695597);
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
      lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((locallfe.ae == 2) || (locallfe.ae == 1))
      {
        a(localAVActivity, 1L);
        if (localAVActivity != null) {
          localAVActivity.runOnUiThread(new ScreenShareCtrl.4(this, localAVActivity, locallfe));
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
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "requestShareScreenOps, emShareOps[" + paramInt + "], cur[" + locallfe.ae + "," + locallfe.af + "]");
    }
    if ((locallfe.af != 1) && (locallfe.af != 0)) {
      return 3;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      switch (locallfe.ae)
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
        return a(locallfe, paramInt, 1);
        switch (locallfe.ae)
        {
        }
        break;
      }
    }
    return a(locallfe, paramInt, 1);
  }
  
  public lwd a()
  {
    if (this.jdField_a_of_type_Lwd == null) {
      this.jdField_a_of_type_Lwd = new lwd(this);
    }
    return this.jdField_a_of_type_Lwd;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5)
  {
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvVideoController.a;
    if (localVideoAppInterface == null) {
      return;
    }
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((locallfe.F != paramInt3) || (locallfe.jdField_g_of_type_Long != paramLong))
    {
      QLog.i("AVShare", 1, "onShareOpsCallback, error session, session[" + locallfe + "], [" + paramInt3 + "," + paramLong + "," + paramInt4 + "," + paramInt5 + "], actionResult[" + paramInt1 + "], shareType[" + paramInt2 + "]");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "onShareOpsCallback, session[" + locallfe + "], [" + paramInt3 + "," + paramLong + "," + paramInt4 + "," + paramInt5 + "], actionResult[" + paramInt1 + "], shareType[" + paramInt2 + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask != null)
    {
      localVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask);
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask = null;
    }
    paramInt5 = locallfe.ae;
    switch (paramInt1)
    {
    default: 
      paramInt1 = paramInt5;
    }
    while (paramInt1 != locallfe.ae)
    {
      locallfe.a("onShareOpsCallback", paramInt1, paramInt2);
      localVideoAppInterface.a(new Object[] { Integer.valueOf(519), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong), Integer.valueOf(paramInt4) });
      return;
      paramInt1 = paramInt5;
      if (locallfe.ae == 1)
      {
        paramInt1 = 2;
        continue;
        paramInt1 = paramInt5;
        if (locallfe.ae == 1)
        {
          paramInt1 = 3;
          continue;
          paramInt1 = paramInt5;
          if (locallfe.ae == 4)
          {
            paramInt1 = 5;
            continue;
            paramInt1 = paramInt5;
            if (locallfe.ae == 4) {
              paramInt1 = 6;
            }
          }
        }
      }
    }
  }
  
  @TargetApi(21)
  public void a(int paramInt, long paramLong, nbs paramnbs)
  {
    if (paramnbs == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
        } while ((((lfe)localObject).F != paramInt) || (((lfe)localObject).jdField_g_of_type_Long != paramLong));
        if (QLog.isColorLevel()) {
          QLog.i("AVShare", 2, "onRecSharePushEncParam, param[" + paramnbs + "], session[" + localObject + "]");
        }
      } while (((lfe)localObject).ae != 2);
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (localObject == null);
    ((mjw)localObject).a(paramnbs.jdField_a_of_type_Int, paramnbs.b, paramnbs.c);
  }
  
  public void a(long paramLong)
  {
    lfe locallfe1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l2;
    int i;
    lfe locallfe2;
    try
    {
      l1 = Long.parseLong(locallfe1.jdField_d_of_type_JavaLangString);
      l2 = l1;
      if (l1 == 0L)
      {
        l2 = l1;
        if (locallfe1.jdField_g_of_type_Long != 0L) {
          l2 = locallfe1.jdField_g_of_type_Long;
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
        QLog.i("normal_2_meeting", 2, "switchToDoubleMeeting, session[" + locallfe1 + "]");
      }
      lbz locallbz = lbz.a();
      i = locallfe1.jdField_d_of_type_Int;
      String str1 = locallfe1.c;
      String str2 = lbz.a(100, String.valueOf(l2), new int[0]);
      locallfe2 = locallbz.a(str2, false);
      locallfe2.a(paramLong, locallfe1.jdField_j_of_type_Boolean);
      locallfe2.jdField_g_of_type_Boolean = locallfe1.jdField_g_of_type_Boolean;
      locallfe2.aG = locallfe1.jdField_j_of_type_Boolean;
      locallfe2.b("switchToDoubleMeeting", locallfe1.P);
      locallfe2.b("switchToDoubleMeeting", locallfe1.q);
      locallfe2.jdField_d_of_type_JavaLangString = locallfe1.jdField_d_of_type_JavaLangString;
      if (TextUtils.isEmpty(locallfe2.jdField_d_of_type_JavaLangString)) {
        locallfe2.jdField_d_of_type_JavaLangString = String.valueOf(l2);
      }
      locallfe2.jdField_e_of_type_JavaLangString = locallfe1.jdField_e_of_type_JavaLangString;
      locallfe2.D = 8;
      locallfe2.aE = true;
      locallfe2.F = 3;
      locallfe2.jdField_g_of_type_Long = l2;
      locallfe2.jdField_j_of_type_Int = 0;
      locallfe2.f("switchToDoubleMeeting", true);
      locallfe2.b(locallfe1.c());
      locallfe2.c(locallfe1.d());
      locallfe2.ad = 5;
      this.jdField_a_of_type_ComTencentAvVideoController.n(true);
      this.jdField_a_of_type_ComTencentAvVideoController.a(locallfe1.jdField_d_of_type_JavaLangString, 8);
      this.jdField_a_of_type_ComTencentAvVideoController.b(262);
      this.jdField_a_of_type_ComTencentAvVideoController.b(locallfe1.jdField_d_of_type_JavaLangString, 72);
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Int = 3;
      if (locallbz.a(str1))
      {
        boolean bool = locallbz.a(paramLong, str1);
        QLog.i("AVShare", 2, "switchToDoubleMeeting, need double remove. ret[" + bool + "]");
      }
      if (locallbz.a() != locallfe2) {
        locallbz.b(str2);
      }
      if (QLog.isColorLevel()) {
        QLog.i("normal_2_meeting", 2, "switchToDoubleMeeting, after close pre one. cur[" + this.jdField_a_of_type_ComTencentAvVideoController.a() + "]");
      }
      locallfe2.z = -1;
      if (i != 1) {
        break label571;
      }
    }
    locallfe2.a(paramLong, "switchToDoubleMeeting.1", 3);
    for (;;)
    {
      locallfe2.jdField_j_of_type_Int = 0;
      locallfe2.jdField_g_of_type_Long = l2;
      locallfe2.c("switchToDoubleMeeting", 0);
      this.jdField_a_of_type_ComTencentAvVideoController.a.a(new Object[] { Integer.valueOf(174), Long.valueOf(paramLong) });
      return;
      label571:
      if (i == 2) {
        locallfe2.a(paramLong, "switchToDoubleMeeting.2", 4);
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
    Object localObject = lbz.a(100, String.valueOf(paramLong2), new int[0]);
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    localObject = lbz.a().c((String)localObject);
    ((lfe)localObject).S = true;
    ((lfe)localObject).jdField_f_of_type_Int = 2;
    ((lfe)localObject).jdField_f_of_type_JavaLangString = null;
    ((lfe)localObject).jdField_e_of_type_Boolean = true;
    ((lfe)localObject).s = String.valueOf(paramLong2);
    ((lfe)localObject).jdField_d_of_type_JavaLangString = locallfe.jdField_d_of_type_JavaLangString;
    ((lfe)localObject).jdField_e_of_type_JavaLangString = locallfe.jdField_e_of_type_JavaLangString;
    ((lfe)localObject).aG = locallfe.jdField_j_of_type_Boolean;
    ((lfe)localObject).a(paramLong1, false);
    ((lfe)localObject).jdField_g_of_type_Boolean = locallfe.jdField_g_of_type_Boolean;
    ((lfe)localObject).b("onSwitch2DoubleMeeting", locallfe.P);
    ((lfe)localObject).b("onSwitch2DoubleMeeting", locallfe.q);
    ((lfe)localObject).aE = true;
    if (locallfe.jdField_d_of_type_Int == 1)
    {
      ((lfe)localObject).a(paramLong1, "onSwitch2DoubleMeeting.1", 3);
      ((lfe)localObject).jdField_j_of_type_Int = locallfe.jdField_j_of_type_Int;
      ((lfe)localObject).jdField_g_of_type_Long = paramLong2;
      ((lfe)localObject).F = 3;
      ((lfe)localObject).D = 8;
      ((lfe)localObject).e("onSwitch2DoubleMeeting", true);
      ((lfe)localObject).f("onSwitch2DoubleMeeting", true);
      ((lfe)localObject).a(5, 17);
      ((lfe)localObject).a("onSwitch2DoubleMeeting", 2);
      lbz locallbz = lbz.a();
      lda locallda = this.jdField_a_of_type_ComTencentAvVideoController.a.a();
      if (locallda != null) {
        locallda.a(262);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.b(locallfe.jdField_d_of_type_JavaLangString, 72);
      if ((!TextUtils.isEmpty(locallfe.c)) && (locallbz.a(locallfe.c)))
      {
        boolean bool = locallbz.a(paramLong1, locallfe.c);
        if (QLog.isColorLevel()) {
          QLog.i("AVShare", 2, "onSwitch2DoubleMeeting, need double remove ret[" + bool + "]");
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a() != localObject)
      {
        locallbz.b(((lfe)localObject).c);
        if (QLog.isColorLevel()) {
          QLog.i("AVShare", 2, "onSwitch2DoubleMeeting, need double set main session. ");
        }
      }
      ((lfe)localObject).c("onSwitch2DoubleMeeting", 1);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a.a() <= 0) {
        break label570;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a.a(new Object[] { Integer.valueOf(174), Long.valueOf(paramLong1) });
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(((lfe)localObject).c, ((lfe)localObject).jdField_d_of_type_Int, false, false, true);
      return;
      ((lfe)localObject).a(paramLong1, "onSwitch2DoubleMeeting.2", 4);
      break;
      label570:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a.isBackgroundStop) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong1, 3, paramLong2, new long[] { paramLong2 }, false);
      }
    }
  }
  
  public void a(Bitmap paramBitmap, nbs paramnbs)
  {
    if (paramnbs == null) {}
    QQGAudioCtrl localQQGAudioCtrl;
    do
    {
      return;
      localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localQQGAudioCtrl == null) {
        break;
      }
      if (!this.jdField_a_of_type_Nbs.equals(paramnbs))
      {
        this.jdField_a_of_type_Nbs.a(paramnbs);
        localQQGAudioCtrl.setShareEncParam(this.jdField_a_of_type_Nbs, this.jdField_a_of_type_Int, this.b, 1);
      }
    } while (localQQGAudioCtrl.sendShareFrame(paramBitmap, paramnbs.jdField_a_of_type_Int, paramnbs.b) == 0);
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
      lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (QLog.isColorLevel()) {
        QLog.i("AVShare", 2, "startOrStopScreenShare, seq[" + paramLong + "]");
      }
      int i;
      if ((locallfe.ae == 2) || (locallfe.ae == 1))
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
        if (locallfe.a(this.jdField_a_of_type_ComTencentAvVideoController.a.getCurrentAccountUin()))
        {
          a(1);
          return;
        }
        if (locallfe.y())
        {
          a(8);
          return;
        }
        if ((lwf.a() == 1) || (lwf.a() == 2))
        {
          i = lwf.a();
          PopupDialog.a(paramAVActivity, 230, null, lwf.a(), 2131690697, 2131694399, new lwb(this, i), new lwc(this, i));
          bdla.b(null, "dc00898", "", "", "0X800B48D", "0X800B48D", i, 0, "", "", "", "");
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
  
  public void a(lfe paramlfe)
  {
    if (paramlfe == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "startDoubleMeetingTimeOutTask, info[" + paramlfe + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask);
    }
    this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask = new ScreenShareCtrl.DoubleMeetingInviteTimeOutTask(this.jdField_a_of_type_ComTencentAvVideoController, paramlfe);
    this.jdField_a_of_type_ComTencentAvVideoController.a.a().postDelayed(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask, 15000L);
  }
  
  public void a(nbs paramnbs, int paramInt1, int paramInt2)
  {
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((localQQGAudioCtrl == null) || (paramnbs == null)) {
      return;
    }
    this.jdField_a_of_type_Nbs.a(paramnbs);
    if (paramInt1 != 0) {
      this.jdField_a_of_type_Int = paramInt1;
    }
    if (paramInt2 != 0) {
      this.b = paramInt2;
    }
    localQQGAudioCtrl.setShareEncParam(this.jdField_a_of_type_Nbs, this.jdField_a_of_type_Int, this.b, 0);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, nbs paramnbs)
  {
    if (paramnbs == null) {}
    QQGAudioCtrl localQQGAudioCtrl;
    do
    {
      return;
      localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localQQGAudioCtrl == null) {
        break;
      }
      if (!this.jdField_a_of_type_Nbs.equals(paramnbs))
      {
        this.jdField_a_of_type_Nbs.a(paramnbs);
        localQQGAudioCtrl.setShareEncParam(this.jdField_a_of_type_Nbs, this.jdField_a_of_type_Int, this.b, 1);
      }
    } while (localQQGAudioCtrl.sendShareFrame(paramArrayOfByte, paramInt1, paramnbs.jdField_a_of_type_Int, paramnbs.b, paramInt2) == 0);
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