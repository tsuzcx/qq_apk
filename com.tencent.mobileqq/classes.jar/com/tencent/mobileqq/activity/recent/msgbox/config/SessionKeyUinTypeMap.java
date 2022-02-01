package com.tencent.mobileqq.activity.recent.msgbox.config;

import android.util.SparseArray;

public class SessionKeyUinTypeMap
{
  public static SparseArray<SessionKey> a = new SparseArray();
  
  static
  {
    a.put(1000, new SessionKey(2, 0));
    a.put(1004, new SessionKey(2, 1));
    a.put(1006, new SessionKey(1, 130));
    a.put(1023, new SessionKey(1, 133));
    a.put(1022, new SessionKey(1, 134));
    a.put(10010, new SessionKey(1, 167));
    a.put(10007, new SessionKey(1, 164));
  }
  
  public static boolean a(int paramInt, SessionKey paramSessionKey)
  {
    SessionKey localSessionKey = (SessionKey)a.get(paramInt);
    if ((localSessionKey != null) && (paramSessionKey != null)) {
      return (localSessionKey.a == paramSessionKey.a) && (localSessionKey.b == paramSessionKey.b);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.config.SessionKeyUinTypeMap
 * JD-Core Version:    0.7.0.1
 */