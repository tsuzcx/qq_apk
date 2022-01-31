package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import qwo;
import rai;
import raj;
import vvp;

public class FastWebActivity$30$1
  implements Runnable
{
  public FastWebActivity$30$1(qwo paramqwo, boolean paramBoolean, int paramInt, String paramString, rai paramrai) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      raj localraj = FastWebActivity.a(this.jdField_a_of_type_Qwo.a);
      ArticleInfo localArticleInfo = FastWebActivity.a(this.jdField_a_of_type_Qwo.a);
      int i = this.jdField_a_of_type_Int;
      FastWebActivity localFastWebActivity = this.jdField_a_of_type_Qwo.a;
      String str2 = this.jdField_a_of_type_JavaLangString;
      if (FastWebActivity.b(this.jdField_a_of_type_Qwo.a)) {}
      for (String str1 = "0X8008994";; str1 = "0X800898D")
      {
        localraj.a(localArticleInfo, i, localFastWebActivity, str2, str1, this.jdField_a_of_type_Rai.a(this.jdField_a_of_type_Int));
        return;
      }
    }
    vvp.a(1, 2131623975);
    QLog.d("Q.readinjoy.fast_web", 2, "shareJson get false ! action : " + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.30.1
 * JD-Core Version:    0.7.0.1
 */