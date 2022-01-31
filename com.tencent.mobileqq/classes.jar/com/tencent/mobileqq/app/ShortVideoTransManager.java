package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.ShortVideoUpInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import mqq.manager.Manager;

public class ShortVideoTransManager
  implements Manager
{
  private EntityManager a;
  
  public ShortVideoTransManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  public ShortVideoUpInfo a(String paramString)
  {
    return (ShortVideoUpInfo)this.a.a(ShortVideoUpInfo.class, paramString);
  }
  
  public void a(ShortVideoUpInfo paramShortVideoUpInfo)
  {
    ShortVideoUpInfo localShortVideoUpInfo = (ShortVideoUpInfo)this.a.a(ShortVideoUpInfo.class, paramShortVideoUpInfo.key);
    if (localShortVideoUpInfo != null)
    {
      localShortVideoUpInfo.transferedSize = paramShortVideoUpInfo.transferedSize;
      localShortVideoUpInfo.timeStamp = paramShortVideoUpInfo.timeStamp;
      this.a.a(localShortVideoUpInfo);
      return;
    }
    this.a.a(paramShortVideoUpInfo);
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    paramString = a(paramString);
    if (paramString != null) {
      bool = this.a.b(paramString);
    }
    return bool;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ShortVideoTransManager
 * JD-Core Version:    0.7.0.1
 */