package com.tencent.mobileqq.activity.aio.qim;

import com.tencent.qphone.base.util.QLog;

class QIMUserManager$2
  implements Runnable
{
  QIMUserManager$2(QIMUserManager paramQIMUserManager, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    if (QIMUserManager.a(this.this$0, this.a, this.b) == 0)
    {
      if (QIMUserManager.a(this.this$0, this.b))
      {
        QIMUserManager.a(this.this$0);
        QIMUserManager.a(this.this$0, 2);
      }
      else
      {
        QIMUserManager.a(this.this$0, 4);
      }
    }
    else {
      QIMUserManager.a(this.this$0, 3);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append(" startDownLoadQimTheme QimIconsState ");
      localStringBuilder.append(QIMUserManager.c(this.this$0));
      QLog.i("QIMUserManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qim.QIMUserManager.2
 * JD-Core Version:    0.7.0.1
 */