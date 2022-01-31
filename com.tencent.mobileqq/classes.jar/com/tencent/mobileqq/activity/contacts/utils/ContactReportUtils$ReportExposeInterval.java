package com.tencent.mobileqq.activity.contacts.utils;

import ahqj;
import ahqk;
import android.content.SharedPreferences;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactReportUtils$ReportExposeInterval
  implements Runnable
{
  private volatile long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private List<ahqj> jdField_a_of_type_JavaUtilList;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  ContactReportUtils$ReportExposeInterval()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getSubThreadLooper());
    a(localQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("ContactReportUtils", 2, "create ReportExposeInterval, enable = " + this.jdField_a_of_type_Boolean + ", interval = " + this.jdField_a_of_type_Long);
    }
  }
  
  private void a(ahqj paramahqj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactReportUtils", 2, "really do delay report, mApp = " + this.jdField_a_of_type_JavaLangRefWeakReference);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localQQAppInterface == null);
    ContactReportUtils.a(localQQAppInterface, paramahqj.jdField_a_of_type_Int, paramahqj.jdField_a_of_type_JavaUtilArrayList, paramahqj.jdField_b_of_type_JavaUtilArrayList, paramahqj.c, paramahqj.d, paramahqj.jdField_b_of_type_Int, paramahqj.jdField_a_of_type_JavaLangString, true);
  }
  
  private void a(QQAppInterface arg1)
  {
    if (??? != null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(???);
      ??? = BaseApplicationImpl.getApplication().getSharedPreferences("com.tencent.mobileqq.ReportExposeInterval_" + ???.getCurrentAccountUin(), 0);
      ahqk localahqk = new ahqk();
      this.jdField_a_of_type_Boolean = ???.getBoolean("ReportExposeInterval_enable", localahqk.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Long = ???.getLong("ReportExposeInterval_interval", localahqk.jdField_a_of_type_Long);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        return;
      }
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this);
      this.b = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    if (this.jdField_a_of_type_Long <= 0L)
    {
      this.jdField_a_of_type_Long = 0L;
      a();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, ArrayList<String> arg3, ArrayList<String> paramArrayList2, ArrayList<Integer> paramArrayList, ArrayList<byte[]> paramArrayList3, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactReportUtils", 2, "reportExpose delay, app = " + paramQQAppInterface);
    }
    if (paramQQAppInterface == null) {
      return;
    }
    QQAppInterface localQQAppInterface = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if (localQQAppInterface != paramQQAppInterface) {
      a(paramQQAppInterface);
    }
    paramQQAppInterface = new ahqj();
    paramQQAppInterface.jdField_a_of_type_Int = paramInt1;
    paramQQAppInterface.jdField_a_of_type_JavaUtilArrayList = ???;
    paramQQAppInterface.jdField_b_of_type_JavaUtilArrayList = paramArrayList2;
    paramQQAppInterface.c = paramArrayList;
    paramQQAppInterface.d = paramArrayList3;
    paramQQAppInterface.jdField_b_of_type_Int = paramInt2;
    paramQQAppInterface.jdField_a_of_type_JavaLangString = paramString;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramQQAppInterface);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if ((!this.b) || (paramBoolean))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this);
        this.jdField_a_of_type_AndroidOsHandler.post(this);
        this.b = true;
      }
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public long b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      long l = this.jdField_a_of_type_JavaUtilList.size();
      return l;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    a();
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Long > 0L)
    {
      ArrayList localArrayList = new ArrayList();
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_JavaUtilList.clear();
        if (localArrayList.isEmpty()) {
          break label106;
        }
        ??? = localArrayList.iterator();
        if (((Iterator)???).hasNext()) {
          a((ahqj)((Iterator)???).next());
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, this.jdField_a_of_type_Long);
    }
    return;
    label106:
    if (QLog.isColorLevel()) {
      QLog.d("ContactReportUtils", 2, "last report size is 0, stop delay report");
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.utils.ContactReportUtils.ReportExposeInterval
 * JD-Core Version:    0.7.0.1
 */