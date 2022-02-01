package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bclx;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLightInteractInfo;
import feedcloud.FeedCloudMeta.StUser;
import vxl;
import vxm;
import zxl;

public class QCircleLightInteractPushWidget
  extends QCircleBaseLightInteractWidget
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private QCircleFollowView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView;
  private zxl<QCircleReportBean> jdField_a_of_type_Zxl;
  private TextView b;
  
  public QCircleLightInteractPushWidget(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a(FeedCloudMeta.StLightInteractInfo paramStLightInteractInfo)
  {
    int i = paramStLightInteractInfo.count.get();
    if (i >= 10)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130844052));
      this.b.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130844055));
    this.b.setText(String.valueOf(i));
    this.b.setVisibility(0);
  }
  
  private void a(FeedCloudMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramStUser);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStUser.nick.get());
    paramStUser = new vxl(this, paramStUser);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(paramStUser);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramStUser);
  }
  
  private void b(FeedCloudMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDismiss(false);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedShowToast(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData(paramStUser);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowStateChangeListener(new vxm(this));
  }
  
  public int a()
  {
    return 2131560768;
  }
  
  public QCircleReportBean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getReportBean("QCircleLightInteractPushWidget", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Zxl != null) {
      return QCircleReportBean.getReportBean("QCircleLightInteractPushWidget", (QCircleReportBean)this.jdField_a_of_type_Zxl.getReportBean());
    }
    return null;
  }
  
  protected String a()
  {
    return "QCircleLightInteractPushWidget";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131373899));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373902));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373896));
    this.b = ((TextView)paramView.findViewById(2131373897));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)paramView.findViewById(2131373900));
  }
  
  public void a(AppInterface paramAppInterface, FeedCloudMeta.StFeed paramStFeed, ReportExtraTypeInfo paramReportExtraTypeInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo = paramReportExtraTypeInfo;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, int paramInt)
  {
    RecyclerView.LayoutParams localLayoutParams;
    if ((paramObject instanceof FeedCloudMeta.StLightInteractInfo)) {
      if (paramInt == 0)
      {
        localLayoutParams = (RecyclerView.LayoutParams)getLayoutParams();
        if (localLayoutParams == null) {
          break label79;
        }
        localLayoutParams.setMargins(0, bclx.a(-1.5F), 0, 0);
        setLayoutParams(localLayoutParams);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StLightInteractInfo = ((FeedCloudMeta.StLightInteractInfo)paramObject);
      a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StLightInteractInfo.user);
      a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StLightInteractInfo);
      b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StLightInteractInfo.user);
      return;
      label79:
      localLayoutParams = new RecyclerView.LayoutParams(-2, -2);
      localLayoutParams.setMargins(0, bclx.a(-1.5F), 0, 0);
      setLayoutParams(localLayoutParams);
    }
  }
  
  public void setReportBeanAgent(zxl<QCircleReportBean> paramzxl)
  {
    this.jdField_a_of_type_Zxl = paramzxl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleLightInteractPushWidget
 * JD-Core Version:    0.7.0.1
 */