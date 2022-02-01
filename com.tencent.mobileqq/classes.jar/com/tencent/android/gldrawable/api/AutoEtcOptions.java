package com.tencent.android.gldrawable.api;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/api/AutoEtcOptions;", "Lcom/tencent/android/gldrawable/api/GLDrawableOptions;", "()V", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "toBundle", "Landroid/os/Bundle;", "Companion", "api_release"}, k=1, mv={1, 1, 16})
public final class AutoEtcOptions
  implements GLDrawableOptions
{
  public static final AutoEtcOptions.Companion Companion = new AutoEtcOptions.Companion(null);
  @NotNull
  public static final String NAME = "AutoETC";
  @NotNull
  private String filePath = "";
  
  @NotNull
  public final String getFilePath()
  {
    return this.filePath;
  }
  
  public final void setFilePath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.filePath = paramString;
  }
  
  @NotNull
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("type_flag", "AutoETC");
    localBundle.putString("filePath", this.filePath);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.AutoEtcOptions
 * JD-Core Version:    0.7.0.1
 */