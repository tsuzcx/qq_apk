package androidx.appcompat.widget;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class SearchView$6
  implements View.OnKeyListener
{
  SearchView$6(SearchView paramSearchView) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.this$0.mSearchable == null) {
      return false;
    }
    if ((this.this$0.mSearchSrcTextView.isPopupShowing()) && (this.this$0.mSearchSrcTextView.getListSelection() != -1)) {
      return this.this$0.onSuggestionsKey(paramView, paramInt, paramKeyEvent);
    }
    if ((!this.this$0.mSearchSrcTextView.isEmpty()) && (paramKeyEvent.hasNoModifiers()) && (paramKeyEvent.getAction() == 1) && (paramInt == 66))
    {
      paramView.cancelLongPress();
      paramView = this.this$0;
      paramView.launchQuerySearch(0, null, paramView.mSearchSrcTextView.getText().toString());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.SearchView.6
 * JD-Core Version:    0.7.0.1
 */