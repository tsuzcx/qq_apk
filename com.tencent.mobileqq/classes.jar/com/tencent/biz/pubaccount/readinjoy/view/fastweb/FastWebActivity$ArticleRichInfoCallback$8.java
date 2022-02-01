package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import pvj;
import qfg;
import tfu;
import tke;

public class FastWebActivity$ArticleRichInfoCallback$8
  implements Runnable
{
  public FastWebActivity$ArticleRichInfoCallback$8(tfu paramtfu, int paramInt, FastWebArticleInfo paramFastWebArticleInfo, String paramString) {}
  
  public void run()
  {
    QLog.d("FastWebActivity", 2, "get article business success, busiFlag:" + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.p = this.jdField_a_of_type_JavaLangString;
    if ((this.jdField_a_of_type_Int == 0) && (FastWebActivity.a(this.jdField_a_of_type_Tfu.a) != null))
    {
      tke.d(FastWebActivity.a(this.jdField_a_of_type_Tfu.a));
      qfg localqfg = pvj.a().a();
      if (localqfg != null) {
        localqfg.a(FastWebActivity.a(this.jdField_a_of_type_Tfu.a).j, FastWebActivity.a(this.jdField_a_of_type_Tfu.a));
      }
      tke.a(FastWebActivity.a(this.jdField_a_of_type_Tfu.a));
      FastWebActivity.d(this.jdField_a_of_type_Tfu.a);
      FastWebActivity.a(this.jdField_a_of_type_Tfu.a).a(FastWebActivity.a(this.jdField_a_of_type_Tfu.a), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.ArticleRichInfoCallback.8
 * JD-Core Version:    0.7.0.1
 */