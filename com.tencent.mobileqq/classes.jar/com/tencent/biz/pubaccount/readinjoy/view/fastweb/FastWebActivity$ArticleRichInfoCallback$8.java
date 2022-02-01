package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ItemDatasListUtils;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$ArticleRichInfoCallback$8
  implements Runnable
{
  FastWebActivity$ArticleRichInfoCallback$8(FastWebActivity.ArticleRichInfoCallback paramArticleRichInfoCallback, int paramInt, FastWebArticleInfo paramFastWebArticleInfo, String paramString) {}
  
  public void run()
  {
    QLog.d("FastWebActivity", 2, "get article business success, busiFlag:" + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.p = this.jdField_a_of_type_JavaLangString;
    if ((this.jdField_a_of_type_Int == 0) && (FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a) != null))
    {
      ItemDatasListUtils.d(FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a));
      FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().a();
      if (localFastWebModule != null) {
        localFastWebModule.a(FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a).j, FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a));
      }
      ItemDatasListUtils.a(FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a));
      FastWebActivity.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a);
      FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a).a(FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.ArticleRichInfoCallback.8
 * JD-Core Version:    0.7.0.1
 */