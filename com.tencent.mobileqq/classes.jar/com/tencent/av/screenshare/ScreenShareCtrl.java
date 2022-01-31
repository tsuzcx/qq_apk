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
import lfb;
import lga;
import lid;
import lyh;
import lyj;
import mls;

public class ScreenShareCtrl
{
  private int jdField_a_of_type_Int;
  private final VideoController jdField_a_of_type_ComTencentAvVideoController;
  private ScreenShareCtrl.DoubleMeetingInviteTimeOutTask jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask;
  private ScreenShareCtrl.ShareOpsTimeOutTask jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private final lyh jdField_a_of_type_Lyh = new lyh();
  private lyj jdField_a_of_type_Lyj;
  private int b;
  
  public ScreenShareCtrl(VideoController paramVideoController)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
  }
  
  private VideoConstants.EmShareOpsRet a(lid paramlid, VideoConstants.EmShareOps paramEmShareOps, int paramInt)
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
        paramlid.a("executeShareScreenOps", VideoConstants.EmShareState.REQUESTING_START, paramInt);
        if (paramEmShareOps != VideoConstants.EmShareOps.STOP) {
          break label124;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if (((QQGAudioCtrl)localObject2).StartOrStopShareSend(bool, paramInt)) {
          break label154;
        }
        localObject2 = VideoConstants.EmShareOpsRet.REQUESTING_FAIL;
        if (paramEmShareOps != VideoConstants.EmShareOps.START) {
          break label130;
        }
        paramlid.a("executeShareScreenOps", VideoConstants.EmShareState.START_FAIL, paramInt);
        return localObject2;
        if (paramEmShareOps != VideoConstants.EmShareOps.STOP) {
          break;
        }
        paramlid.a("executeShareScreenOps", VideoConstants.EmShareState.REQUESTING_STOP, paramInt);
        break;
      }
      localObject1 = localObject2;
    } while (paramEmShareOps != VideoConstants.EmShareOps.STOP);
    label130:
    paramlid.a("executeShareScreenOps", VideoConstants.EmShareState.STOP_FAIL, paramInt);
    return localObject2;
    label154:
    localObject2 = VideoConstants.EmShareOpsRet.SUC;
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask != null)
    {
      ((VideoAppInterface)localObject1).a().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask);
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask = null;
    }
    this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask = new ScreenShareCtrl.ShareOpsTimeOutTask(this.jdField_a_of_type_ComTencentAvVideoController, paramlid, paramEmShareOps, paramInt);
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
      localObject = localResources.getString(2131696315);
      continue;
      localObject = localResources.getString(2131696314);
      continue;
      localObject = localResources.getString(2131696316);
    }
  }
  
  public VideoConstants.EmShareOpsRet a(VideoConstants.EmShareOps paramEmShareOps)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a() == null) {
      return VideoConstants.EmShareOpsRet.CTRL_NULL;
    }
    lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "requestShareScreenOps, emShareOps[" + paramEmShareOps + "], cur[" + locallid.a + "," + locallid.ad + "]");
    }
    if ((locallid.ad != 1) && (locallid.ad != 0)) {
      return VideoConstants.EmShareOpsRet.INVALID_SHARE_TYPE;
    }
    VideoConstants.EmShareOpsRet localEmShareOpsRet = VideoConstants.EmShareOpsRet.UNKNOWN;
    switch (lyi.b[paramEmShareOps.ordinal()])
    {
    default: 
      return localEmShareOpsRet;
    case 1: 
      switch (lyi.a[locallid.a.ordinal()])
      {
      default: 
        return localEmShareOpsRet;
      case 1: 
      case 2: 
        return VideoConstants.EmShareOpsRet.SUC;
      }
      return a(locallid, paramEmShareOps, 1);
    }
    switch (lyi.a[locallid.a.ordinal()])
    {
    default: 
      return localEmShareOpsRet;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
      return a(locallid, paramEmShareOps, 1);
    }
    return VideoConstants.EmShareOpsRet.SUC;
  }
  
  public lyj a()
  {
    if (this.jdField_a_of_type_Lyj == null) {
      this.jdField_a_of_type_Lyj = new lyj(this);
    }
    return this.jdField_a_of_type_Lyj;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5)
  {
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvVideoController.a;
    if (localVideoAppInterface == null) {}
    for (;;)
    {
      return;
      lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((locallid.E != paramInt3) || (locallid.jdField_g_of_type_Long != paramLong))
      {
        QLog.i("AVShare", 1, "onShareOpsCallback, error session, session[" + locallid + "], [" + paramInt3 + "," + paramLong + "," + paramInt4 + "," + paramInt5 + "], actionResult[" + paramInt1 + "], shareType[" + paramInt2 + "]");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AVShare", 2, "onShareOpsCallback, session[" + locallid + "], [" + paramInt3 + "," + paramLong + "," + paramInt4 + "," + paramInt5 + "], actionResult[" + paramInt1 + "], shareType[" + paramInt2 + "]");
      }
      if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask != null)
      {
        localVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask);
        this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask = null;
      }
      VideoConstants.EmShareState localEmShareState = locallid.a;
      switch (paramInt1)
      {
      }
      while (localEmShareState != locallid.a)
      {
        locallid.a("onShareOpsCallback", localEmShareState, paramInt2);
        localVideoAppInterface.a(new Object[] { Integer.valueOf(519), localEmShareState, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong), Integer.valueOf(paramInt4) });
        return;
        if (locallid.a == VideoConstants.EmShareState.REQUESTING_START)
        {
          localEmShareState = VideoConstants.EmShareState.START_SUC;
          continue;
          if (locallid.a == VideoConstants.EmShareState.REQUESTING_START)
          {
            localEmShareState = VideoConstants.EmShareState.START_FAIL;
            continue;
            if (locallid.a == VideoConstants.EmShareState.REQUESTING_STOP)
            {
              localEmShareState = VideoConstants.EmShareState.STOP_SUC;
              continue;
              if (locallid.a == VideoConstants.EmShareState.REQUESTING_STOP) {
                localEmShareState = VideoConstants.EmShareState.STOP_FAIL;
              }
            }
          }
        }
      }
    }
  }
  
  @TargetApi(21)
  public void a(int paramInt, long paramLong, lyh paramlyh)
  {
    if (paramlyh == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
        } while ((((lid)localObject).E != paramInt) || (((lid)localObject).jdField_g_of_type_Long != paramLong));
        if (QLog.isColorLevel()) {
          QLog.i("AVShare", 2, "onRecSharePushEncParam, param[" + paramlyh + "], session[" + localObject + "]");
        }
      } while (((lid)localObject).a != VideoConstants.EmShareState.START_SUC);
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (localObject == null);
    ((mls)localObject).a(paramlyh.jdField_a_of_type_Int, paramlyh.b, paramlyh.c);
  }
  
  public void a(long paramLong)
  {
    lid locallid1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l2;
    int i;
    lid locallid2;
    try
    {
      l1 = Long.parseLong(locallid1.jdField_d_of_type_JavaLangString);
      l2 = l1;
      if (l1 == 0L)
      {
        l2 = l1;
        if (locallid1.jdField_g_of_type_Long != 0L) {
          l2 = locallid1.jdField_g_of_type_Long;
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
        QLog.i("normal_2_meeting", 2, "switchToDoubleMeeting, session[" + locallid1 + "]");
      }
      lfb locallfb = lfb.a();
      i = locallid1.jdField_d_of_type_Int;
      String str1 = locallid1.c;
      String str2 = lfb.a(100, String.valueOf(l2), new int[0]);
      locallid2 = locallfb.a(str2, false);
      locallid2.a(paramLong, locallid1.j);
      locallid2.jdField_g_of_type_Boolean = locallid1.jdField_g_of_type_Boolean;
      locallid2.aF = locallid1.j;
      locallid2.a("switchToDoubleMeeting", locallid1.O);
      locallid2.b("switchToDoubleMeeting", locallid1.q);
      locallid2.jdField_d_of_type_JavaLangString = locallid1.jdField_d_of_type_JavaLangString;
      if (TextUtils.isEmpty(locallid2.jdField_d_of_type_JavaLangString)) {
        locallid2.jdField_d_of_type_JavaLangString = String.valueOf(l2);
      }
      locallid2.jdField_e_of_type_JavaLangString = locallid1.jdField_e_of_type_JavaLangString;
      locallid2.C = 8;
      locallid2.aD = true;
      locallid2.E = 3;
      locallid2.jdField_g_of_type_Long = l2;
      locallid2.i = 0;
      locallid2.e("switchToDoubleMeeting", true);
      locallid2.b(locallid1.b());
      locallid2.c(locallid1.c());
      locallid2.ac = 5;
      this.jdField_a_of_type_ComTencentAvVideoController.o(true);
      this.jdField_a_of_type_ComTencentAvVideoController.a(locallid1.jdField_d_of_type_JavaLangString, 8);
      this.jdField_a_of_type_ComTencentAvVideoController.b(262);
      this.jdField_a_of_type_ComTencentAvVideoController.b(locallid1.jdField_d_of_type_JavaLangString, 72);
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Int = 3;
      if (locallfb.a(str1))
      {
        boolean bool = locallfb.a(paramLong, str1);
        QLog.i("AVShare", 2, "switchToDoubleMeeting, need double remove. ret[" + bool + "]");
      }
      if (locallfb.a() != locallid2) {
        locallfb.b(str2);
      }
      if (QLog.isColorLevel()) {
        QLog.i("normal_2_meeting", 2, "switchToDoubleMeeting, after close pre one. cur[" + this.jdField_a_of_type_ComTencentAvVideoController.a() + "]");
      }
      locallid2.y = -1;
      if (i != 1) {
        break label571;
      }
    }
    locallid2.a(paramLong, "switchToDoubleMeeting.1", 3);
    for (;;)
    {
      locallid2.i = 0;
      locallid2.jdField_g_of_type_Long = l2;
      locallid2.b("switchToDoubleMeeting", 0);
      this.jdField_a_of_type_ComTencentAvVideoController.a.a(new Object[] { Integer.valueOf(174), Long.valueOf(paramLong) });
      return;
      label571:
      if (i == 2) {
        locallid2.a(paramLong, "switchToDoubleMeeting.2", 4);
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
    Object localObject = lfb.a(100, String.valueOf(paramLong2), new int[0]);
    lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
    localObject = lfb.a().c((String)localObject);
    ((lid)localObject).R = true;
    ((lid)localObject).jdField_f_of_type_Int = 2;
    ((lid)localObject).jdField_f_of_type_JavaLangString = null;
    ((lid)localObject).jdField_e_of_type_Boolean = true;
    ((lid)localObject).s = String.valueOf(paramLong2);
    ((lid)localObject).jdField_d_of_type_JavaLangString = locallid.jdField_d_of_type_JavaLangString;
    ((lid)localObject).jdField_e_of_type_JavaLangString = locallid.jdField_e_of_type_JavaLangString;
    ((lid)localObject).aF = locallid.j;
    ((lid)localObject).a(paramLong1, false);
    ((lid)localObject).jdField_g_of_type_Boolean = locallid.jdField_g_of_type_Boolean;
    ((lid)localObject).a("onSwitch2DoubleMeeting", locallid.O);
    ((lid)localObject).b("onSwitch2DoubleMeeting", locallid.q);
    ((lid)localObject).aD = true;
    if (locallid.jdField_d_of_type_Int == 1)
    {
      ((lid)localObject).a(paramLong1, "onSwitch2DoubleMeeting.1", 3);
      ((lid)localObject).i = locallid.i;
      ((lid)localObject).jdField_g_of_type_Long = paramLong2;
      ((lid)localObject).E = 3;
      ((lid)localObject).C = 8;
      ((lid)localObject).d("onSwitch2DoubleMeeting", true);
      ((lid)localObject).e("onSwitch2DoubleMeeting", true);
      ((lid)localObject).a(5, 17);
      ((lid)localObject).a("onSwitch2DoubleMeeting", 2);
      lfb locallfb = lfb.a();
      lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a.a();
      if (locallga != null) {
        locallga.a(262);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.b(locallid.jdField_d_of_type_JavaLangString, 72);
      if ((!TextUtils.isEmpty(locallid.c)) && (locallfb.a(locallid.c)))
      {
        boolean bool = locallfb.a(paramLong1, locallid.c);
        if (QLog.isColorLevel()) {
          QLog.i("AVShare", 2, "onSwitch2DoubleMeeting, need double remove ret[" + bool + "]");
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a() != localObject)
      {
        locallfb.b(((lid)localObject).c);
        if (QLog.isColorLevel()) {
          QLog.i("AVShare", 2, "onSwitch2DoubleMeeting, need double set main session. ");
        }
      }
      ((lid)localObject).b("onSwitch2DoubleMeeting", 1);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a.a() <= 0) {
        break label570;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a.a(new Object[] { Integer.valueOf(174), Long.valueOf(paramLong1) });
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(((lid)localObject).c, ((lid)localObject).jdField_d_of_type_Int, false, false, true);
      return;
      ((lid)localObject).a(paramLong1, "onSwitch2DoubleMeeting.2", 4);
      break;
      label570:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a.isBackground_Stop) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong1, 3, paramLong2, new long[] { paramLong2 }, false);
      }
    }
  }
  
  public void a(Bitmap paramBitmap, lyh paramlyh)
  {
    if (paramlyh == null) {}
    QQGAudioCtrl localQQGAudioCtrl;
    do
    {
      return;
      localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (localQQGAudioCtrl == null);
    if (!this.jdField_a_of_type_Lyh.equals(paramlyh))
    {
      this.jdField_a_of_type_Lyh.a(paramlyh);
      localQQGAudioCtrl.SetShareEncParam(this.jdField_a_of_type_Lyh, this.jdField_a_of_type_Int, this.b, 1);
    }
    localQQGAudioCtrl.SendShareFrame2Native(paramBitmap, paramlyh.jdField_a_of_type_Int, paramlyh.b);
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
      lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (QLog.isColorLevel()) {
        QLog.i("AVShare", 2, "startOrStopScreenShare, seq[" + paramLong + "]");
      }
      if ((locallid.a == VideoConstants.EmShareState.START_SUC) || (locallid.a == VideoConstants.EmShareState.REQUESTING_START))
      {
        if (a(VideoConstants.EmShareOps.STOP) == VideoConstants.EmShareOpsRet.SUC)
        {
          a(i);
          if (paramAVActivity != null) {
            break label124;
          }
        }
        label124:
        for (paramAVActivity = localObject;; paramAVActivity = paramAVActivity.a())
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
        if (locallid.a(this.jdField_a_of_type_ComTencentAvVideoController.a.getCurrentAccountUin()))
        {
          a(1);
          return;
        }
        if (locallid.x())
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
    paramArrayOfByte.e("onSwitchMeeting", true);
    paramArrayOfByte.jdField_g_of_type_Long = 0L;
    paramArrayOfByte.a(6, 16);
    this.jdField_a_of_type_ComTencentAvVideoController.a.a(new Object[] { Integer.valueOf(174), Long.valueOf(l) });
    a();
  }
  
  public void a(lid paramlid)
  {
    if (paramlid == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "startDoubleMeetingTimeOutTask, info[" + paramlid + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask);
    }
    this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask = new ScreenShareCtrl.DoubleMeetingInviteTimeOutTask(this.jdField_a_of_type_ComTencentAvVideoController, paramlid);
    this.jdField_a_of_type_ComTencentAvVideoController.a.a().postDelayed(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask, 15000L);
  }
  
  public void a(lyh paramlyh, int paramInt1, int paramInt2)
  {
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((localQQGAudioCtrl == null) || (paramlyh == null)) {
      return;
    }
    this.jdField_a_of_type_Lyh.a(paramlyh);
    if (paramInt1 != 0) {
      this.jdField_a_of_type_Int = paramInt1;
    }
    if (paramInt2 != 0) {
      this.b = paramInt2;
    }
    localQQGAudioCtrl.SetShareEncParam(this.jdField_a_of_type_Lyh, this.jdField_a_of_type_Int, this.b, 0);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, lyh paramlyh)
  {
    if (paramlyh == null) {}
    QQGAudioCtrl localQQGAudioCtrl;
    do
    {
      return;
      localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (localQQGAudioCtrl == null);
    if (!this.jdField_a_of_type_Lyh.equals(paramlyh))
    {
      this.jdField_a_of_type_Lyh.a(paramlyh);
      localQQGAudioCtrl.SetShareEncParam(this.jdField_a_of_type_Lyh, this.jdField_a_of_type_Int, this.b, 1);
    }
    localQQGAudioCtrl.SendShareFrame2Native(paramArrayOfByte, paramInt1, paramlyh.jdField_a_of_type_Int, paramlyh.b, paramInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl
 * JD-Core Version:    0.7.0.1
 */