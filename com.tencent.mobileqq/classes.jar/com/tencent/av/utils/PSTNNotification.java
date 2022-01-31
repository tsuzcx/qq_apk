package com.tencent.av.utils;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.widget.RemoteViews;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.CallbackWaitingActivityExt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.QNotificationManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Stack;

public class PSTNNotification
{
  static PSTNNotification jdField_a_of_type_ComTencentAvUtilsPSTNNotification;
  final int jdField_a_of_type_Int = 2130840237;
  Notification jdField_a_of_type_AndroidAppNotification = null;
  Context jdField_a_of_type_AndroidContentContext = null;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  Bundle jdField_a_of_type_AndroidOsBundle = null;
  RemoteViews jdField_a_of_type_AndroidWidgetRemoteViews = null;
  NotificationStyleDiscover jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover;
  QNotificationManager jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager = null;
  String jdField_a_of_type_JavaLangString = null;
  Stack jdField_a_of_type_JavaUtilStack = new Stack();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  String jdField_b_of_type_JavaLangString = null;
  
  PSTNNotification(Context paramContext)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    }
    this.jdField_a_of_type_AndroidAppNotification = new Notification();
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager = new QNotificationManager(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover = new NotificationStyleDiscover(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetRemoteViews = new RemoteViews(this.jdField_a_of_type_AndroidContentContext.getPackageName(), 2130969370);
  }
  
  public static PSTNNotification a(Context paramContext)
  {
    if ((jdField_a_of_type_ComTencentAvUtilsPSTNNotification == null) && (paramContext != null)) {
      jdField_a_of_type_ComTencentAvUtilsPSTNNotification = new PSTNNotification(paramContext);
    }
    return jdField_a_of_type_ComTencentAvUtilsPSTNNotification;
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PSTNNotification", 2, "addNotification");
    }
    this.jdField_a_of_type_AndroidAppNotification = new Notification();
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager = new QNotificationManager(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetRemoteViews = new RemoteViews(this.jdField_a_of_type_AndroidContentContext.getPackageName(), 2130969370);
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      this.jdField_a_of_type_JavaLangString = "";
      if (QLog.isColorLevel()) {
        QLog.e("PSTNNotification", 2, "addNotification mName ==null");
      }
    }
    int i = Process.myPid();
    String str;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      str = "";
    }
    for (;;)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, CallbackWaitingActivityExt.class);
      localIntent.addFlags(268435456);
      localIntent.addFlags(4194304);
      localIntent.addFlags(262144);
      Object localObject1 = new PstnSessionInfo();
      Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      ((PstnSessionInfo)localObject1).jdField_a_of_type_JavaLangString = ((QQAppInterface)localObject2).a().a().jdField_a_of_type_JavaLangString;
      ((PstnSessionInfo)localObject1).d = ((QQAppInterface)localObject2).a().a().d;
      ((PstnSessionInfo)localObject1).jdField_b_of_type_JavaLangString = ((QQAppInterface)localObject2).a().a().jdField_b_of_type_JavaLangString;
      ((PstnSessionInfo)localObject1).c = ((QQAppInterface)localObject2).a().a().c;
      ((PstnSessionInfo)localObject1).jdField_a_of_type_Int = ((QQAppInterface)localObject2).a().a().jdField_a_of_type_Int;
      ((PstnSessionInfo)localObject1).jdField_b_of_type_Int = ((QQAppInterface)localObject2).a().a().jdField_b_of_type_Int;
      localIntent.putExtra("pstn_session_info", (Parcelable)localObject1);
      localIntent.putExtra("needStopService", true);
      localObject2 = this.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_AndroidAppNotification.tickerText = str;
      localIntent.putExtra("PID", i);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131366312, 2130840237);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130840237;
      localObject1 = null;
      if (localIntent != null) {
        localObject1 = PendingIntent.getActivity(this.jdField_a_of_type_AndroidContentContext, 0, localIntent, 268435456);
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.b() > 0.0F) {
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setFloat(2131366311, "setTextSize", this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.b());
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.a() > 0.0F) {
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setFloat(2131366313, "setTextSize", this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.a());
      }
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewText(2131366311, (CharSequence)localObject2);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewText(2131366313, str);
      try
      {
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
          this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewBitmap(2131366310, this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
        this.jdField_a_of_type_AndroidAppNotification.flags = 2;
        this.jdField_a_of_type_AndroidAppNotification.contentView = this.jdField_a_of_type_AndroidWidgetRemoteViews;
        this.jdField_a_of_type_AndroidAppNotification.contentIntent = ((PendingIntent)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.notify("PSTNNotification", 2130840237, this.jdField_a_of_type_AndroidAppNotification);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      this.jdField_a_of_type_Boolean = true;
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131429555);
      continue;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131429562);
    }
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PSTNNotification", 2, "updateNotification mIsActive: " + this.jdField_a_of_type_Boolean);
        }
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppNotification != null)) {
          str = "";
        }
        switch (paramInt)
        {
        case 0: 
          this.jdField_a_of_type_AndroidAppNotification.tickerText = str;
          this.jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.notify("PSTNNotification", 2130840237, this.jdField_a_of_type_AndroidAppNotification);
          return;
        }
      }
      finally {}
      String str = this.jdField_a_of_type_AndroidContentContext.getString(2131429555);
      continue;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131429562);
    }
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PSTNNotification", 2, "addNotification name: " + paramString1 + ", id: " + paramString2 + ", type: " + paramInt + ", mName: " + this.jdField_a_of_type_JavaLangString + ", mId: " + this.jdField_b_of_type_JavaLangString + ", mType: " + this.jdField_b_of_type_Int);
    }
    if ((paramString1 != null) && (paramString1.equals(this.jdField_a_of_type_JavaLangString)) && (paramBitmap == this.jdField_a_of_type_AndroidGraphicsBitmap) && (paramInt == this.jdField_b_of_type_Int))
    {
      b();
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PSTNNotification", 2, "addNotification store");
      }
      c();
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    a();
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.notify("PSTNNotification", 2130840237, this.jdField_a_of_type_AndroidAppNotification);
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PSTNNotification", 2, "notifyNotification mIsActive: " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.notify("PSTNNotification", 2130840237, this.jdField_a_of_type_AndroidAppNotification);
      return;
    }
    a();
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +32 -> 37
    //   8: ldc 94
    //   10: iconst_2
    //   11: new 241	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 288
    //   21: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 46	com/tencent/av/utils/PSTNNotification:jdField_a_of_type_Boolean	Z
    //   28: invokevirtual 251	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   31: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload_0
    //   38: getfield 46	com/tencent/av/utils/PSTNNotification:jdField_a_of_type_Boolean	Z
    //   41: ifeq +86 -> 127
    //   44: aload_0
    //   45: getfield 30	com/tencent/av/utils/PSTNNotification:jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager	Lcom/tencent/mobileqq/msf/sdk/QNotificationManager;
    //   48: ldc 94
    //   50: ldc 24
    //   52: invokevirtual 291	com/tencent/mobileqq/msf/sdk/QNotificationManager:cancel	(Ljava/lang/String;I)V
    //   55: aload_0
    //   56: getfield 51	com/tencent/av/utils/PSTNNotification:jdField_a_of_type_JavaUtilStack	Ljava/util/Stack;
    //   59: invokevirtual 294	java/util/Stack:size	()I
    //   62: ifle +68 -> 130
    //   65: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +12 -> 80
    //   71: ldc 94
    //   73: iconst_2
    //   74: ldc_w 296
    //   77: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aload_0
    //   81: getfield 51	com/tencent/av/utils/PSTNNotification:jdField_a_of_type_JavaUtilStack	Ljava/util/Stack;
    //   84: invokevirtual 300	java/util/Stack:pop	()Ljava/lang/Object;
    //   87: checkcast 302	kig
    //   90: astore_1
    //   91: aload_0
    //   92: aload_1
    //   93: getfield 303	kig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   96: putfield 36	com/tencent/av/utils/PSTNNotification:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   99: aload_0
    //   100: aload_1
    //   101: getfield 304	kig:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   104: putfield 38	com/tencent/av/utils/PSTNNotification:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   107: aload_0
    //   108: aload_1
    //   109: getfield 305	kig:jdField_a_of_type_Int	I
    //   112: putfield 42	com/tencent/av/utils/PSTNNotification:jdField_b_of_type_Int	I
    //   115: aload_0
    //   116: aload_1
    //   117: getfield 306	kig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   120: putfield 40	com/tencent/av/utils/PSTNNotification:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   123: aload_0
    //   124: invokevirtual 284	com/tencent/av/utils/PSTNNotification:a	()V
    //   127: aload_0
    //   128: monitorexit
    //   129: return
    //   130: aload_0
    //   131: iconst_0
    //   132: putfield 46	com/tencent/av/utils/PSTNNotification:jdField_a_of_type_Boolean	Z
    //   135: aload_0
    //   136: aconst_null
    //   137: putfield 28	com/tencent/av/utils/PSTNNotification:jdField_a_of_type_AndroidAppNotification	Landroid/app/Notification;
    //   140: goto -13 -> 127
    //   143: astore_1
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_1
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	PSTNNotification
    //   90	27	1	localkig	kig
    //   143	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	37	143	finally
    //   37	80	143	finally
    //   80	127	143	finally
    //   130	140	143	finally
  }
  
  public void d()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PSTNNotification", 2, "cancelNotificationEx mIsActive: " + this.jdField_a_of_type_Boolean);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_Int = 0;
        this.jdField_b_of_type_JavaLangString = null;
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilStack.clear();
        this.jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.cancel("PSTNNotification", 2130840237);
        this.jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager = null;
        this.jdField_a_of_type_AndroidWidgetRemoteViews = null;
        this.jdField_a_of_type_AndroidAppNotification = null;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.utils.PSTNNotification
 * JD-Core Version:    0.7.0.1
 */