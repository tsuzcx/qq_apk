package com.tencent.mobileqq.apollo.process.chanel;

import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVVideoCtrl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.tmg_opensdk.AVManager;

class CmGameAvHandler$9
  implements Runnable
{
  CmGameAvHandler$9(CmGameAvHandler paramCmGameAvHandler, int paramInt, long paramLong) {}
  
  public void run()
  {
    AVManager.a(BaseApplicationImpl.getContext()).a().getVideoCtrl().switchCamera(this.jdField_a_of_type_Int, new CmGameAvHandler.9.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.9
 * JD-Core Version:    0.7.0.1
 */