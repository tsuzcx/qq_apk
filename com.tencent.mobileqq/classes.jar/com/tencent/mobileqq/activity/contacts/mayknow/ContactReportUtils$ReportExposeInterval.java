package com.tencent.mobileqq.activity.contacts.mayknow;

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
  private List<ContactReportUtils.ReportExposeInterval.ReportItem> jdField_a_of_type_JavaUtilList;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b = false;
  
  ContactReportUtils$ReportExposeInterval()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getSubThreadLooper());
    a((QQAppInterface)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("create ReportExposeInterval, enable = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(", interval = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      QLog.d("ContactReportUtils", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(ContactReportUtils.ReportExposeInterval.ReportItem paramReportItem)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("really do delay report, mApp = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangRefWeakReference);
      QLog.d("ContactReportUtils", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return;
    }
    localObject = (QQAppInterface)((WeakReference)localObject).get();
    if (localObject != null) {
      ContactReportUtils.a((QQAppInterface)localObject, paramReportItem.jdField_a_of_type_Int, paramReportItem.jdField_a_of_type_JavaUtilArrayList, paramReportItem.jdField_b_of_type_JavaUtilArrayList, paramReportItem.c, paramReportItem.d, paramReportItem.jdField_b_of_type_Int, paramReportItem.jdField_a_of_type_JavaLangString, true);
    }
  }
  
  private void a(QQAppInterface arg1)
  {
    if (??? != null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(???);
      Object localObject1 = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("com.tencent.mobileqq.ReportExposeInterval_");
      localStringBuilder.append(???.getCurrentAccountUin());
      ??? = ((BaseApplicationImpl)localObject1).getSharedPreferences(localStringBuilder.toString(), 0);
      localObject1 = new ContactReportUtils.ReportExposeIntervalConfig();
      this.jdField_a_of_type_Boolean = ???.getBoolean("ReportExposeInterval_enable", ((ContactReportUtils.ReportExposeIntervalConfig)localObject1).jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Long = ???.getLong("ReportExposeInterval_interval", ((ContactReportUtils.ReportExposeIntervalConfig)localObject1).jdField_a_of_type_Long);
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportExpose delay, app = ");
      ((StringBuilder)localObject).append(paramQQAppInterface);
      QLog.d("ContactReportUtils", 2, ((StringBuilder)localObject).toString());
    }
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject = null;
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      localObject = (QQAppInterface)localWeakReference.get();
    }
    if (localObject != paramQQAppInterface) {
      a(paramQQAppInterface);
    }
    paramQQAppInterface = new ContactReportUtils.ReportExposeInterval.ReportItem();
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
        if (!localArrayList.isEmpty())
        {
          ??? = localArrayList.iterator();
          while (((Iterator)???).hasNext()) {
            a((ContactReportUtils.ReportExposeInterval.ReportItem)((Iterator)???).next());
          }
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, this.jdField_a_of_type_Long);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ContactReportUtils", 2, "last report size is 0, stop delay report");
        }
        a();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils.ReportExposeInterval
 * JD-Core Version:    0.7.0.1
 */