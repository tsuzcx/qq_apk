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
  private volatile long a;
  private volatile boolean b;
  private final Object c = new Object();
  private List<ContactReportUtils.ReportExposeInterval.ReportItem> d;
  private Handler e;
  private WeakReference<QQAppInterface> f;
  private volatile boolean g = false;
  
  ContactReportUtils$ReportExposeInterval()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.b = false;
    this.a = 0L;
    this.d = new LinkedList();
    this.e = new Handler(ThreadManagerV2.getSubThreadLooper());
    a((QQAppInterface)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("create ReportExposeInterval, enable = ");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(", interval = ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("ContactReportUtils", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(ContactReportUtils.ReportExposeInterval.ReportItem paramReportItem)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("really do delay report, mApp = ");
      ((StringBuilder)localObject).append(this.f);
      QLog.d("ContactReportUtils", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    localObject = (QQAppInterface)((WeakReference)localObject).get();
    if (localObject != null) {
      ContactReportUtils.a((QQAppInterface)localObject, paramReportItem.a, paramReportItem.b, paramReportItem.c, paramReportItem.d, paramReportItem.e, paramReportItem.f, paramReportItem.g, true);
    }
  }
  
  private void a(QQAppInterface arg1)
  {
    if (??? != null)
    {
      this.f = new WeakReference(???);
      Object localObject1 = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("com.tencent.mobileqq.ReportExposeInterval_");
      localStringBuilder.append(???.getCurrentAccountUin());
      ??? = ((BaseApplicationImpl)localObject1).getSharedPreferences(localStringBuilder.toString(), 0);
      localObject1 = new ContactReportUtils.ReportExposeIntervalConfig();
      this.b = ???.getBoolean("ReportExposeInterval_enable", ((ContactReportUtils.ReportExposeIntervalConfig)localObject1).a);
      this.a = ???.getLong("ReportExposeInterval_interval", ((ContactReportUtils.ReportExposeIntervalConfig)localObject1).b);
      synchronized (this.c)
      {
        this.d.clear();
        return;
      }
    }
  }
  
  public void a()
  {
    try
    {
      this.e.removeCallbacks(this);
      this.g = false;
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
    this.a = paramLong;
    if (this.a <= 0L)
    {
      this.a = 0L;
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
    WeakReference localWeakReference = this.f;
    if (localWeakReference != null) {
      localObject = (QQAppInterface)localWeakReference.get();
    }
    if (localObject != paramQQAppInterface) {
      a(paramQQAppInterface);
    }
    paramQQAppInterface = new ContactReportUtils.ReportExposeInterval.ReportItem();
    paramQQAppInterface.a = paramInt1;
    paramQQAppInterface.b = ???;
    paramQQAppInterface.c = paramArrayList2;
    paramQQAppInterface.d = paramArrayList;
    paramQQAppInterface.e = paramArrayList3;
    paramQQAppInterface.f = paramInt2;
    paramQQAppInterface.g = paramString;
    synchronized (this.c)
    {
      this.d.add(paramQQAppInterface);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if ((!this.g) || (paramBoolean))
      {
        this.e.removeCallbacks(this);
        this.e.post(this);
        this.g = true;
      }
      return;
    }
    finally {}
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
    a();
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public long c()
  {
    return this.a;
  }
  
  public long d()
  {
    synchronized (this.c)
    {
      long l = this.d.size();
      return l;
    }
  }
  
  public void run()
  {
    if (this.a > 0L)
    {
      ArrayList localArrayList = new ArrayList();
      synchronized (this.c)
      {
        localArrayList.addAll(this.d);
        this.d.clear();
        if (!localArrayList.isEmpty())
        {
          ??? = localArrayList.iterator();
          while (((Iterator)???).hasNext()) {
            a((ContactReportUtils.ReportExposeInterval.ReportItem)((Iterator)???).next());
          }
          this.e.postDelayed(this, this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils.ReportExposeInterval
 * JD-Core Version:    0.7.0.1
 */