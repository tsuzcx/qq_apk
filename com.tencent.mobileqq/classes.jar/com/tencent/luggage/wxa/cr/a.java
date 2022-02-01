package com.tencent.luggage.wxa.cr;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.qw.ag;
import com.tencent.luggage.wxa.qw.no;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.q;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

public class a
  extends com.tencent.luggage.wxa.jx.a<com.tencent.luggage.wxa.dq.c>
{
  public static final int CTRL_INDEX = 66;
  public static final String NAME = "reportSubmitForm";
  
  private com.tencent.luggage.wxa.ro.d<ag> a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3)
  {
    com.tencent.luggage.wxa.qw.af localaf = new com.tencent.luggage.wxa.qw.af();
    localaf.a = new LinkedList();
    no localno = new no();
    localno.a = paramInt1;
    localno.b = paramString1;
    localno.c = paramString2;
    localno.d = paramString3;
    localno.e = paramInt2;
    localno.f = paramInt3;
    localaf.a.add(localno);
    return ((b)e.a(b.class)).b("/cgi-bin/mmbiz-bin/wxausrevent/batchrecordwxatemplatemsgevent", paramString1, localaf, ag.class);
  }
  
  private static String a(com.tencent.luggage.wxa.dq.c paramc)
  {
    String str = paramc.getAppId();
    paramc = paramc.f().j().a.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(System.currentTimeMillis());
    return q.a(StringUtils.join(new String[] { str, paramc, localStringBuilder.toString() }, '#'));
  }
  
  public void a(com.tencent.luggage.wxa.dq.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = a(paramc);
    Object localObject = paramc.ao();
    com.tencent.luggage.wxa.do.d locald = paramc.f().i();
    String str = locald.J;
    int i = locald.c();
    int j = locald.S.pkgVersion;
    o.d("MicroMsg.JsApiReportSubmitForm", "reportSubmitForm formId:%s", new Object[] { paramJSONObject });
    a(1, str, paramJSONObject, (String)localObject, i, j).a(new a.2(this)).a(com.tencent.luggage.wxa.rp.d.b, new a.1(this));
    localObject = new HashMap();
    ((HashMap)localObject).put("formId", paramJSONObject);
    paramc.a(paramInt, a("ok", (Map)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cr.a
 * JD-Core Version:    0.7.0.1
 */