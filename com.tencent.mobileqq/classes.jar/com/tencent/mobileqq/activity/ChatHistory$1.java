package com.tencent.mobileqq.activity;

import android.os.Handler.Callback;

class ChatHistory$1
  implements Handler.Callback
{
  ChatHistory$1(ChatHistory paramChatHistory) {}
  
  /* Error */
  public boolean handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 28	android/os/Message:what	I
    //   4: tableswitch	default:+72 -> 76, 0:+687->691, 1:+637->641, 2:+628->632, 3:+578->582, 4:+492->496, 5:+473->477, 6:+439->443, 7:+389->393, 8:+243->247, 9:+212->216, 10:+188->192, 11:+164->168, 12:+87->91, 13:+74->78
    //   77: ireturn
    //   78: aload_0
    //   79: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   82: aload_1
    //   83: getfield 31	android/os/Message:arg1	I
    //   86: invokevirtual 37	com/tencent/mobileqq/activity/ChatHistory:b	(I)V
    //   89: iconst_1
    //   90: ireturn
    //   91: aload_1
    //   92: getfield 31	android/os/Message:arg1	I
    //   95: ifle +20 -> 115
    //   98: aload_0
    //   99: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   102: aload_1
    //   103: getfield 41	android/os/Message:obj	Ljava/lang/Object;
    //   106: checkcast 43	java/lang/String
    //   109: invokevirtual 46	com/tencent/mobileqq/activity/ChatHistory:a	(Ljava/lang/String;)V
    //   112: goto +18 -> 130
    //   115: aload_0
    //   116: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   119: astore_1
    //   120: aload_1
    //   121: aload_1
    //   122: ldc 47
    //   124: invokevirtual 51	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   127: invokevirtual 54	com/tencent/mobileqq/activity/ChatHistory:d	(Ljava/lang/String;)V
    //   130: aload_0
    //   131: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   134: getfield 58	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   137: ldc 60
    //   139: ldc 62
    //   141: ldc 62
    //   143: ldc 64
    //   145: ldc 64
    //   147: aload_0
    //   148: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   151: getfield 67	com/tencent/mobileqq/activity/ChatHistory:L	I
    //   154: iconst_0
    //   155: ldc 62
    //   157: ldc 62
    //   159: ldc 62
    //   161: ldc 62
    //   163: invokestatic 72	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   166: iconst_1
    //   167: ireturn
    //   168: aload_0
    //   169: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   172: aload_1
    //   173: getfield 31	android/os/Message:arg1	I
    //   176: aload_1
    //   177: getfield 75	android/os/Message:arg2	I
    //   180: invokevirtual 78	com/tencent/mobileqq/activity/ChatHistory:a	(II)V
    //   183: aload_0
    //   184: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   187: invokevirtual 81	com/tencent/mobileqq/activity/ChatHistory:i	()V
    //   190: iconst_1
    //   191: ireturn
    //   192: aload_0
    //   193: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   196: aload_1
    //   197: getfield 31	android/os/Message:arg1	I
    //   200: aload_1
    //   201: getfield 75	android/os/Message:arg2	I
    //   204: invokevirtual 78	com/tencent/mobileqq/activity/ChatHistory:a	(II)V
    //   207: aload_0
    //   208: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   211: invokevirtual 84	com/tencent/mobileqq/activity/ChatHistory:g	()V
    //   214: iconst_1
    //   215: ireturn
    //   216: aload_0
    //   217: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   220: aload_1
    //   221: getfield 31	android/os/Message:arg1	I
    //   224: aload_1
    //   225: getfield 75	android/os/Message:arg2	I
    //   228: invokevirtual 78	com/tencent/mobileqq/activity/ChatHistory:a	(II)V
    //   231: aload_0
    //   232: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   235: invokevirtual 87	com/tencent/mobileqq/activity/ChatHistory:h	()V
    //   238: aload_0
    //   239: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   242: invokevirtual 90	com/tencent/mobileqq/activity/ChatHistory:f	()V
    //   245: iconst_1
    //   246: ireturn
    //   247: aload_1
    //   248: getfield 41	android/os/Message:obj	Ljava/lang/Object;
    //   251: ifnull +609 -> 860
    //   254: aload_1
    //   255: getfield 41	android/os/Message:obj	Ljava/lang/Object;
    //   258: checkcast 92	android/database/Cursor
    //   261: astore_1
    //   262: aload_0
    //   263: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   266: getfield 96	com/tencent/mobileqq/activity/ChatHistory:j	Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;
    //   269: ifnull +42 -> 311
    //   272: aload_0
    //   273: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   276: getfield 96	com/tencent/mobileqq/activity/ChatHistory:j	Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;
    //   279: invokevirtual 102	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:getCursor	()Landroid/database/Cursor;
    //   282: ifnull +18 -> 300
    //   285: aload_0
    //   286: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   289: getfield 96	com/tencent/mobileqq/activity/ChatHistory:j	Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;
    //   292: invokevirtual 102	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:getCursor	()Landroid/database/Cursor;
    //   295: invokeinterface 105 1 0
    //   300: aload_0
    //   301: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   304: getfield 96	com/tencent/mobileqq/activity/ChatHistory:j	Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;
    //   307: aload_1
    //   308: invokevirtual 109	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:changeCursor	(Landroid/database/Cursor;)V
    //   311: aload_0
    //   312: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   315: getfield 96	com/tencent/mobileqq/activity/ChatHistory:j	Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;
    //   318: ifnull +542 -> 860
    //   321: aload_0
    //   322: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   325: getfield 96	com/tencent/mobileqq/activity/ChatHistory:j	Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;
    //   328: getfield 112	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:e	I
    //   331: iflt +529 -> 860
    //   334: aload_0
    //   335: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   338: getfield 96	com/tencent/mobileqq/activity/ChatHistory:j	Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;
    //   341: getfield 112	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:e	I
    //   344: bipush 8
    //   346: if_icmpge +514 -> 860
    //   349: aload_0
    //   350: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   353: getfield 115	com/tencent/mobileqq/activity/ChatHistory:i	Lcom/tencent/widget/XListView;
    //   356: aload_0
    //   357: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   360: getfield 96	com/tencent/mobileqq/activity/ChatHistory:j	Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;
    //   363: getfield 112	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:e	I
    //   366: aload_0
    //   367: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   370: getfield 115	com/tencent/mobileqq/activity/ChatHistory:i	Lcom/tencent/widget/XListView;
    //   373: invokevirtual 121	com/tencent/widget/XListView:getHeaderViewsCount	()I
    //   376: iadd
    //   377: invokevirtual 124	com/tencent/widget/XListView:setSelection	(I)V
    //   380: aload_0
    //   381: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   384: getfield 96	com/tencent/mobileqq/activity/ChatHistory:j	Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;
    //   387: iconst_m1
    //   388: putfield 112	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:e	I
    //   391: iconst_1
    //   392: ireturn
    //   393: aload_0
    //   394: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   397: getfield 128	com/tencent/mobileqq/activity/ChatHistory:m	Landroid/widget/TextView;
    //   400: iconst_1
    //   401: invokevirtual 134	android/widget/TextView:setEnabled	(Z)V
    //   404: aload_0
    //   405: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   408: getfield 138	com/tencent/mobileqq/activity/ChatHistory:w	Landroid/app/Dialog;
    //   411: ifnull +13 -> 424
    //   414: aload_0
    //   415: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   418: getfield 138	com/tencent/mobileqq/activity/ChatHistory:w	Landroid/app/Dialog;
    //   421: invokevirtual 143	android/app/Dialog:dismiss	()V
    //   424: aload_0
    //   425: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   428: astore_1
    //   429: aload_1
    //   430: ldc 144
    //   432: aload_1
    //   433: ldc 145
    //   435: invokevirtual 51	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   438: invokevirtual 148	com/tencent/mobileqq/activity/ChatHistory:a	(ILjava/lang/String;)V
    //   441: iconst_1
    //   442: ireturn
    //   443: aload_0
    //   444: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   447: getfield 128	com/tencent/mobileqq/activity/ChatHistory:m	Landroid/widget/TextView;
    //   450: iconst_1
    //   451: invokevirtual 134	android/widget/TextView:setEnabled	(Z)V
    //   454: invokestatic 154	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   457: invokestatic 160	com/tencent/mobileqq/utils/NetworkUtil:isNetSupport	(Landroid/content/Context;)Z
    //   460: ifeq +400 -> 860
    //   463: aload_0
    //   464: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   467: getfield 164	com/tencent/mobileqq/activity/ChatHistory:Y	Lcom/tencent/mobileqq/banner/TipsBar;
    //   470: bipush 8
    //   472: invokevirtual 169	com/tencent/mobileqq/banner/TipsBar:setVisibility	(I)V
    //   475: iconst_1
    //   476: ireturn
    //   477: aload_0
    //   478: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   481: astore_1
    //   482: aload_1
    //   483: ldc 144
    //   485: aload_1
    //   486: ldc 170
    //   488: invokevirtual 51	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   491: invokevirtual 148	com/tencent/mobileqq/activity/ChatHistory:a	(ILjava/lang/String;)V
    //   494: iconst_1
    //   495: ireturn
    //   496: aload_0
    //   497: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   500: astore_2
    //   501: aload_2
    //   502: new 172	com/tencent/qqlive/module/videoreport/inject/dialog/ReportDialog
    //   505: dup
    //   506: aload_2
    //   507: ldc 173
    //   509: invokespecial 176	com/tencent/qqlive/module/videoreport/inject/dialog/ReportDialog:<init>	(Landroid/content/Context;I)V
    //   512: putfield 138	com/tencent/mobileqq/activity/ChatHistory:w	Landroid/app/Dialog;
    //   515: aload_0
    //   516: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   519: getfield 138	com/tencent/mobileqq/activity/ChatHistory:w	Landroid/app/Dialog;
    //   522: ldc 177
    //   524: invokevirtual 180	android/app/Dialog:setContentView	(I)V
    //   527: aload_0
    //   528: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   531: getfield 138	com/tencent/mobileqq/activity/ChatHistory:w	Landroid/app/Dialog;
    //   534: ldc 181
    //   536: invokevirtual 185	android/app/Dialog:findViewById	(I)Landroid/view/View;
    //   539: checkcast 130	android/widget/TextView
    //   542: aload_1
    //   543: getfield 41	android/os/Message:obj	Ljava/lang/Object;
    //   546: invokevirtual 189	java/lang/Object:toString	()Ljava/lang/String;
    //   549: invokevirtual 193	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   552: aload_0
    //   553: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   556: getfield 138	com/tencent/mobileqq/activity/ChatHistory:w	Landroid/app/Dialog;
    //   559: new 195	com/tencent/mobileqq/activity/ChatHistory$1$1
    //   562: dup
    //   563: aload_0
    //   564: invokespecial 198	com/tencent/mobileqq/activity/ChatHistory$1$1:<init>	(Lcom/tencent/mobileqq/activity/ChatHistory$1;)V
    //   567: invokevirtual 202	android/app/Dialog:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   570: aload_0
    //   571: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   574: getfield 138	com/tencent/mobileqq/activity/ChatHistory:w	Landroid/app/Dialog;
    //   577: invokevirtual 205	android/app/Dialog:show	()V
    //   580: iconst_1
    //   581: ireturn
    //   582: aload_0
    //   583: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   586: getfield 128	com/tencent/mobileqq/activity/ChatHistory:m	Landroid/widget/TextView;
    //   589: iconst_1
    //   590: invokevirtual 134	android/widget/TextView:setEnabled	(Z)V
    //   593: aload_0
    //   594: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   597: getfield 138	com/tencent/mobileqq/activity/ChatHistory:w	Landroid/app/Dialog;
    //   600: ifnull +13 -> 613
    //   603: aload_0
    //   604: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   607: getfield 138	com/tencent/mobileqq/activity/ChatHistory:w	Landroid/app/Dialog;
    //   610: invokevirtual 143	android/app/Dialog:dismiss	()V
    //   613: aload_0
    //   614: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   617: astore_1
    //   618: aload_1
    //   619: ldc 144
    //   621: aload_1
    //   622: ldc 206
    //   624: invokevirtual 51	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   627: invokevirtual 148	com/tencent/mobileqq/activity/ChatHistory:a	(ILjava/lang/String;)V
    //   630: iconst_1
    //   631: ireturn
    //   632: aload_0
    //   633: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   636: invokevirtual 209	com/tencent/mobileqq/activity/ChatHistory:k	()V
    //   639: iconst_1
    //   640: ireturn
    //   641: aload_0
    //   642: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   645: getfield 128	com/tencent/mobileqq/activity/ChatHistory:m	Landroid/widget/TextView;
    //   648: iconst_1
    //   649: invokevirtual 134	android/widget/TextView:setEnabled	(Z)V
    //   652: aload_0
    //   653: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   656: getfield 138	com/tencent/mobileqq/activity/ChatHistory:w	Landroid/app/Dialog;
    //   659: ifnull +13 -> 672
    //   662: aload_0
    //   663: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   666: getfield 138	com/tencent/mobileqq/activity/ChatHistory:w	Landroid/app/Dialog;
    //   669: invokevirtual 143	android/app/Dialog:dismiss	()V
    //   672: aload_0
    //   673: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   676: astore_1
    //   677: aload_1
    //   678: ldc 144
    //   680: aload_1
    //   681: ldc 210
    //   683: invokevirtual 51	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   686: invokevirtual 148	com/tencent/mobileqq/activity/ChatHistory:a	(ILjava/lang/String;)V
    //   689: iconst_1
    //   690: ireturn
    //   691: aload_0
    //   692: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   695: getfield 128	com/tencent/mobileqq/activity/ChatHistory:m	Landroid/widget/TextView;
    //   698: iconst_1
    //   699: invokevirtual 134	android/widget/TextView:setEnabled	(Z)V
    //   702: aload_0
    //   703: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   706: getfield 138	com/tencent/mobileqq/activity/ChatHistory:w	Landroid/app/Dialog;
    //   709: ifnull +26 -> 735
    //   712: aload_0
    //   713: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   716: getfield 138	com/tencent/mobileqq/activity/ChatHistory:w	Landroid/app/Dialog;
    //   719: invokevirtual 214	android/app/Dialog:isShowing	()Z
    //   722: ifeq +13 -> 735
    //   725: aload_0
    //   726: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   729: getfield 138	com/tencent/mobileqq/activity/ChatHistory:w	Landroid/app/Dialog;
    //   732: invokevirtual 143	android/app/Dialog:dismiss	()V
    //   735: aload_0
    //   736: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   739: aconst_null
    //   740: putfield 138	com/tencent/mobileqq/activity/ChatHistory:w	Landroid/app/Dialog;
    //   743: goto +95 -> 838
    //   746: astore_1
    //   747: goto +103 -> 850
    //   750: astore_1
    //   751: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   754: ifeq -19 -> 735
    //   757: new 221	java/lang/StringBuilder
    //   760: dup
    //   761: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   764: astore_2
    //   765: aload_2
    //   766: ldc 224
    //   768: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: pop
    //   772: aload_2
    //   773: aload_1
    //   774: invokevirtual 231	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   777: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: pop
    //   781: ldc 233
    //   783: iconst_2
    //   784: aload_2
    //   785: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   788: invokestatic 237	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   791: goto -56 -> 735
    //   794: astore_1
    //   795: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   798: ifeq -63 -> 735
    //   801: new 221	java/lang/StringBuilder
    //   804: dup
    //   805: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   808: astore_2
    //   809: aload_2
    //   810: ldc 224
    //   812: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: pop
    //   816: aload_2
    //   817: aload_1
    //   818: invokevirtual 238	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   821: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: pop
    //   825: ldc 233
    //   827: iconst_2
    //   828: aload_2
    //   829: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   832: invokestatic 237	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   835: goto -100 -> 735
    //   838: aload_0
    //   839: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   842: bipush 10
    //   844: iconst_0
    //   845: invokevirtual 241	com/tencent/mobileqq/activity/ChatHistory:a	(IZ)V
    //   848: iconst_1
    //   849: ireturn
    //   850: aload_0
    //   851: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   854: aconst_null
    //   855: putfield 138	com/tencent/mobileqq/activity/ChatHistory:w	Landroid/app/Dialog;
    //   858: aload_1
    //   859: athrow
    //   860: iconst_1
    //   861: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	862	0	this	1
    //   0	862	1	paramMessage	android.os.Message
    //   500	329	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   702	735	746	finally
    //   751	791	746	finally
    //   795	835	746	finally
    //   702	735	750	java/lang/Exception
    //   702	735	794	java/lang/IllegalArgumentException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.1
 * JD-Core Version:    0.7.0.1
 */