package com.tencent.mobileqq.ar.ARPromotion;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.view.Surface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARRenderModel.GreetingYUVProgram;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnDefinitionInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

public class ARPromotionMediaPlayerWrapper
  implements SurfaceTexture.OnFrameAvailableListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnDefinitionInfoListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private ARPromotionMediaPlayerWrapper.OnPlayMediaStatusListener jdField_a_of_type_ComTencentMobileqqArARPromotionARPromotionMediaPlayerWrapper$OnPlayMediaStatusListener;
  private GreetingYUVProgram jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingYUVProgram = new GreetingYUVProgram(0);
  private ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ARPromotionMediaPlayerWrapper.1(this);
  private String jdField_a_of_type_JavaLangString;
  volatile boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer = new ByteBuffer[3];
  private int jdField_b_of_type_Int = -1;
  private final boolean jdField_b_of_type_Boolean = false;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  private int jdField_c_of_type_Int = 0;
  private volatile boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 1;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e = false;
  private boolean f = true;
  private boolean g = false;
  
  public ARPromotionMediaPlayerWrapper(ARPromotionMediaPlayerWrapper.OnPlayMediaStatusListener paramOnPlayMediaStatusListener, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARPromotionMediaPlayerWrapper$OnPlayMediaStatusListener = paramOnPlayMediaStatusListener;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(String paramString)
  {
    paramString = SuperPlayerFactory.createVideoInfoForUrl(paramString, 101, MD5Utils.toMD5(paramString));
    SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain();
    localSuperPlayerOption.enableCodecReuse = false;
    localSuperPlayerOption.isPrePlay = false;
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.openMediaPlayer(BaseApplicationImpl.getContext(), paramString, 0L, localSuperPlayerOption);
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if ((this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0] == null) || (this.jdField_a_of_type_ArrayOfInt[0] != paramArrayOfByte1.length)) {
      try
      {
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0] = ByteBuffer.allocateDirect(paramArrayOfByte1.length);
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].order(ByteOrder.nativeOrder());
      }
      catch (Throwable localThrowable1)
      {
        QLog.e("ARWorldCupMediaPlayerWrapper", 1, "textureYUV fail.", localThrowable1);
      }
    }
    this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].clear();
    this.jdField_a_of_type_ArrayOfInt[0] = paramArrayOfByte1.length;
    this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].put(paramArrayOfByte1);
    this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].position(0);
    if ((this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1] == null) || (this.jdField_a_of_type_ArrayOfInt[1] != paramArrayOfByte2.length)) {
      try
      {
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1] = ByteBuffer.allocateDirect(paramArrayOfByte1.length);
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].order(ByteOrder.nativeOrder());
      }
      catch (Throwable localThrowable2)
      {
        QLog.e("ARWorldCupMediaPlayerWrapper", 1, "textureYUV fail.", localThrowable2);
      }
    }
    this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].clear();
    this.jdField_a_of_type_ArrayOfInt[1] = paramArrayOfByte2.length;
    this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].put(paramArrayOfByte2);
    this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].position(0);
    if ((this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2] == null) || (this.jdField_a_of_type_ArrayOfInt[2] != paramArrayOfByte3.length)) {
      try
      {
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2] = ByteBuffer.allocateDirect(paramArrayOfByte1.length);
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].order(ByteOrder.nativeOrder());
      }
      catch (Throwable paramArrayOfByte1)
      {
        QLog.e("ARWorldCupMediaPlayerWrapper", 1, "textureYUV fail.", paramArrayOfByte1);
      }
    }
    this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].clear();
    this.jdField_a_of_type_ArrayOfInt[2] = paramArrayOfByte3.length;
    this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].put(paramArrayOfByte3);
    this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].position(0);
  }
  
  private void d()
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 2, String.format("initVideoPlayer mVideoPlayer=%s", new Object[] { this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer }));
    if ((this.jdField_a_of_type_AndroidGraphicsSurfaceTexture == null) || (this.jdField_a_of_type_AndroidViewSurface == null))
    {
      localObject = new int[1];
      GLES20.glGenTextures(1, (int[])localObject, 0);
      Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
      this.jdField_b_of_type_Int = localObject[0];
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
      this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    }
    Object localObject = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 108, null);
    }
    else
    {
      ((ISuperPlayer)localObject).stop();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.reset();
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setSurface(this.jdField_a_of_type_AndroidViewSurface);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoPreparedListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnInfoListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnErrorListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnDefinitionInfoListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnSeekCompleteListener(this);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null)
    {
      localObject = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(((ISuperPlayer)localObject).getVideoWidth(), this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getVideoHeight(), 33984);
        QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.checkIfNeedUpdateRenderBuffer line1");
      }
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender == null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
      QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.checkIfNeedUpdateRenderBuffer line2");
    }
    Object localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
    if ((localObject != null) && (!GLES20.glIsTexture(((RenderBuffer)localObject).getTexId()))) {
      QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.checkIfNeedUpdateRenderBuffer error happen,FBO texture ID is released");
    }
  }
  
  public long a()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getCurrentPositionMs();
    }
    return -1L;
  }
  
  public void a()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.seekTo(0);
        QLog.d("ARWorldCupMediaPlayerWrapper", 1, "mVideoPlayer restart seekTo(0)");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ARWorldCupMediaPlayerWrapper", 1, "restart mVideoPlayer error happen", localException);
    }
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 2, String.format("playVideo videoUrl=%s videoSize=%s", new Object[] { paramString, Long.valueOf(paramLong) }));
    d();
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if ((localISuperPlayer != null) && (!localISuperPlayer.isPlaying()))
    {
      this.f = true;
      this.jdField_d_of_type_Boolean = paramBoolean2;
      this.jdField_c_of_type_Int = 0;
      int i = paramInt;
      if (paramInt <= 0) {
        i = 10000;
      }
      this.jdField_d_of_type_Int = i;
      this.jdField_a_of_type_JavaLangString = paramString;
      a(paramString);
      this.e = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("call setMu result:");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("ARWorldCupMediaPlayerWrapper", 2, ((StringBuilder)localObject).toString());
    this.g = paramBoolean;
    localObject = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localObject != null) {
      ((ISuperPlayer)localObject).setOutputMute(paramBoolean);
    }
  }
  
  public boolean a()
  {
    ISuperPlayer localISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (localISuperPlayer == null) {
      return false;
    }
    return localISuperPlayer.isPlaying();
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: ldc 180
    //   2: iconst_1
    //   3: ldc_w 359
    //   6: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_0
    //   10: getfield 107	com/tencent/mobileqq/ar/ARPromotion/ARPromotionMediaPlayerWrapper:jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer	Lcom/tencent/superplayer/api/ISuperPlayer;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +184 -> 199
    //   18: aload_0
    //   19: lconst_0
    //   20: putfield 51	com/tencent/mobileqq/ar/ARPromotion/ARPromotionMediaPlayerWrapper:jdField_a_of_type_Long	J
    //   23: aload_1
    //   24: invokeinterface 337 1 0
    //   29: ifne +10 -> 39
    //   32: aload_0
    //   33: getfield 80	com/tencent/mobileqq/ar/ARPromotion/ARPromotionMediaPlayerWrapper:e	Z
    //   36: ifeq +26 -> 62
    //   39: ldc 180
    //   41: iconst_1
    //   42: ldc_w 361
    //   45: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_0
    //   49: getfield 107	com/tencent/mobileqq/ar/ARPromotion/ARPromotionMediaPlayerWrapper:jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer	Lcom/tencent/superplayer/api/ISuperPlayer;
    //   52: invokeinterface 247 1 0
    //   57: aload_0
    //   58: iconst_0
    //   59: putfield 80	com/tencent/mobileqq/ar/ARPromotion/ARPromotionMediaPlayerWrapper:e	Z
    //   62: aload_0
    //   63: getfield 110	com/tencent/mobileqq/ar/ARPromotion/ARPromotionMediaPlayerWrapper:jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   66: ifnull +133 -> 199
    //   69: aload_0
    //   70: aconst_null
    //   71: putfield 110	com/tencent/mobileqq/ar/ARPromotion/ARPromotionMediaPlayerWrapper:jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   74: return
    //   75: astore_1
    //   76: new 340	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 341	java/lang/StringBuilder:<init>	()V
    //   83: astore_2
    //   84: goto +40 -> 124
    //   87: astore_1
    //   88: goto +61 -> 149
    //   91: astore_1
    //   92: ldc 180
    //   94: iconst_1
    //   95: ldc_w 363
    //   98: aload_1
    //   99: invokestatic 187	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   102: aload_0
    //   103: getfield 110	com/tencent/mobileqq/ar/ARPromotion/ARPromotionMediaPlayerWrapper:jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   106: ifnull +93 -> 199
    //   109: aload_0
    //   110: aconst_null
    //   111: putfield 110	com/tencent/mobileqq/ar/ARPromotion/ARPromotionMediaPlayerWrapper:jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   114: return
    //   115: astore_1
    //   116: new 340	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 341	java/lang/StringBuilder:<init>	()V
    //   123: astore_2
    //   124: aload_2
    //   125: ldc_w 365
    //   128: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload_2
    //   133: aload_1
    //   134: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: ldc 180
    //   140: iconst_1
    //   141: aload_2
    //   142: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: return
    //   149: aload_0
    //   150: getfield 110	com/tencent/mobileqq/ar/ARPromotion/ARPromotionMediaPlayerWrapper:jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   153: ifnull +44 -> 197
    //   156: aload_0
    //   157: aconst_null
    //   158: putfield 110	com/tencent/mobileqq/ar/ARPromotion/ARPromotionMediaPlayerWrapper:jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   161: goto +36 -> 197
    //   164: astore_2
    //   165: new 340	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 341	java/lang/StringBuilder:<init>	()V
    //   172: astore_3
    //   173: aload_3
    //   174: ldc_w 365
    //   177: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload_3
    //   182: aload_2
    //   183: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: ldc 180
    //   189: iconst_1
    //   190: aload_3
    //   191: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 370	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload_1
    //   198: athrow
    //   199: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	ARPromotionMediaPlayerWrapper
    //   13	11	1	localISuperPlayer	ISuperPlayer
    //   75	1	1	localException1	Exception
    //   87	1	1	localObject	Object
    //   91	8	1	localException2	Exception
    //   115	83	1	localException3	Exception
    //   83	59	2	localStringBuilder1	StringBuilder
    //   164	19	2	localException4	Exception
    //   172	19	3	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   62	74	75	java/lang/Exception
    //   18	39	87	finally
    //   39	62	87	finally
    //   92	102	87	finally
    //   18	39	91	java/lang/Exception
    //   39	62	91	java/lang/Exception
    //   102	114	115	java/lang/Exception
    //   149	161	164	java/lang/Exception
  }
  
  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void c()
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, String.format("releaseVideoPlayer mVideoPlayer=%s", new Object[] { this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer }));
    try
    {
      this.f = true;
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionARPromotionMediaPlayerWrapper$OnPlayMediaStatusListener = null;
      if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null) {
        break label192;
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.release();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = null;
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingYUVProgram.c();
      if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
      {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(null);
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
      }
      if (this.jdField_a_of_type_AndroidViewSurface != null)
      {
        this.jdField_a_of_type_AndroidViewSurface.release();
        this.jdField_a_of_type_AndroidViewSurface = null;
      }
      if (this.jdField_b_of_type_Int != -1)
      {
        GLES20.glDeleteTextures(1, new int[] { this.jdField_b_of_type_Int }, 0);
        this.jdField_b_of_type_Int = -1;
      }
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null)
      {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
      }
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender == null) {
        break label192;
      }
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
      return;
    }
    catch (Exception localException)
    {
      label183:
      label192:
      break label183;
    }
    QLog.e("ARWorldCupMediaPlayerWrapper", 1, "release finllay fail.");
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    this.jdField_a_of_type_Boolean = false;
    paramISuperPlayer = new ARPromotionMediaPlayerWrapper.3(this);
    ARPromotionMediaPlayerWrapper.OnPlayMediaStatusListener localOnPlayMediaStatusListener = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARPromotionMediaPlayerWrapper$OnPlayMediaStatusListener;
    if (localOnPlayMediaStatusListener != null) {
      localOnPlayMediaStatusListener.a(paramISuperPlayer);
    }
  }
  
  public void onDefinitionInfoUpdate(ISuperPlayer paramISuperPlayer, String paramString, ArrayList<String> paramArrayList) {}
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "onError");
    this.jdField_a_of_type_Boolean = false;
    return false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARPromotionMediaPlayerWrapper$OnPlayMediaStatusListener;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.a(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return false;
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onSeekComplete");
    paramISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (paramISuperPlayer != null)
    {
      this.jdField_a_of_type_Boolean = false;
      try
      {
        paramISuperPlayer.start();
        return;
      }
      catch (Exception paramISuperPlayer)
      {
        QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onSeekComplete fail.", paramISuperPlayer);
      }
    }
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onVideoPrepared");
    this.jdField_a_of_type_Boolean = false;
    paramISuperPlayer = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
    if (paramISuperPlayer != null) {
      try
      {
        paramISuperPlayer.start();
        return;
      }
      catch (Exception paramISuperPlayer)
      {
        QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onVideoPrepared fail.", paramISuperPlayer);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper
 * JD-Core Version:    0.7.0.1
 */