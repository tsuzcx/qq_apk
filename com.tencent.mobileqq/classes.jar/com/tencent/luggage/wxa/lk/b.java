package com.tencent.luggage.wxa.lk;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import com.tencent.luggage.wxa.qz.o;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/IsoDepLogic;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "()V", "TAG", "", "exec", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "tag", "Landroid/nfc/Tag;", "function", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/INFCTechExecParams;", "execAsync", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "getHistoricalBytes", "", "isoDep", "Landroid/nfc/tech/IsoDep;", "getIsoDep", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 1, 16})
public final class b
  implements a
{
  public static final b a = new b();
  
  private final IsoDep a(Tag paramTag)
  {
    return IsoDep.get(paramTag);
  }
  
  private final byte[] a(IsoDep paramIsoDep)
  {
    paramIsoDep = paramIsoDep.getHistoricalBytes();
    if (paramIsoDep != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("historicalBytes: ");
      String str = Arrays.toString(paramIsoDep);
      Intrinsics.checkExpressionValueIsNotNull(str, "java.util.Arrays.toString(this)");
      localStringBuilder.append(str);
      o.e("MicroMsg.AppBrand.IsoDepLogic", localStringBuilder.toString());
      return paramIsoDep;
    }
    return null;
  }
  
  public void a(@NotNull Tag paramTag, @NotNull String paramString, @Nullable com.tencent.luggage.wxa.ll.a parama, @NotNull Function1<? super e<Object>, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramTag, "tag");
    Intrinsics.checkParameterIsNotNull(paramString, "function");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    parama = new StringBuilder();
    parama.append("execAsync, function: ");
    parama.append(paramString);
    o.e("MicroMsg.AppBrand.IsoDepLogic", parama.toString());
    paramTag = a(paramTag);
    if (paramTag == null)
    {
      paramFunction1.invoke(new e.a(13015, "unavailable tech"));
      return;
    }
    if ((paramString.hashCode() == -969018485) && (paramString.equals("getHistoricalBytes"))) {
      paramTag = (e)new e.b(a(paramTag));
    } else {
      paramTag = (e)new e.a(13024, "function not support");
    }
    paramFunction1.invoke(paramTag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lk.b
 * JD-Core Version:    0.7.0.1
 */