package com.tencent.mobileqq.activity.specialcare;

class QQSpecialFriendSettingActivity$2
  implements CallBack
{
  QQSpecialFriendSettingActivity$2(QQSpecialFriendSettingActivity paramQQSpecialFriendSettingActivity) {}
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +34 -> 37
    //   6: new 27	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   13: astore_2
    //   14: aload_2
    //   15: ldc 30
    //   17: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_2
    //   22: iload_1
    //   23: invokevirtual 37	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: ldc 39
    //   29: iconst_2
    //   30: aload_2
    //   31: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 47	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: iload_1
    //   38: ifeq +13 -> 51
    //   41: aload_0
    //   42: getfield 12	com/tencent/mobileqq/activity/specialcare/QQSpecialFriendSettingActivity$2:a	Lcom/tencent/mobileqq/activity/specialcare/QQSpecialFriendSettingActivity;
    //   45: invokestatic 51	com/tencent/mobileqq/activity/specialcare/QQSpecialFriendSettingActivity:a	(Lcom/tencent/mobileqq/activity/specialcare/QQSpecialFriendSettingActivity;)V
    //   48: goto +17 -> 65
    //   51: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +11 -> 65
    //   57: ldc 39
    //   59: iconst_2
    //   60: ldc 53
    //   62: invokestatic 56	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: aload_0
    //   66: getfield 12	com/tencent/mobileqq/activity/specialcare/QQSpecialFriendSettingActivity$2:a	Lcom/tencent/mobileqq/activity/specialcare/QQSpecialFriendSettingActivity;
    //   69: invokevirtual 59	com/tencent/mobileqq/activity/specialcare/QQSpecialFriendSettingActivity:stopTitleProgress	()Z
    //   72: pop
    //   73: return
    //   74: astore_2
    //   75: goto +11 -> 86
    //   78: astore_2
    //   79: aload_2
    //   80: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   83: goto -18 -> 65
    //   86: aload_0
    //   87: getfield 12	com/tencent/mobileqq/activity/specialcare/QQSpecialFriendSettingActivity$2:a	Lcom/tencent/mobileqq/activity/specialcare/QQSpecialFriendSettingActivity;
    //   90: invokevirtual 59	com/tencent/mobileqq/activity/specialcare/QQSpecialFriendSettingActivity:stopTitleProgress	()Z
    //   93: pop
    //   94: goto +5 -> 99
    //   97: aload_2
    //   98: athrow
    //   99: goto -2 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	2
    //   0	102	1	paramBoolean	boolean
    //   13	18	2	localStringBuilder	java.lang.StringBuilder
    //   74	1	2	localObject	Object
    //   78	20	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   41	48	74	finally
    //   51	65	74	finally
    //   79	83	74	finally
    //   41	48	78	java/lang/Exception
    //   51	65	78	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity.2
 * JD-Core Version:    0.7.0.1
 */