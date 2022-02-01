package com.tencent.mobileqq.app.notification.processor.business;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.notification.struct.AbstractBusinessFoldedNotificationProcessor;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyUtilsConstants;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.List;

public class PublicAccountNotificationProcessor
  extends AbstractBusinessFoldedNotificationProcessor
{
  protected PublicAccountNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  public NotificationElement a(Message paramMessage)
  {
    Object localObject3 = SkinUtils.a(this.a.getApp().getResources().getDrawable(2130841180));
    this.b.a((Bitmap)localObject3);
    String str1 = d();
    this.b.d(str1);
    Object localObject2 = XMLMessageUtils.a(paramMessage);
    Object localObject1 = str1;
    if (localObject2 != null)
    {
      localObject1 = str1;
      if (!((PAMessage)localObject2).items.isEmpty())
      {
        localObject1 = ((PAMessage.Item)((PAMessage)localObject2).items.get(0)).title;
        if ((((PAMessage.Item)((PAMessage)localObject2).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject2).items.get(0)).digestList != null))
        {
          this.b.c((String)localObject1);
          localObject1 = (String)((PAMessage.Item)((PAMessage)localObject2).items.get(0)).digestList.get(0);
          this.b.d((String)localObject1);
        }
        else
        {
          this.b.d((String)localObject1);
        }
      }
    }
    str1 = this.b.c();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append((String)localObject1);
    str1 = ((StringBuilder)localObject2).toString();
    this.b.b(str1);
    a(paramMessage, this.b);
    if (paramMessage.extStr == null) {
      return null;
    }
    if (((paramMessage.extLong & 0x1) == 0) && (!paramMessage.extStr.contains("lockDisplay"))) {
      return null;
    }
    if (((paramMessage.extLong & 0x1) == 1) && (!paramMessage.getExtInfoFromExtStr("lockDisplay").equals("true"))) {
      return null;
    }
    Intent localIntent = this.b.b();
    str1 = this.b.d();
    String str2 = this.b.a();
    localIntent.putExtra("need_report", true);
    localIntent.putExtra("incoming_msguid", paramMessage.msgUid);
    localIntent.putExtra("incoming_shmsgseq", paramMessage.shmsgseq);
    Object localObject4 = localIntent.getStringExtra("uin");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject4))) {
      localObject2 = str1.replace((CharSequence)localObject4, "");
    } else {
      localObject2 = str1;
    }
    Object localObject5;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = localObject1;
    }
    else
    {
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append((String)localObject2);
      ((StringBuilder)localObject5).append(" : ");
      ((StringBuilder)localObject5).append((String)localObject1);
      localObject2 = ((StringBuilder)localObject5).toString();
    }
    if (AppConstants.REMINDER_UIN.equals(localObject4)) {}
    for (localObject1 = this.a.getFaceBitmap(paramMessage.frienduin, true);; localObject1 = localObject3)
    {
      localObject4 = localObject2;
      localObject3 = str1;
      break;
      if (AppConstants.KANDIAN_DAILY_UIN.equals(localObject4))
      {
        localObject5 = BaseApplicationImpl.getContext().getResources().getDrawable(ReadInJoyUtilsConstants.b);
        if ((localObject5 instanceof BitmapDrawable))
        {
          localObject1 = ((BitmapDrawable)localObject5).getBitmap();
          localObject3 = str1;
          localObject4 = str2;
          break;
        }
        localObject1 = localObject3;
        localObject3 = str1;
        localObject4 = str2;
        if (!(localObject5 instanceof SkinnableBitmapDrawable)) {
          break;
        }
        localObject1 = ((SkinnableBitmapDrawable)localObject5).getBitmap();
        localObject3 = str1;
        localObject4 = str2;
        break;
      }
      str1 = this.a.getApp().getString(2131886307);
    }
    ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).reportForLockScreenExposure(this.a.getMessageFacade(), paramMessage, localIntent);
    this.b.a(localIntent);
    this.b.c((String)localObject3);
    this.b.d((String)localObject4);
    this.b.b((String)localObject2);
    this.b.a((Bitmap)localObject1);
    return this.b;
  }
  
  public int b(Message paramMessage)
  {
    return 267;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.business.PublicAccountNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */