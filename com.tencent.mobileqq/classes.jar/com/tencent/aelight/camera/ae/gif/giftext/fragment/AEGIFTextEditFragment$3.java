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
    AEGIFTextEditFragment.b(this.b).dismiss();
    this.b.getFragmentManager().popBackStack();
  }
  
  public void a(String paramString)
  {
    this.b.a.a(this.a, paramString);
    AEGIFTextEditFragment.b(this.b).dismiss();
    this.b.getFragmentManager().popBackStack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFTextEditFragment.3
 * JD-Core Version:    0.7.0.1
 */