package com.tencent.av.opengl.texture;

import android.content.Context;
import android.opengl.GLES20;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLId;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.avcore.jni.render.GLRenderListener;
import com.tencent.avcore.jni.render.IGLRenderTexture;
import com.tencent.avcore.jni.render.IRenderTextureProxy;
import com.tencent.avcore.jni.render.RenderTextureJni;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public abstract class YUVTexture
  extends BasicTexture
  implements IGLRenderTexture, IRenderTextureProxy
{
  public static float[] a;
  static boolean jdField_b_of_type_Boolean = false;
  public float a;
  private long jdField_a_of_type_Long = 0L;
  Context jdField_a_of_type_AndroidContentContext;
  private GLRenderListener jdField_a_of_type_ComTencentAvcoreJniRenderGLRenderListener;
  private final RenderTextureJni jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni;
  private final String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  public float b;
  private long jdField_b_of_type_Long = 0L;
  protected float[] b;
  private long jdField_c_of_type_Long = 0L;
  boolean jdField_c_of_type_Boolean = true;
  private long jdField_d_of_type_Long = 0L;
  volatile boolean jdField_d_of_type_Boolean = true;
  private long jdField_e_of_type_Long = 0L;
  private boolean jdField_e_of_type_Boolean = true;
  protected int k = -1;
  protected int l = 0;
  protected int m = 0;
  public int n = -1;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { 1.0F, 1.0F, 1.0F, 0.0F, 0.00093F, -0.3437F, 1.77216F, 0.0F, 1.401687F, -0.71417F, 0.00099F, 0.0F, -0.7011F, 0.525F, -0.8828F, 1.0F };
  }
  
  public YUVTexture(Context paramContext, String paramString, long paramLong)
  {
    super(null, 0);
    this.jdField_b_of_type_ArrayOfFloat = new float[] { 1.0F, 1.0F, 1.0F, 0.0F, 0.00093F, -0.3437F, 1.77216F, 0.0F, 1.401687F, -0.71417F, 0.00099F, 0.0F, -0.7011F, 0.525F, -0.8828F, 1.0F };
    this.jdField_a_of_type_Float = 1.2F;
    this.jdField_b_of_type_Float = 1.93F;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_c_of_type_Boolean = QAVConfigUtils.h();
    QLog.d("YUVTexture", 1, "ray debug,YUVTexture, initial from config,upLoadWhenGetNewData = " + this.jdField_c_of_type_Boolean);
    if (AudioHelper.a(22) == 1) {
      this.jdField_c_of_type_Boolean = true;
    }
    for (;;)
    {
      QLog.d("YUVTexture", 1, "ray debug,YUVTexture, initial upLoadWhenGetNewData = " + this.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_Int = 1;
      if (!jdField_b_of_type_Boolean) {}
      try
      {
        SoLoadUtil.a(paramContext, "xplatform", 0, false);
        jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni = new RenderTextureJni(this);
        try
        {
          if (jdField_b_of_type_Boolean)
          {
            WeakReference localWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni);
            this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.init(Utils.a(paramContext), localWeakReference, paramLong);
          }
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        catch (Error paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        finally
        {
          this.jdField_a_of_type_JavaLangString = (getClass().getSimpleName() + "_" + paramString + "_0x" + Long.toHexString(this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.getNativeContext()));
        }
        if (AudioHelper.a(22) != 0) {
          continue;
        }
        this.jdField_c_of_type_Boolean = false;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;)
        {
          localUnsatisfiedLinkError.printStackTrace();
        }
      }
    }
  }
  
  /* Error */
  public int a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: sipush 3553
    //   3: iload_2
    //   4: invokestatic 199	android/opengl/GLES20:glBindTexture	(II)V
    //   7: sipush 3553
    //   10: sipush 10241
    //   13: ldc 200
    //   15: invokestatic 204	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   18: sipush 3553
    //   21: sipush 10240
    //   24: ldc 205
    //   26: invokestatic 204	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   29: sipush 3553
    //   32: sipush 10242
    //   35: ldc 206
    //   37: invokestatic 204	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   40: sipush 3553
    //   43: sipush 10243
    //   46: ldc 206
    //   48: invokestatic 204	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   51: aload_0
    //   52: getfield 89	com/tencent/av/opengl/texture/YUVTexture:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   55: invokevirtual 212	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   58: iload_1
    //   59: invokevirtual 218	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   62: astore_3
    //   63: aload_3
    //   64: invokestatic 224	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   67: astore 4
    //   69: aload_3
    //   70: invokevirtual 229	java/io/InputStream:close	()V
    //   73: aload 4
    //   75: ifnull +61 -> 136
    //   78: sipush 3553
    //   81: iconst_0
    //   82: aload 4
    //   84: iconst_0
    //   85: invokestatic 235	android/opengl/GLUtils:texImage2D	(IILandroid/graphics/Bitmap;I)V
    //   88: aload 4
    //   90: invokevirtual 240	android/graphics/Bitmap:recycle	()V
    //   93: iload_2
    //   94: ireturn
    //   95: astore_3
    //   96: aload_3
    //   97: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   100: goto -27 -> 73
    //   103: astore 4
    //   105: aload_3
    //   106: invokevirtual 229	java/io/InputStream:close	()V
    //   109: iconst_m1
    //   110: ireturn
    //   111: astore_3
    //   112: aload_3
    //   113: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   116: goto -7 -> 109
    //   119: astore 4
    //   121: aload_3
    //   122: invokevirtual 229	java/io/InputStream:close	()V
    //   125: aload 4
    //   127: athrow
    //   128: astore_3
    //   129: aload_3
    //   130: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   133: goto -8 -> 125
    //   136: iconst_m1
    //   137: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	YUVTexture
    //   0	138	1	paramInt1	int
    //   0	138	2	paramInt2	int
    //   62	8	3	localInputStream	java.io.InputStream
    //   95	11	3	localIOException1	java.io.IOException
    //   111	11	3	localIOException2	java.io.IOException
    //   128	2	3	localIOException3	java.io.IOException
    //   67	22	4	localBitmap	android.graphics.Bitmap
    //   103	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   119	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   69	73	95	java/io/IOException
    //   63	69	103	java/lang/OutOfMemoryError
    //   105	109	111	java/io/IOException
    //   63	69	119	finally
    //   121	125	128	java/io/IOException
  }
  
  public RenderTextureJni a()
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni;
  }
  
  public String a()
  {
    long l6 = System.currentTimeMillis();
    long l1 = -1L;
    if (this.jdField_a_of_type_Long != 0L) {
      l1 = l6 - this.jdField_a_of_type_Long;
    }
    long l2 = -1L;
    if (this.jdField_b_of_type_Long != 0L) {
      l2 = l6 - this.jdField_b_of_type_Long;
    }
    long l3 = -1L;
    if (this.jdField_c_of_type_Long != 0L) {
      l3 = l6 - this.jdField_c_of_type_Long;
    }
    long l4 = -1L;
    if (this.jdField_d_of_type_Long != 0L) {
      l4 = l6 - this.jdField_d_of_type_Long;
    }
    long l5 = -1L;
    if (this.jdField_e_of_type_Long != 0L) {
      l5 = l6 - this.jdField_e_of_type_Long;
    }
    return "TAG[" + this.jdField_a_of_type_JavaLangString + "], onBindTime[" + l1 + "], MSG_SHOW[" + l2 + "], MSG_RENDER[" + l4 + "], MSG_RESET[" + l3 + "], MSG_FLUSH[" + l5 + "], isBind[" + e() + "], Source[" + c() + ", " + d() + "], ImgAngle[" + j() + "]";
  }
  
  public void a(GLRenderListener paramGLRenderListener)
  {
    this.jdField_a_of_type_ComTencentAvcoreJniRenderGLRenderListener = paramGLRenderListener;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "setIsBind, old[%s], new[%s]", Boolean.valueOf(this.jdField_e_of_type_Boolean), Boolean.valueOf(paramBoolean) });
    }
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(GLCanvas paramGLCanvas)
  {
    if (AudioHelper.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    int i;
    if (!c())
    {
      if (this.jdField_a_of_type_ArrayOfInt == null) {
        this.jdField_a_of_type_ArrayOfInt = new int[3];
      }
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        this.jdField_a_of_type_ArrayOfInt[i] = paramGLCanvas.a().a();
        i += 1;
      }
    }
    for (int j = 1;; j = 0)
    {
      TextureProgram localTextureProgram = a();
      if (this.jdField_e_of_type_Boolean) {
        if (this.jdField_c_of_type_Boolean)
        {
          if (!this.jdField_d_of_type_Boolean) {
            break label234;
          }
          this.jdField_d_of_type_Boolean = false;
          i = 1;
        }
      }
      for (;;)
      {
        if ((i != 0) || (j != 0)) {
          e();
        }
        for (i = uploadContent(this.jdField_a_of_type_ArrayOfInt);; i = -1)
        {
          if (i != -1) {
            this.k = i;
          }
          if (this.k != -1) {
            GLES20.glUniform1i(localTextureProgram.a()[10].jdField_a_of_type_Int, this.k);
          }
          this.jdField_b_of_type_Int = 1;
          if ((this.jdField_a_of_type_Boolean) && (this.n == -1))
          {
            this.n = paramGLCanvas.a().a();
            this.n = a(2130840448, this.n);
          }
          if (this.k != -1)
          {
            return true;
            i = 1;
            break;
          }
          return false;
        }
        label234:
        i = 0;
      }
    }
  }
  
  public byte[] a()
  {
    return getCaptureFrameTexture();
  }
  
  public ShaderParameter[] a(GLCanvas paramGLCanvas)
  {
    TextureProgram localTextureProgram = a();
    paramGLCanvas = super.a(paramGLCanvas);
    try
    {
      GLES20.glUniform1f(localTextureProgram.a()[7].jdField_a_of_type_Int, getImgWidth());
      GLES20.glUniform1f(localTextureProgram.a()[8].jdField_a_of_type_Int, getImgHeight());
      GLES20.glUniformMatrix4fv(localTextureProgram.a()[9].jdField_a_of_type_Int, 1, false, this.jdField_b_of_type_ArrayOfFloat, 0);
      if ((this.jdField_a_of_type_Boolean) && (this.n != -1))
      {
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glActiveTexture(33987);
        Utils.a();
        GLES20.glBindTexture(g(), this.n);
        Utils.a();
        GLES20.glUniform1i(localTextureProgram.a()[11].jdField_a_of_type_Int, 3);
        Utils.a();
        GLES20.glUniform1i(localTextureProgram.a()[12].jdField_a_of_type_Int, 1);
        Utils.a();
      }
      return paramGLCanvas;
    }
    catch (Exception localException) {}
    return paramGLCanvas;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public byte[] b()
  {
    return getFaceFeature();
  }
  
  public boolean canRender()
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.canRender();
  }
  
  public void e()
  {
    onFaceFeatureUpdate(getFaceFeature());
  }
  
  public boolean e()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public void flush(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.flush(paramBoolean);
  }
  
  public int g()
  {
    return 3553;
  }
  
  public int getCaptureFrameHeight()
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.getCaptureFrameHeight();
  }
  
  public byte[] getCaptureFrameTexture()
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.getCaptureFrameTexture();
  }
  
  public int getCaptureFrameWidth()
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.getCaptureFrameWidth();
  }
  
  public byte[] getFaceFeature()
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.getFaceFeature();
  }
  
  public byte[] getFrameTexture()
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.getFrameTexture();
  }
  
  public int getImgAngle()
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.getImgAngle();
  }
  
  public int getImgHeight()
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.getImgHeight();
  }
  
  public int getImgWidth()
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.getImgWidth();
  }
  
  public int h()
  {
    return getCaptureFrameWidth();
  }
  
  public int i()
  {
    return getCaptureFrameHeight();
  }
  
  public int j()
  {
    if (this.jdField_e_of_type_Boolean) {}
    try
    {
      this.l = getImgAngle();
      return this.l;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public int k()
  {
    return this.k;
  }
  
  public void markForPerf(int paramInt)
  {
    if (paramInt == 0) {
      if (AudioHelper.jdField_b_of_type_Boolean) {
        this.jdField_c_of_type_Long = System.currentTimeMillis();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt != 2) {
            break;
          }
        } while (!AudioHelper.jdField_b_of_type_Boolean);
        this.jdField_d_of_type_Long = System.currentTimeMillis();
        return;
        if (paramInt != 1) {
          break;
        }
      } while (!AudioHelper.jdField_b_of_type_Boolean);
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      return;
    } while ((paramInt != 3) || (!AudioHelper.jdField_b_of_type_Boolean));
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public void nativeFrameDataUpdate()
  {
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void onFaceFeatureUpdate(byte[] paramArrayOfByte)
  {
    if ((this.jdField_a_of_type_ComTencentAvcoreJniRenderGLRenderListener != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      this.jdField_a_of_type_ComTencentAvcoreJniRenderGLRenderListener.onFaceFeatureUpdate(paramArrayOfByte);
    }
  }
  
  public void onPause()
  {
    this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.onPause();
  }
  
  public void onRenderFlush()
  {
    if (this.jdField_a_of_type_ComTencentAvcoreJniRenderGLRenderListener != null) {
      this.jdField_a_of_type_ComTencentAvcoreJniRenderGLRenderListener.onRenderFlush();
    }
  }
  
  public void onRenderFrame()
  {
    if (this.jdField_a_of_type_ComTencentAvcoreJniRenderGLRenderListener != null) {
      this.jdField_a_of_type_ComTencentAvcoreJniRenderGLRenderListener.onRenderFrame();
    }
  }
  
  public void onRenderInfoNotify(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_ComTencentAvcoreJniRenderGLRenderListener != null) {
      this.jdField_a_of_type_ComTencentAvcoreJniRenderGLRenderListener.onRenderInfoNotify(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onRenderReset()
  {
    if (this.jdField_a_of_type_ComTencentAvcoreJniRenderGLRenderListener != null) {
      this.jdField_a_of_type_ComTencentAvcoreJniRenderGLRenderListener.onRenderReset();
    }
  }
  
  public void onResume()
  {
    this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.onResume();
  }
  
  public boolean updateCurFrame()
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.updateCurFrame();
  }
  
  public int uploadContent(int[] paramArrayOfInt)
  {
    return this.jdField_a_of_type_ComTencentAvcoreJniRenderRenderTextureJni.uploadContent(paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.texture.YUVTexture
 * JD-Core Version:    0.7.0.1
 */