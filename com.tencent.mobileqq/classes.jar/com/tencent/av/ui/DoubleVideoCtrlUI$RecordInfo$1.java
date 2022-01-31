package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import mcz;

public class DoubleVideoCtrlUI$RecordInfo$1
  implements Runnable
{
  public DoubleVideoCtrlUI$RecordInfo$1(mcz parammcz) {}
  
  public void run()
  {
    int i = 2130841692;
    if ((mcz.a(this.this$0) == null) || (mcz.a(this.this$0) == null) || (mcz.a(this.this$0).a == null)) {}
    while (mcz.a(this.this$0) != 1) {
      return;
    }
    mcz.b(this.this$0);
    if (mcz.c(this.this$0) < 3)
    {
      localObject = this.this$0;
      if (mcz.c(this.this$0) == 1) {
        i = 2130841693;
      }
      mcz.a((mcz)localObject, i);
      mcz.a(this.this$0).a.f(-1025L, 65535);
      mcz.a(this.this$0).a().postDelayed(this.this$0.a, 1000L);
      return;
    }
    mcz.b(this.this$0, 2);
    mcz.a(this.this$0, 2130841692);
    mcz.a(this.this$0).a.f(-1026L, 65535);
    Object localObject = (QavRecordButtonView)mcz.a(this.this$0).findViewById(2131374986);
    if (localObject != null) {
      ((QavRecordButtonView)localObject).callOnClick();
    }
    mcz.a(this.this$0).a(new Object[] { Integer.valueOf(8001), "OnRecord" });
    mcz.c(this.this$0, 0);
    mcz.b(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.RecordInfo.1
 * JD-Core Version:    0.7.0.1
 */