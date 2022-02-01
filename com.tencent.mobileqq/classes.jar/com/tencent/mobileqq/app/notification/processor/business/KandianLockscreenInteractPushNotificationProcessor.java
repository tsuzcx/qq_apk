package com.tencent.mobileqq.app.notification.processor.business;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.notification.struct.AbstractBusinessFoldedNotificationProcessor;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyUtilsConstants;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianLockScreenPushAladdinConfig;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.theme.SkinnableBitmapDrawable;

public class KandianLockscreenInteractPushNotificationProcessor
  extends AbstractBusinessFoldedNotificationProcessor
{
  protected KandianLockscreenInteractPushNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  public int a(Message paramMessage)
  {
    return 526;
  }
  
  public NotificationElement a(Message paramMessage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append(": ");
    localObject = ((StringBuilder)localObject).toString();
    this.a.b((String)localObject);
    this.a.d(c());
    a();
    a(paramMessage, this.a);
    paramMessage = ImageUtil.j();
    localObject = BaseApplicationImpl.getContext().getResources().getDrawable(ReadInJoyUtilsConstants.b);
    if ((localObject instanceof BitmapDrawable)) {
      paramMessage = ((BitmapDrawable)localObject).getBitmap();
    } else if ((localObject instanceof SkinnableBitmapDrawable)) {
      paramMessage = ((SkinnableBitmapDrawable)localObject).getBitmap();
    }
    localObject = RIJKanDianLockScreenPushAladdinConfig.a(BaseApplicationImpl.getContext());
    this.a.a(paramMessage);
    this.a.c((String)localObject);
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.business.KandianLockscreenInteractPushNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */