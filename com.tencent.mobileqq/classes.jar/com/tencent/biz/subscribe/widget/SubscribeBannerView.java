package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class SubscribeBannerView
  extends BaseWidgetView
{
  private static int f = ImmersiveUtils.dpToPx(20.0F);
  private SubscribeBannerView.BannerAdapter c;
  private SubscribeBannerView.DotsIndicator d;
  private ViewPager e;
  
  public SubscribeBannerView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public SubscribeBannerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(FrameLayout paramFrameLayout)
  {
    this.d = new SubscribeBannerView.DotsIndicator(getContext());
    paramFrameLayout = new FrameLayout.LayoutParams(-2, -2);
    paramFrameLayout.gravity = 81;
    addView(this.d, paramFrameLayout);
  }
  
  public void a()
  {
    SubscribeBannerView.BannerAdapter localBannerAdapter = this.c;
    if (localBannerAdapter != null) {
      localBannerAdapter.a().clear();
    }
  }
  
  protected void a(Context paramContext, View paramView)
  {
    this.e = new ViewPager(getContext());
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    paramContext.bottomMargin = f;
    this.e.setLayoutParams(paramContext);
    this.e.setOffscreenPageLimit(3);
    this.e.setOnPageChangeListener(new SubscribeBannerView.1(this));
    paramContext = (FrameLayout)paramView;
    paramContext.addView(this.e);
    a(paramContext);
  }
  
  protected void a(Object paramObject) {}
  
  protected int getLayoutId()
  {
    return 0;
  }
  
  public void setAdapter(SubscribeBannerView.BannerAdapter paramBannerAdapter)
  {
    this.c = paramBannerAdapter;
    paramBannerAdapter = this.e;
    if (paramBannerAdapter != null) {
      paramBannerAdapter.setAdapter(this.c);
    }
  }
  
  public void setBannerHeight(int paramInt)
  {
    if (getLayoutParams() != null)
    {
      getLayoutParams().height = (paramInt + f);
      requestLayout();
    }
  }
  
  public void setDatas(List paramList)
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((SubscribeBannerView.BannerAdapter)localObject).a((ArrayList)paramList);
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((SubscribeBannerView.DotsIndicator)localObject).removeAllViews();
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.d.a(paramList.size());
        this.d.setDotsSelected(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeBannerView
 * JD-Core Version:    0.7.0.1
 */