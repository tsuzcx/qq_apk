package androidx.appcompat.app;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AlertController$1
  implements View.OnClickListener
{
  AlertController$1(AlertController paramAlertController) {}
  
  public void onClick(View paramView)
  {
    Message localMessage;
    if ((paramView == this.this$0.mButtonPositive) && (this.this$0.mButtonPositiveMessage != null)) {
      localMessage = Message.obtain(this.this$0.mButtonPositiveMessage);
    } else if ((paramView == this.this$0.mButtonNegative) && (this.this$0.mButtonNegativeMessage != null)) {
      localMessage = Message.obtain(this.this$0.mButtonNegativeMessage);
    } else if ((paramView == this.this$0.mButtonNeutral) && (this.this$0.mButtonNeutralMessage != null)) {
      localMessage = Message.obtain(this.this$0.mButtonNeutralMessage);
    } else {
      localMessage = null;
    }
    if (localMessage != null) {
      localMessage.sendToTarget();
    }
    this.this$0.mHandler.obtainMessage(1, this.this$0.mDialog).sendToTarget();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AlertController.1
 * JD-Core Version:    0.7.0.1
 */