package com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageConfig;", "", "()V", "barrageLoop", "", "getBarrageLoop", "()Z", "setBarrageLoop", "(Z)V", "barrageSpace", "", "getBarrageSpace", "()I", "setBarrageSpace", "(I)V", "barrageTransparent", "", "getBarrageTransparent", "()F", "setBarrageTransparent", "(F)V", "lineCount", "getLineCount", "setLineCount", "orderOfAscending", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageConfig$AscendingOrder;", "getOrderOfAscending", "()Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageConfig$AscendingOrder;", "setOrderOfAscending", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageConfig$AscendingOrder;)V", "slideDuration", "getSlideDuration", "setSlideDuration", "AscendingOrder", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class BarrageConfig
{
  private float jdField_a_of_type_Float = 5.5F;
  private int jdField_a_of_type_Int = 3;
  @NotNull
  private BarrageConfig.AscendingOrder jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageConfig$AscendingOrder = BarrageConfig.AscendingOrder.TimeAsc;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float = 0.2F;
  private int jdField_b_of_type_Int = 8;
  
  public final float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(@NotNull BarrageConfig.AscendingOrder paramAscendingOrder)
  {
    Intrinsics.checkParameterIsNotNull(paramAscendingOrder, "<set-?>");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageConfig$AscendingOrder = paramAscendingOrder;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public final int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public final void b(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public final void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageConfig
 * JD-Core Version:    0.7.0.1
 */