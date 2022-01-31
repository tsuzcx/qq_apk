package com.tencent.mobileqq.app;

import alse;
import java.util.ArrayList;

class MessageHandler$MessageHandleThread
  extends Thread
{
  ArrayList<alse> a;
  public boolean a;
  public volatile boolean b;
  
  public MessageHandler$MessageHandleThread(ArrayList<alse> paramArrayList)
  {
    this.jdField_a_of_type_Boolean = true;
    Object localObject;
    this.jdField_a_of_type_JavaUtilArrayList = localObject;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.notifyAll();
      return;
    }
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +31 -> 34
    //   6: ldc 43
    //   8: iconst_2
    //   9: new 45	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   16: ldc 48
    //   18: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 56	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:getName	()Ljava/lang/String;
    //   25: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: iconst_0
    //   35: istore_1
    //   36: aload_0
    //   37: getfield 20	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:jdField_a_of_type_Boolean	Z
    //   40: ifeq +1267 -> 1307
    //   43: iload_1
    //   44: iconst_2
    //   45: if_icmplt +13 -> 58
    //   48: aload_0
    //   49: getfield 22	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   52: invokevirtual 69	java/util/ArrayList:size	()I
    //   55: ifle +1252 -> 1307
    //   58: ldc 71
    //   60: invokestatic 76	bhxr:a	(Ljava/lang/String;)V
    //   63: iload_1
    //   64: istore_2
    //   65: aload_0
    //   66: getfield 22	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   69: astore 12
    //   71: iload_1
    //   72: istore_2
    //   73: aload 12
    //   75: monitorenter
    //   76: iload_1
    //   77: istore_2
    //   78: aload_0
    //   79: getfield 22	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   82: invokevirtual 69	java/util/ArrayList:size	()I
    //   85: ifle +579 -> 664
    //   88: iload_1
    //   89: istore_2
    //   90: aload_0
    //   91: getfield 22	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   94: iconst_0
    //   95: invokevirtual 80	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   98: checkcast 82	alse
    //   101: astore 11
    //   103: iconst_0
    //   104: istore_1
    //   105: aload 12
    //   107: monitorexit
    //   108: aload_0
    //   109: iconst_1
    //   110: putfield 33	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:b	Z
    //   113: aload 11
    //   115: ifnull +204 -> 319
    //   118: lconst_0
    //   119: lstore 4
    //   121: iconst_0
    //   122: istore_3
    //   123: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +81 -> 207
    //   129: invokestatic 88	java/lang/System:currentTimeMillis	()J
    //   132: lstore 6
    //   134: aload 11
    //   136: getfield 91	alse:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   139: ifnull +605 -> 744
    //   142: aload 11
    //   144: getfield 91	alse:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   147: invokevirtual 94	java/lang/Object:hashCode	()I
    //   150: istore_2
    //   151: iload_2
    //   152: istore_3
    //   153: lload 6
    //   155: lstore 4
    //   157: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +47 -> 207
    //   163: ldc 43
    //   165: iconst_2
    //   166: new 45	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   173: ldc 96
    //   175: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 11
    //   180: getfield 99	alse:jdField_a_of_type_Int	I
    //   183: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   186: ldc 104
    //   188: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: iload_2
    //   192: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: lload 6
    //   203: lstore 4
    //   205: iload_2
    //   206: istore_3
    //   207: aload 11
    //   209: getfield 99	alse:jdField_a_of_type_Int	I
    //   212: tableswitch	default:+1140 -> 1352, 1:+537->749, 2:+583->795, 3:+616->828, 4:+641->853, 5:+852->1064
    //   249: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   252: getfield 110	com/tencent/mobileqq/app/MessageHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   255: getfield 115	com/tencent/mobileqq/app/QQAppInterface:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   258: invokevirtual 119	com/tencent/mobileqq/app/automator/Automator:d	()V
    //   261: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq +55 -> 319
    //   267: ldc 43
    //   269: iconst_2
    //   270: new 45	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   277: ldc 121
    //   279: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload 11
    //   284: getfield 99	alse:jdField_a_of_type_Int	I
    //   287: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   290: ldc 104
    //   292: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: iload_3
    //   296: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   299: ldc 123
    //   301: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokestatic 88	java/lang/System:currentTimeMillis	()J
    //   307: lload 4
    //   309: lsub
    //   310: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   313: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aload_0
    //   320: iconst_0
    //   321: putfield 33	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:b	Z
    //   324: aload_0
    //   325: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   328: invokestatic 129	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Landroid/util/Pair;
    //   331: ifnull +223 -> 554
    //   334: aload_0
    //   335: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   338: invokestatic 132	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Z
    //   341: ifeq +213 -> 554
    //   344: aload_0
    //   345: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   348: invokestatic 134	com/tencent/mobileqq/app/MessageHandler:b	(Lcom/tencent/mobileqq/app/MessageHandler;)Z
    //   351: ifeq +203 -> 554
    //   354: aload_0
    //   355: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   358: invokestatic 137	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Ljava/util/concurrent/atomic/AtomicBoolean;
    //   361: astore 11
    //   363: aload 11
    //   365: monitorenter
    //   366: aload_0
    //   367: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   370: invokestatic 129	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Landroid/util/Pair;
    //   373: ifnull +178 -> 551
    //   376: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   379: ifeq +11 -> 390
    //   382: ldc 43
    //   384: iconst_2
    //   385: ldc 139
    //   387: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: iconst_2
    //   391: anewarray 141	java/lang/Long
    //   394: astore 12
    //   396: aload 12
    //   398: iconst_0
    //   399: aload_0
    //   400: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   403: invokestatic 129	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Landroid/util/Pair;
    //   406: getfield 146	android/util/Pair:first	Ljava/lang/Object;
    //   409: checkcast 148	RegisterProxySvcPack/RegisterPushNotice
    //   412: getfield 152	RegisterProxySvcPack/RegisterPushNotice:ulTimeOutFlag	J
    //   415: invokestatic 156	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   418: aastore
    //   419: aload 12
    //   421: iconst_1
    //   422: aload_0
    //   423: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   426: invokestatic 129	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Landroid/util/Pair;
    //   429: getfield 159	android/util/Pair:second	Ljava/lang/Object;
    //   432: checkcast 141	java/lang/Long
    //   435: aastore
    //   436: aload_0
    //   437: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   440: invokestatic 129	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Landroid/util/Pair;
    //   443: getfield 146	android/util/Pair:first	Ljava/lang/Object;
    //   446: checkcast 148	RegisterProxySvcPack/RegisterPushNotice
    //   449: getfield 162	RegisterProxySvcPack/RegisterPushNotice:uFlag	J
    //   452: lconst_1
    //   453: land
    //   454: lconst_1
    //   455: lcmp
    //   456: ifne +829 -> 1285
    //   459: iconst_1
    //   460: istore 10
    //   462: aload_0
    //   463: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   466: aconst_null
    //   467: invokestatic 165	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;Landroid/util/Pair;)Landroid/util/Pair;
    //   470: pop
    //   471: aload 12
    //   473: iconst_1
    //   474: aaload
    //   475: invokevirtual 168	java/lang/Long:longValue	()J
    //   478: lconst_1
    //   479: lcmp
    //   480: ifeq +29 -> 509
    //   483: aload_0
    //   484: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   487: getfield 171	com/tencent/mobileqq/app/MessageHandler:a	Layvc;
    //   490: invokevirtual 176	ayvc:c	()Z
    //   493: ifeq +16 -> 509
    //   496: aload_0
    //   497: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   500: getfield 171	com/tencent/mobileqq/app/MessageHandler:a	Layvc;
    //   503: invokevirtual 178	ayvc:b	()Z
    //   506: ifne +24 -> 530
    //   509: aload_0
    //   510: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   513: invokevirtual 181	com/tencent/mobileqq/app/MessageHandler:j	()V
    //   516: aload_0
    //   517: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   520: sipush 4013
    //   523: iload 10
    //   525: aload 12
    //   527: invokevirtual 185	com/tencent/mobileqq/app/MessageHandler:notifyUI	(IZLjava/lang/Object;)V
    //   530: aload_0
    //   531: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   534: invokestatic 137	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Ljava/util/concurrent/atomic/AtomicBoolean;
    //   537: iconst_1
    //   538: invokevirtual 191	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   541: aload_0
    //   542: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   545: invokestatic 137	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Ljava/util/concurrent/atomic/AtomicBoolean;
    //   548: invokevirtual 30	java/lang/Object:notifyAll	()V
    //   551: aload 11
    //   553: monitorexit
    //   554: aload_0
    //   555: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   558: invokestatic 193	com/tencent/mobileqq/app/MessageHandler:c	(Lcom/tencent/mobileqq/app/MessageHandler;)Z
    //   561: ifeq +15 -> 576
    //   564: aload_0
    //   565: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   568: sipush 4017
    //   571: iconst_1
    //   572: aconst_null
    //   573: invokevirtual 185	com/tencent/mobileqq/app/MessageHandler:notifyUI	(IZLjava/lang/Object;)V
    //   576: aload_0
    //   577: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   580: getfield 196	com/tencent/mobileqq/app/MessageHandler:e	Z
    //   583: ifeq +72 -> 655
    //   586: aload_0
    //   587: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   590: invokestatic 132	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Z
    //   593: ifeq +62 -> 655
    //   596: aload_0
    //   597: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   600: invokestatic 134	com/tencent/mobileqq/app/MessageHandler:b	(Lcom/tencent/mobileqq/app/MessageHandler;)Z
    //   603: ifeq +52 -> 655
    //   606: aload_0
    //   607: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   610: invokestatic 137	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Ljava/util/concurrent/atomic/AtomicBoolean;
    //   613: astore 11
    //   615: aload 11
    //   617: monitorenter
    //   618: aload_0
    //   619: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   622: invokestatic 137	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Ljava/util/concurrent/atomic/AtomicBoolean;
    //   625: invokevirtual 199	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   628: ifne +24 -> 652
    //   631: aload_0
    //   632: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   635: invokestatic 137	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Ljava/util/concurrent/atomic/AtomicBoolean;
    //   638: iconst_1
    //   639: invokevirtual 191	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   642: aload_0
    //   643: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   646: invokestatic 137	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;)Ljava/util/concurrent/atomic/AtomicBoolean;
    //   649: invokevirtual 30	java/lang/Object:notifyAll	()V
    //   652: aload 11
    //   654: monitorexit
    //   655: invokestatic 202	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:yield	()V
    //   658: invokestatic 204	bhxr:a	()V
    //   661: goto -625 -> 36
    //   664: iload_1
    //   665: istore_2
    //   666: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   669: ifeq +33 -> 702
    //   672: iload_1
    //   673: istore_2
    //   674: ldc 43
    //   676: iconst_2
    //   677: new 45	java/lang/StringBuilder
    //   680: dup
    //   681: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   684: ldc 206
    //   686: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: aload_0
    //   690: invokevirtual 56	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:getName	()Ljava/lang/String;
    //   693: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   702: iload_1
    //   703: istore_2
    //   704: aload_0
    //   705: getfield 22	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   708: ldc2_w 207
    //   711: invokevirtual 212	java/lang/Object:wait	(J)V
    //   714: iload_1
    //   715: iconst_1
    //   716: iadd
    //   717: istore_1
    //   718: aconst_null
    //   719: astore 11
    //   721: goto -616 -> 105
    //   724: iload_1
    //   725: istore_2
    //   726: aload 12
    //   728: monitorexit
    //   729: iload_1
    //   730: istore_2
    //   731: aload 11
    //   733: athrow
    //   734: astore 11
    //   736: iload_2
    //   737: istore_1
    //   738: invokestatic 204	bhxr:a	()V
    //   741: goto -80 -> 661
    //   744: iconst_0
    //   745: istore_2
    //   746: goto -595 -> 151
    //   749: aload_0
    //   750: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   753: ldc 214
    //   755: invokevirtual 217	com/tencent/mobileqq/app/MessageHandler:a	(Ljava/lang/String;)Labnx;
    //   758: sipush 1002
    //   761: iconst_3
    //   762: anewarray 27	java/lang/Object
    //   765: dup
    //   766: iconst_0
    //   767: aload 11
    //   769: getfield 220	alse:jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   772: aastore
    //   773: dup
    //   774: iconst_1
    //   775: aload 11
    //   777: getfield 223	alse:jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   780: aastore
    //   781: dup
    //   782: iconst_2
    //   783: aload 11
    //   785: getfield 91	alse:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   788: aastore
    //   789: invokevirtual 228	abnx:a	(I[Ljava/lang/Object;)V
    //   792: goto -544 -> 248
    //   795: aload_0
    //   796: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   799: aload 11
    //   801: getfield 220	alse:jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   804: aload 11
    //   806: getfield 223	alse:jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   809: aload 11
    //   811: getfield 91	alse:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   814: invokestatic 231	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/mobileqq/app/MessageHandler;Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)V
    //   817: goto -569 -> 248
    //   820: astore 11
    //   822: invokestatic 204	bhxr:a	()V
    //   825: aload 11
    //   827: athrow
    //   828: aload_0
    //   829: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   832: aload 11
    //   834: getfield 220	alse:jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   837: aload 11
    //   839: getfield 223	alse:jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   842: aload 11
    //   844: getfield 91	alse:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   847: invokestatic 233	com/tencent/mobileqq/app/MessageHandler:b	(Lcom/tencent/mobileqq/app/MessageHandler;Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)V
    //   850: goto -602 -> 248
    //   853: aload 11
    //   855: getfield 91	alse:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   858: ifnull +96 -> 954
    //   861: aload 11
    //   863: getfield 91	alse:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   866: instanceof 235
    //   869: ifeq +85 -> 954
    //   872: aload 11
    //   874: getfield 91	alse:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   877: checkcast 235	MessageSvcPack/GroupInfo
    //   880: astore 12
    //   882: aload_0
    //   883: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   886: getfield 110	com/tencent/mobileqq/app/MessageHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   889: invokevirtual 238	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   892: astore 13
    //   894: aload 12
    //   896: getfield 241	MessageSvcPack/GroupInfo:lGroupCode	J
    //   899: lstore 6
    //   901: aload 12
    //   903: getfield 244	MessageSvcPack/GroupInfo:lMemberSeq	J
    //   906: lstore 8
    //   908: aload_0
    //   909: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   912: getfield 110	com/tencent/mobileqq/app/MessageHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   915: invokevirtual 247	com/tencent/mobileqq/app/QQAppInterface:a	()Layvc;
    //   918: aload 12
    //   920: getfield 241	MessageSvcPack/GroupInfo:lGroupCode	J
    //   923: invokestatic 252	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   926: invokevirtual 255	ayvc:a	(Ljava/lang/String;)I
    //   929: iconst_2
    //   930: if_icmpne +437 -> 1367
    //   933: iconst_1
    //   934: istore 10
    //   936: aload 13
    //   938: lload 6
    //   940: invokestatic 252	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   943: iconst_1
    //   944: lload 8
    //   946: iload 10
    //   948: invokevirtual 260	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;IJZ)V
    //   951: goto -703 -> 248
    //   954: aload 11
    //   956: getfield 91	alse:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   959: ifnull -711 -> 248
    //   962: aload 11
    //   964: getfield 91	alse:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   967: instanceof 262
    //   970: ifeq -722 -> 248
    //   973: aload 11
    //   975: getfield 91	alse:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   978: checkcast 262	msf/registerproxy/register_proxy$GroupList
    //   981: astore 12
    //   983: aload_0
    //   984: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   987: getfield 110	com/tencent/mobileqq/app/MessageHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   990: invokevirtual 238	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   993: astore 13
    //   995: aload 12
    //   997: getfield 266	msf/registerproxy/register_proxy$GroupList:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1000: invokevirtual 270	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1003: lstore 6
    //   1005: aload 12
    //   1007: getfield 273	msf/registerproxy/register_proxy$GroupList:member_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1010: invokevirtual 270	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1013: lstore 8
    //   1015: aload_0
    //   1016: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1019: getfield 110	com/tencent/mobileqq/app/MessageHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1022: invokevirtual 247	com/tencent/mobileqq/app/QQAppInterface:a	()Layvc;
    //   1025: aload 12
    //   1027: getfield 266	msf/registerproxy/register_proxy$GroupList:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1030: invokevirtual 270	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1033: invokestatic 252	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1036: invokevirtual 255	ayvc:a	(Ljava/lang/String;)I
    //   1039: iconst_2
    //   1040: if_icmpne +333 -> 1373
    //   1043: iconst_1
    //   1044: istore 10
    //   1046: aload 13
    //   1048: lload 6
    //   1050: invokestatic 252	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1053: iconst_1
    //   1054: lload 8
    //   1056: iload 10
    //   1058: invokevirtual 260	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;IJZ)V
    //   1061: goto -813 -> 248
    //   1064: aload 11
    //   1066: getfield 91	alse:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   1069: ifnull +98 -> 1167
    //   1072: aload 11
    //   1074: getfield 91	alse:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   1077: instanceof 275
    //   1080: ifeq +87 -> 1167
    //   1083: aload 11
    //   1085: getfield 91	alse:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   1088: checkcast 275	MessageSvcPack/stConfNumInfo
    //   1091: astore 12
    //   1093: aload_0
    //   1094: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1097: getfield 110	com/tencent/mobileqq/app/MessageHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1100: invokevirtual 238	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1103: astore 13
    //   1105: aload 12
    //   1107: getfield 278	MessageSvcPack/stConfNumInfo:lConfUin	J
    //   1110: lstore 6
    //   1112: aload 12
    //   1114: getfield 281	MessageSvcPack/stConfNumInfo:uMemberMsgSeq	J
    //   1117: lstore 8
    //   1119: aload_0
    //   1120: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1123: getfield 110	com/tencent/mobileqq/app/MessageHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1126: invokevirtual 247	com/tencent/mobileqq/app/QQAppInterface:a	()Layvc;
    //   1129: aload 12
    //   1131: getfield 278	MessageSvcPack/stConfNumInfo:lConfUin	J
    //   1134: invokestatic 252	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1137: invokevirtual 283	ayvc:b	(Ljava/lang/String;)I
    //   1140: iconst_2
    //   1141: if_icmpne +238 -> 1379
    //   1144: iconst_1
    //   1145: istore 10
    //   1147: aload 13
    //   1149: lload 6
    //   1151: invokestatic 252	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1154: sipush 3000
    //   1157: lload 8
    //   1159: iload 10
    //   1161: invokevirtual 260	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;IJZ)V
    //   1164: goto -916 -> 248
    //   1167: aload 11
    //   1169: getfield 91	alse:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   1172: ifnull -924 -> 248
    //   1175: aload 11
    //   1177: getfield 91	alse:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   1180: instanceof 285
    //   1183: ifeq -935 -> 248
    //   1186: aload 11
    //   1188: getfield 91	alse:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   1191: checkcast 285	msf/registerproxy/register_proxy$DiscussList
    //   1194: astore 12
    //   1196: aload_0
    //   1197: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1200: getfield 110	com/tencent/mobileqq/app/MessageHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1203: invokevirtual 238	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1206: astore 13
    //   1208: aload 12
    //   1210: getfield 288	msf/registerproxy/register_proxy$DiscussList:discuss_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1213: invokevirtual 270	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1216: lstore 6
    //   1218: aload 12
    //   1220: getfield 289	msf/registerproxy/register_proxy$DiscussList:member_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1223: invokevirtual 270	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1226: lstore 8
    //   1228: aload_0
    //   1229: getfield 15	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:this$0	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1232: getfield 110	com/tencent/mobileqq/app/MessageHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1235: invokevirtual 247	com/tencent/mobileqq/app/QQAppInterface:a	()Layvc;
    //   1238: aload 12
    //   1240: getfield 288	msf/registerproxy/register_proxy$DiscussList:discuss_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1243: invokevirtual 270	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1246: invokestatic 252	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1249: invokevirtual 283	ayvc:b	(Ljava/lang/String;)I
    //   1252: iconst_2
    //   1253: if_icmpne +26 -> 1279
    //   1256: iconst_1
    //   1257: istore 10
    //   1259: aload 13
    //   1261: lload 6
    //   1263: invokestatic 252	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1266: sipush 3000
    //   1269: lload 8
    //   1271: iload 10
    //   1273: invokevirtual 260	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;IJZ)V
    //   1276: goto -1028 -> 248
    //   1279: iconst_0
    //   1280: istore 10
    //   1282: goto -23 -> 1259
    //   1285: iconst_0
    //   1286: istore 10
    //   1288: goto -826 -> 462
    //   1291: astore 12
    //   1293: aload 11
    //   1295: monitorexit
    //   1296: aload 12
    //   1298: athrow
    //   1299: astore 12
    //   1301: aload 11
    //   1303: monitorexit
    //   1304: aload 12
    //   1306: athrow
    //   1307: aload_0
    //   1308: invokevirtual 290	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:a	()V
    //   1311: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1314: ifeq +32 -> 1346
    //   1317: ldc 43
    //   1319: iconst_2
    //   1320: new 45	java/lang/StringBuilder
    //   1323: dup
    //   1324: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   1327: ldc_w 292
    //   1330: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1333: aload_0
    //   1334: invokevirtual 56	com/tencent/mobileqq/app/MessageHandler$MessageHandleThread:getName	()Ljava/lang/String;
    //   1337: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1343: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1346: return
    //   1347: astore 11
    //   1349: goto -625 -> 724
    //   1352: goto -1104 -> 248
    //   1355: astore 11
    //   1357: iload_2
    //   1358: istore_1
    //   1359: goto -635 -> 724
    //   1362: astore 11
    //   1364: goto -626 -> 738
    //   1367: iconst_0
    //   1368: istore 10
    //   1370: goto -434 -> 936
    //   1373: iconst_0
    //   1374: istore 10
    //   1376: goto -330 -> 1046
    //   1379: iconst_0
    //   1380: istore 10
    //   1382: goto -235 -> 1147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1385	0	this	MessageHandleThread
    //   35	1324	1	i	int
    //   64	1294	2	j	int
    //   122	174	3	k	int
    //   119	189	4	l1	long
    //   132	1130	6	l2	long
    //   906	364	8	l3	long
    //   460	921	10	bool	boolean
    //   734	76	11	localException1	java.lang.Exception
    //   820	482	11	localObject2	Object
    //   1347	1	11	localObject3	Object
    //   1355	1	11	localObject4	Object
    //   1362	1	11	localException2	java.lang.Exception
    //   69	1170	12	localObject5	Object
    //   1291	6	12	localObject6	Object
    //   1299	6	12	localObject7	Object
    //   892	368	13	localQQMessageFacade	com.tencent.imcore.message.QQMessageFacade
    // Exception table:
    //   from	to	target	type
    //   65	71	734	java/lang/Exception
    //   73	76	734	java/lang/Exception
    //   731	734	734	java/lang/Exception
    //   65	71	820	finally
    //   73	76	820	finally
    //   108	113	820	finally
    //   123	151	820	finally
    //   157	201	820	finally
    //   207	248	820	finally
    //   248	319	820	finally
    //   319	366	820	finally
    //   554	576	820	finally
    //   576	618	820	finally
    //   655	658	820	finally
    //   731	734	820	finally
    //   749	792	820	finally
    //   795	817	820	finally
    //   828	850	820	finally
    //   853	933	820	finally
    //   936	951	820	finally
    //   954	1043	820	finally
    //   1046	1061	820	finally
    //   1064	1144	820	finally
    //   1147	1164	820	finally
    //   1167	1256	820	finally
    //   1259	1276	820	finally
    //   1296	1299	820	finally
    //   1304	1307	820	finally
    //   366	390	1291	finally
    //   390	459	1291	finally
    //   462	509	1291	finally
    //   509	530	1291	finally
    //   530	551	1291	finally
    //   551	554	1291	finally
    //   1293	1296	1291	finally
    //   618	652	1299	finally
    //   652	655	1299	finally
    //   1301	1304	1299	finally
    //   105	108	1347	finally
    //   78	88	1355	finally
    //   90	103	1355	finally
    //   666	672	1355	finally
    //   674	702	1355	finally
    //   704	714	1355	finally
    //   726	729	1355	finally
    //   108	113	1362	java/lang/Exception
    //   123	151	1362	java/lang/Exception
    //   157	201	1362	java/lang/Exception
    //   207	248	1362	java/lang/Exception
    //   248	319	1362	java/lang/Exception
    //   319	366	1362	java/lang/Exception
    //   554	576	1362	java/lang/Exception
    //   576	618	1362	java/lang/Exception
    //   655	658	1362	java/lang/Exception
    //   749	792	1362	java/lang/Exception
    //   795	817	1362	java/lang/Exception
    //   828	850	1362	java/lang/Exception
    //   853	933	1362	java/lang/Exception
    //   936	951	1362	java/lang/Exception
    //   954	1043	1362	java/lang/Exception
    //   1046	1061	1362	java/lang/Exception
    //   1064	1144	1362	java/lang/Exception
    //   1147	1164	1362	java/lang/Exception
    //   1167	1256	1362	java/lang/Exception
    //   1259	1276	1362	java/lang/Exception
    //   1296	1299	1362	java/lang/Exception
    //   1304	1307	1362	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.MessageHandleThread
 * JD-Core Version:    0.7.0.1
 */