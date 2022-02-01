package com.tencent.av.wtogether.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChildPressEffectRelativeLayout
  extends RelativeLayout
{
  List<View> a = new ArrayList();
  
  public ChildPressEffectRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ChildPressEffectRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ChildPressEffectRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    if (isPressed())
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((View)localIterator.next()).setPressed(false);
      }
    }
    super.drawableStateChanged();
  }
  
  public void setPressed(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((View)localIterator.next()).setPressed(false);
      }
    }
    super.setPressed(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.view.ChildPressEffectRelativeLayout
 * JD-Core Version:    0.7.0.1
 */