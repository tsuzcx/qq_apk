package com.tencent.mobileqq.activity.aio.helper;

import android.text.Editable;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.XEditTextEx;
import mqq.app.AppRuntime;

class FullScreenInputHelper$5
  implements ActionMode.Callback
{
  FullScreenInputHelper$5(FullScreenInputHelper paramFullScreenInputHelper) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    Object localObject = FullScreenInputHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    boolean bool1;
    if (paramMenuItem.getItemId() == 1)
    {
      ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800A513", "0X800A513", FullScreenInputHelper.a(this.a), 0, "", "", "", "");
      FullScreenInputHelper.a(this.a).jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().insert(FullScreenInputHelper.a(this.a).jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart(), "\n");
      paramActionMode.finish();
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          if (paramMenuItem.getItemId() == 2)
          {
            if (this.a.b())
            {
              ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800A514", "0X800A514", FullScreenInputHelper.a(this.a), 0, "", "", "", "");
              this.a.a(false);
            }
            for (;;)
            {
              paramActionMode.finish();
              return true;
              ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X8009F28", "0X8009F28", FullScreenInputHelper.a(this.a), 0, "", "", "", "");
              FullScreenInputHelper.b(this.a);
            }
          }
          bool1 = bool2;
        } while (paramMenuItem.getItemId() != 3);
        localObject = (WriteTogetherHelper)FullScreenInputHelper.a(this.a).a(74);
        bool1 = bool2;
      } while (localObject == null);
      localObject = ((WriteTogetherHelper)localObject).a();
      bool1 = bool2;
    } while (localObject == null);
    return ((ActionMode.Callback)localObject).onActionItemClicked(paramActionMode, paramMenuItem);
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    if (!SimpleUIUtil.a())
    {
      paramMenu.add(0, 1, 196608, HardCodeUtil.a(2131704985));
      if (!this.a.b()) {
        break label100;
      }
    }
    label100:
    for (Object localObject = HardCodeUtil.a(2131704986);; localObject = HardCodeUtil.a(2131704983))
    {
      paramMenu.add(0, 2, 196608, (CharSequence)localObject);
      if (this.a.a() == 0)
      {
        localObject = (WriteTogetherHelper)FullScreenInputHelper.a(this.a).a(74);
        if (localObject != null)
        {
          localObject = ((WriteTogetherHelper)localObject).a();
          if (localObject != null) {
            ((ActionMode.Callback)localObject).onCreateActionMode(paramActionMode, paramMenu);
          }
        }
      }
      return true;
    }
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