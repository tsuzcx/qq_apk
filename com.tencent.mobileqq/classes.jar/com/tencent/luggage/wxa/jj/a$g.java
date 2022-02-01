package com.tencent.luggage.wxa.jj;

import android.text.TextUtils;
import com.tencent.luggage.util.m;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class a$g
{
  private static final g h = new g();
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final boolean f;
  public final ArrayList<a.h> g = new ArrayList();
  
  private a$g()
  {
    this.a = "";
    this.b = "";
    this.c = "";
    this.d = "";
    this.e = "";
    this.f = false;
  }
  
  public a$g(JSONObject paramJSONObject, g paramg)
  {
    Object localObject = paramg;
    if (paramg == null) {
      localObject = h;
    }
    this.a = paramJSONObject.optString("position", ((g)localObject).a);
    this.b = paramJSONObject.optString("color", ((g)localObject).b);
    this.c = paramJSONObject.optString("selectedColor", ((g)localObject).c);
    this.d = paramJSONObject.optString("backgroundColor", ((g)localObject).d);
    this.e = paramJSONObject.optString("borderStyle", ((g)localObject).e);
    this.f = paramJSONObject.optBoolean("custom", ((g)localObject).f);
    this.g.addAll(((g)localObject).g);
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("list");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        paramg = a.a(paramJSONObject.getJSONObject(i));
        localObject = this.g.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (TextUtils.equals(((a.h)((Iterator)localObject).next()).a, paramg.a)) {
            ((Iterator)localObject).remove();
          }
        }
        this.g.add(paramg);
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      o.b("MicroMsg.AppBrandAppConfig", paramJSONObject.getMessage());
    }
  }
  
  public boolean a(String paramString)
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      if (((a.h)localIterator.next()).a.equals(m.b(paramString))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.a.g
 * JD-Core Version:    0.7.0.1
 */