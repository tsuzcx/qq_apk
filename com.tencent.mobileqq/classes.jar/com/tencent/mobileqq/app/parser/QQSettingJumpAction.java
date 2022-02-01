package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.utils.JumpAction;
import java.util.HashMap;

public class QQSettingJumpAction
  extends JumpAction
{
  public QQSettingJumpAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    Intent localIntent;
    if ("general".equals(this.e))
    {
      localIntent = new Intent(this.b, GeneralSettingActivity.class);
      localIntent.addFlags(603979776);
      this.b.startActivity(localIntent);
    }
    else if ("deviceLock".equals(this.e))
    {
      localIntent = new Intent();
      localIntent.putExtra("from", (String)this.f.get("from"));
      localIntent.setFlags(67108864);
      RouteUtils.a(this.b, localIntent, "/base/safe/authDevActivity");
    }
    else
    {
      if (!"phone".equals(this.e)) {
        break label155;
      }
      localIntent = new Intent(this.b, PhoneUnityBindInfoActivity.class);
      localIntent.putExtra("from", "from_schema");
      localIntent.setFlags(67108864);
      this.b.startActivity(localIntent);
    }
    return true;
    label155:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QQSettingJumpAction
 * JD-Core Version:    0.7.0.1
 */