package com.tencent.aelight.camera.ae.album.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

class AEAbstractPhotoListFragment$6
  implements View.OnClickListener
{
  AEAbstractPhotoListFragment$6(AEAbstractPhotoListFragment paramAEAbstractPhotoListFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.m.isPlaying())
    {
      this.a.m.pause();
      return;
    }
    this.a.m.resume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.6
 * JD-Core Version:    0.7.0.1
 */