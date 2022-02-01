package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.tipmessage;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.MessageObserver;
import com.tencent.mobileqq.data.MessageRecord;

class RIJTipMessageManager$1
  implements KandianMergeManager.MessageObserver
{
  RIJTipMessageManager$1(RIJTipMessageManager paramRIJTipMessageManager) {}
  
  public void a(MessageRecord paramMessageRecord) {}
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    RIJTipMessageManager.a(this.a).a().runOnUiThread(new RIJTipMessageManager.1.2(this));
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    RIJTipMessageManager.a(this.a).a().runOnUiThread(new RIJTipMessageManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.tipmessage.RIJTipMessageManager.1
 * JD-Core Version:    0.7.0.1
 */