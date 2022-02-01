package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

final class ReplyTextItemBuilder$5
  implements Runnable
{
  ReplyTextItemBuilder$5(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, ReplyTextItemBuilder.SourceMessagePulledCallBack paramSourceMessagePulledCallBack, Context paramContext, ChatThumbView paramChatThumbView) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/tencent/mobileqq/activity/aio/item/ReplyTextItemBuilder$5:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   4: astore 4
    //   6: aload 4
    //   8: instanceof 37
    //   11: istore_3
    //   12: aconst_null
    //   13: astore 6
    //   15: iconst_0
    //   16: istore_1
    //   17: iload_3
    //   18: ifeq +30 -> 48
    //   21: aload 4
    //   23: checkcast 37	com/tencent/mobileqq/data/HasSourceMessage
    //   26: astore 4
    //   28: aload 4
    //   30: invokeinterface 41 1 0
    //   35: astore 5
    //   37: aload 4
    //   39: invokeinterface 45 1 0
    //   44: istore_3
    //   45: goto +8 -> 53
    //   48: aconst_null
    //   49: astore 5
    //   51: iconst_0
    //   52: istore_3
    //   53: aload 5
    //   55: ifnonnull +4 -> 59
    //   58: return
    //   59: aload_0
    //   60: getfield 22	com/tencent/mobileqq/activity/aio/item/ReplyTextItemBuilder$5:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   63: invokevirtual 51	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   66: aload_0
    //   67: getfield 20	com/tencent/mobileqq/activity/aio/item/ReplyTextItemBuilder$5:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   70: getfield 57	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   73: aload_0
    //   74: getfield 20	com/tencent/mobileqq/activity/aio/item/ReplyTextItemBuilder$5:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   77: getfield 61	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   80: aload 5
    //   82: getfield 67	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo:mSourceMsgSeq	J
    //   85: invokevirtual 72	com/tencent/imcore/message/QQMessageFacade:c	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   88: astore 7
    //   90: aload 7
    //   92: astore 4
    //   94: aload 7
    //   96: ifnonnull +301 -> 397
    //   99: aload 7
    //   101: astore 4
    //   103: iload_3
    //   104: ifne +293 -> 397
    //   107: aload 7
    //   109: astore 4
    //   111: aload_0
    //   112: getfield 20	com/tencent/mobileqq/activity/aio/item/ReplyTextItemBuilder$5:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   115: getfield 57	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   118: ifnull +279 -> 397
    //   121: aload_0
    //   122: getfield 20	com/tencent/mobileqq/activity/aio/item/ReplyTextItemBuilder$5:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   125: astore 4
    //   127: aload 4
    //   129: instanceof 37
    //   132: ifeq +13 -> 145
    //   135: aload 4
    //   137: checkcast 37	com/tencent/mobileqq/data/HasSourceMessage
    //   140: invokeinterface 75 1 0
    //   145: new 77	android/os/Bundle
    //   148: dup
    //   149: invokespecial 78	android/os/Bundle:<init>	()V
    //   152: astore 4
    //   154: aload_0
    //   155: getfield 22	com/tencent/mobileqq/activity/aio/item/ReplyTextItemBuilder$5:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   158: invokevirtual 51	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   161: astore 9
    //   163: new 80	java/util/ArrayList
    //   166: dup
    //   167: invokespecial 81	java/util/ArrayList:<init>	()V
    //   170: astore 8
    //   172: aload 9
    //   174: getfield 85	com/tencent/imcore/message/QQMessageFacade:f	Ljava/util/concurrent/atomic/AtomicInteger;
    //   177: iconst_1
    //   178: invokevirtual 91	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   181: istore_2
    //   182: aload 4
    //   184: ldc 93
    //   186: iload_2
    //   187: invokevirtual 97	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   190: aload 4
    //   192: ldc 99
    //   194: iconst_0
    //   195: invokevirtual 103	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   198: aload 9
    //   200: getfield 107	com/tencent/imcore/message/QQMessageFacade:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   203: iload_2
    //   204: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: aload 8
    //   209: invokevirtual 119	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   212: pop
    //   213: aload_0
    //   214: getfield 22	com/tencent/mobileqq/activity/aio/item/ReplyTextItemBuilder$5:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   217: invokevirtual 123	com/tencent/mobileqq/app/QQAppInterface:getMsgHandler	()Lcom/tencent/mobileqq/app/MessageHandler;
    //   220: aload_0
    //   221: getfield 20	com/tencent/mobileqq/activity/aio/item/ReplyTextItemBuilder$5:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   224: getfield 57	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   227: aload 5
    //   229: getfield 67	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo:mSourceMsgSeq	J
    //   232: aload 5
    //   234: getfield 67	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo:mSourceMsgSeq	J
    //   237: iconst_1
    //   238: aload 4
    //   240: iconst_0
    //   241: invokevirtual 128	com/tencent/mobileqq/app/MessageHandler:a	(Ljava/lang/String;JJZLandroid/os/Bundle;I)Z
    //   244: pop
    //   245: aload 9
    //   247: getfield 131	com/tencent/imcore/message/QQMessageFacade:h	Ljava/util/concurrent/ConcurrentHashMap;
    //   250: aload_0
    //   251: getfield 20	com/tencent/mobileqq/activity/aio/item/ReplyTextItemBuilder$5:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   254: getfield 57	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   257: aload_0
    //   258: getfield 20	com/tencent/mobileqq/activity/aio/item/ReplyTextItemBuilder$5:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   261: getfield 61	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   264: invokestatic 136	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   267: iconst_0
    //   268: invokestatic 141	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   271: invokevirtual 119	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   274: pop
    //   275: invokestatic 147	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   278: invokestatic 153	com/tencent/mobileqq/utils/NetworkUtil:isNetworkAvailable	(Landroid/content/Context;)Z
    //   281: ifeq +41 -> 322
    //   284: aload 8
    //   286: monitorenter
    //   287: aload 8
    //   289: ldc2_w 154
    //   292: invokevirtual 159	java/lang/Object:wait	(J)V
    //   295: goto +15 -> 310
    //   298: astore 4
    //   300: goto +16 -> 316
    //   303: astore 4
    //   305: aload 4
    //   307: invokevirtual 162	java/lang/InterruptedException:printStackTrace	()V
    //   310: aload 8
    //   312: monitorexit
    //   313: goto +9 -> 322
    //   316: aload 8
    //   318: monitorexit
    //   319: aload 4
    //   321: athrow
    //   322: aload 7
    //   324: astore 4
    //   326: aload 8
    //   328: invokeinterface 168 1 0
    //   333: ifle +64 -> 397
    //   336: aload 7
    //   338: astore 4
    //   340: iload_1
    //   341: aload 8
    //   343: invokeinterface 168 1 0
    //   348: if_icmpge +49 -> 397
    //   351: aload 8
    //   353: iload_1
    //   354: invokeinterface 172 2 0
    //   359: checkcast 53	com/tencent/mobileqq/data/MessageRecord
    //   362: getfield 175	com/tencent/mobileqq/data/MessageRecord:shmsgseq	J
    //   365: aload 5
    //   367: getfield 67	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo:mSourceMsgSeq	J
    //   370: lcmp
    //   371: ifne +19 -> 390
    //   374: aload 8
    //   376: iload_1
    //   377: invokeinterface 172 2 0
    //   382: checkcast 53	com/tencent/mobileqq/data/MessageRecord
    //   385: astore 4
    //   387: goto +10 -> 397
    //   390: iload_1
    //   391: iconst_1
    //   392: iadd
    //   393: istore_1
    //   394: goto -58 -> 336
    //   397: aload_0
    //   398: getfield 20	com/tencent/mobileqq/activity/aio/item/ReplyTextItemBuilder$5:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   401: getfield 61	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   404: ifeq +76 -> 480
    //   407: aload 4
    //   409: instanceof 177
    //   412: ifne +11 -> 423
    //   415: aload 4
    //   417: instanceof 179
    //   420: ifeq +60 -> 480
    //   423: aload 4
    //   425: invokevirtual 182	com/tencent/mobileqq/data/MessageRecord:isLongMsg	()Z
    //   428: ifeq +52 -> 480
    //   431: new 184	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   438: astore 7
    //   440: aload_0
    //   441: getfield 22	com/tencent/mobileqq/activity/aio/item/ReplyTextItemBuilder$5:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   444: aload_0
    //   445: getfield 20	com/tencent/mobileqq/activity/aio/item/ReplyTextItemBuilder$5:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   448: aload 4
    //   450: aload 7
    //   452: invokestatic 190	com/tencent/mobileqq/activity/aio/item/ReplyTextItemBuilder:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/StringBuilder;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   455: astore 5
    //   457: aload 5
    //   459: ifnull +21 -> 480
    //   462: aload 7
    //   464: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: astore 6
    //   469: aload 5
    //   471: astore 4
    //   473: aload 6
    //   475: astore 5
    //   477: goto +7 -> 484
    //   480: aload 6
    //   482: astore 5
    //   484: invokestatic 200	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   487: new 202	com/tencent/mobileqq/activity/aio/item/ReplyTextItemBuilder$5$1
    //   490: dup
    //   491: aload_0
    //   492: aload 4
    //   494: aload 5
    //   496: invokespecial 205	com/tencent/mobileqq/activity/aio/item/ReplyTextItemBuilder$5$1:<init>	(Lcom/tencent/mobileqq/activity/aio/item/ReplyTextItemBuilder$5;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   499: invokevirtual 211	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   502: pop
    //   503: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	504	0	this	5
    //   16	378	1	i	int
    //   181	23	2	j	int
    //   11	93	3	bool	boolean
    //   4	235	4	localObject1	Object
    //   298	1	4	localObject2	Object
    //   303	17	4	localInterruptedException	java.lang.InterruptedException
    //   324	169	4	localObject3	Object
    //   35	460	5	localObject4	Object
    //   13	468	6	str	java.lang.String
    //   88	375	7	localObject5	Object
    //   170	205	8	localArrayList	java.util.ArrayList
    //   161	85	9	localQQMessageFacade	com.tencent.imcore.message.QQMessageFacade
    // Exception table:
    //   from	to	target	type
    //   287	295	298	finally
    //   305	310	298	finally
    //   310	313	298	finally
    //   316	319	298	finally
    //   287	295	303	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */