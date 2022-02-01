package com.tencent.biz.qqstory.model;

import android.os.Handler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class TrimmableManager
  implements IManager
{
  private CopyOnWriteArraySet<ITrimmable> a = new CopyOnWriteArraySet();
  private Handler b = new Handler(ThreadManager.getSubThreadLooper());
  
  public TrimmableManager()
  {
    this.a.add(new TrimmableManager.URLDrawableTrimmer());
  }
  
  private void b(int paramInt)
  {
    SLog.d("TrimmableManager", "trimMemory : level = %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2)) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((ITrimmable)localIterator.next()).a(paramInt);
    }
    System.gc();
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.b.post(new TrimmableManager.1(this, paramInt));
  }
  
  public void a(ITrimmable paramITrimmable)
  {
    this.a.add(paramITrimmable);
  }
  
  public void b() {}
  
  public void b(ITrimmable paramITrimmable)
  {
    this.a.remove(paramITrimmable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TrimmableManager
 * JD-Core Version:    0.7.0.1
 */