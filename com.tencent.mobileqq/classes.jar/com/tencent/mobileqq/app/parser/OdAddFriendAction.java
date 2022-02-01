package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class OdAddFriendAction
  extends JumpAction
{
  public OdAddFriendAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean c()
  {
    Object localObject = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("friendUin"));
    localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend((Activity)this.jdField_a_of_type_AndroidContentContext, 1, (String)localObject, "", 3001, 11, "", "", null, "", "");
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject);
    return true;
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = c();
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("OdAddFriendAction", 1, localStringBuilder.toString());
      b_("OdAddFriendAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.OdAddFriendAction
 * JD-Core Version:    0.7.0.1
 */