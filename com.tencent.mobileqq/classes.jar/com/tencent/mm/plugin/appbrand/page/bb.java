package com.tencent.mm.plugin.appbrand.page;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.tencent.luggage.wxa.ef.d;
import com.tencent.luggage.wxa.oi.e;
import com.tencent.luggage.wxa.pc.l;
import com.tencent.luggage.wxa.qz.o;
import java.net.URL;
import java.util.LinkedList;
import java.util.Map;

public final class bb
  extends af
  implements ba
{
  private u a;
  private ba.a b;
  private final aa c = new bb.1(this, null);
  private volatile boolean d = false;
  private boolean e = false;
  private final LinkedList<Runnable> f = new LinkedList();
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private String k = null;
  private long l = 0L;
  
  bb(@NonNull am paramam)
  {
    super(paramam);
    ((an)paramam).setAppBrandWebViewClient(this.c);
    l();
  }
  
  private void a(boolean paramBoolean)
  {
    if (!this.e)
    {
      this.l = com.tencent.luggage.wxa.qz.af.b();
      this.b.b(paramBoolean);
      this.e = true;
      if (paramBoolean) {
        this.g = true;
      }
    }
  }
  
  private void c(@NonNull Runnable paramRunnable)
  {
    if (this.d)
    {
      m();
      paramRunnable.run();
      return;
    }
    this.f.addLast(paramRunnable);
  }
  
  private void l()
  {
    if (b().a(e.class) != null) {
      return;
    }
    b().setOnTrimListener(new bb.2(this));
  }
  
  @UiThread
  private void m()
  {
    LinkedList localLinkedList = new LinkedList(this.f);
    this.f.clear();
    o.d("Luggage.MPWebViewRenderEngineLegacyImpl", "executeDeferredEvaluations %s size %d, hash[%d]", new Object[] { this.k, Integer.valueOf(localLinkedList.size()), Integer.valueOf(hashCode()) });
    d.a("executeDeferredEvaluations", new bb.3(this, localLinkedList));
  }
  
  @UiThread
  private void n()
  {
    this.f.clear();
  }
  
  private void o()
  {
    o.d("Luggage.MPWebViewRenderEngineLegacyImpl", "[wxa_reload]dispatchTrimmed %s", new Object[] { this.k });
    this.j = true;
    this.d = false;
    this.e = false;
    this.g = false;
    this.h = false;
    b().setOnTrimListener(null);
    n();
  }
  
  @UiThread
  public void a(@NonNull ba.a parama)
  {
    this.a = parama.d();
    this.b = parama;
    this.c.a(this.a);
    n();
  }
  
  @UiThread
  public void a(@NonNull String paramString, @Nullable ValueCallback<String> paramValueCallback)
  {
    if (this.d)
    {
      b().evaluateJavascript(paramString, paramValueCallback);
      return;
    }
    this.f.addLast(new bb.5(this, paramString, paramValueCallback));
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!this.i))
    {
      l.a(new bb.4(this, paramURL, paramString, paramValueCallback));
      return;
    }
    if (paramValueCallback != null) {
      paramValueCallback.onReceiveValue("FATAL");
    }
  }
  
  public boolean a()
  {
    if (!this.j) {
      return false;
    }
    this.e = false;
    this.d = false;
    j();
    c(new bb.8(this));
    return true;
  }
  
  @UiThread
  public void b(@NonNull Runnable paramRunnable)
  {
    if (this.d)
    {
      m();
      paramRunnable.run();
      return;
    }
    this.f.addLast(paramRunnable);
  }
  
  public void destroy()
  {
    this.i = true;
    super.destroy();
    n();
  }
  
  public void e()
  {
    super.e();
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    a(null, paramString, paramValueCallback);
  }
  
  public void f()
  {
    super.f();
    a();
  }
  
  public boolean h()
  {
    return this.h;
  }
  
  public void i()
  {
    o.d("Luggage.MPWebViewRenderEngineLegacyImpl", "dispatchPreload");
    a(true);
    c(new bb.6(this));
  }
  
  public void j()
  {
    this.j = false;
    this.g = false;
    aa localaa = this.c;
    String str = this.b.c();
    this.k = str;
    localaa.a(str);
    l();
    o.d("Luggage.MPWebViewRenderEngineLegacyImpl", "dispatchInit %s, mPageFrameReady %b, mPageFrameLoaded %b", new Object[] { this.k, Boolean.valueOf(this.d), Boolean.valueOf(this.e) });
    a(false);
    c(new bb.7(this));
  }
  
  public boolean k()
  {
    return this.d;
  }
  
  public void setAppBrandInfo(Map<String, String> paramMap)
  {
    b().setAppBrandInfo(paramMap);
  }
  
  public void setOnTrimListener(ad paramad)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean z_()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bb
 * JD-Core Version:    0.7.0.1
 */