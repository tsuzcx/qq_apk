package com.tencent.mobileqq.ar.ARRenderModel;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARNativeBridge.ARCardAnimationCallback;
import com.tencent.mobileqq.ar.ARVideoUtil;
import com.tencent.mobileqq.ar.arengine.ARResouceDir;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoUtil;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoView;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoView.DrawCallback;
import com.tencent.mobileqq.arcard.ARCardUtils;
import com.tencent.mobileqq.arcard.ARGreetingCardListManager;
import com.tencent.mobileqq.arcard.ARGreetingCardListManager.GreetingCardItem;
import com.tencent.mobileqq.arcard.ARGreetingCardListManager.RenderProxy;
import com.tencent.mobileqq.arcard.ARcardSound;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.sensor.ARSensorManager;
import com.tencent.mobileqq.armap.sensor.SimpleSensorChangeListener;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import zvx;
import zvy;
import zvz;
import zwa;
import zwb;
import zwd;
import zwe;
import zwf;
import zwg;
import zwh;
import zwi;

public class GreetingCardRender
  implements SurfaceTexture.OnFrameAvailableListener, ARNativeBridge.ARCardAnimationCallback, ARBaseRender, AROnlineVideoView.DrawCallback, ARGreetingCardListManager.RenderProxy, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnVideoPreparedListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private ARNativeBridge jdField_a_of_type_ComTencentMobileqqArARNativeBridge;
  private ARRenderMangerInnerCallback jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback;
  private GreetingCardResourceInfo jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardResourceInfo;
  private GreetingYUVProgram jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingYUVProgram = new GreetingYUVProgram(0);
  private AROnlineVideoView jdField_a_of_type_ComTencentMobileqqArOnline_videoAROnlineVideoView;
  private ARGreetingCardListManager.GreetingCardItem jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$GreetingCardItem;
  private ARcardSound jdField_a_of_type_ComTencentMobileqqArcardARcardSound;
  private ARSensorManager jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager;
  private SimpleSensorChangeListener jdField_a_of_type_ComTencentMobileqqArmapSensorSimpleSensorChangeListener = new zwb(this);
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private Runnable jdField_a_of_type_JavaLangRunnable = new zvx(this);
  private final String jdField_a_of_type_JavaLangString = "bgmusic.mp3";
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer = new ByteBuffer[3];
  private volatile int jdField_b_of_type_Int;
  private RenderBuffer jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private boolean jdField_b_of_type_Boolean;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  private volatile int jdField_c_of_type_Int;
  private volatile boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  
  public GreetingCardRender(ARRenderMangerInnerCallback paramARRenderMangerInnerCallback, GreetingCardResourceInfo paramGreetingCardResourceInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback = paramARRenderMangerInnerCallback;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardResourceInfo = paramGreetingCardResourceInfo;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a();
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge = ((ARNativeBridge)paramARRenderMangerInnerCallback.a(0));
    this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager = new ARSensorManager(this.jdField_a_of_type_AndroidContentContext, 4);
    this.jdField_b_of_type_Int = 1;
    if ((ARVideoUtil.a()) || (ARCardUtils.b())) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      return;
    }
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GreetingCardRender", 2, String.format("setNativeState mCurrentState=%s state=%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(paramInt) }));
    }
    this.jdField_b_of_type_Int = paramInt;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      return;
    case 2: 
      ARGLSurfaceView.nativeSetLogLevel(QLog.getUIN_REPORTLOG_LEVEL());
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.getIndentification();
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeCreateEngineBusiness(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardResourceInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getAssets(), this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardResourceInfo.c, this.jdField_d_of_type_Int, this.e, 7);
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.native_setARCardAnimationCallback(this);
      a(3);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeResume(this.jdField_a_of_type_Int);
      a(5);
      this.jdField_c_of_type_Int = 0;
      return;
    case 5: 
      l();
      return;
    case 6: 
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(new zwi(this));
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativePause(this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeDestroyCertainEngine(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.setupActionCallback(null);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1;
  }
  
  private void a(String paramString, long paramLong)
  {
    QLog.d("GreetingCardRender", 2, String.format("playVideo videoUrl=%s videoSize=%s", new Object[] { paramString, Long.valueOf(paramLong) }));
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo;
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
      if ((TextUtils.isEmpty(paramString)) || (paramString.startsWith("http"))) {
        break label137;
      }
      localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
      if (!this.jdField_b_of_type_Boolean) {
        break label129;
      }
    }
    label129:
    for (Object localObject = "true";; localObject = "false")
    {
      localTVK_PlayerVideoInfo.setConfigMap("software_play", (String)localObject);
      localTVK_PlayerVideoInfo.setPlayType(4);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(BaseApplicationImpl.getContext(), paramString, 0L, 0L, localTVK_PlayerVideoInfo);
      return;
    }
    label137:
    localTVK_PlayerVideoInfo.setConfigMap("file_dir", AROnlineVideoUtil.a(paramString));
    if (this.jdField_b_of_type_Boolean) {}
    for (localObject = "true";; localObject = "false")
    {
      localTVK_PlayerVideoInfo.setConfigMap("software_play", (String)localObject);
      localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20161009");
      localTVK_PlayerVideoInfo.setConfigMap("filesize", String.valueOf(paramLong));
      localTVK_PlayerVideoInfo.setPlayMode("cache_extend_video");
      localTVK_PlayerVideoInfo.setVid(MD5Utils.d(paramString));
      localObject = new HashMap();
      ((HashMap)localObject).put("shouq_bus_type", "shouq_ar_online_video");
      localTVK_PlayerVideoInfo.setReportInfoMap((Map)localObject);
      break;
    }
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if ((this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0] == null) || (this.jdField_a_of_type_ArrayOfInt[0] != paramArrayOfByte1.length)) {}
    try
    {
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0] = ByteBuffer.allocateDirect(paramArrayOfByte1.length);
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].order(ByteOrder.nativeOrder());
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].clear();
      this.jdField_a_of_type_ArrayOfInt[0] = paramArrayOfByte1.length;
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].put(paramArrayOfByte1);
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].position(0);
      if (this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1] != null) {
        if (this.jdField_a_of_type_ArrayOfInt[1] == paramArrayOfByte2.length) {
          break label128;
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1] = ByteBuffer.allocateDirect(paramArrayOfByte1.length);
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].order(ByteOrder.nativeOrder());
        label128:
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].clear();
        this.jdField_a_of_type_ArrayOfInt[1] = paramArrayOfByte2.length;
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].put(paramArrayOfByte2);
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].position(0);
        if (this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2] != null) {
          if (this.jdField_a_of_type_ArrayOfInt[2] == paramArrayOfByte3.length) {
            break label212;
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          for (;;)
          {
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2] = ByteBuffer.allocateDirect(paramArrayOfByte1.length);
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].order(ByteOrder.nativeOrder());
            label212:
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].clear();
            this.jdField_a_of_type_ArrayOfInt[2] = paramArrayOfByte3.length;
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].put(paramArrayOfByte3);
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].position(0);
            return;
            localThrowable1 = localThrowable1;
            QLog.e("GreetingCardRender", 1, "textureYUV fail.", localThrowable1);
          }
          localThrowable2 = localThrowable2;
          QLog.e("GreetingCardRender", 1, "textureYUV fail.", localThrowable2);
        }
        catch (Throwable paramArrayOfByte1)
        {
          for (;;)
          {
            QLog.e("GreetingCardRender", 1, "textureYUV fail.", paramArrayOfByte1);
          }
        }
      }
    }
  }
  
  private void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeOnDrawFrame(this.jdField_a_of_type_Int, paramArrayOfFloat2, paramArrayOfFloat4);
  }
  
  private void b(int paramInt)
  {
    QLog.d("GreetingCardRender", 2, String.format("setARCardVideoYUVTexture textureId=%s", new Object[] { Integer.valueOf(paramInt) }));
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(new zvz(this, paramInt));
    }
  }
  
  private void b(String paramString)
  {
    QLog.d("GreetingCardRender", 2, String.format("setARCardVideoCover videoCoverPath=%s", new Object[] { paramString }));
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(new zvy(this, paramString));
    }
  }
  
  private void c(int paramInt)
  {
    QLog.d("GreetingCardRender", 2, String.format("playARCardAnimation animationType=%s", new Object[] { Integer.valueOf(paramInt) }));
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(new zwa(this, paramInt));
    }
  }
  
  private void h()
  {
    QLog.d("GreetingCardRender", 2, String.format("initVideoPlayer mVideoPlayer=%s", new Object[] { this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer }));
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (localTVK_IProxyFactory != null)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
      this.f = arrayOfInt[0];
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.f);
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
      this.jdField_a_of_type_ComTencentMobileqqArOnline_videoAROnlineVideoView = new AROnlineVideoView(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
      this.jdField_a_of_type_ComTencentMobileqqArOnline_videoAROnlineVideoView.a(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = localTVK_IProxyFactory.createMediaPlayer(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqArOnline_videoAROnlineVideoView);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(this);
    }
  }
  
  private void i()
  {
    QLog.d("GreetingCardRender", 2, "stopVideo");
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(new zwh(this));
  }
  
  private void j()
  {
    QLog.d("GreetingCardRender", 2, String.format("releaseVideoPlayer mVideoPlayer=%s", new Object[] { this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer }));
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
      if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
      {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(null);
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
      }
      if (this.f != -1)
      {
        GLES20.glDeleteTextures(1, new int[] { this.f }, 0);
        this.f = -1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a();
      }
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$GreetingCardItem = ARGreetingCardListManager.a().a();
  }
  
  private void l()
  {
    String str1 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$GreetingCardItem != null) {
      if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$GreetingCardItem.e)) || (this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$GreetingCardItem.e.startsWith("http"))) {
        break label91;
      }
    }
    label91:
    for (str1 = this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$GreetingCardItem.e;; str1 = ARGreetingCardListManager.a().a(this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$GreetingCardItem.e))
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        str2 = ARResouceDir.c() + "arcard_cover_default.png";
      }
      if (!TextUtils.isEmpty(str2)) {
        b(str2);
      }
      return;
    }
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$GreetingCardItem != null) && (this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$GreetingCardItem.jdField_a_of_type_Int == 1)) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$GreetingCardItem.d;; str = null)
    {
      if ((this.jdField_a_of_type_AndroidGraphicsSurfaceTexture == null) && (!TextUtils.isEmpty(str)) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null))
      {
        int[] arrayOfInt = new int[1];
        GLES20.glGenTextures(1, arrayOfInt, 0);
        Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
        this.f = arrayOfInt[0];
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.f);
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
        this.jdField_a_of_type_ComTencentMobileqqArOnline_videoAROnlineVideoView.a(null);
        this.jdField_a_of_type_ComTencentMobileqqArOnline_videoAROnlineVideoView = new AROnlineVideoView(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
        this.jdField_a_of_type_ComTencentMobileqqArOnline_videoAROnlineVideoView.a(this);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.updatePlayerVideoView(this.jdField_a_of_type_ComTencentMobileqqArOnline_videoAROnlineVideoView);
      }
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Long = 0L;
        a(str, 0L);
      }
      return;
    }
  }
  
  public void OnDownloadCallback(String paramString) {}
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardResourceInfo.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardResourceInfo.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    QLog.d("GreetingCardRender", 2, "init");
    h();
    ARGreetingCardListManager.a().a(this);
    if (!this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingYUVProgram.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingYUVProgram.a();
      GreetingYUVProgram localGreetingYUVProgram1 = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingYUVProgram;
      GreetingYUVProgram localGreetingYUVProgram2 = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingYUVProgram;
      localGreetingYUVProgram1.a(GreetingYUVProgram.jdField_a_of_type_ArrayOfFloat);
    }
  }
  
  public void a(ARRenerArumentManager.DrawFrameParements paramDrawFrameParements)
  {
    a((float[])paramDrawFrameParements.a("TARGET_SIZE"), (float[])paramDrawFrameParements.a("POSE"), (float[])paramDrawFrameParements.a("CAMERA_MATRIX"), (float[])paramDrawFrameParements.a("CAMERA_POSITION"));
  }
  
  public void a(ARGreetingCardListManager.GreetingCardItem paramGreetingCardItem)
  {
    this.jdField_a_of_type_ComTencentMobileqqArcardARGreetingCardListManager$GreetingCardItem = paramGreetingCardItem;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      b(paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean)
  {
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      QLog.d("GreetingCardRender", 2, "switch from hardcode to softCode");
    }
    this.jdField_a_of_type_Long += 1L;
    if (this.jdField_b_of_type_Boolean != true) {
      this.jdField_b_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback != null) && (this.jdField_a_of_type_Long > 2L))
    {
      paramArrayOfByte1 = new zwd(this, paramInt1, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(paramArrayOfByte1);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Int == 6) && (this.jdField_a_of_type_Int != 0);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void a_(int paramInt1, int paramInt2)
  {
    this.jdField_d_of_type_Int = paramInt1;
    this.e = paramInt2;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardResourceInfo.jdField_b_of_type_Int;
  }
  
  public void b()
  {
    QLog.d("GreetingCardRender", 2, "start");
    if (1 == this.jdField_b_of_type_Int)
    {
      k();
      ARGreetingCardListManager.a().b();
      a(2);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Int == 5)
    {
      int i = this.jdField_c_of_type_Int + 1;
      this.jdField_c_of_type_Int = i;
      if (i >= 2)
      {
        ARGreetingCardListManager.a().c();
        a(6);
      }
    }
  }
  
  public boolean c()
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(new zwg(this));
    return true;
  }
  
  public void d()
  {
    QLog.d("GreetingCardRender", 2, String.format("onDestroy mCurrentState=%s mCallDestroyFromPause=%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    j();
    if (this.jdField_a_of_type_ComTencentMobileqqArcardARcardSound != null) {
      this.jdField_a_of_type_ComTencentMobileqqArcardARcardSound.a();
    }
    ARGreetingCardListManager.a().e();
    ARGreetingCardListManager.a().a(null);
    if (this.jdField_b_of_type_Int == 6)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback != null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(1, 0);
        this.jdField_a_of_type_Boolean = false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingCardResourceInfo.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_b_of_type_Int == 6) {
        a(7);
      }
    }
  }
  
  public void e()
  {
    i();
    c(1);
    ARGreetingCardListManager.a().a(false);
  }
  
  public void f()
  {
    i();
    c(2);
    ARGreetingCardListManager.a().a(false);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(1, 0);
    }
  }
  
  public void onAnimationComplete(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("GreetingCardRender", 2, String.format("onAnimationComplete animationType=%s curFragment=%s totalFragment=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    if ((paramInt1 == 1) || (paramInt1 == 2)) {
      if (paramInt2 == 1)
      {
        l();
        ARGreetingCardListManager.a().d();
      }
    }
    while (paramInt1 != 3)
    {
      do
      {
        return;
      } while (paramInt2 != 2);
      ARGreetingCardListManager.a().a(true);
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(new zwe(this));
      return;
    }
    if (ARGreetingCardListManager.a().a() != -1)
    {
      ARGreetingCardListManager.a().a(true);
      ARGreetingCardListManager.a().d();
    }
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(new zwf(this));
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    QLog.d("GreetingCardRender", 2, "TVK_IMediaPlayer.onCompletion");
    ARGreetingCardListManager.a().f();
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    QLog.d("GreetingCardRender", 2, String.format("TVK_IMediaPlayer.onError model=%s what=%s position=%s detailInfo=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString }));
    return false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    QLog.d("GreetingCardRender", 2, "TVK_IMediaPlayer.onVideoPrepared");
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      return;
    }
    catch (Exception paramTVK_IMediaPlayer)
    {
      QLog.d("GreetingCardRender", 1, "TVK_IMediaPlayer.onVideoPrepared fail.", paramTVK_IMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.GreetingCardRender
 * JD-Core Version:    0.7.0.1
 */