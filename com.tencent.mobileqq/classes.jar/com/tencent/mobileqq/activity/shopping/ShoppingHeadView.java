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
  ShoppingHeadView.OnClickEventListener c;
  private ItemCountView d;
  private ItemCountView e;
  private ItemCountView f;
  private ItemCountView g;
  private ImageView h;
  private RelativeLayout i;
  private LinearLayout j;
  
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
  
  public void a()
  {
    a(this.d, 0);
    a(this.e, 0);
    a(this.f, 0);
    a(this.g, 0);
  }
  
  protected void a(Context paramContext, View paramView)
  {
    this.d = ((ItemCountView)paramView.findViewById(2131447664));
    this.d.setBg(getResources().getDrawable(2130841388));
    this.d.setTitle("待付款");
    this.e = ((ItemCountView)paramView.findViewById(2131447665));
    this.e.setBg(getResources().getDrawable(2130841389));
    this.e.setTitle("待发货");
    this.f = ((ItemCountView)paramView.findViewById(2131427889));
    this.f.setBg(getResources().getDrawable(2130841384));
    this.f.setTitle("已发货");
    this.g = ((ItemCountView)paramView.findViewById(2131427888));
    this.g.setBg(getResources().getDrawable(2130841383));
    this.g.setTitle("退款/售后");
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    paramView.findViewById(2131428275).setOnClickListener(this);
    this.j = ((LinearLayout)paramView.findViewById(2131447534));
    this.i = ((RelativeLayout)paramView.findViewById(2131432573));
    this.h = ((ImageView)paramView.findViewById(2131432572));
    paramContext = URLDrawable.getDrawable("https://sola.gtimg.cn/aoi/sola/20200530172043_bPKKBWfucM.png", null);
    this.h.setImageDrawable(paramContext);
  }
  
  protected void a(Object paramObject) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.j.setVisibility(8);
      this.i.setVisibility(0);
      return;
    }
    this.j.setVisibility(0);
    this.i.setVisibility(8);
  }
  
  protected int getLayoutId()
  {
    return 2131625261;
  }
  
  public void onClick(View paramView)
  {
    if (this.c != null) {
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131447665: 
        this.c.b();
        break;
      case 2131447664: 
        this.c.a();
        break;
      case 2131428275: 
        this.c.e();
        break;
      case 2131427889: 
        this.c.c();
        break;
      case 2131427888: 
        this.c.d();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setAfterSaleViewCount(int paramInt)
  {
    a(this.g, paramInt);
  }
  
  public void setAfterSendViewCount(int paramInt)
  {
    a(this.f, paramInt);
  }
  
  public void setOnClickEventListener(ShoppingHeadView.OnClickEventListener paramOnClickEventListener)
  {
    this.c = paramOnClickEventListener;
  }
  
  public void setToPayViewCount(int paramInt)
  {
    a(this.d, paramInt);
  }
  
  public void setToSendViewCount(int paramInt)
  {
    a(this.e, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shopping.ShoppingHeadView
 * JD-Core Version:    0.7.0.1
 */