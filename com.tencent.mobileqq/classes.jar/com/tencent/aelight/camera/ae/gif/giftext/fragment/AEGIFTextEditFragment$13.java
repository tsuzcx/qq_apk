package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;

class AEGIFTextEditFragment$13
  implements Runnable
{
  AEGIFTextEditFragment$13(AEGIFTextEditFragment paramAEGIFTextEditFragment, int paramInt) {}
  
  public void run()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)AEGIFTextEditFragment.a(this.this$0).getLayoutParams();
    int i = localMarginLayoutParams.bottomMargin;
    int j = this.a;
    if (i != j)
    {
      localMarginLayoutParams.bottomMargin = j;
      AEGIFTextEditFragment.a(this.this$0).setLayoutParams(localMarginLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFTextEditFragment.13
 * JD-Core Version:    0.7.0.1
 */