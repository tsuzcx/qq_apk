package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

public class StickerBubbleLinearLayout
  extends LinearLayout
{
  public StickerBubbleLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 >= paramView.getLeft())
    {
      if (paramFloat1 > paramView.getRight()) {
        return false;
      }
      if (paramFloat2 >= paramView.getTop()) {
        return paramFloat2 <= paramView.getBottom();
      }
    }
    return false;
  }
  
  public View a(float paramFloat1, float paramFloat2)
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (a(localView, paramFloat1, paramFloat2)) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleLinearLayout
 * JD-Core Version:    0.7.0.1
 */