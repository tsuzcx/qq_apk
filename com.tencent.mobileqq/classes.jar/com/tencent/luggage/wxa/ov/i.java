package com.tencent.luggage.wxa.ov;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.dz.a;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.page.m;
import org.json.JSONException;
import org.json.JSONObject;

class i
  implements e
{
  public void a(@NonNull com.tencent.luggage.wxa.ed.d paramd, @NonNull JSONObject paramJSONObject)
  {
    try
    {
      if ((d.a.b(paramd.j().G)) && (!TextUtils.isEmpty(paramd.j().v)))
      {
        paramJSONObject.put("debugLaunchInfo", new JSONObject(paramd.j().v));
        return;
      }
    }
    catch (JSONException paramd)
    {
      com.tencent.luggage.wxa.qz.o.b("Luggage.PVReportFieldsHelperForCommLib", "fillDebugLaunchInfo ex = %s", new Object[] { paramd });
    }
  }
  
  public void a(@NonNull com.tencent.luggage.wxa.ed.d paramd, @NonNull JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(paramd, paramJSONObject);
      a(paramd, paramJSONObject);
      return;
    }
    try
    {
      d(paramd, paramJSONObject);
      a(paramd, paramJSONObject);
      Object localObject = paramd.k().getReporter().a().b().d;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((h.b)localObject).a;
      }
      paramJSONObject.put("referpagepath", localObject);
      paramJSONObject.put("clickTimestamp", paramd.j().l);
      return;
    }
    catch (Exception paramd)
    {
      com.tencent.luggage.wxa.qz.o.b("Luggage.PVReportFieldsHelperForCommLib", "fillEventOnAppEnterForeground ex = %s", new Object[] { paramd });
    }
  }
  
  public void a(@NonNull com.tencent.luggage.wxa.iu.d paramd, @NonNull JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = com.tencent.luggage.wxa.ou.f.a((com.tencent.luggage.wxa.dq.c)paramd.C().getCurrentPage().getCurrentPageView());
      int i = ((Integer)((Pair)localObject).first).intValue();
      localObject = (String)((Pair)localObject).second;
      paramJSONObject.put("targetAction", i);
      paramJSONObject.put("targetPagePath", localObject);
      paramJSONObject.put("usedState", ((com.tencent.luggage.wxa.ed.d)paramd).l().e);
      return;
    }
    catch (Exception paramd)
    {
      com.tencent.luggage.wxa.qz.o.b("Luggage.PVReportFieldsHelperForCommLib", "fillEventOnAppEnterBackground ex = %s", new Object[] { paramd });
    }
  }
  
  public void b(@NonNull com.tencent.luggage.wxa.ed.d paramd, @NonNull JSONObject paramJSONObject)
  {
    try
    {
      d(paramd, paramJSONObject);
      paramJSONObject.put("referpagepath", com.tencent.luggage.wxa.ou.f.a(paramd.j().h));
      paramJSONObject.put("clickTimestamp", paramd.j().l);
      return;
    }
    catch (Exception paramd)
    {
      com.tencent.luggage.wxa.qz.o.b("Luggage.PVReportFieldsHelperForCommLib", "fillWxConfigLaunchInfo ex = %s", new Object[] { paramd });
    }
  }
  
  public void c(@NonNull com.tencent.luggage.wxa.ed.d paramd, @NonNull JSONObject paramJSONObject)
  {
    try
    {
      paramd = paramd.j().j;
      if (!TextUtils.isEmpty(paramd))
      {
        paramJSONObject.put("nativeExtraData", new JSONObject(paramd));
        return;
      }
    }
    catch (JSONException paramd)
    {
      com.tencent.luggage.wxa.qz.o.a("Luggage.PVReportFieldsHelperForCommLib", paramd, "fillWithHostNativeExtraData", new Object[0]);
    }
  }
  
  public void d(@NonNull com.tencent.luggage.wxa.ed.d paramd, @NonNull JSONObject paramJSONObject)
  {
    paramJSONObject.put("scene", paramd.l().c);
    paramJSONObject.put("scene_note", paramd.l().d);
    paramJSONObject.put("sessionId", paramd.j().h());
    paramJSONObject.put("usedState", paramd.l().e);
    paramJSONObject.put("prescene", paramd.l().a);
    paramJSONObject.put("prescene_note", paramd.l().b);
    paramJSONObject.put("mode", "default");
    String str = paramd.j().e;
    if (!TextUtils.isEmpty(str)) {
      paramJSONObject.put("shortLink", str);
    }
    int i;
    if (d.a.b(paramd.j().G)) {
      i = 0;
    } else {
      i = paramd.j().n;
    }
    paramJSONObject.put("appversion", i);
    try
    {
      paramd = paramd.j().j();
      if (paramd != null) {
        paramJSONObject.put("shareInfo", paramd);
      }
      return;
    }
    catch (JSONException paramd) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ov.i
 * JD-Core Version:    0.7.0.1
 */