import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.RecentUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

public class aqba
  extends aqbc
{
  public aqba(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_prompt");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_desc");
      }
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!bbbd.a(localRecentUser.uin)) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1005) && ((localRecentUser.getType() != 1006) || (a(aqas.h))) && (localRecentUser.getType() != 1009) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 0) || (!nbc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType())))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (k()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (l()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (m()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super.a(paramQQAppInterface, paramActivity);
    alta.a(paramQQAppInterface, this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_name"), this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_view"));
  }
  
  public boolean a()
  {
    super.a();
    e();
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct"))
    {
      d();
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    return true;
  }
  
  protected boolean a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = paramInt1;
    localSessionInfo.jdField_a_of_type_JavaLangString = paramString1;
    localSessionInfo.b = paramString2;
    if ((localSessionInfo.jdField_a_of_type_Int < 0) || (TextUtils.isEmpty(localSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
        bded.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false);
      }
      return false;
    }
    this.jdField_a_of_type_AndroidOsBundle.keySet();
    paramString2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_name");
    paramString1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_view");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_desc");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_ver");
    String str4 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_prompt");
    String str5 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_meta");
    String str6 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_config");
    String str7 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_compat");
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_list");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_text");
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)))
    {
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
        bded.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false);
      }
      return false;
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
      bded.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "0", "2000", "2006", "0", false);
    }
    paramString1 = new ArkAppMessage(str4, paramString2, (String)localObject2, paramString1, str3, str5, str6, str7);
    if (!TextUtils.isEmpty(str2)) {
      paramString1.mText = str2;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        i = ((JSONArray)localObject1).length();
        paramString1.mAppList = new ArrayList();
        paramInt1 = 0;
        if (paramInt1 < i)
        {
          str2 = ((JSONArray)localObject1).optString(paramInt1);
          if (TextUtils.isEmpty(str2)) {
            break label622;
          }
          localObject2 = new ArkAppMessage();
          ((ArkAppMessage)localObject2).fromAppXml(str2);
          paramString1.mAppList.add(localObject2);
        }
      }
      catch (Exception localException)
      {
        com.tencent.TMG.utils.QLog.e("ForwardOption.ForwardBaseOption", 1, "appList error");
      }
      paramString2 = (ArkAppMessage)alsx.a(2, paramString2, this.jdField_a_of_type_AndroidOsBundle, paramString1);
      if (paramString2 == null) {}
      for (;;)
      {
        paramString2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_appId_ark_from_sdk");
        String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_name");
        str2 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_action_data");
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_a_action_data");
        str3 = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_url");
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString1.appId = paramString2;
          paramString1.mSourceName = str1;
          paramString1.mSourceActionData = str2;
          paramString1.mSource_A_ActionData = ((String)localObject2);
          paramString1.mSourceUrl = str3;
        }
        i = this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID");
        paramInt1 = i;
        if (i == 0)
        {
          paramString2 = this.jdField_a_of_type_AndroidOsBundle.getIntArray("KEY_MSG_FORWARD_ID_ARRAY");
          paramInt1 = i;
          if (paramString2 != null) {
            if (paramString2.length <= paramInt2) {
              break label602;
            }
          }
        }
        for (paramInt1 = paramString2[paramInt2];; paramInt1 = i)
        {
          aaod.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, paramString1, paramInt1);
          return true;
          label602:
          ArkAppCenter.c("ArkApp", "ForwardArkMsgOption.sendArkMessage, forward array has not enough length");
        }
        paramString1 = paramString2;
      }
      label622:
      paramInt1 += 1;
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  protected boolean c()
  {
    if (f())
    {
      List localList = b();
      int i = 0;
      while (i < localList.size())
      {
        ResultRecord localResultRecord = (ResultRecord)localList.get(i);
        a(localResultRecord.jdField_a_of_type_JavaLangString, localResultRecord.a(), localResultRecord.c, i);
        i += 1;
      }
      return super.c();
    }
    d();
    return super.c();
  }
  
  protected void d()
  {
    super.d();
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_type");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_title");
    if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2))) {}
    do
    {
      return;
      axqw.b(null, "dc00898", "", "", "0X800A631", "0X800A631", 0, 0, str1, ForwardUtils.b(i), str2, "");
    } while (!com.tencent.qphone.base.util.QLog.isColorLevel());
    com.tencent.qphone.base.util.QLog.d("ForwardOption.ForwardBaseOption", 2, new Object[] { "ARK转发=0X800A631, type=", str1, ", uinType=", ForwardUtils.b(i), ", title=", str2 });
  }
  
  protected boolean d()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    return a(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), i, this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin"), 0);
  }
  
  public void e()
  {
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_name");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_h5_from_js");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_view");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      aloz.a(str1, str3, str2, new aqbb(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqba
 * JD-Core Version:    0.7.0.1
 */