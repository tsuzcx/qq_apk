package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import bgsp;
import bgtn;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleDitto.StButton;
import qqcircle.QQCircleDitto.StItemContainer;
import qqcircle.QQCircleDitto.StItemInfo;
import uxh;
import uxn;
import vrf;
import vxs;
import vxt;

public class QCirclePushRankItemView
  extends QCircleBaseWidgetView<QQCircleDitto.StItemContainer>
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 1;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private QCircleFollowView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView;
  private RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private QQCircleDitto.StItemInfo jdField_a_of_type_QqcircleQQCircleDitto$StItemInfo;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private RoundCornerImageView jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  
  public QCirclePushRankItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCirclePushRankItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCirclePushRankItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2)) {
      return 1;
    }
    return 0;
  }
  
  @NotNull
  private FeedCloudMeta.StUser a(QQCircleDitto.StItemInfo paramStItemInfo)
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(paramStItemInfo.id.get());
    localStUser.followState.set(a(paramStItemInfo.buttonInfo.buttonValue.get()));
    localStUser.nick.set(paramStItemInfo.name.get());
    return localStUser;
  }
  
  public int a()
  {
    return 2131560769;
  }
  
  protected String a()
  {
    return "QCirclePushRankItemView";
  }
  
  public void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QCirclePushRankItemView);
    if (paramContext != null)
    {
      this.jdField_a_of_type_Int = paramContext.getInt(0, 1);
      paramContext.recycle();
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131369315));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131373181));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)paramView.findViewById(2131369094));
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)paramView.findViewById(2131369096));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379785));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379828));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369208));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373904));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)paramView.findViewById(2131373989));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedShowToast(true);
    setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
  }
  
  protected void a(QQCircleDitto.StItemContainer paramStItemContainer)
  {
    if (paramStItemContainer == null) {}
    while ((paramStItemContainer.items == null) || (paramStItemContainer.items.size() < this.jdField_a_of_type_Int)) {
      return;
    }
    this.jdField_a_of_type_QqcircleQQCircleDitto$StItemInfo = ((QQCircleDitto.StItemInfo)paramStItemContainer.items.get(this.jdField_a_of_type_Int - 1));
    FeedCloudMeta.StUser localStUser = a(this.jdField_a_of_type_QqcircleQQCircleDitto$StItemInfo);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(((BaseActivity)getContext()).app, localStUser);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setItemPreClickListener(new vxs(this));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowStateChangeListener(new vxt(this, paramStItemContainer));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localStUser.nick.get());
    if (this.jdField_a_of_type_QqcircleQQCircleDitto$StItemInfo.des.size() > 0) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)this.jdField_a_of_type_QqcircleQQCircleDitto$StItemInfo.des.get(0));
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      label184:
      switch (paramStItemContainer.containerType.get())
      {
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130843931);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData(localStUser);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(bgtn.b(8.0F));
      this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(bgtn.b(8.0F));
      if ((this.jdField_a_of_type_QqcircleQQCircleDitto$StItemInfo.images.get() == null) || (this.jdField_a_of_type_QqcircleQQCircleDitto$StItemInfo.images.get().size() <= 0)) {
        break;
      }
      paramStItemContainer = (FeedCloudMeta.StImage)this.jdField_a_of_type_QqcircleQQCircleDitto$StItemInfo.images.get(0);
      if ((paramStItemContainer == null) || (paramStItemContainer.picUrl.get() == null)) {
        break;
      }
      uxh.a(paramStItemContainer.picUrl.get(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, getResources().getDrawable(2130844019));
      return;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130844070);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844073);
      uxh.a("https://sola.gtimg.cn/aoi/sola/20200623154422_w42NLL8ijc.png", this.jdField_a_of_type_ComTencentImageURLImageView, new ColorDrawable(getResources().getColor(2131166233)));
      break label184;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130844070);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844072);
      uxh.a("https://sola.gtimg.cn/aoi/sola/20200623154420_cLrwyWNcQ2.png", this.jdField_a_of_type_ComTencentImageURLImageView, new ColorDrawable(getResources().getColor(2131166233)));
      break label184;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130844070);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844074);
      uxh.a("https://sola.gtimg.cn/aoi/sola/20200623154424_iTsZYrPgUW.png", this.jdField_a_of_type_ComTencentImageURLImageView, new ColorDrawable(getResources().getColor(2131166233)));
      break label184;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130844068));
      continue;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130843916));
    }
  }
  
  public void onClick(View paramView)
  {
    try
    {
      String str = uxn.a(this.jdField_a_of_type_QqcircleQQCircleDitto$StItemInfo.urlInfo.get(), "RankItemUrl");
      if (bgsp.a(str)) {
        QLog.w("QCirclePushRankItemView", 1, "rank item url is empty");
      }
      Intent localIntent = new Intent(getContext(), JumpActivity.class);
      localIntent.setData(Uri.parse(str));
      getContext().startActivity(localIntent);
      if (a() != null) {
        vrf.a("", 9, 2, 0, ((QQCircleDitto.StItemContainer)a()).containerType.get() + "", "", "", "", "", this.jdField_a_of_type_ArrayOfByte, d(), -1);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setRank(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setReportInfo(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushRankItemView
 * JD-Core Version:    0.7.0.1
 */