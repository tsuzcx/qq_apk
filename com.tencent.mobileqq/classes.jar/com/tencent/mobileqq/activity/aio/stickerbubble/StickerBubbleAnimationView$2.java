package com.tencent.mobileqq.activity.aio.stickerbubble;

import aevh;
import aevk;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.qphone.base.util.QLog;

class StickerBubbleAnimationView$2
  implements Runnable
{
  StickerBubbleAnimationView$2(StickerBubbleAnimationView paramStickerBubbleAnimationView, BitmapDrawable[] paramArrayOfBitmapDrawable, aevh paramaevh, String paramString, int paramInt) {}
  
  public void run()
  {
    int j = 0;
    int i = 1;
    if (i < this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable.length)
    {
      this.jdField_a_of_type_Aevh.a();
      Object localObject = StickerBubbleAnimationView.a(this.this$0, this.jdField_a_of_type_Aevh.a(), 0.7D);
      BitmapDrawable[] arrayOfBitmapDrawable = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable;
      if (localObject != null) {}
      for (localObject = new BitmapDrawable(this.this$0.getResources(), (Bitmap)localObject);; localObject = null)
      {
        arrayOfBitmapDrawable[i] = localObject;
        QLog.d("StickerBubbleAnimationView", 2, "decode gif: " + i + " / " + this.jdField_a_of_type_Aevh.c() + " / " + this.jdField_a_of_type_JavaLangString);
        if (i != this.jdField_a_of_type_Aevh.c())
        {
          if (QLog.isColorLevel()) {
            QLog.e("StickerBubbleAnimationView", 2, "index is not matched, " + i + " / " + this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable.length + " / " + this.jdField_a_of_type_JavaLangString);
          }
          j = 1;
        }
        i += 1;
        break;
      }
    }
    if (j == 0) {
      aevk.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.2
 * JD-Core Version:    0.7.0.1
 */