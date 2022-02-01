package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqconnectface.IIdentificationApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class IdentifierWebJumpAction
  extends JumpAction
{
  public IdentifierWebJumpAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      String str = h((String)this.f.get("url"));
      if ((!TextUtils.isEmpty((CharSequence)this.f.get("appid"))) && (!TextUtils.isEmpty((CharSequence)this.f.get("openid"))))
      {
        ReportController.b(this.a, "dc00898", "", "", "0X80097E8", "0X80097E8", 0, 0, "", "", (String)this.f.get("appid"), "");
        ((IIdentificationApi)QRoute.api(IIdentificationApi.class)).preResDownload();
        localObject = new Intent(this.b, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", str);
        this.b.startActivity((Intent)localObject);
        return true;
      }
      QLog.e("IdentifierWebJumpAction", 1, "identification with illegal params");
      return true;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doAction error: ");
      ((StringBuilder)localObject).append(localException.getMessage());
      QLog.e("IdentifierWebJumpAction", 1, ((StringBuilder)localObject).toString());
      h_("IdentifierWebJumpAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.IdentifierWebJumpAction
 * JD-Core Version:    0.7.0.1
 */