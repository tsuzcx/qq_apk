package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabNormalRedDotReporter;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/common/RIJTabFrameBase$FeedsOperation;", "", "()V", "operationBitmap", "", "getOperationBitmap", "()I", "setOperationBitmap", "(I)V", "tabFrameVisibleTimeMillis", "", "userStayInTabFrameTimeMillis", "getUserStayInTabFrameTimeMillis", "()J", "setUserStayInTabFrameTimeMillis", "(J)V", "reset", "", "setOperationFlag", "operationBitFlag", "channelId", "startTabFrameStayTimeCalculate", "stopTabFrameStayTimeCalculate", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJTabFrameBase$FeedsOperation
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private long b;
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public final void a()
  {
    RIJXTabNormalRedDotReporter.a.a();
    this.jdField_a_of_type_Int = 0;
    ReadinjoyReportUtils.b();
    this.jdField_a_of_type_Long = 0L;
    QLog.d("RIJTabFrameBase", 1, "reset feeds operation");
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    RIJXTabNormalRedDotReporter.a.a(paramInt2, paramInt1);
    this.jdField_a_of_type_Int |= paramInt1;
    QLog.d("RIJTabFrameBase", 1, "set operation flag : " + paramInt1);
    ReadinjoyReportUtils.a(paramInt1);
  }
  
  public final void b()
  {
    this.jdField_a_of_type_Long += NetConnInfoCenter.getServerTimeMillis() - this.b;
  }
  
  public final void c()
  {
    this.b = NetConnInfoCenter.getServerTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase.FeedsOperation
 * JD-Core Version:    0.7.0.1
 */