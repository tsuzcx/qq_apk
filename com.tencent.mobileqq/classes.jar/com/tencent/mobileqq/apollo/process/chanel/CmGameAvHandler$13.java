package com.tencent.mobileqq.apollo.process.chanel;

import aksm;
import alcm;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVVideoCtrl;
import com.tencent.common.app.BaseApplicationImpl;

public class CmGameAvHandler$13
  implements Runnable
{
  public CmGameAvHandler$13(aksm paramaksm, float paramFloat) {}
  
  public void run()
  {
    alcm.a(BaseApplicationImpl.getContext()).a().getVideoCtrl().inputBeautyParam(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.13
 * JD-Core Version:    0.7.0.1
 */