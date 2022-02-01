package com.tencent.biz.qqstory.takevideo2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.View;

public class LayoutModifier$FactoryMerger
  implements LayoutInflater.Factory2
{
  private final LayoutInflater.Factory2 jdField_a_of_type_AndroidViewLayoutInflater$Factory2;
  private final LayoutInflater.Factory jdField_a_of_type_AndroidViewLayoutInflater$Factory;
  
  protected View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    LayoutModifier.Log.a("LayoutModifier", "onCreateViewPrivate " + paramString);
    return null;
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView2 = a(paramView, paramString, paramContext, paramAttributeSet);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = localView2;
      if (this.jdField_a_of_type_AndroidViewLayoutInflater$Factory2 != null) {
        localView1 = this.jdField_a_of_type_AndroidViewLayoutInflater$Factory2.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
      }
    }
    LayoutModifier.Log.a("LayoutModifier", "onCreateView " + localView1);
    return localView1;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView2 = a(null, paramString, paramContext, paramAttributeSet);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = localView2;
      if (this.jdField_a_of_type_AndroidViewLayoutInflater$Factory != null) {
        localView1 = this.jdField_a_of_type_AndroidViewLayoutInflater$Factory.onCreateView(paramString, paramContext, paramAttributeSet);
      }
    }
    LayoutModifier.Log.a("LayoutModifier", "onCreateView " + localView1);
    return localView1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo2.LayoutModifier.FactoryMerger
 * JD-Core Version:    0.7.0.1
 */