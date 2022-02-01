package com.tencent.mobileqq.activity.shopping;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedBaseHeaderView;
import com.tencent.image.URLDrawable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ShoppingHeadView
  extends RelativeFeedBaseHeaderView
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ItemCountView jdField_a_of_type_ComTencentMobileqqActivityShoppingItemCountView;
  ShoppingHeadView.OnClickEventListener jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingHeadView$OnClickEventListener;
  private ItemCountView b;
  private ItemCountView c;
  private ItemCountView d;
  
  public ShoppingHeadView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(ItemCountView paramItemCountView, int paramInt)
  {
    if (paramItemCountView != null) {
      if (paramInt == 0) {
        break label17;
      }
    }
    label17:
    for (boolean bool = true;; bool = false)
    {
      paramItemCountView.setRedCount(bool, paramInt);
      return;
    }
  }
  
  public int a()
  {
    return 2131559438;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqActivityShoppingItemCountView, 0);
    a(this.b, 0);
    a(this.c, 0);
    a(this.d, 0);
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityShoppingItemCountView = ((ItemCountView)paramView.findViewById(2131379608));
    this.jdField_a_of_type_ComTencentMobileqqActivityShoppingItemCountView.setBg(getResources().getDrawable(2130840740));
    this.jdField_a_of_type_ComTencentMobileqqActivityShoppingItemCountView.setTitle("待付款");
    this.b = ((ItemCountView)paramView.findViewById(2131379609));
    this.b.setBg(getResources().getDrawable(2130840741));
    this.b.setTitle("待发货");
    this.c = ((ItemCountView)paramView.findViewById(2131362329));
    this.c.setBg(getResources().getDrawable(2130840736));
    this.c.setTitle("已发货");
    this.d = ((ItemCountView)paramView.findViewById(2131362328));
    this.d.setBg(getResources().getDrawable(2130840735));
    this.d.setTitle("退款/售后");
    this.jdField_a_of_type_ComTencentMobileqqActivityShoppingItemCountView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    paramView.findViewById(2131362693).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131379487));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366390));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366389));
    paramContext = URLDrawable.getDrawable("https://sola.gtimg.cn/aoi/sola/20200530172043_bPKKBWfucM.png", null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramContext);
  }
  
  public void a(Object paramObject) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingHeadView$OnClickEventListener == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131362328: 
        this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingHeadView$OnClickEventListener.d();
        break;
      case 2131379608: 
        this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingHeadView$OnClickEventListener.a();
        break;
      case 2131379609: 
        this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingHeadView$OnClickEventListener.b();
        break;
      case 2131362329: 
        this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingHeadView$OnClickEventListener.c();
        break;
      case 2131362693: 
        this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingHeadView$OnClickEventListener.e();
      }
    }
  }
  
  public void setAfterSaleViewCount(int paramInt)
  {
    a(this.d, paramInt);
  }
  
  public void setAfterSendViewCount(int paramInt)
  {
    a(this.c, paramInt);
  }
  
  public void setOnClickEventListener(ShoppingHeadView.OnClickEventListener paramOnClickEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingHeadView$OnClickEventListener = paramOnClickEventListener;
  }
  
  public void setToPayViewCount(int paramInt)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqActivityShoppingItemCountView, paramInt);
  }
  
  public void setToSendViewCount(int paramInt)
  {
    a(this.b, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shopping.ShoppingHeadView
 * JD-Core Version:    0.7.0.1
 */