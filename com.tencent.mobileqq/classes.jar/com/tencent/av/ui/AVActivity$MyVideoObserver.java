package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
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
import com.tencent.av.business.manager.avatar2d.Avatar2dItem;
import com.tencent.av.business.manager.avatar2d.EffectAvatar2dManager;
import com.tencent.av.business.manager.filter.EffectFilterTools.DataReport;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.business.manager.pendant.EffectPendantTools.DataReport;
import com.tencent.av.business.manager.pendant.ItemBase;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.business.manager.zimu.EffectZimuManager.DataReport;
import com.tencent.av.camera.AndroidCamera;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.screenshare.ScreenShareReportHelper;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView;
import com.tencent.av.ui.effect.toolbar.oldversion.BeautyToolbar.DataReport;
import com.tencent.av.ui.funchat.record.QavRecordReporter;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.wtogether.callback.WatchTogetherUIProxy;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.widget.QQToast;
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
    SessionInfo localSessionInfo = this.b.I.k();
    localSessionInfo.c(this.b.K.af ^ true);
    AVActivity.d(this.b);
    paramView = this.b;
    boolean bool = false;
    paramView.a(1, false);
    int i;
    if (paramVideoLayerUI != null)
    {
      if ((this.b.V == 0) || (this.b.V == 180)) {
        bool = true;
      }
      if (bool) {
        i = 1;
      } else {
        i = 2;
      }
      paramVideoLayerUI.l(i);
      paramView = this.b.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enterWatchTogetherStatus, portrait[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.d(paramView, 1, localStringBuilder.toString());
      paramView = paramVideoLayerUI.D();
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
    paramWatchTogetherUIProxy.setImmersiveStatus(localSessionInfo.ct);
    paramWatchTogetherMediaPlayCtrl.a(paramWatchTogetherUIProxy);
    if (!paramWatchTogetherMediaPlayCtrl.u())
    {
      paramWatchTogetherMediaPlayCtrl.a(paramView);
      return;
    }
    this.b.H.a().postDelayed(new AVActivity.MyVideoObserver.1(this, paramWatchTogetherMediaPlayCtrl, paramView), 200L);
  }
  
  private void b(WatchTogetherMediaPlayCtrl paramWatchTogetherMediaPlayCtrl, View paramView, VideoLayerUI paramVideoLayerUI, WatchTogetherUIProxy paramWatchTogetherUIProxy, boolean paramBoolean)
  {
    this.b.setRequestedOrientation(1);
    QLog.d(this.b.i, 1, "quitWatchTogetherStatus, displayRotation[ActivityInfo.SCREEN_ORIENTATION_PORTRAIT]");
    this.b.a(1, false);
    if (paramVideoLayerUI != null) {
      paramVideoLayerUI.l(0);
    }
    paramWatchTogetherUIProxy.setSeekBarChangeListener(null);
    paramWatchTogetherUIProxy.setWatchTogetherMediaPlayerProxy(null);
    paramWatchTogetherUIProxy.setWatchTogetherParams(false, paramBoolean);
    paramWatchTogetherMediaPlayCtrl.b(paramWatchTogetherUIProxy);
    paramWatchTogetherMediaPlayCtrl.a("full-onRecvWatchTogetherStatusChanged", null);
    paramWatchTogetherMediaPlayCtrl.z();
    paramWatchTogetherMediaPlayCtrl.A();
  }
  
  protected void a()
  {
    super.a();
    if (this.b.K != null)
    {
      this.b.K.q();
      this.b.K.h();
    }
    if (this.b.H != null)
    {
      if (this.b.j != null) {
        this.b.H.b(this.b.e, this.b.j, this.b.p);
      }
      Object localObject;
      if (this.b.I != null)
      {
        localObject = this.b;
        ((AVActivity)localObject).f = ((AVActivity)localObject).I.k().az;
        localObject = this.b;
        ((AVActivity)localObject).t = ((AVActivity)localObject).I.k().aB;
      }
      if (QLog.isColorLevel())
      {
        localObject = this.b.i;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setBindInfo: mBindType = ");
        localStringBuilder.append(this.b.f);
        localStringBuilder.append(",mBindId = ");
        localStringBuilder.append(this.b.t);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      this.b.H.c(this.b.f, this.b.t);
    }
    if (this.b.ah == null) {
      AVActivity.c(this.b);
    }
  }
  
  protected void a(int paramInt) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (this.b.af != null) {
      this.b.af.a(paramInt1, paramInt2);
    }
  }
  
  @TargetApi(21)
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    long l = AudioHelper.c();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.b.i;
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
    Object localObject1 = this.b.I;
    if (localObject1 == null)
    {
      QLog.i("AVShare", 1, "onShareStateChange, ctrl is null.");
      return;
    }
    localObject1 = ((VideoController)localObject1).k();
    if ((((SessionInfo)localObject1).aQ == paramInt3) && (((SessionInfo)localObject1).aN == paramLong))
    {
      if (paramInt2 == 1)
      {
        if (((SessionInfo)localObject1).cj == 3)
        {
          localObject2 = this.b.v();
          if (localObject2 != null) {
            ((ScreenRecordHelper)localObject2).b(3);
          }
        }
        else if (((SessionInfo)localObject1).cj == 2)
        {
          this.b.K.D(l);
          localObject2 = SessionMgr.a().b();
          ScreenShareReportHelper.b("0X800AD8F", ScreenShareReportHelper.a((SessionInfo)localObject2), String.valueOf(ScreenShareReportHelper.a(((SessionInfo)localObject2).f)));
        }
        if (((SessionInfo)localObject1).cj == 5) {
          this.b.K.E(l);
        }
      }
      this.b.runOnUiThread(new AVActivity.MyVideoObserver.2(this));
      return;
    }
    QLog.i("AVShare", 1, "onShareStateChange, not same session");
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2) {}
  
  protected void a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b.i);
    ((StringBuilder)localObject).append(".onConnected");
    AudioHelper.b(((StringBuilder)localObject).toString());
    localObject = this.b.I.k();
    VideoNodeManager.a(31);
    String str1 = ((SessionInfo)localObject).s;
    String str2 = this.b.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onConnected, mVideoLayerUI[");
    boolean bool;
    if (this.b.L != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], peerUin[");
    localStringBuilder.append(str1);
    localStringBuilder.append("], mShutCamera[");
    localStringBuilder.append(this.b.z);
    localStringBuilder.append("], SessionType[");
    localStringBuilder.append(((SessionInfo)localObject).g);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str2, 1, localStringBuilder.toString());
    if (this.b.L != null) {
      this.b.L.S();
    }
    if ((((SessionInfo)localObject).g != 2) && (((SessionInfo)localObject).g != 4))
    {
      this.b.b(true);
      this.b.f(true);
    }
    else
    {
      this.b.b(false);
      this.b.f(false);
    }
    if (((SessionInfo)localObject).g == 2)
    {
      if (this.b.z)
      {
        ((SessionInfo)localObject).b(paramLong, false);
        this.b.H.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
      }
      if (this.b.L != null)
      {
        str1 = ((SessionInfo)localObject).s;
        bool = ((SessionInfo)localObject).I;
        this.b.L.a(paramLong, str1, 1, bool, false, this.b.I.h(this.b.j));
      }
    }
    if (((SessionInfo)localObject).g == 1) {
      ((SessionInfo)localObject).b(paramLong, false);
    }
    this.b.I.c(paramLong);
    this.b.h(paramLong);
    if (this.b.H.isBackgroundStop) {
      this.b.I.p();
    }
    if (this.b.K != null)
    {
      this.b.K.e(paramLong);
      if ((2 == ((SessionInfo)localObject).g) || (this.b.A)) {
        this.b.K.c(paramLong, "onConnected");
      }
    }
    if (this.b.K != null) {
      this.b.K.ak();
    }
    EffectZimuManager.a(this.b.I);
    DoodleLogic.b().e();
    QavVideoRecordUICtrl.a(this.b.I);
    this.b.H.a().postDelayed(this.b.F, 200L);
    this.b.ab.a(paramLong, this.b, 4, 0);
    if (this.b.ai != null) {
      this.b.ai.e();
    }
  }
  
  protected void a(long paramLong, int paramInt)
  {
    if (this.b.K != null) {
      this.b.K.c(paramLong, paramInt);
    }
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2)
  {
    if ((this.b.I.k().cv) && ((paramInt1 != AVActivity.x()) || (paramInt2 != AVActivity.y())))
    {
      AVActivity.b(this.b, paramInt2);
      AVActivity.c(this.b, paramInt1);
      return;
    }
    if (this.b.M != null) {
      this.b.M.reopenCamera("AVnotify", paramLong, paramInt1, paramInt2);
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString)
  {
    String str = this.b.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClose, reason[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], peerUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], mPeerUin[");
    localStringBuilder.append(this.b.j);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if ((paramString != null) && (!UITools.b(paramString, this.b.j))) {
      return;
    }
    if ((paramInt == 49) && (this.b.I != null) && (this.b.I.k().cB) && (this.b.ad != null)) {
      this.b.ad.e();
    }
    if ((this.b.N != null) && (this.b.N.e())) {
      this.b.N.g();
    }
    if ((this.b.K != null) && ((this.b.K instanceof DoubleVideoCtrlUI))) {
      this.b.K.a(paramLong, paramInt);
    }
    AVLog.printColorLog(this.b.i, "DataReport onClose: ");
    EffectPendantTools.DataReport.a(this.b.i, this.b.H);
    EffectZimuManager.DataReport.a(this.b.H);
    EffectFilterTools.DataReport.a(this.b.H);
    BeautyToolbar.DataReport.b(this.b.H.getCurrentAccountUin());
    VoiceChangeDataReport.a(this.b.I.k());
    MultiVideoRichActionReportCollection.a(this.b.H);
    paramString = new StringBuilder();
    paramString.append(this.b.H.b().p(this.b.H.b().k().s));
    paramString.append("");
    paramString = paramString.toString();
    MagicDataReport.a(this.b.H, paramString);
    MagicDataReport.a(2, paramString);
    MagicDataReport.a(2);
    this.b.ab.a(paramLong, this.b, 3, 2);
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.b.af != null) {
      this.b.af.a(paramLong1, paramLong2, paramLong3);
    }
  }
  
  protected void a(long paramLong, String paramString, boolean paramBoolean)
  {
    if (this.b.K != null) {
      this.b.K.a(paramLong, paramString, paramBoolean);
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    if (this.b.K != null) {
      this.b.K.b(paramLong, paramBoolean);
    }
  }
  
  protected void a(RecvMsg paramRecvMsg)
  {
    super.a(paramRecvMsg);
    if ((this.b.L != null) && (this.b.I != null))
    {
      this.b.h(-1033L);
      this.b.L.a(paramRecvMsg);
      int i = this.b.I.k().g;
      if ((i != 1) && (i != 2))
      {
        this.b.L.f(true);
        this.b.L.n(1);
        return;
      }
      this.b.L.f(false);
      this.b.L.n(2);
    }
  }
  
  protected void a(String paramString)
  {
    AVActivity.a(this.b, paramString);
  }
  
  protected void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.b.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGroundGlassSwitch, fromUin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], nOff[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], mSessionType[");
      localStringBuilder.append(this.b.b);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if ((2 == this.b.b) && (this.b.K != null)) {
      this.b.K.g(paramInt);
    }
  }
  
  protected void a(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = this.b.aj;
    boolean bool2 = false;
    paramString1.removeMessages(0);
    boolean bool1;
    if (this.b.K != null)
    {
      paramString1 = this.b.K.am();
      if (paramString1 != null)
      {
        if (paramInt == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramString1.a(bool1, this.b.I.k().cv ^ true);
      }
    }
    paramString1 = this.b.i;
    paramString2 = new StringBuilder();
    paramString2.append("[onRspAvatar2DSwitch] errCode[");
    paramString2.append(paramInt);
    paramString2.append("] isLocalAvatar2DInUsing[");
    paramString2.append(this.b.I.k().cv);
    paramString2.append("].");
    QLog.d(paramString1, 1, paramString2.toString());
    if (paramInt == 0)
    {
      long l = AudioHelper.c();
      paramString1 = this.b.I.k().s;
      if (!this.b.I.k().cv)
      {
        this.b.I.k().a(true, true);
        if ((this.b.M != null) && (!this.b.M.isCameraOpened(l)))
        {
          this.b.I.k().b(true, true);
          this.b.X.a(false, l);
          QLog.d(this.b.i, 1, "[onRspAvatar2DSwitch] onRequest_OpenCamera.");
        }
        else if (this.b.I != null)
        {
          this.b.I.ar();
        }
        if ((AndroidCamera.b != AVActivity.x()) || (AndroidCamera.c != AVActivity.y()))
        {
          AVActivity.c(this.b, AndroidCamera.b);
          AVActivity.b(this.b, AndroidCamera.c);
          this.b.H.a(new Object[] { Integer.valueOf(32), Integer.valueOf(AVActivity.x()), Integer.valueOf(AVActivity.y()), Long.valueOf(l) });
        }
        if (this.b.I.k().cx) {
          paramInt = 1;
        } else {
          paramInt = 2;
        }
        ReportController.b(null, "dc00898", "", "", "0X800BCDD", "0X800BCDD", paramInt, 0, "", "", "", "");
      }
      else
      {
        this.b.L.i(1);
        if (this.b.I.k().cx)
        {
          this.b.X.c(l);
          this.b.I.k().b(true, false);
          QLog.d(this.b.i, 1, "[onRspAvatar2DSwitch] onRequest_CloseCamera.");
        }
        else
        {
          this.b.L.K();
          if ((AndroidCamera.b != AVActivity.e(this.b)) || (AndroidCamera.c != AVActivity.f(this.b))) {
            this.b.H.a(new Object[] { Integer.valueOf(32), Integer.valueOf(AVActivity.e(this.b)), Integer.valueOf(AVActivity.f(this.b)), Long.valueOf(l) });
          }
        }
        if ((!this.b.I.k().I) && (!this.b.I.k().cw))
        {
          this.b.L.a(l, paramString1, 1);
          QLog.d(this.b.i, 1, "[onRspAvatar2DSwitch] closePeerVideo.");
        }
        this.b.I.k().a(true, false);
      }
      if (this.b.K != null)
      {
        bool1 = bool2;
        if (this.b.I.k().cw)
        {
          bool1 = bool2;
          if (this.b.I.k().cv) {
            bool1 = true;
          }
        }
        this.b.K.a(l, this.b.I.k().cv, bool1);
      }
    }
    else
    {
      QQToast.makeText(this.b.getApplicationContext(), "对方版本暂不支持变身", 1).show();
      ((EffectAvatar2dManager)this.b.H.c(16)).a(AudioHelper.c(), null);
      ReportController.b(null, "dc00898", "", "", "0X800BCE6", "0X800BCE6", 0, 0, "", "", "", "");
    }
  }
  
  protected void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    int m = (int)(0x3 & paramLong);
    int j = (int)(paramLong >> 4 & 0x7);
    int k = (int)(0x7 & paramLong >> 7);
    if (QLog.isColorLevel()) {
      QLog.d(this.b.i, 2, String.format("onNetLevel_S2C, peerUin[%s], level[%s], detail[%s], netLevel[%s], s2cSelfNetLevel[%s], s2cPeerNetLevel[%s]", new Object[] { paramString, Long.valueOf(paramLong), paramArrayOfByte, Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k) }));
    }
    if (this.b.K != null)
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
      this.b.K.a(i, j, k, paramString);
    }
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    if ((this.b.e == 25) && (this.b.K != null)) {
      this.b.K.a(paramString, paramBitmap);
    }
    super.a(paramString, paramBitmap);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (this.b.K != null) {
      this.b.K.a(paramString1, paramString2);
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (this.b.I == null) {
      return;
    }
    long l = AudioHelper.c();
    SessionInfo localSessionInfo = this.b.I.k();
    String str = this.b.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroyUI, peerUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], isQuit[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], mPeerUin[");
    localStringBuilder.append(this.b.j);
    localStringBuilder.append("], mIsDoubleVideoMeeting[");
    localStringBuilder.append(this.b.A);
    localStringBuilder.append("], mSessionType[");
    localStringBuilder.append(this.b.b);
    localStringBuilder.append("], mSessionId[");
    localStringBuilder.append(this.b.d);
    localStringBuilder.append("], mRelationId[");
    localStringBuilder.append(this.b.k);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("], \nsession[");
    localStringBuilder.append(localSessionInfo);
    localStringBuilder.append("]");
    AVLog.printAllUserLog(str, localStringBuilder.toString());
    int i;
    if ((this.b.b != 1) && (this.b.b != 2))
    {
      if ((this.b.b == 3) || (this.b.b == 4))
      {
        str = this.b.k;
        if (((str != null) && (paramString != null) && (str.equals(paramString))) || ((this.b.A) && (TextUtils.equals(this.b.j, paramString))))
        {
          paramString = this.b;
          paramString.y = paramBoolean;
          AVLog.printAllUserLog(paramString.i, "onDestroyUI exit 2");
          this.b.c(l);
          paramString = this.b;
          paramString.B = true;
          paramString.finish();
          this.b.b(true);
          if (!paramBoolean)
          {
            i = SmallScreenUtils.a(localSessionInfo.bB);
            this.b.overridePendingTransition(0, i);
            return;
          }
          this.b.overridePendingTransition(0, 2130772285);
        }
      }
    }
    else
    {
      if ((this.b.j != null) && (paramString != null) && (this.b.j.equals(paramString)))
      {
        paramString = this.b;
        paramString.y = paramBoolean;
        AVLog.printAllUserLog(paramString.i, "onDestroyUI exit 1");
        this.b.finish();
        this.b.b(true);
        if (!paramBoolean)
        {
          i = SmallScreenUtils.a(localSessionInfo.bB);
          this.b.overridePendingTransition(0, i);
        }
        else
        {
          this.b.overridePendingTransition(0, 2130772285);
        }
      }
      if (this.b.L != null)
      {
        paramString = SharedPreUtils.B(this.b.getApplicationContext()).edit();
        paramString.putInt("video_position", this.b.L.ac());
        paramString.commit();
        DataReport.a(this.b.L.ac());
      }
    }
  }
  
  protected void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    long l = AudioHelper.c();
    if (paramBoolean)
    {
      boolean bool = AEFilterSupport.b();
      AVActivity.b(this.b, bool ^ true);
      if (!bool)
      {
        TipsUtil.a(this.b.H, 1016, "对方开启了变身，当前设备暂不支持显示");
        ReportController.b(null, "dc00898", "", "", "0X800BCE4", "0X800BCE4", 0, 0, "", "", "", "");
      }
    }
    else if (AVActivity.g(this.b))
    {
      TipsUtil.b(this.b.H, 1016);
      return;
    }
    this.b.L.a(paramString1, 1, paramBoolean);
    if (this.b.K != null) {
      this.b.K.e(l, paramBoolean);
    }
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = (EffectAvatar2dManager)this.b.H.c(16);
        localObject = (Avatar2dItem)paramString1.b(paramString2);
        if ((localObject != null) && (!((Avatar2dItem)localObject).isUsable()) && (!TextUtils.isEmpty(((Avatar2dItem)localObject).getResUrl())))
        {
          paramString1.b(l, (ItemBase)localObject);
          this.b.H.a(new Object[] { Integer.valueOf(525), Boolean.valueOf(true) });
          paramString1 = this.b.i;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("notifyPeerAvatar2DSwitch startDownload: ");
          ((StringBuilder)localObject).append(paramString2);
          QLog.d(paramString1, 1, ((StringBuilder)localObject).toString());
        }
      }
      if (!this.b.I.k().I)
      {
        QLog.d(this.b.i, 1, "[notifyPeerAvatar2DSwitch] opened:  Need Close peer View.");
        this.b.I.k().b(false, true);
      }
      if ((!this.b.I.k().I) && (!this.b.I.k().H) && (!this.b.I.k().cv))
      {
        if (this.b.K != null)
        {
          this.b.K.j();
          this.b.I.k().a(l, "onResumeVideo", 1);
        }
        TipsUtil.a(this.b.H, 1016, "对方开启了变身");
        paramString1 = this.b.aj.obtainMessage();
        paramString1.what = 1;
        this.b.aj.sendMessageDelayed(paramString1, 3000L);
        QLog.d(this.b.i, 1, "[notifyPeerAvatar2DSwitch] open : head view for local.");
      }
      paramString1 = this.b.K;
      Object localObject = this.b.getApplicationContext();
      if ((this.b.M != null) && (!this.b.M.isCameraOpened(AudioHelper.c()))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramString1.a((Context)localObject, paramBoolean, paramString2);
      this.b.I.k().a(false, true);
      return;
    }
    QLog.d(this.b.i, 1, "[notifyPeerAvatar2DSwitch] close.");
    if (this.b.I.k().cy)
    {
      QLog.d(this.b.i, 1, "[notifyPeerAvatar2DSwitch] close. closePeerVideo");
      this.b.L.a(l, paramString1, 1);
      this.b.I.k().b(false, false);
    }
    else if ((this.b.I.k().I) && (!this.b.I.k().H) && (!this.b.I.k().cv))
    {
      QLog.d(this.b.i, 1, "[notifyPeerAvatar2DSwitch] close. just close self video.");
      this.b.L.f(l);
    }
    this.b.I.k().a(false, false);
    if ((!this.b.I.k().I) && (!this.b.I.k().H) && (!this.b.I.k().cv) && (this.b.K != null)) {
      this.b.K.i();
    }
  }
  
  protected void a(String paramString, byte[] paramArrayOfByte)
  {
    if ((this.b.L != null) && (this.b.I.k().cw) && (!AVActivity.g(this.b)) && (this.b.L.a(paramString, paramArrayOfByte)))
    {
      QLog.d(this.b.i, 1, "[onRecvAvatar2DAIData] use New view.");
      if ((!this.b.I.k().I) && (!this.b.I.k().cw))
      {
        QLog.d(this.b.i, 1, "[onRecvAvatar2DAIData] need Close remote View.");
        this.b.I.k().b(false, true);
      }
      this.b.I.k().a(false, true);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.b.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvWatchTogetherImmerseStatusChanged enable=");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.b.L != null) {
      this.b.L.d(paramBoolean);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    if (this.b.af != null) {
      this.b.af.a(paramBoolean, paramInt1, paramString, paramInt2);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.b.i;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onRecvWatchTogetherStatusChanged enter=");
      ((StringBuilder)localObject2).append(paramBoolean1);
      ((StringBuilder)localObject2).append(", admin=");
      ((StringBuilder)localObject2).append(paramBoolean2);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.b.findViewById(2131428977);
    Object localObject2 = this.b.L;
    WatchTogetherUIProxy localWatchTogetherUIProxy = this.b.d(paramBoolean2);
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.f().aA();
    if (localWatchTogetherMediaPlayCtrl == null) {
      return;
    }
    localWatchTogetherMediaPlayCtrl.a(this.b.V);
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
      String str = this.b.i;
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
    if (this.b.K != null)
    {
      this.b.K.b(paramInt);
      if (paramInt == 0)
      {
        this.b.K.q(true);
        return;
      }
      this.b.K.q(false);
    }
  }
  
  protected void b(long paramLong)
  {
    String str = this.b.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResumeVideo, mIsDoubleVideoMeeting[");
    localStringBuilder.append(this.b.A);
    localStringBuilder.append("], mVideoLayerUI[");
    boolean bool;
    if (this.b.L != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], isResume[");
    localStringBuilder.append(this.b.isResume());
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (this.b.K != null) {
      this.b.K.j();
    }
    AVActivity.a(this.b);
    if ((this.b.L != null) && (this.b.isResume()))
    {
      str = this.b.I.k().s;
      this.b.L.a(paramLong, str, 1, true, false, this.b.I.h(this.b.j));
      this.b.L.a(paramLong, this.b.I.k().s, 1, this.b.P, true, false);
    }
    if ((this.b.K != null) && ((2 == this.b.I.k().g) || (this.b.A))) {
      this.b.K.c(paramLong, "onResumeVideo");
    }
    if (this.b.J != null) {
      this.b.J.b();
    }
    if (this.b.ai != null) {
      this.b.ai.e();
    }
  }
  
  protected void b(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.b.K != null) {
      this.b.K.a(paramLong1, paramLong2, paramLong3);
    }
  }
  
  protected void b(long paramLong, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.b.i;
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
    if (paramString.equals(this.b.j)) {
      TraeHelper.a().a(paramLong, "DEVICE_SPEAKERPHONE");
    }
    if ((this.b.ad != null) && (this.b.ad.o() != 1)) {
      this.b.ad.D();
    }
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    if (this.b.K != null) {
      this.b.K.b(paramString);
    }
  }
  
  protected void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString = this.b.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGroundGlassWaitTimeChange : nTime=");
      localStringBuilder.append(paramInt);
      QLog.d(paramString, 2, localStringBuilder.toString());
    }
    if ((2 == this.b.b) && (this.b.K != null)) {
      this.b.K.h(paramInt);
    }
  }
  
  protected void b(String paramString, boolean paramBoolean)
  {
    String str = this.b.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFinish peerUin = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" # isQuit :");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("|");
    localStringBuilder.append(this.b.b);
    localStringBuilder.append("|");
    localStringBuilder.append(this.b.j);
    AVLog.printAllUserLog(str, localStringBuilder.toString());
    if ((this.b.b == 1) || (this.b.b == 2))
    {
      if ((this.b.j != null) && (paramString != null) && (this.b.j.equals(paramString)))
      {
        paramString = this.b;
        paramString.y = paramBoolean;
        paramString.finish();
        if (!paramBoolean)
        {
          int j = 2130772257;
          int i = j;
          if (this.b.I != null)
          {
            paramString = this.b.I.k();
            i = j;
            if (paramString != null) {
              i = SmallScreenUtils.a(paramString.bB);
            }
          }
          this.b.overridePendingTransition(0, i);
        }
        else
        {
          this.b.overridePendingTransition(0, 2130772285);
        }
      }
      if (this.b.L != null)
      {
        paramString = SharedPreUtils.B(this.b.getApplicationContext()).edit();
        paramString.putInt("video_position", this.b.L.ac());
        paramString.commit();
        DataReport.a(this.b.L.ac());
      }
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (this.b.K != null) {
      this.b.K.c(paramBoolean);
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.b.K != null) {
      this.b.K.b(paramBoolean1, paramBoolean2);
    }
  }
  
  protected void c()
  {
    long l = AudioHelper.c();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.b.i;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onPauseVideo, begin, seq[");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (this.b.I == null) {
      return;
    }
    Object localObject1 = this.b.I.k();
    if (this.b.L != null)
    {
      localObject2 = ((SessionInfo)localObject1).s;
      this.b.L.a(l, (String)localObject2, 1, false, false, this.b.I.h(this.b.j));
      if ((!((SessionInfo)localObject1).p()) && (!((SessionInfo)localObject1).cv)) {
        this.b.a(1, false);
      }
    }
    if (this.b.K != null)
    {
      this.b.K.i();
      this.b.K.f(l, 16777215);
    }
    if (this.b.af != null) {
      this.b.af.c();
    }
    if (this.b.J != null) {
      this.b.J.b();
    }
    if ((this.b.I != null) && (this.b.ad != null) && (this.b.M != null))
    {
      boolean bool1 = ((SessionInfo)localObject1).R;
      boolean bool2 = this.b.M.isCameraOpened(l);
      boolean bool3 = ((SessionInfo)localObject1).I;
      boolean bool4 = ((SessionInfo)localObject1).cB;
      boolean bool5 = ((SessionInfo)localObject1).cD;
      localObject1 = this.b.i;
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
          this.b.ad.e();
          this.b.I.au();
          if (!bool1)
          {
            QavRecordReporter.a("0X8008ACB");
            if (this.b.H != null) {
              TipsUtil.a(this.b.H, 1023, 2131893521);
            }
          }
        }
        else if (bool5)
        {
          this.b.ad.D();
        }
      }
    }
    if (this.b.ai != null) {
      this.b.ai.e();
    }
  }
  
  protected void c(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      str = this.b.i;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("yiler onPlayAnnimate receive id:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d(str, 2, ((StringBuilder)localObject).toString());
    }
    if (this.b.isDestroyed()) {
      return;
    }
    int i = VipFunCallUtil.c();
    String str = VipFunCallUtil.a(this.b.H, paramInt, i, null);
    if (str == null) {
      return;
    }
    if ((new File(str).exists()) && (this.b.I.k().i != 4) && (this.b.b == 1) && (this.b.G != null) && (this.b.G.getParent() != null))
    {
      if (this.b.L != null) {
        this.b.L.T();
      }
      if (this.b.Y == null)
      {
        localObject = this.b;
        ((AVActivity)localObject).Y = VipFunCallManager.a((Activity)((AVActivity)localObject).Z.get(), (RelativeLayout)this.b.G.getParent(), false);
      }
      VipFunCallUtil.a(this.b.H.getApp().getApplicationContext(), this.b.Y, str, i, this.b.am, paramInt, false);
    }
    if (QLog.isColorLevel())
    {
      str = this.b.i;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("yiler onPlayAnnimate finish id:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d(str, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    if (this.b.K != null) {
      this.b.K.a(paramInt1, paramInt2);
    }
  }
  
  protected void c(String paramString)
  {
    if ((this.b.e == 25) && (this.b.K != null)) {
      this.b.K.a(paramString);
    }
    super.c(paramString);
  }
  
  protected void c(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.b.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPeerSwitchTerminal, bStartSwitch[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.b.K != null) {
      this.b.K.a(paramString, paramBoolean);
    }
    EffectZimuManager.a(this.b.I);
    if ((this.b.L != null) && (this.b.I.k().I))
    {
      paramString = this.b.I.k().s;
      paramBoolean = this.b.I.h(this.b.j);
      this.b.L.a(paramString, paramBoolean);
    }
    QavVideoRecordUICtrl.a(this.b.I);
    if (this.b.I != null)
    {
      paramBoolean = this.b.I.k().cB;
      boolean bool = this.b.I.k().cD;
      if (QLog.isColorLevel())
      {
        paramString = this.b.i;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPeerSwitchTerminal, recording=");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(", beenRecorded=");
        ((StringBuilder)localObject).append(bool);
        QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
      }
      if (paramBoolean)
      {
        if (this.b.ad != null) {
          this.b.ad.e();
        }
        this.b.I.au();
      }
      else if ((bool) && (this.b.X != null))
      {
        this.b.X.a("self", String.valueOf(3));
      }
      this.b.I.k().cA = false;
      if (this.b.ad != null) {
        this.b.ad.E();
      }
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    if (this.b.K != null) {
      this.b.K.d(paramBoolean);
    }
  }
  
  protected void d()
  {
    super.d();
    if (this.b.K != null)
    {
      this.b.K.o(true);
      this.b.K.W();
    }
  }
  
  protected void e()
  {
    super.e();
    if (this.b.K != null)
    {
      this.b.K.o(false);
      this.b.K.X();
    }
  }
  
  protected void f()
  {
    if (this.b.isDestroyed()) {
      return;
    }
    AVActivity localAVActivity = this.b;
    WTogetherUtil.a(localAVActivity, localAVActivity.getResources().getString(2131893776));
  }
  
  protected void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      TipsUtil.a(this.b.H, 3017);
      return;
    }
    TipsUtil.b(this.b.H, 3017);
  }
  
  protected void g()
  {
    super.g();
    if (this.b.K != null) {
      this.b.K.k();
    }
  }
  
  protected void i()
  {
    if (QLog.isColorLevel())
    {
      String str = this.b.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNeedShowPeerVideo, mIsDoubleVideoMeeting[");
      localStringBuilder.append(this.b.A);
      localStringBuilder.append("], mPeerUin");
      localStringBuilder.append(this.b.j);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.b.K != null) {
      this.b.K.l();
    }
  }
  
  protected void j()
  {
    if (this.b.K != null) {
      this.b.K.x();
    }
  }
  
  protected void k()
  {
    if (this.b.K != null) {
      this.b.K.y();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.MyVideoObserver
 * JD-Core Version:    0.7.0.1
 */