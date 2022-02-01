package com.tencent.mobileqq.activity.photo.album.albumlist;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;

public abstract class AlbumListCustomization<O extends OtherCommonData>
{
  protected O a;
  protected PhotoCommonBaseData<O> a;
  public AbstractAlbumListFragment a;
  protected AlbumListBaseData a;
  public AlbumListCustomization.IalbumListAdapterCallBack a;
  
  protected AlbumListCustomization(AbstractAlbumListFragment paramAbstractAlbumListFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListCustomization$IalbumListAdapterCallBack = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment = paramAbstractAlbumListFragment;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData = PhotoCommonBaseData.getInstance(paramAbstractAlbumListFragment.getActivity().getIntent().getBooleanExtra("NEED_NEW_PHOTO_COMMON_DATA", true));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.bindCommonData(a());
    paramAbstractAlbumListFragment.getActivity().getIntent().putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.addHoldNember();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListBaseData = new AlbumListBaseData();
    if (QLog.isColorLevel())
    {
      paramAbstractAlbumListFragment = new StringBuilder();
      paramAbstractAlbumListFragment.append("AlbumListCustomization new，activity = ");
      paramAbstractAlbumListFragment.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment);
      paramAbstractAlbumListFragment.append(",PhotoCommonData = ");
      paramAbstractAlbumListFragment.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData);
      QLog.d("QQAlbum", 2, paramAbstractAlbumListFragment.toString());
    }
  }
  
  protected OtherCommonData a()
  {
    return new AlbumListCustomization.1(this);
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AlbumListCustomization close，activity = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment);
      localStringBuilder.append(",PhotoCommonData = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.releaseCommonData();
  }
  
  public abstract void a(Intent paramIntent);
  
  public abstract boolean a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomization
 * JD-Core Version:    0.7.0.1
 */