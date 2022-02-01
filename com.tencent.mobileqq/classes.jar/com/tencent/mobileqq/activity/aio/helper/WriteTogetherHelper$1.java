package com.tencent.mobileqq.activity.aio.helper;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HardCodeUtil;

class WriteTogetherHelper$1
  implements ActionMode.Callback
{
  WriteTogetherHelper$1(WriteTogetherHelper paramWriteTogetherHelper) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    String str = "";
    Object localObject = WriteTogetherHelper.a(this.a).a;
    paramMenuItem = str;
    if (localObject != null)
    {
      localObject = ((EditText)localObject).getText();
      paramMenuItem = str;
      if (localObject != null) {
        paramMenuItem = localObject.toString();
      }
    }
    this.a.b(paramMenuItem, 1);
    paramActionMode.finish();
    return true;
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    if ((this.a.a()) && (WriteTogetherHelper.a(this.a))) {
      paramMenu.add(0, 3, 196608, HardCodeUtil.a(2131720726));
    }
    return this.a.a();
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.WriteTogetherHelper.1
 * JD-Core Version:    0.7.0.1
 */