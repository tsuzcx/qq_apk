package com.tencent.intervideo.nowproxy;

import com.tencent.intervideo.nowproxy.baseability.ticket.UnifyAccountMgr.IExchangeCallback;
import com.tencent.intervideo.nowproxy.common.log.XLog;
import com.tencent.intervideo.nowproxy.common.login.AccountInfo;
import com.tencent.intervideo.nowproxy.common.login.LoginData;
import com.tencent.intervideo.nowproxy.common.login.LoginObserver;
import com.tencent.intervideo.nowproxy.common.login.NowLoginInfo;
import org.json.JSONObject;

class NowRoomEntry$1
  implements UnifyAccountMgr.IExchangeCallback
{
  NowRoomEntry$1(NowRoomEntry paramNowRoomEntry, AccountInfo paramAccountInfo, int paramInt, boolean paramBoolean, LoginData paramLoginData) {}
  
  public void onAccountInfoRecv(JSONObject paramJSONObject)
  {
    NowLoginInfo localNowLoginInfo = new NowLoginInfo();
    long l1 = paramJSONObject.optLong("tiny_id");
    String str = paramJSONObject.optString("a2");
    long l2 = paramJSONObject.optLong("uid");
    localNowLoginInfo.ilive_a2 = str;
    localNowLoginInfo.ilive_tinyid = String.valueOf(l1);
    localNowLoginInfo.appid = this.this$0.mInitData.mAppID;
    localNowLoginInfo.__client_type = String.valueOf(Integer.valueOf(this.this$0.mInitData.mAppID).intValue() * 16 + 2);
    localNowLoginInfo.ilive_uin = l2;
    localNowLoginInfo.lastLoginTime = System.currentTimeMillis();
    localNowLoginInfo.loginType = this.val$accountInfo.login_type;
    Global.sNowLoginInfo = localNowLoginInfo;
    if (this.this$0.mLoginObserver != null) {
      this.this$0.mLoginObserver.onGetNowTicket(this.val$source, 0, localNowLoginInfo);
    }
    if (this.val$notifyPlugin) {
      this.this$0.enterPluginManager(3, LoginData.getLoginBundle(this.val$loginData));
    }
  }
  
  public void onError(int paramInt)
  {
    XLog.e("NowPluginManager | NowRoomEntry", "exChangeTicket error, code=" + paramInt);
    if (this.this$0.mLoginObserver != null) {
      this.this$0.mLoginObserver.onGetNowTicket(this.val$source, paramInt, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.NowRoomEntry.1
 * JD-Core Version:    0.7.0.1
 */