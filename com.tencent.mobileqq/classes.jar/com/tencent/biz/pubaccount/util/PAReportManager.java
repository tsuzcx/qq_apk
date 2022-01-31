package com.tencent.biz.pubaccount.util;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.Manager;
import mup;

public class PAReportManager
  implements Handler.Callback, Manager
{
  private volatile int jdField_a_of_type_Int = -1;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public PAReportManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAReport", 2, "scheduleReport ... size = " + this.jdField_a_of_type_JavaUtilList.size() + ", count = " + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_JavaUtilList.size() == 0) && (this.jdField_a_of_type_Int == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("PAReport", 2, "scheduleReport ... No need query DB");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList.size() != 0) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.hasMessages(100001));
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(100001, 3000L);
    return;
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(100002);
  }
  
  public void a(PAReportInfo paramPAReportInfo)
  {
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.post(new mup(this, paramPAReportInfo));
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAReport", 2, "queryDatabases ... size = " + this.jdField_a_of_type_JavaUtilList.size() + ", count = " + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b().a(PAReportInfo.class.getSimpleName());
    }
    List localList2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PAReportInfo.class, true, null, (String[])null, null, null, null, String.valueOf(20));
    if (localList2 != null) {}
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.addAll(localList2);
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(100002);
      return;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAReport", 2, "reporting ... size = " + this.jdField_a_of_type_JavaUtilList.size() + ", count = " + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {}
    for (;;)
    {
      return;
      Object localObject1 = (PAReportInfo)this.jdField_a_of_type_JavaUtilList.get(0);
      if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject1)) {
        continue;
      }
      this.jdField_a_of_type_Int -= 1;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.remove(0);
        ??? = new ArrayList();
        localObject1 = ((PAReportInfo)localObject1).msgIds.split("\\|");
        int j = localObject1.length;
        int i = 0;
        if (i >= j) {
          continue;
        }
        ((List)???).add(localObject1[i]);
        i += 1;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100001)
    {
      b();
      return true;
    }
    if (paramMessage.what == 100002)
    {
      c();
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_Int = -1;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PAReportManager
 * JD-Core Version:    0.7.0.1
 */