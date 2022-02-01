package com.tencent.component.media.image;

import android.os.Looper;
import android.os.Message;
import com.tencent.component.media.utils.BaseHandler;

class ImageManager$5
  extends BaseHandler
{
  ImageManager$5(ImageManager paramImageManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 1000) {
            return;
          }
          ImageManager.access$500(this.this$0, paramMessage);
          return;
        }
        ImageManager.access$400(this.this$0, paramMessage);
        return;
      }
      ImageManager.access$300(this.this$0, paramMessage);
      return;
    }
    ImageManager.access$200(this.this$0, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageManager.5
 * JD-Core Version:    0.7.0.1
 */