package com.tencent.mobileqq.activity.recent.config.cache;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;

class NewFriendCacheProcessor$2
  implements Runnable
{
  NewFriendCacheProcessor$2(NewFriendCacheProcessor paramNewFriendCacheProcessor, QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +16 -> 19
    //   6: aload_0
    //   7: getfield 16	com/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor$2:this$0	Lcom/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor;
    //   10: getfield 38	com/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor:a	Ljava/lang/String;
    //   13: iconst_2
    //   14: ldc 40
    //   16: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: getfield 18	com/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor$2:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   23: invokevirtual 50	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   26: astore_2
    //   27: aload_2
    //   28: ldc 52
    //   30: ldc 54
    //   32: iconst_1
    //   33: anewarray 56	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: getstatic 61	com/tencent/mobileqq/app/AppConstants:RECOMMEND_CONTACT_UIN	Ljava/lang/String;
    //   41: aastore
    //   42: invokevirtual 67	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   45: istore_1
    //   46: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +45 -> 94
    //   52: aload_0
    //   53: getfield 16	com/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor$2:this$0	Lcom/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor;
    //   56: getfield 38	com/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor:a	Ljava/lang/String;
    //   59: astore_3
    //   60: new 69	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   67: astore 4
    //   69: aload 4
    //   71: ldc 72
    //   73: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 4
    //   79: iload_1
    //   80: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_3
    //   85: iconst_2
    //   86: aload 4
    //   88: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: aload_2
    //   95: invokestatic 88	com/tencent/mobileqq/data/ConversationInfo:getConversationInfoTableName	()Ljava/lang/String;
    //   98: ldc 54
    //   100: iconst_1
    //   101: anewarray 56	java/lang/String
    //   104: dup
    //   105: iconst_0
    //   106: getstatic 61	com/tencent/mobileqq/app/AppConstants:RECOMMEND_CONTACT_UIN	Ljava/lang/String;
    //   109: aastore
    //   110: invokevirtual 67	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   113: istore_1
    //   114: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +45 -> 162
    //   120: aload_0
    //   121: getfield 16	com/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor$2:this$0	Lcom/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor;
    //   124: getfield 38	com/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor:a	Ljava/lang/String;
    //   127: astore_3
    //   128: new 69	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   135: astore 4
    //   137: aload 4
    //   139: ldc 90
    //   141: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 4
    //   147: iload_1
    //   148: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload_3
    //   153: iconst_2
    //   154: aload 4
    //   156: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_2
    //   163: getstatic 61	com/tencent/mobileqq/app/AppConstants:RECOMMEND_CONTACT_UIN	Ljava/lang/String;
    //   166: sipush 4000
    //   169: invokestatic 96	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   172: ldc 98
    //   174: iconst_1
    //   175: anewarray 56	java/lang/String
    //   178: dup
    //   179: iconst_0
    //   180: getstatic 61	com/tencent/mobileqq/app/AppConstants:RECOMMEND_CONTACT_UIN	Ljava/lang/String;
    //   183: aastore
    //   184: invokevirtual 67	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   187: istore_1
    //   188: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq +41 -> 232
    //   194: aload_0
    //   195: getfield 16	com/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor$2:this$0	Lcom/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor;
    //   198: getfield 38	com/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor:a	Ljava/lang/String;
    //   201: astore_2
    //   202: new 69	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   209: astore_3
    //   210: aload_3
    //   211: ldc 100
    //   213: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload_3
    //   218: iload_1
    //   219: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload_2
    //   224: iconst_2
    //   225: aload_3
    //   226: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: aload_0
    //   233: getfield 20	com/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor$2:b	Landroid/content/SharedPreferences;
    //   236: invokeinterface 106 1 0
    //   241: ldc 108
    //   243: iconst_0
    //   244: invokeinterface 114 3 0
    //   249: invokeinterface 117 1 0
    //   254: pop
    //   255: return
    //   256: astore_2
    //   257: goto +28 -> 285
    //   260: astore_2
    //   261: aload_2
    //   262: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   265: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +16 -> 284
    //   271: aload_0
    //   272: getfield 16	com/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor$2:this$0	Lcom/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor;
    //   275: getfield 38	com/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor:a	Ljava/lang/String;
    //   278: iconst_2
    //   279: ldc 122
    //   281: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: return
    //   285: aload_0
    //   286: getfield 20	com/tencent/mobileqq/activity/recent/config/cache/NewFriendCacheProcessor$2:b	Landroid/content/SharedPreferences;
    //   289: invokeinterface 106 1 0
    //   294: ldc 108
    //   296: iconst_0
    //   297: invokeinterface 114 3 0
    //   302: invokeinterface 117 1 0
    //   307: pop
    //   308: aload_2
    //   309: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	2
    //   45	174	1	i	int
    //   26	198	2	localObject1	Object
    //   256	1	2	localObject2	Object
    //   260	49	2	localException	java.lang.Exception
    //   59	167	3	localObject3	Object
    //   67	88	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   19	94	256	finally
    //   94	162	256	finally
    //   162	232	256	finally
    //   261	284	256	finally
    //   19	94	260	java/lang/Exception
    //   94	162	260	java/lang/Exception
    //   162	232	260	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.NewFriendCacheProcessor.2
 * JD-Core Version:    0.7.0.1
 */