package com.tencent.biz.qqcircle.publish.outbox.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NetStateCheckBanner
  extends BasePushBanner
{
  private boolean k = false;
  
  public NetStateCheckBanner(Context paramContext)
  {
    super(paramContext);
  }
  
  public NetStateCheckBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean a()
  {
    return (this.b) && (getVisibility() == 0);
  }
  
  public ImageView getBannerCloseButton()
  {
    return this.h;
  }
  
  public TextView getBannerTextView()
  {
    return this.g;
  }
  
  public boolean getCloseType()
  {
    return this.k;
  }
  
  public int getPriority()
  {
    return 64;
  }
  
  public int getType()
  {
    return 1;
  }
  
  public View getView()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.outbox.banner.NetStateCheckBanner
 * JD-Core Version:    0.7.0.1
 */