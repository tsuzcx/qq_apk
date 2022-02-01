package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import pmh;
import pwt;
import sxd;
import sxp;
import tbx;

public class FastWebActivity$42$8
  implements Runnable
{
  public FastWebActivity$42$8(sxd paramsxd, int paramInt, FastWebArticleInfo paramFastWebArticleInfo, String paramString) {}
  
  public void run()
  {
    QLog.d("FastWebActivity", 2, "get article business success, busiFlag:" + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.p = this.jdField_a_of_type_JavaLangString;
    if ((this.jdField_a_of_type_Int == 0) && (FastWebActivity.a(this.jdField_a_of_type_Sxd.a) != null))
    {
      tbx.d(FastWebActivity.a(this.jdField_a_of_type_Sxd.a));
      pwt localpwt = pmh.a().a();
      if (localpwt != null) {
        localpwt.a(FastWebActivity.a(this.jdField_a_of_type_Sxd.a).j, FastWebActivity.a(this.jdField_a_of_type_Sxd.a));
      }
      tbx.a(FastWebActivity.a(this.jdField_a_of_type_Sxd.a));
      FastWebActivity.a(this.jdField_a_of_type_Sxd.a).notifyDataSetChanged();
      FastWebActivity.a(this.jdField_a_of_type_Sxd.a).a(FastWebActivity.a(this.jdField_a_of_type_Sxd.a), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.42.8
 * JD-Core Version:    0.7.0.1
 */