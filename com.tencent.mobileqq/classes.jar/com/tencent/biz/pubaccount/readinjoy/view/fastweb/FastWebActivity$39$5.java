package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import rzd;
import rzr;

public class FastWebActivity$39$5
  implements Runnable
{
  public FastWebActivity$39$5(rzd paramrzd, boolean paramBoolean) {}
  
  public void run()
  {
    if (FastWebActivity.a(this.jdField_a_of_type_Rzd.a) == null) {
      return;
    }
    FastWebActivity.a(this.jdField_a_of_type_Rzd.a).jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    FastWebActivity.a(this.jdField_a_of_type_Rzd.a).a(FastWebActivity.a(this.jdField_a_of_type_Rzd.a).jdField_a_of_type_Boolean);
    FastWebActivity.a(this.jdField_a_of_type_Rzd.a).notifyDataSetChanged();
    QLog.d(FastWebActivity.a(this.jdField_a_of_type_Rzd.a), 2, " handleLikeStateResp isliked : " + FastWebActivity.a(this.jdField_a_of_type_Rzd.a).jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.39.5
 * JD-Core Version:    0.7.0.1
 */