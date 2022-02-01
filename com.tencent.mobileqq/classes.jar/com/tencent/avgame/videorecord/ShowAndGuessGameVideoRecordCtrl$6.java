package com.tencent.avgame.videorecord;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.view.View;
import neg;
import nkk;

public class ShowAndGuessGameVideoRecordCtrl$6
  implements Runnable
{
  public ShowAndGuessGameVideoRecordCtrl$6(nkk paramnkk, int paramInt, View paramView) {}
  
  public void run()
  {
    float f1;
    float f2;
    float f3;
    float f4;
    if (this.this$0.d())
    {
      f1 = (this.jdField_a_of_type_Int >> 16 & 0xFF) / 255.0F;
      f2 = (this.jdField_a_of_type_Int >> 8 & 0xFF) / 255.0F;
      f3 = (this.jdField_a_of_type_Int & 0xFF) / 255.0F;
      f4 = (this.jdField_a_of_type_Int >> 24 & 0xFF) / 255.0F;
      if (f4 <= 0.0F) {
        break label264;
      }
      this.this$0.a(true, f1, f2, f3, f4);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.destroyDrawingCache();
      Bitmap localBitmap = this.jdField_a_of_type_AndroidViewView.getDrawingCache();
      if (localBitmap != null)
      {
        int k = this.jdField_a_of_type_AndroidViewView.getLeft();
        int m = this.jdField_a_of_type_AndroidViewView.getTop();
        int j = k;
        int i = m;
        if (nkk.a(this.this$0) != null)
        {
          RectF localRectF = nkk.a(this.this$0).a();
          j = k;
          i = m;
          if (localRectF != null)
          {
            f1 = localRectF.right;
            f2 = localRectF.left;
            f3 = localRectF.bottom;
            f4 = localRectF.top;
            j = (int)((f1 - f2 - this.jdField_a_of_type_AndroidViewView.getWidth()) / 2.0F);
            i = (int)((f3 - f4 - this.jdField_a_of_type_AndroidViewView.getHeight()) / 2.0F);
          }
        }
        this.this$0.b(localBitmap, this.jdField_a_of_type_AndroidViewView.getWidth(), this.jdField_a_of_type_AndroidViewView.getHeight(), j, i);
      }
      return;
      label264:
      this.this$0.a(false, 0.0F, 0.0F, 0.0F, 0.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.ShowAndGuessGameVideoRecordCtrl.6
 * JD-Core Version:    0.7.0.1
 */