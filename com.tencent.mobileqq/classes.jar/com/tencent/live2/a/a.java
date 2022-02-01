package com.tencent.live2.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.h;
import com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType;
import com.tencent.live2.V2TXLiveDef.V2TXLiveFillMode;
import com.tencent.live2.V2TXLiveDef.V2TXLivePixelFormat;
import com.tencent.live2.V2TXLiveDef.V2TXLivePlayStatus;
import com.tencent.live2.V2TXLiveDef.V2TXLivePlayerStatistics;
import com.tencent.live2.V2TXLiveDef.V2TXLiveRotation;
import com.tencent.live2.V2TXLiveDef.V2TXLiveStatusChangeReason;
import com.tencent.live2.V2TXLiveDef.V2TXLiveTexture;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoFrame;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.live2.impl.a.a;
import com.tencent.live2.impl.b;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.TXLivePlayer.ITXAudioRawDataListener;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXLivePlayVideoRenderListener;
import com.tencent.rtmp.TXLivePlayer.ITXVideoRawDataListener;
import com.tencent.rtmp.TXLivePlayer.TXLiteAVTexture;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.Locale;

public class a
  extends V2TXLivePlayer
  implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, ITXLivePlayListener, TXLivePlayer.ITXAudioRawDataListener, TXLivePlayer.ITXAudioVolumeEvaluationListener, TXLivePlayer.ITXLivePlayVideoRenderListener, TXLivePlayer.ITXVideoRawDataListener
{
  private Context a;
  private V2TXLivePlayer b;
  private TXLivePlayer c;
  private TXLivePlayConfig d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private V2TXLiveDef.V2TXLivePlayerStatistics i;
  private V2TXLiveDef.V2TXLivePlayStatus j = V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped;
  private V2TXLiveDef.V2TXLivePlayStatus k = V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped;
  private boolean l;
  private V2TXLivePlayerObserver m;
  private boolean n;
  private TXCloudVideoView o;
  private TextureView p;
  private SurfaceView q;
  private int r = -1;
  
  public a(V2TXLivePlayer paramV2TXLivePlayer, Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramV2TXLivePlayer;
    this.i = new V2TXLiveDef.V2TXLivePlayerStatistics();
    this.c = new TXLivePlayer(this.a);
    this.c.setPlayListener(this);
    this.d = new TXLivePlayConfig();
    this.d.setConnectRetryInterval(3);
    this.d.setConnectRetryCount(3);
    this.c.setConfig(this.d);
    this.c.enableHardwareDecode(true);
    this.c.setAudioVolumeEvaluationListener(this);
  }
  
