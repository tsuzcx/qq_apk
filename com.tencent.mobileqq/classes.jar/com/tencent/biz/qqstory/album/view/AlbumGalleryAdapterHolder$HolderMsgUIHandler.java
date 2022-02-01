package com.tencent.biz.qqstory.album.view;

import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

class AlbumGalleryAdapterHolder$HolderMsgUIHandler
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    SLog.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "on receive msg play loop");
    if (AlbumGalleryAdapterHolder.a(this.a) == 1)
    {
      if (AlbumGalleryAdapterHolder.a(this.a) == null) {
        return;
      }
      paramMessage = AlbumGalleryAdapterHolder.a(this.a);
      Object localObject = this.a;
      int i = AlbumGalleryAdapterHolder.a((AlbumGalleryAdapterHolder)localObject, paramMessage, AlbumGalleryAdapterHolder.c((AlbumGalleryAdapterHolder)localObject));
      int j = AlbumGalleryAdapterHolder.a(this.a, paramMessage, i + 1);
      if ((paramMessage.size() > 1) && (i != j) && (i >= 0))
      {
        AlbumGalleryAdapterHolder.a(this.a, j);
        localObject = (StoryAlbum.PicInfo)paramMessage.get(i);
        paramMessage = (StoryAlbum.PicInfo)paramMessage.get(j);
        this.a.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setVisibility(0);
        this.a.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setLocalDrawable(((StoryAlbum.PicInfo)localObject).a, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, AlbumGalleryAdapterHolder.a(this.a));
        this.a.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setLocalDrawable(paramMessage.a, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, AlbumGalleryAdapterHolder.a(this.a));
        paramMessage = AnimationUtils.loadAnimation(AlbumGalleryAdapterHolder.a(this.a), 2130772283);
        paramMessage.setAnimationListener(new AlbumGalleryAdapterHolder.HolderMsgUIHandler.1(this));
        this.a.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.startAnimation(paramMessage);
        SLog.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "on receive msg play loop, start play loop , ani index = %d , rear index = %d", Integer.valueOf(i), Integer.valueOf(j));
        return;
      }
      AlbumGalleryAdapterHolder.b(this.a);
      SLog.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "on receive msg play loop, pick count not enougth , dont play loop");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryAdapterHolder.HolderMsgUIHandler
 * JD-Core Version:    0.7.0.1
 */