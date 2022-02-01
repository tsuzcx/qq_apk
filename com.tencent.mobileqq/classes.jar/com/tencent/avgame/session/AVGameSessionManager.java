package com.tencent.avgame.session;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class AVGameSessionManager
{
  private AVGameSession jdField_a_of_type_ComTencentAvgameSessionAVGameSession = null;
  private final Map<String, AVGameSession> jdField_a_of_type_JavaUtilMap = new HashMap(3);
  
  public AVGameSession a()
  {
    return this.jdField_a_of_type_ComTencentAvgameSessionAVGameSession;
  }
  
  public AVGameSession a(int paramInt, String paramString, boolean paramBoolean)
  {
    AVGameSession localAVGameSession1;
    if (!TextUtils.isEmpty(paramString))
    {
      AVGameSession localAVGameSession2 = (AVGameSession)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      localAVGameSession1 = localAVGameSession2;
      if (localAVGameSession2 == null)
      {
        localAVGameSession2 = new AVGameSession(paramInt, paramString);
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localAVGameSession2);
        if (this.jdField_a_of_type_JavaUtilMap.size() != 1)
        {
          localAVGameSession1 = localAVGameSession2;
          if (!paramBoolean) {}
        }
        else
        {
          a(paramString);
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
    if (!this.jdField_a_of_type_JavaUtilMap.isEmpty()) {
      return (AVGameSession)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    return null;
  }
  
  public void a(String paramString)
  {
    paramString = a(paramString);
    if ((paramString != null) && (!paramString.a))
    {
      AVGameSession localAVGameSession = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSession;
      if (localAVGameSession != null) {
        localAVGameSession.a = false;
      }
      paramString.a = true;
      this.jdField_a_of_type_ComTencentAvgameSessionAVGameSession = paramString;
    }
  }
  
  public AVGameSession b(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      AVGameSession localAVGameSession1 = (AVGameSession)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      paramString = localAVGameSession1;
      if (localAVGameSession1 != null)
      {
        AVGameSession localAVGameSession2 = this.jdField_a_of_type_ComTencentAvgameSessionAVGameSession;
        paramString = localAVGameSession1;
        if (localAVGameSession1 == localAVGameSession2)
        {
          localAVGameSession2.a = false;
          this.jdField_a_of_type_ComTencentAvgameSessionAVGameSession = null;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.session.AVGameSessionManager
 * JD-Core Version:    0.7.0.1
 */