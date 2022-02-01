package com.tencent.mobileqq.app.notification.processor.basemessage;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.app.notification.struct.BaseConversationMessageNotificationProcessor;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.notification.NotifyIdManager;
import mqq.app.MobileQQ;

public final class TroopNotificationProcessor
  extends BaseConversationMessageNotificationProcessor
{
  protected TroopNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  @Nullable
  private NotificationElement e(Message paramMessage)
  {
    if (AnonymousChatHelper.c(paramMessage))
    {
      localObject1 = AnonymousChatHelper.g(paramMessage).c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a.getApp().getString(2131895011));
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("(");
      ((StringBuilder)localObject2).append(b());
      ((StringBuilder)localObject2).append("):");
      localObject2 = ((StringBuilder)localObject2).toString();
      this.b.b((String)localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a.getApp().getString(2131895011));
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(": ");
      ((StringBuilder)localObject2).append(d());
      localObject1 = ((StringBuilder)localObject2).toString();
      this.b.d((String)localObject1);
      localObject1 = "";
    }
    else
    {
      localObject1 = TroopBusinessUtil.a(paramMessage);
      if (localObject1 != null) {
        localObject1 = ((TroopBusinessUtil.TroopBusinessMessage)localObject1).d;
      } else if (!TextUtils.isEmpty(paramMessage.nickName)) {
        localObject1 = paramMessage.nickName;
      } else {
        localObject1 = ContactUtils.b(this.a, paramMessage.frienduin, paramMessage.senderuin);
      }
    }
    if ((paramMessage.msgtype == -2035) || (paramMessage.msgtype == -2038))
    {
      localObject2 = MessageForGrayTips.getOrginMsg(d());
      this.b.a((String)localObject2);
    }
    if (paramMessage.msgtype == -3006)
    {
      localObject1 = MessageForPubAccount.getMsgSummary(this.a, paramMessage, false);
      this.b.a((String)localObject1);
      localObject1 = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.a, this.a.getApplication().getApplicationContext());
    }
    if (MsgProxyUtils.f(paramMessage.msgtype))
    {
      localObject1 = this.a.getNamePostfix(paramMessage);
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a.getNamePostfix(paramMessage));
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("(");
    ((StringBuilder)localObject2).append(b());
    ((StringBuilder)localObject2).append("):");
    localObject2 = ((StringBuilder)localObject2).toString();
    this.b.b((String)localObject2);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(": ");
      ((StringBuilder)localObject2).append(d());
      localObject1 = ((StringBuilder)localObject2).toString();
      this.b.d((String)localObject1);
    }
    else
    {
      localObject1 = d();
      this.b.d((String)localObject1);
    }
    Object localObject1 = ColorNickManager.b(c());
    this.b.d((String)localObject1);
    if (this.a.getMessageFacade().d.d() == 1)
    {
      localObject1 = this.a.getTroopFaceBitmap(paramMessage.frienduin, (byte)3, false, false);
      this.b.a((Bitmap)localObject1);
    }
    localObject1 = NotifyIdManager.a(this.a);
    if (localObject1 != null)
    {
      localObject1 = ((NotifyIdManager)localObject1).b(c(), paramMessage);
      this.b.d((String)localObject1);
    }
    localObject1 = MessageNotificationSettingManager.a(this.a).a(c(), paramMessage);
    this.b.d((String)localObject1);
    return c(paramMessage);
  }
  
  @Nullable
  private NotificationElement f(Message paramMessage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(b());
    ((StringBuilder)localObject).append(":");
    localObject = ((StringBuilder)localObject).toString();
    this.b.b((String)localObject);
    localObject = d();
    this.b.d((String)localObject);
    return c(paramMessage);
  }
  
  private boolean g(Message paramMessage)
  {
    return (paramMessage.msgtype == -1013) || (paramMessage.msgtype == -2030) || (paramMessage.msgtype == -1047);
  }
  
  public NotificationElement a(Message paramMessage)
  {
    if (g(paramMessage)) {
      return f(paramMessage);
    }
    return e(paramMessage);
  }
  
  public int b(Message paramMessage)
  {
    return d(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.basemessage.TroopNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */