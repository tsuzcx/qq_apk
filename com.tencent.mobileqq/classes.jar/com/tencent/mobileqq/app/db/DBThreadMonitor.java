package com.tencent.mobileqq.app.db;

import android.os.Looper;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class DBThreadMonitor
{
  private final String a;
  private final Object b = new Object();
  private HashMap<Long, CompetitionThreadInfo> c = new LinkedHashMap();
  
  public DBThreadMonitor(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DBThreadBlockMonitor_");
    localStringBuilder.append(paramString);
    this.a = localStringBuilder.toString();
  }
  
  private boolean a(long paramLong)
  {
    return Looper.getMainLooper().getThread().getId() == paramLong;
  }
  
  private String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (this.b)
    {
      Iterator localIterator = this.c.values().iterator();
      while (localIterator.hasNext())
      {
        CompetitionThreadInfo localCompetitionThreadInfo = (CompetitionThreadInfo)localIterator.next();
        long l1 = System.nanoTime();
        long l2 = localCompetitionThreadInfo.c;
        l1 -= l2;
        double d = l1;
        Double.isNaN(d);
        d /= 1000000.0D;
        localStringBuilder.append("isMainThread: ");
        localStringBuilder.append(a(localCompetitionThreadInfo.a));
        localStringBuilder.append(", ");
        localStringBuilder.append(localCompetitionThreadInfo);
        localStringBuilder.append(", waitingTime: ");
        localStringBuilder.append(l1);
        localStringBuilder.append(" ns; ");
        localStringBuilder.append(d);
        localStringBuilder.append("ms;");
        localStringBuilder.append("\n");
      }
      return localStringBuilder.toString();
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a()
  {
    if (!SQLiteDatabase.sIsLogcatDBOperation) {
      return;
    }
    long l = Thread.currentThread().getId();
    Object localObject2 = Thread.currentThread().getName();
    synchronized (this.b)
    {
      localObject2 = new CompetitionThreadInfo(l, (String)localObject2, System.nanoTime());
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addCompetitionThread -> isMainThread: ");
      localStringBuilder.append(a(l));
      localStringBuilder.append(", curThreadInfo : ");
      localStringBuilder.append(localObject2);
      localStringBuilder.append(", BlockThreadList : \n");
      localStringBuilder.append(c());
      QLog.d(str, 1, localStringBuilder.toString());
      this.c.put(Long.valueOf(l), localObject2);
      QLog.d(this.a, 1, new Throwable("add competition thread stack"), new Object[0]);
      return;
    }
  }
  
  public void b()
  {
    if (!SQLiteDatabase.sIsLogcatDBOperation) {
      return;
    }
    long l1 = Thread.currentThread().getId();
    synchronized (this.b)
    {
      CompetitionThreadInfo localCompetitionThreadInfo = (CompetitionThreadInfo)this.c.remove(Long.valueOf(l1));
      if (localCompetitionThreadInfo != null)
      {
        long l2 = System.nanoTime();
        long l3 = localCompetitionThreadInfo.c;
        double d = l2 - l3;
        Double.isNaN(d);
        d /= 1000000.0D;
        String str = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("finish thread : ");
        localStringBuilder.append(localCompetitionThreadInfo);
        localStringBuilder.append(", isMainThread: ");
        localStringBuilder.append(a(l1));
        localStringBuilder.append(", cost: ");
        localStringBuilder.append(System.nanoTime() - localCompetitionThreadInfo.c);
        localStringBuilder.append("ns, ");
        localStringBuilder.append(d);
        localStringBuilder.append("ms, BlockThreadList : \n");
        localStringBuilder.append(c());
        QLog.d(str, 1, localStringBuilder.toString());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.db.DBThreadMonitor
 * JD-Core Version:    0.7.0.1
 */