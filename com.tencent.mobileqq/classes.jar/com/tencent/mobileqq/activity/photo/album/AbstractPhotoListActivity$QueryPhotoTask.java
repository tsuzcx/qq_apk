package com.tencent.mobileqq.activity.photo.album;

import android.os.AsyncTask;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class AbstractPhotoListActivity$QueryPhotoTask
  extends AsyncTask<Object, Object, List<LocalMediaInfo>>
{
  private WeakReference<PhotoListLogicBase> mLogicForQueryTask;
  
  public AbstractPhotoListActivity$QueryPhotoTask(PhotoListLogicBase paramPhotoListLogicBase)
  {
    this.mLogicForQueryTask = new WeakReference(paramPhotoListLogicBase);
  }
  
  protected List<LocalMediaInfo> doInBackground(Object... paramVarArgs)
  {
    PhotoListLogicBase localPhotoListLogicBase = (PhotoListLogicBase)this.mLogicForQueryTask.get();
    if (localPhotoListLogicBase == null) {
      return null;
    }
    if (localPhotoListLogicBase.mPhotoListData.isQuerying.compareAndSet(false, true))
    {
      paramVarArgs = localPhotoListLogicBase.queryDoInBackground(paramVarArgs);
      localPhotoListLogicBase.mPhotoListData.isQuerying.set(false);
    }
    for (;;)
    {
      return paramVarArgs;
      paramVarArgs = null;
    }
  }
  
  protected void onPostExecute(List<LocalMediaInfo> paramList)
  {
    PhotoListLogic localPhotoListLogic = (PhotoListLogic)this.mLogicForQueryTask.get();
    if (localPhotoListLogic == null) {
      return;
    }
    localPhotoListLogic.onQueryPhoto(paramList);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.QueryPhotoTask
 * JD-Core Version:    0.7.0.1
 */