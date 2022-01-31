package com.tencent.mobileqq.apollo.process.chanel;

import akxb;
import alhb;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVVideoCtrl;
import com.tencent.common.app.BaseApplicationImpl;

public class CmGameAvHandler$13
  implements Runnable
{
  public CmGameAvHandler$13(akxb paramakxb, float paramFloat) {}
  
  public void run()
  {
    alhb.a(BaseApplicationImpl.getContext()).a().getVideoCtrl().inputBeautyParam(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.13
 * JD-Core Version:    0.7.0.1
 */