package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import bdoo;
import com.tencent.widget.AbsListView.LayoutParams;

public class ReadInJoyStaticGridView
  extends ReadInJoyDynamicGridView
{
  public ReadInJoyStaticGridView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyStaticGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadInJoyStaticGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    setNumColumns(4);
    setHorizontalSpacing(bdoo.a(0.0F));
    setVerticalSpacing(bdoo.a(0.0F));
    setSelector(17170445);
    setClipChildren(false);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 2) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyStaticGridView
 * JD-Core Version:    0.7.0.1
 */