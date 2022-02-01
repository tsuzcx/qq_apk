package com.tencent.gdtad.views.videoceiling;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.gdtad.log.GdtLog;

public class GdtVideoCeilingScrollVIew
  extends ScrollView
{
  public GdtVideoCeilingScrollVIew(Context paramContext)
  {
    super(paramContext);
  }
  
  public GdtVideoCeilingScrollVIew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GdtVideoCeilingScrollVIew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    GdtLog.b("GdtVideoCeilingScrollVIew", "dispatchTouchEvent");
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    GdtLog.b("GdtVideoCeilingScrollVIew", "onInterceptTouchEvent");
    return false;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onScrollChanged: t -> ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", oldt -> ");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append(", l -> ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", oldl -> ");
    localStringBuilder.append(paramInt3);
    GdtLog.b("GdtVideoCeilingScrollVIew", localStringBuilder.toString());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    GdtLog.b("GdtVideoCeilingScrollVIew", "onTouchEvent");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingScrollVIew
 * JD-Core Version:    0.7.0.1
 */