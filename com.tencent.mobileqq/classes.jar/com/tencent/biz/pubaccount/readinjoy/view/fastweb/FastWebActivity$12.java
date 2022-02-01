package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment.HippyCommentPageListener;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.FastWebMergeAdapter;
import com.tencent.hippy.qq.tuwen.adapter.TKDTuWenHippyCommentAdapter;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$12
  implements ReadInJoyCommentListFragment.HippyCommentPageListener
{
  FastWebActivity$12(FastWebActivity paramFastWebActivity, int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    if (FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity) == null) {
      return;
    }
    if (paramBoolean)
    {
      QLog.d("FastWebActivity", 1, "hippy init success");
      FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity).setTuWenHippyCallback(new FastWebActivity.TKDTuWenHippyCallback(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity, null));
      FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity).setOnOpenCommentEditListener(new FastWebActivity.MyOpenCommentEditListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity, null));
      FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity).a(null);
      return;
    }
    QLog.d("FastWebActivity", 1, "hippy init fail");
    FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity).b(FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity));
    FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity).destroy();
    FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity, null);
    FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity, this.jdField_a_of_type_Int);
    FastWebActivity.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.12
 * JD-Core Version:    0.7.0.1
 */