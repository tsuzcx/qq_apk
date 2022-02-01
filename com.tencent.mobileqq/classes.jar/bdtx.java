import android.view.View.OnClickListener;

class bdtx
  implements View.OnClickListener
{
  bdtx(bdts parambdts) {}
  
  /* Error */
  public void onClick(android.view.View paramView)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 4
    //   3: aconst_null
    //   4: astore 9
    //   6: aload_1
    //   7: invokevirtual 26	android/view/View:getContext	()Landroid/content/Context;
    //   10: astore 11
    //   12: aload_1
    //   13: ldc 27
    //   15: invokevirtual 31	android/view/View:getTag	(I)Ljava/lang/Object;
    //   18: astore 6
    //   20: aload 6
    //   22: ifnull +123 -> 145
    //   25: aload 6
    //   27: instanceof 33
    //   30: ifeq +115 -> 145
    //   33: aload 6
    //   35: checkcast 33	bdtz
    //   38: astore 8
    //   40: aload_0
    //   41: getfield 12	bdtx:a	Lbdts;
    //   44: getfield 38	bdts:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   47: instanceof 40
    //   50: ifeq +113 -> 163
    //   53: aload_0
    //   54: getfield 12	bdtx:a	Lbdts;
    //   57: getfield 38	bdts:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   60: checkcast 40	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   63: getfield 44	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:mMsgActionData	Ljava/lang/String;
    //   66: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   69: ifne +94 -> 163
    //   72: aload_0
    //   73: getfield 12	bdtx:a	Lbdts;
    //   76: getfield 38	bdts:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   79: checkcast 40	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   82: getfield 44	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:mMsgActionData	Ljava/lang/String;
    //   85: ldc 52
    //   87: invokevirtual 58	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   90: ifeq +73 -> 163
    //   93: new 60	android/content/Intent
    //   96: dup
    //   97: aload 11
    //   99: ldc 62
    //   101: invokespecial 65	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   104: astore 6
    //   106: aload 6
    //   108: aload_0
    //   109: getfield 12	bdtx:a	Lbdts;
    //   112: getfield 38	bdts:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   115: checkcast 40	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   118: getfield 44	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:mMsgActionData	Ljava/lang/String;
    //   121: invokestatic 71	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   124: invokevirtual 75	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   127: pop
    //   128: aload 6
    //   130: ldc 77
    //   132: ldc 79
    //   134: invokevirtual 83	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   137: pop
    //   138: aload 11
    //   140: aload 6
    //   142: invokevirtual 89	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   145: invokestatic 95	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
    //   148: aload_1
    //   149: invokevirtual 98	com/tencent/qqlive/module/videoreport/collect/EventCollector:onViewClicked	(Landroid/view/View;)V
    //   152: return
    //   153: astore 6
    //   155: aload 6
    //   157: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   160: goto -15 -> 145
    //   163: aload_0
    //   164: getfield 12	bdtx:a	Lbdts;
    //   167: getfield 105	bdts:v	I
    //   170: iconst_4
    //   171: if_icmpne +604 -> 775
    //   174: ldc 107
    //   176: astore 7
    //   178: aload 7
    //   180: astore 6
    //   182: aload_0
    //   183: getfield 12	bdtx:a	Lbdts;
    //   186: getfield 38	bdts:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   189: ifnull +37 -> 226
    //   192: aload 7
    //   194: astore 6
    //   196: aload_0
    //   197: getfield 12	bdtx:a	Lbdts;
    //   200: getfield 38	bdts:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   203: getfield 113	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   206: ifnull +20 -> 226
    //   209: aload_0
    //   210: getfield 12	bdtx:a	Lbdts;
    //   213: getfield 38	bdts:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   216: getfield 113	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   219: ldc 115
    //   221: invokevirtual 121	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   224: astore 6
    //   226: lload 4
    //   228: lstore_2
    //   229: aload 8
    //   231: getfield 124	bdtz:a	Lcom/tencent/mobileqq/widget/PAVideoView;
    //   234: invokevirtual 130	com/tencent/mobileqq/widget/PAVideoView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   237: ifnull +71 -> 308
    //   240: lload 4
    //   242: lstore_2
    //   243: aload 8
    //   245: getfield 124	bdtz:a	Lcom/tencent/mobileqq/widget/PAVideoView;
    //   248: invokevirtual 130	com/tencent/mobileqq/widget/PAVideoView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   251: instanceof 132
    //   254: ifeq +54 -> 308
    //   257: aload 8
    //   259: getfield 124	bdtz:a	Lcom/tencent/mobileqq/widget/PAVideoView;
    //   262: invokevirtual 130	com/tencent/mobileqq/widget/PAVideoView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   265: checkcast 132	com/tencent/image/URLDrawable
    //   268: astore 7
    //   270: lload 4
    //   272: lstore_2
    //   273: aload 7
    //   275: invokevirtual 136	com/tencent/image/URLDrawable:getStatus	()I
    //   278: iconst_1
    //   279: if_icmpne +29 -> 308
    //   282: lload 4
    //   284: lstore_2
    //   285: aload 7
    //   287: invokevirtual 139	com/tencent/image/URLDrawable:getCurrDrawable	()Landroid/graphics/drawable/Drawable;
    //   290: instanceof 141
    //   293: ifeq +15 -> 308
    //   296: aload 7
    //   298: invokevirtual 139	com/tencent/image/URLDrawable:getCurrDrawable	()Landroid/graphics/drawable/Drawable;
    //   301: checkcast 141	com/tencent/image/QQLiveDrawable
    //   304: invokevirtual 145	com/tencent/image/QQLiveDrawable:getCurrentPosition	()J
    //   307: lstore_2
    //   308: aload_1
    //   309: ldc 146
    //   311: invokevirtual 31	android/view/View:getTag	(I)Ljava/lang/Object;
    //   314: checkcast 54	java/lang/String
    //   317: astore 7
    //   319: aload 7
    //   321: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   324: ifne -179 -> 145
    //   327: aload 7
    //   329: ldc 148
    //   331: lload_2
    //   332: invokestatic 152	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   335: invokestatic 157	blhn:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   338: ldc 159
    //   340: aload 6
    //   342: invokestatic 157	blhn:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   345: astore 13
    //   347: new 60	android/content/Intent
    //   350: dup
    //   351: aload 11
    //   353: ldc 161
    //   355: invokespecial 65	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   358: astore 12
    //   360: aload 12
    //   362: ldc 163
    //   364: invokestatic 168	java/lang/System:currentTimeMillis	()J
    //   367: invokevirtual 171	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   370: pop
    //   371: aload_0
    //   372: getfield 12	bdtx:a	Lbdts;
    //   375: getfield 38	bdts:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   378: getfield 113	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   381: ldc 173
    //   383: invokevirtual 121	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   386: astore 6
    //   388: aload_0
    //   389: getfield 12	bdtx:a	Lbdts;
    //   392: getfield 38	bdts:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   395: getfield 113	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   398: ldc 175
    //   400: invokevirtual 121	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   403: astore 7
    //   405: aload 7
    //   407: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   410: ifeq +197 -> 607
    //   413: new 177	org/json/JSONObject
    //   416: dup
    //   417: invokespecial 178	org/json/JSONObject:<init>	()V
    //   420: astore 8
    //   422: aload 8
    //   424: ldc 180
    //   426: invokevirtual 183	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   429: astore 7
    //   431: aload 8
    //   433: ldc 185
    //   435: invokevirtual 183	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   438: astore 8
    //   440: invokestatic 191	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   443: invokevirtual 195	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   446: checkcast 197	com/tencent/mobileqq/app/QQAppInterface
    //   449: astore 9
    //   451: new 199	oeu
    //   454: dup
    //   455: invokespecial 200	oeu:<init>	()V
    //   458: astore 10
    //   460: aload 10
    //   462: iconst_3
    //   463: putfield 202	oeu:a	I
    //   466: aload 10
    //   468: iconst_1
    //   469: putfield 205	oeu:f	I
    //   472: aload 10
    //   474: aload_0
    //   475: getfield 12	bdtx:a	Lbdts;
    //   478: getfield 38	bdts:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   481: getfield 113	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   484: invokestatic 210	oer:a	(Loeu;Lcom/tencent/mobileqq/data/MessageRecord;)Loeu;
    //   487: astore 10
    //   489: aload 9
    //   491: sipush 139
    //   494: invokevirtual 213	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lanud;
    //   497: checkcast 207	oer
    //   500: aload 10
    //   502: aconst_null
    //   503: invokevirtual 216	oer:a	(Loeu;Ljava/lang/String;)V
    //   506: aload 7
    //   508: invokestatic 222	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   511: pop2
    //   512: aload 8
    //   514: astore 9
    //   516: aload 7
    //   518: astore 8
    //   520: aload 9
    //   522: astore 7
    //   524: aload 6
    //   526: astore 9
    //   528: aload 6
    //   530: ifnull +21 -> 551
    //   533: aload 6
    //   535: ldc 224
    //   537: ldc 107
    //   539: invokevirtual 228	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   542: ldc 230
    //   544: ldc 107
    //   546: invokevirtual 228	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   549: astore 9
    //   551: ldc 232
    //   553: aload_0
    //   554: getfield 12	bdtx:a	Lbdts;
    //   557: getfield 235	bdts:ax	Ljava/lang/String;
    //   560: invokevirtual 239	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   563: ifeq +90 -> 653
    //   566: invokestatic 191	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   569: invokevirtual 195	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   572: checkcast 197	com/tencent/mobileqq/app/QQAppInterface
    //   575: bipush 88
    //   577: invokevirtual 243	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   580: checkcast 245	oek
    //   583: astore 6
    //   585: aload 6
    //   587: ifnull -442 -> 145
    //   590: aload 6
    //   592: aload_0
    //   593: getfield 12	bdtx:a	Lbdts;
    //   596: aload 11
    //   598: checkcast 247	android/app/Activity
    //   601: invokevirtual 250	oek:a	(Lbdol;Landroid/app/Activity;)V
    //   604: goto -459 -> 145
    //   607: new 177	org/json/JSONObject
    //   610: dup
    //   611: aload 7
    //   613: invokespecial 253	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   616: astore 8
    //   618: goto -196 -> 422
    //   621: astore 7
    //   623: aconst_null
    //   624: astore 10
    //   626: aload 9
    //   628: astore 8
    //   630: aload 6
    //   632: astore 7
    //   634: aload 10
    //   636: astore 6
    //   638: aload 6
    //   640: astore 9
    //   642: aload 7
    //   644: astore 6
    //   646: aload 9
    //   648: astore 7
    //   650: goto -126 -> 524
    //   653: new 255	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 256	java/lang/StringBuilder:<init>	()V
    //   660: astore 10
    //   662: aload 10
    //   664: aload 13
    //   666: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: astore 14
    //   671: aload 13
    //   673: ldc_w 262
    //   676: invokevirtual 265	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   679: ifeq +88 -> 767
    //   682: ldc_w 267
    //   685: astore 6
    //   687: aload 14
    //   689: aload 6
    //   691: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: aload 9
    //   696: invokestatic 270	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   699: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: ldc_w 272
    //   705: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: aload 8
    //   710: invokestatic 270	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   713: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: ldc_w 274
    //   719: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: aload 7
    //   724: invokestatic 270	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   727: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: pop
    //   731: aload 12
    //   733: ldc_w 276
    //   736: aload 10
    //   738: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokevirtual 83	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   744: pop
    //   745: aload 12
    //   747: ldc_w 282
    //   750: ldc_w 284
    //   753: invokevirtual 83	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   756: pop
    //   757: aload 11
    //   759: aload 12
    //   761: invokevirtual 89	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   764: goto -619 -> 145
    //   767: ldc_w 286
    //   770: astore 6
    //   772: goto -85 -> 687
    //   775: aload_0
    //   776: getfield 12	bdtx:a	Lbdts;
    //   779: getfield 38	bdts:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   782: ifnull +53 -> 835
    //   785: aload_0
    //   786: getfield 12	bdtx:a	Lbdts;
    //   789: getfield 38	bdts:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   792: getfield 289	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgUrl	Ljava/lang/String;
    //   795: ifnull +40 -> 835
    //   798: aload_0
    //   799: getfield 12	bdtx:a	Lbdts;
    //   802: getfield 38	bdts:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   805: getfield 289	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgUrl	Ljava/lang/String;
    //   808: ldc_w 291
    //   811: invokevirtual 265	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   814: ifeq +21 -> 835
    //   817: aload 11
    //   819: aload_0
    //   820: getfield 12	bdtx:a	Lbdts;
    //   823: getfield 38	bdts:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   826: getfield 289	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgUrl	Ljava/lang/String;
    //   829: invokestatic 297	ozs:d	(Landroid/content/Context;Ljava/lang/String;)V
    //   832: goto -687 -> 145
    //   835: invokestatic 302	bdog:a	()Lbdog;
    //   838: astore 6
    //   840: aload 6
    //   842: invokevirtual 305	bdog:a	()Z
    //   845: ifne +43 -> 888
    //   848: aload_0
    //   849: getfield 12	bdtx:a	Lbdts;
    //   852: getfield 38	bdts:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   855: instanceof 40
    //   858: ifeq -713 -> 145
    //   861: aload_0
    //   862: getfield 12	bdtx:a	Lbdts;
    //   865: getfield 38	bdts:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   868: checkcast 40	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   871: astore 6
    //   873: aload_0
    //   874: getfield 12	bdtx:a	Lbdts;
    //   877: aload 11
    //   879: aload 6
    //   881: lconst_0
    //   882: invokevirtual 308	bdts:a	(Landroid/content/Context;Lcom/tencent/mobileqq/structmsg/StructMsgForGeneralShare;J)V
    //   885: goto -740 -> 145
    //   888: aload 6
    //   890: aload 11
    //   892: iconst_3
    //   893: aload_0
    //   894: getfield 12	bdtx:a	Lbdts;
    //   897: getfield 38	bdts:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   900: getfield 311	com/tencent/mobileqq/structmsg/AbsStructMsg:uinType	I
    //   903: invokevirtual 314	bdog:a	(Landroid/content/Context;II)Z
    //   906: ifeq +43 -> 949
    //   909: aload_0
    //   910: getfield 12	bdtx:a	Lbdts;
    //   913: getfield 38	bdts:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   916: instanceof 40
    //   919: ifeq -774 -> 145
    //   922: aload_0
    //   923: getfield 12	bdtx:a	Lbdts;
    //   926: getfield 38	bdts:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   929: checkcast 40	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   932: astore 6
    //   934: aload_0
    //   935: getfield 12	bdtx:a	Lbdts;
    //   938: aload 11
    //   940: aload 6
    //   942: lconst_0
    //   943: invokevirtual 308	bdts:a	(Landroid/content/Context;Lcom/tencent/mobileqq/structmsg/StructMsgForGeneralShare;J)V
    //   946: goto -801 -> 145
    //   949: aload 11
    //   951: invokestatic 319	nnr:a	(Landroid/content/Context;)Z
    //   954: ifne +19 -> 973
    //   957: aload 11
    //   959: ldc_w 320
    //   962: iconst_0
    //   963: invokestatic 325	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   966: invokevirtual 328	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   969: pop
    //   970: goto -825 -> 145
    //   973: aload_0
    //   974: getfield 12	bdtx:a	Lbdts;
    //   977: aload 11
    //   979: aload_0
    //   980: getfield 12	bdtx:a	Lbdts;
    //   983: getfield 38	bdts:a	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   986: checkcast 40	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   989: lconst_0
    //   990: invokevirtual 308	bdts:a	(Landroid/content/Context;Lcom/tencent/mobileqq/structmsg/StructMsgForGeneralShare;J)V
    //   993: goto -848 -> 145
    //   996: astore 6
    //   998: aconst_null
    //   999: astore 6
    //   1001: aconst_null
    //   1002: astore 7
    //   1004: aload 9
    //   1006: astore 8
    //   1008: goto -370 -> 638
    //   1011: astore 8
    //   1013: aconst_null
    //   1014: astore 10
    //   1016: aload 6
    //   1018: astore 8
    //   1020: aload 7
    //   1022: astore 9
    //   1024: aload 10
    //   1026: astore 6
    //   1028: aload 8
    //   1030: astore 7
    //   1032: aload 9
    //   1034: astore 8
    //   1036: goto -398 -> 638
    //   1039: astore 9
    //   1041: aload 8
    //   1043: astore 9
    //   1045: aload 7
    //   1047: astore 8
    //   1049: aload 6
    //   1051: astore 7
    //   1053: aload 9
    //   1055: astore 6
    //   1057: goto -419 -> 638
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1060	0	this	bdtx
    //   0	1060	1	paramView	android.view.View
    //   228	104	2	l1	long
    //   1	282	4	l2	long
    //   18	123	6	localObject1	Object
    //   153	3	6	localException1	java.lang.Exception
    //   180	761	6	localObject2	Object
    //   996	1	6	localException2	java.lang.Exception
    //   999	57	6	localObject3	Object
    //   176	436	7	localObject4	Object
    //   621	1	7	localException3	java.lang.Exception
    //   632	420	7	localObject5	Object
    //   38	969	8	localObject6	Object
    //   1011	1	8	localException4	java.lang.Exception
    //   1018	30	8	localObject7	Object
    //   4	1029	9	localObject8	Object
    //   1039	1	9	localException5	java.lang.Exception
    //   1043	11	9	localObject9	Object
    //   458	567	10	localObject10	Object
    //   10	968	11	localContext	android.content.Context
    //   358	402	12	localIntent	android.content.Intent
    //   345	327	13	str	java.lang.String
    //   669	19	14	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   93	145	153	java/lang/Exception
    //   388	422	621	java/lang/Exception
    //   422	431	621	java/lang/Exception
    //   607	618	621	java/lang/Exception
    //   371	388	996	java/lang/Exception
    //   431	440	1011	java/lang/Exception
    //   440	512	1039	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdtx
 * JD-Core Version:    0.7.0.1
 */