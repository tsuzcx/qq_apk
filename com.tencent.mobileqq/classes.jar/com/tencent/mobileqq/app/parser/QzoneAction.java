package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.util.QzoneAuthorizeConfig;
import java.util.Map;

public class QzoneAction
  extends JumpAction
{
  public QzoneAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean c()
  {
    if (this.c != null)
    {
      if (!QzoneAuthorizeConfig.getInstance().hasSchemeRight(this.i, this.c))
      {
        QLog.e("QzoneAction", 1, "has no right to handle this schema");
        return false;
      }
      Intent localIntent2 = null;
      Object localObject;
      Intent localIntent1;
      if (this.c.startsWith("mqqzone"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mqzone");
        ((StringBuilder)localObject).append(this.c.substring(7));
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        String str = (String)URLUtil.a(this.c).get("schema");
        localObject = localIntent2;
        if (!TextUtils.isEmpty(str)) {
          try
          {
            localObject = new String(Base64.decode(str, 0), "utf-8");
          }
          catch (Exception localException)
          {
            QLog.e("QzoneAction", 1, localException, new Object[0]);
            localIntent1 = localIntent2;
          }
        }
      }
      if (!TextUtils.isEmpty(localIntent1))
      {
        localIntent2 = new Intent();
        localIntent2.putExtra("cmd", "Schema");
        localIntent2.putExtra("schema", localIntent1);
        if (i(localIntent1))
        {
          ((IWSManager)QRoute.api(IWSManager.class)).enterTrendsTabWs(this.b, "from_trends_tab", this.p, this.x, localIntent2);
          return true;
        }
        QZoneHelper.forwardToQzoneTransluentActivity((Activity)this.b, QZoneHelper.UserInfo.getInstance(), localIntent2);
        return true;
      }
      QLog.e("QzoneAction", 1, "gotoQzoneHandleSchema,schema=null");
      return true;
    }
    return false;
  }
  
  private boolean i(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("mqzone://arouse/normalvideolayer")) && (TextUtils.equals(j(paramString), "6"));
  }
  
  private String j(String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString).getQueryParameter("request_from");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
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
      QLog.e("QzoneAction", 1, localStringBuilder.toString());
      h_("QzoneAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QzoneAction
 * JD-Core Version:    0.7.0.1
 */