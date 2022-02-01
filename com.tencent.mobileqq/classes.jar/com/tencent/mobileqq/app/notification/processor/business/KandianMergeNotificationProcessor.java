package com.tencent.mobileqq.app.notification.processor.business;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.notification.struct.AbstractBusinessFoldedNotificationProcessor;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyUtilsConstants;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
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
  
  public NotificationElement a(Message paramMessage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(b());
    ((StringBuilder)localObject).append(": ");
    localObject = ((StringBuilder)localObject).toString();
    this.b.b((String)localObject);
    this.b.d(d());
    e();
    a(paramMessage, this.b);
    if (!((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).needKanDianNotification(paramMessage)) {
      return null;
    }
    localObject = this.b.b();
    ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).reportForLockScreenExposure(this.a.getMessageFacade(), paramMessage, (Intent)localObject);
    paramMessage = ImageUtil.p();
    Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(ReadInJoyUtilsConstants.b);
    if ((localDrawable instanceof BitmapDrawable)) {
      paramMessage = ((BitmapDrawable)localDrawable).getBitmap();
    } else if ((localDrawable instanceof SkinnableBitmapDrawable)) {
      paramMessage = ((SkinnableBitmapDrawable)localDrawable).getBitmap();
    }
    this.b.a((Intent)localObject);
    this.b.a(paramMessage);
    return this.b;
  }
  
  public int b(Message paramMessage)
  {
    return -113;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.business.KandianMergeNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */