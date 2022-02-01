package androidx.cursoradapter.widget;

import android.database.ContentObserver;
import android.os.Handler;

class CursorAdapter$ChangeObserver
  extends ContentObserver
{
  CursorAdapter$ChangeObserver(CursorAdapter paramCursorAdapter)
  {
    super(new Handler());
  }
  
  public boolean deliverSelfNotifications()
  {
    return true;
  }
  
  public void onChange(boolean paramBoolean)
  {
    this.this$0.onContentChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.cursoradapter.widget.CursorAdapter.ChangeObserver
 * JD-Core Version:    0.7.0.1
 */