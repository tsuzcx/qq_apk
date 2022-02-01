package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.callback.FeedBackClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.IUIDelegate;

public class CommonAdBar
  extends FrameLayout
  implements FeedBackClickListener
{
  private IUIDelegate a;
  
  public CommonAdBar(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public CommonAdBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CommonAdBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public IUIDelegate a()
  {
    return this.a;
  }
  
  public void a()
  {
    removeAllViews();
  }
  
  public void a(IUIDelegate paramIUIDelegate)
  {
    IUIDelegate localIUIDelegate = this.a;
    if (localIUIDelegate != null) {
      localIUIDelegate.c();
    }
    this.a = paramIUIDelegate;
    this.a.a(this);
    addView(paramIUIDelegate.a());
  }
  
  public void b()
  {
    setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.CommonAdBar
 * JD-Core Version:    0.7.0.1
 */