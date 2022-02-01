package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$ArticleRichInfoCallback$1
  implements Runnable
{
  FastWebActivity$ArticleRichInfoCallback$1(FastWebActivity.ArticleRichInfoCallback paramArticleRichInfoCallback, boolean paramBoolean, FastWebShareInfo paramFastWebShareInfo, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebShareInfo != null))
    {
      FastWebShareUtils localFastWebShareUtils = FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a);
      ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a.a;
      int i = this.jdField_a_of_type_Int;
      FastWebActivity localFastWebActivity = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a;
      String str2 = this.jdField_a_of_type_JavaLangString;
      if (FastWebActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a)) {}
      for (String str1 = "0X8008994";; str1 = "0X800898D")
      {
        localFastWebShareUtils.a(localArticleInfo, i, localFastWebActivity, str2, str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebShareInfo.a(this.jdField_a_of_type_Int), FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a), FastWebActivity.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a), FastWebActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback.a));
        return;
      }
    }
    QRUtils.a(1, 2131689486);
    QLog.d("Q.readinjoy.fast_web", 2, "shareJson get false ! action : " + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.ArticleRichInfoCallback.1
 * JD-Core Version:    0.7.0.1
 */