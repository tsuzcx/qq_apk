package com.huawei.hms.api;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class a
{
  static final a a = new a();
  List<Activity> b = new ArrayList(1);
  
  void a(Activity paramActivity)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Activity localActivity = (Activity)localIterator.next();
      if ((localActivity != null) && (localActivity != paramActivity) && (!localActivity.isFinishing())) {
        localActivity.finish();
      }
    }
    this.b.add(paramActivity);
  }
  
  void b(Activity paramActivity)
  {
    this.b.remove(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.api.a
 * JD-Core Version:    0.7.0.1
 */