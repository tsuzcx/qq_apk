package com.tencent.component.network.module.common;

import com.tencent.component.network.utils.thread.ThreadPool.Job;

class DnsService$ResolverDomainTask
  implements ThreadPool.Job<Object>
{
  private String mApn;
  private String mDomain;
  private volatile boolean mIsExpired = false;
  
  public DnsService$ResolverDomainTask(DnsService paramDnsService, String paramString1, String paramString2)
  {
    this.mDomain = paramString1;
    this.mApn = paramString2;
  }
  
  private String tryHttpDNS(int paramInt)
  {
    return null;
  }
  
  /* Error */
  public Object run(com.tencent.component.network.utils.thread.ThreadPool.JobContext arg1)
  {
    // Byte code:
    //   0: invokestatic 46	com/tencent/component/network/module/common/DnsService:access$000	()[B
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   10: invokestatic 50	com/tencent/component/network/module/common/DnsService:access$100	(Lcom/tencent/component/network/module/common/DnsService;)Ljava/util/List;
    //   13: aload_0
    //   14: invokeinterface 56 2 0
    //   19: pop
    //   20: aload_1
    //   21: monitorexit
    //   22: aconst_null
    //   23: astore_1
    //   24: aconst_null
    //   25: astore 6
    //   27: invokestatic 62	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   30: astore 7
    //   32: aload 7
    //   34: astore 8
    //   36: ldc 64
    //   38: aload 7
    //   40: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   43: ifeq +8 -> 51
    //   46: invokestatic 72	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
    //   49: astore 8
    //   51: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   54: lstore 4
    //   56: aload_0
    //   57: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   60: invokestatic 82	com/tencent/component/network/module/common/DnsService:access$200	(Lcom/tencent/component/network/module/common/DnsService;)Z
    //   63: ifeq +162 -> 225
    //   66: aload 6
    //   68: astore_1
    //   69: aload_0
    //   70: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   73: invokestatic 86	com/tencent/component/network/module/common/DnsService:access$300	(Lcom/tencent/component/network/module/common/DnsService;)Ljava/util/HashSet;
    //   76: aload_0
    //   77: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   80: invokevirtual 91	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   83: ifne +24 -> 107
    //   86: aload_0
    //   87: iconst_0
    //   88: invokespecial 93	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:tryHttpDNS	(I)Ljava/lang/String;
    //   91: astore 6
    //   93: aload 6
    //   95: astore_1
    //   96: aload 6
    //   98: ifnonnull +9 -> 107
    //   101: aload_0
    //   102: iconst_1
    //   103: invokespecial 93	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:tryHttpDNS	(I)Ljava/lang/String;
    //   106: astore_1
    //   107: aload_1
    //   108: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   111: ifne +99 -> 210
    //   114: ldc 101
    //   116: new 103	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   123: ldc 106
    //   125: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_1
    //   129: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload_0
    //   139: getfield 23	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
    //   142: ifne +46 -> 188
    //   145: aload_0
    //   146: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   149: aload_0
    //   150: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   153: aload_1
    //   154: invokestatic 122	com/tencent/component/network/module/common/DnsService:access$400	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   157: invokestatic 46	com/tencent/component/network/module/common/DnsService:access$000	()[B
    //   160: astore_1
    //   161: aload_1
    //   162: monitorenter
    //   163: aload_0
    //   164: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   167: invokestatic 50	com/tencent/component/network/module/common/DnsService:access$100	(Lcom/tencent/component/network/module/common/DnsService;)Ljava/util/List;
    //   170: aload_0
    //   171: invokeinterface 125 2 0
    //   176: pop
    //   177: aload_1
    //   178: monitorexit
    //   179: aconst_null
    //   180: areturn
    //   181: astore 6
    //   183: aload_1
    //   184: monitorexit
    //   185: aload 6
    //   187: athrow
    //   188: aload_0
    //   189: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   192: aload_0
    //   193: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   196: aconst_null
    //   197: invokestatic 122	com/tencent/component/network/module/common/DnsService:access$400	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   200: goto -43 -> 157
    //   203: astore 6
    //   205: aload_1
    //   206: monitorexit
    //   207: aload 6
    //   209: athrow
    //   210: aload_0
    //   211: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   214: invokestatic 86	com/tencent/component/network/module/common/DnsService:access$300	(Lcom/tencent/component/network/module/common/DnsService;)Ljava/util/HashSet;
    //   217: aload_0
    //   218: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   221: invokevirtual 126	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   224: pop
    //   225: aload_1
    //   226: astore 6
    //   228: aload_0
    //   229: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   232: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   235: ifne +27 -> 262
    //   238: aload_0
    //   239: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   242: invokestatic 132	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   245: astore 7
    //   247: aload_1
    //   248: astore 6
    //   250: aload 7
    //   252: ifnull +10 -> 262
    //   255: aload 7
    //   257: invokevirtual 135	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   260: astore 6
    //   262: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   265: ifeq +28 -> 293
    //   268: ldc 101
    //   270: new 103	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   277: ldc 141
    //   279: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload 6
    //   284: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: aload 6
    //   295: astore_1
    //   296: aload_0
    //   297: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   300: aload 6
    //   302: invokestatic 145	com/tencent/component/network/module/common/DnsService:access$500	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;)Z
    //   305: ifne +152 -> 457
    //   308: aload 6
    //   310: astore_1
    //   311: aload_0
    //   312: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   315: invokestatic 148	com/tencent/component/network/module/common/DnsService:access$600	(Lcom/tencent/component/network/module/common/DnsService;)Z
    //   318: ifeq +139 -> 457
    //   321: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   324: lload 4
    //   326: lsub
    //   327: lstore_2
    //   328: aload 6
    //   330: astore 7
    //   332: aload_0
    //   333: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   336: astore_1
    //   337: ldc2_w 149
    //   340: lload_2
    //   341: lsub
    //   342: ldc2_w 151
    //   345: lcmp
    //   346: iflt +280 -> 626
    //   349: ldc2_w 149
    //   352: lload_2
    //   353: lsub
    //   354: lstore_2
    //   355: aload 6
    //   357: astore 7
    //   359: aload_1
    //   360: lload_2
    //   361: invokestatic 158	com/tencent/component/network/module/common/dns/DnsMain:getBetterHostByName	(Ljava/lang/String;J)[Ljava/net/InetAddress;
    //   364: astore 9
    //   366: aload 6
    //   368: astore_1
    //   369: aload 9
    //   371: ifnull +86 -> 457
    //   374: aload 6
    //   376: astore_1
    //   377: aload 6
    //   379: astore 7
    //   381: aload 9
    //   383: arraylength
    //   384: ifle +73 -> 457
    //   387: aload 6
    //   389: astore 7
    //   391: aload 9
    //   393: iconst_0
    //   394: aaload
    //   395: invokevirtual 135	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   398: astore 6
    //   400: aload 6
    //   402: astore_1
    //   403: aload 6
    //   405: astore 7
    //   407: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   410: ifeq +47 -> 457
    //   413: aload 6
    //   415: astore 7
    //   417: ldc 101
    //   419: new 103	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   426: ldc 160
    //   428: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: aload_0
    //   432: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   435: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: ldc 162
    //   440: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload 6
    //   445: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   454: aload 6
    //   456: astore_1
    //   457: invokestatic 62	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   460: astore 7
    //   462: aload 7
    //   464: astore 6
    //   466: ldc 64
    //   468: aload 7
    //   470: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   473: ifeq +8 -> 481
    //   476: invokestatic 72	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
    //   479: astore 6
    //   481: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   484: ifeq +99 -> 583
    //   487: ldc 101
    //   489: new 103	java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   496: ldc 164
    //   498: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: aload_0
    //   502: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   505: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: ldc 166
    //   510: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: aload_1
    //   514: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: ldc 168
    //   519: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   525: lload 4
    //   527: lsub
    //   528: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   531: ldc 173
    //   533: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: aload 8
    //   538: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: ldc 175
    //   543: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: aload 6
    //   548: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: ldc 177
    //   553: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: invokestatic 183	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   559: invokevirtual 186	java/lang/Thread:getId	()J
    //   562: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   565: ldc 188
    //   567: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: aload_0
    //   571: getfield 23	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
    //   574: invokevirtual 191	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   577: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   580: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   583: aload_0
    //   584: getfield 23	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
    //   587: ifne +61 -> 648
    //   590: aload_0
    //   591: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   594: aload_0
    //   595: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   598: aload_1
    //   599: invokestatic 122	com/tencent/component/network/module/common/DnsService:access$400	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   602: invokestatic 46	com/tencent/component/network/module/common/DnsService:access$000	()[B
    //   605: astore_1
    //   606: aload_1
    //   607: monitorenter
    //   608: aload_0
    //   609: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   612: invokestatic 50	com/tencent/component/network/module/common/DnsService:access$100	(Lcom/tencent/component/network/module/common/DnsService;)Ljava/util/List;
    //   615: aload_0
    //   616: invokeinterface 125 2 0
    //   621: pop
    //   622: aload_1
    //   623: monitorexit
    //   624: aconst_null
    //   625: areturn
    //   626: ldc2_w 151
    //   629: lstore_2
    //   630: goto -275 -> 355
    //   633: astore_1
    //   634: ldc 101
    //   636: ldc 193
    //   638: aload_1
    //   639: invokestatic 197	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   642: aload 7
    //   644: astore_1
    //   645: goto -188 -> 457
    //   648: aload_0
    //   649: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   652: aload_0
    //   653: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   656: aconst_null
    //   657: invokestatic 122	com/tencent/component/network/module/common/DnsService:access$400	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   660: goto -58 -> 602
    //   663: astore 6
    //   665: ldc 101
    //   667: ldc 199
    //   669: aload 6
    //   671: invokestatic 197	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   674: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   677: ifeq +27 -> 704
    //   680: ldc 101
    //   682: new 103	java/lang/StringBuilder
    //   685: dup
    //   686: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   689: ldc 141
    //   691: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: aload_1
    //   695: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   701: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   704: aload_1
    //   705: astore 6
    //   707: aload_0
    //   708: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   711: aload_1
    //   712: invokestatic 145	com/tencent/component/network/module/common/DnsService:access$500	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;)Z
    //   715: ifne +146 -> 861
    //   718: aload_1
    //   719: astore 6
    //   721: aload_0
    //   722: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   725: invokestatic 148	com/tencent/component/network/module/common/DnsService:access$600	(Lcom/tencent/component/network/module/common/DnsService;)Z
    //   728: ifeq +133 -> 861
    //   731: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   734: lload 4
    //   736: lsub
    //   737: lstore_2
    //   738: aload_1
    //   739: astore 7
    //   741: aload_0
    //   742: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   745: astore 6
    //   747: ldc2_w 149
    //   750: lload_2
    //   751: lsub
    //   752: ldc2_w 151
    //   755: lcmp
    //   756: iflt +252 -> 1008
    //   759: ldc2_w 149
    //   762: lload_2
    //   763: lsub
    //   764: lstore_2
    //   765: aload_1
    //   766: astore 7
    //   768: aload 6
    //   770: lload_2
    //   771: invokestatic 158	com/tencent/component/network/module/common/dns/DnsMain:getBetterHostByName	(Ljava/lang/String;J)[Ljava/net/InetAddress;
    //   774: astore 9
    //   776: aload_1
    //   777: astore 6
    //   779: aload 9
    //   781: ifnull +80 -> 861
    //   784: aload_1
    //   785: astore 6
    //   787: aload_1
    //   788: astore 7
    //   790: aload 9
    //   792: arraylength
    //   793: ifle +68 -> 861
    //   796: aload_1
    //   797: astore 7
    //   799: aload 9
    //   801: iconst_0
    //   802: aaload
    //   803: invokevirtual 135	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   806: astore_1
    //   807: aload_1
    //   808: astore 6
    //   810: aload_1
    //   811: astore 7
    //   813: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   816: ifeq +45 -> 861
    //   819: aload_1
    //   820: astore 7
    //   822: ldc 101
    //   824: new 103	java/lang/StringBuilder
    //   827: dup
    //   828: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   831: ldc 160
    //   833: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: aload_0
    //   837: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   840: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: ldc 162
    //   845: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: aload_1
    //   849: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   855: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   858: aload_1
    //   859: astore 6
    //   861: invokestatic 62	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   864: astore 7
    //   866: aload 7
    //   868: astore_1
    //   869: ldc 64
    //   871: aload 7
    //   873: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   876: ifeq +7 -> 883
    //   879: invokestatic 72	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
    //   882: astore_1
    //   883: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   886: ifeq +99 -> 985
    //   889: ldc 101
    //   891: new 103	java/lang/StringBuilder
    //   894: dup
    //   895: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   898: ldc 164
    //   900: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   903: aload_0
    //   904: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   907: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: ldc 166
    //   912: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: aload 6
    //   917: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: ldc 168
    //   922: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   928: lload 4
    //   930: lsub
    //   931: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   934: ldc 173
    //   936: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: aload 8
    //   941: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: ldc 175
    //   946: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: aload_1
    //   950: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: ldc 177
    //   955: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: invokestatic 183	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   961: invokevirtual 186	java/lang/Thread:getId	()J
    //   964: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   967: ldc 188
    //   969: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: aload_0
    //   973: getfield 23	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
    //   976: invokevirtual 191	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   979: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   985: aload_0
    //   986: getfield 23	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
    //   989: ifne +42 -> 1031
    //   992: aload_0
    //   993: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   996: aload_0
    //   997: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   1000: aload 6
    //   1002: invokestatic 122	com/tencent/component/network/module/common/DnsService:access$400	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   1005: goto -403 -> 602
    //   1008: ldc2_w 151
    //   1011: lstore_2
    //   1012: goto -247 -> 765
    //   1015: astore_1
    //   1016: ldc 101
    //   1018: ldc 193
    //   1020: aload_1
    //   1021: invokestatic 197	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1024: aload 7
    //   1026: astore 6
    //   1028: goto -167 -> 861
    //   1031: aload_0
    //   1032: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   1035: aload_0
    //   1036: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   1039: aconst_null
    //   1040: invokestatic 122	com/tencent/component/network/module/common/DnsService:access$400	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   1043: goto -441 -> 602
    //   1046: astore 6
    //   1048: ldc 101
    //   1050: ldc 199
    //   1052: aload 6
    //   1054: invokestatic 197	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1057: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   1060: ifeq +27 -> 1087
    //   1063: ldc 101
    //   1065: new 103	java/lang/StringBuilder
    //   1068: dup
    //   1069: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1072: ldc 141
    //   1074: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: aload_1
    //   1078: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1084: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1087: aload_1
    //   1088: astore 6
    //   1090: aload_0
    //   1091: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   1094: aload_1
    //   1095: invokestatic 145	com/tencent/component/network/module/common/DnsService:access$500	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;)Z
    //   1098: ifne +146 -> 1244
    //   1101: aload_1
    //   1102: astore 6
    //   1104: aload_0
    //   1105: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   1108: invokestatic 148	com/tencent/component/network/module/common/DnsService:access$600	(Lcom/tencent/component/network/module/common/DnsService;)Z
    //   1111: ifeq +133 -> 1244
    //   1114: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   1117: lload 4
    //   1119: lsub
    //   1120: lstore_2
    //   1121: aload_1
    //   1122: astore 7
    //   1124: aload_0
    //   1125: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   1128: astore 6
    //   1130: ldc2_w 149
    //   1133: lload_2
    //   1134: lsub
    //   1135: ldc2_w 151
    //   1138: lcmp
    //   1139: iflt +252 -> 1391
    //   1142: ldc2_w 149
    //   1145: lload_2
    //   1146: lsub
    //   1147: lstore_2
    //   1148: aload_1
    //   1149: astore 7
    //   1151: aload 6
    //   1153: lload_2
    //   1154: invokestatic 158	com/tencent/component/network/module/common/dns/DnsMain:getBetterHostByName	(Ljava/lang/String;J)[Ljava/net/InetAddress;
    //   1157: astore 9
    //   1159: aload_1
    //   1160: astore 6
    //   1162: aload 9
    //   1164: ifnull +80 -> 1244
    //   1167: aload_1
    //   1168: astore 6
    //   1170: aload_1
    //   1171: astore 7
    //   1173: aload 9
    //   1175: arraylength
    //   1176: ifle +68 -> 1244
    //   1179: aload_1
    //   1180: astore 7
    //   1182: aload 9
    //   1184: iconst_0
    //   1185: aaload
    //   1186: invokevirtual 135	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1189: astore_1
    //   1190: aload_1
    //   1191: astore 6
    //   1193: aload_1
    //   1194: astore 7
    //   1196: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   1199: ifeq +45 -> 1244
    //   1202: aload_1
    //   1203: astore 7
    //   1205: ldc 101
    //   1207: new 103	java/lang/StringBuilder
    //   1210: dup
    //   1211: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1214: ldc 160
    //   1216: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: aload_0
    //   1220: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   1223: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: ldc 162
    //   1228: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: aload_1
    //   1232: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1235: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1238: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1241: aload_1
    //   1242: astore 6
    //   1244: invokestatic 62	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1247: astore 7
    //   1249: aload 7
    //   1251: astore_1
    //   1252: ldc 64
    //   1254: aload 7
    //   1256: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1259: ifeq +7 -> 1266
    //   1262: invokestatic 72	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
    //   1265: astore_1
    //   1266: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   1269: ifeq +99 -> 1368
    //   1272: ldc 101
    //   1274: new 103	java/lang/StringBuilder
    //   1277: dup
    //   1278: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1281: ldc 164
    //   1283: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1286: aload_0
    //   1287: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   1290: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: ldc 166
    //   1295: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1298: aload 6
    //   1300: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1303: ldc 168
    //   1305: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1308: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   1311: lload 4
    //   1313: lsub
    //   1314: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1317: ldc 173
    //   1319: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1322: aload 8
    //   1324: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1327: ldc 175
    //   1329: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1332: aload_1
    //   1333: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: ldc 177
    //   1338: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1341: invokestatic 183	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1344: invokevirtual 186	java/lang/Thread:getId	()J
    //   1347: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1350: ldc 188
    //   1352: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1355: aload_0
    //   1356: getfield 23	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
    //   1359: invokevirtual 191	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1362: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1365: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1368: aload_0
    //   1369: getfield 23	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
    //   1372: ifne +42 -> 1414
    //   1375: aload_0
    //   1376: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   1379: aload_0
    //   1380: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   1383: aload 6
    //   1385: invokestatic 122	com/tencent/component/network/module/common/DnsService:access$400	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   1388: goto -786 -> 602
    //   1391: ldc2_w 151
    //   1394: lstore_2
    //   1395: goto -247 -> 1148
    //   1398: astore_1
    //   1399: ldc 101
    //   1401: ldc 193
    //   1403: aload_1
    //   1404: invokestatic 197	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1407: aload 7
    //   1409: astore 6
    //   1411: goto -167 -> 1244
    //   1414: aload_0
    //   1415: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   1418: aload_0
    //   1419: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   1422: aconst_null
    //   1423: invokestatic 122	com/tencent/component/network/module/common/DnsService:access$400	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   1426: goto -824 -> 602
    //   1429: astore 6
    //   1431: ldc 101
    //   1433: ldc 201
    //   1435: aload 6
    //   1437: invokestatic 197	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1440: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   1443: ifeq +27 -> 1470
    //   1446: ldc 101
    //   1448: new 103	java/lang/StringBuilder
    //   1451: dup
    //   1452: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1455: ldc 141
    //   1457: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1460: aload_1
    //   1461: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1464: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1467: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1470: aload_1
    //   1471: astore 6
    //   1473: aload_0
    //   1474: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   1477: aload_1
    //   1478: invokestatic 145	com/tencent/component/network/module/common/DnsService:access$500	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;)Z
    //   1481: ifne +146 -> 1627
    //   1484: aload_1
    //   1485: astore 6
    //   1487: aload_0
    //   1488: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   1491: invokestatic 148	com/tencent/component/network/module/common/DnsService:access$600	(Lcom/tencent/component/network/module/common/DnsService;)Z
    //   1494: ifeq +133 -> 1627
    //   1497: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   1500: lload 4
    //   1502: lsub
    //   1503: lstore_2
    //   1504: aload_1
    //   1505: astore 7
    //   1507: aload_0
    //   1508: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   1511: astore 6
    //   1513: ldc2_w 149
    //   1516: lload_2
    //   1517: lsub
    //   1518: ldc2_w 151
    //   1521: lcmp
    //   1522: iflt +252 -> 1774
    //   1525: ldc2_w 149
    //   1528: lload_2
    //   1529: lsub
    //   1530: lstore_2
    //   1531: aload_1
    //   1532: astore 7
    //   1534: aload 6
    //   1536: lload_2
    //   1537: invokestatic 158	com/tencent/component/network/module/common/dns/DnsMain:getBetterHostByName	(Ljava/lang/String;J)[Ljava/net/InetAddress;
    //   1540: astore 9
    //   1542: aload_1
    //   1543: astore 6
    //   1545: aload 9
    //   1547: ifnull +80 -> 1627
    //   1550: aload_1
    //   1551: astore 6
    //   1553: aload_1
    //   1554: astore 7
    //   1556: aload 9
    //   1558: arraylength
    //   1559: ifle +68 -> 1627
    //   1562: aload_1
    //   1563: astore 7
    //   1565: aload 9
    //   1567: iconst_0
    //   1568: aaload
    //   1569: invokevirtual 135	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1572: astore_1
    //   1573: aload_1
    //   1574: astore 6
    //   1576: aload_1
    //   1577: astore 7
    //   1579: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   1582: ifeq +45 -> 1627
    //   1585: aload_1
    //   1586: astore 7
    //   1588: ldc 101
    //   1590: new 103	java/lang/StringBuilder
    //   1593: dup
    //   1594: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1597: ldc 160
    //   1599: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: aload_0
    //   1603: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   1606: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1609: ldc 162
    //   1611: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1614: aload_1
    //   1615: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1618: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1621: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1624: aload_1
    //   1625: astore 6
    //   1627: invokestatic 62	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1630: astore 7
    //   1632: aload 7
    //   1634: astore_1
    //   1635: ldc 64
    //   1637: aload 7
    //   1639: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1642: ifeq +7 -> 1649
    //   1645: invokestatic 72	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
    //   1648: astore_1
    //   1649: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   1652: ifeq +99 -> 1751
    //   1655: ldc 101
    //   1657: new 103	java/lang/StringBuilder
    //   1660: dup
    //   1661: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1664: ldc 164
    //   1666: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1669: aload_0
    //   1670: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   1673: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1676: ldc 166
    //   1678: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1681: aload 6
    //   1683: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1686: ldc 168
    //   1688: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1691: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   1694: lload 4
    //   1696: lsub
    //   1697: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1700: ldc 173
    //   1702: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1705: aload 8
    //   1707: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1710: ldc 175
    //   1712: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1715: aload_1
    //   1716: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1719: ldc 177
    //   1721: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1724: invokestatic 183	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1727: invokevirtual 186	java/lang/Thread:getId	()J
    //   1730: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1733: ldc 188
    //   1735: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1738: aload_0
    //   1739: getfield 23	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
    //   1742: invokevirtual 191	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1745: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1748: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1751: aload_0
    //   1752: getfield 23	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
    //   1755: ifne +42 -> 1797
    //   1758: aload_0
    //   1759: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   1762: aload_0
    //   1763: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   1766: aload 6
    //   1768: invokestatic 122	com/tencent/component/network/module/common/DnsService:access$400	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   1771: goto -1169 -> 602
    //   1774: ldc2_w 151
    //   1777: lstore_2
    //   1778: goto -247 -> 1531
    //   1781: astore_1
    //   1782: ldc 101
    //   1784: ldc 193
    //   1786: aload_1
    //   1787: invokestatic 197	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1790: aload 7
    //   1792: astore 6
    //   1794: goto -167 -> 1627
    //   1797: aload_0
    //   1798: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   1801: aload_0
    //   1802: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   1805: aconst_null
    //   1806: invokestatic 122	com/tencent/component/network/module/common/DnsService:access$400	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   1809: goto -1207 -> 602
    //   1812: astore 9
    //   1814: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   1817: ifeq +27 -> 1844
    //   1820: ldc 101
    //   1822: new 103	java/lang/StringBuilder
    //   1825: dup
    //   1826: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1829: ldc 141
    //   1831: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1834: aload_1
    //   1835: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1838: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1841: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1844: aload_1
    //   1845: astore 6
    //   1847: aload_0
    //   1848: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   1851: aload_1
    //   1852: invokestatic 145	com/tencent/component/network/module/common/DnsService:access$500	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;)Z
    //   1855: ifne +146 -> 2001
    //   1858: aload_1
    //   1859: astore 6
    //   1861: aload_0
    //   1862: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   1865: invokestatic 148	com/tencent/component/network/module/common/DnsService:access$600	(Lcom/tencent/component/network/module/common/DnsService;)Z
    //   1868: ifeq +133 -> 2001
    //   1871: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   1874: lload 4
    //   1876: lsub
    //   1877: lstore_2
    //   1878: aload_1
    //   1879: astore 7
    //   1881: aload_0
    //   1882: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   1885: astore 6
    //   1887: ldc2_w 149
    //   1890: lload_2
    //   1891: lsub
    //   1892: ldc2_w 151
    //   1895: lcmp
    //   1896: iflt +252 -> 2148
    //   1899: ldc2_w 149
    //   1902: lload_2
    //   1903: lsub
    //   1904: lstore_2
    //   1905: aload_1
    //   1906: astore 7
    //   1908: aload 6
    //   1910: lload_2
    //   1911: invokestatic 158	com/tencent/component/network/module/common/dns/DnsMain:getBetterHostByName	(Ljava/lang/String;J)[Ljava/net/InetAddress;
    //   1914: astore 10
    //   1916: aload_1
    //   1917: astore 6
    //   1919: aload 10
    //   1921: ifnull +80 -> 2001
    //   1924: aload_1
    //   1925: astore 6
    //   1927: aload_1
    //   1928: astore 7
    //   1930: aload 10
    //   1932: arraylength
    //   1933: ifle +68 -> 2001
    //   1936: aload_1
    //   1937: astore 7
    //   1939: aload 10
    //   1941: iconst_0
    //   1942: aaload
    //   1943: invokevirtual 135	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1946: astore_1
    //   1947: aload_1
    //   1948: astore 6
    //   1950: aload_1
    //   1951: astore 7
    //   1953: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   1956: ifeq +45 -> 2001
    //   1959: aload_1
    //   1960: astore 7
    //   1962: ldc 101
    //   1964: new 103	java/lang/StringBuilder
    //   1967: dup
    //   1968: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   1971: ldc 160
    //   1973: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1976: aload_0
    //   1977: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   1980: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1983: ldc 162
    //   1985: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1988: aload_1
    //   1989: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1992: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1995: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1998: aload_1
    //   1999: astore 6
    //   2001: invokestatic 62	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   2004: astore 7
    //   2006: aload 7
    //   2008: astore_1
    //   2009: ldc 64
    //   2011: aload 7
    //   2013: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2016: ifeq +7 -> 2023
    //   2019: invokestatic 72	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
    //   2022: astore_1
    //   2023: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   2026: ifeq +99 -> 2125
    //   2029: ldc 101
    //   2031: new 103	java/lang/StringBuilder
    //   2034: dup
    //   2035: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   2038: ldc 164
    //   2040: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2043: aload_0
    //   2044: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   2047: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2050: ldc 166
    //   2052: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2055: aload 6
    //   2057: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2060: ldc 168
    //   2062: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2065: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   2068: lload 4
    //   2070: lsub
    //   2071: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2074: ldc 173
    //   2076: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2079: aload 8
    //   2081: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2084: ldc 175
    //   2086: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2089: aload_1
    //   2090: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2093: ldc 177
    //   2095: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2098: invokestatic 183	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2101: invokevirtual 186	java/lang/Thread:getId	()J
    //   2104: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2107: ldc 188
    //   2109: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2112: aload_0
    //   2113: getfield 23	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
    //   2116: invokevirtual 191	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2119: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2122: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2125: aload_0
    //   2126: getfield 23	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
    //   2129: ifne +42 -> 2171
    //   2132: aload_0
    //   2133: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   2136: aload_0
    //   2137: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   2140: aload 6
    //   2142: invokestatic 122	com/tencent/component/network/module/common/DnsService:access$400	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   2145: aload 9
    //   2147: athrow
    //   2148: ldc2_w 151
    //   2151: lstore_2
    //   2152: goto -247 -> 1905
    //   2155: astore_1
    //   2156: ldc 101
    //   2158: ldc 193
    //   2160: aload_1
    //   2161: invokestatic 197	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2164: aload 7
    //   2166: astore 6
    //   2168: goto -167 -> 2001
    //   2171: aload_0
    //   2172: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   2175: aload_0
    //   2176: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   2179: aconst_null
    //   2180: invokestatic 122	com/tencent/component/network/module/common/DnsService:access$400	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   2183: goto -38 -> 2145
    //   2186: astore 6
    //   2188: aload_1
    //   2189: monitorexit
    //   2190: aload 6
    //   2192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2193	0	this	ResolverDomainTask
    //   327	1825	2	l1	long
    //   54	2015	4	l2	long
    //   25	72	6	str	String
    //   181	5	6	localObject1	Object
    //   203	5	6	localObject2	Object
    //   226	321	6	localObject3	Object
    //   663	7	6	localUnknownHostException	java.net.UnknownHostException
    //   705	322	6	localObject4	Object
    //   1046	7	6	localException	java.lang.Exception
    //   1088	322	6	localObject5	Object
    //   1429	7	6	localError	java.lang.Error
    //   1471	696	6	localObject6	Object
    //   2186	5	6	localObject7	Object
    //   30	2135	7	localObject8	Object
    //   34	2046	8	localObject9	Object
    //   364	1202	9	arrayOfInetAddress1	java.net.InetAddress[]
    //   1812	334	9	localObject10	Object
    //   1914	26	10	arrayOfInetAddress2	java.net.InetAddress[]
    // Exception table:
    //   from	to	target	type
    //   6	22	181	finally
    //   183	185	181	finally
    //   163	179	203	finally
    //   205	207	203	finally
    //   332	337	633	java/lang/Throwable
    //   359	366	633	java/lang/Throwable
    //   381	387	633	java/lang/Throwable
    //   391	400	633	java/lang/Throwable
    //   407	413	633	java/lang/Throwable
    //   417	454	633	java/lang/Throwable
    //   228	247	663	java/net/UnknownHostException
    //   255	262	663	java/net/UnknownHostException
    //   741	747	1015	java/lang/Throwable
    //   768	776	1015	java/lang/Throwable
    //   790	796	1015	java/lang/Throwable
    //   799	807	1015	java/lang/Throwable
    //   813	819	1015	java/lang/Throwable
    //   822	858	1015	java/lang/Throwable
    //   228	247	1046	java/lang/Exception
    //   255	262	1046	java/lang/Exception
    //   1124	1130	1398	java/lang/Throwable
    //   1151	1159	1398	java/lang/Throwable
    //   1173	1179	1398	java/lang/Throwable
    //   1182	1190	1398	java/lang/Throwable
    //   1196	1202	1398	java/lang/Throwable
    //   1205	1241	1398	java/lang/Throwable
    //   228	247	1429	java/lang/Error
    //   255	262	1429	java/lang/Error
    //   1507	1513	1781	java/lang/Throwable
    //   1534	1542	1781	java/lang/Throwable
    //   1556	1562	1781	java/lang/Throwable
    //   1565	1573	1781	java/lang/Throwable
    //   1579	1585	1781	java/lang/Throwable
    //   1588	1624	1781	java/lang/Throwable
    //   228	247	1812	finally
    //   255	262	1812	finally
    //   665	674	1812	finally
    //   1048	1057	1812	finally
    //   1431	1440	1812	finally
    //   1881	1887	2155	java/lang/Throwable
    //   1908	1916	2155	java/lang/Throwable
    //   1930	1936	2155	java/lang/Throwable
    //   1939	1947	2155	java/lang/Throwable
    //   1953	1959	2155	java/lang/Throwable
    //   1962	1998	2155	java/lang/Throwable
    //   608	624	2186	finally
    //   2188	2190	2186	finally
  }
  
  public void setIsExpired(boolean paramBoolean)
  {
    this.mIsExpired = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.module.common.DnsService.ResolverDomainTask
 * JD-Core Version:    0.7.0.1
 */