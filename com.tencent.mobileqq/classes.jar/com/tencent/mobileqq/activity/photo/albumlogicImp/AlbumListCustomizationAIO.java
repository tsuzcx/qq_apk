package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.AlbumListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.statistics.ReportController;

public class AlbumListCustomizationAIO
  extends AlbumListCustomizationDefault
{
  public static final String j = "com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationAIO";
  
  protected AlbumListCustomizationAIO(AbstractAlbumListFragment paramAbstractAlbumListFragment)
  {
    super(paramAbstractAlbumListFragment);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
  }
  
  public boolean a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    int i;
    if (paramQQAlbumInfo.id.equals("$RecentAlbumId")) {
      i = 1;
    } else if (paramQQAlbumInfo.id.equals("qzone_album")) {
      i = 2;
    } else {
      i = 3;
    }
    ReportController.b(null, "CliOper", "", ((PhotoOtherData)this.e).e, "0X800A917", "0X800A917", i, 0, "", "", "", "");
    return super.a(paramQQAlbumInfo, paramInt, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationAIO
 * JD-Core Version:    0.7.0.1
 */