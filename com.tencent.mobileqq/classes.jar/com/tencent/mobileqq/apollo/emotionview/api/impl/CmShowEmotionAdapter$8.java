package com.tencent.mobileqq.apollo.emotionview.api.impl;

import com.tencent.mobileqq.apollo.meme.GetFrameCallback;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

class CmShowEmotionAdapter$8
  implements GetFrameCallback
{
  CmShowEmotionAdapter$8(CmShowEmotionAdapter paramCmShowEmotionAdapter, ApolloLinearLayout.ViewHolder paramViewHolder, ApolloInfo paramApolloInfo) {}
  
  public void a(boolean paramBoolean, String paramString, @NotNull MemeAction paramMemeAction)
  {
    if (this.a != null) {
      ThreadManager.getUIHandler().post(new CmShowEmotionAdapter.8.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.api.impl.CmShowEmotionAdapter.8
 * JD-Core Version:    0.7.0.1
 */