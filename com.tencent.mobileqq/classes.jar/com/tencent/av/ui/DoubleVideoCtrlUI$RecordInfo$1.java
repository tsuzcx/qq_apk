package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import mdo;

public class DoubleVideoCtrlUI$RecordInfo$1
  implements Runnable
{
  public DoubleVideoCtrlUI$RecordInfo$1(mdo parammdo) {}
  
  public void run()
  {
    int i = 2130842231;
    if ((mdo.a(this.this$0) == null) || (mdo.a(this.this$0) == null) || (mdo.a(this.this$0).a == null)) {}
    while (mdo.b(this.this$0) != 1) {
      return;
    }
    mdo.c(this.this$0);
    if (mdo.d(this.this$0) < 3)
    {
      localObject = this.this$0;
      if (mdo.d(this.this$0) == 1) {
        i = 2130842232;
      }
      mdo.a((mdo)localObject, i);
      mdo.a(this.this$0).a.i(-1025L, 16777215);
      mdo.a(this.this$0).a().postDelayed(this.this$0.a, 1000L);
      return;
    }
    mdo.b(this.this$0, 2);
    mdo.a(this.this$0, 2130842231);
    mdo.a(this.this$0).a.i(-1026L, 16777215);
    Object localObject = (QavRecordButtonView)mdo.a(this.this$0).findViewById(2131376385);
    if (localObject != null) {
      ((QavRecordButtonView)localObject).callOnClick();
    }
    mdo.a(this.this$0).a(new Object[] { Integer.valueOf(8001), "OnRecord" });
    mdo.c(this.this$0, 0);
    mdo.b(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.RecordInfo.1
 * JD-Core Version:    0.7.0.1
 */