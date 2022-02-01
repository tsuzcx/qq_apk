package com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix;

import com.tencent.qphone.base.util.QLog;
import omw;
import omy;
import ono;
import onp;
import ons;

public class RIJBiuAndCommentMixDataManager$1
  implements Runnable
{
  public RIJBiuAndCommentMixDataManager$1(ono paramono, ons paramons, int paramInt) {}
  
  public void run()
  {
    if (ono.a(this.this$0) != null)
    {
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "onBiuAndCommentMixSend callBack to mBiuAndCommentListener");
      ono.a(this.this$0).a(this.jdField_a_of_type_Ons);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Ons.c() == 1))
      {
        omy localomy = omw.a(this.jdField_a_of_type_Ons, false);
        omw.a().a(localomy);
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