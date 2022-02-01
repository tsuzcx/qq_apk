package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ContactAddAction
  extends JumpAction
{
  public ContactAddAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = b();
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("ContactAddAction", 1, localStringBuilder.toString());
      b_("ContactAddAction");
    }
    return false;
  }
  
  public boolean b()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AddContactsActivity.class);
    localIntent.setFlags(67108864);
    int j = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("des_type"));
    int i = j;
    if (j != 0)
    {
      i = j;
      if (j != 1)
      {
        i = j;
        if (j != 2) {
          i = 0;
        }
      }
    }
    localIntent.putExtra("tab_index_key", i);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.ContactAddAction
 * JD-Core Version:    0.7.0.1
 */