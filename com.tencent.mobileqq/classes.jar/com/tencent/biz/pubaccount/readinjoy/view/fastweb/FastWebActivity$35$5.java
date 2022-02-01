package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import snx;

public class FastWebActivity$35$5
  implements Runnable
{
  public FastWebActivity$35$5(snx paramsnx, boolean paramBoolean) {}
  
  public void run()
  {
    if (FastWebActivity.a(this.jdField_a_of_type_Snx.a) == null) {
      return;
    }
    FastWebActivity.a(this.jdField_a_of_type_Snx.a).jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    FastWebActivity.a(this.jdField_a_of_type_Snx.a).a(FastWebActivity.a(this.jdField_a_of_type_Snx.a).jdField_a_of_type_Boolean);
    FastWebActivity.c(this.jdField_a_of_type_Snx.a);
    QLog.d("FastWebActivity", 2, " handleLikeStateResp isliked : " + FastWebActivity.a(this.jdField_a_of_type_Snx.a).jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.35.5
 * JD-Core Version:    0.7.0.1
 */