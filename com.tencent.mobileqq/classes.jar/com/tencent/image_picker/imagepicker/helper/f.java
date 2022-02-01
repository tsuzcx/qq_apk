package com.tencent.image_picker.imagepicker.helper;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import androidx.core.content.ContextCompat;

public class f
{
  public static Drawable a(Context paramContext)
  {
    int i;
    if ((Build.VERSION.SDK_INT >= 17) && (paramContext.getResources().getConfiguration().getLayoutDirection() == 1)) {
      i = 2130853690;
    } else {
      i = 2130853689;
    }
    return ContextCompat.getDrawable(paramContext.getApplicationContext(), i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image_picker.imagepicker.helper.f
 * JD-Core Version:    0.7.0.1
 */