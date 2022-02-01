import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.view.Surface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.1;
import com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.3;
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

public class aoru
  implements SurfaceTexture.OnFrameAvailableListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnDefinitionInfoListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private aorv jdField_a_of_type_Aorv;
  private aouq jdField_a_of_type_Aouq = new aouq(0);
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
  private int jdField_c_of_type_Int;
  private volatile boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 1;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f = true;
  private boolean g;
  
  public aoru(aorv paramaorv, int paramInt)
  {
    this.jdField_a_of_type_Aorv = paramaorv;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(String paramString)
  {
    paramString = SuperPlayerFactory.createVideoInfoForUrl(paramString, 101, bita.d(paramString));
    SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain();
    localSuperPlayerOption.enableCodecReuse = false;
    localSuperPlayerOption.isPrePlay = false;
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.openMediaPlayer(BaseApplicationImpl.getContext(), paramString, 0L, localSuperPlayerOption);
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
            QLog.e("ARWorldCupMediaPlayerWrapper", 1, "textureYUV fail.", localThrowable1);
          }
          localThrowable2 = localThrowable2;
          QLog.e("ARWorldCupMediaPlayerWrapper", 1, "textureYUV fail.", localThrowable2);
        }
        catch (Throwable paramArrayOfByte1)
        {
          for (;;)
          {
            QLog.e("ARWorldCupMediaPlayerWrapper", 1, "textureYUV fail.", paramArrayOfByte1);
          }
        }
      }
    }
  }
  
  private void d()
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 2, String.format("initVideoPlayer mVideoPlayer=%s", new Object[] { this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer }));
    if ((this.jdField_a_of_type_AndroidGraphicsSurfaceTexture == null) || (this.jdField_a_of_type_AndroidViewSurface == null))
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
      this.jdField_b_of_type_Int = arrayOfInt[0];
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
      this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    }
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 108, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setSurface(this.jdField_a_of_type_AndroidViewSurface);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoPreparedListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnInfoListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnErrorListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnDefinitionInfoListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnSeekCompleteListener(this);
      return;
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.reset();
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) && (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null))
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getVideoWidth(), this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getVideoHeight(), 33984);
      QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.checkIfNeedUpdateRenderBuffer line1");
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender == null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
      QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.checkIfNeedUpdateRenderBuffer line2");
    }
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) && (!GLES20.glIsTexture(this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId()))) {
      QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.checkIfNeedUpdateRenderBuffer error happen,FBO texture ID is released");
    }
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
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
      }
      return;
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
    if ((this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (!this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying()))
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
    QLog.d("ARWorldCupMediaPlayerWrapper", 2, "call setMu result:" + paramBoolean);
    this.g = paramBoolean;
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying();
  }
  
  public void b()
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "stopVideo");
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Long = 0L;
        if ((this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying()) || (this.e))
        {
          QLog.d("ARWorldCupMediaPlayerWrapper", 1, "run inner stopVideo");
          this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
          this.e = false;
        }
      }
      catch (Exception localException2)
      {
        localException2 = localException2;
        QLog.e("ARWorldCupMediaPlayerWrapper", 1, "playVideo fail.", localException2);
        try
        {
          if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
          return;
        }
        catch (Exception localException3)
        {
          QLog.e("ARWorldCupMediaPlayerWrapper", 1, "stopVideo finllay fail." + localException3);
          return;
        }
      }
      finally {}
      try
      {
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
        }
        return;
      }
      catch (Exception localException1)
      {
        QLog.e("ARWorldCupMediaPlayerWrapper", 1, "stopVideo finllay fail." + localException1);
        return;
      }
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
      }
      throw localObject;
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        QLog.e("ARWorldCupMediaPlayerWrapper", 1, "stopVideo finllay fail." + localException4);
      }
    }
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
      this.jdField_a_of_type_Aorv = null;
      if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.release();
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = null;
        this.jdField_a_of_type_Aouq.c();
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
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender != null) {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ARWorldCupMediaPlayerWrapper", 1, "release finllay fail.");
    }
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    this.jdField_a_of_type_Boolean = false;
    paramISuperPlayer = new ARPromotionMediaPlayerWrapper.3(this);
    if (this.jdField_a_of_type_Aorv != null) {
      this.jdField_a_of_type_Aorv.a(paramISuperPlayer);
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
    if (this.jdField_a_of_type_Aorv != null) {
      this.jdField_a_of_type_Aorv.a(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return false;
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onSeekComplete");
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_Boolean = false;
    }
    try
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
      return;
    }
    catch (Exception paramISuperPlayer)
    {
      QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onSeekComplete fail.", paramISuperPlayer);
    }
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onVideoPrepared");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
      return;
    }
    catch (Exception paramISuperPlayer)
    {
      QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onVideoPrepared fail.", paramISuperPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoru
 * JD-Core Version:    0.7.0.1
 */