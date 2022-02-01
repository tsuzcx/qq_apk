package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import ssj;

public class FastWebActivity$ArticleRichInfoCallback$4
  implements Runnable
{
  public FastWebActivity$ArticleRichInfoCallback$4(ssj paramssj, int paramInt) {}
  
  public void run()
  {
    if (FastWebActivity.a(this.jdField_a_of_type_Ssj.a) == null) {
      return;
    }
    FastWebActivity.a(this.jdField_a_of_type_Ssj.a).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    FastWebActivity.a(this.jdField_a_of_type_Ssj.a).a(FastWebActivity.a(this.jdField_a_of_type_Ssj.a).jdField_a_of_type_Int);
    FastWebActivity.c(this.jdField_a_of_type_Ssj.a);
    QLog.d("FastWebActivity", 2, " handleLikeCntInfoResp likeCnt : " + FastWebActivity.a(this.jdField_a_of_type_Ssj.a).jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.ArticleRichInfoCallback.4
 * JD-Core Version:    0.7.0.1
 */