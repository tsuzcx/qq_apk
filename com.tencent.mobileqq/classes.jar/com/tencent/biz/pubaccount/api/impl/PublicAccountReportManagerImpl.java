package com.tencent.biz.pubaccount.api.impl;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.biz.pubaccount.api.IPublicAccountReportManager;
import com.tencent.biz.pubaccount.util.PAReportInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class PublicAccountReportManagerImpl
  implements Handler.Callback, IPublicAccountReportManager, Manager
{
  public static final int ACTION_QUERY_DB = 100001;
  public static final int ACTION_REPORT = 100002;
  public static final int LOAD_PA_COUNT = 20;
  public static final int MSG_REPORT_RECORD_MAX_COUNT = 80;
  public static final String TAG = "PAReport";
  private QQAppInterface app;
  private EntityManager em;
  private volatile boolean isInited = false;
  private volatile int mCount = -1;
  private MqqWeakReferenceHandler mHandlerRunInSubThread;
  private List<PAReportInfo> mReporting = new ArrayList();
  
  public PublicAccountReportManagerImpl() {}
  
  public PublicAccountReportManagerImpl(QQAppInterface paramQQAppInterface)
  {
    init(paramQQAppInterface);
  }
  
  private void init(QQAppInterface paramQQAppInterface)
  {
    if (!this.isInited) {
      try
      {
        if (!this.isInited)
        {
          this.app = paramQQAppInterface;
          this.em = this.app.getEntityManagerFactory().createEntityManager();
          this.mHandlerRunInSubThread = new MqqWeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
          this.isInited = true;
        }
        return;
      }
      finally {}
    }
  }
  
  public void addReporting(Entity paramEntity)
  {
    this.mHandlerRunInSubThread.post(new PublicAccountReportManagerImpl.1(this, paramEntity));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100001)
    {
      queryDatabases();
      return true;
    }
    if (paramMessage.what == 100002)
    {
      reporting();
      return true;
    }
    return false;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      init((QQAppInterface)paramAppRuntime);
    }
  }
  
  public void onDestroy()
  {
    this.em.close();
    synchronized (this.mReporting)
    {
      this.mReporting.clear();
      this.mCount = -1;
      return;
    }
  }
  
  public void queryDatabases()
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("queryDatabases ... size = ");
      ((StringBuilder)???).append(this.mReporting.size());
      ((StringBuilder)???).append(", count = ");
      ((StringBuilder)???).append(this.mCount);
      QLog.d("PAReport", 2, ((StringBuilder)???).toString());
    }
    if ((this.mCount == -1) && (this.app.getReadableDatabase() != null)) {
      this.mCount = this.app.getReadableDatabase().getCount(PAReportInfo.class.getSimpleName());
    }
    List localList = this.em.query(PAReportInfo.class, true, null, (String[])null, null, null, null, String.valueOf(20));
    if (localList != null) {
      synchronized (this.mReporting)
      {
        this.mReporting.addAll(localList);
      }
    }
    this.mHandlerRunInSubThread.sendEmptyMessage(100002);
  }
  
  public void reporting()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reporting ... size = ");
      ((StringBuilder)localObject1).append(this.mReporting.size());
      ((StringBuilder)localObject1).append(", count = ");
      ((StringBuilder)localObject1).append(this.mCount);
      QLog.d("PAReport", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.mReporting.size() <= 0) {
      return;
    }
    Object localObject1 = this.mReporting;
    int i = 0;
    localObject1 = (PAReportInfo)((List)localObject1).get(0);
    if (this.em.remove((Entity)localObject1))
    {
      this.mCount -= 1;
      synchronized (this.mReporting)
      {
        this.mReporting.remove(0);
        ??? = new ArrayList();
        localObject1 = ((PAReportInfo)localObject1).msgIds.split("\\|");
        int j = localObject1.length;
        if (i < j)
        {
          ((List)???).add(localObject1[i]);
          i += 1;
        }
      }
    }
  }
  
  public void scheduleReport()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scheduleReport ... size = ");
      localStringBuilder.append(this.mReporting.size());
      localStringBuilder.append(", count = ");
      localStringBuilder.append(this.mCount);
      QLog.d("PAReport", 2, localStringBuilder.toString());
    }
    if ((this.mReporting.size() == 0) && (this.mCount == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PAReport", 2, "scheduleReport ... No need query DB");
      }
      return;
    }
    if (this.mReporting.size() == 0)
    {
      if (!this.mHandlerRunInSubThread.hasMessages(100001)) {
        this.mHandlerRunInSubThread.sendEmptyMessageDelayed(100001, 3000L);
      }
      return;
    }
    this.mHandlerRunInSubThread.sendEmptyMessage(100002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountReportManagerImpl
 * JD-Core Version:    0.7.0.1
 */