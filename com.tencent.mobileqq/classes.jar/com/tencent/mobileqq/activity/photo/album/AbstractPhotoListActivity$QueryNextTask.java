package com.tencent.mobileqq.activity.photo.album;

import android.os.AsyncTask;
import android.util.Pair;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.queryMedia.MediaQueryHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class AbstractPhotoListActivity$QueryNextTask
  extends AsyncTask<Object, Object, Pair<List<LocalMediaInfo>, Integer>>
{
  private WeakReference<PhotoListLogicBase> mLogicForQueryTask;
  
  public AbstractPhotoListActivity$QueryNextTask(PhotoListLogicBase paramPhotoListLogicBase)
  {
    this.mLogicForQueryTask = new WeakReference(paramPhotoListLogicBase);
  }
  
  protected Pair<List<LocalMediaInfo>, Integer> doInBackground(Object... paramVarArgs)
  {
    paramVarArgs = (PhotoListLogicBase)this.mLogicForQueryTask.get();
    if (paramVarArgs == null) {
      return null;
    }
    List localList = paramVarArgs.mPhotoCommonData.mMediaQueryHelper.mediaList;
    int i = localList.size();
    if (paramVarArgs.mPhotoListData.isQuerying.compareAndSet(false, true))
    {
      paramVarArgs.mPhotoCommonData.mMediaQueryHelper.queryNext();
      paramVarArgs.updateAddData(localList, i);
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListActivity", 2, "QueryPhotoTask,doInBackground,mediaList.size :" + localList.size());
      }
      paramVarArgs.mPhotoListData.isQuerying.set(false);
    }
    return new Pair(localList, Integer.valueOf(i));
  }
  
  protected void onPostExecute(Pair<List<LocalMediaInfo>, Integer> paramPair)
  {
    PhotoListLogic localPhotoListLogic = (PhotoListLogic)this.mLogicForQueryTask.get();
    if (localPhotoListLogic == null) {
      return;
    }
    localPhotoListLogic.mActivity.photoListAdapter.setPhotoList((List)paramPair.first);
    localPhotoListLogic.mActivity.photoListAdapter.notifyItemRangeInserted(((Integer)paramPair.second).intValue(), ((List)paramPair.first).size() - ((Integer)paramPair.second).intValue());
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.QueryNextTask
 * JD-Core Version:    0.7.0.1
 */