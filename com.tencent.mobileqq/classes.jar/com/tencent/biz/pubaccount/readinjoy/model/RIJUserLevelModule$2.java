package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RIJUserLevelDialog.DialogClick;

class RIJUserLevelModule$2
  implements RIJUserLevelDialog.DialogClick
{
  RIJUserLevelModule$2(RIJUserLevelModule paramRIJUserLevelModule, Context paramContext, RIJUserLevelRequestModule.UserLevelInfo paramUserLevelInfo) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUserLevelRequestModule$UserLevelInfo.jumpUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule.2
 * JD-Core Version:    0.7.0.1
 */