package com.tencent.luggage.wxa.at;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class a
{
  public static boolean a(Context paramContext)
  {
    boolean bool;
    if (new Intent("android.media.action.IMAGE_CAPTURE").resolveActivity(paramContext.getPackageManager()) != null) {
      bool = true;
    } else {
      bool = false;
    }
    if (!bool)
    {
      paramContext = paramContext.getApplicationContext();
      Toast.makeText(paramContext, paramContext.getString(2131918045), 1).show();
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.at.a
 * JD-Core Version:    0.7.0.1
 */