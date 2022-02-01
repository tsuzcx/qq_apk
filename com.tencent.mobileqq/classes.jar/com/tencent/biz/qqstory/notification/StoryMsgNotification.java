package com.tencent.biz.qqstory.notification;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class StoryMsgNotification
{
  protected static SparseArray<StoryPushMsg> a;
  protected static final SparseIntArray a;
  private static StoryMsgNotification jdField_a_of_type_ComTencentBizQqstoryNotificationStoryMsgNotification;
  public static final String a;
  public static final String b;
  private ArrayList<URLDrawable> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QQStoryConstant.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(HardCodeUtil.a(2131714329));
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(QQStoryConstant.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(HardCodeUtil.a(2131714330));
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    jdField_a_of_type_ComTencentBizQqstoryNotificationStoryMsgNotification = null;
    jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    jdField_a_of_type_AndroidUtilSparseIntArray.put(1, 246);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(2, 246);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(3, 247);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(4, 248);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(5, 249);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(6, 250);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(7, 251);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(8, 252);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(9, 253);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10, 254);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(11, 255);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(12, 246);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(13, 246);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(37, 247);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(38, 256);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(39, 257);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(40, 247);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(41, 258);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(42, 259);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(47, 260);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(46, 261);
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public static StoryMsgNotification a()
  {
    if (jdField_a_of_type_ComTencentBizQqstoryNotificationStoryMsgNotification == null) {
      jdField_a_of_type_ComTencentBizQqstoryNotificationStoryMsgNotification = new StoryMsgNotification();
    }
    return jdField_a_of_type_ComTencentBizQqstoryNotificationStoryMsgNotification;
  }
  
  protected int a(int paramInt)
  {
    int i;
    if ((paramInt != 1) && (paramInt != 12))
    {
      i = paramInt;
      if (paramInt != 13) {}
    }
    else
    {
      i = 2;
    }
    return i;
  }
  
  protected String a(StoryPushMsg paramStoryPushMsg)
  {
    String str = jdField_a_of_type_JavaLangString;
    int i = a(paramStoryPushMsg.jdField_a_of_type_Int);
    int j = b(i);
    if ((i != 1) && (i != 2) && (i != 4) && (i != 12) && (i != 13))
    {
      switch (i)
      {
      default: 
        return str;
      }
      if (!android.text.TextUtils.isEmpty(paramStoryPushMsg.h)) {
        return paramStoryPushMsg.h;
      }
    }
    else
    {
      if (j > 100) {
        return String.format(jdField_b_of_type_JavaLangString, new Object[] { "99+" });
      }
      if (j > 1) {
        str = String.format(jdField_b_of_type_JavaLangString, new Object[] { String.valueOf(j) });
      }
    }
    return str;
  }
  
  public void a(Context paramContext)
  {
    ThreadManager.post(new StoryMsgNotification.2(this), 8, null, true);
  }
  
  public void a(Context paramContext, int paramInt)
  {
    int i = a(paramInt);
    jdField_a_of_type_AndroidUtilSparseArray.remove(i);
    QQNotificationManager.getInstance().cancel("StoryMsgNotification", jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt));
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("readPushMsgs type = ");
      paramContext.append(paramInt);
      QLog.w("Q.qqstory.protocol", 2, paramContext.toString());
    }
  }
  
  protected void a(StoryPushMsg paramStoryPushMsg)
  {
    if (paramStoryPushMsg == null) {
      return;
    }
    int i = a(paramStoryPushMsg.jdField_a_of_type_Int);
    paramStoryPushMsg.jdField_b_of_type_Int = (b(i) + 1);
    jdField_a_of_type_AndroidUtilSparseArray.put(i, paramStoryPushMsg);
    if (i == 3)
    {
      UserManager localUserManager = (UserManager)SuperManager.a(2);
      if (localUserManager.b(paramStoryPushMsg.a()) == null)
      {
        QQUserUIItem localQQUserUIItem = new QQUserUIItem();
        localQQUserUIItem.uid = paramStoryPushMsg.a();
        localQQUserUIItem.setUnionId(paramStoryPushMsg.c);
        localUserManager.a(localQQUserUIItem);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, StoryPushMsg paramStoryPushMsg)
  {
    if (paramQQAppInterface != null)
    {
      if (paramStoryPushMsg == null) {
        return;
      }
      int i = jdField_a_of_type_AndroidUtilSparseIntArray.get(paramStoryPushMsg.jdField_a_of_type_Int);
      if (i == 0) {
        return;
      }
      a(paramStoryPushMsg);
      if ((paramStoryPushMsg.jdField_a_of_type_Int != 3) && (paramStoryPushMsg.jdField_a_of_type_Int != 9)) {
        localObject1 = "";
      } else {
        localObject1 = String.valueOf(paramStoryPushMsg.jdField_a_of_type_Long);
      }
      boolean bool = android.text.TextUtils.isEmpty(paramStoryPushMsg.jdField_a_of_type_JavaLangString);
      Object localObject3 = "9999";
      if (bool) {
        localObject2 = "9999";
      } else {
        localObject2 = paramStoryPushMsg.jdField_a_of_type_JavaLangString;
      }
      StoryReportor.a("notice_msg", "push_suc_all", 0, 0, new String[] { localObject2, localObject1, "", "" });
      if (StoryMsgNotificationUtils.a(paramQQAppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.protocol", 2, "showQQStoryMsgNotification QQIsForeground return--------");
        }
        return;
      }
      if (android.text.TextUtils.isEmpty(paramStoryPushMsg.jdField_a_of_type_JavaLangString)) {
        localObject2 = localObject3;
      } else {
        localObject2 = paramStoryPushMsg.jdField_a_of_type_JavaLangString;
      }
      StoryReportor.a("notice_msg", "push_suc", 0, 0, new String[] { localObject2, localObject1, "", "" });
      StoryMsgNotificationUtils.a(paramInt, paramQQAppInterface);
      Object localObject4 = a(paramStoryPushMsg);
      Object localObject2 = paramStoryPushMsg.jdField_b_of_type_JavaLangString;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("showQQStoryMsgNotification line1 = ");
        ((StringBuilder)localObject1).append((String)localObject4);
        ((StringBuilder)localObject1).append(", line2 = ");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.w("zivonchen", 2, ((StringBuilder)localObject1).toString());
      }
      localObject3 = new NotificationCompat.Builder(paramQQAppInterface.getApp());
      Object localObject1 = localObject2;
      if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion((String)localObject2)) {
        localObject1 = new QQTextBuilder(EmotionCodecUtils.b((String)localObject2), 3, 16).toPlainText();
      }
      ((NotificationCompat.Builder)localObject3).setSmallIcon(2130841470).setWhen(System.currentTimeMillis()).setContentTitle((CharSequence)localObject4).setContentText((CharSequence)localObject1).setPriority(2).setStyle(new NotificationCompat.BigTextStyle().bigText((CharSequence)localObject1));
      if (!android.text.TextUtils.isEmpty(paramStoryPushMsg.g))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        localObject1 = URLDrawable.getDrawable(paramStoryPushMsg.g, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setURLDrawableListener(new StoryMsgNotification.1(this, (NotificationCompat.Builder)localObject3, paramQQAppInterface, paramStoryPushMsg, i));
        if (((URLDrawable)localObject1).getStatus() == 1)
        {
          localObject1 = com.tencent.mobileqq.utils.ImageUtil.a(((URLDrawable)localObject1).getCurrDrawable(), 200, 200);
          localObject2 = com.tencent.biz.common.util.ImageUtil.b((Bitmap)localObject1, 1);
          ((NotificationCompat.Builder)localObject3).setLargeIcon((Bitmap)localObject2);
          if ((QLog.isColorLevel()) && (localObject2 != null))
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("thumbDrawable onLoadSuccessed start, cutBitmap.size():");
            ((StringBuilder)localObject4).append(((Bitmap)localObject2).getHeight());
            ((StringBuilder)localObject4).append(", ");
            ((StringBuilder)localObject4).append(((Bitmap)localObject2).getWidth());
            QLog.d("StoryMsgNotification", 2, ((StringBuilder)localObject4).toString());
          }
          a(paramQQAppInterface, paramStoryPushMsg, i, (NotificationCompat.Builder)localObject3);
          ((Bitmap)localObject1).recycle();
          return;
        }
        ((URLDrawable)localObject1).startDownload();
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        return;
      }
      a(paramQQAppInterface, paramStoryPushMsg, i, (NotificationCompat.Builder)localObject3);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, StoryPushMsg paramStoryPushMsg, int paramInt, NotificationCompat.Builder paramBuilder)
  {
    Intent localIntent1 = new Intent("com.tencent.biz.qqstory.notification.qqstory_jump_activity_notify");
    localIntent1.putExtra("storyPushMsg", paramStoryPushMsg);
    localIntent1.setPackage(MobileQQ.getContext().getPackageName());
    localIntent1.putExtra("param_notifyid", paramInt);
    paramBuilder.setContentIntent(PendingIntent.getBroadcast(paramQQAppInterface.getApp(), paramInt, localIntent1, 1207959552));
    paramBuilder = paramBuilder.build();
    paramBuilder.flags = 16;
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    Intent localIntent2 = new Intent("com.tencent.biz.qqstory.notification.qqstory_delete_notify");
    localIntent1.putExtra("param_notifyid", paramInt);
    localIntent2.setPackage(MobileQQ.getContext().getPackageName());
    localIntent2.putExtra("push_type", paramStoryPushMsg.jdField_a_of_type_Int);
    paramBuilder.deleteIntent = PendingIntent.getBroadcast(paramQQAppInterface.getApp(), paramInt, localIntent2, 134217728);
    BadgeUtils.a(paramQQAppInterface.getApp(), 0, paramBuilder);
    localQQNotificationManager.notify("StoryMsgNotification", paramInt, paramBuilder);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("showQQStoryMsgNotification pushMsg: ");
      paramQQAppInterface.append(paramStoryPushMsg);
      QLog.w("Q.qqstory.protocol", 2, paramQQAppInterface.toString());
    }
  }
  
  public int b(int paramInt)
  {
    StoryPushMsg localStoryPushMsg = (StoryPushMsg)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localStoryPushMsg == null) {
      return 0;
    }
    return localStoryPushMsg.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.notification.StoryMsgNotification
 * JD-Core Version:    0.7.0.1
 */