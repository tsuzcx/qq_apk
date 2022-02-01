package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import java.lang.ref.WeakReference;

class InformationFaceAdapter$InformationItemLayout$1$2
  implements Runnable
{
  InformationFaceAdapter$InformationItemLayout$1$2(InformationFaceAdapter.InformationItemLayout.1 param1, int paramInt) {}
  
  public void run()
  {
    if (((QIMCommonLoadingView)this.b.b.get()).getVisibility() == 8)
    {
      ((ProgressBar)this.b.g.get()).setVisibility(8);
      ((QIMCommonLoadingView)this.b.b.get()).setProgress(0L);
      ((QIMCommonLoadingView)this.b.b.get()).setVisibility(0);
      ((ImageView)this.b.c.get()).setVisibility(8);
    }
    ((QIMCommonLoadingView)this.b.b.get()).setProgress(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.InformationItemLayout.1.2
 * JD-Core Version:    0.7.0.1
 */