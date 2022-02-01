package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import com.tencent.widget.ActionSheet;

class AppletsFolderManager$2
  implements Runnable
{
  AppletsFolderManager$2(AppletsFolderManager paramAppletsFolderManager, Context paramContext, String paramString1, String paramString2) {}
  
  public void run()
  {
    ActionSheet localActionSheet = ActionSheet.create(this.a);
    localActionSheet.setMainTitle(this.a.getString(2131886992));
    localActionSheet.addButton(2131886993, 3);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnDismissListener(new AppletsFolderManager.2.1(this));
    localActionSheet.setOnButtonClickListener(new AppletsFolderManager.2.2(this, localActionSheet));
    if (!localActionSheet.isShowing())
    {
      AppletsFolderManager.a(this.this$0, false);
      localActionSheet.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.AppletsFolderManager.2
 * JD-Core Version:    0.7.0.1
 */