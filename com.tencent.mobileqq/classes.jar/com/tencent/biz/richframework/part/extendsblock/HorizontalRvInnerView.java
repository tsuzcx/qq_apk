package com.tencent.biz.richframework.part.extendsblock;

import aace;
import aacn;
import aacp;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import java.util.ArrayList;

public class HorizontalRvInnerView
  extends RecyclerViewCompat
{
  private aacn jdField_a_of_type_Aacn;
  private aacp jdField_a_of_type_Aacp;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  
  public HorizontalRvInnerView(Context paramContext, aacn paramaacn)
  {
    super(paramContext);
    this.jdField_a_of_type_Aacn = paramaacn;
    setDescendantFocusability(393216);
    this.jdField_a_of_type_Aacp = new aacp(this);
    setAdapter(this.jdField_a_of_type_Aacp);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new aace(getContext(), 0, false);
    setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    setOverScrollMode(2);
  }
  
  public HorizontalRvInnerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void setData(ArrayList paramArrayList)
  {
    if (this.jdField_a_of_type_Aacp != null) {
      this.jdField_a_of_type_Aacp.setDatas(paramArrayList);
    }
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setOrientation(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.extendsblock.HorizontalRvInnerView
 * JD-Core Version:    0.7.0.1
 */