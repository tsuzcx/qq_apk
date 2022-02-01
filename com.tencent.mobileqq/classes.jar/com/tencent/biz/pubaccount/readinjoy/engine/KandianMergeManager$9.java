package com.tencent.biz.pubaccount.readinjoy.engine;

import android.os.Parcel;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinListener;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager;

class KandianMergeManager$9
  implements AladdinListener
{
  KandianMergeManager$9(KandianMergeManager paramKandianMergeManager) {}
  
  public void a()
  {
    if (TaskManager.getConfigOn())
    {
      TaskManager.getInstance().startAllTasks();
      return;
    }
    TaskManager.getInstance().stopAllTasks();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.9
 * JD-Core Version:    0.7.0.1
 */