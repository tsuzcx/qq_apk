package com.tencent.mobileqq.activity.photo.album;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

class PhotoPreviewLogicDefault$4
  implements View.OnClickListener
{
  PhotoPreviewLogicDefault$4(PhotoPreviewLogicDefault paramPhotoPreviewLogicDefault) {}
  
  public void onClick(View paramView)
  {
    ((NewPhotoPreviewActivity)this.a.mActivity).sendBtn.setClickable(false);
    if (((NewPhotoPreviewActivity)this.a.mActivity).getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false)) {
      if (FileManagerUtil.a()) {
        FMDialogUtil.a(this.a.mActivity, 2131692609, 2131692614, new PhotoPreviewLogicDefault.4.1(this));
      }
    }
    for (;;)
    {
      LpReportInfo_pf00064.allReport(603, 1);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.d();
      continue;
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault.4
 * JD-Core Version:    0.7.0.1
 */