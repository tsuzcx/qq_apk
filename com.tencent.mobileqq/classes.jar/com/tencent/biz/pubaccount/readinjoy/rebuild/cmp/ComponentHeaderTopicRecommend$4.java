package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.Ox978RespCallBack;
import com.tencent.mobileqq.app.ThreadManager;

class ComponentHeaderTopicRecommend$4
  implements UserOperationModule.Ox978RespCallBack
{
  ComponentHeaderTopicRecommend$4(ComponentHeaderTopicRecommend paramComponentHeaderTopicRecommend) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 2)) {
      ThreadManager.post(new ComponentHeaderTopicRecommend.4.1(this), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderTopicRecommend.4
 * JD-Core Version:    0.7.0.1
 */