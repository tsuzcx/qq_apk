package com.tencent.aelight.camera.ae.album.logic;

import com.tencent.aelight.camera.ae.album.adapter.AEAlbumListAdapter;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractAlbumListFragment;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class AEAlbumListLogicBase$3
  implements Runnable
{
  AEAlbumListLogicBase$3(AEAlbumListLogicBase paramAEAlbumListLogicBase, AEAlbumListAdapter paramAEAlbumListAdapter, MediaFileFilter paramMediaFileFilter) {}
  
  public void run()
  {
    LogTag.a();
    Object localObject = this.a.b(((AEAbstractAlbumListFragment)this.this$0.a.get()).getActivity(), 2147483647, -1, this.b, -1, false, null);
    this.a.c((QQAlbumInfo)localObject);
    LogTag.a("PEAK", "queryRecentBucket");
    LogTag.a();
    localObject = this.b;
    if ((localObject != null) && (((MediaFileFilter)localObject).showVideo()))
    {
      localObject = this.a.a(((AEAbstractAlbumListFragment)this.this$0.a.get()).getActivity());
      this.a.e((QQAlbumInfo)localObject);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryAlbumList() run postVideoAlbum()， videoAlbumInfo.count=");
        localStringBuilder.append(((QQAlbumInfo)localObject).mMediaFileCount);
        QLog.d("QQAlbum", 2, localStringBuilder.toString());
      }
    }
    LogTag.a("PEAK", "queryVideoBucket");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogicBase.3
 * JD-Core Version:    0.7.0.1
 */