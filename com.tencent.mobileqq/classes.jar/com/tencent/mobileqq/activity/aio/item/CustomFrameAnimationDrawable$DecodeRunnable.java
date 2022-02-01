package com.tencent.mobileqq.activity.aio.item;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Vector;

class CustomFrameAnimationDrawable$DecodeRunnable
  implements Runnable
{
  int a;
  int b;
  String c;
  ArrayList<Bitmap> d;
  Resources e;
  BitmapFactory.Options f = new BitmapFactory.Options();
  
  public CustomFrameAnimationDrawable$DecodeRunnable(int paramInt1, String paramString, int paramInt2, ArrayList<Bitmap> paramArrayList)
  {
    this.a = paramString;
    this.c = paramInt2;
    this.b = paramArrayList;
    Object localObject;
    this.d = localObject;
  }
  
  public void a(Resources paramResources)
  {
    this.e = paramResources;
  }
  
  public void run()
  {
    String str1;
    Object localObject1;
    if (CustomFrameAnimationDrawable.a(this.this$0))
    {
      str1 = CustomFrameAnimationDrawable.d(this.this$0).a(CustomFrameAnimationDrawable.b(this.this$0), CustomFrameAnimationDrawable.c(this.this$0), this.a);
      localObject1 = CommonImageCacheHelper.a(str1);
    }
    else
    {
      str1 = null;
      localObject1 = str1;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = this.f;
      ((BitmapFactory.Options)localObject2).inSampleSize = 1;
      ((BitmapFactory.Options)localObject2).inMutable = true;
      if (CustomFrameAnimationDrawable.e(this.this$0).size() > 0) {
        localObject2 = (Bitmap)CustomFrameAnimationDrawable.e(this.this$0).remove(0);
      } else {
        localObject2 = null;
      }
      if ((!CustomFrameAnimationDrawable.a(this.this$0)) && (localObject2 != null) && (!((Bitmap)localObject2).isRecycled()) && (CustomFrameAnimationDrawable.p())) {
        this.f.inBitmap = ((Bitmap)localObject2);
      }
      int i = this.b;
      if (i != 0)
      {
        try
        {
          localObject2 = BaseImageUtil.a(this.e, i);
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            break label242;
          }
        }
        QLog.d("CustomFrameAnimationDrawable", 2, localOutOfMemoryError1.toString());
        localObject2 = localObject1;
      }
      else
      {
        String str2 = this.c;
        localObject2 = localObject1;
        if (str2 != null) {
          try
          {
            localObject2 = BaseImageUtil.a(str2, this.f);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            localObject2 = localObject1;
            if (QLog.isColorLevel())
            {
              QLog.d("CustomFrameAnimationDrawable", 2, localOutOfMemoryError2.toString());
              localObject2 = localObject1;
            }
          }
        }
      }
    }
    label242:
    if (localObject2 != null)
    {
      if (CustomFrameAnimationDrawable.a(this.this$0)) {
        CommonImageCacheHelper.a(str1, (Bitmap)localObject2);
      }
      this.d.add(localObject2);
    }
    this.this$0.h = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.DecodeRunnable
 * JD-Core Version:    0.7.0.1
 */