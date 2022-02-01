package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.polylike.flowlayout.QCircleTagFlowLayout;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLightInteractInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Map;
import qqcircle.QQCircleFeedBase.LightInteractionBusiData;

public class QCircleLightInteractPolyLikeWidget
  extends QCircleBaseLightInteractWidget
{
  private QCircleAvatarView e;
  private TextView f;
  private ImageView g;
  private QCircleFollowView h;
  private ReportBean<QCircleReportBean> i;
  private QCircleTagFlowLayout j;
  
  public QCircleLightInteractPolyLikeWidget(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a()
  {
    VideoReport.setElementId(this, "em_xsj_user_row");
    Map localMap = new QCircleDTParamBuilder().buildElementParams();
    localMap.put("xsj_parent_emid", "em_xsj_likes_list");
    VideoReport.setElementParams(this, localMap);
  }
  
  private void a(FeedCloudMeta.StLightInteractInfo paramStLightInteractInfo)
  {
    QQCircleFeedBase.LightInteractionBusiData localLightInteractionBusiData = new QQCircleFeedBase.LightInteractionBusiData();
    try
    {
      localLightInteractionBusiData.mergeFrom(paramStLightInteractInfo.busiData.get().toByteArray());
    }
    catch (InvalidProtocolBufferMicroException paramStLightInteractInfo)
    {
      paramStLightInteractInfo.printStackTrace();
    }
    paramStLightInteractInfo = new ArrayList();
    if (localLightInteractionBusiData.polyInfos.size() == 0) {
      paramStLightInteractInfo.add(localLightInteractionBusiData.polyInfo);
    } else {
      paramStLightInteractInfo.addAll(localLightInteractionBusiData.polyInfos.get());
    }
    this.j.setAdapter(new QCircleLightInteractPolyLikeWidget.PolyTagAdapter(this, paramStLightInteractInfo));
  }
  
  private void a(FeedCloudMeta.StUser paramStUser)
  {
    this.h.setFollowedDismiss(false);
    this.h.setUserData(paramStUser);
    this.h.setFollowStateChangeListener(new QCircleLightInteractPolyLikeWidget.1(this));
  }
  
  private void b(FeedCloudMeta.StUser paramStUser)
  {
    this.e.setUser(paramStUser);
    this.f.setText(paramStUser.nick.get());
    if (paramStUser.id.get().equals(this.a.poster.id.get()))
    {
      this.g.setVisibility(0);
      this.g.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845329));
    }
    else
    {
      this.g.setVisibility(8);
    }
    paramStUser = new QCircleLightInteractPolyLikeWidget.2(this, paramStUser);
    this.e.setOnClickListener(paramStUser);
    this.f.setOnClickListener(paramStUser);
  }
  
  protected void bindData(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof FeedCloudMeta.StLightInteractInfo))
    {
      this.b = ((FeedCloudMeta.StLightInteractInfo)paramObject);
      b(this.b.user);
      a(this.b);
      a(this.b.user);
    }
  }
  
  public int getLayoutId()
  {
    return 2131626907;
  }
  
  protected String getLogTag()
  {
    return "QCircleLightInteractPolyLikeWidget";
  }
  
  public QCircleReportBean getReportBean()
  {
    if (this.mReportBean != null) {
      return QCircleReportBean.getReportBean("QCircleLightInteractPolyLikeWidget", this.mReportBean);
    }
    ReportBean localReportBean = this.i;
    if (localReportBean != null) {
      return QCircleReportBean.getReportBean("QCircleLightInteractPolyLikeWidget", (QCircleReportBean)localReportBean.getReportBean());
    }
    return null;
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.e = ((QCircleAvatarView)paramView.findViewById(2131441779));
    this.f = ((TextView)paramView.findViewById(2131441784));
    this.g = ((ImageView)paramView.findViewById(2131441786));
    this.h = ((QCircleFollowView)paramView.findViewById(2131441780));
    this.j = ((QCircleTagFlowLayout)paramView.findViewById(2131441893));
    a();
  }
  
  public void setReportBeanAgent(ReportBean<QCircleReportBean> paramReportBean)
  {
    this.i = paramReportBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleLightInteractPolyLikeWidget
 * JD-Core Version:    0.7.0.1
 */