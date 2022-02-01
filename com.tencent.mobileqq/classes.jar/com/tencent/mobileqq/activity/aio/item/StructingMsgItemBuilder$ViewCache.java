package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public class StructingMsgItemBuilder$ViewCache
{
  private static final String jdField_a_of_type_JavaLangString = "ViewCache";
  private StructingMsgItemBuilder.CacheMap jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$CacheMap;
  private StructingMsgItemBuilder.CacheMap b = new StructingMsgItemBuilder.CacheMap(null);
  
  public StructingMsgItemBuilder$ViewCache()
  {
    this.a = new StructingMsgItemBuilder.CacheMap(null);
  }
  
  private StructingMsgItemBuilder.ViewWrapper a(String paramString, ViewGroup paramViewGroup)
  {
    Iterator localIterator = this.b.get(paramString).iterator();
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
    this.b.remove(paramString);
    this.a.add(paramString);
    return paramString;
  }
  
  public View a(String paramString, ViewGroup paramViewGroup)
  {
    a(paramString, paramViewGroup);
    paramString = a(paramString, paramViewGroup);
    if (paramString != null) {
      return paramString.a();
    }
    return null;
  }
  
  public void a()
  {
    this.a.clear();
    this.b.clear();
  }
  
  public void a(String paramString, View paramView, ViewGroup paramViewGroup)
  {
    this.a.add(new StructingMsgItemBuilder.ViewWrapper(paramString, paramView, paramViewGroup));
  }
  
  public void a(String paramString, ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {
      return;
    }
    paramString = this.a.get(paramString).iterator();
    while (paramString.hasNext())
    {
      StructingMsgItemBuilder.ViewWrapper localViewWrapper = (StructingMsgItemBuilder.ViewWrapper)paramString.next();
      if ((localViewWrapper != null) && (localViewWrapper.a() != null) && (localViewWrapper.a() == paramViewGroup))
      {
        localViewWrapper.a().removeAllViews();
        this.a.remove(localViewWrapper);
        this.b.add(localViewWrapper);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.ViewCache
 * JD-Core Version:    0.7.0.1
 */