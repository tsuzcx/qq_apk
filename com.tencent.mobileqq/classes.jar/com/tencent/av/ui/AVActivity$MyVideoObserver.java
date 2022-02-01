package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.av.AVLog;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.business.manager.filter.EffectFilterTools.DataReport;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.business.manager.pendant.EffectPendantTools.DataReport;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.zimu.EffectZimuManager.DataReport;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.screenshare.ScreenShareReportHelper;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.ui.funchat.record.QavRecordReporter;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.wtogether.callback.WatchTogetherUIProxy;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class AVActivity$MyVideoObserver
  extends VideoObserver
{
  AVActivity$MyVideoObserver(AVActivity paramAVActivity) {}
  
  private void a(WatchTogetherMediaPlayCtrl paramWatchTogetherMediaPlayCtrl, View paramView, VideoLayerUI paramVideoLayerUI, WatchTogetherUIProxy paramWatchTogetherUIProxy, boolean paramBoolean)
  {
    boolean bool2 = false;
    SessionInfo localSessionInfo = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool1;
    int i;
    if (!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_h_of_type_Boolean)
    {
      bool1 = true;
      localSessionInfo.c(bool1);
      AVActivity.c(this.a);
      this.a.a(1, false);
      if (paramVideoLayerUI == null) {
        break label249;
      }
      if (this.a.jdField_h_of_type_Int != 0)
      {
        bool1 = bool2;
        if (this.a.jdField_h_of_type_Int != 180) {}
      }
      else
      {
        bool1 = true;
      }
      if (!bool1) {
        break label215;
      }
      i = 1;
      label96:
      paramVideoLayerUI.j(i);
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 1, "enterWatchTogetherStatus, portrait[" + bool1 + "]");
      paramView = paramVideoLayerUI.a();
    }
    for (;;)
    {
      paramWatchTogetherUIProxy.setWatchTogetherMediaPlayerProxy(paramWatchTogetherMediaPlayCtrl);
      paramWatchTogetherUIProxy.setWatchTogetherParams(true, paramBoolean);
      paramWatchTogetherUIProxy.setOrientationParams(i);
      paramWatchTogetherUIProxy.setSeekBarChangeListener(paramWatchTogetherMediaPlayCtrl);
      paramWatchTogetherUIProxy.setImmersiveStatus(localSessionInfo.B());
      paramWatchTogetherMediaPlayCtrl.a(paramWatchTogetherUIProxy);
      if (!paramWatchTogetherMediaPlayCtrl.k())
      {
        paramWatchTogetherMediaPlayCtrl.a(paramView);
        return;
        bool1 = false;
        break;
        label215:
        i = 2;
        break label96;
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new AVActivity.MyVideoObserver.1(this, paramWatchTogetherMediaPlayCtrl, paramView), 200L);
      return;
      label249:
      paramView = null;
      i = 1;
    }
  }
  
  private void b(WatchTogetherMediaPlayCtrl paramWatchTogetherMediaPlayCtrl, View paramView, VideoLayerUI paramVideoLayerUI, WatchTogetherUIProxy paramWatchTogetherUIProxy, boolean paramBoolean)
  {
    this.a.setRequestedOrientation(1);
    QLog.d(this.a.jdField_b_of_type_JavaLangString, 1, "quitWatchTogetherStatus, displayRotation[ActivityInfo.SCREEN_ORIENTATION_PORTRAIT]");
    this.a.a(1, false);
    if (paramVideoLayerUI != null) {
      paramVideoLayerUI.j(0);
    }
    paramWatchTogetherUIProxy.setSeekBarChangeListener(null);
    paramWatchTogetherUIProxy.setWatchTogetherMediaPlayerProxy(null);
    paramWatchTogetherUIProxy.setWatchTogetherParams(false, paramBoolean);
    paramWatchTogetherMediaPlayCtrl.b(paramWatchTogetherUIProxy);
    paramWatchTogetherMediaPlayCtrl.a("full-onRecvWatchTogetherStatusChanged", null);
    paramWatchTogetherMediaPlayCtrl.g();
    paramWatchTogetherMediaPlayCtrl.h();
  }
  
  public void a()
  {
    super.a();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.o();
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.g();
    }
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      if (this.a.c != null) {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.jdField_d_of_type_Int, this.a.c, this.a.i);
      }
      if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        this.a.jdField_e_of_type_Int = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_A_of_type_Int;
        this.a.m = this.a.jdField_a_of_type_ComTencentAvVideoController.a().p;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "setBindInfo: mBindType = " + this.a.jdField_e_of_type_Int + ",mBindId = " + this.a.m);
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(this.a.jdField_e_of_type_Int, this.a.m);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch == null) {
      AVActivity.b(this.a);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer != null) {
      this.a.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer.a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer != null) {
      this.a.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer.a(paramInt1, paramInt2);
    }
  }
  
  @TargetApi(21)
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_b_of_type_JavaLangString, 2, "onShareStateChange, shareState[" + paramInt1 + "], shareType[" + paramInt2 + "], relationType[" + paramInt3 + "], relationId[" + paramLong + "], multiAvType[" + paramInt4 + "], seq[" + l + "]");
    }
    Object localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController;
    if (localObject1 == null)
    {
      QLog.i("AVShare", 1, "onShareStateChange, ctrl is null.");
      return;
    }
    localObject1 = ((VideoController)localObject1).a();
    if ((((SessionInfo)localObject1).F != paramInt3) || (((SessionInfo)localObject1).jdField_g_of_type_Long != paramLong))
    {
      QLog.i("AVShare", 1, "onShareStateChange, not same session");
      return;
    }
    Object localObject2;
    if (paramInt2 == 1)
    {
      if (((SessionInfo)localObject1).ae != 3) {
        break label224;
      }
      localObject2 = this.a.a();
      if (localObject2 != null) {
        ((ScreenRecordHelper)localObject2).a(3);
      }
    }
    for (;;)
    {
      if (((SessionInfo)localObject1).ae == 5) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.A(l);
      }
      this.a.runOnUiThread(new AVActivity.MyVideoObserver.2(this));
      return;
      label224:
      if (((SessionInfo)localObject1).ae == 2)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.z(l);
        localObject2 = SessionMgr.a().a();
        ScreenShareReportHelper.b("0X800AD8F", ScreenShareReportHelper.a((SessionInfo)localObject2), String.valueOf(ScreenShareReportHelper.a(((SessionInfo)localObject2).c)));
      }
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2) {}
  
  public void a(long paramLong)
  {
    AudioHelper.b(this.a.jdField_b_of_type_JavaLangString + ".onConnected");
    SessionInfo localSessionInfo = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    VideoNodeManager.a(31);
    String str1 = localSessionInfo.jdField_d_of_type_JavaLangString;
    String str2 = this.a.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("onConnected, mVideoLayerUI[");
    boolean bool;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      bool = true;
      QLog.w(str2, 1, bool + "], peerUin[" + str1 + "], mShutCamera[" + this.a.f + "], SessionType[" + localSessionInfo.jdField_d_of_type_Int + "], seq[" + paramLong + "]");
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.v();
      }
      if ((localSessionInfo.jdField_d_of_type_Int != 2) && (localSessionInfo.jdField_d_of_type_Int != 4)) {
        break label560;
      }
      this.a.b(false);
      this.a.f(false);
    }
    for (;;)
    {
      if (localSessionInfo.jdField_d_of_type_Int == 2)
      {
        if (this.a.f)
        {
          localSessionInfo.a(paramLong, false);
          this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
        }
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
        {
          str1 = localSessionInfo.jdField_d_of_type_JavaLangString;
          bool = localSessionInfo.k;
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str1, 1, bool, false, this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c));
        }
      }
      if (localSessionInfo.jdField_d_of_type_Int == 1) {
        localSessionInfo.a(paramLong, false);
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.c(paramLong);
      this.a.g(paramLong);
      if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundStop) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.b();
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.e(paramLong);
        if ((2 == localSessionInfo.jdField_d_of_type_Int) || (this.a.g)) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramLong, "onConnected");
        }
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.P();
      }
      ZimuToolbar.sendSupportionToPeer(this.a.jdField_a_of_type_ComTencentAvVideoController);
      DoodleLogic.a().c();
      QavVideoRecordUICtrl.a(this.a.jdField_a_of_type_ComTencentAvVideoController);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 200L);
      this.a.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(paramLong, this.a, 4, 0);
      this.a.a(paramLong, 2000L);
      if (this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null) {
        this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a();
      }
      return;
      bool = false;
      break;
      label560:
      this.a.b(true);
      this.a.f(true);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramLong, paramInt);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
      this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a("AVnotify", paramLong, paramInt1, paramInt2);
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onClose, reason[" + paramInt + "], peerUin[" + paramString + "], mPeerUin[" + this.a.c + "], seq[" + paramLong + "]");
    if ((paramString != null) && (!UITools.a(paramString, this.a.c))) {
      return;
    }
    if ((paramInt == 49) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().B) && (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) && (this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi.a())) {
      this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi.f();
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI))) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong, paramInt);
    }
    AVLog.printColorLog(this.a.jdField_b_of_type_JavaLangString, "DataReport onClose: ");
    EffectPendantTools.DataReport.a(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    EffectZimuManager.DataReport.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    EffectFilterTools.DataReport.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    BeautyToolbar.DataReport.b(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    VoiceChangeDataReport.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a());
    MultiVideoRichActionReportCollection.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    paramString = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().jdField_d_of_type_JavaLangString) + "";
    MagicDataReport.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString);
    MagicDataReport.a(2, paramString);
    MagicDataReport.a(2);
    this.a.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(paramLong, this.a, 3, 2);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer != null) {
      this.a.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer.a(paramLong1, paramLong2, paramLong3);
    }
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong, paramString, paramBoolean);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramLong, paramBoolean);
    }
  }
  
  public void a(RecvMsg paramRecvMsg)
  {
    super.a(paramRecvMsg);
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      this.a.g(-1033L);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramRecvMsg);
      int i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
      if ((i == 1) || (i == 2))
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f(false);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.k(2);
      }
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f(true);
    this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.k(1);
  }
  
  public void a(String paramString)
  {
    AVActivity.a(this.a, paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onGroundGlassSwitch, fromUin[" + paramString + "], nOff[" + paramInt + "], mSessionType[" + this.a.jdField_b_of_type_Int + "]");
    }
    if ((2 == this.a.jdField_b_of_type_Int) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt);
    }
  }
  
  public void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    int i = 2;
    int m = (int)(0x3 & paramLong);
    int j = (int)(paramLong >> 4 & 0x7);
    int k = (int)(paramLong >> 7 & 0x7);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, String.format("onNetLevel_S2C, peerUin[%s], level[%s], detail[%s], netLevel[%s], s2cSelfNetLevel[%s], s2cPeerNetLevel[%s]", new Object[] { paramString, Long.valueOf(paramLong), paramArrayOfByte, Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k) }));
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      switch (m)
      {
      default: 
        i = -1;
      }
    }
    for (;;)
    {
      paramString = null;
      if (paramArrayOfByte != null) {
        paramString = new String(paramArrayOfByte);
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(i, j, k, paramString);
      return;
      i = 3;
      continue;
      i = 1;
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if ((this.a.jdField_d_of_type_Int == 25) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString, paramBitmap);
    }
    super.a(paramString, paramBitmap);
  }
  
  public void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString1, paramString2);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {}
    long l;
    SessionInfo localSessionInfo;
    int i;
    label349:
    String str;
    do
    {
      do
      {
        for (;;)
        {
          return;
          l = AudioHelper.b();
          localSessionInfo = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
          AVLog.printAllUserLog(this.a.jdField_b_of_type_JavaLangString, "onDestroyUI, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], mPeerUin[" + this.a.c + "], mIsDoubleVideoMeeting[" + this.a.g + "], mSessionType[" + this.a.jdField_b_of_type_Int + "], mSessionId[" + this.a.jdField_a_of_type_JavaLangString + "], mRelationId[" + this.a.jdField_d_of_type_JavaLangString + "], seq[" + l + "], \nsession[" + localSessionInfo + "]");
          if ((this.a.jdField_b_of_type_Int != 1) && (this.a.jdField_b_of_type_Int != 2)) {
            break;
          }
          if ((this.a.c != null) && (paramString != null) && (this.a.c.equals(paramString)))
          {
            this.a.jdField_e_of_type_Boolean = paramBoolean;
            AVLog.printAllUserLog(this.a.jdField_b_of_type_JavaLangString, "onDestroyUI exit 1");
            this.a.finish();
            this.a.b(true);
            if (paramBoolean) {
              break label349;
            }
            i = SmallScreenUtils.a(localSessionInfo.L);
            this.a.overridePendingTransition(0, i);
          }
          while (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
          {
            paramString = SharedPreUtils.a(this.a.getApplicationContext()).edit();
            paramString.putInt("video_position", this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h());
            paramString.commit();
            DataReport.a(this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h());
            return;
            this.a.overridePendingTransition(0, 2130772192);
          }
        }
      } while ((this.a.jdField_b_of_type_Int != 3) && (this.a.jdField_b_of_type_Int != 4));
      str = this.a.jdField_d_of_type_JavaLangString;
    } while (((str == null) || (paramString == null) || (!str.equals(paramString))) && ((!this.a.g) || (!TextUtils.equals(this.a.c, paramString))));
    this.a.jdField_e_of_type_Boolean = paramBoolean;
    AVLog.printAllUserLog(this.a.jdField_b_of_type_JavaLangString, "onDestroyUI exit 2");
    this.a.b(l);
    this.a.jdField_h_of_type_Boolean = true;
    this.a.finish();
    this.a.b(true);
    if (!paramBoolean)
    {
      i = SmallScreenUtils.a(localSessionInfo.L);
      this.a.overridePendingTransition(0, i);
      return;
    }
    this.a.overridePendingTransition(0, 2130772192);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onRecvWatchTogetherImmerseStatusChanged enable=" + paramBoolean);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer != null) {
      this.a.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer.a(paramBoolean, paramInt1, paramString, paramInt2);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onRecvWatchTogetherStatusChanged enter=" + paramBoolean1 + ", admin=" + paramBoolean2);
    }
    View localView = this.a.findViewById(2131363184);
    VideoLayerUI localVideoLayerUI = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
    WatchTogetherUIProxy localWatchTogetherUIProxy = this.a.a(paramBoolean2);
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.a().a();
    if (localWatchTogetherMediaPlayCtrl == null) {
      return;
    }
    localWatchTogetherMediaPlayCtrl.a(this.a.jdField_h_of_type_Int);
    if (paramBoolean1)
    {
      a(localWatchTogetherMediaPlayCtrl, localView, localVideoLayerUI, localWatchTogetherUIProxy, paramBoolean2);
      return;
    }
    b(localWatchTogetherMediaPlayCtrl, localView, localVideoLayerUI, localWatchTogetherUIProxy, paramBoolean2);
  }
  
  @TargetApi(17)
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onRecvAudioFrame=" + paramArrayOfByte.length + ", type=" + paramInt1 + ", size=" + paramInt2);
    }
  }
  
  public void b()
  {
    super.b();
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt);
      if (paramInt == 0) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(true);
      }
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(false);
  }
  
  public void b(long paramLong)
  {
    String str = this.a.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("onResumeVideo, mIsDoubleVideoMeeting[").append(this.a.g).append("], mVideoLayerUI[");
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "], isResume[" + this.a.isResume() + "], seq[" + paramLong + "]");
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i();
      }
      AVActivity.a(this.a);
      if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.a.isResume()))
      {
        str = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str, 1, true, false, this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c));
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString, 1, this.a.jdField_b_of_type_AndroidGraphicsBitmap, true, false);
      }
      if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((2 == this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int) || (this.a.g))) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramLong, "onResumeVideo");
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog.b();
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null) {
        this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a();
      }
      return;
    }
  }
  
  public void b(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong1, paramLong2, paramLong3);
    }
  }
  
  public void b(long paramLong, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onCloseSessionFinished, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], seq[" + paramLong + "]");
    }
    if (paramString.equals(this.a.c)) {
      TraeHelper.a().a(paramLong, "DEVICE_SPEAKERPHONE");
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) && (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d() != 1)) {
      this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.m();
    }
  }
  
  public void b(String paramString)
  {
    AVActivity.a(this.a, paramString);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onGroundGlassWaitTimeChange : nTime=" + paramInt);
    }
    if ((2 == this.a.jdField_b_of_type_Int) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.f(paramInt);
    }
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    AVLog.printAllUserLog(this.a.jdField_b_of_type_JavaLangString, "onFinish peerUin = " + paramString + " # isQuit :" + paramBoolean + "|" + this.a.jdField_b_of_type_Int + "|" + this.a.c);
    if ((this.a.jdField_b_of_type_Int == 1) || (this.a.jdField_b_of_type_Int == 2)) {
      if ((this.a.c != null) && (paramString != null) && (this.a.c.equals(paramString)))
      {
        this.a.jdField_e_of_type_Boolean = paramBoolean;
        this.a.finish();
        if (paramBoolean) {
          break label261;
        }
        int j = 2130772163;
        int i = j;
        if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
        {
          paramString = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
          i = j;
          if (paramString != null) {
            i = SmallScreenUtils.a(paramString.L);
          }
        }
        this.a.overridePendingTransition(0, i);
      }
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        paramString = SharedPreUtils.a(this.a.getApplicationContext()).edit();
        paramString.putInt("video_position", this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h());
        paramString.commit();
        DataReport.a(this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h());
      }
      return;
      label261:
      this.a.overridePendingTransition(0, 2130772192);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramBoolean);
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramBoolean1, paramBoolean2);
    }
  }
  
  public void c()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onPauseVideo, begin, seq[" + l + "]");
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {}
    for (;;)
    {
      return;
      SessionInfo localSessionInfo = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        String str = localSessionInfo.jdField_d_of_type_JavaLangString;
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(l, str, 1, false, false, this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c));
        if (!localSessionInfo.r()) {
          this.a.a(1, false);
        }
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.h();
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i(l, 16777215);
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer != null) {
        this.a.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer.c();
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog.b();
      }
      boolean bool5;
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) && (this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null))
      {
        boolean bool1 = localSessionInfo.t;
        boolean bool2 = this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(l);
        boolean bool3 = localSessionInfo.k;
        boolean bool4 = localSessionInfo.B;
        bool5 = localSessionInfo.C;
        QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onPauseVideo, hangup[" + bool1 + "], cameraOpen[" + bool2 + "], remoteHasVideo[" + bool3 + "], recording[" + bool4 + "], recordedByOther[" + bool5 + "]");
        if ((bool1) || (!bool3))
        {
          if (!bool4) {
            break label452;
          }
          this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
          this.a.jdField_a_of_type_ComTencentAvVideoController.D();
          if (!bool1)
          {
            QavRecordReporter.a("0X8008ACB");
            if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
              TipsUtil.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1023, 2131695748);
            }
          }
        }
      }
      while (this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a();
        return;
        label452:
        if (bool5) {
          this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.m();
        }
      }
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "yiler onPlayAnnimate receive id:" + paramInt);
    }
    if (this.a.isDestroyed()) {}
    do
    {
      int i;
      String str;
      do
      {
        return;
        i = VipFunCallManager.a();
        str = VipFunCallManager.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, i, null);
      } while (str == null);
      File localFile = new File(str);
      if ((localFile != null) && (localFile.exists()) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 4) && (this.a.jdField_b_of_type_Int == 1) && (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null))
      {
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.w();
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView == null) {
          this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = VipFunCallManager.a((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), (RelativeLayout)this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent(), false);
        }
        if (!VipFunCallManager.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView, str, i, this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallMediaListener, paramInt, false)) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "yiler onPlayAnnimate finish id:" + paramInt);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt1, paramInt2);
    }
  }
  
  public void c(String paramString)
  {
    super.c(paramString);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramString);
    }
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a.jdField_b_of_type_JavaLangString, 2, "onPeerSwitchTerminal, bStartSwitch[" + paramBoolean + "]");
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString, paramBoolean);
    }
    ZimuToolbar.sendSupportionToPeer(this.a.jdField_a_of_type_ComTencentAvVideoController);
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().k))
    {
      paramString = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      paramBoolean = this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramString, paramBoolean);
    }
    QavVideoRecordUICtrl.a(this.a.jdField_a_of_type_ComTencentAvVideoController);
    boolean bool;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      paramBoolean = this.a.jdField_a_of_type_ComTencentAvVideoController.a().B;
      bool = this.a.jdField_a_of_type_ComTencentAvVideoController.a().C;
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onPeerSwitchTerminal, recording=" + paramBoolean + ", beenRecorded=" + bool);
      }
      if (!paramBoolean) {
        break label308;
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) {
        this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.D();
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_A_of_type_Boolean = false;
      if (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) {
        this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.n();
      }
      return;
      label308:
      if ((bool) && (this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver != null)) {
        this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver.a("self", String.valueOf(3));
      }
    }
  }
  
  public void d()
  {
    super.d();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.k(true);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.F();
    }
  }
  
  public void d(String paramString)
  {
    if ((this.a.jdField_d_of_type_Int == 25) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString);
    }
    super.d(paramString);
  }
  
  public void e()
  {
    super.e();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.k(false);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.G();
    }
  }
  
  public void f()
  {
    if (this.a.isDestroyed()) {
      return;
    }
    WTogetherUtil.a(this.a, this.a.getResources().getString(2131695999));
  }
  
  public void g()
  {
    super.g();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.j();
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onNeedShowPeerVideo, mIsDoubleVideoMeeting[" + this.a.g + "], mPeerUin" + this.a.c + "]");
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.k();
    }
  }
  
  public void j()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.t();
    }
  }
  
  public void k()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.u();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.MyVideoObserver
 * JD-Core Version:    0.7.0.1
 */