package com.tencent.biz.pubaccount.readinjoy.viola.delegate;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout.SuspensionGestureListener;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;

class ViolaInitDelegate$5
  implements CommonSuspensionGestureLayout.SuspensionGestureListener
{
  ViolaInitDelegate$5(ViolaInitDelegate paramViolaInitDelegate, FrameLayout paramFrameLayout) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (ViolaInitDelegate.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaDelegateViolaInitDelegate) != null) {
      ViolaInitDelegate.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaDelegateViolaInitDelegate).a(paramInt);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 5)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("float_layer_finsh_action");
      ViolaInitDelegate.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaDelegateViolaInitDelegate).getActivity().sendBroadcast(localIntent);
    }
    ViolaInitDelegate.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaDelegateViolaInitDelegate).getActivity().doOnBackPressed();
    ViolaInitDelegate.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaDelegateViolaInitDelegate).getActivity().overridePendingTransition(0, 0);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    }
  }
  
  public void b(int paramInt) {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaInitDelegate.5
 * JD-Core Version:    0.7.0.1
 */