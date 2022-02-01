package com.tencent.luggage.wxa.fl;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.tencent.luggage.wxa.qz.r;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/test_kit/ForceKillAppNotify$Companion;", "", "()V", "NAME", "", "TEMPLATE", "sendKillBroadcast", "", "appId", "versionType", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b$a
{
  @JvmStatic
  public final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    Object localObject1 = new Object[2];
    localObject1[0] = paramString;
    localObject1[1] = Integer.valueOf(paramInt);
    Object localObject2 = String.format("<sysmsg type=\"AppBrandForceKill\"><AppBrandForceKill>\n\t<AppId>%s</AppId>\n\t<VersionType>%d</VersionType>\n</AppBrandForceKill></sysmsg>", Arrays.copyOf((Object[])localObject1, localObject1.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "java.lang.String.format(this, *args)");
    paramString = r.a();
    localObject1 = new Intent();
    Charset localCharset = Charsets.UTF_8;
    if (localObject2 != null)
    {
      localObject2 = ((String)localObject2).getBytes(localCharset);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "(this as java.lang.String).getBytes(charset)");
      ((Intent)localObject1).putExtra("kContent", Base64.encode((byte[])localObject2, 0));
      ((Intent)localObject1).putExtra("kAction", "ForceKillAppNotify");
      ((Intent)localObject1).setAction("com.tencent.wmpf.dev.testkit.DebuggerBroadcastReceiver.ACTION");
      paramString.sendBroadcast((Intent)localObject1);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fl.b.a
 * JD-Core Version:    0.7.0.1
 */