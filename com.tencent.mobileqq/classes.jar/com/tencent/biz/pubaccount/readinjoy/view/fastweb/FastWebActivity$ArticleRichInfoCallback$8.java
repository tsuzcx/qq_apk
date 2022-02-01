package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import pkm;
import pum;
import ssj;
import swt;

public class FastWebActivity$ArticleRichInfoCallback$8
  implements Runnable
{
  public FastWebActivity$ArticleRichInfoCallback$8(ssj paramssj, int paramInt, FastWebArticleInfo paramFastWebArticleInfo, String paramString) {}
  
  public void run()
  {
    QLog.d("FastWebActivity", 2, "get article business success, busiFlag:" + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.p = this.jdField_a_of_type_JavaLangString;
    if ((this.jdField_a_of_type_Int == 0) && (FastWebActivity.a(this.jdField_a_of_type_Ssj.a) != null))
    {
      swt.d(FastWebActivity.a(this.jdField_a_of_type_Ssj.a));
      pum localpum = pkm.a().a();
      if (localpum != null) {
        localpum.a(FastWebActivity.a(this.jdField_a_of_type_Ssj.a).j, FastWebActivity.a(this.jdField_a_of_type_Ssj.a));
      }
      swt.a(FastWebActivity.a(this.jdField_a_of_type_Ssj.a));
      FastWebActivity.c(this.jdField_a_of_type_Ssj.a);
      FastWebActivity.a(this.jdField_a_of_type_Ssj.a).a(FastWebActivity.a(this.jdField_a_of_type_Ssj.a), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.ArticleRichInfoCallback.8
 * JD-Core Version:    0.7.0.1
 */