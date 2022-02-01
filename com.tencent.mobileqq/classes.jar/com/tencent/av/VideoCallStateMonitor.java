package com.tencent.av;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class VideoCallStateMonitor
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private VideoCallStateMonitor.TimerHandler jdField_a_of_type_ComTencentAvVideoCallStateMonitor$TimerHandler;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private List<VideoCallStateMonitor.MemoryDetail> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private volatile int jdField_b_of_type_Int;
  private volatile long jdField_b_of_type_Long;
  private int jdField_c_of_type_Int;
  private volatile long jdField_c_of_type_Long;
  private long d;
  
  VideoCallStateMonitor(@NonNull VideoAppInterface paramVideoAppInterface, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoCallStateMonitor <");
      localStringBuilder.append(this);
      localStringBuilder.append("> created");
      QLog.d("VideoCallStateMonitor", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = "0";
    }
    this.jdField_a_of_type_ComTencentAvVideoController = VideoController.a();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.d = 0L;
    this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor$TimerHandler = new VideoCallStateMonitor.TimerHandler(this);
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 2;
  }
  
  private int a()
  {
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().d;
    if (i == 1) {
      return 1;
    }
    if (i == 2) {
      return 2;
    }
    if (i == 0) {
      return 0;
    }
    return 2;
  }
  
  private long a(Map<String, Integer> paramMap, String paramString)
  {
    if ((paramMap != null) && (paramMap.containsKey(paramString))) {
      return ((Integer)paramMap.get(paramString)).intValue();
    }
    return -1L;
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("begin monitor ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("VideoCallStateMonitor", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = DeviceInfoUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
    if (a((Map)localObject, "summary.total-pss") <= 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoCallStateMonitor", 1, "getTotalPss error!");
      }
    }
    else
    {
      a(SystemClock.uptimeMillis(), (Map)localObject);
      a(DeviceInfoUtil.e() / 1000L);
    }
    if (this.jdField_b_of_type_Long > 0L)
    {
      long l = SystemClock.uptimeMillis() - this.jdField_b_of_type_Long;
      if (l > 0L) {
        b(l);
      }
    }
  }
  
  private void a(long paramLong)
  {
    if (paramLong > 0L)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("call avail mem: ");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("kb");
        QLog.d("VideoCallStateMonitor", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_JavaLangString, "availMem2", String.valueOf(paramLong));
    }
  }
  
  private void a(long paramLong, Map<String, Integer> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    this.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_Long += a(paramMap, "summary.total-pss");
    long l = this.jdField_a_of_type_Long / this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_JavaLangString, "avgMemory", String.valueOf(l));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("call avg pss: ");
      localStringBuilder.append(l);
      localStringBuilder.append("kb");
      QLog.d("VideoCallStateMonitor", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCallStateMonitor", 2, String.format("report memory type=%s value=%sKB, time=%s", new Object[] { Integer.valueOf(a()), paramMap.toString(), Long.valueOf(paramLong) }));
    }
    this.jdField_a_of_type_JavaUtilList.add(new VideoCallStateMonitor.MemoryDetail(a(), a(paramMap, "summary.total-pss"), a(paramMap, "summary.java-heap"), a(paramMap, "summary.native-heap"), a(paramMap, "summary.code"), a(paramMap, "summary.graphics"), paramLong));
  }
  
  private void b(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("call time: ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("ms");
      QLog.d("VideoCallStateMonitor", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_JavaLangString, "callDur", String.valueOf(paramLong));
  }
  
  private void c()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("postReportMemory size = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.d("VideoCallStateMonitor", 2, ((StringBuilder)localObject1).toString());
    }
    int i = this.jdField_a_of_type_JavaUtilList.size();
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    if (i >= 4)
    {
      Object localObject3 = this.jdField_a_of_type_JavaUtilList;
      int j = i - 1 - 1;
      long l3 = ((VideoCallStateMonitor.MemoryDetail)((List)localObject3).get(j)).jdField_a_of_type_Long;
      long l4 = ((VideoCallStateMonitor.MemoryDetail)this.jdField_a_of_type_JavaUtilList.get(1)).jdField_a_of_type_Long;
      long l1 = ((VideoCallStateMonitor.MemoryDetail)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_b_of_type_Long - ((VideoCallStateMonitor.MemoryDetail)this.jdField_a_of_type_JavaUtilList.get(1)).jdField_b_of_type_Long;
      long l2 = ((VideoCallStateMonitor.MemoryDetail)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_c_of_type_Long - ((VideoCallStateMonitor.MemoryDetail)this.jdField_a_of_type_JavaUtilList.get(1)).jdField_c_of_type_Long;
      i = 1;
      double d1;
      double d2;
      double d4;
      while (i < j)
      {
        localObject3 = (VideoCallStateMonitor.MemoryDetail)this.jdField_a_of_type_JavaUtilList.get(i);
        Object localObject4 = this.jdField_a_of_type_JavaUtilList;
        i += 1;
        localObject4 = (VideoCallStateMonitor.MemoryDetail)((List)localObject4).get(i);
        if ((((VideoCallStateMonitor.MemoryDetail)localObject3).jdField_a_of_type_Int != 0) && (((VideoCallStateMonitor.MemoryDetail)localObject3).jdField_a_of_type_Int != ((VideoCallStateMonitor.MemoryDetail)localObject4).jdField_a_of_type_Int)) {
          if (QLog.isColorLevel()) {
            QLog.d("VideoCallStateMonitor", 2, "postReportMemory failed, session type changed");
          }
        }
        for (;;)
        {
          i = 1;
          break label579;
          this.jdField_c_of_type_Int = ((VideoCallStateMonitor.MemoryDetail)localObject4).jdField_a_of_type_Int;
          if ((!((VideoCallStateMonitor.MemoryDetail)localObject3).a()) || (!((VideoCallStateMonitor.MemoryDetail)localObject4).a())) {
            break label560;
          }
          d1 = ((VideoCallStateMonitor.MemoryDetail)localObject4).f - ((VideoCallStateMonitor.MemoryDetail)localObject3).f;
          d2 = ((VideoCallStateMonitor.MemoryDetail)localObject4).jdField_a_of_type_Long - ((VideoCallStateMonitor.MemoryDetail)localObject3).jdField_a_of_type_Long;
          d3 = ((VideoCallStateMonitor.MemoryDetail)localObject4).jdField_b_of_type_Long - ((VideoCallStateMonitor.MemoryDetail)localObject3).jdField_b_of_type_Long;
          d4 = ((VideoCallStateMonitor.MemoryDetail)localObject4).jdField_c_of_type_Long - ((VideoCallStateMonitor.MemoryDetail)localObject3).jdField_c_of_type_Long;
          if (d1 > 0.0D) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoCallStateMonitor", 2, "postReportMemory failed, timestamp fatal error");
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCallStateMonitor", 2, String.format("total pss grow %skb, java pss grow %skb, native pss grow %skb [in %sms]", new Object[] { Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d1) }));
        }
        Double.isNaN(d2);
        Double.isNaN(d1);
        ((List)localObject1).add(Double.valueOf(d2 * 1000.0D / d1));
        Double.isNaN(d3);
        Double.isNaN(d1);
        ((List)localObject2).add(Double.valueOf(d3 * 1000.0D / d1));
        Double.isNaN(d4);
        Double.isNaN(d1);
        localArrayList.add(Double.valueOf(d4 * 1000.0D / d1));
        continue;
        label560:
        if (QLog.isColorLevel()) {
          QLog.d("VideoCallStateMonitor", 2, "postReportMemory failed, cannot get memory info");
        }
        return;
      }
      i = 0;
      label579:
      double d3 = 0.0D;
      if (i == 0)
      {
        localObject3 = ((List)localObject1).iterator();
        for (d1 = 0.0D; ((Iterator)localObject3).hasNext(); d1 += ((Double)((Iterator)localObject3).next()).doubleValue()) {}
        localObject3 = ((List)localObject2).iterator();
        for (d2 = 0.0D; ((Iterator)localObject3).hasNext(); d2 += ((Double)((Iterator)localObject3).next()).doubleValue()) {}
        localObject3 = localArrayList.iterator();
        while (((Iterator)localObject3).hasNext()) {
          d3 += ((Double)((Iterator)localObject3).next()).doubleValue();
        }
        d4 = ((List)localObject1).size();
        Double.isNaN(d4);
        d1 /= d4;
        d4 = ((List)localObject2).size();
        Double.isNaN(d4);
        d2 /= d4;
        d4 = localArrayList.size();
        Double.isNaN(d4);
        d3 /= d4;
        localObject2 = new HashMap(9);
        ((HashMap)localObject2).put("selfUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        ((HashMap)localObject2).put("peerUin", this.jdField_a_of_type_JavaLangString);
        ((HashMap)localObject2).put("sessionId", String.valueOf(this.d));
        ((HashMap)localObject2).put("startTimestamp", String.valueOf(this.jdField_c_of_type_Long));
        if (this.jdField_a_of_type_Boolean) {
          localObject1 = "1";
        } else {
          localObject1 = "0";
        }
        ((HashMap)localObject2).put("firstChat", localObject1);
        ((HashMap)localObject2).put("chatType", String.valueOf(this.jdField_c_of_type_Int));
        ((HashMap)localObject2).put("device_memory", String.valueOf(DeviceInfoUtil.a() / 1024L));
        ((HashMap)localObject2).put("totalPss_growth", String.valueOf(l3 - l4));
        ((HashMap)localObject2).put("totalPss_growthRate", String.valueOf(d1));
        ((HashMap)localObject2).put("javaPss_growth", String.valueOf(l1));
        ((HashMap)localObject2).put("javaPss_growthRate", String.valueOf(d2));
        ((HashMap)localObject2).put("nativePss_growth", String.valueOf(l2));
        ((HashMap)localObject2).put("nativePss_growthRate", String.valueOf(d3));
        if (this.jdField_b_of_type_Long > 0L) {
          localObject1 = String.valueOf(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long);
        } else {
          localObject1 = "";
        }
        ((HashMap)localObject2).put("call_dur", localObject1);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("postReportMemory success: ");
          ((StringBuilder)localObject1).append(((HashMap)localObject2).toString());
          QLog.d("VideoCallStateMonitor", 2, ((StringBuilder)localObject1).toString());
        }
        ThreadManager.post(new VideoCallStateMonitor.1(this, (HashMap)localObject2), 5, null, false);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCallStateMonitor", 2, "postReportMemory failed, skip");
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("postReportMemory failed, node size = ");
      ((StringBuilder)localObject1).append(i);
      QLog.d("VideoCallStateMonitor", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  void a()
  {
    if (this.jdField_b_of_type_Int == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCallStateMonitor", 2, "startCallMonitor");
      }
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.g;
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      this.d = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor$TimerHandler.a();
      this.jdField_b_of_type_Int = 1;
      return;
    }
    QLog.e("VideoCallStateMonitor", 1, "startCallMonitor state error");
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Int != 2)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopMonitor ");
        localStringBuilder.append(Log.getStackTraceString(new RuntimeException()));
        QLog.d("VideoCallStateMonitor", 2, localStringBuilder.toString());
      }
      this.jdField_b_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentAvVideoCallStateMonitor$TimerHandler.b();
      return;
    }
    QLog.e("VideoCallStateMonitor", 1, "stopMonitor state error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoCallStateMonitor
 * JD-Core Version:    0.7.0.1
 */