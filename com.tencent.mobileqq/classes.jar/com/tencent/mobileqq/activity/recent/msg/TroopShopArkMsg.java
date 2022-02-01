package com.tencent.mobileqq.activity.recent.msg;

import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopShopArkMsg
  extends AbstructRecentUserMsg
{
  public TroopShopArkMsg(Context paramContext)
  {
    paramContext = new StringBuilder();
    paramContext.append("[");
    paramContext.append(HardCodeUtil.a(2131897565));
    paramContext.append("]");
    this.c = paramContext.toString();
    this.d = this.c;
  }
  
  public Object a(int paramInt, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof TroopShopArkMsg))
    {
      paramObject = (TroopShopArkMsg)paramObject;
      paramObject.h.b(paramMessageInfo.c);
      return paramObject;
    }
    paramObject = new TroopShopArkMsg(BaseApplication.getContext());
    paramObject.h = new MessageNavInfo(paramMessageInfo.c);
    return paramObject;
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
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uniseq", this.a);
      localJSONObject.put("shmsgseq", this.b);
      localJSONObject.put("content", this.c);
      localJSONObject.put("color", this.f);
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
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.TroopShopArkMsg
 * JD-Core Version:    0.7.0.1
 */