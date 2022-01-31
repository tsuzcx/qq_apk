package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import osj;
import pai;
import rje;
import rjs;
import rnm;

public class FastWebActivity$33$8
  implements Runnable
{
  public FastWebActivity$33$8(rje paramrje, int paramInt, FastWebArticleInfo paramFastWebArticleInfo, String paramString) {}
  
  public void run()
  {
    QLog.d(FastWebActivity.a(this.jdField_a_of_type_Rje.a), 2, "get article business success, busiFlag:" + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.p = this.jdField_a_of_type_JavaLangString;
    if ((this.jdField_a_of_type_Int == 0) && (FastWebActivity.a(this.jdField_a_of_type_Rje.a) != null))
    {
      rnm.d(FastWebActivity.a(this.jdField_a_of_type_Rje.a));
      pai localpai = osj.a().a();
      if (localpai != null) {
        localpai.a(FastWebActivity.a(this.jdField_a_of_type_Rje.a).j, FastWebActivity.a(this.jdField_a_of_type_Rje.a));
      }
      rnm.a(FastWebActivity.a(this.jdField_a_of_type_Rje.a));
      FastWebActivity.a(this.jdField_a_of_type_Rje.a).notifyDataSetChanged();
      FastWebActivity.a(this.jdField_a_of_type_Rje.a).a(FastWebActivity.a(this.jdField_a_of_type_Rje.a), 0);
    }
    FastWebActivity.m(this.jdField_a_of_type_Rje.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.33.8
 * JD-Core Version:    0.7.0.1
 */