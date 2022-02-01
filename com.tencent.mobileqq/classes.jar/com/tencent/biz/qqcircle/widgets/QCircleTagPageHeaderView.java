package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import anni;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vys;
import zxs;

public class QCircleTagPageHeaderView
  extends QCircleBaseWidgetView<zxs>
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
    return 2131560785;
  }
  
  protected String a()
  {
    return "QCircleTagPageHeaderView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView = ((AvatarListView)paramView.findViewById(2131363114));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379957));
    this.b = ((TextView)paramView.findViewById(2131379808));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369056));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView = ((QCircleFollowTagView)paramView.findViewById(2131373941));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView.setItemReportListener(new vys(this));
  }
  
  protected void a(zxs paramzxs)
  {
    if ((paramzxs != null) && ((paramzxs.a instanceof FeedCloudMeta.StTagInfo)))
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo = ((FeedCloudMeta.StTagInfo)paramzxs.a);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagName.get());
      this.b.setText(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagTotalUser.get() + anni.a(2131697267));
      paramzxs = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.userList.get().iterator();
      while (localIterator.hasNext()) {
        paramzxs.add(((FeedCloudMeta.StUser)localIterator.next()).id.get());
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setData(paramzxs);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView.setTagInfo(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTagPageHeaderView
 * JD-Core Version:    0.7.0.1
 */