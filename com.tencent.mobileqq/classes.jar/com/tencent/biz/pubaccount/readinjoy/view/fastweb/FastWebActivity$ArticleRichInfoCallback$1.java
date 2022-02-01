package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import ssj;
import swh;
import swi;
import yyi;

public class FastWebActivity$ArticleRichInfoCallback$1
  implements Runnable
{
  public FastWebActivity$ArticleRichInfoCallback$1(ssj paramssj, boolean paramBoolean, swh paramswh, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Swh != null))
    {
      swi localswi = FastWebActivity.a(this.jdField_a_of_type_Ssj.a);
      ArticleInfo localArticleInfo = this.jdField_a_of_type_Ssj.a.a;
      int i = this.jdField_a_of_type_Int;
      FastWebActivity localFastWebActivity = this.jdField_a_of_type_Ssj.a;
      String str2 = this.jdField_a_of_type_JavaLangString;
      if (FastWebActivity.b(this.jdField_a_of_type_Ssj.a)) {}
      for (String str1 = "0X8008994";; str1 = "0X800898D")
      {
        localswi.a(localArticleInfo, i, localFastWebActivity, str2, str1, this.jdField_a_of_type_Swh.a(this.jdField_a_of_type_Int), FastWebActivity.a(this.jdField_a_of_type_Ssj.a), FastWebActivity.i(this.jdField_a_of_type_Ssj.a), FastWebActivity.b(this.jdField_a_of_type_Ssj.a));
        return;
      }
    }
    yyi.a(1, 2131689486);
    QLog.d("Q.readinjoy.fast_web", 2, "shareJson get false ! action : " + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.ArticleRichInfoCallback.1
 * JD-Core Version:    0.7.0.1
 */