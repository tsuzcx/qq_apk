package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class AEGIFTextEditFragment$12
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  AEGIFTextEditFragment$12(AEGIFTextEditFragment paramAEGIFTextEditFragment, View paramView) {}
  
  public void onGlobalLayout()
  {
    Log.d("AEGIFTextEditFragment", "onGlobalLayout");
    Rect localRect = new Rect();
    this.a.getWindowVisibleDisplayFrame(localRect);
    int i = this.a.getRootView().getHeight() - localRect.bottom;
    int j = AEGIFTextEditFragment.i(this.b);
    if (i > j)
    {
      AEGIFTextEditFragment.a(this.b, i - j);
      return;
    }
    AEGIFTextEditFragment.a(this.b, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFTextEditFragment.12
 * JD-Core Version:    0.7.0.1
 */