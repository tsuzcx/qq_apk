package com.tencent.avgame.session;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class AVGameSessionManager
{
  private final Map<String, AVGameSession> a = new HashMap(3);
  private AVGameSession b = null;
  
  public AVGameSession a()
  {
    return this.b;
  }
  
  public AVGameSession a(int paramInt, String paramString, boolean paramBoolean)
  {
    AVGameSession localAVGameSession1;
    if (!TextUtils.isEmpty(paramString))
    {
      AVGameSession localAVGameSession2 = (AVGameSession)this.a.get(paramString);
      localAVGameSession1 = localAVGameSession2;
      if (localAVGameSession2 == null)
      {
        localAVGameSession2 = new AVGameSession(paramInt, paramString);
        this.a.put(paramString, localAVGameSession2);
        if (this.a.size() != 1)
        {
          localAVGameSession1 = localAVGameSession2;
          if (!paramBoolean) {}
        }
        else
        {
          c(paramString);
          return localAVGameSession2;
        }
      }
    }
    else
    {
      localAVGameSession1 = null;
    }
    return localAVGameSession1;
  }
  
  public AVGameSession a(String paramString)
  {
    if (!this.a.isEmpty()) {
      return (AVGameSession)this.a.get(paramString);
    }
    return null;
  }
  
  public AVGameSession b(String paramString)
  {
    if (!this.a.isEmpty())
    {
      AVGameSession localAVGameSession1 = (AVGameSession)this.a.remove(paramString);
      paramString = localAVGameSession1;
      if (localAVGameSession1 != null)
      {
        AVGameSession localAVGameSession2 = this.b;
        paramString = localAVGameSession1;
        if (localAVGameSession1 == localAVGameSession2)
        {
          localAVGameSession2.c = false;
          this.b = null;
          return localAVGameSession1;
        }
      }
    }
    else
    {
      paramString = null;
    }
    return paramString;
  }
  
  public void c(String paramString)
  {
    paramString = a(paramString);
    if ((paramString != null) && (!paramString.c))
    {
      AVGameSession localAVGameSession = this.b;
      if (localAVGameSession != null) {
        localAVGameSession.c = false;
      }
      paramString.c = true;
      this.b = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.session.AVGameSessionManager
 * JD-Core Version:    0.7.0.1
 */