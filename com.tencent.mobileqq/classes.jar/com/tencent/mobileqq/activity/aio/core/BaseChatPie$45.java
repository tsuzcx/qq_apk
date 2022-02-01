package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XEditTextEx;

class BaseChatPie$45
  implements Runnable
{
  BaseChatPie$45(BaseChatPie paramBaseChatPie, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.setRequestedOrientation4Recording(true);
    this.this$0.cancelRemainScreenOn();
    this.this$0.recorderVolumeChange(0);
    this.this$0.input.setEnabled(true);
    if (this.val$isNoPermission)
    {
      this.this$0.showAbnormalRecordDlg();
      return;
    }
    QQToast.a(this.this$0.app.getApp(), 2131690019, 1).b(this.this$0.mContext.getResources().getDimensionPixelSize(2131299080));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.45
 * JD-Core Version:    0.7.0.1
 */