package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QCircleInteractiveLayout
  extends FrameLayout
{
  private View a;
  private int[] b = new int[4];
  private boolean c;
  private List<QCircleInteractiveLayout.OnDownTouchListener> d = new ArrayList();
  
  public QCircleInteractiveLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((View)localObject).getLocationOnScreen(this.b);
      localObject = this.b;
      localObject[2] = (localObject[0] + this.a.getWidth());
      localObject = this.b;
      localObject[3] = (localObject[1] + this.a.getHeight());
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    paramMotionEvent = this.b;
    if ((f1 >= paramMotionEvent[0]) && (f1 <= paramMotionEvent[2]) && (f2 >= paramMotionEvent[1]) && (f2 <= paramMotionEvent[3]))
    {
      QLog.i("QCircleInteractiveLayout", 1, "checkInteractiveState in mExcludeView area");
      return;
    }
    this.c = true;
    QLog.i("QCircleInteractiveLayout", 1, "checkInteractiveState mHaveInteractive = true");
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        ((QCircleInteractiveLayout.OnDownTouchListener)localIterator.next()).a();
      }
    }
    if ((paramMotionEvent.getAction() == 0) && (!a())) {
      a(paramMotionEvent);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setExcludeInteractiveView(View paramView)
  {
    this.a = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleInteractiveLayout
 * JD-Core Version:    0.7.0.1
 */