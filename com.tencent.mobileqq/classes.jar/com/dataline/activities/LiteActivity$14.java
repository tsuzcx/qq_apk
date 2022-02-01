package com.dataline.activities;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

final class LiteActivity$14
  implements LiteActivity.GetBackgroundCB
{
  LiteActivity$14(IphoneTitleBarActivity paramIphoneTitleBarActivity, String paramString, ViewGroup paramViewGroup) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if ((paramBitmap != null) || (paramBoolean)) {
      new Handler(Looper.getMainLooper()).post(new LiteActivity.14.1(this, paramBoolean, paramBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.14
 * JD-Core Version:    0.7.0.1
 */