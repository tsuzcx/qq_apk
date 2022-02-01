package com.tencent.mobileqq.activity.aio;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;

class IntimateInfoShareHelper$3
  implements Runnable
{
  IntimateInfoShareHelper$3(IntimateInfoShareHelper paramIntimateInfoShareHelper, Bitmap paramBitmap, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      localObject1 = this.a;
    }
    else
    {
      localObject1 = this.this$0;
      localObject1 = ((IntimateInfoShareHelper)localObject1).a(IntimateInfoShareHelper.a((IntimateInfoShareHelper)localObject1));
    }
    int i = this.b;
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
    if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()) && (IntimateInfoShareHelper.e(this.this$0) != null) && (!IntimateInfoShareHelper.e(this.this$0).isFinishing()))
    {
      i = this.b;
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
                  IntimateInfoShareHelper.e(this.this$0, (Bitmap)localObject2);
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
            IntimateInfoShareHelper.d(this.this$0, (Bitmap)localObject2);
          }
        }
        else {
          IntimateInfoShareHelper.c(this.this$0, (Bitmap)localObject2);
        }
      }
      else {
        IntimateInfoShareHelper.b(this.this$0, (Bitmap)localObject2);
      }
      IntimateInfoShareHelper.f(this.this$0);
      return;
    }
    IntimateInfoShareHelper.a(this.this$0, 1, 2131891007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.3
 * JD-Core Version:    0.7.0.1
 */