package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public class StructingMsgItemBuilder$ViewCache
{
  private static final String a = "ViewCache";
  private StructingMsgItemBuilder.CacheMap b = new StructingMsgItemBuilder.CacheMap(null);
  private StructingMsgItemBuilder.CacheMap c = new StructingMsgItemBuilder.CacheMap(null);
  
  private StructingMsgItemBuilder.ViewWrapper c(String paramString, ViewGroup paramViewGroup)
  {
    Iterator localIterator = this.c.get(paramString).iterator();
    while (localIterator.hasNext())
    {
      paramString = (StructingMsgItemBuilder.ViewWrapper)localIterator.next();
      if (paramString != null)
      {
        paramString.a(paramViewGroup);
        break label45;
      }
    }
    paramString = null;
    label45:
    this.c.remove(paramString);
    this.b.add(paramString);
    return paramString;
  }
  
  public void a()
  {
    this.b.clear();
    this.c.clear();
  }
  
  public void a(String paramString, View paramView, ViewGroup paramViewGroup)
  {
    this.b.add(new StructingMsgItemBuilder.ViewWrapper(paramString, paramView, paramViewGroup));
  }
  
  public void a(String paramString, ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {
      return;
    }
    paramString = this.b.get(paramString).iterator();
    while (paramString.hasNext())
    {
      StructingMsgItemBuilder.ViewWrapper localViewWrapper = (StructingMsgItemBuilder.ViewWrapper)paramString.next();
      if ((localViewWrapper != null) && (localViewWrapper.b() != null) && (localViewWrapper.b() == paramViewGroup))
      {
        localViewWrapper.b().removeAllViews();
        this.b.remove(localViewWrapper);
        this.c.add(localViewWrapper);
      }
    }
  }
  
  public View b(String paramString, ViewGroup paramViewGroup)
  {
    a(paramString, paramViewGroup);
    paramString = c(paramString, paramViewGroup);
    if (paramString != null) {
      return paramString.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.ViewCache
 * JD-Core Version:    0.7.0.1
 */