package com.tencent.luggage.wxa.ka;

import androidx.annotation.CallSuper;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.qw.hn;
import com.tencent.mm.plugin.appbrand.widget.dialog.c.c;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public abstract class g
  extends a<com.tencent.luggage.wxa.iu.b>
{
  protected static LinkedList<c.c> a(LinkedList<hn> paramLinkedList)
  {
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      hn localhn = (hn)paramLinkedList.next();
      c.c localc = new c.c();
      localc.a = localhn.a;
      localc.c = localhn.b;
      localc.b = localhn.c;
      localLinkedList.add(localc);
    }
    return localLinkedList;
  }
  
  @CallSuper
  public void a(com.tencent.luggage.wxa.iu.b paramb, JSONObject paramJSONObject, int paramInt)
  {
    boolean bool = paramJSONObject.optBoolean("requestInQueue", true);
    if ("adOperateWXData".equalsIgnoreCase(d()))
    {
      a(paramb, paramJSONObject, paramInt, null);
      return;
    }
    if (!bool)
    {
      b.a(paramb.q()).a(this, paramb, paramJSONObject, paramInt);
      return;
    }
    d.a(paramb.q()).a(this, paramb, paramJSONObject, paramInt);
  }
  
  protected abstract void a(com.tencent.luggage.wxa.iu.b paramb, JSONObject paramJSONObject, int paramInt, e parame);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.g
 * JD-Core Version:    0.7.0.1
 */