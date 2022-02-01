package com.tencent.mobileqq.apollo.process.chanel;

import com.tencent.mobileqq.apollo.tmg_opensdk.AVEngineWalper;

class CmGameAvHandler$5
  implements Runnable
{
  CmGameAvHandler$5(CmGameAvHandler paramCmGameAvHandler, boolean paramBoolean) {}
  
  public void run()
  {
    CmGameAvHandler.a(this.this$0, this.a);
    if (this.a) {
      AVEngineWalper.a().c();
    }
    AVEngineWalper.a().a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.5
 * JD-Core Version:    0.7.0.1
 */