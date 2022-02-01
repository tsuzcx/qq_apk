package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import com.tencent.widget.ActionSheet;

class AppletsFolderManager$2
  implements Runnable
{
  AppletsFolderManager$2(AppletsFolderManager paramAppletsFolderManager, Context paramContext, String paramString1, String paramString2) {}
  
  public void run()
  {
    AppletsFolderManager.a(this.this$0, ActionSheet.create(this.jdField_a_of_type_AndroidContentContext));
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131690180);
    AppletsFolderManager.a(this.this$0).setMainTitle(str);
    AppletsFolderManager.a(this.this$0).addButton(2131690181, 3);
    AppletsFolderManager.a(this.this$0).addCancelButton(2131690800);
    AppletsFolderManager.a(this.this$0).setOnDismissListener(new AppletsFolderManager.2.1(this));
    AppletsFolderManager.a(this.this$0).setOnButtonClickListener(new AppletsFolderManager.2.2(this));
    if (!AppletsFolderManager.a(this.this$0).isShowing())
    {
      AppletsFolderManager.a(this.this$0, false);
      AppletsFolderManager.a(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.AppletsFolderManager.2
 * JD-Core Version:    0.7.0.1
 */