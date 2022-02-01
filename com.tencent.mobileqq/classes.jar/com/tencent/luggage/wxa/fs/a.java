package com.tencent.luggage.wxa.fs;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.pd.g;
import com.tencent.luggage.wxaapi.DebugApi;
import com.tencent.luggage.wxaapi.LaunchWxaAppResultListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/debug/WxaDebugApiDummyIMPL;", "Lcom/tencent/luggage/wxaapi/DebugApi;", "()V", "debugXWeb", "", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "type", "", "deleteLibFile", "getDebugIP", "", "getIsDebugIP", "", "isMultiTaskModeEnabledForWxaApp", "launchByQRRawData", "", "codeRawData", "listener", "Lcom/tencent/luggage/wxaapi/LaunchWxaAppResultListener;", "setDebugIP", "ip", "setIsDebugIP", "isDebugIP", "setMultiTaskModeEnabledForWxaApp", "enabled", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
  implements DebugApi
{
  public a()
  {
    Object localObject = g.a("WxaDebugApiDummyIMPL", DebugApi.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "DummyInvocationHandler.c…L\", DebugApi::class.java)");
    this.a = ((DebugApi)localObject);
  }
  
  public void debugXWeb(Context paramContext, int paramInt)
  {
    this.a.debugXWeb(paramContext, paramInt);
  }
  
  public void deleteLibFile()
  {
    this.a.deleteLibFile();
  }
  
  @NonNull
  @NotNull
  public String getDebugIP()
  {
    return this.a.getDebugIP();
  }
  
  public boolean getIsDebugIP()
  {
    return this.a.getIsDebugIP();
  }
  
  public boolean isMultiTaskModeEnabledForWxaApp()
  {
    return false;
  }
  
  public long launchByQRRawData(@androidx.annotation.Nullable @org.jetbrains.annotations.Nullable Context paramContext, @NonNull @NotNull String paramString, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable LaunchWxaAppResultListener paramLaunchWxaAppResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "codeRawData");
    return this.a.launchByQRRawData(paramContext, paramString, paramLaunchWxaAppResultListener);
  }
  
  public void setDebugIP(@NonNull @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "ip");
    this.a.setDebugIP(paramString);
  }
  
  public void setIsDebugIP(boolean paramBoolean)
  {
    this.a.setIsDebugIP(paramBoolean);
  }
  
  public void setMultiTaskModeEnabledForWxaApp(boolean paramBoolean)
  {
    this.a.setMultiTaskModeEnabledForWxaApp(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fs.a
 * JD-Core Version:    0.7.0.1
 */