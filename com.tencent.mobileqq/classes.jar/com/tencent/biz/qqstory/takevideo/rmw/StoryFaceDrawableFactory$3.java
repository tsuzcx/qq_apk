package com.tencent.biz.qqstory.takevideo.rmw;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LruCache;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.StoryFaceDrawable;

class StoryFaceDrawableFactory$3
  implements Runnable
{
  StoryFaceDrawableFactory$3(StoryFaceDrawableFactory paramStoryFaceDrawableFactory, String paramString1, String paramString2) {}
  
  public void run()
  {
    Bitmap localBitmap = this.this$0.a(this.a);
    if (localBitmap != null)
    {
      StoryFaceDrawable localStoryFaceDrawable = (StoryFaceDrawable)this.this$0.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(this.b);
      if (localStoryFaceDrawable != null)
      {
        localStoryFaceDrawable.a(localBitmap);
        this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(1002).sendToTarget();
        return;
      }
      SLog.d("Q.qqstory.record.StoryFaceDrawableFactory", "Find faceDrawable is not in cache after decoding bitmap!");
      localStoryFaceDrawable = new StoryFaceDrawable(this.this$0.jdField_a_of_type_Int, this.this$0.b);
      localStoryFaceDrawable.a(localBitmap);
      this.this$0.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(this.b, localStoryFaceDrawable);
      return;
    }
    SLog.e("Q.qqstory.record.StoryFaceDrawableFactory", "getFaceBitmapByPath return null!.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.StoryFaceDrawableFactory.3
 * JD-Core Version:    0.7.0.1
 */