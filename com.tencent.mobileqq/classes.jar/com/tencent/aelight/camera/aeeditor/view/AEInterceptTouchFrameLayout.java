package com.tencent.aelight.camera.aeeditor.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AEInterceptTouchFrameLayout
  extends FrameLayout
{
  private AEInterceptTouchFrameLayout.InterceptTouchEventHandler a;
  
  public AEInterceptTouchFrameLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public AEInterceptTouchFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AEInterceptTouchFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AEInterceptTouchFrameLayout.InterceptTouchEventHandler localInterceptTouchEventHandler = this.a;
    if ((localInterceptTouchEventHandler != null) && (localInterceptTouchEventHandler.a(paramMotionEvent))) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AEInterceptTouchFrameLayout.InterceptTouchEventHandler localInterceptTouchEventHandler = this.a;
    if ((localInterceptTouchEventHandler != null) && (localInterceptTouchEventHandler.b(paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setInterceptTouchEventHandler(AEInterceptTouchFrameLayout.InterceptTouchEventHandler paramInterceptTouchEventHandler)
  {
    this.a = paramInterceptTouchEventHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.AEInterceptTouchFrameLayout
 * JD-Core Version:    0.7.0.1
 */