package com.qflutter.qflutter_native_router;

import io.flutter.plugin.common.MethodChannel.Result;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/qflutter/qflutter_native_router/NativeRouter;", "", "openNativePage", "", "nativeType", "", "url", "urlParams", "", "exts", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "qflutter_native_router_release"}, k=1, mv={1, 1, 11})
public abstract interface NativeRouter
{
  public abstract void openNativePage(@Nullable String paramString1, @Nullable String paramString2, @Nullable Map<Object, ? extends Object> paramMap1, @Nullable Map<Object, ? extends Object> paramMap2, @NotNull MethodChannel.Result paramResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.qflutter_native_router.NativeRouter
 * JD-Core Version:    0.7.0.1
 */