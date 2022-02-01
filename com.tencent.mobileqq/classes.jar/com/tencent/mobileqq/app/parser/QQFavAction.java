package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;

public class QQFavAction
  extends JumpAction
{
  public QQFavAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    int i;
    label170:
    do
    {
      try
      {
        if (TextUtils.isEmpty(this.e))
        {
          QLog.e("QQFavAction", 1, "doAction error: action_name is empty");
        }
        else
        {
          try
          {
            i = Integer.parseInt(this.e);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("doAction error NumberFormatException: ");
            localStringBuilder.append(localNumberFormatException.getMessage());
            QLog.e("QQFavAction", 1, localStringBuilder.toString());
            break label170;
          }
          Intent localIntent = new Intent();
          localIntent.putExtra("selfSet_leftViewText", BaseApplicationImpl.getApplication().getApplicationContext().getString(2131887625));
          boolean bool = QfavHelper.a((Activity)this.b, this.a.getAccount(), localIntent, -1, false);
          return bool;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doAction error: ");
        localStringBuilder.append(localException.getMessage());
        QLog.e("QQFavAction", 1, localStringBuilder.toString());
        h_("QQFavAction");
        return false;
      }
      i = -1;
    } while (i == 2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QQFavAction
 * JD-Core Version:    0.7.0.1
 */