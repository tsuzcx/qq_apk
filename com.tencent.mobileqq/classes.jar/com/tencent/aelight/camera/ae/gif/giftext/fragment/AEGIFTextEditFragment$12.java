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
    this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
    int i = this.jdField_a_of_type_AndroidViewView.getRootView().getHeight() - localRect.bottom;
    int j = AEGIFTextEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFTextEditFragment);
    if (i > j)
    {
      AEGIFTextEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFTextEditFragment, i - j);
      return;
    }
    AEGIFTextEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFTextEditFragment, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFTextEditFragment.12
 * JD-Core Version:    0.7.0.1
 */