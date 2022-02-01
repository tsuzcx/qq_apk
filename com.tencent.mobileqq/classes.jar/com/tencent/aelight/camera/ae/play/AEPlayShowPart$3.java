package com.tencent.aelight.camera.ae.play;

import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;
import com.tencent.image.ApngImage;

class AEPlayShowPart$3
  extends ViewPager.SimpleOnPageChangeListener
{
  AEPlayShowPart$3(AEPlayShowPart paramAEPlayShowPart) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 0)
    {
      ApngImage.resumeAll();
      return;
    }
    ApngImage.pauseAll();
  }
  
  public void onPageSelected(int paramInt)
  {
    AEPlayShowPart.access$200(this.this$0).onTabChecked(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEPlayShowPart.3
 * JD-Core Version:    0.7.0.1
 */