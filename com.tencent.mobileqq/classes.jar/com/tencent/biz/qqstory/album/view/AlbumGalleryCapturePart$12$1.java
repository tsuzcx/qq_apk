package com.tencent.biz.qqstory.album.view;

import com.tencent.biz.qqstory.album.StoryScanManager;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideProgressNotifier;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class AlbumGalleryCapturePart$12$1
  implements Runnable
{
  AlbumGalleryCapturePart$12$1(AlbumGalleryCapturePart.12 param12, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "album file not enough , delete album now , left pic size = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$12.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.b()) });
      AlbumGalleryCapturePart.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$12.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart).c(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$12.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum);
      QQToast.a(AlbumGalleryCapturePart.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$12.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart), 1, HardCodeUtil.a(2131700251), 0).a();
      AlbumGalleryCapturePart.c(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$12.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart, false);
      AlbumGalleryCapturePart.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$12.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart, -1L);
      return;
    }
    SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "album select , goto slide show now , album id = %d", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$12.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.a()) });
    SlideShowPhotoListManager.a().c(21);
    SlideShowPhotoListManager.a().b(13);
    SlideShowPhotoListManager.a().a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$12.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum);
    AlbumGalleryCapturePart.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$12.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart).a(0, 10000, 99, 0);
    SlideShowPhotoListManager.a().a(AlbumGalleryCapturePart.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$12.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart), new AlbumGalleryCapturePart.12.1.1(this), 1);
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$12.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.a(1);
    ((StoryScanManager)SuperManager.a(30)).a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$12.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum);
    AlbumGalleryCapturePart.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$12.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.12.1
 * JD-Core Version:    0.7.0.1
 */