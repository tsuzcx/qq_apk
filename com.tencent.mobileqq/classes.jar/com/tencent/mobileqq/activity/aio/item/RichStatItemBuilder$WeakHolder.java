package com.tencent.mobileqq.activity.aio.item;

import android.graphics.Bitmap;
import com.tencent.mobileqq.richstatus.IImageListener;
import java.lang.ref.WeakReference;

class RichStatItemBuilder$WeakHolder
  implements IImageListener
{
  public WeakReference<RichStatItemBuilder> a;
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3)
  {
    if (this.a.get() != null) {
      RichStatItemBuilder.a((RichStatItemBuilder)this.a.get(), paramInt1, paramInt2, paramBitmap, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.WeakHolder
 * JD-Core Version:    0.7.0.1
 */