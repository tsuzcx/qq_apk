package com.tencent.biz.subscribe.component.extendsadapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import java.util.ArrayList;
import wcd;
import wcf;
import wch;

public class ComponentRvInnerView
  extends RecyclerViewCompat
{
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private wcf jdField_a_of_type_Wcf;
  private wch jdField_a_of_type_Wch;
  
  public ComponentRvInnerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentRvInnerView(Context paramContext, wcf paramwcf)
  {
    super(paramContext);
    this.jdField_a_of_type_Wcf = paramwcf;
    setDescendantFocusability(393216);
    this.jdField_a_of_type_Wch = new wch(this);
    setAdapter(this.jdField_a_of_type_Wch);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new wcd(getContext(), 0, false);
    setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    setOverScrollMode(2);
  }
  
  public void setData(ArrayList paramArrayList)
  {
    if (this.jdField_a_of_type_Wch != null) {
      this.jdField_a_of_type_Wch.a(paramArrayList);
    }
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setOrientation(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.component.extendsadapter.ComponentRvInnerView
 * JD-Core Version:    0.7.0.1
 */