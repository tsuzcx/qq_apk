package com.tencent.biz.qqstory.support.logging;

import com.tencent.qphone.base.util.QLog;

public class QQStoryLoggingDelegate
  implements LoggingDelegate
{
  public static final QQStoryLoggingDelegate a = new QQStoryLoggingDelegate();
  public String b = null;
  public int c = 3;
  private int d = -1;
  
  public static QQStoryLoggingDelegate a()
  {
    return a;
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
    case 7: 
      QLog.e(paramString1, 1, paramString2);
      return;
    case 5: 
      QLog.e(paramString1, 1, paramString2);
      return;
    case 4: 
      QLog.i(paramString1, 2, paramString2);
      return;
    case 3: 
      QLog.d(paramString1, 2, paramString2);
      return;
    }
    QLog.d(paramString1, 2, paramString2);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
    case 7: 
      QLog.e(paramString1, 1, paramString2, paramThrowable);
      return;
    case 5: 
      QLog.e(paramString1, 1, paramString2, paramThrowable);
      return;
    case 4: 
      QLog.i(paramString1, 2, paramString2, paramThrowable);
      return;
    case 3: 
      QLog.d(paramString1, 2, paramString2, paramThrowable);
      return;
    }
    QLog.d(paramString1, 2, paramString2, paramThrowable);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(2, paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(3, paramString1, paramString2, paramThrowable);
  }
  
  public boolean a(int paramInt)
  {
    int i = this.d;
    if ((i != -1) && (paramInt >= i)) {
      return true;
    }
    if (5 <= paramInt) {
      return true;
    }
    if (!QLog.isColorLevel()) {
      return false;
    }
    return this.c <= paramInt;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(String paramString1, String paramString2)
  {
    a(3, paramString1, paramString2);
  }
  
  public void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(5, paramString1, paramString2, paramThrowable);
  }
  
  public void c(String paramString1, String paramString2)
  {
    a(4, paramString1, paramString2);
  }
  
  public void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(6, paramString1, paramString2, paramThrowable);
  }
  
  public void d(String paramString1, String paramString2)
  {
    a(5, paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2)
  {
    a(6, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.support.logging.QQStoryLoggingDelegate
 * JD-Core Version:    0.7.0.1
 */