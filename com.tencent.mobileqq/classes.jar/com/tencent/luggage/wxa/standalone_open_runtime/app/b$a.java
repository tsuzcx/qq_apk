package com.tencent.luggage.wxa.standalone_open_runtime.app;

import com.tencent.luggage.wxa.hk.d;
import com.tencent.luggage.wxa.hk.e;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxa/standalone_open_runtime/app/WxaIPCBridgeInitializer$install$1", "Lcom/tencent/mm/ipcinvoker/activate/DefaultInitDelegate;", "onAddTypeTransfer", "", "initializer", "Lcom/tencent/mm/ipcinvoker/activate/TypeTransferInitializer;", "onAttachServiceInfo", "Lcom/tencent/mm/ipcinvoker/activate/IPCInvokerInitializer;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b$a
  extends com.tencent.luggage.wxa.hk.a
{
  public void a(@Nullable d paramd)
  {
    if (paramd != null) {
      paramd.a(r.b(), WxaIPCMainService.class);
    }
    Class[] arrayOfClass = b.a(b.a);
    int k = arrayOfClass.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      Class localClass = arrayOfClass[j];
      if (paramd != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(r.b());
        localStringBuilder.append(":wxa_container");
        localStringBuilder.append(i);
        paramd.a(localStringBuilder.toString(), localClass);
      }
      j += 1;
      i += 1;
    }
  }
  
  public void a(@Nullable e parame)
  {
    super.a(parame);
    if (parame != null) {
      parame.a((com.tencent.luggage.wxa.hp.a)new com.tencent.luggage.wxa.df.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.app.b.a
 * JD-Core Version:    0.7.0.1
 */