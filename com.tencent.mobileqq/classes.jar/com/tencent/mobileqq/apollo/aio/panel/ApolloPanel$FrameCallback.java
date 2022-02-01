package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloViewBinder;
import com.tencent.mobileqq.apollo.meme.GetFrameCallback;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class ApolloPanel$FrameCallback
  implements GetFrameCallback
{
  private List<ApolloViewBinder> a;
  private ApolloActionData b;
  
  public ApolloPanel$FrameCallback(List<ApolloViewBinder> paramList, ApolloActionData paramApolloActionData)
  {
    this.a = paramList;
    this.b = paramApolloActionData;
  }
  
  public void a(boolean paramBoolean, @Nullable String paramString, @Nullable MemeAction paramMemeAction)
  {
    paramString = new StringBuilder();
    paramString.append("ApolloPanel handleCMSPlayerGetFrame success : ");
    paramString.append(paramBoolean);
    paramString.append(" actionId: ");
    paramString.append(this.b.actionId);
    QLog.d("[cmshow]ApolloPanel", 1, paramString.toString());
    ThreadManager.getUIHandler().post(new ApolloPanel.FrameCallback.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.FrameCallback
 * JD-Core Version:    0.7.0.1
 */