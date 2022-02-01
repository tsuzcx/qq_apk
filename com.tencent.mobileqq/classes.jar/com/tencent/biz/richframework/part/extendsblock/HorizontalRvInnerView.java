package com.tencent.biz.richframework.part.extendsblock;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import java.util.ArrayList;
import zpj;
import zpl;
import zpn;

public class HorizontalRvInnerView
  extends RecyclerViewCompat
{
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private zpl jdField_a_of_type_Zpl;
  private zpn jdField_a_of_type_Zpn;
  
  public HorizontalRvInnerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HorizontalRvInnerView(Context paramContext, zpl paramzpl)
  {
    super(paramContext);
    this.jdField_a_of_type_Zpl = paramzpl;
    setDescendantFocusability(393216);
    this.jdField_a_of_type_Zpn = new zpn(this);
    setAdapter(this.jdField_a_of_type_Zpn);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new zpj(getContext(), 0, false);
    setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    setOverScrollMode(2);
  }
  
  public void setData(ArrayList paramArrayList)
  {
    if (this.jdField_a_of_type_Zpn != null) {
      this.jdField_a_of_type_Zpn.a(paramArrayList);
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