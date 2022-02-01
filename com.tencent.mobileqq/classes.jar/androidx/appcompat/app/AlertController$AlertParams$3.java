package androidx.appcompat.app;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AlertController$AlertParams$3
  implements AdapterView.OnItemClickListener
{
  AlertController$AlertParams$3(AlertController.AlertParams paramAlertParams, AlertController paramAlertController) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.this$0.mOnClickListener.onClick(this.val$dialog.mDialog, paramInt);
    if (!this.this$0.mIsSingleChoice) {
      this.val$dialog.mDialog.dismiss();
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AlertController.AlertParams.3
 * JD-Core Version:    0.7.0.1
 */