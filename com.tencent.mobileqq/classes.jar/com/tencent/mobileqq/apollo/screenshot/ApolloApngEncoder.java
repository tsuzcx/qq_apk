package com.tencent.mobileqq.apollo.screenshot;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/ApolloApngEncoder;", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloScreenshotEncoder;", "()V", "mFrameCount", "", "mHandle", "", "addFrame", "", "pixels", "", "width", "height", "close", "convertToGif", "", "apngInputPath", "", "gifOutputPath", "encode", "outputFilePath", "frameTime", "getFrameCount", "init", "nativeEncoderAddFrame", "handle", "delayNum", "delayDenominator", "nativeEncoderAssemble", "outputPath", "nativeEncoderConvertGif", "gifEncoderType", "nativeEncoderInit", "nativeEncoderRelease", "nativeEncoderSavePNGs", "outputDir", "nativeEncoderSetOptimization", "skipFirst", "skipPalette", "skipColor", "zipLevel", "nativeEncoderSetTrueColorBoost", "set", "setOptimization", "setTrueColorBoost", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloApngEncoder
  implements IApolloScreenshotEncoder
{
  public static final ApolloApngEncoder.Companion a;
  private static final File jdField_a_of_type_JavaIoFile = BaseApplicationImpl.getContext().getDir(d, 0);
  @NotNull
  private static final String jdField_a_of_type_JavaLangString = "[ApolloScrshot]-apng";
  private static boolean jdField_a_of_type_Boolean = false;
  @NotNull
  private static final File jdField_b_of_type_JavaIoFile = new File(jdField_a_of_type_JavaIoFile, c);
  @NotNull
  private static final String jdField_b_of_type_JavaLangString = "apng_encoder";
  @NotNull
  private static final String c = "libapng_encoder.so";
  @NotNull
  private static final String d = "apng";
  @NotNull
  private static final String e = "/sdcard/libapng_encoder.so";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloApngEncoder$Companion = new ApolloApngEncoder.Companion(null);
    jdField_a_of_type_JavaLangString = "[ApolloScrshot]-apng";
    jdField_b_of_type_JavaLangString = "apng_encoder";
    c = "libapng_encoder.so";
    d = "apng";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/sdcard/");
    localStringBuilder.append(c);
    e = localStringBuilder.toString();
  }
  
  public ApolloApngEncoder()
  {
    jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloApngEncoder$Companion.a();
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    long l = this.jdField_a_of_type_Long;
    if (l == 0L) {
      return;
    }
    nativeEncoderSetOptimization(l, paramBoolean1, paramBoolean2, paramBoolean3, paramInt);
  }
  
  private final void b(boolean paramBoolean)
  {
    long l = this.jdField_a_of_type_Long;
    if (l == 0L) {
      return;
    }
    try
    {
      nativeEncoderSetTrueColorBoost(l, paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "setTrueColorBoost", localThrowable);
    }
  }
  
  private final native int nativeEncoderAddFrame(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private final native boolean nativeEncoderAssemble(long paramLong, String paramString);
  
  private final native boolean nativeEncoderConvertGif(String paramString1, String paramString2, int paramInt);
  
  private final native long nativeEncoderInit();
  
  private final native void nativeEncoderRelease(long paramLong);
  
  private final native void nativeEncoderSavePNGs(long paramLong, String paramString);
  
  private final native void nativeEncoderSetOptimization(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt);
  
  private final native void nativeEncoderSetTrueColorBoost(long paramLong, boolean paramBoolean);
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (!jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloApngEncoder$Companion.b()) {
      return;
    }
    b();
    this.jdField_a_of_type_Long = nativeEncoderInit();
    a(false, false, false, 1);
    b(true);
  }
  
  public void a(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
    if (jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloApngEncoder$Companion.b())
    {
      if (this.jdField_a_of_type_Long == 0L) {
        return;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 4, "addFrame");
      this.jdField_a_of_type_Int += 1;
      nativeEncoderAddFrame(this.jdField_a_of_type_Long, paramArrayOfByte, paramInt1, paramInt2, 0, 0);
    }
  }
  
  public boolean a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "outputFilePath");
    boolean bool1 = jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloApngEncoder$Companion.b();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    bool1 = bool2;
    if (this.jdField_a_of_type_Long != 0L)
    {
      if (TextUtils.isEmpty((CharSequence)paramString)) {
        return false;
      }
      Object localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("assemble to ");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 4, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append('_');
      ((StringBuilder)localObject).append(System.nanoTime());
      localObject = ((StringBuilder)localObject).toString();
      bool1 = bool2;
      if (nativeEncoderAssemble(this.jdField_a_of_type_Long, (String)localObject))
      {
        bool1 = bool2;
        if (FileUtils.rename((String)localObject, paramString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final boolean a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "apngInputPath");
    Intrinsics.checkParameterIsNotNull(paramString2, "gifOutputPath");
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("convertToGif ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" to ");
    localStringBuilder.append(paramString2);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    localObject = new File(paramString1);
    if (((File)localObject).exists())
    {
      if (((File)localObject).length() <= 0L) {
        return false;
      }
      try
      {
        FileUtils.createFileIfNotExits(paramString2);
        boolean bool = nativeEncoderConvertGif(paramString1, paramString2, 1);
        return bool;
      }
      catch (Throwable paramString1)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "convertToGif", paramString1);
      }
    }
    return false;
  }
  
  public void b()
  {
    if (!jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloApngEncoder$Companion.b()) {
      return;
    }
    long l = this.jdField_a_of_type_Long;
    if (l != 0L)
    {
      nativeEncoderRelease(l);
      this.jdField_a_of_type_Long = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloApngEncoder
 * JD-Core Version:    0.7.0.1
 */