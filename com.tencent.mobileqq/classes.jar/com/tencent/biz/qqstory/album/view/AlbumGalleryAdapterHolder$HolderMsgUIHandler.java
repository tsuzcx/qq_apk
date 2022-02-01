package com.tencent.biz.qqstory.album.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

class AlbumGalleryAdapterHolder$HolderMsgUIHandler
  extends Handler
{
  public AlbumGalleryAdapterHolder$HolderMsgUIHandler(AlbumGalleryAdapterHolder paramAlbumGalleryAdapterHolder, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      SLog.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "on receive msg play loop");
    } while ((AlbumGalleryAdapterHolder.a(this.a) != 1) || (AlbumGalleryAdapterHolder.a(this.a) == null));
    Object localObject = AlbumGalleryAdapterHolder.a(this.a);
    int i = AlbumGalleryAdapterHolder.a(this.a, (List)localObject, AlbumGalleryAdapterHolder.c(this.a));
    int j = AlbumGalleryAdapterHolder.a(this.a, (List)localObject, i + 1);
    if ((((List)localObject).size() <= 1) || (i == j) || (i < 0))
    {
      AlbumGalleryAdapterHolder.b(this.a);
      SLog.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "on receive msg play loop, pick count not enougth , dont play loop");
      return;
    }
    AlbumGalleryAdapterHolder.a(this.a, j);
    paramMessage = (StoryAlbum.PicInfo)((List)localObject).get(i);
    localObject = (StoryAlbum.PicInfo)((List)localObject).get(j);
    this.a.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setVisibility(0);
    this.a.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setLocalDrawable(paramMessage.a, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, AlbumGalleryAdapterHolder.a(this.a));
    this.a.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setLocalDrawable(((StoryAlbum.PicInfo)localObject).a, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, AlbumGalleryAdapterHolder.a(this.a));
    paramMessage = AnimationUtils.loadAnimation(AlbumGalleryAdapterHolder.a(this.a), 2130772255);
    paramMessage.setAnimationListener(new AlbumGalleryAdapterHolder.HolderMsgUIHandler.1(this));
    this.a.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.startAnimation(paramMessage);
    SLog.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "on receive msg play loop, start play loop , ani index = %d , rear index = %d", Integer.valueOf(i), Integer.valueOf(j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryAdapterHolder.HolderMsgUIHandler
 * JD-Core Version:    0.7.0.1
 */