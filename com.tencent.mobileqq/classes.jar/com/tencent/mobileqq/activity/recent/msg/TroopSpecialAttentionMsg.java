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

public class TroopSpecialAttentionMsg
  extends AbstructRecentUserMsg
  implements Cloneable
{
  private String i;
  
  public TroopSpecialAttentionMsg(Context paramContext)
  {
    this.c = HardCodeUtil.a(2131897589);
    this.d = this.c;
  }
  
  public Object a(int paramInt, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof TroopSpecialAttentionMsg))
    {
      paramObject = (TroopSpecialAttentionMsg)paramObject;
      paramObject.h.b(paramMessageInfo.c);
      return paramObject;
    }
    paramObject = new TroopSpecialAttentionMsg(BaseApplication.getContext());
    paramObject.a(paramMessageRecord.senderuin);
    paramObject.h = new MessageNavInfo(paramMessageInfo.c);
    return paramObject;
  }
  
  public void a(String paramString)
  {
    this.i = paramString;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    QLog.d("TroopSpecialAttentionMsg", 2, "deSerialize");
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.c = paramArrayOfByte.getString("content");
      this.e = paramArrayOfByte.getInt("time");
      this.f = paramArrayOfByte.getInt("color");
      this.g = paramArrayOfByte.getString("messageNavInfo");
      this.i = paramArrayOfByte.getString("senderUin");
      if ((this.g != null) && (this.g.length() != 0))
      {
        this.h.a(this.g);
        return;
      }
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public byte[] b()
  {
    return c();
  }
  
  public byte[] c()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("content", this.c);
      localJSONObject.put("time", this.e);
      localJSONObject.put("color", this.f);
      localJSONObject.put("senderUin", this.i);
      if (this.h != null) {
        this.g = this.h.b();
      }
      localJSONObject.put("messageNavInfo", this.g);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject.toString().getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.TroopSpecialAttentionMsg
 * JD-Core Version:    0.7.0.1
 */