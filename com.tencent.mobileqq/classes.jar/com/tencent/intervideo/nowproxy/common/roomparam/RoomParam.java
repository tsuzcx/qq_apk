package com.tencent.intervideo.nowproxy.common.roomparam;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.intervideo.nowproxy.InitData;
import com.tencent.intervideo.nowproxy.common.login.LoginData;

public class RoomParam
{
  public static int getClientType(int paramInt)
  {
    return paramInt * 16 + 2;
  }
  
  public static Bundle getEnterRoomParam(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("roomid", String.valueOf(paramLong));
    localBundle.putString("vid", paramString1);
    localBundle.putString("fromid", paramString2);
    localBundle.putInt("first", paramInt);
    return localBundle;
  }
  
  public static Bundle getRoomInitParam(InitData paramInitData)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", paramInitData.mAppID);
    localBundle.putString("hostVersion", paramInitData.mSourceVersion);
    localBundle.putString("clientType", String.valueOf(paramInitData.mClientType));
    if (!TextUtils.isEmpty(paramInitData.mGuid)) {
      localBundle.putString("guid", paramInitData.mGuid);
    }
    if (!TextUtils.isEmpty(paramInitData.mQUA)) {
      localBundle.putString("qua", paramInitData.mQUA);
    }
    if (!TextUtils.isEmpty(paramInitData.mQBID)) {
      localBundle.putString("qbid", paramInitData.mQBID);
    }
    if (!TextUtils.isEmpty(paramInitData.mSourceUid)) {
      localBundle.putString("uid", paramInitData.mSourceUid);
    }
    return localBundle;
  }
  
  public static Bundle getRoomLoginTicket(LoginData paramLoginData)
  {
    Bundle localBundle = new Bundle();
    if (paramLoginData == null) {
      return localBundle;
    }
    localBundle = LoginData.getLoginBundle(paramLoginData);
    localBundle.putString("uid", paramLoginData.getUserId());
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.common.roomparam.RoomParam
 * JD-Core Version:    0.7.0.1
 */