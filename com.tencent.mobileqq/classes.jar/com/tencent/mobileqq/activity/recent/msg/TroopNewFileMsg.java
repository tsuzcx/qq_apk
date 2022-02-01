package com.tencent.mobileqq.activity.recent.msg;

import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopNewFileMsg
  extends TroopAtMsg
{
  public int i;
  
  public TroopNewFileMsg(Context paramContext, int paramInt)
  {
    this.i = paramInt;
    if (paramInt == 0)
    {
      this.c = "";
      return;
    }
    if (paramInt == 1) {
      this.c = HardCodeUtil.a(2131912939);
    }
  }
  
  public Object a(int paramInt, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof TroopNewFileMsg))
    {
      paramObject = (TroopNewFileMsg)paramObject;
      if (paramObject.i == 0)
      {
        paramObject.h.b(paramMessageInfo.c);
        return paramObject;
      }
    }
    paramObject = new TroopNewFileMsg(BaseApplication.getContext(), 0);
    paramObject.h = new MessageNavInfo(paramMessageInfo.c);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.TroopNewFileMsg
 * JD-Core Version:    0.7.0.1
 */