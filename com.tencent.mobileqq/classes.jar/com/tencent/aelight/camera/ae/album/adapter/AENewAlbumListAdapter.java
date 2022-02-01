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
  public boolean o;
  public long p;
  boolean q;
  
  public AENewAlbumListAdapter(AEAlbumListFragment paramAEAlbumListFragment)
  {
    super(paramAEAlbumListFragment);
  }
  
  protected void b(QQAlbumInfo paramQQAlbumInfo)
  {
    Object localObject;
    if (!this.g.isEmpty())
    {
      localObject = (QQAlbumInfo)this.g.get(0);
      if (!((QQAlbumInfo)localObject).id.equals("$RecentAlbumId")) {
        if (((QQAlbumInfo)localObject).id.equals("qzone_album")) {
          this.g.add(1, paramQQAlbumInfo);
        } else {
          this.g.add(0, paramQQAlbumInfo);
        }
      }
    }
    if ((this.o) && (this.p > 0L) && (b()))
    {
      paramQQAlbumInfo = new QQAlbumInfo();
      paramQQAlbumInfo.id = "qzone_album";
      paramQQAlbumInfo.name = "空间相册";
      paramQQAlbumInfo.mMediaFileCount = ((int)this.p);
      this.g.add(0, paramQQAlbumInfo);
      if (QLog.isColorLevel()) {
        QLog.d("AlbumListAdapter", 1, "addRecentAlbum");
      }
    }
    if (this.q)
    {
      paramQQAlbumInfo = new QQAlbumInfo();
      paramQQAlbumInfo.id = "$CustomAlbumId";
      localObject = SlideShowPhotoListManager.a().g();
      if (((List)localObject).size() > 0)
      {
        paramQQAlbumInfo.name = ((LocalMediaInfo)((List)localObject).get(0)).mAlbumName;
        paramQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)((List)localObject).get(0));
      }
      paramQQAlbumInfo.mMediaFileCount = ((List)localObject).size();
      this.g.add(0, paramQQAlbumInfo);
    }
  }
  
  boolean b()
  {
    if (this.g.size() != 0)
    {
      int i = 0;
      while (i < this.g.size())
      {
        if (((QQAlbumInfo)this.g.get(i)).id.equals("qzone_album")) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.adapter.AENewAlbumListAdapter
 * JD-Core Version:    0.7.0.1
 */