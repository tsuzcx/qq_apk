package androidx.appcompat.app;

import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AlertController$AlertParams$4
  implements AdapterView.OnItemClickListener
{
  AlertController$AlertParams$4(AlertController.AlertParams paramAlertParams, AlertController.RecycleListView paramRecycleListView, AlertController paramAlertController) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.this$0.mCheckedItems != null) {
      this.this$0.mCheckedItems[paramInt] = this.val$listView.isItemChecked(paramInt);
    }
    this.this$0.mOnCheckboxClickListener.onClick(this.val$dialog.mDialog, paramInt, this.val$listView.isItemChecked(paramInt));
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AlertController.AlertParams.4
 * JD-Core Version:    0.7.0.1
 */