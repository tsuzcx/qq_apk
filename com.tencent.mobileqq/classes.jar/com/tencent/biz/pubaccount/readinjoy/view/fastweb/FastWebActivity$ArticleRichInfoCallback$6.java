package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import tfu;

public class FastWebActivity$ArticleRichInfoCallback$6
  implements Runnable
{
  public FastWebActivity$ArticleRichInfoCallback$6(tfu paramtfu, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || (FastWebActivity.a(this.jdField_a_of_type_Tfu.a) == null) || (!this.jdField_a_of_type_JavaLangString.equals(FastWebActivity.a(this.jdField_a_of_type_Tfu.a).j)))
    {
      QLog.d("FastWebActivity", 2, "handleRefreshList, msg not match !" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    FastWebActivity.d(this.jdField_a_of_type_Tfu.a);
    QLog.d("FastWebActivity", 2, "get article topic info success! notify ui bindData");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.ArticleRichInfoCallback.6
 * JD-Core Version:    0.7.0.1
 */