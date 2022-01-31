package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.qphone.base.util.QLog;

public class RecentItemNewFriendMsgData
  extends RecentUserBaseData
{
  private boolean c;
  int j = 0;
  
  public RecentItemNewFriendMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentItemNewFriendMsgData", 2, "RecentItemNewFriendMsgData update");
    }
    super.a(paramQQAppInterface, paramContext);
    NewFriendManager localNewFriendManager = (NewFriendManager)paramQQAppInterface.getManager(33);
    NewFriendMessage localNewFriendMessage = localNewFriendManager.a();
    this.b = paramContext.getString(this.j);
    if (localNewFriendMessage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentItemNewFriendMsgData", 2, "isFirstShow = " + this.jdField_c_of_type_Boolean);
      }
      this.jdField_c_of_type_JavaLangCharSequence = "";
      this.jdField_c_of_type_Int = 0;
      this.jdField_d_of_type_JavaLangCharSequence = "";
      this.a = 0L;
      this.jdField_c_of_type_JavaLangString = "";
      if (AppSetting.b)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(this.b).append(",");
        if (this.jdField_c_of_type_Int != 0) {
          break label300;
        }
      }
    }
    for (;;)
    {
      if (this.jdField_d_of_type_JavaLangCharSequence != null) {
        paramQQAppInterface.append(this.jdField_d_of_type_JavaLangCharSequence + ",");
      }
      paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence).append(",").append(this.jdField_c_of_type_JavaLangString);
      this.jdField_d_of_type_JavaLangString = paramQQAppInterface.toString();
      return;
      this.jdField_d_of_type_JavaLangCharSequence = "";
      if (localNewFriendMessage.a(paramQQAppInterface) != null) {}
      for (paramQQAppInterface = localNewFriendMessage.a(paramQQAppInterface);; paramQQAppInterface = this.jdField_c_of_type_JavaLangCharSequence)
      {
        this.jdField_c_of_type_JavaLangCharSequence = paramQQAppInterface;
        this.jdField_c_of_type_Int = localNewFriendManager.d();
        if (this.a < localNewFriendMessage.a) {
          this.a = localNewFriendMessage.a;
        }
        this.jdField_c_of_type_JavaLangString = TimeManager.a().a(a(), this.a);
        break;
      }
      label300:
      if (this.jdField_c_of_type_Int == 1) {
        paramQQAppInterface.append("有一条未读");
      } else if (this.jdField_c_of_type_Int == 2) {
        paramQQAppInterface.append("有两条未读");
      } else if (this.jdField_c_of_type_Int > 0) {
        paramQQAppInterface.append("有").append(this.jdField_c_of_type_Int).append("条未读,");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemNewFriendMsgData
 * JD-Core Version:    0.7.0.1
 */