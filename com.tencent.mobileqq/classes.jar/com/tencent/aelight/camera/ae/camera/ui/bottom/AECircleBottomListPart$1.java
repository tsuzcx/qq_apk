package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;

class AECircleBottomListPart$1
  implements AEBottomListAdapter.AEBottomListListener
{
  AECircleBottomListPart$1(AECircleBottomListPart paramAECircleBottomListPart) {}
  
  public void a()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", false);
    this.a.a.s().sendBroadcast(localIntent);
    AECircleBottomListPart.a(this.a).b(131076, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AECircleBottomListPart.1
 * JD-Core Version:    0.7.0.1
 */