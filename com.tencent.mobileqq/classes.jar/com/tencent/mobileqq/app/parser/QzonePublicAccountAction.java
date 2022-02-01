package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.contentbox.QZoneMsgActivity;

public class QzonePublicAccountAction
  extends JumpActionBase
{
  public QzonePublicAccountAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    if (this.a == null) {
      return false;
    }
    long l = QZoneHelper.enableQZoneContentBoxMiniProgram();
    if (l != 0L) {
      QZoneMsgActivity.launchContentBoxMiniProgram(l, this.a);
    }
    for (;;)
    {
      return true;
      Intent localIntent = new Intent(this.a, QZoneMsgActivity.class);
      localIntent.addFlags(67108864);
      this.a.startActivity(localIntent);
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = C();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QzonePublicAccountAction", 1, "doAction error: " + localException.getMessage());
      a("QzonePublicAccountAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QzonePublicAccountAction
 * JD-Core Version:    0.7.0.1
 */