package com.tencent.mobileqq.apollo.view;

import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.player.GetFrameCallback;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
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
    paramString = new StringBuilder();
    paramString.append(" handleCMSPlayerGetFrame success : ");
    paramString.append(paramBoolean);
    QLog.d("[cmshow]ApolloDrawerInfoViewListener", 1, paramString.toString());
    if (paramBoolean)
    {
      paramString = new StringBuilder();
      paramString.append(" handleCMSPlayerGetFrame updateItemStatus : ");
      paramString.append(this.a.actionId);
      QLog.d("[cmshow]ApolloDrawerInfoViewListener", 1, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloDrawerInfoViewListener.FrameCallback
 * JD-Core Version:    0.7.0.1
 */