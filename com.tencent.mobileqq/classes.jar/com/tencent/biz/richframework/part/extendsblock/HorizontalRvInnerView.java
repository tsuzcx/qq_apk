package com.tencent.biz.richframework.part.extendsblock;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import java.util.ArrayList;
import zae;
import zag;
import zai;

public class HorizontalRvInnerView
  extends RecyclerViewCompat
{
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private zag jdField_a_of_type_Zag;
  private zai jdField_a_of_type_Zai;
  
  public HorizontalRvInnerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HorizontalRvInnerView(Context paramContext, zag paramzag)
  {
    super(paramContext);
    this.jdField_a_of_type_Zag = paramzag;
    setDescendantFocusability(393216);
    this.jdField_a_of_type_Zai = new zai(this);
    setAdapter(this.jdField_a_of_type_Zai);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new zae(getContext(), 0, false);
    setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    setOverScrollMode(2);
  }
  
  public void setData(ArrayList paramArrayList)
  {
    if (this.jdField_a_of_type_Zai != null) {
      this.jdField_a_of_type_Zai.a(paramArrayList);
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