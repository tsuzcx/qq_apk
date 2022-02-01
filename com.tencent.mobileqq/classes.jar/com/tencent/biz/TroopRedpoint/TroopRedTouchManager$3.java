package com.tencent.biz.TroopRedpoint;

import tencent.im.oidb.cmd0x791.oidb_0x791.GetRedDotRes;

class TroopRedTouchManager$3
  implements Runnable
{
  TroopRedTouchManager$3(TroopRedTouchManager paramTroopRedTouchManager, oidb_0x791.GetRedDotRes paramGetRedDotRes) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/biz/TroopRedpoint/TroopRedTouchManager$3:this$0	Lcom/tencent/biz/TroopRedpoint/TroopRedTouchManager;
    //   4: getfield 28	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: invokevirtual 34	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   10: invokevirtual 40	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   13: astore_2
    //   14: new 42	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   21: astore_3
    //   22: aload_3
    //   23: ldc 45
    //   25: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_3
    //   30: aload_0
    //   31: getfield 14	com/tencent/biz/TroopRedpoint/TroopRedTouchManager$3:this$0	Lcom/tencent/biz/TroopRedpoint/TroopRedTouchManager;
    //   34: getfield 28	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: invokevirtual 53	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   40: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: new 55	java/io/File
    //   47: dup
    //   48: aload_2
    //   49: aload_3
    //   50: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 61	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   56: invokevirtual 64	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   59: astore_3
    //   60: aload_0
    //   61: getfield 14	com/tencent/biz/TroopRedpoint/TroopRedTouchManager$3:this$0	Lcom/tencent/biz/TroopRedpoint/TroopRedTouchManager;
    //   64: astore_2
    //   65: aload_2
    //   66: monitorenter
    //   67: iconst_0
    //   68: istore_1
    //   69: aload_3
    //   70: aload_0
    //   71: getfield 16	com/tencent/biz/TroopRedpoint/TroopRedTouchManager$3:a	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   74: invokevirtual 70	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:toByteArray	()[B
    //   77: iconst_0
    //   78: invokestatic 76	com/tencent/mobileqq/utils/FileUtils:pushData2File	(Ljava/lang/String;[BZ)Z
    //   81: pop
    //   82: goto +12 -> 94
    //   85: astore_3
    //   86: goto +113 -> 199
    //   89: astore_3
    //   90: aload_3
    //   91: invokevirtual 79	java/lang/Exception:printStackTrace	()V
    //   94: new 42	java/lang/StringBuilder
    //   97: dup
    //   98: ldc 81
    //   100: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   103: astore_3
    //   104: iload_1
    //   105: aload_0
    //   106: getfield 16	com/tencent/biz/TroopRedpoint/TroopRedTouchManager$3:a	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   109: getfield 88	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:rpt_msg_reddot_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   112: invokevirtual 94	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   115: if_icmpge +32 -> 147
    //   118: aload_3
    //   119: aload_0
    //   120: getfield 16	com/tencent/biz/TroopRedpoint/TroopRedTouchManager$3:a	Ltencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes;
    //   123: getfield 88	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:rpt_msg_reddot_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   126: iload_1
    //   127: invokevirtual 98	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   130: checkcast 100	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo
    //   133: invokestatic 103	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:a	(Ltencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo;)Ljava/lang/String;
    //   136: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: iload_1
    //   141: iconst_1
    //   142: iadd
    //   143: istore_1
    //   144: goto -40 -> 104
    //   147: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +46 -> 196
    //   153: new 42	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   160: astore 4
    //   162: aload 4
    //   164: aload_0
    //   165: getfield 14	com/tencent/biz/TroopRedpoint/TroopRedTouchManager$3:this$0	Lcom/tencent/biz/TroopRedpoint/TroopRedTouchManager;
    //   168: getfield 113	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:c	Ljava/lang/String;
    //   171: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 4
    //   177: ldc 115
    //   179: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 4
    //   185: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: iconst_2
    //   189: aload_3
    //   190: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload_2
    //   197: monitorexit
    //   198: return
    //   199: aload_2
    //   200: monitorexit
    //   201: goto +5 -> 206
    //   204: aload_3
    //   205: athrow
    //   206: goto -2 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	3
    //   68	76	1	i	int
    //   13	187	2	localObject1	Object
    //   21	49	3	localObject2	Object
    //   85	1	3	localObject3	Object
    //   89	2	3	localException	java.lang.Exception
    //   103	102	3	localStringBuilder1	java.lang.StringBuilder
    //   160	24	4	localStringBuilder2	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   69	82	85	finally
    //   90	94	85	finally
    //   94	104	85	finally
    //   104	140	85	finally
    //   147	196	85	finally
    //   196	198	85	finally
    //   199	201	85	finally
    //   69	82	89	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchManager.3
 * JD-Core Version:    0.7.0.1
 */