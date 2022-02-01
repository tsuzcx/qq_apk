package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Canvas;
import com.tencent.mobileqq.activity.ChatFragment.MyDispatchDrawListener;

public class ChatFragmentTopGestureLayout
  extends TopGestureLayout
{
  public ChatFragment.MyDispatchDrawListener mMyDispatchDrawListener;
  
  public ChatFragmentTopGestureLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ChatFragmentTopGestureLayout(Context paramContext, ChatFragment.MyDispatchDrawListener paramMyDispatchDrawListener, TopGestureLayout.InterceptTouchEventListener paramInterceptTouchEventListener)
  {
    super(paramContext);
    init(paramContext);
    this.mInterceptTouchEventListener = paramInterceptTouchEventListener;
    this.mMyDispatchDrawListener = paramMyDispatchDrawListener;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    paramCanvas = this.mMyDispatchDrawListener;
    if (paramCanvas != null) {
      paramCanvas.a();
    }
  }
  
  public void setMyDispatchDrawListener(ChatFragment.MyDispatchDrawListener paramMyDispatchDrawListener)
  {
    this.mMyDispatchDrawListener = paramMyDispatchDrawListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.ChatFragmentTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */