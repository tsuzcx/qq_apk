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
    List localList = paramVarArgs.e.mMediaQueryHelper.mediaList;
    int i = localList.size();
    if (paramVarArgs.g.L.compareAndSet(false, true))
    {
      paramVarArgs.e.mMediaQueryHelper.queryNext();
      paramVarArgs.a(localList, i);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QueryPhotoTask,doInBackground,mediaList.size :");
        localStringBuilder.append(localList.size());
        QLog.d("QQAlbum", 2, localStringBuilder.toString());
      }
      paramVarArgs.g.L.set(false);
    }
    return new Pair(localList, Integer.valueOf(i));
  }
  
  protected void a(Pair<List<LocalMediaInfo>, Integer> paramPair)
  {
    PhotoListCustomization localPhotoListCustomization = (PhotoListCustomization)this.a.get();
    if (localPhotoListCustomization == null) {
      return;
    }
    localPhotoListCustomization.h.t.a((List)paramPair.first);
    localPhotoListCustomization.h.t.notifyItemRangeInserted(((Integer)paramPair.second).intValue(), ((List)paramPair.first).size() - ((Integer)paramPair.second).intValue());
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.photolist.QueryNextTask
 * JD-Core Version:    0.7.0.1
 */