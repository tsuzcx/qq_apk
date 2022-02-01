package com.tencent.mobileqq.activity.photo.album.albumlist;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;

public abstract class AlbumListCustomization<O extends OtherCommonData>
{
  public AbstractAlbumListFragment c;
  protected PhotoCommonBaseData<O> d;
  protected O e;
  protected AlbumListBaseData f;
  public AlbumListCustomization.IalbumListAdapterCallBack g = null;
  
  protected AlbumListCustomization(AbstractAlbumListFragment paramAbstractAlbumListFragment)
  {
    this.c = paramAbstractAlbumListFragment;
    this.d = PhotoCommonBaseData.getInstance(paramAbstractAlbumListFragment.getActivity().getIntent().getBooleanExtra("NEED_NEW_PHOTO_COMMON_DATA", true));
    this.e = this.d.bindCommonData(f());
    paramAbstractAlbumListFragment.getActivity().getIntent().putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    this.d.addHoldNember();
    this.f = new AlbumListBaseData();
    if (QLog.isColorLevel())
    {
      paramAbstractAlbumListFragment = new StringBuilder();
      paramAbstractAlbumListFragment.append("AlbumListCustomization new，activity = ");
      paramAbstractAlbumListFragment.append(this.c);
      paramAbstractAlbumListFragment.append(",PhotoCommonData = ");
      paramAbstractAlbumListFragment.append(this.d);
      QLog.d("QQAlbum", 2, paramAbstractAlbumListFragment.toString());
    }
  }
  
  public abstract void a(Intent paramIntent);
  
  public abstract boolean a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent);
  
  protected OtherCommonData f()
  {
    return new AlbumListCustomization.1(this);
  }
  
  public void g()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AlbumListCustomization close，activity = ");
      localStringBuilder.append(this.c);
      localStringBuilder.append(",PhotoCommonData = ");
      localStringBuilder.append(this.d);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    this.d.releaseCommonData();
  }
  
  public abstract void h();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomization
 * JD-Core Version:    0.7.0.1
 */