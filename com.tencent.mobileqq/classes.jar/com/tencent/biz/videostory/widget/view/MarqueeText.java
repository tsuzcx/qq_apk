package com.tencent.biz.videostory.widget.view;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;

public class MarqueeText
  extends TextView
{
  public MarqueeText(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MarqueeText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MarqueeText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setMarqueeRepeatLimit(-1);
    setSingleLine();
    setEllipsize(TextUtils.TruncateAt.MARQUEE);
    setFocusable(false);
    setSelected(true);
    setHorizontallyScrolling(true);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    setSelected(true);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.MarqueeText
 * JD-Core Version:    0.7.0.1
 */