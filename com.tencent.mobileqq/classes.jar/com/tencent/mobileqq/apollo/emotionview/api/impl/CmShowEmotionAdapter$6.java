package com.tencent.mobileqq.apollo.emotionview.api.impl;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.OnSendListener;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;

class CmShowEmotionAdapter$6
  implements ApolloLinearLayout.OnSendListener
{
  CmShowEmotionAdapter$6(CmShowEmotionAdapter paramCmShowEmotionAdapter) {}
  
  public void a()
  {
    AIOEmoticonUIHelper localAIOEmoticonUIHelper = (AIOEmoticonUIHelper)CmShowEmotionAdapter.f(this.a).q(105);
    if (localAIOEmoticonUIHelper != null) {
      localAIOEmoticonUIHelper.j().onPullDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.api.impl.CmShowEmotionAdapter.6
 * JD-Core Version:    0.7.0.1
 */