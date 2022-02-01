package com.tencent.mobileqq.app.notification.processor.business;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.notification.struct.AbstractBusinessFoldedNotificationProcessor;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.theme.SkinnableBitmapDrawable;

public class KandianMergeNotificationProcessor
  extends AbstractBusinessFoldedNotificationProcessor
{
  protected KandianMergeNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  public int a(Message paramMessage)
  {
    return -113;
  }
  
  public NotificationElement a(Message paramMessage)
  {
    Object localObject = a() + ": ";
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b((String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d(c());
    a();
    a(paramMessage, this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement);
    if (!ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage)) {
      return null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a();
    ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade(), paramMessage, (Intent)localObject);
    paramMessage = ImageUtil.h();
    Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130842888);
    if ((localDrawable instanceof BitmapDrawable)) {
      paramMessage = ((BitmapDrawable)localDrawable).getBitmap();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a(paramMessage);
      return this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement;
      if ((localDrawable instanceof SkinnableBitmapDrawable)) {
        paramMessage = ((SkinnableBitmapDrawable)localDrawable).getBitmap();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.business.KandianMergeNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */