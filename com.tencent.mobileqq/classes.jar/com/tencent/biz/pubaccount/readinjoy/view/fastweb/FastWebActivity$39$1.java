package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import rzd;
import scw;
import scx;
import ybk;

public class FastWebActivity$39$1
  implements Runnable
{
  public FastWebActivity$39$1(rzd paramrzd, boolean paramBoolean, int paramInt, String paramString, scw paramscw) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      scx localscx = FastWebActivity.a(this.jdField_a_of_type_Rzd.a);
      ArticleInfo localArticleInfo = FastWebActivity.a(this.jdField_a_of_type_Rzd.a);
      int i = this.jdField_a_of_type_Int;
      FastWebActivity localFastWebActivity = this.jdField_a_of_type_Rzd.a;
      String str2 = this.jdField_a_of_type_JavaLangString;
      if (FastWebActivity.d(this.jdField_a_of_type_Rzd.a)) {}
      for (String str1 = "0X8008994";; str1 = "0X800898D")
      {
        localscx.a(localArticleInfo, i, localFastWebActivity, str2, str1, this.jdField_a_of_type_Scw.a(this.jdField_a_of_type_Int));
        return;
      }
    }
    ybk.a(1, 2131689512);
    QLog.d("Q.readinjoy.fast_web", 2, "shareJson get false ! action : " + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.39.1
 * JD-Core Version:    0.7.0.1
 */