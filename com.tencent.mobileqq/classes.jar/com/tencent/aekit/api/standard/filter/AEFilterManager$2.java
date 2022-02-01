package com.tencent.aekit.api.standard.filter;

import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.ttpic.openapi.listener.LightNodeAppliedListener;

class AEFilterManager$2
  implements LightNodeAppliedListener
{
  AEFilterManager$2(AEFilterManager paramAEFilterManager) {}
  
  public void onLightNodeApplied()
  {
    AEFilterManager localAEFilterManager = this.this$0;
    AEFilterManager.access$002(localAEFilterManager, AEFilterManager.access$300(localAEFilterManager).getAudioReader());
    AEFilterManager.access$400(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEFilterManager.2
 * JD-Core Version:    0.7.0.1
 */