package com.tencent.mobileqq.ark.api.module;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.ark.ipc.IPCSyncMethodHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.Locale;

public class ArkQQAPIIPCModule$GetUserInformationHandler
  implements IPCSyncMethodHandler
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
  
  public String a()
  {
    return "QQ.GetUserInformation";
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
    Object localObject3 = ((FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a((String)localObject1);
    if (localObject3 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.GetUserInformationHandler", 2, "GetUserInformation FriendCard is null");
      }
      return null;
    }
    String str1 = ((Card)localObject3).strNick;
    int i = ((Card)localObject3).shGender;
    Object localObject2 = "";
    if (i == 0) {
      paramString = BaseActivity.sTopActivity.getString(2131693879);
    } else if (((Card)localObject3).shGender == 1) {
      paramString = BaseActivity.sTopActivity.getString(2131692259);
    } else {
      paramString = "";
    }
    String str2 = ((Card)localObject3).strCity;
    String str3 = ((Card)localObject3).strProvince;
    localObject3 = ((Card)localObject3).strCountry;
    localObject1 = localQQAppInterface.getQQHeadSettingFromDB((String)localObject1);
    if ((localObject1 != null) && (!TextUtils.isEmpty(((Setting)localObject1).url)))
    {
      localObject1 = MsfSdkUtils.insertMtype("QQHeadIcon", AvatarDownloadUtil.getQQAvatarDownLoadUrl(((Setting)localObject1).url, ((Setting)localObject1).bFaceFlags, ((Setting)localObject1).bUsrType, 0));
    }
    else
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("ArkApp.GetUserInformationHandler", 2, "GetUserInformation QQHeadSetting is empty");
        localObject1 = localObject2;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("GetUserInformation nickname=");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append(", avatarUrl=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", gender=");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(", city=");
      ((StringBuilder)localObject2).append(str2);
      ((StringBuilder)localObject2).append(", province=");
      ((StringBuilder)localObject2).append(str3);
      ((StringBuilder)localObject2).append(", country=");
      ((StringBuilder)localObject2).append((String)localObject3);
      QLog.d("ArkApp.GetUserInformationHandler", 2, ((StringBuilder)localObject2).toString());
    }
    return String.format(Locale.CHINA, "{\"nickname\":\"%s\",\"avatar\":\"%s\",\"gender\":\"%s\",\"city\":\"%s\",\"province\":\"%s\",\"country\":\"%s\"}", new Object[] { str1, localObject1, paramString, str2, str3, localObject3 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.GetUserInformationHandler
 * JD-Core Version:    0.7.0.1
 */