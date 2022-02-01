package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StUserRecomInfo;
import java.util.List;
import qqcircle.QQCircleFeedBase.StUinBannerData;
import qqcircle.QQCircleFeedBase.StUserRecomInfoBusiData;
import uxo;
import uxx;
import vrf;
import vxa;

public class QCircleFollowUserListItemView
  extends QCircleBaseWidgetView<FeedCloudMeta.StUserRecomInfo>
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private QCircleFollowView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private QCircleAvatarView jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private String jdField_b_of_type_JavaLangString;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private QCircleAvatarView jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private QCircleAvatarView jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  
  public QCircleFollowUserListItemView(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 2131560716;
  }
  
  protected String a()
  {
    return "QCircleFollowUserListItemView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131373829));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131373824));
    this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131373826));
    this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131373825));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373834));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373831));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373830));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373822));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131373832));
    this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundURL("https://sola.gtimg.cn/aoi/sola/20200619175130_E9peEWVngd.png");
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)paramView.findViewById(2131373828));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setItemReportListener(new vxa(this));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373833);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131373827);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  protected void a(FeedCloudMeta.StUserRecomInfo paramStUserRecomInfo)
  {
    a(paramStUserRecomInfo, -1);
  }
  
  public void a(FeedCloudMeta.StUserRecomInfo paramStUserRecomInfo, int paramInt)
  {
    if (paramStUserRecomInfo == null) {
      return;
    }
    super.a(paramStUserRecomInfo, paramInt);
    QQCircleFeedBase.StUserRecomInfoBusiData localStUserRecomInfoBusiData = new QQCircleFeedBase.StUserRecomInfoBusiData();
    try
    {
      localStUserRecomInfoBusiData.mergeFrom(paramStUserRecomInfo.busiData.get().toByteArray());
      if (localStUserRecomInfoBusiData.pattonType.get() == 1)
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        if ((localStUserRecomInfoBusiData.bannerData != null) && (localStUserRecomInfoBusiData.bannerData.text.get() != null) && (!TextUtils.isEmpty(localStUserRecomInfoBusiData.bannerData.text.get()))) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(localStUserRecomInfoBusiData.bannerData.text.get());
        }
        if ((localStUserRecomInfoBusiData.bannerData != null) && (localStUserRecomInfoBusiData.bannerData.userList.get() != null) && (!localStUserRecomInfoBusiData.bannerData.userList.get().isEmpty()))
        {
          if (localStUserRecomInfoBusiData.bannerData.userList.get().size() == 1)
          {
            this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setAvatar(uxx.a(getContext()), ((FeedCloudMeta.StUser)localStUserRecomInfoBusiData.bannerData.userList.get().get(0)).id.get());
            this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setVisibility(0);
            this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setVisibility(8);
            this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setVisibility(8);
          }
        }
        else
        {
          if (localStUserRecomInfoBusiData.recomSource.get() != 1) {
            break label782;
          }
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
          return;
        }
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        continue;
        if (localStUserRecomInfoBusiData.bannerData.userList.get().size() == 2)
        {
          this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setAvatar(uxx.a(getContext()), ((FeedCloudMeta.StUser)localStUserRecomInfoBusiData.bannerData.userList.get().get(0)).id.get());
          this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setAvatar(uxx.a(getContext()), ((FeedCloudMeta.StUser)localStUserRecomInfoBusiData.bannerData.userList.get().get(1)).id.get());
          this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setVisibility(0);
          this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setVisibility(0);
          this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setVisibility(8);
        }
        else if (localStUserRecomInfoBusiData.bannerData.userList.get().size() > 2)
        {
          this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setAvatar(uxx.a(getContext()), ((FeedCloudMeta.StUser)localStUserRecomInfoBusiData.bannerData.userList.get().get(0)).id.get());
          this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setAvatar(uxx.a(getContext()), ((FeedCloudMeta.StUser)localStUserRecomInfoBusiData.bannerData.userList.get().get(1)).id.get());
          this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setAvatar(uxx.a(getContext()), ((FeedCloudMeta.StUser)localStUserRecomInfoBusiData.bannerData.userList.get().get(2)).id.get());
          this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setVisibility(0);
          this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setVisibility(0);
          this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setVisibility(0);
        }
        else
        {
          this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setVisibility(8);
          this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setVisibility(8);
          this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setVisibility(8);
        }
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setAvatar(uxx.a(getContext()), paramStUserRecomInfo.user.id.get());
      this.jdField_b_of_type_JavaLangString = paramStUserRecomInfo.user.id.get();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStUserRecomInfo.user.nick.get());
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramStUserRecomInfo.user.desc.get());
      URLImageView localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
      if (paramStUserRecomInfo.user.frdState.get() == 1)
      {
        paramInt = 0;
        label696:
        localURLImageView.setVisibility(paramInt);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData(paramStUserRecomInfo.user);
        if (this.jdField_b_of_type_Int == -1) {
          if (paramStUserRecomInfo.user.followState.get() != 0) {
            break label774;
          }
        }
      }
      label774:
      for (this.jdField_b_of_type_Int = 1; this.jdField_b_of_type_Int == 1; this.jdField_b_of_type_Int = 0)
      {
        vrf.a("", 11, 29, 3, this.jdField_b_of_type_JavaLangString, null, null, null, null);
        break;
        paramInt = 8;
        break label696;
      }
      label782:
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 28;
    switch (paramView.getId())
    {
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        uxo.a(this.jdField_a_of_type_JavaLangString);
        vrf.a("", 11, 28, 5);
      }
    } while (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
    uxo.a(this.jdField_b_of_type_JavaLangString, a().clone());
    String str = this.jdField_b_of_type_JavaLangString;
    if (this.jdField_a_of_type_Int == 0) {}
    for (;;)
    {
      vrf.a(str, 11, i, 2);
      break;
      i = 30;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFollowUserListItemView
 * JD-Core Version:    0.7.0.1
 */