package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import ogy;
import oph;
import qwo;
import qxb;
import rau;

public class FastWebActivity$30$8
  implements Runnable
{
  public FastWebActivity$30$8(qwo paramqwo, int paramInt, FastWebArticleInfo paramFastWebArticleInfo, String paramString) {}
  
  public void run()
  {
    QLog.d(FastWebActivity.a(this.jdField_a_of_type_Qwo.a), 2, "get article business success, busiFlag:" + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.o = this.jdField_a_of_type_JavaLangString;
    if ((this.jdField_a_of_type_Int == 0) && (FastWebActivity.a(this.jdField_a_of_type_Qwo.a) != null))
    {
      rau.d(FastWebActivity.a(this.jdField_a_of_type_Qwo.a));
      oph localoph = ogy.a().a();
      if (localoph != null) {
        localoph.a(FastWebActivity.a(this.jdField_a_of_type_Qwo.a).j, FastWebActivity.a(this.jdField_a_of_type_Qwo.a));
      }
      rau.a(FastWebActivity.a(this.jdField_a_of_type_Qwo.a));
      FastWebActivity.a(this.jdField_a_of_type_Qwo.a).notifyDataSetChanged();
      FastWebActivity.a(this.jdField_a_of_type_Qwo.a).a(FastWebActivity.a(this.jdField_a_of_type_Qwo.a), 0);
    }
    FastWebActivity.m(this.jdField_a_of_type_Qwo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.30.8
 * JD-Core Version:    0.7.0.1
 */