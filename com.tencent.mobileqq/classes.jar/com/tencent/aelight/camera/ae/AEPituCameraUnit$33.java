package com.tencent.aelight.camera.ae;

import android.os.Handler;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

class AEPituCameraUnit$33
  implements Runnable
{
  AEPituCameraUnit$33(AEPituCameraUnit paramAEPituCameraUnit, LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable) {}
  
  public void run()
  {
    if (AEPituCameraUnit.p(this.this$0) == null)
    {
      ViewStub localViewStub = (ViewStub)this.this$0.g.findViewById(2063991436);
      AEPituCameraUnit.a(this.this$0, (ImageView)localViewStub.inflate().findViewById(2063990887));
    }
    this.this$0.D.postDelayed(AEPituCameraUnit.q(this.this$0), this.a.getTotalDuration());
    AEPituCameraUnit.p(this.this$0).setVisibility(0);
    AEPituCameraUnit.p(this.this$0).setImageDrawable(this.a);
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.33
 * JD-Core Version:    0.7.0.1
 */