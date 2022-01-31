package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import qwo;

public class FastWebActivity$30$3
  implements Runnable
{
  public FastWebActivity$30$3(qwo paramqwo, long paramLong) {}
  
  public void run()
  {
    QLog.d(FastWebActivity.a(this.jdField_a_of_type_Qwo.a), 2, " update biuView cnt : " + this.jdField_a_of_type_Long);
    if (FastWebActivity.a(this.jdField_a_of_type_Qwo.a) != null) {
      FastWebActivity.a(this.jdField_a_of_type_Qwo.a).b(FastWebActivity.a(this.jdField_a_of_type_Qwo.a).c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.30.3
 * JD-Core Version:    0.7.0.1
 */