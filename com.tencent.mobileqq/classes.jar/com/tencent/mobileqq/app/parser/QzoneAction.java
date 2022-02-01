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
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.util.QzoneAuthorizeConfig;
import java.util.Map;

public class QzoneAction
  extends JumpActionBase
{
  public QzoneAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (!QzoneAuthorizeConfig.getInstance().hasSchemeRight(this.e, this.jdField_a_of_type_JavaLangString))
      {
        QLog.e("QzoneAction", 1, "has no right to handle this schema");
        return false;
      }
      String str;
      Intent localIntent;
      if (this.jdField_a_of_type_JavaLangString.startsWith("mqqzone"))
      {
        str = "mqzone" + this.jdField_a_of_type_JavaLangString.substring("mqqzone".length());
        if (TextUtils.isEmpty(str)) {
          break label224;
        }
        localIntent = new Intent();
        localIntent.putExtra("cmd", "Schema");
        localIntent.putExtra("schema", str);
        if (!c(str)) {
          break label207;
        }
        ((IWSManager)QRoute.api(IWSManager.class)).enterTrendsTabWs(this.jdField_a_of_type_AndroidContentContext, "from_trends_tab", this.d, this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo, localIntent);
      }
      for (;;)
      {
        for (;;)
        {
          return true;
          str = (String)URLUtil.a(this.jdField_a_of_type_JavaLangString).get("schema");
          if (!TextUtils.isEmpty(str)) {
            try
            {
              str = new String(Base64.decode(str, 0), "utf-8");
            }
            catch (Exception localException)
            {
              QLog.e("QzoneAction", 1, localException, new Object[0]);
            }
          }
        }
        Object localObject = null;
        break;
        label207:
        QZoneHelper.forwardToQzoneTransluentActivity((Activity)this.jdField_a_of_type_AndroidContentContext, QZoneHelper.UserInfo.getInstance(), localIntent);
        continue;
        label224:
        QLog.e("QzoneAction", 1, "gotoQzoneHandleSchema,schema=null");
      }
    }
    return false;
  }
  
  private String a(String paramString)
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
  
  private boolean c(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("mqzone://arouse/normalvideolayer")) && (TextUtils.equals(a(paramString), "6"));
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
      QLog.e("QzoneAction", 1, "doAction error: " + localException.getMessage());
      a("QzoneAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QzoneAction
 * JD-Core Version:    0.7.0.1
 */