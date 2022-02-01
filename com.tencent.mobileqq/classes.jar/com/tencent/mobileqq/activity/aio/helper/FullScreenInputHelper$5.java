package com.tencent.mobileqq.activity.aio.helper;

import android.text.Editable;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.widget.XEditTextEx;
import mqq.app.AppRuntime;

class FullScreenInputHelper$5
  implements ActionMode.Callback
{
  FullScreenInputHelper$5(FullScreenInputHelper paramFullScreenInputHelper) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    Object localObject = this.a.a.d;
    FullScreenInputHelper.a(this.a, paramMenuItem.getItemId());
    if (paramMenuItem.getItemId() == 1)
    {
      ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800A513", "0X800A513", FullScreenInputHelper.d(this.a), 0, "", "", "", "");
      this.a.a.Y.getText().insert(this.a.a.Y.getSelectionStart(), "\n");
      paramActionMode.finish();
      return true;
    }
    if (paramMenuItem.getItemId() == 2)
    {
      if (this.a.e())
      {
        ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800A514", "0X800A514", FullScreenInputHelper.d(this.a), 0, "", "", "", "");
        this.a.b(false);
        if (QQTheme.isNowSimpleUI()) {
          FullScreenInputHelper.e(this.a).d();
        } else {
          this.a.b(false);
        }
      }
      else
      {
        ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X8009F28", "0X8009F28", FullScreenInputHelper.d(this.a), 0, "", "", "", "");
        SimpleFullInputReporter.a(this.a.a.d, "0X800BDA1", FullScreenInputHelper.c(this.a), "");
        if (QQTheme.isNowSimpleUI()) {
          FullScreenInputHelper.e(this.a).c();
        } else {
          this.a.b();
        }
      }
      paramActionMode.finish();
      return true;
    }
    if (paramMenuItem.getItemId() == 3)
    {
      localObject = (WriteTogetherHelper)this.a.a.q(74);
      if (localObject != null)
      {
        localObject = ((WriteTogetherHelper)localObject).c();
        if (localObject != null) {
          return ((ActionMode.Callback)localObject).onActionItemClicked(paramActionMode, paramMenuItem);
        }
      }
    }
    return false;
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    paramMenu.add(0, 1, 196608, HardCodeUtil.a(2131902951));
    int i;
    if (this.a.e()) {
      i = 2131902952;
    } else {
      i = 2131902949;
    }
    paramMenu.add(0, 2, 196608, HardCodeUtil.a(i));
    if (this.a.o() == 0)
    {
      Object localObject = (WriteTogetherHelper)this.a.a.q(74);
      if (localObject != null)
      {
        localObject = ((WriteTogetherHelper)localObject).c();
        if (localObject != null) {
          ((ActionMode.Callback)localObject).onCreateActionMode(paramActionMode, paramMenu);
        }
      }
    }
    if (!this.a.e()) {
      SimpleFullInputReporter.a(this.a.a.d, "0X800BDA0", FullScreenInputHelper.c(this.a), "");
    }
    return true;
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper.5
 * JD-Core Version:    0.7.0.1
 */