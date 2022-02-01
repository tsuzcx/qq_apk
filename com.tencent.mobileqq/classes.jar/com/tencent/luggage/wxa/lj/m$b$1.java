package com.tencent.luggage.wxa.lj;

import android.nfc.NdefMessage;
import com.tencent.luggage.wxa.pd.p;
import com.tencent.luggage.wxa.pd.p.a;
import com.tencent.luggage.wxa.pd.p.b;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "id", "", "techs", "", "", "messages", "Landroid/nfc/NdefMessage;", "invoke"}, k=3, mv={1, 1, 16})
final class m$b$1
  extends Lambda
  implements Function3<byte[], List<? extends String>, List<? extends NdefMessage>, Unit>
{
  m$b$1(m.b paramb)
  {
    super(3);
  }
  
  public final void a(@Nullable byte[] paramArrayOfByte, @NotNull List<String> paramList, @Nullable List<NdefMessage> paramList1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "techs");
    if (paramList1 != null)
    {
      paramList1 = new HashMap(com.tencent.luggage.wxa.ll.c.a.a(paramList1));
      if (p.b.b == p.a(this.a.b.getJsRuntime(), (Map)paramList1, (p.a)this.a.b.b(p.a.class)))
      {
        o.c("MicroMsg.AppBrand.JsApiStartNFCDiscovery", "invoke, convert NativeBuffer fail");
        return;
      }
      m.a(this.a.a).a(this.a.b).a(paramArrayOfByte, paramList, paramList1);
      return;
    }
    c.a(m.a(this.a.a).a(this.a.b), paramArrayOfByte, paramList, null, 4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lj.m.b.1
 * JD-Core Version:    0.7.0.1
 */