  public static int a(String paramString)
  {
    if ((!paramString.startsWith("rtmp://")) && (!paramString.startsWith("room://")) && (!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
      return -2;
    }
    return 0;
  }
  
  private void a()
  {
    c("stopPlayInner: ");
    this.e = false;
    this.f = false;
    this.h = false;
    this.g = false;
    this.i = new V2TXLiveDef.V2TXLivePlayerStatistics();
    c();
    this.c.stopPlay(true);
  }
  
  private void a(V2TXLiveDef.V2TXLivePlayStatus paramV2TXLivePlayStatus, V2TXLiveDef.V2TXLiveStatusChangeReason paramV2TXLiveStatusChangeReason)
  {
    if (!b.a(this.j, paramV2TXLivePlayStatus, paramV2TXLiveStatusChangeReason)) {
      return;
    }
    this.j = paramV2TXLivePlayStatus;
    paramV2TXLivePlayStatus = this.m;
    if (paramV2TXLivePlayStatus != null) {
      paramV2TXLivePlayStatus.onAudioPlayStatusUpdate(this.b, this.j, paramV2TXLiveStatusChangeReason, new Bundle());
    }
  }
  
  private int b(String paramString)
  {
    if (this.r != -1)
    {
      paramString = new StringBuilder();
      paramString.append("force set url type:");
      paramString.append(this.r);
      c(paramString.toString());
      return this.r;
    }
    if (paramString == null) {
      return 1;
    }
    if (paramString.startsWith("rtmp")) {
      return 0;
    }
    return 1;
  }
  
  private void b()
  {
    TXCloudVideoView localTXCloudVideoView = this.o;
    Object localObject1 = this.p;
    Object localObject2 = this.q;
    if (localTXCloudVideoView != null)
    {
      c("bindRenderView: cloud view.");
      this.c.setSurface(null);
      this.c.setSurfaceSize(0, 0);
      this.c.setPlayerView(localTXCloudVideoView);
      return;
    }
    if (localObject1 != null)
    {
      c("bindRenderView: texture view.");
      this.c.setPlayerView(null);
      localObject2 = ((TextureView)localObject1).getSurfaceTexture();
      ((TextureView)localObject1).setSurfaceTextureListener(this);
      if (localObject2 != null)
      {
        c("bindRenderView: surface texture is valid, set into player.");
        localObject2 = new Surface((SurfaceTexture)localObject2);
        this.c.setSurface((Surface)localObject2);
        this.c.setSurfaceSize(((TextureView)localObject1).getWidth(), ((TextureView)localObject1).getHeight());
      }
    }
    else if (localObject2 != null)
    {
      c("bindRenderView: surface view.");
      this.c.setPlayerView(null);
      ((SurfaceView)localObject2).getHolder().addCallback(this);
      localObject1 = ((SurfaceView)localObject2).getHolder().getSurface();
      if (((Surface)localObject1).isValid())
      {
        c("bindRenderView: surface is valid, set into player.");
        this.c.setSurface((Surface)localObject1);
        this.c.setSurfaceSize(((SurfaceView)localObject2).getWidth(), ((SurfaceView)localObject2).getHeight());
      }
    }
    else
    {
      d("bindRender: all view is null, bind fail.");
    }
  }
  
  private void b(V2TXLiveDef.V2TXLivePlayStatus paramV2TXLivePlayStatus, V2TXLiveDef.V2TXLiveStatusChangeReason paramV2TXLiveStatusChangeReason)
  {
    if (!b.a(this.k, paramV2TXLivePlayStatus, paramV2TXLiveStatusChangeReason)) {
      return;
    }
    this.k = paramV2TXLivePlayStatus;
    paramV2TXLivePlayStatus = this.m;
    if (paramV2TXLivePlayStatus != null) {
      paramV2TXLivePlayStatus.onVideoPlayStatusUpdate(this.b, this.j, paramV2TXLiveStatusChangeReason, new Bundle());
    }
  }
  
  private void c()
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      c("unbindRenderView: unbind texture view.");
      ((TextureView)localObject).setSurfaceTextureListener(null);
      this.c.setSurface(null);
      this.c.setSurfaceSize(0, 0);
    }
    localObject = this.q;
    if (localObject != null)
    {
      c("unbindRenderView: unbind surface view.");
      ((SurfaceView)localObject).getHolder().removeCallback(this);
      this.c.setSurface(null);
      this.c.setSurfaceSize(0, 0);
    }
  }
  
  private void c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v2_api_rtmp_player(");
    localStringBuilder.append(this);
    localStringBuilder.append(") ");
    localStringBuilder.append(paramString);
    TXCLog.i("V2-TXRTMPPlayerImpl", localStringBuilder.toString());
  }
  
  private void d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v2_api_rtmp_player(");
    localStringBuilder.append(this);
    localStringBuilder.append(") ");
    localStringBuilder.append(paramString);
    TXCLog.e("V2-TXRTMPPlayerImpl", localStringBuilder.toString());
  }
  
  private void e(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v2_api_rtmp_player(");
    localStringBuilder.append(this);
    localStringBuilder.append(") ");
    localStringBuilder.append(paramString);
    TXCLog.w("V2-TXRTMPPlayerImpl", localStringBuilder.toString());
  }
  
  public int enableCustomRendering(boolean paramBoolean, V2TXLiveDef.V2TXLivePixelFormat paramV2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType paramV2TXLiveBufferType)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVideoFrameObserver: enable-");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" format-");
    localStringBuilder.append(paramV2TXLivePixelFormat);
    localStringBuilder.append(" type-");
    localStringBuilder.append(paramV2TXLiveBufferType);
    c(localStringBuilder.toString());
    V2TXLiveDef.V2TXLivePixelFormat localV2TXLivePixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420;
    localStringBuilder = null;
    if ((paramV2TXLivePixelFormat == localV2TXLivePixelFormat) && (paramV2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray))
    {
      c("setVideoFrameObserver: use I420 array render.");
      this.c.setVideoRenderListener(null, null);
      paramV2TXLiveBufferType = this.c;
      paramV2TXLivePixelFormat = localStringBuilder;
      if (paramBoolean) {
        paramV2TXLivePixelFormat = this;
      }
      paramV2TXLiveBufferType.setVideoRawDataListener(paramV2TXLivePixelFormat);
      return 0;
    }
    if ((paramV2TXLivePixelFormat == V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D) && (paramV2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture))
    {
      c("setVideoFrameObserver: use texture render.");
      this.c.setVideoRawDataListener(null);
      paramV2TXLiveBufferType = this.c;
      if (paramBoolean) {
        paramV2TXLivePixelFormat = this;
      } else {
        paramV2TXLivePixelFormat = null;
      }
      paramV2TXLiveBufferType.setVideoRenderListener(paramV2TXLivePixelFormat, null);
      return 0;
    }
    this.c.setVideoRawDataListener(null);
    this.c.setVideoRenderListener(null, null);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVideoFrameObserver: format or type isn't support. force clean observer. format-");
    localStringBuilder.append(paramV2TXLivePixelFormat);
    localStringBuilder.append(" type-");
    localStringBuilder.append(paramV2TXLiveBufferType);
    d(localStringBuilder.toString());
    return -4;
  }
  
  public int enableVolumeEvaluation(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0)
    {
      e("enableVolumeEvaluation: invalid params.");
      i1 = 0;
    }
    this.c.enableAudioVolumeEvaluation(i1);
    return 0;
  }
  
  public int isPlaying()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onAudioInfoChanged(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAudioInfoChanged: sampleRate-");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" channels-");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" bits-");
    localStringBuilder.append(paramInt3);
    c(localStringBuilder.toString());
  }
  
  public void onAudioVolumeEvaluationNotify(int paramInt)
  {
    V2TXLivePlayerObserver localV2TXLivePlayerObserver = this.m;
    if (localV2TXLivePlayerObserver != null) {
      localV2TXLivePlayerObserver.onPlayoutVolumeUpdate(this.b, paramInt);
    }
  }
  
  public void onNetStatus(Bundle paramBundle)
  {
    try
    {
      localObject = h.a();
      if ((localObject != null) && (localObject.length == 2))
      {
        this.i.appCpu = (localObject[0] / 10);
        this.i.systemCpu = (localObject[1] / 10);
      }
      this.i.width = paramBundle.getInt("VIDEO_WIDTH");
      this.i.height = paramBundle.getInt("VIDEO_HEIGHT");
      this.i.fps = paramBundle.getInt("VIDEO_FPS");
      this.i.videoBitrate = paramBundle.getInt("VIDEO_BITRATE");
      this.i.audioBitrate = paramBundle.getInt("AUDIO_BITRATE");
    }
    catch (Exception localException)
    {
      Object localObject;
      label110:
      break label110;
    }
    localObject = this.m;
    if (localObject != null) {
      ((V2TXLivePlayerObserver)localObject).onStatisticsUpdate(this.b, this.i);
    }
    if ((localObject != null) && ((localObject instanceof com.tencent.live2.impl.a.a))) {
      ((com.tencent.live2.impl.a.a)localObject).onPlayNetStatus(paramBundle);
    }
  }
  
  public void onPcmDataAvailable(byte[] paramArrayOfByte, long paramLong) {}
  
  public void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPlayEvent event:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" param:");
    ((StringBuilder)localObject).append(paramBundle);
    c(((StringBuilder)localObject).toString());
    V2TXLivePlayerObserver localV2TXLivePlayerObserver = this.m;
    if (paramInt != -2301)
    {
      if (paramInt != 2007)
      {
        if (paramInt != 2026)
        {
          if (paramInt != 2105)
          {
            if (paramInt != 2003)
            {
              if ((paramInt == 2004) && (this.h))
              {
                c("onPlayEvent: loading finish.");
                this.h = false;
                if (this.f) {
                  a(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingEnd);
                }
                if (this.e) {
                  b(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingEnd);
                }
              }
            }
            else if (!this.e)
            {
              c("onPlayEvent: onRecvFirstVideoFrame.");
              this.e = true;
              b(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStarted);
            }
          }
          else if (localV2TXLivePlayerObserver != null)
          {
            V2TXLivePlayer localV2TXLivePlayer = this.b;
            if (paramBundle == null) {
              localObject = new Bundle();
            } else {
              localObject = paramBundle;
            }
            localV2TXLivePlayerObserver.onWarning(localV2TXLivePlayer, 2105, "player video block happen.", (Bundle)localObject);
          }
        }
        else if (!this.f)
        {
          c("onPlayEvent: onRecvFirstAudioFrame.");
          this.f = true;
          a(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStarted);
        }
      }
      else if (!this.h)
      {
        c("onPlayEvent: loading start.");
        this.h = true;
        if (this.f) {
          a(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusLoading, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingBegin);
        }
        if (this.e) {
          b(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusLoading, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingBegin);
        }
      }
    }
    else
    {
      d("onPlayEvent: stop play because of disconnect.");
      a();
      a(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStopped);
      b(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStopped);
    }
    if ((localV2TXLivePlayerObserver != null) && ((localV2TXLivePlayerObserver instanceof com.tencent.live2.impl.a.a))) {
      ((com.tencent.live2.impl.a.a)localV2TXLivePlayerObserver).onPlayEvent(paramInt, paramBundle);
    }
  }
  
  public void onRenderVideoFrame(TXLivePlayer.TXLiteAVTexture paramTXLiteAVTexture)
  {
    V2TXLivePlayerObserver localV2TXLivePlayerObserver = this.m;
    if ((localV2TXLivePlayerObserver != null) && (paramTXLiteAVTexture != null))
    {
      V2TXLiveDef.V2TXLiveVideoFrame localV2TXLiveVideoFrame = new V2TXLiveDef.V2TXLiveVideoFrame();
      localV2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D;
      localV2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture;
      localV2TXLiveVideoFrame.width = paramTXLiteAVTexture.width;
      localV2TXLiveVideoFrame.height = paramTXLiteAVTexture.height;
      localV2TXLiveVideoFrame.rotation = 0;
      localV2TXLiveVideoFrame.texture = new V2TXLiveDef.V2TXLiveTexture();
      localV2TXLiveVideoFrame.texture.textureId = paramTXLiteAVTexture.textureId;
      if ((paramTXLiteAVTexture.eglContext instanceof javax.microedition.khronos.egl.EGLContext)) {
        localV2TXLiveVideoFrame.texture.eglContext10 = ((javax.microedition.khronos.egl.EGLContext)paramTXLiteAVTexture.eglContext);
      } else if ((Build.VERSION.SDK_INT >= 17) && ((paramTXLiteAVTexture.eglContext instanceof android.opengl.EGLContext))) {
        localV2TXLiveVideoFrame.texture.eglContext14 = ((android.opengl.EGLContext)paramTXLiteAVTexture.eglContext);
      }
      localV2TXLivePlayerObserver.onRenderVideoFrame(this.b, localV2TXLiveVideoFrame);
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TextureView: available width-");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" height-");
    localStringBuilder.append(paramInt2);
    c(localStringBuilder.toString());
    if (paramSurfaceTexture != null) {
      this.c.setSurface(new Surface(paramSurfaceTexture));
    }
    this.c.setSurfaceSize(paramInt1, paramInt2);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    c("TextureView: destroyed.");
    this.c.setSurface(null);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    paramSurfaceTexture = new StringBuilder();
    paramSurfaceTexture.append("TextureView: size changed width-");
    paramSurfaceTexture.append(paramInt1);
    paramSurfaceTexture.append(" height-");
    paramSurfaceTexture.append(paramInt2);
    c(paramSurfaceTexture.toString());
    this.c.setSurfaceSize(paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void onVideoRawDataAvailable(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    V2TXLivePlayerObserver localV2TXLivePlayerObserver = this.m;
    if (localV2TXLivePlayerObserver != null)
    {
      V2TXLiveDef.V2TXLiveVideoFrame localV2TXLiveVideoFrame = new V2TXLiveDef.V2TXLiveVideoFrame();
      localV2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420;
      localV2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray;
      localV2TXLiveVideoFrame.data = paramArrayOfByte;
      localV2TXLiveVideoFrame.width = paramInt1;
      localV2TXLiveVideoFrame.height = paramInt2;
      localV2TXLiveVideoFrame.rotation = 0;
      localV2TXLivePlayerObserver.onRenderVideoFrame(this.b, localV2TXLiveVideoFrame);
    }
  }
  
  public int pauseAudio()
  {
    this.l = true;
    this.c.setMute(true);
    a(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped);
    return 0;
  }
  
  public int pauseVideo()
  {
    if (this.o != null) {
      this.c.setPlayerView(null);
    } else if ((this.q != null) || (this.p != null)) {
      this.c.setSurface(null);
    }
    if (this.e)
    {
      b(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStarted);
      if (this.h) {
        b(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusLoading, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingBegin);
      }
    }
    return 0;
  }
  
  public int resumeAudio()
  {
    this.l = false;
    this.c.setMute(false);
    if (this.f)
    {
      a(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStarted);
      if (this.h) {
        a(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusLoading, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingBegin);
      }
    }
    return 0;
  }
  
  public int resumeVideo()
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      this.c.setPlayerView((TXCloudVideoView)localObject);
    }
    else
    {
      localObject = this.p;
      if (localObject != null)
      {
        localObject = ((TextureView)localObject).getSurfaceTexture();
        if (localObject != null) {
          this.c.setSurface(new Surface((SurfaceTexture)localObject));
        }
      }
      else
      {
        localObject = this.q;
        if (localObject != null)
        {
          localObject = ((SurfaceView)localObject).getHolder().getSurface();
          if (((Surface)localObject).isValid()) {
            this.c.setSurface((Surface)localObject);
          }
        }
      }
    }
    b(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStarted);
    return 0;
  }
  
  public int setCacheParams(float paramFloat1, float paramFloat2)
  {
    float f1;
    if (paramFloat1 > paramFloat2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("force fix error params. min:");
      ((StringBuilder)localObject).append(paramFloat2);
      ((StringBuilder)localObject).append(" max:");
      ((StringBuilder)localObject).append(paramFloat1);
      e(((StringBuilder)localObject).toString());
      f1 = paramFloat2;
    }
    else
    {
      f1 = paramFloat1;
      paramFloat1 = paramFloat2;
    }
    this.d.setCacheTime(paramFloat1);
    this.d.setMaxAutoAdjustCacheTime(paramFloat1);
    this.d.setMinAutoAdjustCacheTime(f1);
    Object localObject = this.d;
    boolean bool;
    if (f1 != paramFloat1) {
      bool = true;
    } else {
      bool = false;
    }
    ((TXLivePlayConfig)localObject).setAutoAdjustCacheTime(bool);
    return 0;
  }
  
  public void setObserver(V2TXLivePlayerObserver paramV2TXLivePlayerObserver)
  {
    this.m = paramV2TXLivePlayerObserver;
  }
  
  public int setPlayoutVolume(int paramInt)
  {
    this.c.setVolume(paramInt);
    return 0;
  }
  
  public int setProperty(String paramString, Object paramObject)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1120433643: 
      if (paramString.equals("setSurface")) {
        i1 = 0;
      }
      break;
    case 787234457: 
      if (paramString.equals("enableRecvSEIMessage")) {
        i1 = 2;
      }
      break;
    case 480042124: 
      if (paramString.equals("setSurfaceSize")) {
        i1 = 1;
      }
      break;
    case 190314931: 
      if (paramString.equals("setPlayURLType")) {
        i1 = 3;
      }
      break;
    }
    int i1 = -1;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return 0;
          }
          if ((paramObject != null) && ((paramObject instanceof Integer)))
          {
            this.r = ((Integer)paramObject).intValue();
            return 0;
          }
        }
        else if ((paramObject != null) && ((paramObject instanceof Boolean)))
        {
          this.d.setEnableMessage(((Boolean)paramObject).booleanValue());
          this.c.setConfig(this.d);
          return 0;
        }
      }
      else if ((paramObject != null) && ((paramObject instanceof a.a)))
      {
        paramString = (a.a)paramObject;
        this.c.setSurfaceSize(paramString.a, paramString.b);
        return 0;
      }
    }
    else
    {
      if (paramObject == null)
      {
        this.c.setSurface(null);
        return 0;
      }
      if ((paramObject instanceof Surface)) {
        this.c.setSurface((Surface)paramObject);
      }
    }
    return 0;
  }
  
  public int setRenderFillMode(V2TXLiveDef.V2TXLiveFillMode paramV2TXLiveFillMode)
  {
    V2TXLiveDef.V2TXLiveFillMode localV2TXLiveFillMode = paramV2TXLiveFillMode;
    if (paramV2TXLiveFillMode == null)
    {
      e("setRenderFillMode: param is null, fix it.");
      localV2TXLiveFillMode = V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFill;
    }
    this.c.setRenderMode(b.a(localV2TXLiveFillMode));
    return 0;
  }
  
  public int setRenderRotation(V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation)
  {
    V2TXLiveDef.V2TXLiveRotation localV2TXLiveRotation = paramV2TXLiveRotation;
    if (paramV2TXLiveRotation == null)
    {
      e("setRenderRotation: param is null, fix it.");
      localV2TXLiveRotation = V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation0;
    }
    this.c.setRenderRotation(b.a(localV2TXLiveRotation));
    return 0;
  }
  
  public int setRenderView(SurfaceView paramSurfaceView)
  {
    c();
    this.q = paramSurfaceView;
    b();
    return 0;
  }
  
  public int setRenderView(TextureView paramTextureView)
  {
    c();
    this.p = paramTextureView;
    b();
    return 0;
  }
  
  public int setRenderView(TXCloudVideoView paramTXCloudVideoView)
  {
    c();
    if (paramTXCloudVideoView != null) {
      paramTXCloudVideoView.showLog(this.n);
    }
    this.o = paramTXCloudVideoView;
    b();
    return 0;
  }
  
  public void showDebugView(boolean paramBoolean)
  {
    this.n = paramBoolean;
    TXCloudVideoView localTXCloudVideoView = this.o;
    if (localTXCloudVideoView != null) {
      localTXCloudVideoView.showLog(paramBoolean);
    }
  }
  
  public int snapshot()
  {
    this.c.snapshot(new a.1(this));
    return 0;
  }
  
  public int startPlay(String paramString)
  {
    int i1 = b(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startPlay: url-");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" type-");
    localStringBuilder.append(i1);
    c(localStringBuilder.toString());
    c();
    b();
    this.e = false;
    this.f = false;
    this.j = V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped;
    this.k = V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped;
    this.h = false;
    this.g = true;
    this.c.setConfig(this.d);
    this.c.callExperimentalAPI(String.format(Locale.ENGLISH, "{\"api\":\"setInterfaceType\", \"params\": {\"type\":%d}}", new Object[] { Integer.valueOf(1) }));
    i1 = this.c.startPlay(paramString, i1);
    this.c.setMute(this.l);
    if (i1 != 0)
    {
      d("startPlay: play fail, force stop.");
      a();
    }
    return 0;
  }
  
  public int stopPlay()
  {
    c("stopPlay:");
    if (!this.g)
    {
      e("stopPlay: player have been stop.");
      return 0;
    }
    a();
    a(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped);
    b(V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped);
    return 0;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    c("SurfaceView: onSizeChanged.");
    this.c.setSurfaceSize(paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    c("SurfaceView: onCreate.");
    this.c.setSurface(paramSurfaceHolder.getSurface());
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    c("SurfaceView: onDestroyed.");
    this.c.setSurface(null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.a.a
 * JD-Core Version:    0.7.0.1
 */