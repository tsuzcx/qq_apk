package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import qwo;
import qxb;
import rau;

public class FastWebActivity$30$2
  implements Runnable
{
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (FastWebActivity.a(this.jdField_a_of_type_Qwo.a) == null) || (!this.jdField_a_of_type_JavaLangString.equals(FastWebActivity.a(this.jdField_a_of_type_Qwo.a).innerUniqueID)))
    {
      QLog.d(FastWebActivity.a(this.jdField_a_of_type_Qwo.a), 2, "get article topic info fail, msg not match !");
      return;
    }
    rau.a(this.jdField_a_of_type_Boolean, FastWebActivity.a(this.jdField_a_of_type_Qwo.a), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, FastWebActivity.a(this.jdField_a_of_type_Qwo.a));
    FastWebActivity.a(this.jdField_a_of_type_Qwo.a).notifyDataSetChanged();
    QLog.d(FastWebActivity.a(this.jdField_a_of_type_Qwo.a), 2, "get article topic info success! notify ui bindData");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.30.2
 * JD-Core Version:    0.7.0.1
 */