package com.tencent.biz.pubaccount.readinjoy.data;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.statistics.UEC;
import com.tencent.mobileqq.statistics.UEC.IReporter;
import com.tencent.mobileqq.statistics.UEC.UECItem;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class ReadInJoyDAUStatistic
  implements Handler.Callback, UEC.IReporter, Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public ReadInJoyDAUStatistic(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private String a()
  {
    return new SimpleDateFormat("yyyyMMdd").format(new Date());
  }
  
  public String a(String paramString1, String paramString2)
  {
    try
    {
      arrayOfString = paramString2.split("\\|");
      if (arrayOfString == null) {
        return paramString1;
      }
      i = 0;
    }
    catch (Exception localException1)
    {
      try
      {
        String[] arrayOfString;
        int i;
        if (i >= arrayOfString.length) {
          break label165;
        }
        String str1 = arrayOfString[i];
        int j = str1.indexOf("+");
        int k = str1.indexOf(":");
        paramString2 = paramString1;
        if (j > 0)
        {
          paramString2 = paramString1;
          if (k > 0)
          {
            paramString2 = str1.substring(0, j);
            String str2 = str1.substring(j + 1, k);
            str1 = str1.substring(k + 1);
            paramString2 = UEC.a(paramString1, paramString2, Integer.valueOf(str2).intValue(), Integer.valueOf(str1).intValue());
          }
        }
        i += 1;
        paramString1 = paramString2;
      }
      catch (Exception localException2)
      {
        label129:
        break label129;
      }
      localException1 = localException1;
      paramString2 = paramString1;
      if (!QLog.isColorLevel()) {
        break label165;
      }
      QLog.d("Q.activity_dau", 2, "saveToDB|preActivityList error:" + localException1);
      paramString2 = paramString1;
    }
    paramString2 = paramString1;
    label165:
    return paramString2;
    return paramString1;
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (SharedPreUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
    {
      Message localMessage = new Message();
      localMessage.what = 0;
      localMessage.obj = paramArrayList;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2;
    Object localObject3;
    if (paramMessage.what == 0)
    {
      paramMessage = (ArrayList)paramMessage.obj;
      if (paramMessage != null)
      {
        paramMessage = paramMessage.iterator();
        label308:
        while (paramMessage.hasNext())
        {
          localObject2 = (UEC.UECItem)paramMessage.next();
          localObject1 = ((UEC.UECItem)localObject2).jdField_a_of_type_JavaLangString;
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject1))
          {
            localObject3 = (ReadInJoyActivityDAUInfo)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
            ((ReadInJoyActivityDAUInfo)localObject3).count += 1;
            ((ReadInJoyActivityDAUInfo)localObject3).showTime += ((UEC.UECItem)localObject2).jdField_a_of_type_Long;
            ((ReadInJoyActivityDAUInfo)localObject3).displayCount += ((UEC.UECItem)localObject2).jdField_b_of_type_Int;
            ((ReadInJoyActivityDAUInfo)localObject3).preActivityList = a(((ReadInJoyActivityDAUInfo)localObject3).preActivityList, ((UEC.UECItem)localObject2).jdField_b_of_type_JavaLangString);
            ((ReadInJoyActivityDAUInfo)localObject3).activeDate = a();
          }
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label308;
            }
            localObject2 = (ReadInJoyActivityDAUInfo)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
            if (localObject2 == null) {
              break;
            }
            QLog.d("Q.activity_dau", 2, "reportInternal|activityName:" + (String)localObject1 + " count:" + ((ReadInJoyActivityDAUInfo)localObject2).count + " time:" + ((ReadInJoyActivityDAUInfo)localObject2).showTime + " dis:" + ((ReadInJoyActivityDAUInfo)localObject2).displayCount + " pre:" + ((ReadInJoyActivityDAUInfo)localObject2).preActivityList);
            break;
            localObject3 = new ReadInJoyActivityDAUInfo();
            ((ReadInJoyActivityDAUInfo)localObject3).count = 1;
            ((ReadInJoyActivityDAUInfo)localObject3).activityName = ((String)localObject1);
            ((ReadInJoyActivityDAUInfo)localObject3).showTime = ((UEC.UECItem)localObject2).jdField_a_of_type_Long;
            ((ReadInJoyActivityDAUInfo)localObject3).displayCount = ((UEC.UECItem)localObject2).jdField_b_of_type_Int;
            ((ReadInJoyActivityDAUInfo)localObject3).preActivityList = ((UEC.UECItem)localObject2).jdField_b_of_type_JavaLangString;
            ((ReadInJoyActivityDAUInfo)localObject3).activeDate = a();
            this.jdField_a_of_type_JavaUtilHashMap.put(localObject1, localObject3);
          }
        }
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.size() >= 4)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      }
    }
    while (paramMessage.what != 1)
    {
      do
      {
        return false;
      } while (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1));
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 120000L);
      return false;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
        break label418;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) {
        return false;
      }
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    label418:
    paramMessage = this.jdField_a_of_type_JavaUtilHashMap.keySet();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    for (;;)
    {
      try
      {
        ((EntityTransaction)localObject1).a();
        localObject2 = paramMessage.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label745;
        }
        localObject3 = (String)((Iterator)localObject2).next();
        localReadInJoyActivityDAUInfo = (ReadInJoyActivityDAUInfo)this.jdField_a_of_type_JavaUtilHashMap.get(localObject3);
        paramMessage = (ReadInJoyActivityDAUInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ReadInJoyActivityDAUInfo.class, (String)localObject3);
        if (paramMessage != null) {
          continue;
        }
        paramMessage = new ReadInJoyActivityDAUInfo();
        paramMessage.activityName = ((String)localObject3);
        paramMessage.count = localReadInJoyActivityDAUInfo.count;
        paramMessage.showTime = localReadInJoyActivityDAUInfo.showTime;
        paramMessage.displayCount = localReadInJoyActivityDAUInfo.displayCount;
        paramMessage.preActivityList = localReadInJoyActivityDAUInfo.preActivityList;
        paramMessage.activeDate = a();
      }
      catch (Exception paramMessage)
      {
        ReadInJoyActivityDAUInfo localReadInJoyActivityDAUInfo;
        paramMessage.printStackTrace();
        ((EntityTransaction)localObject1).b();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.activity_dau", 2, "saveToDB|cache size:" + this.jdField_a_of_type_JavaUtilHashMap.size());
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        return false;
        paramMessage.count += localReadInJoyActivityDAUInfo.count;
        paramMessage.showTime += localReadInJoyActivityDAUInfo.showTime;
        paramMessage.displayCount += localReadInJoyActivityDAUInfo.displayCount;
        paramMessage.preActivityList = a(paramMessage.preActivityList, localReadInJoyActivityDAUInfo.preActivityList);
        paramMessage.activeDate = a();
        continue;
      }
      finally
      {
        ((EntityTransaction)localObject1).b();
      }
      if (paramMessage.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramMessage);
      }
      else if ((paramMessage.getStatus() == 1001) || (paramMessage.getStatus() == 1002))
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramMessage);
        continue;
        label745:
        ((EntityTransaction)localObject1).c();
        ((EntityTransaction)localObject1).b();
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.data.ReadInJoyDAUStatistic
 * JD-Core Version:    0.7.0.1
 */