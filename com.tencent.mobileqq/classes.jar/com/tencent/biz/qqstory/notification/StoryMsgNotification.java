package com.tencent.biz.qqstory.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.QNotificationManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import java.util.ArrayList;
import ngj;
import ngk;

public class StoryMsgNotification
{
  public static SparseArray a;
  public static final SparseIntArray a;
  private static StoryMsgNotification jdField_a_of_type_ComTencentBizQqstoryNotificationStoryMsgNotification;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    jdField_a_of_type_AndroidUtilSparseIntArray.put(1, 201);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(2, 201);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(3, 202);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(4, 203);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(5, 204);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(6, 205);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(7, 206);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(8, 207);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(9, 208);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10, 209);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(11, 210);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(12, 201);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(13, 201);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(37, 202);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(38, 212);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(39, 213);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(40, 202);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(41, 214);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(42, 215);
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
    int i = a(paramStoryPushMsg.jdField_a_of_type_Int);
    int j = b(i);
    switch (i)
    {
    }
    do
    {
      do
      {
        return "日迹消息";
        if (j > 100) {
          return String.format("日迹消息（共%s条未读）", new Object[] { "99+" });
        }
      } while (j <= 1);
      return String.format("日迹消息（共%s条未读）", new Object[] { String.valueOf(j) });
    } while (TextUtils.isEmpty(paramStoryPushMsg.h));
    return paramStoryPushMsg.h;
  }
  
  public void a(Context paramContext)
  {
    ThreadManager.post(new ngk(this, paramContext), 8, null, true);
  }
  
  public void a(Context paramContext, int paramInt)
  {
    int i = a(paramInt);
    jdField_a_of_type_AndroidUtilSparseArray.remove(i);
    new QNotificationManager(paramContext).cancel("StoryMsgNotification", jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt));
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.protocol", 2, "readPushMsgs type = " + paramInt);
    }
  }
  
  protected void a(StoryPushMsg paramStoryPushMsg)
  {
    if (paramStoryPushMsg == null) {}
    UserManager localUserManager;
    do
    {
      int i;
      do
      {
        return;
        i = a(paramStoryPushMsg.jdField_a_of_type_Int);
        paramStoryPushMsg.jdField_b_of_type_Int = (b(i) + 1);
        jdField_a_of_type_AndroidUtilSparseArray.put(i, paramStoryPushMsg);
      } while (i != 3);
      localUserManager = (UserManager)SuperManager.a(2);
    } while (localUserManager.b(paramStoryPushMsg.a()) != null);
    QQUserUIItem localQQUserUIItem = new QQUserUIItem();
    localQQUserUIItem.uid = paramStoryPushMsg.a();
    localQQUserUIItem.setUnionId(paramStoryPushMsg.c);
    localUserManager.a(localQQUserUIItem);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, StoryPushMsg paramStoryPushMsg)
  {
    if ((paramQQAppInterface == null) || (paramStoryPushMsg == null)) {}
    int i;
    do
    {
      return;
      i = jdField_a_of_type_AndroidUtilSparseIntArray.get(paramStoryPushMsg.jdField_a_of_type_Int);
    } while (i == 0);
    a(paramStoryPushMsg);
    String str1 = "";
    if ((paramStoryPushMsg.jdField_a_of_type_Int == 3) || (paramStoryPushMsg.jdField_a_of_type_Int == 9)) {
      str1 = String.valueOf(paramStoryPushMsg.jdField_a_of_type_Long);
    }
    if (TextUtils.isEmpty(paramStoryPushMsg.jdField_a_of_type_JavaLangString)) {}
    for (String str2 = "9999";; str2 = paramStoryPushMsg.jdField_a_of_type_JavaLangString)
    {
      StoryReportor.a("notice_msg", "push_suc_all", 0, 0, new String[] { str2, str1, "", "" });
      if (!StoryMsgNotificationUtils.a(paramQQAppInterface)) {
        break label139;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.qqstory.protocol", 2, "showQQStoryMsgNotification QQIsForeground return--------");
      return;
    }
    label139:
    if (TextUtils.isEmpty(paramStoryPushMsg.jdField_a_of_type_JavaLangString)) {}
    NotificationCompat.Builder localBuilder;
    Object localObject;
    for (str2 = "9999";; str2 = paramStoryPushMsg.jdField_a_of_type_JavaLangString)
    {
      StoryReportor.a("notice_msg", "push_suc", 0, 0, new String[] { str2, str1, "", "" });
      StoryMsgNotificationUtils.a(paramInt, paramQQAppInterface);
      str1 = a(paramStoryPushMsg);
      str2 = paramStoryPushMsg.jdField_b_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.w("zivonchen", 2, "showQQStoryMsgNotification line1 = " + str1 + ", line2 = " + str2);
      }
      localBuilder = new NotificationCompat.Builder(paramQQAppInterface.getApp());
      localBuilder.setSmallIcon(2130839532).setWhen(System.currentTimeMillis()).setContentTitle(str1).setContentText(str2).setPriority(2).setStyle(new NotificationCompat.BigTextStyle().bigText(str2));
      if (TextUtils.isEmpty(paramStoryPushMsg.g)) {
        break label490;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      localObject = URLDrawable.getDrawable(paramStoryPushMsg.g, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setURLDrawableListener(new ngj(this, localBuilder, paramQQAppInterface, paramStoryPushMsg, i, str1, str2));
      if (((URLDrawable)localObject).getStatus() != 1) {
        break;
      }
      localObject = com.tencent.mobileqq.utils.ImageUtil.a(((URLDrawable)localObject).getCurrDrawable(), 200, 200);
      Bitmap localBitmap = com.tencent.biz.common.util.ImageUtil.b((Bitmap)localObject, 1);
      localBuilder.setLargeIcon(localBitmap);
      if (QLog.isColorLevel()) {
        QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadSuccessed start, cutBitmap.size():" + localBitmap.getHeight() + ", " + localBitmap.getWidth());
      }
      a(paramQQAppInterface, paramStoryPushMsg, i, str1, str2, localBuilder.build());
      ((Bitmap)localObject).recycle();
      return;
    }
    ((URLDrawable)localObject).startDownload();
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    return;
    label490:
    a(paramQQAppInterface, paramStoryPushMsg, i, str1, str2, localBuilder.build());
  }
  
  public void a(QQAppInterface paramQQAppInterface, StoryPushMsg paramStoryPushMsg, int paramInt, String paramString1, String paramString2, Notification paramNotification)
  {
    paramNotification.flags = 16;
    Object localObject = new Intent("com.tencent.biz.qqstory.notification.qqstory_jump_activity_notify");
    ((Intent)localObject).putExtra("storyPushMsg", paramStoryPushMsg);
    localObject = PendingIntent.getBroadcast(paramQQAppInterface.getApp(), paramInt, (Intent)localObject, 1207959552);
    paramNotification.setLatestEventInfo(paramQQAppInterface.getApp(), paramString1, paramString2, (PendingIntent)localObject);
    paramString1 = new QNotificationManager(paramQQAppInterface.getApp());
    paramString2 = new Intent("com.tencent.biz.qqstory.notification.qqstory_delete_notify");
    paramString2.putExtra("push_type", paramStoryPushMsg.jdField_a_of_type_Int);
    paramNotification.deleteIntent = PendingIntent.getBroadcast(paramQQAppInterface.getApp(), paramInt, paramString2, 134217728);
    BadgeUtils.a(paramQQAppInterface.getApp(), 0, paramNotification);
    paramString1.notify("StoryMsgNotification", paramInt, paramNotification);
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.protocol", 2, "showQQStoryMsgNotification pushMsg: " + paramStoryPushMsg);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.notification.StoryMsgNotification
 * JD-Core Version:    0.7.0.1
 */