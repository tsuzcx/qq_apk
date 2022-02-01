package com.tencent.biz.qqcircle.manager;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class QCircleTagFollowManager
{
  public static final String a = "QCircleTagFollowManager";
  private static volatile QCircleTagFollowManager b;
  private ConcurrentHashMap<String, Boolean> c = new ConcurrentHashMap();
  private List<SoftReference<QCircleTagFollowManager.OnFollowListener>> d = new LinkedList();
  
  public static QCircleTagFollowManager a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new QCircleTagFollowManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    ConcurrentHashMap localConcurrentHashMap = this.c;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.put(paramString, Boolean.valueOf(paramBoolean));
    }
  }
  
  public boolean a(String paramString)
  {
    return (paramString != null) && (this.c.containsKey(paramString));
  }
  
  public void b()
  {
    if (this.c != null)
    {
      QLog.i(a, 1, "clear all");
      this.c.clear();
    }
  }
  
  public boolean b(String paramString)
  {
    if (a(paramString))
    {
      paramString = (Boolean)this.c.get(paramString);
      if (paramString == null)
      {
        QLog.e(a, 1, "mTagFollowMap getValue tagId null");
        return false;
      }
      return paramString.booleanValue();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleTagFollowManager
 * JD-Core Version:    0.7.0.1
 */