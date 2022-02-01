package com.tencent.mobileqq.app;

import android.os.HandlerThread;

class ThreadExcutor$4
  extends HandlerThread
{
  ThreadExcutor$4(ThreadExcutor paramThreadExcutor, String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  private void checkQQGlobalThread()
  {
    if (!ThreadSetting.isPublicVersion)
    {
      String str = getName();
      if ((!str.equals("QQ_FILE_RW")) && (!str.equals("QQ_SUB")) && (!str.equals("Recent_Handler"))) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" can't quit Global Thread ");
      throw new RuntimeException(localStringBuilder.toString());
    }
  }
  
  public boolean quit()
  {
    checkQQGlobalThread();
    return super.quit();
  }
  
  public boolean quitSafely()
  {
    checkQQGlobalThread();
    return super.quitSafely();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadExcutor.4
 * JD-Core Version:    0.7.0.1
 */