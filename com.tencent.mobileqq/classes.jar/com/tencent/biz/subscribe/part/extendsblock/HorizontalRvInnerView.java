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
    HorizontalRvInnerView.HorizontalRvAdapter localHorizontalRvAdapter = this.jdField_a_of_type_ComTencentBizSubscribePartExtendsblockHorizontalRvInnerView$HorizontalRvAdapter;
    if (localHorizontalRvAdapter != null) {
      localHorizontalRvAdapter.a(paramArrayList);
    }
  }
  
  public void setOrientation(int paramInt)
  {
    LinearLayoutManager localLinearLayoutManager = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
    if (localLinearLayoutManager != null) {
      localLinearLayoutManager.setOrientation(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.extendsblock.HorizontalRvInnerView
 * JD-Core Version:    0.7.0.1
 */