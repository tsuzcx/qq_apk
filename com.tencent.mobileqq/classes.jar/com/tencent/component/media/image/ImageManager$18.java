package com.tencent.component.media.image;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.component.media.utils.BaseHandler;
import com.tencent.component.media.utils.ImageManagerLog;

class ImageManager$18
  extends BroadcastReceiver
{
  ImageManager$18(ImageManager paramImageManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ImageManagerLog.w(ImageManager.TAG, "registerDumpMemoryCacheReceiver, onReceive");
    int i = paramIntent.getIntExtra("hashcodeEx", 0);
    int j = paramIntent.getIntExtra("imagetype", 0);
    paramContext = ImageManager.access$2800(this.this$0).obtainMessage();
    paramContext.what = 1000;
    paramContext.arg1 = i;
    paramContext.arg2 = j;
    ImageManager.access$2800(this.this$0).sendMessage(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.image.ImageManager.18
 * JD-Core Version:    0.7.0.1
 */