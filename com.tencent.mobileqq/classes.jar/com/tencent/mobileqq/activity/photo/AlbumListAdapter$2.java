package com.tencent.mobileqq.activity.photo;

import aglc;
import agqf;
import ajyc;
import apvb;
import com.tencent.mobileqq.data.QQAlbumInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class AlbumListAdapter$2
  implements Runnable
{
  public AlbumListAdapter$2(aglc paramaglc) {}
  
  public void run()
  {
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
    Object localObject = new ArrayList(this.this$0.a.size());
    ((List)localObject).addAll(this.this$0.a);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      QQAlbumInfo localQQAlbumInfo = (QQAlbumInfo)((Iterator)localObject).next();
      if ((localQQAlbumInfo != null) && (localQQAlbumInfo.mCoverInfo != null))
      {
        String str2 = apvb.c(localQQAlbumInfo.mCoverInfo.path);
        String str1 = localQQAlbumInfo.name;
        if ((str2 != null) && (str1 != null) && (!str1.equals(ajyc.a(2131700189))) && (!str1.equals(ajyc.a(2131700197))))
        {
          str2 = str2.toLowerCase(Locale.US);
          str1 = str1.toLowerCase(Locale.US);
          if (str2.contains("/tencent/"))
          {
            if (str2.contains("/qq_collection/")) {
              i3 += localQQAlbumInfo.mMediaFileCount;
            } else if ((str1.equals("qq_images")) || (str2.contains("/mobileqq/photo")) || (str2.contains("/mobileqq/diskcache"))) {
              i2 += localQQAlbumInfo.mMediaFileCount;
            } else if (str1.equals("qqfile_recv")) {
              i1 += localQQAlbumInfo.mMediaFileCount;
            } else if (str1.equals("qq_favorite")) {
              m += localQQAlbumInfo.mMediaFileCount;
            } else if (str2.contains("/zebra/cache")) {
              n += 1;
            } else if ((str1.equals("weixin")) || (str1.equals("wechat")) || (str1.equals("micromsg"))) {
              k += localQQAlbumInfo.mMediaFileCount;
            } else if (agqf.a(str2)) {
              j += localQQAlbumInfo.mMediaFileCount;
            } else {
              i += localQQAlbumInfo.mMediaFileCount;
            }
          }
          else if (str1.equals("qq_screenshot")) {
            i5 += localQQAlbumInfo.mMediaFileCount;
          } else if ((str2.contains("screenshot")) || (str2.contains(ajyc.a(2131700191))) || (str2.contains(ajyc.a(2131700198))) || (str2.equals("screen_cap")) || (str2.equals("ScreenCapture"))) {
            i4 += localQQAlbumInfo.mMediaFileCount;
          } else if ((str1.contains("camera")) || (str1.equals("dcim")) || (str1.equals("100MEDIA")) || (str1.equals("100ANDRO")) || (str1.contains(ajyc.a(2131700183))) || (str1.contains(ajyc.a(2131700185))) || (str1.contains(ajyc.a(2131700187)))) {
            i6 += localQQAlbumInfo.mMediaFileCount;
          } else if (agqf.a(str2)) {
            j += localQQAlbumInfo.mMediaFileCount;
          } else {
            i += localQQAlbumInfo.mMediaFileCount;
          }
        }
      }
    }
    agqf.a(i6, i5, i4, j, i, i3, i2, i1, n, m, k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.AlbumListAdapter.2
 * JD-Core Version:    0.7.0.1
 */