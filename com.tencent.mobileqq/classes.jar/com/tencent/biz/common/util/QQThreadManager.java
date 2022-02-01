package com.tencent.biz.common.util;

import com.tencent.biz.common.offline.util.IThreadManager;
import com.tencent.mobileqq.app.ThreadManager;

public class QQThreadManager
  implements IThreadManager
{
  public void a(Runnable paramRunnable)
  {
    ThreadManager.executeOnNetWorkThread(paramRunnable);
  }
  
  public void b(Runnable paramRunnable)
  {
    ThreadManager.executeOnFileThread(paramRunnable);
  }
  
  public void c(Runnable paramRunnable)
  {
    ThreadManager.post(paramRunnable, 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.common.util.QQThreadManager
 * JD-Core Version:    0.7.0.1
 */