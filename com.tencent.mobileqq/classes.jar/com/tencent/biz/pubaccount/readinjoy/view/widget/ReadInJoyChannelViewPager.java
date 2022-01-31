package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import android.util.AttributeSet;

public class ReadInJoyChannelViewPager
  extends ViewPagerCompat
{
  public ReadInJoyChannelViewPager(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ReadInJoyChannelViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    setOffscreenPageLimit(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager
 * JD-Core Version:    0.7.0.1
 */