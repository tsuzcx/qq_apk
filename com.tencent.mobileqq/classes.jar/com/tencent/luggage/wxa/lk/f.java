package com.tencent.luggage.wxa.lk;

import android.nfc.Tag;
import android.nfc.tech.NfcA;
import com.tencent.luggage.wxa.qz.o;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NfcALogic;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "()V", "TAG", "", "emptyByteArray", "", "getEmptyByteArray", "()[B", "emptyByteArray$delegate", "Lkotlin/Lazy;", "exec", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "tag", "Landroid/nfc/Tag;", "function", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/INFCTechExecParams;", "execAsync", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "getAtqa", "nfcA", "Landroid/nfc/tech/NfcA;", "getNfcA", "getSak", "", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 1, 16})
public final class f
  implements a
{
  public static final f a = new f();
  private static final Lazy b = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0)f.a.a);
  
  private final NfcA a(Tag paramTag)
  {
    return NfcA.get(paramTag);
  }
  
  private final byte[] a()
  {
    return (byte[])b.getValue();
  }
  
  private final byte[] a(NfcA paramNfcA)
  {
    paramNfcA = paramNfcA.getAtqa();
    if (paramNfcA == null) {
      paramNfcA = a();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("atqa: ");
    String str = Arrays.toString(paramNfcA);
    Intrinsics.checkExpressionValueIsNotNull(str, "java.util.Arrays.toString(this)");
    localStringBuilder.append(str);
    o.e("MicroMsg.AppBrand.NfcALogic", localStringBuilder.toString());
    return paramNfcA;
  }
  
  private final short b(NfcA paramNfcA)
  {
    return paramNfcA.getSak();
  }
  
  public void a(@NotNull Tag paramTag, @NotNull String paramString, @Nullable com.tencent.luggage.wxa.ll.a parama, @NotNull Function1<? super e<Object>, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramTag, "tag");
    Intrinsics.checkParameterIsNotNull(paramString, "function");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    parama = new StringBuilder();
    parama.append("execAsync, function: ");
    parama.append(paramString);
    o.e("MicroMsg.AppBrand.NfcALogic", parama.toString());
    paramTag = a(paramTag);
    if (paramTag == null)
    {
      paramFunction1.invoke(new e.a(13015, "unavailable tech"));
      return;
    }
    int i = paramString.hashCode();
    if (i != -1249350489)
    {
      if ((i == -75677191) && (paramString.equals("getAtqa")))
      {
        paramTag = (e)new e.b(a(paramTag));
        break label178;
      }
    }
    else if (paramString.equals("getSak"))
    {
      paramTag = (e)new e.b(Short.valueOf(b(paramTag)));
      break label178;
    }
    paramTag = (e)new e.a(13024, "function not support");
    label178:
    paramFunction1.invoke(paramTag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lk.f
 * JD-Core Version:    0.7.0.1
 */