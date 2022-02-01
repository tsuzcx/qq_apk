package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import mcn;

public class DoubleVideoCtrlUI$RecordInfo$1
  implements Runnable
{
  public DoubleVideoCtrlUI$RecordInfo$1(mcn parammcn) {}
  
  public void run()
  {
    int i = 2130842163;
    if ((mcn.a(this.this$0) == null) || (mcn.a(this.this$0) == null) || (mcn.a(this.this$0).a == null)) {}
    while (mcn.a(this.this$0) != 1) {
      return;
    }
    mcn.b(this.this$0);
    if (mcn.c(this.this$0) < 3)
    {
      localObject = this.this$0;
      if (mcn.c(this.this$0) == 1) {
        i = 2130842164;
      }
      mcn.a((mcn)localObject, i);
      mcn.a(this.this$0).a.f(-1025L, 65535);
      mcn.a(this.this$0).a().postDelayed(this.this$0.a, 1000L);
      return;
    }
    mcn.b(this.this$0, 2);
    mcn.a(this.this$0, 2130842163);
    mcn.a(this.this$0).a.f(-1026L, 65535);
    Object localObject = (QavRecordButtonView)mcn.a(this.this$0).findViewById(2131376232);
    if (localObject != null) {
      ((QavRecordButtonView)localObject).callOnClick();
    }
    mcn.a(this.this$0).a(new Object[] { Integer.valueOf(8001), "OnRecord" });
    mcn.c(this.this$0, 0);
    mcn.b(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.RecordInfo.1
 * JD-Core Version:    0.7.0.1
 */