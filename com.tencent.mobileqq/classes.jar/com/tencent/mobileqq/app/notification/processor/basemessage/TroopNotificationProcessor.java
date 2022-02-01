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
  
  private boolean a(Message paramMessage)
  {
    return (paramMessage.msgtype == -1013) || (paramMessage.msgtype == -2030) || (paramMessage.msgtype == -1047);
  }
  
  @Nullable
  private NotificationElement c(Message paramMessage)
  {
    if (AnonymousChatHelper.a(paramMessage))
    {
      localObject1 = AnonymousChatHelper.a(paramMessage).b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697238));
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("(");
      ((StringBuilder)localObject2).append(a());
      ((StringBuilder)localObject2).append("):");
      localObject2 = ((StringBuilder)localObject2).toString();
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b((String)localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697238));
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(": ");
      ((StringBuilder)localObject2).append(c());
      localObject1 = ((StringBuilder)localObject2).toString();
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject1);
      localObject1 = "";
    }
    else
    {
      localObject1 = TroopBusinessUtil.a(paramMessage);
      if (localObject1 != null) {
        localObject1 = ((TroopBusinessUtil.TroopBusinessMessage)localObject1).c;
      } else if (!TextUtils.isEmpty(paramMessage.nickName)) {
        localObject1 = paramMessage.nickName;
      } else {
        localObject1 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin, paramMessage.senderuin);
      }
    }
    if ((paramMessage.msgtype == -2035) || (paramMessage.msgtype == -2038))
    {
      localObject2 = MessageForGrayTips.getOrginMsg(c());
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a((String)localObject2);
    }
    if (paramMessage.msgtype == -3006)
    {
      localObject1 = MessageForPubAccount.getMsgSummary(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage, false);
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a((String)localObject1);
      localObject1 = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
    }
    if (MsgProxyUtils.f(paramMessage.msgtype))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNamePostfix(paramMessage);
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNamePostfix(paramMessage));
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("(");
    ((StringBuilder)localObject2).append(a());
    ((StringBuilder)localObject2).append("):");
    localObject2 = ((StringBuilder)localObject2).toString();
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b((String)localObject2);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(": ");
      ((StringBuilder)localObject2).append(c());
      localObject1 = ((StringBuilder)localObject2).toString();
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject1);
    }
    else
    {
      localObject1 = c();
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject1);
    }
    Object localObject1 = ColorNickManager.b(b());
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject1);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a.b() == 1)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopFaceBitmap(paramMessage.frienduin, (byte)3, false, false);
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a((Bitmap)localObject1);
    }
    localObject1 = NotifyIdManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localObject1 != null)
    {
      localObject1 = ((NotifyIdManager)localObject1).b(b(), paramMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject1);
    }
    localObject1 = MessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(b(), paramMessage);
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject1);
    return b(paramMessage);
  }
  
  @Nullable
  private NotificationElement d(Message paramMessage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append(":");
    localObject = ((StringBuilder)localObject).toString();
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b((String)localObject);
    localObject = c();
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject);
    return b(paramMessage);
  }
  
  public int a(Message paramMessage)
  {
    return b(paramMessage);
  }
  
  public NotificationElement a(Message paramMessage)
  {
    if (a(paramMessage)) {
      return d(paramMessage);
    }
    return c(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.basemessage.TroopNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */