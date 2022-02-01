package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.os.Build;
import biuj;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$48
  implements Runnable
{
  BaseChatPie$48(BaseChatPie paramBaseChatPie, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.tag, 2, "recorderVolumeChange " + this.val$state);
    }
    if (this.val$state == 1) {
      if (!this.this$0.isRecording()) {
        QLog.i(this.this$0.tag, 1, "volueme state err" + Build.MANUFACTURER + Build.MODEL);
      }
    }
    while (((this.val$state != 2) && (this.val$state != 0)) || (this.this$0.mRecordToastDialog == null) || (!this.this$0.mRecordToastDialog.isShowing()) || (this.this$0.mRecordToastDialog.getWindow() == null))
    {
      do
      {
        return;
      } while ((this.this$0.mRecordToastDialog != null) && (this.this$0.mRecordToastDialog.isShowing()));
      this.this$0.mRecordToastDialog = new biuj(this.this$0.mContext);
      this.this$0.mRecordToastDialog.a(this.this$0.mContext.getString(2131698247));
      this.this$0.mRecordToastDialog.show();
      return;
    }
    this.this$0.mRecordToastDialog.dismiss();
    this.this$0.mRecordToastDialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.48
 * JD-Core Version:    0.7.0.1
 */