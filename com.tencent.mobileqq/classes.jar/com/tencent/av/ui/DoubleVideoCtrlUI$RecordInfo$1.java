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
    if ((DoubleVideoCtrlUI.RecordInfo.a(this.this$0) != null) && (DoubleVideoCtrlUI.RecordInfo.a(this.this$0) != null))
    {
      if (DoubleVideoCtrlUI.RecordInfo.a(this.this$0).a == null) {
        return;
      }
      if (DoubleVideoCtrlUI.RecordInfo.b(this.this$0) != 1) {
        return;
      }
      DoubleVideoCtrlUI.RecordInfo.c(this.this$0);
      int j = DoubleVideoCtrlUI.RecordInfo.d(this.this$0);
      int i = 2130842272;
      if (j < 3)
      {
        localObject = this.this$0;
        if (DoubleVideoCtrlUI.RecordInfo.d((DoubleVideoCtrlUI.RecordInfo)localObject) == 1) {
          i = 2130842273;
        }
        DoubleVideoCtrlUI.RecordInfo.a((DoubleVideoCtrlUI.RecordInfo)localObject, i);
        DoubleVideoCtrlUI.RecordInfo.a(this.this$0).a.i(-1025L, 16777215);
        DoubleVideoCtrlUI.RecordInfo.a(this.this$0).a().postDelayed(this.this$0.a, 1000L);
        return;
      }
      DoubleVideoCtrlUI.RecordInfo.b(this.this$0, 2);
      DoubleVideoCtrlUI.RecordInfo.a(this.this$0, 2130842272);
      DoubleVideoCtrlUI.RecordInfo.a(this.this$0).a.i(-1026L, 16777215);
      Object localObject = (QavRecordButtonView)DoubleVideoCtrlUI.RecordInfo.a(this.this$0).findViewById(2131376277);
      if (localObject != null) {
        ((QavRecordButtonView)localObject).callOnClick();
      }
      DoubleVideoCtrlUI.RecordInfo.a(this.this$0).a(new Object[] { Integer.valueOf(8001), "OnRecord" });
      DoubleVideoCtrlUI.RecordInfo.c(this.this$0, 0);
      DoubleVideoCtrlUI.RecordInfo.b(this.this$0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.RecordInfo.1
 * JD-Core Version:    0.7.0.1
 */