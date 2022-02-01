package com.tencent.biz.qqcircle.richframework.widget.actionsheet;

import android.app.Activity;
import android.content.Context;
import com.tencent.qphone.base.util.QLog;

public class ActionSheetHelper
{
  public static String a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getString(paramInt);
  }
  
  public static void a(Activity paramActivity, ActionSheet paramActionSheet)
  {
    if (paramActivity != null)
    {
      if (paramActionSheet == null) {
        return;
      }
      try
      {
        if (!paramActivity.isFinishing())
        {
          paramActionSheet.dismiss();
          return;
        }
        paramActionSheet = new StringBuilder();
        paramActionSheet.append("dismissActionSheet when activity(");
        paramActionSheet.append(paramActivity);
        paramActionSheet.append(") is finish!");
        QLog.e("ActionSheetHelper", 1, paramActionSheet.toString());
        return;
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheetHelper
 * JD-Core Version:    0.7.0.1
 */