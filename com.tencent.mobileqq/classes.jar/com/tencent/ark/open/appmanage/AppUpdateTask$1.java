package com.tencent.ark.open.appmanage;

import java.util.ArrayList;
import java.util.Iterator;

class AppUpdateTask$1
  implements Runnable
{
  AppUpdateTask$1(AppUpdateTask paramAppUpdateTask, ArrayList paramArrayList, AppUpdateTask.IUpdateAppByNameCallback paramIUpdateAppByNameCallback) {}
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator = this.val$appList.iterator();
    while (localIterator.hasNext())
    {
      ??? = (AppUpdateTask.UpdateApp)localIterator.next();
      if (!AppUpdateTask.access$000(this.this$0, ((AppUpdateTask.UpdateApp)???).appName, this.val$cb))
      {
        AppUpdateTask.UpdateTask localUpdateTask = AppUpdateTask.access$100(this.this$0, (AppUpdateTask.UpdateApp)???, this.val$cb);
        synchronized (AppUpdateTask.access$200(this.this$0))
        {
          AppUpdateTask.access$200(this.this$0).add(localUpdateTask);
          localArrayList1.add(localUpdateTask);
        }
      }
    }
    this.this$0.queryAppInfo(localArrayList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.appmanage.AppUpdateTask.1
 * JD-Core Version:    0.7.0.1
 */