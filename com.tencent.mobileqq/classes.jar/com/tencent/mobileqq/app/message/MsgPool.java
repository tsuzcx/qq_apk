package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.app.msgcache.CacheConstants;
import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class MsgPool
{
  private static ConcurrentHashMap d = new ConcurrentHashMap();
  private MsgLruCache a;
  protected ConcurrentHashMap a;
  private ConcurrentHashMap b = new ConcurrentHashMap();
  private ConcurrentHashMap c = new ConcurrentHashMap();
  
  private MsgPool()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppMsgcacheMsgLruCache = new MsgLruCache();
  }
  
  public static MsgPool a(String paramString)
  {
    Object localObject = paramString;
    if (paramString == null)
    {
      paramString = "null";
      localObject = paramString;
      if (QLog.isColorLevel())
      {
        QLog.e("MsgPool", 2, "getPoolInstance curUin is null");
        localObject = paramString;
      }
    }
    paramString = null;
    if (!d.containsKey(localObject)) {}
    for (;;)
    {
      synchronized (d)
      {
        if (!d.containsKey(localObject))
        {
          paramString = new MsgPool();
          d.put(localObject, paramString);
        }
        localObject = (MsgPool)d.get(localObject);
        if (localObject == null) {
          return paramString;
        }
      }
      return localObject;
      paramString = null;
    }
  }
  
  public static void a(String paramString)
  {
    String str = paramString;
    if (paramString == null)
    {
      paramString = "null";
      str = paramString;
      if (QLog.isColorLevel())
      {
        QLog.e("MsgPool", 2, "getPoolInstance curUin is null");
        str = paramString;
      }
    }
    if (d.containsKey(str)) {
      ((MsgPool)d.remove(str)).a().destroy();
    }
  }
  
  public MsgLruCache a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMsgcacheMsgLruCache;
  }
  
  public Object a(String arg1, int paramInt)
  {
    String str = MsgProxyUtils.a(???, paramInt);
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {}
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, new Object());
      }
      return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
    }
  }
  
  public ConcurrentHashMap a()
  {
    if (CacheConstants.a) {
      return this.jdField_a_of_type_ComTencentMobileqqAppMsgcacheMsgLruCache;
    }
    return this.b;
  }
  
  public ConcurrentHashMap b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.MsgPool
 * JD-Core Version:    0.7.0.1
 */