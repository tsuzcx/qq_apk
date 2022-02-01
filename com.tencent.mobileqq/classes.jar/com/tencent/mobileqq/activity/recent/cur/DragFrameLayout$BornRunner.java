package com.tencent.mobileqq.activity.recent.cur;

import alpt;
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
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Int >= 0)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Int >= DragFrameLayout.a().length) {}
    }
    try
    {
      localObject1 = BitmapFactory.decodeResource(this.this$0.getResources(), DragFrameLayout.a()[this.jdField_a_of_type_Int]);
      return localObject1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("DragRelativeLayout", 2, "decodeBitmap failed" + localOutOfMemoryError, localOutOfMemoryError);
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
      if (DragFrameLayout.a(this.this$0) == 2) {
        if (DragFrameLayout.a(this.this$0) == null) {
          break label221;
        }
      }
    }
    label221:
    for (List localList = DragFrameLayout.a(this.this$0).onGetVisiableDragView();; localList = null)
    {
      if ((DragFrameLayout.a(this.this$0) != null) && (localList != null) && (localList.size() > 0))
      {
        DragFrameLayout.a(this.this$0, 5);
        DragFrameLayout.a(this.this$0, new DragFrameLayout.AllBornRunner(this.this$0, localList));
        DragFrameLayout.a(this.this$0, null);
      }
      for (;;)
      {
        this.this$0.invalidate();
        return;
        DragFrameLayout.a(this.this$0, -1);
        if (QLog.isColorLevel()) {
          QLog.d("Drag", 2, "DONE!");
        }
        DragFrameLayout.a(this.this$0, true);
        break;
        DragFrameLayout.a(this.this$0, -1);
        if (QLog.isColorLevel()) {
          QLog.d("Drag", 2, "DONE!");
        }
        DragFrameLayout.a(this.this$0, true);
        break;
        this.jdField_a_of_type_Int += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.BornRunner
 * JD-Core Version:    0.7.0.1
 */