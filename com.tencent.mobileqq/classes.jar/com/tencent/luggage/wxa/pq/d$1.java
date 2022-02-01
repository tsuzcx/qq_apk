package com.tencent.luggage.wxa.pq;

import android.widget.EditText;
import com.tencent.luggage.wxa.jx.n;
import com.tencent.luggage.wxa.pp.ac;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;
import java.util.HashMap;

final class d$1
  implements i
{
  d$1(WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public void a(String paramString, i.a parama)
  {
    Object localObject = (EditText)this.a.get();
    u localu = (u)this.b.get();
    if (localObject != null)
    {
      if (localu == null) {
        return;
      }
      int i = ((ac)localObject).getInputId();
      localObject = new d.a();
      HashMap localHashMap = new HashMap();
      localHashMap.put("id", paramString);
      localHashMap.put("type", parama.name().toLowerCase());
      localHashMap.put("inputId", Integer.valueOf(i));
      ((d.a)localObject).a(localu).a(localHashMap).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pq.d.1
 * JD-Core Version:    0.7.0.1
 */