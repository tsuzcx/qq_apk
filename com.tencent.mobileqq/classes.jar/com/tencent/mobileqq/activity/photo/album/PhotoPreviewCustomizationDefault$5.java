package com.tencent.mobileqq.activity.photo.album;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

class PhotoPreviewCustomizationDefault$5
  implements View.OnClickListener
{
  PhotoPreviewCustomizationDefault$5(PhotoPreviewCustomizationDefault paramPhotoPreviewCustomizationDefault) {}
  
  public void onClick(View paramView)
  {
    this.a.s().l.setClickable(false);
    this.a.j();
    LpReportInfo_pf00064.allReport(603, 1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault.5
 * JD-Core Version:    0.7.0.1
 */