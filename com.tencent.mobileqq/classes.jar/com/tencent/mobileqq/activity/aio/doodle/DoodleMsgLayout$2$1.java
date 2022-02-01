package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.widget.ImageView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;

class DoodleMsgLayout$2$1
  implements Runnable
{
  DoodleMsgLayout$2$1(DoodleMsgLayout.2 param2, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (DoodleMsgLayout.e(this.b.this$0) != null)
    {
      PhotoProgressDrawable localPhotoProgressDrawable = new PhotoProgressDrawable(this.a, 0, false);
      localPhotoProgressDrawable.setBounds(new Rect(0, 0, Utils.a(19.0F, this.b.this$0.getResources()), Utils.a(19.0F, this.b.this$0.getResources())));
      DoodleMsgLayout.e(this.b.this$0).setImageDrawable(localPhotoProgressDrawable);
    }
    DoodleMsgLayout.b(this.b.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.2.1
 * JD-Core Version:    0.7.0.1
 */