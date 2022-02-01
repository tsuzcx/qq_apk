package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class LightAppOpenAction
  extends JumpAction
{
  public LightAppOpenAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean c()
  {
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this.b, 0, 2131624257, 17);
    localQQProgressDialog.a(this.b.getString(2131887062));
    localQQProgressDialog.getWindow().setDimAmount(0.0F);
    localQQProgressDialog.show();
    localQQProgressDialog.setCanceledOnTouchOutside(true);
    String str1 = (String)this.f.get("app");
    if ((TextUtils.isEmpty(str1)) && (QLog.isColorLevel())) {
      QLog.e("LightAppOpenAction", 2, "Ark mqqapi://ligthapp/open goToLightAppOpen jumpAction. appName=null");
    }
    String str2 = (String)this.f.get("meta");
    String str3 = (String)this.f.get("view");
    ArkAppCenter localArkAppCenter = (ArkAppCenter)this.a.getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
    ArkAppMgr.getInstance().getAppPathByName(str1, "0.0.0.1", new LightAppOpenAction.1(this, localQQProgressDialog, str3, str2, str1));
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
      QLog.e("LightAppOpenAction", 1, localStringBuilder.toString());
      h_("LightAppOpenAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.LightAppOpenAction
 * JD-Core Version:    0.7.0.1
 */