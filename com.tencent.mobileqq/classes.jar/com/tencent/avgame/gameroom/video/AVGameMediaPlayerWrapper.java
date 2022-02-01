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
  private int jdField_a_of_type_Int = -1;
  private Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private AVGameMediaPlayerWrapper.OnAVGameMediaPlayerCallBack jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper$OnAVGameMediaPlayerCallBack;
  private AVGameMediaPlayerCtrl.CustomHandler jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler;
  private volatile ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = true;
  private boolean d = false;
  private boolean e = false;
  
  private boolean b()
  {
    return this.e;
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewSurface;
    if (localObject != null)
    {
      ((Surface)localObject).release();
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
    if (localObject != null)
    {
      ((SurfaceTexture)localObject).setOnFrameAvailableListener(null);
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    }
    int i = this.jdField_a_of_type_Int;
    if (i != -1)
    {
      GlUtil.deleteTexture(i);
      this.jdField_a_of_type_Int = -1;
    }
  }
  
  private void e()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "initMediaPlayer");
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 107, null);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      d();
      this.jdField_a_of_type_Int = GlUtil.createTexture(36197);
      GLES20.glBindTexture(36197, 0);
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_Int);
      if (Build.VERSION.SDK_INT >= 21) {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this, this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler);
      } else {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
      }
      this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setSurface(this.jdField_a_of_type_AndroidViewSurface);
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoPreparedListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCaptureImageListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnInfoListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnErrorListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnDefinitionInfoListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnTVideoNetInfoUpdateListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoSizeChangedListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnSeekCompleteListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnAudioFrameOutputListener(this);
  }
  
  private void f()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "releaseMediaPlayer");
    AVGameMediaPlayerCtrl.CustomHandler localCustomHandler = this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler;
    if (localCustomHandler != null) {
      localCustomHandler.post(new AVGameMediaPlayerWrapper.6(this));
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
  }
  
  public SurfaceTexture a()
  {
    return this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  }
  
  public void a()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "releaseMgrRes");
    f();
  }
  
  public void a(AVGameMediaPlayerWrapper.OnAVGameMediaPlayerCallBack paramOnAVGameMediaPlayerCallBack, AVGameMediaPlayerCtrl.CustomHandler paramCustomHandler)
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "addAVGameMediaPlayerCallBack");
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper$OnAVGameMediaPlayerCallBack = paramOnAVGameMediaPlayerCallBack;
    this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler = paramCustomHandler;
  }
  
  public void a(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playAudioByUrl url:=");
    localStringBuilder.append(paramString);
    QLog.d("AVGameMediaPlayerWrapper", 1, localStringBuilder.toString());
    this.jdField_a_of_type_JavaLangString = paramString;
    this.e = false;
    this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler.post(new AVGameMediaPlayerWrapper.3(this, paramLong));
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOutputMute(this.c);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying());
  }
  
  public void b()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "stopVideoPlay");
    AVGameMediaPlayerCtrl.CustomHandler localCustomHandler = this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler;
    if (localCustomHandler != null) {
      localCustomHandler.post(new AVGameMediaPlayerWrapper.5(this));
    }
  }
  
  public void b(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playVideoByUrl url:=");
    localStringBuilder.append(paramString);
    QLog.d("AVGameMediaPlayerWrapper", 1, localStringBuilder.toString());
    this.jdField_a_of_type_JavaLangString = paramString;
    this.e = false;
    this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler.post(new AVGameMediaPlayerWrapper.4(this, paramLong));
  }
  
  public void c()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "doDestroy");
    f();
    if (!b()) {
      AVGameExceptionReporter.a().a(4, this.jdField_a_of_type_JavaLangString, 0, null);
    }
  }
  
  public void onAudioFrameOutput(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    AVGameMediaPlayerWrapper.OnAVGameMediaPlayerCallBack localOnAVGameMediaPlayerCallBack = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper$OnAVGameMediaPlayerCallBack;
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
    paramISuperPlayer.append(this.jdField_a_of_type_JavaLangString);
    QLog.d("AVGameMediaPlayerWrapper", 1, paramISuperPlayer.toString());
    paramISuperPlayer = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper$OnAVGameMediaPlayerCallBack;
    if (paramISuperPlayer != null) {
      if (this.jdField_a_of_type_Boolean) {
        paramISuperPlayer.d(this.jdField_a_of_type_JavaLangString);
      } else {
        paramISuperPlayer.b(this.jdField_a_of_type_JavaLangString);
      }
    }
    this.e = true;
    AVGameExceptionReporter.a().a(2, this.jdField_a_of_type_JavaLangString, 0, null);
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
    AVGameExceptionReporter.a().a(3, this.jdField_a_of_type_JavaLangString, paramInt3, paramString);
    if (!this.jdField_a_of_type_Boolean) {
      ReportController.b(null, "dc00898", "", "", "0X800B0E7", "0X800B0E7", 0, 0, "", "", "", "");
    } else {
      ReportController.b(null, "dc00898", "", "", "0X800B1F4", "0X800B1F4", 0, 0, "", "", "", "");
    }
    return false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if (this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler != null)
    {
      if (this.b)
      {
        this.b = false;
        paramSurfaceTexture = new StringBuilder();
        paramSurfaceTexture.append("onFrameAvailable avalibale:= + ");
        paramSurfaceTexture.append(this.jdField_a_of_type_JavaLangString);
        QLog.d("AVGameMediaPlayerWrapper", 1, paramSurfaceTexture.toString());
      }
      if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null) {
        return;
      }
      long l = System.currentTimeMillis();
      paramSurfaceTexture = this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler.obtainMessage(256, this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y, Long.valueOf(l));
      this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler.sendMessage(paramSurfaceTexture);
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
    paramISuperPlayer = this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.post(new AVGameMediaPlayerWrapper.9(this));
    }
  }
  
  public void onTVideoNetInfoUpdate(ISuperPlayer paramISuperPlayer, TVideoNetInfo paramTVideoNetInfo) {}
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "onVideoPrepared");
    paramISuperPlayer = this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler;
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