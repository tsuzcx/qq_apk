package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.utils.AlbumUtil;

public class PhotoListCustomizationProfileCustomCover
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationProfileCustomCover";
  
  protected PhotoListCustomizationProfileCustomCover(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    AlbumUtil.a();
    String str = paramLocalMediaInfo.path;
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
    localIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
    localIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
    localIntent.putExtra("media_info", paramLocalMediaInfo);
    localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, PhotoCropActivity.class);
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    localIntent.putExtra("PhotoConst.SOURCE_FROM", "FROM_SELECT_PHOTO");
    localIntent.addFlags(603979776);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.startActivity(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
    AlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationProfileCustomCover
 * JD-Core Version:    0.7.0.1
 */