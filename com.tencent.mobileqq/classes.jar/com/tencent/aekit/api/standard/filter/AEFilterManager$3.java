package com.tencent.aekit.api.standard.filter;

import com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener;

class AEFilterManager$3
  implements LightNode.ILightNodeTipsListener
{
  AEFilterManager$3(AEFilterManager paramAEFilterManager) {}
  
  public void onHideNormalTip()
  {
    if (AEFilterManager.access$400(this.this$0) != null) {
      AEFilterManager.access$400(this.this$0).onHideNormalTip();
    }
  }
  
  public void onHidePagTip()
  {
    if (AEFilterManager.access$400(this.this$0) != null) {
      AEFilterManager.access$400(this.this$0).onHidePagTip();
    }
  }
  
  public void onShowNormalTip(String paramString1, String paramString2, int paramInt)
  {
    if (AEFilterManager.access$400(this.this$0) != null) {
      AEFilterManager.access$400(this.this$0).onShowNormalTip(paramString1, paramString2, paramInt);
    }
  }
  
  public void onShowPagTip(String paramString, int paramInt)
  {
    if (AEFilterManager.access$400(this.this$0) != null) {
      AEFilterManager.access$400(this.this$0).onShowPagTip(paramString, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEFilterManager.3
 * JD-Core Version:    0.7.0.1
 */