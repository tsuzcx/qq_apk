package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import pfa;
import ppe;
import snx;
import sst;

public class FastWebActivity$35$8
  implements Runnable
{
  public FastWebActivity$35$8(snx paramsnx, int paramInt, FastWebArticleInfo paramFastWebArticleInfo, String paramString) {}
  
  public void run()
  {
    QLog.d("FastWebActivity", 2, "get article business success, busiFlag:" + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.p = this.jdField_a_of_type_JavaLangString;
    if ((this.jdField_a_of_type_Int == 0) && (FastWebActivity.a(this.jdField_a_of_type_Snx.a) != null))
    {
      sst.d(FastWebActivity.a(this.jdField_a_of_type_Snx.a));
      ppe localppe = pfa.a().a();
      if (localppe != null) {
        localppe.a(FastWebActivity.a(this.jdField_a_of_type_Snx.a).j, FastWebActivity.a(this.jdField_a_of_type_Snx.a));
      }
      sst.a(FastWebActivity.a(this.jdField_a_of_type_Snx.a));
      FastWebActivity.c(this.jdField_a_of_type_Snx.a);
      FastWebActivity.a(this.jdField_a_of_type_Snx.a).a(FastWebActivity.a(this.jdField_a_of_type_Snx.a), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.35.8
 * JD-Core Version:    0.7.0.1
 */