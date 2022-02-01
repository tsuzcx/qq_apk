package com.tencent.mobileqq.activity.recent.cur;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

class DragFrameLayout$BornRunner
  implements Runnable
{
  private int a;
  private PointF b = new PointF();
  
  public DragFrameLayout$BornRunner(DragFrameLayout paramDragFrameLayout, PointF paramPointF)
  {
    this.b.set(paramPointF);
    this.a = -1;
  }
  
  public Bitmap a()
  {
    int i = this.a;
    if ((i >= 0) && (i < DragFrameLayout.b().length)) {
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeResource(this.this$0.getResources(), DragFrameLayout.b()[this.a]);
        return localBitmap;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("decodeBitmap failed");
          localStringBuilder.append(localOutOfMemoryError);
          QLog.e("DragRelativeLayout", 2, localStringBuilder.toString(), localOutOfMemoryError);
        }
      }
    }
    return null;
  }
  
  public void run()
  {
    if (this.a == DragFrameLayout.b().length)
    {
      if (this == DragFrameLayout.b(this.this$0)) {
        DragFrameLayout.a(this.this$0, null);
      }
      DragFrameLayout.a(this.this$0, null);
      if (DragFrameLayout.c(this.this$0) == 2)
      {
        Object localObject;
        if (DragFrameLayout.d(this.this$0) != null)
        {
          localObject = DragFrameLayout.d(this.this$0).g();
        }
        else
        {
          if ((!TextUtils.isEmpty(DragFrameLayout.e(this.this$0))) && (DragFrameLayout.f(this.this$0).containsKey(DragFrameLayout.e(this.this$0))))
          {
            localObject = (DragFrameLayout.IDragViewProvider)DragFrameLayout.f(this.this$0).get(DragFrameLayout.e(this.this$0));
            if (localObject != null)
            {
              localObject = ((DragFrameLayout.IDragViewProvider)localObject).g();
              break label147;
            }
          }
          localObject = null;
        }
        label147:
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          DragFrameLayout.a(this.this$0, 5);
          DragFrameLayout localDragFrameLayout = this.this$0;
          DragFrameLayout.a(localDragFrameLayout, new DragFrameLayout.AllBornRunner(localDragFrameLayout, (List)localObject));
        }
        else
        {
          DragFrameLayout.a(this.this$0, -1);
          if (QLog.isColorLevel()) {
            QLog.d("Drag", 2, "DONE!");
          }
          DragFrameLayout.a(this.this$0, true);
          DragFrameLayout.a(this.this$0, null);
        }
      }
      else
      {
        DragFrameLayout.a(this.this$0, -1);
        if (QLog.isColorLevel()) {
          QLog.d("Drag", 2, "DONE!");
        }
        DragFrameLayout.a(this.this$0, true);
        DragFrameLayout.a(this.this$0, null);
      }
    }
    else
    {
      this.a += 1;
    }
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.BornRunner
 * JD-Core Version:    0.7.0.1
 */