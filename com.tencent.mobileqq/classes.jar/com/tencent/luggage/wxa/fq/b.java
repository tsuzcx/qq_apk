package com.tencent.luggage.wxa.fq;

import android.content.Context;
import androidx.annotation.StringRes;
import com.tencent.luggage.wxa.dc.o;
import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.jj.u;
import com.tencent.luggage.wxa.qw.lv;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import com.tencent.luggage.wxaapi.DebugApi;
import com.tencent.luggage.wxaapi.WxaApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/DemoScan;", "", "()V", "API", "Lcom/tencent/luggage/wxaapi/WxaApi;", "TAG", "", "isMultiTaskModeEnabledForWxaApp", "", "()Z", "attachAPI", "", "api", "byQRRawData", "context", "Landroid/content/Context;", "rawData", "timestamp", "", "hostExtraData", "", "byQRScanner", "showToast", "resId", "", "syncAppIdByUsername", "username", "waitForQBarScanResult", "Lcom/tencent/luggage/wxaapi/internal/ui/WxaScanResultDelegateActivity$ScanResultModel;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForQRCodeHandler", "Lcom/tencent/luggage/wxaapi/internal/DemoScan$QRCodeHandleResult;", "codeData", "codeType", "codeVersion", "invokeTimestampNs", "(Landroid/content/Context;Ljava/lang/String;IILjava/util/Map;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "QRCodeHandleResult", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
{
  public static final b a = new b();
  private static WxaApi b;
  
  private final String a(String paramString)
  {
    Object localObject = (CharSequence)paramString;
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return null;
    }
    localObject = u.a().a(paramString, new String[] { "appId" });
    if (localObject != null)
    {
      localObject = ((s)localObject).d;
      if (localObject != null) {
        return localObject;
      }
    }
    try
    {
      localObject = o.a(null, paramString);
      u.a().b(paramString, (lv)localObject);
      paramString = u.a().a(paramString, new String[] { "appId" }).d;
      if (paramString == null) {
        Intrinsics.throwNpe();
      }
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private final void a(@StringRes int paramInt)
  {
    f.a.a((Runnable)new b.c(paramInt));
  }
  
  private final boolean a()
  {
    Object localObject = b;
    if (localObject != null)
    {
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("API");
      }
      localObject = ((WxaApi)localObject).getDebugApi();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "API.debugApi");
      return ((DebugApi)localObject).isMultiTaskModeEnabledForWxaApp();
    }
    return false;
  }
  
  public final void a(@NotNull Context paramContext, @NotNull String paramString, long paramLong, @Nullable Map<String, ? extends Object> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "rawData");
    BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, null, null, (Function2)new b.b(paramContext, paramString, paramMap, paramLong, null), 3, null);
  }
  
  public final void a(@NotNull WxaApi paramWxaApi)
  {
    Intrinsics.checkParameterIsNotNull(paramWxaApi, "api");
    b = paramWxaApi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.b
 * JD-Core Version:    0.7.0.1
 */