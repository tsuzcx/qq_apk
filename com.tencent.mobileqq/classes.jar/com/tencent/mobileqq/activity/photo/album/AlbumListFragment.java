package com.tencent.mobileqq.activity.photo.album;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomization;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class AlbumListFragment
  extends AbstractAlbumListFragment
{
  protected AlbumListCustomization<? extends OtherCommonData> a()
  {
    int i = getActivity().getIntent().getIntExtra("enter_from", 0);
    AlbumListCustomization localAlbumListCustomization = ((IPhotoLogicFactory)QRoute.api(IPhotoLogicFactory.class)).createAlbumListLogic(this, getActivity().getIntent());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generateLogic:");
      localStringBuilder.append(localAlbumListCustomization.getClass().getName());
      localStringBuilder.append(" enterFrom:");
      localStringBuilder.append(i);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    return localAlbumListCustomization;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AlbumListFragment
 * JD-Core Version:    0.7.0.1
 */