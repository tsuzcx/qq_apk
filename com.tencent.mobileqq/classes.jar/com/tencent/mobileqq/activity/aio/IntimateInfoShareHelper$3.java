package com.tencent.mobileqq.activity.aio;

import agim;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;

public class IntimateInfoShareHelper$3
  implements Runnable
{
  public IntimateInfoShareHelper$3(agim paramagim, Bitmap paramBitmap, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {}
    Bitmap localBitmap2;
    for (Bitmap localBitmap1 = this.this$0.a(agim.a(this.this$0));; localBitmap1 = this.jdField_a_of_type_AndroidGraphicsBitmap)
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
      if ((localBitmap2 != null) && (!localBitmap2.isRecycled()) && (agim.a(this.this$0) != null) && (!agim.a(this.this$0).isFinishing())) {
        break;
      }
      agim.a(this.this$0, 1, 2131693111);
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      agim.a(this.this$0);
      return;
      agim.a(this.this$0, localBitmap2);
      continue;
      agim.b(this.this$0, localBitmap2);
      continue;
      agim.c(this.this$0, localBitmap2);
      continue;
      agim.a(this.this$0, localBitmap2, this.jdField_a_of_type_Int);
      continue;
      agim.a(this.this$0, localBitmap2, this.jdField_a_of_type_Int);
      continue;
      agim.d(this.this$0, localBitmap2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.3
 * JD-Core Version:    0.7.0.1
 */