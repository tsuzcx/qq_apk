package com.tencent.luggage.wxa.fs;

import com.tencent.luggage.wxa.qz.w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/debug/WxaDebugApiSnapshotIMPL$Companion;", "", "()V", "KEY_DEBUG_IP", "", "KEY_IS_DEBUG_IP", "KEY_MULTI_TASK", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "TAG", "getDebugIP", "getIsDebugIP", "", "setDebugIP", "", "ip", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b$a
{
  public final w a()
  {
    return w.a("wxasnapshotdebug.cfg", 2);
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "ip");
    ((a)this).a().putString("KEY_DEBUG_IP", paramString);
  }
  
  public final boolean b()
  {
    return ((a)this).a().getBoolean("KEY_IS_DEBUG_IP", false);
  }
  
  @NotNull
  public final String c()
  {
    String str = ((a)this).a().getString("KEY_DEBUG_IP", "180.163.26.93");
    if (str == null) {
      Intrinsics.throwNpe();
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fs.b.a
 * JD-Core Version:    0.7.0.1
 */