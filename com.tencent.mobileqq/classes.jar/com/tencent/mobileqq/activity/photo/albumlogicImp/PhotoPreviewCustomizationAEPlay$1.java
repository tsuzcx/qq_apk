package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.aelight.camera.play.api.IAETemplateInfo;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoPreviewCustomizationAEPlay$1
  implements View.OnClickListener
{
  PhotoPreviewCustomizationAEPlay$1(PhotoPreviewCustomizationAEPlay paramPhotoPreviewCustomizationAEPlay) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (PhotoPreviewCustomizationAEPlay.a(this.a))
    {
      QLog.d("PhotoPreviewCustomizationAEPlay", 2, "need more pic.");
      localObject = this.a;
      PhotoPreviewCustomizationAEPlay.a((PhotoPreviewCustomizationAEPlay)localObject, String.format(PhotoPreviewCustomizationAEPlay.b((PhotoPreviewCustomizationAEPlay)localObject).getString(2131886358), new Object[] { Integer.valueOf(this.a.f.maxSelectNum) }));
    }
    else
    {
      this.a.s().l.setClickable(false);
      localObject = new Intent();
      ((Intent)localObject).putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.a.f.selectedPhotoList);
      ((Intent)localObject).putExtra("pic_choose_in_node_id", PhotoPreviewCustomizationAEPlay.c(this.a).getIntent().getIntExtra("pic_choose_in_node_id", 0));
      ((Intent)localObject).putExtra("pic_result_back_type", 0);
      ((IAETemplateInfo)QRoute.api(IAETemplateInfo.class)).sendPickedPhotosToMe(PhotoPreviewCustomizationAEPlay.d(this.a), (Intent)localObject);
      ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportPicChooseNextBtn();
      PhotoPreviewCustomizationAEPlay.e(this.a).finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAEPlay.1
 * JD-Core Version:    0.7.0.1
 */