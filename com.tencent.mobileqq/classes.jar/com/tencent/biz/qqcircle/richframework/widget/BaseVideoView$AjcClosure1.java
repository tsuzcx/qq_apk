package com.tencent.biz.qqcircle.richframework.widget;

import android.widget.SeekBar;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.AroundClosure;

public class BaseVideoView$AjcClosure1
  extends AroundClosure
{
  public BaseVideoView$AjcClosure1(Object[] paramArrayOfObject)
  {
    super(paramArrayOfObject);
  }
  
  public Object run(Object[] paramArrayOfObject)
  {
    paramArrayOfObject = this.state;
    BaseVideoView.a((BaseVideoView)paramArrayOfObject[0], (SeekBar)paramArrayOfObject[1], (JoinPoint)paramArrayOfObject[2]);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.BaseVideoView.AjcClosure1
 * JD-Core Version:    0.7.0.1
 */