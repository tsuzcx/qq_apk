package com.tencent.mobileqq.activity.aio;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;

class IntimateInfoShareHelper$3
  implements Runnable
{
  IntimateInfoShareHelper$3(IntimateInfoShareHelper paramIntimateInfoShareHelper, Bitmap paramBitmap, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    else
    {
      localObject1 = this.this$0;
      localObject1 = ((IntimateInfoShareHelper)localObject1).a(IntimateInfoShareHelper.a((IntimateInfoShareHelper)localObject1));
    }
    int i = this.jdField_a_of_type_Int;
    Object localObject2;
    if (i != 3)
    {
      localObject2 = localObject1;
      if (i != 4) {}
    }
    else
    {
      localObject2 = this.this$0.a((Bitmap)localObject1);
    }
    if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()) && (IntimateInfoShareHelper.a(this.this$0) != null) && (!IntimateInfoShareHelper.a(this.this$0).isFinishing()))
    {
      i = this.jdField_a_of_type_Int;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i == 5) {
                  IntimateInfoShareHelper.d(this.this$0, (Bitmap)localObject2);
                }
              }
              else {
                IntimateInfoShareHelper.a(this.this$0, (Bitmap)localObject2, i);
              }
            }
            else {
              IntimateInfoShareHelper.a(this.this$0, (Bitmap)localObject2, i);
            }
          }
          else {
            IntimateInfoShareHelper.c(this.this$0, (Bitmap)localObject2);
          }
        }
        else {
          IntimateInfoShareHelper.b(this.this$0, (Bitmap)localObject2);
        }
      }
      else {
        IntimateInfoShareHelper.a(this.this$0, (Bitmap)localObject2);
      }
      IntimateInfoShareHelper.a(this.this$0);
      return;
    }
    IntimateInfoShareHelper.a(this.this$0, 1, 2131693458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.3
 * JD-Core Version:    0.7.0.1
 */