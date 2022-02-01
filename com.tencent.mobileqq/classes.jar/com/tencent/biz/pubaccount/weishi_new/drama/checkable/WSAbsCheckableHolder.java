package com.tencent.biz.pubaccount.weishi_new.drama.checkable;

import android.view.ViewGroup;
import com.tencent.widget.pull2refresh.BaseViewHolder;

public abstract class WSAbsCheckableHolder<M extends Checkable>
  extends BaseViewHolder<M>
{
  protected OnCheckedListener<M> a;
  private M b;
  
  public WSAbsCheckableHolder(ViewGroup paramViewGroup, int paramInt, OnCheckedListener<M> paramOnCheckedListener)
  {
    super(paramViewGroup, paramInt);
    this.a = paramOnCheckedListener;
  }
  
  private void b(M paramM)
  {
    this.b = paramM;
  }
  
  protected void a()
  {
    OnCheckedListener localOnCheckedListener = this.a;
    if (localOnCheckedListener != null) {
      localOnCheckedListener.b(this.b, getAdapterPosition());
    }
  }
  
  public void a(M paramM)
  {
    super.bindData(paramM);
    b(paramM);
  }
  
  protected abstract void a(boolean paramBoolean);
  
  protected M b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.checkable.WSAbsCheckableHolder
 * JD-Core Version:    0.7.0.1
 */