package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import tfu;
import tjs;
import tjt;
import znl;

public class FastWebActivity$ArticleRichInfoCallback$1
  implements Runnable
{
  public FastWebActivity$ArticleRichInfoCallback$1(tfu paramtfu, boolean paramBoolean, tjs paramtjs, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Tjs != null))
    {
      tjt localtjt = FastWebActivity.a(this.jdField_a_of_type_Tfu.a);
      ArticleInfo localArticleInfo = this.jdField_a_of_type_Tfu.a.a;
      int i = this.jdField_a_of_type_Int;
      FastWebActivity localFastWebActivity = this.jdField_a_of_type_Tfu.a;
      String str2 = this.jdField_a_of_type_JavaLangString;
      if (FastWebActivity.b(this.jdField_a_of_type_Tfu.a)) {}
      for (String str1 = "0X8008994";; str1 = "0X800898D")
      {
        localtjt.a(localArticleInfo, i, localFastWebActivity, str2, str1, this.jdField_a_of_type_Tjs.a(this.jdField_a_of_type_Int), FastWebActivity.a(this.jdField_a_of_type_Tfu.a), FastWebActivity.i(this.jdField_a_of_type_Tfu.a), FastWebActivity.b(this.jdField_a_of_type_Tfu.a));
        return;
      }
    }
    znl.a(1, 2131689486);
    QLog.d("Q.readinjoy.fast_web", 2, "shareJson get false ! action : " + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.ArticleRichInfoCallback.1
 * JD-Core Version:    0.7.0.1
 */