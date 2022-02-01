package com.tencent.biz.qqstory.comment.lego;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class LegoBase<T>
{
  private static int a;
  private LegoBase b;
  private HashMap<String, LegoBase> c = new HashMap();
  private List<T> d;
  private boolean e = false;
  public Context p;
  public View q;
  protected LegoDataProvider r;
  protected LegoEvenHandler s;
  
  public LegoBase(Context paramContext, int paramInt)
  {
    this.q = LayoutInflater.from(paramContext).inflate(paramInt, null, true);
    this.p = paramContext;
  }
  
  public LegoBase(Context paramContext, View paramView)
  {
    this.q = paramView;
    this.p = paramContext;
  }
  
  public abstract LegoEvenHandler a();
  
  public abstract void a(Context paramContext, View paramView);
  
  public void a(LegoEvenHandler paramLegoEvenHandler)
  {
    this.s = paramLegoEvenHandler;
  }
  
  public void a(String paramString, LegoBase paramLegoBase)
  {
    paramLegoBase.b = this;
    this.c.put(paramString, paramLegoBase);
  }
  
  public abstract void a(List<T> paramList);
  
  public LegoBase b(String paramString)
  {
    return (LegoBase)this.c.get(paramString);
  }
  
  public abstract LegoDataProvider b();
  
  public void b(List<T> paramList)
  {
    this.d = paramList;
  }
  
  public void c()
  {
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((LegoBase)this.c.get(str)).c();
    }
  }
  
  public void c(List<T> paramList)
  {
    if (!this.e) {
      return;
    }
    View localView = this.q;
    if (localView != null) {
      localView.setVisibility(0);
    }
    this.d = paramList;
    a(paramList);
  }
  
  public abstract void d();
  
  public void l()
  {
    View localView = this.q;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public LegoBase m()
  {
    return this.b;
  }
  
  public boolean n()
  {
    return this.e;
  }
  
  public void o()
  {
    if (this.e) {
      return;
    }
    this.e = true;
    Object localObject = this.q;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    if (this.s == null) {
      this.s = a();
    }
    if (this.r == null) {
      this.r = b();
    }
    a(this.p, this.q);
    d();
    localObject = this.d;
    if (localObject != null)
    {
      a((List)localObject);
    }
    else
    {
      localObject = this.r;
      if (localObject != null) {
        ((LegoDataProvider)localObject).a();
      } else {
        a(null);
      }
    }
    localObject = this.c.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      ((LegoBase)this.c.get(str)).o();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.lego.LegoBase
 * JD-Core Version:    0.7.0.1
 */