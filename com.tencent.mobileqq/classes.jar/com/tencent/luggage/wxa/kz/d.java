package com.tencent.luggage.wxa.kz;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.af;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Locale;
import org.json.JSONObject;

public final class d
  extends com.tencent.luggage.wxa.jx.a<h>
{
  private static final int CTRL_INDEX = 120;
  private static final String NAME = "getImageInfo";
  private static final Collection<d.b> a;
  
  static
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new d.a(null));
    localLinkedList.add(new d.d(null));
    a = Collections.unmodifiableCollection(localLinkedList);
  }
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    paramh.getAppId();
    paramJSONObject = paramJSONObject.optString("src");
    if (af.c(paramJSONObject))
    {
      paramh.a(paramInt, b("fail:invalid data"));
      return;
    }
    com.tencent.luggage.wxa.rd.a.a(new d.1(this, paramh, paramJSONObject, new WeakReference(paramh), paramInt), String.format(Locale.US, "AppBrandJsApiGetImageInfo[%s]", new Object[] { paramJSONObject }), 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kz.d
 * JD-Core Version:    0.7.0.1
 */