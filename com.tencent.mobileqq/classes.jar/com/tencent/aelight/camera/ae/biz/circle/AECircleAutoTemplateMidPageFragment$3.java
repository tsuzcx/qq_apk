package com.tencent.aelight.camera.ae.biz.circle;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qcircle.tavcut.player.MoviePlayer;

class AECircleAutoTemplateMidPageFragment$3
  implements View.OnClickListener
{
  AECircleAutoTemplateMidPageFragment$3(AECircleAutoTemplateMidPageFragment paramAECircleAutoTemplateMidPageFragment) {}
  
  public void onClick(View paramView)
  {
    if ((AECircleAutoTemplateMidPageFragment.b(this.a) != null) && (AECircleAutoTemplateMidPageFragment.b(this.a).isPlaying()))
    {
      AECircleAutoTemplateMidPageFragment.b(this.a).pause();
      return;
    }
    if ((AECircleAutoTemplateMidPageFragment.b(this.a) != null) && (!AECircleAutoTemplateMidPageFragment.b(this.a).isPlaying())) {
      AECircleAutoTemplateMidPageFragment.b(this.a).play();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECircleAutoTemplateMidPageFragment.3
 * JD-Core Version:    0.7.0.1
 */