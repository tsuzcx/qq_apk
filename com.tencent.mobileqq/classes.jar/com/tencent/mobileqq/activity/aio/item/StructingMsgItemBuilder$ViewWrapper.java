package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.SoftReference;

class StructingMsgItemBuilder$ViewWrapper
{
  String a;
  SoftReference<View> b;
  SoftReference<ViewGroup> c;
  
  public StructingMsgItemBuilder$ViewWrapper(String paramString, View paramView, ViewGroup paramViewGroup)
  {
    this.a = paramString;
    this.b = new SoftReference(paramView);
    this.c = new SoftReference(paramViewGroup);
  }
  
  public View a()
  {
    return (View)this.b.get();
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.c = new SoftReference(paramViewGroup);
  }
  
  public ViewGroup b()
  {
    return (ViewGroup)this.c.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.ViewWrapper
 * JD-Core Version:    0.7.0.1
 */