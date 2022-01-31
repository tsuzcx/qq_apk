package com.tencent.mobileqq.app.automator.step;

import ajsd;
import aklk;
import akll;
import android.os.Build.VERSION;
import aukp;
import aukq;
import aywm;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class CleanCache$1
  implements Runnable
{
  private int a;
  
  CleanCache$1(CleanCache paramCleanCache) {}
  
  /* Error */
  private int a(File paramFile, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 27	java/io/File:exists	()Z
    //   4: ifeq +502 -> 506
    //   7: aload_1
    //   8: invokevirtual 30	java/io/File:isDirectory	()Z
    //   11: ifeq +495 -> 506
    //   14: aload_1
    //   15: invokevirtual 34	java/io/File:listFiles	()[Ljava/io/File;
    //   18: astore 14
    //   20: aload 14
    //   22: ifnonnull +5 -> 27
    //   25: iconst_0
    //   26: ireturn
    //   27: aload 14
    //   29: arraylength
    //   30: istore 5
    //   32: lconst_0
    //   33: lstore 8
    //   35: aload_1
    //   36: getstatic 39	aywm:a	Ljava/io/File;
    //   39: if_acmpne +40 -> 79
    //   42: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +34 -> 79
    //   48: ldc 46
    //   50: iconst_2
    //   51: new 48	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   58: ldc 51
    //   60: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: iload 5
    //   65: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: ldc 60
    //   70: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: iload 5
    //   81: iload_2
    //   82: if_icmple +412 -> 494
    //   85: aload 14
    //   87: new 70	aklm
    //   90: dup
    //   91: aload_0
    //   92: invokespecial 73	aklm:<init>	(Lcom/tencent/mobileqq/app/automator/step/CleanCache$1;)V
    //   95: invokestatic 79	java/util/Arrays:sort	([Ljava/lang/Object;Ljava/util/Comparator;)V
    //   98: aload 14
    //   100: arraylength
    //   101: istore 7
    //   103: iconst_0
    //   104: istore 6
    //   106: iload 5
    //   108: istore 4
    //   110: lload 8
    //   112: lstore 10
    //   114: iload 4
    //   116: istore_2
    //   117: iload 6
    //   119: iload 7
    //   121: if_icmpge +40 -> 161
    //   124: aload 14
    //   126: iload 6
    //   128: aaload
    //   129: astore 15
    //   131: lload 8
    //   133: aload 15
    //   135: invokevirtual 83	java/io/File:length	()J
    //   138: ladd
    //   139: lstore 8
    //   141: aload 15
    //   143: invokevirtual 86	java/io/File:delete	()Z
    //   146: pop
    //   147: iload 4
    //   149: iconst_1
    //   150: isub
    //   151: istore_2
    //   152: iload_2
    //   153: iload_3
    //   154: if_icmpgt +146 -> 300
    //   157: lload 8
    //   159: lstore 10
    //   161: iload 5
    //   163: iload_3
    //   164: isub
    //   165: istore_3
    //   166: invokestatic 91	java/lang/System:currentTimeMillis	()J
    //   169: lstore 12
    //   171: aload 14
    //   173: arraylength
    //   174: istore 4
    //   176: iload 4
    //   178: iload_2
    //   179: isub
    //   180: istore 4
    //   182: iload_3
    //   183: istore_2
    //   184: iload 4
    //   186: aload 14
    //   188: arraylength
    //   189: if_icmpge +146 -> 335
    //   192: aload 14
    //   194: iload 4
    //   196: aaload
    //   197: astore 15
    //   199: lload 10
    //   201: lstore 8
    //   203: iload_2
    //   204: istore_3
    //   205: aload 15
    //   207: invokevirtual 27	java/io/File:exists	()Z
    //   210: ifeq +279 -> 489
    //   213: lload 10
    //   215: lstore 8
    //   217: iload_2
    //   218: istore_3
    //   219: aload 15
    //   221: invokevirtual 94	java/io/File:isFile	()Z
    //   224: ifeq +265 -> 489
    //   227: lload 12
    //   229: aload 15
    //   231: invokevirtual 97	java/io/File:lastModified	()J
    //   234: lsub
    //   235: ldc2_w 98
    //   238: lcmp
    //   239: ifle +96 -> 335
    //   242: lload 10
    //   244: aload 15
    //   246: invokevirtual 83	java/io/File:length	()J
    //   249: ladd
    //   250: lstore 10
    //   252: aload 15
    //   254: invokevirtual 86	java/io/File:delete	()Z
    //   257: pop
    //   258: iload_2
    //   259: iconst_1
    //   260: iadd
    //   261: istore_2
    //   262: lload 10
    //   264: lstore 8
    //   266: iload_2
    //   267: istore_3
    //   268: iload 4
    //   270: sipush 200
    //   273: irem
    //   274: ifne +215 -> 489
    //   277: ldc2_w 100
    //   280: invokestatic 107	java/lang/Thread:sleep	(J)V
    //   283: lload 10
    //   285: lstore 8
    //   287: iload 4
    //   289: iconst_1
    //   290: iadd
    //   291: istore 4
    //   293: lload 8
    //   295: lstore 10
    //   297: goto -113 -> 184
    //   300: iload_2
    //   301: sipush 200
    //   304: irem
    //   305: ifne +9 -> 314
    //   308: ldc2_w 100
    //   311: invokestatic 107	java/lang/Thread:sleep	(J)V
    //   314: iload 6
    //   316: iconst_1
    //   317: iadd
    //   318: istore 6
    //   320: iload_2
    //   321: istore 4
    //   323: goto -213 -> 110
    //   326: astore 15
    //   328: lload 10
    //   330: lstore 8
    //   332: goto -45 -> 287
    //   335: iload_2
    //   336: istore_3
    //   337: aload_1
    //   338: getstatic 39	aywm:a	Ljava/io/File;
    //   341: if_acmpne +141 -> 482
    //   344: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +46 -> 393
    //   350: ldc 46
    //   352: iconst_2
    //   353: new 48	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   360: ldc 109
    //   362: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: iload_2
    //   366: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   369: ldc 111
    //   371: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: lload 10
    //   376: ldc2_w 112
    //   379: ldiv
    //   380: ldc2_w 112
    //   383: ldiv
    //   384: invokevirtual 116	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   387: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   393: iload_2
    //   394: istore_3
    //   395: iload_2
    //   396: ifle +86 -> 482
    //   399: aload_0
    //   400: getfield 14	com/tencent/mobileqq/app/automator/step/CleanCache$1:this$0	Lcom/tencent/mobileqq/app/automator/step/CleanCache;
    //   403: getfield 121	com/tencent/mobileqq/app/automator/step/CleanCache:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   406: getfield 127	com/tencent/mobileqq/app/automator/Automator:mApp	Lcom/tencent/common/app/AppInterface;
    //   409: invokevirtual 132	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   412: invokestatic 137	bbkb:a	(Ljava/lang/String;)J
    //   415: lstore 8
    //   417: invokestatic 142	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   420: ldc2_w 143
    //   423: ldiv
    //   424: lstore 10
    //   426: lload 8
    //   428: lconst_0
    //   429: lcmp
    //   430: ifeq +34 -> 464
    //   433: lload 10
    //   435: lload 8
    //   437: lcmp
    //   438: ifle +26 -> 464
    //   441: invokestatic 150	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   444: invokestatic 155	axrn:a	(Landroid/content/Context;)Laxrn;
    //   447: aconst_null
    //   448: ldc 157
    //   450: iconst_1
    //   451: lload 10
    //   453: lload 8
    //   455: lsub
    //   456: iload_2
    //   457: i2l
    //   458: aconst_null
    //   459: ldc 159
    //   461: invokevirtual 162	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   464: aload_0
    //   465: getfield 14	com/tencent/mobileqq/app/automator/step/CleanCache$1:this$0	Lcom/tencent/mobileqq/app/automator/step/CleanCache;
    //   468: getfield 121	com/tencent/mobileqq/app/automator/step/CleanCache:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   471: getfield 127	com/tencent/mobileqq/app/automator/Automator:mApp	Lcom/tencent/common/app/AppInterface;
    //   474: invokevirtual 132	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   477: invokestatic 165	bbkb:a	(Ljava/lang/String;)V
    //   480: iload_2
    //   481: istore_3
    //   482: iload_3
    //   483: ireturn
    //   484: astore 15
    //   486: goto -172 -> 314
    //   489: iload_3
    //   490: istore_2
    //   491: goto -204 -> 287
    //   494: iconst_0
    //   495: istore_3
    //   496: iload 5
    //   498: istore_2
    //   499: lload 8
    //   501: lstore 10
    //   503: goto -337 -> 166
    //   506: iconst_0
    //   507: istore_3
    //   508: goto -26 -> 482
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	this	1
    //   0	511	1	paramFile	File
    //   0	511	2	paramInt1	int
    //   0	511	3	paramInt2	int
    //   108	214	4	i	int
    //   30	467	5	j	int
    //   104	215	6	k	int
    //   101	21	7	m	int
    //   33	467	8	l1	long
    //   112	390	10	l2	long
    //   169	59	12	l3	long
    //   18	175	14	arrayOfFile	File[]
    //   129	124	15	localFile	File
    //   326	1	15	localInterruptedException1	java.lang.InterruptedException
    //   484	1	15	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   277	283	326	java/lang/InterruptedException
    //   308	314	484	java/lang/InterruptedException
  }
  
  private int a(File[] paramArrayOfFile, int paramInt)
  {
    int i = 0;
    for (;;)
    {
      int j = paramInt;
      if (i < paramArrayOfFile.length)
      {
        File localFile = paramArrayOfFile[i];
        if (localFile.exists()) {
          localFile.delete();
        }
        paramArrayOfFile[i] = null;
        paramInt += 1;
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "onCleanCache->delRemainQQHead. delete QQHead,filePath=" + localFile.getAbsolutePath());
        }
        if (paramInt >= this.a) {
          j = paramInt;
        }
      }
      else
      {
        return j;
      }
      i += 1;
    }
  }
  
  /* Error */
  private File[] a(File[] paramArrayOfFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 10
    //   9: iconst_0
    //   10: istore 5
    //   12: aload_0
    //   13: getfield 14	com/tencent/mobileqq/app/automator/step/CleanCache$1:this$0	Lcom/tencent/mobileqq/app/automator/step/CleanCache;
    //   16: getfield 121	com/tencent/mobileqq/app/automator/step/CleanCache:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   19: getfield 180	com/tencent/mobileqq/app/automator/Automator:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   22: invokevirtual 186	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Laukq;
    //   25: invokevirtual 192	aukq:createEntityManager	()Laukp;
    //   28: astore 7
    //   30: aload 7
    //   32: iconst_0
    //   33: ldc 194
    //   35: invokevirtual 199	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   38: iconst_2
    //   39: anewarray 201	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: ldc 203
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: ldc 205
    //   51: aastore
    //   52: ldc 207
    //   54: iconst_1
    //   55: anewarray 201	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: ldc 209
    //   62: aastore
    //   63: aconst_null
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: invokevirtual 214	aukp:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   70: astore 8
    //   72: aload 10
    //   74: astore 9
    //   76: aload 8
    //   78: ifnull +99 -> 177
    //   81: aload 10
    //   83: astore 9
    //   85: aload 8
    //   87: invokeinterface 219 1 0
    //   92: ifeq +85 -> 177
    //   95: new 221	java/util/HashMap
    //   98: dup
    //   99: aload 8
    //   101: invokeinterface 225 1 0
    //   106: invokespecial 228	java/util/HashMap:<init>	(I)V
    //   109: astore 9
    //   111: aload 8
    //   113: iconst_0
    //   114: invokeinterface 232 2 0
    //   119: astore 10
    //   121: aload 8
    //   123: iconst_1
    //   124: invokeinterface 236 2 0
    //   129: istore_2
    //   130: aload_0
    //   131: getfield 14	com/tencent/mobileqq/app/automator/step/CleanCache$1:this$0	Lcom/tencent/mobileqq/app/automator/step/CleanCache;
    //   134: getfield 121	com/tencent/mobileqq/app/automator/step/CleanCache:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   137: getfield 180	com/tencent/mobileqq/app/automator/Automator:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   140: astore 11
    //   142: iload_2
    //   143: iconst_4
    //   144: if_icmpne +410 -> 554
    //   147: iconst_1
    //   148: istore 6
    //   150: aload 9
    //   152: aload 11
    //   154: iload 6
    //   156: aload 10
    //   158: invokevirtual 239	com/tencent/mobileqq/app/QQAppInterface:a	(ZLjava/lang/String;)Ljava/lang/String;
    //   161: aload 10
    //   163: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   166: pop
    //   167: aload 8
    //   169: invokeinterface 246 1 0
    //   174: ifne -63 -> 111
    //   177: aload 7
    //   179: new 48	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   186: ldc 248
    //   188: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc 194
    //   193: invokevirtual 199	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   196: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc 250
    //   201: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokevirtual 254	aukp:b	(Ljava/lang/String;)Z
    //   210: pop
    //   211: aload 9
    //   213: ifnull +347 -> 560
    //   216: aload 9
    //   218: invokevirtual 257	java/util/HashMap:size	()I
    //   221: ifle +339 -> 560
    //   224: iconst_0
    //   225: istore_3
    //   226: iconst_0
    //   227: istore_2
    //   228: iload_2
    //   229: istore 4
    //   231: iload_3
    //   232: aload_1
    //   233: arraylength
    //   234: if_icmpge +101 -> 335
    //   237: aload_1
    //   238: iload_3
    //   239: aaload
    //   240: astore 10
    //   242: aload 10
    //   244: invokevirtual 171	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   247: astore 11
    //   249: iload_2
    //   250: istore 4
    //   252: aload 9
    //   254: aload 11
    //   256: invokevirtual 261	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   259: ifeq +285 -> 544
    //   262: aload 10
    //   264: invokevirtual 27	java/io/File:exists	()Z
    //   267: ifeq +9 -> 276
    //   270: aload 10
    //   272: invokevirtual 86	java/io/File:delete	()Z
    //   275: pop
    //   276: aload_1
    //   277: iload_3
    //   278: aconst_null
    //   279: aastore
    //   280: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   283: ifeq +256 -> 539
    //   286: ldc 46
    //   288: iconst_2
    //   289: new 48	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   296: ldc_w 263
    //   299: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload 9
    //   304: aload 11
    //   306: invokevirtual 267	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   309: checkcast 201	java/lang/String
    //   312: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: ldc_w 269
    //   318: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload 11
    //   323: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: goto +207 -> 539
    //   335: aload_1
    //   336: astore 9
    //   338: iload 4
    //   340: ifle +59 -> 399
    //   343: aload_1
    //   344: arraylength
    //   345: iload 4
    //   347: isub
    //   348: anewarray 23	java/io/File
    //   351: astore 9
    //   353: iconst_0
    //   354: istore_2
    //   355: iload 5
    //   357: istore_3
    //   358: iload_3
    //   359: aload_1
    //   360: arraylength
    //   361: if_icmpge +38 -> 399
    //   364: iload_2
    //   365: aload 9
    //   367: arraylength
    //   368: if_icmpge +31 -> 399
    //   371: aload_1
    //   372: iload_3
    //   373: aaload
    //   374: ifnull +162 -> 536
    //   377: iload_2
    //   378: iconst_1
    //   379: iadd
    //   380: istore 4
    //   382: aload 9
    //   384: iload_2
    //   385: aload_1
    //   386: iload_3
    //   387: aaload
    //   388: aastore
    //   389: iload 4
    //   391: istore_2
    //   392: iload_3
    //   393: iconst_1
    //   394: iadd
    //   395: istore_3
    //   396: goto -38 -> 358
    //   399: aload 8
    //   401: ifnull +10 -> 411
    //   404: aload 8
    //   406: invokeinterface 272 1 0
    //   411: aload 9
    //   413: astore 10
    //   415: aload 7
    //   417: ifnull +12 -> 429
    //   420: aload 7
    //   422: invokevirtual 274	aukp:a	()V
    //   425: aload 9
    //   427: astore 10
    //   429: aload 10
    //   431: areturn
    //   432: astore 7
    //   434: aconst_null
    //   435: astore 7
    //   437: aload 7
    //   439: ifnull +10 -> 449
    //   442: aload 7
    //   444: invokeinterface 272 1 0
    //   449: aload_1
    //   450: astore 10
    //   452: aload 8
    //   454: ifnull -25 -> 429
    //   457: aload 8
    //   459: invokevirtual 274	aukp:a	()V
    //   462: aload_1
    //   463: areturn
    //   464: astore_1
    //   465: aconst_null
    //   466: astore 8
    //   468: aload 9
    //   470: astore 7
    //   472: aload 8
    //   474: ifnull +10 -> 484
    //   477: aload 8
    //   479: invokeinterface 272 1 0
    //   484: aload 7
    //   486: ifnull +8 -> 494
    //   489: aload 7
    //   491: invokevirtual 274	aukp:a	()V
    //   494: aload_1
    //   495: athrow
    //   496: astore_1
    //   497: aconst_null
    //   498: astore 8
    //   500: goto -28 -> 472
    //   503: astore_1
    //   504: goto -32 -> 472
    //   507: astore 8
    //   509: aload 7
    //   511: astore 8
    //   513: aconst_null
    //   514: astore 7
    //   516: goto -79 -> 437
    //   519: astore 9
    //   521: aload 7
    //   523: astore 9
    //   525: aload 8
    //   527: astore 7
    //   529: aload 9
    //   531: astore 8
    //   533: goto -96 -> 437
    //   536: goto -144 -> 392
    //   539: iload_2
    //   540: iconst_1
    //   541: iadd
    //   542: istore 4
    //   544: iload_3
    //   545: iconst_1
    //   546: iadd
    //   547: istore_3
    //   548: iload 4
    //   550: istore_2
    //   551: goto -323 -> 228
    //   554: iconst_0
    //   555: istore 6
    //   557: goto -407 -> 150
    //   560: iconst_0
    //   561: istore 4
    //   563: goto -228 -> 335
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	566	0	this	1
    //   0	566	1	paramArrayOfFile	File[]
    //   129	422	2	i	int
    //   225	323	3	j	int
    //   229	333	4	k	int
    //   10	346	5	m	int
    //   148	408	6	bool	boolean
    //   28	393	7	localaukp	aukp
    //   432	1	7	localException1	Exception
    //   435	93	7	localObject1	Object
    //   1	498	8	localCursor	android.database.Cursor
    //   507	1	8	localException2	Exception
    //   511	21	8	localObject2	Object
    //   4	465	9	localObject3	Object
    //   519	1	9	localException3	Exception
    //   523	7	9	localObject4	Object
    //   7	444	10	localObject5	Object
    //   140	182	11	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   12	30	432	java/lang/Exception
    //   12	30	464	finally
    //   30	72	496	finally
    //   85	111	503	finally
    //   111	142	503	finally
    //   150	177	503	finally
    //   177	211	503	finally
    //   216	224	503	finally
    //   231	237	503	finally
    //   242	249	503	finally
    //   252	276	503	finally
    //   280	332	503	finally
    //   343	353	503	finally
    //   358	371	503	finally
    //   30	72	507	java/lang/Exception
    //   85	111	519	java/lang/Exception
    //   111	142	519	java/lang/Exception
    //   150	177	519	java/lang/Exception
    //   177	211	519	java/lang/Exception
    //   216	224	519	java/lang/Exception
    //   231	237	519	java/lang/Exception
    //   242	249	519	java/lang/Exception
    //   252	276	519	java/lang/Exception
    //   280	332	519	java/lang/Exception
    //   343	353	519	java/lang/Exception
    //   358	371	519	java/lang/Exception
  }
  
  private File[] a(File[] paramArrayOfFile, int paramInt)
  {
    int m = 0;
    aukp localaukp = null;
    localObject2 = localaukp;
    for (;;)
    {
      try
      {
        localObject3 = new LinkedList();
        localObject2 = localaukp;
        localaukp = this.this$0.a.app.getEntityManagerFactory().createEntityManager();
        localObject2 = localaukp;
      }
      catch (Exception localException)
      {
        Object localObject4;
        Object localObject5;
        int k;
        Object localObject3 = paramArrayOfFile;
        if (localObject2 == null) {
          continue;
        }
        ((aukp)localObject2).a();
        return paramArrayOfFile;
      }
      finally
      {
        Object localObject1 = null;
        if (localObject1 != null) {
          localObject1.a();
        }
      }
      try
      {
        localObject4 = (ArrayList)localaukp.a(Friends.class, false, "groupid>=?", new String[] { "0" }, null, null, null, null);
        if (localObject4 != null)
        {
          localObject2 = localaukp;
          if (((ArrayList)localObject4).size() != 0)
          {
            i = 0;
            localObject2 = localaukp;
            if (i < ((ArrayList)localObject4).size())
            {
              localObject2 = localaukp;
              localObject5 = (Friends)((ArrayList)localObject4).get(i);
              localObject2 = localaukp;
              ((LinkedList)localObject3).add(this.this$0.a.app.a(false, ((Friends)localObject5).uin));
              i += 1;
              continue;
            }
          }
        }
        localObject2 = localaukp;
        localObject4 = (ArrayList)localaukp.a(TroopInfo.class, false, null, null, null, null, null, null);
        if (localObject4 == null) {
          break label598;
        }
        localObject2 = localaukp;
        if (((ArrayList)localObject4).size() <= 0) {
          break label598;
        }
        i = 0;
        localObject2 = localaukp;
        if (i >= ((ArrayList)localObject4).size()) {
          break label598;
        }
        localObject2 = localaukp;
        localObject5 = (TroopInfo)((ArrayList)localObject4).get(i);
        localObject2 = localaukp;
        ((LinkedList)localObject3).add(this.this$0.a.app.a(true, ((TroopInfo)localObject5).troopuin));
        i += 1;
        continue;
      }
      finally
      {
        continue;
        continue;
        j = 0;
        i = 0;
        continue;
      }
      k = i;
      localObject2 = localaukp;
      if (j < paramArrayOfFile.length)
      {
        localObject4 = paramArrayOfFile[j];
        localObject2 = localaukp;
        localObject5 = ((File)localObject4).getAbsolutePath();
        k = i;
        localObject2 = localaukp;
        if (!((LinkedList)localObject3).contains(localObject5))
        {
          k = i;
          localObject2 = localaukp;
          if (((String)localObject5).indexOf("discussion_") < 0)
          {
            k = i;
            localObject2 = localaukp;
            if (((String)localObject5).indexOf("sys_") < 0)
            {
              localObject2 = localaukp;
              if (((File)localObject4).exists())
              {
                localObject2 = localaukp;
                ((File)localObject4).delete();
              }
              paramArrayOfFile[j] = null;
              i += 1;
              localObject2 = localaukp;
              if (QLog.isColorLevel())
              {
                localObject2 = localaukp;
                QLog.d("QQInitHandler", 2, "onCleanCache->delSecondaryQQHead. delete QQHead,filePath=" + ((File)localObject4).getAbsolutePath());
              }
              k = i;
              localObject2 = localaukp;
              if (paramInt + i >= this.a) {
                k = i;
              }
            }
          }
        }
      }
      else
      {
        localObject2 = paramArrayOfFile;
        if (k <= 0) {
          continue;
        }
        localObject2 = localaukp;
        localObject3 = new File[paramArrayOfFile.length - k];
        paramInt = 0;
        i = m;
        localObject2 = localaukp;
        if (i >= paramArrayOfFile.length) {
          continue;
        }
        localObject2 = localaukp;
        if (paramInt >= localObject3.length) {
          continue;
        }
        if (paramArrayOfFile[i] == null) {
          break label595;
        }
        j = paramInt + 1;
        localObject3[paramInt] = paramArrayOfFile[i];
        paramInt = j;
        i += 1;
        continue;
      }
      j += 1;
      i = k;
    }
    localObject2 = localObject3;
    localObject3 = localObject2;
    if (localaukp != null)
    {
      localaukp.a();
      localObject3 = localObject2;
    }
    return localObject3;
  }
  
  public void run()
  {
    int m = 0;
    int j;
    Object localObject2;
    int k;
    int i1;
    try
    {
      String[] arrayOfString = new String[2];
      arrayOfString[0] = ajsd.bI;
      arrayOfString[1] = "/data/data/com.tencent.mobileqq/files/head/_hd/";
      j = arrayOfString.length;
      i = 0;
      if (i >= j) {
        break label384;
      }
      localObject2 = new File(arrayOfString[i]);
      if ((!((File)localObject2).exists()) || (!((File)localObject2).isDirectory())) {
        break label820;
      }
      localObject2 = ((File)localObject2).listFiles();
      if ((localObject2 == null) || (localObject2.length <= 3000)) {
        break label820;
      }
      k = localObject2.length;
      n = localObject2.length;
      this.a = (k - 2500);
      localObject2 = a((File[])localObject2);
      n = n - localObject2.length + 0;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "onCleanCache. after delTemporaryQQHead. totalCount=" + k + ", currNeedDelCount=" + this.a + ", delCount=" + n);
      }
      if (n >= this.a) {
        break label820;
      }
      Arrays.sort((Object[])localObject2, new aklk(this));
      i1 = localObject2.length;
      localObject2 = a((File[])localObject2, n);
      n += i1 - localObject2.length;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "onCleanCache. after delSecondaryQQHead. totalCount=" + k + ", currNeedDelCount=" + this.a + ", delCount=" + n);
      }
      if (n >= this.a) {
        break label820;
      }
      n = a((File[])localObject2, n);
      if (!QLog.isColorLevel()) {
        break label820;
      }
      QLog.d("QQInitHandler", 2, "onCleanCache. after delRemainQQHead. totalCount=" + k + ", currNeedDelCount=" + this.a + ", delCount=" + n);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.this$0.a.notifyUI(40001, true, null);
    return;
    label384:
    Object localObject1 = new String[2];
    localObject1[0] = ajsd.bK;
    localObject1[1] = "/data/data/com.tencent.mobileqq/files/head/_stranger/";
    int n = localObject1.length;
    int i = 0;
    label411:
    if (i < n)
    {
      localObject2 = new File(localObject1[i]);
      if ((!((File)localObject2).exists()) || (!((File)localObject2).isDirectory())) {
        break label848;
      }
      localObject2 = ((File)localObject2).listFiles();
      if ((localObject2 == null) || (localObject2.length <= 300)) {
        break label848;
      }
      Arrays.sort((Object[])localObject2, new akll(this));
      i1 = localObject2.length;
      j = 0;
      k = 0;
    }
    for (;;)
    {
      if (j < i1)
      {
        Object localObject3 = localObject2[j];
        if (!localObject3.exists()) {
          break label827;
        }
        localObject3.delete();
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label848;
        }
        QLog.d("QQInitHandler", 2, "onCleanCache. delete stranger head...");
        break label848;
        localObject1 = new File[3];
        localObject1[0] = new File(ajsd.aW + "photo");
        localObject1[1] = new File(ajsd.aW + "ptv_template");
        localObject1[2] = new File(ajsd.bH + File.separator + "_dynamic");
        k = localObject1.length;
        j = 0;
        i = m;
        while (i < k)
        {
          j += a(localObject1[i], 2000, 500);
          i += 1;
        }
        i = a(new File(SafeBitmapFactory.LARGE_MAP_CACHE_PATH), 150, 50) + j;
        if (Build.VERSION.SDK_INT < 21) {
          i += a(aywm.a, 2000, 500);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQInitHandler", 2, "onCleanCache. delete " + i + " cache file(s)");
          }
          this.this$0.e();
          this.this$0.c();
          CleanCache.a(this.this$0);
          CleanCache.b(this.this$0);
          break;
          j = a(aywm.a, 5000, 2000);
          i += j;
        }
        label820:
        i += 1;
        break;
        label827:
        localObject2[j] = null;
        k += 1;
        if (i1 - k > 20) {
          break label855;
        }
      }
      label848:
      i += 1;
      break label411;
      label855:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CleanCache.1
 * JD-Core Version:    0.7.0.1
 */