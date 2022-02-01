package com.tencent.biz.qqstory.model;

import android.os.Handler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class TrimmableManager
  implements IManager
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private CopyOnWriteArraySet<ITrimmable> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  
  public TrimmableManager()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(new TrimmableManager.URLDrawableTrimmer());
  }
  
  private void b(int paramInt)
  {
    SLog.d("TrimmableManager", "trimMemory : level = %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((ITrimmable)localIterator.next()).a(paramInt);
    }
    System.gc();
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new TrimmableManager.1(this, paramInt));
  }
  
  public void a(ITrimmable paramITrimmable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramITrimmable);
  }
  
  public void b() {}
  
  public void b(ITrimmable paramITrimmable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramITrimmable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TrimmableManager
 * JD-Core Version:    0.7.0.1
 */