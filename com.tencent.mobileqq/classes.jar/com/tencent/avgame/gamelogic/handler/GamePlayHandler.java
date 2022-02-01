package com.tencent.avgame.gamelogic.handler;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.avgame.business.handler.AVGameBusinessHandler;
import com.tencent.avgame.business.observer.ObserverCenter;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.GameUtil;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.AnswerInfo;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameInfo;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.observer.GamePlayObserver;
import com.tencent.avgame.gameroom.festivalreport.CJSurvivalFestivalReporter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import trpc.qq_vgame.common.AvGameCommon.GameInfo;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.Result;
import trpc.qq_vgame.common.AvGameCommon.RoomUserInfo;
import trpc.qq_vgame.common.AvGameCommon.UserAnswerInfo;
import trpc.qq_vgame.game_ranking.AvGameRanking.GetRankingListReq;
import trpc.qq_vgame.game_ranking.AvGameRanking.GetRankingListRsp;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyActorGiveOutAnswerS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyAnswerFinishS2cReq;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyAnswerRightS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyChangeActorS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyChangeQuestionS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyGameOverS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyMsg;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyNextActorTipsS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyQuestionTimeoutS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyTranslateInfoS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.RoomOwnerStartGameS2CReq;
import trpc.qq_vgame.playgame.AvGamePlay.AnswerReq;
import trpc.qq_vgame.playgame.AvGamePlay.StartGameReq;
import trpc.qq_vgame.playgame.AvGamePlay.StartGameRsp;
import trpc.qq_vgame.question.AvGameQuestionInfo.CmdAnswerQuestionReq;
import trpc.qq_vgame.question.AvGameQuestionInfo.CmdAnswerQuestionRsp;
import trpc.qq_vgame.question.AvGameQuestionInfo.CmdGetQuestionReq;
import trpc.qq_vgame.question.AvGameQuestionInfo.CmdGetQuestionRsp;

