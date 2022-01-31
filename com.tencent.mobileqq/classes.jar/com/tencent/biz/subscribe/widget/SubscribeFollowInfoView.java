package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import azkz;
import bdnn;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.SquareImageView;
import ybm;
import ybu;
import ynw;

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
  
  public int a()
  {
    return 2131558709;
  }
  
  protected void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    ynw localynw = new ynw(this, paramStFeed);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().width = azkz.a(27.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().height = azkz.a(27.0F);
      ybm.a(paramStFeed.poster.icon.get(), this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setOnClickListener(localynw);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStFeed.poster.nick.get());
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(localynw);
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView != null)
    {
      if (ybu.a(paramStFeed.poster.attr.get())) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setFeedData(paramStFeed);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setExtraTypeInfo(a());
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131368704));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378663));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView = ((FollowTextView)paramView.findViewById(2131378803));
  }
  
  public boolean a()
  {
    return (a() != null) && (bdnn.a(((CertifiedAccountMeta.StFeed)a()).poster.nick.get()));
  }
  
  public void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().width = azkz.a(27.0F);
        this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().height = azkz.a(27.0F);
        ybm.a(paramStFeed.poster.icon.get(), this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStFeed.poster.nick.get());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeFollowInfoView
 * JD-Core Version:    0.7.0.1
 */