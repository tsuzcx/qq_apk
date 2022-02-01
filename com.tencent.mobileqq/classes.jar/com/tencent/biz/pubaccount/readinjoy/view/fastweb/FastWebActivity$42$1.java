package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import sxd;
import tbl;
import tbm;
import zvc;

public class FastWebActivity$42$1
  implements Runnable
{
  public FastWebActivity$42$1(sxd paramsxd, boolean paramBoolean, int paramInt, String paramString, tbl paramtbl) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      tbm localtbm = FastWebActivity.a(this.jdField_a_of_type_Sxd.a);
      ArticleInfo localArticleInfo = this.jdField_a_of_type_Sxd.a.a;
      int i = this.jdField_a_of_type_Int;
      FastWebActivity localFastWebActivity = this.jdField_a_of_type_Sxd.a;
      String str2 = this.jdField_a_of_type_JavaLangString;
      if (FastWebActivity.d(this.jdField_a_of_type_Sxd.a)) {}
      for (String str1 = "0X8008994";; str1 = "0X800898D")
      {
        localtbm.a(localArticleInfo, i, localFastWebActivity, str2, str1, this.jdField_a_of_type_Tbl.a(this.jdField_a_of_type_Int), FastWebActivity.c(this.jdField_a_of_type_Sxd.a), FastWebActivity.i(this.jdField_a_of_type_Sxd.a), FastWebActivity.d(this.jdField_a_of_type_Sxd.a));
        return;
      }
    }
    zvc.a(1, 2131689486);
    QLog.d("Q.readinjoy.fast_web", 2, "shareJson get false ! action : " + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.42.1
 * JD-Core Version:    0.7.0.1
 */