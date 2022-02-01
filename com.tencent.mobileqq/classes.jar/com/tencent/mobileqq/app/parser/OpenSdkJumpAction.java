package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.open.agent.AuthorityControlAppDetailsFragment;
import com.tencent.open.agent.BindTroopPreVerificationFragment;
import com.tencent.open.agent.JoinTroopPreVerificationFragment;
import com.tencent.open.sdk.data.AuthoritySdkJumpInfo;
import com.tencent.open.sdk.data.BasicSdkJumpInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class OpenSdkJumpAction
  extends JumpAction
{
  public OpenSdkJumpAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doAction: action=");
    localStringBuilder.append(this.e);
    QLog.i("OpenSdkJumpAction", 1, localStringBuilder.toString());
    if ("join_group".equals(this.e))
    {
      d();
      return true;
    }
    if ("bind_group".equals(this.e))
    {
      e();
      return true;
    }
    if ("open_auth_manage".equals(this.e)) {
      b();
    }
    return true;
  }
  
  protected void b()
  {
    BasicSdkJumpInfo localBasicSdkJumpInfo = c();
    if (localBasicSdkJumpInfo == null) {
      return;
    }
    AuthorityControlAppDetailsFragment.a(this.b, new AuthoritySdkJumpInfo(localBasicSdkJumpInfo));
  }
  
  protected BasicSdkJumpInfo c()
  {
    String str1 = (String)this.f.get("src_type");
    String str2 = (String)this.f.get("app_id");
    Object localObject = h((String)this.f.get("open_id"));
    String str3 = h((String)this.f.get("app_name"));
    String str4 = h((String)this.f.get("sdk_version"));
    if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(this.i))) {
      try
      {
        long l = Long.parseLong(str2);
        return new BasicSdkJumpInfo(l, (String)localObject, str1, this.i, this.j, str3, str4);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e("OpenSdkJumpAction", 1, "getBasicInfo: parse long error.", localNumberFormatException);
        return null;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getBasicInfo: appId/openId/src/pkgName is empty!");
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append(" appId: ");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(" src=");
    ((StringBuilder)localObject).append(localNumberFormatException);
    QLog.e("OpenSdkJumpAction", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  protected void d()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = f();
    localBundle.putInt("action", 3);
    localIntent.putExtra("key_params", localBundle);
    PublicFragmentActivity.Launcher.a(this.b, localIntent, PublicTransFragmentActivity.class, JoinTroopPreVerificationFragment.class);
  }
  
  protected void e()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = f();
    localBundle.putInt("action", 1);
    localIntent.putExtra("key_params", localBundle);
    PublicFragmentActivity.Launcher.a(this.b, localIntent, PublicTransFragmentActivity.class, BindTroopPreVerificationFragment.class);
  }
  
  protected Bundle f()
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.f.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str2 = (String)localEntry.getValue();
      if (!TextUtils.isEmpty(str2))
      {
        String str1 = str2;
        if (!((String)localEntry.getKey()).equals("src_type")) {
          str1 = h(str2);
        }
        localBundle.putString((String)localEntry.getKey(), str1);
      }
    }
    localBundle.putString("pkg_name", this.i);
    localBundle.putString("pkg_sig", this.j);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.OpenSdkJumpAction
 * JD-Core Version:    0.7.0.1
 */