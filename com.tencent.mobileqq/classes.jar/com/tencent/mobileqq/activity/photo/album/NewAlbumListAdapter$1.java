package com.tencent.mobileqq.activity.photo.album;

import aild;
import aimd;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.data.QQAlbumInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class NewAlbumListAdapter$1
  implements Runnable
{
  public NewAlbumListAdapter$1(aimd paramaimd) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.getDataInfos();
    int i6 = 0;
    int i5 = 0;
    int i4 = 0;
    int j = 0;
    int i = 0;
    int i3 = 0;
    int i2 = 0;
    int i1 = 0;
    int n = 0;
    int m = 0;
    int k = 0;
    Object localObject2 = new ArrayList(((List)localObject1).size());
    ((List)localObject2).addAll((Collection)localObject1);
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (QQAlbumInfo)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((QQAlbumInfo)localObject2).mCoverInfo != null))
      {
        String str2 = AlbumListAdapter.getFileDirectoryOf(((QQAlbumInfo)localObject2).mCoverInfo.path);
        String str1 = ((QQAlbumInfo)localObject2).name;
        if ((str2 != null) && (str1 != null) && (!str1.equals("最近照片")) && (!str1.equals("空间照片")))
        {
          str2 = str2.toLowerCase(Locale.US);
          str1 = str1.toLowerCase(Locale.US);
          if (str2.contains("/tencent/"))
          {
            if (str2.contains("/qq_collection/")) {
              i3 += ((QQAlbumInfo)localObject2).mMediaFileCount;
            } else if ((str1.equals("qq_images")) || (str2.contains("/mobileqq/photo")) || (str2.contains("/mobileqq/diskcache"))) {
              i2 += ((QQAlbumInfo)localObject2).mMediaFileCount;
            } else if (str1.equals("qqfile_recv")) {
              i1 += ((QQAlbumInfo)localObject2).mMediaFileCount;
            } else if (str1.equals("qq_favorite")) {
              m += ((QQAlbumInfo)localObject2).mMediaFileCount;
            } else if (str2.contains("/zebra/cache")) {
              n += 1;
            } else if ((str1.equals("weixin")) || (str1.equals("wechat")) || (str1.equals("micromsg"))) {
              k += ((QQAlbumInfo)localObject2).mMediaFileCount;
            } else if (aild.a(str2)) {
              j += ((QQAlbumInfo)localObject2).mMediaFileCount;
            } else {
              i += ((QQAlbumInfo)localObject2).mMediaFileCount;
            }
          }
          else if (str1.equals("qq_screenshot")) {
            i5 += ((QQAlbumInfo)localObject2).mMediaFileCount;
          } else if ((str2.contains("screenshot")) || (str2.contains("截屏")) || (str2.contains("截图")) || (str2.equals("screen_cap")) || (str2.equals("ScreenCapture"))) {
            i4 += ((QQAlbumInfo)localObject2).mMediaFileCount;
          } else if ((str1.contains("camera")) || (str1.equals("dcim")) || (str1.equals("100MEDIA")) || (str1.equals("100ANDRO")) || (str1.contains("相机")) || (str1.contains("照片")) || (str1.contains("相片"))) {
            i6 += ((QQAlbumInfo)localObject2).mMediaFileCount;
          } else if (aild.a(str2)) {
            j += ((QQAlbumInfo)localObject2).mMediaFileCount;
          } else {
            i += ((QQAlbumInfo)localObject2).mMediaFileCount;
          }
        }
      }
    }
    aild.a(i6, i5, i4, j, i, i3, i2, i1, n, m, k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.NewAlbumListAdapter.1
 * JD-Core Version:    0.7.0.1
 */