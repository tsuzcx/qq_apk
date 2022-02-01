package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLightInteractInfo;
import qqcircle.QQCircleFeedBase.LightInteractionBusiData;

public class QCircleLightInteractDividerWidget
  extends QCircleBaseLightInteractWidget
{
  private ReportBean<QCircleReportBean> e;
  private TextView f;
  
  public QCircleLightInteractDividerWidget(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, QCircleExtraTypeInfo paramQCircleExtraTypeInfo, int paramInt)
  {
    this.a = paramStFeed;
    this.d = paramQCircleExtraTypeInfo;
    this.c = paramInt;
  }
  
  protected void bindData(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof FeedCloudMeta.StLightInteractInfo))
    {
      FeedCloudMeta.StLightInteractInfo localStLightInteractInfo = (FeedCloudMeta.StLightInteractInfo)paramObject;
      paramObject = new QQCircleFeedBase.LightInteractionBusiData();
      try
      {
        paramObject.mergeFrom(localStLightInteractInfo.busiData.get().toByteArray());
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      this.f.setText(paramObject.splitItemText.get());
    }
  }
  
  public int getLayoutId()
  {
    return 2131626858;
  }
  
  protected String getLogTag()
  {
    return "QCircleLightInteractPushWidget";
  }
  
  public QCircleReportBean getReportBean()
  {
    if (this.mReportBean != null) {
      return QCircleReportBean.getReportBean("QCircleLightInteractPushWidget", this.mReportBean);
    }
    ReportBean localReportBean = this.e;
    if (localReportBean != null) {
      return QCircleReportBean.getReportBean("QCircleLightInteractPushWidget", (QCircleReportBean)localReportBean.getReportBean());
    }
    return null;
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.f = ((TextView)paramView.findViewById(2131441906));
  }
  
  public void setReportBeanAgent(ReportBean<QCircleReportBean> paramReportBean)
  {
    this.e = paramReportBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleLightInteractDividerWidget
 * JD-Core Version:    0.7.0.1
 */