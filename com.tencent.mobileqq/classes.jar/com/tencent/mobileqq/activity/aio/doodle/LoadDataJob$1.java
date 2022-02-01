package com.tencent.mobileqq.activity.aio.doodle;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class LoadDataJob$1
  implements Runnable
{
  LoadDataJob$1(LoadDataJob paramLoadDataJob, DoodleParam paramDoodleParam, List paramList) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadDataJob", 2, "run write parcel begin:");
    }
    Object localObject = this.this$0;
    ((LoadDataJob)localObject).a(this.a, LoadDataJob.a((LoadDataJob)localObject, ((LoadDataJob)localObject).a, false));
    localObject = this.this$0;
    if (((LoadDataJob)localObject).a(this.b, LoadDataJob.b((LoadDataJob)localObject, ((LoadDataJob)localObject).a, false)))
    {
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((PathDrawer)((Iterator)localObject).next()).e();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoadDataJob", 2, "run write parcel end:");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LoadDataJob.1
 * JD-Core Version:    0.7.0.1
 */