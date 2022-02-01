package com.tencent.av.opengl.effects;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class FilterProcessTest
{
  private static final String[] b = { "10.AV_SRC", "20.AV_PRE_RENDER", "30.AV_FILTER_NEW", "40.AV_FILTER", "50.AV_POST_RENDER", "60.AV_RETURN", "appleVideoDenoise", "appleLowLightEnhance", "applyBeauty30", "mInputTextureFbo", "applyBeauty20", "mirrorTextureIn", "mirrorTextureOut" };
  private static boolean c = false;
  private static boolean d = false;
  private static final String e;
  private static final StringBuilder k = new StringBuilder(500);
  public boolean a = false;
  private boolean f = false;
  private String g;
  private int h = 0;
  private FilterProcessTest.DebugFile[] i = null;
  private byte[] j = null;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/avdebug/");
    e = localStringBuilder.toString();
  }
  
  static String a(int paramInt)
  {
    String[] arrayOfString = b;
    if (paramInt < arrayOfString.length) {
      return arrayOfString[paramInt];
    }
    return "unknown";
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    String str;
    if (paramInt3 != 16)
    {
      if (paramInt3 != 17)
      {
        if (paramInt3 != 35)
        {
          if (paramInt3 != 42) {
            str = "UnKnown";
          } else {
            str = "RGB32";
          }
        }
        else {
          str = "YUV420";
        }
      }
      else {
        str = "NV21";
      }
    }
    else {
      str = "NV16";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[w");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("h");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("f");
    localStringBuilder.append(str);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    paramInt1 = paramInt2 * paramInt1 * 4;
    byte[] arrayOfByte = this.j;
    if ((arrayOfByte != null) && (arrayOfByte.length == paramInt1))
    {
      Arrays.fill(arrayOfByte, (byte)0);
      return;
    }
    this.j = new byte[paramInt1];
  }
  
  private static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
    GLES20.glFramebufferTexture2D(36160, paramInt2, 3553, paramInt1, 0);
    GLES20.glReadPixels(0, 0, paramInt3, paramInt4, 6408, 5121, ByteBuffer.wrap(paramArrayOfByte));
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
  }
  
  /* Error */
  private static void a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +102 -> 103
    //   4: aload_1
    //   5: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: aconst_null
    //   13: astore_3
    //   14: aconst_null
    //   15: astore_2
    //   16: new 169	java/io/FileOutputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 172	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload_1
    //   26: aload_0
    //   27: invokestatic 158	com/tencent/av/opengl/effects/FilterProcessTest:b	(Ljava/io/FileOutputStream;[B)V
    //   30: aload_1
    //   31: invokevirtual 175	java/io/FileOutputStream:flush	()V
    //   34: aload_1
    //   35: invokevirtual 178	java/io/FileOutputStream:close	()V
    //   38: aload_1
    //   39: invokevirtual 178	java/io/FileOutputStream:close	()V
    //   42: return
    //   43: astore_0
    //   44: aload_1
    //   45: astore_2
    //   46: goto +39 -> 85
    //   49: astore_2
    //   50: aload_1
    //   51: astore_0
    //   52: aload_2
    //   53: astore_1
    //   54: goto +10 -> 64
    //   57: astore_0
    //   58: goto +27 -> 85
    //   61: astore_1
    //   62: aload_3
    //   63: astore_0
    //   64: aload_0
    //   65: astore_2
    //   66: aload_1
    //   67: invokevirtual 181	java/lang/Exception:printStackTrace	()V
    //   70: aload_0
    //   71: ifnull +13 -> 84
    //   74: aload_0
    //   75: invokevirtual 178	java/io/FileOutputStream:close	()V
    //   78: return
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 181	java/lang/Exception:printStackTrace	()V
    //   84: return
    //   85: aload_2
    //   86: ifnull +15 -> 101
    //   89: aload_2
    //   90: invokevirtual 178	java/io/FileOutputStream:close	()V
    //   93: goto +8 -> 101
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 181	java/lang/Exception:printStackTrace	()V
    //   101: aload_0
    //   102: athrow
    //   103: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramArrayOfByte	byte[]
    //   0	104	1	paramString	String
    //   15	31	2	str	String
    //   49	4	2	localException	java.lang.Exception
    //   65	25	2	arrayOfByte	byte[]
    //   13	50	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   25	38	43	finally
    //   25	38	49	java/lang/Exception
    //   16	25	57	finally
    //   66	70	57	finally
    //   16	25	61	java/lang/Exception
    //   38	42	79	java/lang/Exception
    //   74	78	79	java/lang/Exception
    //   89	93	96	java/lang/Exception
  }
  
  private FilterProcessTest.DebugFile b(int paramInt)
  {
    FilterProcessTest.DebugFile[] arrayOfDebugFile = this.i;
    if ((arrayOfDebugFile != null) && (paramInt < arrayOfDebugFile.length)) {
      return arrayOfDebugFile[paramInt];
    }
    return null;
  }
  
  private void b(FilterProcessRender paramFilterProcessRender, int paramInt, CameraFrame paramCameraFrame, GLTexture paramGLTexture)
  {
    FilterProcessTest.DebugFile localDebugFile = b(paramInt);
    if (localDebugFile != null)
    {
      Object localObject = null;
      int i2 = paramFilterProcessRender.b;
      int n = paramFilterProcessRender.c;
      int i3 = 42;
      int i1;
      int m;
      if (paramInt == 0)
      {
        i1 = i2;
        m = n;
        if (paramCameraFrame != null)
        {
          i1 = i2;
          m = n;
          if (paramCameraFrame.c())
          {
            paramCameraFrame = paramCameraFrame.a;
            paramInt = paramFilterProcessRender.c;
            m = paramFilterProcessRender.b;
          }
        }
      }
      else
      {
        for (paramFilterProcessRender = paramCameraFrame;; paramFilterProcessRender = paramCameraFrame)
        {
          n = 17;
          break label518;
          if (paramInt != 5) {
            break;
          }
          i1 = i2;
          m = n;
          if (paramCameraFrame == null) {
            break label509;
          }
          i1 = i2;
          m = n;
          if (!paramCameraFrame.c()) {
            break label509;
          }
          paramCameraFrame = paramCameraFrame.a;
          paramInt = paramFilterProcessRender.c;
          m = paramFilterProcessRender.b;
        }
        if (paramInt == 3)
        {
          i1 = i2;
          m = n;
          if (paramGLTexture != null)
          {
            i1 = i2;
            m = n;
            if (paramGLTexture.b != -1)
            {
              a(i2, n);
              a(paramGLTexture.b, 36064, i2, n, this.j);
              paramFilterProcessRender = this.j;
              paramInt = i2;
              m = n;
              n = i3;
              break label518;
            }
          }
        }
        else if (paramInt == 2)
        {
          i1 = i2;
          m = n;
          if (paramGLTexture != null)
          {
            i1 = i2;
            m = n;
            if (paramGLTexture.b != -1)
            {
              a(i2, n);
              a(paramGLTexture.b, 36064, i2, n, this.j);
              paramFilterProcessRender = this.j;
              paramInt = i2;
              m = n;
              n = i3;
              break label518;
            }
          }
        }
        else if (paramInt == 4)
        {
          paramInt = paramFilterProcessRender.c;
          n = paramFilterProcessRender.b;
          i1 = paramInt;
          m = n;
          if (paramFilterProcessRender.o != null)
          {
            paramCameraFrame = paramFilterProcessRender.o.d();
            i1 = paramFilterProcessRender.o.e();
            paramFilterProcessRender = paramCameraFrame;
            m = n;
            n = i1;
            break label518;
          }
        }
        else
        {
          i1 = i2;
          m = n;
          if (paramInt == 1)
          {
            if ((paramGLTexture != null) && (paramGLTexture.b != -1))
            {
              a(i2, n);
              a(paramGLTexture.b, 36064, i2, n, this.j);
              paramFilterProcessRender = this.j;
              paramInt = i2;
              m = n;
              n = i3;
              break label518;
            }
            i1 = i2;
            m = n;
            if (paramGLTexture != null)
            {
              i1 = i2;
              m = n;
              if (paramGLTexture.a != -1)
              {
                a(i2, n);
                YuvPostRender.a(paramGLTexture.a, i2, n, this.j);
                paramFilterProcessRender = this.j;
                paramInt = i2;
                m = n;
                n = i3;
                break label518;
              }
            }
          }
        }
      }
      label509:
      n = 0;
      paramInt = i1;
      paramFilterProcessRender = localObject;
      label518:
      if (paramFilterProcessRender != null) {
        localDebugFile.a(paramFilterProcessRender, n, paramInt, m);
      }
    }
  }
  
  private static void b(FileOutputStream paramFileOutputStream, byte[] paramArrayOfByte)
  {
    if (paramFileOutputStream != null)
    {
      if (paramArrayOfByte == null) {
        return;
      }
      try
      {
        paramFileOutputStream.write(paramArrayOfByte);
        paramFileOutputStream.flush();
        return;
      }
      catch (Throwable paramFileOutputStream)
      {
        paramFileOutputStream.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    int m = AudioHelper.a(24);
    int n = 0;
    if (m == 1)
    {
      if (this.a) {
        return;
      }
      this.a = true;
    }
    else
    {
      if (!this.a) {
        return;
      }
      b();
      this.a = false;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startOneChat debug[");
      ((StringBuilder)localObject1).append(this.a);
      ((StringBuilder)localObject1).append("]");
      QLog.i("FilterProcessTest", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = null;
    Object localObject2;
    Object localObject3;
    if (this.a)
    {
      localObject1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss/", Locale.getDefault());
      localObject2 = new Date(System.currentTimeMillis());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(e);
      ((StringBuilder)localObject3).append(((SimpleDateFormat)localObject1).format((Date)localObject2));
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject3 = new File((String)localObject2);
      if (((File)localObject3).exists())
      {
        localObject1 = localObject2;
        if (((File)localObject3).isDirectory()) {}
      }
      else
      {
        localObject1 = localObject2;
        if (!((File)localObject3).mkdirs())
        {
          this.a = false;
          localObject1 = localObject2;
          if (QLog.isDevelopLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("startOneChat mkdir fail path: ");
            ((StringBuilder)localObject1).append((String)localObject2);
            QLog.i("FilterProcessTest", 4, ((StringBuilder)localObject1).toString());
            localObject1 = localObject2;
          }
        }
      }
    }
    if (this.a)
    {
      m = n;
      if (this.i == null)
      {
        this.i = new FilterProcessTest.DebugFile[6];
        m = n;
      }
      while (m < this.i.length)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(b[m]);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = this.i;
        if (localObject3[m] != null) {
          localObject3[m].a();
        }
        this.i[m] = new FilterProcessTest.DebugFile((String)localObject2);
        m += 1;
      }
    }
  }
  
  @TargetApi(23)
  void a(FilterProcessRender paramFilterProcessRender, int paramInt, CameraFrame paramCameraFrame, GLTexture paramGLTexture)
  {
    if (this.a) {
      b(paramFilterProcessRender, paramInt, paramCameraFrame, paramGLTexture);
    }
    if (!this.f) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(a(paramInt));
    localObject = ((StringBuilder)localObject).toString();
    int n = paramFilterProcessRender.c * paramFilterProcessRender.b * 4;
    if (paramInt != 0)
    {
      if (paramInt != 10)
      {
        int m = 0;
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if ((paramGLTexture != null) && (paramGLTexture.b != -1))
            {
              paramCameraFrame = new StringBuilder();
              paramCameraFrame.append((String)localObject);
              paramCameraFrame.append("_text_");
              paramCameraFrame.append(a(paramFilterProcessRender.b, paramFilterProcessRender.c, 0));
              paramCameraFrame.append(".jpg");
              paramCameraFrame = paramCameraFrame.toString();
              RenderUtil.a(paramGLTexture.b, paramFilterProcessRender.b, paramFilterProcessRender.c, paramCameraFrame);
            }
            else if ((paramGLTexture != null) && (paramGLTexture.a != -1))
            {
              paramCameraFrame = this.j;
              if ((paramCameraFrame == null) || (paramCameraFrame.length != n)) {
                this.j = new byte[n];
              }
              paramCameraFrame = new StringBuilder();
              paramCameraFrame.append((String)localObject);
              paramCameraFrame.append("_fbo_");
              paramCameraFrame.append(a(paramFilterProcessRender.b, paramFilterProcessRender.c, 42));
              paramCameraFrame.append(".yuv");
              paramCameraFrame = paramCameraFrame.toString();
              YuvPostRender.a(paramGLTexture.a, paramFilterProcessRender.b, paramFilterProcessRender.c, this.j);
              a(this.j, paramCameraFrame);
            }
            else if ((paramCameraFrame != null) && (paramCameraFrame.c()))
            {
              paramGLTexture = new StringBuilder();
              paramGLTexture.append((String)localObject);
              paramGLTexture.append("_data_");
              paramGLTexture.append(a(paramFilterProcessRender.c, paramFilterProcessRender.b, 17));
              paramGLTexture.append(".yuv");
              paramFilterProcessRender = paramGLTexture.toString();
              a(paramCameraFrame.a, paramFilterProcessRender);
            }
          }
          else if ((paramCameraFrame != null) && (paramCameraFrame.c()))
          {
            paramGLTexture = new StringBuilder();
            paramGLTexture.append((String)localObject);
            paramGLTexture.append("_directReturn_");
            paramGLTexture.append(a(paramFilterProcessRender.c, paramFilterProcessRender.b, 17));
            paramGLTexture.append(".yuv");
            paramFilterProcessRender = paramGLTexture.toString();
            a(paramCameraFrame.a, paramFilterProcessRender);
          }
        }
        else
        {
          if ((paramGLTexture != null) && (paramGLTexture.a != -1))
          {
            paramCameraFrame = this.j;
            if ((paramCameraFrame == null) || (paramCameraFrame.length != n)) {
              this.j = new byte[n];
            }
            paramCameraFrame = new StringBuilder();
            paramCameraFrame.append((String)localObject);
            paramCameraFrame.append("_rgbRotateCenterTextureFbo_");
            paramCameraFrame.append(paramGLTexture.a);
            paramCameraFrame.append("_");
            paramCameraFrame.append(a(paramFilterProcessRender.c, paramFilterProcessRender.b, 42));
            paramCameraFrame.append(".yuv");
            paramCameraFrame = paramCameraFrame.toString();
            YuvPostRender.a(paramGLTexture.a, paramFilterProcessRender.c, paramFilterProcessRender.b, this.j);
            a(this.j, paramCameraFrame);
          }
          if ((paramGLTexture != null) && (paramGLTexture.b != -1))
          {
            paramCameraFrame = new StringBuilder();
            paramCameraFrame.append((String)localObject);
            paramCameraFrame.append("_rgbRotateCenterTextureId_");
            paramCameraFrame.append(a(paramFilterProcessRender.c, paramFilterProcessRender.b, 0));
            paramCameraFrame.append(".jpg");
            paramCameraFrame = paramCameraFrame.toString();
            RenderUtil.a(paramGLTexture.b, paramFilterProcessRender.c, paramFilterProcessRender.b, paramCameraFrame);
          }
          paramCameraFrame = null;
          paramInt = m;
          if (paramFilterProcessRender.o != null)
          {
            paramCameraFrame = paramFilterProcessRender.o.d();
            paramInt = paramFilterProcessRender.o.e();
          }
          if ((paramCameraFrame != null) && (paramInt == 35))
          {
            paramGLTexture = new StringBuilder();
            paramGLTexture.append((String)localObject);
            paramGLTexture.append("_i420Data_");
            paramGLTexture.append(a(paramFilterProcessRender.c, paramFilterProcessRender.b, 17));
            paramGLTexture.append(".yuv");
            a(paramCameraFrame, paramGLTexture.toString());
          }
          else if ((paramCameraFrame != null) && (paramInt == 42))
          {
            paramGLTexture = new StringBuilder();
            paramGLTexture.append((String)localObject);
            paramGLTexture.append("_rgbaData_");
            paramGLTexture.append(a(paramFilterProcessRender.c, paramFilterProcessRender.b, 42));
            paramGLTexture.append(".yuv");
            a(paramCameraFrame, paramGLTexture.toString());
          }
        }
      }
      else if ((paramCameraFrame != null) && (paramCameraFrame.c()))
      {
        paramGLTexture = new StringBuilder();
        paramGLTexture.append((String)localObject);
        paramGLTexture.append("_beauty2D_");
        paramGLTexture.append(a(paramFilterProcessRender.c, paramFilterProcessRender.b, 17));
        paramGLTexture.append(".yuv");
        paramFilterProcessRender = paramGLTexture.toString();
        a(paramCameraFrame.a, paramFilterProcessRender);
      }
    }
    else if ((paramCameraFrame != null) && (paramCameraFrame.c()))
    {
      paramGLTexture = new StringBuilder();
      paramGLTexture.append((String)localObject);
      paramGLTexture.append("_yuvData_");
      paramGLTexture.append(a(paramFilterProcessRender.c, paramFilterProcessRender.b, 17));
      paramGLTexture.append(".yuv");
      paramFilterProcessRender = paramGLTexture.toString();
      a(paramCameraFrame.a, paramFilterProcessRender);
    }
    this.h += 1;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FilterProcessTest", 2, "endOfOneChat");
    }
    if (!this.a) {
      return;
    }
    FilterProcessTest.DebugFile[] arrayOfDebugFile = this.i;
    if ((arrayOfDebugFile != null) && (arrayOfDebugFile.length > 0))
    {
      int m = 0;
      for (;;)
      {
        arrayOfDebugFile = this.i;
        if (m >= arrayOfDebugFile.length) {
          break;
        }
        if (arrayOfDebugFile[m] != null)
        {
          arrayOfDebugFile[m].a();
          this.i[m] = null;
        }
        m += 1;
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.f) {
      return;
    }
    if (QLog.isColorLevel())
    {
      int[] arrayOfInt = new int[1];
      GLES20.glBindFramebuffer(36160, paramInt2);
      GLES20.glGetFramebufferAttachmentParameteriv(36160, 36064, 36048, arrayOfInt, 0);
      GLES20.glGetFramebufferAttachmentParameteriv(36160, 36064, 36049, arrayOfInt, 0);
      GLES20.glBindFramebuffer(36160, 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("logFrameBuffer, action[");
      localStringBuilder.append(a(paramInt1));
      localStringBuilder.append("], fbo[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], textureid[");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("], check[");
      localStringBuilder.append(arrayOfInt[0]);
      localStringBuilder.append("]");
      QLog.w("FilterProcessRender", 1, localStringBuilder.toString());
    }
  }
  
  public void c()
  {
    this.f = d;
    if (this.f)
    {
      this.h = 0;
      Object localObject = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss/", Locale.getDefault());
      Date localDate = new Date(System.currentTimeMillis());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(e);
      localStringBuilder.append(((SimpleDateFormat)localObject).format(localDate));
      this.g = localStringBuilder.toString();
      localObject = new File(this.g);
      if (((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) && (!((File)localObject).mkdirs()))
      {
        this.f = false;
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("beginTestSaveData mkdir fail path: ");
          ((StringBuilder)localObject).append(this.g);
          QLog.i("FilterProcessTest", 2, ((StringBuilder)localObject).toString());
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("beginTestSaveData path: ");
        ((StringBuilder)localObject).append(this.g);
        QLog.i("FilterProcessTest", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void d()
  {
    if (this.f)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("图片已经保存在日志目录下\n");
      localStringBuilder.append(this.g);
      AudioHelper.d(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.FilterProcessTest
 * JD-Core Version:    0.7.0.1
 */