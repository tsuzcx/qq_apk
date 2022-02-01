package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import sxd;
import sxp;

public class FastWebActivity$42$5
  implements Runnable
{
  public FastWebActivity$42$5(sxd paramsxd, boolean paramBoolean) {}
  
  public void run()
  {
    if (FastWebActivity.a(this.jdField_a_of_type_Sxd.a) == null) {
      return;
    }
    FastWebActivity.a(this.jdField_a_of_type_Sxd.a).jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    FastWebActivity.a(this.jdField_a_of_type_Sxd.a).a(FastWebActivity.a(this.jdField_a_of_type_Sxd.a).jdField_a_of_type_Boolean);
    FastWebActivity.a(this.jdField_a_of_type_Sxd.a).notifyDataSetChanged();
    QLog.d("FastWebActivity", 2, " handleLikeStateResp isliked : " + FastWebActivity.a(this.jdField_a_of_type_Sxd.a).jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.42.5
 * JD-Core Version:    0.7.0.1
 */