public class GamePlayHandler
  extends AVGameBusinessHandler
{
  public GamePlayHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  @NotNull
  private String a()
  {
    return BaseApplicationImpl.getContext().getResources().getString(2131690380);
  }
  
  private String a(int paramInt)
  {
    return BaseApplicationImpl.getContext().getResources().getString(paramInt);
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, AvGameNotify.NotifyActorGiveOutAnswerS2CReq paramNotifyActorGiveOutAnswerS2CReq, long paramLong3)
  {
    String str = paramNotifyActorGiveOutAnswerS2CReq.tips.get();
    paramNotifyActorGiveOutAnswerS2CReq = GameUtil.b((AvGameCommon.GameQuestionInfo)paramNotifyActorGiveOutAnswerS2CReq.question_info.get(), false);
    ObserverCenter.a().b(GamePlayObserver.class, 9, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, str, paramNotifyActorGiveOutAnswerS2CReq, Long.valueOf(paramLong3) });
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, AvGameNotify.NotifyAnswerFinishS2cReq paramNotifyAnswerFinishS2cReq, long paramLong3)
  {
    Object localObject = paramNotifyAnswerFinishS2cReq.user_answer_info.get();
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AvGameCommon.UserAnswerInfo localUserAnswerInfo = (AvGameCommon.UserAnswerInfo)((Iterator)localObject).next();
        AnswerInfo localAnswerInfo = new AnswerInfo();
        localAnswerInfo.parseFrom(localUserAnswerInfo);
        localArrayList.add(localAnswerInfo);
      }
    }
    localObject = GameUtil.b((AvGameCommon.GameQuestionInfo)paramNotifyAnswerFinishS2cReq.next_question_info.get(), false);
    int i = paramNotifyAnswerFinishS2cReq.score.get();
    ObserverCenter.a().a(GamePlayObserver.class, 15, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, localArrayList, localObject, Integer.valueOf(i), Long.valueOf(paramLong3) });
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, AvGameNotify.NotifyAnswerRightS2CReq paramNotifyAnswerRightS2CReq, long paramLong3)
  {
    ITopic localITopic = GameUtil.b((AvGameCommon.GameQuestionInfo)paramNotifyAnswerRightS2CReq.question_info.get(), false);
    Object localObject = paramNotifyAnswerRightS2CReq.actor_info;
    Player localPlayer = new Player();
    localPlayer.parseFrom((AvGameCommon.RoomUserInfo)localObject);
    int i = paramNotifyAnswerRightS2CReq.score.get();
    int j = paramNotifyAnswerRightS2CReq.actor_score.get();
    long l = paramNotifyAnswerRightS2CReq.continue_correct_num.get();
    paramNotifyAnswerRightS2CReq = (AvGameCommon.UserAnswerInfo)paramNotifyAnswerRightS2CReq.user_answer_info.get();
    localObject = new AnswerInfo();
    ((AnswerInfo)localObject).parseFrom(paramNotifyAnswerRightS2CReq);
    ObserverCenter.a().b(GamePlayObserver.class, 7, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, Integer.valueOf(i), Integer.valueOf(j), localITopic, localPlayer, Long.valueOf(l), localObject, Long.valueOf(paramLong3) });
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, AvGameNotify.NotifyChangeActorS2CReq paramNotifyChangeActorS2CReq, long paramLong3)
  {
    ITopic localITopic = GameUtil.b((AvGameCommon.GameQuestionInfo)paramNotifyChangeActorS2CReq.question_info.get(), false);
    paramNotifyChangeActorS2CReq = paramNotifyChangeActorS2CReq.actor_info;
    Player localPlayer = new Player();
    localPlayer.parseFrom(paramNotifyChangeActorS2CReq);
    ObserverCenter.a().b(GamePlayObserver.class, 4, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, localITopic, localPlayer, Long.valueOf(paramLong3) });
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, AvGameNotify.NotifyChangeQuestionS2CReq paramNotifyChangeQuestionS2CReq, long paramLong3)
  {
    ITopic localITopic = GameUtil.b((AvGameCommon.GameQuestionInfo)paramNotifyChangeQuestionS2CReq.question_info.get(), false);
    long l = paramNotifyChangeQuestionS2CReq.switcher_uin.get();
    if (localITopic != null) {
      localITopic.a(l);
    }
    Object localObject = null;
    paramNotifyChangeQuestionS2CReq = localObject;
    if (l > 0L) {}
    try
    {
      paramNotifyChangeQuestionS2CReq = Long.toString(l);
      ObserverCenter.a().b(GamePlayObserver.class, 5, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, localITopic, paramNotifyChangeQuestionS2CReq, Long.valueOf(paramLong3) });
      return;
    }
    catch (Exception paramNotifyChangeQuestionS2CReq)
    {
      for (;;)
      {
        paramNotifyChangeQuestionS2CReq = localObject;
      }
    }
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, AvGameNotify.NotifyGameOverS2CReq paramNotifyGameOverS2CReq, long paramLong3)
  {
    ObserverCenter.a().b(GamePlayObserver.class, 3, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, Long.valueOf(paramLong3) });
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, AvGameNotify.NotifyNextActorTipsS2CReq paramNotifyNextActorTipsS2CReq, long paramLong3)
  {
    String str = paramNotifyNextActorTipsS2CReq.tips.get();
    paramNotifyNextActorTipsS2CReq = paramNotifyNextActorTipsS2CReq.actor_info;
    Player localPlayer = new Player();
    localPlayer.parseFrom(paramNotifyNextActorTipsS2CReq);
    ObserverCenter.a().b(GamePlayObserver.class, 6, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, str, localPlayer, Long.valueOf(paramLong3) });
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, AvGameNotify.NotifyQuestionTimeoutS2CReq paramNotifyQuestionTimeoutS2CReq, long paramLong3)
  {
    paramNotifyQuestionTimeoutS2CReq = GameUtil.b((AvGameCommon.GameQuestionInfo)paramNotifyQuestionTimeoutS2CReq.question_info.get(), false);
    ObserverCenter.a().b(GamePlayObserver.class, 8, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, paramNotifyQuestionTimeoutS2CReq, Long.valueOf(paramLong3) });
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, AvGameNotify.NotifyTranslateInfoS2CReq paramNotifyTranslateInfoS2CReq, long paramLong3)
  {
    long l = paramNotifyTranslateInfoS2CReq.uin.get();
    int i = paramNotifyTranslateInfoS2CReq.trans_cost_time.get();
    String str = paramNotifyTranslateInfoS2CReq.play_game_id.get();
    paramNotifyTranslateInfoS2CReq = paramNotifyTranslateInfoS2CReq.answer.get();
    ObserverCenter.a().a(GamePlayObserver.class, 12, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, Long.valueOf(l), Integer.valueOf(i), str, paramNotifyTranslateInfoS2CReq, Long.valueOf(paramLong3) });
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, AvGameNotify.RoomOwnerStartGameS2CReq paramRoomOwnerStartGameS2CReq, long paramLong3)
  {
    Object localObject1 = (AvGameCommon.RoomUserInfo)paramRoomOwnerStartGameS2CReq.actor_info.get();
    Object localObject2 = (AvGameCommon.GameQuestionInfo)paramRoomOwnerStartGameS2CReq.question_info.get();
    AvGameCommon.GameInfo localGameInfo = (AvGameCommon.GameInfo)paramRoomOwnerStartGameS2CReq.game_info.get();
    localObject2 = GameUtil.b((AvGameCommon.GameQuestionInfo)localObject2, false);
    if (localObject2 == null)
    {
      QLog.d("avgame_logic.GamePlayHandler", 1, "handleGameStartPush topic=null return");
      return;
    }
    Player localPlayer = new Player();
    localPlayer.parseFrom((AvGameCommon.RoomUserInfo)localObject1);
    localObject1 = new GameInfo();
    ((GameInfo)localObject1).a(localGameInfo);
    if (paramRoomOwnerStartGameS2CReq.question_class.has()) {
      ((GameInfo)localObject1).a = paramRoomOwnerStartGameS2CReq.question_class.get();
    }
    ObserverCenter.a().b(GamePlayObserver.class, 2, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, localObject1, localPlayer, localObject2, Long.valueOf(paramLong3) });
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 270	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 271
    //   7: ldc_w 273
    //   10: invokevirtual 278	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   13: astore 13
    //   15: aload_1
    //   16: getfield 270	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   19: ldc_w 280
    //   22: invokevirtual 284	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   25: lstore 7
    //   27: aload_1
    //   28: getfield 270	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   31: ldc_w 286
    //   34: invokevirtual 290	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   37: istore 6
    //   39: aload_1
    //   40: getfield 270	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   43: ldc_w 292
    //   46: ldc_w 273
    //   49: invokevirtual 278	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 15
    //   54: ldc_w 293
    //   57: istore 5
    //   59: ldc_w 273
    //   62: astore 11
    //   64: new 295	com/tencent/avgame/gamelogic/data/RoomInfo
    //   67: dup
    //   68: invokespecial 296	com/tencent/avgame/gamelogic/data/RoomInfo:<init>	()V
    //   71: astore 14
    //   73: aload_2
    //   74: invokevirtual 301	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   77: ifeq +507 -> 584
    //   80: new 303	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp
    //   83: dup
    //   84: invokespecial 304	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp:<init>	()V
    //   87: astore 16
    //   89: aload 16
    //   91: aload_3
    //   92: checkcast 306	[B
    //   95: checkcast 306	[B
    //   98: invokevirtual 310	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   101: pop
    //   102: aload 16
    //   104: getfield 314	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp:res	Ltrpc/qq_vgame/common/AvGameCommon$Result;
    //   107: invokevirtual 317	trpc/qq_vgame/common/AvGameCommon$Result:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   110: checkcast 316	trpc/qq_vgame/common/AvGameCommon$Result
    //   113: getfield 320	trpc/qq_vgame/common/AvGameCommon$Result:errcode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   116: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   119: istore 4
    //   121: aload 16
    //   123: getfield 314	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp:res	Ltrpc/qq_vgame/common/AvGameCommon$Result;
    //   126: invokevirtual 317	trpc/qq_vgame/common/AvGameCommon$Result:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   129: checkcast 316	trpc/qq_vgame/common/AvGameCommon$Result
    //   132: getfield 324	trpc/qq_vgame/common/AvGameCommon$Result:errmsg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   135: invokevirtual 329	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   138: invokevirtual 334	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   141: astore_1
    //   142: aload 14
    //   144: aload 16
    //   146: getfield 338	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp:room_info	Ltrpc/qq_vgame/common/AvGameCommon$RoomInfo;
    //   149: invokevirtual 341	com/tencent/avgame/gamelogic/data/RoomInfo:parseFrom	(Ltrpc/qq_vgame/common/AvGameCommon$RoomInfo;)V
    //   152: aload 16
    //   154: getfield 344	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp:low_version_users	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   157: invokevirtual 345	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   160: ifeq +419 -> 579
    //   163: aload 16
    //   165: getfield 344	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp:low_version_users	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   168: invokevirtual 89	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   171: astore 11
    //   173: new 91	java/util/ArrayList
    //   176: dup
    //   177: aload 11
    //   179: invokeinterface 348 1 0
    //   184: invokespecial 351	java/util/ArrayList:<init>	(I)V
    //   187: astore_3
    //   188: aload 11
    //   190: invokeinterface 100 1 0
    //   195: astore 11
    //   197: aload 11
    //   199: invokeinterface 106 1 0
    //   204: ifeq +268 -> 472
    //   207: aload_3
    //   208: aload 11
    //   210: invokeinterface 110 1 0
    //   215: checkcast 227	trpc/qq_vgame/common/AvGameCommon$RoomUserInfo
    //   218: getfield 352	trpc/qq_vgame/common/AvGameCommon$RoomUserInfo:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   221: invokevirtual 169	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   224: invokestatic 74	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   227: invokeinterface 123 2 0
    //   232: pop
    //   233: goto -36 -> 197
    //   236: astore 11
    //   238: aload_3
    //   239: astore 12
    //   241: aload_1
    //   242: astore_3
    //   243: aload 12
    //   245: astore_1
    //   246: ldc 238
    //   248: iconst_1
    //   249: new 354	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   256: ldc_w 357
    //   259: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload 11
    //   264: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 366	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 369	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: aload_1
    //   274: astore 11
    //   276: aload_3
    //   277: astore_1
    //   278: aload 11
    //   280: astore_3
    //   281: ldc 238
    //   283: ldc_w 371
    //   286: aconst_null
    //   287: iconst_1
    //   288: anewarray 373	com/tencent/mobileqq/pb/MessageMicro
    //   291: dup
    //   292: iconst_0
    //   293: aload 16
    //   295: aastore
    //   296: invokestatic 376	com/tencent/avgame/gamelogic/GameUtil:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   299: iload 4
    //   301: ifne +272 -> 573
    //   304: aload_0
    //   305: aload 13
    //   307: lload 7
    //   309: iload 6
    //   311: aload 15
    //   313: aload 16
    //   315: invokespecial 379	com/tencent/avgame/gamelogic/handler/GamePlayHandler:a	(Ljava/lang/String;JILjava/lang/String;Ltrpc/qq_vgame/playgame/AvGamePlay$StartGameRsp;)Z
    //   318: istore 9
    //   320: iload 9
    //   322: istore 10
    //   324: iload 4
    //   326: istore 5
    //   328: iload 9
    //   330: ifne +86 -> 416
    //   333: aload_1
    //   334: astore 11
    //   336: aload_1
    //   337: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   340: ifeq +9 -> 349
    //   343: aload_0
    //   344: invokespecial 387	com/tencent/avgame/gamelogic/handler/GamePlayHandler:a	()Ljava/lang/String;
    //   347: astore 11
    //   349: invokestatic 64	com/tencent/avgame/business/observer/ObserverCenter:a	()Lcom/tencent/avgame/business/observer/ObserverCenter;
    //   352: ldc 66
    //   354: iconst_0
    //   355: iconst_0
    //   356: bipush 7
    //   358: anewarray 68	java/lang/Object
    //   361: dup
    //   362: iconst_0
    //   363: aload 13
    //   365: aastore
    //   366: dup
    //   367: iconst_1
    //   368: lload 7
    //   370: invokestatic 74	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   373: aastore
    //   374: dup
    //   375: iconst_2
    //   376: iload 6
    //   378: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   381: aastore
    //   382: dup
    //   383: iconst_3
    //   384: iload 4
    //   386: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   389: aastore
    //   390: dup
    //   391: iconst_4
    //   392: aload 11
    //   394: aastore
    //   395: dup
    //   396: iconst_5
    //   397: aload 14
    //   399: aastore
    //   400: dup
    //   401: bipush 6
    //   403: aload_3
    //   404: aastore
    //   405: invokevirtual 77	com/tencent/avgame/business/observer/ObserverCenter:b	(Ljava/lang/Class;IZLjava/lang/Object;)V
    //   408: iload 4
    //   410: istore 5
    //   412: iload 9
    //   414: istore 10
    //   416: ldc 238
    //   418: iconst_1
    //   419: bipush 6
    //   421: anewarray 68	java/lang/Object
    //   424: dup
    //   425: iconst_0
    //   426: ldc_w 389
    //   429: aastore
    //   430: dup
    //   431: iconst_1
    //   432: iload 10
    //   434: invokestatic 394	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   437: aastore
    //   438: dup
    //   439: iconst_2
    //   440: ldc_w 396
    //   443: aastore
    //   444: dup
    //   445: iconst_3
    //   446: aload_2
    //   447: invokevirtual 301	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   450: invokestatic 394	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   453: aastore
    //   454: dup
    //   455: iconst_4
    //   456: ldc_w 398
    //   459: aastore
    //   460: dup
    //   461: iconst_5
    //   462: iload 5
    //   464: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   467: aastore
    //   468: invokestatic 401	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   471: return
    //   472: goto -191 -> 281
    //   475: astore_1
    //   476: aconst_null
    //   477: astore_1
    //   478: ldc_w 293
    //   481: istore 4
    //   483: aload 11
    //   485: astore_3
    //   486: aload_3
    //   487: astore 11
    //   489: aload_1
    //   490: astore_3
    //   491: aload 11
    //   493: astore_1
    //   494: goto -213 -> 281
    //   497: astore_1
    //   498: aconst_null
    //   499: astore_1
    //   500: aload 11
    //   502: astore_3
    //   503: goto -17 -> 486
    //   506: astore_3
    //   507: aconst_null
    //   508: astore 11
    //   510: aload_1
    //   511: astore_3
    //   512: aload 11
    //   514: astore_1
    //   515: goto -29 -> 486
    //   518: astore 11
    //   520: aload_1
    //   521: astore 11
    //   523: aload_3
    //   524: astore_1
    //   525: aload 11
    //   527: astore_3
    //   528: goto -42 -> 486
    //   531: astore 12
    //   533: aconst_null
    //   534: astore_1
    //   535: ldc_w 293
    //   538: istore 4
    //   540: aload 11
    //   542: astore_3
    //   543: aload 12
    //   545: astore 11
    //   547: goto -301 -> 246
    //   550: astore 12
    //   552: aconst_null
    //   553: astore_1
    //   554: aload 11
    //   556: astore_3
    //   557: aload 12
    //   559: astore 11
    //   561: goto -315 -> 246
    //   564: astore 11
    //   566: aload_1
    //   567: astore_3
    //   568: aconst_null
    //   569: astore_1
    //   570: goto -324 -> 246
    //   573: iconst_0
    //   574: istore 9
    //   576: goto -256 -> 320
    //   579: aconst_null
    //   580: astore_3
    //   581: goto -109 -> 472
    //   584: iconst_0
    //   585: istore 10
    //   587: goto -171 -> 416
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	590	0	this	GamePlayHandler
    //   0	590	1	paramToServiceMsg	ToServiceMsg
    //   0	590	2	paramFromServiceMsg	FromServiceMsg
    //   0	590	3	paramObject	Object
    //   119	420	4	i	int
    //   57	406	5	j	int
    //   37	340	6	k	int
    //   25	344	7	l	long
    //   318	257	9	bool1	boolean
    //   322	264	10	bool2	boolean
    //   62	147	11	localObject1	Object
    //   236	27	11	localInvalidProtocolBufferMicroException1	InvalidProtocolBufferMicroException
    //   274	239	11	localObject2	Object
    //   518	1	11	localException	Exception
    //   521	39	11	localObject3	Object
    //   564	1	11	localInvalidProtocolBufferMicroException2	InvalidProtocolBufferMicroException
    //   239	5	12	localObject4	Object
    //   531	13	12	localInvalidProtocolBufferMicroException3	InvalidProtocolBufferMicroException
    //   550	8	12	localInvalidProtocolBufferMicroException4	InvalidProtocolBufferMicroException
    //   13	351	13	str1	String
    //   71	327	14	localRoomInfo	com.tencent.avgame.gamelogic.data.RoomInfo
    //   52	260	15	str2	String
    //   87	227	16	localStartGameRsp	AvGamePlay.StartGameRsp
    // Exception table:
    //   from	to	target	type
    //   188	197	236	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   197	233	236	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   89	121	475	java/lang/Exception
    //   121	142	497	java/lang/Exception
    //   142	188	506	java/lang/Exception
    //   188	197	518	java/lang/Exception
    //   197	233	518	java/lang/Exception
    //   89	121	531	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   121	142	550	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   142	188	564	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (((Boolean)paramToServiceMsg.getAttribute("fromVoice", Boolean.valueOf(false))).booleanValue())
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramArrayOfByte);
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramArrayOfByte);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    String str = paramToServiceMsg.extraData.getString("gameId");
    long l1 = paramToServiceMsg.extraData.getLong("roomId");
    boolean bool = false;
    int i = -2147483648;
    paramToServiceMsg = "";
    ToServiceMsg localToServiceMsg = paramToServiceMsg;
    int j = i;
    int k;
    if (paramFromServiceMsg.isSuccess())
    {
      AvGameQuestionInfo.CmdGetQuestionRsp localCmdGetQuestionRsp = new AvGameQuestionInfo.CmdGetQuestionRsp();
      j = i;
      k = i;
      try
      {
        localCmdGetQuestionRsp.mergeFrom(paramArrayOfByte);
        j = i;
        k = i;
        i = ((AvGameCommon.Result)localCmdGetQuestionRsp.res.get()).errcode.get();
        j = i;
        k = i;
        paramArrayOfByte = ((AvGameCommon.Result)localCmdGetQuestionRsp.res.get()).errmsg.get().toStringUtf8();
        paramToServiceMsg = paramArrayOfByte;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          long l2;
          QLog.e("avgame_logic.GamePlayHandler", 1, paramString + ":" + paramArrayOfByte);
          i = j;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          i = k;
          continue;
          bool = false;
          continue;
          paramToServiceMsg = null;
          continue;
          paramToServiceMsg = a(2131690560);
          continue;
          paramToServiceMsg = a(2131690559);
          continue;
          bool = false;
        }
      }
      GameUtil.a("avgame_logic.GamePlayHandler", paramString, new String[] { "rsp" }, new MessageMicro[] { localCmdGetQuestionRsp });
      localToServiceMsg = paramToServiceMsg;
      j = i;
      if (i == 0) {
        if (paramInt == 13)
        {
          bool = true;
          paramArrayOfByte = GameUtil.b((AvGameCommon.GameQuestionInfo)localCmdGetQuestionRsp.question_info.get(), bool);
          l2 = localCmdGetQuestionRsp.seq.get();
          if (paramArrayOfByte == null) {
            break label552;
          }
          bool = true;
          ObserverCenter.a().b(GamePlayObserver.class, paramInt, true, new Object[] { Long.valueOf(l1), str, Long.valueOf(l2), paramArrayOfByte });
          if (QLog.isColorLevel()) {
            QLog.i("avgame_logic.GamePlayHandler", 2, String.format("%s topic=%s", new Object[] { paramString, paramArrayOfByte }));
          }
        }
      }
    }
    for (;;)
    {
      if (!bool)
      {
        if (paramInt == 1)
        {
          if (i != 202) {
            break label541;
          }
          if (str != null)
          {
            paramToServiceMsg = str.split("_");
            if ((paramToServiceMsg == null) || (paramToServiceMsg.length < 3) || (!String.valueOf(2).equalsIgnoreCase(paramToServiceMsg[1]))) {
              break label530;
            }
            paramToServiceMsg = a(2131690493);
          }
        }
        else
        {
          ObserverCenter.a().b(GamePlayObserver.class, paramInt, false, new Object[] { Long.valueOf(l1), str, paramToServiceMsg });
        }
      }
      else
      {
        QLog.d("avgame_logic.GamePlayHandler", 1, new Object[] { paramString, " suc=", Boolean.valueOf(bool), " rspResult=", Boolean.valueOf(paramFromServiceMsg.isSuccess()), " errCode=", Integer.valueOf(i), " roomId=", Long.valueOf(l1), " gameId=", str });
        return;
      }
      label530:
      label541:
      label552:
      paramToServiceMsg = localToServiceMsg;
      i = j;
    }
  }
  
  private void a(String paramString1, long paramLong, String paramString2, int paramInt, String paramString3)
  {
    AvGameQuestionInfo.CmdGetQuestionReq localCmdGetQuestionReq = new AvGameQuestionInfo.CmdGetQuestionReq();
    localCmdGetQuestionReq.play_game_id.set(paramString2);
    localCmdGetQuestionReq.uin.set(Long.parseLong(paramString1));
    localCmdGetQuestionReq.req_src.set(0);
    localCmdGetQuestionReq.req_type.set(paramInt);
    paramString1 = createToServiceMsg("qqvgame.QuestionManager-GetQuestion");
    paramString1.extraData.putString("gameId", paramString2);
    paramString1.extraData.putLong("roomId", paramLong);
    paramString1.extraData.putInt("reqType", paramInt);
    paramString1.putWupBuffer(localCmdGetQuestionReq.toByteArray());
    sendPbReq(paramString1);
    QLog.d("avgame_logic.GamePlayHandler", 1, String.format("%s reqType=%d roomId=%d gameId=%s", new Object[] { paramString3, Integer.valueOf(paramInt), Long.valueOf(paramLong), paramString2 }));
  }
  
  private boolean a(String paramString1, long paramLong, int paramInt, String paramString2, AvGamePlay.StartGameRsp paramStartGameRsp)
  {
    long l = paramStartGameRsp.seq.get();
    String str = paramStartGameRsp.play_game_id.get();
    Object localObject = (AvGameCommon.RoomUserInfo)paramStartGameRsp.actor_info.get();
    AvGameCommon.GameInfo localGameInfo = (AvGameCommon.GameInfo)paramStartGameRsp.game_info.get();
    AvGameCommon.GameQuestionInfo localGameQuestionInfo = (AvGameCommon.GameQuestionInfo)paramStartGameRsp.question_info.get();
    paramStartGameRsp = new Player();
    paramStartGameRsp.parseFrom((AvGameCommon.RoomUserInfo)localObject);
    localObject = new GameInfo();
    ((GameInfo)localObject).a(localGameInfo);
    ((GameInfo)localObject).a = paramString2;
    int i = paramInt;
    if (paramInt <= 0) {
      i = GameUtil.a(localGameInfo.type.get());
    }
    paramString2 = GameUtil.b(localGameQuestionInfo, false);
    if (paramString2 == null)
    {
      QLog.d("avgame_logic.GamePlayHandler", 1, "onHandleStartGameReq topic=null return");
      return false;
    }
    ObserverCenter.a().b(GamePlayObserver.class, 0, true, new Object[] { paramString1, Long.valueOf(paramLong), Integer.valueOf(i), Long.valueOf(l), str, localObject, paramStartGameRsp, paramString2 });
    return true;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1 = paramToServiceMsg.extraData.getString("gameId");
    String str2 = paramToServiceMsg.extraData.getString("uin");
    int k = -2147483648;
    int i;
    int j;
    boolean bool;
    if (paramFromServiceMsg.isSuccess())
    {
      AvGameRanking.GetRankingListRsp localGetRankingListRsp = new AvGameRanking.GetRankingListRsp();
      i = k;
      j = k;
      try
      {
        localGetRankingListRsp.mergeFrom((byte[])paramObject);
        i = k;
        j = k;
        k = ((AvGameCommon.Result)localGetRankingListRsp.res.get()).errcode.get();
        i = k;
        j = k;
        paramToServiceMsg = ((AvGameCommon.Result)localGetRankingListRsp.res.get()).errmsg.get().toStringUtf8();
        i = k;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          QLog.e("avgame_logic.GamePlayHandler", 1, "handleGetRankingListReq:" + paramToServiceMsg);
          paramToServiceMsg = "";
        }
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          i = j;
          paramToServiceMsg = "";
          continue;
          bool = false;
        }
      }
      GameUtil.a("avgame_logic.GamePlayHandler", "handleGetRankingListReq", new String[] { "rsp" }, new MessageMicro[] { localGetRankingListRsp });
      if (i == 0)
      {
        bool = true;
        paramObject = GameUtil.a(localGetRankingListRsp);
        ObserverCenter.a().b(GamePlayObserver.class, 10, true, new Object[] { str2, str1, paramObject });
      }
    }
    for (;;)
    {
      if (!bool)
      {
        paramObject = paramToServiceMsg;
        if (TextUtils.isEmpty(paramToServiceMsg)) {
          paramObject = a();
        }
        ObserverCenter.a().b(GamePlayObserver.class, 10, false, new Object[] { str2, str1, paramObject });
      }
      QLog.d("avgame_logic.GamePlayHandler", 1, new Object[] { "handleGetRankingListReq suc=", Boolean.valueOf(bool), " rspResult=", Boolean.valueOf(paramFromServiceMsg.isSuccess()), " errCode=", Integer.valueOf(i), " gameId=", str1 });
      return;
      paramToServiceMsg = "";
      i = -2147483648;
      bool = false;
    }
  }
  
  /* Error */
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 562
    //   4: invokevirtual 565	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   7: checkcast 429	java/lang/String
    //   10: astore_1
    //   11: invokestatic 438	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +42 -> 56
    //   17: ldc 238
    //   19: iconst_2
    //   20: new 354	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 567
    //   30: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 569
    //   40: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_2
    //   44: invokevirtual 572	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   47: invokevirtual 575	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: invokevirtual 366	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_2
    //   57: invokevirtual 301	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   60: ifeq +219 -> 279
    //   63: new 577	trpc/qq_vgame/playgame/AvGamePlay$AnswerRsp
    //   66: dup
    //   67: invokespecial 578	trpc/qq_vgame/playgame/AvGamePlay$AnswerRsp:<init>	()V
    //   70: astore_1
    //   71: aload_1
    //   72: aload_3
    //   73: invokevirtual 579	trpc/qq_vgame/playgame/AvGamePlay$AnswerRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   76: pop
    //   77: ldc 238
    //   79: ldc_w 581
    //   82: aconst_null
    //   83: iconst_1
    //   84: anewarray 373	com/tencent/mobileqq/pb/MessageMicro
    //   87: dup
    //   88: iconst_0
    //   89: aload_1
    //   90: aastore
    //   91: invokestatic 376	com/tencent/avgame/gamelogic/GameUtil:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   94: aload_1
    //   95: getfield 582	trpc/qq_vgame/playgame/AvGamePlay$AnswerRsp:res	Ltrpc/qq_vgame/common/AvGameCommon$Result;
    //   98: invokevirtual 317	trpc/qq_vgame/common/AvGameCommon$Result:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   101: checkcast 316	trpc/qq_vgame/common/AvGameCommon$Result
    //   104: getfield 320	trpc/qq_vgame/common/AvGameCommon$Result:errcode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   107: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   110: istore 4
    //   112: aload_1
    //   113: getfield 582	trpc/qq_vgame/playgame/AvGamePlay$AnswerRsp:res	Ltrpc/qq_vgame/common/AvGameCommon$Result;
    //   116: invokevirtual 317	trpc/qq_vgame/common/AvGameCommon$Result:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   119: checkcast 316	trpc/qq_vgame/common/AvGameCommon$Result
    //   122: getfield 324	trpc/qq_vgame/common/AvGameCommon$Result:errmsg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   125: invokevirtual 329	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   128: invokevirtual 334	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   131: astore_2
    //   132: aload_1
    //   133: getfield 585	trpc/qq_vgame/playgame/AvGamePlay$AnswerRsp:answer_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   136: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   139: istore 5
    //   141: aload_1
    //   142: getfield 588	trpc/qq_vgame/playgame/AvGamePlay$AnswerRsp:right_answer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   145: invokevirtual 44	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   148: astore_3
    //   149: aload_1
    //   150: getfield 589	trpc/qq_vgame/playgame/AvGamePlay$AnswerRsp:score	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   153: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   156: istore 6
    //   158: invokestatic 64	com/tencent/avgame/business/observer/ObserverCenter:a	()Lcom/tencent/avgame/business/observer/ObserverCenter;
    //   161: astore_1
    //   162: iload 5
    //   164: iconst_1
    //   165: if_icmpne +52 -> 217
    //   168: iconst_1
    //   169: istore 7
    //   171: aload_1
    //   172: ldc 66
    //   174: bipush 14
    //   176: iconst_1
    //   177: iconst_5
    //   178: anewarray 68	java/lang/Object
    //   181: dup
    //   182: iconst_0
    //   183: iload 4
    //   185: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   188: aastore
    //   189: dup
    //   190: iconst_1
    //   191: aload_2
    //   192: aastore
    //   193: dup
    //   194: iconst_2
    //   195: iload 7
    //   197: invokestatic 394	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   200: aastore
    //   201: dup
    //   202: iconst_3
    //   203: aload_3
    //   204: aastore
    //   205: dup
    //   206: iconst_4
    //   207: iload 6
    //   209: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: invokevirtual 77	com/tencent/avgame/business/observer/ObserverCenter:b	(Ljava/lang/Class;IZLjava/lang/Object;)V
    //   216: return
    //   217: iconst_0
    //   218: istore 7
    //   220: goto -49 -> 171
    //   223: astore_1
    //   224: ldc 238
    //   226: iconst_1
    //   227: new 354	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   234: ldc_w 591
    //   237: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_1
    //   241: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 366	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 369	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: return
    //   251: astore_1
    //   252: ldc 238
    //   254: iconst_1
    //   255: new 354	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   262: ldc_w 593
    //   265: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_1
    //   269: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 366	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 369	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: return
    //   279: invokestatic 64	com/tencent/avgame/business/observer/ObserverCenter:a	()Lcom/tencent/avgame/business/observer/ObserverCenter;
    //   282: ldc 66
    //   284: bipush 14
    //   286: iconst_0
    //   287: iconst_5
    //   288: anewarray 68	java/lang/Object
    //   291: dup
    //   292: iconst_0
    //   293: ldc_w 293
    //   296: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   299: aastore
    //   300: dup
    //   301: iconst_1
    //   302: ldc_w 273
    //   305: aastore
    //   306: dup
    //   307: iconst_2
    //   308: iconst_0
    //   309: invokestatic 394	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   312: aastore
    //   313: dup
    //   314: iconst_3
    //   315: ldc_w 273
    //   318: aastore
    //   319: dup
    //   320: iconst_4
    //   321: iconst_0
    //   322: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   325: aastore
    //   326: invokevirtual 77	com/tencent/avgame/business/observer/ObserverCenter:b	(Ljava/lang/Class;IZLjava/lang/Object;)V
    //   329: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	this	GamePlayHandler
    //   0	330	1	paramToServiceMsg	ToServiceMsg
    //   0	330	2	paramFromServiceMsg	FromServiceMsg
    //   0	330	3	paramArrayOfByte	byte[]
    //   110	74	4	i	int
    //   139	27	5	j	int
    //   156	52	6	k	int
    //   169	50	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   71	162	223	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   171	216	223	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   71	162	251	java/lang/Exception
    //   171	216	251	java/lang/Exception
  }
  
  private void b(String paramString1, int paramInt, String paramString2, long paramLong, String paramString3)
  {
    AvGameQuestionInfo.CmdAnswerQuestionReq localCmdAnswerQuestionReq = new AvGameQuestionInfo.CmdAnswerQuestionReq();
    localCmdAnswerQuestionReq.uin.set(Long.parseLong(paramString2));
    localCmdAnswerQuestionReq.play_game_id.set(paramString3);
    localCmdAnswerQuestionReq.answer.set(paramString1);
    localCmdAnswerQuestionReq.trans_mod.set(7);
    localCmdAnswerQuestionReq.trans_cost.set(paramInt);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.QuestionManager-AnswerQuestion");
    localToServiceMsg.extraData.putString("gameId", paramString3);
    localToServiceMsg.extraData.putLong("roomId", paramLong);
    localToServiceMsg.putWupBuffer(localCmdAnswerQuestionReq.toByteArray());
    sendPbReq(localToServiceMsg);
    QLog.i("avgame_logic.GamePlayHandler", 1, "sendAnswerQuestionReq. answer = " + paramString1 + ", recogTimeLen = " + paramInt + ", uin = " + paramString2 + ", roomId = " + paramLong + ", gameId = " + paramString3);
  }
  
  /* Error */
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 562
    //   4: invokevirtual 565	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   7: checkcast 429	java/lang/String
    //   10: astore_1
    //   11: invokestatic 438	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +42 -> 56
    //   17: ldc 238
    //   19: iconst_2
    //   20: new 354	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 624
    //   30: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 569
    //   40: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_2
    //   44: invokevirtual 572	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   47: invokevirtual 575	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: invokevirtual 366	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_2
    //   57: invokevirtual 301	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   60: ifeq +256 -> 316
    //   63: new 577	trpc/qq_vgame/playgame/AvGamePlay$AnswerRsp
    //   66: dup
    //   67: invokespecial 578	trpc/qq_vgame/playgame/AvGamePlay$AnswerRsp:<init>	()V
    //   70: astore_1
    //   71: aload_1
    //   72: aload_3
    //   73: invokevirtual 579	trpc/qq_vgame/playgame/AvGamePlay$AnswerRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   76: pop
    //   77: aload_1
    //   78: getfield 582	trpc/qq_vgame/playgame/AvGamePlay$AnswerRsp:res	Ltrpc/qq_vgame/common/AvGameCommon$Result;
    //   81: invokevirtual 317	trpc/qq_vgame/common/AvGameCommon$Result:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   84: checkcast 316	trpc/qq_vgame/common/AvGameCommon$Result
    //   87: getfield 320	trpc/qq_vgame/common/AvGameCommon$Result:errcode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   90: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   93: istore 4
    //   95: aload_1
    //   96: getfield 582	trpc/qq_vgame/playgame/AvGamePlay$AnswerRsp:res	Ltrpc/qq_vgame/common/AvGameCommon$Result;
    //   99: invokevirtual 317	trpc/qq_vgame/common/AvGameCommon$Result:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   102: checkcast 316	trpc/qq_vgame/common/AvGameCommon$Result
    //   105: getfield 324	trpc/qq_vgame/common/AvGameCommon$Result:errmsg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   108: invokevirtual 329	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   111: invokevirtual 334	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   114: astore_2
    //   115: aload_1
    //   116: getfield 585	trpc/qq_vgame/playgame/AvGamePlay$AnswerRsp:answer_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   119: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   122: istore 5
    //   124: aload_1
    //   125: getfield 588	trpc/qq_vgame/playgame/AvGamePlay$AnswerRsp:right_answer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   128: invokevirtual 44	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   131: astore_3
    //   132: aload_1
    //   133: getfield 589	trpc/qq_vgame/playgame/AvGamePlay$AnswerRsp:score	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   136: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   139: istore 6
    //   141: ldc 238
    //   143: ldc_w 626
    //   146: aconst_null
    //   147: iconst_1
    //   148: anewarray 373	com/tencent/mobileqq/pb/MessageMicro
    //   151: dup
    //   152: iconst_0
    //   153: aload_1
    //   154: aastore
    //   155: invokestatic 376	com/tencent/avgame/gamelogic/GameUtil:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   158: invokestatic 64	com/tencent/avgame/business/observer/ObserverCenter:a	()Lcom/tencent/avgame/business/observer/ObserverCenter;
    //   161: astore_1
    //   162: iload 5
    //   164: iconst_1
    //   165: if_icmpne +89 -> 254
    //   168: iconst_1
    //   169: istore 7
    //   171: aload_1
    //   172: ldc 66
    //   174: bipush 16
    //   176: iconst_1
    //   177: iconst_5
    //   178: anewarray 68	java/lang/Object
    //   181: dup
    //   182: iconst_0
    //   183: iload 4
    //   185: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   188: aastore
    //   189: dup
    //   190: iconst_1
    //   191: aload_2
    //   192: aastore
    //   193: dup
    //   194: iconst_2
    //   195: iload 7
    //   197: invokestatic 394	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   200: aastore
    //   201: dup
    //   202: iconst_3
    //   203: aload_3
    //   204: aastore
    //   205: dup
    //   206: iconst_4
    //   207: iload 6
    //   209: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: invokevirtual 77	com/tencent/avgame/business/observer/ObserverCenter:b	(Ljava/lang/Class;IZLjava/lang/Object;)V
    //   216: ldc 238
    //   218: iconst_2
    //   219: new 354	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 624
    //   229: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: iload 4
    //   234: invokevirtual 575	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   237: ldc_w 569
    //   240: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_2
    //   244: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 366	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 447	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: return
    //   254: iconst_0
    //   255: istore 7
    //   257: goto -86 -> 171
    //   260: astore_1
    //   261: ldc 238
    //   263: iconst_1
    //   264: new 354	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   271: ldc_w 628
    //   274: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_1
    //   278: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 366	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 369	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: return
    //   288: astore_1
    //   289: ldc 238
    //   291: iconst_1
    //   292: new 354	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 630
    //   302: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_1
    //   306: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 366	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 369	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: return
    //   316: invokestatic 64	com/tencent/avgame/business/observer/ObserverCenter:a	()Lcom/tencent/avgame/business/observer/ObserverCenter;
    //   319: ldc 66
    //   321: bipush 16
    //   323: iconst_1
    //   324: iconst_5
    //   325: anewarray 68	java/lang/Object
    //   328: dup
    //   329: iconst_0
    //   330: ldc_w 273
    //   333: aastore
    //   334: dup
    //   335: iconst_1
    //   336: ldc_w 631
    //   339: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   342: aastore
    //   343: dup
    //   344: iconst_2
    //   345: iconst_0
    //   346: invokestatic 394	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   349: aastore
    //   350: dup
    //   351: iconst_3
    //   352: aconst_null
    //   353: aastore
    //   354: dup
    //   355: iconst_4
    //   356: iconst_0
    //   357: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   360: aastore
    //   361: invokevirtual 77	com/tencent/avgame/business/observer/ObserverCenter:b	(Ljava/lang/Class;IZLjava/lang/Object;)V
    //   364: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	GamePlayHandler
    //   0	365	1	paramToServiceMsg	ToServiceMsg
    //   0	365	2	paramFromServiceMsg	FromServiceMsg
    //   0	365	3	paramArrayOfByte	byte[]
    //   93	140	4	i	int
    //   122	44	5	j	int
    //   139	69	6	k	int
    //   169	87	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   71	162	260	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   171	253	260	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   71	162	288	java/lang/Exception
    //   171	253	288	java/lang/Exception
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    String str = paramToServiceMsg.extraData.getString("gameId");
    long l = paramToServiceMsg.extraData.getLong("roomId");
    int i = -2147483648;
    paramToServiceMsg = "";
    ObserverCenter.a().b(GamePlayObserver.class, 17, false, new Object[0]);
    if (paramFromServiceMsg.isSuccess()) {
      paramToServiceMsg = new AvGameQuestionInfo.CmdAnswerQuestionRsp();
    }
    try
    {
      paramToServiceMsg.mergeFrom(paramArrayOfByte);
      i = ((AvGameCommon.Result)paramToServiceMsg.res.get()).errcode.get();
      paramToServiceMsg = ((AvGameCommon.Result)paramToServiceMsg.res.get()).errmsg.get().toStringUtf8();
      if (QLog.isColorLevel()) {
        QLog.d("avgame_logic.GamePlayHandler", 2, "handleAnswerQuestionRsp. gameId = " + str + ", roomId = " + l + ", errCode = " + i + ", errMsg = " + paramToServiceMsg);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      QLog.e("avgame_logic.GamePlayHandler", 1, "handleAnswerQuestionRsp. parse pb failed. err = " + paramToServiceMsg);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("avgame_logic.GamePlayHandler", 1, "handleAnswerQuestionRsp. parse pb failed. err2 = " + paramToServiceMsg);
    }
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, String paramString2, long paramLong, String paramString3, int paramInt3)
  {
    AvGamePlay.AnswerReq localAnswerReq = new AvGamePlay.AnswerReq();
    localAnswerReq.uin.set(Long.parseLong(paramString2));
    localAnswerReq.play_game_id.set(paramString3);
    localAnswerReq.scene_type.set(paramInt3);
    localAnswerReq.question_index.set(paramInt1 + 1);
    localAnswerReq.answer.set(paramString1);
    localAnswerReq.trans_mod.set(7);
    localAnswerReq.trans_cost.set(paramInt2);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.GameManager-AnswerQuestion");
    localToServiceMsg.addAttribute("fromVoice", Boolean.valueOf(true));
    paramString1 = String.format("sendAnswerQuestionReqNew. questionIndex=%d uin=%s gameId=%s answer=%s recogTimeLen=%d sceneType=%d", new Object[] { Integer.valueOf(paramInt1), paramString2, paramString3, paramString1, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    localToServiceMsg.addAttribute("msg", paramString1);
    localToServiceMsg.putWupBuffer(localAnswerReq.toByteArray());
    sendPbReq(localToServiceMsg);
    QLog.i("avgame_logic.GamePlayHandler", 2, paramString1);
  }
  
  public void a(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AvGamePlay.AnswerReq localAnswerReq = new AvGamePlay.AnswerReq();
    localAnswerReq.uin.set(paramLong);
    localAnswerReq.play_game_id.set(paramString);
    localAnswerReq.question_index.set(paramInt1);
    localAnswerReq.answer_index.set(paramInt2);
    localAnswerReq.scene_type.set(paramInt4);
    localAnswerReq.answer_duration.set(paramInt3);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.GameManager-AnswerQuestion");
    localToServiceMsg.putWupBuffer(localAnswerReq.toByteArray());
    paramString = String.format("sendClickAnswer. uin=%d gameId=%s questionIndex=%d answerIndex=%d answerDuration=%d sceneType=%d", new Object[] { Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    localToServiceMsg.addAttribute("fromVoice", Boolean.valueOf(false));
    localToServiceMsg.addAttribute("msg", paramString);
    sendPbReq(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("avgame_logic.GamePlayHandler", 2, paramString);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, long paramLong, String paramString3)
  {
    b(paramString1, paramInt, paramString2, paramLong, paramString3);
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AvGamePlay.StartGameReq localStartGameReq = new AvGamePlay.StartGameReq();
    localStartGameReq.uin.set(Long.valueOf(paramString1).longValue());
    localStartGameReq.roomid.set(paramLong);
    localStartGameReq.type.set(paramInt1);
    if (paramString2 != null) {
      localStartGameReq.question_class.set(paramString2);
    }
    if (GameEngine.a().f())
    {
      localStartGameReq.pk_id.set(paramInt2);
      localStartGameReq.pk_round.set(paramInt4);
    }
    localStartGameReq.scene_type.set(paramInt3);
    localStartGameReq.game_mode.set(paramInt5);
    localStartGameReq.trans_mod.set(paramInt6);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.GameManager-StartGame");
    localToServiceMsg.extraData.putString("uin", paramString1);
    localToServiceMsg.extraData.putLong("roomId", paramLong);
    localToServiceMsg.extraData.putInt("gameType", paramInt1);
    if (paramString2 != null) {
      localToServiceMsg.extraData.putString("questionClass", paramString2);
    }
    localToServiceMsg.putWupBuffer(localStartGameReq.toByteArray());
    sendPbReq(localToServiceMsg);
    QLog.d("avgame_logic.GamePlayHandler", 1, String.format("startGameReq roomId=%d hostUin=%s type=%d pkId=%d sceneType=%d pkRound=%d gameMode=%d localVoiceMode=%d", new Object[] { Long.valueOf(paramLong), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6) }));
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    a(paramString1, paramLong, paramString2, 0, "switchTopicReq()");
  }
  
  public void a(String paramString1, long paramLong, String paramString2, boolean paramBoolean)
  {
    a(paramString1, paramLong, paramString2, 1, "pullTopics() fromStart=" + paramBoolean);
  }
  
  public void a(String paramString1, String paramString2)
  {
    AvGameRanking.GetRankingListReq localGetRankingListReq = new AvGameRanking.GetRankingListReq();
    localGetRankingListReq.play_game_id.set(paramString2);
    localGetRankingListReq.uin.set(Long.parseLong(paramString1));
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.GameRanking-GetRankingList");
    localToServiceMsg.extraData.putString("uin", paramString1);
    localToServiceMsg.extraData.putString("gameId", paramString2);
    localToServiceMsg.putWupBuffer(localGetRankingListReq.toByteArray());
    sendPbReq(localToServiceMsg);
    QLog.d("avgame_logic.GamePlayHandler", 1, String.format("getRankingListReq gameId=%s", new Object[] { paramString2 }));
  }
  
  public void a(AvGameNotify.NotifyMsg paramNotifyMsg)
  {
    int i = paramNotifyMsg.type.get();
    long l1 = paramNotifyMsg.seq.get();
    long l2 = paramNotifyMsg.roomid.get();
    String str2 = paramNotifyMsg.play_game_id.get();
    long l3 = SystemClock.elapsedRealtime();
    QLog.d("avgame_logic.GamePlayHandler", 1, String.format("handleOnlinePush type=%d [%s] seq=%d roomId=%d gameId=%s", new Object[] { Integer.valueOf(i), GameUtil.a(i), Long.valueOf(l1), Long.valueOf(l2), str2 }));
    if (GameEngine.a().a() != null) {}
    for (String str1 = GameEngine.a().a().b();; str1 = "")
    {
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (!str1.equals(str2))) {
        CJSurvivalFestivalReporter.a(str2, i);
      }
      switch (i)
      {
      default: 
        return;
      }
    }
    paramNotifyMsg = (AvGameNotify.RoomOwnerStartGameS2CReq)paramNotifyMsg.start_game_req.get();
    GameUtil.a("avgame_logic.GamePlayHandler", "NT_GAME_START", null, new MessageMicro[] { paramNotifyMsg });
    a(l1, l2, str2, paramNotifyMsg, l3);
    return;
    paramNotifyMsg = (AvGameNotify.NotifyGameOverS2CReq)paramNotifyMsg.game_over_req.get();
    GameUtil.a("avgame_logic.GamePlayHandler", "NT_GAME_OVER", null, new MessageMicro[] { paramNotifyMsg });
    a(l1, l2, str2, paramNotifyMsg, l3);
    return;
    paramNotifyMsg = (AvGameNotify.NotifyChangeQuestionS2CReq)paramNotifyMsg.change_question_req.get();
    GameUtil.a("avgame_logic.GamePlayHandler", "NT_TOPIC_CHANGE", null, new MessageMicro[] { paramNotifyMsg });
    a(l1, l2, str2, paramNotifyMsg, l3);
    return;
    paramNotifyMsg = (AvGameNotify.NotifyNextActorTipsS2CReq)paramNotifyMsg.next_actor_tips_req.get();
    GameUtil.a("avgame_logic.GamePlayHandler", "NT_NEXT_ACTOR_TIPS", null, new MessageMicro[] { paramNotifyMsg });
    a(l1, l2, str2, paramNotifyMsg, l3);
    return;
    paramNotifyMsg = (AvGameNotify.NotifyChangeActorS2CReq)paramNotifyMsg.change_actor_req.get();
    GameUtil.a("avgame_logic.GamePlayHandler", "NT_ACTOR_CHANGE", null, new MessageMicro[] { paramNotifyMsg });
    a(l1, l2, str2, paramNotifyMsg, l3);
    return;
    paramNotifyMsg = (AvGameNotify.NotifyAnswerRightS2CReq)paramNotifyMsg.answer_right_req.get();
    GameUtil.a("avgame_logic.GamePlayHandler", "NT_ANSWER_RIGHT", null, new MessageMicro[] { paramNotifyMsg });
    a(l1, l2, str2, paramNotifyMsg, l3);
    return;
    paramNotifyMsg = (AvGameNotify.NotifyQuestionTimeoutS2CReq)paramNotifyMsg.question_timeout_req.get();
    GameUtil.a("avgame_logic.GamePlayHandler", "NT_TOPIC_TIMEOUT", null, new MessageMicro[] { paramNotifyMsg });
    a(l1, l2, str2, paramNotifyMsg, l3);
    return;
    paramNotifyMsg = (AvGameNotify.NotifyActorGiveOutAnswerS2CReq)paramNotifyMsg.actor_giveout_answer_req.get();
    GameUtil.a("avgame_logic.GamePlayHandler", "NT_ACTOR_GIVEOUT_ANSWER", null, new MessageMicro[] { paramNotifyMsg });
    a(l1, l2, str2, paramNotifyMsg, l3);
    return;
    paramNotifyMsg = (AvGameNotify.NotifyAnswerFinishS2cReq)paramNotifyMsg.answer_finish_req.get();
    GameUtil.a("avgame_logic.GamePlayHandler", "NT_ALL_ANSWER_FINISH", null, new MessageMicro[] { paramNotifyMsg });
    a(l1, l2, str2, paramNotifyMsg, l3);
    return;
    paramNotifyMsg = (AvGameNotify.NotifyTranslateInfoS2CReq)paramNotifyMsg.translate_info_req.get();
    GameUtil.a("avgame_logic.GamePlayHandler", "NT_TRANSLATE_INFO", null, new MessageMicro[] { paramNotifyMsg });
    a(l1, l2, str2, paramNotifyMsg, l3);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("qqvgame.GameManager-StartGame");
      this.allowCmdSet.add("qqvgame.QuestionManager-GetQuestion");
      this.allowCmdSet.add("qqvgame.GameRanking-GetRankingList");
      this.allowCmdSet.add("qqvgame.QuestionManager-AnswerQuestion");
      this.allowCmdSet.add("qqvgame.GameManager-AnswerQuestion");
    }
    return this.allowCmdSet;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return GamePlayObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("qqvgame.GameManager-StartGame".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      int i;
      do
      {
        return;
        if (!"qqvgame.QuestionManager-GetQuestion".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
          break;
        }
        i = paramToServiceMsg.extraData.getInt("reqType");
        if (i == 0)
        {
          a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject, "handleSwitchTopicReq()", 1);
          return;
        }
      } while (i != 1);
      a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject, "handlePullTopics()", 13);
      return;
      if ("qqvgame.GameRanking-GetRankingList".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.QuestionManager-AnswerQuestion".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
        return;
      }
    } while (!"qqvgame.GameManager-AnswerQuestion".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()));
    a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.handler.GamePlayHandler
 * JD-Core Version:    0.7.0.1
 */