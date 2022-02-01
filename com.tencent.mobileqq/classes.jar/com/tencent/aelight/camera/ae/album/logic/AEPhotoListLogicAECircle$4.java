package com.tencent.aelight.camera.ae.album.logic;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qcircle.tavcut.exporter.MovieExporter;

class AEPhotoListLogicAECircle$4
  implements View.OnClickListener
{
  AEPhotoListLogicAECircle$4(AEPhotoListLogicAECircle paramAEPhotoListLogicAECircle) {}
  
  public void onClick(View paramView)
  {
    if (AEPhotoListLogicAECircle.a(this.a) != null)
    {
      if (AEPhotoListLogicAECircle.d(this.a) != null) {
        AEPhotoListLogicAECircle.d(this.a).cancelCompress();
      }
      AEPhotoListLogicAECircle.a(this.a).dismiss();
      AEPhotoListLogicAECircle.a(this.a, null);
      AEPhotoListLogicAECircle.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicAECircle.4
 * JD-Core Version:    0.7.0.1
 */