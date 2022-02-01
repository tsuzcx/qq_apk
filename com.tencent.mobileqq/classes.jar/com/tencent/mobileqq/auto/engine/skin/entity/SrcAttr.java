package com.tencent.mobileqq.auto.engine.skin.entity;

import android.view.View;
import android.widget.ImageView;

public class SrcAttr
  extends SkinAttr
{
  public boolean applyInner(View paramView)
  {
    if ((paramView instanceof ImageView))
    {
      paramView = (ImageView)paramView;
      if (isColorAttr())
      {
        paramView.setImageResource(getColor());
        return true;
      }
      if (isDrawableAttr())
      {
        paramView.setImageDrawable(getDrawable());
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.skin.entity.SrcAttr
 * JD-Core Version:    0.7.0.1
 */