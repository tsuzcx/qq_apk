package com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix;

import com.tencent.qphone.base.util.QLog;
import ooh;
import ooj;
import ooz;
import opa;
import opd;

public class RIJBiuAndCommentMixDataManager$1
  implements Runnable
{
  public RIJBiuAndCommentMixDataManager$1(ooz paramooz, opd paramopd, int paramInt) {}
  
  public void run()
  {
    if (ooz.a(this.this$0) != null)
    {
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "onBiuAndCommentMixSend callBack to mBiuAndCommentListener");
      ooz.a(this.this$0).a(this.jdField_a_of_type_Opd);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Opd.c() == 1))
      {
        ooj localooj = ooh.a(this.jdField_a_of_type_Opd, false);
        ooh.a().a(localooj);
      }
      return;
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "onBiuAndCommentMixSend dataManager is destory");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentMixDataManager.1
 * JD-Core Version:    0.7.0.1
 */