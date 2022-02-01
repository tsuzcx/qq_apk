package com.tencent.avgame.gameroom.video;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.avgame.qav.AVGameMediaPlayerCtrl.CustomHandler;
import com.tencent.avgame.report.exception.AVGameExceptionReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnAudioFrameOutputListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnDefinitionInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import java.util.ArrayList;

public class AVGameMediaPlayerWrapper
  implements SurfaceTexture.OnFrameAvailableListener, SDKInitListener, ISuperPlayer.OnAudioFrameOutputListener, ISuperPlayer.OnCaptureImageListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnDefinitionInfoListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnTVideoNetInfoListener, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnVideoSizeChangedListener
{
  private volatile ISuperPlayer a;
  private String b;
  private boolean c = false;
  private boolean d = false;
  private boolean e = true;
  private boolean f = false;
  private Point g = new Point();
  private int h = -1;
  private Surface i;
  private SurfaceTexture j;
  private AVGameMediaPlayerWrapper.OnAVGameMediaPlayerCallBack k;
  private AVGameMediaPlayerCtrl.CustomHandler l;
  private boolean m = false;
  
  private void h()
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      ((Surface)localObject).release();
      this.i = null;
    }
    localObject = this.j;
    if (localObject != null)
    {
      ((SurfaceTexture)localObject).setOnFrameAvailableListener(null);
      this.j.release();
      this.j = null;
    }
    int n = this.h;
    if (n != -1)
    {
      GlUtil.deleteTexture(n);
      this.h = -1;
    }
  }
  
  private void i()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "initMediaPlayer");
    if (this.a == null)
    {
      boolean bool = QQVideoPlaySDKManager.isSDKReady();
      ISuperPlayer localISuperPlayer = null;
      if (bool) {
        localISuperPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 107, null);
      }
      this.a = localISuperPlayer;
    }
    if (this.a == null)
    {
      QLog.d("AVGameMediaPlayerWrapper", 1, "initMediaPlayer fail");
      return;
    }
    if (!this.c)
    {
      h();
      this.h = GlUtil.createTexture(36197);
      GLES20.glBindTexture(36197, 0);
      this.j = new SurfaceTexture(this.h);
      if (Build.VERSION.SDK_INT >= 21) {
        this.j.setOnFrameAvailableListener(this, this.l);
      } else {
        this.j.setOnFrameAvailableListener(this);
      }
      this.i = new Surface(this.j);
      this.a.setSurface(this.i);
    }
    this.a.setOnVideoPreparedListener(this);
    this.a.setOnCaptureImageListener(this);
    this.a.setOnInfoListener(this);
    this.a.setOnErrorListener(this);
    this.a.setOnDefinitionInfoListener(this);
    this.a.setOnTVideoNetInfoUpdateListener(this);
    this.a.setOnCompletionListener(this);
    this.a.setOnVideoSizeChangedListener(this);
    this.a.setOnSeekCompleteListener(this);
    this.a.setOnAudioFrameOutputListener(this);
  }
  
  private boolean j()
  {
    return this.m;
  }
  
  private void k()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "releaseMediaPlayer");
    AVGameMediaPlayerCtrl.CustomHandler localCustomHandler = this.l;
    if (localCustomHandler != null) {
      localCustomHandler.post(new AVGameMediaPlayerWrapper.6(this));
    }
  }
  
  public long a()
  {
    if (this.a != null) {
      return this.a.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public void a(AVGameMediaPlayerWrapper.OnAVGameMediaPlayerCallBack paramOnAVGameMediaPlayerCallBack, AVGameMediaPlayerCtrl.CustomHandler paramCustomHandler)
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "addAVGameMediaPlayerCallBack");
    this.k = paramOnAVGameMediaPlayerCallBack;
    this.l = paramCustomHandler;
  }
  
  public void a(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playAudioByUrl url:=");
    localStringBuilder.append(paramString);
    QLog.d("AVGameMediaPlayerWrapper", 1, localStringBuilder.toString());
    this.b = paramString;
    this.m = false;
    this.l.post(new AVGameMediaPlayerWrapper.3(this, paramLong));
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (this.a != null) {
      this.a.setOutputMute(this.e);
    }
  }
  
  public void b()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "releaseMgrRes");
    k();
  }
  
  public void b(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playVideoByUrl url:=");
    localStringBuilder.append(paramString);
    QLog.d("AVGameMediaPlayerWrapper", 1, localStringBuilder.toString());
    this.b = paramString;
    this.m = false;
    this.l.post(new AVGameMediaPlayerWrapper.4(this, paramLong));
  }
  
  public void c()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "stopVideoPlay");
    AVGameMediaPlayerCtrl.CustomHandler localCustomHandler = this.l;
    if (localCustomHandler != null) {
      localCustomHandler.post(new AVGameMediaPlayerWrapper.5(this));
    }
  }
  
  public boolean d()
  {
    return (this.a != null) && (this.a.isPlaying());
  }
  
  public int e()
  {
    return this.h;
  }
  
  public SurfaceTexture f()
  {
    return this.j;
  }
  
  public void g()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "doDestroy");
    k();
    if (!j()) {
      AVGameExceptionReporter.a().a(4, this.b, 0, null);
    }
  }
  
  public void onAudioFrameOutput(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    AVGameMediaPlayerWrapper.OnAVGameMediaPlayerCallBack localOnAVGameMediaPlayerCallBack = this.k;
    if (localOnAVGameMediaPlayerCallBack != null) {
      localOnAVGameMediaPlayerCallBack.a(paramTPAudioFrameBuffer);
    }
  }
  
  public void onCaptureImageFailed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2) {}
  
  public void onCaptureImageSucceed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap) {}
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer = new StringBuilder();
    paramISuperPlayer.append("onCompletion url:=");
    paramISuperPlayer.append(this.b);
    QLog.d("AVGameMediaPlayerWrapper", 1, paramISuperPlayer.toString());
    paramISuperPlayer = this.k;
    if (paramISuperPlayer != null) {
      if (this.c) {
        paramISuperPlayer.d(this.b);
      } else {
        paramISuperPlayer.b(this.b);
      }
    }
    this.m = true;
    AVGameExceptionReporter.a().a(2, this.b, 0, null);
  }
  
  public void onDefinitionInfoUpdate(ISuperPlayer paramISuperPlayer, String paramString, ArrayList<String> paramArrayList) {}
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramISuperPlayer = new StringBuilder();
    paramISuperPlayer.append("PlayerCaptureProxy onError: module = ");
    paramISuperPlayer.append(paramInt1);
    paramISuperPlayer.append(", errorType = ");
    paramISuperPlayer.append(paramInt2);
    paramISuperPlayer.append(", errorCode = ");
    paramISuperPlayer.append(paramInt3);
    paramISuperPlayer.append(", extraInfo = ");
    paramISuperPlayer.append(paramString);
    QLog.e("AVGameMediaPlayerWrapper", 1, paramISuperPlayer.toString());
    AVGameExceptionReporter.a().a(3, this.b, paramInt3, paramString);
    if (!this.c) {
      ReportController.b(null, "dc00898", "", "", "0X800B0E7", "0X800B0E7", 0, 0, "", "", "", "");
    } else {
      ReportController.b(null, "dc00898", "", "", "0X800B1F4", "0X800B1F4", 0, 0, "", "", "", "");
    }
    return false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if (this.l != null)
    {
      if (this.d)
      {
        this.d = false;
        paramSurfaceTexture = new StringBuilder();
        paramSurfaceTexture.append("onFrameAvailable avalibale:= + ");
        paramSurfaceTexture.append(this.b);
        QLog.d("AVGameMediaPlayerWrapper", 1, paramSurfaceTexture.toString());
      }
      if (this.a == null) {
        return;
      }
      long l1 = System.currentTimeMillis();
      paramSurfaceTexture = this.l.obtainMessage(256, this.g.x, this.g.y, Long.valueOf(l1));
      this.l.sendMessage(paramSurfaceTexture);
    }
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return false;
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSDKInited b:=");
    localStringBuilder.append(paramBoolean);
    QLog.d("AVGameMediaPlayerWrapper", 1, localStringBuilder.toString());
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "onSeekComplete");
    paramISuperPlayer = this.l;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.post(new AVGameMediaPlayerWrapper.9(this));
    }
  }
  
  public void onTVideoNetInfoUpdate(ISuperPlayer paramISuperPlayer, TVideoNetInfo paramTVideoNetInfo) {}
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "onVideoPrepared");
    paramISuperPlayer = this.l;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.post(new AVGameMediaPlayerWrapper.8(this));
    }
  }
  
  public void onVideoSizeChanged(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper
 * JD-Core Version:    0.7.0.1
 */