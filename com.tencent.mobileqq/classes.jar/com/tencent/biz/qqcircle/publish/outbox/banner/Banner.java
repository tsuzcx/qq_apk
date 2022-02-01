package com.tencent.biz.qqcircle.publish.outbox.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.biz.qqcircle.utils.ViewUtils;

public abstract class Banner
  extends RelativeLayout
{
  protected Banner.OnDisplayListener a;
  public boolean b = false;
  public boolean c = false;
  protected BannerHost d;
  
  public Banner(Context paramContext)
  {
    super(paramContext);
  }
  
  public Banner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public abstract boolean a();
  
  public abstract int getPriority();
  
  public abstract int getType();
  
  public void setBannerHost(BannerHost paramBannerHost)
  {
    this.d = paramBannerHost;
  }
  
  public void setDefaultLayoutParams()
  {
    setLayoutParams(new ViewGroup.LayoutParams(-1, ViewUtils.a(40.0F)));
  }
  
  public void setOnDisplayListener(Banner.OnDisplayListener paramOnDisplayListener)
  {
    this.a = paramOnDisplayListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.outbox.banner.Banner
 * JD-Core Version:    0.7.0.1
 */