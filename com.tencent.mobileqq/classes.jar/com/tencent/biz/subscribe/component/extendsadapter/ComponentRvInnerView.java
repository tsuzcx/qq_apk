package com.tencent.biz.subscribe.component.extendsadapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import java.util.ArrayList;
import yed;
import yef;
import yeh;

public class ComponentRvInnerView
  extends RecyclerViewCompat
{
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private yef jdField_a_of_type_Yef;
  private yeh jdField_a_of_type_Yeh;
  
  public ComponentRvInnerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentRvInnerView(Context paramContext, yef paramyef)
  {
    super(paramContext);
    this.jdField_a_of_type_Yef = paramyef;
    setDescendantFocusability(393216);
    this.jdField_a_of_type_Yeh = new yeh(this);
    setAdapter(this.jdField_a_of_type_Yeh);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new yed(getContext(), 0, false);
    setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    setOverScrollMode(2);
  }
  
  public void setData(ArrayList paramArrayList)
  {
    if (this.jdField_a_of_type_Yeh != null) {
      this.jdField_a_of_type_Yeh.a(paramArrayList);
    }
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setOrientation(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.component.extendsadapter.ComponentRvInnerView
 * JD-Core Version:    0.7.0.1
 */