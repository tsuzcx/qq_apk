package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;

class TextPreviewSettingActivity$1
  extends Handler
{
  TextPreviewSettingActivity$1(TextPreviewSettingActivity paramTextPreviewSettingActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ImageView localImageView = (ImageView)this.a.findViewById(2131367104);
    int i = paramMessage.what;
    if (i != 16)
    {
      if (i != 18)
      {
        if (i != 19) {
          return;
        }
        if ((paramMessage.obj instanceof Bitmap)) {
          localImageView.setImageBitmap((Bitmap)paramMessage.obj);
        }
      }
      else if ((paramMessage.obj instanceof Drawable))
      {
        localImageView.setImageDrawable((Drawable)paramMessage.obj);
      }
    }
    else {
      localImageView.setImageDrawable(TextPreviewSettingActivity.a(this.a).getFontNameDrawable(TextPreviewSettingActivity.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewSettingActivity.1
 * JD-Core Version:    0.7.0.1
 */