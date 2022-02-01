package com.tencent.biz.pubaccount.util.api.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.ActionSheet;

class PublicAccountH5AbilityPluginImpl$20
  implements View.OnClickListener
{
  PublicAccountH5AbilityPluginImpl$20(PublicAccountH5AbilityPluginImpl paramPublicAccountH5AbilityPluginImpl, int paramInt1, int paramInt2, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.d.choosePicture(this.a, this.b);
    paramView = this.d;
    paramView.cameraCallback = this.c;
    paramView.paActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.20
 * JD-Core Version:    0.7.0.1
 */