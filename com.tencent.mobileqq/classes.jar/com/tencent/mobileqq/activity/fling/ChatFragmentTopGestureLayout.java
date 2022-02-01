package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.mobileqq.activity.ChatFragment.MyDispatchDrawListener;
import com.tencent.qphone.base.util.QLog;

public class ChatFragmentTopGestureLayout
  extends TopGestureLayout
{
  private int a;
  private boolean b = false;
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
  
  public void disableTopInset()
  {
    this.b = true;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    paramCanvas = this.mMyDispatchDrawListener;
    if (paramCanvas != null) {
      paramCanvas.a();
    }
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    this.a = paramRect.top;
    if (this.b) {
      paramRect.top = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fitSystemWindows this:");
    localStringBuilder.append(this);
    QLog.i("TopGestureLayout", 1, localStringBuilder.toString());
    return super.fitSystemWindows(paramRect);
  }
  
  public int getTopInst()
  {
    return this.a;
  }
  
  public void setMyDispatchDrawListener(ChatFragment.MyDispatchDrawListener paramMyDispatchDrawListener)
  {
    this.mMyDispatchDrawListener = paramMyDispatchDrawListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.ChatFragmentTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */