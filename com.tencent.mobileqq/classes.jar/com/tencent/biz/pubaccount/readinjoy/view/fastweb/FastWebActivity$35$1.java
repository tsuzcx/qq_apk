package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import snx;
import ssh;
import ssi;
import zyx;

public class FastWebActivity$35$1
  implements Runnable
{
  public FastWebActivity$35$1(snx paramsnx, boolean paramBoolean, int paramInt, String paramString, ssh paramssh) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      ssi localssi = FastWebActivity.a(this.jdField_a_of_type_Snx.a);
      ArticleInfo localArticleInfo = this.jdField_a_of_type_Snx.a.a;
      int i = this.jdField_a_of_type_Int;
      FastWebActivity localFastWebActivity = this.jdField_a_of_type_Snx.a;
      String str2 = this.jdField_a_of_type_JavaLangString;
      if (FastWebActivity.b(this.jdField_a_of_type_Snx.a)) {}
      for (String str1 = "0X8008994";; str1 = "0X800898D")
      {
        localssi.a(localArticleInfo, i, localFastWebActivity, str2, str1, this.jdField_a_of_type_Ssh.a(this.jdField_a_of_type_Int), FastWebActivity.a(this.jdField_a_of_type_Snx.a), FastWebActivity.h(this.jdField_a_of_type_Snx.a), FastWebActivity.b(this.jdField_a_of_type_Snx.a));
        return;
      }
    }
    zyx.a(1, 2131689486);
    QLog.d("Q.readinjoy.fast_web", 2, "shareJson get false ! action : " + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.35.1
 * JD-Core Version:    0.7.0.1
 */