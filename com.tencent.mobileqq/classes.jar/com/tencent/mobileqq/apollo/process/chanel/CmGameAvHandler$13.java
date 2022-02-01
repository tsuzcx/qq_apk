package com.tencent.mobileqq.apollo.process.chanel;

import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVVideoCtrl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.tmg_opensdk.AVManager;

class CmGameAvHandler$13
  implements Runnable
{
  CmGameAvHandler$13(CmGameAvHandler paramCmGameAvHandler, float paramFloat) {}
  
  public void run()
  {
    AVManager.a(BaseApplicationImpl.getContext()).a().getVideoCtrl().inputBeautyParam(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.13
 * JD-Core Version:    0.7.0.1
 */