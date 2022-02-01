package com.tencent.biz.qqcircle.widgets.pick;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

public class WheelTextView
  extends TextView
{
  public WheelTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WheelTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void setTextSize(float paramFloat)
  {
    Object localObject = getContext();
    if (localObject == null) {
      localObject = Resources.getSystem();
    } else {
      localObject = ((Context)localObject).getResources();
    }
    paramFloat = TypedValue.applyDimension(1, paramFloat, ((Resources)localObject).getDisplayMetrics());
    if (paramFloat != getPaint().getTextSize())
    {
      getPaint().setTextSize(paramFloat);
      if (getLayout() != null) {
        invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pick.WheelTextView
 * JD-Core Version:    0.7.0.1
 */