package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

public class QQSettingJumpAction
  extends JumpActionBase
{
  public QQSettingJumpAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    Intent localIntent;
    if ("general".equals(this.c))
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, GeneralSettingActivity.class);
      localIntent.addFlags(603979776);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
    for (;;)
    {
      return true;
      if ("deviceLock".equals(this.c))
      {
        localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AuthDevActivity.class);
        localIntent.putExtra("from", (String)this.jdField_a_of_type_JavaUtilHashMap.get("from"));
        localIntent.setFlags(67108864);
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      }
      else
      {
        if (!"phone".equals(this.c)) {
          break;
        }
        localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, PhoneUnityBindInfoActivity.class);
        localIntent.putExtra("from", "from_schema");
        localIntent.setFlags(67108864);
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QQSettingJumpAction
 * JD-Core Version:    0.7.0.1
 */