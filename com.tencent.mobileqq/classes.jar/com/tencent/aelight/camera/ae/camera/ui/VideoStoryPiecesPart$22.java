package com.tencent.aelight.camera.ae.camera.ui;

import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel;
import com.tencent.aelight.camera.ae.part.AEVideoStoryStateViewModel;
import com.tencent.biz.videostory.animator.AnimationListener.Stop;
import com.tencent.qphone.base.util.QLog;

class VideoStoryPiecesPart$22
  implements AnimationListener.Stop
{
  VideoStoryPiecesPart$22(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoStoryPiecesPart", 2, "ptv panel down");
    }
    if (VideoStoryPiecesPart.ak(this.a) != null)
    {
      VideoStoryPiecesPart.ak(this.a).setAlpha(1.0F);
      VideoStoryPiecesPart.ak(this.a).setVisibility(4);
      VideoStoryPiecesPart.al(this.a).b().postValue(Boolean.valueOf(false));
    }
    VideoStoryPiecesPart.am(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.22
 * JD-Core Version:    0.7.0.1
 */