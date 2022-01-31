package com.tencent.component.media.image;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.component.media.utils.BaseHandler;
import java.util.HashMap;

class ImageManager$11
  extends BroadcastReceiver
{
  ImageManager$11(ImageManager paramImageManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction() == null) {
      return;
    }
    ImageManager.access$1802(null);
    ImageManager.access$1900().clear();
    ImageManager.access$2002(false);
    ImageManager.access$2100().clear();
    ImageManager.access$2200(this.this$0);
    ImageManager.getCachePath(paramContext);
    ImageManager.access$2800(this.this$0).post(new ImageManager.11.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.image.ImageManager.11
 * JD-Core Version:    0.7.0.1
 */