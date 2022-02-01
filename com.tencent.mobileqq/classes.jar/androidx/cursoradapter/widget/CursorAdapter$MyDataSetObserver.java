package androidx.cursoradapter.widget;

import android.database.DataSetObserver;

class CursorAdapter$MyDataSetObserver
  extends DataSetObserver
{
  CursorAdapter$MyDataSetObserver(CursorAdapter paramCursorAdapter) {}
  
  public void onChanged()
  {
    CursorAdapter localCursorAdapter = this.this$0;
    localCursorAdapter.mDataValid = true;
    localCursorAdapter.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    CursorAdapter localCursorAdapter = this.this$0;
    localCursorAdapter.mDataValid = false;
    localCursorAdapter.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.cursoradapter.widget.CursorAdapter.MyDataSetObserver
 * JD-Core Version:    0.7.0.1
 */