package com.tencent.av.opengl.effects;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.AudioHelper;
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
  private static final String jdField_a_of_type_JavaLangString = AppConstants.SDCARD_ROOT + "/avdebug/";
  private static final StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(500);
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "10.AV_SRC", "20.AV_PRE_RENDER", "30.AV_FILTER_NEW", "40.AV_FILTER", "50.AV_POST_RENDER", "60.AV_RETURN", "appleVideoDenoise", "appleLowLightEnhance", "applyBeauty30", "mInputTextureFbo", "applyBeauty20", "mirrorTextureIn", "mirrorTextureOut" };
  private static boolean jdField_b_of_type_Boolean = false;
  private static boolean c = false;
  private int jdField_a_of_type_Int = 0;
  public boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private FilterProcessTest.DebugFile[] jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile = null;
  private String jdField_b_of_type_JavaLangString;
  private boolean d = false;
  
  public FilterProcessTest()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private FilterProcessTest.DebugFile a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile != null)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile[paramInt];
      }
    }
    return localObject1;
  }
  
  static String a(int paramInt)
  {
    if (paramInt < jdField_a_of_type_ArrayOfJavaLangString.length) {
      return jdField_a_of_type_ArrayOfJavaLangString[paramInt];
    }
    return "unknown";
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    String str = "UnKnown";
    switch (paramInt3)
    {
    }
    for (;;)
    {
      return "[w" + paramInt1 + "h" + paramInt2 + "f" + str + "]";
      str = "RGB32";
      continue;
      str = "NV21";
      continue;
      str = "YUV420";
      continue;
      str = "NV16";
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    paramInt1 = paramInt2 * paramInt1 * 4;
    if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != paramInt1))
    {
      this.jdField_a_of_type_ArrayOfByte = new byte[paramInt1];
      return;
    }
    Arrays.fill(this.jdField_a_of_type_ArrayOfByte, (byte)0);
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
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 165	java/io/FileOutputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 168	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore_1
    //   23: aload_2
    //   24: aload_0
    //   25: invokestatic 154	com/tencent/av/opengl/effects/FilterProcessTest:b	(Ljava/io/FileOutputStream;[B)V
    //   28: aload_2
    //   29: astore_1
    //   30: aload_2
    //   31: invokevirtual 171	java/io/FileOutputStream:flush	()V
    //   34: aload_2
    //   35: astore_1
    //   36: aload_2
    //   37: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   40: aload_2
    //   41: ifnull -30 -> 11
    //   44: aload_2
    //   45: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   48: return
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 177	java/lang/Exception:printStackTrace	()V
    //   54: return
    //   55: astore_3
    //   56: aconst_null
    //   57: astore_0
    //   58: aload_0
    //   59: astore_1
    //   60: aload_3
    //   61: invokevirtual 177	java/lang/Exception:printStackTrace	()V
    //   64: aload_0
    //   65: ifnull -54 -> 11
    //   68: aload_0
    //   69: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   72: return
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 177	java/lang/Exception:printStackTrace	()V
    //   78: return
    //   79: astore_0
    //   80: aconst_null
    //   81: astore_1
    //   82: aload_1
    //   83: ifnull +7 -> 90
    //   86: aload_1
    //   87: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   90: aload_0
    //   91: athrow
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 177	java/lang/Exception:printStackTrace	()V
    //   97: goto -7 -> 90
    //   100: astore_0
    //   101: goto -19 -> 82
    //   104: astore_3
    //   105: aload_2
    //   106: astore_0
    //   107: goto -49 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramArrayOfByte	byte[]
    //   0	110	1	paramString	String
    //   20	86	2	localFileOutputStream	FileOutputStream
    //   55	6	3	localException1	java.lang.Exception
    //   104	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   44	48	49	java/lang/Exception
    //   12	21	55	java/lang/Exception
    //   68	72	73	java/lang/Exception
    //   12	21	79	finally
    //   86	90	92	java/lang/Exception
    //   23	28	100	finally
    //   30	34	100	finally
    //   36	40	100	finally
    //   60	64	100	finally
    //   23	28	104	java/lang/Exception
    //   30	34	104	java/lang/Exception
    //   36	40	104	java/lang/Exception
  }
  
  private void b(FilterProcessRender paramFilterProcessRender, int paramInt, CameraFrame paramCameraFrame, GLTexture paramGLTexture)
  {
    int n = 17;
    FilterProcessTest.DebugFile localDebugFile = a(paramInt);
    int k;
    int m;
    int i;
    int j;
    if (localDebugFile != null)
    {
      k = paramFilterProcessRender.jdField_a_of_type_Int;
      m = paramFilterProcessRender.b;
      if (paramInt != 0) {
        break label97;
      }
      i = m;
      j = k;
      if (paramCameraFrame == null) {
        break label525;
      }
      i = m;
      j = k;
      if (!paramCameraFrame.b()) {
        break label525;
      }
      paramCameraFrame = paramCameraFrame.jdField_a_of_type_ArrayOfByte;
      j = paramFilterProcessRender.b;
      i = paramFilterProcessRender.jdField_a_of_type_Int;
      paramFilterProcessRender = paramCameraFrame;
      paramInt = n;
    }
    for (;;)
    {
      if (paramFilterProcessRender != null) {
        localDebugFile.a(paramFilterProcessRender, paramInt, j, i);
      }
      return;
      label97:
      if (paramInt == 5)
      {
        i = m;
        j = k;
        if (paramCameraFrame != null)
        {
          i = m;
          j = k;
          if (paramCameraFrame.b())
          {
            paramCameraFrame = paramCameraFrame.jdField_a_of_type_ArrayOfByte;
            j = paramFilterProcessRender.b;
            i = paramFilterProcessRender.jdField_a_of_type_Int;
            paramInt = n;
            paramFilterProcessRender = paramCameraFrame;
          }
        }
      }
      else if (paramInt == 3)
      {
        i = m;
        j = k;
        if (paramGLTexture != null)
        {
          i = m;
          j = k;
          if (paramGLTexture.b != -1)
          {
            a(k, m);
            a(paramGLTexture.b, 36064, k, m, this.jdField_a_of_type_ArrayOfByte);
            paramFilterProcessRender = this.jdField_a_of_type_ArrayOfByte;
            paramInt = 42;
            i = m;
            j = k;
          }
        }
      }
      else if (paramInt == 2)
      {
        i = m;
        j = k;
        if (paramGLTexture != null)
        {
          i = m;
          j = k;
          if (paramGLTexture.b != -1)
          {
            a(k, m);
            a(paramGLTexture.b, 36064, k, m, this.jdField_a_of_type_ArrayOfByte);
            paramFilterProcessRender = this.jdField_a_of_type_ArrayOfByte;
            paramInt = 42;
            i = m;
            j = k;
          }
        }
      }
      else if (paramInt == 4)
      {
        paramInt = paramFilterProcessRender.b;
        k = paramFilterProcessRender.jdField_a_of_type_Int;
        i = k;
        j = paramInt;
        if (paramFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender != null)
        {
          paramCameraFrame = paramFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender.a();
          m = paramFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender.a();
          i = k;
          j = paramInt;
          paramInt = m;
          paramFilterProcessRender = paramCameraFrame;
        }
      }
      else
      {
        i = m;
        j = k;
        if (paramInt == 1)
        {
          if ((paramGLTexture != null) && (paramGLTexture.b != -1))
          {
            a(k, m);
            a(paramGLTexture.b, 36064, k, m, this.jdField_a_of_type_ArrayOfByte);
            paramFilterProcessRender = this.jdField_a_of_type_ArrayOfByte;
            paramInt = 42;
            i = m;
            j = k;
            continue;
          }
          i = m;
          j = k;
          if (paramGLTexture != null)
          {
            i = m;
            j = k;
            if (paramGLTexture.jdField_a_of_type_Int != -1)
            {
              a(k, m);
              YuvPostRender.a(paramGLTexture.jdField_a_of_type_Int, k, m, this.jdField_a_of_type_ArrayOfByte);
              paramFilterProcessRender = this.jdField_a_of_type_ArrayOfByte;
              paramInt = 42;
              i = m;
              j = k;
              continue;
            }
          }
        }
      }
      label525:
      paramInt = 0;
      paramFilterProcessRender = null;
    }
  }
  
  private static void b(FileOutputStream paramFileOutputStream, byte[] paramArrayOfByte)
  {
    if ((paramFileOutputStream == null) || (paramArrayOfByte == null)) {
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
  
  public void a()
  {
    int j = 0;
    if (AudioHelper.a(24) == 1) {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
    }
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FilterProcessTest", 2, "startOneChat debug[" + this.jdField_a_of_type_Boolean + "]");
      }
      Object localObject1 = null;
      Object localObject2;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss/", Locale.getDefault());
        localObject2 = new Date(System.currentTimeMillis());
        localObject2 = jdField_a_of_type_JavaLangString + ((SimpleDateFormat)localObject1).format((Date)localObject2);
        File localFile = new File((String)localObject2);
        if (localFile.exists())
        {
          localObject1 = localObject2;
          if (localFile.isDirectory()) {}
        }
        else
        {
          localObject1 = localObject2;
          if (!localFile.mkdirs())
          {
            this.jdField_a_of_type_Boolean = false;
            localObject1 = localObject2;
            if (QLog.isDevelopLevel())
            {
              QLog.i("FilterProcessTest", 4, "startOneChat mkdir fail path: " + (String)localObject2);
              localObject1 = localObject2;
            }
          }
        }
      }
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      int i = j;
      if (this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile == null)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile = new FilterProcessTest.DebugFile[6];
        i = j;
      }
      while (i < this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile.length)
      {
        localObject2 = (String)localObject1 + jdField_a_of_type_ArrayOfJavaLangString[i];
        if (this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile[i] != null) {
          this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile[i].a();
        }
        this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile[i] = new FilterProcessTest.DebugFile((String)localObject2);
        i += 1;
      }
      break;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      b();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.d) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    int[] arrayOfInt = new int[1];
    GLES20.glBindFramebuffer(36160, paramInt2);
    GLES20.glGetFramebufferAttachmentParameteriv(36160, 36064, 36048, arrayOfInt, 0);
    GLES20.glGetFramebufferAttachmentParameteriv(36160, 36064, 36049, arrayOfInt, 0);
    GLES20.glBindFramebuffer(36160, 0);
    QLog.w("FilterProcessRender", 1, "logFrameBuffer, action[" + a(paramInt1) + "], fbo[" + paramInt2 + "], textureid[" + paramInt3 + "], check[" + arrayOfInt[0] + "]");
  }
  
  @TargetApi(23)
  void a(FilterProcessRender paramFilterProcessRender, int paramInt, CameraFrame paramCameraFrame, GLTexture paramGLTexture)
  {
    int i = 0;
    if (this.jdField_a_of_type_Boolean) {
      b(paramFilterProcessRender, paramInt, paramCameraFrame, paramGLTexture);
    }
    if (!this.d) {
      return;
    }
    String str = this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Int + "_" + a(paramInt);
    int j = paramFilterProcessRender.b * paramFilterProcessRender.jdField_a_of_type_Int * 4;
    switch (paramInt)
    {
    default: 
      if ((paramGLTexture != null) && (paramGLTexture.b != -1))
      {
        paramCameraFrame = str + "_text_" + a(paramFilterProcessRender.jdField_a_of_type_Int, paramFilterProcessRender.b, 0) + ".jpg";
        RenderUtil.a(paramGLTexture.b, paramFilterProcessRender.jdField_a_of_type_Int, paramFilterProcessRender.b, paramCameraFrame);
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int += 1;
      return;
      if ((paramCameraFrame != null) && (paramCameraFrame.b()))
      {
        paramFilterProcessRender = str + "_yuvData_" + a(paramFilterProcessRender.b, paramFilterProcessRender.jdField_a_of_type_Int, 17) + ".yuv";
        a(paramCameraFrame.jdField_a_of_type_ArrayOfByte, paramFilterProcessRender);
        continue;
        if ((paramCameraFrame != null) && (paramCameraFrame.b()))
        {
          paramFilterProcessRender = str + "_beauty2D_" + a(paramFilterProcessRender.b, paramFilterProcessRender.jdField_a_of_type_Int, 17) + ".yuv";
          a(paramCameraFrame.jdField_a_of_type_ArrayOfByte, paramFilterProcessRender);
          continue;
          if ((paramCameraFrame != null) && (paramCameraFrame.b()))
          {
            paramFilterProcessRender = str + "_directReturn_" + a(paramFilterProcessRender.b, paramFilterProcessRender.jdField_a_of_type_Int, 17) + ".yuv";
            a(paramCameraFrame.jdField_a_of_type_ArrayOfByte, paramFilterProcessRender);
            continue;
            if ((paramGLTexture != null) && (paramGLTexture.jdField_a_of_type_Int != -1))
            {
              if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != j)) {
                this.jdField_a_of_type_ArrayOfByte = new byte[j];
              }
              paramCameraFrame = str + "_rgbRotateCenterTextureFbo_" + paramGLTexture.jdField_a_of_type_Int + "_" + a(paramFilterProcessRender.b, paramFilterProcessRender.jdField_a_of_type_Int, 42) + ".yuv";
              YuvPostRender.a(paramGLTexture.jdField_a_of_type_Int, paramFilterProcessRender.b, paramFilterProcessRender.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
              a(this.jdField_a_of_type_ArrayOfByte, paramCameraFrame);
            }
            if ((paramGLTexture != null) && (paramGLTexture.b != -1))
            {
              paramCameraFrame = str + "_rgbRotateCenterTextureId_" + a(paramFilterProcessRender.b, paramFilterProcessRender.jdField_a_of_type_Int, 0) + ".jpg";
              RenderUtil.a(paramGLTexture.b, paramFilterProcessRender.b, paramFilterProcessRender.jdField_a_of_type_Int, paramCameraFrame);
            }
            paramCameraFrame = null;
            paramInt = i;
            if (paramFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender != null)
            {
              paramCameraFrame = paramFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender.a();
              paramInt = paramFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender.a();
            }
            if ((paramCameraFrame != null) && (paramInt == 35))
            {
              a(paramCameraFrame, str + "_i420Data_" + a(paramFilterProcessRender.b, paramFilterProcessRender.jdField_a_of_type_Int, 17) + ".yuv");
            }
            else if ((paramCameraFrame != null) && (paramInt == 42))
            {
              a(paramCameraFrame, str + "_rgbaData_" + a(paramFilterProcessRender.b, paramFilterProcessRender.jdField_a_of_type_Int, 42) + ".yuv");
              continue;
              if ((paramGLTexture != null) && (paramGLTexture.jdField_a_of_type_Int != -1))
              {
                if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != j)) {
                  this.jdField_a_of_type_ArrayOfByte = new byte[j];
                }
                paramCameraFrame = str + "_fbo_" + a(paramFilterProcessRender.jdField_a_of_type_Int, paramFilterProcessRender.b, 42) + ".yuv";
                YuvPostRender.a(paramGLTexture.jdField_a_of_type_Int, paramFilterProcessRender.jdField_a_of_type_Int, paramFilterProcessRender.b, this.jdField_a_of_type_ArrayOfByte);
                a(this.jdField_a_of_type_ArrayOfByte, paramCameraFrame);
              }
              else if ((paramCameraFrame != null) && (paramCameraFrame.b()))
              {
                paramFilterProcessRender = str + "_data_" + a(paramFilterProcessRender.b, paramFilterProcessRender.jdField_a_of_type_Int, 17) + ".yuv";
                a(paramCameraFrame.jdField_a_of_type_ArrayOfByte, paramFilterProcessRender);
              }
            }
          }
        }
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FilterProcessTest", 2, "endOfOneChat");
    }
    if (!this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile != null) && (this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile.length > 0))
      {
        int i = 0;
        while (i < this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile.length)
        {
          if (this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile[i] != null)
          {
            this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile[i].a();
            this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile[i] = null;
          }
          i += 1;
        }
      }
    }
  }
  
  public void c()
  {
    this.d = c;
    if (this.d)
    {
      this.jdField_a_of_type_Int = 0;
      Object localObject = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss/", Locale.getDefault());
      Date localDate = new Date(System.currentTimeMillis());
      this.jdField_b_of_type_JavaLangString = (jdField_a_of_type_JavaLangString + ((SimpleDateFormat)localObject).format(localDate));
      localObject = new File(this.jdField_b_of_type_JavaLangString);
      if (((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) && (!((File)localObject).mkdirs()))
      {
        this.d = false;
        if (QLog.isDevelopLevel()) {
          QLog.i("FilterProcessTest", 2, "beginTestSaveData mkdir fail path: " + this.jdField_b_of_type_JavaLangString);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("FilterProcessTest", 2, "beginTestSaveData path: " + this.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  public void d()
  {
    if (this.d) {
      AudioHelper.c("图片已经保存在日志目录下\n" + this.jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.FilterProcessTest
 * JD-Core Version:    0.7.0.1
 */