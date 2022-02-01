package com.tencent.biz.subscribe.widget.textview;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class NewStyleFollowTextView
  extends FollowTextView
{
  public NewStyleFollowTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public NewStyleFollowTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void b()
  {
    int i;
    if (this.a) {
      i = 2130839117;
    } else {
      i = 2130839115;
    }
    setBackgroundResource(i);
    if (this.a) {
      i = -9211021;
    } else {
      i = Color.parseColor("#9A9A9A");
    }
    setTextColor(i);
    setText(2131887693);
  }
  
  protected void c()
  {
    int i;
    if (this.a) {
      i = 2130839204;
    } else {
      i = 2130839202;
    }
    setBackgroundResource(i);
    if (this.a) {
      i = -1493172225;
    } else {
      i = -1;
    }
    setTextColor(i);
    setText(2131887699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.textview.NewStyleFollowTextView
 * JD-Core Version:    0.7.0.1
 */