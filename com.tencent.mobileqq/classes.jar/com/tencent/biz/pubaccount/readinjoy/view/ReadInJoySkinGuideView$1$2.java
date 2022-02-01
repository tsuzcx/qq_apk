package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.IButtonHandle;

class ReadInJoySkinGuideView$1$2
  implements SceneBuilder.IButtonHandle
{
  ReadInJoySkinGuideView$1$2(ReadInJoySkinGuideView.1 param1) {}
  
  /* Error */
  public void a(com.tencent.mobileqq.surfaceviewaction.ILayer paramILayer, com.tencent.mobileqq.surfaceviewaction.ISprite paramISprite, java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_3
    //   1: ldc 23
    //   3: invokevirtual 29	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +110 -> 116
    //   9: aload_0
    //   10: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   13: getfield 34	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_a_of_type_AndroidViewView$OnClickListener	Landroid/view/View$OnClickListener;
    //   16: aload_0
    //   17: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   20: getfield 38	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:this$0	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView;
    //   23: invokeinterface 44 2 0
    //   28: ldc 46
    //   30: invokestatic 52	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   33: checkcast 46	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   36: aload_0
    //   37: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   40: getfield 55	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   43: ldc 57
    //   45: ldc 59
    //   47: ldc 59
    //   49: iconst_0
    //   50: iconst_0
    //   51: aload_0
    //   52: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   55: getfield 63	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   58: new 65	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   65: ldc 57
    //   67: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokestatic 75	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/util/RIJAppSetting:a	()I
    //   73: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: new 65	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   86: ldc 57
    //   88: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   95: getfield 38	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:this$0	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView;
    //   98: invokestatic 87	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView;)I
    //   101: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: ldc 57
    //   109: iconst_0
    //   110: invokeinterface 91 12 0
    //   115: return
    //   116: aload_3
    //   117: ldc 93
    //   119: invokevirtual 29	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   122: ifeq +131 -> 253
    //   125: aload_0
    //   126: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   129: getfield 95	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_b_of_type_AndroidViewView$OnClickListener	Landroid/view/View$OnClickListener;
    //   132: aload_0
    //   133: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   136: getfield 38	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:this$0	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView;
    //   139: invokeinterface 44 2 0
    //   144: aload_0
    //   145: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   148: getfield 98	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   151: aload_0
    //   152: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   155: getfield 55	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   158: invokevirtual 103	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   161: iconst_1
    //   162: invokestatic 109	com/tencent/mobileqq/utils/SharedPreUtils:m	(Landroid/content/Context;Ljava/lang/String;Z)V
    //   165: ldc 46
    //   167: invokestatic 52	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   170: checkcast 46	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   173: aload_0
    //   174: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   177: getfield 55	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   180: ldc 57
    //   182: ldc 111
    //   184: ldc 111
    //   186: iconst_0
    //   187: iconst_0
    //   188: aload_0
    //   189: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   192: getfield 63	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   195: new 65	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   202: ldc 57
    //   204: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokestatic 75	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/util/RIJAppSetting:a	()I
    //   210: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: new 65	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   223: ldc 57
    //   225: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_0
    //   229: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   232: getfield 38	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:this$0	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView;
    //   235: invokestatic 87	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView;)I
    //   238: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: ldc 57
    //   246: iconst_0
    //   247: invokeinterface 91 12 0
    //   252: return
    //   253: aload_3
    //   254: ldc 113
    //   256: invokevirtual 29	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   259: ifeq +329 -> 588
    //   262: aload_1
    //   263: ldc 114
    //   265: invokestatic 119	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   268: invokeinterface 124 2 0
    //   273: astore_1
    //   274: aload_1
    //   275: ifnull +8 -> 283
    //   278: aload_1
    //   279: fconst_0
    //   280: invokevirtual 130	com/tencent/mobileqq/surfaceviewaction/BaseNode:c	(F)V
    //   283: aload_0
    //   284: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   287: getfield 38	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:this$0	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView;
    //   290: getfield 133	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView:a	Landroid/media/MediaPlayer;
    //   293: ifnonnull +235 -> 528
    //   296: aload_0
    //   297: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   300: getfield 38	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:this$0	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView;
    //   303: new 135	android/media/MediaPlayer
    //   306: dup
    //   307: invokespecial 136	android/media/MediaPlayer:<init>	()V
    //   310: putfield 133	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView:a	Landroid/media/MediaPlayer;
    //   313: aload_0
    //   314: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   317: getfield 38	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:this$0	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView;
    //   320: getfield 133	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView:a	Landroid/media/MediaPlayer;
    //   323: new 65	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   330: aload_0
    //   331: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   334: getfield 138	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   337: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: ldc 140
    //   342: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokevirtual 144	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   351: aload_0
    //   352: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   355: getfield 38	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:this$0	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView;
    //   358: getfield 133	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView:a	Landroid/media/MediaPlayer;
    //   361: invokevirtual 147	android/media/MediaPlayer:prepare	()V
    //   364: aload_0
    //   365: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   368: getfield 38	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:this$0	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView;
    //   371: getfield 133	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView:a	Landroid/media/MediaPlayer;
    //   374: invokevirtual 150	android/media/MediaPlayer:start	()V
    //   377: new 152	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder
    //   380: dup
    //   381: invokespecial 153	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder:<init>	()V
    //   384: astore_1
    //   385: aload_1
    //   386: invokevirtual 157	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder:e	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder;
    //   389: pop
    //   390: aload_1
    //   391: ldc 159
    //   393: aload_0
    //   394: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   397: getfield 63	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   400: invokevirtual 162	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder;
    //   403: pop
    //   404: aload_1
    //   405: ldc 164
    //   407: aload_0
    //   408: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   411: getfield 167	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_a_of_type_Int	I
    //   414: invokevirtual 170	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder:a	(Ljava/lang/String;I)Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder;
    //   417: pop
    //   418: ldc 46
    //   420: invokestatic 52	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   423: checkcast 46	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   426: aload_0
    //   427: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   430: getfield 55	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   433: ldc 57
    //   435: ldc 172
    //   437: ldc 172
    //   439: iconst_0
    //   440: iconst_0
    //   441: aload_0
    //   442: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   445: getfield 63	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   448: new 65	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   455: ldc 57
    //   457: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: invokestatic 75	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/util/RIJAppSetting:a	()I
    //   463: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   466: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: new 65	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   476: ldc 57
    //   478: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: aload_0
    //   482: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   485: getfield 38	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:this$0	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView;
    //   488: invokestatic 87	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView;)I
    //   491: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   494: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: aload_1
    //   498: invokevirtual 174	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder:a	()Ljava/lang/String;
    //   501: iconst_0
    //   502: invokeinterface 91 12 0
    //   507: return
    //   508: astore_1
    //   509: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   512: ifeq -135 -> 377
    //   515: ldc 182
    //   517: iconst_2
    //   518: aload_1
    //   519: invokestatic 186	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   522: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   525: goto -148 -> 377
    //   528: aload_0
    //   529: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   532: getfield 38	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:this$0	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView;
    //   535: getfield 133	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView:a	Landroid/media/MediaPlayer;
    //   538: invokevirtual 192	android/media/MediaPlayer:isPlaying	()Z
    //   541: ifne -164 -> 377
    //   544: aload_0
    //   545: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   548: getfield 38	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:this$0	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView;
    //   551: getfield 133	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView:a	Landroid/media/MediaPlayer;
    //   554: invokevirtual 150	android/media/MediaPlayer:start	()V
    //   557: goto -180 -> 377
    //   560: astore_1
    //   561: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   564: ifeq -187 -> 377
    //   567: ldc 182
    //   569: iconst_2
    //   570: aload_1
    //   571: invokestatic 186	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   574: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: goto -200 -> 377
    //   580: astore_2
    //   581: aload_2
    //   582: invokevirtual 195	org/json/JSONException:printStackTrace	()V
    //   585: goto -167 -> 418
    //   588: new 152	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder
    //   591: dup
    //   592: invokespecial 153	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder:<init>	()V
    //   595: astore_1
    //   596: aload_1
    //   597: invokevirtual 197	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder:b	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder;
    //   600: invokevirtual 157	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder:e	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder;
    //   603: invokevirtual 200	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder:g	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder;
    //   606: pop
    //   607: aload_1
    //   608: ldc 159
    //   610: aload_0
    //   611: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   614: getfield 63	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   617: invokevirtual 162	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder;
    //   620: pop
    //   621: aload_1
    //   622: ldc 202
    //   624: aload_3
    //   625: invokevirtual 162	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder;
    //   628: pop
    //   629: aload_1
    //   630: ldc 204
    //   632: aload_2
    //   633: checkcast 126	com/tencent/mobileqq/surfaceviewaction/BaseNode
    //   636: invokevirtual 207	com/tencent/mobileqq/surfaceviewaction/BaseNode:e_	()I
    //   639: invokevirtual 170	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder:a	(Ljava/lang/String;I)Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder;
    //   642: pop
    //   643: aload_1
    //   644: ldc 164
    //   646: aload_0
    //   647: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   650: getfield 167	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_a_of_type_Int	I
    //   653: invokevirtual 170	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder:a	(Ljava/lang/String;I)Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder;
    //   656: pop
    //   657: aload_0
    //   658: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   661: getfield 55	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   664: aload_0
    //   665: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   668: getfield 98	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   671: aload_3
    //   672: invokestatic 212	com/tencent/mobileqq/utils/JumpParser:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/utils/JumpAction;
    //   675: astore_2
    //   676: aload_2
    //   677: ifnull +125 -> 802
    //   680: aload_2
    //   681: invokevirtual 216	com/tencent/mobileqq/utils/JumpAction:a	()Z
    //   684: pop
    //   685: aload_0
    //   686: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   689: getfield 34	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_a_of_type_AndroidViewView$OnClickListener	Landroid/view/View$OnClickListener;
    //   692: aload_0
    //   693: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   696: getfield 38	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:this$0	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView;
    //   699: invokeinterface 44 2 0
    //   704: ldc 46
    //   706: invokestatic 52	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   709: checkcast 46	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   712: aload_0
    //   713: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   716: getfield 55	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   719: ldc 57
    //   721: ldc 218
    //   723: ldc 218
    //   725: iconst_0
    //   726: iconst_0
    //   727: aload_0
    //   728: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   731: getfield 63	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   734: new 65	java/lang/StringBuilder
    //   737: dup
    //   738: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   741: ldc 57
    //   743: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: invokestatic 75	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/util/RIJAppSetting:a	()I
    //   749: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   752: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   755: new 65	java/lang/StringBuilder
    //   758: dup
    //   759: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   762: ldc 57
    //   764: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: aload_0
    //   768: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   771: getfield 38	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:this$0	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView;
    //   774: invokestatic 87	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView;)I
    //   777: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   780: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   783: aload_1
    //   784: invokevirtual 174	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder:a	()Ljava/lang/String;
    //   787: iconst_0
    //   788: invokeinterface 91 12 0
    //   793: return
    //   794: astore_2
    //   795: aload_2
    //   796: invokevirtual 195	org/json/JSONException:printStackTrace	()V
    //   799: goto -142 -> 657
    //   802: aload_3
    //   803: ldc 220
    //   805: invokevirtual 224	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   808: ifne +12 -> 820
    //   811: aload_3
    //   812: ldc 226
    //   814: invokevirtual 224	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   817: ifeq -702 -> 115
    //   820: new 228	android/content/Intent
    //   823: dup
    //   824: aload_0
    //   825: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   828: getfield 98	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   831: ldc 230
    //   833: invokespecial 233	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   836: astore_2
    //   837: aload_2
    //   838: ldc 235
    //   840: aload_3
    //   841: invokevirtual 239	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   844: pop
    //   845: aload_0
    //   846: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   849: getfield 98	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   852: aload_2
    //   853: invokevirtual 245	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   856: aload_0
    //   857: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   860: getfield 34	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_a_of_type_AndroidViewView$OnClickListener	Landroid/view/View$OnClickListener;
    //   863: aload_0
    //   864: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   867: getfield 38	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:this$0	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView;
    //   870: invokeinterface 44 2 0
    //   875: ldc 46
    //   877: invokestatic 52	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   880: checkcast 46	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   883: aload_0
    //   884: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   887: getfield 55	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   890: ldc 57
    //   892: ldc 218
    //   894: ldc 218
    //   896: iconst_0
    //   897: iconst_0
    //   898: aload_0
    //   899: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   902: getfield 63	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   905: new 65	java/lang/StringBuilder
    //   908: dup
    //   909: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   912: ldc 57
    //   914: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: invokestatic 75	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/util/RIJAppSetting:a	()I
    //   920: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   923: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   926: new 65	java/lang/StringBuilder
    //   929: dup
    //   930: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   933: ldc 57
    //   935: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: aload_0
    //   939: getfield 12	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1$2:a	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1;
    //   942: getfield 38	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView$1:this$0	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView;
    //   945: invokestatic 87	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoySkinGuideView;)I
    //   948: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   951: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   954: aload_1
    //   955: invokevirtual 174	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder:a	()Ljava/lang/String;
    //   958: iconst_0
    //   959: invokeinterface 91 12 0
    //   964: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	965	0	this	2
    //   0	965	1	paramILayer	com.tencent.mobileqq.surfaceviewaction.ILayer
    //   0	965	2	paramISprite	com.tencent.mobileqq.surfaceviewaction.ISprite
    //   0	965	3	paramString	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   313	377	508	java/lang/Exception
    //   528	557	560	java/lang/Exception
    //   385	418	580	org/json/JSONException
    //   596	657	794	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView.1.2
 * JD-Core Version:    0.7.0.1
 */