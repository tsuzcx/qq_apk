package com.tencent.biz.qqstory.album.view;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.album.StoryScanManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import mqq.os.MqqHandler;

class AlbumGalleryCapturePart$7
  extends SimpleJob<Void>
{
  AlbumGalleryCapturePart$7(AlbumGalleryCapturePart paramAlbumGalleryCapturePart) {}
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = (StoryScanManager)SuperManager.a(30);
    paramVarArgs = paramJobContext.b();
    ThreadManager.getUIHandler().post(new AlbumGalleryCapturePart.7.1(this, paramVarArgs, paramJobContext));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.7
 * JD-Core Version:    0.7.0.1
 */