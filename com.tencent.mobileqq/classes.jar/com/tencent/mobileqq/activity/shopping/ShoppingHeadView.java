package com.tencent.mobileqq.activity.shopping;

import amgw;
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
  amgw jdField_a_of_type_Amgw;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ItemCountView jdField_a_of_type_ComTencentMobileqqActivityShoppingItemCountView;
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
    return 2131559320;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityShoppingItemCountView = ((ItemCountView)paramView.findViewById(2131379112));
    this.jdField_a_of_type_ComTencentMobileqqActivityShoppingItemCountView.setBg(getResources().getDrawable(2130840535));
    this.jdField_a_of_type_ComTencentMobileqqActivityShoppingItemCountView.setTitle("待付款");
    this.b = ((ItemCountView)paramView.findViewById(2131379113));
    this.b.setBg(getResources().getDrawable(2130840536));
    this.b.setTitle("待发货");
    this.c = ((ItemCountView)paramView.findViewById(2131362293));
    this.c.setBg(getResources().getDrawable(2130840531));
    this.c.setTitle("已发货");
    this.d = ((ItemCountView)paramView.findViewById(2131362292));
    this.d.setBg(getResources().getDrawable(2130840530));
    this.d.setTitle("退款/售后");
    this.jdField_a_of_type_ComTencentMobileqqActivityShoppingItemCountView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    paramView.findViewById(2131362641).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131378993));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366088));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366087));
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
    if (this.jdField_a_of_type_Amgw == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131362292: 
        this.jdField_a_of_type_Amgw.d();
        break;
      case 2131379112: 
        this.jdField_a_of_type_Amgw.a();
        break;
      case 2131379113: 
        this.jdField_a_of_type_Amgw.b();
        break;
      case 2131362293: 
        this.jdField_a_of_type_Amgw.c();
        break;
      case 2131362641: 
        this.jdField_a_of_type_Amgw.e();
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
  
  public void setOnClickEventListener(amgw paramamgw)
  {
    this.jdField_a_of_type_Amgw = paramamgw;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shopping.ShoppingHeadView
 * JD-Core Version:    0.7.0.1
 */