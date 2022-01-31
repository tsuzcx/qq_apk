package com.tencent.biz.subscribe.component.extendsadapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import java.util.ArrayList;
import yip;
import yir;
import yit;

public class ComponentRvInnerView
  extends RecyclerViewCompat
{
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private yir jdField_a_of_type_Yir;
  private yit jdField_a_of_type_Yit;
  
  public ComponentRvInnerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentRvInnerView(Context paramContext, yir paramyir)
  {
    super(paramContext);
    this.jdField_a_of_type_Yir = paramyir;
    setDescendantFocusability(393216);
    this.jdField_a_of_type_Yit = new yit(this);
    setAdapter(this.jdField_a_of_type_Yit);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new yip(getContext(), 0, false);
    setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    setOverScrollMode(2);
  }
  
  public void setData(ArrayList paramArrayList)
  {
    if (this.jdField_a_of_type_Yit != null) {
      this.jdField_a_of_type_Yit.setDatas(paramArrayList);
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