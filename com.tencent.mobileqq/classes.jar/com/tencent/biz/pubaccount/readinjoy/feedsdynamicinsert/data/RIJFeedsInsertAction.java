package com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data;

import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/data/RIJFeedsInsertAction;", "", "actionType", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertRecordAction$ActionType;", "progress", "", "priority", "watch_time", "(Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertRecordAction$ActionType;III)V", "getActionType", "()Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertRecordAction$ActionType;", "setActionType", "(Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertRecordAction$ActionType;)V", "getPriority", "()I", "setPriority", "(I)V", "getProgress", "setProgress", "getWatch_time", "setWatch_time", "compareTo", "other", "toString", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsInsertAction
  implements Comparable<RIJFeedsInsertAction>
{
  private int jdField_a_of_type_Int;
  @NotNull
  private RIJFeedsDynamicInsertRecordAction.ActionType jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsdynamicinsertRIJFeedsDynamicInsertRecordAction$ActionType;
  private int b;
  private int c;
  
  public RIJFeedsInsertAction(@NotNull RIJFeedsDynamicInsertRecordAction.ActionType paramActionType, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsdynamicinsertRIJFeedsDynamicInsertRecordAction$ActionType = paramActionType;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(@NotNull RIJFeedsInsertAction paramRIJFeedsInsertAction)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJFeedsInsertAction, "other");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsdynamicinsertRIJFeedsDynamicInsertRecordAction$ActionType == paramRIJFeedsInsertAction.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsdynamicinsertRIJFeedsDynamicInsertRecordAction$ActionType) {
      return 0;
    }
    if (this.b < paramRIJFeedsInsertAction.b) {
      return -1;
    }
    return 1;
  }
  
  @NotNull
  public final RIJFeedsDynamicInsertRecordAction.ActionType a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsdynamicinsertRIJFeedsDynamicInsertRecordAction$ActionType;
  }
  
  public final int b()
  {
    return this.c;
  }
  
  @NotNull
  public String toString()
  {
    return "RIJFeedsInsertAction(actionType=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsdynamicinsertRIJFeedsDynamicInsertRecordAction$ActionType + ", progress=" + this.jdField_a_of_type_Int + ", watchTime=" + this.c + ", priority=" + this.b + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction
 * JD-Core Version:    0.7.0.1
 */