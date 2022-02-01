package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StUser;
import uzg;

public class QCircleBlackListItemView
  extends QCircleBaseWidgetView<FeedCloudMeta.StUser>
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleAddBlackListView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAddBlackListView;
  private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  
  public QCircleBlackListItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131560686;
  }
  
  protected String a()
  {
    return "QCircleBlackListItemView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131373895));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373896));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAddBlackListView = ((QCircleAddBlackListView)paramView.findViewById(2131373894));
  }
  
  protected void a(FeedCloudMeta.StUser paramStUser)
  {
    a(paramStUser, -1);
  }
  
  public void a(FeedCloudMeta.StUser paramStUser, int paramInt)
  {
    if (paramStUser == null) {
      return;
    }
    super.a(paramStUser, paramInt);
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = paramStUser;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.blackState.set(1);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setAvatar(uzg.a(getContext()), paramStUser.id.get());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStUser.nick.get());
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAddBlackListView.setUserData(paramStUser);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleBlackListItemView
 * JD-Core Version:    0.7.0.1
 */