package com.tencent.mobileqq.activity.aio.rebuild.tips;

import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.IMsgTipsFilter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.gameroom.IWerewolvesMsgUtilDelegate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ContactUtils;

public class NearbyTipsFilter
  implements IMsgTipsFilter
{
  private String a(AIOContext paramAIOContext, Message paramMessage)
  {
    String str;
    if (AppConstants.LBS_HELLO_UIN.equals(paramMessage.frienduin))
    {
      str = ContactUtils.g(paramAIOContext.a(), paramMessage.senderuin);
      paramAIOContext = str;
      if (TextUtils.isEmpty(str)) {
        return paramMessage.senderuin;
      }
    }
    else
    {
      str = ContactUtils.g(paramAIOContext.a(), paramMessage.frienduin);
      paramAIOContext = str;
      if (TextUtils.isEmpty(str)) {
        paramAIOContext = paramMessage.frienduin;
      }
    }
    return paramAIOContext;
  }
  
  public CharSequence a(AIOContext paramAIOContext, Intent paramIntent, MessageRecord paramMessageRecord, Message paramMessage)
  {
    paramIntent = paramIntent.getStringExtra("uinname");
    if (((1010 == paramMessage.istroop) || (1001 == paramMessage.istroop)) && (!TextUtils.isEmpty(paramIntent)))
    {
      paramMessageRecord = new SpannableStringBuilder();
      paramAIOContext = a(paramAIOContext, paramMessage);
      paramMessageRecord.append(paramIntent);
      paramMessageRecord.append("-");
      paramMessageRecord.append(paramAIOContext);
      return paramMessageRecord;
    }
    return null;
  }
  
  public CharSequence a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    if ((1010 == paramMessage.istroop) || (1001 == paramMessage.istroop))
    {
      paramMessageRecord = a(paramAIOContext, paramMessage);
      if (paramMessage.msgtype == -1024) {
        return String.format(paramAIOContext.a().getResources().getString(2131698742), new Object[] { paramMessageRecord });
      }
    }
    return null;
  }
  
  public boolean a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    paramMessageRecord = (HotChatManager)paramAIOContext.a().getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    paramAIOContext = paramAIOContext.a().getIntent();
    String str = paramAIOContext.getStringExtra("uin");
    boolean bool1 = paramMessageRecord.b(str);
    boolean bool2 = paramAIOContext.getBooleanExtra("isGameRoom", false);
    if ((bool1) || (bool2))
    {
      paramAIOContext = paramMessageRecord.a(str);
      if (((paramAIOContext == null) || (!paramAIOContext.isGameRoom)) && (!bool2)) {
        return true;
      }
    }
    if (paramMessageRecord.b(paramMessage.frienduin)) {
      return true;
    }
    if (((paramMessage.istroop == 1001) || (paramMessage.istroop == 10002)) && (UinTypeUtil.a(paramMessage))) {
      return true;
    }
    if (((IWerewolvesMsgUtilDelegate)QRoute.api(IWerewolvesMsgUtilDelegate.class)).isWerewolvesMsg(paramMessage)) {
      return true;
    }
    return UinTypeUtil.d(paramMessage.senderuin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.tips.NearbyTipsFilter
 * JD-Core Version:    0.7.0.1
 */