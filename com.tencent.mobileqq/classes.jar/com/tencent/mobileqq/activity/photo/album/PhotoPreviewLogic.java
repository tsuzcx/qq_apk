package com.tencent.mobileqq.activity.photo.album;

import aimj;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;

public abstract class PhotoPreviewLogic<K extends AbstractPhotoPreviewActivity>
{
  public K mActivity;
  protected PhotoPreviewLogic.IimageAdapterCallback mImageAdapterCallback = null;
  protected PhotoPreviewLogic.IonCheckedChangedCallback mOnCheckedChangedCallback = null;
  public aimj mPhotoCommonData;
  protected PhotoPreviewBaseData mPhotoPreviewData;
  
  protected PhotoPreviewLogic(K paramK)
  {
    this.mActivity = paramK;
    this.mPhotoCommonData = aimj.getInstance(paramK.getIntent().getBooleanExtra("NEED_NEW_PHOTO_COMMON_DATA", true));
    paramK.getIntent().putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    this.mPhotoCommonData.addHoldNember();
    this.mPhotoPreviewData = new PhotoPreviewBaseData();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, "PhotoPreviewLogic new，activity = " + paramK + ",PhotoCommonData = " + this.mPhotoCommonData);
    }
  }
  
  public void close()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, "PhotoPreviewLogic close，activity = " + this.mActivity + ",PhotoCommonData = " + this.mPhotoCommonData);
    }
    this.mPhotoCommonData.releaseCommonData();
  }
  
  protected abstract void doOnDestroy();
  
  protected abstract void doOnResume();
  
  protected abstract void initData(Intent paramIntent);
  
  protected abstract void initUI();
  
  protected abstract boolean needShowMultiPhoto();
  
  protected abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  protected abstract void onBackPressed(boolean paramBoolean);
  
  protected abstract void onGalleryItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong);
  
  protected abstract void onMagicStickClick(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent);
  
  protected abstract void onQualityBtnClick(CompoundButton paramCompoundButton, boolean paramBoolean);
  
  protected abstract void onSelectClick(View paramView);
  
  protected abstract void updateButton();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogic
 * JD-Core Version:    0.7.0.1
 */