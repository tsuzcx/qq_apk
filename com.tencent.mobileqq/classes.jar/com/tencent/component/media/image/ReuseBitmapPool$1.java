package com.tencent.component.media.image;

import android.graphics.Bitmap;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.LruCache;
import java.util.List;
import java.util.TreeMap;

class ReuseBitmapPool$1
  extends LruCache<Integer, Bitmap>
{
  ReuseBitmapPool$1(ReuseBitmapPool paramReuseBitmapPool, int paramInt)
  {
    super(paramInt);
  }
  
  protected void entryRemoved(boolean paramBoolean, Integer paramInteger, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    try
    {
      super.entryRemoved(paramBoolean, paramInteger, paramBitmap1, paramBitmap2);
      if (paramBoolean)
      {
        int i = BitmapUtils.getBitmapAllocSize(paramBitmap1);
        paramBitmap1 = (List)ReuseBitmapPool.access$000(this.this$0).get(Integer.valueOf(i));
        if (paramBitmap1 == null)
        {
          ImageManagerEnv.getLogger();
          return;
        }
        paramBitmap1.remove(paramInteger);
        if (paramBitmap1.isEmpty()) {
          ReuseBitmapPool.access$000(this.this$0).remove(Integer.valueOf(i));
        }
        ImageManagerEnv.getLogger();
      }
      return;
    }
    finally {}
  }
  
  protected int sizeOf(Integer paramInteger, Bitmap paramBitmap)
  {
    return BitmapUtils.getBitmapAllocSize(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.ReuseBitmapPool.1
 * JD-Core Version:    0.7.0.1
 */