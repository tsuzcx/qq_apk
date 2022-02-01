package com.tencent.luggage.wxa.fl;

import android.content.Intent;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.ah;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/test_kit/ForceKillAppNotify;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/test_kit/DebuggerBroadcastAction;", "()V", "name", "", "onAction", "", "intent", "Landroid/content/Intent;", "xml", "onKill", "appId", "versionType", "", "Companion", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public abstract class b
  implements a
{
  public static final b.a c = new b.a(null);
  
  @JvmStatic
  public static final void b(@NotNull String paramString, int paramInt)
  {
    c.a(paramString, paramInt);
  }
  
  @NotNull
  public String a()
  {
    return "ForceKillAppNotify";
  }
  
  public void a(@NotNull Intent paramIntent, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    Intrinsics.checkParameterIsNotNull(paramString, "xml");
    int i = ((CharSequence)paramString).length();
    int j = 1;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    paramString = ah.a(paramString, "sysmsg", null);
    paramIntent = (String)paramString.get(".sysmsg.AppBrandForceKill.AppId");
    int k = af.a((String)paramString.get(".sysmsg.AppBrandForceKill.VersionType"), 0);
    paramString = (CharSequence)paramIntent;
    i = j;
    if (paramString != null) {
      if (paramString.length() == 0) {
        i = j;
      } else {
        i = 0;
      }
    }
    if (i != 0) {
      return;
    }
    a(paramIntent, k);
  }
  
  public abstract void a(@NotNull String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fl.b
 * JD-Core Version:    0.7.0.1
 */