package com.tencent.mobileqq.activity.recent.msgbox.config;

import android.util.SparseArray;

public class SessionKeyUinTypeMap
{
  public static SparseArray<SessionKey> a = new SparseArray();
  
  static
  {
    a.put(1000, new SessionKey(2, 0));
    a.put(1006, new SessionKey(1, 130));
    a.put(1005, new SessionKey(1, 201));
    a.put(1024, new SessionKey(1, 58));
    a.put(10007, new SessionKey(1, 164));
  }
  
  public static boolean a(int paramInt, SessionKey paramSessionKey)
  {
    SessionKey localSessionKey = (SessionKey)a.get(paramInt);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localSessionKey != null)
    {
      bool1 = bool2;
      if (paramSessionKey != null)
      {
        bool1 = bool2;
        if (localSessionKey.a == paramSessionKey.a)
        {
          bool1 = bool2;
          if (localSessionKey.b == paramSessionKey.b) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.config.SessionKeyUinTypeMap
 * JD-Core Version:    0.7.0.1
 */