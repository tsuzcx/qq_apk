package com.tencent.mobileqq.activity.recent.msg;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.api.INearbyFlowerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopReceivedFlowsersMsg
  extends AbstructRecentUserMsg
{
  public boolean i = false;
  
  public TroopReceivedFlowsersMsg(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public TroopReceivedFlowsersMsg(Context paramContext, boolean paramBoolean)
  {
    this.c = HardCodeUtil.a(2131895460);
    this.d = this.c;
    this.i = paramBoolean;
  }
  
  public Object a(int paramInt, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    boolean bool = ((INearbyFlowerUtil)QRoute.api(INearbyFlowerUtil.class)).isNearbyFlowerMsg(paramMessageRecord);
    if ((paramMessageRecord.msgtype != -2035) && (paramMessageRecord.msgtype != -2038) && (!bool)) {
      return null;
    }
    if (bool)
    {
      if ((paramObject instanceof TroopReceivedFlowsersMsg))
      {
        paramObject = (TroopReceivedFlowsersMsg)paramObject;
        paramObject.h.b(paramMessageInfo.c);
        return paramObject;
      }
      paramObject = new TroopReceivedFlowsersMsg(BaseApplication.getContext());
      paramObject.h = new MessageNavInfo(paramMessageInfo.c);
      return paramObject;
    }
    if ((paramMessageRecord instanceof MessageForDeliverGiftTips))
    {
      paramQQAppInterface = (MessageForDeliverGiftTips)paramMessageRecord;
      paramInt = 1;
      int j = 1;
      if ((paramObject instanceof TroopReceivedFlowsersMsg))
      {
        paramMessageRecord = (TroopReceivedFlowsersMsg)paramObject;
        paramInt = j;
        if (paramMessageRecord.i)
        {
          paramInt = j;
          if (!paramQQAppInterface.isToAll()) {
            paramInt = 0;
          }
        }
        paramObject = paramMessageRecord;
        j = paramInt;
        if (!paramMessageRecord.i)
        {
          paramMessageRecord.h.b(paramMessageInfo.c);
          paramObject = paramMessageRecord;
          j = paramInt;
        }
      }
      else
      {
        paramObject = new TroopReceivedFlowsersMsg(BaseApplication.getContext(), paramQQAppInterface.isToAll());
        paramObject.h = new MessageNavInfo(paramMessageInfo.c);
        j = paramInt;
      }
      if ((j != 0) && (!TextUtils.isEmpty(paramQQAppInterface.remindBrief)))
      {
        paramMessageInfo = paramQQAppInterface.remindBrief.split("#");
        paramMessageRecord = new StringBuffer("[");
        paramMessageRecord.append(paramMessageInfo[0]);
        paramMessageRecord.append("]");
        paramObject.c = paramMessageRecord.toString();
      }
      return paramObject;
    }
    ReportController.b(paramQQAppInterface, "P_CliOper", "BizTechReport", "", "Troop_gift", "MsgBizType.TYPE_TROOP_RECEIVED_FLOWSER_MSG, MessageRecord cast to GiftTips", 0, -1, paramMessageRecord.getClass().getName(), "", "", "");
    return null;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.a = paramArrayOfByte.optLong("uniseq");
      this.b = paramArrayOfByte.optLong("shmsgseq");
      this.c = paramArrayOfByte.optString("content");
      this.f = paramArrayOfByte.optInt("color");
      this.i = paramArrayOfByte.optBoolean("isToAll");
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
    return c();
  }
  
  public byte[] c()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uniseq", this.a);
      localJSONObject.put("shmsgseq", this.b);
      localJSONObject.put("content", this.c);
      localJSONObject.put("color", this.f);
      localJSONObject.put("isToAll", this.i);
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
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.TroopReceivedFlowsersMsg
 * JD-Core Version:    0.7.0.1
 */