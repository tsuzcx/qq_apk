package com.tencent.mobileqq.activity.photo.album;

import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class NewAlbumListAdapter
  extends AlbumListAdapter
{
  public long a;
  public QQAlbumInfo a;
  
  public NewAlbumListAdapter(AlbumListFragment paramAlbumListFragment)
  {
    super(paramAlbumListFragment);
  }
  
  public static void a(NewAlbumListAdapter.AlbumStatistic paramAlbumStatistic, String paramString, QQAlbumInfo paramQQAlbumInfo)
  {
    String str = paramQQAlbumInfo.name;
    if (paramString.contains("/qq_collection/"))
    {
      paramAlbumStatistic.f += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if ((str.equals("qq_images")) || (paramString.contains("/mobileqq/photo")) || (paramString.contains("/mobileqq/diskcache")))
    {
      paramAlbumStatistic.g += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if (str.equals("qqfile_recv"))
    {
      paramAlbumStatistic.h += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if (str.equals("qq_favorite"))
    {
      paramAlbumStatistic.j += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if (paramString.contains("/zebra/cache"))
    {
      paramAlbumStatistic.i += 1;
      return;
    }
    if ((str.equals("weixin")) || (str.equals("wechat")) || (str.equals("micromsg")))
    {
      paramAlbumStatistic.k += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if (StatisticConstants.a(paramString))
    {
      paramAlbumStatistic.d += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    paramAlbumStatistic.e += paramQQAlbumInfo.mMediaFileCount;
  }
  
  public static void b(NewAlbumListAdapter.AlbumStatistic paramAlbumStatistic, String paramString, QQAlbumInfo paramQQAlbumInfo)
  {
    String str = paramQQAlbumInfo.name;
    if (str.equals("qq_screenshot"))
    {
      paramAlbumStatistic.b += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if ((paramString.contains("screenshot")) || (paramString.contains("截屏")) || (paramString.contains("截图")) || (paramString.equals("screen_cap")) || (paramString.equals("ScreenCapture")))
    {
      paramAlbumStatistic.c += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if ((str.contains("camera")) || (str.equals("dcim")) || (str.equals("100MEDIA")) || (str.equals("100ANDRO")) || (str.contains("相机")) || (str.contains("照片")) || (str.contains("相片")))
    {
      paramAlbumStatistic.a += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if (StatisticConstants.a(paramString))
    {
      paramAlbumStatistic.d += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    paramAlbumStatistic.e += paramQQAlbumInfo.mMediaFileCount;
  }
  
  public void a(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    this.jdField_a_of_type_Long = paramLong;
    QQAlbumInfo localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo.id = "qzone_album";
    localQQAlbumInfo.name = "空间相册";
    localQQAlbumInfo.mMediaFileCount = ((int)this.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListAdapter", 1, "setQzoneAlbumNum " + paramLong);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataQQAlbumInfo = localQQAlbumInfo;
  }
  
  protected List<QQAlbumInfo> getDefaultAlbums()
  {
    List localList = super.getDefaultAlbums();
    if ((localList != null) && (this.jdField_a_of_type_ComTencentMobileqqDataQQAlbumInfo != null)) {
      localList.add(0, this.jdField_a_of_type_ComTencentMobileqqDataQQAlbumInfo);
    }
    return localList;
  }
  
  void setData()
  {
    super.setData();
    ThreadManager.post(new NewAlbumListAdapter.1(this), 2, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.NewAlbumListAdapter
 * JD-Core Version:    0.7.0.1
 */