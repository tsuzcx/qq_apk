package androidx.appcompat.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AlertController$AlertParams$1
  extends ArrayAdapter<CharSequence>
{
  AlertController$AlertParams$1(AlertController.AlertParams paramAlertParams, Context paramContext, int paramInt1, int paramInt2, CharSequence[] paramArrayOfCharSequence, AlertController.RecycleListView paramRecycleListView)
  {
    super(paramContext, paramInt1, paramInt2, paramArrayOfCharSequence);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = super.getView(paramInt, paramView, paramViewGroup);
    if ((this.this$0.mCheckedItems != null) && (this.this$0.mCheckedItems[paramInt] != 0)) {
      this.val$listView.setItemChecked(paramInt, true);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AlertController.AlertParams.1
 * JD-Core Version:    0.7.0.1
 */