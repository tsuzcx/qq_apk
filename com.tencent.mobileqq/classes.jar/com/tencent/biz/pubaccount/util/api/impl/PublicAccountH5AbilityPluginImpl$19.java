package com.tencent.biz.pubaccount.util.api.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.ActionSheet;

class PublicAccountH5AbilityPluginImpl$19
  implements View.OnClickListener
{
  PublicAccountH5AbilityPluginImpl$19(PublicAccountH5AbilityPluginImpl paramPublicAccountH5AbilityPluginImpl, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.b.takePicture();
    paramView = this.b;
    paramView.cameraCallback = this.a;
    paramView.paActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.19
 * JD-Core Version:    0.7.0.1
 */