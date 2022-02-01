package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AVGameShareEntryLobbyAction
  extends JumpAction
{
  public AVGameShareEntryLobbyAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      String str = (String)this.f.get("fromType");
      if ((str != null) && ("1".equals(str))) {
        ReportController.b(p(), "dc00898", "", "", "0X800B693", "0X800B693", 0, 0, "", "", "", "");
      }
      QPublicFragmentActivity.start(this.b, AVGameRoomCenterFragment.class);
      return true;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("AVGameShareEntryLobbyAction", 1, localStringBuilder.toString());
      h_("AVGameShareEntryLobbyAction");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.AVGameShareEntryLobbyAction
 * JD-Core Version:    0.7.0.1
 */