package com.tencent.mobileqq.activity.photo.album.albumlist;

import android.os.MessageQueue.IdleHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

class AbstractAlbumListFragment$2
  implements MessageQueue.IdleHandler
{
  AbstractAlbumListFragment$2(AbstractAlbumListFragment paramAbstractAlbumListFragment, int paramInt1, int paramInt2) {}
  
  public boolean queueIdle()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load Scroll Position,index:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" top:");
      localStringBuilder.append(this.b);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAbstractAlbumListFragment.a.setSelectionFromTop(this.jdField_a_of_type_Int, this.b);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment.2
 * JD-Core Version:    0.7.0.1
 */