package com.tencent.aekit.api.standard.filter;

import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.ttpic.openapi.listener.LightNodeAppliedListener;

class AEFilterManager$2
  implements LightNodeAppliedListener
{
  AEFilterManager$2(AEFilterManager paramAEFilterManager) {}
  
  public void onLightNodeApplied()
  {
    AEFilterManager.access$002(this.this$0, AEFilterManager.access$200(this.this$0).getAudioReader());
    AEFilterManager.access$300(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEFilterManager.2
 * JD-Core Version:    0.7.0.1
 */