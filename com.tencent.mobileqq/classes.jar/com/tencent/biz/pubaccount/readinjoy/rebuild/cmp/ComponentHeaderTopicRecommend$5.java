package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.Ox978RespCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

class ComponentHeaderTopicRecommend$5
  implements UserOperationModule.Ox978RespCallBack
{
  ComponentHeaderTopicRecommend$5(ComponentHeaderTopicRecommend paramComponentHeaderTopicRecommend) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 1)) {
      ReadInJoyLogicEngine.a().a((int)ComponentHeaderTopicRecommend.a(this.a).businessId, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderTopicRecommend.5
 * JD-Core Version:    0.7.0.1
 */