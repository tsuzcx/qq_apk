package com.tencent.mobileqq.activity.aio.item;

import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.scribble.IScribbleMsgUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ScribbleItemBuilder$2
  implements ActionSheet.OnButtonClickListener
{
  ScribbleItemBuilder$2(ScribbleItemBuilder paramScribbleItemBuilder, View paramView, MessageForScribble paramMessageForScribble, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      long l = SystemClock.uptimeMillis();
      if (l - this.d.a < 500L) {
        return;
      }
      paramView = this.d;
      paramView.a = l;
      paramView = FileTransferManager.a(paramView.d);
      if (paramView != null) {
        paramView.a(this.a, this.d);
      }
      ((IScribbleMsgUtils)QRoute.api(IScribbleMsgUtils.class)).ReSendScribbleMsgRecord(this.d.d, this.b);
    }
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */