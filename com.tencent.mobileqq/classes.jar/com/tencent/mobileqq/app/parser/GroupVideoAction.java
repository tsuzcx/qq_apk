package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class GroupVideoAction
  extends JumpActionBase
{
  public GroupVideoAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomcode");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("isgroupcode");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("backtype");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("open_type");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extra");
    GroupVideoManager localGroupVideoManager = (GroupVideoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER);
    try
    {
      i = Integer.parseInt(str3);
      QLog.i("GroupVideoAction", 1, "[goToGroupVideoPlugin], roomId:" + str1 + ",fromId:" + str2 + " isGroupCode:" + str3);
      localGroupVideoManager.a(this.jdField_a_of_type_AndroidContentContext, str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), i, "download", str2, str4, str5, str6);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 1;
      }
    }
  }
  
  private boolean D()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
    localObject = (GroupVideoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER);
    QLog.i("GroupVideoAction", 1, "[goToPreLoadGroupVideoPlugin]");
    ((GroupVideoManager)localObject).a(null, 10L);
    return true;
  }
  
  public boolean a()
  {
    try
    {
      if ("openroom".equals(this.c)) {
        return C();
      }
      if ("preload".equals(this.c))
      {
        boolean bool = D();
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e("GroupVideoAction", 1, "doAction error: " + localException.getMessage());
      a("GroupVideoAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.GroupVideoAction
 * JD-Core Version:    0.7.0.1
 */