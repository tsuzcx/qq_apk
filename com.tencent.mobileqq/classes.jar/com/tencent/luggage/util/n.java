package com.tencent.luggage.util;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.r;

public class n
{
  @Nullable
  public static Display a(int paramInt)
  {
    Display[] arrayOfDisplay = ((DisplayManager)r.a().getSystemService("display")).getDisplays();
    int j = arrayOfDisplay.length;
    int i = 0;
    while (i < j)
    {
      Display localDisplay = arrayOfDisplay[i];
      if (localDisplay.getDisplayId() == paramInt) {
        return localDisplay;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.n
 * JD-Core Version:    0.7.0.1
 */