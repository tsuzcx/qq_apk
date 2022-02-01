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
    if (paramItemCountView != null)
    {
      boolean bool;
      if (paramInt != 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramItemCountView.setRedCount(bool, paramInt);
    }
  }
  
  protected int a()
  {
    return 2131559312;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqActivityShoppingItemCountView, 0);
    a(this.b, 0);
    a(this.c, 0);
    a(this.d, 0);
  }
  
  protected void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityShoppingItemCountView = ((ItemCountView)paramView.findViewById(2131378955));
    this.jdField_a_of_type_ComTencentMobileqqActivityShoppingItemCountView.setBg(getResources().getDrawable(2130840615));
    this.jdField_a_of_type_ComTencentMobileqqActivityShoppingItemCountView.setTitle("待付款");
    this.b = ((ItemCountView)paramView.findViewById(2131378956));
    this.b.setBg(getResources().getDrawable(2130840616));
    this.b.setTitle("待发货");
    this.c = ((ItemCountView)paramView.findViewById(2131362290));
    this.c.setBg(getResources().getDrawable(2130840611));
    this.c.setTitle("已发货");
    this.d = ((ItemCountView)paramView.findViewById(2131362289));
    this.d.setBg(getResources().getDrawable(2130840610));
    this.d.setTitle("退款/售后");
    this.jdField_a_of_type_ComTencentMobileqqActivityShoppingItemCountView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    paramView.findViewById(2131362654).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131378837));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366273));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366272));
    paramContext = URLDrawable.getDrawable("https://sola.gtimg.cn/aoi/sola/20200530172043_bPKKBWfucM.png", null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramContext);
  }
  
  protected void a(Object paramObject) {}
  
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingHeadView$OnClickEventListener != null) {
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131378956: 
        this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingHeadView$OnClickEventListener.b();
        break;
      case 2131378955: 
        this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingHeadView$OnClickEventListener.a();
        break;
      case 2131362654: 
        this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingHeadView$OnClickEventListener.e();
        break;
      case 2131362290: 
        this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingHeadView$OnClickEventListener.c();
        break;
      case 2131362289: 
        this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingHeadView$OnClickEventListener.d();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shopping.ShoppingHeadView
 * JD-Core Version:    0.7.0.1
 */