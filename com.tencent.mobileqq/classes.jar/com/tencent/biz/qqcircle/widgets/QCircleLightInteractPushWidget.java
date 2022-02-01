package com.tencent.biz.qqcircle.widgets;

import aabg;
import aadv;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bdep;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLightInteractInfo;
import feedcloud.FeedCloudMeta.StUser;
import wav;
import waw;

public class QCircleLightInteractPushWidget
  extends QCircleBaseLightInteractWidget
{
  private aabg<QCircleReportBean> jdField_a_of_type_Aabg;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private QCircleFollowView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView;
  private TextView b;
  
  public QCircleLightInteractPushWidget(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a(FeedCloudMeta.StLightInteractInfo paramStLightInteractInfo)
  {
    int i = paramStLightInteractInfo.count.get();
    aadv.a(this.b, true);
    this.b.setText("x" + i);
    if (i >= 10)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130844070));
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130843909);
      this.b.setTextColor(-1);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130844073));
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130844100);
    this.b.setTextColor(-16777216);
  }
  
  private void a(FeedCloudMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramStUser);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStUser.nick.get());
    paramStUser = new wav(this, paramStUser);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(paramStUser);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramStUser);
  }
  
  private void b(FeedCloudMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDismiss(false);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedShowToast(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData(paramStUser);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowStateChangeListener(new waw(this));
  }
  
  public int a()
  {
    return 2131560793;
  }
  
  public QCircleReportBean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getReportBean("QCircleLightInteractPushWidget", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Aabg != null) {
      return QCircleReportBean.getReportBean("QCircleLightInteractPushWidget", (QCircleReportBean)this.jdField_a_of_type_Aabg.getReportBean());
    }
    return null;
  }
  
  protected String a()
  {
    return "QCircleLightInteractPushWidget";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131374033));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374037));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131374031));
    this.b = ((TextView)paramView.findViewById(2131374032));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373980);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)paramView.findViewById(2131374035));
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
        localLayoutParams.setMargins(0, bdep.a(-1.5F), 0, 0);
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
      localLayoutParams.setMargins(0, bdep.a(-1.5F), 0, 0);
      setLayoutParams(localLayoutParams);
    }
  }
  
  public void setReportBeanAgent(aabg<QCircleReportBean> paramaabg)
  {
    this.jdField_a_of_type_Aabg = paramaabg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleLightInteractPushWidget
 * JD-Core Version:    0.7.0.1
 */