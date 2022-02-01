package com.tencent.mobileqq.activity.bless;

import android.os.Message;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;

class BlessResultActivity$1
  implements Runnable
{
  BlessResultActivity$1(BlessResultActivity paramBlessResultActivity, String paramString) {}
  
  public void run()
  {
    try
    {
      long l = FileUtils.getFileSizes(this.a);
      if (l < 25600L)
      {
        localObject1 = this.this$0.a.obtainMessage(1004);
        this.this$0.a.sendMessage((Message)localObject1);
        return;
      }
      Object localObject1 = BlessResultActivity.a(this.a);
      ImageUtil.a(BaseApplication.getContext(), this.a, (String)localObject1, 160, 160);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("share ptv to FC. srcLen:");
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append(" ,objLen:");
        ((StringBuilder)localObject2).append(FileUtils.getFileSizes((String)localObject1));
        ((StringBuilder)localObject2).append(" , thumbPath:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("BlessResultActivity", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = this.this$0.a.obtainMessage(1004);
      ((Message)localObject2).obj = localObject1;
      this.this$0.a.sendMessage((Message)localObject2);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessResultActivity.1
 * JD-Core Version:    0.7.0.1
 */