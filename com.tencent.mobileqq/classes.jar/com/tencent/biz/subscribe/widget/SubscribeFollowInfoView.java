package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.subscribe.SubImageLoader;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.SquareImageView;

public class SubscribeFollowInfoView
  extends BaseWidgetView<CertifiedAccountMeta.StFeed>
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FollowTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  
  public SubscribeFollowInfoView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public SubscribeFollowInfoView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public SubscribeFollowInfoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected int a()
  {
    return 2131558744;
  }
  
  protected void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    SubscribeFollowInfoView.1 local1 = new SubscribeFollowInfoView.1(this, paramStFeed);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
    if (localObject != null)
    {
      ((SquareImageView)localObject).getLayoutParams().width = ScreenUtil.dip2px(27.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().height = ScreenUtil.dip2px(27.0F);
      SubImageLoader.a(paramStFeed.poster.icon.get(), this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setOnClickListener(local1);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      ((TextView)localObject).setText(paramStFeed.poster.nick.get());
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(local1);
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView != null)
    {
      if (SubscribeUtils.a(paramStFeed.poster.attr.get()))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setFeedData(paramStFeed);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setExtraTypeInfo(a());
    }
  }
  
  protected void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131369284));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379529));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView = ((FollowTextView)paramView.findViewById(2131379687));
  }
  
  protected boolean a()
  {
    return (a() != null) && (StringUtil.a(((CertifiedAccountMeta.StFeed)a()).poster.nick.get()));
  }
  
  public void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
      if (localObject != null)
      {
        ((SquareImageView)localObject).getLayoutParams().width = ScreenUtil.dip2px(27.0F);
        this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().height = ScreenUtil.dip2px(27.0F);
        SubImageLoader.a(paramStFeed.poster.icon.get(), this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setText(paramStFeed.poster.nick.get());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeFollowInfoView
 * JD-Core Version:    0.7.0.1
 */