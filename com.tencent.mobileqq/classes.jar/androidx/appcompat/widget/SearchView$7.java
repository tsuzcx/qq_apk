package androidx.appcompat.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchView$7
  implements TextView.OnEditorActionListener
{
  SearchView$7(SearchView paramSearchView) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    this.this$0.onSubmitQuery();
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.SearchView.7
 * JD-Core Version:    0.7.0.1
 */