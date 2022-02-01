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
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.screenshare.ScreenShareReportHelper;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.ui.funchat.record.QavRecordReporter;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.wtogether.callback.WatchTogetherUIProxy;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
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
    SessionInfo localSessionInfo = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    localSessionInfo.c(this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_h_of_type_Boolean ^ true);
    AVActivity.c(this.a);
    paramView = this.a;
    boolean bool = false;
    paramView.a(1, false);
    int i;
    if (paramVideoLayerUI != null)
    {
      if ((this.a.jdField_h_of_type_Int == 0) || (this.a.jdField_h_of_type_Int == 180)) {
        bool = true;
      }
      if (bool) {
        i = 1;
      } else {
        i = 2;
      }
      paramVideoLayerUI.j(i);
      paramView = this.a.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enterWatchTogetherStatus, portrait[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.d(paramView, 1, localStringBuilder.toString());
      paramView = paramVideoLayerUI.a();
    }
    else
    {
      paramView = null;
      i = 1;
    }
    paramWatchTogetherUIProxy.setWatchTogetherMediaPlayerProxy(paramWatchTogetherMediaPlayCtrl);
    paramWatchTogetherUIProxy.setWatchTogetherParams(true, paramBoolean);
    paramWatchTogetherUIProxy.setOrientationParams(i);
    paramWatchTogetherUIProxy.setSeekBarChangeListener(paramWatchTogetherMediaPlayCtrl);
    paramWatchTogetherUIProxy.setImmersiveStatus(localSessionInfo.ax);
    paramWatchTogetherMediaPlayCtrl.a(paramWatchTogetherUIProxy);
    if (!paramWatchTogetherMediaPlayCtrl.k())
    {
      paramWatchTogetherMediaPlayCtrl.a(paramView);
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new AVActivity.MyVideoObserver.1(this, paramWatchTogetherMediaPlayCtrl, paramView), 200L);
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
  
  protected void a()
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
      Object localObject;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        localObject = this.a;
        ((AVActivity)localObject).jdField_e_of_type_Int = ((AVActivity)localObject).jdField_a_of_type_ComTencentAvVideoController.a().A;
        localObject = this.a;
        ((AVActivity)localObject).m = ((AVActivity)localObject).jdField_a_of_type_ComTencentAvVideoController.a().o;
      }
      if (QLog.isColorLevel())
      {
        localObject = this.a.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setBindInfo: mBindType = ");
        localStringBuilder.append(this.a.jdField_e_of_type_Int);
        localStringBuilder.append(",mBindId = ");
        localStringBuilder.append(this.a.m);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(this.a.jdField_e_of_type_Int, this.a.m);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch == null) {
      AVActivity.b(this.a);
    }
  }
  
  protected void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer != null) {
      this.a.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer.a(paramInt);
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer != null) {
      this.a.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer.a(paramInt1, paramInt2);
    }
  }
  
  @TargetApi(21)
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    long l = AudioHelper.b();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.a.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onShareStateChange, shareState[");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("], shareType[");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append("], relationType[");
      ((StringBuilder)localObject2).append(paramInt3);
      ((StringBuilder)localObject2).append("], relationId[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("], multiAvType[");
      ((StringBuilder)localObject2).append(paramInt4);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController;
    if (localObject1 == null)
    {
      QLog.i("AVShare", 1, "onShareStateChange, ctrl is null.");
      return;
    }
    localObject1 = ((VideoController)localObject1).a();
    if ((((SessionInfo)localObject1).E == paramInt3) && (((SessionInfo)localObject1).jdField_f_of_type_Long == paramLong))
    {
      if (paramInt2 == 1)
      {
        if (((SessionInfo)localObject1).X == 3)
        {
          localObject2 = this.a.a();
          if (localObject2 != null) {
            ((ScreenRecordHelper)localObject2).a(3);
          }
        }
        else if (((SessionInfo)localObject1).X == 2)
        {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.y(l);
          localObject2 = SessionMgr.a().a();
          ScreenShareReportHelper.b("0X800AD8F", ScreenShareReportHelper.a((SessionInfo)localObject2), String.valueOf(ScreenShareReportHelper.a(((SessionInfo)localObject2).jdField_b_of_type_JavaLangString)));
        }
        if (((SessionInfo)localObject1).X == 5) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.z(l);
        }
      }
      this.a.runOnUiThread(new AVActivity.MyVideoObserver.2(this));
      return;
    }
    QLog.i("AVShare", 1, "onShareStateChange, not same session");
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2) {}
  
  protected void a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject).append(".onConnected");
    AudioHelper.b(((StringBuilder)localObject).toString());
    localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    VideoNodeManager.a(31);
    String str1 = ((SessionInfo)localObject).c;
    String str2 = this.a.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onConnected, mVideoLayerUI[");
    boolean bool;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], peerUin[");
    localStringBuilder.append(str1);
    localStringBuilder.append("], mShutCamera[");
    localStringBuilder.append(this.a.f);
    localStringBuilder.append("], SessionType[");
    localStringBuilder.append(((SessionInfo)localObject).jdField_d_of_type_Int);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str2, 1, localStringBuilder.toString());
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.u();
    }
    if ((((SessionInfo)localObject).jdField_d_of_type_Int != 2) && (((SessionInfo)localObject).jdField_d_of_type_Int != 4))
    {
      this.a.b(true);
      this.a.e(true);
    }
    else
    {
      this.a.b(false);
      this.a.e(false);
    }
    if (((SessionInfo)localObject).jdField_d_of_type_Int == 2)
    {
      if (this.a.f)
      {
        ((SessionInfo)localObject).b(paramLong, false);
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        str1 = ((SessionInfo)localObject).c;
        bool = ((SessionInfo)localObject).k;
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str1, 1, bool, false, this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c));
      }
    }
    if (((SessionInfo)localObject).jdField_d_of_type_Int == 1) {
      ((SessionInfo)localObject).b(paramLong, false);
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.c(paramLong);
    this.a.g(paramLong);
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundStop) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.d();
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.e(paramLong);
      if ((2 == ((SessionInfo)localObject).jdField_d_of_type_Int) || (this.a.g)) {
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
  }
  
  protected void a(long paramLong, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramLong, paramInt);
    }
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi != null) {
      this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.reopenCamera("AVnotify", paramLong, paramInt1, paramInt2);
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString)
  {
    String str = this.a.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClose, reason[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], peerUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], mPeerUin[");
    localStringBuilder.append(this.a.c);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if ((paramString != null) && (!UITools.a(paramString, this.a.c))) {
      return;
    }
    if ((paramInt == 49) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().az) && (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)) {
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
    paramString = new StringBuilder();
    paramString.append(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().c));
    paramString.append("");
    paramString = paramString.toString();
    MagicDataReport.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString);
    MagicDataReport.a(2, paramString);
    MagicDataReport.a(2);
    this.a.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(paramLong, this.a, 3, 2);
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer != null) {
      this.a.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer.a(paramLong1, paramLong2, paramLong3);
    }
  }
  
  protected void a(long paramLong, String paramString, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong, paramString, paramBoolean);
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramLong, paramBoolean);
    }
  }
  
  protected void a(RecvMsg paramRecvMsg)
  {
    super.a(paramRecvMsg);
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      this.a.g(-1033L);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramRecvMsg);
      int i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
      if ((i != 1) && (i != 2))
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f(true);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.k(1);
        return;
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f(false);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.k(2);
    }
  }
  
  protected void a(String paramString)
  {
    AVActivity.a(this.a, paramString);
  }
  
  protected void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGroundGlassSwitch, fromUin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], nOff[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], mSessionType[");
      localStringBuilder.append(this.a.jdField_b_of_type_Int);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if ((2 == this.a.jdField_b_of_type_Int) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt);
    }
  }
  
  protected void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    int m = (int)(0x3 & paramLong);
    int j = (int)(paramLong >> 4 & 0x7);
    int k = (int)(0x7 & paramLong >> 7);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, String.format("onNetLevel_S2C, peerUin[%s], level[%s], detail[%s], netLevel[%s], s2cSelfNetLevel[%s], s2cPeerNetLevel[%s]", new Object[] { paramString, Long.valueOf(paramLong), paramArrayOfByte, Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k) }));
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      int i = -1;
      if ((m != 0) && (m != 1))
      {
        if (m != 2)
        {
          if (m == 3) {
            i = 1;
          }
        }
        else {
          i = 2;
        }
      }
      else {
        i = 3;
      }
      paramString = null;
      if (paramArrayOfByte != null) {
        paramString = new String(paramArrayOfByte);
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(i, j, k, paramString);
    }
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    if ((this.a.jdField_d_of_type_Int == 25) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString, paramBitmap);
    }
    super.a(paramString, paramBitmap);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString1, paramString2);
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    long l = AudioHelper.b();
    SessionInfo localSessionInfo = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    String str = this.a.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroyUI, peerUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], isQuit[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], mPeerUin[");
    localStringBuilder.append(this.a.c);
    localStringBuilder.append("], mIsDoubleVideoMeeting[");
    localStringBuilder.append(this.a.g);
    localStringBuilder.append("], mSessionType[");
    localStringBuilder.append(this.a.jdField_b_of_type_Int);
    localStringBuilder.append("], mSessionId[");
    localStringBuilder.append(this.a.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("], mRelationId[");
    localStringBuilder.append(this.a.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("], \nsession[");
    localStringBuilder.append(localSessionInfo);
    localStringBuilder.append("]");
    AVLog.printAllUserLog(str, localStringBuilder.toString());
    int i;
    if ((this.a.jdField_b_of_type_Int != 1) && (this.a.jdField_b_of_type_Int != 2))
    {
      if ((this.a.jdField_b_of_type_Int == 3) || (this.a.jdField_b_of_type_Int == 4))
      {
        str = this.a.jdField_d_of_type_JavaLangString;
        if (((str != null) && (paramString != null) && (str.equals(paramString))) || ((this.a.g) && (TextUtils.equals(this.a.c, paramString))))
        {
          paramString = this.a;
          paramString.jdField_e_of_type_Boolean = paramBoolean;
          AVLog.printAllUserLog(paramString.jdField_b_of_type_JavaLangString, "onDestroyUI exit 2");
          this.a.b(l);
          paramString = this.a;
          paramString.jdField_h_of_type_Boolean = true;
          paramString.finish();
          this.a.b(true);
          if (!paramBoolean)
          {
            i = SmallScreenUtils.a(localSessionInfo.K);
            this.a.overridePendingTransition(0, i);
            return;
          }
          this.a.overridePendingTransition(0, 2130772219);
        }
      }
    }
    else
    {
      if ((this.a.c != null) && (paramString != null) && (this.a.c.equals(paramString)))
      {
        paramString = this.a;
        paramString.jdField_e_of_type_Boolean = paramBoolean;
        AVLog.printAllUserLog(paramString.jdField_b_of_type_JavaLangString, "onDestroyUI exit 1");
        this.a.finish();
        this.a.b(true);
        if (!paramBoolean)
        {
          i = SmallScreenUtils.a(localSessionInfo.K);
          this.a.overridePendingTransition(0, i);
        }
        else
        {
          this.a.overridePendingTransition(0, 2130772219);
        }
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        paramString = SharedPreUtils.a(this.a.getApplicationContext()).edit();
        paramString.putInt("video_position", this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h());
        paramString.commit();
        DataReport.a(this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h());
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvWatchTogetherImmerseStatusChanged enable=");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(paramBoolean);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer != null) {
      this.a.jdField_a_of_type_ComTencentAvUiQavDoubleVideoSharpnessMangaer.a(paramBoolean, paramInt1, paramString, paramInt2);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.a.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onRecvWatchTogetherStatusChanged enter=");
      ((StringBuilder)localObject2).append(paramBoolean1);
      ((StringBuilder)localObject2).append(", admin=");
      ((StringBuilder)localObject2).append(paramBoolean2);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.a.findViewById(2131363124);
    Object localObject2 = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
    WatchTogetherUIProxy localWatchTogetherUIProxy = this.a.a(paramBoolean2);
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.a().a();
    if (localWatchTogetherMediaPlayCtrl == null) {
      return;
    }
    localWatchTogetherMediaPlayCtrl.a(this.a.jdField_h_of_type_Int);
    if (paramBoolean1)
    {
      a(localWatchTogetherMediaPlayCtrl, (View)localObject1, (VideoLayerUI)localObject2, localWatchTogetherUIProxy, paramBoolean2);
      return;
    }
    b(localWatchTogetherMediaPlayCtrl, (View)localObject1, (VideoLayerUI)localObject2, localWatchTogetherUIProxy, paramBoolean2);
  }
  
  @TargetApi(17)
  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvAudioFrame=");
      localStringBuilder.append(paramArrayOfByte.length);
      localStringBuilder.append(", type=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", size=");
      localStringBuilder.append(paramInt2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  protected void b()
  {
    super.b();
  }
  
  protected void b(int paramInt)
  {
    super.b(paramInt);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt);
      if (paramInt == 0)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.n(true);
        return;
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.n(false);
    }
  }
  
  protected void b(long paramLong)
  {
    String str = this.a.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResumeVideo, mIsDoubleVideoMeeting[");
    localStringBuilder.append(this.a.g);
    localStringBuilder.append("], mVideoLayerUI[");
    boolean bool;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], isResume[");
    localStringBuilder.append(this.a.isResume());
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i();
    }
    AVActivity.a(this.a);
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.a.isResume()))
    {
      str = this.a.jdField_a_of_type_ComTencentAvVideoController.a().c;
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str, 1, true, false, this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c));
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, 1, this.a.jdField_b_of_type_AndroidGraphicsBitmap, true, false);
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
  }
  
  protected void b(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong1, paramLong2, paramLong3);
    }
  }
  
  protected void b(long paramLong, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCloseSessionFinished, peerUin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], isQuit[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (paramString.equals(this.a.c)) {
      TraeHelper.a().a(paramLong, "DEVICE_SPEAKERPHONE");
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) && (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d() != 1)) {
      this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.m();
    }
  }
  
  protected void b(String paramString)
  {
    AVActivity.a(this.a, paramString);
  }
  
  protected void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString = this.a.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGroundGlassWaitTimeChange : nTime=");
      localStringBuilder.append(paramInt);
      QLog.d(paramString, 2, localStringBuilder.toString());
    }
    if ((2 == this.a.jdField_b_of_type_Int) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.f(paramInt);
    }
  }
  
  protected void b(String paramString, boolean paramBoolean)
  {
    String str = this.a.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFinish peerUin = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" # isQuit :");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("|");
    localStringBuilder.append(this.a.jdField_b_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append(this.a.c);
    AVLog.printAllUserLog(str, localStringBuilder.toString());
    if ((this.a.jdField_b_of_type_Int == 1) || (this.a.jdField_b_of_type_Int == 2))
    {
      if ((this.a.c != null) && (paramString != null) && (this.a.c.equals(paramString)))
      {
        paramString = this.a;
        paramString.jdField_e_of_type_Boolean = paramBoolean;
        paramString.finish();
        if (!paramBoolean)
        {
          int j = 2130772191;
          int i = j;
          if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
          {
            paramString = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
            i = j;
            if (paramString != null) {
              i = SmallScreenUtils.a(paramString.K);
            }
          }
          this.a.overridePendingTransition(0, i);
        }
        else
        {
          this.a.overridePendingTransition(0, 2130772219);
        }
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        paramString = SharedPreUtils.a(this.a.getApplicationContext()).edit();
        paramString.putInt("video_position", this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h());
        paramString.commit();
        DataReport.a(this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.h());
      }
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramBoolean);
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramBoolean1, paramBoolean2);
    }
  }
  
  protected void c()
  {
    long l = AudioHelper.b();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.a.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onPauseVideo, begin, seq[");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    Object localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      localObject2 = ((SessionInfo)localObject1).c;
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(l, (String)localObject2, 1, false, false, this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c));
      if (!((SessionInfo)localObject1).p()) {
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
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) && (this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi != null))
    {
      boolean bool1 = ((SessionInfo)localObject1).s;
      boolean bool2 = this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.isCameraOpened(l);
      boolean bool3 = ((SessionInfo)localObject1).k;
      boolean bool4 = ((SessionInfo)localObject1).az;
      boolean bool5 = ((SessionInfo)localObject1).aA;
      localObject1 = this.a.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onPauseVideo, hangup[");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append("], cameraOpen[");
      ((StringBuilder)localObject2).append(bool2);
      ((StringBuilder)localObject2).append("], remoteHasVideo[");
      ((StringBuilder)localObject2).append(bool3);
      ((StringBuilder)localObject2).append("], recording[");
      ((StringBuilder)localObject2).append(bool4);
      ((StringBuilder)localObject2).append("], recordedByOther[");
      ((StringBuilder)localObject2).append(bool5);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      if ((bool1) || (!bool3)) {
        if (bool4)
        {
          this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
          this.a.jdField_a_of_type_ComTencentAvVideoController.C();
          if (!bool1)
          {
            QavRecordReporter.a("0X8008ACB");
            if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
              TipsUtil.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1023, 2131695762);
            }
          }
        }
        else if (bool5)
        {
          this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.m();
        }
      }
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null) {
      this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a();
    }
  }
  
  protected void c(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      str = this.a.jdField_b_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("yiler onPlayAnnimate receive id:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d(str, 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.isDestroyed()) {
      return;
    }
    int i = VipFunCallUtil.a();
    String str = VipFunCallUtil.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, i, null);
    if (str == null) {
      return;
    }
    if ((new File(str).exists()) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 4) && (this.a.jdField_b_of_type_Int == 1) && (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null))
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.v();
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView == null)
      {
        localObject = this.a;
        ((AVActivity)localObject).jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView = VipFunCallManager.a((Activity)((AVActivity)localObject).jdField_a_of_type_JavaLangRefWeakReference.get(), (RelativeLayout)this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent(), false);
      }
      VipFunCallUtil.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), this.a.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView, str, i, this.a.jdField_a_of_type_ComTencentMobileqqVasVipavVipFunCallMediaListener, paramInt, false);
    }
    if (QLog.isColorLevel())
    {
      str = this.a.jdField_b_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("yiler onPlayAnnimate finish id:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d(str, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt1, paramInt2);
    }
  }
  
  protected void c(String paramString)
  {
    super.c(paramString);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramString);
    }
  }
  
  protected void c(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.a.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPeerSwitchTerminal, bStartSwitch[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString, paramBoolean);
    }
    ZimuToolbar.sendSupportionToPeer(this.a.jdField_a_of_type_ComTencentAvVideoController);
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().k))
    {
      paramString = this.a.jdField_a_of_type_ComTencentAvVideoController.a().c;
      paramBoolean = this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramString, paramBoolean);
    }
    QavVideoRecordUICtrl.a(this.a.jdField_a_of_type_ComTencentAvVideoController);
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      paramBoolean = this.a.jdField_a_of_type_ComTencentAvVideoController.a().az;
      boolean bool = this.a.jdField_a_of_type_ComTencentAvVideoController.a().aA;
      if (QLog.isColorLevel())
      {
        paramString = this.a.jdField_b_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPeerSwitchTerminal, recording=");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(", beenRecorded=");
        ((StringBuilder)localObject).append(bool);
        QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
      }
      if (paramBoolean)
      {
        if (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) {
          this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
        }
        this.a.jdField_a_of_type_ComTencentAvVideoController.C();
      }
      else if ((bool) && (this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver != null))
      {
        this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver.a("self", String.valueOf(3));
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().ay = false;
      if (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) {
        this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.n();
      }
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(paramBoolean);
    }
  }
  
  protected void d()
  {
    super.d();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.l(true);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.F();
    }
  }
  
  protected void d(String paramString)
  {
    if ((this.a.jdField_d_of_type_Int == 25) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString);
    }
    super.d(paramString);
  }
  
  protected void e()
  {
    super.e();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.l(false);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.G();
    }
  }
  
  protected void f()
  {
    if (this.a.isDestroyed()) {
      return;
    }
    AVActivity localAVActivity = this.a;
    WTogetherUtil.a(localAVActivity, localAVActivity.getResources().getString(2131696014));
  }
  
  protected void g()
  {
    super.g();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.j();
    }
  }
  
  protected void i()
  {
    if (QLog.isColorLevel())
    {
      String str = this.a.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNeedShowPeerVideo, mIsDoubleVideoMeeting[");
      localStringBuilder.append(this.a.g);
      localStringBuilder.append("], mPeerUin");
      localStringBuilder.append(this.a.c);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.k();
    }
  }
  
  protected void j()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.t();
    }
  }
  
  protected void k()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.u();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.MyVideoObserver
 * JD-Core Version:    0.7.0.1
 */