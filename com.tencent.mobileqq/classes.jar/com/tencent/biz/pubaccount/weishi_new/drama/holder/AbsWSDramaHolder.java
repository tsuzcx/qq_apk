package com.tencent.biz.pubaccount.weishi_new.drama.holder;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import mqq.util.WeakReference;

public abstract class AbsWSDramaHolder
  extends BaseViewHolder<WSDramaItemData>
{
  public IWSItemView<WSDramaItemData> a;
  public WSDramaItemData a;
  public WeakReference<WSDramaPageContract.View> a;
  
  public AbsWSDramaHolder(ViewGroup paramViewGroup, int paramInt1, int paramInt2, WSDramaPageContract.View paramView)
  {
    super(paramViewGroup, paramInt1);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramView);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView = a(paramInt2);
  }
  
  public abstract IWSItemView<WSDramaItemData> a(int paramInt);
  
  public WSDramaPageContract.View a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_MqqUtilWeakReference;
    if (localWeakReference != null) {
      return (WSDramaPageContract.View)localWeakReference.get();
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    IWSItemView localIWSItemView = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView;
    if (localIWSItemView != null) {
      localIWSItemView.b(paramInt);
    }
  }
  
  public void a(WSDramaItemData paramWSDramaItemData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaDataWSDramaItemData = paramWSDramaItemData;
    IWSItemView localIWSItemView = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView;
    if (localIWSItemView != null)
    {
      localIWSItemView.a(paramWSDramaItemData);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView.a(getLayoutPosition() - 1);
    }
  }
  
  public void onViewDetachedFromWindow()
  {
    super.onViewDetachedFromWindow();
    IWSItemView localIWSItemView = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView;
    if (localIWSItemView != null) {
      localIWSItemView.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.holder.AbsWSDramaHolder
 * JD-Core Version:    0.7.0.1
 */