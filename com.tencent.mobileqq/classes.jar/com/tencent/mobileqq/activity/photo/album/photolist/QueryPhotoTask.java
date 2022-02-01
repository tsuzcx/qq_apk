package com.tencent.mobileqq.activity.photo.album.photolist;

import android.os.AsyncTask;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class QueryPhotoTask
  extends AsyncTask<Object, Object, List<LocalMediaInfo>>
{
  private WeakReference<PhotoListCustomization> a;
  
  public QueryPhotoTask(PhotoListCustomization paramPhotoListCustomization)
  {
    this.a = new WeakReference(paramPhotoListCustomization);
  }
  
  protected List<LocalMediaInfo> a(Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAlbum", 2, "QueryPhotoTask,doInBackground");
    }
    PhotoListCustomization localPhotoListCustomization = (PhotoListCustomization)this.a.get();
    List localList = null;
    if (localPhotoListCustomization == null) {
      return null;
    }
    if (localPhotoListCustomization.g.L.compareAndSet(false, true))
    {
      localList = localPhotoListCustomization.a(paramVarArgs);
      localPhotoListCustomization.g.L.set(false);
    }
    return localList;
  }
  
  protected void a(List<LocalMediaInfo> paramList)
  {
    PhotoListCustomization localPhotoListCustomization = (PhotoListCustomization)this.a.get();
    if (localPhotoListCustomization == null) {
      return;
    }
    localPhotoListCustomization.a(paramList);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.photolist.QueryPhotoTask
 * JD-Core Version:    0.7.0.1
 */