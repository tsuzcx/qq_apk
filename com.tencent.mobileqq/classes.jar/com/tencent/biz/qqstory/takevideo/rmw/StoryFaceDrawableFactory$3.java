package com.tencent.biz.qqstory.takevideo.rmw;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LruCache;
import wsv;
import xhu;
import xqi;

public class StoryFaceDrawableFactory$3
  implements Runnable
{
  public void run()
  {
    Bitmap localBitmap = this.this$0.a(this.a);
    if (localBitmap != null)
    {
      xqi localxqi = (xqi)this.this$0.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(this.b);
      if (localxqi != null)
      {
        localxqi.a(localBitmap);
        this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(1002).sendToTarget();
        return;
      }
      wsv.d("Q.qqstory.record.StoryFaceDrawableFactory", "Find faceDrawable is not in cache after decoding bitmap!");
      localxqi = new xqi(this.this$0.jdField_a_of_type_Int, this.this$0.b);
      localxqi.a(localBitmap);
      this.this$0.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(this.b, localxqi);
      return;
    }
    wsv.e("Q.qqstory.record.StoryFaceDrawableFactory", "getFaceBitmapByPath return null!.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.StoryFaceDrawableFactory.3
 * JD-Core Version:    0.7.0.1
 */