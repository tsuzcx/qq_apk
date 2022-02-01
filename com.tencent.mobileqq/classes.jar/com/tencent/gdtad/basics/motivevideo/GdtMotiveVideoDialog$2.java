package com.tencent.gdtad.basics.motivevideo;

import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;

class GdtMotiveVideoDialog$2
  implements View.OnSystemUiVisibilityChangeListener
{
  GdtMotiveVideoDialog$2(GdtMotiveVideoDialog paramGdtMotiveVideoDialog, ViewGroup paramViewGroup) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0) {
      this.jdField_a_of_type_AndroidViewViewGroup.setSystemUiVisibility(7942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMotiveVideoDialog.2
 * JD-Core Version:    0.7.0.1
 */