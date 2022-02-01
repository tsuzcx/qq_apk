package com.tencent.mobileqq.apollo.screenshot;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.meme.ERROR_APNG_ENCODE_FAIL;
import com.tencent.mobileqq.apollo.meme.ERROR_APNG_ENV_INIT_FAIL;
import com.tencent.mobileqq.apollo.meme.RECORD_COMPLETE;
import com.tencent.mobileqq.cmshow.engine.action.ActionStatus;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/ApolloApngEncoder;", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloScreenshotEncoder;", "()V", "mFrameCount", "", "mHandle", "", "addFrame", "", "pixels", "", "width", "height", "close", "convertToGif", "", "apngInputPath", "", "gifOutputPath", "encode", "Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;", "outputFilePath", "frameTime", "getFrameCount", "init", "nativeEncoderAddFrame", "handle", "delayNum", "delayDenominator", "nativeEncoderAssemble", "outputPath", "nativeEncoderConvertGif", "gifEncoderType", "nativeEncoderInit", "nativeEncoderRelease", "nativeEncoderSavePNGs", "outputDir", "nativeEncoderSetOptimization", "skipFirst", "skipPalette", "skipColor", "zipLevel", "nativeEncoderSetTrueColorBoost", "set", "setOptimization", "setTrueColorBoost", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloApngEncoder
  implements IApolloScreenshotEncoder
{
  public static final ApolloApngEncoder.Companion a = new ApolloApngEncoder.Companion(null);
  @NotNull
  private static final String d = "[cmshow][MemePlayer][ApolloScrshot]-apng";
  @NotNull
  private static final String e = "apng_encoder";
  @NotNull
  private static final String f = "libapng_encoder.so";
  @NotNull
  private static final String g = "apng";
  @NotNull
  private static final String h = "/sdcard/libapng_encoder.so";
  private static final File i = BaseApplicationImpl.getContext().getDir(g, 0);
  @NotNull
  private static final File j = new File(i, f);
  private static boolean k;
  private long b;
  private int c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/sdcard/");
    localStringBuilder.append(f);
    h = localStringBuilder.toString();
  }
  
  public ApolloApngEncoder()
  {
    a.e();
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    long l = this.b;
    if (l == 0L) {
      return;
    }
    nativeEncoderSetOptimization(l, paramBoolean1, paramBoolean2, paramBoolean3, paramInt);
  }
  
  private final void b(boolean paramBoolean)
  {
    long l = this.b;
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
      QLog.e(d, 1, "setTrueColorBoost", localThrowable);
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
  
  @NotNull
  public ActionStatus a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "outputFilePath");
    if ((a.d()) && (this.b != 0L))
    {
      Object localObject = d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("assemble to ");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 4, localStringBuilder.toString());
      if (TextUtils.isEmpty((CharSequence)paramString)) {
        return (ActionStatus)ERROR_APNG_ENCODE_FAIL.a;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append('_');
      ((StringBuilder)localObject).append(System.nanoTime());
      localObject = ((StringBuilder)localObject).toString();
      if ((nativeEncoderAssemble(this.b, (String)localObject)) && (FileUtils.rename((String)localObject, paramString))) {
        return (ActionStatus)RECORD_COMPLETE.a;
      }
      return (ActionStatus)ERROR_APNG_ENCODE_FAIL.a;
    }
    return (ActionStatus)ERROR_APNG_ENV_INIT_FAIL.a;
  }
  
  public void a()
  {
    if (!a.d()) {
      return;
    }
    b();
    this.b = nativeEncoderInit();
    a(false, false, false, 1);
    b(true);
  }
  
  public void a(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
    if (a.d())
    {
      if (this.b == 0L) {
        return;
      }
      this.c += 1;
      String str = d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addFrame, frameCount:");
      localStringBuilder.append(this.c);
      QLog.d(str, 4, localStringBuilder.toString());
      nativeEncoderAddFrame(this.b, paramArrayOfByte, paramInt1, paramInt2, 0, 0);
    }
  }
  
  public final boolean a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "apngInputPath");
    Intrinsics.checkParameterIsNotNull(paramString2, "gifOutputPath");
    Object localObject = d;
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
        QLog.e(d, 1, "convertToGif", paramString1);
      }
    }
    return false;
  }
  
  public void b()
  {
    if (!a.d()) {
      return;
    }
    long l = this.b;
    if (l != 0L)
    {
      nativeEncoderRelease(l);
      this.b = 0L;
    }
  }
  
  public int c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloApngEncoder
 * JD-Core Version:    0.7.0.1
 */