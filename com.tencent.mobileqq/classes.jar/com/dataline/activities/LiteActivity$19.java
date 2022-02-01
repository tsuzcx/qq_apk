package com.dataline.activities;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;

final class LiteActivity$19
  implements LiteActivity.CreateThumbCB
{
  LiteActivity$19(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void a(String paramString)
  {
    new Handler(Looper.getMainLooper()).post(new LiteActivity.19.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.19
 * JD-Core Version:    0.7.0.1
 */