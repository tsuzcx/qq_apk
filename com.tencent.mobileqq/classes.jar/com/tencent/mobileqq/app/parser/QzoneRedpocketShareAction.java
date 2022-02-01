package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneShareManager;

public class QzoneRedpocketShareAction
  extends JumpAction
{
  public QzoneRedpocketShareAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean c()
  {
    String str1 = this.a.getCurrentUin();
    String str2 = this.a.getCurrentNickname();
    String str3 = QUA.getQUA3();
    QZoneShareManager.shareToQZoneForRedPocket(this.b, str1, null, 0, str2, str3);
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
      QLog.e("QzoneRedpocketShareAction", 1, localStringBuilder.toString());
      h_("QzoneRedpocketShareAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QzoneRedpocketShareAction
 * JD-Core Version:    0.7.0.1
 */