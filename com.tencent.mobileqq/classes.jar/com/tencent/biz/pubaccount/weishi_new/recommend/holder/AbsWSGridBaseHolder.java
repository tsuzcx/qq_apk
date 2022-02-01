package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.widget.pull2refresh.BaseViewHolder;

public abstract class AbsWSGridBaseHolder<T>
  extends BaseViewHolder<T>
{
  protected WSRecommendAdapter a;
  public IWSItemView<T> a;
  public T a;
  
  public AbsWSGridBaseHolder(ViewGroup paramViewGroup, int paramInt1, int paramInt2, WSRecommendAdapter paramWSRecommendAdapter)
  {
    super(paramViewGroup, paramInt1);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter = paramWSRecommendAdapter;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView = a(paramInt2);
  }
  
  public abstract IWSItemView<T> a(int paramInt);
  
  public void bindData(T paramT)
  {
    super.bindData(paramT);
    this.jdField_a_of_type_JavaLangObject = paramT;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView.a(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.AbsWSGridBaseHolder
 * JD-Core Version:    0.7.0.1
 */