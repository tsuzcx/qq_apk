package com.tencent.aelight.camera.ae.biz.circle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.aelight.camera.ae.biz.circle.part.AECircleRecomAutoTemplatePart;

class AECirclePhotoListFragment$4
  extends BroadcastReceiver
{
  AECirclePhotoListFragment$4(AECirclePhotoListFragment paramAECirclePhotoListFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (this.a.h != null)) {
      this.a.h.a(paramIntent.getExtras());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListFragment.4
 * JD-Core Version:    0.7.0.1
 */