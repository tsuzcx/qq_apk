package com.tencent.luggage.wxa.er;

import com.tencent.luggage.wxa.dd.b.a;
import com.tencent.luggage.wxa.dx.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appstorage.e.a;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/standalone_ext/impl/WxaMMKVStorageManager$ISOLATE_ID$2$1$1", "Lcom/tencent/luggage/login/account/IWxaAccountManager$IAccountCallback;", "onAccountLogin", "", "onAccountLogout", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class c$a$a
  implements b.a
{
  c$a$a(com.tencent.luggage.wxa.dd.e parame) {}
  
  public void a() {}
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reset isolated mmkv storage, id:");
    localStringBuilder.append(this.a);
    o.d("Luggage.WxaMMKVStorageManager", localStringBuilder.toString());
    com.tencent.mm.plugin.appbrand.appstorage.e.a.a((a)this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.er.c.a.a
 * JD-Core Version:    0.7.0.1
 */