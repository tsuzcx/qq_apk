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
    this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl.choosePicture(this.jdField_a_of_type_Int, this.b);
    paramView = this.jdField_a_of_type_ComTencentBizPubaccountUtilApiImplPublicAccountH5AbilityPluginImpl;
    paramView.cameraCallback = this.jdField_a_of_type_JavaLangString;
    paramView.paActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.20
 * JD-Core Version:    0.7.0.1
 */