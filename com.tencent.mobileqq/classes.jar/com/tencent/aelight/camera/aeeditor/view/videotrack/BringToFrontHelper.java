package com.tencent.aelight.camera.aeeditor.view.videotrack;

import android.view.View;
import android.view.ViewGroup;

public class BringToFrontHelper
{
  private int a;
  
  public int a(int paramInt1, int paramInt2)
  {
    int i = this.a;
    if (i != -1)
    {
      int j = paramInt1 - 1;
      if (paramInt2 == j)
      {
        if (i > j) {
          this.a = j;
        }
        return this.a;
      }
      if (paramInt2 == i) {
        return j;
      }
    }
    i = paramInt2;
    if (paramInt1 <= paramInt2) {
      i = paramInt1 - 1;
    }
    return i;
  }
  
  public void a(ViewGroup paramViewGroup, View paramView)
  {
    this.a = paramViewGroup.indexOfChild(paramView);
    if (this.a != -1) {
      paramViewGroup.postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.videotrack.BringToFrontHelper
 * JD-Core Version:    0.7.0.1
 */