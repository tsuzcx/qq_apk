package com.tencent.mobileqq.activity.photo.album;

import android.os.AsyncTask;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public class AbstractPhotoListActivity$QueryPhotoTask
  extends AsyncTask<Object, Object, List<LocalMediaInfo>>
{
  private WeakReference<PhotoListLogicBase> mLogicForQueryTask;
  
  public AbstractPhotoListActivity$QueryPhotoTask(AbstractPhotoListActivity paramAbstractPhotoListActivity) {}
  
  protected List<LocalMediaInfo> doInBackground(Object... paramVarArgs)
  {
    paramVarArgs = (PhotoListLogicBase)this.mLogicForQueryTask.get();
    if (paramVarArgs == null) {
      paramVarArgs = null;
    }
    List localList;
    do
    {
      return paramVarArgs;
      localList = paramVarArgs.queryPhotoList();
      paramVarArgs = localList;
    } while (!QLog.isColorLevel());
    QLog.d("PhotoListActivity", 2, "QueryPhotoTask,doInBackground,mediaList.size :" + localList.size());
    return localList;
  }
  
  protected void onPostExecute(List<LocalMediaInfo> paramList)
  {
    PhotoListLogic localPhotoListLogic = (PhotoListLogic)this.mLogicForQueryTask.get();
    if (localPhotoListLogic == null) {
      return;
    }
    localPhotoListLogic.onQueryPhoto(paramList);
    this.this$0.cancleProgressDailog();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.mLogicForQueryTask = new WeakReference(this.this$0.mPhotoListLogic);
    this.this$0.showProgressDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.QueryPhotoTask
 * JD-Core Version:    0.7.0.1
 */