package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.play.AETemplateInfoFragment;
import dov.com.qq.im.ae.report.AEBaseDataReporter;

class PhotoPreviewLogicAEPlay$1
  implements View.OnClickListener
{
  PhotoPreviewLogicAEPlay$1(PhotoPreviewLogicAEPlay paramPhotoPreviewLogicAEPlay) {}
  
  public void onClick(View paramView)
  {
    if (PhotoPreviewLogicAEPlay.a(this.a))
    {
      QLog.d("PhotoPreviewLogicAEPlay", 2, "need more pic.");
      PhotoPreviewLogicAEPlay.a(this.a, String.format(((NewPhotoPreviewActivity)this.a.mActivity).getString(2131689785), new Object[] { Integer.valueOf(PhotoPreviewLogicAEPlay.a(this.a).maxSelectNum) }));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((NewPhotoPreviewActivity)this.a.mActivity).sendBtn.setClickable(false);
      Intent localIntent = new Intent();
      localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", PhotoPreviewLogicAEPlay.b(this.a).selectedPhotoList);
      localIntent.putExtra("pic_choose_in_node_id", ((NewPhotoPreviewActivity)this.a.mActivity).getIntent().getIntExtra("pic_choose_in_node_id", 0));
      localIntent.putExtra("pic_result_back_type", 0);
      AETemplateInfoFragment.sendPickedPhotosToMe(this.a.mActivity, localIntent);
      AEBaseDataReporter.a().U();
      ((NewPhotoPreviewActivity)this.a.mActivity).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewLogicAEPlay.1
 * JD-Core Version:    0.7.0.1
 */