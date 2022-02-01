package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import com.etrump.mixlayout.FontManager;

class TextPreviewSettingActivity$1
  extends Handler
{
  TextPreviewSettingActivity$1(TextPreviewSettingActivity paramTextPreviewSettingActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ImageView localImageView = (ImageView)this.a.findViewById(2131367321);
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        localImageView.setImageDrawable(TextPreviewSettingActivity.a(this.a).a(TextPreviewSettingActivity.a(this.a)));
        return;
      } while (!(paramMessage.obj instanceof Drawable));
      localImageView.setImageDrawable((Drawable)paramMessage.obj);
      return;
    } while (!(paramMessage.obj instanceof Bitmap));
    localImageView.setImageBitmap((Bitmap)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewSettingActivity.1
 * JD-Core Version:    0.7.0.1
 */