package androidx.appcompat.app;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;

class AlertController$AlertParams$2
  extends CursorAdapter
{
  private final int mIsCheckedIndex;
  private final int mLabelIndex;
  
  AlertController$AlertParams$2(AlertController.AlertParams paramAlertParams, Context paramContext, Cursor paramCursor, boolean paramBoolean, AlertController.RecycleListView paramRecycleListView, AlertController paramAlertController)
  {
    super(paramContext, paramCursor, paramBoolean);
    paramAlertParams = getCursor();
    this.mLabelIndex = paramAlertParams.getColumnIndexOrThrow(this.this$0.mLabelColumn);
    this.mIsCheckedIndex = paramAlertParams.getColumnIndexOrThrow(this.this$0.mIsCheckedColumn);
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    ((CheckedTextView)paramView.findViewById(16908308)).setText(paramCursor.getString(this.mLabelIndex));
    paramView = this.val$listView;
    int i = paramCursor.getPosition();
    int j = paramCursor.getInt(this.mIsCheckedIndex);
    boolean bool = true;
    if (j != 1) {
      bool = false;
    }
    paramView.setItemChecked(i, bool);
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.this$0.mInflater.inflate(this.val$dialog.mMultiChoiceItemLayout, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AlertController.AlertParams.2
 * JD-Core Version:    0.7.0.1
 */