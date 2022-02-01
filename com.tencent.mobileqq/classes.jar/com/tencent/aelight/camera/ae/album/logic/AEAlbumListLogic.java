package com.tencent.aelight.camera.ae.album.logic;

import android.content.Intent;
import com.tencent.aelight.camera.ae.album.data.AEPhotoCommonDataCreator;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractAlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public abstract class AEAlbumListLogic<K extends AEAbstractAlbumListFragment>
{
  public static volatile AEAlbumListLogic a;
  public AEAlbumListLogic.IalbumListAdapterCallBack a;
  protected PhotoCommonBaseData a;
  public AlbumListBaseData a;
  public WeakReference<K> a;
  
  protected AEAlbumListLogic(K paramK)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEAlbumListLogic$IalbumListAdapterCallBack = null;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramK);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData = AEPhotoCommonDataCreator.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.addHoldNember();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListBaseData = new AlbumListBaseData();
    if (QLog.isColorLevel())
    {
      paramK = new StringBuilder();
      paramK.append("AlbumListLogic new，activity = ");
      paramK.append(this.jdField_a_of_type_MqqUtilWeakReference);
      paramK.append(",PhotoCommonData = ");
      paramK.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData);
      QLog.d("AlbumListActivity", 2, paramK.toString());
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AlbumListLogic new，fragment = ");
      localStringBuilder.append(this.jdField_a_of_type_MqqUtilWeakReference.get());
      localStringBuilder.append(",PhotoCommonData = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.releaseCommonData();
    jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEAlbumListLogic = null;
  }
  
  public abstract void a(Intent paramIntent);
  
  public abstract boolean a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogic
 * JD-Core Version:    0.7.0.1
 */