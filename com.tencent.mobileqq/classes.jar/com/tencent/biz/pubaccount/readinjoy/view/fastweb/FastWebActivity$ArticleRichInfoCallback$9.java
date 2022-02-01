package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebPTSDataConverter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ItemDatasListUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.List;

class FastWebActivity$ArticleRichInfoCallback$9
  implements Runnable
{
  FastWebActivity$ArticleRichInfoCallback$9(FastWebActivity.ArticleRichInfoCallback paramArticleRichInfoCallback, String paramString, FastWebArticleInfo paramFastWebArticleInfo) {}
  
  public void run()
  {
    QLog.i("FastWebActivity", 1, "[handleTopicTag], rowKey = " + this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.b == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.b.size() <= 0)) {
      QLog.i("FastWebActivity", 1, "[handleTopicTag] topicTagList is null.");
    }
    ProteusItemData localProteusItemData;
    do
    {
      return;
      if (!ReadInJoyHelper.g())
      {
        QLog.i("FastWebActivity", 1, "[handleTopicTag] topic switch is off.");
        return;
      }
      localProteusItemData = FastWebPTSDataConverter.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a.jdField_a_of_type_AndroidUtilSparseArray);
    } while ((FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a) == null) || (localProteusItemData == null));
    ItemDatasListUtils.f(FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a));
    ItemDatasListUtils.a(FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a), localProteusItemData, FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a));
    FastWebActivity.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.ArticleRichInfoCallback.9
 * JD-Core Version:    0.7.0.1
 */