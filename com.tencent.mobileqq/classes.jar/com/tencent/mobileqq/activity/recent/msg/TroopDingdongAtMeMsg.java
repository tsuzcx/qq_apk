package com.tencent.mobileqq.activity.recent.msg;

import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopDingdongAtMeMsg
  extends TroopAtMsg
{
  public TroopDingdongAtMeMsg(Context paramContext)
  {
    this.c = HardCodeUtil.a(2131888695);
  }
  
  public Object a(int paramInt, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof TroopDingdongAtMeMsg))
    {
      paramObject = (TroopDingdongAtMeMsg)paramObject;
      paramObject.h.b(paramMessageInfo.c);
      return paramObject;
    }
    paramObject = new TroopDingdongAtMeMsg(BaseApplication.getContext());
    paramObject.h = new MessageNavInfo(paramMessageInfo.c);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.TroopDingdongAtMeMsg
 * JD-Core Version:    0.7.0.1
 */