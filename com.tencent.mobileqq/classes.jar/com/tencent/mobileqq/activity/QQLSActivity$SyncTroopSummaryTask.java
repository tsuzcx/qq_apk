package com.tencent.mobileqq.activity;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArraySet;

public class QQLSActivity$SyncTroopSummaryTask
  implements Runnable
{
  WeakReference<AppInterface> a;
  WeakReferenceHandler b;
  String c;
  String d;
  
  public QQLSActivity$SyncTroopSummaryTask(AppInterface paramAppInterface, WeakReferenceHandler paramWeakReferenceHandler, String paramString1, String paramString2)
  {
    this.a = new WeakReference(paramAppInterface);
    this.b = paramWeakReferenceHandler;
    this.c = paramString1;
    this.d = paramString2;
  }
  
  public void run()
  {
    AppInterface localAppInterface = (AppInterface)this.a.get();
    String str = this.d.concat(this.c);
    if ((localAppInterface != null) && (this.b != null) && (!QQLSActivity.m().contains(str)))
    {
      QQLSActivity.m().add(str);
      ContactUtils.b(localAppInterface, this.d, this.c);
      this.b.sendEmptyMessage(17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.SyncTroopSummaryTask
 * JD-Core Version:    0.7.0.1
 */