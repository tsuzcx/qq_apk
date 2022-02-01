package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.QQAlbumUtils;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.AlbumUtil;

public class PhotoListCustomizationCrop
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationCrop";
  
  public PhotoListCustomizationCrop(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    AlbumUtil.a();
    String str = paramLocalMediaInfo.path;
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
    localIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
    localIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
    localIntent.putExtra("media_info", paramLocalMediaInfo);
    if (localIntent.getBooleanExtra("PhotoConst.MULTI_PREVIEW_IN_SINGLE_MODE", false))
    {
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mediaPathsList);
      localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramLocalMediaInfo.position);
    }
    paramInt = localIntent.getIntExtra("Business_Origin", 0);
    if ((100 != paramInt) && (102 != paramInt) && (103 != paramInt))
    {
      localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, PhotoCropActivity.class);
    }
    else
    {
      if (100 == paramInt)
      {
        int i = ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity);
        localIntent.putExtra("PhotoConst.CLIP_WIDTH", i);
        localIntent.putExtra("PhotoConst.CLIP_HEIGHT", i);
        localIntent.putExtra("PhotoConst.TARGET_WIDTH", 1080);
        localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 1080);
        localIntent.putExtra("PhotoConst.TARGET_SAMPLE_SIZE", 1620);
      }
      else
      {
        localIntent.putExtra("PhotoConst.IS_WITH_PENDANT", false);
        localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
        localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
      }
      localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, PhotoCropForPortraitActivity.class);
      localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getShapeOfBusi(paramInt));
    }
    QQAlbumUtils.a(localIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, str, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.q);
    localIntent.putExtra("PHOTOLIST_START_POSITION", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a.findFirstVisibleItemPosition());
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    localIntent.putExtra("PhotoConst.SOURCE_FROM", "FROM_SELECT_PHOTO");
    localIntent.addFlags(603979776);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.startActivity(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
    AlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationCrop
 * JD-Core Version:    0.7.0.1
 */