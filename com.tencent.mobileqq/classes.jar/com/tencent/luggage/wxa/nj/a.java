package com.tencent.luggage.wxa.nj;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c.b;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.jx.e.a;
import com.tencent.luggage.wxa.jx.f.b;
import com.tencent.luggage.wxa.jx.f.c;
import com.tencent.luggage.wxa.jx.f.d;
import com.tencent.luggage.wxa.jx.j;
import com.tencent.luggage.wxa.jx.k;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.page.ab;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import java.util.Map;

public class a
  extends LinearLayout
  implements e
{
  @NonNull
  private u a;
  private LinearLayout b;
  private ab c;
  
  public a(Context paramContext, @NonNull u paramu)
  {
    super(paramContext);
    this.a = paramu;
    this.b = this;
  }
  
  @Nullable
  public <T extends com.tencent.luggage.wxa.ba.b> T a(Class<T> paramClass)
  {
    return this.a.a(paramClass);
  }
  
  public void a()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandKeyBoardComponentView", "destroy view containers");
    Object localObject = this.c;
    if (localObject != null)
    {
      ((ab)localObject).g();
      this.c = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((LinearLayout)localObject).removeAllViews();
      this.b = null;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.a.a(paramInt, paramString);
  }
  
  public void a(ah paramah)
  {
    this.a.a(paramah);
  }
  
  public void a(ah paramah, com.tencent.mm.plugin.appbrand.jsruntime.o paramo)
  {
    this.a.a(paramah, paramo);
  }
  
  public void a(ah paramah, int[] paramArrayOfInt)
  {
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandKeyBoardComponentView", "publish JsApiEvent event, int[] dst");
    this.a.a(paramah);
  }
  
  public void a(f.b paramb) {}
  
  public void a(f.c paramc) {}
  
  public void a(f.d paramd) {}
  
  public void a(Runnable paramRunnable)
  {
    this.a.a(paramRunnable);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandKeyBoardComponentView", "publish String event, String data, int[] dst");
    this.a.a(paramString1, paramString2);
  }
  
  public boolean a(@Nullable k paramk)
  {
    return false;
  }
  
  public <T extends j> T b(Class<T> paramClass)
  {
    return null;
  }
  
  public void b(f.b paramb) {}
  
  public void b(f.c paramc) {}
  
  public void b(f.d paramd) {}
  
  public e.a c(boolean paramBoolean)
  {
    if (paramBoolean) {
      return getGlobalCustomViewContainer();
    }
    return getCustomViewContainer();
  }
  
  @Nullable
  public <T extends k> T c(@NonNull Class<T> paramClass)
  {
    return null;
  }
  
  public boolean d()
  {
    return (getRuntime() != null) && (!getRuntime().au());
  }
  
  public boolean e()
  {
    return this.a.e();
  }
  
  public Map<String, m> g()
  {
    return null;
  }
  
  public String getAppId()
  {
    return this.a.getAppId();
  }
  
  public com.tencent.luggage.wxa.ix.b getAppState()
  {
    return null;
  }
  
  public Handler getAsyncHandler()
  {
    return null;
  }
  
  public int getComponentId()
  {
    return hashCode();
  }
  
  public View getContentView()
  {
    return this.b;
  }
  
  public ab getCustomViewContainer()
  {
    if (this.c != null)
    {
      com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandKeyBoardComponentView", "getCustomViewContainer, existed ViewContainer");
      return this.c;
    }
    if ((getContentView() instanceof ViewGroup))
    {
      this.c = new ab((ViewGroup)getContentView());
      com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandKeyBoardComponentView", "getCustomViewContainer, create customViewContainer");
      return this.c;
    }
    return null;
  }
  
  @Nullable
  public l getDialogContainer()
  {
    return null;
  }
  
  @Nullable
  public com.tencent.mm.plugin.appbrand.appstorage.o getFileSystem()
  {
    return null;
  }
  
  public e.a getGlobalCustomViewContainer()
  {
    if (getRuntime().aU() != null) {
      return getRuntime().aU();
    }
    return null;
  }
  
  public i getJsRuntime()
  {
    return null;
  }
  
  public FrameLayout getPageArea()
  {
    return null;
  }
  
  public d getRuntime()
  {
    return this.a.q();
  }
  
  public i h()
  {
    return null;
  }
  
  public void setInterceptor(c.b paramb) {}
  
  public boolean v()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nj.a
 * JD-Core Version:    0.7.0.1
 */