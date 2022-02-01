package com.tencent.mobileqq.apollo.emotionview.api.impl;

import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.player.GetFrameCallback;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

class CmShowEmotionAdapter$6
  implements GetFrameCallback
{
  CmShowEmotionAdapter$6(CmShowEmotionAdapter paramCmShowEmotionAdapter, ApolloLinearLayout.ViewHolder paramViewHolder, ApolloInfo paramApolloInfo) {}
  
  public void a(boolean paramBoolean, String paramString, @NotNull CMSAction paramCMSAction)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$ViewHolder != null) {
      ThreadManager.getUIHandler().post(new CmShowEmotionAdapter.6.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.api.impl.CmShowEmotionAdapter.6
 * JD-Core Version:    0.7.0.1
 */