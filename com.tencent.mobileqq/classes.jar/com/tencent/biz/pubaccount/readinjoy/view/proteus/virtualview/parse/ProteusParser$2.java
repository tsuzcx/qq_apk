package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;

class ProteusParser$2
  implements ProteusParser.HasDynamicDataCallback
{
  ProteusParser$2(ProteusParser paramProteusParser, ViewBean paramViewBean, Object paramObject) {}
  
  public void onCallBack(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.val$viewBean.valueBean.putDataAttributeDynamicValue("$setRemoteInfo:", this.val$value);
      return;
    }
    this.val$viewBean.valueBean.putDataAttributeLocalData("$setRemoteInfo:", this.val$value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser.2
 * JD-Core Version:    0.7.0.1
 */