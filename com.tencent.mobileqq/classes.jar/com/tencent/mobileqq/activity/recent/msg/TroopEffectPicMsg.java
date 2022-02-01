package com.tencent.mobileqq.activity.recent.msg;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopEffectPicMsg
  extends TroopAtMsg
{
  public TroopEffectPicMsg(Context paramContext)
  {
    this.a = "";
  }
  
  public Object a(int paramInt, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    return new TroopEffectPicMsg(BaseApplication.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.TroopEffectPicMsg
 * JD-Core Version:    0.7.0.1
 */