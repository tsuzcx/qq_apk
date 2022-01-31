package com.tencent.biz.qqcircle.widgets;

import alud;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ufs;
import yif;

public class QCircleTagPageHeaderView
  extends BaseWidgetView<yif>
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AvatarListView jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView;
  private QCircleFollowTagView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView;
  private FeedCloudMeta.StTagInfo jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo;
  private TextView b;
  
  public QCircleTagPageHeaderView(@NonNull Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
  }
  
  public int a()
  {
    return 2131560593;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView = ((AvatarListView)paramView.findViewById(2131363000));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379043));
    this.b = ((TextView)paramView.findViewById(2131378918));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368719));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView = ((QCircleFollowTagView)paramView.findViewById(2131373248));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView.setItemReportListener(new ufs(this));
  }
  
  protected void a(yif paramyif)
  {
    if ((paramyif != null) && ((paramyif.a instanceof FeedCloudMeta.StTagInfo)))
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo = ((FeedCloudMeta.StTagInfo)paramyif.a);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagName.get());
      this.b.setText(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagTotalUser.get() + alud.a(2131698390));
      paramyif = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.userList.get().iterator();
      while (localIterator.hasNext()) {
        paramyif.add(((FeedCloudMeta.StUser)localIterator.next()).id.get());
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setData(paramyif);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView.setTagInfo(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTagPageHeaderView
 * JD-Core Version:    0.7.0.1
 */