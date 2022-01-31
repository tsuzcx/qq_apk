package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import rzd;
import rzr;

public class FastWebActivity$39$4
  implements Runnable
{
  public FastWebActivity$39$4(rzd paramrzd, int paramInt) {}
  
  public void run()
  {
    if (FastWebActivity.a(this.jdField_a_of_type_Rzd.a) == null) {
      return;
    }
    FastWebActivity.a(this.jdField_a_of_type_Rzd.a).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    FastWebActivity.a(this.jdField_a_of_type_Rzd.a).a(FastWebActivity.a(this.jdField_a_of_type_Rzd.a).jdField_a_of_type_Int);
    FastWebActivity.a(this.jdField_a_of_type_Rzd.a).notifyDataSetChanged();
    QLog.d(FastWebActivity.a(this.jdField_a_of_type_Rzd.a), 2, " handleLikeCntInfoResp likeCnt : " + FastWebActivity.a(this.jdField_a_of_type_Rzd.a).jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.39.4
 * JD-Core Version:    0.7.0.1
 */