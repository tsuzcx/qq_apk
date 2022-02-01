package com.tencent.biz.qqcircle.richframework.outbox;

import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.publish.queue.util.NeedParcel;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;

public class QCircleSenderTask
  extends QCircleOutboxTask
{
  public QCircleBaseRequest j;
  @NeedParcel
  public String k;
  @NeedParcel
  public String l;
  @NeedParcel
  public long m;
  @NeedParcel
  public String n;
  public BaseSenderChain o;
  
  public QCircleSenderTask() {}
  
  public QCircleSenderTask(QCircleBaseRequest paramQCircleBaseRequest, BaseSenderChain paramBaseSenderChain)
  {
    this.j = paramQCircleBaseRequest;
    this.e = paramQCircleBaseRequest.getRequestByteKey();
    this.k = paramQCircleBaseRequest.getCmdName();
    paramQCircleBaseRequest = new StringBuilder();
    paramQCircleBaseRequest.append(this.k);
    paramQCircleBaseRequest.append(HostDataTransUtils.getAccount());
    paramQCircleBaseRequest.append(HostDataTransUtils.getQUA3());
    paramQCircleBaseRequest.append(new String(this.e));
    this.l = paramQCircleBaseRequest.toString();
    this.o = paramBaseSenderChain;
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString)
  {
    if (paramBoolean)
    {
      localObject1 = "0";
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject1 = QCircleReportHelper.newEntry("ret_code", (String)localObject1);
    paramString = QCircleReportHelper.newEntry("url", paramString);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.k);
    ((StringBuilder)localObject2).append("");
    localObject2 = QCircleReportHelper.newEntry("refer", ((StringBuilder)localObject2).toString());
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.c);
    ((StringBuilder)localObject3).append("");
    localObject3 = QCircleReportHelper.newEntry("count", ((StringBuilder)localObject3).toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("_");
    localStringBuilder.append(Arrays.toString(this.f));
    localStringBuilder.append("_");
    localStringBuilder.append(this.m);
    localStringBuilder.append("_");
    localStringBuilder.append(this.n);
    localStringBuilder.append("_state=");
    localStringBuilder.append(b());
    QCircleQualityReporter.reportQualityEvent("outbox_task_resend_event", Arrays.asList(new FeedCloudCommon.Entry[] { localObject1, paramString, localObject2, localObject3, QCircleReportHelper.newEntry("attach_info", localStringBuilder.toString()) }), false);
  }
  
  public long a()
  {
    return super.a();
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append("QCircleSenderTask");
      paramString1 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" id:");
      localStringBuilder.append(a());
      localStringBuilder.append(" ,state:");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" ,cmd:");
      localStringBuilder.append(this.k);
      localStringBuilder.append(" ,resultCode:");
      localStringBuilder.append(this.m);
      localStringBuilder.append(" ,errMsg:");
      localStringBuilder.append(this.n);
      QLog.e(paramString1, 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("QCircleSenderTask");
    paramString1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" id:");
    localStringBuilder.append(a());
    localStringBuilder.append(" ,state:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" ,cmd:");
    localStringBuilder.append(this.k);
    QLog.d(paramString1, 1, localStringBuilder.toString());
  }
  
  public void c()
  {
    this.j = null;
    this.o = null;
  }
  
  public void d()
  {
    this.c += 1;
  }
  
  public void e()
  {
    if ((this.j == null) && (!k())) {
      this.j = new QCircleSenderRequest(this.k, this.e);
    }
  }
  
  public void f() {}
  
  public boolean k()
  {
    return (this.j == null) && (this.e == null);
  }
  
  public String n()
  {
    return this.k;
  }
  
  protected String o()
  {
    return "QCircleSenderTask";
  }
  
  public void p()
  {
    if (4 == this.d)
    {
      QLog.i("QCircleSenderTask", 1, "QCircleSenderTask.run is already removed");
      return;
    }
    q();
    this.b = System.currentTimeMillis();
  }
  
  public void q()
  {
    if (this.j == null) {
      this.j = new QCircleSenderRequest(this.k, this.e, this.f);
    }
    VSNetworkHelper.getInstance().sendRequest(this.j, new QCircleSenderTask.1(this));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doRun id:");
    localStringBuilder.append(a());
    QLog.i("QCircleSenderTask", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.outbox.QCircleSenderTask
 * JD-Core Version:    0.7.0.1
 */