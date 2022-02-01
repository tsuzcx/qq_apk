package com.tencent.av.utils;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.concurrent.ConcurrentHashMap;

public class VExtensionInfoManager
{
  private EntityManagerFactory a;
  private EntityManager b;
  private ConcurrentHashMap<String, Entity> c = new ConcurrentHashMap();
  
  public VExtensionInfoManager(VideoAppInterface paramVideoAppInterface)
  {
    this.a = paramVideoAppInterface.getEntityManagerFactory(paramVideoAppInterface.getCurrentAccountUin());
    this.b = this.a.createEntityManager();
  }
  
  public ExtensionInfo a(String paramString)
  {
    Object localObject = null;
    ExtensionInfo localExtensionInfo = null;
    if (paramString != null)
    {
      if ("".equals(paramString)) {
        return null;
      }
      ConcurrentHashMap localConcurrentHashMap = this.c;
      localObject = localExtensionInfo;
      if (localConcurrentHashMap != null) {
        localObject = (ExtensionInfo)localConcurrentHashMap.get(paramString);
      }
      if (localObject != null) {
        return localObject;
      }
      localExtensionInfo = (ExtensionInfo)this.b.find(ExtensionInfo.class, paramString);
      localObject = localExtensionInfo;
      if (localExtensionInfo != null)
      {
        localConcurrentHashMap = this.c;
        localObject = localExtensionInfo;
        if (localConcurrentHashMap != null) {
          try
          {
            this.c.put(paramString, localExtensionInfo);
            return localExtensionInfo;
          }
          finally {}
        }
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.VExtensionInfoManager
 * JD-Core Version:    0.7.0.1
 */