package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import android.app.Dialog;
import android.app.FragmentManager;
import com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFTextEditViewModel;
import com.tencent.aelight.camera.ae.gif.video.PngsTextDrawer.Callback;

class AEGIFTextEditFragment$3
  implements PngsTextDrawer.Callback
{
  AEGIFTextEditFragment$3(AEGIFTextEditFragment paramAEGIFTextEditFragment, String paramString) {}
  
  public void a()
  {
    AEGIFTextEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFTextEditFragment).dismiss();
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFTextEditFragment.getFragmentManager().popBackStack();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFTextEditFragment.a.a(this.jdField_a_of_type_JavaLangString, paramString);
    AEGIFTextEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFTextEditFragment).dismiss();
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFTextEditFragment.getFragmentManager().popBackStack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFTextEditFragment.3
 * JD-Core Version:    0.7.0.1
 */