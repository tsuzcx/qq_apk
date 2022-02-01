package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.data.EqqConfig;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class EqqDetailDataManager
  implements Manager
{
  private EntityManager a;
  private ConcurrentHashMap<String, EqqDetail> b;
  private EqqConfig c = null;
  
  public EqqDetailDataManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  public EqqDetail a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    EqqDetail localEqqDetail = null;
    if (bool) {
      return null;
    }
    ConcurrentHashMap localConcurrentHashMap = this.b;
    if (localConcurrentHashMap != null) {
      localEqqDetail = (EqqDetail)localConcurrentHashMap.get(paramString);
    }
    return localEqqDetail;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.eqq", 2, "initEqqDetailCache() begin");
    }
    Object localObject = this.a;
    int i = 0;
    localObject = ((EntityManager)localObject).query(EqqDetail.class, false, "followType=?", new String[] { "0" }, null, null, null, null);
    if (localObject != null) {
      i = ((List)localObject).size();
    }
    this.b = new ConcurrentHashMap(i);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EqqDetail localEqqDetail = (EqqDetail)((Iterator)localObject).next();
        this.b.put(localEqqDetail.uin, localEqqDetail);
      }
    }
    b();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initEqqDetailCache() end: ");
      ((StringBuilder)localObject).append(this.b.size());
      QLog.d("Q.contacttab.eqq", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(EqqDetail paramEqqDetail)
  {
    if (paramEqqDetail == null) {
      return;
    }
    a(paramEqqDetail);
    if (this.b == null) {
      this.b = new ConcurrentHashMap();
    }
    if (paramEqqDetail.followType == 0) {
      this.b.put(paramEqqDetail.uin, paramEqqDetail);
    }
  }
  
  protected boolean a(Entity paramEntity)
  {
    int i = paramEntity.getStatus();
    boolean bool = false;
    if (i == 1000)
    {
      this.a.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
      return bool;
    }
    if ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return false;
    }
    return this.a.update(paramEntity);
  }
  
  public String b()
  {
    Object localObject = this.c;
    if (localObject == null)
    {
      localObject = this.a.query(EqqConfig.class);
      if ((localObject != null) && (((List)localObject).size() >= 1))
      {
        this.c = ((EqqConfig)((List)localObject).get(0));
        return this.c.getData();
      }
      return "";
    }
    return ((EqqConfig)localObject).getData();
  }
  
  public void b(EqqDetail paramEqqDetail)
  {
    if (paramEqqDetail == null) {
      return;
    }
    this.a.remove(paramEqqDetail);
    this.a.close();
    ConcurrentHashMap localConcurrentHashMap = this.b;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.remove(paramEqqDetail.uin);
    }
  }
  
  public void b(String paramString)
  {
    if (this.c == null) {
      this.c = new EqqConfig(paramString);
    }
    a(this.c);
  }
  
  public void onDestroy()
  {
    EntityManager localEntityManager = this.a;
    if (localEntityManager != null) {
      localEntityManager.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.EqqDetailDataManager
 * JD-Core Version:    0.7.0.1
 */