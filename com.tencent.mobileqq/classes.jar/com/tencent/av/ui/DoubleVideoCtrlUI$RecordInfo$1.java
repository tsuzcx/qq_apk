package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import lsg;

public class DoubleVideoCtrlUI$RecordInfo$1
  implements Runnable
{
  public DoubleVideoCtrlUI$RecordInfo$1(lsg paramlsg) {}
  
  public void run()
  {
    int i = 2130841600;
    if ((lsg.a(this.this$0) == null) || (lsg.a(this.this$0) == null) || (lsg.a(this.this$0).a == null)) {}
    while (lsg.a(this.this$0) != 1) {
      return;
    }
    lsg.b(this.this$0);
    if (lsg.c(this.this$0) < 3)
    {
      localObject = this.this$0;
      if (lsg.c(this.this$0) == 1) {
        i = 2130841601;
      }
      lsg.a((lsg)localObject, i);
      lsg.a(this.this$0).a.f(-1025L, 65535);
      lsg.a(this.this$0).a().postDelayed(this.this$0.a, 1000L);
      return;
    }
    lsg.b(this.this$0, 2);
    lsg.a(this.this$0, 2130841600);
    lsg.a(this.this$0).a.f(-1026L, 65535);
    Object localObject = (QavRecordButtonView)lsg.a(this.this$0).findViewById(2131309242);
    if (localObject != null) {
      ((QavRecordButtonView)localObject).callOnClick();
    }
    lsg.a(this.this$0).a(new Object[] { Integer.valueOf(8001), "OnRecord" });
    lsg.c(this.this$0, 0);
    lsg.b(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.RecordInfo.1
 * JD-Core Version:    0.7.0.1
 */