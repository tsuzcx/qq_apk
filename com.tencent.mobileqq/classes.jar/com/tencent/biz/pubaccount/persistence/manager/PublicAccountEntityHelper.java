package com.tencent.biz.pubaccount.persistence.manager;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;
import mqq.manager.Manager;

public class PublicAccountEntityHelper
  implements Manager
{
  private QQAppInterface a;
  private PublicAccountEntityManagerFactory b;
  private EntityManager c;
  
  public PublicAccountEntityHelper(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = a(this.a);
    this.c = this.b.createEntityManager();
  }
  
  private PublicAccountEntityManagerFactory a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getAccount();
    if (paramQQAppInterface != null)
    {
      PublicAccountEntityManagerFactory localPublicAccountEntityManagerFactory = this.b;
      if (localPublicAccountEntityManagerFactory != null) {
        return localPublicAccountEntityManagerFactory;
      }
      try
      {
        if (this.b == null)
        {
          paramQQAppInterface = new PublicAccountEntityManagerFactory(paramQQAppInterface);
          ThreadManager.post(new PublicAccountEntityHelper.1(this, paramQQAppInterface), 8, null, false);
          this.b = paramQQAppInterface;
        }
        return this.b;
      }
      finally {}
    }
    throw new IllegalStateException("Can not create a entity factory, the account is null.");
  }
  
  public List<? extends Entity> a(Class<? extends Entity> paramClass, boolean paramBoolean, String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      EntityManager localEntityManager = this.c;
      if (localEntityManager == null) {
        return null;
      }
      paramClass = this.c.query(paramClass, paramBoolean, paramString1, paramArrayOfString, paramString2, paramString3, paramString4, paramString5);
      return paramClass;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    try
    {
      EntityManager localEntityManager = this.c;
      if (localEntityManager == null) {
        return;
      }
      localEntityManager = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DELETE FROM ");
      localStringBuilder.append(paramString);
      localEntityManager.execSQL(localStringBuilder.toString());
      return;
    }
    finally {}
  }
  
  public boolean a(Entity paramEntity)
  {
    try
    {
      EntityManager localEntityManager = this.c;
      boolean bool = false;
      if (localEntityManager == null) {
        return false;
      }
      int i;
      if (paramEntity.getStatus() == 1000)
      {
        b(paramEntity);
        this.c.persistOrReplace(paramEntity);
        i = paramEntity.getStatus();
        if (i == 1001) {
          bool = true;
        }
        return bool;
      }
      if (paramEntity.getStatus() != 1001)
      {
        i = paramEntity.getStatus();
        if (i != 1002) {
          return false;
        }
      }
      bool = this.c.update(paramEntity);
      return bool;
    }
    finally {}
  }
  
  public void b(Entity paramEntity)
  {
    try
    {
      Object localObject1 = this.c;
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = null;
      localObject1 = localObject2;
      if ((paramEntity instanceof PAAdPreloadTask))
      {
        localObject1 = localObject2;
        if (this.c.tabbleIsExist(PAAdPreloadTask.class.getSimpleName()))
        {
          paramEntity = (PAAdPreloadTask)paramEntity;
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(paramEntity.mVideoVid)) {
            localObject1 = this.c.find(PAAdPreloadTask.class, "mVideoVid = ?", new String[] { paramEntity.mVideoVid });
          }
        }
      }
      if (localObject1 != null) {
        this.c.remove((Entity)localObject1);
      }
      return;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((EntityManager)localObject).close();
    }
    localObject = this.b;
    if (localObject != null) {
      ((PublicAccountEntityManagerFactory)localObject).close();
    }
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.persistence.manager.PublicAccountEntityHelper
 * JD-Core Version:    0.7.0.1
 */