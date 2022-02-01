package com.tencent.avgame.videorecord;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.View;
import mqq.util.WeakReference;
import ngv;

public class GuessSongGameRecordCtrl$4
  implements Runnable
{
  public GuessSongGameRecordCtrl$4(ngv paramngv, int paramInt, View paramView) {}
  
  public void run()
  {
    float f1;
    if (this.this$0.d())
    {
      f1 = (this.jdField_a_of_type_Int >> 16 & 0xFF) / 255.0F;
      float f2 = (this.jdField_a_of_type_Int >> 8 & 0xFF) / 255.0F;
      float f3 = (this.jdField_a_of_type_Int & 0xFF) / 255.0F;
      float f4 = (this.jdField_a_of_type_Int >> 24 & 0xFF) / 255.0F;
      if (f4 <= 0.0F) {
        break label213;
      }
      this.this$0.a(true, f1, f2, f3, f4);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.destroyDrawingCache();
      Bitmap localBitmap = this.jdField_a_of_type_AndroidViewView.getDrawingCache();
      if (localBitmap != null)
      {
        Context localContext = (Context)this.this$0.a.get();
        if (localContext != null)
        {
          f1 = 720.0F / localContext.getResources().getDisplayMetrics().widthPixels;
          int i = (int)(this.jdField_a_of_type_AndroidViewView.getWidth() * f1);
          int j = (int)(f1 * this.jdField_a_of_type_AndroidViewView.getHeight());
          int k = (720 - i) / 2;
          int m = (720 - j) / 2;
          this.this$0.b(localBitmap, i, j, k, m);
        }
      }
      return;
      label213:
      this.this$0.a(false, 0.0F, 0.0F, 0.0F, 0.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessSongGameRecordCtrl.4
 * JD-Core Version:    0.7.0.1
 */