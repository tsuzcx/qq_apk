package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCircleTopTagEvent;
import com.tencent.biz.qqcircle.requests.QCircleDoFollowTagRequest;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StTagInfo;
import udo;
import udp;
import yiw;

public class QCircleFollowTagListItemView
  extends BaseWidgetView<FeedCloudMeta.StTagInfo>
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FeedCloudMeta.StTagInfo jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  
  public QCircleFollowTagListItemView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a()
  {
    return 2131560554;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366655));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366657));
    this.b = ((TextView)paramView.findViewById(2131366656));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366654);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new udo(this));
  }
  
  public void a(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    a(paramStTagInfo, -1);
  }
  
  public void a(FeedCloudMeta.StTagInfo paramStTagInfo, int paramInt)
  {
    if (paramStTagInfo == null) {
      return;
    }
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo = paramStTagInfo;
    if (!TextUtils.isEmpty(((FeedCloudMeta.StTagInfo)paramStTagInfo.get()).tagName.get())) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((FeedCloudMeta.StTagInfo)paramStTagInfo.get()).tagName.get());
    }
    this.b.setText(String.format(getResources().getString(2131698322), new Object[] { String.valueOf(((FeedCloudMeta.StTagInfo)paramStTagInfo.get()).tagTotalUser.get()) }));
    if (this.jdField_a_of_type_Boolean)
    {
      if (((FeedCloudMeta.StTagInfo)paramStTagInfo.get()).isTop.get() == 1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843752);
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166183);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843754);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166182);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo == null)
    {
      QLog.e("QCircleFollowTagListItemView", 1, "follow tag failed! mTagInfo == null");
      return;
    }
    int i;
    Object localObject;
    if (paramBoolean)
    {
      i = 2;
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo != null)
      {
        ((FeedCloudMeta.StTagInfo)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.get()).followState.set(i);
        localObject = ((FeedCloudMeta.StTagInfo)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.get()).isTop;
        if (!paramBoolean) {
          break label135;
        }
      }
    }
    label135:
    for (int j = 1;; j = 0)
    {
      ((PBUInt32Field)localObject).set(j);
      yiw.a().a(new QCircleTopTagEvent(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo, i));
      localObject = new QCircleDoFollowTagRequest(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagName.get(), i, null);
      VSNetworkHelper.a().a((VSBaseRequest)localObject, new udp(this, paramBoolean));
      return;
      i = 3;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFollowTagListItemView
 * JD-Core Version:    0.7.0.1
 */