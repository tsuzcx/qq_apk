import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.mobileqq.vpng.glrenderer.GLRenderer;
import com.tencent.mobileqq.vpng.glrenderer.VPNGRenderer.2;
import com.tencent.qphone.base.util.QLog;
import cooperation.liveroom.LiveRoomGiftCallback;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class bdzn
  extends GLRenderer
  implements SurfaceTexture.OnFrameAvailableListener
{
  private static final short[] jdField_a_of_type_ArrayOfShort = { 0, 1, 2, 0, 2, 3 };
  private long jdField_a_of_type_Long;
  private MediaPlayer.OnCompletionListener jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener;
  public MediaPlayer a;
  private bdzm jdField_a_of_type_Bdzm;
  private LiveRoomGiftCallback jdField_a_of_type_CooperationLiveroomLiveRoomGiftCallback;
  private String jdField_a_of_type_JavaLangString;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  private ShortBuffer jdField_a_of_type_JavaNioShortBuffer;
  private float[] jdField_a_of_type_ArrayOfFloat = { -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F };
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private SurfaceTexture jdField_b_of_type_AndroidGraphicsSurfaceTexture;
  private FloatBuffer jdField_b_of_type_JavaNioFloatBuffer;
  private boolean jdField_b_of_type_Boolean;
  private float[] jdField_b_of_type_ArrayOfFloat;
  private int jdField_c_of_type_Int;
  private FloatBuffer jdField_c_of_type_JavaNioFloatBuffer;
  private volatile boolean jdField_c_of_type_Boolean;
  private float[] jdField_c_of_type_ArrayOfFloat;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private float[] jdField_d_of_type_ArrayOfFloat;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private float[] jdField_e_of_type_ArrayOfFloat;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private float[] jdField_f_of_type_ArrayOfFloat;
  private int jdField_g_of_type_Int;
  private float[] jdField_g_of_type_ArrayOfFloat;
  private int jdField_h_of_type_Int;
  private float[] jdField_h_of_type_ArrayOfFloat;
  private int jdField_i_of_type_Int;
  private float[] jdField_i_of_type_ArrayOfFloat;
  private int jdField_j_of_type_Int;
  private float[] jdField_j_of_type_ArrayOfFloat = new float[16];
  private int k = 0;
  
  bdzn(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    k();
  }
  
  private void a(String paramString)
  {
    float[] arrayOfFloat;
    if (((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramString)) || (!this.jdField_c_of_type_Boolean) || (this.jdField_f_of_type_Boolean)) && (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)) {
      if (this.k == 0)
      {
        arrayOfFloat = this.jdField_f_of_type_ArrayOfFloat;
        this.jdField_b_of_type_ArrayOfFloat = arrayOfFloat;
        if (this.k != 0) {
          break label180;
        }
        arrayOfFloat = this.jdField_g_of_type_ArrayOfFloat;
        label68:
        this.jdField_c_of_type_ArrayOfFloat = arrayOfFloat;
        this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        if (this.jdField_f_of_type_Boolean)
        {
          this.jdField_f_of_type_Boolean = false;
          this.jdField_a_of_type_Long = 0L;
          q();
        }
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        this.jdField_i_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoWidth();
        this.jdField_j_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoHeight();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        this.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangString = paramString;
        return;
        if (this.k == 1)
        {
          arrayOfFloat = this.jdField_d_of_type_ArrayOfFloat;
          break;
        }
        arrayOfFloat = this.jdField_i_of_type_ArrayOfFloat;
        break;
        label180:
        if (this.k == 1)
        {
          arrayOfFloat = this.jdField_e_of_type_ArrayOfFloat;
          break label68;
        }
        arrayOfFloat = this.jdField_h_of_type_ArrayOfFloat;
      }
      catch (Exception localException)
      {
        QLog.e("VPNGRenderer", 2, "playVideo Exception: " + localException.getMessage());
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener == null) {
          continue;
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener.onCompletion(this.jdField_a_of_type_AndroidMediaMediaPlayer);
        continue;
      }
      if (this.jdField_c_of_type_Boolean) {
        j();
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    float f2 = this.jdField_i_of_type_Int;
    float f1 = this.jdField_j_of_type_Int;
    float f3;
    if ((this.k == 1) || (this.k == 0))
    {
      f2 /= 2.0F;
      f3 = paramInt1 / f2 * f1 / paramInt2;
      if ((this.k != 1) && (this.k != 2)) {
        break label204;
      }
      if (paramInt2 * f2 < paramInt1 * f1) {
        break label194;
      }
      f3 = paramInt2 / f1;
      label81:
      f2 = f2 * f3 / paramInt1;
      f1 = f1 * f3 / paramInt2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfFloat[0] = (-f2);
      this.jdField_a_of_type_ArrayOfFloat[1] = f1;
      this.jdField_a_of_type_ArrayOfFloat[2] = (-f2);
      this.jdField_a_of_type_ArrayOfFloat[3] = (-f1);
      this.jdField_a_of_type_ArrayOfFloat[4] = f2;
      this.jdField_a_of_type_ArrayOfFloat[5] = (-f1);
      this.jdField_a_of_type_ArrayOfFloat[6] = f2;
      this.jdField_a_of_type_ArrayOfFloat[7] = f1;
      this.jdField_c_of_type_JavaNioFloatBuffer.put(this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_c_of_type_JavaNioFloatBuffer.position(0);
      return;
      f1 /= 2.0F;
      break;
      label194:
      f3 = paramInt1 / f2;
      break label81;
      label204:
      f1 = f3;
      f2 = 1.0F;
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (this.jdField_c_of_type_JavaNioFloatBuffer == null) {
      return;
    }
    b(paramInt1, paramInt2);
    GLES20.glEnableVertexAttribArray(this.jdField_f_of_type_Int);
    GLES20.glVertexAttribPointer(this.jdField_f_of_type_Int, 2, 5126, false, 0, this.jdField_c_of_type_JavaNioFloatBuffer);
    GLES20.glBindTexture(3553, this.jdField_a_of_type_ArrayOfInt[0]);
    GLES20.glUniform1i(this.jdField_c_of_type_Int, 0);
    GLES20.glEnableVertexAttribArray(this.jdField_d_of_type_Int);
    GLES20.glVertexAttribPointer(this.jdField_d_of_type_Int, 2, 5126, false, 0, this.jdField_a_of_type_JavaNioFloatBuffer);
    GLES20.glEnableVertexAttribArray(this.jdField_e_of_type_Int);
    GLES20.glVertexAttribPointer(this.jdField_e_of_type_Int, 2, 5126, false, 0, this.jdField_b_of_type_JavaNioFloatBuffer);
    GLES20.glUniformMatrix4fv(this.jdField_g_of_type_Int, 1, false, this.jdField_j_of_type_ArrayOfFloat, 0);
    GLES20.glDrawElements(4, jdField_a_of_type_ArrayOfShort.length, 5123, this.jdField_a_of_type_JavaNioShortBuffer);
    GLES20.glDisableVertexAttribArray(this.jdField_f_of_type_Int);
    GLES20.glDisableVertexAttribArray(this.jdField_d_of_type_Int);
    GLES20.glDisableVertexAttribArray(this.jdField_e_of_type_Int);
  }
  
  private void k()
  {
    this.jdField_f_of_type_ArrayOfFloat = new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.5F, 1.0F };
    this.jdField_g_of_type_ArrayOfFloat = new float[] { 0.5F, 1.0F, 0.5F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    this.jdField_e_of_type_ArrayOfFloat = new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.5F, 1.0F };
    this.jdField_d_of_type_ArrayOfFloat = new float[] { 0.5F, 1.0F, 0.5F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    this.jdField_b_of_type_ArrayOfFloat = this.jdField_f_of_type_ArrayOfFloat;
    this.jdField_c_of_type_ArrayOfFloat = this.jdField_g_of_type_ArrayOfFloat;
    this.jdField_h_of_type_ArrayOfFloat = new float[] { 0.0F, 1.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F, 1.0F };
    this.jdField_i_of_type_ArrayOfFloat = new float[] { 0.0F, 0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.5F };
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new bdzo(this));
    a(new VPNGRenderer.2(this));
  }
  
  private void l()
  {
    try
    {
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (!this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("VPNGRenderer", 1, "playVideo(" + this.jdField_a_of_type_JavaLangString + "): " + localException.getMessage());
    }
  }
  
  /* Error */
  private void m()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 250	bdzn:jdField_d_of_type_Boolean	Z
    //   6: ifne +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_0
    //   15: getfield 58	bdzn:jdField_h_of_type_Int	I
    //   18: invokestatic 253	android/opengl/GLES20:glUseProgram	(I)V
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 255	bdzn:jdField_b_of_type_Boolean	Z
    //   27: ifeq +50 -> 77
    //   30: aload_0
    //   31: getfield 81	bdzn:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   34: ifnull +43 -> 77
    //   37: aload_0
    //   38: getfield 257	bdzn:jdField_b_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   41: ifnull +36 -> 77
    //   44: aload_0
    //   45: getfield 81	bdzn:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   48: invokevirtual 243	android/media/MediaPlayer:isPlaying	()Z
    //   51: ifeq +26 -> 77
    //   54: aload_0
    //   55: getfield 257	bdzn:jdField_b_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   58: invokevirtual 262	android/graphics/SurfaceTexture:updateTexImage	()V
    //   61: aload_0
    //   62: getfield 257	bdzn:jdField_b_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   65: aload_0
    //   66: getfield 51	bdzn:jdField_j_of_type_ArrayOfFloat	[F
    //   69: invokevirtual 266	android/graphics/SurfaceTexture:getTransformMatrix	([F)V
    //   72: aload_0
    //   73: iconst_0
    //   74: putfield 255	bdzn:jdField_b_of_type_Boolean	Z
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_0
    //   80: aload_0
    //   81: getfield 268	bdzn:jdField_a_of_type_Int	I
    //   84: aload_0
    //   85: getfield 270	bdzn:jdField_b_of_type_Int	I
    //   88: invokespecial 272	bdzn:c	(II)V
    //   91: return
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    //   97: astore_1
    //   98: ldc 129
    //   100: iconst_2
    //   101: new 131	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   108: ldc_w 274
    //   111: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_1
    //   115: invokevirtual 143	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   118: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: goto -50 -> 77
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	bdzn
    //   92	4	1	localObject1	java.lang.Object
    //   97	18	1	localException	Exception
    //   130	4	1	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	11	92	finally
    //   12	14	92	finally
    //   93	95	92	finally
    //   23	77	97	java/lang/Exception
    //   23	77	130	finally
    //   77	79	130	finally
    //   98	127	130	finally
    //   131	133	130	finally
  }
  
  private void n()
  {
    this.jdField_h_of_type_Int = baay.a("attribute vec4 vPosition;\nattribute vec4 vTexCoordinate;\nattribute vec4 vTexAlphaCoordinate;\nuniform mat4 textureTransform;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexAlphaCoordinate;\nvoid main () {\n    v_TexCoordinate = (textureTransform * vTexCoordinate).xy;\n    v_TexAlphaCoordinate = (textureTransform * vTexAlphaCoordinate).xy;\n    gl_Position = vPosition;\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES texture;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexAlphaCoordinate;\nvoid main () {\n    vec4 color = texture2D(texture, v_TexCoordinate);\n    float r = texture2D(texture, v_TexAlphaCoordinate).r;\n    float g = texture2D(texture, v_TexAlphaCoordinate).g;\n    float b = texture2D(texture, v_TexAlphaCoordinate).b;\n    float alpha = min(r, min(g, b)) * texture2D(texture, v_TexAlphaCoordinate).a;\n    gl_FragColor = color;\n    gl_FragColor.a = gl_FragColor.a * alpha;\n    gl_FragColor.r = gl_FragColor.r * alpha;\n    gl_FragColor.g = gl_FragColor.g * alpha;\n    gl_FragColor.b = gl_FragColor.b * alpha;\n}");
    GLES20.glUseProgram(this.jdField_h_of_type_Int);
    this.jdField_c_of_type_Int = GLES20.glGetUniformLocation(this.jdField_h_of_type_Int, "texture");
    this.jdField_d_of_type_Int = GLES20.glGetAttribLocation(this.jdField_h_of_type_Int, "vTexCoordinate");
    this.jdField_e_of_type_Int = GLES20.glGetAttribLocation(this.jdField_h_of_type_Int, "vTexAlphaCoordinate");
    this.jdField_f_of_type_Int = GLES20.glGetAttribLocation(this.jdField_h_of_type_Int, "vPosition");
    this.jdField_g_of_type_Int = GLES20.glGetUniformLocation(this.jdField_h_of_type_Int, "textureTransform");
  }
  
  private void o()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(jdField_a_of_type_ArrayOfShort.length * 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioShortBuffer = localByteBuffer.asShortBuffer();
    this.jdField_a_of_type_JavaNioShortBuffer.put(jdField_a_of_type_ArrayOfShort);
    this.jdField_a_of_type_JavaNioShortBuffer.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(this.jdField_a_of_type_ArrayOfFloat.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_c_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
    this.jdField_c_of_type_JavaNioFloatBuffer.put(this.jdField_a_of_type_ArrayOfFloat);
    this.jdField_c_of_type_JavaNioFloatBuffer.position(0);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      return;
    }
    q();
    GLES20.glActiveTexture(33984);
    GLES20.glGenTextures(1, this.jdField_a_of_type_ArrayOfInt, 0);
    GLES20.glBindTexture(36197, this.jdField_a_of_type_ArrayOfInt[0]);
    this.jdField_b_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_ArrayOfInt[0]);
    this.jdField_b_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    Surface localSurface = new Surface(this.jdField_b_of_type_AndroidGraphicsSurfaceTexture);
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setSurface(localSurface);
      localSurface.release();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("VPNGRenderer", 1, "setupTexture(" + this.jdField_a_of_type_JavaLangString + "): " + localException.getMessage());
      }
    }
  }
  
  private void q()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(this.jdField_b_of_type_ArrayOfFloat.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
    this.jdField_a_of_type_JavaNioFloatBuffer.put(this.jdField_b_of_type_ArrayOfFloat);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(this.jdField_c_of_type_ArrayOfFloat.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_b_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
    this.jdField_b_of_type_JavaNioFloatBuffer.put(this.jdField_c_of_type_ArrayOfFloat);
    this.jdField_b_of_type_JavaNioFloatBuffer.position(0);
  }
  
  void a(bdzm parambdzm)
  {
    this.jdField_a_of_type_Bdzm = parambdzm;
  }
  
  public void a(String paramString, int paramInt, LiveRoomGiftCallback paramLiveRoomGiftCallback)
  {
    this.k = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_CooperationLiveroomLiveRoomGiftCallback = paramLiveRoomGiftCallback;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    b();
    if (this.jdField_b_of_type_AndroidGraphicsSurfaceTexture != null)
    {
      this.jdField_b_of_type_AndroidGraphicsSurfaceTexture.release();
      this.jdField_b_of_type_AndroidGraphicsSurfaceTexture = null;
    }
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(null);
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_a_of_type_CooperationLiveroomLiveRoomGiftCallback != null) {
        this.jdField_a_of_type_CooperationLiveroomLiveRoomGiftCallback.onCall(6, "");
      }
      super.c();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("VPNGRenderer", 2, "release: " + localException.getMessage());
      }
    }
  }
  
  public void d()
  {
    n();
    o();
    p();
    l();
    this.jdField_a_of_type_Bdzm.onDrawBegin();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture == null) {
      GLES20.glClearColor(1.0F, 1.0F, 1.0F, 0.0F);
    }
    for (;;)
    {
      GLES20.glClear(16640);
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(1, 771);
      m();
      GLES20.glFinish();
      return;
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    }
  }
  
  public void f() {}
  
  public void g()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("VPNGRenderer", 2, "onDestroy: " + localException.getMessage());
    }
  }
  
  public void h()
  {
    a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void i()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      if (this.jdField_a_of_type_CooperationLiveroomLiveRoomGiftCallback != null) {
        this.jdField_a_of_type_CooperationLiveroomLiveRoomGiftCallback.onCall(3, "");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("VPNGRenderer", 2, "pauseVideo: " + localException.getMessage());
      }
    }
  }
  
  public void j()
  {
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("VPNGRenderer", 2, "resumeVideo: " + localException.getMessage());
    }
  }
  
  /* Error */
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 255	bdzn:jdField_b_of_type_Boolean	Z
    //   7: aload_0
    //   8: iconst_1
    //   9: putfield 250	bdzn:jdField_d_of_type_Boolean	Z
    //   12: aload_0
    //   13: getfield 96	bdzn:jdField_a_of_type_Long	J
    //   16: lconst_0
    //   17: lcmp
    //   18: ifne +33 -> 51
    //   21: aload_0
    //   22: invokestatic 439	java/lang/System:currentTimeMillis	()J
    //   25: putfield 96	bdzn:jdField_a_of_type_Long	J
    //   28: aload_0
    //   29: getfield 64	bdzn:jdField_a_of_type_CooperationLiveroomLiveRoomGiftCallback	Lcooperation/liveroom/LiveRoomGiftCallback;
    //   32: ifnull +16 -> 48
    //   35: aload_0
    //   36: getfield 64	bdzn:jdField_a_of_type_CooperationLiveroomLiveRoomGiftCallback	Lcooperation/liveroom/LiveRoomGiftCallback;
    //   39: iconst_4
    //   40: ldc_w 376
    //   43: invokeinterface 382 3 0
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: aload_0
    //   52: getfield 64	bdzn:jdField_a_of_type_CooperationLiveroomLiveRoomGiftCallback	Lcooperation/liveroom/LiveRoomGiftCallback;
    //   55: ifnull -7 -> 48
    //   58: aload_0
    //   59: getfield 64	bdzn:jdField_a_of_type_CooperationLiveroomLiveRoomGiftCallback	Lcooperation/liveroom/LiveRoomGiftCallback;
    //   62: iconst_5
    //   63: ldc_w 376
    //   66: invokeinterface 382 3 0
    //   71: goto -23 -> 48
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	bdzn
    //   0	79	1	paramSurfaceTexture	SurfaceTexture
    // Exception table:
    //   from	to	target	type
    //   2	48	74	finally
    //   48	50	74	finally
    //   51	71	74	finally
    //   75	77	74	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdzn
 * JD-Core Version:    0.7.0.1
 */