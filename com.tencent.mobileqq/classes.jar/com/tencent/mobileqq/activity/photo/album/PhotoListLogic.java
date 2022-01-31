package com.tencent.mobileqq.activity.photo.album;

import aimj;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.CompoundButton;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaScannerListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public abstract class PhotoListLogic<K extends AbstractPhotoListActivity>
  implements MediaScanner.OnMediaScannerListener
{
  public K mActivity;
  public aimj mPhotoCommonData;
  protected PhotoListBaseData mPhotoListData;
  protected PhotoListLogic.IonSelectionChangeListener mSelectionListener = null;
  
  protected PhotoListLogic(K paramK)
  {
    this.mActivity = paramK;
    this.mPhotoCommonData = aimj.getInstance(paramK.getIntent().getBooleanExtra("NEED_NEW_PHOTO_COMMON_DATA", true));
    paramK.getIntent().putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    this.mPhotoCommonData.addHoldNember();
    this.mPhotoListData = new PhotoListBaseData();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListActivity", 2, "PhotoListLogic new，activity = " + paramK + ",PhotoCommonData = " + this.mPhotoCommonData);
    }
  }
  
  protected abstract boolean addAndRemovePhotoByGesture(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean);
  
  public void close()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListActivity", 2, "PhotoListLogic close，activity = " + this.mActivity + ",PhotoCommonData = " + this.mPhotoCommonData);
    }
    this.mPhotoCommonData.releaseCommonData();
  }
  
  protected abstract void doOnDestroy();
  
  protected abstract void doOnResume();
  
  protected abstract void enterAlbumListFragment(Intent paramIntent);
  
  protected abstract void enterPhotoPreviewActivity(boolean paramBoolean, Intent paramIntent);
  
  protected abstract String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo);
  
  protected abstract List<LocalMediaInfo> getLocalMediaInfos();
  
  protected abstract void handlePicCapture(Intent paramIntent);
  
  protected abstract void handleVideoCapture(Intent paramIntent);
  
  protected abstract void handleVideoEncodeSucceed(Message paramMessage);
  
  protected abstract void initData(Intent paramIntent);
  
  protected abstract boolean needVedio();
  
  protected abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  protected void onAlbumListShown(boolean paramBoolean) {}
  
  protected abstract void onBackPressed();
  
  protected abstract void onGestureSelectEnd(boolean paramBoolean, int paramInt1, int paramInt2);
  
  protected abstract void onMagicStickClick(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent);
  
  protected abstract void onPreviewBtnClick(View paramView);
  
  protected abstract void onQualityBtnClick(CompoundButton paramCompoundButton, boolean paramBoolean);
  
  protected abstract boolean onQueryPhoto(List<LocalMediaInfo> paramList);
  
  protected abstract void onSendBtnClick(View paramView);
  
  protected abstract void onTitleBtnCancelClick(View paramView);
  
  protected abstract void postInitUI();
  
  protected abstract void processQueryResult(List<LocalMediaInfo> paramList);
  
  protected abstract void startPhotoPreviewActivity(Intent paramIntent);
  
  protected abstract void updateButton();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogic
 * JD-Core Version:    0.7.0.1
 */