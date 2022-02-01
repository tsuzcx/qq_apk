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
    Object localObject = "";
    if (AnonymousChatHelper.a(paramMessage))
    {
      String str1 = AnonymousChatHelper.a(paramMessage).b;
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697219) + str1 + "(" + a() + "):";
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b(str2);
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697219) + str1 + ": " + c();
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d(str1);
      if ((paramMessage.msgtype == -2035) || (paramMessage.msgtype == -2038))
      {
        str1 = MessageForGrayTips.getOrginMsg(c());
        this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a(str1);
      }
      if (paramMessage.msgtype == -3006)
      {
        localObject = MessageForPubAccount.getMsgSummary(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage, false);
        this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a((String)localObject);
        localObject = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
      }
      if (!MsgProxyUtils.f(paramMessage.msgtype)) {
        break label488;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNamePostfix(paramMessage);
      label236:
      str1 = (String)localObject + "(" + a() + "):";
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b(str1);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label517;
      }
      localObject = (String)localObject + ": " + c();
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject);
    }
    for (;;)
    {
      localObject = ColorNickManager.b(b());
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a.b() == 1)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopFaceBitmap(paramMessage.frienduin, (byte)3, false, false);
        this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a((Bitmap)localObject);
      }
      localObject = NotifyIdManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localObject != null)
      {
        localObject = ((NotifyIdManager)localObject).b(b(), paramMessage);
        this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject);
      }
      localObject = MessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(b(), paramMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject);
      return b(paramMessage);
      localObject = TroopBusinessUtil.a(paramMessage);
      if (localObject != null)
      {
        localObject = ((TroopBusinessUtil.TroopBusinessMessage)localObject).c;
        break;
      }
      if (!TextUtils.isEmpty(paramMessage.nickName))
      {
        localObject = paramMessage.nickName;
        break;
      }
      localObject = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin, paramMessage.senderuin);
      break;
      label488:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNamePostfix(paramMessage) + (String)localObject;
      break label236;
      label517:
      localObject = c();
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject);
    }
  }
  
  @Nullable
  private NotificationElement d(Message paramMessage)
  {
    String str = a() + ":";
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b(str);
    str = c();
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d(str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.basemessage.TroopNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */