package com.tencent.gdtad.basics.motivevideo;

import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;

class GdtMotiveVideoDialog$3
  implements View.OnSystemUiVisibilityChangeListener
{
  GdtMotiveVideoDialog$3(GdtMotiveVideoDialog paramGdtMotiveVideoDialog, ViewGroup paramViewGroup) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0) {
      this.a.setSystemUiVisibility(7942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMotiveVideoDialog.3
 * JD-Core Version:    0.7.0.1
 */