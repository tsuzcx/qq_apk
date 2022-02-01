package com.tencent.gamecenter.wadl.api.impl;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterBroadcastReceiver;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;

class QQGameCheckServiceImpl$1
  implements Runnable
{
  QQGameCheckServiceImpl$1(QQGameCheckServiceImpl paramQQGameCheckServiceImpl, int paramInt) {}
  
  public void run()
  {
    Object localObject3 = GameCenterSpUtils.a("APPOINTMENT_LIST");
    Object localObject4 = GameCenterSpUtils.a("DELAY_LIST");
    Object localObject2 = GameCenterSpUtils.a("APPOINTMENT_UPDATE_LIST");
    Object localObject1 = GameCenterSpUtils.a("APPOINTMENT_TGPA_LIST");
    if ((TextUtils.isEmpty((CharSequence)localObject3)) && (TextUtils.isEmpty((CharSequence)localObject4)) && (TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty((CharSequence)localObject1)))
    {
      QLog.d("Wadl_QQGameCheckServiceImpl", 1, "checkGameCenter no task, unRegisterReceiver");
      GameCenterBroadcastReceiver.b();
      return;
    }
    GameCenterUtil.a();
    if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (GameCenterUtil.b))
    {
      localObject4 = ((String)localObject4).split("\\|");
      QQGameCheckServiceImpl.access$000(this.this$0, this.a, (String[])localObject4);
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (GameCenterUtil.c))
    {
      localObject3 = ((String)localObject3).split("\\|");
      QQGameCheckServiceImpl.access$100(this.this$0, this.a, (String[])localObject3);
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (GameCenterUtil.d)) {
      try
      {
        localObject2 = new JSONArray((String)localObject2);
        QQGameCheckServiceImpl.access$200(this.this$0, (JSONArray)localObject2);
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        QQGameCheckServiceImpl.access$300(this.this$0, (JSONArray)localObject1);
        return;
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameCheckServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */