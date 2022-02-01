package com.tencent.mobileqq.activity.aio.zhitu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.widget.HorizontalListView;

public class ZhituEmotionHorizonListView
  extends HorizontalListView
{
  private ZhituEmotionHorizonListView.HorizonListViewTouchListener a;
  
  public ZhituEmotionHorizonListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ZhituEmotionHorizonListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    ZhituEmotionHorizonListView.HorizonListViewTouchListener localHorizonListViewTouchListener = this.a;
    if (localHorizonListViewTouchListener != null) {
      localHorizonListViewTouchListener.a(paramMotionEvent.getAction());
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramInt1 > 0) && ((getAdapter() instanceof ZhituPicAdapter))) {
      ((ZhituPicAdapter)getAdapter()).b();
    }
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  public void setTouchListener(ZhituEmotionHorizonListView.HorizonListViewTouchListener paramHorizonListViewTouchListener)
  {
    this.a = paramHorizonListViewTouchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituEmotionHorizonListView
 * JD-Core Version:    0.7.0.1
 */