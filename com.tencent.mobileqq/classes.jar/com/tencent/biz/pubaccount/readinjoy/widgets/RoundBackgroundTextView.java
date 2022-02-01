package com.tencent.biz.pubaccount.readinjoy.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.widget.presseffect.PressEffectTextView;

public class RoundBackgroundTextView
  extends PressEffectTextView
{
  public RoundBackgroundTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RoundBackgroundTextView);
      if (paramContext != null)
      {
        int i = paramContext.getColor(0, 0);
        int j = paramContext.getColor(2, 0);
        int k = paramContext.getInt(3, -1);
        float f = paramContext.getDimension(1, 0.0F);
        if (Build.VERSION.SDK_INT >= 16)
        {
          paramAttributeSet = new GradientDrawable();
          paramAttributeSet.setColor(i);
          paramAttributeSet.setCornerRadius(f);
          paramAttributeSet.setStroke(k, j);
          setBackground(paramAttributeSet);
        }
        paramContext.recycle();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.widgets.RoundBackgroundTextView
 * JD-Core Version:    0.7.0.1
 */