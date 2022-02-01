package com.tencent.av.business.manager.report;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Process;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.BusinessManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;

public class VideoNodeReporter
  extends BusinessManager
{
  static String d;
  List<VideoNodeReporter.SeesionRecord> e = new ArrayList();
  int f;
  Handler g;
  HandlerThread h = new HandlerThread("VideoNodeReportThread");
  Handler.Callback i = new VideoNodeReporter.1(this);
  
  public VideoNodeReporter(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.h.start();
    this.g = new Handler(this.h.getLooper(), this.i);
    paramVideoAppInterface = BaseApplicationImpl.processName.split(":");
    if ((paramVideoAppInterface != null) && (paramVideoAppInterface.length == 2)) {
      paramVideoAppInterface = paramVideoAppInterface[1];
    } else {
      paramVideoAppInterface = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo_node_report_");
    localStringBuilder.append(paramVideoAppInterface);
    d = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append("construct VideoNodeReporter  sSPName = ");
      paramVideoAppInterface.append(d);
      QLog.d("VideoNodeReporter", 2, paramVideoAppInterface.toString());
    }
  }
  
  private void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("writeSpSessionRecord,roomId = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(",detail = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("VideoNodeReporter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = BaseApplicationImpl.getApplication().getSystemSharedPreferences(d, 0).edit();
    ((SharedPreferences.Editor)localObject).putString(String.valueOf(paramLong), paramString);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  private void b(long paramLong1, int paramInt, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" reportNode ,node = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(",value = ");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append(",roomId = ");
      ((StringBuilder)localObject1).append(paramLong1);
      QLog.d("VideoNodeReporter", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = b(paramLong1);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new VideoNodeReporter.SeesionRecord();
      ((VideoNodeReporter.SeesionRecord)localObject1).a = paramLong1;
      this.e.add(localObject1);
    }
    localObject2 = this.c.getCurrentAccountUin();
    Object localObject3 = this.c.b().k();
    if (((VideoNodeReporter.SeesionRecord)localObject1).a == ((SessionInfo)localObject3).D()) {
      ((VideoNodeReporter.SeesionRecord)localObject1).a((SessionInfo)localObject3, (String)localObject2);
    }
    localObject2 = ((VideoNodeReporter.SeesionRecord)localObject1).a();
    localObject1 = ((VideoNodeReporter.SeesionRecord)localObject1).a(paramInt, paramLong2);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append((String)localObject1);
    a(paramLong1, ((StringBuilder)localObject3).toString());
  }
  
  static String c()
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
  }
  
  private void d()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getSystemSharedPreferences(d, 0);
    Map localMap = ((SharedPreferences)localObject1).getAll();
    if ((localMap != null) && (localMap.size() > 0))
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkAndReportCrashRecord, allContent.size() = ");
      ((StringBuilder)localObject2).append(localMap.size());
      QLog.d("VideoNodeReporter", 1, ((StringBuilder)localObject2).toString());
      localObject2 = localMap.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        try
        {
          c(Long.decode((String)localEntry.getKey()).longValue());
        }
        catch (Exception localException)
        {
          QLog.d("VideoNodeReporter", 1, "checkAndReportCrashRecord Exception ", localException);
          ((SharedPreferences)localObject1).edit().remove((String)localEntry.getKey()).commit();
        }
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("checkAndReportCrashRecord allContent = ");
    ((StringBuilder)localObject1).append(localMap);
    QLog.d("VideoNodeReporter", 1, ((StringBuilder)localObject1).toString());
  }
  
  private void d(long paramLong)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSystemSharedPreferences(d, 0).edit();
    ((SharedPreferences.Editor)localObject).remove(String.valueOf(paramLong));
    ((SharedPreferences.Editor)localObject).commit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("removeSpSessionRecord,roomId = ");
    ((StringBuilder)localObject).append(paramLong);
    AVLog.printAllUserLog("VideoNodeReporter", ((StringBuilder)localObject).toString());
  }
  
  private String e(long paramLong)
  {
    String str = BaseApplicationImpl.getApplication().getSystemSharedPreferences(d, 0).getString(String.valueOf(paramLong), "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getSpSessionRecord roomId = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(",result = ");
    localStringBuilder.append(str);
    QLog.d("VideoNodeReporter", 1, localStringBuilder.toString());
    return str;
  }
  
  protected void a()
  {
    AVLog.printAllUserLog("VideoNodeReporter", "onCreate ");
    d();
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" report ,node = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",value = ");
    localStringBuilder.append(paramLong);
    QLog.d("VideoNodeReporter", 1, localStringBuilder.toString());
    if ((this.c != null) && (this.c.b() != null) && (this.c.b().k() != null))
    {
      if (this.c.z)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" report error 1 ,exit has been called,node = ");
        localStringBuilder.append(paramInt);
        AVLog.printAllUserLog("VideoNodeReporter", localStringBuilder.toString());
        return;
      }
      this.g.post(new VideoNodeReporter.3(this, paramInt, paramLong));
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(" report error 0: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("|");
    localStringBuilder.append(this.c);
    AVLog.printAllUserLog("VideoNodeReporter", localStringBuilder.toString());
  }
  
  public void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateCallerRoomId roomId = ");
    localStringBuilder.append(paramLong);
    QLog.d("VideoNodeReporter", 1, localStringBuilder.toString());
    this.g.post(new VideoNodeReporter.2(this, paramLong));
  }
  
  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" reportByRoomId ,node = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",value = ");
    localStringBuilder.append(paramLong2);
    QLog.d("VideoNodeReporter", 1, localStringBuilder.toString());
    if ((this.c != null) && (this.c.b() != null) && (this.c.b().k() != null))
    {
      if (this.c.z)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" reportByRoomId error 1 ,exit has been called,node = ");
        localStringBuilder.append(paramInt);
        AVLog.printAllUserLog("VideoNodeReporter", localStringBuilder.toString());
        return;
      }
      if (paramLong1 == 0L)
      {
        QLog.d("VideoNodeReporter", 1, "reportByRoomId rooid is 0", new Throwable("test"));
        return;
      }
      this.g.post(new VideoNodeReporter.4(this, paramLong1, paramInt, paramLong2));
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(" reportByRoomId error 0: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("|");
    localStringBuilder.append(this.c);
    AVLog.printAllUserLog("VideoNodeReporter", localStringBuilder.toString());
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder();
    paramString1.append(" onSessionStatusChanged :");
    paramString1.append(paramInt);
    paramString1.append(",para = ");
    paramString1.append(paramString2);
    AVLog.printAllUserLog("VideoNodeReporter", paramString1.toString());
    if (paramInt != 1) {
      return;
    }
    if (this.e.size() > 0)
    {
      paramString1 = this.e.iterator();
      while (paramString1.hasNext()) {
        ((VideoNodeReporter.SeesionRecord)paramString1.next()).i = System.currentTimeMillis();
      }
    }
    a(38, this.f);
  }
  
  protected boolean a(String paramString)
  {
    return true;
  }
  
  VideoNodeReporter.SeesionRecord b(long paramLong)
  {
    if (this.e.size() > 0)
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        VideoNodeReporter.SeesionRecord localSeesionRecord = (VideoNodeReporter.SeesionRecord)localIterator.next();
        if (paramLong == localSeesionRecord.a) {
          return localSeesionRecord;
        }
      }
    }
    return null;
  }
  
  public void b()
  {
    try
    {
      Object localObject = (ActivityManager)this.c.getApplication().getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      ((ActivityManager)localObject).getMemoryInfo(localMemoryInfo);
      long l1 = DeviceInfoUtil.a(Process.myPid()) / 1024L / 1024L;
      long l2 = localMemoryInfo.availMem / 1024L / 1024L;
      long l3 = localMemoryInfo.threshold / 1024L / 1024L;
      boolean bool = localMemoryInfo.lowMemory;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportMemoryStatus,availMem = ");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(",threshold = ");
      ((StringBuilder)localObject).append(l3);
      ((StringBuilder)localObject).append(",isLowMemory = ");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(",pss = ");
      ((StringBuilder)localObject).append(l1);
      QLog.d("VideoNodeReporter", 1, ((StringBuilder)localObject).toString());
      a(21, l3);
      a(15, l2);
      a(22, l1);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("VideoNodeReporter", 1, "reportMemoryStatus,Exception ", localException);
    }
  }
  
  public void b(String paramString)
  {
    this.g.post(new VideoNodeReporter.5(this, paramString));
  }
  
  public void c(long paramLong)
  {
    this.g.post(new VideoNodeReporter.6(this, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter
 * JD-Core Version:    0.7.0.1
 */