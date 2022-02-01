package com.tencent.biz.subscribe.part.extendsblock;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import com.tencent.biz.subscribe.part.block.base.SafeLinearLayoutManager;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import java.util.ArrayList;

public class HorizontalRvInnerView
  extends RecyclerViewCompat
{
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private HorizontalRVBlock jdField_a_of_type_ComTencentBizSubscribePartExtendsblockHorizontalRVBlock;
  private HorizontalRvInnerView.HorizontalRvAdapter jdField_a_of_type_ComTencentBizSubscribePartExtendsblockHorizontalRvInnerView$HorizontalRvAdapter;
  
  public HorizontalRvInnerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HorizontalRvInnerView(Context paramContext, HorizontalRVBlock paramHorizontalRVBlock)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizSubscribePartExtendsblockHorizontalRVBlock = paramHorizontalRVBlock;
    setDescendantFocusability(393216);
    this.jdField_a_of_type_ComTencentBizSubscribePartExtendsblockHorizontalRvInnerView$HorizontalRvAdapter = new HorizontalRvInnerView.HorizontalRvAdapter(this);
    setAdapter(this.jdField_a_of_type_ComTencentBizSubscribePartExtendsblockHorizontalRvInnerView$HorizontalRvAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new SafeLinearLayoutManager(getContext(), 0, false);
    setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    setOverScrollMode(2);
  }
  
  public void setData(ArrayList paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribePartExtendsblockHorizontalRvInnerView$HorizontalRvAdapter != null) {
      this.jdField_a_of_type_ComTencentBizSubscribePartExtendsblockHorizontalRvInnerView$HorizontalRvAdapter.a(paramArrayList);
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
 * Qualified Name:     com.tencent.biz.subscribe.part.extendsblock.HorizontalRvInnerView
 * JD-Core Version:    0.7.0.1
 */