package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import com.tencent.aelight.camera.ae.config.CameraPeakServiceObserver;
import com.tencent.common.app.AppInterface;

class AEGIFTextEditFragment$11
  extends CameraPeakServiceObserver
{
  AEGIFTextEditFragment$11(AEGIFTextEditFragment paramAEGIFTextEditFragment, AppInterface paramAppInterface) {}
  
  public void onUpdateTextValid(boolean paramBoolean1, boolean paramBoolean2)
  {
    AEGIFTextEditFragment.h(this.b).a(paramBoolean1, paramBoolean2);
    this.a.removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFTextEditFragment.11
 * JD-Core Version:    0.7.0.1
 */