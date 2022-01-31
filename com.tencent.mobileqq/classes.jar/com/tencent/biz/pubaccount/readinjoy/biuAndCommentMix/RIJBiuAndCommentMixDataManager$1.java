package com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix;

import com.tencent.qphone.base.util.QLog;
import ohs;
import ohu;
import oik;
import oil;
import oio;

public class RIJBiuAndCommentMixDataManager$1
  implements Runnable
{
  public RIJBiuAndCommentMixDataManager$1(oik paramoik, oio paramoio, int paramInt) {}
  
  public void run()
  {
    if (oik.a(this.this$0) != null)
    {
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "onBiuAndCommentMixSend callBack to mBiuAndCommentListener");
      oik.a(this.this$0).a(this.jdField_a_of_type_Oio);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Oio.c() == 1))
      {
        ohu localohu = ohs.a(this.jdField_a_of_type_Oio, false);
        ohs.a().a(localohu);
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