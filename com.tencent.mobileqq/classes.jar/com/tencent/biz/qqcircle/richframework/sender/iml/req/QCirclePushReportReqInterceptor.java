package com.tencent.biz.qqcircle.richframework.sender.iml.req;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import feedcloud.FeedCloudWrite.StDoPushReq;
import java.util.Map;

public class QCirclePushReportReqInterceptor
  extends QCircleBaseReportReqInterceptor<QCircleDoRecommendRequest>
{
  private int d;
  private int e;
  private String f;
  
  private void c(int paramInt)
  {
    if (!TextUtils.isEmpty(this.a))
    {
      if (this.c == null) {
        return;
      }
      this.c.put("xsj_action_type", this.f);
      this.c.put("xsj_push_times", Integer.valueOf(paramInt));
      if (this.b != null)
      {
        VideoReport.reportEvent(this.a, this.b, this.c);
        return;
      }
      VideoReport.reportEvent(this.a, this.c);
    }
  }
  
  private void d(int paramInt)
  {
    QCircleLpReportDc05507.DataBuilder localDataBuilder = b();
    if (localDataBuilder != null)
    {
      localDataBuilder.setExt2(String.valueOf(paramInt));
      int i = this.d;
      if ((i != 0) && (paramInt == 1))
      {
        localDataBuilder.setActionType(i);
      }
      else
      {
        i = this.e;
        if ((i != 0) && (paramInt > 1)) {
          localDataBuilder.setActionType(i);
        }
      }
      QCircleLpReportDc05507.report(localDataBuilder);
    }
  }
  
  private void e(int paramInt)
  {
    QCircleLpReportDc05501.DataBuilder localDataBuilder = a();
    if (localDataBuilder != null)
    {
      localDataBuilder.setExt2(String.valueOf(paramInt));
      int i = this.d;
      if ((i != 0) && (paramInt == 1))
      {
        localDataBuilder.setActionType(i);
      }
      else
      {
        i = this.e;
        if ((i != 0) && (paramInt > 1)) {
          localDataBuilder.setActionType(i);
        }
      }
      QCircleLpReportDc05501.report(localDataBuilder);
    }
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(QCircleDoRecommendRequest paramQCircleDoRecommendRequest, BaseSenderChain paramBaseSenderChain)
  {
    if ((paramQCircleDoRecommendRequest != null) && (paramQCircleDoRecommendRequest.getReq() != null))
    {
      int i = paramQCircleDoRecommendRequest.getReq().comboCount.get();
      if (paramQCircleDoRecommendRequest.getReq().pushType.get() == 0)
      {
        d(i);
        e(i);
      }
      c(i);
      paramBaseSenderChain.a(paramQCircleDoRecommendRequest);
    }
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public void b(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.sender.iml.req.QCirclePushReportReqInterceptor
 * JD-Core Version:    0.7.0.1
 */