package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.SoftReference;

class StructingMsgItemBuilder$ViewWrapper
{
  String jdField_a_of_type_JavaLangString;
  SoftReference<View> jdField_a_of_type_JavaLangRefSoftReference;
  SoftReference<ViewGroup> b;
  
  public StructingMsgItemBuilder$ViewWrapper(String paramString, View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramView);
    this.b = new SoftReference(paramViewGroup);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefSoftReference.get();
  }
  
  public ViewGroup a()
  {
    return (ViewGroup)this.b.get();
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.b = new SoftReference(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.ViewWrapper
 * JD-Core Version:    0.7.0.1
 */