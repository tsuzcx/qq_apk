package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.utils.AlbumUtil;

public class PhotoListCustomizationExtendFriendAvatar
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationExtendFriendAvatar";
  
  protected PhotoListCustomizationExtendFriendAvatar(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 10021))
    {
      this.c.setResult(-1, paramIntent);
      this.c.finish();
    }
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    AlbumUtil.a();
    paramLocalMediaInfo = paramLocalMediaInfo.path;
    Intent localIntent = this.c.getIntent();
    localIntent.putExtra("ALBUM_NAME", this.e.albumName);
    localIntent.putExtra("ALBUM_ID", this.e.albumId);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.e.selectedPhotoList);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramLocalMediaInfo);
    localIntent.setClass(this.c, PhotoCropActivity.class);
    localIntent.putExtra("PHOTOLIST_START_POSITION", this.h.m.findFirstVisibleItemPosition());
    localIntent.putExtra("PhotoConst.SOURCE_FROM", "FROM_SELECT_PHOTO");
    this.c.startActivityForResult(localIntent, 10021);
    AlbumUtil.anim(this.c, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationExtendFriendAvatar
 * JD-Core Version:    0.7.0.1
 */