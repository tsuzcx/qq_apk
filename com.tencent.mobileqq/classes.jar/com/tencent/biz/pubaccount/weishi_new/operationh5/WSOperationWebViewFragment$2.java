package com.tencent.biz.pubaccount.weishi_new.operationh5;

import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.weishi_new.WSPublicAccLaunchParams;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.operationh5.report.WSOperationH5BeaconReporter;

class WSOperationWebViewFragment$2
  implements OperationTitleBarView.OperationTitleClickListener
{
  WSOperationWebViewFragment$2(WSOperationWebViewFragment paramWSOperationWebViewFragment) {}
  
  public void a()
  {
    WSOperationWebViewFragment localWSOperationWebViewFragment = this.a;
    localWSOperationWebViewFragment.jdField_a_of_type_Boolean = true;
    localWSOperationWebViewFragment.jdField_a_of_type_ComTencentBizPubaccountWeishi_newOperationh5ReportWSOperationH5BeaconReporter.e();
    this.a.jdField_a_of_type_ComTencentBizPubaccountWeishi_newOperationh5ReportWSOperationH5BeaconReporter.b();
    WeishiActivityHelper.a(this.a.requireActivity(), new WSPublicAccLaunchParams("from_operation_h5", 0, false).b(this.a.getUrl()));
  }
  
  public void b()
  {
    this.a.requireActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.operationh5.WSOperationWebViewFragment.2
 * JD-Core Version:    0.7.0.1
 */