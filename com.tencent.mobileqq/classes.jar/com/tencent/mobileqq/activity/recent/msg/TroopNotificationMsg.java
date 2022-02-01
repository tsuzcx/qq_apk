package com.tencent.mobileqq.activity.recent.msg;

import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopNotificationMsg
  extends AbstructRecentUserMsg
  implements Cloneable
{
  public int i;
  
  public TroopNotificationMsg(Context paramContext, boolean paramBoolean)
  {
    this.c = HardCodeUtil.a(2131917246);
    if (paramBoolean) {
      this.c = HardCodeUtil.a(2131917247);
    }
    this.d = this.c;
  }
  
  public Object a(int paramInt, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (paramInt == 28)
    {
      paramMessageInfo = new TroopNotificationMsg(BaseApplication.getContext(), false);
      paramMessageInfo.i = 1;
      return paramMessageInfo;
    }
    if ((paramObject instanceof TroopNotificationMsg))
    {
      paramObject = (TroopNotificationMsg)paramObject;
      paramObject.h.b(paramMessageInfo.c);
      return paramObject;
    }
    paramObject = new TroopNotificationMsg(BaseApplication.getContext(), false);
    paramObject.h = new MessageNavInfo(paramMessageInfo.c);
    return paramObject;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TroopNotificationMsg.class.getSimpleName(), 2, "deSerialize");
    }
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.c = paramArrayOfByte.getString("remindText");
      this.f = paramArrayOfByte.getInt("color");
      this.i = paramArrayOfByte.getInt("ctl_flag");
      if (this.h == null) {
        this.h = new MessageNavInfo();
      }
      this.h.a(paramArrayOfByte.getString("messageNavInfo"));
      return;
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public byte[] b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TroopNotificationMsg.class.getSimpleName(), 2, "serialize");
    }
    return c();
  }
  
  public byte[] c()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("remindText", this.c);
      localJSONObject.put("color", this.f);
      localJSONObject.put("ctl_flag", this.i);
      if (this.h != null) {
        localJSONObject.put("messageNavInfo", this.h.b());
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject.toString().getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.TroopNotificationMsg
 * JD-Core Version:    0.7.0.1
 */