package com.tencent.biz.qqcircle.widgets;

import aabg;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.polylike.flowlayout.QCircleTagFlowLayout;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLightInteractInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import qqcircle.QQCircleFeedBase.LightInteractionBusiData;
import was;
import wat;
import wau;

public class QCircleLightInteractPolyLikeWidget
  extends QCircleBaseLightInteractWidget
{
  private aabg<QCircleReportBean> jdField_a_of_type_Aabg;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleTagFlowLayout jdField_a_of_type_ComTencentBizQqcirclePolylikeFlowlayoutQCircleTagFlowLayout;
  private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private QCircleFollowView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView;
  
  public QCircleLightInteractPolyLikeWidget(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a(FeedCloudMeta.StLightInteractInfo paramStLightInteractInfo)
  {
    QQCircleFeedBase.LightInteractionBusiData localLightInteractionBusiData = new QQCircleFeedBase.LightInteractionBusiData();
    try
    {
      localLightInteractionBusiData.mergeFrom(paramStLightInteractInfo.busiData.get().toByteArray());
      paramStLightInteractInfo = new ArrayList();
      if (localLightInteractionBusiData.polyInfos.size() == 0)
      {
        paramStLightInteractInfo.add(localLightInteractionBusiData.polyInfo);
        this.jdField_a_of_type_ComTencentBizQqcirclePolylikeFlowlayoutQCircleTagFlowLayout.setAdapter(new wau(this, paramStLightInteractInfo));
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramStLightInteractInfo)
    {
      for (;;)
      {
        paramStLightInteractInfo.printStackTrace();
        continue;
        paramStLightInteractInfo.addAll(localLightInteractionBusiData.polyInfos.get());
      }
    }
  }
  
  private void a(FeedCloudMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDismiss(false);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedShowToast(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData(paramStUser);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowStateChangeListener(new was(this));
  }
  
  private void b(FeedCloudMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramStUser);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStUser.nick.get());
    if (paramStUser.id.get().equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get()))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844048);
    }
    for (;;)
    {
      paramStUser = new wat(this, paramStUser);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(paramStUser);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramStUser);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public int a()
  {
    return 2131560773;
  }
  
  public QCircleReportBean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getReportBean("QCircleLightInteractPolyLikeWidget", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Aabg != null) {
      return QCircleReportBean.getReportBean("QCircleLightInteractPolyLikeWidget", (QCircleReportBean)this.jdField_a_of_type_Aabg.getReportBean());
    }
    return null;
  }
  
  protected String a()
  {
    return "QCircleLightInteractPolyLikeWidget";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131374006));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374011));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131374013));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)paramView.findViewById(2131374007));
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeFlowlayoutQCircleTagFlowLayout = ((QCircleTagFlowLayout)paramView.findViewById(2131374078));
  }
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof FeedCloudMeta.StLightInteractInfo))
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StLightInteractInfo = ((FeedCloudMeta.StLightInteractInfo)paramObject);
      this.b = paramInt;
      b(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StLightInteractInfo.user);
      a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StLightInteractInfo);
      a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StLightInteractInfo.user);
    }
  }
  
  public void setReportBeanAgent(aabg<QCircleReportBean> paramaabg)
  {
    this.jdField_a_of_type_Aabg = paramaabg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleLightInteractPolyLikeWidget
 * JD-Core Version:    0.7.0.1
 */