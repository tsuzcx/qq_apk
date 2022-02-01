package c.t.m.sapp.c;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class i
  implements Runnable
{
  public Context a;
  public List<a> b = null;
  public boolean c = false;
  public List<a> d = null;
  public c e = null;
  public boolean f = false;
  
  public i(Context paramContext, List<a> paramList, boolean paramBoolean)
  {
    this.a = paramContext;
    this.f = paramBoolean;
    this.b = new ArrayList();
    this.b.addAll(paramList);
    this.e = new c(this.a);
  }
  
  public final String a()
  {
    Object localObject1 = new JSONObject();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.a.getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append(q.b);
    localObject2 = ((StringBuilder)localObject2).toString();
    try
    {
      localObject3 = q.l(this.a);
      ((JSONObject)localObject1).put("appkey", localObject3);
      ((JSONObject)localObject1).put("appversion", q.c(this.a));
      ((JSONObject)localObject1).put("imei", q.h(this.a));
      ((JSONObject)localObject1).put("coverSDKver", h.a);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(q.e());
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append(q.f());
      ((JSONObject)localObject1).put("model", ((StringBuilder)localObject3).toString());
      ((JSONObject)localObject1).put("APILevel", q.b());
      localObject3 = new JSONArray();
      if (this.b != null)
      {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          Object localObject4 = (a)localIterator.next();
          if (localObject4 != null)
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("compId", ((a)localObject4).a);
            localJSONObject.put("compVer", ((a)localObject4).b);
            localJSONObject.put("size", ((a)localObject4).d);
            localObject4 = q.a(new File((String)localObject2, ((a)localObject4).c));
            localJSONObject.put("md5", localObject4);
            ((JSONArray)localObject3).put(localJSONObject);
          }
        }
      }
      ((JSONObject)localObject1).put("compList", localObject3);
      localObject1 = ((JSONObject)localObject1).toString();
      localObject2 = e.a(this.a);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("req:");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((e)localObject2).a("DRG", ((StringBuilder)localObject3).toString());
      localObject1 = m.b((String)localObject1, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q");
      return localObject1;
    }
    catch (Exception localException)
    {
      localObject2 = e.a(this.a);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("reqDerror:");
      ((StringBuilder)localObject3).append(localException.toString());
      ((e)localObject2).a("DRG", ((StringBuilder)localObject3).toString());
    }
    return null;
  }
  
  public final boolean a(String paramString)
  {
    paramString = q.d(m.a(paramString, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q"));
    if (paramString == null) {
      return false;
    }
    this.d = q.e(paramString);
    Object localObject = q.e(q.a(this.a, "__bad_dex_info___sapp", "preference_default_sapp"));
    boolean bool1;
    if (!((List)localObject).isEmpty()) {
      bool1 = l.a((List)localObject, this.d);
    } else {
      bool1 = false;
    }
    boolean bool3 = a(this.b, this.d);
    localObject = q.e(q.a(this.a, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "preference_default_sapp"));
    boolean bool2;
    if (!((List)localObject).isEmpty()) {
      bool2 = l.a((List)localObject, this.d);
    } else {
      bool2 = false;
    }
    localObject = e.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("need and samebad:");
    localStringBuilder.append(bool3);
    localStringBuilder.append(",");
    localStringBuilder.append(bool1);
    ((e)localObject).a("DRG", localStringBuilder.toString());
    if ((!bool3) && (!bool1) && (!bool2))
    {
      localObject = e.a(this.a);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("to download:");
      localStringBuilder.append(paramString);
      ((e)localObject).a("DRG", localStringBuilder.toString());
      this.e.b(this.d);
      return true;
    }
    return false;
  }
  
  public final boolean a(List<a> paramList1, List<a> paramList2)
  {
    paramList1 = paramList1.iterator();
    boolean bool = true;
    while (paramList1.hasNext())
    {
      a locala1 = (a)paramList1.next();
      Iterator localIterator = paramList2.iterator();
      while (localIterator.hasNext())
      {
        a locala2 = (a)localIterator.next();
        if (!locala2.c.contains(".dex"))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(locala2.c);
          localStringBuilder.append(".dex");
          locala2.c = localStringBuilder.toString();
        }
        if ((locala1.c.equals(locala2.c)) && (locala1.d == locala2.d) && (locala1.e.equals(locala2.e)))
        {
          i = 1;
          break label163;
        }
      }
      int i = 0;
      label163:
      if (i == 0) {
        bool = false;
      }
    }
    return bool;
  }
  
  public final boolean b()
  {
    long l = q.a(this.a, "__last_check_update_time___sapp", Long.valueOf(0L)).longValue();
    return System.currentTimeMillis() - l > 3600000L;
  }
  
  public final boolean c()
  {
    Object localObject1 = a();
    if (localObject1 == null) {
      return false;
    }
    localObject1 = ((String)localObject1).getBytes();
    if (localObject1 != null)
    {
      new HashMap();
      int j;
      for (int i = 0;; i = j)
      {
        j = i + 1;
        if (i >= 3) {
          break;
        }
        Object localObject2 = p.a("https://cc.map.qq.com?desc_c", (byte[])localObject1);
        if (localObject2 != null)
        {
          localObject1 = new String((byte[])localObject2);
          localObject2 = e.a(this.a);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("response suc,try:");
          localStringBuilder.append(j);
          ((e)localObject2).a("DRG", localStringBuilder.toString());
          return a((String)localObject1);
        }
        q.a(10000L);
      }
    }
    return false;
  }
  
  public void run()
  {
    boolean bool = b();
    e locale = e.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("t:");
    localStringBuilder.append(bool);
    localStringBuilder.append(",i:");
    localStringBuilder.append(this.f);
    locale.a("DRG", localStringBuilder.toString());
    if (!bool) {
      bool = this.f;
    }
    c();
    q.b(this.a, "__last_check_update_time___sapp", Long.valueOf(System.currentTimeMillis()));
    e.a(this.a).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.sapp.c.i
 * JD-Core Version:    0.7.0.1
 */