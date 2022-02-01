package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import sxd;

public class FastWebActivity$42$3
  implements Runnable
{
  public FastWebActivity$42$3(sxd paramsxd, long paramLong) {}
  
  public void run()
  {
    QLog.d("FastWebActivity", 2, " update biuView cnt : " + this.jdField_a_of_type_Long);
    if (FastWebActivity.a(this.jdField_a_of_type_Sxd.a) != null) {
      FastWebActivity.a(this.jdField_a_of_type_Sxd.a).a(FastWebActivity.a(this.jdField_a_of_type_Sxd.a).c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.42.3
 * JD-Core Version:    0.7.0.1
 */