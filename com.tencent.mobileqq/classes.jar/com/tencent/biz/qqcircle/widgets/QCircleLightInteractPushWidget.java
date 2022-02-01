package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLightInteractInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.Map;

public class QCircleLightInteractPushWidget
  extends QCircleBaseLightInteractWidget
{
  private QCircleAvatarView e;
  private TextView f;
  private ImageView g;
  private TextView h;
  private QCircleFollowView i;
  private View j;
  private ReportBean<QCircleReportBean> k;
  
  public QCircleLightInteractPushWidget(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a()
  {
    VideoReport.setElementId(this, "em_xsj_user_row");
    Map localMap = new QCircleDTParamBuilder().buildElementParams();
    localMap.put("xsj_parent_emid", "em_xsj_rockets_list");
    VideoReport.setElementParams(this, localMap);
  }
  
  private void a(FeedCloudMeta.StLightInteractInfo paramStLightInteractInfo)
  {
    int m = paramStLightInteractInfo.count.get();
    RFWTypefaceUtil.a(this.h, true);
    paramStLightInteractInfo = this.h;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("x");
    localStringBuilder.append(m);
    paramStLightInteractInfo.setText(localStringBuilder.toString());
    if (m >= 10)
    {
      paramStLightInteractInfo = this.g;
      paramStLightInteractInfo.setImageDrawable(paramStLightInteractInfo.getContext().getResources().getDrawable(2130845091));
      this.j.setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845337));
      this.h.setTextColor(-1);
      return;
    }
    paramStLightInteractInfo = this.g;
    paramStLightInteractInfo.setImageDrawable(paramStLightInteractInfo.getContext().getResources().getDrawable(2130845092));
    this.j.setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845433));
    this.h.setTextColor(QCircleSkinHelper.getInstance().getColor(2131167084));
  }
  
  private void a(FeedCloudMeta.StUser paramStUser)
  {
    this.e.setUser(paramStUser);
    this.f.setText(paramStUser.nick.get());
    paramStUser = new QCircleLightInteractPushWidget.1(this, paramStUser);
    this.e.setOnClickListener(paramStUser);
    this.f.setOnClickListener(paramStUser);
  }
  
  private void b(FeedCloudMeta.StUser paramStUser)
  {
    this.i.setFollowedDismiss(false);
    this.i.setUserData(paramStUser);
    this.i.setFollowStateChangeListener(new QCircleLightInteractPushWidget.2(this));
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
      if (paramInt == 0)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)getLayoutParams();
        if (localLayoutParams != null)
        {
          localLayoutParams.setMargins(0, ViewUtils.a(-1.5F), 0, 0);
          setLayoutParams(localLayoutParams);
        }
        else
        {
          localLayoutParams = new RecyclerView.LayoutParams(-2, -2);
          localLayoutParams.setMargins(0, ViewUtils.a(-1.5F), 0, 0);
          setLayoutParams(localLayoutParams);
        }
      }
      this.b = ((FeedCloudMeta.StLightInteractInfo)paramObject);
      a(this.b.user);
      a(this.b);
      b(this.b.user);
    }
  }
  
  public int getLayoutId()
  {
    return 2131626940;
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
    ReportBean localReportBean = this.k;
    if (localReportBean != null) {
      return QCircleReportBean.getReportBean("QCircleLightInteractPushWidget", (QCircleReportBean)localReportBean.getReportBean());
    }
    return null;
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.e = ((QCircleAvatarView)paramView.findViewById(2131441831));
    this.f = ((TextView)paramView.findViewById(2131441835));
    this.g = ((ImageView)paramView.findViewById(2131441827));
    this.h = ((TextView)paramView.findViewById(2131441828));
    this.j = paramView.findViewById(2131441727);
    this.i = ((QCircleFollowView)paramView.findViewById(2131441833));
    a();
  }
  
  public void setReportBeanAgent(ReportBean<QCircleReportBean> paramReportBean)
  {
    this.k = paramReportBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleLightInteractPushWidget
 * JD-Core Version:    0.7.0.1
 */