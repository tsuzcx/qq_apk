package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.AlbumListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;

public class AlbumListCustomizationQzone
  extends AlbumListCustomizationDefault
{
  public static final String j = "com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationQzone";
  boolean k = false;
  
  protected AlbumListCustomizationQzone(AbstractAlbumListFragment paramAbstractAlbumListFragment)
  {
    super(paramAbstractAlbumListFragment);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.k = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_QZONE_AND_NEED_FILTER_RECENT_IMAGES", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationQzone
 * JD-Core Version:    0.7.0.1
 */