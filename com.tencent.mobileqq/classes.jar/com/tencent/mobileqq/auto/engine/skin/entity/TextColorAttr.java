package com.tencent.mobileqq.auto.engine.skin.entity;

import android.view.View;
import android.widget.TextView;

public class TextColorAttr
  extends SkinAttr
{
  public boolean applyInner(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (isColorAttr())
      {
        paramView.setTextColor(getColorStateList());
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.skin.entity.TextColorAttr
 * JD-Core Version:    0.7.0.1
 */