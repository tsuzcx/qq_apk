package com.tencent.mobileqq.activity.recent.cur;

import android.view.View;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;

public class TabDragListener
  implements DragFrameLayout.OnDragListener
{
  public TabDragAnimationView a;
  public View b;
  private boolean c = false;
  
  public TabDragListener(TabDragAnimationView paramTabDragAnimationView)
  {
    this.a = paramTabDragAnimationView;
  }
  
  public void a(float paramFloat1, float paramFloat2, int paramInt, View paramView)
  {
    if (this.a != null)
    {
      View localView = this.b;
      if (localView != null)
      {
        if (!localView.equals(paramView)) {
          return;
        }
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("drag detect x=");
          paramView.append(paramFloat1);
          paramView.append(",y=");
          paramView.append(paramFloat2);
          paramView.append(",dragType=");
          paramView.append(paramInt);
          QLog.d("TabDragListener", 2, paramView.toString());
        }
        if ((paramInt != 1) && (paramInt != 2))
        {
          if (this.c)
          {
            this.c = false;
            this.a.b();
          }
        }
        else
        {
          if (!this.c) {
            this.a.c();
          }
          this.c = true;
          this.a.a(paramFloat1, paramFloat2, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.cur.TabDragListener
 * JD-Core Version:    0.7.0.1
 */