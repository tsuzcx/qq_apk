package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import rje;
import rna;
import rnb;
import wim;

public class FastWebActivity$33$1
  implements Runnable
{
  public FastWebActivity$33$1(rje paramrje, boolean paramBoolean, int paramInt, String paramString, rna paramrna) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      rnb localrnb = FastWebActivity.a(this.jdField_a_of_type_Rje.a);
      ArticleInfo localArticleInfo = FastWebActivity.a(this.jdField_a_of_type_Rje.a);
      int i = this.jdField_a_of_type_Int;
      FastWebActivity localFastWebActivity = this.jdField_a_of_type_Rje.a;
      String str2 = this.jdField_a_of_type_JavaLangString;
      if (FastWebActivity.b(this.jdField_a_of_type_Rje.a)) {}
      for (String str1 = "0X8008994";; str1 = "0X800898D")
      {
        localrnb.a(localArticleInfo, i, localFastWebActivity, str2, str1, this.jdField_a_of_type_Rna.a(this.jdField_a_of_type_Int));
        return;
      }
    }
    wim.a(1, 2131689512);
    QLog.d("Q.readinjoy.fast_web", 2, "shareJson get false ! action : " + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.33.1
 * JD-Core Version:    0.7.0.1
 */