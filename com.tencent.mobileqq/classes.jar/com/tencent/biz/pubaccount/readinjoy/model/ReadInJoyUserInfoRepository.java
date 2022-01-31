package com.tencent.biz.pubaccount.readinjoy.model;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import luu;
import luv;

public class ReadInJoyUserInfoRepository
{
  private ReadInJoyUserInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  
  public ReadInJoyUserInfoRepository(ExecutorService paramExecutorService, ReadInJoyUserInfoModule paramReadInJoyUserInfoModule, EntityManager paramEntityManager)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = paramExecutorService;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule = paramReadInJoyUserInfoModule;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
  }
  
  private void a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
        QLog.d("ReadInJoyUserInfoRepository", 2, "notifyCallback.");
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule == null);
      ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule.a();
      if ((localConcurrentHashMap != null) && (localConcurrentHashMap.get(paramString) != null))
      {
        Iterator localIterator = ((List)localConcurrentHashMap.get(paramString)).iterator();
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if (localWeakReference.get() != null) {
            ((ReadInJoyUserInfoModule.RefreshUserInfoCallBack)localWeakReference.get()).a(paramString, paramReadInJoyUserInfo);
          }
        }
        localConcurrentHashMap.remove(paramString);
      }
      paramReadInJoyUserInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule.b();
    } while (paramReadInJoyUserInfo == null);
    paramReadInJoyUserInfo.remove(paramString);
  }
  
  private void b(ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QLog.d("ReadInJoyUserInfoRepository", 2, new Object[] { "saveReadInJoyUserInfoToDB, \n  userInfo = ", paramReadInJoyUserInfo });
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService != null) && (paramReadInJoyUserInfo != null) && (!this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown())) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new luu(this, paramReadInJoyUserInfo));
    }
  }
  
  public ReadInJoyUserInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      localObject = MD5.toMD5(paramString);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    Object localObject = (ReadInJoyUserInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
    if ((localObject != null) && (!((ReadInJoyUserInfo)localObject).requestFlag))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule.a(localArrayList, 1, 1, 0);
      }
    }
    QLog.d("ReadInJoyUserInfoRepository", 2, new Object[] { "getReadInJoyUserInfoByUin, \n ", "userInfo = ", localObject });
    return localObject;
  }
  
  public List a(String paramString)
  {
    Object localObject = MD5.toMD5(paramString);
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return null;
      localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ReadInJoyUserInfo.class, true, "md5Uin = ?", new String[] { localObject }, null, null, null, "1");
    } while ((localObject == null) || (((List)localObject).size() <= 0));
    QLog.d("ReadInJoyUserInfoRepository", 2, new Object[] { "loadSingleReadInJoyUserInfoFromDB, userInfo = ", ((List)localObject).get(0) });
    a(paramString, ((ReadInJoyUserInfo)((List)localObject).get(0)).md5Uin, (ReadInJoyUserInfo)((List)localObject).get(0), false);
    return localObject;
  }
  
  public void a()
  {
    QLog.d("ReadInJoyUserInfoRepository", 2, "resetRequestFlag.");
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyUserInfo)((Map.Entry)localIterator.next()).getValue()).requestFlag = false;
      }
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService != null) && (!this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown())) {
        this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new luv(this, paramInt));
      }
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      QLog.d("ReadInJoyUserInfoRepository", 1, "loadReadInJoyUserInfoFromDB exception.");
      localRejectedExecutionException.printStackTrace();
    }
  }
  
  public void a(ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((paramReadInJoyUserInfo != null) && (!TextUtils.isEmpty(paramReadInJoyUserInfo.md5Uin)))
    {
      String str = MD5.toMD5(paramReadInJoyUserInfo.md5Uin);
      if (!TextUtils.isEmpty(str)) {
        paramReadInJoyUserInfo.md5Uin = str;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, ReadInJoyUserInfo paramReadInJoyUserInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, paramReadInJoyUserInfo);
    QLog.d("ReadInJoyUserInfoRepository", 2, new Object[] { "updateReadInJoyUserInfo, \n key = ", paramString2, Character.valueOf('\n'), "userInfo = ", paramReadInJoyUserInfo, Character.valueOf('\n'), "saveToDB = ", Boolean.valueOf(paramBoolean) });
    a(paramString1, paramReadInJoyUserInfo);
    if (paramBoolean) {
      b(paramReadInJoyUserInfo);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoRepository
 * JD-Core Version:    0.7.0.1
 */