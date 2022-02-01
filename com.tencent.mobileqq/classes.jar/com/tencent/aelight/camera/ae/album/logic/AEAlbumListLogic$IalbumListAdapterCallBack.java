package com.tencent.aelight.camera.ae.album.logic;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.data.QQAlbumInfo;
import java.util.ArrayList;
import java.util.List;

public abstract interface AEAlbumListLogic$IalbumListAdapterCallBack
{
  public abstract View a(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public abstract String a();
  
  public abstract List<LocalMediaInfo> a(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList);
  
  public abstract List<QQAlbumInfo> a(List<QQAlbumInfo> paramList1, List<QQAlbumInfo> paramList2, int paramInt);
  
  public abstract void a(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogic.IalbumListAdapterCallBack
 * JD-Core Version:    0.7.0.1
 */