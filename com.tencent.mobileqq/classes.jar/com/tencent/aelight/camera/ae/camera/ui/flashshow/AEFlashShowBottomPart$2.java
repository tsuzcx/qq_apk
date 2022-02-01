package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.flashshow.FlashShowDtReportHelper;
import com.tencent.qqlive.module.videoreport.VideoReport;

class AEFlashShowBottomPart$2
  implements View.OnClickListener
{
  AEFlashShowBottomPart$2(AEFlashShowBottomPart paramAEFlashShowBottomPart) {}
  
  public void onClick(View paramView)
  {
    AEFlashShowBottomPart.c(this.a).a().postValue(new MaterialPanelOpenState(true, null));
    VideoReport.reportEvent("dt_clck", AEFlashShowBottomPart.d(this.a), FlashShowDtReportHelper.a().d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPart.2
 * JD-Core Version:    0.7.0.1
 */