package com.tencent.luggage.wxa.fv;

import com.tencent.ilinkservice.ac;
import com.tencent.ilinkservice.ao;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxaapi/internal/tdi/DemoILinkActivateDevice$ilinkServiceCallback$1", "Lcom/tencent/ilinkservice/IlinkServiceCallback;", "onAllResourceNeedRecreate", "", "onCloneMultiProcessTdiSession", "p0", "", "p1", "", "p2", "Lcom/tencent/ilinkservice/IlinkTdiCloneSessionInterface;", "onDeviceInfoNotMatch", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a$c
  implements ac
{
  public void a()
  {
    o.d("DemoILinkActivateDevice", "ilinkServiceCallback.onAllResourceNeedRecreate()");
    a.c(a.c);
  }
  
  public void a(int paramInt, @Nullable String paramString, @Nullable ao paramao)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ilinkServiceCallback.onCloneMultiProcessTdiSession(");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramao);
    localStringBuilder.append(')');
    o.d("DemoILinkActivateDevice", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fv.a.c
 * JD-Core Version:    0.7.0.1
 */