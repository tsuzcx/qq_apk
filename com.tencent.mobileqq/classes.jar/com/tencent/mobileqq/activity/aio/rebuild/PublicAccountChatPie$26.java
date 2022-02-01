package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import org.json.JSONObject;

class PublicAccountChatPie$26
  implements HttpWebCgiAsyncTask.Callback
{
  PublicAccountChatPie$26(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject == null) {
      return;
    }
    if (paramJSONObject.optInt("retcode", -1) == 0)
    {
      paramJSONObject = (TroopBindPublicAccountMgr)this.a.d.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
      paramInt = paramJSONObject.b(this.a.ah.b);
      paramJSONObject.a(this.a.ah.b, 0, paramInt & 0xF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.26
 * JD-Core Version:    0.7.0.1
 */