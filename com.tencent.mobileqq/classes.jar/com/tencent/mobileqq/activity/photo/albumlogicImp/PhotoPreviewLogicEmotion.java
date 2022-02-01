package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault;
import java.util.ArrayList;

class PhotoPreviewLogicEmotion
  extends PhotoPreviewLogicDefault
{
  protected PhotoPreviewLogicEmotion(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.a.customSendBtnText = ((NewPhotoPreviewActivity)this.mActivity).getString(2131694898);
  }
  
  public void initUI()
  {
    super.initUI();
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setOnClickListener(new PhotoPreviewLogicEmotion.1(this));
  }
  
  public boolean needShowMultiPhoto()
  {
    return (this.mPhotoCommonData.selectedPhotoList != null) && (!this.mPhotoCommonData.selectedPhotoList.isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewLogicEmotion
 * JD-Core Version:    0.7.0.1
 */