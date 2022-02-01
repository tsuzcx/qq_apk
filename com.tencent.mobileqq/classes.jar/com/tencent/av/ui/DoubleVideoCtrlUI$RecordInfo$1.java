package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import mcs;

public class DoubleVideoCtrlUI$RecordInfo$1
  implements Runnable
{
  public DoubleVideoCtrlUI$RecordInfo$1(mcs parammcs) {}
  
  public void run()
  {
    int i = 2130842217;
    if ((mcs.a(this.this$0) == null) || (mcs.a(this.this$0) == null) || (mcs.a(this.this$0).a == null)) {}
    while (mcs.a(this.this$0) != 1) {
      return;
    }
    mcs.b(this.this$0);
    if (mcs.c(this.this$0) < 3)
    {
      localObject = this.this$0;
      if (mcs.c(this.this$0) == 1) {
        i = 2130842218;
      }
      mcs.a((mcs)localObject, i);
      mcs.a(this.this$0).a.i(-1025L, 65535);
      mcs.a(this.this$0).a().postDelayed(this.this$0.a, 1000L);
      return;
    }
    mcs.b(this.this$0, 2);
    mcs.a(this.this$0, 2130842217);
    mcs.a(this.this$0).a.i(-1026L, 65535);
    Object localObject = (QavRecordButtonView)mcs.a(this.this$0).findViewById(2131376139);
    if (localObject != null) {
      ((QavRecordButtonView)localObject).callOnClick();
    }
    mcs.a(this.this$0).a(new Object[] { Integer.valueOf(8001), "OnRecord" });
    mcs.c(this.this$0, 0);
    mcs.b(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.RecordInfo.1
 * JD-Core Version:    0.7.0.1
 */