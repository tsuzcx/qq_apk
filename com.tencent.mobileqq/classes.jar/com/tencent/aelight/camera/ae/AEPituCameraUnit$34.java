package com.tencent.aelight.camera.ae;

import android.widget.ImageView;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

class AEPituCameraUnit$34
  implements Runnable
{
  AEPituCameraUnit$34(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void run()
  {
    AEPituCameraUnit.p(this.this$0).setVisibility(8);
    if (AEPituCameraUnit.p(this.this$0).getDrawable() != null)
    {
      LazyLoadAnimationDrawable localLazyLoadAnimationDrawable = (LazyLoadAnimationDrawable)AEPituCameraUnit.p(this.this$0).getDrawable();
      localLazyLoadAnimationDrawable.stop();
      localLazyLoadAnimationDrawable.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.34
 * JD-Core Version:    0.7.0.1
 */