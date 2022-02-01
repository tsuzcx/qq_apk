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
    //   86: invokevirtual 36	com/tencent/mobileqq/activity/ChatHistory:a	(I)V
    //   89: iconst_1
    //   90: ireturn
    //   91: aload_1
    //   92: getfield 31	android/os/Message:arg1	I
    //   95: ifle +20 -> 115
    //   98: aload_0
    //   99: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   102: aload_1
    //   103: getfield 40	android/os/Message:obj	Ljava/lang/Object;
    //   106: checkcast 42	java/lang/String
    //   109: invokevirtual 45	com/tencent/mobileqq/activity/ChatHistory:a	(Ljava/lang/String;)V
    //   112: goto +18 -> 130
    //   115: aload_0
    //   116: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   119: astore_1
    //   120: aload_1
    //   121: aload_1
    //   122: ldc 46
    //   124: invokevirtual 50	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   127: invokevirtual 53	com/tencent/mobileqq/activity/ChatHistory:b	(Ljava/lang/String;)V
    //   130: aload_0
    //   131: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   134: getfield 57	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   137: ldc 59
    //   139: ldc 61
    //   141: ldc 61
    //   143: ldc 63
    //   145: ldc 63
    //   147: aload_0
    //   148: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   151: getfield 66	com/tencent/mobileqq/activity/ChatHistory:k	I
    //   154: iconst_0
    //   155: ldc 61
    //   157: ldc 61
    //   159: ldc 61
    //   161: ldc 61
    //   163: invokestatic 71	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   166: iconst_1
    //   167: ireturn
    //   168: aload_0
    //   169: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   172: aload_1
    //   173: getfield 31	android/os/Message:arg1	I
    //   176: aload_1
    //   177: getfield 74	android/os/Message:arg2	I
    //   180: invokevirtual 77	com/tencent/mobileqq/activity/ChatHistory:a	(II)V
    //   183: aload_0
    //   184: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   187: invokevirtual 80	com/tencent/mobileqq/activity/ChatHistory:g	()V
    //   190: iconst_1
    //   191: ireturn
    //   192: aload_0
    //   193: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   196: aload_1
    //   197: getfield 31	android/os/Message:arg1	I
    //   200: aload_1
    //   201: getfield 74	android/os/Message:arg2	I
    //   204: invokevirtual 77	com/tencent/mobileqq/activity/ChatHistory:a	(II)V
    //   207: aload_0
    //   208: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   211: invokevirtual 83	com/tencent/mobileqq/activity/ChatHistory:e	()V
    //   214: iconst_1
    //   215: ireturn
    //   216: aload_0
    //   217: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   220: aload_1
    //   221: getfield 31	android/os/Message:arg1	I
    //   224: aload_1
    //   225: getfield 74	android/os/Message:arg2	I
    //   228: invokevirtual 77	com/tencent/mobileqq/activity/ChatHistory:a	(II)V
    //   231: aload_0
    //   232: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   235: invokevirtual 86	com/tencent/mobileqq/activity/ChatHistory:f	()V
    //   238: aload_0
    //   239: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   242: invokevirtual 89	com/tencent/mobileqq/activity/ChatHistory:d	()V
    //   245: iconst_1
    //   246: ireturn
    //   247: aload_1
    //   248: getfield 40	android/os/Message:obj	Ljava/lang/Object;
    //   251: ifnull +609 -> 860
    //   254: aload_1
    //   255: getfield 40	android/os/Message:obj	Ljava/lang/Object;
    //   258: checkcast 91	android/database/Cursor
    //   261: astore_1
    //   262: aload_0
    //   263: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   266: getfield 94	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter	Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;
    //   269: ifnull +42 -> 311
    //   272: aload_0
    //   273: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   276: getfield 94	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter	Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;
    //   279: invokevirtual 100	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:getCursor	()Landroid/database/Cursor;
    //   282: ifnull +18 -> 300
    //   285: aload_0
    //   286: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   289: getfield 94	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter	Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;
    //   292: invokevirtual 100	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:getCursor	()Landroid/database/Cursor;
    //   295: invokeinterface 103 1 0
    //   300: aload_0
    //   301: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   304: getfield 94	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter	Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;
    //   307: aload_1
    //   308: invokevirtual 107	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:changeCursor	(Landroid/database/Cursor;)V
    //   311: aload_0
    //   312: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   315: getfield 94	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter	Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;
    //   318: ifnull +542 -> 860
    //   321: aload_0
    //   322: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   325: getfield 94	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter	Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;
    //   328: getfield 110	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:c	I
    //   331: iflt +529 -> 860
    //   334: aload_0
    //   335: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   338: getfield 94	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter	Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;
    //   341: getfield 110	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:c	I
    //   344: bipush 8
    //   346: if_icmpge +514 -> 860
    //   349: aload_0
    //   350: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   353: getfield 113	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   356: aload_0
    //   357: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   360: getfield 94	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter	Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;
    //   363: getfield 110	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:c	I
    //   366: aload_0
    //   367: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   370: getfield 113	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   373: invokevirtual 119	com/tencent/widget/XListView:getHeaderViewsCount	()I
    //   376: iadd
    //   377: invokevirtual 122	com/tencent/widget/XListView:setSelection	(I)V
    //   380: aload_0
    //   381: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   384: getfield 94	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter	Lcom/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter;
    //   387: iconst_m1
    //   388: putfield 110	com/tencent/mobileqq/activity/ChatHistory$ChatHistoryAdapter:c	I
    //   391: iconst_1
    //   392: ireturn
    //   393: aload_0
    //   394: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   397: getfield 125	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   400: iconst_1
    //   401: invokevirtual 131	android/widget/TextView:setEnabled	(Z)V
    //   404: aload_0
    //   405: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   408: getfield 134	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   411: ifnull +13 -> 424
    //   414: aload_0
    //   415: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   418: getfield 134	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   421: invokevirtual 139	android/app/Dialog:dismiss	()V
    //   424: aload_0
    //   425: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   428: astore_1
    //   429: aload_1
    //   430: ldc 140
    //   432: aload_1
    //   433: ldc 141
    //   435: invokevirtual 50	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   438: invokevirtual 144	com/tencent/mobileqq/activity/ChatHistory:a	(ILjava/lang/String;)V
    //   441: iconst_1
    //   442: ireturn
    //   443: aload_0
    //   444: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   447: getfield 125	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   450: iconst_1
    //   451: invokevirtual 131	android/widget/TextView:setEnabled	(Z)V
    //   454: invokestatic 150	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   457: invokestatic 156	com/tencent/mobileqq/utils/NetworkUtil:isNetSupport	(Landroid/content/Context;)Z
    //   460: ifeq +400 -> 860
    //   463: aload_0
    //   464: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   467: getfield 159	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_ComTencentMobileqqBannerTipsBar	Lcom/tencent/mobileqq/banner/TipsBar;
    //   470: bipush 8
    //   472: invokevirtual 164	com/tencent/mobileqq/banner/TipsBar:setVisibility	(I)V
    //   475: iconst_1
    //   476: ireturn
    //   477: aload_0
    //   478: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   481: astore_1
    //   482: aload_1
    //   483: ldc 140
    //   485: aload_1
    //   486: ldc 165
    //   488: invokevirtual 50	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   491: invokevirtual 144	com/tencent/mobileqq/activity/ChatHistory:a	(ILjava/lang/String;)V
    //   494: iconst_1
    //   495: ireturn
    //   496: aload_0
    //   497: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   500: astore_2
    //   501: aload_2
    //   502: new 167	com/tencent/qqlive/module/videoreport/inject/dialog/ReportDialog
    //   505: dup
    //   506: aload_2
    //   507: ldc 168
    //   509: invokespecial 171	com/tencent/qqlive/module/videoreport/inject/dialog/ReportDialog:<init>	(Landroid/content/Context;I)V
    //   512: putfield 134	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   515: aload_0
    //   516: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   519: getfield 134	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   522: ldc 172
    //   524: invokevirtual 175	android/app/Dialog:setContentView	(I)V
    //   527: aload_0
    //   528: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   531: getfield 134	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   534: ldc 176
    //   536: invokevirtual 180	android/app/Dialog:findViewById	(I)Landroid/view/View;
    //   539: checkcast 127	android/widget/TextView
    //   542: aload_1
    //   543: getfield 40	android/os/Message:obj	Ljava/lang/Object;
    //   546: invokevirtual 184	java/lang/Object:toString	()Ljava/lang/String;
    //   549: invokevirtual 188	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   552: aload_0
    //   553: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   556: getfield 134	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   559: new 190	com/tencent/mobileqq/activity/ChatHistory$1$1
    //   562: dup
    //   563: aload_0
    //   564: invokespecial 193	com/tencent/mobileqq/activity/ChatHistory$1$1:<init>	(Lcom/tencent/mobileqq/activity/ChatHistory$1;)V
    //   567: invokevirtual 197	android/app/Dialog:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   570: aload_0
    //   571: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   574: getfield 134	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   577: invokevirtual 200	android/app/Dialog:show	()V
    //   580: iconst_1
    //   581: ireturn
    //   582: aload_0
    //   583: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   586: getfield 125	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   589: iconst_1
    //   590: invokevirtual 131	android/widget/TextView:setEnabled	(Z)V
    //   593: aload_0
    //   594: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   597: getfield 134	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   600: ifnull +13 -> 613
    //   603: aload_0
    //   604: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   607: getfield 134	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   610: invokevirtual 139	android/app/Dialog:dismiss	()V
    //   613: aload_0
    //   614: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   617: astore_1
    //   618: aload_1
    //   619: ldc 140
    //   621: aload_1
    //   622: ldc 201
    //   624: invokevirtual 50	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   627: invokevirtual 144	com/tencent/mobileqq/activity/ChatHistory:a	(ILjava/lang/String;)V
    //   630: iconst_1
    //   631: ireturn
    //   632: aload_0
    //   633: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   636: invokevirtual 204	com/tencent/mobileqq/activity/ChatHistory:i	()V
    //   639: iconst_1
    //   640: ireturn
    //   641: aload_0
    //   642: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   645: getfield 125	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   648: iconst_1
    //   649: invokevirtual 131	android/widget/TextView:setEnabled	(Z)V
    //   652: aload_0
    //   653: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   656: getfield 134	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   659: ifnull +13 -> 672
    //   662: aload_0
    //   663: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   666: getfield 134	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   669: invokevirtual 139	android/app/Dialog:dismiss	()V
    //   672: aload_0
    //   673: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   676: astore_1
    //   677: aload_1
    //   678: ldc 140
    //   680: aload_1
    //   681: ldc 205
    //   683: invokevirtual 50	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   686: invokevirtual 144	com/tencent/mobileqq/activity/ChatHistory:a	(ILjava/lang/String;)V
    //   689: iconst_1
    //   690: ireturn
    //   691: aload_0
    //   692: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   695: getfield 125	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   698: iconst_1
    //   699: invokevirtual 131	android/widget/TextView:setEnabled	(Z)V
    //   702: aload_0
    //   703: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   706: getfield 134	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   709: ifnull +26 -> 735
    //   712: aload_0
    //   713: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   716: getfield 134	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   719: invokevirtual 209	android/app/Dialog:isShowing	()Z
    //   722: ifeq +13 -> 735
    //   725: aload_0
    //   726: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   729: getfield 134	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   732: invokevirtual 139	android/app/Dialog:dismiss	()V
    //   735: aload_0
    //   736: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   739: aconst_null
    //   740: putfield 134	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   743: goto +95 -> 838
    //   746: astore_1
    //   747: goto +103 -> 850
    //   750: astore_1
    //   751: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   754: ifeq -19 -> 735
    //   757: new 216	java/lang/StringBuilder
    //   760: dup
    //   761: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   764: astore_2
    //   765: aload_2
    //   766: ldc 219
    //   768: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: pop
    //   772: aload_2
    //   773: aload_1
    //   774: invokevirtual 226	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   777: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: pop
    //   781: ldc 228
    //   783: iconst_2
    //   784: aload_2
    //   785: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   788: invokestatic 232	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   791: goto -56 -> 735
    //   794: astore_1
    //   795: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   798: ifeq -63 -> 735
    //   801: new 216	java/lang/StringBuilder
    //   804: dup
    //   805: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   808: astore_2
    //   809: aload_2
    //   810: ldc 219
    //   812: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: pop
    //   816: aload_2
    //   817: aload_1
    //   818: invokevirtual 233	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   821: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: pop
    //   825: ldc 228
    //   827: iconst_2
    //   828: aload_2
    //   829: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   832: invokestatic 232	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   835: goto -100 -> 735
    //   838: aload_0
    //   839: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   842: bipush 10
    //   844: iconst_0
    //   845: invokevirtual 236	com/tencent/mobileqq/activity/ChatHistory:a	(IZ)V
    //   848: iconst_1
    //   849: ireturn
    //   850: aload_0
    //   851: getfield 12	com/tencent/mobileqq/activity/ChatHistory$1:a	Lcom/tencent/mobileqq/activity/ChatHistory;
    //   854: aconst_null
    //   855: putfield 134	com/tencent/mobileqq/activity/ChatHistory:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.1
 * JD-Core Version:    0.7.0.1
 */