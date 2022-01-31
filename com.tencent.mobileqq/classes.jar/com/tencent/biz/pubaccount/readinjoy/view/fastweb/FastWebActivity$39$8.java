package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import owy;
import pfo;
import rzd;
import rzr;
import sdi;

public class FastWebActivity$39$8
  implements Runnable
{
  public FastWebActivity$39$8(rzd paramrzd, int paramInt, FastWebArticleInfo paramFastWebArticleInfo, String paramString) {}
  
  public void run()
  {
    QLog.d(FastWebActivity.a(this.jdField_a_of_type_Rzd.a), 2, "get article business success, busiFlag:" + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.p = this.jdField_a_of_type_JavaLangString;
    if ((this.jdField_a_of_type_Int == 0) && (FastWebActivity.a(this.jdField_a_of_type_Rzd.a) != null))
    {
      sdi.d(FastWebActivity.a(this.jdField_a_of_type_Rzd.a));
      pfo localpfo = owy.a().a();
      if (localpfo != null) {
        localpfo.a(FastWebActivity.a(this.jdField_a_of_type_Rzd.a).j, FastWebActivity.a(this.jdField_a_of_type_Rzd.a));
      }
      sdi.a(FastWebActivity.a(this.jdField_a_of_type_Rzd.a));
      FastWebActivity.a(this.jdField_a_of_type_Rzd.a).notifyDataSetChanged();
      FastWebActivity.a(this.jdField_a_of_type_Rzd.a).a(FastWebActivity.a(this.jdField_a_of_type_Rzd.a), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.39.8
 * JD-Core Version:    0.7.0.1
 */