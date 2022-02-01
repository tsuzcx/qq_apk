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
      ((StringBuilder)localObject1).append(this.c);
      ((StringBuilder)localObject1).append("  serverName:");
      ((StringBuilder)localObject1).append(this.d);
      ((StringBuilder)localObject1).append("  hostName:");
      ((StringBuilder)localObject1).append(this.e);
      QLog.d("Jumpaction", 2, ((StringBuilder)localObject1).toString());
    }
    if (TextUtils.isEmpty(this.e))
    {
      QLog.e("QappCenterJumpAction", 1, "gotoQAppcenter error: action_name is empty");
      return false;
    }
    if (this.e.equals("index"))
    {
      localObject1 = new Intent(this.b, QZoneAppListActivity.class);
      ((Intent)localObject1).putExtra("goto_type", 1);
      this.b.startActivity((Intent)localObject1);
      return true;
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (this.e.equals("detail"))
    {
      if (!TextUtils.isEmpty(this.c))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(Common.h());
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
          ((StringBuilder)localObject1).append(Common.o());
          ((StringBuilder)localObject1).append(File.separator);
          ((StringBuilder)localObject1).append("qapp_center_detail.htm");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = new Intent(this.b, QZoneAppListActivity.class);
        localObject3 = new Bundle();
        localObject4 = Uri.parse(this.c).getQueryParameter("param");
        ((Bundle)localObject3).putString("APP_URL", (String)localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("&");
        ((StringBuilder)localObject1).append((String)localObject4);
        ((Bundle)localObject3).putString("APP_PARAMS", ((StringBuilder)localObject1).toString());
        ((Bundle)localObject3).putInt("goto_type", 2);
        ((Intent)localObject2).putExtras((Bundle)localObject3);
        ((Intent)localObject2).putExtra("adapter_action", "action_app_detail");
        this.b.startActivity((Intent)localObject2);
        return true;
      }
    }
    else if (this.e.equals("webview"))
    {
      if (!TextUtils.isEmpty(this.c))
      {
        localObject1 = new Intent(this.b, QZoneAppListActivity.class);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("APP_URL", Uri.parse(this.c).getQueryParameter("url"));
        ((Bundle)localObject2).putInt("goto_type", 3);
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        this.b.startActivity((Intent)localObject1);
        return true;
      }
    }
    else if ((this.e.equals("local")) && (!TextUtils.isEmpty(this.c)))
    {
      localObject2 = Uri.parse(this.c);
      localObject1 = ((Uri)localObject2).getQueryParameter("title");
      localObject3 = Common.a(((Uri)localObject2).getQueryParameter("url"));
      if (localObject3.length > 1)
      {
        localObject2 = localObject3[0];
        if ((((String)localObject2).startsWith("file://")) && ((((String)localObject2).contains(Common.h())) || (((String)localObject2).contains("android_asset/Page/system/"))))
        {
          localObject3 = localObject3[1];
          localObject4 = new Intent(this.b, QZoneAppListActivity.class);
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
          this.b.startActivity((Intent)localObject4);
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
      h_("QappCenterJumpAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QappCenterJumpAction
 * JD-Core Version:    0.7.0.1
 */