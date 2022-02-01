package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import java.util.ArrayList;

class ProteusParser$3
  implements ProteusParser.HasDynamicDataCallback
{
  ProteusParser$3(ProteusParser paramProteusParser, ViewBean paramViewBean, String paramString, Object paramObject, ArrayList paramArrayList) {}
  
  public void onCallBack(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.val$viewBean.valueBean.putDataAttributeDynamicValue(this.val$key, this.val$valueObj);
      this.val$dollarNames.addAll(this.this$0.getDollarName(this.val$valueObj));
      return;
    }
    this.val$viewBean.valueBean.putDataAttributeLocalData(this.val$key, this.val$valueObj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser.3
 * JD-Core Version:    0.7.0.1
 */