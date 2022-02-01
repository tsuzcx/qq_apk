package com.tencent.mobileqq.app.qim;

import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QIMNewFriend
{
  private static QIMUndecideNotifyDialog a;
  private static DialogInterface.OnDismissListener b = new QIMNewFriend.1();
  
  public static void a()
  {
    QIMUndecideNotifyDialog localQIMUndecideNotifyDialog = a;
    if ((localQIMUndecideNotifyDialog != null) && (localQIMUndecideNotifyDialog.isShowing())) {
      a.dismiss();
    }
  }
  
  public static boolean a(QBaseActivity paramQBaseActivity, ArrayList<QIMNotifyAddFriend> paramArrayList)
  {
    try
    {
      if ((a != null) && (a.isShowing()))
      {
        bool1 = a.a(paramArrayList);
        return bool1;
      }
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramArrayList != null)
      {
        bool1 = bool2;
        if (paramArrayList.size() > 0)
        {
          a = new QIMUndecideNotifyDialog(paramQBaseActivity, paramArrayList);
          a.setOnDismissListener(b);
          a.show();
          bool1 = true;
        }
      }
      if (QLog.isColorLevel())
      {
        paramQBaseActivity = new StringBuilder();
        paramQBaseActivity.append("showDialogIfNeed");
        paramQBaseActivity.append(bool1);
        QLog.i("UndecidedListDialogUtil", 2, paramQBaseActivity.toString());
      }
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.qim.QIMNewFriend
 * JD-Core Version:    0.7.0.1
 */