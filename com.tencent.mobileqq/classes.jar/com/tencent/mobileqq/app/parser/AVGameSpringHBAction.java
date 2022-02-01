package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.avgame.business.AvGameManager;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AVGameSpringHBAction
  extends JumpActionBase
{
  public AVGameSpringHBAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private long a()
  {
    return System.currentTimeMillis() / 1000L;
  }
  
  private long a(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      QLog.e("AVGameSpringHBAction", 1, "[parseTimeToLong] ", paramString);
    }
    return 0L;
  }
  
  private void a()
  {
    PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, AVGameRoomCenterFragment.class);
  }
  
  private void a(String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    AvGameManager localAvGameManager = (AvGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if (localAvGameManager == null)
    {
      QLog.d("AVGameSpringHBAction", 1, "[jumpGameRoom] error: manager is null.");
      return;
    }
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      QLog.d("AVGameSpringHBAction", 1, "[jumpGameRoom] error: context is not instanceof Activity.");
      return;
    }
    try
    {
      int i = Integer.parseInt(paramString1);
      localAvGameManager.a((Activity)this.jdField_a_of_type_AndroidContentContext, i, paramBoolean, paramInt, paramString2);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      QLog.e("AVGameSpringHBAction", 1, "[jumpGameRoom] error: ", paramString1);
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    long l1 = a();
    long l2 = a(paramString1);
    long l3 = a(paramString2);
    if ((l2 == 0L) || (l3 == 0L)) {}
    while ((l1 < l2) || (l1 >= l3)) {
      return false;
    }
    return true;
  }
  
  public boolean a()
  {
    return a(1);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("pkid");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("starttime");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("endtime");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("iscj");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromtype");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    try
    {
      if (!TextUtils.isEmpty(str6))
      {
        i = Integer.valueOf(str6).intValue();
        if ((str4 != null) && (Integer.parseInt(str4) == 1))
        {
          bool1 = true;
          if (paramInt != 2) {
            break label230;
          }
          paramInt = 1;
          if (QLog.isColorLevel()) {
            QLog.d("AVGameSpringHBAction", 2, new Object[] { "[doAction] pkID: ", str1, ", startTime: ", str2, ", endTime: ", str3, ",sourceValue: ", Integer.valueOf(i) });
          }
          if (!a(str2, str3)) {
            break label235;
          }
          a(str1, bool1, i, str5);
          bool1 = true;
          return bool1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        int i = 0;
        continue;
        boolean bool1 = false;
        continue;
        label230:
        paramInt = 0;
        continue;
        label235:
        bool1 = bool2;
        if (paramInt == 0)
        {
          a();
          continue;
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.AVGameSpringHBAction
 * JD-Core Version:    0.7.0.1
 */