package com.tencent.aelight.camera.ae.biz.circle;

import com.tencent.aelight.camera.ae.biz.circle.adapter.AlbumListAdapter;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class AECircleAlbumListLogic$3
  implements Runnable
{
  AECircleAlbumListLogic$3(AECircleAlbumListLogic paramAECircleAlbumListLogic, AlbumListAdapter paramAlbumListAdapter, MediaFileFilter paramMediaFileFilter) {}
  
  public void run()
  {
    LogTag.a();
    Object localObject = AlbumListAdapter.b(((AECircleAlbumListFragment)this.this$0.a.get()).getActivity());
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterAlbumListAdapter.c((QQAlbumInfo)localObject);
    LogTag.a("PEAK", "queryRecentBucket");
    LogTag.a();
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter;
    if ((localObject != null) && (((MediaFileFilter)localObject).showVideo()))
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterAlbumListAdapter.a(((AECircleAlbumListFragment)this.this$0.a.get()).getActivity());
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterAlbumListAdapter.e((QQAlbumInfo)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECircleAlbumListLogic.3
 * JD-Core Version:    0.7.0.1
 */