package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.ob.a;
import com.tencent.luggage.wxa.ob.a.a;
import com.tencent.luggage.wxa.qw.e;
import com.tencent.luggage.wxa.qw.ir;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/CgiExceptionWithAction;", "Lcom/tencent/mm/plugin/appbrand/networking/CgiException;", "errCode", "", "errMsg", "", "action", "Lcom/tencent/mm/protocal/protobuf/TransferAction;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/TransferAction;)V", "getAction", "()Lcom/tencent/mm/protocal/protobuf/TransferAction;", "Companion", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class d
  extends a
{
  @Deprecated
  public static final d.a a = new d.a(null);
  @NotNull
  private final ir e;
  
  public d(int paramInt, @Nullable String paramString, @NotNull ir paramir)
  {
    super(a.a.f, paramInt, paramString);
    this.e = paramir;
    if (this.e.a == 3)
    {
      if (this.e.d == null)
      {
        o.b("Luggage.WXA.CgiExceptionWithAction", "action.action_code == 3 but alert_msg_info is null");
        return;
      }
      paramString = new StringBuilder();
      paramString.append("action.action_code == 3, show alert{ ");
      paramString.append(this.e.d.a);
      paramString.append(' ');
      paramString.append(this.e.d.b);
      paramString.append(" }");
      o.d("Luggage.WXA.CgiExceptionWithAction", paramString.toString());
      paramString = l.a;
      paramir = this.e.d;
      Intrinsics.checkExpressionValueIsNotNull(paramir, "action.alert_msg_info");
      paramString.a(paramir);
    }
  }
  
  @NotNull
  public final ir a()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.d
 * JD-Core Version:    0.7.0.1
 */