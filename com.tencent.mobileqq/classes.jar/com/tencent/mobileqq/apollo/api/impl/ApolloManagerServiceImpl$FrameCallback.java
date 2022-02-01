package com.tencent.mobileqq.apollo.api.impl;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.meme.GetFrameCallback;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

public class ApolloManagerServiceImpl$FrameCallback
  implements GetFrameCallback
{
  private ApolloActionData b;
  private GetFrameCallback c;
  private IApolloResManager d;
  
  public ApolloManagerServiceImpl$FrameCallback(ApolloManagerServiceImpl paramApolloManagerServiceImpl, ApolloActionData paramApolloActionData, GetFrameCallback paramGetFrameCallback, IApolloResManager paramIApolloResManager)
  {
    this.b = paramApolloActionData;
    this.c = paramGetFrameCallback;
    this.d = paramIApolloResManager;
  }
  
  public void a(boolean paramBoolean, @Nullable String paramString, @Nullable MemeAction paramMemeAction)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleMemeGetFrame onComplete success:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", action:");
    ((StringBuilder)localObject).append(paramMemeAction.h());
    ((StringBuilder)localObject).append(", path:");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("[cmshow]ApolloManager", 1, ((StringBuilder)localObject).toString());
    ApolloManagerServiceImpl.access$1700().remove(paramMemeAction);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))
    {
      if (FileUtils.copyFile(paramString, this.d.a(this.b, 10)))
      {
        localObject = this.c;
        if (localObject != null) {
          ((GetFrameCallback)localObject).a(true, paramString, paramMemeAction);
        }
        return;
      }
      QLog.d("[cmshow]ApolloManager", 1, "handleMemeGetFrame copyFile failed.");
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleMemeGetFrame file not exists:");
      ((StringBuilder)localObject).append(paramString);
      QLog.w("[cmshow]ApolloManager", 1, ((StringBuilder)localObject).toString());
    }
    ApolloManagerServiceImpl.access$1600(this.a).remove(Integer.valueOf(this.b.actionId));
    localObject = this.c;
    if (localObject != null) {
      ((GetFrameCallback)localObject).a(false, paramString, paramMemeAction);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.FrameCallback
 * JD-Core Version:    0.7.0.1
 */