package com.tencent.luggage.wxa.ka;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.qz.o;
import java.util.Map;
import org.json.JSONObject;

class d
  extends com.tencent.luggage.wxa.pd.e<d.a>
  implements c, e
{
  private static final Map<String, d> a = new ArrayMap();
  private static final d b = new d.1(null);
  
  private d(com.tencent.luggage.wxa.iu.d paramd)
  {
    super(localStringBuilder.toString(), Looper.getMainLooper());
    if (paramd == null) {
      return;
    }
    paramd.al().a(new d.2(this));
  }
  
  @NonNull
  public static d a(com.tencent.luggage.wxa.iu.d paramd)
  {
    if ((paramd != null) && (!paramd.au())) {
      synchronized (a)
      {
        d locald2 = (d)a.get(paramd.aa());
        d locald1 = locald2;
        if (locald2 == null)
        {
          locald1 = new d(paramd);
          a.put(paramd.aa(), locald1);
        }
        return locald1;
      }
    }
    return b;
  }
  
  public void a()
  {
    d();
  }
  
  public void a(@NonNull g paramg, @NonNull b paramb, @NonNull JSONObject paramJSONObject, int paramInt)
  {
    o.d("MicroMsg.AppBrandAuthJsApiQueue", "execute name[%s], callbackId[%d], appId[%s]", new Object[] { paramg.d(), Integer.valueOf(paramInt), paramb.getAppId() });
    super.c(new d.3(this, paramb, paramg, this, paramJSONObject, paramInt));
  }
  
  protected boolean a(d.a parama)
  {
    return false;
  }
  
  protected void b(d.a parama)
  {
    o.e(q(), "about to executeTask %s", new Object[] { parama.toString() });
    parama.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.d
 * JD-Core Version:    0.7.0.1
 */