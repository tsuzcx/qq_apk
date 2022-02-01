package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import com.tencent.aelight.camera.ae.config.CameraPeakServiceObserver;
import com.tencent.common.app.AppInterface;

class AEGIFTextEditFragment$11
  extends CameraPeakServiceObserver
{
  AEGIFTextEditFragment$11(AEGIFTextEditFragment paramAEGIFTextEditFragment, AppInterface paramAppInterface) {}
  
  public void onUpdateTextValid(boolean paramBoolean1, boolean paramBoolean2)
  {
    AEGIFTextEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextFragmentAEGIFTextEditFragment).a(paramBoolean1, paramBoolean2);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFTextEditFragment.11
 * JD-Core Version:    0.7.0.1
 */