package com.tencent.android.gldrawable.api.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.android.gldrawable.api.ILoadUtils;
import com.tencent.android.gldrawable.api.IReporter;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/api/base/EmptyLoadUtils;", "Lcom/tencent/android/gldrawable/api/ILoadUtils;", "()V", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "Lkotlin/Lazy;", "workHandler", "Lcom/tencent/android/gldrawable/api/base/AutoReleaseThreadHandler;", "getWorkHandler", "()Lcom/tencent/android/gldrawable/api/base/AutoReleaseThreadHandler;", "workHandler$delegate", "checkCRC", "", "f1", "Ljava/io/File;", "f2", "copyFile", "", "origin", "dst", "deleteFilesInDirectory", "dir", "getApkFile", "context", "Landroid/content/Context;", "getApplication", "Landroid/app/Application;", "getReport", "Lcom/tencent/android/gldrawable/api/IReporter;", "getTestApkFile", "postSubTask", "block", "Lkotlin/Function0;", "postUITask", "showTestToast", "toast", "", "unzipFile", "dstDir", "api_release"}, k=1, mv={1, 1, 16})
public final class EmptyLoadUtils
  implements ILoadUtils
{
  private final Lazy mainHandler$delegate = LazyKt.lazy((Function0)EmptyLoadUtils.mainHandler.2.INSTANCE);
  private final Lazy workHandler$delegate = LazyKt.lazy((Function0)EmptyLoadUtils.workHandler.2.INSTANCE);
  
  private final Handler getMainHandler()
  {
    return (Handler)this.mainHandler$delegate.getValue();
  }
  
  private final AutoReleaseThreadHandler getWorkHandler()
  {
    return (AutoReleaseThreadHandler)this.workHandler$delegate.getValue();
  }
  
  public boolean checkCRC(@NotNull File paramFile1, @NotNull File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "f1");
    Intrinsics.checkParameterIsNotNull(paramFile2, "f2");
    paramFile1 = new StringBuilder();
    paramFile1.append("An operation is not implemented: ");
    paramFile1.append("Not yet implemented");
    throw ((Throwable)new NotImplementedError(paramFile1.toString()));
  }
  
  public void copyFile(@NotNull File paramFile1, @NotNull File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "origin");
    Intrinsics.checkParameterIsNotNull(paramFile2, "dst");
    paramFile1 = new StringBuilder();
    paramFile1.append("An operation is not implemented: ");
    paramFile1.append("Not yet implemented");
    throw ((Throwable)new NotImplementedError(paramFile1.toString()));
  }
  
  public void deleteFilesInDirectory(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "dir");
    paramFile = new StringBuilder();
    paramFile.append("An operation is not implemented: ");
    paramFile.append("Not yet implemented");
    throw ((Throwable)new NotImplementedError(paramFile.toString()));
  }
  
  @NotNull
  public File getApkFile(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = new StringBuilder();
    paramContext.append("An operation is not implemented: ");
    paramContext.append("Not yet implemented");
    throw ((Throwable)new NotImplementedError(paramContext.toString()));
  }
  
  @NotNull
  public Application getApplication()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("An operation is not implemented: ");
    localStringBuilder.append("Not yet implemented");
    throw ((Throwable)new NotImplementedError(localStringBuilder.toString()));
  }
  
  @NotNull
  public IReporter getReport()
  {
    return (IReporter)new EmptyLoadUtils.getReport.1("GLDrawable");
  }
  
  @NotNull
  public File getTestApkFile()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("An operation is not implemented: ");
    localStringBuilder.append("Not yet implemented");
    throw ((Throwable)new NotImplementedError(localStringBuilder.toString()));
  }
  
  public void postSubTask(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    getWorkHandler().post((Runnable)new EmptyLoadUtils.sam.java_lang_Runnable.0(paramFunction0));
  }
  
  public void postUITask(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))
    {
      paramFunction0.invoke();
      return;
    }
    getMainHandler().post((Runnable)new EmptyLoadUtils.sam.java_lang_Runnable.0(paramFunction0));
  }
  
  public void showTestToast(@NotNull Context paramContext, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "toast");
    paramContext = new StringBuilder();
    paramContext.append("An operation is not implemented: ");
    paramContext.append("Not yet implemented");
    throw ((Throwable)new NotImplementedError(paramContext.toString()));
  }
  
  public void unzipFile(@NotNull File paramFile1, @NotNull File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "origin");
    Intrinsics.checkParameterIsNotNull(paramFile2, "dstDir");
    paramFile1 = new StringBuilder();
    paramFile1.append("An operation is not implemented: ");
    paramFile1.append("Not yet implemented");
    throw ((Throwable)new NotImplementedError(paramFile1.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.base.EmptyLoadUtils
 * JD-Core Version:    0.7.0.1
 */