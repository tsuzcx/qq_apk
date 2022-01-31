package com.tencent.av.opengl.texture;

import android.content.Context;
import android.opengl.GLES20;
import android.os.Looper;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import lrb;
import lsv;
import lsy;
import ltw;
import lty;
import luf;
import lug;
import lux;
import mvh;

public abstract class YUVTexture
  extends lty
{
  public static float[] a;
  static boolean jdField_b_of_type_Boolean;
  public float a;
  private long jdField_a_of_type_Long;
  protected Context a;
  private final String jdField_a_of_type_JavaLangString;
  private lrb jdField_a_of_type_Lrb;
  private luf jdField_a_of_type_Luf;
  private lug jdField_a_of_type_Lug;
  boolean jdField_a_of_type_Boolean = false;
  public float b;
  private long jdField_b_of_type_Long;
  protected float[] b;
  private long jdField_c_of_type_Long;
  boolean jdField_c_of_type_Boolean = true;
  private long d;
  public volatile boolean d;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean = true;
  protected int k = -1;
  protected int l;
  public int m = -1;
  private long mNativeContext;
  
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
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_c_of_type_Boolean = mvh.g();
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
        Looper localLooper1 = Looper.myLooper();
        if (localLooper1 != null) {
          this.jdField_a_of_type_Luf = new luf(this, localLooper1);
        }
        try
        {
          if (jdField_b_of_type_Boolean) {
            Init(lux.a(paramContext), new WeakReference(this), paramLong);
          }
          return;
        }
        catch (Exception paramContext)
        {
          Looper localLooper2;
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
          this.jdField_a_of_type_JavaLangString = (getClass().getSimpleName() + "_" + paramString + "_0x" + Long.toHexString(this.mNativeContext));
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
          continue;
          localLooper2 = Looper.getMainLooper();
          if (localLooper2 != null) {
            this.jdField_a_of_type_Luf = new luf(this, localLooper2);
          } else {
            this.jdField_a_of_type_Luf = null;
          }
        }
      }
    }
  }
  
  static void onNativeNotify(Object paramObject1, int paramInt, Object paramObject2)
  {
    paramObject1 = (YUVTexture)((WeakReference)paramObject1).get();
    if (paramObject1 != null)
    {
      if (paramInt != 0) {
        break label40;
      }
      if (AudioHelper.jdField_b_of_type_Boolean) {
        paramObject1.jdField_c_of_type_Long = System.currentTimeMillis();
      }
      paramObject1.a(0, 0, paramObject2);
    }
    label40:
    do
    {
      return;
      if (paramInt == 2)
      {
        if (AudioHelper.jdField_b_of_type_Boolean) {
          paramObject1.jdField_d_of_type_Long = System.currentTimeMillis();
        }
        paramObject1.a(2, 0, paramObject2);
        return;
      }
      if (paramInt == 1)
      {
        if (AudioHelper.jdField_b_of_type_Boolean) {
          paramObject1.jdField_e_of_type_Long = System.currentTimeMillis();
        }
        paramObject1.a(1, 0, paramObject2);
        return;
      }
    } while (paramInt != 3);
    if (AudioHelper.jdField_b_of_type_Boolean) {
      paramObject1.jdField_b_of_type_Long = System.currentTimeMillis();
    }
    paramObject1.a(3, 0, paramObject2);
  }
  
  private native int uploadContent(int[] paramArrayOfInt);
  
  native void Init(int paramInt, Object paramObject, long paramLong);
  
  native void Uninit();
  
  /* Error */
  public int a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: sipush 3553
    //   3: iload_2
    //   4: invokestatic 223	android/opengl/GLES20:glBindTexture	(II)V
    //   7: sipush 3553
    //   10: sipush 10241
    //   13: ldc 224
    //   15: invokestatic 228	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   18: sipush 3553
    //   21: sipush 10240
    //   24: ldc 229
    //   26: invokestatic 228	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   29: sipush 3553
    //   32: sipush 10242
    //   35: ldc 230
    //   37: invokestatic 228	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   40: sipush 3553
    //   43: sipush 10243
    //   46: ldc 230
    //   48: invokestatic 228	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   51: aload_0
    //   52: getfield 70	com/tencent/av/opengl/texture/YUVTexture:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   55: invokevirtual 236	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   58: iload_1
    //   59: invokevirtual 242	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   62: astore_3
    //   63: aload_3
    //   64: invokestatic 248	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   67: astore 4
    //   69: aload_3
    //   70: invokevirtual 253	java/io/InputStream:close	()V
    //   73: aload 4
    //   75: ifnull +61 -> 136
    //   78: sipush 3553
    //   81: iconst_0
    //   82: aload 4
    //   84: iconst_0
    //   85: invokestatic 259	android/opengl/GLUtils:texImage2D	(IILandroid/graphics/Bitmap;I)V
    //   88: aload 4
    //   90: invokevirtual 264	android/graphics/Bitmap:recycle	()V
    //   93: iload_2
    //   94: ireturn
    //   95: astore_3
    //   96: aload_3
    //   97: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   100: goto -27 -> 73
    //   103: astore 4
    //   105: aload_3
    //   106: invokevirtual 253	java/io/InputStream:close	()V
    //   109: iconst_m1
    //   110: ireturn
    //   111: astore_3
    //   112: aload_3
    //   113: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   116: goto -7 -> 109
    //   119: astore 4
    //   121: aload_3
    //   122: invokevirtual 253	java/io/InputStream:close	()V
    //   125: aload 4
    //   127: athrow
    //   128: astore_3
    //   129: aload_3
    //   130: invokevirtual 265	java/io/IOException:printStackTrace	()V
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
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_Luf != null)
    {
      paramObject = this.jdField_a_of_type_Luf.obtainMessage(paramInt1, 0, 0, paramObject);
      if (paramInt2 == 0) {
        this.jdField_a_of_type_Luf.sendMessage(paramObject);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      this.jdField_a_of_type_Luf.sendMessageDelayed(paramObject, paramInt2);
      return;
    }
    QLog.e(this.jdField_a_of_type_JavaLangString, 2, "notifyUpdateUI|mEventHandler == null");
  }
  
  public void a(lug paramlug)
  {
    this.jdField_a_of_type_Lug = paramlug;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "setIsBind, old[%s], new[%s]", Boolean.valueOf(this.jdField_e_of_type_Boolean), Boolean.valueOf(paramBoolean) });
    }
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(lsv paramlsv)
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
        this.jdField_a_of_type_ArrayOfInt[i] = paramlsv.a().a();
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
            break label293;
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
          for (;;)
          {
            if (this.k != -1) {
              GLES20.glUniform1i(localTextureProgram.a()[10].jdField_a_of_type_Int, this.k);
            }
            this.jdField_b_of_type_Int = 1;
            if ((this.jdField_a_of_type_Boolean) && (this.m == -1))
            {
              this.m = paramlsv.a().a();
              this.m = a(2130840081, this.m);
            }
            if (this.k == -1) {
              break label286;
            }
            return true;
            i = 1;
            break;
            if (QLog.isColorLevel()) {
              QLog.w(this.jdField_a_of_type_JavaLangString, 2, "onBind, uploadContent fail, mYuvFormat[" + this.k + "], isBind[" + this.jdField_e_of_type_Boolean + "]");
            }
          }
          label286:
          return false;
        }
        label293:
        i = 0;
      }
    }
  }
  
  public byte[] a()
  {
    return getFrameTexture();
  }
  
  public ltw[] a(lsv paramlsv)
  {
    TextureProgram localTextureProgram = a();
    paramlsv = super.a(paramlsv);
    try
    {
      GLES20.glUniform1f(localTextureProgram.a()[7].jdField_a_of_type_Int, getImgWidth());
      GLES20.glUniform1f(localTextureProgram.a()[8].jdField_a_of_type_Int, getImgHeight());
      GLES20.glUniformMatrix4fv(localTextureProgram.a()[9].jdField_a_of_type_Int, 1, false, this.jdField_b_of_type_ArrayOfFloat, 0);
      if ((this.jdField_a_of_type_Boolean) && (this.m != -1))
      {
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glActiveTexture(33987);
        lux.a();
        GLES20.glBindTexture(g(), this.m);
        lux.a();
        GLES20.glUniform1i(localTextureProgram.a()[11].jdField_a_of_type_Int, 3);
        lux.a();
        GLES20.glUniform1i(localTextureProgram.a()[12].jdField_a_of_type_Int, 1);
        lux.a();
      }
      return paramlsv;
    }
    catch (Exception localException) {}
    return paramlsv;
  }
  
  public native boolean addYUVFrame(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9);
  
  public native boolean addYuvFrame(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public boolean b()
  {
    return true;
  }
  
  public byte[] b()
  {
    return getCaptureFrameTexture();
  }
  
  public byte[] c()
  {
    return getFaceFeature();
  }
  
  public native boolean canRender();
  
  public void e()
  {
    if (this.jdField_a_of_type_Lug != null)
    {
      byte[] arrayOfByte = getFaceFeature();
      if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
        this.jdField_a_of_type_Lug.a(arrayOfByte);
      }
    }
  }
  
  public boolean e()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public native void flush(boolean paramBoolean);
  
  public int g()
  {
    return 3553;
  }
  
  native byte[] getCaptureFrameTexture();
  
  native byte[] getFaceFeature();
  
  native int getFrameCount();
  
  native int getFrameIndex();
  
  native byte[] getFrameTexture();
  
  public native int getImgAngle();
  
  public native int getImgHeight();
  
  public native int getImgWidth();
  
  native int getcaptureFrameHeight();
  
  native int getcaptureFrameWidth();
  
  public int h()
  {
    return getcaptureFrameWidth();
  }
  
  public int i()
  {
    return getcaptureFrameHeight();
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
  
  public native void onPause();
  
  public native void onResume();
  
  public native boolean updateCurFrame();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.opengl.texture.YUVTexture
 * JD-Core Version:    0.7.0.1
 */