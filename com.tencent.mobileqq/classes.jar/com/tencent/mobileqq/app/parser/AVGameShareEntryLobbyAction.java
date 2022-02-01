package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AVGameShareEntryLobbyAction
  extends JumpActionBase
{
  public AVGameShareEntryLobbyAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromType");
      if ((str != null) && (str.equals("1"))) {
        ReportController.b(a(), "dc00898", "", "", "0X800B693", "0X800B693", 0, 0, "", "", "", "");
      }
      PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, AVGameRoomCenterFragment.class);
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("AVGameShareEntryLobbyAction", 1, "doAction error: " + localException.getMessage());
      a("AVGameShareEntryLobbyAction");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.AVGameShareEntryLobbyAction
 * JD-Core Version:    0.7.0.1
 */