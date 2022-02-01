package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class ServiceAccountFolderActivity$3$1
  implements Runnable
{
  ServiceAccountFolderActivity$3$1(ServiceAccountFolderActivity.3 param3, int paramInt) {}
  
  public void run()
  {
    int i = this.a;
    if (i <= 0)
    {
      this.b.a.setVisibility(8);
    }
    else if (i > 99)
    {
      this.b.a.setText("99+");
      this.b.a.setVisibility(0);
    }
    else
    {
      this.b.a.setText(String.valueOf(this.a));
      this.b.a.setVisibility(0);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateUnreadNumOnTitleBar->unread num:");
      localStringBuilder.append(this.a);
      QLog.d("ServiceAccountFolderActivity", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity.3.1
 * JD-Core Version:    0.7.0.1
 */