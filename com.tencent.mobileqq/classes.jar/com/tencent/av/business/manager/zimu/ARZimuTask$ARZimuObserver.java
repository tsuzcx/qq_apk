package com.tencent.av.business.manager.zimu;

import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

class ARZimuTask$ARZimuObserver
  implements Observer
{
  private WeakReference<ARZimuTask> a;
  
  public ARZimuTask$ARZimuObserver(ARZimuTask paramARZimuTask)
  {
    this.a = new WeakReference(paramARZimuTask);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    ARZimuTask localARZimuTask = (ARZimuTask)this.a.get();
    if (localARZimuTask == null) {
      return;
    }
    ARZimuTask.a(localARZimuTask, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.zimu.ARZimuTask.ARZimuObserver
 * JD-Core Version:    0.7.0.1
 */