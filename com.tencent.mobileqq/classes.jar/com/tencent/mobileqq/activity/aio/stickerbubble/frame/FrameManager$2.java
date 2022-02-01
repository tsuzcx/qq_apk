package com.tencent.mobileqq.activity.aio.stickerbubble.frame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.qphone.base.util.QLog;

class FrameManager$2
  implements Runnable
{
  FrameManager$2(FrameManager paramFrameManager, BitmapDrawable[] paramArrayOfBitmapDrawable, IFrameDecode paramIFrameDecode, String paramString, int paramInt) {}
  
  public void run()
  {
    int j = 1;
    int i = 0;
    Object localObject;
    for (;;)
    {
      localObject = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable;
      if (j >= localObject.length) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleFrameIFrameDecode.a();
      localObject = FrameManager.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleFrameIFrameDecode.a(), 0.7D);
      BitmapDrawable[] arrayOfBitmapDrawable = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable;
      if (localObject != null) {
        localObject = new BitmapDrawable(FrameManager.a(this.this$0).getResources(), (Bitmap)localObject);
      } else {
        localObject = null;
      }
      arrayOfBitmapDrawable[j] = localObject;
      if (j != this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleFrameIFrameDecode.c()) {
        i = 1;
      } else {
        i = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.e("StickerBubble_FrameDecode", 2, new Object[] { "decode gif, i: ", Integer.valueOf(j), " index: ", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleFrameIFrameDecode.c()), " len: ", Integer.valueOf(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable.length), " path: ", this.jdField_a_of_type_JavaLangString });
      }
      j += 1;
    }
    if (i == 0) {
      FrameCache.a(this.jdField_a_of_type_JavaLangString, (BitmapDrawable[])localObject, this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleFrameIFrameDecode.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.frame.FrameManager.2
 * JD-Core Version:    0.7.0.1
 */