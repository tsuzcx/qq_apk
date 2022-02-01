package com.tencent.avgame.ui;

import android.text.TextUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.qphone.base.util.QLog;
import new;

class AVGameActivity$6
  implements Runnable
{
  AVGameActivity$6(AVGameActivity paramAVGameActivity, int paramInt) {}
  
  public void run()
  {
    QLog.i("AVGameActivity", 1, "onEnterRoom run mGameExited:" + AVGameActivity.a(this.this$0) + " retCode:" + this.a + " mRoomId:" + AVGameActivity.a(this.this$0));
    if (AVGameActivity.a(this.this$0)) {}
    do
    {
      do
      {
        return;
        if (this.a != 0) {
          break;
        }
      } while ((TextUtils.isEmpty(AVGameActivity.a(this.this$0))) || (AVGameActivity.a(this.this$0) == null));
      AVGameActivity.a(this.this$0).a().a(1, AVGameActivity.a(this.this$0));
      return;
    } while ((this.a == 5) || (this.a == 6));
    AVGameActivity.a(this.this$0, 2, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameActivity.6
 * JD-Core Version:    0.7.0.1
 */