package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import rje;
import rjs;

public class FastWebActivity$33$6
  implements Runnable
{
  public FastWebActivity$33$6(rje paramrje, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || (FastWebActivity.a(this.jdField_a_of_type_Rje.a) == null) || (!this.jdField_a_of_type_JavaLangString.equals(FastWebActivity.a(this.jdField_a_of_type_Rje.a).j)))
    {
      QLog.d(FastWebActivity.a(this.jdField_a_of_type_Rje.a), 2, "handleRefreshList, msg not match !" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    FastWebActivity.a(this.jdField_a_of_type_Rje.a).notifyDataSetChanged();
    QLog.d(FastWebActivity.a(this.jdField_a_of_type_Rje.a), 2, "get article topic info success! notify ui bindData");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.33.6
 * JD-Core Version:    0.7.0.1
 */