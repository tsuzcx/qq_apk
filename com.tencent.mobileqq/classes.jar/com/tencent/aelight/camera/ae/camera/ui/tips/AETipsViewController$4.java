package com.tencent.aelight.camera.ae.camera.ui.tips;

import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

class AETipsViewController$4
  implements PAGView.PAGViewListener
{
  AETipsViewController$4(AETipsViewController paramAETipsViewController) {}
  
  public void onAnimationCancel(PAGView paramPAGView)
  {
    AETipsViewController.d(this.a).setVisibility(8);
  }
  
  public void onAnimationEnd(PAGView paramPAGView)
  {
    AETipsViewController.d(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(PAGView paramPAGView) {}
  
  public void onAnimationStart(PAGView paramPAGView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.tips.AETipsViewController.4
 * JD-Core Version:    0.7.0.1
 */