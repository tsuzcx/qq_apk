import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.qg.sdk.video.IMediaPlayer;
import com.tencent.qg.sdk.video.VideoPlayer;
import com.tencent.qg.video.videodecoder.MediaDecoder;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class bkge
  implements IMediaPlayer
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private bkgo jdField_a_of_type_Bkgo = new bkgf(this);
  private MediaDecoder jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder;
  private GPUOESBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private volatile boolean jdField_d_of_type_Boolean;
  private int e = -1;
  private int f = -1;
  private volatile int g = 0;
  
  private int[] a()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(36197, arrayOfInt[0]);
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    return arrayOfInt;
  }
  
  private void e()
  {
    yuk.b("DefaultMediaPlayer", "onVideoPlayEnded");
    VideoPlayer.nativeEvent(this.jdField_a_of_type_Long, "ended");
    this.jdField_d_of_type_Boolean = true;
  }
  
  private void f()
  {
    yuk.b("DefaultMediaPlayer", "onVideoPlayRepeated");
    this.jdField_d_of_type_Boolean = false;
  }
  
  private void g()
  {
    boolean bool2 = true;
    bkgg.a(hashCode(), "[Player] handle play cmd from qg");
    yuk.a("DefaultMediaPlayer", "handleStartPlay , src = %s", this.jdField_a_of_type_JavaLangString);
    this.jdField_d_of_type_Int = a()[0];
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, 33984);
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter == null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter = ((GPUOESBaseFilter)bbmy.a(102));
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.init();
    }
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) {
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.b();
    }
    this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder = new MediaDecoder(this.jdField_a_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_a_of_type_Bkgo, false, hashCode());
    this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.a();
    MediaDecoder localMediaDecoder;
    if (this.f != -1)
    {
      localMediaDecoder = this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder;
      if (this.f == 1)
      {
        bool1 = true;
        localMediaDecoder.a(bool1);
      }
    }
    else if (this.e != -1)
    {
      localMediaDecoder = this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder;
      if (this.e != 1) {
        break label218;
      }
    }
    label218:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localMediaDecoder.b(bool1);
      this.jdField_d_of_type_Boolean = false;
      this.g = 0;
      bkgg.a(hashCode(), "[Player] handle play cmd from qg finish");
      return;
      bool1 = false;
      break;
    }
  }
  
  private void h()
  {
    yuk.a("DefaultMediaPlayer", "handleResumePlay , src = %s", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.d();
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.setTexId(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.drawTexture(this.jdField_d_of_type_Int, null, null);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
    if (this.g == 1)
    {
      this.g = 2;
      VideoPlayer.nativeEvent(this.jdField_a_of_type_Long, "ready");
      bkgg.a(hashCode(), "[Player] render first frame to qg");
    }
  }
  
  public void a()
  {
    yuk.b("DefaultMediaPlayer", "onResume");
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) {
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.d();
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void b()
  {
    yuk.b("DefaultMediaPlayer", "onPause");
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) {
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.c();
    }
  }
  
  public void c()
  {
    yuk.b("DefaultMediaPlayer", "onStop");
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) {
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.b();
    }
  }
  
  public void create(long paramLong)
  {
    yuk.b("DefaultMediaPlayer", "qg -> create");
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      g();
    }
    do
    {
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        h();
        return;
      }
    } while (!isPlaying());
    i();
  }
  
  public void destroy()
  {
    yuk.b("DefaultMediaPlayer", "qg -> destroy");
    c();
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.destroy();
    }
  }
  
  public int getCurrentPosition()
  {
    return (int)this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.a();
  }
  
  public int getDuration()
  {
    return (int)wmk.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean isEnd()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean isMuted()
  {
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) {
      return this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.c();
    }
    return false;
  }
  
  public boolean isPlaying()
  {
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) {
      return this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.a();
    }
    return false;
  }
  
  public void pause()
  {
    yuk.b("DefaultMediaPlayer", "qg -> pause");
    b();
  }
  
  public void play(int paramInt1, int paramInt2, int paramInt3)
  {
    yuk.a("DefaultMediaPlayer", "qg -> play , texture id = %d , width = %d , height = %d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
    bkgg.a(hashCode(), "[Player] receive play cmd from qg");
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    if ((!this.jdField_c_of_type_Boolean) && (isPlaying())) {
      return;
    }
    if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) && (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.b()))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void seekTo(int paramInt)
  {
    this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.a(paramInt);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.f = i;
      if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) {
        this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.a(paramBoolean);
      }
      return;
    }
  }
  
  public void setMuted(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.e = i;
      if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder != null) {
        this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder.b(paramBoolean);
      }
      return;
    }
  }
  
  public void setSrc(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      str = paramString;
      if (!paramString.startsWith(this.jdField_b_of_type_JavaLangString)) {
        str = this.jdField_b_of_type_JavaLangString + paramString;
      }
    }
    if (!TextUtils.equals(str, this.jdField_a_of_type_JavaLangString)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      this.jdField_a_of_type_JavaLangString = str;
      yuk.a("DefaultMediaPlayer", "qg -> set Src , src = %s , isSrcChanged :%s", str, Boolean.valueOf(this.jdField_c_of_type_Boolean));
      return;
    }
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    yuk.b("DefaultMediaPlayer", "qg -> setVolume , not support yet");
  }
  
  public void stop()
  {
    yuk.b("DefaultMediaPlayer", "qg -> stop");
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkge
 * JD-Core Version:    0.7.0.1
 */