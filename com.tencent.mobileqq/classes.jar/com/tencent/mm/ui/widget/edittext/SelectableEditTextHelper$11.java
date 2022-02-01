package com.tencent.mm.ui.widget.edittext;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import com.tencent.mm.ui.f;

class SelectableEditTextHelper$11
  implements ActionMode.Callback
{
  SelectableEditTextHelper$11(SelectableEditTextHelper paramSelectableEditTextHelper) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return false;
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    f.b("SelectableEditTextHelper", "mDisableCallback", new Object[0]);
    SelectableEditTextHelper.a(this.a, paramMenu);
    return false;
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper.11
 * JD-Core Version:    0.7.0.1
 */