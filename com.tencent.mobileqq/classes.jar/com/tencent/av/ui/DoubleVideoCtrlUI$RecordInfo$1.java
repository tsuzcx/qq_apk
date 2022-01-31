package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import mcu;

public class DoubleVideoCtrlUI$RecordInfo$1
  implements Runnable
{
  public DoubleVideoCtrlUI$RecordInfo$1(mcu parammcu) {}
  
  public void run()
  {
    int i = 2130841692;
    if ((mcu.a(this.this$0) == null) || (mcu.a(this.this$0) == null) || (mcu.a(this.this$0).a == null)) {}
    while (mcu.a(this.this$0) != 1) {
      return;
    }
    mcu.b(this.this$0);
    if (mcu.c(this.this$0) < 3)
    {
      localObject = this.this$0;
      if (mcu.c(this.this$0) == 1) {
        i = 2130841693;
      }
      mcu.a((mcu)localObject, i);
      mcu.a(this.this$0).a.f(-1025L, 65535);
      mcu.a(this.this$0).a().postDelayed(this.this$0.a, 1000L);
      return;
    }
    mcu.b(this.this$0, 2);
    mcu.a(this.this$0, 2130841692);
    mcu.a(this.this$0).a.f(-1026L, 65535);
    Object localObject = (QavRecordButtonView)mcu.a(this.this$0).findViewById(2131374988);
    if (localObject != null) {
      ((QavRecordButtonView)localObject).callOnClick();
    }
    mcu.a(this.this$0).a(new Object[] { Integer.valueOf(8001), "OnRecord" });
    mcu.c(this.this$0, 0);
    mcu.b(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.RecordInfo.1
 * JD-Core Version:    0.7.0.1
 */