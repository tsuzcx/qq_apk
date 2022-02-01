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
  private static final String jdField_a_of_type_JavaLangString;
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
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/avdebug/");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public FilterProcessTest()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private FilterProcessTest.DebugFile a(int paramInt)
  {
    FilterProcessTest.DebugFile[] arrayOfDebugFile = this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile;
    if ((arrayOfDebugFile != null) && (paramInt < arrayOfDebugFile.length)) {
      return arrayOfDebugFile[paramInt];
    }
    return null;
  }
  
  static String a(int paramInt)
  {
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
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
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if ((arrayOfByte != null) && (arrayOfByte.length == paramInt1))
    {
      Arrays.fill(arrayOfByte, (byte)0);
      return;
    }
    this.jdField_a_of_type_ArrayOfByte = new byte[paramInt1];
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
    //   5: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: aconst_null
    //   13: astore_3
    //   14: aconst_null
    //   15: astore_2
    //   16: new 165	java/io/FileOutputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 168	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload_1
    //   26: aload_0
    //   27: invokestatic 154	com/tencent/av/opengl/effects/FilterProcessTest:b	(Ljava/io/FileOutputStream;[B)V
    //   30: aload_1
    //   31: invokevirtual 171	java/io/FileOutputStream:flush	()V
    //   34: aload_1
    //   35: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   38: aload_1
    //   39: invokevirtual 174	java/io/FileOutputStream:close	()V
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
    //   67: invokevirtual 177	java/lang/Exception:printStackTrace	()V
    //   70: aload_0
    //   71: ifnull +13 -> 84
    //   74: aload_0
    //   75: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   78: return
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 177	java/lang/Exception:printStackTrace	()V
    //   84: return
    //   85: aload_2
    //   86: ifnull +15 -> 101
    //   89: aload_2
    //   90: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   93: goto +8 -> 101
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 177	java/lang/Exception:printStackTrace	()V
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
  
  private void b(FilterProcessRender paramFilterProcessRender, int paramInt, CameraFrame paramCameraFrame, GLTexture paramGLTexture)
  {
    FilterProcessTest.DebugFile localDebugFile = a(paramInt);
    if (localDebugFile != null)
    {
      Object localObject = null;
      int m = paramFilterProcessRender.jdField_a_of_type_Int;
      int j = paramFilterProcessRender.b;
      int n = 42;
      int k;
      int i;
      if (paramInt == 0)
      {
        k = m;
        i = j;
        if (paramCameraFrame != null)
        {
          k = m;
          i = j;
          if (paramCameraFrame.b())
          {
            paramCameraFrame = paramCameraFrame.jdField_a_of_type_ArrayOfByte;
            paramInt = paramFilterProcessRender.b;
            i = paramFilterProcessRender.jdField_a_of_type_Int;
          }
        }
      }
      else
      {
        for (paramFilterProcessRender = paramCameraFrame;; paramFilterProcessRender = paramCameraFrame)
        {
          j = 17;
          break label518;
          if (paramInt != 5) {
            break;
          }
          k = m;
          i = j;
          if (paramCameraFrame == null) {
            break label509;
          }
          k = m;
          i = j;
          if (!paramCameraFrame.b()) {
            break label509;
          }
          paramCameraFrame = paramCameraFrame.jdField_a_of_type_ArrayOfByte;
          paramInt = paramFilterProcessRender.b;
          i = paramFilterProcessRender.jdField_a_of_type_Int;
        }
        if (paramInt == 3)
        {
          k = m;
          i = j;
          if (paramGLTexture != null)
          {
            k = m;
            i = j;
            if (paramGLTexture.b != -1)
            {
              a(m, j);
              a(paramGLTexture.b, 36064, m, j, this.jdField_a_of_type_ArrayOfByte);
              paramFilterProcessRender = this.jdField_a_of_type_ArrayOfByte;
              paramInt = m;
              i = j;
              j = n;
              break label518;
            }
          }
        }
        else if (paramInt == 2)
        {
          k = m;
          i = j;
          if (paramGLTexture != null)
          {
            k = m;
            i = j;
            if (paramGLTexture.b != -1)
            {
              a(m, j);
              a(paramGLTexture.b, 36064, m, j, this.jdField_a_of_type_ArrayOfByte);
              paramFilterProcessRender = this.jdField_a_of_type_ArrayOfByte;
              paramInt = m;
              i = j;
              j = n;
              break label518;
            }
          }
        }
        else if (paramInt == 4)
        {
          paramInt = paramFilterProcessRender.b;
          j = paramFilterProcessRender.jdField_a_of_type_Int;
          k = paramInt;
          i = j;
          if (paramFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender != null)
          {
            paramCameraFrame = paramFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender.a();
            k = paramFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender.a();
            paramFilterProcessRender = paramCameraFrame;
            i = j;
            j = k;
            break label518;
          }
        }
        else
        {
          k = m;
          i = j;
          if (paramInt == 1)
          {
            if ((paramGLTexture != null) && (paramGLTexture.b != -1))
            {
              a(m, j);
              a(paramGLTexture.b, 36064, m, j, this.jdField_a_of_type_ArrayOfByte);
              paramFilterProcessRender = this.jdField_a_of_type_ArrayOfByte;
              paramInt = m;
              i = j;
              j = n;
              break label518;
            }
            k = m;
            i = j;
            if (paramGLTexture != null)
            {
              k = m;
              i = j;
              if (paramGLTexture.jdField_a_of_type_Int != -1)
              {
                a(m, j);
                YuvPostRender.a(paramGLTexture.jdField_a_of_type_Int, m, j, this.jdField_a_of_type_ArrayOfByte);
                paramFilterProcessRender = this.jdField_a_of_type_ArrayOfByte;
                paramInt = m;
                i = j;
                j = n;
                break label518;
              }
            }
          }
        }
      }
      label509:
      j = 0;
      paramInt = k;
      paramFilterProcessRender = localObject;
      label518:
      if (paramFilterProcessRender != null) {
        localDebugFile.a(paramFilterProcessRender, j, paramInt, i);
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
    int i = AudioHelper.a(24);
    int j = 0;
    if (i == 1)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
    }
    else
    {
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      b();
      this.jdField_a_of_type_Boolean = false;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startOneChat debug[");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject1).append("]");
      QLog.i("FilterProcessTest", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = null;
    Object localObject2;
    Object localObject3;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss/", Locale.getDefault());
      localObject2 = new Date(System.currentTimeMillis());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(jdField_a_of_type_JavaLangString);
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
          this.jdField_a_of_type_Boolean = false;
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
    if (this.jdField_a_of_type_Boolean)
    {
      i = j;
      if (this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile == null)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile = new FilterProcessTest.DebugFile[6];
        i = j;
      }
      while (i < this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile.length)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(jdField_a_of_type_ArrayOfJavaLangString[i]);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile;
        if (localObject3[i] != null) {
          localObject3[i].a();
        }
        this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile[i] = new FilterProcessTest.DebugFile((String)localObject2);
        i += 1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.d) {
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
  
  @TargetApi(23)
  void a(FilterProcessRender paramFilterProcessRender, int paramInt, CameraFrame paramCameraFrame, GLTexture paramGLTexture)
  {
    if (this.jdField_a_of_type_Boolean) {
      b(paramFilterProcessRender, paramInt, paramCameraFrame, paramGLTexture);
    }
    if (!this.d) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(a(paramInt));
    localObject = ((StringBuilder)localObject).toString();
    int j = paramFilterProcessRender.b * paramFilterProcessRender.jdField_a_of_type_Int * 4;
    if (paramInt != 0)
    {
      if (paramInt != 10)
      {
        int i = 0;
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if ((paramGLTexture != null) && (paramGLTexture.b != -1))
            {
              paramCameraFrame = new StringBuilder();
              paramCameraFrame.append((String)localObject);
              paramCameraFrame.append("_text_");
              paramCameraFrame.append(a(paramFilterProcessRender.jdField_a_of_type_Int, paramFilterProcessRender.b, 0));
              paramCameraFrame.append(".jpg");
              paramCameraFrame = paramCameraFrame.toString();
              RenderUtil.a(paramGLTexture.b, paramFilterProcessRender.jdField_a_of_type_Int, paramFilterProcessRender.b, paramCameraFrame);
            }
            else if ((paramGLTexture != null) && (paramGLTexture.jdField_a_of_type_Int != -1))
            {
              paramCameraFrame = this.jdField_a_of_type_ArrayOfByte;
              if ((paramCameraFrame == null) || (paramCameraFrame.length != j)) {
                this.jdField_a_of_type_ArrayOfByte = new byte[j];
              }
              paramCameraFrame = new StringBuilder();
              paramCameraFrame.append((String)localObject);
              paramCameraFrame.append("_fbo_");
              paramCameraFrame.append(a(paramFilterProcessRender.jdField_a_of_type_Int, paramFilterProcessRender.b, 42));
              paramCameraFrame.append(".yuv");
              paramCameraFrame = paramCameraFrame.toString();
              YuvPostRender.a(paramGLTexture.jdField_a_of_type_Int, paramFilterProcessRender.jdField_a_of_type_Int, paramFilterProcessRender.b, this.jdField_a_of_type_ArrayOfByte);
              a(this.jdField_a_of_type_ArrayOfByte, paramCameraFrame);
            }
            else if ((paramCameraFrame != null) && (paramCameraFrame.b()))
            {
              paramGLTexture = new StringBuilder();
              paramGLTexture.append((String)localObject);
              paramGLTexture.append("_data_");
              paramGLTexture.append(a(paramFilterProcessRender.b, paramFilterProcessRender.jdField_a_of_type_Int, 17));
              paramGLTexture.append(".yuv");
              paramFilterProcessRender = paramGLTexture.toString();
              a(paramCameraFrame.jdField_a_of_type_ArrayOfByte, paramFilterProcessRender);
            }
          }
          else if ((paramCameraFrame != null) && (paramCameraFrame.b()))
          {
            paramGLTexture = new StringBuilder();
            paramGLTexture.append((String)localObject);
            paramGLTexture.append("_directReturn_");
            paramGLTexture.append(a(paramFilterProcessRender.b, paramFilterProcessRender.jdField_a_of_type_Int, 17));
            paramGLTexture.append(".yuv");
            paramFilterProcessRender = paramGLTexture.toString();
            a(paramCameraFrame.jdField_a_of_type_ArrayOfByte, paramFilterProcessRender);
          }
        }
        else
        {
          if ((paramGLTexture != null) && (paramGLTexture.jdField_a_of_type_Int != -1))
          {
            paramCameraFrame = this.jdField_a_of_type_ArrayOfByte;
            if ((paramCameraFrame == null) || (paramCameraFrame.length != j)) {
              this.jdField_a_of_type_ArrayOfByte = new byte[j];
            }
            paramCameraFrame = new StringBuilder();
            paramCameraFrame.append((String)localObject);
            paramCameraFrame.append("_rgbRotateCenterTextureFbo_");
            paramCameraFrame.append(paramGLTexture.jdField_a_of_type_Int);
            paramCameraFrame.append("_");
            paramCameraFrame.append(a(paramFilterProcessRender.b, paramFilterProcessRender.jdField_a_of_type_Int, 42));
            paramCameraFrame.append(".yuv");
            paramCameraFrame = paramCameraFrame.toString();
            YuvPostRender.a(paramGLTexture.jdField_a_of_type_Int, paramFilterProcessRender.b, paramFilterProcessRender.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
            a(this.jdField_a_of_type_ArrayOfByte, paramCameraFrame);
          }
          if ((paramGLTexture != null) && (paramGLTexture.b != -1))
          {
            paramCameraFrame = new StringBuilder();
            paramCameraFrame.append((String)localObject);
            paramCameraFrame.append("_rgbRotateCenterTextureId_");
            paramCameraFrame.append(a(paramFilterProcessRender.b, paramFilterProcessRender.jdField_a_of_type_Int, 0));
            paramCameraFrame.append(".jpg");
            paramCameraFrame = paramCameraFrame.toString();
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
            paramGLTexture = new StringBuilder();
            paramGLTexture.append((String)localObject);
            paramGLTexture.append("_i420Data_");
            paramGLTexture.append(a(paramFilterProcessRender.b, paramFilterProcessRender.jdField_a_of_type_Int, 17));
            paramGLTexture.append(".yuv");
            a(paramCameraFrame, paramGLTexture.toString());
          }
          else if ((paramCameraFrame != null) && (paramInt == 42))
          {
            paramGLTexture = new StringBuilder();
            paramGLTexture.append((String)localObject);
            paramGLTexture.append("_rgbaData_");
            paramGLTexture.append(a(paramFilterProcessRender.b, paramFilterProcessRender.jdField_a_of_type_Int, 42));
            paramGLTexture.append(".yuv");
            a(paramCameraFrame, paramGLTexture.toString());
          }
        }
      }
      else if ((paramCameraFrame != null) && (paramCameraFrame.b()))
      {
        paramGLTexture = new StringBuilder();
        paramGLTexture.append((String)localObject);
        paramGLTexture.append("_beauty2D_");
        paramGLTexture.append(a(paramFilterProcessRender.b, paramFilterProcessRender.jdField_a_of_type_Int, 17));
        paramGLTexture.append(".yuv");
        paramFilterProcessRender = paramGLTexture.toString();
        a(paramCameraFrame.jdField_a_of_type_ArrayOfByte, paramFilterProcessRender);
      }
    }
    else if ((paramCameraFrame != null) && (paramCameraFrame.b()))
    {
      paramGLTexture = new StringBuilder();
      paramGLTexture.append((String)localObject);
      paramGLTexture.append("_yuvData_");
      paramGLTexture.append(a(paramFilterProcessRender.b, paramFilterProcessRender.jdField_a_of_type_Int, 17));
      paramGLTexture.append(".yuv");
      paramFilterProcessRender = paramGLTexture.toString();
      a(paramCameraFrame.jdField_a_of_type_ArrayOfByte, paramFilterProcessRender);
    }
    this.jdField_a_of_type_Int += 1;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FilterProcessTest", 2, "endOfOneChat");
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    FilterProcessTest.DebugFile[] arrayOfDebugFile = this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile;
    if ((arrayOfDebugFile != null) && (arrayOfDebugFile.length > 0))
    {
      int i = 0;
      for (;;)
      {
        arrayOfDebugFile = this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile;
        if (i >= arrayOfDebugFile.length) {
          break;
        }
        if (arrayOfDebugFile[i] != null)
        {
          arrayOfDebugFile[i].a();
          this.jdField_a_of_type_ArrayOfComTencentAvOpenglEffectsFilterProcessTest$DebugFile[i] = null;
        }
        i += 1;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append(((SimpleDateFormat)localObject).format(localDate));
      this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
      localObject = new File(this.jdField_b_of_type_JavaLangString);
      if (((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) && (!((File)localObject).mkdirs()))
      {
        this.d = false;
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("beginTestSaveData mkdir fail path: ");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
          QLog.i("FilterProcessTest", 2, ((StringBuilder)localObject).toString());
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("beginTestSaveData path: ");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
        QLog.i("FilterProcessTest", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void d()
  {
    if (this.d)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("图片已经保存在日志目录下\n");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      AudioHelper.c(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.FilterProcessTest
 * JD-Core Version:    0.7.0.1
 */