package com.tencent.mobileqq.activity.aio;

import afbf;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;

public class IntimateInfoShareHelper$3
  implements Runnable
{
  public IntimateInfoShareHelper$3(afbf paramafbf, Bitmap paramBitmap, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {}
    Bitmap localBitmap2;
    for (Bitmap localBitmap1 = this.this$0.a(afbf.a(this.this$0));; localBitmap1 = this.jdField_a_of_type_AndroidGraphicsBitmap)
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
      if ((localBitmap2 != null) && (!localBitmap2.isRecycled()) && (afbf.a(this.this$0) != null) && (!afbf.a(this.this$0).isFinishing())) {
        break;
      }
      afbf.a(this.this$0, 1, 2131693173);
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      afbf.a(this.this$0);
      return;
      afbf.a(this.this$0, localBitmap2);
      continue;
      afbf.b(this.this$0, localBitmap2);
      continue;
      afbf.c(this.this$0, localBitmap2);
      continue;
      afbf.a(this.this$0, localBitmap2, this.jdField_a_of_type_Int);
      continue;
      afbf.a(this.this$0, localBitmap2, this.jdField_a_of_type_Int);
      continue;
      afbf.d(this.this$0, localBitmap2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.3
 * JD-Core Version:    0.7.0.1
 */