package com.tencent.mobileqq.apollo.screenshot;

import anbg;
import anbq;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/ApolloApngEncoder;", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloScreenshotEncoder;", "()V", "mHandle", "", "addFrame", "", "pixels", "", "width", "", "height", "close", "encode", "", "outputFilePath", "", "frameTime", "init", "nativeEncoderAddFrame", "handle", "delayNum", "delayDenominator", "nativeEncoderAssemble", "outputPath", "nativeEncoderInit", "nativeEncoderRelease", "nativeEncoderSavePNGs", "outputDir", "nativeEncoderSetOptimization", "skipFirst", "skipPalette", "skipColor", "zipLevel", "setOptimization", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ApolloApngEncoder
  implements anbq
{
  public static final anbg a;
  private static final File jdField_a_of_type_JavaIoFile = BaseApplicationImpl.getContext().getDir(d, 0);
  @NotNull
  private static final String jdField_a_of_type_JavaLangString = "ApolloScrshot-apng";
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
  private long jdField_a_of_type_Long;
  
  static
  {
    jdField_a_of_type_Anbg = new anbg(null);
    jdField_a_of_type_JavaLangString = "ApolloScrshot-apng";
    jdField_b_of_type_JavaLangString = "apng_encoder";
    c = "libapng_encoder.so";
    d = "apng";
    e = "/sdcard/" + c;
  }
  
  public ApolloApngEncoder()
  {
    jdField_a_of_type_Anbg.a();
  }
  
  private final native int nativeEncoderAddFrame(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private final native boolean nativeEncoderAssemble(long paramLong, String paramString);
  
  private final native long nativeEncoderInit();
  
  private final native void nativeEncoderRelease(long paramLong);
  
  private final native void nativeEncoderSavePNGs(long paramLong, String paramString);
  
  private final native void nativeEncoderSetOptimization(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt);
  
  public void a()
  {
    if (!jdField_a_of_type_Anbg.b()) {
      return;
    }
    b();
    this.jdField_a_of_type_Long = nativeEncoderInit();
    a(false, false, false, 9);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    if (this.jdField_a_of_type_Long == 0L) {
      return;
    }
    nativeEncoderSetOptimization(this.jdField_a_of_type_Long, paramBoolean1, paramBoolean2, paramBoolean3, paramInt);
  }
  
  public void a(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
    if ((!jdField_a_of_type_Anbg.b()) || (this.jdField_a_of_type_Long == 0L)) {
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "addFrame");
    nativeEncoderAddFrame(this.jdField_a_of_type_Long, paramArrayOfByte, paramInt1, paramInt2, 0, 0);
  }
  
  public boolean a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "outputFilePath");
    if (!jdField_a_of_type_Anbg.b()) {}
    while ((this.jdField_a_of_type_Long == 0L) || (TextUtils.isEmpty((CharSequence)paramString))) {
      return false;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "assemble to " + paramString);
    String str = paramString + '_' + System.nanoTime();
    if ((nativeEncoderAssemble(this.jdField_a_of_type_Long, str)) && (FileUtils.rename(str, paramString))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void b()
  {
    if (!jdField_a_of_type_Anbg.b()) {}
    while (this.jdField_a_of_type_Long == 0L) {
      return;
    }
    nativeEncoderRelease(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloApngEncoder
 * JD-Core Version:    0.7.0.1
 */