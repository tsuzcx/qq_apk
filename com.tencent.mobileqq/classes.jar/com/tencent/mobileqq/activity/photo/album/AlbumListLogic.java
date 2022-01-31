package com.tencent.mobileqq.activity.photo.album;

import aiqy;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;

public abstract class AlbumListLogic<K extends AbstractAlbumListFragment>
{
  protected AlbumListLogic.IalbumListAdapterCallBack mAlbumListAdapterCallBack = null;
  protected AlbumListBaseData mAlbumListData;
  public K mFragment;
  public aiqy mPhotoCommonData;
  
  protected AlbumListLogic(K paramK)
  {
    this.mFragment = paramK;
    this.mPhotoCommonData = aiqy.getInstance(paramK.getActivity().getIntent().getBooleanExtra("NEED_NEW_PHOTO_COMMON_DATA", true));
    paramK.getActivity().getIntent().putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    this.mPhotoCommonData.addHoldNember();
    this.mAlbumListData = new AlbumListBaseData();
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListFragment", 2, "AlbumListLogic new，activity = " + this.mFragment + ",PhotoCommonData = " + this.mPhotoCommonData);
    }
  }
  
  public void close()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListFragment", 2, "AlbumListLogic close，activity = " + this.mFragment + ",PhotoCommonData = " + this.mPhotoCommonData);
    }
    this.mPhotoCommonData.releaseCommonData();
  }
  
  protected abstract void initData(Intent paramIntent);
  
  protected abstract boolean onItemClick(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent);
  
  protected abstract void postInitUI();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AlbumListLogic
 * JD-Core Version:    0.7.0.1
 */