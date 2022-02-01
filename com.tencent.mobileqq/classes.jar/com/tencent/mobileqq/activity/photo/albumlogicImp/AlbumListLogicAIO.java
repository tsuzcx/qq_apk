package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.AlbumListLogicDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.statistics.ReportController;

public class AlbumListLogicAIO
  extends AlbumListLogicDefault
{
  protected AlbumListLogicAIO(AlbumListFragment paramAlbumListFragment)
  {
    super(paramAlbumListFragment);
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
  }
  
  public boolean onItemClick(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    int i;
    if (paramQQAlbumInfo.id.equals("$RecentAlbumId")) {
      i = 1;
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X800A917", "0X800A917", i, 0, "", "", "", "");
      return super.onItemClick(paramQQAlbumInfo, paramInt, paramIntent);
      if (paramQQAlbumInfo.id.equals("qzone_album")) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListLogicAIO
 * JD-Core Version:    0.7.0.1
 */