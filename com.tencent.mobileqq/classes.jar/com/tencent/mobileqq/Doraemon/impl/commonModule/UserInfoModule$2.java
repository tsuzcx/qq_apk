package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb6e.Oidb_0xb6e.AppFriendsInfo;
import tencent.im.oidb.cmd0xb6e.Oidb_0xb6e.RspBody;

class UserInfoModule$2
  extends ProtoUtils.TroopProtocolObserver
{
  UserInfoModule$2(UserInfoModule paramUserInfoModule, APICallback paramAPICallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      paramBundle = UserInfoModule.b;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onResult appid=");
      ((StringBuilder)localObject1).append(UserInfoModule.a(this.b).b);
      ((StringBuilder)localObject1).append(", openid=");
      ((StringBuilder)localObject1).append(this.b.c.a);
      ((StringBuilder)localObject1).append(", openkey=");
      ((StringBuilder)localObject1).append(this.b.c.b);
      ((StringBuilder)localObject1).append(", code=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.i(paramBundle, 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new Oidb_0xb6e.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = paramBundle;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
      }
      if (paramArrayOfByte != null)
      {
        paramBundle = new JSONObject();
        localObject1 = new JSONArray();
        paramArrayOfByte = paramArrayOfByte.rpt_friends_info.get().iterator();
        while (paramArrayOfByte.hasNext())
        {
          Object localObject2 = (Oidb_0xb6e.AppFriendsInfo)paramArrayOfByte.next();
          String str1 = ((Oidb_0xb6e.AppFriendsInfo)localObject2).openid.get();
          String str2 = ((Oidb_0xb6e.AppFriendsInfo)localObject2).nick.get().toStringUtf8();
          localObject2 = ((Oidb_0xb6e.AppFriendsInfo)localObject2).figure_url_qq.get();
          if (!TextUtils.isEmpty(str1))
          {
            try
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("openid", str1.toUpperCase());
              localJSONObject.put("nickName", str2);
              localJSONObject.put("avatarUrl", localObject2);
              ((JSONArray)localObject1).put(localJSONObject);
            }
            catch (JSONException localJSONException) {}
            if (QLog.isColorLevel()) {
              QLog.e(UserInfoModule.b, 2, localJSONException.getMessage(), localJSONException);
            }
          }
        }
        try
        {
          paramBundle.put("appfriends", localObject1);
        }
        catch (JSONException paramArrayOfByte)
        {
          if (QLog.isColorLevel()) {
            QLog.e(UserInfoModule.b, 2, paramArrayOfByte.getMessage(), paramArrayOfByte);
          }
        }
        DoraemonUtil.a(this.a, paramBundle);
        return;
      }
      DoraemonUtil.a(this.a, -1, "parse result error, try again");
      return;
    }
    DoraemonUtil.a(this.a, paramInt, "getappfriends result error, try again");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule.2
 * JD-Core Version:    0.7.0.1
 */