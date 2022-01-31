package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import qwo;
import qxb;

public class FastWebActivity$30$5
  implements Runnable
{
  public FastWebActivity$30$5(qwo paramqwo, boolean paramBoolean) {}
  
  public void run()
  {
    if (FastWebActivity.a(this.jdField_a_of_type_Qwo.a) == null) {
      return;
    }
    FastWebActivity.a(this.jdField_a_of_type_Qwo.a).jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    FastWebActivity.a(this.jdField_a_of_type_Qwo.a).a(FastWebActivity.a(this.jdField_a_of_type_Qwo.a).jdField_a_of_type_Boolean);
    FastWebActivity.a(this.jdField_a_of_type_Qwo.a).notifyDataSetChanged();
    QLog.d(FastWebActivity.a(this.jdField_a_of_type_Qwo.a), 2, " handleLikeStateResp isliked : " + FastWebActivity.a(this.jdField_a_of_type_Qwo.a).jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.30.5
 * JD-Core Version:    0.7.0.1
 */