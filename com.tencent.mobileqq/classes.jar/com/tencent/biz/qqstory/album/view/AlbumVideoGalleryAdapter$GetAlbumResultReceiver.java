package com.tencent.biz.qqstory.album.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.album.StoryScanManager.ScanResultEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class AlbumVideoGalleryAdapter$GetAlbumResultReceiver
  extends QQUIEventReceiver<AlbumVideoGalleryAdapter, StoryScanManager.ScanResultEvent>
{
  public void a(@NonNull AlbumVideoGalleryAdapter paramAlbumVideoGalleryAdapter, @NonNull StoryScanManager.ScanResultEvent paramScanResultEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramScanResultEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      SLog.a("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "on receiver scan data ,error! code = %d", Integer.valueOf(paramScanResultEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode));
      paramAlbumVideoGalleryAdapter.c();
      bool1 = bool2;
    }
    for (;;)
    {
      AlbumVideoGalleryAdapter.a(paramAlbumVideoGalleryAdapter).a(bool1);
      return;
      SLog.a("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "on receiver scan data ,size = %d", Integer.valueOf(paramScanResultEvent.jdField_a_of_type_JavaUtilList.size()));
      bool1 = bool2;
      if (paramAlbumVideoGalleryAdapter.a(paramScanResultEvent.jdField_a_of_type_JavaUtilList))
      {
        bool1 = bool2;
        if (paramScanResultEvent.jdField_a_of_type_JavaUtilList.size() > 0) {
          bool1 = true;
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return StoryScanManager.ScanResultEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumVideoGalleryAdapter.GetAlbumResultReceiver
 * JD-Core Version:    0.7.0.1
 */