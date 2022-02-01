package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;

class QQSettingMe$12
  implements Runnable
{
  QQSettingMe$12(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    Object localObject = (IRedTouchManager)this.this$0.a.getRuntimeService(IRedTouchManager.class, "");
    this.this$0.j = ((IRedTouchManager)localObject).getAppInfoByPath(String.valueOf(100460));
    if ((this.this$0.j != null) && (this.this$0.j.iNewFlag.has()) && (this.this$0.j.iNewFlag.get() == 1)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = QQSettingMe.b(this.this$0);
      if (QLog.isColorLevel()) {
        QLog.i("QQSettingRedesign", 2, String.format("updateHeadIconNewView needShow=%b newNeedShow=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      if (QQSettingMe.c(this.this$0) != (bool1 | bool2))
      {
        localObject = this.this$0.b.obtainMessage(1);
        this.this$0.b.sendMessage((Message)localObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.12
 * JD-Core Version:    0.7.0.1
 */