package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import java.util.Map;

class ProteusParserWithHotReload$1
  implements ProteusParser.HasDynamicDataCallback
{
  ProteusParserWithHotReload$1(ProteusParserWithHotReload paramProteusParserWithHotReload, ViewBean paramViewBean, String paramString, Object paramObject, Map paramMap) {}
  
  public void onCallBack(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.val$viewBean.valueBean.putAttributeDynamicValue(this.val$key, this.val$valueObj);
      this.val$templateGlobalVar.putAll(this.this$0.getTemplateGlobalVarKey(this.val$valueObj));
      return;
    }
    this.val$viewBean.valueBean.putNomalValue(this.val$key, this.val$valueObj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload.1
 * JD-Core Version:    0.7.0.1
 */