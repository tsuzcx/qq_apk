package com.tencent.aelight.camera.ae.album.fragment;

import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

class AEAbstractPhotoListFragment$5
  implements Runnable
{
  AEAbstractPhotoListFragment$5(AEAbstractPhotoListFragment paramAEAbstractPhotoListFragment) {}
  
  public void run()
  {
    int i = AEAbstractPhotoListFragment.c(this.this$0).indexOfChild(AEAbstractPhotoListFragment.b(this.this$0));
    int j = Math.min(AEAbstractPhotoListFragment.c(this.this$0).getWidth(), AEAbstractPhotoListFragment.c(this.this$0).getHeight());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createVideoPreviewView--length=");
    localStringBuilder.append(j);
    AEQLog.b("PhotoListActivity", localStringBuilder.toString());
    AEAbstractPhotoListFragment.c(this.this$0).addView(this.this$0.m, Math.max(0, i + 1), new FrameLayout.LayoutParams(j, j));
    this.this$0.m.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.5
 * JD-Core Version:    0.7.0.1
 */