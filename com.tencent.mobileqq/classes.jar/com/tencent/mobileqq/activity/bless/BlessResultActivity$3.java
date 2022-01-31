package com.tencent.mobileqq.activity.bless;

import android.os.Message;
import bdhb;
import bdhj;
import bhsl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class BlessResultActivity$3
  implements Runnable
{
  BlessResultActivity$3(BlessResultActivity paramBlessResultActivity, String paramString) {}
  
  public void run()
  {
    try
    {
      long l = bdhb.a(this.a);
      if (l < 25600L)
      {
        localObject = this.this$0.a.obtainMessage(1004);
        this.this$0.a.sendMessage((Message)localObject);
        return;
      }
      Object localObject = BlessResultActivity.a(this.a);
      bdhj.a(BaseApplication.getContext(), this.a, (String)localObject, 160, 160);
      if (QLog.isColorLevel()) {
        QLog.d("BlessResultActivity", 2, "share ptv to FC. srcLen:" + l + " ,objLen:" + bdhb.a((String)localObject) + " , thumbPath:" + (String)localObject);
      }
      Message localMessage = this.this$0.a.obtainMessage(1004);
      localMessage.obj = localObject;
      this.this$0.a.sendMessage(localMessage);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessResultActivity.3
 * JD-Core Version:    0.7.0.1
 */