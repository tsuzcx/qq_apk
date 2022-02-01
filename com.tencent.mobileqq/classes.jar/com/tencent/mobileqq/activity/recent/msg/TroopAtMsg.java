package com.tencent.mobileqq.activity.recent.msg;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopAtMsg
  extends AbstructRecentUserMsg
{
  private String i;
  
  public Object a(int paramInt, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    return null;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.a = paramArrayOfByte.getLong("uniseq");
      this.b = paramArrayOfByte.getLong("shmsgseq");
      this.c = paramArrayOfByte.getString("content");
      this.f = paramArrayOfByte.getInt("color");
      this.i = paramArrayOfByte.getString("senderUin");
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
  
  public TroopAtMsg b(String paramString)
  {
    this.i = paramString;
    return this;
  }
  
  public byte[] b()
  {
    return d();
  }
  
  public String c()
  {
    return this.i;
  }
  
  public byte[] d()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uniseq", this.a);
      localJSONObject.put("shmsgseq", this.b);
      localJSONObject.put("content", this.c);
      localJSONObject.put("color", this.f);
      localJSONObject.put("senderUin", this.i);
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
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.TroopAtMsg
 * JD-Core Version:    0.7.0.1
 */