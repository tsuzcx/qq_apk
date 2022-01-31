package com.tencent.mobileqq.apollo.script;

import akwk;
import akwl;
import android.os.Message;
import bdcb;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class SpriteUIHandler$5
  implements Runnable
{
  SpriteUIHandler$5(SpriteUIHandler paramSpriteUIHandler, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      MqqHandler localMqqHandler = SpriteUIHandler.a(this.this$0).a().a();
      if (1 == this.a)
      {
        localMqqHandler.obtainMessage(47, (int)((float)bdcb.h() / 7.0F / 2.84D) + 40, 0).sendToTarget();
        return;
      }
      if (2 == this.a)
      {
        localMqqHandler.obtainMessage(47, this.b + 40 + (int)((float)bdcb.h() / 7.0F), 0).sendToTarget();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("cmshow_scripted_SpriteUIHandler", 1, localException, new Object[0]);
      return;
    }
    if (3 == this.a) {
      if ((akwk.a(SpriteUIHandler.a(this.this$0).a())) && (akwk.b(SpriteUIHandler.a(this.this$0).a(), "select_more_msg")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteUIHandler", 2, "addOrRemoveMargin hidden but not should remove margin");
        }
      }
      else {
        localException.sendEmptyMessage(62);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler.5
 * JD-Core Version:    0.7.0.1
 */