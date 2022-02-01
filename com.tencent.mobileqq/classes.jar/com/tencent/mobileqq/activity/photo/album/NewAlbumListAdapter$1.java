package com.tencent.mobileqq.activity.photo.album;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.data.QQAlbumInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

class NewAlbumListAdapter$1
  implements Runnable
{
  NewAlbumListAdapter$1(NewAlbumListAdapter paramNewAlbumListAdapter) {}
  
  public void run()
  {
    NewAlbumListAdapter.AlbumStatistic localAlbumStatistic = new NewAlbumListAdapter.AlbumStatistic();
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
            NewAlbumListAdapter.a(localAlbumStatistic, str1, (QQAlbumInfo)localObject2);
          } else {
            NewAlbumListAdapter.b(localAlbumStatistic, str1, (QQAlbumInfo)localObject2);
          }
        }
      }
    }
    StatisticConstants.a(localAlbumStatistic.a, localAlbumStatistic.b, localAlbumStatistic.c, localAlbumStatistic.d, localAlbumStatistic.e, localAlbumStatistic.f, localAlbumStatistic.g, localAlbumStatistic.h, localAlbumStatistic.i, localAlbumStatistic.j, localAlbumStatistic.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.NewAlbumListAdapter.1
 * JD-Core Version:    0.7.0.1
 */