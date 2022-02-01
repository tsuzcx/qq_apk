package com.tencent.mobileqq.activity.photo.album.photolist;

import android.os.AsyncTask;
import android.util.Pair;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class QueryNextTask
  extends AsyncTask<Object, Object, Pair<List<LocalMediaInfo>, Integer>>
{
  private WeakReference<PhotoListCustomization> a;
  
  public QueryNextTask(PhotoListCustomization paramPhotoListCustomization)
  {
    this.a = new WeakReference(paramPhotoListCustomization);
  }
  
  protected Pair<List<LocalMediaInfo>, Integer> a(Object... paramVarArgs)
  {
    paramVarArgs = (PhotoListCustomization)this.a.get();
    if (paramVarArgs == null) {
      return null;
    }
    List localList = paramVarArgs.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mMediaQueryHelper.mediaList;
    int i = localList.size();
    if (paramVarArgs.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.a.compareAndSet(false, true))
    {
      paramVarArgs.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mMediaQueryHelper.queryNext();
      paramVarArgs.a(localList, i);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QueryPhotoTask,doInBackground,mediaList.size :");
        localStringBuilder.append(localList.size());
        QLog.d("QQAlbum", 2, localStringBuilder.toString());
      }
      paramVarArgs.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.a.set(false);
    }
    return new Pair(localList, Integer.valueOf(i));
  }
  
  protected void a(Pair<List<LocalMediaInfo>, Integer> paramPair)
  {
    PhotoListCustomization localPhotoListCustomization = (PhotoListCustomization)this.a.get();
    if (localPhotoListCustomization == null) {
      return;
    }
    localPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a.a((List)paramPair.first);
    localPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a.notifyItemRangeInserted(((Integer)paramPair.second).intValue(), ((List)paramPair.first).size() - ((Integer)paramPair.second).intValue());
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.photolist.QueryNextTask
 * JD-Core Version:    0.7.0.1
 */