package com.tencent.biz.pubaccount.weishi_new.drama.holder;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWSItemView;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageFragment;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.controller.WSDramaItemVideoAreaController;
import com.tencent.biz.pubaccount.weishi_new.drama.utils.WSDramaUtils;
import mqq.util.WeakReference;

public abstract class AbsWSDramaVideoItemView
  extends AbsWSItemView<WSDramaItemData>
{
  private WSDramaItemVideoAreaController jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHolderControllerWSDramaItemVideoAreaController;
  private final WeakReference<WSDramaPageContract.View> jdField_a_of_type_MqqUtilWeakReference;
  
  public AbsWSDramaVideoItemView(Context paramContext, View paramView, WSDramaPageContract.View paramView1)
  {
    super(paramContext, paramView);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramView1);
  }
  
  private void e()
  {
    WSDramaPageContract.View localView = (WSDramaPageContract.View)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localView instanceof WSDramaPageFragment)) {
      WSDramaUtils.a((WSDramaPageFragment)localView, ((WSDramaItemData)this.jdField_a_of_type_JavaLangObject).a(), ((WSDramaItemData)this.jdField_a_of_type_JavaLangObject).b(), WSDramaUtils.a);
    }
  }
  
  public WSDramaItemVideoAreaController a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHolderControllerWSDramaItemVideoAreaController;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHolderControllerWSDramaItemVideoAreaController = new WSDramaItemVideoAreaController(this.jdField_a_of_type_AndroidContentContext);
    a(2131380791, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHolderControllerWSDramaItemVideoAreaController);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new AbsWSDramaVideoItemView.1(this));
  }
  
  public void c() {}
  
  public void d() {}
  
  public void d(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.holder.AbsWSDramaVideoItemView
 * JD-Core Version:    0.7.0.1
 */