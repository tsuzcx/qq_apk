package com.tencent.biz.qqstory.album.view;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.qq.im.capture.view.CustomLinearSnapHelper;

class AlbumGalleryCapturePart$10
  extends RecyclerView.OnScrollListener
{
  private long jdField_a_of_type_Long;
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((paramInt == 1) && (AlbumGalleryCapturePart.b(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart)))
    {
      SLog.b("FredguoFix", "set needAnimated to false, break animation");
      AlbumGalleryCapturePart.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart).a(AlbumGalleryCapturePart.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart));
      AlbumGalleryCapturePart.b(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart, false);
      AlbumGalleryCapturePart.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart, false);
    }
    if (paramInt == 0)
    {
      AlbumGalleryCapturePart.d(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart, false);
      this.jdField_a_of_type_Long = 0L;
      if (AlbumGalleryCapturePart.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart).a(paramRecyclerView.getLayoutManager()) == null) {
        return;
      }
      if (AlbumGalleryCapturePart.c(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart))
      {
        SLog.b("FredguoFix", "animated to false, play animation done");
        AlbumGalleryCapturePart.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart, false);
        AlbumGalleryCapturePart.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart).a(AlbumGalleryCapturePart.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart));
      }
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart.a();
      return;
    }
    AlbumGalleryCapturePart.d(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart, true);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_a_of_type_Long) >= 20L)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.10
 * JD-Core Version:    0.7.0.1
 */