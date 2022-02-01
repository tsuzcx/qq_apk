package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.ThreadManager;

class KandianSubscribeManager$2
  extends MessageObserver
{
  KandianSubscribeManager$2(KandianSubscribeManager paramKandianSubscribeManager) {}
  
  public void onGetPAMsgFin(boolean paramBoolean)
  {
    super.onGetPAMsgFin(paramBoolean);
    ThreadManager.executeOnSubThread(new KandianSubscribeManager.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager.2
 * JD-Core Version:    0.7.0.1
 */