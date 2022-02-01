package com.tencent.aelight.camera.aeeditor.view.timeline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.aeeditor.view.timebar.ScaleTimeBar;
import com.tencent.aelight.camera.log.AEQLog;

public class ScaleScrollLayout
  extends RelativeLayout
{
  private Point jdField_a_of_type_AndroidGraphicsPoint = null;
  private View jdField_a_of_type_AndroidViewView = null;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public ScaleScrollLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScaleScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScaleScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public Point a()
  {
    return this.jdField_a_of_type_AndroidGraphicsPoint;
  }
  
  public void a()
  {
    this.b = false;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramMotionEvent.getAction());
    ((StringBuilder)localObject).append("");
    AEQLog.a("MvCutFragment", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
    boolean bool;
    if ((paramMotionEvent.getActionMasked() != 1) && (paramMotionEvent.getActionMasked() != 3)) {
      bool = false;
    } else {
      bool = true;
    }
    this.b = bool;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        localObject = MotionEvent.obtain(paramMotionEvent);
        ((MotionEvent)localObject).setAction(0);
        this.jdField_a_of_type_AndroidViewView.dispatchTouchEvent((MotionEvent)localObject);
        this.jdField_a_of_type_Boolean = true;
      }
      return this.jdField_a_of_type_AndroidViewView.dispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() > 1) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((paramMotionEvent.getPointerCount() > 1) && ((localView instanceof ScaleTimeBar))) {
        return localView.onTouchEvent(paramMotionEvent);
      }
      i += 1;
    }
    return true;
  }
  
  public void setHandleView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.timeline.ScaleScrollLayout
 * JD-Core Version:    0.7.0.1
 */