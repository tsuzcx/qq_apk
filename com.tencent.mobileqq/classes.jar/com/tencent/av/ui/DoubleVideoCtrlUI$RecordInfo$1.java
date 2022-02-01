package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;

class DoubleVideoCtrlUI$RecordInfo$1
  implements Runnable
{
  DoubleVideoCtrlUI$RecordInfo$1(DoubleVideoCtrlUI.RecordInfo paramRecordInfo) {}
  
  public void run()
  {
    if ((DoubleVideoCtrlUI.RecordInfo.b(this.this$0) != null) && (DoubleVideoCtrlUI.RecordInfo.c(this.this$0) != null))
    {
      if (DoubleVideoCtrlUI.RecordInfo.b(this.this$0).K == null) {
        return;
      }
      if (DoubleVideoCtrlUI.RecordInfo.d(this.this$0) != 1) {
        return;
      }
      DoubleVideoCtrlUI.RecordInfo.e(this.this$0);
      int j = DoubleVideoCtrlUI.RecordInfo.f(this.this$0);
      int i = 2130843216;
      if (j < 3)
      {
        localObject = this.this$0;
        if (DoubleVideoCtrlUI.RecordInfo.f((DoubleVideoCtrlUI.RecordInfo)localObject) == 1) {
          i = 2130843217;
        }
        DoubleVideoCtrlUI.RecordInfo.a((DoubleVideoCtrlUI.RecordInfo)localObject, i);
        DoubleVideoCtrlUI.RecordInfo.b(this.this$0).K.f(-1025L, 16777215);
        DoubleVideoCtrlUI.RecordInfo.c(this.this$0).a().postDelayed(this.this$0.a, 1000L);
        return;
      }
      DoubleVideoCtrlUI.RecordInfo.b(this.this$0, 2);
      DoubleVideoCtrlUI.RecordInfo.a(this.this$0, 2130843216);
      DoubleVideoCtrlUI.RecordInfo.b(this.this$0).K.f(-1026L, 16777215);
      Object localObject = (QavRecordButtonView)DoubleVideoCtrlUI.RecordInfo.b(this.this$0).findViewById(2131444486);
      if (localObject != null) {
        ((QavRecordButtonView)localObject).callOnClick();
      }
      DoubleVideoCtrlUI.RecordInfo.c(this.this$0).a(new Object[] { Integer.valueOf(8001), "OnRecord" });
      DoubleVideoCtrlUI.RecordInfo.c(this.this$0, 0);
      DoubleVideoCtrlUI.RecordInfo.b(this.this$0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.RecordInfo.1
 * JD-Core Version:    0.7.0.1
 */