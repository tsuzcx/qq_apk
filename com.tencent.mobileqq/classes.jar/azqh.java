import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;

public class azqh
  extends azqq
{
  public azqh(AbsShareMsg paramAbsShareMsg, QQAppInterface paramQQAppInterface, View paramView)
  {
    super(paramQQAppInterface, paramView);
  }
  
  public boolean a(Activity paramActivity, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = AbsShareMsg.parsePackageNameAndData(paramString2, paramString3)[0];
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "SourceClickHandler click2YYB  appid = " + paramLong + "; packageName=" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    paramString2 = new Bundle();
    paramString2.putString("packageName", paramString1);
    paramString2.putString("appId", paramLong + "");
    paramString2.putString("big_brother_source_key", "biz_src_jc_aio");
    bfei.b(paramActivity, paramString2);
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "SourceClickHandler clickWebMsg  url = " + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {
      return false;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("title", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName);
    localIntent.putExtra("url", paramString);
    syb.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.message, localIntent, paramString);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    azmj.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString, "", "", "");
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "SourceClickHandler clickAppMsg url = " + paramString1 + ", actionData = " + paramString2 + ", actionDataA = " + paramString3);
    }
    paramString1 = AbsShareMsg.parsePackageNameAndData(paramString2, paramString3);
    paramString2 = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
    try
    {
      if (paramString2.getPackageInfo(paramString1[0], 1) != null)
      {
        paramString2 = paramString2.getLaunchIntentForPackage(paramString1[0]);
        if (paramString2 == null) {
          return false;
        }
        paramString2.putExtra("big_brother_source_key", "biz_src_jc_aio");
        paramString2.addFlags(67108864);
        if (!TextUtils.isEmpty(paramString1[1])) {
          paramString2.setData(Uri.parse(paramString1[1]));
        }
        try
        {
          paramString3 = (alyh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(23);
          paramString2.putExtra("report_open_type", "structmsg_source");
          paramString2.putExtra("report_url", "");
          paramString2.putExtra("report_from", "1");
          paramString2.putExtra("report_click_origin", "AIOTail");
          paramString2.putExtra("report_class_name", this.jdField_a_of_type_AndroidContentContext.getClass().getName());
          paramString3.b(paramString1[0].trim(), this.jdField_a_of_type_AndroidContentContext, paramString2);
          return true;
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AppStartedHandler", 2, "<-- StartAppCheckHandler AbsShareMSG Failed!");
            }
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramString2);
          }
        }
      }
      return false;
    }
    catch (PackageManager.NameNotFoundException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, paramString1.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azqh
 * JD-Core Version:    0.7.0.1
 */