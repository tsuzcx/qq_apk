package com.tencent.luggage.wxa.oq;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient.CustomViewCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a
  implements d
{
  protected c a;
  protected View b;
  protected boolean c = false;
  private final d.b d = new a.1(this);
  private d.b e;
  private View f;
  private WebChromeClient.CustomViewCallback g;
  private int h;
  private ViewGroup.LayoutParams i;
  private ViewGroup j;
  private final Set<b> k = Collections.newSetFromMap(new ConcurrentHashMap());
  
  public a(@NonNull c paramc, @Nullable d.b paramb)
  {
    this.e = paramb;
    this.a = paramc;
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void a(@NonNull View paramView, int paramInt)
  {
    this.c = true;
    d.b localb = this.e;
    Object localObject = localb;
    if (localb == null) {
      localObject = this.d;
    }
    this.b = this.f;
    this.f = paramView;
    if (this.b == null)
    {
      if ((paramView.getParent() instanceof ViewGroup))
      {
        this.j = ((ViewGroup)paramView.getParent());
        this.h = this.j.indexOfChild(paramView);
        this.i = paramView.getLayoutParams();
        this.j.removeView(paramView);
      }
      else
      {
        this.h = 0;
        this.j = null;
        this.i = null;
      }
      localObject = ((d.b)localObject).a(paramView);
      ((ViewGroup)localObject).addView(paramView, new ViewGroup.LayoutParams(-1, -1));
      ((ViewGroup)localObject).bringChildToFront(paramView);
      paramView.setX(0.0F);
      paramView.setY(0.0F);
    }
  }
  
  public void a(WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.g = paramCustomViewCallback;
  }
  
  public void a(b paramb)
  {
    if (paramb == null) {
      return;
    }
    this.k.add(paramb);
  }
  
  public void b()
  {
    c();
    this.k.clear();
    this.g = null;
  }
  
  public void b(b paramb)
  {
    if (paramb == null) {
      return;
    }
    this.k.remove(paramb);
  }
  
  public boolean c()
  {
    if (this.f == null) {
      return false;
    }
    Object localObject = this.g;
    if (localObject != null) {
      ((WebChromeClient.CustomViewCallback)localObject).onCustomViewHidden();
    }
    if ((this.f.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.f.getParent()).removeView(this.f);
    }
    localObject = this.j;
    if (localObject != null) {
      ((ViewGroup)localObject).addView(this.f, this.h, this.i);
    }
    this.f = null;
    this.g = null;
    this.c = false;
    return true;
  }
  
  public final boolean d()
  {
    return this.c;
  }
  
  protected void e()
  {
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).d();
    }
  }
  
  protected void f()
  {
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oq.a
 * JD-Core Version:    0.7.0.1
 */