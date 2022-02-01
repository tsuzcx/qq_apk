package com.tencent.aelight.camera.aeeditor.view.reorder;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Property;
import android.view.View;
import androidx.annotation.RequiresApi;

final class ReorderTransition$1
  extends Property<View, Rect>
{
  ReorderTransition$1(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  @RequiresApi(api=18)
  public Rect a(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramView.getClipBounds();
    }
    return new Rect();
  }
  
  @RequiresApi(api=18)
  public void a(View paramView, Rect paramRect)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      paramView.setClipBounds(paramRect);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.reorder.ReorderTransition.1
 * JD-Core Version:    0.7.0.1
 */