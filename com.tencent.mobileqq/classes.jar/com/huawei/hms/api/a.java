package com.huawei.hms.api;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class a
{
  static final a b = new a();
  List<Activity> a = new ArrayList(1);
  
  void a(Activity paramActivity)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Activity localActivity = (Activity)localIterator.next();
      if ((localActivity != null) && (localActivity != paramActivity) && (!localActivity.isFinishing())) {
        localActivity.finish();
      }
    }
    this.a.add(paramActivity);
  }
  
  void b(Activity paramActivity)
  {
    this.a.remove(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.api.a
 * JD-Core Version:    0.7.0.1
 */