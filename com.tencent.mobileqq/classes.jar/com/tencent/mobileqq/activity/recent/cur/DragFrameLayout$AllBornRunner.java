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
  private int jdField_a_of_type_Int;
  private List<View> jdField_a_of_type_JavaUtilList;
  private Bitmap[] jdField_a_of_type_ArrayOfAndroidGraphicsBitmap;
  
  public DragFrameLayout$AllBornRunner(List<View> paramList)
  {
    Collection localCollection;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(localCollection);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = new Bitmap[DragFrameLayout.a().length];
  }
  
  public Bitmap a()
  {
    int i = this.jdField_a_of_type_Int;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (i >= 0)
    {
      localObject1 = localObject2;
      if (i < DragFrameLayout.a().length)
      {
        try
        {
          localObject2 = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[this.jdField_a_of_type_Int];
          localObject1 = localObject2;
          if (localObject2 != null) {
            return localObject1;
          }
          try
          {
            localObject1 = BitmapFactory.decodeResource(this.this$0.getResources(), DragFrameLayout.a()[this.jdField_a_of_type_Int]);
            localObject2 = localObject1;
            this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[this.jdField_a_of_type_Int] = localObject1;
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
  
  public PointF a()
  {
    PointF localPointF = new PointF();
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      View localView = (View)this.jdField_a_of_type_JavaUtilList.get(0);
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
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      if (this == DragFrameLayout.a(this.this$0)) {
        DragFrameLayout.a(this.this$0, null);
      }
      DragFrameLayout.a(this.this$0, -1);
      if (QLog.isColorLevel()) {
        QLog.d("Drag", 2, "DONE!");
      }
      DragFrameLayout.a(this.this$0, true);
    }
    else
    {
      View localView = (View)this.jdField_a_of_type_JavaUtilList.get(0);
      if (this.jdField_a_of_type_Int == DragFrameLayout.a().length)
      {
        this.jdField_a_of_type_JavaUtilList.remove(0);
        this.jdField_a_of_type_Int = -1;
      }
      else
      {
        localView.setVisibility(4);
        this.jdField_a_of_type_Int += 1;
      }
    }
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.AllBornRunner
 * JD-Core Version:    0.7.0.1
 */