package com.tencent.biz.pubaccount.accountdetail.model;

import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailDynamicDataManagerService;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.accountdetail.bean.AccountDetailDynamicInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.impl.PublicAccountObserverImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.mp.account_detail_dynamic_list.AccountDetailDynamicListRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class AccountDetailDynamicListModel
{
  static long a = -1L;
  
  /* Error */
  public static int a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 19	com/tencent/mobileqq/mp/account_detail_dynamic_list$AccountDetailDynamicListResponse
    //   6: dup
    //   7: invokespecial 20	com/tencent/mobileqq/mp/account_detail_dynamic_list$AccountDetailDynamicListResponse:<init>	()V
    //   10: astore 15
    //   12: aload 15
    //   14: aload_2
    //   15: invokevirtual 24	com/tencent/mobileqq/mp/account_detail_dynamic_list$AccountDetailDynamicListResponse:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   18: pop
    //   19: aload 15
    //   21: getfield 28	com/tencent/mobileqq/mp/account_detail_dynamic_list$AccountDetailDynamicListResponse:ret_info	Lcom/tencent/mobileqq/mp/account_detail_dynamic_list$RetInfo;
    //   24: invokevirtual 34	com/tencent/mobileqq/mp/account_detail_dynamic_list$RetInfo:has	()Z
    //   27: istore 6
    //   29: iconst_0
    //   30: istore 5
    //   32: iload 6
    //   34: ifeq +418 -> 452
    //   37: aload 15
    //   39: getfield 28	com/tencent/mobileqq/mp/account_detail_dynamic_list$AccountDetailDynamicListResponse:ret_info	Lcom/tencent/mobileqq/mp/account_detail_dynamic_list$RetInfo;
    //   42: getfield 38	com/tencent/mobileqq/mp/account_detail_dynamic_list$RetInfo:ret_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   45: invokevirtual 44	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   48: ifne +404 -> 452
    //   51: aload 15
    //   53: getfield 48	com/tencent/mobileqq/mp/account_detail_dynamic_list$AccountDetailDynamicListResponse:puin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   56: invokevirtual 51	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   59: ifeq +387 -> 446
    //   62: aload 15
    //   64: getfield 54	com/tencent/mobileqq/mp/account_detail_dynamic_list$AccountDetailDynamicListResponse:last_msg_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   67: invokevirtual 51	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   70: ifeq +376 -> 446
    //   73: aload 15
    //   75: getfield 57	com/tencent/mobileqq/mp/account_detail_dynamic_list$AccountDetailDynamicListResponse:msg_cnt	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   78: invokevirtual 58	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   81: ifeq +365 -> 446
    //   84: aload 15
    //   86: getfield 48	com/tencent/mobileqq/mp/account_detail_dynamic_list$AccountDetailDynamicListResponse:puin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   89: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   92: lstore 7
    //   94: aload 15
    //   96: getfield 54	com/tencent/mobileqq/mp/account_detail_dynamic_list$AccountDetailDynamicListResponse:last_msg_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   99: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   102: lstore 9
    //   104: aload 15
    //   106: getfield 57	com/tencent/mobileqq/mp/account_detail_dynamic_list$AccountDetailDynamicListResponse:msg_cnt	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   109: invokevirtual 44	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   112: i2l
    //   113: lstore 11
    //   115: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +101 -> 219
    //   121: new 68	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   128: astore 13
    //   130: aload 13
    //   132: ldc 71
    //   134: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 13
    //   140: lload 7
    //   142: invokevirtual 78	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 13
    //   148: ldc 80
    //   150: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 13
    //   156: lload 9
    //   158: invokevirtual 78	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 13
    //   164: ldc 82
    //   166: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 13
    //   172: lload 11
    //   174: invokevirtual 78	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 13
    //   180: ldc 84
    //   182: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 13
    //   188: iload_1
    //   189: invokevirtual 87	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 13
    //   195: ldc 89
    //   197: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 13
    //   203: iload_3
    //   204: invokevirtual 87	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: ldc 91
    //   210: iconst_2
    //   211: aload 13
    //   213: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload_0
    //   220: ldc 101
    //   222: ldc 103
    //   224: invokevirtual 109	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   227: checkcast 101	com/tencent/biz/pubaccount/accountdetail/api/IPublicAccountDetailDynamicDataManagerService
    //   230: astore 13
    //   232: aload 13
    //   234: lload 7
    //   236: invokeinterface 113 3 0
    //   241: checkcast 115	java/util/ArrayList
    //   244: astore_0
    //   245: iload_1
    //   246: ifeq +28 -> 274
    //   249: iload_3
    //   250: ifeq +24 -> 274
    //   253: aload_0
    //   254: ifnull +20 -> 274
    //   257: aload_0
    //   258: invokevirtual 118	java/util/ArrayList:isEmpty	()Z
    //   261: istore 6
    //   263: iload 6
    //   265: ifne +9 -> 274
    //   268: ldc 2
    //   270: monitorexit
    //   271: bipush 6
    //   273: ireturn
    //   274: new 115	java/util/ArrayList
    //   277: dup
    //   278: invokespecial 119	java/util/ArrayList:<init>	()V
    //   281: astore 14
    //   283: aload 15
    //   285: getfield 123	com/tencent/mobileqq/mp/account_detail_dynamic_list$AccountDetailDynamicListResponse:msg_infos	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   288: invokevirtual 126	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   291: ifeq +114 -> 405
    //   294: aload 15
    //   296: getfield 123	com/tencent/mobileqq/mp/account_detail_dynamic_list$AccountDetailDynamicListResponse:msg_infos	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   299: invokevirtual 129	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   302: astore_0
    //   303: aload_0
    //   304: ifnonnull +9 -> 313
    //   307: iconst_0
    //   308: istore 4
    //   310: goto +11 -> 321
    //   313: aload_0
    //   314: invokeinterface 134 1 0
    //   319: istore 4
    //   321: iload 5
    //   323: iload 4
    //   325: if_icmpge +80 -> 405
    //   328: aload_0
    //   329: iload 5
    //   331: invokeinterface 137 2 0
    //   336: checkcast 139	com/tencent/mobileqq/pb/ByteStringMicro
    //   339: astore 15
    //   341: aload 15
    //   343: invokevirtual 142	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   346: astore 15
    //   348: aload 14
    //   350: aload 15
    //   352: invokevirtual 146	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   355: pop
    //   356: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq +125 -> 484
    //   362: new 68	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   369: astore 16
    //   371: aload 16
    //   373: ldc 148
    //   375: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload 16
    //   381: aload 15
    //   383: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload 16
    //   389: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: astore 15
    //   394: ldc 91
    //   396: iconst_2
    //   397: aload 15
    //   399: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   402: goto +82 -> 484
    //   405: lload 11
    //   407: aload 14
    //   409: invokevirtual 149	java/util/ArrayList:size	()I
    //   412: i2l
    //   413: lcmp
    //   414: ifne +26 -> 440
    //   417: aload 13
    //   419: aload_2
    //   420: iload_1
    //   421: lload 7
    //   423: lload 9
    //   425: lload 11
    //   427: aload 14
    //   429: iload_3
    //   430: invokeinterface 153 11 0
    //   435: istore 4
    //   437: goto +6 -> 443
    //   440: iconst_5
    //   441: istore 4
    //   443: goto +12 -> 455
    //   446: iconst_4
    //   447: istore 4
    //   449: goto +6 -> 455
    //   452: iconst_0
    //   453: istore 4
    //   455: ldc 2
    //   457: monitorexit
    //   458: iload 4
    //   460: ireturn
    //   461: astore_0
    //   462: ldc 2
    //   464: monitorexit
    //   465: goto +5 -> 470
    //   468: aload_0
    //   469: athrow
    //   470: goto -2 -> 468
    //   473: iconst_2
    //   474: istore 4
    //   476: astore_0
    //   477: goto -22 -> 455
    //   480: astore_0
    //   481: goto +12 -> 493
    //   484: iload 5
    //   486: iconst_1
    //   487: iadd
    //   488: istore 5
    //   490: goto -169 -> 321
    //   493: iconst_2
    //   494: istore 4
    //   496: goto -41 -> 455
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	499	0	paramQQAppInterface	QQAppInterface
    //   0	499	1	paramBoolean1	boolean
    //   0	499	2	paramArrayOfByte	byte[]
    //   0	499	3	paramBoolean2	boolean
    //   308	187	4	i	int
    //   30	459	5	j	int
    //   27	237	6	bool	boolean
    //   92	330	7	l1	long
    //   102	322	9	l2	long
    //   113	313	11	l3	long
    //   128	290	13	localObject1	Object
    //   281	147	14	localArrayList	java.util.ArrayList
    //   10	388	15	localObject2	Object
    //   369	19	16	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   3	12	461	finally
    //   12	29	461	finally
    //   37	219	461	finally
    //   219	245	461	finally
    //   257	263	461	finally
    //   274	303	461	finally
    //   313	321	461	finally
    //   328	341	461	finally
    //   341	394	461	finally
    //   394	402	461	finally
    //   405	437	461	finally
    //   12	29	473	java/lang/Exception
    //   37	219	473	java/lang/Exception
    //   219	245	473	java/lang/Exception
    //   257	263	473	java/lang/Exception
    //   274	303	473	java/lang/Exception
    //   313	321	473	java/lang/Exception
    //   328	341	473	java/lang/Exception
    //   394	402	473	java/lang/Exception
    //   405	437	473	java/lang/Exception
    //   341	394	480	java/lang/Exception
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, int paramInt, PublicAccountObserverImpl paramPublicAccountObserverImpl)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAccountDetailDynamicList last_msg_id:");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append("  msg_cnt:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("  mLastMSgID: ");
      ((StringBuilder)localObject).append(a);
      QLog.d("AccountDetailDynamicListModel", 2, ((StringBuilder)localObject).toString());
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), PublicAccountServletImpl.class);
    localNewIntent.putExtra("cmd", "pull_account_detail_dynamic_list");
    Object localObject = new account_detail_dynamic_list.AccountDetailDynamicListRequest();
    ((account_detail_dynamic_list.AccountDetailDynamicListRequest)localObject).versionInfo.set("8.7.0,3,5295");
    ((account_detail_dynamic_list.AccountDetailDynamicListRequest)localObject).puin.set(paramLong1);
    ((account_detail_dynamic_list.AccountDetailDynamicListRequest)localObject).last_msg_id.set(paramLong2);
    ((account_detail_dynamic_list.AccountDetailDynamicListRequest)localObject).msg_cnt.set(paramInt);
    localNewIntent.putExtra("data", ((account_detail_dynamic_list.AccountDetailDynamicListRequest)localObject).toByteArray());
    int m = 0;
    int j = 0;
    int k = 1;
    boolean bool;
    if (paramLong2 == 0L) {
      bool = true;
    } else {
      bool = false;
    }
    localNewIntent.putExtra("isFirstEnter", bool);
    a = paramLong2;
    localObject = (IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    paramInt = m;
    int i = k;
    if (localObject != null)
    {
      localObject = (PublicAccountDetailImpl)((IPublicAccountDataManager)localObject).findAccountDetailInfo(String.valueOf(paramLong1));
      paramInt = m;
      i = k;
      if (localObject != null)
      {
        paramInt = j;
        if (((PublicAccountDetailImpl)localObject).followType == 1) {
          paramInt = 1;
        }
        i = PublicAccountDetailImpl.getReportAccountType(paramQQAppInterface, String.valueOf(paramLong1), (PublicAccountDetailImpl)localObject);
      }
    }
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append("");
    String str1 = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramLong2);
    ((StringBuilder)localObject).append("");
    String str2 = ((StringBuilder)localObject).toString();
    if (paramInt != 0) {
      localObject = "02";
    } else {
      localObject = "01";
    }
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str1, "0X80077FF", "0X80077FF", 0, 0, "1", str2, (String)localObject, String.valueOf(i), false);
    localNewIntent.setObserver(new AccountDetailDynamicListModel.1(paramQQAppInterface, bool, paramPublicAccountObserverImpl));
    paramQQAppInterface.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailDynamicListModel", 2, "getAccountDetailDynamicList exit");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, PublicAccountObserverImpl paramPublicAccountObserverImpl)
  {
    ((IPublicAccountDetailDynamicDataManagerService)paramQQAppInterface.getRuntimeService(IPublicAccountDetailDynamicDataManagerService.class, "all")).getDynamicListForFirstEnterFromDB(paramQQAppInterface, paramLong, paramPublicAccountObserverImpl);
    a(paramQQAppInterface, paramLong, 0L, 25, paramPublicAccountObserverImpl);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, long paramLong, PublicAccountObserverImpl paramPublicAccountObserverImpl)
  {
    AccountDetailDynamicInfo localAccountDetailDynamicInfo = (AccountDetailDynamicInfo)((IPublicAccountDetailDynamicDataManagerService)paramQQAppInterface.getRuntimeService(IPublicAccountDetailDynamicDataManagerService.class, "all")).getAccountDetailDynamicInfoFromCache(paramLong);
    if ((localAccountDetailDynamicInfo != null) && (localAccountDetailDynamicInfo.b > 0L))
    {
      if (a != localAccountDetailDynamicInfo.b) {
        a(paramQQAppInterface, paramLong, localAccountDetailDynamicInfo.b, 25, paramPublicAccountObserverImpl);
      }
    }
    else {
      a(paramQQAppInterface, paramLong, paramPublicAccountObserverImpl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.model.AccountDetailDynamicListModel
 * JD-Core Version:    0.7.0.1
 */