package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import osg;
import paf;
import rjb;
import rjp;
import rnj;

public class FastWebActivity$33$8
  implements Runnable
{
  public FastWebActivity$33$8(rjb paramrjb, int paramInt, FastWebArticleInfo paramFastWebArticleInfo, String paramString) {}
  
  public void run()
  {
    QLog.d(FastWebActivity.a(this.jdField_a_of_type_Rjb.a), 2, "get article business success, busiFlag:" + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.p = this.jdField_a_of_type_JavaLangString;
    if ((this.jdField_a_of_type_Int == 0) && (FastWebActivity.a(this.jdField_a_of_type_Rjb.a) != null))
    {
      rnj.d(FastWebActivity.a(this.jdField_a_of_type_Rjb.a));
      paf localpaf = osg.a().a();
      if (localpaf != null) {
        localpaf.a(FastWebActivity.a(this.jdField_a_of_type_Rjb.a).j, FastWebActivity.a(this.jdField_a_of_type_Rjb.a));
      }
      rnj.a(FastWebActivity.a(this.jdField_a_of_type_Rjb.a));
      FastWebActivity.a(this.jdField_a_of_type_Rjb.a).notifyDataSetChanged();
      FastWebActivity.a(this.jdField_a_of_type_Rjb.a).a(FastWebActivity.a(this.jdField_a_of_type_Rjb.a), 0);
    }
    FastWebActivity.m(this.jdField_a_of_type_Rjb.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.33.8
 * JD-Core Version:    0.7.0.1
 */