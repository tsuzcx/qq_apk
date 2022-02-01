package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.kb.c.b;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.es;
import com.tencent.luggage.wxa.qw.et;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONStringer;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiGetAllPhone;", "", "appId", "", "apiName", "withCredentials", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getApiName", "()Ljava/lang/String;", "getAppId", "getWithCredentials", "()Z", "jsonStringer", "run", "", "callback", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "isSucces", "errMsg", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "phoneItems", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "info", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class d
{
  @NotNull
  private final String a;
  @NotNull
  private final String b;
  private final boolean c;
  
  public d(@NotNull String paramString1, @NotNull String paramString2, boolean paramBoolean)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramBoolean;
  }
  
  private final String a(String paramString, boolean paramBoolean)
  {
    JSONStringer localJSONStringer = new JSONStringer();
    try
    {
      localJSONStringer.object();
      localJSONStringer.key("api_name");
      localJSONStringer.value(paramString);
      localJSONStringer.key("with_credentials");
      localJSONStringer.value(paramBoolean);
      localJSONStringer.endObject();
    }
    catch (JSONException paramString)
    {
      o.a("MicroMsg.JsApiGetPhoneNumberNew", (Throwable)paramString, "", new Object[0]);
    }
    paramString = localJSONStringer.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "jsonStringer.toString()");
    return paramString;
  }
  
  public final void a(@Nullable Function4<? super Boolean, ? super String, ? super List<r>, ? super c.b, Unit> paramFunction4)
  {
    Object localObject = a(this.b, this.c);
    es locales = new es();
    locales.a = this.a;
    Charset localCharset = Charsets.UTF_8;
    if (localObject != null)
    {
      localObject = ((String)localObject).getBytes(localCharset);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.String).getBytes(charset)");
      locales.b = new com.tencent.luggage.wxa.qu.b((byte[])localObject);
      ((com.tencent.luggage.wxa.ob.b)e.a(com.tencent.luggage.wxa.ob.b.class)).b("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", this.a, (a)locales, et.class).a((com.tencent.luggage.wxa.rl.b)new d.a(paramFunction4)).a((e.a)new d.b(paramFunction4));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.d
 * JD-Core Version:    0.7.0.1
 */