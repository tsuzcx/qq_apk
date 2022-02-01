package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import mdj;

public class DoubleVideoCtrlUI$RecordInfo$1
  implements Runnable
{
  public DoubleVideoCtrlUI$RecordInfo$1(mdj parammdj) {}
  
  public void run()
  {
    int i = 2130842175;
    if ((mdj.a(this.this$0) == null) || (mdj.a(this.this$0) == null) || (mdj.a(this.this$0).a == null)) {}
    while (mdj.a(this.this$0) != 1) {
      return;
    }
    mdj.b(this.this$0);
    if (mdj.c(this.this$0) < 3)
    {
      localObject = this.this$0;
      if (mdj.c(this.this$0) == 1) {
        i = 2130842176;
      }
      mdj.a((mdj)localObject, i);
      mdj.a(this.this$0).a.i(-1025L, 65535);
      mdj.a(this.this$0).a().postDelayed(this.this$0.a, 1000L);
      return;
    }
    mdj.b(this.this$0, 2);
    mdj.a(this.this$0, 2130842175);
    mdj.a(this.this$0).a.i(-1026L, 65535);
    Object localObject = (QavRecordButtonView)mdj.a(this.this$0).findViewById(2131376372);
    if (localObject != null) {
      ((QavRecordButtonView)localObject).callOnClick();
    }
    mdj.a(this.this$0).a(new Object[] { Integer.valueOf(8001), "OnRecord" });
    mdj.c(this.this$0, 0);
    mdj.b(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.RecordInfo.1
 * JD-Core Version:    0.7.0.1
 */