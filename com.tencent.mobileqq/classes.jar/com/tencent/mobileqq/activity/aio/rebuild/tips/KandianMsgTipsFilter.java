package com.tencent.mobileqq.activity.aio.rebuild.tips;

import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.IMsgTipsFilter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;

public class KandianMsgTipsFilter
  implements IMsgTipsFilter
{
  public CharSequence a(AIOContext paramAIOContext, Intent paramIntent, MessageRecord paramMessageRecord, Message paramMessage)
  {
    if ((7220 == paramMessage.istroop) && (paramMessage.extInt == 2) && (!TextUtils.isEmpty(paramMessage.senderuin)))
    {
      paramIntent = paramIntent.getStringExtra("uinname");
      paramMessageRecord = new SpannableStringBuilder();
      paramAIOContext = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramAIOContext instanceof QQAppInterface)) {
        paramAIOContext = (QQAppInterface)paramAIOContext;
      } else {
        paramAIOContext = null;
      }
      if (paramAIOContext == null) {
        return null;
      }
      paramAIOContext = (PublicAccountInfo)((IPublicAccountDataManager)paramAIOContext.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(paramMessage.senderuin);
      if ((paramAIOContext != null) && (!TextUtils.isEmpty(paramAIOContext.name)))
      {
        paramMessageRecord.append(paramAIOContext.name);
        return paramMessageRecord;
      }
      if (!TextUtils.isEmpty(paramIntent)) {
        paramMessageRecord.append(paramIntent);
      }
      return paramMessageRecord;
    }
    return null;
  }
  
  public boolean a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    if (paramMessage.istroop == 7220) {
      return true;
    }
    if ((paramMessage.istroop == 1008) && (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramMessage.senderuin))) {
      return true;
    }
    if ((paramMessage.istroop == 1008) && (AppConstants.KANDIAN_DAILY_UIN.equals(paramMessage.senderuin))) {
      return true;
    }
    if ((paramMessage.istroop != 7220) && (TextUtils.equals(paramMessage.frienduin, AppConstants.NEW_KANDIAN_UIN))) {
      return true;
    }
    return paramMessage.istroop == 10013;
  }
  
  public CharSequence b(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.tips.KandianMsgTipsFilter
 * JD-Core Version:    0.7.0.1
 */