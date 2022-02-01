package com.tencent.av.wtogether.view;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.util.InputMethodUtil;

class GroupFileSearchDialog$4
  implements TextView.OnEditorActionListener
{
  GroupFileSearchDialog$4(GroupFileSearchDialog paramGroupFileSearchDialog) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 3) && ((paramKeyEvent == null) || (paramKeyEvent.getKeyCode() != 66))) {
      return false;
    }
    InputMethodUtil.b(this.a.a);
    this.a.d();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.view.GroupFileSearchDialog.4
 * JD-Core Version:    0.7.0.1
 */