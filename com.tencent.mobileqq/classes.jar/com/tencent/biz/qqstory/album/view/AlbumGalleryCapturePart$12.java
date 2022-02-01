package com.tencent.biz.qqstory.album.view;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.album.StoryScanManager;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import mqq.os.MqqHandler;

class AlbumGalleryCapturePart$12
  extends SimpleJob<Void>
{
  AlbumGalleryCapturePart$12(AlbumGalleryCapturePart paramAlbumGalleryCapturePart, StoryAlbum paramStoryAlbum) {}
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    boolean bool = this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.c();
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.c() < 2) {
      StoryScanManager.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum, 10);
    }
    ThreadManager.getUIHandler().post(new AlbumGalleryCapturePart.12.1(this, bool));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.12
 * JD-Core Version:    0.7.0.1
 */