package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import rjb;
import rjp;

public class FastWebActivity$33$4
  implements Runnable
{
  public FastWebActivity$33$4(rjb paramrjb, int paramInt) {}
  
  public void run()
  {
    if (FastWebActivity.a(this.jdField_a_of_type_Rjb.a) == null) {
      return;
    }
    FastWebActivity.a(this.jdField_a_of_type_Rjb.a).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    FastWebActivity.a(this.jdField_a_of_type_Rjb.a).a(FastWebActivity.a(this.jdField_a_of_type_Rjb.a).jdField_a_of_type_Int);
    FastWebActivity.a(this.jdField_a_of_type_Rjb.a).notifyDataSetChanged();
    QLog.d(FastWebActivity.a(this.jdField_a_of_type_Rjb.a), 2, " handleLikeCntInfoResp likeCnt : " + FastWebActivity.a(this.jdField_a_of_type_Rjb.a).jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.33.4
 * JD-Core Version:    0.7.0.1
 */