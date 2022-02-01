package com.tencent.biz.qqcircle.publish.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

public class QZoneCheckBox
  extends CheckBox
{
  View.OnClickListener a;
  
  public QZoneCheckBox(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QZoneCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131953496);
  }
  
  public QZoneCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean performClick()
  {
    View.OnClickListener localOnClickListener = this.a;
    boolean bool = false;
    if (localOnClickListener != null)
    {
      playSoundEffect(0);
      this.a.onClick(this);
      bool = true;
    }
    sendAccessibilityEvent(1);
    return bool;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.a = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.view.QZoneCheckBox
 * JD-Core Version:    0.7.0.1
 */