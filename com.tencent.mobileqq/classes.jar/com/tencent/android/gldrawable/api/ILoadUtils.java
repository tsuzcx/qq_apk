package com.tencent.android.gldrawable.api;

import android.app.Application;
import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/api/ILoadUtils;", "", "checkCRC", "", "f1", "Ljava/io/File;", "f2", "copyFile", "", "origin", "dst", "deleteFilesInDirectory", "dir", "getApkFile", "context", "Landroid/content/Context;", "getApplication", "Landroid/app/Application;", "getReport", "Lcom/tencent/android/gldrawable/api/IReporter;", "getTestApkFile", "postSubTask", "block", "Lkotlin/Function0;", "postUITask", "showTestToast", "toast", "", "unzipFile", "dstDir", "api_release"}, k=1, mv={1, 1, 16})
public abstract interface ILoadUtils
{
  public abstract boolean checkCRC(@NotNull File paramFile1, @NotNull File paramFile2);
  
  public abstract void copyFile(@NotNull File paramFile1, @NotNull File paramFile2);
  
  public abstract void deleteFilesInDirectory(@NotNull File paramFile);
  
  @NotNull
  public abstract File getApkFile(@NotNull Context paramContext);
  
  @NotNull
  public abstract Application getApplication();
  
  @NotNull
  public abstract IReporter getReport();
  
  @NotNull
  public abstract File getTestApkFile();
  
  public abstract void postSubTask(@NotNull Function0<Unit> paramFunction0);
  
  public abstract void postUITask(@NotNull Function0<Unit> paramFunction0);
  
  public abstract void showTestToast(@NotNull Context paramContext, @NotNull String paramString);
  
  public abstract void unzipFile(@NotNull File paramFile1, @NotNull File paramFile2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.ILoadUtils
 * JD-Core Version:    0.7.0.1
 */