package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import tfu;

public class FastWebActivity$ArticleRichInfoCallback$5
  implements Runnable
{
  public FastWebActivity$ArticleRichInfoCallback$5(tfu paramtfu, boolean paramBoolean) {}
  
  public void run()
  {
    if (FastWebActivity.a(this.jdField_a_of_type_Tfu.a) == null) {
      return;
    }
    FastWebActivity.a(this.jdField_a_of_type_Tfu.a).jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    FastWebActivity.a(this.jdField_a_of_type_Tfu.a).a(FastWebActivity.a(this.jdField_a_of_type_Tfu.a).jdField_a_of_type_Boolean);
    FastWebActivity.d(this.jdField_a_of_type_Tfu.a);
    QLog.d("FastWebActivity", 2, " handleLikeStateResp isliked : " + FastWebActivity.a(this.jdField_a_of_type_Tfu.a).jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.ArticleRichInfoCallback.5
 * JD-Core Version:    0.7.0.1
 */