package com.tencent.mobileqq.ar.arcore;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager.DisplayListener;
import android.view.Display;
import android.view.WindowManager;

@TargetApi(17)
public class DisplayRotationHelper
  implements DisplayManager.DisplayListener
{
  private boolean a;
  private int b;
  private int c;
  private final Context d;
  private final Display e;
  
  @TargetApi(23)
  public DisplayRotationHelper(Context paramContext)
  {
    this.d = paramContext;
    this.e = ((WindowManager)paramContext.getSystemService(WindowManager.class)).getDefaultDisplay();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.a = true;
  }
  
  public void onDisplayAdded(int paramInt) {}
  
  public void onDisplayChanged(int paramInt)
  {
    this.a = true;
  }
  
  public void onDisplayRemoved(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcore.DisplayRotationHelper
 * JD-Core Version:    0.7.0.1
 */