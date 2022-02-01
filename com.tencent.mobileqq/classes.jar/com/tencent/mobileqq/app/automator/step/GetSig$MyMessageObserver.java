package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.MessageObserver;

class GetSig$MyMessageObserver
  extends MessageObserver
{
  private GetSig$MyMessageObserver(GetSig paramGetSig) {}
  
  protected void onUpdateSendGetSig(boolean paramBoolean)
  {
    GetSig localGetSig = this.a;
    int i;
    if (paramBoolean) {
      i = 7;
    } else {
      i = 6;
    }
    localGetSig.setResult(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSig.MyMessageObserver
 * JD-Core Version:    0.7.0.1
 */