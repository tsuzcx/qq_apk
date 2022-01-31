package com.tencent.mobileqq.activity.photo.album;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.data.QQAlbumInfo;
import java.util.ArrayList;
import java.util.List;

public abstract interface AlbumListLogic$IalbumListAdapterCallBack
{
  public abstract String adapterGenerateSelection();
  
  public abstract List<QQAlbumInfo> compact(List<QQAlbumInfo> paramList1, List<QQAlbumInfo> paramList2, int paramInt);
  
  public abstract View getView(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public abstract void queryAlbumList(int paramInt);
  
  public abstract List<LocalMediaInfo> queryRecentImageList(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AlbumListLogic.IalbumListAdapterCallBack
 * JD-Core Version:    0.7.0.1
 */