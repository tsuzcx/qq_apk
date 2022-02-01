package com.tencent.biz.qqcircle.widgets;

import aabn;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import anzj;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wce;

public class QCircleTagPageHeaderView
  extends QCircleBaseWidgetView<aabn>
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleAvatarListView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarListView;
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
    return 2131560811;
  }
  
  protected String a()
  {
    return "QCircleTagPageHeaderView";
  }
  
  protected void a(aabn paramaabn)
  {
    if ((paramaabn != null) && ((paramaabn.a instanceof FeedCloudMeta.StTagInfo)))
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo = ((FeedCloudMeta.StTagInfo)paramaabn.a);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagName.get());
      this.b.setText(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagTotalUser.get() + anzj.a(2131697345));
      paramaabn = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.userList.get().iterator();
      while (localIterator.hasNext()) {
        paramaabn.add(((FeedCloudMeta.StUser)localIterator.next()).id.get());
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarListView.setData(paramaabn);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView.setTagInfo(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo);
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarListView = ((QCircleAvatarListView)paramView.findViewById(2131363135));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380141));
    this.b = ((TextView)paramView.findViewById(2131379988));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369145));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView = ((QCircleFollowTagView)paramView.findViewById(2131374079));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView.setItemReportListener(new wce(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTagPageHeaderView
 * JD-Core Version:    0.7.0.1
 */