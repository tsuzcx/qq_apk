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
  
  protected Bundle a()
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str2 = (String)localEntry.getValue();
      if (!TextUtils.isEmpty(str2))
      {
        String str1 = str2;
        if (!((String)localEntry.getKey()).equals("src_type")) {
          str1 = c(str2);
        }
        localBundle.putString((String)localEntry.getKey(), str1);
      }
    }
    localBundle.putString("pkg_name", this.e);
    localBundle.putString("pkg_sig", this.f);
    return localBundle;
  }
  
  protected BasicSdkJumpInfo a()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("app_id");
    Object localObject = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("sdk_version"));
    if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(this.e))) {
      try
      {
        long l = Long.parseLong(str2);
        return new BasicSdkJumpInfo(l, (String)localObject, str1, this.e, this.f, str3, str4);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e("OpenSdkJumpAction", 1, "getBasicInfo: parse long error.", localNumberFormatException);
        return null;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getBasicInfo: appId/openId/src/pkgName is empty!");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append(" appId: ");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(" src=");
    ((StringBuilder)localObject).append(localNumberFormatException);
    QLog.e("OpenSdkJumpAction", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  protected void a()
  {
    BasicSdkJumpInfo localBasicSdkJumpInfo = a();
    if (localBasicSdkJumpInfo == null) {
      return;
    }
    AuthorityControlAppDetailsFragment.a(this.jdField_a_of_type_AndroidContentContext, new AuthoritySdkJumpInfo(localBasicSdkJumpInfo));
  }
  
  public boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doAction: action=");
    localStringBuilder.append(this.c);
    QLog.i("OpenSdkJumpAction", 1, localStringBuilder.toString());
    if ("join_group".equals(this.c))
    {
      b();
      return true;
    }
    if ("bind_group".equals(this.c))
    {
      c();
      return true;
    }
    if ("open_auth_manage".equals(this.c)) {
      a();
    }
    return true;
  }
  
  protected void b()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = a();
    localBundle.putInt("action", 3);
    localIntent.putExtra("key_params", localBundle);
    PublicFragmentActivity.Launcher.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicTransFragmentActivity.class, JoinTroopPreVerificationFragment.class);
  }
  
  protected void c()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = a();
    localBundle.putInt("action", 1);
    localIntent.putExtra("key_params", localBundle);
    PublicFragmentActivity.Launcher.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicTransFragmentActivity.class, BindTroopPreVerificationFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.OpenSdkJumpAction
 * JD-Core Version:    0.7.0.1
 */