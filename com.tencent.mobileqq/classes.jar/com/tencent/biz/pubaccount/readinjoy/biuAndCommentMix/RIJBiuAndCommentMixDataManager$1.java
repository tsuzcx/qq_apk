package com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix;

import com.tencent.qphone.base.util.QLog;
import owf;
import owh;
import owx;
import owy;
import oxb;

public class RIJBiuAndCommentMixDataManager$1
  implements Runnable
{
  public RIJBiuAndCommentMixDataManager$1(owx paramowx, oxb paramoxb, int paramInt) {}
  
  public void run()
  {
    if (owx.a(this.this$0) != null)
    {
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "onBiuAndCommentMixSend callBack to mBiuAndCommentListener");
      owx.a(this.this$0).a(this.jdField_a_of_type_Oxb);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Oxb.c() == 1))
      {
        owh localowh = owf.a(this.jdField_a_of_type_Oxb, false);
        owf.a().a(localowh);
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