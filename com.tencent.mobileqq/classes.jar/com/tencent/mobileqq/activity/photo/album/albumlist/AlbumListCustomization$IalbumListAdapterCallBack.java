package com.tencent.mobileqq.activity.photo.album.albumlist;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.data.QQAlbumInfo;
import java.util.List;

public abstract interface AlbumListCustomization$IalbumListAdapterCallBack
{
  public abstract View a(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public abstract List<QQAlbumInfo> a(List<QQAlbumInfo> paramList1, List<QQAlbumInfo> paramList2, int paramInt);
  
  public abstract void a(int paramInt);
  
  public abstract String b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomization.IalbumListAdapterCallBack
 * JD-Core Version:    0.7.0.1
 */