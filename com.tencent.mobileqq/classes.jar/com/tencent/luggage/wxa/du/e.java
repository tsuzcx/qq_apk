package com.tencent.luggage.wxa.du;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.dq.a.a;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.ny.f;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import java.util.Map;
import org.json.JSONObject;

public abstract class e<Service extends c>
  extends a.a<Service>
  implements f
{
  public e(Service paramService)
  {
    super(paramService);
  }
  
  public String A()
  {
    return ((c)y()).getAppId();
  }
  
  @Nullable
  public com.tencent.luggage.wxa.ed.d B()
  {
    if (y() == null) {
      return null;
    }
    return ((c)y()).i();
  }
  
  protected final void C()
  {
    ((c)y()).b();
  }
  
  protected void D() {}
  
  protected Map<String, m> E()
  {
    return null;
  }
  
  public <T> T a(Class<T> paramClass)
  {
    if (n.class.equals(paramClass)) {
      return paramClass.cast(((c)y()).A());
    }
    if (paramClass.isInstance(this)) {
      return paramClass.cast(this);
    }
    return super.a(paramClass);
  }
  
  protected abstract void a(com.tencent.luggage.wxa.iu.d paramd);
  
  public void a(@NonNull JSONObject paramJSONObject) {}
  
  public boolean a(int paramInt, String paramString)
  {
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  public void b(@NonNull JSONObject paramJSONObject) {}
  
  public String c(String paramString)
  {
    return null;
  }
  
  public abstract boolean d();
  
  protected i e()
  {
    return null;
  }
  
  protected void f() {}
  
  protected void g() {}
  
  protected void h() {}
  
  public void p() {}
  
  public void q() {}
  
  protected void u() {}
  
  protected abstract void v();
  
  protected abstract void w();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.du.e
 * JD-Core Version:    0.7.0.1
 */