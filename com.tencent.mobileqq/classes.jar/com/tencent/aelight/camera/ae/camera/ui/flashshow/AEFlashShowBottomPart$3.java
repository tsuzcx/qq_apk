package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.flashshow.FlashShowDtReportHelper;
import com.tencent.qqlive.module.videoreport.VideoReport;

class AEFlashShowBottomPart$3
  implements View.OnClickListener
{
  AEFlashShowBottomPart$3(AEFlashShowBottomPart paramAEFlashShowBottomPart) {}
  
  public void onClick(View paramView)
  {
    AEFlashShowBottomPart.c(this.a).b().postValue(Boolean.valueOf(true));
    VideoReport.reportEvent("dt_clck", AEFlashShowBottomPart.e(this.a), FlashShowDtReportHelper.a().d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPart.3
 * JD-Core Version:    0.7.0.1
 */