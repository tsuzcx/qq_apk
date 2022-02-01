package com.tencent.biz.pubaccount.weishi_new.drama.checkable;

import android.view.ViewGroup;
import com.tencent.widget.pull2refresh.BaseViewHolder;

public abstract class WSAbsCheckableHolder<M extends Checkable>
  extends BaseViewHolder<M>
{
  private M a;
  protected OnCheckedListener<M> a;
  
  public WSAbsCheckableHolder(ViewGroup paramViewGroup, int paramInt, OnCheckedListener<M> paramOnCheckedListener)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCheckableOnCheckedListener = paramOnCheckedListener;
  }
  
  private void b(M paramM)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCheckableCheckable = paramM;
  }
  
  protected M a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCheckableCheckable;
  }
  
  protected void a()
  {
    OnCheckedListener localOnCheckedListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCheckableOnCheckedListener;
    if (localOnCheckedListener != null) {
      localOnCheckedListener.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCheckableCheckable, getAdapterPosition());
    }
  }
  
  public void a(M paramM)
  {
    super.bindData(paramM);
    b(paramM);
  }
  
  protected abstract void a(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.checkable.WSAbsCheckableHolder
 * JD-Core Version:    0.7.0.1
 */