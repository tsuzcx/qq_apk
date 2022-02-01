package com.tencent.mobileqq.activity.aio.doodle;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

class LoadDataJob$2
  implements LoadDataJob.UnmarshallJobListener
{
  LoadDataJob$2(LoadDataJob paramLoadDataJob, Map paramMap, List paramList) {}
  
  public void a(int paramInt, PathDrawer paramPathDrawer)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("unmarshall task finish id:");
      ((StringBuilder)???).append(paramInt);
      QLog.d("LoadDataJob", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.a)
    {
      this.a.remove(Integer.valueOf(paramInt));
      this.a.notifyAll();
      synchronized (this.b)
      {
        this.b.add(paramPathDrawer);
        if (this.b.size() == LoadDataJob.a(this.c)) {
          this.b.notifyAll();
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LoadDataJob.2
 * JD-Core Version:    0.7.0.1
 */