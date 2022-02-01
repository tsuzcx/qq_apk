package com.tencent.mobileqq.apollo.request;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelManager;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.IApolloMessageService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.handler.ApolloRequest;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloBattleGameInfo;
import com.tencent.mobileqq.apollo.model.ApolloCmQQStatusData;
import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.apollo.model.ApolloObtainedActionData;
import com.tencent.mobileqq.apollo.model.ApolloRecommendAction;
import com.tencent.mobileqq.apollo.model.CmAvatarFaceInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.script.SpriteRscBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloActionUsedManager;
import com.tencent.mobileqq.apollo.utils.RequestRoute;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResDownloaderFacade;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.pb.apolloactionused.ApolloActionUsed.EmotionUsedRsp;
import com.tencent.pb.apolloactionused.ApolloActionUsed.EmuInfo;
import com.tencent.pb.apolloactionused.ApolloActionUsed.EmuTopo;
import com.tencent.pb.apolloqquserimg.ApolloQQUsrImg.Action;
import com.tencent.pb.apolloqquserimg.ApolloQQUsrImg.QQUsrImgRsp;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import trpc.cmshow.game.OpenGameBox.StBoxItem;
import trpc.cmshow.game.OpenGameBox.StOpenGameBoxRsp;
import trpc.cmshow.game.OpenGameBox.StScene;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/request/ApolloRequestReceiver;", "", "()V", "handleApolloRoleAndDress", "", "params", "Lcom/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams;", "handleApolloSetModel", "handleApolloStandAction", "handleBodyFiled", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "handler", "Lcom/tencent/mobileqq/apollo/handler/ApolloExtensionHandler;", "respBody", "Lorg/json/JSONObject;", "apolloManager", "Lcom/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl;", "apolloBaseInfo", "Lcom/tencent/mobileqq/apollo/model/ApolloBaseInfo;", "changeFlag", "", "handleBuyActionByGold", "handleChangeApolloStatus", "handleCheckActionAuth", "handleExploreInfo", "handleExploreInfo2D", "handleExploreInfoCommon", "handleGetApolloActionUsedList", "handleGetApolloAvatarDataRsp", "handleGetApolloBaseInfo", "handleGetApolloBattleGameList", "handleGetSignStr", "handleGetUserApolloDress", "handleGetUserApolloInfo", "handleRecommendAction", "handleSetUserFlagResponse", "parseSaveApolloDress", "rootData", "parseSaveApolloInfo", "touin", "", "response", "Lcom/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp;", "mask", "", "updateActList", "Lcom/tencent/mobileqq/apollo/api/IApolloManagerService;", "actIdMap", "Ljava/util/HashMap;", "", "Landroid/os/Bundle;", "actObtainArray", "Lorg/json/JSONArray;", "adm", "Lcom/tencent/mobileqq/apollo/persistence/api/IApolloDaoManagerService;", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloRequestReceiver
{
  public static final ApolloRequestReceiver.Companion a = new ApolloRequestReceiver.Companion(null);
  
  /* Error */
  private final void a(ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 91	com/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams:c	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   4: astore 12
    //   6: aload 12
    //   8: ifnull +1014 -> 1022
    //   11: aload_1
    //   12: getfield 95	com/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams:b	Landroid/content/Intent;
    //   15: astore 13
    //   17: aload 13
    //   19: ifnull +1003 -> 1022
    //   22: aload_1
    //   23: getfield 99	com/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams:d	[B
    //   26: astore 11
    //   28: aload 11
    //   30: ifnull +992 -> 1022
    //   33: aload_1
    //   34: getfield 101	com/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: astore 14
    //   39: aload 14
    //   41: ifnull +981 -> 1022
    //   44: aload_1
    //   45: getfield 104	com/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams:e	Lcom/tencent/mobileqq/apollo/handler/ApolloExtensionHandler;
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull +972 -> 1022
    //   53: aload 13
    //   55: ldc 106
    //   57: invokevirtual 112	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   60: astore 13
    //   62: aload 11
    //   64: ifnull +905 -> 969
    //   67: aload 12
    //   69: invokevirtual 118	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   72: ifne +6 -> 78
    //   75: goto +894 -> 969
    //   78: new 120	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp
    //   81: dup
    //   82: invokespecial 121	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:<init>	()V
    //   85: astore 12
    //   87: aload 12
    //   89: aload 11
    //   91: invokevirtual 125	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   94: pop
    //   95: aload 12
    //   97: getfield 129	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:ret	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   100: invokevirtual 135	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   103: lstore 9
    //   105: lconst_0
    //   106: lload 9
    //   108: lcmp
    //   109: ifeq +104 -> 213
    //   112: new 137	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   119: astore 14
    //   121: aload 14
    //   123: ldc 140
    //   125: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 14
    //   131: aload 13
    //   133: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 14
    //   139: ldc 146
    //   141: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 14
    //   147: lload 9
    //   149: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 14
    //   155: ldc 151
    //   157: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 12
    //   163: getfield 155	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:errmsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   166: invokevirtual 160	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   169: ifeq +854 -> 1023
    //   172: aload 12
    //   174: getfield 155	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:errmsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   177: invokevirtual 163	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   180: astore 11
    //   182: goto +3 -> 185
    //   185: aload 14
    //   187: aload 11
    //   189: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: ldc 165
    //   195: iconst_1
    //   196: aload 14
    //   198: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 173	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload_1
    //   205: bipush 28
    //   207: iconst_0
    //   208: aconst_null
    //   209: invokevirtual 179	com/tencent/mobileqq/apollo/handler/ApolloExtensionHandler:notifyUI	(IZLjava/lang/Object;)V
    //   212: return
    //   213: new 181	com/tencent/pb/apollo/STExploreInfo$STGetMsgRsp
    //   216: dup
    //   217: invokespecial 182	com/tencent/pb/apollo/STExploreInfo$STGetMsgRsp:<init>	()V
    //   220: astore 11
    //   222: aload 11
    //   224: aload 12
    //   226: getfield 186	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:pbRsqData	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   229: invokevirtual 191	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   232: invokevirtual 197	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   235: invokevirtual 198	com/tencent/pb/apollo/STExploreInfo$STGetMsgRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   238: pop
    //   239: aload 11
    //   241: getfield 202	com/tencent/pb/apollo/STExploreInfo$STGetMsgRsp:eid_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   244: invokevirtual 205	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   247: ifeq +628 -> 875
    //   250: aload 11
    //   252: getfield 202	com/tencent/pb/apollo/STExploreInfo$STGetMsgRsp:eid_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   255: invokevirtual 208	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   258: invokeinterface 214 1 0
    //   263: astore 12
    //   265: aload 12
    //   267: invokeinterface 219 1 0
    //   272: ifeq +794 -> 1066
    //   275: aload 12
    //   277: invokeinterface 223 1 0
    //   282: checkcast 225	com/tencent/pb/apollo/STExploreInfo$STEntryIdMsg
    //   285: astore 15
    //   287: aload 15
    //   289: getfield 229	com/tencent/pb/apollo/STExploreInfo$STEntryIdMsg:entry_id	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   292: invokevirtual 234	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   295: istore_3
    //   296: aload 15
    //   298: getfield 238	com/tencent/pb/apollo/STExploreInfo$STEntryIdMsg:next_req_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   301: invokevirtual 241	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   304: istore 4
    //   306: aload 14
    //   308: invokevirtual 247	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   311: astore 11
    //   313: new 137	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   320: astore 16
    //   322: aload 16
    //   324: ldc 249
    //   326: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload 16
    //   332: aload 14
    //   334: invokevirtual 252	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   337: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload 11
    //   343: aload 16
    //   345: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: iconst_0
    //   349: invokevirtual 258	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   352: astore 16
    //   354: aload 16
    //   356: ldc_w 260
    //   359: invokestatic 266	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   362: iload_3
    //   363: iconst_1
    //   364: if_icmpne +17 -> 381
    //   367: ldc_w 268
    //   370: astore 11
    //   372: aload_1
    //   373: iload 4
    //   375: putfield 271	com/tencent/mobileqq/apollo/handler/ApolloExtensionHandler:d	I
    //   378: goto +14 -> 392
    //   381: ldc_w 273
    //   384: astore 11
    //   386: aload_1
    //   387: iload 4
    //   389: putfield 275	com/tencent/mobileqq/apollo/handler/ApolloExtensionHandler:e	I
    //   392: aload 16
    //   394: invokeinterface 281 1 0
    //   399: aload 11
    //   401: iload 4
    //   403: invokeinterface 287 3 0
    //   408: invokeinterface 290 1 0
    //   413: pop
    //   414: aload 15
    //   416: getfield 293	com/tencent/pb/apollo/STExploreInfo$STEntryIdMsg:msg_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   419: invokevirtual 208	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   422: invokeinterface 214 1 0
    //   427: astore 11
    //   429: aload 11
    //   431: invokeinterface 219 1 0
    //   436: ifeq -171 -> 265
    //   439: aload 11
    //   441: invokeinterface 223 1 0
    //   446: checkcast 295	com/tencent/pb/apollo/STExploreInfo$STMsgInfo
    //   449: astore 18
    //   451: aload 18
    //   453: getfield 298	com/tencent/pb/apollo/STExploreInfo$STMsgInfo:seq	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   456: invokevirtual 135	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   459: lstore 9
    //   461: aload 18
    //   463: getfield 301	com/tencent/pb/apollo/STExploreInfo$STMsgInfo:wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   466: invokevirtual 191	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   469: invokevirtual 304	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   472: astore 15
    //   474: aload 18
    //   476: getfield 307	com/tencent/pb/apollo/STExploreInfo$STMsgInfo:jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   479: invokevirtual 191	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   482: invokevirtual 304	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   485: astore 16
    //   487: aload 18
    //   489: getfield 310	com/tencent/pb/apollo/STExploreInfo$STMsgInfo:is_red	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   492: invokevirtual 234	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   495: istore 5
    //   497: aload 18
    //   499: getfield 313	com/tencent/pb/apollo/STExploreInfo$STMsgInfo:icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   502: invokevirtual 191	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   505: invokevirtual 304	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   508: astore 17
    //   510: aload 18
    //   512: getfield 316	com/tencent/pb/apollo/STExploreInfo$STMsgInfo:action_id	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   515: invokevirtual 234	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   518: istore 6
    //   520: aload 18
    //   522: getfield 319	com/tencent/pb/apollo/STExploreInfo$STMsgInfo:bubble_id	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   525: invokevirtual 234	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   528: istore 7
    //   530: aload 18
    //   532: getfield 322	com/tencent/pb/apollo/STExploreInfo$STMsgInfo:scheme	Lcom/tencent/mobileqq/pb/PBStringField;
    //   535: invokevirtual 163	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   538: astore 12
    //   540: aload 14
    //   542: ldc_w 324
    //   545: ldc_w 326
    //   548: invokevirtual 330	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   551: checkcast 324	com/tencent/mobileqq/apollo/api/IApolloManagerService
    //   554: aload 14
    //   556: invokevirtual 252	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   559: invokeinterface 334 2 0
    //   564: istore 8
    //   566: aload 12
    //   568: astore 11
    //   570: iconst_2
    //   571: iload 8
    //   573: if_icmpne +36 -> 609
    //   576: new 137	java/lang/StringBuilder
    //   579: dup
    //   580: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   583: astore 11
    //   585: aload 11
    //   587: ldc_w 336
    //   590: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: pop
    //   594: aload 11
    //   596: aload 12
    //   598: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload 11
    //   604: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: astore 11
    //   609: aload 18
    //   611: getfield 339	com/tencent/pb/apollo/STExploreInfo$STMsgInfo:msg_id	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   614: invokevirtual 340	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   617: ifeq +414 -> 1031
    //   620: aload 18
    //   622: getfield 339	com/tencent/pb/apollo/STExploreInfo$STMsgInfo:msg_id	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   625: invokevirtual 234	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   628: istore_2
    //   629: goto +3 -> 632
    //   632: new 342	org/json/JSONObject
    //   635: dup
    //   636: invokespecial 343	org/json/JSONObject:<init>	()V
    //   639: astore 12
    //   641: aload 12
    //   643: ldc_w 344
    //   646: iload_3
    //   647: invokevirtual 348	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   650: pop
    //   651: aload 12
    //   653: ldc_w 349
    //   656: lload 9
    //   658: invokevirtual 352	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   661: pop
    //   662: aload 12
    //   664: ldc_w 353
    //   667: aload 15
    //   669: invokevirtual 356	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   672: pop
    //   673: aload 12
    //   675: ldc_w 357
    //   678: aload 16
    //   680: invokevirtual 356	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   683: pop
    //   684: aload 12
    //   686: ldc_w 358
    //   689: iload 5
    //   691: invokevirtual 348	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   694: pop
    //   695: aload 12
    //   697: ldc_w 359
    //   700: aload 17
    //   702: invokevirtual 356	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   705: pop
    //   706: aload 12
    //   708: ldc_w 360
    //   711: iload 6
    //   713: invokevirtual 348	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   716: pop
    //   717: aload 12
    //   719: ldc_w 361
    //   722: iload 7
    //   724: invokevirtual 348	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   727: pop
    //   728: aload 12
    //   730: ldc_w 362
    //   733: aload 11
    //   735: invokevirtual 356	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   738: pop
    //   739: aload 12
    //   741: ldc_w 364
    //   744: iload 4
    //   746: invokevirtual 348	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   749: pop
    //   750: aload 12
    //   752: ldc_w 366
    //   755: iconst_1
    //   756: invokevirtual 348	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   759: pop
    //   760: aload 12
    //   762: ldc_w 367
    //   765: iload_2
    //   766: invokevirtual 348	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   769: pop
    //   770: aload 12
    //   772: ldc_w 369
    //   775: iload 8
    //   777: invokevirtual 348	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   780: pop
    //   781: new 137	java/lang/StringBuilder
    //   784: dup
    //   785: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   788: astore 11
    //   790: aload 11
    //   792: ldc_w 371
    //   795: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: pop
    //   799: aload 11
    //   801: aload 13
    //   803: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: pop
    //   807: aload 11
    //   809: ldc_w 373
    //   812: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: pop
    //   816: aload 11
    //   818: iload_3
    //   819: invokevirtual 376	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   822: pop
    //   823: aload 11
    //   825: ldc_w 378
    //   828: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: pop
    //   832: aload 11
    //   834: aload 12
    //   836: invokevirtual 381	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   839: pop
    //   840: aload 11
    //   842: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   845: astore 11
    //   847: ldc 165
    //   849: iconst_1
    //   850: aload 11
    //   852: invokestatic 383	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   855: aload 12
    //   857: invokevirtual 384	org/json/JSONObject:toString	()Ljava/lang/String;
    //   860: astore 12
    //   862: aload_1
    //   863: astore 11
    //   865: aload_1
    //   866: bipush 28
    //   868: iconst_1
    //   869: aload 12
    //   871: invokevirtual 179	com/tencent/mobileqq/apollo/handler/ApolloExtensionHandler:notifyUI	(IZLjava/lang/Object;)V
    //   874: return
    //   875: aload_1
    //   876: astore 11
    //   878: new 85	java/lang/Exception
    //   881: dup
    //   882: ldc_w 386
    //   885: invokespecial 389	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   888: checkcast 391	java/lang/Throwable
    //   891: athrow
    //   892: astore_1
    //   893: goto +11 -> 904
    //   896: astore 12
    //   898: aload_1
    //   899: astore 11
    //   901: aload 12
    //   903: astore_1
    //   904: new 137	java/lang/StringBuilder
    //   907: dup
    //   908: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   911: astore 12
    //   913: aload 12
    //   915: ldc 140
    //   917: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: pop
    //   921: aload 12
    //   923: aload 13
    //   925: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: pop
    //   929: aload 12
    //   931: ldc_w 393
    //   934: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: pop
    //   938: aload 12
    //   940: aload_1
    //   941: invokevirtual 396	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   944: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: pop
    //   948: ldc 165
    //   950: iconst_1
    //   951: aload 12
    //   953: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   956: invokestatic 173	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   959: aload 11
    //   961: bipush 28
    //   963: iconst_0
    //   964: aconst_null
    //   965: invokevirtual 179	com/tencent/mobileqq/apollo/handler/ApolloExtensionHandler:notifyUI	(IZLjava/lang/Object;)V
    //   968: return
    //   969: new 137	java/lang/StringBuilder
    //   972: dup
    //   973: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   976: astore 11
    //   978: aload 11
    //   980: ldc 140
    //   982: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   985: pop
    //   986: aload 11
    //   988: aload 13
    //   990: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: pop
    //   994: aload 11
    //   996: ldc_w 398
    //   999: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: pop
    //   1003: ldc 165
    //   1005: iconst_1
    //   1006: aload 11
    //   1008: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1011: invokestatic 173	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1014: aload_1
    //   1015: bipush 28
    //   1017: iconst_0
    //   1018: aconst_null
    //   1019: invokevirtual 179	com/tencent/mobileqq/apollo/handler/ApolloExtensionHandler:notifyUI	(IZLjava/lang/Object;)V
    //   1022: return
    //   1023: ldc_w 400
    //   1026: astore 11
    //   1028: goto -843 -> 185
    //   1031: iconst_0
    //   1032: istore_2
    //   1033: goto -401 -> 632
    //   1036: astore 12
    //   1038: goto +14 -> 1052
    //   1041: astore 12
    //   1043: aload_1
    //   1044: astore 11
    //   1046: aload 12
    //   1048: astore_1
    //   1049: goto -145 -> 904
    //   1052: aload_1
    //   1053: astore 11
    //   1055: aload 12
    //   1057: astore_1
    //   1058: goto -154 -> 904
    //   1061: astore 12
    //   1063: goto -165 -> 898
    //   1066: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1067	0	this	ApolloRequestReceiver
    //   0	1067	1	paramApolloRequestReceiveParams	ApolloRequestReceiveParams
    //   628	405	2	i	int
    //   295	524	3	j	int
    //   304	441	4	k	int
    //   495	195	5	m	int
    //   518	194	6	n	int
    //   528	195	7	i1	int
    //   564	212	8	i2	int
    //   103	554	9	l	long
    //   26	1028	11	localObject1	Object
    //   4	866	12	localObject2	Object
    //   896	6	12	localException1	Exception
    //   911	41	12	localStringBuilder	StringBuilder
    //   1036	1	12	localException2	Exception
    //   1041	15	12	localException3	Exception
    //   1061	1	12	localException4	Exception
    //   15	974	13	localObject3	Object
    //   37	518	14	localObject4	Object
    //   285	383	15	localObject5	Object
    //   320	359	16	localObject6	Object
    //   508	193	17	str	String
    //   449	172	18	localSTMsgInfo	com.tencent.pb.apollo.STExploreInfo.STMsgInfo
    // Exception table:
    //   from	to	target	type
    //   865	874	892	java/lang/Exception
    //   878	892	892	java/lang/Exception
    //   78	105	896	java/lang/Exception
    //   112	182	896	java/lang/Exception
    //   185	212	896	java/lang/Exception
    //   213	265	896	java/lang/Exception
    //   265	362	896	java/lang/Exception
    //   372	378	896	java/lang/Exception
    //   386	392	896	java/lang/Exception
    //   392	530	896	java/lang/Exception
    //   847	862	1036	java/lang/Exception
    //   540	566	1041	java/lang/Exception
    //   576	609	1041	java/lang/Exception
    //   609	629	1041	java/lang/Exception
    //   632	847	1041	java/lang/Exception
    //   530	540	1061	java/lang/Exception
  }
  
  private final void a(QQAppInterface paramQQAppInterface, ApolloExtensionHandler paramApolloExtensionHandler, JSONObject paramJSONObject)
  {
    boolean bool = QLog.isColorLevel();
    Object localObject2 = "[cmshow]ApolloRequestReceiver";
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleGetUserApolloDress rootData: ");
      ((StringBuilder)localObject1).append(paramJSONObject);
      QLog.d("[cmshow]ApolloRequestReceiver", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "app.getRuntimeService(IA…ava, ProcessConstant.ALL)");
    IApolloDaoManagerService localIApolloDaoManagerService = (IApolloDaoManagerService)localObject1;
    ArrayList localArrayList = new ArrayList();
    JSONArray localJSONArray = paramJSONObject.getJSONArray("data");
    HashMap localHashMap = new HashMap();
    localObject1 = "";
    Object localObject4 = localObject2;
    Object localObject3 = localObject1;
    int j;
    int i;
    long l1;
    if (localJSONArray != null)
    {
      j = localJSONArray.length();
      i = 0;
      for (;;)
      {
        localObject4 = localObject2;
        localObject3 = localObject1;
        if (i >= j) {
          break label567;
        }
        localObject3 = localJSONArray.opt(i);
        if (localObject3 == null) {
          break;
        }
        localObject3 = (JSONObject)localObject3;
        l1 = ((JSONObject)localObject3).optLong("uin");
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(String.valueOf(l1));
        ((StringBuilder)localObject4).append((String)localObject1);
        ApolloBaseInfo localApolloBaseInfo = localIApolloDaoManagerService.getApolloBaseInfo(((StringBuilder)localObject4).toString());
        long l2 = ((JSONObject)localObject3).optLong("ts");
        localObject4 = ((JSONObject)localObject3).toString();
        Intrinsics.checkExpressionValueIsNotNull(localObject4, "avatar.toString()");
        Intrinsics.checkExpressionValueIsNotNull(localApolloBaseInfo, "apolloBaseInfo");
        localObject3 = localApolloBaseInfo.getApolloDress();
        localApolloBaseInfo.setApolloDress(l2, (String)localObject4);
        localApolloBaseInfo.setQQApolloStatus();
        if ((localApolloBaseInfo.apolloCmQQStatusData != null) && (localApolloBaseInfo.apolloCmQQStatusData.shouldOverWriteSp(String.valueOf(l1))) && (localApolloBaseInfo.apolloCmQQStatusData.shouldRefreshSettings()))
        {
          localApolloBaseInfo.apolloCmQQStatusData.setShowUpParams(CmShowWnsUtils.R());
          localApolloBaseInfo.apolloCmQQStatusData.refreshSettings();
        }
        localObject4 = localApolloBaseInfo.getApolloDress();
        if (localObject3 == null) {
          localObject3 = localObject1;
        } else {
          localObject3 = ((ApolloDress)localObject3).encode();
        }
        if (localObject4 == null) {
          localObject4 = localObject1;
        } else {
          localObject4 = ((ApolloDress)localObject4).encode();
        }
        Object localObject5 = (CharSequence)localObject4;
        if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.equals((CharSequence)localObject3, (CharSequence)localObject5)))
        {
          localApolloBaseInfo.apolloHistoryDress = ((String)localObject3);
          localApolloBaseInfo.appearAction = ((String)null);
          SpriteRscBuilder.b(String.valueOf(l1));
          if (QLog.isColorLevel())
          {
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("save history uin:");
            ((StringBuilder)localObject5).append(l1);
            ((StringBuilder)localObject5).append(", dress: ");
            ((StringBuilder)localObject5).append((String)localObject3);
            ((StringBuilder)localObject5).append(", new dres: ");
            ((StringBuilder)localObject5).append((String)localObject4);
            QLog.d((String)localObject2, 2, ((StringBuilder)localObject5).toString());
          }
        }
        localObject3 = (Map)localHashMap;
        localObject4 = localApolloBaseInfo.uin;
        Intrinsics.checkExpressionValueIsNotNull(localObject4, "apolloBaseInfo.uin");
        ((Map)localObject3).put(localObject4, localApolloBaseInfo);
        localArrayList.add(localApolloBaseInfo);
        i += 1;
      }
      throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
    }
    label567:
    localObject1 = paramJSONObject.optJSONObject("device");
    if (localObject1 != null)
    {
      ApolloUtilImpl.saveDeviceMSAALevel(((JSONObject)localObject1).optInt("level"));
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleGetUserApolloDress MSAA_level deviceJson : ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d((String)localObject4, 2, ((StringBuilder)localObject2).toString());
      }
    }
    localObject2 = paramJSONObject.optJSONArray("data2");
    if (localObject2 != null)
    {
      int k = ((JSONArray)localObject2).length();
      i = 0;
      paramJSONObject = (JSONObject)localObject3;
      while (i < k)
      {
        localObject1 = ((JSONArray)localObject2).opt(i);
        if (localObject1 != null)
        {
          localObject3 = (JSONObject)localObject1;
          l1 = ((JSONObject)localObject3).optLong("uin");
          localObject1 = (ApolloBaseInfo)localHashMap.get(String.valueOf(l1));
          if (localObject1 == null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(String.valueOf(l1));
            ((StringBuilder)localObject1).append(paramJSONObject);
            localObject1 = localIApolloDaoManagerService.getApolloBaseInfo(((StringBuilder)localObject1).toString());
            j = 1;
          }
          else
          {
            j = 0;
          }
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          ((ApolloBaseInfo)localObject1).setApolloDress3D((AppInterface)paramQQAppInterface, (JSONObject)localObject3);
          if (j != 0) {
            localArrayList.add(localObject1);
          }
          localObject1 = ((ApolloBaseInfo)localObject1).getApolloDress3D();
          if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)((ApolloDress)localObject1).faceData))) {
            ApolloResDownloaderFacade.a.a((AppRuntime)paramQQAppInterface, ((ApolloDress)localObject1).faceData, null);
          }
          i += 1;
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      paramQQAppInterface = localArrayList.iterator();
      while (paramQQAppInterface.hasNext())
      {
        paramApolloExtensionHandler = (ApolloBaseInfo)paramQQAppInterface.next();
        if (paramApolloExtensionHandler != null) {
          if (paramApolloExtensionHandler.apolloServerTS != 0L)
          {
            if (paramApolloExtensionHandler.apolloLocalTS != paramApolloExtensionHandler.apolloServerTS) {
              paramApolloExtensionHandler.apolloLocalTS = paramApolloExtensionHandler.apolloServerTS;
            }
          }
          else {
            paramApolloExtensionHandler.apolloServerTS = paramApolloExtensionHandler.apolloLocalTS;
          }
        }
      }
      paramQQAppInterface = (List)localArrayList;
      localIApolloDaoManagerService.bulkSaveOrUpdateApolloBaseInfos(paramQQAppInterface);
      ApolloResManagerFacade.a.a(paramQQAppInterface);
      return;
    }
    paramQQAppInterface = ((Map)localHashMap).entrySet().iterator();
    while (paramQQAppInterface.hasNext())
    {
      paramJSONObject = (Map.Entry)paramQQAppInterface.next();
      paramApolloExtensionHandler.a((String)paramJSONObject.getKey(), (ApolloBaseInfo)paramJSONObject.getValue());
    }
  }
  
  private final void a(QQAppInterface paramQQAppInterface, ApolloExtensionHandler paramApolloExtensionHandler, JSONObject paramJSONObject, ApolloManagerServiceImpl paramApolloManagerServiceImpl, ApolloBaseInfo paramApolloBaseInfo, boolean paramBoolean)
  {
    int i;
    if (paramJSONObject.has("CurrencyInfo"))
    {
      i = paramJSONObject.getJSONObject("CurrencyInfo").optInt("balance");
      paramApolloManagerServiceImpl = paramApolloManagerServiceImpl.getApolloPanelManager();
      Intrinsics.checkExpressionValueIsNotNull(paramApolloManagerServiceImpl, "apolloManager.getApolloPanelManager()");
      if (paramApolloManagerServiceImpl != null)
      {
        paramApolloManagerServiceImpl.a = i;
        if (paramApolloManagerServiceImpl.h) {
          paramApolloManagerServiceImpl.d();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloRequestReceiver", 2, new Object[] { "balance:", Integer.valueOf(i) });
      }
    }
    if (paramJSONObject.has("zancount")) {
      paramApolloExtensionHandler.notifyUI(6, true, Integer.valueOf(paramJSONObject.optInt("zancount")));
    }
    if (paramJSONObject.has("gameCoinInfo"))
    {
      i = paramJSONObject.getJSONObject("gameCoinInfo").optInt("balance", 0);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloRequestReceiver", 2, new Object[] { "[handleGetUserApolloInfo] game coin count=", Integer.valueOf(i) });
      }
      ApolloGameUtil.a((AppInterface)paramQQAppInterface, i);
    }
    if (paramBoolean)
    {
      paramQQAppInterface = paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "app.getRuntimeService(IA…ava, ProcessConstant.ALL)");
      ((IApolloDaoManagerService)paramQQAppInterface).saveOrUpdateApolloBaseInfo(paramApolloBaseInfo);
    }
  }
  
  private final boolean a(QQAppInterface paramQQAppInterface, ApolloExtensionHandler paramApolloExtensionHandler, IApolloManagerService paramIApolloManagerService, HashMap<Integer, Bundle> paramHashMap, JSONArray paramJSONArray, IApolloDaoManagerService paramIApolloDaoManagerService)
  {
    boolean bool = false;
    if (paramIApolloDaoManagerService == null) {
      return false;
    }
    paramIApolloDaoManagerService.saveObtainedActionList(paramJSONArray);
    Object localObject = paramIApolloDaoManagerService.getNotFeeTypeActionList(1);
    paramJSONArray = paramIApolloDaoManagerService.getHideActionList();
    int k;
    int j;
    int i;
    if (localObject != null)
    {
      k = ((Collection)localObject).size();
      j = 0;
      i = 0;
      while (j < k)
      {
        ApolloActionData localApolloActionData = (ApolloActionData)((List)localObject).get(j);
        if (paramHashMap.containsKey(Integer.valueOf(localApolloActionData.actionId)))
        {
          ApolloUtilImpl.updateObtainedAction(localApolloActionData, (Bundle)paramHashMap.get(Integer.valueOf(localApolloActionData.actionId)));
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleGetUserApolloInfo update actlist id: ");
            localStringBuilder.append(localApolloActionData.actionId);
            QLog.d("[cmshow]ApolloRequestReceiver", 2, localStringBuilder.toString());
          }
          i = 1;
        }
        j += 1;
      }
      j = i;
      if (paramQQAppInterface != null)
      {
        j = i;
        if (i != 0)
        {
          paramIApolloDaoManagerService.bulkSaveOrUpdateApolloActionData((List)localObject);
          j = i;
        }
      }
    }
    else
    {
      j = 0;
    }
    if (paramJSONArray != null)
    {
      int m = ((Collection)paramJSONArray).size();
      k = 0;
      i = 0;
      while (k < m)
      {
        localObject = (ApolloActionData)paramJSONArray.get(k);
        if (paramHashMap.containsKey(Integer.valueOf(((ApolloActionData)localObject).actionId)))
        {
          ((ApolloActionData)localObject).isShow = 1;
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloRequestReceiver", 2, new Object[] { "[handleGetUserApolloInfo] set user action ", Integer.valueOf(((ApolloActionData)localObject).actionId), " visible" });
          }
          i = 1;
        }
        k += 1;
      }
      k = i;
      if (paramQQAppInterface != null)
      {
        k = i;
        if (i != 0)
        {
          paramIApolloDaoManagerService.bulkSaveOrUpdateApolloActionData(paramJSONArray);
          k = i;
        }
      }
    }
    else
    {
      k = 0;
    }
    if ((k == 0) && (j == 0)) {
      paramApolloExtensionHandler.notifyUI(9, false, null);
    } else {
      bool = true;
    }
    paramQQAppInterface = paramHashMap.keySet().iterator();
    while (paramQQAppInterface.hasNext())
    {
      paramApolloExtensionHandler = (Integer)paramQQAppInterface.next();
      Intrinsics.checkExpressionValueIsNotNull(paramApolloExtensionHandler, "id");
      if (paramIApolloDaoManagerService.findActionById(paramApolloExtensionHandler.intValue()) == null) {
        paramIApolloManagerService.checkActionJsonInterval();
      }
    }
    return bool;
  }
  
  private final boolean a(QQAppInterface paramQQAppInterface, ApolloExtensionHandler paramApolloExtensionHandler, String paramString, WebSSOAgent.UniSsoServerRsp paramUniSsoServerRsp, long paramLong)
  {
    paramUniSsoServerRsp = new JSONObject(paramUniSsoServerRsp.rspdata.get()).getJSONObject("data");
    if ((paramUniSsoServerRsp != null) && (paramQQAppInterface != null))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleGetUserApolloInfo apollo data: ");
        ((StringBuilder)localObject1).append(paramUniSsoServerRsp);
        QLog.d("[cmshow]ApolloRequestReceiver", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if (localObject1 != null)
      {
        localObject1 = (ApolloManagerServiceImpl)localObject1;
        Object localObject2 = paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
        if (localObject2 != null)
        {
          localObject2 = ((ApolloDaoManagerServiceImpl)localObject2).getApolloBaseInfo(paramString);
          int i;
          if (paramUniSsoServerRsp.has("vip"))
          {
            i = paramUniSsoServerRsp.getInt("vip");
            if (i != ((ApolloBaseInfo)localObject2).apolloVipFlag)
            {
              ((ApolloBaseInfo)localObject2).apolloVipFlag = i;
              bool1 = true;
              break label177;
            }
          }
          boolean bool1 = false;
          label177:
          boolean bool2 = bool1;
          if (paramUniSsoServerRsp.has("viplevel"))
          {
            i = paramUniSsoServerRsp.getInt("viplevel");
            bool2 = bool1;
            if (i != ((ApolloBaseInfo)localObject2).apolloVipLevel)
            {
              ((ApolloBaseInfo)localObject2).apolloVipLevel = i;
              bool2 = true;
            }
          }
          bool1 = bool2;
          if (paramUniSsoServerRsp.has("userstatus"))
          {
            i = paramUniSsoServerRsp.getInt("userstatus");
            bool1 = bool2;
            if (i != ((ApolloBaseInfo)localObject2).apolloStatus)
            {
              ((ApolloBaseInfo)localObject2).apolloStatus = i;
              bool1 = true;
            }
          }
          bool2 = bool1;
          int j;
          int k;
          Object localObject4;
          if (paramUniSsoServerRsp.has("userswitch"))
          {
            localObject3 = paramUniSsoServerRsp.getJSONObject("userswitch");
            i = ((JSONObject)localObject3).optInt("drawer");
            j = ((JSONObject)localObject3).optInt("data_card");
            k = ((JSONObject)localObject3).optInt("aio");
            if ((i != ((ApolloBaseInfo)localObject2).apolloDrawerStatus) || (j != ((ApolloBaseInfo)localObject2).apolloCardStatus) || (k != ((ApolloBaseInfo)localObject2).apolloAIOStatus))
            {
              ((ApolloBaseInfo)localObject2).apolloDrawerStatus = i;
              ((ApolloBaseInfo)localObject2).apolloCardStatus = j;
              ((ApolloBaseInfo)localObject2).apolloAIOStatus = k;
              bool1 = true;
            }
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("userSwitch drawer = ");
            ((StringBuilder)localObject3).append(i);
            ((StringBuilder)localObject3).append(" , datacard = ");
            ((StringBuilder)localObject3).append(j);
            ((StringBuilder)localObject3).append(", aio = ");
            ((StringBuilder)localObject3).append(k);
            QLog.d("[cmshow]ApolloRequestReceiver", 1, ((StringBuilder)localObject3).toString());
            bool2 = bool1;
            if (Intrinsics.areEqual(paramQQAppInterface.getCurrentAccountUin(), paramString))
            {
              localObject3 = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
              if (((ApolloBaseInfo)localObject2).apolloAIOStatus == 1) {
                i = 0;
              } else {
                i = 1;
              }
              localObject3 = ((SharedPreferences)localObject3).edit();
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("sprite_hide_key");
              ((StringBuilder)localObject4).append(paramString);
              ((SharedPreferences.Editor)localObject3).putInt(((StringBuilder)localObject4).toString(), i).commit();
              bool2 = bool1;
            }
          }
          paramString = BaseApplicationImpl.getApplication();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("get_user_apollo_info_drawer_dress_sp");
          ((StringBuilder)localObject3).append(paramQQAppInterface.getCurrentUin());
          paramString = paramString.getSharedPreferences(((StringBuilder)localObject3).toString(), 0);
          if (paramUniSsoServerRsp.has("avatar"))
          {
            localObject3 = paramUniSsoServerRsp.getJSONObject("avatar");
            i = ((JSONObject)localObject3).optInt("actid");
            localObject3 = ((JSONObject)localObject3).optString("bubble");
            paramString.edit().putInt("actid", i).putString("bubble", (String)localObject3);
          }
          if (paramUniSsoServerRsp.has("3dAbility")) {
            paramString.edit().putInt("3dAbility", paramUniSsoServerRsp.optInt("3dAbility"));
          }
          if (paramUniSsoServerRsp.has("model")) {
            paramString.edit().putInt("model", paramUniSsoServerRsp.optInt("model"));
          }
          paramString.edit().commit();
          if (paramUniSsoServerRsp.has("actlist"))
          {
            paramString = paramUniSsoServerRsp.getJSONArray("actlist");
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]ApolloRequestReceiver", 2, new Object[] { "[handleGetUserApolloInfo] user action list=", paramString });
            }
            localObject3 = new HashMap(paramString.length());
            localObject4 = new JSONArray();
            i = paramString.length();
            j = 0;
            while (j < i)
            {
              Bundle localBundle = new Bundle();
              JSONObject localJSONObject = paramString.getJSONObject(j);
              k = localJSONObject.optInt("id");
              localBundle.putLong("beginTs", localJSONObject.optLong("beginTs"));
              localBundle.putLong("endts", localJSONObject.optLong("endts"));
              int m = localJSONObject.optInt("way");
              localBundle.putInt("way", m);
              localBundle.putInt("slaveActId", localJSONObject.optInt("slaveActId"));
              if (k != 0) {
                ((Map)localObject3).put(Integer.valueOf(k), localBundle);
              }
              if (m == 6) {
                k = 6;
              } else {
                k = 0;
              }
              localJSONObject.put("type", k);
              ((JSONArray)localObject4).put(localJSONObject);
              j += 1;
            }
            bool1 = bool2;
            if (((HashMap)localObject3).size() > 0)
            {
              ((ApolloManagerServiceImpl)localObject1).setUserActionId((HashMap)localObject3);
              paramString = paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
              Intrinsics.checkExpressionValueIsNotNull(paramString, "app.getRuntimeService(\n …ant.ALL\n                )");
              paramString = (IApolloDaoManagerService)paramString;
              a(paramQQAppInterface, paramApolloExtensionHandler, (IApolloManagerService)localObject1, (HashMap)localObject3, (JSONArray)localObject4, paramString);
              bool1 = bool2;
            }
          }
          else
          {
            bool1 = bool2;
            paramApolloExtensionHandler.notifyUI(9, false, null);
          }
          long l = 1073741824;
          if (l == (paramLong & l)) {
            bool2 = a(paramQQAppInterface, paramUniSsoServerRsp);
          } else {
            bool2 = false;
          }
          if (bool2)
          {
            QLog.d("[cmshow]ApolloRequestReceiver", 1, "[handleGetUserApolloInfo] send NOTIFY_TYPE_REFRESH_ACTION");
            paramApolloExtensionHandler.notifyUI(9, true, null);
          }
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "apolloBaseInfo");
          a(paramQQAppInterface, paramApolloExtensionHandler, paramUniSsoServerRsp, (ApolloManagerServiceImpl)localObject1, (ApolloBaseInfo)localObject2, bool1);
          return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl");
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl");
    }
    return false;
  }
  
  private final boolean a(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject)
  {
    QLog.d("[cmshow]ApolloRequestReceiver", 1, "[handleGetUserApolloInfo] rsp for recommend action");
    List localList = (List)new ArrayList();
    Object localObject1 = (List)new ArrayList();
    Object localObject2;
    int j;
    int i;
    int k;
    if (paramJSONObject.has("hotAct"))
    {
      localObject2 = paramJSONObject.getJSONArray("hotAct");
      QLog.d("[cmshow]ApolloRequestReceiver", 1, new Object[] { "[handleGetUserApolloInfo] hotAct=", localObject2 });
      j = ((JSONArray)localObject2).length();
      i = 0;
      while (i < j)
      {
        k = ((JSONArray)localObject2).optInt(i);
        ApolloRecommendAction localApolloRecommendAction = new ApolloRecommendAction();
        localApolloRecommendAction.id = k;
        localApolloRecommendAction.type = 1;
        localList.add(localApolloRecommendAction);
        ((List)localObject1).add(localApolloRecommendAction);
        i += 1;
      }
    }
    if (paramJSONObject.has("ascendAct"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("ascendAct");
      QLog.d("[cmshow]ApolloRequestReceiver", 1, new Object[] { "[handleGetUserApolloInfo] ascendAct=", paramJSONObject });
      k = paramJSONObject.length();
      i = 0;
      while (i < k)
      {
        int m = paramJSONObject.optInt(i);
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (((ApolloRecommendAction)((Iterator)localObject2).next()).id == m)
          {
            j = 1;
            break label250;
          }
        }
        j = 0;
        label250:
        if (j == 0)
        {
          localObject2 = new ApolloRecommendAction();
          ((ApolloRecommendAction)localObject2).id = m;
          ((ApolloRecommendAction)localObject2).type = 2;
          localList.add(localObject2);
        }
        i += 1;
      }
    }
    paramQQAppInterface = paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (IApolloDaoManagerService)paramQQAppInterface;
      paramJSONObject = paramQQAppInterface.getRecommendList();
      QLog.d("[cmshow]ApolloRequestReceiver", 1, new Object[] { "[handleGetUserApolloInfo] recommendActionList=", localList, ", local=", paramJSONObject });
      j = paramJSONObject.size();
      if (j != localList.size())
      {
        i = 1;
      }
      else
      {
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label446;
          }
          localObject1 = (ApolloRecommendAction)paramJSONObject.get(i);
          localObject2 = (ApolloRecommendAction)localList.get(i);
          if ((((ApolloRecommendAction)localObject1).id != ((ApolloRecommendAction)localObject2).id) || (((ApolloRecommendAction)localObject1).type != ((ApolloRecommendAction)localObject2).type)) {
            break;
          }
          i += 1;
        }
        label446:
        i = 0;
      }
      if (i != 0)
      {
        QLog.d("[cmshow]ApolloRequestReceiver", 1, new Object[] { "[handleGetUserApolloInfo] update recommendActionList=", localList });
        paramQQAppInterface.removeAllRecommendActionList();
        paramQQAppInterface.saveRecommendActionList(localList);
        return true;
      }
      return false;
    }
    paramQQAppInterface = new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService");
    for (;;)
    {
      throw paramQQAppInterface;
    }
  }
  
  @RequestRoute(a="cmshowar_message_plat.get_msg")
  private final void handleExploreInfo(ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    a(paramApolloRequestReceiveParams);
  }
  
  @RequestRoute(a="apollo_interact.get_msg")
  private final void handleExploreInfo2D(ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    a(paramApolloRequestReceiveParams);
  }
  
  @RequestRoute(a="apollo_router_light.apollo_emotionsvr_linkcmd_emotionused")
  private final void handleGetApolloActionUsedList(ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Object localObject2 = paramApolloRequestReceiveParams.c;
    Object localObject3;
    Object localObject1;
    QQAppInterface localQQAppInterface;
    ApolloExtensionHandler localApolloExtensionHandler;
    if (localObject2 != null)
    {
      localObject3 = paramApolloRequestReceiveParams.b;
      if (localObject3 != null)
      {
        localObject1 = paramApolloRequestReceiveParams.d;
        if (localObject1 != null)
        {
          localQQAppInterface = paramApolloRequestReceiveParams.a;
          if (localQQAppInterface != null)
          {
            localApolloExtensionHandler = paramApolloRequestReceiveParams.e;
            if (localApolloExtensionHandler != null)
            {
              if (localApolloExtensionHandler == null)
              {
                QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloActionUsedList] baseHandler is null");
                return;
              }
              if (localQQAppInterface == null)
              {
                QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloActionUsedList] baseHandler.app is null");
                return;
              }
              if (localObject3 == null)
              {
                QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloActionUsedList] failed. request is null!");
                return;
              }
              if ((localObject2 == null) || (!((FromServiceMsg)localObject2).isSuccess()) || (localObject1 == null)) {}
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramApolloRequestReceiveParams = new WebSSOAgent.UniSsoServerRsp();
        paramApolloRequestReceiveParams.mergeFrom((byte[])localObject1);
        localObject2 = ApolloActionUsedManager.a((AppInterface)localQQAppInterface);
        localObject3 = new ApolloActionUsed.EmotionUsedRsp();
        ((ApolloActionUsed.EmotionUsedRsp)localObject3).mergeFrom(paramApolloRequestReceiveParams.pbRsqData.get().toByteArray());
        paramApolloRequestReceiveParams = ((ApolloActionUsed.EmotionUsedRsp)localObject3).emtps.get();
        if (ApolloRequest.a != -1) {
          break label467;
        }
        i = 1;
        if ((paramApolloRequestReceiveParams != null) && (paramApolloRequestReceiveParams.size() >= 1))
        {
          Iterator localIterator = paramApolloRequestReceiveParams.iterator();
          if (localIterator.hasNext())
          {
            paramApolloRequestReceiveParams = (ApolloActionUsed.EmuTopo)localIterator.next();
            Object localObject4 = paramApolloRequestReceiveParams.emus.get();
            localObject1 = (List)new ArrayList();
            localObject4 = ((List)localObject4).iterator();
            if (((Iterator)localObject4).hasNext())
            {
              ((List)localObject1).add(Integer.valueOf((int)((ApolloActionUsed.EmuInfo)((Iterator)localObject4).next()).id.get()));
              continue;
            }
            int j = paramApolloRequestReceiveParams.pkgid.get();
            if (((List)localObject1).size() > 0)
            {
              paramApolloRequestReceiveParams = (ApolloRequestReceiveParams)localObject1;
              if (((List)localObject1).size() > 48) {
                paramApolloRequestReceiveParams = ((List)localObject1).subList(0, 48);
              }
              ((ApolloActionUsedManager)localObject2).a(j, paramApolloRequestReceiveParams);
            }
            else
            {
              QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloActionUsedList] emtInfo is null");
              paramApolloRequestReceiveParams = (ApolloRequestReceiveParams)localObject1;
            }
            if (i != 0) {
              continue;
            }
            localApolloExtensionHandler.notifyUI(38, true, new Object[] { Integer.valueOf(j), paramApolloRequestReceiveParams });
            continue;
          }
          long l = ((ApolloActionUsed.EmotionUsedRsp)localObject3).refresh_cycle.get();
          ((ApolloActionUsedManager)localObject2).a((AppRuntime)localQQAppInterface, l * 1000L);
          return;
        }
        QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloActionUsedList] actionUsedList is empty");
        return;
      }
      catch (Exception paramApolloRequestReceiveParams)
      {
        QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloActionUsedList] exception=", (Throwable)paramApolloRequestReceiveParams);
        return;
      }
      QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloActionUsedList] failed. no response data!");
      return;
      label467:
      int i = 0;
    }
  }
  
  @RequestRoute(a="apollo_router_light.apollo_imglogic_linkcmd_get_avatars")
  private final void handleGetApolloAvatarDataRsp(ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Object localObject2 = paramApolloRequestReceiveParams.c;
    if (localObject2 != null)
    {
      Object localObject3 = paramApolloRequestReceiveParams.b;
      if (localObject3 != null)
      {
        Object localObject1 = paramApolloRequestReceiveParams.d;
        if (localObject1 != null)
        {
          Object localObject4 = paramApolloRequestReceiveParams.a;
          if (localObject4 != null)
          {
            paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.e;
            if (paramApolloRequestReceiveParams != null)
            {
              if (paramApolloRequestReceiveParams == null)
              {
                QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloAvatarDataRsp] vasHandler is null");
                return;
              }
              if (localObject4 == null)
              {
                QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloAvatarDataRsp] vasHandler.app is null");
                return;
              }
              if (localObject3 == null)
              {
                QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloAvatarDataRsp] failed. request is null!");
                return;
              }
              if ((localObject2 != null) && (((FromServiceMsg)localObject2).isSuccess()) && (localObject1 != null)) {
                try
                {
                  localObject2 = new WebSSOAgent.UniSsoServerRsp();
                  ((WebSSOAgent.UniSsoServerRsp)localObject2).mergeFrom((byte[])localObject1);
                  localObject4 = new ApolloQQUsrImg.QQUsrImgRsp();
                  ((ApolloQQUsrImg.QQUsrImgRsp)localObject4).mergeFrom(((WebSSOAgent.UniSsoServerRsp)localObject2).pbRsqData.get().toByteArray());
                  localObject1 = ((ApolloQQUsrImg.QQUsrImgRsp)localObject4).acts.get();
                  localObject2 = ((ApolloQQUsrImg.QQUsrImgRsp)localObject4).jump_more.get();
                  localObject3 = ((ApolloQQUsrImg.QQUsrImgRsp)localObject4).jump_open_page.get();
                  int j = ((ApolloQQUsrImg.QQUsrImgRsp)localObject4).icon_nums.get();
                  if ((localObject1 != null) && (((List)localObject1).size() >= 1))
                  {
                    if (TextUtils.isEmpty((CharSequence)localObject2))
                    {
                      QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloAvatarDataRsp] jumpMoreUrl is null");
                      return;
                    }
                    if (TextUtils.isEmpty((CharSequence)localObject3))
                    {
                      QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloAvatarDataRsp] jumpMallUrl is null");
                      return;
                    }
                    if (j < 1)
                    {
                      QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloAvatarDataRsp] counts is null");
                      return;
                    }
                    localObject4 = (List)new ArrayList();
                    int k = ((Collection)localObject1).size();
                    int i = 0;
                    while (i < k)
                    {
                      ApolloQQUsrImg.Action localAction = (ApolloQQUsrImg.Action)((List)localObject1).get(i);
                      CmAvatarFaceInfo localCmAvatarFaceInfo = new CmAvatarFaceInfo();
                      localCmAvatarFaceInfo.setActionId((int)localAction.act_id.get());
                      localCmAvatarFaceInfo.setIsDynamic((int)localAction.is_dynamic.get());
                      localCmAvatarFaceInfo.setType((int)localAction.type.get());
                      localCmAvatarFaceInfo.setActionType(localAction.act_type.get());
                      localCmAvatarFaceInfo.setIcon(localAction.icon.get());
                      ((List)localObject4).add(localCmAvatarFaceInfo);
                      i += 1;
                    }
                    ((BusinessHandler)paramApolloRequestReceiveParams).notifyUI(39, true, new Object[] { localObject4, localObject2, localObject3, Integer.valueOf(j) });
                    return;
                  }
                  QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloAvatarDataRsp] actionList is empty");
                  return;
                }
                catch (Exception paramApolloRequestReceiveParams)
                {
                  QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloAvatarActionListNetworkRsp] exception=", (Throwable)paramApolloRequestReceiveParams);
                  return;
                }
              }
              QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloAvatarDataRsp] failed. no response data!");
            }
          }
        }
      }
    }
  }
  
  @RequestRoute(a="OidbSvc.0x5eb_15")
  private final void handleGetApolloBaseInfo(ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Object localObject3 = paramApolloRequestReceiveParams.c;
    if (localObject3 != null)
    {
      Object localObject4 = paramApolloRequestReceiveParams.b;
      if (localObject4 != null)
      {
        Object localObject2 = paramApolloRequestReceiveParams.d;
        if (localObject2 != null)
        {
          Object localObject1 = paramApolloRequestReceiveParams.a;
          if (localObject1 != null)
          {
            ApolloExtensionHandler localApolloExtensionHandler = paramApolloRequestReceiveParams.e;
            if (localApolloExtensionHandler != null)
            {
              Object localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("handleGetApolloBaseInfo ");
              ((StringBuilder)localObject5).append(((FromServiceMsg)localObject3).isSuccess());
              ((StringBuilder)localObject5).append(", ");
              if (localObject2 != null) {
                paramApolloRequestReceiveParams = Integer.valueOf(localObject2.length);
              } else {
                paramApolloRequestReceiveParams = null;
              }
              ((StringBuilder)localObject5).append(Integer.valueOf(paramApolloRequestReceiveParams.intValue()));
              QLog.d("[cmshow]ApolloRequestReceiver", 1, ((StringBuilder)localObject5).toString());
              int j;
              int i;
              if ((localObject2 != null) && (((FromServiceMsg)localObject3).isSuccess())) {
                try
                {
                  localObject3 = new oidb_sso.OIDBSSOPkg();
                  ((oidb_sso.OIDBSSOPkg)localObject3).mergeFrom((byte[])localObject2);
                  if (((oidb_sso.OIDBSSOPkg)localObject3).uint32_result.has())
                  {
                    if (((oidb_sso.OIDBSSOPkg)localObject3).uint32_result.get() != 0) {
                      return;
                    }
                    paramApolloRequestReceiveParams = new oidb_0x5eb.RspBody();
                    paramApolloRequestReceiveParams.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.get().toByteArray());
                    localObject2 = new ArrayList(paramApolloRequestReceiveParams.rpt_msg_uin_data.size());
                    localObject3 = new ArrayList(paramApolloRequestReceiveParams.rpt_msg_uin_data.size());
                    localObject1 = ((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all");
                    Intrinsics.checkExpressionValueIsNotNull(localObject1, "app.getRuntimeService(IA…ava, ProcessConstant.ALL)");
                    localObject1 = (IApolloDaoManagerService)localObject1;
                    j = paramApolloRequestReceiveParams.rpt_msg_uin_data.size();
                    i = 0;
                    while (i < j)
                    {
                      localObject4 = (oidb_0x5eb.UdcUinData)paramApolloRequestReceiveParams.rpt_msg_uin_data.get(i);
                      localObject5 = new StringBuilder();
                      ((StringBuilder)localObject5).append(String.valueOf(((oidb_0x5eb.UdcUinData)localObject4).uint64_uin.get()));
                      ((StringBuilder)localObject5).append("");
                      localObject5 = ((StringBuilder)localObject5).toString();
                      ApolloBaseInfo localApolloBaseInfo = ((IApolloDaoManagerService)localObject1).getApolloBaseInfo((String)localObject5);
                      if (((oidb_0x5eb.UdcUinData)localObject4).uint32_apollo_vip_flag.has()) {
                        localApolloBaseInfo.apolloVipFlag = ((oidb_0x5eb.UdcUinData)localObject4).uint32_apollo_vip_flag.get();
                      }
                      if (((oidb_0x5eb.UdcUinData)localObject4).uint32_apollo_vip_level.has()) {
                        localApolloBaseInfo.apolloVipLevel = ((oidb_0x5eb.UdcUinData)localObject4).uint32_apollo_vip_level.get();
                      }
                      if (((oidb_0x5eb.UdcUinData)localObject4).uint32_apollo_status.has()) {
                        localApolloBaseInfo.apolloStatus = ((oidb_0x5eb.UdcUinData)localObject4).uint32_apollo_status.get();
                      }
                      if (((oidb_0x5eb.UdcUinData)localObject4).uint32_apollo_timestamp.has()) {
                        localApolloBaseInfo.apolloServerTS = ((oidb_0x5eb.UdcUinData)localObject4).uint32_apollo_timestamp.get();
                      }
                      if (((oidb_0x5eb.UdcUinData)localObject4).uint32_cmshow_3d_flag.has()) {
                        localApolloBaseInfo.cmshow3dFlag = ((oidb_0x5eb.UdcUinData)localObject4).uint32_cmshow_3d_flag.get();
                      }
                      if (((oidb_0x5eb.UdcUinData)localObject4).uint32_flag_super_yellow_diamond.has()) {
                        localApolloBaseInfo.superYellowDiamondFlag = ((oidb_0x5eb.UdcUinData)localObject4).uint32_flag_super_yellow_diamond.get();
                      }
                      QLog.d("[cmshow]ApolloRequestReceiver", 1, new Object[] { "handleGetApolloBaseInfo uin: ", localApolloBaseInfo.uin, ",apollo vipFlag: ", Integer.valueOf(localApolloBaseInfo.apolloVipFlag), ", apollo status: ", Integer.valueOf(localApolloBaseInfo.apolloStatus), ", apollo level: ", Integer.valueOf(localApolloBaseInfo.apolloVipLevel), ", svr TS: ", Long.valueOf(localApolloBaseInfo.apolloServerTS), ", cmshow3dFlag=", Integer.valueOf(localApolloBaseInfo.cmshow3dFlag) });
                      if (localApolloBaseInfo.apolloLocalTS != localApolloBaseInfo.apolloServerTS) {
                        ((ArrayList)localObject2).add(Long.valueOf(((oidb_0x5eb.UdcUinData)localObject4).uint64_uin.get()));
                      } else {
                        localApolloExtensionHandler.b((String)localObject5, localApolloBaseInfo);
                      }
                      localApolloBaseInfo.apolloUpdateTime = NetConnInfoCenter.getServerTime();
                      ((ArrayList)localObject3).add(localApolloBaseInfo);
                      i += 1;
                    }
                    ((IApolloDaoManagerService)localObject1).bulkSaveOrUpdateApolloBaseInfos((List)localObject3);
                    localApolloExtensionHandler.a((ArrayList)localObject2, "AIO");
                    return;
                  }
                  return;
                }
                catch (Throwable paramApolloRequestReceiveParams)
                {
                  QLog.e("[cmshow]ApolloRequestReceiver", 1, "", paramApolloRequestReceiveParams);
                  return;
                }
              }
              paramApolloRequestReceiveParams = ((Intent)localObject4).getStringArrayExtra("uins");
              if (paramApolloRequestReceiveParams != null)
              {
                localObject2 = new ArrayList(paramApolloRequestReceiveParams.length);
                j = paramApolloRequestReceiveParams.length;
                i = 0;
                while (i < j)
                {
                  localObject3 = paramApolloRequestReceiveParams[i];
                  localObject4 = ((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all");
                  Intrinsics.checkExpressionValueIsNotNull(localObject4, "app.getRuntimeService(IA…ava, ProcessConstant.ALL)");
                  localObject4 = ((IApolloDaoManagerService)localObject4).getApolloBaseInfo((String)localObject3);
                  if ((localObject4 != null) && (((ApolloBaseInfo)localObject4).apolloLocalTS != ((ApolloBaseInfo)localObject4).apolloServerTS))
                  {
                    Intrinsics.checkExpressionValueIsNotNull(localObject3, "uin");
                    ((ArrayList)localObject2).add(Long.valueOf(Long.parseLong((String)localObject3)));
                  }
                  else
                  {
                    localApolloExtensionHandler.b((String)localObject3, (ApolloBaseInfo)localObject4);
                  }
                  i += 1;
                }
                localApolloExtensionHandler.a((ArrayList)localObject2, "AIOPanel");
              }
            }
          }
        }
      }
    }
  }
  
  @RequestRoute(a="apollo_router_light.cmshow_game_linkcmd_open_game_box")
  private final void handleGetApolloBattleGameList(ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Object localObject3 = paramApolloRequestReceiveParams.c;
    if (localObject3 != null)
    {
      Object localObject1 = paramApolloRequestReceiveParams.b;
      if (localObject1 != null)
      {
        Object localObject2 = paramApolloRequestReceiveParams.d;
        if (localObject2 != null)
        {
          QQAppInterface localQQAppInterface = paramApolloRequestReceiveParams.a;
          if (localQQAppInterface != null)
          {
            paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.e;
            if (paramApolloRequestReceiveParams != null)
            {
              if (paramApolloRequestReceiveParams == null)
              {
                QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloBattleGameList] baseHandler is null");
                return;
              }
              if (localQQAppInterface == null)
              {
                QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloBattleGameList] baseHandler.app is null");
                return;
              }
              if (localObject1 == null)
              {
                QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloBattleGameList] failed. request is null!");
                return;
              }
              if ((localObject3 != null) && (((FromServiceMsg)localObject3).isSuccess()) && (localObject2 != null)) {
                try
                {
                  localObject3 = new WebSSOAgent.UniSsoServerRsp();
                  ((WebSSOAgent.UniSsoServerRsp)localObject3).mergeFrom((byte[])localObject2);
                  localObject2 = new OpenGameBox.StOpenGameBoxRsp();
                  ((OpenGameBox.StOpenGameBoxRsp)localObject2).mergeFrom(((WebSSOAgent.UniSsoServerRsp)localObject3).pbRsqData.get().toByteArray());
                  if (((Intent)localObject1).getBooleanExtra("cm_battle_game_hippy", false))
                  {
                    paramApolloRequestReceiveParams.notifyUI(40, true, localObject2);
                    return;
                  }
                  localObject1 = ((OpenGameBox.StOpenGameBoxRsp)localObject2).scenes.get();
                  if ((localObject1 != null) && (((List)localObject1).size() >= 1))
                  {
                    localObject1 = (OpenGameBox.StScene)((List)localObject1).get(0);
                    if (localObject1 != null)
                    {
                      int i = ((OpenGameBox.StScene)localObject1).scene_id.get();
                      localObject2 = (List)new ArrayList();
                      localObject3 = ((OpenGameBox.StScene)localObject1).items.get().iterator();
                      while (((Iterator)localObject3).hasNext())
                      {
                        ApolloBattleGameInfo localApolloBattleGameInfo = ApolloUtilImpl.stBoxItem2ApolloBattleGameInfo(i, (OpenGameBox.StBoxItem)((Iterator)localObject3).next());
                        Intrinsics.checkExpressionValueIsNotNull(localApolloBattleGameInfo, "ApolloUtilImpl.stBoxItem…leGameInfo(sceneId, item)");
                        ((List)localObject2).add(localApolloBattleGameInfo);
                      }
                      if (((List)localObject2).size() > 0)
                      {
                        ((IApolloDaoManagerService)localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).updateBattleGameInfo(i, (List)localObject2);
                        paramApolloRequestReceiveParams.notifyUI(37, true, new Object[] { Integer.valueOf(i), localObject2 });
                      }
                      ApolloUtilImpl.saveApolloPanelBattleGameRequestInterval((AppInterface)localQQAppInterface, i, ((OpenGameBox.StScene)localObject1).refresh_interval.get() * 1000L);
                      return;
                    }
                    QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloBattleGameList] stScene is null");
                    return;
                  }
                  QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloBattleGameList] stSceneList is empty");
                  return;
                }
                catch (Exception paramApolloRequestReceiveParams)
                {
                  QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloBattleGameList] exception=", (Throwable)paramApolloRequestReceiveParams);
                  return;
                }
              }
              paramApolloRequestReceiveParams.notifyUI(40, false, null);
              QLog.e("[cmshow]ApolloRequestReceiver", 1, "[handleGetApolloBattleGameList] failed. no response data!");
            }
          }
        }
      }
    }
  }
  
  @RequestRoute(a="apollo_core.get_avatar")
  private final void handleGetUserApolloDress(ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Object localObject2 = paramApolloRequestReceiveParams.c;
    if (localObject2 != null)
    {
      Intent localIntent = paramApolloRequestReceiveParams.b;
      if (localIntent != null)
      {
        byte[] arrayOfByte = paramApolloRequestReceiveParams.d;
        if (arrayOfByte != null)
        {
          Object localObject1 = paramApolloRequestReceiveParams.a;
          if (localObject1 != null)
          {
            ApolloExtensionHandler localApolloExtensionHandler = paramApolloRequestReceiveParams.e;
            if (localApolloExtensionHandler != null)
            {
              paramApolloRequestReceiveParams = new StringBuilder();
              paramApolloRequestReceiveParams.append("; isSuccess: ");
              paramApolloRequestReceiveParams.append(((FromServiceMsg)localObject2).isSuccess());
              paramApolloRequestReceiveParams.append(", ret: ");
              paramApolloRequestReceiveParams.append(((FromServiceMsg)localObject2).getResultCode());
              QLog.d("[cmshow]ApolloRequestReceiver", 1, paramApolloRequestReceiveParams.toString());
              int j = 0;
              int k;
              int i;
              if ((arrayOfByte != null) && (((FromServiceMsg)localObject2).isSuccess()))
              {
                try
                {
                  paramApolloRequestReceiveParams = new WebSSOAgent.UniSsoServerRsp();
                  paramApolloRequestReceiveParams.mergeFrom(arrayOfByte);
                  if (QLog.isColorLevel())
                  {
                    localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append("handleGetUserApolloDress ret: ");
                    ((StringBuilder)localObject2).append(paramApolloRequestReceiveParams.ret.get());
                    QLog.d("[cmshow]ApolloRequestReceiver", 2, ((StringBuilder)localObject2).toString());
                  }
                  if (0L == paramApolloRequestReceiveParams.ret.get()) {
                    paramApolloRequestReceiveParams = new JSONObject(paramApolloRequestReceiveParams.rspdata.get());
                  }
                  try
                  {
                    a((QQAppInterface)localObject1, localApolloExtensionHandler, paramApolloRequestReceiveParams);
                  }
                  catch (Throwable paramApolloRequestReceiveParams)
                  {
                    break label343;
                  }
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("handleGetUserApolloDress request failed ");
                  ((StringBuilder)localObject1).append(paramApolloRequestReceiveParams.ret.get());
                  QLog.e("[cmshow]ApolloRequestReceiver", 1, ((StringBuilder)localObject1).toString());
                  paramApolloRequestReceiveParams = localIntent.getExtras().get("uinArr");
                  if (paramApolloRequestReceiveParams != null)
                  {
                    paramApolloRequestReceiveParams = (Long[])paramApolloRequestReceiveParams;
                    if (paramApolloRequestReceiveParams == null) {
                      break label451;
                    }
                    k = paramApolloRequestReceiveParams.length;
                    i = 0;
                    while (i < k)
                    {
                      localApolloExtensionHandler.a(String.valueOf(paramApolloRequestReceiveParams[i].longValue()), null);
                      i += 1;
                    }
                  }
                  throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Long>");
                }
                catch (Throwable paramApolloRequestReceiveParams) {}
                label343:
                QLog.e("[cmshow]ApolloRequestReceiver", 1, "", paramApolloRequestReceiveParams);
              }
              else
              {
                paramApolloRequestReceiveParams = new StringBuilder();
                paramApolloRequestReceiveParams.append("handleGetUserApolloDress fail ret: ");
                paramApolloRequestReceiveParams.append(((FromServiceMsg)localObject2).getResultCode());
                QLog.e("[cmshow]ApolloRequestReceiver", 1, paramApolloRequestReceiveParams.toString());
                paramApolloRequestReceiveParams = localIntent.getExtras().get("uinArr");
                if (paramApolloRequestReceiveParams == null) {
                  break label574;
                }
                paramApolloRequestReceiveParams = (Long[])paramApolloRequestReceiveParams;
                if (paramApolloRequestReceiveParams != null)
                {
                  k = paramApolloRequestReceiveParams.length;
                  i = 0;
                  while (i < k)
                  {
                    localApolloExtensionHandler.a(String.valueOf(paramApolloRequestReceiveParams[i].longValue()), null);
                    i += 1;
                  }
                }
              }
              label451:
              paramApolloRequestReceiveParams = localIntent.getExtras().get("uinArr");
              if (paramApolloRequestReceiveParams != null)
              {
                paramApolloRequestReceiveParams = (Long[])paramApolloRequestReceiveParams;
                if (paramApolloRequestReceiveParams != null)
                {
                  k = paramApolloRequestReceiveParams.length;
                  i = j;
                  while (i < k)
                  {
                    long l = paramApolloRequestReceiveParams[i].longValue();
                    localApolloExtensionHandler.g.remove(Long.valueOf(l));
                    i += 1;
                  }
                }
                if (QLog.isColorLevel())
                {
                  paramApolloRequestReceiveParams = new StringBuilder();
                  paramApolloRequestReceiveParams.append("handleGetUserApolloDress done  mSendingQueue size: ");
                  paramApolloRequestReceiveParams.append(localApolloExtensionHandler.g.size());
                  QLog.i("[cmshow]ApolloRequestReceiver", 2, paramApolloRequestReceiveParams.toString());
                }
                return;
              }
              throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Long>");
              label574:
              throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Long>");
            }
            return;
          }
          return;
        }
        return;
      }
      return;
    }
  }
  
  /* Error */
  @RequestRoute(a="apollo_extend.set_user_flag")
  private final void handleSetUserFlagResponse(ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 91	com/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams:c	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   4: astore 11
    //   6: aload 11
    //   8: ifnull +625 -> 633
    //   11: aload_1
    //   12: getfield 95	com/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams:b	Landroid/content/Intent;
    //   15: astore 12
    //   17: aload 12
    //   19: ifnull +614 -> 633
    //   22: aload_1
    //   23: getfield 99	com/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams:d	[B
    //   26: astore 10
    //   28: aload 10
    //   30: ifnull +603 -> 633
    //   33: aload_1
    //   34: getfield 101	com/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: astore 9
    //   39: aload 9
    //   41: ifnull +592 -> 633
    //   44: aload_1
    //   45: getfield 104	com/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams:e	Lcom/tencent/mobileqq/apollo/handler/ApolloExtensionHandler;
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull +583 -> 633
    //   53: invokestatic 404	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq +12 -> 68
    //   59: ldc 165
    //   61: iconst_2
    //   62: ldc_w 1287
    //   65: invokestatic 383	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: new 421	java/util/HashMap
    //   71: dup
    //   72: invokespecial 422	java/util/HashMap:<init>	()V
    //   75: astore 8
    //   77: aload 12
    //   79: ifnull +168 -> 247
    //   82: aload 12
    //   84: ldc_w 415
    //   87: invokevirtual 1291	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   90: astore 12
    //   92: aload 12
    //   94: ifnull +153 -> 247
    //   97: new 1293	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerReq
    //   100: dup
    //   101: invokespecial 1294	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerReq:<init>	()V
    //   104: astore 13
    //   106: aload 13
    //   108: aload 12
    //   110: invokevirtual 1295	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerReq:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   113: pop
    //   114: new 342	org/json/JSONObject
    //   117: dup
    //   118: aload 13
    //   120: getfield 1298	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerReq:reqdata	Lcom/tencent/mobileqq/pb/PBStringField;
    //   123: invokevirtual 163	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   126: invokespecial 755	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   129: astore 12
    //   131: aload 12
    //   133: ldc_w 1300
    //   136: invokevirtual 639	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   139: ifeq +108 -> 247
    //   142: aload 12
    //   144: ldc_w 1300
    //   147: invokevirtual 419	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   150: astore 12
    //   152: aload 12
    //   154: ifnull +93 -> 247
    //   157: aload 12
    //   159: invokevirtual 428	org/json/JSONArray:length	()I
    //   162: istore_3
    //   163: iconst_0
    //   164: istore_2
    //   165: iload_2
    //   166: iload_3
    //   167: if_icmpge +80 -> 247
    //   170: aload 12
    //   172: iload_2
    //   173: invokevirtual 856	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   176: astore 13
    //   178: aload 13
    //   180: ifnull +44 -> 224
    //   183: aload 13
    //   185: ldc_w 873
    //   188: invokevirtual 553	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   191: istore 4
    //   193: aload 13
    //   195: ldc_w 1302
    //   198: invokevirtual 553	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   201: istore 5
    //   203: aload 8
    //   205: checkcast 526	java/util/Map
    //   208: iload 4
    //   210: invokestatic 669	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   213: iload 5
    //   215: invokestatic 669	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   218: invokeinterface 533 3 0
    //   223: pop
    //   224: iload_2
    //   225: iconst_1
    //   226: iadd
    //   227: istore_2
    //   228: goto -63 -> 165
    //   231: astore 12
    //   233: ldc 165
    //   235: iconst_1
    //   236: ldc_w 1304
    //   239: aload 12
    //   241: checkcast 391	java/lang/Throwable
    //   244: invokestatic 1004	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   247: ldc 165
    //   249: iconst_2
    //   250: iconst_2
    //   251: anewarray 4	java/lang/Object
    //   254: dup
    //   255: iconst_0
    //   256: ldc_w 1306
    //   259: aastore
    //   260: dup
    //   261: iconst_1
    //   262: aload 8
    //   264: aastore
    //   265: invokestatic 672	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   268: aload 10
    //   270: ifnull +328 -> 598
    //   273: aload 11
    //   275: invokevirtual 118	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   278: ifne +6 -> 284
    //   281: goto +317 -> 598
    //   284: new 120	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp
    //   287: dup
    //   288: invokespecial 121	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:<init>	()V
    //   291: astore 11
    //   293: aload 11
    //   295: aload 10
    //   297: invokevirtual 125	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   300: pop
    //   301: aload 11
    //   303: getfield 129	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:ret	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   306: invokevirtual 135	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   309: lstore 6
    //   311: ldc 165
    //   313: iconst_2
    //   314: iconst_2
    //   315: anewarray 4	java/lang/Object
    //   318: dup
    //   319: iconst_0
    //   320: ldc_w 1308
    //   323: aastore
    //   324: dup
    //   325: iconst_1
    //   326: lload 6
    //   328: invokestatic 1155	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   331: aastore
    //   332: invokestatic 672	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   335: lload 6
    //   337: lconst_0
    //   338: lcmp
    //   339: ifeq +13 -> 352
    //   342: aload_1
    //   343: bipush 22
    //   345: iconst_0
    //   346: aload 8
    //   348: invokevirtual 179	com/tencent/mobileqq/apollo/handler/ApolloExtensionHandler:notifyUI	(IZLjava/lang/Object;)V
    //   351: return
    //   352: aload 8
    //   354: bipush 16
    //   356: invokestatic 669	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   359: invokevirtual 715	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   362: ifeq +200 -> 562
    //   365: aload 8
    //   367: bipush 16
    //   369: invokestatic 669	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   372: invokevirtual 569	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   375: astore 10
    //   377: aload 10
    //   379: ifnonnull +6 -> 385
    //   382: invokestatic 572	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   385: aload 10
    //   387: ldc_w 1310
    //   390: invokestatic 266	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   393: aload 10
    //   395: checkcast 1312	java/lang/Number
    //   398: invokevirtual 1313	java/lang/Number:intValue	()I
    //   401: istore_2
    //   402: aload 9
    //   404: ldc_w 408
    //   407: ldc_w 326
    //   410: invokevirtual 330	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   413: astore 10
    //   415: aload 10
    //   417: ldc_w 410
    //   420: invokestatic 266	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   423: aload 10
    //   425: checkcast 408	com/tencent/mobileqq/apollo/persistence/api/IApolloDaoManagerService
    //   428: astore 10
    //   430: aload 10
    //   432: aload 9
    //   434: invokevirtual 804	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   437: invokeinterface 448 2 0
    //   442: astore 9
    //   444: aload 9
    //   446: ifnull +116 -> 562
    //   449: aload 9
    //   451: getfield 1316	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:apolloAISwitch	I
    //   454: bipush 16
    //   456: iand
    //   457: iload_2
    //   458: iconst_4
    //   459: ishl
    //   460: if_icmpeq +102 -> 562
    //   463: invokestatic 404	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   466: ifeq +30 -> 496
    //   469: ldc 165
    //   471: iconst_2
    //   472: iconst_2
    //   473: anewarray 4	java/lang/Object
    //   476: dup
    //   477: iconst_0
    //   478: ldc_w 1318
    //   481: aastore
    //   482: dup
    //   483: iconst_1
    //   484: aload 9
    //   486: getfield 1316	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:apolloAISwitch	I
    //   489: invokestatic 1322	java/lang/Integer:toBinaryString	(I)Ljava/lang/String;
    //   492: aastore
    //   493: invokestatic 672	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   496: aload 9
    //   498: getfield 1316	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:apolloAISwitch	I
    //   501: istore_2
    //   502: aload 9
    //   504: bipush 16
    //   506: aload 9
    //   508: getfield 1316	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:apolloAISwitch	I
    //   511: ixor
    //   512: iload_2
    //   513: bipush 239
    //   515: iand
    //   516: ior
    //   517: putfield 1316	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:apolloAISwitch	I
    //   520: aload 10
    //   522: aload 9
    //   524: invokeinterface 690 2 0
    //   529: invokestatic 404	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   532: ifeq +30 -> 562
    //   535: ldc 165
    //   537: iconst_2
    //   538: iconst_2
    //   539: anewarray 4	java/lang/Object
    //   542: dup
    //   543: iconst_0
    //   544: ldc_w 1324
    //   547: aastore
    //   548: dup
    //   549: iconst_1
    //   550: aload 9
    //   552: getfield 1316	com/tencent/mobileqq/apollo/model/ApolloBaseInfo:apolloAISwitch	I
    //   555: invokestatic 1322	java/lang/Integer:toBinaryString	(I)Ljava/lang/String;
    //   558: aastore
    //   559: invokestatic 672	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   562: aload_1
    //   563: bipush 22
    //   565: iconst_1
    //   566: aload 8
    //   568: invokevirtual 179	com/tencent/mobileqq/apollo/handler/ApolloExtensionHandler:notifyUI	(IZLjava/lang/Object;)V
    //   571: return
    //   572: astore 9
    //   574: ldc 165
    //   576: iconst_1
    //   577: ldc_w 1326
    //   580: aload 9
    //   582: checkcast 391	java/lang/Throwable
    //   585: invokestatic 1004	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   588: aload_1
    //   589: bipush 22
    //   591: iconst_0
    //   592: aload 8
    //   594: invokevirtual 179	com/tencent/mobileqq/apollo/handler/ApolloExtensionHandler:notifyUI	(IZLjava/lang/Object;)V
    //   597: return
    //   598: ldc 165
    //   600: iconst_2
    //   601: iconst_2
    //   602: anewarray 4	java/lang/Object
    //   605: dup
    //   606: iconst_0
    //   607: ldc_w 1328
    //   610: aastore
    //   611: dup
    //   612: iconst_1
    //   613: aload 11
    //   615: invokevirtual 1245	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   618: invokestatic 669	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   621: aastore
    //   622: invokestatic 1330	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   625: aload_1
    //   626: bipush 22
    //   628: iconst_0
    //   629: aconst_null
    //   630: invokevirtual 179	com/tencent/mobileqq/apollo/handler/ApolloExtensionHandler:notifyUI	(IZLjava/lang/Object;)V
    //   633: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	634	0	this	ApolloRequestReceiver
    //   0	634	1	paramApolloRequestReceiveParams	ApolloRequestReceiveParams
    //   164	352	2	i	int
    //   162	6	3	j	int
    //   191	18	4	k	int
    //   201	13	5	m	int
    //   309	27	6	l	long
    //   75	518	8	localHashMap	HashMap
    //   37	514	9	localObject1	Object
    //   572	9	9	localException1	Exception
    //   26	495	10	localObject2	Object
    //   4	610	11	localObject3	Object
    //   15	156	12	localObject4	Object
    //   231	9	12	localException2	Exception
    //   104	90	13	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   106	152	231	java/lang/Exception
    //   157	163	231	java/lang/Exception
    //   170	178	231	java/lang/Exception
    //   183	224	231	java/lang/Exception
    //   284	335	572	java/lang/Exception
    //   342	351	572	java/lang/Exception
    //   352	377	572	java/lang/Exception
    //   382	385	572	java/lang/Exception
    //   385	444	572	java/lang/Exception
    //   449	496	572	java/lang/Exception
    //   496	562	572	java/lang/Exception
    //   562	571	572	java/lang/Exception
  }
  
  @RequestRoute(a="apollo_core.save_checkmul")
  public final void handleApolloRoleAndDress(@NotNull ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Intrinsics.checkParameterIsNotNull(paramApolloRequestReceiveParams, "params");
    Object localObject2 = paramApolloRequestReceiveParams.b;
    Object localObject1;
    long l;
    if (localObject2 != null)
    {
      localObject1 = paramApolloRequestReceiveParams.c;
      if (localObject1 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleApolloRoleAndDress; isSuccess: ");
        localStringBuilder.append(((FromServiceMsg)localObject1).isSuccess());
        localStringBuilder.append(", ret: ");
        localStringBuilder.append(((FromServiceMsg)localObject1).getResultCode());
        QLog.d("[cmshow]ApolloRequestReceiver", 2, localStringBuilder.toString());
        l = ((Intent)localObject2).getLongExtra("index", -1L);
        if (!((FromServiceMsg)localObject1).isSuccess()) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject1).mergeFrom(paramApolloRequestReceiveParams.d);
        paramApolloRequestReceiveParams = new StringBuilder();
        paramApolloRequestReceiveParams.append("handleApolloRoleAndDress ret: ");
        paramApolloRequestReceiveParams.append(((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get());
        paramApolloRequestReceiveParams.append("; errMsg: ");
        paramApolloRequestReceiveParams.append(((WebSSOAgent.UniSsoServerRsp)localObject1).errmsg.get());
        QLog.d("[cmshow]ApolloRequestReceiver", 1, paramApolloRequestReceiveParams.toString());
        if (((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get() == 0L)
        {
          paramApolloRequestReceiveParams = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject1).rspdata.get());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handleApolloRoleAndDress dataJson : ");
          ((StringBuilder)localObject2).append(paramApolloRequestReceiveParams);
          QLog.d("[cmshow]ApolloRequestReceiver", 1, ((StringBuilder)localObject2).toString());
        }
        paramApolloRequestReceiveParams = ApolloRequestCallbackManager.a;
        if (((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get() != 0L) {
          break label388;
        }
        bool = true;
        paramApolloRequestReceiveParams.a(l, bool, ((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get(), ((WebSSOAgent.UniSsoServerRsp)localObject1).errmsg.get());
        return;
      }
      catch (Throwable paramApolloRequestReceiveParams)
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloRequestReceiver", 2, "", paramApolloRequestReceiveParams);
        }
        ApolloRequestCallbackManager.a.a(l, false, -1L, "exception");
        return;
      }
      paramApolloRequestReceiveParams = new StringBuilder();
      paramApolloRequestReceiveParams.append("handleApolloRoleAndDress fail ret: ");
      paramApolloRequestReceiveParams.append(((FromServiceMsg)localObject1).getResultCode());
      QLog.e("[cmshow]ApolloRequestReceiver", 1, paramApolloRequestReceiveParams.toString());
      ApolloRequestCallbackManager.a.a(l, false, ((FromServiceMsg)localObject1).getResultCode(), ((FromServiceMsg)localObject1).getBusinessFailMsg());
      return;
      label388:
      boolean bool = false;
    }
  }
  
  @RequestRoute(a="apollo_core.set_model")
  public final void handleApolloSetModel(@NotNull ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Intrinsics.checkParameterIsNotNull(paramApolloRequestReceiveParams, "params");
    Object localObject2 = paramApolloRequestReceiveParams.c;
    Object localObject3;
    Object localObject1;
    Object localObject4;
    long l1;
    if (localObject2 != null)
    {
      localObject3 = paramApolloRequestReceiveParams.b;
      if (localObject3 != null)
      {
        localObject1 = paramApolloRequestReceiveParams.a;
        if (localObject1 != null)
        {
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("handleApolloSetModel; isSuccess: ");
            ((StringBuilder)localObject4).append(((FromServiceMsg)localObject2).isSuccess());
            ((StringBuilder)localObject4).append(", ret: ");
            ((StringBuilder)localObject4).append(((FromServiceMsg)localObject2).getResultCode());
            QLog.d("[cmshow]ApolloRequestReceiver", 2, ((StringBuilder)localObject4).toString());
          }
          l1 = ((Intent)localObject3).getLongExtra("index", -1L);
          if (!((FromServiceMsg)localObject2).isSuccess()) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject2).mergeFrom(paramApolloRequestReceiveParams.d);
        paramApolloRequestReceiveParams = new StringBuilder();
        paramApolloRequestReceiveParams.append("handleApolloSetModel ret: ");
        paramApolloRequestReceiveParams.append(((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get());
        QLog.d("[cmshow]ApolloRequestReceiver", 1, paramApolloRequestReceiveParams.toString());
        int i = ((Intent)localObject3).getIntExtra("model", 1);
        if (((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get() == 0L)
        {
          paramApolloRequestReceiveParams = ((QQAppInterface)localObject1).getRuntimeService(IApolloManagerService.class, "all");
          Intrinsics.checkExpressionValueIsNotNull(paramApolloRequestReceiveParams, "app.getRuntimeService(IA…ava, ProcessConstant.ALL)");
          paramApolloRequestReceiveParams = (IApolloManagerService)paramApolloRequestReceiveParams;
          localObject3 = ((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all");
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "app.getRuntimeService(IA…ava, ProcessConstant.ALL)");
          localObject3 = (IApolloDaoManagerService)localObject3;
          localObject4 = ((IApolloDaoManagerService)localObject3).getApolloBaseInfo(((QQAppInterface)localObject1).getCurrentUin());
          int j = ((ApolloBaseInfo)localObject4).cmshow3dFlag;
          if (i == 1) {
            ((ApolloBaseInfo)localObject4).cmshow3dFlag |= 0x1;
          } else {
            ((ApolloBaseInfo)localObject4).cmshow3dFlag &= 0xFFFFFFFE;
          }
          if (((ApolloBaseInfo)localObject4).cmshow3dFlag != j)
          {
            ((IApolloDaoManagerService)localObject3).saveOrUpdateApolloBaseInfo((ApolloBaseInfo)localObject4);
            paramApolloRequestReceiveParams.notify3dFlagUpdate(j, ((ApolloBaseInfo)localObject4).cmshow3dFlag);
            paramApolloRequestReceiveParams = new ArrayList();
            paramApolloRequestReceiveParams.add(((QQAppInterface)localObject1).getCurrentUin());
            ((IApolloMessageService)((QQAppInterface)localObject1).getRuntimeService(IApolloMessageService.class, "all")).apolloStatusOrDressChange(3, paramApolloRequestReceiveParams);
          }
        }
        paramApolloRequestReceiveParams = ApolloRequestCallbackManager.a;
        if (((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get() != 0L) {
          break label526;
        }
        bool = true;
        long l2 = ((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get();
        localObject1 = ((WebSSOAgent.UniSsoServerRsp)localObject2).errmsg.get();
        try
        {
          paramApolloRequestReceiveParams.a(l1, bool, l2, (String)localObject1);
          return;
        }
        catch (Throwable paramApolloRequestReceiveParams) {}
        QLog.d("[cmshow]ApolloRequestReceiver", 1, "handleApolloSetModel failed ", paramApolloRequestReceiveParams);
      }
      catch (Throwable paramApolloRequestReceiveParams) {}
      ApolloRequestCallbackManager.a.a(l1, false, -1L, "exception");
      return;
      paramApolloRequestReceiveParams = new StringBuilder();
      paramApolloRequestReceiveParams.append("handleApolloSetModel fail ret: ");
      paramApolloRequestReceiveParams.append(((FromServiceMsg)localObject2).getResultCode());
      QLog.e("[cmshow]ApolloRequestReceiver", 1, paramApolloRequestReceiveParams.toString());
      ApolloRequestCallbackManager.a.a(l1, false, ((FromServiceMsg)localObject2).getResultCode(), ((FromServiceMsg)localObject2).getBusinessFailMsg());
      return;
      label526:
      boolean bool = false;
    }
  }
  
  @RequestRoute(a="apollo_terminal_info.get_user_appear_info")
  public final void handleApolloStandAction(@NotNull ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Intrinsics.checkParameterIsNotNull(paramApolloRequestReceiveParams, "params");
    Object localObject2 = paramApolloRequestReceiveParams.c;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = paramApolloRequestReceiveParams.d;
      if (localObject1 != null)
      {
        paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.a;
        if ((paramApolloRequestReceiveParams != null) && (localObject1 != null) && (((FromServiceMsg)localObject2).isSuccess())) {
          if (paramApolloRequestReceiveParams == null) {
            return;
          }
        }
      }
    }
    for (;;)
    {
      int j;
      int m;
      try
      {
        localObject2 = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject2).mergeFrom((byte[])localObject1);
        if (((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get() != 0L)
        {
          QLog.d("[cmshow]ApolloRequestReceiver", 2, new Object[] { "handleApolloStandAction error ret: ", Long.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get()) });
          return;
        }
        Object localObject3 = ((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleApolloStandAction response:");
        ((StringBuilder)localObject1).append((String)localObject3);
        QLog.i("[cmshow]ApolloRequestReceiver", 2, ((StringBuilder)localObject1).toString());
        localObject2 = ((IApolloManagerService)paramApolloRequestReceiveParams.getRuntimeService(IApolloManagerService.class, "all")).getStandUpSp();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "app.getRuntimeService(IA…stant.ALL).getStandUpSp()");
        localObject1 = ((SharedPreferences)localObject2).edit();
        localObject3 = new JSONObject((String)localObject3).getJSONArray("data");
        int i = ((JSONArray)localObject3).length();
        List localList = (List)new ArrayList();
        paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.getRuntimeService(IApolloDaoManagerService.class, "all");
        Intrinsics.checkExpressionValueIsNotNull(paramApolloRequestReceiveParams, "app.getRuntimeService(IA…ava, ProcessConstant.ALL)");
        IApolloDaoManagerService localIApolloDaoManagerService = (IApolloDaoManagerService)paramApolloRequestReceiveParams;
        paramApolloRequestReceiveParams = new ArrayList();
        j = 0;
        if (j < i)
        {
          Object localObject5 = ((JSONArray)localObject3).getJSONObject(j);
          JSONArray localJSONArray = new JSONArray();
          Object localObject4 = ((JSONObject)localObject5).getString("uin");
          JSONObject localJSONObject = new JSONObject(((SharedPreferences)localObject2).getString((String)localObject4, "{}"));
          localObject5 = ((JSONObject)localObject5).getJSONArray("action");
          Object localObject6 = localJSONObject.optJSONArray("action");
          int k = ((JSONArray)localObject5).length();
          localList.clear();
          m = 0;
          if (m < k)
          {
            int n = ((JSONArray)localObject5).getJSONObject(m).getInt("id");
            long l = ((JSONArray)localObject5).getJSONObject(m).getLong("updateTs");
            Object localObject7 = ApolloResManagerFacade.a;
            Intrinsics.checkExpressionValueIsNotNull(localObject6, "localArray");
            ((ApolloResManagerFacade)localObject7).a(n, l, (JSONArray)localObject6);
            boolean bool = ((JSONArray)localObject5).getJSONObject(m).has("actPlace");
            if (bool)
            {
              n = ((JSONArray)localObject5).getJSONObject(m).getInt("actPlace");
              if (n == 1)
              {
                localObject7 = ((JSONArray)localObject5).getJSONObject(m);
                Intrinsics.checkExpressionValueIsNotNull(localObject7, "tmpArray.getJSONObject(j)");
                localList.add(localObject7);
                break label776;
              }
              if (n != 2) {
                break label776;
              }
              localJSONArray.put(((JSONArray)localObject5).getJSONObject(m));
              break label776;
            }
            localObject7 = ((JSONArray)localObject5).getJSONObject(m);
            Intrinsics.checkExpressionValueIsNotNull(localObject7, "tmpArray.getJSONObject(j)");
            localList.add(localObject7);
            localJSONArray.put(((JSONArray)localObject5).getJSONObject(m));
            break label776;
          }
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(",sort result:");
          ((StringBuilder)localObject5).append(localList);
          QLog.d("[cmshow]ApolloRequestReceiver", 2, new Object[] { "uin:", localObject4, ((StringBuilder)localObject5).toString() });
          localObject5 = new JSONArray();
          localObject6 = localList.iterator();
          if (((Iterator)localObject6).hasNext())
          {
            ((JSONArray)localObject5).put((JSONObject)((Iterator)localObject6).next());
            continue;
          }
          localJSONObject.put("action", localObject5);
          ((SharedPreferences.Editor)localObject1).putString((String)localObject4, localJSONObject.toString());
          localObject4 = localIApolloDaoManagerService.getApolloBaseInfo((String)localObject4);
          if (localObject4 == null) {
            break label785;
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("action", localJSONArray);
          ((ApolloBaseInfo)localObject4).appearAction = localJSONObject.toString();
          paramApolloRequestReceiveParams.add(localObject4);
          break label785;
        }
        ((SharedPreferences.Editor)localObject1).commit();
        localIApolloDaoManagerService.bulkSaveOrUpdateApolloBaseInfos((List)paramApolloRequestReceiveParams);
        return;
      }
      catch (Exception paramApolloRequestReceiveParams)
      {
        QLog.e("[cmshow]ApolloRequestReceiver", 1, "handleApolloStandAction ", (Throwable)paramApolloRequestReceiveParams);
      }
      return;
      label776:
      m += 1;
      continue;
      label785:
      j += 1;
    }
  }
  
  @RequestRoute(a="apollo_currency.buy_item_by_curre")
  public final void handleBuyActionByGold(@NotNull ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Intrinsics.checkParameterIsNotNull(paramApolloRequestReceiveParams, "params");
    Object localObject3 = paramApolloRequestReceiveParams.c;
    Object localObject2;
    Object localObject1;
    int i;
    int j;
    if (localObject3 != null)
    {
      Intent localIntent = paramApolloRequestReceiveParams.b;
      if (localIntent != null)
      {
        localObject2 = paramApolloRequestReceiveParams.d;
        if (localObject2 != null)
        {
          localObject1 = paramApolloRequestReceiveParams.a;
          if (localObject1 != null)
          {
            paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.e;
            if (paramApolloRequestReceiveParams != null)
            {
              i = localIntent.getIntExtra("id", 0);
              j = localIntent.getIntExtra("packageId", 0);
              if ((localObject2 != null) && (((FromServiceMsg)localObject3).isSuccess())) {
                if (i <= 0) {
                  return;
                }
              }
            }
          }
        }
      }
    }
    int k;
    do
    {
      try
      {
        localObject3 = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject3).mergeFrom((byte[])localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloRequestReceiver", 2, new Object[] { "handleBuyActionByGold msg: ", ((WebSSOAgent.UniSsoServerRsp)localObject3).rspdata.get() });
        }
        if (((WebSSOAgent.UniSsoServerRsp)localObject3).ret.get() != 0L)
        {
          QLog.d("[cmshow]ApolloRequestReceiver", 2, new Object[] { "handleBuyActionByGold error ret: ", Long.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject3).ret.get()) });
          return;
        }
        localObject2 = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject3).rspdata.get()).getJSONObject("data");
        if ((localObject2 != null) && (localObject1 != null))
        {
          k = ((JSONObject)localObject2).optInt("isSuccBuy");
          int m = ((JSONObject)localObject2).optInt("balance");
          localObject2 = ((QQAppInterface)localObject1).getRuntimeService(IApolloManagerService.class, "all");
          if (localObject2 != null)
          {
            localObject2 = ((ApolloManagerServiceImpl)localObject2).getApolloPanelManager();
            if (localObject2 == null) {
              continue;
            }
            ((ApolloPanelManager)localObject2).a = m;
            continue;
            localObject2 = ((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all");
            if (localObject2 != null)
            {
              localObject2 = (IApolloDaoManagerService)localObject2;
              localObject3 = new ApolloObtainedActionData();
              ((ApolloObtainedActionData)localObject3).id = i;
              ((ApolloObtainedActionData)localObject3).beginTs = NetConnInfoCenter.getServerTime();
              ((ApolloObtainedActionData)localObject3).type = 0;
              ((ApolloObtainedActionData)localObject3).way = 4;
              ((IApolloDaoManagerService)localObject2).insertObtainedActionData((ApolloObtainedActionData)localObject3);
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("jumpPkdId", j);
              ((Bundle)localObject2).putInt("jumpActionId", i);
              paramApolloRequestReceiveParams.notifyUI(9, true, localObject2);
              paramApolloRequestReceiveParams = new HashMap();
              ((Map)paramApolloRequestReceiveParams).put("APOLLO_POP_TYPE", "toast");
              localObject2 = (Map)paramApolloRequestReceiveParams;
              localObject3 = ((QQAppInterface)localObject1).getApp().getString(2131886684);
              Intrinsics.checkExpressionValueIsNotNull(localObject3, "app.getApp().getString(R…o_panel_gold_action_auth)");
              ((Map)localObject2).put("tips", localObject3);
              localObject1 = ((QQAppInterface)localObject1).getHandler(ChatActivity.class);
              Intrinsics.checkExpressionValueIsNotNull(localObject1, "app.getHandler(ChatActivity::class.java)");
              if (localObject1 != null)
              {
                localObject1 = ((MqqHandler)localObject1).obtainMessage(45);
                ((Message)localObject1).obj = paramApolloRequestReceiveParams;
                ((Message)localObject1).sendToTarget();
              }
              ApolloItemBuilder.a(HardCodeUtil.a(2131913253), 1, (Context)BaseApplicationImpl.getContext());
              return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService");
          }
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl");
        }
        QLog.d("[cmshow]ApolloRequestReceiver", 2, "handleBuyActionByGold error respBody is null");
        return;
      }
      catch (Exception paramApolloRequestReceiveParams)
      {
        QLog.e("[cmshow]ApolloRequestReceiver", 1, "handleBuyActionByGold failed", (Throwable)paramApolloRequestReceiveParams);
      }
      return;
    } while (k == 1);
  }
  
  @RequestRoute(a="apollo_core.set_status")
  public final void handleChangeApolloStatus(@NotNull ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Intrinsics.checkParameterIsNotNull(paramApolloRequestReceiveParams, "params");
    Object localObject1 = paramApolloRequestReceiveParams.c;
    Intent localIntent;
    Object localObject2;
    Object localObject3;
    long l1;
    if (localObject1 != null)
    {
      localIntent = paramApolloRequestReceiveParams.b;
      if (localIntent != null)
      {
        localObject2 = paramApolloRequestReceiveParams.a;
        if (localObject2 != null)
        {
          localObject3 = paramApolloRequestReceiveParams.e;
          if (localObject3 != null)
          {
            l1 = localIntent.getLongExtra("index", -1L);
            if (!((FromServiceMsg)localObject1).isSuccess()) {}
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject1).mergeFrom(paramApolloRequestReceiveParams.d);
        int i = localIntent.getIntExtra("apollo_status", 0);
        paramApolloRequestReceiveParams = new StringBuilder();
        paramApolloRequestReceiveParams.append("handleChangeApolloStatus ret: ");
        paramApolloRequestReceiveParams.append(((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get());
        paramApolloRequestReceiveParams.append(", apollo status:");
        paramApolloRequestReceiveParams.append(i);
        QLog.d("[cmshow]ApolloRequestReceiver", 1, paramApolloRequestReceiveParams.toString());
        paramApolloRequestReceiveParams = new Pair(((QQAppInterface)localObject2).getCurrentUin(), Integer.valueOf(i));
        if (0L == ((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get())
        {
          if (i != 0)
          {
            ((ApolloExtensionHandler)localObject3).notifyUI(3, true, paramApolloRequestReceiveParams);
            paramApolloRequestReceiveParams = ((QQAppInterface)localObject2).getRuntimeService(IApolloManagerService.class, "all");
            Intrinsics.checkExpressionValueIsNotNull(paramApolloRequestReceiveParams, "app.getRuntimeService(IA…ava, ProcessConstant.ALL)");
            paramApolloRequestReceiveParams = (IApolloManagerService)paramApolloRequestReceiveParams;
            localObject3 = ((QQAppInterface)localObject2).getRuntimeService(IApolloDaoManagerService.class, "all");
            Intrinsics.checkExpressionValueIsNotNull(localObject3, "app.getRuntimeService(IA…ava, ProcessConstant.ALL)");
            localObject2 = ((IApolloDaoManagerService)localObject3).getApolloBaseInfo(((QQAppInterface)localObject2).getCurrentUin());
            if (localObject2 == null) {
              break label442;
            }
            ((ApolloBaseInfo)localObject2).apolloStatus = i;
            paramApolloRequestReceiveParams.saveOrUpdateApolloBaseInfo((ApolloBaseInfo)localObject2);
          }
          else
          {
            ((ApolloExtensionHandler)localObject3).notifyUI(3, false, paramApolloRequestReceiveParams);
          }
        }
        else {
          ((ApolloExtensionHandler)localObject3).notifyUI(3, false, paramApolloRequestReceiveParams);
        }
        paramApolloRequestReceiveParams = ApolloRequestCallbackManager.a;
        if (((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get() != 0L) {
          break label443;
        }
        bool = true;
        long l2 = ((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get();
        localObject1 = ((WebSSOAgent.UniSsoServerRsp)localObject1).errmsg.get();
        try
        {
          paramApolloRequestReceiveParams.a(l1, bool, l2, (String)localObject1);
          return;
        }
        catch (Exception paramApolloRequestReceiveParams) {}
        QLog.e("[cmshow]ApolloRequestReceiver", 1, "handleChangeApolloStatus failed ", (Throwable)paramApolloRequestReceiveParams);
      }
      catch (Exception paramApolloRequestReceiveParams) {}
      ApolloRequestCallbackManager.a.a(l1, false, -1L, "exception");
      return;
      paramApolloRequestReceiveParams = new StringBuilder();
      paramApolloRequestReceiveParams.append("handleChangeApolloStatus fail ret: ");
      paramApolloRequestReceiveParams.append(((FromServiceMsg)localObject1).getResultCode());
      QLog.e("[cmshow]ApolloRequestReceiver", 1, paramApolloRequestReceiveParams.toString());
      ApolloRequestCallbackManager.a.a(l1, false, ((FromServiceMsg)localObject1).getResultCode(), ((FromServiceMsg)localObject1).getBusinessFailMsg());
      return;
      label442:
      return;
      label443:
      boolean bool = false;
    }
  }
  
  @RequestRoute(a="apollo_core.check_act")
  public final void handleCheckActionAuth(@NotNull ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Intrinsics.checkParameterIsNotNull(paramApolloRequestReceiveParams, "params");
    Object localObject2 = paramApolloRequestReceiveParams.c;
    if (localObject2 != null)
    {
      Object localObject1 = paramApolloRequestReceiveParams.b;
      if (localObject1 != null)
      {
        Object localObject3 = paramApolloRequestReceiveParams.d;
        if (localObject3 != null)
        {
          ApolloExtensionHandler localApolloExtensionHandler = paramApolloRequestReceiveParams.e;
          if (localApolloExtensionHandler != null)
          {
            int i = ((Intent)localObject1).getIntExtra("actionId", 0);
            paramApolloRequestReceiveParams = ((Intent)localObject1).getStringExtra("actionText");
            Object localObject4 = ((Intent)localObject1).getStringExtra("textType");
            String str = ((Intent)localObject1).getStringExtra("optFrom");
            int j = ((Intent)localObject1).getIntExtra("audioId", 0);
            float f = ((Intent)localObject1).getFloatExtra("audioTime", 0.0F);
            int k = ((Intent)localObject1).getIntExtra("isPlayDefultAudio", 0);
            localObject1 = new HashMap();
            Map localMap = (Map)localObject1;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(String.valueOf(i));
            localStringBuilder.append("");
            localMap.put("id", localStringBuilder.toString());
            Intrinsics.checkExpressionValueIsNotNull(paramApolloRequestReceiveParams, "actionText");
            localMap.put("actionText", paramApolloRequestReceiveParams);
            Intrinsics.checkExpressionValueIsNotNull(localObject4, "textType");
            localMap.put("textType", localObject4);
            Intrinsics.checkExpressionValueIsNotNull(str, "from");
            localMap.put("optFrom", str);
            paramApolloRequestReceiveParams = new StringBuilder();
            paramApolloRequestReceiveParams.append("");
            paramApolloRequestReceiveParams.append(j);
            localMap.put("audioId", paramApolloRequestReceiveParams.toString());
            paramApolloRequestReceiveParams = new StringBuilder();
            paramApolloRequestReceiveParams.append("");
            paramApolloRequestReceiveParams.append(f);
            localMap.put("audioTime", paramApolloRequestReceiveParams.toString());
            paramApolloRequestReceiveParams = new StringBuilder();
            paramApolloRequestReceiveParams.append("");
            paramApolloRequestReceiveParams.append(k);
            localMap.put("isPlayDefultAudio", paramApolloRequestReceiveParams.toString());
            if ((localObject3 != null) && (((FromServiceMsg)localObject2).isSuccess()))
            {
              try
              {
                localObject2 = new WebSSOAgent.UniSsoServerRsp();
                ((WebSSOAgent.UniSsoServerRsp)localObject2).mergeFrom((byte[])localObject3);
                if ((QLog.isColorLevel()) && (((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.has()))
                {
                  paramApolloRequestReceiveParams = new StringBuilder();
                  paramApolloRequestReceiveParams.append("handleCheckActionAuth ret: ");
                  paramApolloRequestReceiveParams.append(((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get());
                  paramApolloRequestReceiveParams.append(", msg: ");
                  paramApolloRequestReceiveParams.append(((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get());
                  QLog.d("[cmshow]ApolloRequestReceiver", 2, paramApolloRequestReceiveParams.toString());
                }
                paramApolloRequestReceiveParams = (Map)localObject1;
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append(String.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get()));
                ((StringBuilder)localObject3).append("");
                paramApolloRequestReceiveParams.put("ret", ((StringBuilder)localObject3).toString());
                long l = ((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get();
                if (0L == l) {}
                try
                {
                  localApolloExtensionHandler.notifyUI(5, true, localObject1);
                  return;
                }
                catch (Exception paramApolloRequestReceiveParams) {}
                paramApolloRequestReceiveParams = (ApolloRequestReceiveParams)localObject1;
                localObject2 = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get()).getJSONObject("data").getJSONObject("acresult");
                localObject3 = (Map)paramApolloRequestReceiveParams;
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append(String.valueOf(((JSONObject)localObject2).optInt("type")));
                ((StringBuilder)localObject4).append("");
                ((Map)localObject3).put("type", ((StringBuilder)localObject4).toString());
                localObject3 = (Map)paramApolloRequestReceiveParams;
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append(String.valueOf(((JSONObject)localObject2).optInt("id")));
                ((StringBuilder)localObject4).append("");
                ((Map)localObject3).put("id", ((StringBuilder)localObject4).toString());
                localObject3 = (Map)paramApolloRequestReceiveParams;
                localObject4 = ((JSONObject)localObject2).optString("msg");
                Intrinsics.checkExpressionValueIsNotNull(localObject4, "acresult.optString(\"msg\")");
                ((Map)localObject3).put("content", localObject4);
                localObject3 = (Map)paramApolloRequestReceiveParams;
                localObject2 = ((JSONObject)localObject2).optString("url");
                Intrinsics.checkExpressionValueIsNotNull(localObject2, "acresult.optString(\"url\")");
                ((Map)localObject3).put("url", localObject2);
                localApolloExtensionHandler.notifyUI(5, false, paramApolloRequestReceiveParams);
                return;
              }
              catch (Exception paramApolloRequestReceiveParams) {}
              QLog.e("[cmshow]ApolloRequestReceiver", 1, "handleChangeApolloStatus failed ", (Throwable)paramApolloRequestReceiveParams);
              localMap.put("ret", "-1");
              localApolloExtensionHandler.notifyUI(5, false, localObject1);
              return;
            }
            paramApolloRequestReceiveParams = new StringBuilder();
            paramApolloRequestReceiveParams.append(String.valueOf(((FromServiceMsg)localObject2).getResultCode()));
            paramApolloRequestReceiveParams.append("");
            localMap.put("ret", paramApolloRequestReceiveParams.toString());
            localApolloExtensionHandler.notifyUI(5, false, localObject1);
            paramApolloRequestReceiveParams = new StringBuilder();
            paramApolloRequestReceiveParams.append("handleChangeApolloStatus fail ret: ");
            paramApolloRequestReceiveParams.append(((FromServiceMsg)localObject2).getResultCode());
            QLog.e("[cmshow]ApolloRequestReceiver", 2, paramApolloRequestReceiveParams.toString());
          }
        }
      }
    }
  }
  
  @RequestRoute(a="apollo_motto.get_user_motto")
  public final void handleGetSignStr(@NotNull ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Intrinsics.checkParameterIsNotNull(paramApolloRequestReceiveParams, "params");
    Object localObject1 = paramApolloRequestReceiveParams.c;
    if (localObject1 != null)
    {
      Object localObject2 = paramApolloRequestReceiveParams.d;
      if (localObject2 != null)
      {
        paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.a;
        if (paramApolloRequestReceiveParams != null)
        {
          if ((localObject2 != null) && (((FromServiceMsg)localObject1).isSuccess())) {
            try
            {
              localObject1 = new WebSSOAgent.UniSsoServerRsp();
              ((WebSSOAgent.UniSsoServerRsp)localObject1).mergeFrom((byte[])localObject2);
              if (((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get() != 0L)
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("handleGetSignStr err  ret: ");
                ((StringBuilder)localObject2).append(((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get());
                QLog.d("[cmshow]ApolloRequestReceiver", 2, ((StringBuilder)localObject2).toString());
              }
              localObject2 = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject1).rspdata.get()).optJSONArray("data").optJSONObject(0);
              localObject1 = ((JSONObject)localObject2).optString("motto_content");
              Object localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(String.valueOf(((JSONObject)localObject2).optLong("uin")));
              ((StringBuilder)localObject3).append("");
              localObject2 = ((StringBuilder)localObject3).toString();
              paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.getRuntimeService(IApolloDaoManagerService.class, "all");
              Intrinsics.checkExpressionValueIsNotNull(paramApolloRequestReceiveParams, "app.getRuntimeService(IA…ava, ProcessConstant.ALL)");
              paramApolloRequestReceiveParams = (IApolloDaoManagerService)paramApolloRequestReceiveParams;
              localObject3 = paramApolloRequestReceiveParams.getApolloBaseInfo((String)localObject2);
              if (localObject3 != null)
              {
                ((ApolloBaseInfo)localObject3).apolloSignStr = ((String)localObject1);
                ((ApolloBaseInfo)localObject3).apolloLocalSignTs = ((ApolloBaseInfo)localObject3).apolloSignValidTS;
                paramApolloRequestReceiveParams.saveOrUpdateApolloBaseInfo((ApolloBaseInfo)localObject3);
              }
              paramApolloRequestReceiveParams = new StringBuilder();
              paramApolloRequestReceiveParams.append("handleGetSignStr uin: ");
              paramApolloRequestReceiveParams.append((String)localObject2);
              paramApolloRequestReceiveParams.append(", sign: ");
              paramApolloRequestReceiveParams.append((String)localObject1);
              QLog.d("[cmshow]ApolloRequestReceiver", 2, paramApolloRequestReceiveParams.toString());
              return;
            }
            catch (Exception paramApolloRequestReceiveParams)
            {
              QLog.e("[cmshow]ApolloRequestReceiver", 1, "handleGetSignStr error", (Throwable)paramApolloRequestReceiveParams);
              return;
            }
          }
          paramApolloRequestReceiveParams = new StringBuilder();
          paramApolloRequestReceiveParams.append("handleGetSignStr fail ret: ");
          paramApolloRequestReceiveParams.append(((FromServiceMsg)localObject1).getResultCode());
          QLog.e("[cmshow]ApolloRequestReceiver", 2, paramApolloRequestReceiveParams.toString());
        }
      }
    }
  }
  
  @RequestRoute(a="apollo_core.get_user_info_v2")
  public final void handleGetUserApolloInfo(@NotNull ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Intrinsics.checkParameterIsNotNull(paramApolloRequestReceiveParams, "params");
    Object localObject2 = paramApolloRequestReceiveParams.c;
    if (localObject2 != null)
    {
      Intent localIntent = paramApolloRequestReceiveParams.b;
      if (localIntent != null)
      {
        Object localObject3 = paramApolloRequestReceiveParams.d;
        if (localObject3 != null)
        {
          Object localObject1 = paramApolloRequestReceiveParams.a;
          if (localObject1 != null)
          {
            ApolloExtensionHandler localApolloExtensionHandler = paramApolloRequestReceiveParams.e;
            if (localApolloExtensionHandler != null)
            {
              paramApolloRequestReceiveParams = localIntent.getStringExtra("touin");
              long l = localIntent.getLongExtra("mask", 0L);
              if ((localObject3 != null) && (((FromServiceMsg)localObject2).isSuccess()) && (!TextUtils.isEmpty((CharSequence)paramApolloRequestReceiveParams))) {
                try
                {
                  localObject2 = new WebSSOAgent.UniSsoServerRsp();
                  ((WebSSOAgent.UniSsoServerRsp)localObject2).mergeFrom((byte[])localObject3);
                  if (QLog.isColorLevel())
                  {
                    localObject3 = new StringBuilder();
                    ((StringBuilder)localObject3).append("handleGetUserApolloInfo msg: ");
                    ((StringBuilder)localObject3).append(((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get());
                    ((StringBuilder)localObject3).append(", touin:");
                    ((StringBuilder)localObject3).append(paramApolloRequestReceiveParams);
                    ((StringBuilder)localObject3).append(", mask: ");
                    ((StringBuilder)localObject3).append(l);
                    QLog.d("[cmshow]ApolloRequestReceiver", 2, ((StringBuilder)localObject3).toString());
                  }
                  if (((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get() != 0L)
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append(", ret:");
                    ((StringBuilder)localObject1).append(((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get());
                    QLog.e("[cmshow]ApolloRequestReceiver", 1, new Object[] { "handleGetUserApolloInfo error, touin:", paramApolloRequestReceiveParams, ", mask:", Long.valueOf(l), ((StringBuilder)localObject1).toString() });
                    return;
                  }
                  Intrinsics.checkExpressionValueIsNotNull(paramApolloRequestReceiveParams, "touin");
                  a((QQAppInterface)localObject1, localApolloExtensionHandler, paramApolloRequestReceiveParams, (WebSSOAgent.UniSsoServerRsp)localObject2, l);
                  return;
                }
                catch (Exception paramApolloRequestReceiveParams)
                {
                  QLog.e("[cmshow]ApolloRequestReceiver", 1, "handleGetUserApolloInfo failed", (Throwable)paramApolloRequestReceiveParams);
                  return;
                }
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(", ret:");
              ((StringBuilder)localObject1).append(((FromServiceMsg)localObject2).getResultCode());
              QLog.e("[cmshow]ApolloRequestReceiver", 1, new Object[] { "handleGetUserApolloInfo fail, touin:", paramApolloRequestReceiveParams, ", mask:", Long.valueOf(l), ((StringBuilder)localObject1).toString() });
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.request.ApolloRequestReceiver
 * JD-Core Version:    0.7.0.1
 */