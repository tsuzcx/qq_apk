package com.tencent.biz.pubaccount.weishi_new.baseui;

import android.content.Context;
import android.support.annotation.IdRes;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.controller.AbsWSDramaUIGroup;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class AbsWSItemView<T>
  implements IWSItemView<T>
{
  protected View a;
  protected Context b;
  public T c;
  private final Map<String, AbsWsUIGroup<T>> d = new HashMap();
  
  public AbsWSItemView(Context paramContext, View paramView)
  {
    this.b = paramContext;
    this.a = paramView;
    b();
  }
  
  public void a()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsWsUIGroup)((Map.Entry)((Iterator)localObject).next()).getValue()).g();
      }
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsWsUIGroup)((Map.Entry)((Iterator)localObject).next()).getValue()).b(paramInt);
      }
    }
  }
  
  protected void a(@IdRes int paramInt, AbsWsUIGroup<T> paramAbsWsUIGroup)
  {
    paramAbsWsUIGroup.a((ViewStub)this.a.findViewById(paramInt));
    this.d.put(String.valueOf(paramAbsWsUIGroup.hashCode()), paramAbsWsUIGroup);
  }
  
  public void a(T paramT)
  {
    this.c = paramT;
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsWsUIGroup)((Map.Entry)((Iterator)localObject).next()).getValue()).a(paramT);
      }
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        AbsWsUIGroup localAbsWsUIGroup = (AbsWsUIGroup)((Map.Entry)((Iterator)localObject).next()).getValue();
        if ((localAbsWsUIGroup instanceof AbsWSDramaUIGroup)) {
          ((AbsWSDramaUIGroup)localAbsWsUIGroup).d(paramInt);
        }
      }
    }
  }
  
  public void c(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.baseui.AbsWSItemView
 * JD-Core Version:    0.7.0.1
 */