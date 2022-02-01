package com.tencent.mobileqq.ark.API;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.Locale;

public class ArkQQAPIIPCModule$GetUserInformationHandler
  implements ArkQQAPIIPCModule.IPCSyncMethodHandler
{
  public EIPCResult a(Bundle paramBundle)
  {
    Object localObject = ArkQQAPIIPCModule.a();
    if (localObject == null)
    {
      QLog.e("ArkApp.GetUserInformationHandler", 1, "Handler_GetNickName.onCall, qq app is null");
      return EIPCResult.createResult(-102, new Bundle());
    }
    localObject = paramBundle.getString("uin", ((QQAppInterface)localObject).getCurrentAccountUin());
    paramBundle = new Bundle();
    localObject = a((String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramBundle.putString("userInfo", (String)localObject);
    }
    return EIPCResult.createResult(0, paramBundle);
  }
  
  public String a(String paramString)
  {
    QQAppInterface localQQAppInterface = ArkQQAPIIPCModule.a();
    if (localQQAppInterface == null) {
      return null;
    }
    Object localObject1 = paramString;
    if (paramString == null) {
      localObject1 = localQQAppInterface.getCurrentUin();
    }
    Object localObject2 = ((FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a((String)localObject1);
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.GetUserInformationHandler", 2, "GetUserInformation FriendCard is null");
      }
      return null;
    }
    String str1 = ((Card)localObject2).strNick;
    paramString = "";
    String str2;
    String str3;
    String str4;
    if (((Card)localObject2).shGender == 0)
    {
      paramString = BaseActivity.sTopActivity.getString(2131693923);
      str2 = ((Card)localObject2).strCity;
      str3 = ((Card)localObject2).strProvince;
      str4 = ((Card)localObject2).strCountry;
      localObject2 = "";
      localObject1 = localQQAppInterface.getQQHeadSettingFromDB((String)localObject1);
      if ((localObject1 == null) || (TextUtils.isEmpty(((Setting)localObject1).url))) {
        break label291;
      }
      localObject1 = MsfSdkUtils.insertMtype("QQHeadIcon", AvatarDownloadUtil.getQQAvatarDownLoadUrl(((Setting)localObject1).url, ((Setting)localObject1).bFaceFlags, ((Setting)localObject1).bUsrType, 0));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.GetUserInformationHandler", 2, "GetUserInformation nickname=" + str1 + ", avatarUrl=" + (String)localObject1 + ", gender=" + paramString + ", city=" + str2 + ", province=" + str3 + ", country=" + str4);
      }
      return String.format(Locale.CHINA, "{\"nickname\":\"%s\",\"avatar\":\"%s\",\"gender\":\"%s\",\"city\":\"%s\",\"province\":\"%s\",\"country\":\"%s\"}", new Object[] { str1, localObject1, paramString, str2, str3, str4 });
      if (((Card)localObject2).shGender != 1) {
        break;
      }
      paramString = BaseActivity.sTopActivity.getString(2131692330);
      break;
      label291:
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("ArkApp.GetUserInformationHandler", 2, "GetUserInformation QQHeadSetting is empty");
        localObject1 = localObject2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkQQAPIIPCModule.GetUserInformationHandler
 * JD-Core Version:    0.7.0.1
 */