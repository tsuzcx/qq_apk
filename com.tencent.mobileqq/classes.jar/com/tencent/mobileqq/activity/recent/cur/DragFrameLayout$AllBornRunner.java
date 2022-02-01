package com.tencent.mobileqq.activity.recent.cur;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class DragFrameLayout$AllBornRunner
  implements Runnable
{
  private int a;
  private List<View> b;
  private Bitmap[] c;
  
  public DragFrameLayout$AllBornRunner(List<View> paramList)
  {
    Collection localCollection;
    this.b = new ArrayList(localCollection);
    this.a = -1;
    this.c = new Bitmap[DragFrameLayout.b().length];
  }
  
  public PointF a()
  {
    PointF localPointF = new PointF();
    if (this.b.size() > 0)
    {
      View localView = (View)this.b.get(0);
      Rect localRect = new Rect();
      this.this$0.getGlobalVisibleRect(localRect);
      int i = localRect.left;
      int j = localRect.top;
      localView.getGlobalVisibleRect(localRect);
      localRect.left -= i;
      localRect.top -= j;
      localRect.right -= i;
      localRect.bottom -= j;
      localPointF.set(localRect.centerX(), localRect.centerY());
    }
    return localPointF;
  }
  
  public Bitmap b()
  {
    int i = this.a;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (i >= 0)
    {
      localObject1 = localObject2;
      if (i < DragFrameLayout.b().length)
      {
        try
        {
          localObject2 = this.c[this.a];
          localObject1 = localObject2;
          if (localObject2 != null) {
            return localObject1;
          }
          try
          {
            localObject1 = BitmapFactory.decodeResource(this.this$0.getResources(), DragFrameLayout.b()[this.a]);
            localObject2 = localObject1;
            this.c[this.a] = localObject1;
          }
          catch (OutOfMemoryError localOutOfMemoryError1) {}
          localObject1 = localObject2;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          localObject2 = null;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("decodeBitmap failed");
          ((StringBuilder)localObject1).append(localOutOfMemoryError2);
          QLog.e("DragRelativeLayout", 2, ((StringBuilder)localObject1).toString(), localOutOfMemoryError2);
          localObject1 = localObject2;
        }
      }
    }
    return localObject1;
  }
  
  public void run()
  {
    if (this.b.size() == 0)
    {
      if (this == DragFrameLayout.a(this.this$0)) {
        DragFrameLayout.a(this.this$0, null);
      }
      DragFrameLayout.a(this.this$0, -1);
      if (QLog.isColorLevel()) {
        QLog.d("Drag", 2, "DONE!");
      }
      DragFrameLayout.a(this.this$0, true);
      DragFrameLayout.a(this.this$0, null);
    }
    else
    {
      View localView = (View)this.b.get(0);
      if (this.a == DragFrameLayout.b().length)
      {
        this.b.remove(0);
        this.a = -1;
      }
      else
      {
        localView.setVisibility(4);
        this.a += 1;
      }
    }
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.AllBornRunner
 * JD-Core Version:    0.7.0.1
 */