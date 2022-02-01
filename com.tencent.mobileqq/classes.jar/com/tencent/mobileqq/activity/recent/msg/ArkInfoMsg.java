package com.tencent.mobileqq.activity.recent.msg;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class ArkInfoMsg
  extends TroopAtMsg
{
  public ArkInfoMsg(Context paramContext, String paramString)
  {
    a(paramString);
  }
  
  public Object a(int paramInt, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramMessageRecord instanceof MessageForArkApp)) {
      paramMessageRecord = ArkTipsManager.a((MessageForArkApp)paramMessageRecord);
    } else {
      paramMessageRecord = null;
    }
    if ((paramObject instanceof ArkInfoMsg))
    {
      paramObject = (ArkInfoMsg)paramObject;
      if (paramMessageRecord != null) {
        paramObject.a(paramMessageRecord);
      }
      paramObject.h.b(paramMessageInfo.c);
      return paramObject;
    }
    paramObject = BaseApplication.getContext();
    if (paramMessageRecord == null) {
      paramMessageRecord = "";
    }
    paramObject = new ArkInfoMsg(paramObject, paramMessageRecord);
    paramObject.h = new MessageNavInfo(paramMessageInfo.c);
    return paramObject;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "";
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('[');
      localStringBuilder.append(paramString);
      localStringBuilder.append(']');
      paramString = localStringBuilder.toString();
    }
    this.c = paramString;
    this.d = this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.ArkInfoMsg
 * JD-Core Version:    0.7.0.1
 */