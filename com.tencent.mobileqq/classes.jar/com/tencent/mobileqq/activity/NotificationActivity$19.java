package com.tencent.mobileqq.activity;

import android.content.DialogInterface.OnClickListener;

class NotificationActivity$19
  implements DialogInterface.OnClickListener
{
  NotificationActivity$19(NotificationActivity paramNotificationActivity, String paramString) {}
  
  /* Error */
  public void onClick(android.content.DialogInterface paramDialogInterface, int paramInt)
  {
    // Byte code:
    //   0: new 25	android/content/Intent
    //   3: dup
    //   4: ldc 27
    //   6: aload_0
    //   7: getfield 15	com/tencent/mobileqq/activity/NotificationActivity$19:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10: invokestatic 33	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   13: invokespecial 36	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   16: astore_1
    //   17: aload_0
    //   18: getfield 13	com/tencent/mobileqq/activity/NotificationActivity$19:jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   21: aload_1
    //   22: invokevirtual 42	com/tencent/mobileqq/activity/NotificationActivity:startActivity	(Landroid/content/Intent;)V
    //   25: aconst_null
    //   26: ldc 44
    //   28: ldc 46
    //   30: ldc 48
    //   32: ldc 50
    //   34: ldc 52
    //   36: iconst_0
    //   37: iconst_0
    //   38: ldc 48
    //   40: ldc 48
    //   42: ldc 48
    //   44: ldc 48
    //   46: invokestatic 58	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   49: goto +81 -> 130
    //   52: astore_1
    //   53: goto +73 -> 126
    //   56: astore_1
    //   57: aconst_null
    //   58: ldc 44
    //   60: ldc 46
    //   62: ldc 48
    //   64: ldc 50
    //   66: ldc 52
    //   68: iconst_0
    //   69: iconst_0
    //   70: ldc 48
    //   72: ldc 48
    //   74: ldc 48
    //   76: ldc 48
    //   78: invokestatic 58	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   81: goto +8 -> 89
    //   84: astore_3
    //   85: aload_3
    //   86: invokevirtual 61	java/lang/Exception:printStackTrace	()V
    //   89: aload_0
    //   90: getfield 13	com/tencent/mobileqq/activity/NotificationActivity$19:jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   93: invokevirtual 64	com/tencent/mobileqq/activity/NotificationActivity:finish	()V
    //   96: aload_1
    //   97: athrow
    //   98: aconst_null
    //   99: ldc 44
    //   101: ldc 46
    //   103: ldc 48
    //   105: ldc 50
    //   107: ldc 52
    //   109: iconst_0
    //   110: iconst_0
    //   111: ldc 48
    //   113: ldc 48
    //   115: ldc 48
    //   117: ldc 48
    //   119: invokestatic 58	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   122: goto +8 -> 130
    //   125: astore_1
    //   126: aload_1
    //   127: invokevirtual 61	java/lang/Exception:printStackTrace	()V
    //   130: aload_0
    //   131: getfield 13	com/tencent/mobileqq/activity/NotificationActivity$19:jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   134: invokevirtual 64	com/tencent/mobileqq/activity/NotificationActivity:finish	()V
    //   137: return
    //   138: astore_1
    //   139: goto -41 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	19
    //   0	142	1	paramDialogInterface	android.content.DialogInterface
    //   0	142	2	paramInt	int
    //   84	2	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   25	49	52	java/lang/Exception
    //   0	25	56	finally
    //   57	81	84	java/lang/Exception
    //   98	122	125	java/lang/Exception
    //   0	25	138	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.19
 * JD-Core Version:    0.7.0.1
 */