package com.tencent.mobileqq.apollo.request;

import com.tencent.mobileqq.apollo.game.CmGameConnManager;
import com.tencent.mobileqq.apollo.game.CmGameConnManager.GameConnInfo;
import com.tencent.mobileqq.apollo.game.api.IApolloGameManager;
import com.tencent.mobileqq.apollo.game.api.impl.ApolloGameManagerImpl;
import com.tencent.mobileqq.apollo.utils.RequestRoute;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gamecenter.data.PadFaceManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.pb.apollo.CmGameMsgTunnel.AddrDistribueRsp;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/request/CmGameRequestReceiver;", "", "()V", "handleApolloGameKey", "", "params", "Lcom/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams;", "handleApolloGameLoginList", "handleCmGameConnInfoRsp", "handleGetPadFaceAd", "handleReportPadFaceShown", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CmGameRequestReceiver
{
  public static final CmGameRequestReceiver.Companion a = new CmGameRequestReceiver.Companion(null);
  
  @RequestRoute(a="ltgame_addr_distribute.get_iplist")
  private final void handleCmGameConnInfoRsp(ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Object localObject3 = paramApolloRequestReceiveParams.c;
    Object localObject1 = paramApolloRequestReceiveParams.d;
    QQAppInterface localQQAppInterface = paramApolloRequestReceiveParams.a;
    paramApolloRequestReceiveParams = new StringBuilder();
    paramApolloRequestReceiveParams.append("handleCmGameConnInfoRsp, code=");
    if (localObject3 == null) {
      Intrinsics.throwNpe();
    }
    paramApolloRequestReceiveParams.append(((FromServiceMsg)localObject3).getResultCode());
    QLog.d("[cmshow]CmGameRequestReceiver", 1, paramApolloRequestReceiveParams.toString());
    paramApolloRequestReceiveParams = (CmGameConnManager.GameConnInfo)null;
    if ((localObject1 != null) && (((FromServiceMsg)localObject3).isSuccess())) {
      try
      {
        localObject3 = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject3).mergeFrom((byte[])localObject1);
        long l = ((WebSSOAgent.UniSsoServerRsp)localObject3).ret.get();
        QLog.e("[cmshow]CmGameRequestReceiver", 2, new Object[] { "[handleCmGameConnInfoRsp] unissoRet=", Long.valueOf(l) });
        if (l == 0L)
        {
          localObject1 = new CmGameMsgTunnel.AddrDistribueRsp();
          ((CmGameMsgTunnel.AddrDistribueRsp)localObject1).mergeFrom(((WebSSOAgent.UniSsoServerRsp)localObject3).pbRsqData.get().toByteArray());
          int i = ((CmGameMsgTunnel.AddrDistribueRsp)localObject1).port.get();
          localObject1 = new CmGameConnManager.GameConnInfo(((CmGameMsgTunnel.AddrDistribueRsp)localObject1).ip_list.get(), i, ((CmGameMsgTunnel.AddrDistribueRsp)localObject1).aes_key.get(), ((CmGameMsgTunnel.AddrDistribueRsp)localObject1).distribute_ts.get(), ((CmGameMsgTunnel.AddrDistribueRsp)localObject1).sign.get());
          paramApolloRequestReceiveParams = (ApolloRequestReceiveParams)localObject1;
        }
      }
      catch (Exception localException)
      {
        QLog.e("[cmshow]CmGameRequestReceiver", 2, "[handleCmGameConnInfoRsp] failed ", (Throwable)localException);
      }
    }
    if (localQQAppInterface == null) {
      Intrinsics.throwNpe();
    }
    Object localObject2 = localQQAppInterface.getRuntimeService(IApolloGameManager.class, "all");
    if (localObject2 != null)
    {
      localObject2 = ((ApolloGameManagerImpl)localObject2).getCmGameConnManager();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "apolloGameManager.cmGameConnManager");
      if (paramApolloRequestReceiveParams != null)
      {
        ((CmGameConnManager)localObject2).a(paramApolloRequestReceiveParams);
        return;
      }
      ((CmGameConnManager)localObject2).b();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.game.api.impl.ApolloGameManagerImpl");
  }
  
  @RequestRoute(a="QQVacCommSvc.get_padface_add")
  private final void handleGetPadFaceAd(ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Object localObject2 = paramApolloRequestReceiveParams.b;
    FromServiceMsg localFromServiceMsg = paramApolloRequestReceiveParams.c;
    Object localObject1 = paramApolloRequestReceiveParams.d;
    paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.a;
    if ((localObject2 != null) && (localObject1 != null) && (localFromServiceMsg != null) && (localFromServiceMsg.isSuccess())) {
      try
      {
        localObject2 = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject2).mergeFrom((byte[])localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]CmGameRequestReceiver", 2, new Object[] { "[handleGetArkAds] ret=", Long.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get()) });
        }
        if (((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get() == 0L)
        {
          localObject1 = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get()).optJSONObject("12818");
          if ((localObject1 != null) && (((JSONObject)localObject1).optInt("ret", 1) == 0))
          {
            if (paramApolloRequestReceiveParams == null) {
              Intrinsics.throwNpe();
            }
            paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.getManager(QQManagerFactory.GAMECENTER_MANAGER);
            if (paramApolloRequestReceiveParams != null)
            {
              paramApolloRequestReceiveParams = (GameCenterManagerImp)paramApolloRequestReceiveParams;
              localObject1 = ((JSONObject)localObject1).optJSONObject("data");
              if (localObject1 != null)
              {
                localObject1 = ((JSONObject)localObject1).optJSONObject("rsp");
                if (localObject1 != null) {
                  paramApolloRequestReceiveParams.b().a((JSONObject)localObject1);
                }
              }
            }
            else
            {
              throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.servlet.GameCenterManagerImp");
            }
          }
        }
      }
      catch (Exception paramApolloRequestReceiveParams)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[handleGetArkAds] err:");
        ((StringBuilder)localObject1).append(paramApolloRequestReceiveParams.getMessage());
        QLog.e("[cmshow]CmGameRequestReceiver", 1, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  @RequestRoute(a="QQVacCommSvc.report_padface_shown")
  private final void handleReportPadFaceShown(ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Object localObject = paramApolloRequestReceiveParams.c;
    if (localObject != null)
    {
      paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.d;
      if (paramApolloRequestReceiveParams != null)
      {
        if (!((FromServiceMsg)localObject).isSuccess()) {
          return;
        }
        try
        {
          localObject = new WebSSOAgent.UniSsoServerRsp();
          ((WebSSOAgent.UniSsoServerRsp)localObject).mergeFrom(paramApolloRequestReceiveParams);
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]CmGameRequestReceiver", 2, new Object[] { "[handleReportPadFaceShown] ret=", Long.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject).ret.get()) });
          }
          if (((WebSSOAgent.UniSsoServerRsp)localObject).ret.get() == 0L)
          {
            paramApolloRequestReceiveParams = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject).rspdata.get()).optJSONObject("12827");
            if (paramApolloRequestReceiveParams != null)
            {
              int i = paramApolloRequestReceiveParams.optInt("ret", 1);
              if (i != 0)
              {
                paramApolloRequestReceiveParams = new StringBuilder();
                paramApolloRequestReceiveParams.append("[handleReportPadFaceShown] ret:");
                paramApolloRequestReceiveParams.append(i);
                QLog.e("[cmshow]CmGameRequestReceiver", 1, paramApolloRequestReceiveParams.toString());
                return;
              }
            }
          }
        }
        catch (Exception paramApolloRequestReceiveParams)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[handleReportPadFaceShown] err:");
          ((StringBuilder)localObject).append(paramApolloRequestReceiveParams.getMessage());
          QLog.e("[cmshow]CmGameRequestReceiver", 1, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  /* Error */
  @RequestRoute(a="apollo_aio_game.check_game_v2")
  public final void handleApolloGameKey(@NotNull ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 303
    //   4: invokestatic 306	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7: aload_1
    //   8: getfield 234	com/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams:b	Landroid/content/Intent;
    //   11: astore 10
    //   13: aload_1
    //   14: getfield 52	com/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams:c	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   17: astore 12
    //   19: aload_1
    //   20: getfield 56	com/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams:d	[B
    //   23: astore 11
    //   25: aload_1
    //   26: getfield 59	com/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   29: astore 13
    //   31: aload_1
    //   32: getfield 309	com/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams:e	Lcom/tencent/mobileqq/apollo/handler/ApolloExtensionHandler;
    //   35: astore 9
    //   37: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +36 -> 76
    //   43: new 61	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   50: astore_1
    //   51: aload_1
    //   52: ldc_w 311
    //   55: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_1
    //   60: aload 11
    //   62: invokevirtual 314	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: ldc 84
    //   68: iconst_2
    //   69: aload_1
    //   70: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload 13
    //   78: ifnull +28 -> 106
    //   81: aload 13
    //   83: ldc_w 316
    //   86: invokevirtual 320	com/tencent/mobileqq/app/QQAppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   89: astore_1
    //   90: aload_1
    //   91: ifnull +15 -> 106
    //   94: aload_1
    //   95: bipush 73
    //   97: invokevirtual 326	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   100: invokevirtual 331	android/os/Message:sendToTarget	()V
    //   103: goto +3 -> 106
    //   106: aload 11
    //   108: ifnull +332 -> 440
    //   111: aload 12
    //   113: ifnull +327 -> 440
    //   116: aload 12
    //   118: invokevirtual 99	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   121: ifeq +319 -> 440
    //   124: new 101	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp
    //   127: dup
    //   128: invokespecial 102	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:<init>	()V
    //   131: astore_1
    //   132: aload_1
    //   133: aload 11
    //   135: invokevirtual 106	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   138: pop
    //   139: aload 10
    //   141: ifnonnull +6 -> 147
    //   144: invokestatic 73	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   147: aload 10
    //   149: ldc_w 333
    //   152: iconst_0
    //   153: invokevirtual 338	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   156: istore_2
    //   157: aload 10
    //   159: ldc_w 340
    //   162: iconst_0
    //   163: invokevirtual 344	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   166: istore 6
    //   168: aload 10
    //   170: ldc_w 346
    //   173: lconst_0
    //   174: invokevirtual 350	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   177: lstore 7
    //   179: aload 10
    //   181: ldc_w 352
    //   184: invokevirtual 356	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   187: astore 11
    //   189: aload 10
    //   191: ldc_w 358
    //   194: invokevirtual 356	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   197: astore 12
    //   199: aload 10
    //   201: ldc_w 360
    //   204: iconst_0
    //   205: invokevirtual 338	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   208: istore_3
    //   209: aload 10
    //   211: ldc_w 362
    //   214: iconst_0
    //   215: invokevirtual 338	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   218: istore 4
    //   220: aload 10
    //   222: ldc_w 364
    //   225: invokevirtual 356	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   228: astore 13
    //   230: aload 10
    //   232: ldc_w 366
    //   235: iconst_0
    //   236: invokevirtual 338	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   239: istore 5
    //   241: new 368	android/os/Bundle
    //   244: dup
    //   245: invokespecial 369	android/os/Bundle:<init>	()V
    //   248: astore 10
    //   250: aload 10
    //   252: ldc_w 333
    //   255: iload_2
    //   256: invokevirtual 373	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   259: aload 10
    //   261: ldc_w 340
    //   264: iload 6
    //   266: invokevirtual 377	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   269: aload 10
    //   271: ldc_w 346
    //   274: lload 7
    //   276: invokevirtual 381	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   279: aload 10
    //   281: ldc_w 352
    //   284: aload 11
    //   286: invokevirtual 385	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: aload 10
    //   291: ldc_w 387
    //   294: aload 12
    //   296: invokevirtual 385	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: aload 10
    //   301: ldc_w 362
    //   304: iload 4
    //   306: invokevirtual 373	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   309: aload 10
    //   311: ldc_w 360
    //   314: iload_3
    //   315: invokevirtual 373	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   318: aload 10
    //   320: ldc_w 389
    //   323: aload_1
    //   324: getfield 110	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:ret	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   327: invokevirtual 116	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   330: invokevirtual 381	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   333: aload 10
    //   335: ldc_w 364
    //   338: aload 13
    //   340: invokevirtual 385	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: aload 10
    //   345: ldc_w 366
    //   348: iload 5
    //   350: invokevirtual 373	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   353: aload 10
    //   355: ldc_w 272
    //   358: aload_1
    //   359: getfield 135	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:pbRsqData	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   362: invokevirtual 140	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   365: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   368: invokevirtual 393	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   371: aload 9
    //   373: ifnonnull +6 -> 379
    //   376: invokestatic 73	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   379: aload 9
    //   381: bipush 21
    //   383: iconst_1
    //   384: aload 10
    //   386: invokevirtual 399	com/tencent/mobileqq/apollo/handler/ApolloExtensionHandler:notifyUI	(IZLjava/lang/Object;)V
    //   389: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   392: ifeq +139 -> 531
    //   395: new 61	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   402: astore 10
    //   404: aload 10
    //   406: ldc_w 401
    //   409: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload 10
    //   415: aload_1
    //   416: getfield 110	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:ret	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   419: invokevirtual 116	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   422: invokevirtual 404	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload 10
    //   428: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: astore_1
    //   432: ldc 84
    //   434: iconst_2
    //   435: aload_1
    //   436: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   439: return
    //   440: aload 9
    //   442: astore_1
    //   443: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   446: ifeq +12 -> 458
    //   449: ldc 84
    //   451: iconst_2
    //   452: ldc_w 406
    //   455: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   458: aload_1
    //   459: ifnonnull +6 -> 465
    //   462: invokestatic 73	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   465: aload_1
    //   466: bipush 21
    //   468: iconst_0
    //   469: aconst_null
    //   470: invokevirtual 399	com/tencent/mobileqq/apollo/handler/ApolloExtensionHandler:notifyUI	(IZLjava/lang/Object;)V
    //   473: return
    //   474: astore_1
    //   475: new 61	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   482: astore 10
    //   484: aload 10
    //   486: ldc_w 408
    //   489: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload 10
    //   495: aload_1
    //   496: invokevirtual 289	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   499: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: ldc 84
    //   505: iconst_1
    //   506: aload 10
    //   508: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   514: aload 9
    //   516: ifnonnull +6 -> 522
    //   519: invokestatic 73	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   522: aload 9
    //   524: bipush 21
    //   526: iconst_0
    //   527: aconst_null
    //   528: invokevirtual 399	com/tencent/mobileqq/apollo/handler/ApolloExtensionHandler:notifyUI	(IZLjava/lang/Object;)V
    //   531: return
    //   532: astore_1
    //   533: goto -58 -> 475
    //   536: astore_1
    //   537: goto +8 -> 545
    //   540: astore_1
    //   541: goto -66 -> 475
    //   544: astore_1
    //   545: goto -70 -> 475
    //   548: astore_1
    //   549: goto -74 -> 475
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	552	0	this	CmGameRequestReceiver
    //   0	552	1	paramApolloRequestReceiveParams	ApolloRequestReceiveParams
    //   156	100	2	i	int
    //   208	107	3	j	int
    //   218	87	4	k	int
    //   239	110	5	m	int
    //   166	99	6	bool	boolean
    //   177	98	7	l	long
    //   35	488	9	localApolloExtensionHandler	com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler
    //   11	496	10	localObject1	Object
    //   23	262	11	localObject2	Object
    //   17	278	12	localObject3	Object
    //   29	310	13	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   432	439	474	java/lang/Exception
    //   443	458	474	java/lang/Exception
    //   462	465	474	java/lang/Exception
    //   465	473	474	java/lang/Exception
    //   81	90	532	java/lang/Exception
    //   94	103	532	java/lang/Exception
    //   116	139	532	java/lang/Exception
    //   144	147	532	java/lang/Exception
    //   147	168	532	java/lang/Exception
    //   379	432	536	java/lang/Exception
    //   189	371	540	java/lang/Exception
    //   376	379	540	java/lang/Exception
    //   179	189	544	java/lang/Exception
    //   168	179	548	java/lang/Exception
  }
  
  @RequestRoute(a="apollo_game_login.get_user_game_list_info")
  public final void handleApolloGameLoginList(@NotNull ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Intrinsics.checkParameterIsNotNull(paramApolloRequestReceiveParams, "params");
    Object localObject = paramApolloRequestReceiveParams.c;
    if (localObject != null)
    {
      byte[] arrayOfByte = paramApolloRequestReceiveParams.d;
      if (arrayOfByte != null)
      {
        paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.a;
        if (paramApolloRequestReceiveParams != null)
        {
          if (!((FromServiceMsg)localObject).isSuccess())
          {
            QLog.e("[cmshow]CmGameRequestReceiver", 1, "[handleApolloGameLoginReq] failed");
            return;
          }
          try
          {
            localObject = new WebSSOAgent.UniSsoServerRsp();
            ((WebSSOAgent.UniSsoServerRsp)localObject).mergeFrom(arrayOfByte);
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]CmGameRequestReceiver", 2, new Object[] { "[handleApolloGameLoginReq] ret=", Long.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject).ret.get()) });
            }
            if (((WebSSOAgent.UniSsoServerRsp)localObject).ret.get() != 0L)
            {
              QLog.e("[cmshow]CmGameRequestReceiver", 1, new Object[] { "[handleApolloGameLoginReq] failed ret:", Long.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject).ret.get()) });
              return;
            }
            if (paramApolloRequestReceiveParams == null)
            {
              QLog.e("[cmshow]CmGameRequestReceiver", 1, "[handleApolloGameLoginReq] app is null");
              return;
            }
            paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.getRuntimeService(IApolloGameManager.class, "all");
            if (paramApolloRequestReceiveParams != null)
            {
              ((ApolloGameManagerImpl)paramApolloRequestReceiveParams).onGameLoginRespFromSvr(((WebSSOAgent.UniSsoServerRsp)localObject).ret.get(), ((WebSSOAgent.UniSsoServerRsp)localObject).pbRsqData.get().toByteArray());
              return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.game.api.impl.ApolloGameManagerImpl");
          }
          catch (Exception paramApolloRequestReceiveParams)
          {
            QLog.e("[cmshow]CmGameRequestReceiver", 1, "[handleApolloGameLoginReq] exception=", (Throwable)paramApolloRequestReceiveParams);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.request.CmGameRequestReceiver
 * JD-Core Version:    0.7.0.1
 */