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
import bdje;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleDitto.StButton;
import qqcircle.QQCircleDitto.StItemInfo;
import tql;
import tqr;
import tyj;
import uce;

public class QCirclePushRankItemView
  extends BaseWidgetView<QQCircleDitto.StItemInfo>
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 1;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  QCircleFollowView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  TextView b;
  TextView c;
  
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
  
  @NotNull
  private FeedCloudMeta.StUser a(QQCircleDitto.StItemInfo paramStItemInfo)
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(paramStItemInfo.id.get());
    localStUser.followState.set(paramStItemInfo.buttonInfo.buttonValue.get());
    localStUser.nick.set(paramStItemInfo.name.get());
    return localStUser;
  }
  
  public int a()
  {
    return 2131560569;
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
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368921));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131372545));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368868));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378844));
    this.b = ((TextView)paramView.findViewById(2131378878));
    this.c = ((TextView)paramView.findViewById(2131378879));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)paramView.findViewById(2131373237));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedTextColor(-1);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowTextColor(-1);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedShowToast(true);
    paramContext = "";
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      tql.a(paramContext, this.jdField_a_of_type_ComTencentImageURLImageView, new ColorDrawable(getResources().getColor(2131166178)));
      setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
      return;
      paramContext = "https://qzonestyle.gtimg.cn/aoi/sola/20200331161054_JaSN6DXnkA.png";
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843655);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130843649);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130843652);
      continue;
      paramContext = "https://qzonestyle.gtimg.cn/aoi/sola/20200331161054_qobdcpSIsN.png";
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843656);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130843650);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130843653);
      continue;
      paramContext = "https://qzonestyle.gtimg.cn/aoi/sola/20200331161054_WgBM4iDm6a.png";
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843657);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUnFollowDrawable(2130843651);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDrawable(2130843654);
    }
  }
  
  protected void a(QQCircleDitto.StItemInfo paramStItemInfo)
  {
    FeedCloudMeta.StUser localStUser = a(paramStItemInfo);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(((BaseActivity)getContext()).app, localStUser);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData(localStUser);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setItemPreClickListener(new uce(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localStUser.nick.get());
    if (paramStItemInfo.des.size() > 0) {
      this.b.setText((CharSequence)paramStItemInfo.des.get(0));
    }
    if (paramStItemInfo.des.size() > 1) {
      this.c.setText((CharSequence)paramStItemInfo.des.get(1));
    }
  }
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = tqr.a(((QQCircleDitto.StItemInfo)a()).urlInfo.get(), "RankItemUrl");
      if (bdje.a(paramView)) {
        QLog.w("QCirclePushRankItemView", 1, "rank item url is empty");
      }
      Intent localIntent = new Intent(getContext(), JumpActivity.class);
      localIntent.setData(Uri.parse(paramView));
      getContext().startActivity(localIntent);
      tyj.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 9, 2L, 0L);
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushRankItemView
 * JD-Core Version:    0.7.0.1
 */