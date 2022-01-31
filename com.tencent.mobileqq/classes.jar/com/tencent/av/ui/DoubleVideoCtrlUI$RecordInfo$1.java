package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import mfj;

public class DoubleVideoCtrlUI$RecordInfo$1
  implements Runnable
{
  public DoubleVideoCtrlUI$RecordInfo$1(mfj parammfj) {}
  
  public void run()
  {
    int i = 2130841856;
    if ((mfj.a(this.this$0) == null) || (mfj.a(this.this$0) == null) || (mfj.a(this.this$0).a == null)) {}
    while (mfj.a(this.this$0) != 1) {
      return;
    }
    mfj.b(this.this$0);
    if (mfj.c(this.this$0) < 3)
    {
      localObject = this.this$0;
      if (mfj.c(this.this$0) == 1) {
        i = 2130841857;
      }
      mfj.a((mfj)localObject, i);
      mfj.a(this.this$0).a.f(-1025L, 65535);
      mfj.a(this.this$0).a().postDelayed(this.this$0.a, 1000L);
      return;
    }
    mfj.b(this.this$0, 2);
    mfj.a(this.this$0, 2130841856);
    mfj.a(this.this$0).a.f(-1026L, 65535);
    Object localObject = (QavRecordButtonView)mfj.a(this.this$0).findViewById(2131375509);
    if (localObject != null) {
      ((QavRecordButtonView)localObject).callOnClick();
    }
    mfj.a(this.this$0).a(new Object[] { Integer.valueOf(8001), "OnRecord" });
    mfj.c(this.this$0, 0);
    mfj.b(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.RecordInfo.1
 * JD-Core Version:    0.7.0.1
 */