package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.meme.GetFrameCallback;
import com.tencent.mobileqq.apollo.meme.MemeHelper;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.meme.action.MemePanelAction;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;

class ApolloManagerServiceImpl$8
  implements Runnable
{
  ApolloManagerServiceImpl$8(ApolloManagerServiceImpl paramApolloManagerServiceImpl, ApolloActionData paramApolloActionData, IApolloResManager paramIApolloResManager, GetFrameCallback paramGetFrameCallback) {}
  
  public void run()
  {
    if (ApolloManagerServiceImpl.access$1600(this.this$0).contains(Integer.valueOf(this.a.actionId)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleMemeGetFrame has get, return,");
      ((StringBuilder)localObject).append(this.a.actionId);
      QLog.d("[cmshow]ApolloManager", 1, ((StringBuilder)localObject).toString());
      return;
    }
    ApolloManagerServiceImpl.access$1600(this.this$0).add(Integer.valueOf(this.a.actionId));
    Object localObject = this.b;
    if ((localObject != null) && (((IApolloResManager)localObject).c(this.a)))
    {
      localObject = this.c;
      if (localObject != null) {
        ((GetFrameCallback)localObject).a(true, null, null);
      }
    }
    else
    {
      localObject = ApolloManagerServiceImpl.access$200(this.this$0);
      if (localObject == null)
      {
        QLog.e("[cmshow]ApolloManager", 1, "handleMemeGetFrame getFrameImage error, appInterface is null!");
        return;
      }
      localObject = ((AppInterface)localObject).getAccount();
      localObject = new MemePanelAction(this.a, (String)localObject);
      ApolloManagerServiceImpl.FrameCallback localFrameCallback = new ApolloManagerServiceImpl.FrameCallback(this.this$0, this.a, this.c, this.b);
      ApolloManagerServiceImpl.access$1700().put(localObject, localFrameCallback);
      MemeHelper.a.a((MemeAction)localObject, ApolloManagerServiceImpl.access$1800(this.this$0), localFrameCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.8
 * JD-Core Version:    0.7.0.1
 */