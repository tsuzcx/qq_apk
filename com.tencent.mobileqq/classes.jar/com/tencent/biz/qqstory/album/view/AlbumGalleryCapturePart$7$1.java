package com.tencent.biz.qqstory.album.view;

import android.os.Handler;
import com.tencent.biz.qqstory.album.StoryScanManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

class AlbumGalleryCapturePart$7$1
  implements Runnable
{
  AlbumGalleryCapturePart$7$1(AlbumGalleryCapturePart.7 param7, List paramList, StoryScanManager paramStoryScanManager) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      AlbumGalleryCapturePart.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$7.a).a(this.jdField_a_of_type_JavaUtilList);
      if ((AlbumGalleryCapturePart.c(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$7.a) != -1) || (AlbumGalleryCapturePart.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$7.a) != -1L)) {
        AlbumGalleryCapturePart.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$7.a).sendEmptyMessage(1004);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager.c();
      SLog.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data from db , size = %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      return;
    }
    AlbumGalleryCapturePart.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$7.a).a();
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager.c();
    if (AlbumGalleryCapturePart.c(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$7.a) != -1) {
      AlbumGalleryCapturePart.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$7.a).sendEmptyMessage(1004);
    }
    AlbumGalleryCapturePart.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$7.a).sendEmptyMessageDelayed(1005, 180000L);
    SLog.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data, db no data , scan now");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.7.1
 * JD-Core Version:    0.7.0.1
 */