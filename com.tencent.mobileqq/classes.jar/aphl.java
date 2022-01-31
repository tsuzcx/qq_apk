import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class aphl
  extends apkd
{
  public aphl(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  private void e()
  {
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_name");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_h5_from_normal");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_view");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      alan.a(str1, str3, str2, new aphm(this));
    }
  }
  
  public boolean a()
  {
    e();
    m();
    return super.a();
  }
  
  protected boolean a(bafb parambafb)
  {
    if ((this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_ark_display_share")) && (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_from_h5_parse_meta_success"))) {}
    for (;;)
    {
      return true;
      super.a(parambafb);
    }
  }
  
  protected boolean a(String paramString1, String paramString2, int paramInt)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = paramInt;
    localSessionInfo.jdField_a_of_type_JavaLangString = paramString1;
    localSessionInfo.b = paramString2;
    if ((localSessionInfo.jdField_a_of_type_Int < 0) || (TextUtils.isEmpty(localSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
        bcad.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false);
      }
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_name");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_view");
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_meta");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_config");
    paramString2 = ArkAppCacheMgr.getApplicationFromManifest((String)localObject1, "0.0.0.1");
    paramString1 = null;
    if (paramString2 != null) {
      if (paramString2.containsKey("desc"))
      {
        paramString1 = (String)paramString2.get("desc");
        if (!paramString2.containsKey("version")) {
          break label276;
        }
        paramString2 = (String)paramString2.get("version");
      }
    }
    for (;;)
    {
      label188:
      if (TextUtils.isEmpty(paramString1)) {
        paramString1 = (String)localObject1;
      }
      for (;;)
      {
        String str3 = String.format(ajjy.a(2131638940), new Object[] { paramString1 });
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)))
        {
          if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
            bcad.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false);
          }
          return false;
          paramString1 = "";
          break;
          label276:
          paramString2 = "0.0.0.1";
          break label188;
        }
        if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
          bcad.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "0", false);
        }
        paramString1 = new ArkAppMessage(str3, (String)localObject1, paramString1, (String)localObject2, paramString2, str1, str2, "");
        paramString2 = (ArkAppMessage)alej.a(2, (String)localObject1, this.jdField_a_of_type_AndroidOsBundle, paramString1);
        if (paramString2 == null) {}
        for (;;)
        {
          localObject1 = awuw.a(this.jdField_a_of_type_AndroidOsBundle);
          paramString2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_appId_ark_from_sdk");
          localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_name");
          str1 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_action_data");
          str2 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_a_action_data_from_h5");
          str3 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_url");
          if (!TextUtils.isEmpty(paramString2))
          {
            paramString1.appId = paramString2;
            paramString1.mSourceName = ((String)localObject2);
            paramString1.mSourceActionData = str1;
            paramString1.mSource_A_ActionData = str2;
            paramString1.mSourceUrl = str3;
          }
          if (localObject1 != null) {
            switch (localSessionInfo.jdField_a_of_type_Int)
            {
            }
          }
          for (paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; paramString2 = localSessionInfo.b)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            str2 = localSessionInfo.jdField_a_of_type_JavaLangString;
            paramInt = localSessionInfo.jdField_a_of_type_Int;
            int i = avys.jdField_a_of_type_Int;
            avys.jdField_a_of_type_Int = i + 1;
            paramString1.containStructMsg = awbi.a((QQAppInterface)localObject2, str1, str2, paramString2, paramInt, i, (AbsStructMsg)localObject1);
            aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, paramString1);
            return true;
          }
          paramString1 = paramString2;
        }
      }
      paramString2 = "0.0.0.1";
    }
  }
  
  protected void d()
  {
    boolean bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_from_h5_success");
    boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_from_h5_parse_meta_success");
    QLog.d("ForwardOption.ForwardPluginShareStructMsgOption", 1, new Object[] { "ShareArkFromH5 before sendArkMag isUrlLegal=", Boolean.valueOf(bool1), ", isMetaLegal=", Boolean.valueOf(bool2) });
    if (f())
    {
      Iterator localIterator;
      if ((bool1) && (bool2))
      {
        E();
        localIterator = b().iterator();
      }
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        a(localResultRecord.jdField_a_of_type_JavaLangString, localResultRecord.c, localResultRecord.a());
        continue;
        super.d();
      }
      return;
    }
    if ((bool1) && (bool2))
    {
      E();
      f_();
      return;
    }
    super.d();
  }
  
  protected boolean f_()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    boolean bool = a(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin"), i);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aphl
 * JD-Core Version:    0.7.0.1
 */