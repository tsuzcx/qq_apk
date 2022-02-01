package com.tencent.mobileqq.apollo.view;

import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.GetFrameCallback;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;

public class ApolloDrawerInfoViewListener$FrameCallback
  implements GetFrameCallback
{
  private ApolloActionData a;
  
  public ApolloDrawerInfoViewListener$FrameCallback(ApolloActionData paramApolloActionData)
  {
    this.a = paramApolloActionData;
  }
  
  public void a(boolean paramBoolean, @Nullable String paramString, @Nullable CMSAction paramCMSAction)
  {
    QLog.d("ApolloDrawerInfoViewListener", 1, " handleCMSPlayerGetFrame success : " + paramBoolean);
    if (paramBoolean) {
      QLog.d("ApolloDrawerInfoViewListener", 1, " handleCMSPlayerGetFrame updateItemStatus : " + this.a.actionId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloDrawerInfoViewListener.FrameCallback
 * JD-Core Version:    0.7.0.1
 */