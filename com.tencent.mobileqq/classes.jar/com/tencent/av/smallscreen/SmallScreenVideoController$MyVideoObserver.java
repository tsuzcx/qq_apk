package com.tencent.av.smallscreen;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.QavVideoRecordUICtrl;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class SmallScreenVideoController$MyVideoObserver
  extends VideoObserver
{
  SmallScreenVideoController$MyVideoObserver(SmallScreenVideoController paramSmallScreenVideoController) {}
  
  protected void a(long paramLong)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onConnected, seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenVideoController", 1, ((StringBuilder)localObject).toString());
    }
    VideoNodeManager.a(32);
    if (this.b.u != null) {
      this.b.u.S();
    }
    if (this.b.s.k().g == 2)
    {
      this.b.s.k().b(paramLong, this.b.p ^ true);
      if (this.b.p) {
        this.b.r.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
      }
      if (this.b.u != null)
      {
        localObject = this.b.s.k().s;
        boolean bool = this.b.s.k().I;
        this.b.u.a((String)localObject, 1, bool, false, this.b.s.h(this.b.k));
      }
    }
    if (this.b.s.k().g == 1) {
      this.b.s.k().b(paramLong, false);
    }
    if (this.b.u != null) {
      this.b.u.a(0, 0, true);
    }
    if (this.b.r.isBackgroundStop) {
      this.b.s.p();
    }
    if (this.b.t != null) {
      this.b.t.a();
    }
    EffectZimuManager.a(this.b.s);
    QavVideoRecordUICtrl.a(this.b.s);
  }
  
  protected void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onDetectNoDevicePermission, DeviceType[");
      ((StringBuilder)???).append(paramInt);
      ((StringBuilder)???).append("], seq[");
      ((StringBuilder)???).append(paramLong);
      ((StringBuilder)???).append("]");
      QLog.w("SmallScreenVideoController", 1, ((StringBuilder)???).toString());
    }
    if ((paramInt == 2) || (paramInt == 1))
    {
      this.b.z.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
      paramLong = Long.valueOf(this.b.r.getCurrentAccountUin()).longValue();
      paramInt = this.b.s.k().b(paramLong, 1);
      if (paramInt == -1) {
        return;
      }
      this.b.s.k().bi.remove(paramInt);
      synchronized (this.b.s.k().bk)
      {
        paramInt = this.b.s.k().c(paramLong, 1);
        if (paramInt == -1) {
          return;
        }
        this.b.s.k().bk.remove(paramInt);
        return;
      }
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClose, reason[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], peerUin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("SmallScreenVideoController", 1, localStringBuilder.toString());
    }
    if (!TextUtils.equals(paramString, this.b.s.k().s)) {
      return;
    }
    this.b.v.closeCamera(paramLong, false);
    if (this.b.s.k().p == 1011)
    {
      this.b.u.a(paramString, 1, false, false, this.b.s.h(this.b.k));
      this.b.u.a(false, false);
      this.b.u.B();
    }
    if (this.b.t != null) {
      this.b.t.e(paramInt);
    }
  }
  
  protected void a(RecvMsg paramRecvMsg)
  {
    super.a(paramRecvMsg);
    if ((this.b.u != null) && (this.b.s != null)) {
      this.b.u.a(0, 0, true);
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    this.b.b(paramInt);
  }
  
  protected void a(String paramString1, int paramInt, String paramString2) {}
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (this.b.t != null) {
      this.b.t.a(paramString1, paramString2);
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[random room owner] onDestroyUI isQuit = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", mSessionType = ");
      localStringBuilder.append(this.b.g);
      QLog.d("SmallScreenVideoController", 2, localStringBuilder.toString());
    }
    super.a(paramString, paramBoolean);
    if ((this.b.r != null) && (this.b.r.a() != null)) {
      this.b.r.a().postDelayed(new SmallScreenVideoController.MyVideoObserver.2(this, paramString, paramBoolean), 1500L);
    }
  }
  
  protected void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (this.b.u != null)
    {
      paramString2 = new StringBuilder();
      paramString2.append("notifyPeerAvatar2DSwitch opend=");
      paramString2.append(paramBoolean);
      paramString2.append(" remoteHasVideo=");
      paramString2.append(this.b.s.k().I);
      paramString2.append(" localHasVideo=");
      paramString2.append(this.b.s.k().H);
      QLog.d("SmallScreenVideoController", 1, paramString2.toString());
      if ((!this.b.s.k().I) && (!this.b.s.k().H)) {
        if (paramBoolean)
        {
          paramString2 = this.b.s.k().s;
          this.b.u.a(paramString2, 1, true, false, this.b.s.h(this.b.k));
          this.b.u.a(this.b.s.k().s, 1, this.b.w, true, false);
        }
        else
        {
          this.b.r.a(new Object[] { Integer.valueOf(15), Long.valueOf(AudioHelper.c()) });
        }
      }
      this.b.s.k().a(false, paramBoolean);
      this.b.u.a(paramString1, 1, paramBoolean);
    }
  }
  
  protected void a(String paramString, byte[] paramArrayOfByte)
  {
    if ((this.b.s.k().cw) && (this.b.u != null)) {
      this.b.u.a(paramString, paramArrayOfByte);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.f().aA();
    if (localWatchTogetherMediaPlayCtrl == null) {
      return;
    }
    if (paramBoolean1) {
      return;
    }
    localWatchTogetherMediaPlayCtrl.a("float-onRecvWatchTogetherStatusChanged", null);
    localWatchTogetherMediaPlayCtrl.z();
    localWatchTogetherMediaPlayCtrl.A();
    CameraUtils.a(this.b.c).setCameraSensorMode(false);
  }
  
  protected void b(int paramInt)
  {
    super.b(paramInt);
    if (this.b.t != null) {
      this.b.t.c(paramInt);
    }
  }
  
  protected void b(long paramLong)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResumeVideo, seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenVideoController", 1, ((StringBuilder)localObject).toString());
    }
    if (this.b.u != null)
    {
      localObject = this.b.s.k().s;
      this.b.u.a((String)localObject, 1, true, false, this.b.s.h(this.b.k));
      this.b.u.a(this.b.s.k().s, 1, this.b.w, true, false);
    }
  }
  
  protected void b(String paramString, int paramInt)
  {
    if (paramInt != this.b.s.k().bT)
    {
      paramString = new StringBuilder();
      paramString.append("setGlassWaitTime nTime=");
      paramString.append(paramInt);
      paramString.append(", mCurrentVideoGlassWaitTime=");
      paramString.append(this.b.s.k().bT);
      QLog.d("SmallScreenVideoController", 1, paramString.toString());
    }
    this.b.s.k().bT = paramInt;
  }
  
  protected void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("peerUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" # isQuit :");
      localStringBuilder.append(paramBoolean);
      QLog.d("SmallScreenVideoController", 2, localStringBuilder.toString());
    }
    if ((this.b.g == 1) || (this.b.g == 2))
    {
      if ((this.b.k != null) && (paramString != null) && (this.b.k.equals(paramString)))
      {
        paramString = this.b;
        paramString.o = paramBoolean;
        paramString.d();
      }
      if (this.b.u != null)
      {
        paramString = SharedPreUtils.B(this.b.c).edit();
        paramString.putInt("video_position", this.b.u.ac());
        paramString.commit();
      }
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (this.b.t != null) {
      this.b.t.b(paramBoolean);
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.b.t != null) {
      this.b.t.a(paramBoolean1, paramBoolean2);
    }
  }
  
  protected void c()
  {
    long l = AudioHelper.c();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPauseVideo, seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenVideoController", 1, ((StringBuilder)localObject).toString());
    }
    if (this.b.u != null)
    {
      SmallScreenVideoController.a(this.b, 1);
      localObject = this.b.s.k().s;
      this.b.u.a((String)localObject, 1, false, false, this.b.s.h(this.b.k));
    }
    if ((this.b.s.k().p == 1011) && (this.b.s.k().H))
    {
      this.b.v.closeCamera(l, true);
      if (this.b.s.k().aY == 3) {
        this.b.s.k().aY = 0;
      }
    }
  }
  
  protected void c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("yiler onPlayAnnimate receive id:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SmallScreenVideoController", 2, ((StringBuilder)localObject).toString());
    }
    int i = VipFunCallUtil.c();
    Object localObject = VipFunCallUtil.a(this.b.r, paramInt, i, null);
    if (localObject == null) {
      return;
    }
    if ((new File((String)localObject).exists()) && (this.b.s.k().i != 4) && (this.b.g == 1) && (this.b.u != null)) {
      this.b.u.T();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("yiler onPlayAnnimate finish id:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SmallScreenVideoController", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void c(String paramString, boolean paramBoolean)
  {
    if (this.b.t != null) {
      this.b.t.a(paramString, paramBoolean);
    }
    EffectZimuManager.a(this.b.s);
    if ((this.b.u != null) && (this.b.s.k().I))
    {
      paramString = this.b.s.k().s;
      paramBoolean = this.b.s.h(this.b.k);
      this.b.u.a(paramString, paramBoolean);
    }
    QavVideoRecordUICtrl.a(this.b.s);
  }
  
  protected void d()
  {
    super.d();
    if (this.b.t != null) {
      this.b.t.t();
    }
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRequestVideoMode fromUin = ");
      localStringBuilder.append(paramString);
      QLog.d("SmallScreenVideoController", 2, localStringBuilder.toString());
    }
    this.b.s.k().aY = 2;
    this.b.b();
  }
  
  protected void e()
  {
    super.e();
    if (this.b.t != null) {
      this.b.t.u();
    }
  }
  
  public void e(String paramString)
  {
    long l = AudioHelper.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAcceptVideoMode, fromUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w("SmallScreenVideoController", 1, localStringBuilder.toString());
    this.b.s.k().aY = 3;
    this.b.v.openCamera(l);
    if (this.b.u != null)
    {
      this.b.u.a(true, false);
      this.b.u.c(l, this.b.v.isFrontCamera());
    }
  }
  
  protected void f()
  {
    ThreadManager.getUIHandler().post(new SmallScreenVideoController.MyVideoObserver.1(this));
  }
  
  public void f(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRejectVideoMode fromUin = ");
      localStringBuilder.append(paramString);
      QLog.d("SmallScreenVideoController", 2, localStringBuilder.toString());
    }
    this.b.s.k().aY = 0;
  }
  
  protected void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      TipsUtil.a(this.b.r, 3017);
      return;
    }
    TipsUtil.b(this.b.r, 3017);
  }
  
  protected void g(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCancelVideoMode fromUin = ");
      localStringBuilder.append(paramString);
      QLog.d("SmallScreenVideoController", 2, localStringBuilder.toString());
    }
    super.g(paramString);
    this.b.s.k().aY = 0;
  }
  
  protected void j()
  {
    if (this.b.t != null) {
      this.b.t.d();
    }
  }
  
  protected void k()
  {
    if (this.b.t != null) {
      this.b.t.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.MyVideoObserver
 * JD-Core Version:    0.7.0.1
 */