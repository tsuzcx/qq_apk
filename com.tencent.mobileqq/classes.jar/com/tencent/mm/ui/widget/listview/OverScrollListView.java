package com.tencent.mm.ui.widget.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import com.tencent.mm.ui.f;

public class OverScrollListView
  extends ListView
{
  private int a;
  private float b;
  private float c;
  
  public OverScrollListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public OverScrollListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public OverScrollListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public OverScrollListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i == 2)
      {
        this.c = paramMotionEvent.getY(0);
        this.a = ((int)Math.abs(this.c - this.b));
      }
    }
    else {
      this.b = paramMotionEvent.getY(0);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    f.b("OverScrollListView", "dancy test maxOverScrollYDis: %s", new Object[] { Integer.valueOf(this.a) });
    return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, this.a / 2, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.OverScrollListView
 * JD-Core Version:    0.7.0.1
 */