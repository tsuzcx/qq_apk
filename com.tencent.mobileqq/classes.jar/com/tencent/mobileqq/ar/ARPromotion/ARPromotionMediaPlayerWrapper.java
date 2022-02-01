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
  volatile boolean a = false;
  private final boolean b = false;
  private int c;
  private ISuperPlayer d;
  private long e = 0L;
  private int f = -1;
  private Surface g;
  private SurfaceTexture h;
  private float[] i = new float[16];
  private float[] j = new float[16];
  private ByteBuffer[] k = new ByteBuffer[3];
  private int[] l = new int[3];
  private GreetingYUVProgram m = new GreetingYUVProgram(0);
  private RenderBuffer n;
  private TextureRender o;
  private volatile boolean p = false;
  private ARPromotionMediaPlayerWrapper.OnPlayMediaStatusListener q;
  private boolean r = false;
  private int s = 0;
  private int t = 1;
  private String u;
  private boolean v = false;
  private boolean w = true;
  private Runnable x = new ARPromotionMediaPlayerWrapper.1(this);
  private boolean y = false;
  
  public ARPromotionMediaPlayerWrapper(ARPromotionMediaPlayerWrapper.OnPlayMediaStatusListener paramOnPlayMediaStatusListener, int paramInt)
  {
    this.q = paramOnPlayMediaStatusListener;
    this.c = paramInt;
  }
  
  private void a(String paramString)
  {
    paramString = SuperPlayerFactory.createVideoInfoForUrl(paramString, 101, MD5Utils.toMD5(paramString));
    SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain();
    localSuperPlayerOption.enableCodecReuse = false;
    localSuperPlayerOption.isPrePlay = false;
    this.d.openMediaPlayer(BaseApplicationImpl.getContext(), paramString, 0L, localSuperPlayerOption);
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if ((this.k[0] == null) || (this.l[0] != paramArrayOfByte1.length)) {
      try
      {
        this.k[0] = ByteBuffer.allocateDirect(paramArrayOfByte1.length);
        this.k[0].order(ByteOrder.nativeOrder());
      }
      catch (Throwable localThrowable1)
      {
        QLog.e("ARWorldCupMediaPlayerWrapper", 1, "textureYUV fail.", localThrowable1);
      }
    }
    this.k[0].clear();
    this.l[0] = paramArrayOfByte1.length;
    this.k[0].put(paramArrayOfByte1);
    this.k[0].position(0);
    if ((this.k[1] == null) || (this.l[1] != paramArrayOfByte2.length)) {
      try
      {
        this.k[1] = ByteBuffer.allocateDirect(paramArrayOfByte1.length);
        this.k[1].order(ByteOrder.nativeOrder());
      }
      catch (Throwable localThrowable2)
      {
        QLog.e("ARWorldCupMediaPlayerWrapper", 1, "textureYUV fail.", localThrowable2);
      }
    }
    this.k[1].clear();
    this.l[1] = paramArrayOfByte2.length;
    this.k[1].put(paramArrayOfByte2);
    this.k[1].position(0);
    if ((this.k[2] == null) || (this.l[2] != paramArrayOfByte3.length)) {
      try
      {
        this.k[2] = ByteBuffer.allocateDirect(paramArrayOfByte1.length);
        this.k[2].order(ByteOrder.nativeOrder());
      }
      catch (Throwable paramArrayOfByte1)
      {
        QLog.e("ARWorldCupMediaPlayerWrapper", 1, "textureYUV fail.", paramArrayOfByte1);
      }
    }
    this.k[2].clear();
    this.l[2] = paramArrayOfByte3.length;
    this.k[2].put(paramArrayOfByte3);
    this.k[2].position(0);
  }
  
  private void f()
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 2, String.format("initVideoPlayer mVideoPlayer=%s", new Object[] { this.d }));
    if ((this.h == null) || (this.g == null))
    {
      localObject = new int[1];
      GLES20.glGenTextures(1, (int[])localObject, 0);
      Matrix.setIdentityM(this.j, 0);
      this.f = localObject[0];
      this.h = new SurfaceTexture(this.f);
      this.h.setOnFrameAvailableListener(this);
      this.g = new Surface(this.h);
    }
    Object localObject = this.d;
    if (localObject == null)
    {
      this.d = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 108, null);
    }
    else
    {
      ((ISuperPlayer)localObject).stop();
      this.d.reset();
    }
    this.d.setSurface(this.g);
    this.d.setOnVideoPreparedListener(this);
    this.d.setOnInfoListener(this);
    this.d.setOnErrorListener(this);
    this.d.setOnDefinitionInfoListener(this);
    this.d.setOnCompletionListener(this);
    this.d.setOnSeekCompleteListener(this);
  }
  
  private void g()
  {
    if (this.n == null)
    {
      localObject = this.d;
      if (localObject != null)
      {
        this.n = new RenderBuffer(((ISuperPlayer)localObject).getVideoWidth(), this.d.getVideoHeight(), 33984);
        QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.checkIfNeedUpdateRenderBuffer line1");
      }
    }
    if (this.o == null)
    {
      this.o = new TextureRender();
      QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.checkIfNeedUpdateRenderBuffer line2");
    }
    Object localObject = this.n;
    if ((localObject != null) && (!GLES20.glIsTexture(((RenderBuffer)localObject).getTexId()))) {
      QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.checkIfNeedUpdateRenderBuffer error happen,FBO texture ID is released");
    }
  }
  
  public void a()
  {
    try
    {
      if ((this.d != null) && (!this.a))
      {
        this.a = true;
        this.d.seekTo(0);
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
    f();
    ISuperPlayer localISuperPlayer = this.d;
    if ((localISuperPlayer != null) && (!localISuperPlayer.isPlaying()))
    {
      this.w = true;
      this.r = paramBoolean2;
      this.s = 0;
      int i1 = paramInt;
      if (paramInt <= 0) {
        i1 = 10000;
      }
      this.t = i1;
      this.u = paramString;
      a(paramString);
      this.v = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("call setMu result:");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("ARWorldCupMediaPlayerWrapper", 2, ((StringBuilder)localObject).toString());
    this.y = paramBoolean;
    localObject = this.d;
    if (localObject != null) {
      ((ISuperPlayer)localObject).setOutputMute(paramBoolean);
    }
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: ldc 179
    //   2: iconst_1
    //   3: ldc_w 371
    //   6: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_0
    //   10: getfield 149	com/tencent/mobileqq/ar/ARPromotion/ARPromotionMediaPlayerWrapper:d	Lcom/tencent/superplayer/api/ISuperPlayer;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +184 -> 199
    //   18: aload_0
    //   19: lconst_0
    //   20: putfield 69	com/tencent/mobileqq/ar/ARPromotion/ARPromotionMediaPlayerWrapper:e	J
    //   23: aload_1
    //   24: invokeinterface 349 1 0
    //   29: ifne +10 -> 39
    //   32: aload_0
    //   33: getfield 98	com/tencent/mobileqq/ar/ARPromotion/ARPromotionMediaPlayerWrapper:v	Z
    //   36: ifeq +26 -> 62
    //   39: ldc 179
    //   41: iconst_1
    //   42: ldc_w 373
    //   45: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_0
    //   49: getfield 149	com/tencent/mobileqq/ar/ARPromotion/ARPromotionMediaPlayerWrapper:d	Lcom/tencent/superplayer/api/ISuperPlayer;
    //   52: invokeinterface 251 1 0
    //   57: aload_0
    //   58: iconst_0
    //   59: putfield 98	com/tencent/mobileqq/ar/ARPromotion/ARPromotionMediaPlayerWrapper:v	Z
    //   62: aload_0
    //   63: getfield 285	com/tencent/mobileqq/ar/ARPromotion/ARPromotionMediaPlayerWrapper:n	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   66: ifnull +133 -> 199
    //   69: aload_0
    //   70: aconst_null
    //   71: putfield 285	com/tencent/mobileqq/ar/ARPromotion/ARPromotionMediaPlayerWrapper:n	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   74: return
    //   75: astore_1
    //   76: new 352	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 353	java/lang/StringBuilder:<init>	()V
    //   83: astore_2
    //   84: goto +40 -> 124
    //   87: astore_1
    //   88: goto +61 -> 149
    //   91: astore_1
    //   92: ldc 179
    //   94: iconst_1
    //   95: ldc_w 375
    //   98: aload_1
    //   99: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   102: aload_0
    //   103: getfield 285	com/tencent/mobileqq/ar/ARPromotion/ARPromotionMediaPlayerWrapper:n	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   106: ifnull +93 -> 199
    //   109: aload_0
    //   110: aconst_null
    //   111: putfield 285	com/tencent/mobileqq/ar/ARPromotion/ARPromotionMediaPlayerWrapper:n	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   114: return
    //   115: astore_1
    //   116: new 352	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 353	java/lang/StringBuilder:<init>	()V
    //   123: astore_2
    //   124: aload_2
    //   125: ldc_w 377
    //   128: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload_2
    //   133: aload_1
    //   134: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: ldc 179
    //   140: iconst_1
    //   141: aload_2
    //   142: invokevirtual 366	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: return
    //   149: aload_0
    //   150: getfield 285	com/tencent/mobileqq/ar/ARPromotion/ARPromotionMediaPlayerWrapper:n	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   153: ifnull +44 -> 197
    //   156: aload_0
    //   157: aconst_null
    //   158: putfield 285	com/tencent/mobileqq/ar/ARPromotion/ARPromotionMediaPlayerWrapper:n	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   161: goto +36 -> 197
    //   164: astore_2
    //   165: new 352	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 353	java/lang/StringBuilder:<init>	()V
    //   172: astore_3
    //   173: aload_3
    //   174: ldc_w 377
    //   177: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload_3
    //   182: aload_2
    //   183: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: ldc 179
    //   189: iconst_1
    //   190: aload_3
    //   191: invokevirtual 366	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    this.w = paramBoolean;
  }
  
  public boolean c()
  {
    ISuperPlayer localISuperPlayer = this.d;
    if (localISuperPlayer == null) {
      return false;
    }
    return localISuperPlayer.isPlaying();
  }
  
  public void d()
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, String.format("releaseVideoPlayer mVideoPlayer=%s", new Object[] { this.d }));
    try
    {
      this.w = true;
      this.q = null;
      if (this.d == null) {
        break label192;
      }
      this.p = true;
      this.d.stop();
      this.d.release();
      this.d = null;
      this.m.d();
      if (this.h != null)
      {
        this.h.setOnFrameAvailableListener(null);
        this.h.release();
        this.h = null;
      }
      if (this.g != null)
      {
        this.g.release();
        this.g = null;
      }
      if (this.f != -1)
      {
        GLES20.glDeleteTextures(1, new int[] { this.f }, 0);
        this.f = -1;
      }
      if (this.n != null)
      {
        this.n.destroy();
        this.n = null;
      }
      if (this.o == null) {
        break label192;
      }
      this.o.release();
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
  
  public long e()
  {
    ISuperPlayer localISuperPlayer = this.d;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getCurrentPositionMs();
    }
    return -1L;
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    this.a = false;
    paramISuperPlayer = new ARPromotionMediaPlayerWrapper.3(this);
    ARPromotionMediaPlayerWrapper.OnPlayMediaStatusListener localOnPlayMediaStatusListener = this.q;
    if (localOnPlayMediaStatusListener != null) {
      localOnPlayMediaStatusListener.a(paramISuperPlayer);
    }
  }
  
  public void onDefinitionInfoUpdate(ISuperPlayer paramISuperPlayer, String paramString, ArrayList<String> paramArrayList) {}
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "onError");
    this.a = false;
    return false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture = this.q;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.a(this.x);
    }
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return false;
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onSeekComplete");
    paramISuperPlayer = this.d;
    if (paramISuperPlayer != null)
    {
      this.a = false;
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
    this.a = false;
    paramISuperPlayer = this.d;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper
 * JD-Core Version:    0.7.0.1
 */