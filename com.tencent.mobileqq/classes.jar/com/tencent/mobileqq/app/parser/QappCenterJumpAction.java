package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.open.appcommon.Common;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class QappCenterJumpAction
  extends JumpAction
{
  public QappCenterJumpAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean c()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" source:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("  serverName:");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append("  hostName:");
      ((StringBuilder)localObject1).append(this.c);
      QLog.d("Jumpaction", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.c.equals("index"))
    {
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppListActivity.class);
      ((Intent)localObject1).putExtra("goto_type", 1);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      return true;
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (this.c.equals("detail"))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(Common.g());
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append("qapp_center_detail.htm");
        localObject1 = ((StringBuilder)localObject1).toString();
        if (new File((String)localObject1).exists())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("file:///");
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(Common.m());
          ((StringBuilder)localObject1).append(File.separator);
          ((StringBuilder)localObject1).append("qapp_center_detail.htm");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppListActivity.class);
        localObject3 = new Bundle();
        localObject4 = Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("param");
        ((Bundle)localObject3).putString("APP_URL", (String)localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("&");
        ((StringBuilder)localObject1).append((String)localObject4);
        ((Bundle)localObject3).putString("APP_PARAMS", ((StringBuilder)localObject1).toString());
        ((Bundle)localObject3).putInt("goto_type", 2);
        ((Intent)localObject2).putExtras((Bundle)localObject3);
        ((Intent)localObject2).putExtra("adapter_action", "action_app_detail");
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
        return true;
      }
    }
    else if (this.c.equals("webview"))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppListActivity.class);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("APP_URL", Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("url"));
        ((Bundle)localObject2).putInt("goto_type", 3);
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        return true;
      }
    }
    else if ((this.c.equals("local")) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      localObject2 = Uri.parse(this.jdField_a_of_type_JavaLangString);
      localObject1 = ((Uri)localObject2).getQueryParameter("title");
      localObject3 = Common.a(((Uri)localObject2).getQueryParameter("url"));
      if (localObject3.length > 1)
      {
        localObject2 = localObject3[0];
        if ((((String)localObject2).startsWith("file://")) && ((((String)localObject2).contains(Common.g())) || (((String)localObject2).contains("android_asset/Page/system/"))))
        {
          localObject3 = localObject3[1];
          localObject4 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppListActivity.class);
          Bundle localBundle = new Bundle();
          localBundle.putString("APP_URL", (String)localObject2);
          localObject2 = new ArrayList();
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ((ArrayList)localObject2).add(localObject1);
          }
          localBundle.putStringArrayList("titleName", (ArrayList)localObject2);
          if ((localObject3 != null) && (((String)localObject3).length() > 0)) {
            localBundle.putString("APP_PARAMS", (String)localObject3);
          }
          localBundle.putInt("goto_type", 4);
          ((Intent)localObject4).putExtras(localBundle);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject4);
        }
      }
    }
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
      QLog.e("QappCenterJumpAction", 1, localStringBuilder.toString());
      b_("QappCenterJumpAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QappCenterJumpAction
 * JD-Core Version:    0.7.0.1
 */