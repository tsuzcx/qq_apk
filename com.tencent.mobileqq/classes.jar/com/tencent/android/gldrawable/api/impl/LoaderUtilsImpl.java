package com.tencent.android.gldrawable.api.impl;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import com.tencent.android.gldrawable.api.ILoadUtils;
import com.tencent.android.gldrawable.api.IReporter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKProcessor;
import com.tencent.mobileqq.vas.gldrawable.GLDrawableDownloadHelper;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/api/impl/LoaderUtilsImpl;", "Lcom/tencent/android/gldrawable/api/ILoadUtils;", "()V", "isFirstLoadApk", "", "()Z", "setFirstLoadApk", "(Z)V", "checkCRC", "f1", "Ljava/io/File;", "f2", "copyFile", "", "origin", "dst", "deleteFilesInDirectory", "dir", "getApkFile", "context", "Landroid/content/Context;", "getApplication", "Landroid/app/Application;", "getReport", "Lcom/tencent/android/gldrawable/api/IReporter;", "getTestApkFile", "postSubTask", "block", "Lkotlin/Function0;", "postUITask", "showTestToast", "toast", "", "unzipFile", "dstDir", "Companion", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class LoaderUtilsImpl
  implements ILoadUtils
{
  public static final LoaderUtilsImpl.Companion Companion = new LoaderUtilsImpl.Companion(null);
  private static final boolean DEBUG = false;
  private boolean isFirstLoadApk = true;
  
  public boolean checkCRC(@NotNull File paramFile1, @NotNull File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "f1");
    Intrinsics.checkParameterIsNotNull(paramFile2, "f2");
    long l1 = IOUtil.getCRC32Value(paramFile1);
    boolean bool = false;
    if (l1 == -1L) {
      return false;
    }
    long l2 = IOUtil.getCRC32Value(paramFile2);
    if (l2 == -1L) {
      return false;
    }
    if (l2 == l1) {
      bool = true;
    }
    return bool;
  }
  
  public void copyFile(@NotNull File paramFile1, @NotNull File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "origin");
    Intrinsics.checkParameterIsNotNull(paramFile2, "dst");
    if (FileUtils.copyFile(paramFile1, paramFile2)) {
      return;
    }
    throw ((Throwable)new IOException());
  }
  
  public void deleteFilesInDirectory(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "dir");
    FileUtils.deleteFilesInDirectory(paramFile.getAbsolutePath());
  }
  
  @NotNull
  public File getApkFile(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (!QVipSDKProcessor.c().a()) {
      return new File("none");
    }
    if ((!GLDrawableDownloadHelper.a(paramContext)) || (this.isFirstLoadApk))
    {
      GLDrawableDownloadHelper.a();
      this.isFirstLoadApk = false;
    }
    return new File(GLDrawableDownloadHelper.a(paramContext));
  }
  
  @NotNull
  public Application getApplication()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplication.getContext()");
    return (Application)localBaseApplication;
  }
  
  @NotNull
  public IReporter getReport()
  {
    return (IReporter)new LoaderUtilsImpl.getReport.1("GLDrawable");
  }
  
  @NotNull
  public File getTestApkFile()
  {
    return new File(getApplication().getExternalFilesDir(""), "gldrawable.apk");
  }
  
  public final boolean isFirstLoadApk()
  {
    return this.isFirstLoadApk;
  }
  
  public void postSubTask(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    ThreadManagerV2.executeOnSubThread((Runnable)new LoaderUtilsImpl.sam.java_lang_Runnable.0(paramFunction0));
  }
  
  public void postUITask(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new LoaderUtilsImpl.sam.java_lang_Runnable.0(paramFunction0));
  }
  
  public final void setFirstLoadApk(boolean paramBoolean)
  {
    this.isFirstLoadApk = paramBoolean;
  }
  
  public void showTestToast(@NotNull Context paramContext, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "toast");
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new LoaderUtilsImpl.showTestToast.1(paramContext, paramString));
  }
  
  public void unzipFile(@NotNull File paramFile1, @NotNull File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "origin");
    Intrinsics.checkParameterIsNotNull(paramFile2, "dstDir");
    Pattern localPattern = Pattern.compile(".*\\.so$");
    FileUtils.uncompressZip(paramFile1.getAbsolutePath(), paramFile2.getAbsolutePath(), false, localPattern);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.impl.LoaderUtilsImpl
 * JD-Core Version:    0.7.0.1
 */