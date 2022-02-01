package com.tencent.mobileqq.activity.recent.config.cache;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;

class NewFriendCacheProcessor$1
  implements Runnable
{
  NewFriendCacheProcessor$1(NewFriendCacheProcessor paramNewFriendCacheProcessor, QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +16 -> 19
    //   6: aload_0
    //   7: getfield 16	com/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor$1:this$0	Lcom/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor;
    //   10: getfield 38	com/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor:a	Ljava/lang/String;
    //   13: iconst_2
    //   14: ldc 40
    //   16: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: getfield 18	com/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor$1:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   23: invokevirtual 50	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   26: ldc 52
    //   28: ldc 54
    //   30: iconst_1
    //   31: anewarray 56	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: getstatic 61	com/tencent/mobileqq/app/AppConstants:RECOMMEND_CONTACT_UIN	Ljava/lang/String;
    //   39: aastore
    //   40: invokevirtual 67	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   43: istore_1
    //   44: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq +41 -> 88
    //   50: aload_0
    //   51: getfield 16	com/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor$1:this$0	Lcom/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor;
    //   54: getfield 38	com/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor:a	Ljava/lang/String;
    //   57: astore_2
    //   58: new 69	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   65: astore_3
    //   66: aload_3
    //   67: ldc 72
    //   69: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_3
    //   74: iload_1
    //   75: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_2
    //   80: iconst_2
    //   81: aload_3
    //   82: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: aload_0
    //   89: getfield 20	com/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor$1:b	Landroid/content/SharedPreferences;
    //   92: invokeinterface 89 1 0
    //   97: ldc 91
    //   99: iconst_0
    //   100: invokeinterface 97 3 0
    //   105: invokeinterface 100 1 0
    //   110: pop
    //   111: return
    //   112: astore_2
    //   113: goto +28 -> 141
    //   116: astore_2
    //   117: aload_2
    //   118: invokevirtual 103	java/lang/Exception:printStackTrace	()V
    //   121: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   124: ifeq +16 -> 140
    //   127: aload_0
    //   128: getfield 16	com/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor$1:this$0	Lcom/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor;
    //   131: getfield 38	com/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor:a	Ljava/lang/String;
    //   134: iconst_2
    //   135: ldc 105
    //   137: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: return
    //   141: aload_0
    //   142: getfield 20	com/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor$1:b	Landroid/content/SharedPreferences;
    //   145: invokeinterface 89 1 0
    //   150: ldc 91
    //   152: iconst_0
    //   153: invokeinterface 97 3 0
    //   158: invokeinterface 100 1 0
    //   163: pop
    //   164: aload_2
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	1
    //   43	32	1	i	int
    //   57	23	2	str	java.lang.String
    //   112	1	2	localObject	Object
    //   116	49	2	localException	java.lang.Exception
    //   65	17	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   19	88	112	finally
    //   117	140	112	finally
    //   19	88	116	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.NewFriendCacheProcessor.1
 * JD-Core Version:    0.7.0.1
 */