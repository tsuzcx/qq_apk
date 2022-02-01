package com.tencent.aelight.camera.ae.biz.circle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.aelight.camera.ae.biz.circle.part.AECircleRecomAutoTemplatePart;
import com.tencent.aelight.camera.ae.biz.circle.part.AECircleSelectPanelPart;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import java.util.ArrayList;
import java.util.HashMap;

class AECirclePhotoListFragment$1
  extends BroadcastReceiver
{
  AECirclePhotoListFragment$1(AECirclePhotoListFragment paramAECirclePhotoListFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      paramContext = (ArrayList)paramIntent.getExtras().getSerializable("key_photo_path_between_fragment");
      paramIntent = (HashMap)paramIntent.getExtras().getSerializable("key_qcircle_mid_page_photo_path");
      if ((paramContext != null) && (paramContext.size() > 0) && (!this.a.i.equals("midPageMultiReplace")))
      {
        this.a.a.c.selectedPhotoList.addAll(paramContext);
        if (this.a.a.c.selectedMediaInfoHashMap == null) {
          this.a.a.c.selectedMediaInfoHashMap = new HashMap();
        }
        this.a.a.c.selectedMediaInfoHashMap.putAll(paramIntent);
        paramContext = this.a;
        paramContext.i = "midPageMultiReplace";
        if (paramContext.f != null) {
          this.a.f.e();
        }
        if (this.a.h != null) {
          this.a.h.d();
        }
        AECirclePhotoListFragment.a(this.a, Boolean.valueOf(true));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListFragment.1
 * JD-Core Version:    0.7.0.1
 */