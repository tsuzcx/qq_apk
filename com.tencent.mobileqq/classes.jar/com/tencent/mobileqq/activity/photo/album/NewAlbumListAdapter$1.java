package com.tencent.mobileqq.activity.photo.album;

import akgm;
import akhm;
import akhn;
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
  public NewAlbumListAdapter$1(akhm paramakhm) {}
  
  public void run()
  {
    akhn localakhn = new akhn();
    Object localObject1 = this.this$0.getDataInfos();
    Object localObject2 = new ArrayList(((List)localObject1).size());
    ((List)localObject2).addAll((Collection)localObject1);
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (QQAlbumInfo)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((QQAlbumInfo)localObject2).mCoverInfo != null))
      {
        String str1 = AlbumListAdapter.getFileDirectoryOf(((QQAlbumInfo)localObject2).mCoverInfo.path);
        String str2 = ((QQAlbumInfo)localObject2).name;
        if ((str1 != null) && (str2 != null) && (!str2.equals("最近照片")) && (!str2.equals("空间照片")))
        {
          str1 = str1.toLowerCase(Locale.US);
          if (str1.contains("/tencent/")) {
            akhm.a(localakhn, str1, (QQAlbumInfo)localObject2);
          } else {
            akhm.b(localakhn, str1, (QQAlbumInfo)localObject2);
          }
        }
      }
    }
    akgm.a(localakhn.a, localakhn.b, localakhn.c, localakhn.d, localakhn.e, localakhn.f, localakhn.g, localakhn.h, localakhn.i, localakhn.j, localakhn.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.NewAlbumListAdapter.1
 * JD-Core Version:    0.7.0.1
 */