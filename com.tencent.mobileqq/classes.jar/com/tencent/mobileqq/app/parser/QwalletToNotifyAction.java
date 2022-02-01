package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.HashMap;
import org.json.JSONObject;

public class QwalletToNotifyAction
  extends JumpAction
{
  public QwalletToNotifyAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey("params");
      if (bool) {
        try
        {
          JSONObject localJSONObject = new JSONObject(URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("params")));
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("urlParamObj: ");
            localStringBuilder.append(localJSONObject);
            QLog.i("QwalletToNotifyAction", 2, localStringBuilder.toString());
          }
          if (localJSONObject.optInt("view_type", 0) == 0)
          {
            localJSONObject = localJSONObject.optJSONObject("params");
            if (localJSONObject != null)
            {
              ReminderListFragment.a(this.jdField_a_of_type_AndroidContentContext, localJSONObject.optString("notice_time"));
              return false;
            }
          }
        }
        catch (Exception localException1)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("JumpAction parse url throw an exception: ");
            localStringBuilder.append(localException1);
            QLog.e("QwalletToNotifyAction", 2, localStringBuilder.toString());
          }
        }
      }
      return false;
    }
    catch (Exception localException2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException2.getMessage());
      QLog.e("QwalletToNotifyAction", 1, localStringBuilder.toString());
      b_("QwalletToNotifyAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QwalletToNotifyAction
 * JD-Core Version:    0.7.0.1
 */