package com.tencent.av.utils;

import android.content.Context;
import android.view.Window;
import com.tencent.widget.ActionSheet;

public class VideoActionSheet
  extends ActionSheet
{
  public static boolean a = false;
  boolean b = false;
  
  protected VideoActionSheet(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, paramBoolean1, paramBoolean2);
  }
  
  public static VideoActionSheet a(Context paramContext)
  {
    paramContext = new VideoActionSheet(paramContext, false, false);
    paramContext.getWindow().setWindowAnimations(2131755398);
    return paramContext;
  }
  
  public static boolean a()
  {
    return a;
  }
  
  public void dismiss()
  {
    a = false;
    this.b = false;
    super.dismiss();
  }
  
  public void onDetachedFromWindow()
  {
    if (this.b)
    {
      a = false;
      this.b = false;
    }
    super.onDetachedFromWindow();
  }
  
  public void onStop()
  {
    if (this.b)
    {
      a = false;
      this.b = false;
    }
    super.onStop();
  }
  
  public void show()
  {
    if (a == true) {
      return;
    }
    a = true;
    this.b = true;
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.VideoActionSheet
 * JD-Core Version:    0.7.0.1
 */