package com.tencent.mobileqq.activity.recent.msg;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.api.INearbyFlowerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopHasGiftMsg
  extends AbstructRecentUserMsg
{
  public TroopHasGiftMsg(Context paramContext)
  {
    this.c = HardCodeUtil.a(2131895202);
    this.d = this.c;
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
      if ((paramObject instanceof TroopHasGiftMsg))
      {
        paramObject = (TroopHasGiftMsg)paramObject;
        paramObject.h.b(paramMessageInfo.c);
        paramMessageInfo = paramObject;
      }
      else
      {
        paramObject = new TroopHasGiftMsg(BaseApplication.getContext());
        paramObject.h = new MessageNavInfo(paramMessageInfo.c);
        paramMessageInfo = paramObject;
      }
    }
    else
    {
      if (!(paramMessageRecord instanceof MessageForDeliverGiftTips)) {
        break label284;
      }
      paramMessageRecord = (MessageForDeliverGiftTips)paramMessageRecord;
      if ((paramObject instanceof TroopHasGiftMsg))
      {
        paramObject = (TroopHasGiftMsg)paramObject;
        paramObject.h.b(paramMessageInfo.c);
        paramMessageInfo = paramObject;
      }
      else
      {
        paramObject = new TroopHasGiftMsg(BaseApplication.getContext());
        paramObject.h = new MessageNavInfo(paramMessageInfo.c);
        paramMessageInfo = paramObject;
      }
      if (!TextUtils.isEmpty(paramMessageRecord.remindBrief))
      {
        paramObject = paramMessageRecord.remindBrief.split("#");
        if (paramObject.length > 1)
        {
          paramMessageRecord = new StringBuffer("[");
          paramMessageRecord.append(paramObject[1]);
          paramMessageRecord.append("]");
          paramMessageInfo.c = paramMessageRecord.toString();
        }
      }
      paramObject = (AIOAnimationControlManager)paramQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
      if (paramObject.b(false)) {
        return null;
      }
      paramObject.a = 1;
    }
    return paramMessageInfo;
    label284:
    ReportController.b(paramQQAppInterface, "P_CliOper", "BizTechReport", "", "Troop_gift", "MsgBizType.TYPE_TROOP_HAS_GIFT_IN_TROOP, MessageRecord cast to GiftTips error", 0, -1, paramMessageRecord.getClass().getName(), "", "", "");
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
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.TroopHasGiftMsg
 * JD-Core Version:    0.7.0.1
 */