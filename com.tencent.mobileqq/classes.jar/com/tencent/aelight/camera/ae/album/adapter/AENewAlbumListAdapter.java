package com.tencent.aelight.camera.ae.album.adapter;

import com.tencent.aelight.camera.ae.album.fragment.AEAlbumListFragment;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class AENewAlbumListAdapter
  extends AEAlbumListAdapter
{
  public long a;
  public boolean b;
  boolean c;
  
  public AENewAlbumListAdapter(AEAlbumListFragment paramAEAlbumListFragment)
  {
    super(paramAEAlbumListFragment);
  }
  
  boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() != 0)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (((QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(i)).id.equals("qzone_album")) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  protected void b(QQAlbumInfo paramQQAlbumInfo)
  {
    Object localObject;
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localObject = (QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(0);
      if (!((QQAlbumInfo)localObject).id.equals("$RecentAlbumId")) {
        if (((QQAlbumInfo)localObject).id.equals("qzone_album")) {
          this.jdField_a_of_type_JavaUtilList.add(1, paramQQAlbumInfo);
        } else {
          this.jdField_a_of_type_JavaUtilList.add(0, paramQQAlbumInfo);
        }
      }
    }
    if ((this.b) && (this.jdField_a_of_type_Long > 0L) && (a()))
    {
      paramQQAlbumInfo = new QQAlbumInfo();
      paramQQAlbumInfo.id = "qzone_album";
      paramQQAlbumInfo.name = "空间相册";
      paramQQAlbumInfo.mMediaFileCount = ((int)this.jdField_a_of_type_Long);
      this.jdField_a_of_type_JavaUtilList.add(0, paramQQAlbumInfo);
      if (QLog.isColorLevel()) {
        QLog.d("AlbumListAdapter", 1, "addRecentAlbum");
      }
    }
    if (this.c)
    {
      paramQQAlbumInfo = new QQAlbumInfo();
      paramQQAlbumInfo.id = "$CustomAlbumId";
      localObject = SlideShowPhotoListManager.a().b();
      if (((List)localObject).size() > 0)
      {
        paramQQAlbumInfo.name = ((LocalMediaInfo)((List)localObject).get(0)).mAlbumName;
        paramQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)((List)localObject).get(0));
      }
      paramQQAlbumInfo.mMediaFileCount = ((List)localObject).size();
      this.jdField_a_of_type_JavaUtilList.add(0, paramQQAlbumInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.adapter.AENewAlbumListAdapter
 * JD-Core Version:    0.7.0.1
 */