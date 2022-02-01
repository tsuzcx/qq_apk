package com.tencent.mobileqq.activity.recent.cur;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class DragFrameLayout$BornRunner
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  
  public DragFrameLayout$BornRunner(DragFrameLayout paramDragFrameLayout, PointF paramPointF)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF.set(paramPointF);
    this.jdField_a_of_type_Int = -1;
  }
  
  public Bitmap a()
  {
    int i = this.jdField_a_of_type_Int;
    if ((i >= 0) && (i < DragFrameLayout.a().length)) {
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeResource(this.this$0.getResources(), DragFrameLayout.a()[this.jdField_a_of_type_Int]);
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
    if (this.jdField_a_of_type_Int == DragFrameLayout.a().length)
    {
      if (this == DragFrameLayout.a(this.this$0)) {
        DragFrameLayout.a(this.this$0, null);
      }
      DragFrameLayout.a(this.this$0, null);
      if (DragFrameLayout.a(this.this$0) == 2)
      {
        List localList;
        if (DragFrameLayout.a(this.this$0) != null) {
          localList = DragFrameLayout.a(this.this$0).a();
        } else {
          localList = null;
        }
        if ((DragFrameLayout.a(this.this$0) != null) && (localList != null) && (localList.size() > 0))
        {
          DragFrameLayout.a(this.this$0, 5);
          DragFrameLayout localDragFrameLayout = this.this$0;
          DragFrameLayout.a(localDragFrameLayout, new DragFrameLayout.AllBornRunner(localDragFrameLayout, localList));
        }
        else
        {
          DragFrameLayout.a(this.this$0, -1);
          if (QLog.isColorLevel()) {
            QLog.d("Drag", 2, "DONE!");
          }
          DragFrameLayout.a(this.this$0, true);
        }
      }
      else
      {
        DragFrameLayout.a(this.this$0, -1);
        if (QLog.isColorLevel()) {
          QLog.d("Drag", 2, "DONE!");
        }
        DragFrameLayout.a(this.this$0, true);
      }
      DragFrameLayout.a(this.this$0, null);
    }
    else
    {
      this.jdField_a_of_type_Int += 1;
    }
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.BornRunner
 * JD-Core Version:    0.7.0.1
 */