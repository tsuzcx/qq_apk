package com.tencent.aelight.camera.ae.camera.ui;

import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;

class VideoStoryPiecesPart$1
  implements ViewStub.OnInflateListener
{
  VideoStoryPiecesPart$1(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    if (VideoStoryPiecesPart.a(this.a) == null) {
      return;
    }
    paramViewStub = (RelativeLayout.LayoutParams)VideoStoryPiecesPart.a(this.a).getLayoutParams();
    paramViewStub.addRule(3, paramView.getId());
    VideoStoryPiecesPart.a(this.a).setLayoutParams(paramViewStub);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.1
 * JD-Core Version:    0.7.0.1
 */