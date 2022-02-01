package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$ArticleRichInfoCallback$4
  implements Runnable
{
  FastWebActivity$ArticleRichInfoCallback$4(FastWebActivity.ArticleRichInfoCallback paramArticleRichInfoCallback, int paramInt) {}
  
  public void run()
  {
    if (FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a) == null) {
      return;
    }
    FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a).a(FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a).jdField_a_of_type_Int);
    FastWebActivity.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a);
    QLog.d("FastWebActivity", 2, " handleLikeCntInfoResp likeCnt : " + FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a).jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.ArticleRichInfoCallback.4
 * JD-Core Version:    0.7.0.1
 */