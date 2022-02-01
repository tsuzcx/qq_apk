package com.tencent.av.wtogether.util;

import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ChooseFileAssistant
{
  private static ChooseFileAssistant a;
  private final HashMap<String, ChooseFileAssistant.ChatInfo> b = new HashMap(2);
  
  public static ChooseFileAssistant a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ChooseFileAssistant();
        }
      }
      finally {}
    }
    return a;
  }
  
  public ChooseFileInfo a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    paramString = (ChooseFileAssistant.ChatInfo)this.b.get(paramString);
    if (paramString != null) {
      return paramString.d;
    }
    return null;
  }
  
  public void a(int paramInt, String paramString, ChooseFileInfo paramChooseFileInfo)
  {
    a(paramInt, paramString, paramChooseFileInfo, null);
  }
  
  public void a(int paramInt, String paramString, ChooseFileInfo paramChooseFileInfo, SessionInfo paramSessionInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    ChooseFileAssistant.ChatInfo localChatInfo = (ChooseFileAssistant.ChatInfo)this.b.get(localObject);
    if (localChatInfo != null)
    {
      localChatInfo.d = paramChooseFileInfo;
    }
    else
    {
      localChatInfo = new ChooseFileAssistant.ChatInfo(null);
      localChatInfo.d = paramChooseFileInfo;
      if (paramSessionInfo != null)
      {
        localChatInfo.a = paramSessionInfo.a;
        localChatInfo.b = paramSessionInfo.b;
        localChatInfo.c = paramSessionInfo;
      }
      this.b.put(localObject, localChatInfo);
    }
    if (QLog.isDevelopLevel())
    {
      paramSessionInfo = new StringBuilder();
      paramSessionInfo.append("onChooseFile, uinType[");
      paramSessionInfo.append(paramInt);
      paramSessionInfo.append("], uin[");
      paramSessionInfo.append(paramString);
      paramSessionInfo.append("], file[");
      paramSessionInfo.append(paramChooseFileInfo);
      paramSessionInfo.append("]");
      QLog.i("WTogether.ChooseFileAssistant", 4, paramSessionInfo.toString());
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramSessionInfo.a);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramSessionInfo.b);
    localObject = ((StringBuilder)localObject).toString();
    ChooseFileAssistant.ChatInfo localChatInfo = new ChooseFileAssistant.ChatInfo(null);
    localChatInfo.a = paramSessionInfo.a;
    localChatInfo.b = paramSessionInfo.b;
    localChatInfo.d = null;
    localChatInfo.c = paramSessionInfo;
    this.b.put(localObject, localChatInfo);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClickQavWatchTogether, chat[");
      ((StringBuilder)localObject).append(paramSessionInfo);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.ChooseFileAssistant", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    this.b.put(localObject, null);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("endOfStartWatchTogether, uinType[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], uin[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.ChooseFileAssistant", 4, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.util.ChooseFileAssistant
 * JD-Core Version:    0.7.0.1
 */