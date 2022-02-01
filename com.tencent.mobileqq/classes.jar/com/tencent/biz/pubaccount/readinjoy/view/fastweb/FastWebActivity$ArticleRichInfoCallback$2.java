package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import ssj;
import swt;

public class FastWebActivity$ArticleRichInfoCallback$2
  implements Runnable
{
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Ssj.a.a == null) || (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Ssj.a.a.innerUniqueID)))
    {
      QLog.d("FastWebActivity", 2, "get article topic info fail, msg not match !");
      return;
    }
    swt.a(this.jdField_a_of_type_Boolean, FastWebActivity.a(this.jdField_a_of_type_Ssj.a), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_Ssj.a.a);
    FastWebActivity.c(this.jdField_a_of_type_Ssj.a);
    QLog.d("FastWebActivity", 2, "get article topic info success! notify ui bindData");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.ArticleRichInfoCallback.2
 * JD-Core Version:    0.7.0.1
 */