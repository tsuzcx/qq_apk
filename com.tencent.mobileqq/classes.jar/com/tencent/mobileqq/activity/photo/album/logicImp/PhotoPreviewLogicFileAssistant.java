package com.tencent.mobileqq.activity.photo.album.logicImp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewAdapter;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;

public class PhotoPreviewLogicFileAssistant
  extends PhotoPreviewLogicDefault
{
  public PhotoPreviewLogicFileAssistant(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoListActivity", 2, "sendPicAndVideoToFileAssistant...");
    }
    if ((this.mActivity == null) || (((NewPhotoPreviewActivity)this.mActivity).isFinishing())) {
      return;
    }
    if (((NewPhotoPreviewActivity)this.mActivity).getIntent().getParcelableExtra("PhotoConst.sendToAIOIntent") != null) {}
    for (Intent localIntent = (Intent)((NewPhotoPreviewActivity)this.mActivity).getIntent().getParcelableExtra("PhotoConst.sendToAIOIntent");; localIntent = ((NewPhotoPreviewActivity)this.mActivity).getIntent())
    {
      localIntent.setExtrasClassLoader(PeakConstants.class.getClassLoader());
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      localIntent.putExtra("PhotoConst.PHOTO_PATHS", ((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList());
      ((NewPhotoPreviewActivity)this.mActivity).setResult(-1, localIntent);
      ((NewPhotoPreviewActivity)this.mActivity).finish();
      AlbumUtil.anim(this.mActivity, false, false);
      return;
    }
  }
  
  public boolean needShowMultiPhoto()
  {
    return (this.mPhotoCommonData.selectedPhotoList != null) && (!this.mPhotoCommonData.selectedPhotoList.isEmpty());
  }
  
  public void onGalleryItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onGalleryItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    paramAdapterView = ((NewPhotoPreviewActivity)this.mActivity).adapter.getItem(paramInt);
    if (((NewPhotoPreviewActivity)this.mActivity).getMediaType(paramAdapterView) == 1) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(8);
      ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(8);
      ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(8);
      ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setVisibility(8);
      ((NewPhotoPreviewActivity)this.mActivity).flashTv.setVisibility(8);
      return;
    }
    if (this.a.c) {
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(0);
    }
    for (;;)
    {
      ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(8);
      ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(8);
      ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setVisibility(8);
      ((NewPhotoPreviewActivity)this.mActivity).flashTv.setVisibility(8);
      return;
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(8);
    }
  }
  
  public void onMagicStickClick(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    if (paramBundle != null)
    {
      paramBundle.putBoolean("key_multi_edit_pic", true);
      paramBundle.putBoolean("key_enable_edit_title_bar", true);
    }
    super.onMagicStickClick(paramView, 10000, paramBundle, paramInt2, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.logicImp.PhotoPreviewLogicFileAssistant
 * JD-Core Version:    0.7.0.1
 */