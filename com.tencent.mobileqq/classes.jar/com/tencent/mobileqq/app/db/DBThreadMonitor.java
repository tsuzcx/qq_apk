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
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString;
  private HashMap<Long, CompetitionThreadInfo> jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
  
  public DBThreadMonitor(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = ("DBThreadBlockMonitor_" + paramString);
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      if (localIterator.hasNext())
      {
        CompetitionThreadInfo localCompetitionThreadInfo = (CompetitionThreadInfo)localIterator.next();
        long l = System.nanoTime() - localCompetitionThreadInfo.b;
        double d = l / 1000000.0D;
        localStringBuilder.append("isMainThread: ").append(a(localCompetitionThreadInfo.a)).append(", ").append(localCompetitionThreadInfo).append(", waitingTime: ").append(l).append(" ns; ").append(d).append("ms;").append("\n");
      }
    }
    return localObject2.toString();
  }
  
  private boolean a(long paramLong)
  {
    return Looper.getMainLooper().getThread().getId() == paramLong;
  }
  
  public void a()
  {
    if (!SQLiteDatabase.sIsLogcatDBOperation) {
      return;
    }
    long l = Thread.currentThread().getId();
    Object localObject2 = Thread.currentThread().getName();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localObject2 = new CompetitionThreadInfo(l, (String)localObject2, System.nanoTime());
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "addCompetitionThread -> isMainThread: " + a(l) + ", curThreadInfo : " + localObject2 + ", BlockThreadList : \n" + a());
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), localObject2);
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, new Throwable("add competition thread stack"), new Object[0]);
      return;
    }
  }
  
  public void b()
  {
    if (!SQLiteDatabase.sIsLogcatDBOperation) {
      return;
    }
    long l = Thread.currentThread().getId();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      CompetitionThreadInfo localCompetitionThreadInfo = (CompetitionThreadInfo)this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(l));
      if (localCompetitionThreadInfo != null)
      {
        double d = (System.nanoTime() - localCompetitionThreadInfo.b) / 1000000.0D;
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "finish thread : " + localCompetitionThreadInfo + ", isMainThread: " + a(l) + ", cost: " + (System.nanoTime() - localCompetitionThreadInfo.b) + "ns, " + d + "ms, BlockThreadList : \n" + a());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.db.DBThreadMonitor
 * JD-Core Version:    0.7.0.1
 */