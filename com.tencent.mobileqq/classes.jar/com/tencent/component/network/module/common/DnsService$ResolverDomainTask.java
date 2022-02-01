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
  public Object run(com.tencent.component.network.utils.thread.ThreadPool.JobContext paramJobContext)
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
    //   22: invokestatic 62	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   25: astore_1
    //   26: aload_1
    //   27: astore 8
    //   29: ldc 64
    //   31: aload_1
    //   32: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   35: ifeq +8 -> 43
    //   38: invokestatic 72	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
    //   41: astore 8
    //   43: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   46: lstore 4
    //   48: aload_0
    //   49: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   52: invokestatic 82	com/tencent/component/network/module/common/DnsService:access$200	(Lcom/tencent/component/network/module/common/DnsService;)Z
    //   55: ifeq +170 -> 225
    //   58: aload_0
    //   59: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   62: invokestatic 86	com/tencent/component/network/module/common/DnsService:access$300	(Lcom/tencent/component/network/module/common/DnsService;)Ljava/util/HashSet;
    //   65: aload_0
    //   66: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   69: invokevirtual 91	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   72: ifne +27 -> 99
    //   75: aload_0
    //   76: iconst_0
    //   77: invokespecial 93	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:tryHttpDNS	(I)Ljava/lang/String;
    //   80: astore 6
    //   82: aload 6
    //   84: astore_1
    //   85: aload 6
    //   87: ifnonnull +14 -> 101
    //   90: aload_0
    //   91: iconst_1
    //   92: invokespecial 93	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:tryHttpDNS	(I)Ljava/lang/String;
    //   95: astore_1
    //   96: goto +5 -> 101
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_1
    //   102: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: ifne +102 -> 207
    //   108: new 101	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   115: astore 6
    //   117: aload 6
    //   119: ldc 104
    //   121: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload 6
    //   127: aload_1
    //   128: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: ldc 110
    //   134: aload 6
    //   136: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_0
    //   143: getfield 23	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
    //   146: ifne +18 -> 164
    //   149: aload_0
    //   150: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   153: aload_0
    //   154: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   157: aload_1
    //   158: invokestatic 122	com/tencent/component/network/module/common/DnsService:access$400	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   161: goto +15 -> 176
    //   164: aload_0
    //   165: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   168: aload_0
    //   169: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   172: aconst_null
    //   173: invokestatic 122	com/tencent/component/network/module/common/DnsService:access$400	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   176: invokestatic 46	com/tencent/component/network/module/common/DnsService:access$000	()[B
    //   179: astore_1
    //   180: aload_1
    //   181: monitorenter
    //   182: aload_0
    //   183: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   186: invokestatic 50	com/tencent/component/network/module/common/DnsService:access$100	(Lcom/tencent/component/network/module/common/DnsService;)Ljava/util/List;
    //   189: aload_0
    //   190: invokeinterface 125 2 0
    //   195: pop
    //   196: aload_1
    //   197: monitorexit
    //   198: aconst_null
    //   199: areturn
    //   200: astore 6
    //   202: aload_1
    //   203: monitorexit
    //   204: aload 6
    //   206: athrow
    //   207: aload_0
    //   208: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   211: invokestatic 86	com/tencent/component/network/module/common/DnsService:access$300	(Lcom/tencent/component/network/module/common/DnsService;)Ljava/util/HashSet;
    //   214: aload_0
    //   215: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   218: invokevirtual 126	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   221: pop
    //   222: goto +5 -> 227
    //   225: aconst_null
    //   226: astore_1
    //   227: aload_1
    //   228: astore 6
    //   230: aload_0
    //   231: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   234: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   237: ifne +27 -> 264
    //   240: aload_0
    //   241: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   244: invokestatic 132	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   247: astore 7
    //   249: aload_1
    //   250: astore 6
    //   252: aload 7
    //   254: ifnull +10 -> 264
    //   257: aload 7
    //   259: invokevirtual 135	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   262: astore 6
    //   264: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   267: ifeq +34 -> 301
    //   270: new 101	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   277: astore_1
    //   278: aload_1
    //   279: ldc 141
    //   281: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_1
    //   286: aload 6
    //   288: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: ldc 110
    //   294: aload_1
    //   295: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: aload 6
    //   303: astore_1
    //   304: aload_0
    //   305: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   308: aload 6
    //   310: invokestatic 145	com/tencent/component/network/module/common/DnsService:access$500	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;)Z
    //   313: ifne +196 -> 509
    //   316: aload 6
    //   318: astore_1
    //   319: aload_0
    //   320: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   323: invokestatic 148	com/tencent/component/network/module/common/DnsService:access$600	(Lcom/tencent/component/network/module/common/DnsService;)Z
    //   326: ifeq +183 -> 509
    //   329: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   332: lstore_2
    //   333: aload 6
    //   335: astore 7
    //   337: aload_0
    //   338: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   341: astore_1
    //   342: ldc2_w 149
    //   345: lload_2
    //   346: lload 4
    //   348: lsub
    //   349: lsub
    //   350: lstore_2
    //   351: lload_2
    //   352: ldc2_w 151
    //   355: lcmp
    //   356: iflt +2173 -> 2529
    //   359: goto +3 -> 362
    //   362: aload 6
    //   364: astore 7
    //   366: aload_1
    //   367: lload_2
    //   368: invokestatic 158	com/tencent/component/network/module/common/dns/DnsMain:getBetterHostByName	(Ljava/lang/String;J)[Ljava/net/InetAddress;
    //   371: astore 9
    //   373: aload 6
    //   375: astore_1
    //   376: aload 9
    //   378: ifnull +131 -> 509
    //   381: aload 6
    //   383: astore 7
    //   385: aload 6
    //   387: astore_1
    //   388: aload 9
    //   390: arraylength
    //   391: ifle +118 -> 509
    //   394: aload 6
    //   396: astore 7
    //   398: aload 9
    //   400: iconst_0
    //   401: aaload
    //   402: invokevirtual 135	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   405: astore 6
    //   407: aload 6
    //   409: astore 7
    //   411: aload 6
    //   413: astore_1
    //   414: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   417: ifeq +92 -> 509
    //   420: aload 6
    //   422: astore 7
    //   424: new 101	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   431: astore_1
    //   432: aload 6
    //   434: astore 7
    //   436: aload_1
    //   437: ldc 160
    //   439: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload 6
    //   445: astore 7
    //   447: aload_1
    //   448: aload_0
    //   449: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   452: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: aload 6
    //   458: astore 7
    //   460: aload_1
    //   461: ldc 162
    //   463: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload 6
    //   469: astore 7
    //   471: aload_1
    //   472: aload 6
    //   474: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: pop
    //   478: aload 6
    //   480: astore 7
    //   482: ldc 110
    //   484: aload_1
    //   485: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   491: aload 6
    //   493: astore_1
    //   494: goto +15 -> 509
    //   497: astore_1
    //   498: ldc 110
    //   500: ldc 164
    //   502: aload_1
    //   503: invokestatic 168	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   506: aload 7
    //   508: astore_1
    //   509: invokestatic 62	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   512: astore 7
    //   514: aload 7
    //   516: astore 6
    //   518: ldc 64
    //   520: aload 7
    //   522: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   525: ifeq +8 -> 533
    //   528: invokestatic 72	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
    //   531: astore 6
    //   533: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   536: ifeq +145 -> 681
    //   539: new 101	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   546: astore 7
    //   548: aload 7
    //   550: ldc 170
    //   552: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: aload 7
    //   558: aload_0
    //   559: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   562: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload 7
    //   568: ldc 172
    //   570: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload 7
    //   576: aload_1
    //   577: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload 7
    //   583: ldc 174
    //   585: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: aload 7
    //   591: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   594: lload 4
    //   596: lsub
    //   597: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   600: pop
    //   601: aload 7
    //   603: ldc 179
    //   605: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: pop
    //   609: aload 7
    //   611: aload 8
    //   613: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: pop
    //   617: aload 7
    //   619: ldc 181
    //   621: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: pop
    //   625: aload 7
    //   627: aload 6
    //   629: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: aload 7
    //   635: ldc 183
    //   637: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: pop
    //   641: aload 7
    //   643: invokestatic 189	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   646: invokevirtual 192	java/lang/Thread:getId	()J
    //   649: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   652: pop
    //   653: aload 7
    //   655: ldc 194
    //   657: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: pop
    //   661: aload 7
    //   663: aload_0
    //   664: getfield 23	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
    //   667: invokevirtual 197	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: ldc 110
    //   673: aload 7
    //   675: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   678: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   681: aload_0
    //   682: getfield 23	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
    //   685: ifne +18 -> 703
    //   688: aload_0
    //   689: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   692: aload_0
    //   693: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   696: aload_1
    //   697: invokestatic 122	com/tencent/component/network/module/common/DnsService:access$400	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   700: goto +1334 -> 2034
    //   703: aload_0
    //   704: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   707: aload_0
    //   708: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   711: aconst_null
    //   712: invokestatic 122	com/tencent/component/network/module/common/DnsService:access$400	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   715: goto +1319 -> 2034
    //   718: astore 9
    //   720: goto +1345 -> 2065
    //   723: astore 6
    //   725: ldc 110
    //   727: ldc 199
    //   729: aload 6
    //   731: invokestatic 168	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   734: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   737: ifeq +37 -> 774
    //   740: new 101	java/lang/StringBuilder
    //   743: dup
    //   744: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   747: astore 6
    //   749: aload 6
    //   751: ldc 141
    //   753: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: pop
    //   757: aload 6
    //   759: aload_1
    //   760: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: pop
    //   764: ldc 110
    //   766: aload 6
    //   768: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   771: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   774: aload_1
    //   775: astore 6
    //   777: aload_0
    //   778: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   781: aload_1
    //   782: invokestatic 145	com/tencent/component/network/module/common/DnsService:access$500	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;)Z
    //   785: ifne +192 -> 977
    //   788: aload_1
    //   789: astore 6
    //   791: aload_0
    //   792: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   795: invokestatic 148	com/tencent/component/network/module/common/DnsService:access$600	(Lcom/tencent/component/network/module/common/DnsService;)Z
    //   798: ifeq +179 -> 977
    //   801: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   804: lstore_2
    //   805: aload_1
    //   806: astore 7
    //   808: aload_0
    //   809: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   812: astore 6
    //   814: ldc2_w 149
    //   817: lload_2
    //   818: lload 4
    //   820: lsub
    //   821: lsub
    //   822: lstore_2
    //   823: lload_2
    //   824: ldc2_w 151
    //   827: lcmp
    //   828: iflt +1708 -> 2536
    //   831: goto +3 -> 834
    //   834: aload_1
    //   835: astore 7
    //   837: aload 6
    //   839: lload_2
    //   840: invokestatic 158	com/tencent/component/network/module/common/dns/DnsMain:getBetterHostByName	(Ljava/lang/String;J)[Ljava/net/InetAddress;
    //   843: astore 9
    //   845: aload_1
    //   846: astore 6
    //   848: aload 9
    //   850: ifnull +127 -> 977
    //   853: aload_1
    //   854: astore 7
    //   856: aload_1
    //   857: astore 6
    //   859: aload 9
    //   861: arraylength
    //   862: ifle +115 -> 977
    //   865: aload_1
    //   866: astore 7
    //   868: aload 9
    //   870: iconst_0
    //   871: aaload
    //   872: invokevirtual 135	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   875: astore_1
    //   876: aload_1
    //   877: astore 7
    //   879: aload_1
    //   880: astore 6
    //   882: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   885: ifeq +92 -> 977
    //   888: aload_1
    //   889: astore 7
    //   891: new 101	java/lang/StringBuilder
    //   894: dup
    //   895: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   898: astore 6
    //   900: aload_1
    //   901: astore 7
    //   903: aload 6
    //   905: ldc 160
    //   907: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: pop
    //   911: aload_1
    //   912: astore 7
    //   914: aload 6
    //   916: aload_0
    //   917: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   920: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: pop
    //   924: aload_1
    //   925: astore 7
    //   927: aload 6
    //   929: ldc 162
    //   931: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: pop
    //   935: aload_1
    //   936: astore 7
    //   938: aload 6
    //   940: aload_1
    //   941: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: pop
    //   945: aload_1
    //   946: astore 7
    //   948: ldc 110
    //   950: aload 6
    //   952: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   955: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   958: aload_1
    //   959: astore 6
    //   961: goto +16 -> 977
    //   964: astore_1
    //   965: ldc 110
    //   967: ldc 164
    //   969: aload_1
    //   970: invokestatic 168	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   973: aload 7
    //   975: astore 6
    //   977: invokestatic 62	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   980: astore 7
    //   982: aload 7
    //   984: astore_1
    //   985: ldc 64
    //   987: aload 7
    //   989: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   992: ifeq +7 -> 999
    //   995: invokestatic 72	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
    //   998: astore_1
    //   999: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   1002: ifeq +145 -> 1147
    //   1005: new 101	java/lang/StringBuilder
    //   1008: dup
    //   1009: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1012: astore 7
    //   1014: aload 7
    //   1016: ldc 170
    //   1018: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: pop
    //   1022: aload 7
    //   1024: aload_0
    //   1025: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   1028: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1031: pop
    //   1032: aload 7
    //   1034: ldc 172
    //   1036: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: pop
    //   1040: aload 7
    //   1042: aload 6
    //   1044: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: pop
    //   1048: aload 7
    //   1050: ldc 174
    //   1052: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: pop
    //   1056: aload 7
    //   1058: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   1061: lload 4
    //   1063: lsub
    //   1064: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1067: pop
    //   1068: aload 7
    //   1070: ldc 179
    //   1072: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1075: pop
    //   1076: aload 7
    //   1078: aload 8
    //   1080: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: pop
    //   1084: aload 7
    //   1086: ldc 181
    //   1088: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: pop
    //   1092: aload 7
    //   1094: aload_1
    //   1095: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: pop
    //   1099: aload 7
    //   1101: ldc 183
    //   1103: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: pop
    //   1107: aload 7
    //   1109: invokestatic 189	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1112: invokevirtual 192	java/lang/Thread:getId	()J
    //   1115: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1118: pop
    //   1119: aload 7
    //   1121: ldc 194
    //   1123: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: pop
    //   1127: aload 7
    //   1129: aload_0
    //   1130: getfield 23	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
    //   1133: invokevirtual 197	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1136: pop
    //   1137: ldc 110
    //   1139: aload 7
    //   1141: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1144: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1147: aload_0
    //   1148: getfield 23	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
    //   1151: ifne -448 -> 703
    //   1154: aload 6
    //   1156: astore_1
    //   1157: goto -469 -> 688
    //   1160: astore 6
    //   1162: ldc 110
    //   1164: ldc 201
    //   1166: aload 6
    //   1168: invokestatic 168	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1171: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   1174: ifeq +37 -> 1211
    //   1177: new 101	java/lang/StringBuilder
    //   1180: dup
    //   1181: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1184: astore 6
    //   1186: aload 6
    //   1188: ldc 141
    //   1190: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: pop
    //   1194: aload 6
    //   1196: aload_1
    //   1197: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1200: pop
    //   1201: ldc 110
    //   1203: aload 6
    //   1205: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1208: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1211: aload_1
    //   1212: astore 6
    //   1214: aload_0
    //   1215: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   1218: aload_1
    //   1219: invokestatic 145	com/tencent/component/network/module/common/DnsService:access$500	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;)Z
    //   1222: ifne +192 -> 1414
    //   1225: aload_1
    //   1226: astore 6
    //   1228: aload_0
    //   1229: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   1232: invokestatic 148	com/tencent/component/network/module/common/DnsService:access$600	(Lcom/tencent/component/network/module/common/DnsService;)Z
    //   1235: ifeq +179 -> 1414
    //   1238: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   1241: lstore_2
    //   1242: aload_1
    //   1243: astore 7
    //   1245: aload_0
    //   1246: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   1249: astore 6
    //   1251: ldc2_w 149
    //   1254: lload_2
    //   1255: lload 4
    //   1257: lsub
    //   1258: lsub
    //   1259: lstore_2
    //   1260: lload_2
    //   1261: ldc2_w 151
    //   1264: lcmp
    //   1265: iflt +1278 -> 2543
    //   1268: goto +3 -> 1271
    //   1271: aload_1
    //   1272: astore 7
    //   1274: aload 6
    //   1276: lload_2
    //   1277: invokestatic 158	com/tencent/component/network/module/common/dns/DnsMain:getBetterHostByName	(Ljava/lang/String;J)[Ljava/net/InetAddress;
    //   1280: astore 9
    //   1282: aload_1
    //   1283: astore 6
    //   1285: aload 9
    //   1287: ifnull +127 -> 1414
    //   1290: aload_1
    //   1291: astore 7
    //   1293: aload_1
    //   1294: astore 6
    //   1296: aload 9
    //   1298: arraylength
    //   1299: ifle +115 -> 1414
    //   1302: aload_1
    //   1303: astore 7
    //   1305: aload 9
    //   1307: iconst_0
    //   1308: aaload
    //   1309: invokevirtual 135	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1312: astore_1
    //   1313: aload_1
    //   1314: astore 7
    //   1316: aload_1
    //   1317: astore 6
    //   1319: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   1322: ifeq +92 -> 1414
    //   1325: aload_1
    //   1326: astore 7
    //   1328: new 101	java/lang/StringBuilder
    //   1331: dup
    //   1332: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1335: astore 6
    //   1337: aload_1
    //   1338: astore 7
    //   1340: aload 6
    //   1342: ldc 160
    //   1344: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1347: pop
    //   1348: aload_1
    //   1349: astore 7
    //   1351: aload 6
    //   1353: aload_0
    //   1354: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   1357: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1360: pop
    //   1361: aload_1
    //   1362: astore 7
    //   1364: aload 6
    //   1366: ldc 162
    //   1368: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1371: pop
    //   1372: aload_1
    //   1373: astore 7
    //   1375: aload 6
    //   1377: aload_1
    //   1378: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1381: pop
    //   1382: aload_1
    //   1383: astore 7
    //   1385: ldc 110
    //   1387: aload 6
    //   1389: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1392: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1395: aload_1
    //   1396: astore 6
    //   1398: goto +16 -> 1414
    //   1401: astore_1
    //   1402: ldc 110
    //   1404: ldc 164
    //   1406: aload_1
    //   1407: invokestatic 168	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1410: aload 7
    //   1412: astore 6
    //   1414: invokestatic 62	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1417: astore 7
    //   1419: aload 7
    //   1421: astore_1
    //   1422: ldc 64
    //   1424: aload 7
    //   1426: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1429: ifeq +7 -> 1436
    //   1432: invokestatic 72	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
    //   1435: astore_1
    //   1436: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   1439: ifeq +145 -> 1584
    //   1442: new 101	java/lang/StringBuilder
    //   1445: dup
    //   1446: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1449: astore 7
    //   1451: aload 7
    //   1453: ldc 170
    //   1455: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1458: pop
    //   1459: aload 7
    //   1461: aload_0
    //   1462: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   1465: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1468: pop
    //   1469: aload 7
    //   1471: ldc 172
    //   1473: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1476: pop
    //   1477: aload 7
    //   1479: aload 6
    //   1481: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: pop
    //   1485: aload 7
    //   1487: ldc 174
    //   1489: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1492: pop
    //   1493: aload 7
    //   1495: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   1498: lload 4
    //   1500: lsub
    //   1501: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1504: pop
    //   1505: aload 7
    //   1507: ldc 179
    //   1509: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1512: pop
    //   1513: aload 7
    //   1515: aload 8
    //   1517: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1520: pop
    //   1521: aload 7
    //   1523: ldc 181
    //   1525: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1528: pop
    //   1529: aload 7
    //   1531: aload_1
    //   1532: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1535: pop
    //   1536: aload 7
    //   1538: ldc 183
    //   1540: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1543: pop
    //   1544: aload 7
    //   1546: invokestatic 189	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1549: invokevirtual 192	java/lang/Thread:getId	()J
    //   1552: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1555: pop
    //   1556: aload 7
    //   1558: ldc 194
    //   1560: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1563: pop
    //   1564: aload 7
    //   1566: aload_0
    //   1567: getfield 23	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
    //   1570: invokevirtual 197	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1573: pop
    //   1574: ldc 110
    //   1576: aload 7
    //   1578: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1581: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1584: aload_0
    //   1585: getfield 23	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
    //   1588: ifne -885 -> 703
    //   1591: aload 6
    //   1593: astore_1
    //   1594: goto -906 -> 688
    //   1597: astore 6
    //   1599: ldc 110
    //   1601: ldc 201
    //   1603: aload 6
    //   1605: invokestatic 168	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1608: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   1611: ifeq +37 -> 1648
    //   1614: new 101	java/lang/StringBuilder
    //   1617: dup
    //   1618: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1621: astore 6
    //   1623: aload 6
    //   1625: ldc 141
    //   1627: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1630: pop
    //   1631: aload 6
    //   1633: aload_1
    //   1634: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1637: pop
    //   1638: ldc 110
    //   1640: aload 6
    //   1642: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1645: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1648: aload_1
    //   1649: astore 6
    //   1651: aload_0
    //   1652: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   1655: aload_1
    //   1656: invokestatic 145	com/tencent/component/network/module/common/DnsService:access$500	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;)Z
    //   1659: ifne +192 -> 1851
    //   1662: aload_1
    //   1663: astore 6
    //   1665: aload_0
    //   1666: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   1669: invokestatic 148	com/tencent/component/network/module/common/DnsService:access$600	(Lcom/tencent/component/network/module/common/DnsService;)Z
    //   1672: ifeq +179 -> 1851
    //   1675: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   1678: lstore_2
    //   1679: aload_1
    //   1680: astore 7
    //   1682: aload_0
    //   1683: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   1686: astore 6
    //   1688: ldc2_w 149
    //   1691: lload_2
    //   1692: lload 4
    //   1694: lsub
    //   1695: lsub
    //   1696: lstore_2
    //   1697: lload_2
    //   1698: ldc2_w 151
    //   1701: lcmp
    //   1702: iflt +848 -> 2550
    //   1705: goto +3 -> 1708
    //   1708: aload_1
    //   1709: astore 7
    //   1711: aload 6
    //   1713: lload_2
    //   1714: invokestatic 158	com/tencent/component/network/module/common/dns/DnsMain:getBetterHostByName	(Ljava/lang/String;J)[Ljava/net/InetAddress;
    //   1717: astore 9
    //   1719: aload_1
    //   1720: astore 6
    //   1722: aload 9
    //   1724: ifnull +127 -> 1851
    //   1727: aload_1
    //   1728: astore 7
    //   1730: aload_1
    //   1731: astore 6
    //   1733: aload 9
    //   1735: arraylength
    //   1736: ifle +115 -> 1851
    //   1739: aload_1
    //   1740: astore 7
    //   1742: aload 9
    //   1744: iconst_0
    //   1745: aaload
    //   1746: invokevirtual 135	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1749: astore_1
    //   1750: aload_1
    //   1751: astore 7
    //   1753: aload_1
    //   1754: astore 6
    //   1756: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   1759: ifeq +92 -> 1851
    //   1762: aload_1
    //   1763: astore 7
    //   1765: new 101	java/lang/StringBuilder
    //   1768: dup
    //   1769: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1772: astore 6
    //   1774: aload_1
    //   1775: astore 7
    //   1777: aload 6
    //   1779: ldc 160
    //   1781: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1784: pop
    //   1785: aload_1
    //   1786: astore 7
    //   1788: aload 6
    //   1790: aload_0
    //   1791: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   1794: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1797: pop
    //   1798: aload_1
    //   1799: astore 7
    //   1801: aload 6
    //   1803: ldc 162
    //   1805: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1808: pop
    //   1809: aload_1
    //   1810: astore 7
    //   1812: aload 6
    //   1814: aload_1
    //   1815: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1818: pop
    //   1819: aload_1
    //   1820: astore 7
    //   1822: ldc 110
    //   1824: aload 6
    //   1826: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1829: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1832: aload_1
    //   1833: astore 6
    //   1835: goto +16 -> 1851
    //   1838: astore_1
    //   1839: ldc 110
    //   1841: ldc 164
    //   1843: aload_1
    //   1844: invokestatic 168	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1847: aload 7
    //   1849: astore 6
    //   1851: invokestatic 62	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1854: astore 7
    //   1856: aload 7
    //   1858: astore_1
    //   1859: ldc 64
    //   1861: aload 7
    //   1863: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1866: ifeq +7 -> 1873
    //   1869: invokestatic 72	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
    //   1872: astore_1
    //   1873: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   1876: ifeq +145 -> 2021
    //   1879: new 101	java/lang/StringBuilder
    //   1882: dup
    //   1883: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1886: astore 7
    //   1888: aload 7
    //   1890: ldc 170
    //   1892: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1895: pop
    //   1896: aload 7
    //   1898: aload_0
    //   1899: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   1902: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1905: pop
    //   1906: aload 7
    //   1908: ldc 172
    //   1910: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1913: pop
    //   1914: aload 7
    //   1916: aload 6
    //   1918: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1921: pop
    //   1922: aload 7
    //   1924: ldc 174
    //   1926: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1929: pop
    //   1930: aload 7
    //   1932: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   1935: lload 4
    //   1937: lsub
    //   1938: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1941: pop
    //   1942: aload 7
    //   1944: ldc 179
    //   1946: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1949: pop
    //   1950: aload 7
    //   1952: aload 8
    //   1954: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1957: pop
    //   1958: aload 7
    //   1960: ldc 181
    //   1962: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1965: pop
    //   1966: aload 7
    //   1968: aload_1
    //   1969: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1972: pop
    //   1973: aload 7
    //   1975: ldc 183
    //   1977: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1980: pop
    //   1981: aload 7
    //   1983: invokestatic 189	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1986: invokevirtual 192	java/lang/Thread:getId	()J
    //   1989: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1992: pop
    //   1993: aload 7
    //   1995: ldc 194
    //   1997: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2000: pop
    //   2001: aload 7
    //   2003: aload_0
    //   2004: getfield 23	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
    //   2007: invokevirtual 197	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2010: pop
    //   2011: ldc 110
    //   2013: aload 7
    //   2015: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2018: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2021: aload_0
    //   2022: getfield 23	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
    //   2025: ifne -1322 -> 703
    //   2028: aload 6
    //   2030: astore_1
    //   2031: goto -1343 -> 688
    //   2034: invokestatic 46	com/tencent/component/network/module/common/DnsService:access$000	()[B
    //   2037: astore_1
    //   2038: aload_1
    //   2039: monitorenter
    //   2040: aload_0
    //   2041: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   2044: invokestatic 50	com/tencent/component/network/module/common/DnsService:access$100	(Lcom/tencent/component/network/module/common/DnsService;)Ljava/util/List;
    //   2047: aload_0
    //   2048: invokeinterface 125 2 0
    //   2053: pop
    //   2054: aload_1
    //   2055: monitorexit
    //   2056: aconst_null
    //   2057: areturn
    //   2058: astore 6
    //   2060: aload_1
    //   2061: monitorexit
    //   2062: aload 6
    //   2064: athrow
    //   2065: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   2068: ifeq +37 -> 2105
    //   2071: new 101	java/lang/StringBuilder
    //   2074: dup
    //   2075: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   2078: astore 6
    //   2080: aload 6
    //   2082: ldc 141
    //   2084: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2087: pop
    //   2088: aload 6
    //   2090: aload_1
    //   2091: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2094: pop
    //   2095: ldc 110
    //   2097: aload 6
    //   2099: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2102: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2105: aload_1
    //   2106: astore 6
    //   2108: aload_0
    //   2109: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   2112: aload_1
    //   2113: invokestatic 145	com/tencent/component/network/module/common/DnsService:access$500	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;)Z
    //   2116: ifne +192 -> 2308
    //   2119: aload_1
    //   2120: astore 6
    //   2122: aload_0
    //   2123: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   2126: invokestatic 148	com/tencent/component/network/module/common/DnsService:access$600	(Lcom/tencent/component/network/module/common/DnsService;)Z
    //   2129: ifeq +179 -> 2308
    //   2132: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   2135: lstore_2
    //   2136: aload_1
    //   2137: astore 7
    //   2139: aload_0
    //   2140: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   2143: astore 6
    //   2145: ldc2_w 149
    //   2148: lload_2
    //   2149: lload 4
    //   2151: lsub
    //   2152: lsub
    //   2153: lstore_2
    //   2154: lload_2
    //   2155: ldc2_w 151
    //   2158: lcmp
    //   2159: iflt +398 -> 2557
    //   2162: goto +3 -> 2165
    //   2165: aload_1
    //   2166: astore 7
    //   2168: aload 6
    //   2170: lload_2
    //   2171: invokestatic 158	com/tencent/component/network/module/common/dns/DnsMain:getBetterHostByName	(Ljava/lang/String;J)[Ljava/net/InetAddress;
    //   2174: astore 10
    //   2176: aload_1
    //   2177: astore 6
    //   2179: aload 10
    //   2181: ifnull +127 -> 2308
    //   2184: aload_1
    //   2185: astore 7
    //   2187: aload_1
    //   2188: astore 6
    //   2190: aload 10
    //   2192: arraylength
    //   2193: ifle +115 -> 2308
    //   2196: aload_1
    //   2197: astore 7
    //   2199: aload 10
    //   2201: iconst_0
    //   2202: aaload
    //   2203: invokevirtual 135	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   2206: astore_1
    //   2207: aload_1
    //   2208: astore 7
    //   2210: aload_1
    //   2211: astore 6
    //   2213: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   2216: ifeq +92 -> 2308
    //   2219: aload_1
    //   2220: astore 7
    //   2222: new 101	java/lang/StringBuilder
    //   2225: dup
    //   2226: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   2229: astore 6
    //   2231: aload_1
    //   2232: astore 7
    //   2234: aload 6
    //   2236: ldc 160
    //   2238: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2241: pop
    //   2242: aload_1
    //   2243: astore 7
    //   2245: aload 6
    //   2247: aload_0
    //   2248: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   2251: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2254: pop
    //   2255: aload_1
    //   2256: astore 7
    //   2258: aload 6
    //   2260: ldc 162
    //   2262: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2265: pop
    //   2266: aload_1
    //   2267: astore 7
    //   2269: aload 6
    //   2271: aload_1
    //   2272: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2275: pop
    //   2276: aload_1
    //   2277: astore 7
    //   2279: ldc 110
    //   2281: aload 6
    //   2283: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2286: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2289: aload_1
    //   2290: astore 6
    //   2292: goto +16 -> 2308
    //   2295: astore_1
    //   2296: ldc 110
    //   2298: ldc 164
    //   2300: aload_1
    //   2301: invokestatic 168	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2304: aload 7
    //   2306: astore 6
    //   2308: invokestatic 62	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   2311: astore 7
    //   2313: aload 7
    //   2315: astore_1
    //   2316: ldc 64
    //   2318: aload 7
    //   2320: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2323: ifeq +7 -> 2330
    //   2326: invokestatic 72	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
    //   2329: astore_1
    //   2330: invokestatic 139	com/tencent/component/network/module/base/QDLog:isInfoEnable	()Z
    //   2333: ifeq +145 -> 2478
    //   2336: new 101	java/lang/StringBuilder
    //   2339: dup
    //   2340: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   2343: astore 7
    //   2345: aload 7
    //   2347: ldc 170
    //   2349: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2352: pop
    //   2353: aload 7
    //   2355: aload_0
    //   2356: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   2359: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2362: pop
    //   2363: aload 7
    //   2365: ldc 172
    //   2367: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2370: pop
    //   2371: aload 7
    //   2373: aload 6
    //   2375: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2378: pop
    //   2379: aload 7
    //   2381: ldc 174
    //   2383: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2386: pop
    //   2387: aload 7
    //   2389: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   2392: lload 4
    //   2394: lsub
    //   2395: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2398: pop
    //   2399: aload 7
    //   2401: ldc 179
    //   2403: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2406: pop
    //   2407: aload 7
    //   2409: aload 8
    //   2411: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2414: pop
    //   2415: aload 7
    //   2417: ldc 181
    //   2419: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2422: pop
    //   2423: aload 7
    //   2425: aload_1
    //   2426: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2429: pop
    //   2430: aload 7
    //   2432: ldc 183
    //   2434: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2437: pop
    //   2438: aload 7
    //   2440: invokestatic 189	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2443: invokevirtual 192	java/lang/Thread:getId	()J
    //   2446: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2449: pop
    //   2450: aload 7
    //   2452: ldc 194
    //   2454: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2457: pop
    //   2458: aload 7
    //   2460: aload_0
    //   2461: getfield 23	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
    //   2464: invokevirtual 197	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2467: pop
    //   2468: ldc 110
    //   2470: aload 7
    //   2472: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2475: invokestatic 119	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2478: aload_0
    //   2479: getfield 23	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mIsExpired	Z
    //   2482: ifne +19 -> 2501
    //   2485: aload_0
    //   2486: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   2489: aload_0
    //   2490: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   2493: aload 6
    //   2495: invokestatic 122	com/tencent/component/network/module/common/DnsService:access$400	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   2498: goto +15 -> 2513
    //   2501: aload_0
    //   2502: getfield 18	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:this$0	Lcom/tencent/component/network/module/common/DnsService;
    //   2505: aload_0
    //   2506: getfield 25	com/tencent/component/network/module/common/DnsService$ResolverDomainTask:mDomain	Ljava/lang/String;
    //   2509: aconst_null
    //   2510: invokestatic 122	com/tencent/component/network/module/common/DnsService:access$400	(Lcom/tencent/component/network/module/common/DnsService;Ljava/lang/String;Ljava/lang/String;)V
    //   2513: aload 9
    //   2515: athrow
    //   2516: astore 6
    //   2518: aload_1
    //   2519: monitorexit
    //   2520: goto +6 -> 2526
    //   2523: aload 6
    //   2525: athrow
    //   2526: goto -3 -> 2523
    //   2529: ldc2_w 151
    //   2532: lstore_2
    //   2533: goto -2171 -> 362
    //   2536: ldc2_w 151
    //   2539: lstore_2
    //   2540: goto -1706 -> 834
    //   2543: ldc2_w 151
    //   2546: lstore_2
    //   2547: goto -1276 -> 1271
    //   2550: ldc2_w 151
    //   2553: lstore_2
    //   2554: goto -846 -> 1708
    //   2557: ldc2_w 151
    //   2560: lstore_2
    //   2561: goto -396 -> 2165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2564	0	this	ResolverDomainTask
    //   0	2564	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   332	2229	2	l1	long
    //   46	2347	4	l2	long
    //   80	55	6	localObject1	Object
    //   200	5	6	localObject2	Object
    //   228	400	6	localObject3	Object
    //   723	7	6	localError	java.lang.Error
    //   747	408	6	localObject4	Object
    //   1160	7	6	localException	java.lang.Exception
    //   1184	408	6	localObject5	Object
    //   1597	7	6	localUnknownHostException	java.net.UnknownHostException
    //   1621	408	6	localObject6	Object
    //   2058	5	6	localObject7	Object
    //   2078	416	6	localObject8	Object
    //   2516	8	6	localObject9	Object
    //   247	2224	7	localObject10	Object
    //   27	2383	8	localObject11	Object
    //   371	28	9	arrayOfInetAddress1	java.net.InetAddress[]
    //   718	1	9	localObject12	Object
    //   843	1671	9	arrayOfInetAddress2	java.net.InetAddress[]
    //   2174	26	10	arrayOfInetAddress3	java.net.InetAddress[]
    // Exception table:
    //   from	to	target	type
    //   182	198	200	finally
    //   202	204	200	finally
    //   337	342	497	java/lang/Throwable
    //   366	373	497	java/lang/Throwable
    //   388	394	497	java/lang/Throwable
    //   398	407	497	java/lang/Throwable
    //   414	420	497	java/lang/Throwable
    //   424	432	497	java/lang/Throwable
    //   436	443	497	java/lang/Throwable
    //   447	456	497	java/lang/Throwable
    //   460	467	497	java/lang/Throwable
    //   471	478	497	java/lang/Throwable
    //   482	491	497	java/lang/Throwable
    //   230	249	718	finally
    //   257	264	718	finally
    //   725	734	718	finally
    //   1162	1171	718	finally
    //   1599	1608	718	finally
    //   230	249	723	java/lang/Error
    //   257	264	723	java/lang/Error
    //   808	814	964	java/lang/Throwable
    //   837	845	964	java/lang/Throwable
    //   859	865	964	java/lang/Throwable
    //   868	876	964	java/lang/Throwable
    //   882	888	964	java/lang/Throwable
    //   891	900	964	java/lang/Throwable
    //   903	911	964	java/lang/Throwable
    //   914	924	964	java/lang/Throwable
    //   927	935	964	java/lang/Throwable
    //   938	945	964	java/lang/Throwable
    //   948	958	964	java/lang/Throwable
    //   230	249	1160	java/lang/Exception
    //   257	264	1160	java/lang/Exception
    //   1245	1251	1401	java/lang/Throwable
    //   1274	1282	1401	java/lang/Throwable
    //   1296	1302	1401	java/lang/Throwable
    //   1305	1313	1401	java/lang/Throwable
    //   1319	1325	1401	java/lang/Throwable
    //   1328	1337	1401	java/lang/Throwable
    //   1340	1348	1401	java/lang/Throwable
    //   1351	1361	1401	java/lang/Throwable
    //   1364	1372	1401	java/lang/Throwable
    //   1375	1382	1401	java/lang/Throwable
    //   1385	1395	1401	java/lang/Throwable
    //   230	249	1597	java/net/UnknownHostException
    //   257	264	1597	java/net/UnknownHostException
    //   1682	1688	1838	java/lang/Throwable
    //   1711	1719	1838	java/lang/Throwable
    //   1733	1739	1838	java/lang/Throwable
    //   1742	1750	1838	java/lang/Throwable
    //   1756	1762	1838	java/lang/Throwable
    //   1765	1774	1838	java/lang/Throwable
    //   1777	1785	1838	java/lang/Throwable
    //   1788	1798	1838	java/lang/Throwable
    //   1801	1809	1838	java/lang/Throwable
    //   1812	1819	1838	java/lang/Throwable
    //   1822	1832	1838	java/lang/Throwable
    //   2040	2056	2058	finally
    //   2060	2062	2058	finally
    //   2139	2145	2295	java/lang/Throwable
    //   2168	2176	2295	java/lang/Throwable
    //   2190	2196	2295	java/lang/Throwable
    //   2199	2207	2295	java/lang/Throwable
    //   2213	2219	2295	java/lang/Throwable
    //   2222	2231	2295	java/lang/Throwable
    //   2234	2242	2295	java/lang/Throwable
    //   2245	2255	2295	java/lang/Throwable
    //   2258	2266	2295	java/lang/Throwable
    //   2269	2276	2295	java/lang/Throwable
    //   2279	2289	2295	java/lang/Throwable
    //   6	22	2516	finally
    //   2518	2520	2516	finally
  }
  
  public void setIsExpired(boolean paramBoolean)
  {
    this.mIsExpired = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.module.common.DnsService.ResolverDomainTask
 * JD-Core Version:    0.7.0.1
 */