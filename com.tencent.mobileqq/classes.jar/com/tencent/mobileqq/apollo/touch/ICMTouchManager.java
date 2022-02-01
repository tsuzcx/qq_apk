package com.tencent.mobileqq.apollo.touch;

import android.view.MotionEvent;
import com.tencent.mobileqq.apollo.model.ApolloSkeletonBounding;

public abstract interface ICMTouchManager
{
  public abstract void a(ApolloSkeletonBounding paramApolloSkeletonBounding, int paramInt);
  
  public abstract boolean a(MotionEvent paramMotionEvent);
  
  public abstract void b(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.touch.ICMTouchManager
 * JD-Core Version:    0.7.0.1
 */