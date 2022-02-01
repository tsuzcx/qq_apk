package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerContainer;

class EditVideoSpeedFilter$1
  implements Runnable
{
  EditVideoSpeedFilter$1(EditVideoSpeedFilter paramEditVideoSpeedFilter) {}
  
  public void run()
  {
    if (!EditVideoSpeedFilter.a(this.this$0)) {
      return;
    }
    if (this.this$0.t.M() == null) {
      return;
    }
    Object localObject = this.this$0.t.M().getActivity();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      if ((Build.VERSION.SDK_INT > 16) && (((Activity)localObject).isDestroyed())) {
        return;
      }
      localObject = this.this$0;
      EditVideoSpeedFilter.a((EditVideoSpeedFilter)localObject, (ViewStub)((EditVideoSpeedFilter)localObject).d(2063991314));
      if (this.this$0.m == null)
      {
        localObject = EditVideoSpeedFilter.b(this.this$0).getParent();
        if ((localObject != null) && ((localObject instanceof ViewGroup)))
        {
          localObject = this.this$0;
          ((EditVideoSpeedFilter)localObject).m = ((PickerContainer)EditVideoSpeedFilter.b((EditVideoSpeedFilter)localObject).inflate());
        }
        else
        {
          localObject = this.this$0;
          ((EditVideoSpeedFilter)localObject).m = ((PickerContainer)((EditVideoSpeedFilter)localObject).d(2131445030));
        }
        this.this$0.m.a(this.this$0.t.I, this.this$0);
        this.this$0.m.a(2, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoSpeedFilter.1
 * JD-Core Version:    0.7.0.1
 */