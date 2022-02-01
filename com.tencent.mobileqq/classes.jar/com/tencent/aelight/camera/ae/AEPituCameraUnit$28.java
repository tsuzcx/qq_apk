package com.tencent.aelight.camera.ae;

import android.os.Handler;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

class AEPituCameraUnit$28
  implements Runnable
{
  AEPituCameraUnit$28(AEPituCameraUnit paramAEPituCameraUnit, LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable) {}
  
  public void run()
  {
    if (AEPituCameraUnit.a(this.this$0) == null)
    {
      ViewStub localViewStub = (ViewStub)this.this$0.jdField_a_of_type_AndroidViewView.findViewById(2064122649);
      AEPituCameraUnit.a(this.this$0, (ImageView)localViewStub.inflate().findViewById(2064121956));
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(AEPituCameraUnit.a(this.this$0), this.a.getTotalDuration());
    AEPituCameraUnit.a(this.this$0).setVisibility(0);
    AEPituCameraUnit.a(this.this$0).setImageDrawable(this.a);
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.28
 * JD-Core Version:    0.7.0.1
 */