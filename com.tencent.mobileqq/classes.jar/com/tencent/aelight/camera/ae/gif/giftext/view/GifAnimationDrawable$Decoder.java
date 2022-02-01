package com.tencent.aelight.camera.ae.gif.giftext.view;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Message;
import com.tencent.aelight.camera.aebase.Util;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GifAnimationDrawable$Decoder
  implements Runnable
{
  private final GifAnimationDrawable.Frame a;
  
  public GifAnimationDrawable$Decoder(GifAnimationDrawable paramGifAnimationDrawable, GifAnimationDrawable.Frame paramFrame)
  {
    this.a = paramFrame;
  }
  
  @TargetApi(12)
  private BitmapDrawable a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = GifAnimationDrawable.a(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("decodeBitmap() called with: path = [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return new BitmapDrawable(Util.a(paramString, 320, 320, true));
  }
  
  public void run()
  {
    if (!this.this$0.isRunning()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = GifAnimationDrawable.a(this.this$0);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Decoder index:");
      ((StringBuilder)localObject2).append(this.a.jdField_a_of_type_Int);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("android.resource://main_tab_animation_");
    ((StringBuilder)localObject1).append((String)GifAnimationDrawable.a(this.this$0).get(this.a.jdField_a_of_type_Int));
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = CommonImageCacheHelper.a((String)localObject1);
    StringBuilder localStringBuilder;
    if (localObject2 != null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = GifAnimationDrawable.a(this.this$0);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Decoder hit cache :");
        localStringBuilder.append(this.a.jdField_a_of_type_Int);
        QLog.d((String)localObject1, 2, localStringBuilder.toString());
      }
      this.a.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable((Bitmap)localObject2);
    }
    else
    {
      long l1 = System.currentTimeMillis();
      this.a.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = a((String)GifAnimationDrawable.a(this.this$0).get(this.a.jdField_a_of_type_Int));
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject2 = GifAnimationDrawable.a(this.this$0);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Decoder decodeBitmap index:");
        localStringBuilder.append(this.a.jdField_a_of_type_Int);
        localStringBuilder.append(" cost:");
        localStringBuilder.append(l2 - l1);
        localStringBuilder.append(" delay:");
        localStringBuilder.append(GifAnimationDrawable.a(this.this$0));
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      CommonImageCacheHelper.a((String)localObject1, this.a.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.getBitmap());
    }
    if (!this.this$0.isRunning()) {
      return;
    }
    localObject1 = GifAnimationDrawable.a(this.this$0).obtainMessage(0, this.a);
    GifAnimationDrawable.a(this.this$0).sendMessageAtTime((Message)localObject1, this.a.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.view.GifAnimationDrawable.Decoder
 * JD-Core Version:    0.7.0.1
 */