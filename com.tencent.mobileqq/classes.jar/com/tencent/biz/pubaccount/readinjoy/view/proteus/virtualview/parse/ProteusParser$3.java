package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import java.util.Map;

class ProteusParser$3
  implements ProteusParser.HasDynamicDataCallback
{
  ProteusParser$3(ProteusParser paramProteusParser, ViewBean paramViewBean, String paramString, Object paramObject, Map paramMap) {}
  
  public void onCallBack(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.val$viewBean.valueBean.putDataAttributeDynamicValue(this.val$key, this.val$valueObj);
      this.val$templateGlobalVar.putAll(this.this$0.getTemplateGlobalVarKey(this.val$valueObj));
      return;
    }
    this.val$viewBean.valueBean.putDataAttributeLocalData(this.val$key, this.val$valueObj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser.3
 * JD-Core Version:    0.7.0.1
 */