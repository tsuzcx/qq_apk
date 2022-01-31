package com.tencent.mobileqq.activity.aio;

import aclt;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;

public class IntimateInfoShareHelper$3
  implements Runnable
{
  public IntimateInfoShareHelper$3(aclt paramaclt, Bitmap paramBitmap, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {}
    Bitmap localBitmap2;
    for (Bitmap localBitmap1 = this.this$0.a(aclt.a(this.this$0));; localBitmap1 = this.jdField_a_of_type_AndroidGraphicsBitmap)
    {
      if (this.jdField_a_of_type_Int != 3)
      {
        localBitmap2 = localBitmap1;
        if (this.jdField_a_of_type_Int != 4) {}
      }
      else
      {
        localBitmap2 = this.this$0.a(localBitmap1);
      }
      if ((localBitmap2 != null) && (!localBitmap2.isRecycled()) && (aclt.a(this.this$0) != null) && (!aclt.a(this.this$0).isFinishing())) {
        break;
      }
      aclt.a(this.this$0, 1, 2131628009);
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      aclt.a(this.this$0);
      return;
      this.this$0.a(localBitmap2);
      continue;
      aclt.a(this.this$0, localBitmap2);
      continue;
      aclt.b(this.this$0, localBitmap2);
      continue;
      aclt.a(this.this$0, localBitmap2, this.jdField_a_of_type_Int);
      continue;
      aclt.a(this.this$0, localBitmap2, this.jdField_a_of_type_Int);
      continue;
      aclt.c(this.this$0, localBitmap2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.3
 * JD-Core Version:    0.7.0.1
 */