package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.widget.pull2refresh.BaseViewHolder;

public abstract class WSVerticalBaseHolder<T>
  extends BaseViewHolder<T>
{
  public IWSItemView<T> a;
  public WSVerticalPageFragment a;
  public T a;
  
  public WSVerticalBaseHolder(ViewGroup paramViewGroup, int paramInt1, int paramInt2, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, paramInt1);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView = a(paramInt2);
  }
  
  public abstract FrameLayout a();
  
  public abstract IWSItemView<T> a(int paramInt);
  
  public abstract void a(int paramInt);
  
  public abstract void b(int paramInt);
  
  public void bindData(T paramT)
  {
    super.bindData(paramT);
    this.jdField_a_of_type_JavaLangObject = paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalBaseHolder
 * JD-Core Version:    0.7.0.1
 */