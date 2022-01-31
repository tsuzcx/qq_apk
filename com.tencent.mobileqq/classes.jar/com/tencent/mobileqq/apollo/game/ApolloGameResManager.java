package com.tencent.mobileqq.apollo.game;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.util.HashMap;

public class ApolloGameResManager
{
  public static ApolloGameResManager a;
  private static LRULinkedHashMap jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(2);
  private static HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static ApolloGameResManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameResManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameResManager == null) {
        jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameResManager = new ApolloGameResManager();
      }
      return jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameResManager;
    }
    finally {}
  }
  
  public static String a(String paramString)
  {
    return AppConstants.aK + ".apollo/game/" + String.valueOf(paramString);
  }
  
  /* Error */
  public ApolloGameResManager.ApolloGameRes a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +504 -> 508
    //   7: aload_2
    //   8: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +497 -> 508
    //   14: getstatic 24	com/tencent/mobileqq/apollo/game/ApolloGameResManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   17: ifnonnull +13 -> 30
    //   20: new 20	java/util/HashMap
    //   23: dup
    //   24: invokespecial 22	java/util/HashMap:<init>	()V
    //   27: putstatic 24	com/tencent/mobileqq/apollo/game/ApolloGameResManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   30: getstatic 24	com/tencent/mobileqq/apollo/game/ApolloGameResManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   33: astore 4
    //   35: aload 4
    //   37: monitorenter
    //   38: aload_2
    //   39: invokestatic 71	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   42: istore_3
    //   43: getstatic 24	com/tencent/mobileqq/apollo/game/ApolloGameResManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   46: aload_2
    //   47: invokevirtual 75	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   50: checkcast 77	com/tencent/mobileqq/apollo/utils/ApolloGameRscVerify
    //   53: ifnonnull +31 -> 84
    //   56: new 77	com/tencent/mobileqq/apollo/utils/ApolloGameRscVerify
    //   59: dup
    //   60: iload_3
    //   61: invokespecial 78	com/tencent/mobileqq/apollo/utils/ApolloGameRscVerify:<init>	(I)V
    //   64: astore 5
    //   66: aload 5
    //   68: invokevirtual 81	com/tencent/mobileqq/apollo/utils/ApolloGameRscVerify:a	()Z
    //   71: ifeq +228 -> 299
    //   74: getstatic 24	com/tencent/mobileqq/apollo/game/ApolloGameResManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   77: aload_2
    //   78: aload 5
    //   80: invokevirtual 85	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: aload 4
    //   86: monitorexit
    //   87: aload_1
    //   88: aload_2
    //   89: invokestatic 71	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   92: aconst_null
    //   93: iconst_1
    //   94: invokestatic 90	com/tencent/mobileqq/apollo/game/ApolloGameTool:a	(Ljava/lang/String;ILjava/lang/String;Z)Ljava/lang/String;
    //   97: astore 7
    //   99: aload 7
    //   101: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   104: ifne +404 -> 508
    //   107: getstatic 18	com/tencent/mobileqq/apollo/game/ApolloGameResManager:jdField_a_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   110: aload_2
    //   111: invokevirtual 91	com/tencent/util/LRULinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   114: checkcast 93	android/util/LruCache
    //   117: astore 4
    //   119: aload 4
    //   121: ifnonnull +400 -> 521
    //   124: new 95	yvq
    //   127: dup
    //   128: aload_0
    //   129: ldc 96
    //   131: invokespecial 99	yvq:<init>	(Lcom/tencent/mobileqq/apollo/game/ApolloGameResManager;I)V
    //   134: astore 4
    //   136: getstatic 18	com/tencent/mobileqq/apollo/game/ApolloGameResManager:jdField_a_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   139: aload_2
    //   140: aload 4
    //   142: invokevirtual 100	com/tencent/util/LRULinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   145: pop
    //   146: aload 4
    //   148: aload 7
    //   150: invokevirtual 101	android/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   153: checkcast 103	com/tencent/mobileqq/apollo/game/ApolloGameResManager$ApolloGameRes
    //   156: astore_1
    //   157: aload_1
    //   158: astore 5
    //   160: aload_1
    //   161: ifnonnull +135 -> 296
    //   164: getstatic 24	com/tencent/mobileqq/apollo/game/ApolloGameResManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   167: astore 6
    //   169: aload 6
    //   171: monitorenter
    //   172: getstatic 24	com/tencent/mobileqq/apollo/game/ApolloGameResManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   175: aload_2
    //   176: invokevirtual 75	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   179: checkcast 77	com/tencent/mobileqq/apollo/utils/ApolloGameRscVerify
    //   182: astore 5
    //   184: aload_2
    //   185: invokestatic 105	com/tencent/mobileqq/apollo/game/ApolloGameResManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   188: astore_2
    //   189: aload 7
    //   191: new 33	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   198: aload_2
    //   199: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: ldc 107
    //   204: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: ldc 109
    //   212: invokevirtual 113	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   215: astore_2
    //   216: aload 5
    //   218: ifnull +23 -> 241
    //   221: aload 5
    //   223: aload_2
    //   224: invokevirtual 116	com/tencent/mobileqq/apollo/utils/ApolloGameRscVerify:a	(Ljava/lang/String;)Z
    //   227: ifeq +14 -> 241
    //   230: aload 5
    //   232: aload 7
    //   234: aload_2
    //   235: invokevirtual 119	com/tencent/mobileqq/apollo/utils/ApolloGameRscVerify:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   238: ifne +97 -> 335
    //   241: ldc 121
    //   243: iconst_1
    //   244: new 33	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   251: ldc 123
    //   253: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload 7
    //   258: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc 125
    //   263: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_2
    //   267: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc 125
    //   272: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokestatic 131	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   278: invokevirtual 134	java/lang/Thread:getName	()Ljava/lang/String;
    //   281: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: aload 6
    //   292: monitorexit
    //   293: aconst_null
    //   294: astore 5
    //   296: aload 5
    //   298: areturn
    //   299: ldc 121
    //   301: iconst_1
    //   302: ldc 142
    //   304: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: aload 4
    //   309: monitorexit
    //   310: aconst_null
    //   311: areturn
    //   312: astore 5
    //   314: ldc 121
    //   316: iconst_1
    //   317: aload 5
    //   319: iconst_0
    //   320: anewarray 4	java/lang/Object
    //   323: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   326: goto -242 -> 84
    //   329: astore_1
    //   330: aload 4
    //   332: monitorexit
    //   333: aload_1
    //   334: athrow
    //   335: new 103	com/tencent/mobileqq/apollo/game/ApolloGameResManager$ApolloGameRes
    //   338: dup
    //   339: invokespecial 146	com/tencent/mobileqq/apollo/game/ApolloGameResManager$ApolloGameRes:<init>	()V
    //   342: astore 5
    //   344: aload 5
    //   346: astore_2
    //   347: aload 5
    //   349: aload 7
    //   351: putfield 149	com/tencent/mobileqq/apollo/game/ApolloGameResManager$ApolloGameRes:b	Ljava/lang/String;
    //   354: ldc 151
    //   356: astore_1
    //   357: aload 5
    //   359: astore_2
    //   360: aload 7
    //   362: ldc 153
    //   364: invokevirtual 156	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   367: ifeq +45 -> 412
    //   370: ldc 158
    //   372: astore_1
    //   373: aload 5
    //   375: astore_2
    //   376: aload 5
    //   378: aload_1
    //   379: putfield 160	com/tencent/mobileqq/apollo/game/ApolloGameResManager$ApolloGameRes:a	Ljava/lang/String;
    //   382: aload 5
    //   384: astore_2
    //   385: aload 5
    //   387: invokevirtual 162	com/tencent/mobileqq/apollo/game/ApolloGameResManager$ApolloGameRes:a	()V
    //   390: aload 5
    //   392: astore_2
    //   393: aload 4
    //   395: aload 7
    //   397: aload 5
    //   399: invokevirtual 163	android/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   402: pop
    //   403: aload 5
    //   405: astore_2
    //   406: aload 6
    //   408: monitorexit
    //   409: aload 5
    //   411: areturn
    //   412: aload 5
    //   414: astore_2
    //   415: aload 7
    //   417: ldc 165
    //   419: invokevirtual 156	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   422: ifeq +9 -> 431
    //   425: ldc 167
    //   427: astore_1
    //   428: goto -55 -> 373
    //   431: aload 5
    //   433: astore_2
    //   434: aload 7
    //   436: ldc 169
    //   438: invokevirtual 156	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   441: ifne +83 -> 524
    //   444: aload 5
    //   446: astore_2
    //   447: aload 7
    //   449: ldc 171
    //   451: invokevirtual 156	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   454: ifne +70 -> 524
    //   457: aload 5
    //   459: astore_2
    //   460: aload 7
    //   462: ldc 173
    //   464: invokevirtual 156	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   467: ifne +57 -> 524
    //   470: aload 5
    //   472: astore_2
    //   473: aload 7
    //   475: ldc 175
    //   477: invokevirtual 156	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   480: ifeq -107 -> 373
    //   483: goto +41 -> 524
    //   486: aload_1
    //   487: astore_2
    //   488: aload 6
    //   490: monitorexit
    //   491: aload 4
    //   493: athrow
    //   494: astore_2
    //   495: ldc 121
    //   497: iconst_1
    //   498: aload_2
    //   499: iconst_0
    //   500: anewarray 4	java/lang/Object
    //   503: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   506: aload_1
    //   507: areturn
    //   508: aconst_null
    //   509: areturn
    //   510: astore_2
    //   511: goto -16 -> 495
    //   514: astore 4
    //   516: aload_2
    //   517: astore_1
    //   518: goto -32 -> 486
    //   521: goto -375 -> 146
    //   524: ldc 177
    //   526: astore_1
    //   527: goto -154 -> 373
    //   530: astore 4
    //   532: goto -46 -> 486
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	535	0	this	ApolloGameResManager
    //   0	535	1	paramString1	String
    //   0	535	2	paramString2	String
    //   42	19	3	i	int
    //   33	459	4	localObject1	Object
    //   514	1	4	localObject2	Object
    //   530	1	4	localObject3	Object
    //   64	233	5	localObject4	Object
    //   312	6	5	localThrowable	Throwable
    //   342	129	5	localApolloGameRes	ApolloGameResManager.ApolloGameRes
    //   97	377	7	str	String
    // Exception table:
    //   from	to	target	type
    //   38	84	312	java/lang/Throwable
    //   299	307	312	java/lang/Throwable
    //   38	84	329	finally
    //   84	87	329	finally
    //   299	307	329	finally
    //   307	310	329	finally
    //   314	326	329	finally
    //   330	333	329	finally
    //   491	494	494	java/lang/Throwable
    //   164	172	510	java/lang/Throwable
    //   347	354	514	finally
    //   360	370	514	finally
    //   376	382	514	finally
    //   385	390	514	finally
    //   393	403	514	finally
    //   406	409	514	finally
    //   415	425	514	finally
    //   434	444	514	finally
    //   447	457	514	finally
    //   460	470	514	finally
    //   473	483	514	finally
    //   488	491	514	finally
    //   172	216	530	finally
    //   221	241	530	finally
    //   241	293	530	finally
    //   335	344	530	finally
  }
  
  public void a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameResManager != null) {
        jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameResManager = null;
      }
      if (jdField_a_of_type_ComTencentUtilLRULinkedHashMap != null) {
        jdField_a_of_type_ComTencentUtilLRULinkedHashMap.clear();
      }
      if (jdField_a_of_type_JavaUtilHashMap != null)
      {
        jdField_a_of_type_JavaUtilHashMap.clear();
        jdField_a_of_type_JavaUtilHashMap = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameResManager", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameResManager
 * JD-Core Version:    0.7.0.1
 */