package com.tencent.android.gldrawable.api;

import android.os.Bundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/api/GLDrawableOptions;", "", "toBundle", "Landroid/os/Bundle;", "Companion", "api_release"}, k=1, mv={1, 1, 16})
public abstract interface GLDrawableOptions
{
  public static final GLDrawableOptions.Companion Companion = GLDrawableOptions.Companion.$$INSTANCE;
  @NotNull
  public static final String TYPE_FLAG = "type_flag";
  
  @NotNull
  public abstract Bundle toBundle();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.GLDrawableOptions
 * JD-Core Version:    0.7.0.1
 */