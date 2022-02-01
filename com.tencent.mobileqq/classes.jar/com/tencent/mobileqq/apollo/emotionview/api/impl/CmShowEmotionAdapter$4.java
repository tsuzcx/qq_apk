package com.tencent.mobileqq.apollo.emotionview.api.impl;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.OnSendListener;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;

class CmShowEmotionAdapter$4
  implements ApolloLinearLayout.OnSendListener
{
  CmShowEmotionAdapter$4(CmShowEmotionAdapter paramCmShowEmotionAdapter) {}
  
  public void a()
  {
    AIOEmoticonUIHelper localAIOEmoticonUIHelper = (AIOEmoticonUIHelper)CmShowEmotionAdapter.a(this.a).a(105);
    if (localAIOEmoticonUIHelper != null) {
      localAIOEmoticonUIHelper.c().onPullDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.api.impl.CmShowEmotionAdapter.4
 * JD-Core Version:    0.7.0.1
 */