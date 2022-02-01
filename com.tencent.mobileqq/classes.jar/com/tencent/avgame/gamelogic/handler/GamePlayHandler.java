package com.tencent.avgame.gamelogic.handler;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.avgame.business.handler.AVGameBusinessHandler;
import com.tencent.avgame.business.observer.ObserverCenter;
import com.tencent.avgame.gamelogic.GameUtil;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.AnswerInfo;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameInfo;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.observer.GamePlayObserver;
import com.tencent.avgame.report.exception.AVGameExceptionReporter;
import com.tencent.common.app.AppInterface;
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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import trpc.qq_vgame.common.AvGameCommon.GameInfo;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.Result;
import trpc.qq_vgame.common.AvGameCommon.RoomUserInfo;
import trpc.qq_vgame.common.AvGameCommon.UserAnswerInfo;
import trpc.qq_vgame.game_ranking.AvGameRanking.GetRankingListReq;
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
import trpc.qq_vgame.playgame.AvGamePlay.AnswerRsp;
import trpc.qq_vgame.playgame.AvGamePlay.StartGameReq;
import trpc.qq_vgame.playgame.AvGamePlay.StartGameRsp;
import trpc.qq_vgame.question.AvGameQuestionInfo.CmdAnswerQuestionReq;
import trpc.qq_vgame.question.AvGameQuestionInfo.CmdAnswerQuestionRsp;
import trpc.qq_vgame.question.AvGameQuestionInfo.CmdGetQuestionReq;

public class GamePlayHandler
  extends AVGameBusinessHandler
{
  public GamePlayHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private String a()
  {
    return MobileQQ.sMobileQQ.getResources().getString(2131887214);
  }
  
  private String a(int paramInt)
  {
    return MobileQQ.sMobileQQ.getResources().getString(paramInt);
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
      ((GameInfo)localObject1).g = paramRoomOwnerStartGameS2CReq.question_class.get();
    }
    ObserverCenter.a().b(GamePlayObserver.class, 2, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, localObject1, localPlayer, localObject2, Long.valueOf(paramLong3) });
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 267	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: astore 11
    //   6: ldc_w 269
    //   9: astore 10
    //   11: aload 11
    //   13: ldc_w 270
    //   16: ldc_w 269
    //   19: invokevirtual 275	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 12
    //   24: aload_1
    //   25: getfield 267	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   28: ldc_w 277
    //   31: invokevirtual 281	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   34: lstore 7
    //   36: aload_1
    //   37: getfield 267	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   40: ldc_w 283
    //   43: invokevirtual 287	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   46: istore 6
    //   48: aload_1
    //   49: getfield 267	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   52: ldc_w 289
    //   55: ldc_w 269
    //   58: invokevirtual 275	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   61: astore 14
    //   63: new 291	com/tencent/avgame/gamelogic/data/RoomInfo
    //   66: dup
    //   67: invokespecial 292	com/tencent/avgame/gamelogic/data/RoomInfo:<init>	()V
    //   70: astore 13
    //   72: aload_2
    //   73: invokevirtual 297	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   76: ifeq +442 -> 518
    //   79: new 299	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp
    //   82: dup
    //   83: invokespecial 300	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp:<init>	()V
    //   86: astore 15
    //   88: aload 15
    //   90: aload_3
    //   91: checkcast 302	[B
    //   94: checkcast 302	[B
    //   97: invokevirtual 306	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   100: pop
    //   101: aload 15
    //   103: getfield 310	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp:res	Ltrpc/qq_vgame/common/AvGameCommon$Result;
    //   106: invokevirtual 313	trpc/qq_vgame/common/AvGameCommon$Result:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   109: checkcast 312	trpc/qq_vgame/common/AvGameCommon$Result
    //   112: getfield 316	trpc/qq_vgame/common/AvGameCommon$Result:errcode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   115: invokevirtual 131	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   118: istore 5
    //   120: aload 10
    //   122: astore_3
    //   123: aload 15
    //   125: getfield 310	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp:res	Ltrpc/qq_vgame/common/AvGameCommon$Result;
    //   128: invokevirtual 313	trpc/qq_vgame/common/AvGameCommon$Result:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   131: checkcast 312	trpc/qq_vgame/common/AvGameCommon$Result
    //   134: getfield 320	trpc/qq_vgame/common/AvGameCommon$Result:errmsg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   137: invokevirtual 325	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   140: invokevirtual 330	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   143: astore_1
    //   144: aload_1
    //   145: astore_3
    //   146: aload_1
    //   147: astore 10
    //   149: aload 13
    //   151: aload 15
    //   153: getfield 334	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp:room_info	Ltrpc/qq_vgame/common/AvGameCommon$RoomInfo;
    //   156: invokevirtual 337	com/tencent/avgame/gamelogic/data/RoomInfo:parseFrom	(Ltrpc/qq_vgame/common/AvGameCommon$RoomInfo;)V
    //   159: aload_1
    //   160: astore 11
    //   162: aload_1
    //   163: astore_3
    //   164: aload_1
    //   165: astore 10
    //   167: aload 15
    //   169: getfield 340	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp:low_version_users	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   172: invokevirtual 341	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   175: ifeq +110 -> 285
    //   178: aload_1
    //   179: astore_3
    //   180: aload_1
    //   181: astore 10
    //   183: aload 15
    //   185: getfield 340	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp:low_version_users	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   188: invokevirtual 85	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   191: astore 16
    //   193: aload_1
    //   194: astore_3
    //   195: aload_1
    //   196: astore 10
    //   198: new 87	java/util/ArrayList
    //   201: dup
    //   202: aload 16
    //   204: invokeinterface 344 1 0
    //   209: invokespecial 347	java/util/ArrayList:<init>	(I)V
    //   212: astore 11
    //   214: aload 16
    //   216: invokeinterface 96 1 0
    //   221: astore 16
    //   223: aload_1
    //   224: astore_3
    //   225: aload 11
    //   227: astore 10
    //   229: iload 5
    //   231: istore 4
    //   233: aload 16
    //   235: invokeinterface 102 1 0
    //   240: ifeq +149 -> 389
    //   243: aload 11
    //   245: aload 16
    //   247: invokeinterface 106 1 0
    //   252: checkcast 223	trpc/qq_vgame/common/AvGameCommon$RoomUserInfo
    //   255: getfield 348	trpc/qq_vgame/common/AvGameCommon$RoomUserInfo:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   258: invokevirtual 165	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   261: invokestatic 70	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   264: invokeinterface 119 2 0
    //   269: pop
    //   270: goto -47 -> 223
    //   273: astore 10
    //   275: aload 11
    //   277: astore_3
    //   278: iload 5
    //   280: istore 4
    //   282: goto +65 -> 347
    //   285: aconst_null
    //   286: astore 10
    //   288: aload 11
    //   290: astore_3
    //   291: iload 5
    //   293: istore 4
    //   295: goto +94 -> 389
    //   298: astore 10
    //   300: aconst_null
    //   301: astore 11
    //   303: aload_3
    //   304: astore_1
    //   305: aload 11
    //   307: astore_3
    //   308: iload 5
    //   310: istore 4
    //   312: goto +35 -> 347
    //   315: aconst_null
    //   316: astore_1
    //   317: ldc_w 349
    //   320: istore 4
    //   322: aload 10
    //   324: astore_3
    //   325: aload_1
    //   326: astore 10
    //   328: goto +61 -> 389
    //   331: astore 11
    //   333: aconst_null
    //   334: astore_3
    //   335: ldc_w 349
    //   338: istore 4
    //   340: aload 10
    //   342: astore_1
    //   343: aload 11
    //   345: astore 10
    //   347: new 351	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 352	java/lang/StringBuilder:<init>	()V
    //   354: astore 11
    //   356: aload 11
    //   358: ldc_w 354
    //   361: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: pop
    //   365: aload 11
    //   367: aload 10
    //   369: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: ldc 234
    //   375: iconst_1
    //   376: aload 11
    //   378: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 366	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   384: aload_3
    //   385: astore 10
    //   387: aload_1
    //   388: astore_3
    //   389: ldc 234
    //   391: ldc_w 368
    //   394: aconst_null
    //   395: iconst_1
    //   396: anewarray 370	com/tencent/mobileqq/pb/MessageMicro
    //   399: dup
    //   400: iconst_0
    //   401: aload 15
    //   403: aastore
    //   404: invokestatic 373	com/tencent/avgame/gamelogic/GameUtil:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   407: iload 4
    //   409: ifne +22 -> 431
    //   412: aload_0
    //   413: aload 12
    //   415: lload 7
    //   417: iload 6
    //   419: aload 14
    //   421: aload 15
    //   423: invokespecial 376	com/tencent/avgame/gamelogic/handler/GamePlayHandler:a	(Ljava/lang/String;JILjava/lang/String;Ltrpc/qq_vgame/playgame/AvGamePlay$StartGameRsp;)Z
    //   426: istore 9
    //   428: goto +6 -> 434
    //   431: iconst_0
    //   432: istore 9
    //   434: iload 9
    //   436: ifne +79 -> 515
    //   439: aload_3
    //   440: astore_1
    //   441: aload_3
    //   442: invokestatic 382	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   445: ifeq +8 -> 453
    //   448: aload_0
    //   449: invokespecial 384	com/tencent/avgame/gamelogic/handler/GamePlayHandler:a	()Ljava/lang/String;
    //   452: astore_1
    //   453: invokestatic 60	com/tencent/avgame/business/observer/ObserverCenter:a	()Lcom/tencent/avgame/business/observer/ObserverCenter;
    //   456: ldc 62
    //   458: iconst_0
    //   459: iconst_0
    //   460: bipush 7
    //   462: anewarray 64	java/lang/Object
    //   465: dup
    //   466: iconst_0
    //   467: aload 12
    //   469: aastore
    //   470: dup
    //   471: iconst_1
    //   472: lload 7
    //   474: invokestatic 70	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   477: aastore
    //   478: dup
    //   479: iconst_2
    //   480: iload 6
    //   482: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   485: aastore
    //   486: dup
    //   487: iconst_3
    //   488: iload 4
    //   490: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   493: aastore
    //   494: dup
    //   495: iconst_4
    //   496: aload_1
    //   497: aastore
    //   498: dup
    //   499: iconst_5
    //   500: aload 13
    //   502: aastore
    //   503: dup
    //   504: bipush 6
    //   506: aload 10
    //   508: aastore
    //   509: invokevirtual 73	com/tencent/avgame/business/observer/ObserverCenter:b	(Ljava/lang/Class;IZLjava/lang/Object;)V
    //   512: goto +14 -> 526
    //   515: goto +11 -> 526
    //   518: iconst_0
    //   519: istore 9
    //   521: ldc_w 349
    //   524: istore 4
    //   526: ldc 234
    //   528: iconst_1
    //   529: bipush 6
    //   531: anewarray 64	java/lang/Object
    //   534: dup
    //   535: iconst_0
    //   536: ldc_w 386
    //   539: aastore
    //   540: dup
    //   541: iconst_1
    //   542: iload 9
    //   544: invokestatic 391	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   547: aastore
    //   548: dup
    //   549: iconst_2
    //   550: ldc_w 393
    //   553: aastore
    //   554: dup
    //   555: iconst_3
    //   556: aload_2
    //   557: invokevirtual 297	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   560: invokestatic 391	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   563: aastore
    //   564: dup
    //   565: iconst_4
    //   566: ldc_w 395
    //   569: aastore
    //   570: dup
    //   571: iconst_5
    //   572: iload 4
    //   574: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   577: aastore
    //   578: invokestatic 398	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   581: return
    //   582: astore_1
    //   583: goto -268 -> 315
    //   586: astore_1
    //   587: aload 10
    //   589: astore 11
    //   591: goto -306 -> 285
    //   594: astore_3
    //   595: aload_1
    //   596: astore_3
    //   597: aload 11
    //   599: astore 10
    //   601: iload 5
    //   603: istore 4
    //   605: goto -216 -> 389
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	608	0	this	GamePlayHandler
    //   0	608	1	paramToServiceMsg	ToServiceMsg
    //   0	608	2	paramFromServiceMsg	FromServiceMsg
    //   0	608	3	paramObject	Object
    //   231	373	4	i	int
    //   118	484	5	j	int
    //   46	435	6	k	int
    //   34	439	7	l	long
    //   426	117	9	bool	boolean
    //   9	219	10	localObject1	Object
    //   273	1	10	localInvalidProtocolBufferMicroException1	InvalidProtocolBufferMicroException
    //   286	1	10	localObject2	Object
    //   298	25	10	localInvalidProtocolBufferMicroException2	InvalidProtocolBufferMicroException
    //   326	274	10	localObject3	Object
    //   4	302	11	localObject4	Object
    //   331	13	11	localInvalidProtocolBufferMicroException3	InvalidProtocolBufferMicroException
    //   354	244	11	localObject5	Object
    //   22	446	12	str1	String
    //   70	431	13	localRoomInfo	com.tencent.avgame.gamelogic.data.RoomInfo
    //   61	359	14	str2	String
    //   86	336	15	localStartGameRsp	AvGamePlay.StartGameRsp
    //   191	55	16	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   214	223	273	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   233	270	273	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   123	144	298	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   149	159	298	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   167	178	298	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   183	193	298	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   198	214	298	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   88	120	331	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   88	120	582	java/lang/Exception
    //   123	144	586	java/lang/Exception
    //   149	159	586	java/lang/Exception
    //   167	178	586	java/lang/Exception
    //   183	193	586	java/lang/Exception
    //   198	214	586	java/lang/Exception
    //   214	223	594	java/lang/Exception
    //   233	270	594	java/lang/Exception
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
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 267	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 416
    //   7: invokevirtual 419	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore 16
    //   12: aload_1
    //   13: getfield 267	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   16: ldc_w 277
    //   19: invokevirtual 281	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   22: lstore 9
    //   24: aload_2
    //   25: invokevirtual 297	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   28: istore 13
    //   30: ldc_w 349
    //   33: istore 6
    //   35: ldc_w 269
    //   38: astore_1
    //   39: iload 6
    //   41: istore 7
    //   43: aload_1
    //   44: astore 15
    //   46: iload 13
    //   48: ifeq +334 -> 382
    //   51: new 421	trpc/qq_vgame/question/AvGameQuestionInfo$CmdGetQuestionRsp
    //   54: dup
    //   55: invokespecial 422	trpc/qq_vgame/question/AvGameQuestionInfo$CmdGetQuestionRsp:<init>	()V
    //   58: astore 17
    //   60: iload 6
    //   62: istore 7
    //   64: iload 6
    //   66: istore 8
    //   68: aload 17
    //   70: aload_3
    //   71: invokevirtual 423	trpc/qq_vgame/question/AvGameQuestionInfo$CmdGetQuestionRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   74: pop
    //   75: iload 6
    //   77: istore 7
    //   79: iload 6
    //   81: istore 8
    //   83: aload 17
    //   85: getfield 424	trpc/qq_vgame/question/AvGameQuestionInfo$CmdGetQuestionRsp:res	Ltrpc/qq_vgame/common/AvGameCommon$Result;
    //   88: invokevirtual 313	trpc/qq_vgame/common/AvGameCommon$Result:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   91: checkcast 312	trpc/qq_vgame/common/AvGameCommon$Result
    //   94: getfield 316	trpc/qq_vgame/common/AvGameCommon$Result:errcode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   97: invokevirtual 131	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   100: istore 6
    //   102: iload 6
    //   104: istore 7
    //   106: iload 6
    //   108: istore 8
    //   110: aload 17
    //   112: getfield 424	trpc/qq_vgame/question/AvGameQuestionInfo$CmdGetQuestionRsp:res	Ltrpc/qq_vgame/common/AvGameCommon$Result;
    //   115: invokevirtual 313	trpc/qq_vgame/common/AvGameCommon$Result:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   118: checkcast 312	trpc/qq_vgame/common/AvGameCommon$Result
    //   121: getfield 320	trpc/qq_vgame/common/AvGameCommon$Result:errmsg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   124: invokevirtual 325	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   127: invokevirtual 330	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   130: astore_3
    //   131: aload_3
    //   132: astore_1
    //   133: goto +59 -> 192
    //   136: iload 8
    //   138: istore 6
    //   140: goto +52 -> 192
    //   143: astore_3
    //   144: new 351	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 352	java/lang/StringBuilder:<init>	()V
    //   151: astore 15
    //   153: aload 15
    //   155: aload 4
    //   157: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 15
    //   163: ldc_w 426
    //   166: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 15
    //   172: aload_3
    //   173: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: ldc 234
    //   179: iconst_1
    //   180: aload 15
    //   182: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 366	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: iload 7
    //   190: istore 6
    //   192: ldc 234
    //   194: aload 4
    //   196: iconst_1
    //   197: anewarray 428	java/lang/String
    //   200: dup
    //   201: iconst_0
    //   202: ldc_w 430
    //   205: aastore
    //   206: iconst_1
    //   207: anewarray 370	com/tencent/mobileqq/pb/MessageMicro
    //   210: dup
    //   211: iconst_0
    //   212: aload 17
    //   214: aastore
    //   215: invokestatic 373	com/tencent/avgame/gamelogic/GameUtil:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   218: iload 6
    //   220: istore 7
    //   222: aload_1
    //   223: astore 15
    //   225: iload 6
    //   227: ifne +155 -> 382
    //   230: iload 5
    //   232: bipush 13
    //   234: if_icmpne +9 -> 243
    //   237: iconst_1
    //   238: istore 13
    //   240: goto +6 -> 246
    //   243: iconst_0
    //   244: istore 13
    //   246: aload 17
    //   248: getfield 431	trpc/qq_vgame/question/AvGameQuestionInfo$CmdGetQuestionRsp:question_info	Ltrpc/qq_vgame/common/AvGameCommon$GameQuestionInfo;
    //   251: invokevirtual 49	trpc/qq_vgame/common/AvGameCommon$GameQuestionInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   254: checkcast 46	trpc/qq_vgame/common/AvGameCommon$GameQuestionInfo
    //   257: iload 13
    //   259: invokestatic 55	com/tencent/avgame/gamelogic/GameUtil:b	(Ltrpc/qq_vgame/common/AvGameCommon$GameQuestionInfo;Z)Lcom/tencent/avgame/gamelogic/ITopic;
    //   262: astore_3
    //   263: aload 17
    //   265: getfield 434	trpc/qq_vgame/question/AvGameQuestionInfo$CmdGetQuestionRsp:seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   268: invokevirtual 165	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   271: lstore 11
    //   273: aload_3
    //   274: ifnull +49 -> 323
    //   277: invokestatic 60	com/tencent/avgame/business/observer/ObserverCenter:a	()Lcom/tencent/avgame/business/observer/ObserverCenter;
    //   280: ldc 62
    //   282: iload 5
    //   284: iconst_1
    //   285: iconst_4
    //   286: anewarray 64	java/lang/Object
    //   289: dup
    //   290: iconst_0
    //   291: lload 9
    //   293: invokestatic 70	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   296: aastore
    //   297: dup
    //   298: iconst_1
    //   299: aload 16
    //   301: aastore
    //   302: dup
    //   303: iconst_2
    //   304: lload 11
    //   306: invokestatic 70	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   309: aastore
    //   310: dup
    //   311: iconst_3
    //   312: aload_3
    //   313: aastore
    //   314: invokevirtual 73	com/tencent/avgame/business/observer/ObserverCenter:b	(Ljava/lang/Class;IZLjava/lang/Object;)V
    //   317: iconst_1
    //   318: istore 13
    //   320: goto +6 -> 326
    //   323: iconst_0
    //   324: istore 13
    //   326: iload 13
    //   328: istore 14
    //   330: iload 6
    //   332: istore 7
    //   334: aload_1
    //   335: astore 15
    //   337: invokestatic 437	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   340: ifeq +45 -> 385
    //   343: ldc 234
    //   345: iconst_2
    //   346: ldc_w 439
    //   349: iconst_2
    //   350: anewarray 64	java/lang/Object
    //   353: dup
    //   354: iconst_0
    //   355: aload 4
    //   357: aastore
    //   358: dup
    //   359: iconst_1
    //   360: aload_3
    //   361: aastore
    //   362: invokestatic 443	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   365: invokestatic 446	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: iload 13
    //   370: istore 14
    //   372: iload 6
    //   374: istore 7
    //   376: aload_1
    //   377: astore 15
    //   379: goto +6 -> 385
    //   382: iconst_0
    //   383: istore 14
    //   385: iload 14
    //   387: ifne +129 -> 516
    //   390: iload 5
    //   392: iconst_1
    //   393: if_icmpne +87 -> 480
    //   396: iload 7
    //   398: sipush 202
    //   401: if_icmpne +70 -> 471
    //   404: aload 16
    //   406: ifnull +15 -> 421
    //   409: aload 16
    //   411: ldc_w 448
    //   414: invokevirtual 452	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   417: astore_1
    //   418: goto +5 -> 423
    //   421: aconst_null
    //   422: astore_1
    //   423: aload_1
    //   424: ifnull +33 -> 457
    //   427: aload_1
    //   428: arraylength
    //   429: iconst_3
    //   430: if_icmplt +27 -> 457
    //   433: iconst_2
    //   434: invokestatic 454	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   437: aload_1
    //   438: iconst_1
    //   439: aaload
    //   440: invokevirtual 458	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   443: ifeq +14 -> 457
    //   446: aload_0
    //   447: ldc_w 459
    //   450: invokespecial 461	com/tencent/avgame/gamelogic/handler/GamePlayHandler:a	(I)Ljava/lang/String;
    //   453: astore_1
    //   454: goto +11 -> 465
    //   457: aload_0
    //   458: ldc_w 462
    //   461: invokespecial 461	com/tencent/avgame/gamelogic/handler/GamePlayHandler:a	(I)Ljava/lang/String;
    //   464: astore_1
    //   465: aload_1
    //   466: astore 15
    //   468: goto +12 -> 480
    //   471: aload_0
    //   472: ldc_w 463
    //   475: invokespecial 461	com/tencent/avgame/gamelogic/handler/GamePlayHandler:a	(I)Ljava/lang/String;
    //   478: astore 15
    //   480: invokestatic 60	com/tencent/avgame/business/observer/ObserverCenter:a	()Lcom/tencent/avgame/business/observer/ObserverCenter;
    //   483: ldc 62
    //   485: iload 5
    //   487: iconst_0
    //   488: iconst_3
    //   489: anewarray 64	java/lang/Object
    //   492: dup
    //   493: iconst_0
    //   494: lload 9
    //   496: invokestatic 70	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   499: aastore
    //   500: dup
    //   501: iconst_1
    //   502: aload 16
    //   504: aastore
    //   505: dup
    //   506: iconst_2
    //   507: aload 15
    //   509: aastore
    //   510: invokevirtual 73	com/tencent/avgame/business/observer/ObserverCenter:b	(Ljava/lang/Class;IZLjava/lang/Object;)V
    //   513: goto +3 -> 516
    //   516: ldc 234
    //   518: iconst_1
    //   519: bipush 11
    //   521: anewarray 64	java/lang/Object
    //   524: dup
    //   525: iconst_0
    //   526: aload 4
    //   528: aastore
    //   529: dup
    //   530: iconst_1
    //   531: ldc_w 465
    //   534: aastore
    //   535: dup
    //   536: iconst_2
    //   537: iload 14
    //   539: invokestatic 391	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   542: aastore
    //   543: dup
    //   544: iconst_3
    //   545: ldc_w 393
    //   548: aastore
    //   549: dup
    //   550: iconst_4
    //   551: aload_2
    //   552: invokevirtual 297	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   555: invokestatic 391	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   558: aastore
    //   559: dup
    //   560: iconst_5
    //   561: ldc_w 395
    //   564: aastore
    //   565: dup
    //   566: bipush 6
    //   568: iload 7
    //   570: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   573: aastore
    //   574: dup
    //   575: bipush 7
    //   577: ldc_w 467
    //   580: aastore
    //   581: dup
    //   582: bipush 8
    //   584: lload 9
    //   586: invokestatic 70	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   589: aastore
    //   590: dup
    //   591: bipush 9
    //   593: ldc_w 469
    //   596: aastore
    //   597: dup
    //   598: bipush 10
    //   600: aload 16
    //   602: aastore
    //   603: invokestatic 398	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   606: return
    //   607: astore_3
    //   608: goto -472 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	611	0	this	GamePlayHandler
    //   0	611	1	paramToServiceMsg	ToServiceMsg
    //   0	611	2	paramFromServiceMsg	FromServiceMsg
    //   0	611	3	paramArrayOfByte	byte[]
    //   0	611	4	paramString	String
    //   0	611	5	paramInt	int
    //   33	340	6	i	int
    //   41	528	7	j	int
    //   66	71	8	k	int
    //   22	563	9	l1	long
    //   271	34	11	l2	long
    //   28	341	13	bool1	boolean
    //   328	210	14	bool2	boolean
    //   44	464	15	localObject	Object
    //   10	591	16	str	String
    //   58	206	17	localCmdGetQuestionRsp	trpc.qq_vgame.question.AvGameQuestionInfo.CmdGetQuestionRsp
    // Exception table:
    //   from	to	target	type
    //   68	75	143	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   83	102	143	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   110	131	143	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   68	75	607	java/lang/Exception
    //   83	102	607	java/lang/Exception
    //   110	131	607	java/lang/Exception
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
    ((GameInfo)localObject).g = paramString2;
    int i = paramInt;
    if (paramInt <= 0) {
      i = GameUtil.b(localGameInfo.type.get());
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
  
  /* Error */
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 267	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 416
    //   7: invokevirtual 419	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore 9
    //   12: aload_1
    //   13: getfield 267	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   16: ldc_w 270
    //   19: invokevirtual 419	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 10
    //   24: aload_2
    //   25: invokevirtual 297	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   28: istore 7
    //   30: ldc_w 349
    //   33: istore 4
    //   35: ldc_w 269
    //   38: astore_1
    //   39: iload 4
    //   41: istore 5
    //   43: aload_1
    //   44: astore 8
    //   46: iload 7
    //   48: ifeq +222 -> 270
    //   51: new 545	trpc/qq_vgame/game_ranking/AvGameRanking$GetRankingListRsp
    //   54: dup
    //   55: invokespecial 546	trpc/qq_vgame/game_ranking/AvGameRanking$GetRankingListRsp:<init>	()V
    //   58: astore 11
    //   60: iload 4
    //   62: istore 5
    //   64: iload 4
    //   66: istore 6
    //   68: aload 11
    //   70: aload_3
    //   71: checkcast 302	[B
    //   74: checkcast 302	[B
    //   77: invokevirtual 547	trpc/qq_vgame/game_ranking/AvGameRanking$GetRankingListRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   80: pop
    //   81: iload 4
    //   83: istore 5
    //   85: iload 4
    //   87: istore 6
    //   89: aload 11
    //   91: getfield 548	trpc/qq_vgame/game_ranking/AvGameRanking$GetRankingListRsp:res	Ltrpc/qq_vgame/common/AvGameCommon$Result;
    //   94: invokevirtual 313	trpc/qq_vgame/common/AvGameCommon$Result:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   97: checkcast 312	trpc/qq_vgame/common/AvGameCommon$Result
    //   100: getfield 316	trpc/qq_vgame/common/AvGameCommon$Result:errcode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   103: invokevirtual 131	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   106: istore 4
    //   108: iload 4
    //   110: istore 5
    //   112: iload 4
    //   114: istore 6
    //   116: aload 11
    //   118: getfield 548	trpc/qq_vgame/game_ranking/AvGameRanking$GetRankingListRsp:res	Ltrpc/qq_vgame/common/AvGameCommon$Result;
    //   121: invokevirtual 313	trpc/qq_vgame/common/AvGameCommon$Result:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   124: checkcast 312	trpc/qq_vgame/common/AvGameCommon$Result
    //   127: getfield 320	trpc/qq_vgame/common/AvGameCommon$Result:errmsg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   130: invokevirtual 325	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   133: invokevirtual 330	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   136: astore_3
    //   137: aload_3
    //   138: astore_1
    //   139: goto +51 -> 190
    //   142: iload 6
    //   144: istore 4
    //   146: goto +44 -> 190
    //   149: astore_3
    //   150: new 351	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 352	java/lang/StringBuilder:<init>	()V
    //   157: astore 8
    //   159: aload 8
    //   161: ldc_w 550
    //   164: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 8
    //   170: aload_3
    //   171: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: ldc 234
    //   177: iconst_1
    //   178: aload 8
    //   180: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 366	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: iload 5
    //   188: istore 4
    //   190: ldc 234
    //   192: ldc_w 552
    //   195: iconst_1
    //   196: anewarray 428	java/lang/String
    //   199: dup
    //   200: iconst_0
    //   201: ldc_w 430
    //   204: aastore
    //   205: iconst_1
    //   206: anewarray 370	com/tencent/mobileqq/pb/MessageMicro
    //   209: dup
    //   210: iconst_0
    //   211: aload 11
    //   213: aastore
    //   214: invokestatic 373	com/tencent/avgame/gamelogic/GameUtil:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   217: iload 4
    //   219: istore 5
    //   221: aload_1
    //   222: astore 8
    //   224: iload 4
    //   226: ifne +44 -> 270
    //   229: aload 11
    //   231: invokestatic 555	com/tencent/avgame/gamelogic/GameUtil:a	(Ltrpc/qq_vgame/game_ranking/AvGameRanking$GetRankingListRsp;)Ljava/util/List;
    //   234: astore_3
    //   235: invokestatic 60	com/tencent/avgame/business/observer/ObserverCenter:a	()Lcom/tencent/avgame/business/observer/ObserverCenter;
    //   238: ldc 62
    //   240: bipush 10
    //   242: iconst_1
    //   243: iconst_3
    //   244: anewarray 64	java/lang/Object
    //   247: dup
    //   248: iconst_0
    //   249: aload 10
    //   251: aastore
    //   252: dup
    //   253: iconst_1
    //   254: aload 9
    //   256: aastore
    //   257: dup
    //   258: iconst_2
    //   259: aload_3
    //   260: aastore
    //   261: invokevirtual 73	com/tencent/avgame/business/observer/ObserverCenter:b	(Ljava/lang/Class;IZLjava/lang/Object;)V
    //   264: iconst_1
    //   265: istore 7
    //   267: goto +13 -> 280
    //   270: iconst_0
    //   271: istore 7
    //   273: aload 8
    //   275: astore_1
    //   276: iload 5
    //   278: istore 4
    //   280: iload 7
    //   282: ifne +46 -> 328
    //   285: aload_1
    //   286: astore_3
    //   287: aload_1
    //   288: invokestatic 382	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   291: ifeq +8 -> 299
    //   294: aload_0
    //   295: invokespecial 384	com/tencent/avgame/gamelogic/handler/GamePlayHandler:a	()Ljava/lang/String;
    //   298: astore_3
    //   299: invokestatic 60	com/tencent/avgame/business/observer/ObserverCenter:a	()Lcom/tencent/avgame/business/observer/ObserverCenter;
    //   302: ldc 62
    //   304: bipush 10
    //   306: iconst_0
    //   307: iconst_3
    //   308: anewarray 64	java/lang/Object
    //   311: dup
    //   312: iconst_0
    //   313: aload 10
    //   315: aastore
    //   316: dup
    //   317: iconst_1
    //   318: aload 9
    //   320: aastore
    //   321: dup
    //   322: iconst_2
    //   323: aload_3
    //   324: aastore
    //   325: invokevirtual 73	com/tencent/avgame/business/observer/ObserverCenter:b	(Ljava/lang/Class;IZLjava/lang/Object;)V
    //   328: ldc 234
    //   330: iconst_1
    //   331: bipush 8
    //   333: anewarray 64	java/lang/Object
    //   336: dup
    //   337: iconst_0
    //   338: ldc_w 557
    //   341: aastore
    //   342: dup
    //   343: iconst_1
    //   344: iload 7
    //   346: invokestatic 391	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   349: aastore
    //   350: dup
    //   351: iconst_2
    //   352: ldc_w 393
    //   355: aastore
    //   356: dup
    //   357: iconst_3
    //   358: aload_2
    //   359: invokevirtual 297	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   362: invokestatic 391	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   365: aastore
    //   366: dup
    //   367: iconst_4
    //   368: ldc_w 395
    //   371: aastore
    //   372: dup
    //   373: iconst_5
    //   374: iload 4
    //   376: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   379: aastore
    //   380: dup
    //   381: bipush 6
    //   383: ldc_w 469
    //   386: aastore
    //   387: dup
    //   388: bipush 7
    //   390: aload 9
    //   392: aastore
    //   393: invokestatic 398	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   396: return
    //   397: astore_3
    //   398: goto -256 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	401	0	this	GamePlayHandler
    //   0	401	1	paramToServiceMsg	ToServiceMsg
    //   0	401	2	paramFromServiceMsg	FromServiceMsg
    //   0	401	3	paramObject	Object
    //   33	342	4	i	int
    //   41	236	5	j	int
    //   66	77	6	k	int
    //   28	317	7	bool	boolean
    //   44	230	8	localObject	Object
    //   10	381	9	str1	String
    //   22	292	10	str2	String
    //   58	172	11	localGetRankingListRsp	trpc.qq_vgame.game_ranking.AvGameRanking.GetRankingListRsp
    // Exception table:
    //   from	to	target	type
    //   68	81	149	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   89	108	149	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   116	137	149	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   68	81	397	java/lang/Exception
    //   89	108	397	java/lang/Exception
    //   116	137	397	java/lang/Exception
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    paramToServiceMsg = (String)paramToServiceMsg.getAttribute("msg");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleSendClickAnswer ");
      localStringBuilder.append(paramToServiceMsg);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
      QLog.d("avgame_logic.GamePlayHandler", 2, localStringBuilder.toString());
    }
    boolean bool2 = paramFromServiceMsg.isSuccess();
    boolean bool1 = false;
    if (bool2)
    {
      paramToServiceMsg = new AvGamePlay.AnswerRsp();
      try
      {
        paramToServiceMsg.mergeFrom(paramArrayOfByte);
        GameUtil.a("avgame_logic.GamePlayHandler", "handleSendClickAnswer", null, new MessageMicro[] { paramToServiceMsg });
        int i = ((AvGameCommon.Result)paramToServiceMsg.res.get()).errcode.get();
        paramFromServiceMsg = ((AvGameCommon.Result)paramToServiceMsg.res.get()).errmsg.get().toStringUtf8();
        int j = paramToServiceMsg.answer_result.get();
        paramArrayOfByte = paramToServiceMsg.right_answer.get();
        int k = paramToServiceMsg.score.get();
        paramToServiceMsg = ObserverCenter.a();
        if (j == 1) {
          bool1 = true;
        }
        paramToServiceMsg.b(GamePlayObserver.class, 14, true, new Object[] { Integer.valueOf(i), paramFromServiceMsg, Boolean.valueOf(bool1), paramArrayOfByte, Integer.valueOf(k) });
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleSendClickAnswer. parse pb failed. err2 = ");
        paramFromServiceMsg.append(paramToServiceMsg);
        QLog.e("avgame_logic.GamePlayHandler", 1, paramFromServiceMsg.toString());
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleSendClickAnswer. parse pb failed. err = ");
        paramFromServiceMsg.append(paramToServiceMsg);
        QLog.e("avgame_logic.GamePlayHandler", 1, paramFromServiceMsg.toString());
        return;
      }
    }
    ObserverCenter.a().b(GamePlayObserver.class, 14, false, new Object[] { Integer.valueOf(-2147483648), "", Boolean.valueOf(false), "", Integer.valueOf(0) });
  }
  
  private void b(String paramString1, int paramInt, String paramString2, long paramLong, String paramString3)
  {
    Object localObject = new AvGameQuestionInfo.CmdAnswerQuestionReq();
    ((AvGameQuestionInfo.CmdAnswerQuestionReq)localObject).uin.set(Long.parseLong(paramString2));
    ((AvGameQuestionInfo.CmdAnswerQuestionReq)localObject).play_game_id.set(paramString3);
    ((AvGameQuestionInfo.CmdAnswerQuestionReq)localObject).answer.set(paramString1);
    ((AvGameQuestionInfo.CmdAnswerQuestionReq)localObject).trans_mod.set(7);
    ((AvGameQuestionInfo.CmdAnswerQuestionReq)localObject).trans_cost.set(paramInt);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.QuestionManager-AnswerQuestion");
    localToServiceMsg.extraData.putString("gameId", paramString3);
    localToServiceMsg.extraData.putLong("roomId", paramLong);
    localToServiceMsg.putWupBuffer(((AvGameQuestionInfo.CmdAnswerQuestionReq)localObject).toByteArray());
    sendPbReq(localToServiceMsg);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendAnswerQuestionReq. answer = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", recogTimeLen = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", uin = ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", roomId = ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", gameId = ");
    ((StringBuilder)localObject).append(paramString3);
    QLog.i("avgame_logic.GamePlayHandler", 1, ((StringBuilder)localObject).toString());
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    paramToServiceMsg = (String)paramToServiceMsg.getAttribute("msg");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleSendAnswerQuestionReqNew ");
      localStringBuilder.append(paramToServiceMsg);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
      QLog.d("avgame_logic.GamePlayHandler", 2, localStringBuilder.toString());
    }
    boolean bool2 = paramFromServiceMsg.isSuccess();
    boolean bool1 = false;
    if (bool2)
    {
      paramFromServiceMsg = new AvGamePlay.AnswerRsp();
      try
      {
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        int i = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errcode.get();
        paramToServiceMsg = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errmsg.get().toStringUtf8();
        int j = paramFromServiceMsg.answer_result.get();
        paramArrayOfByte = paramFromServiceMsg.right_answer.get();
        int k = paramFromServiceMsg.score.get();
        GameUtil.a("avgame_logic.GamePlayHandler", "handleSendAnswerQuestionReqNew", null, new MessageMicro[] { paramFromServiceMsg });
        paramFromServiceMsg = ObserverCenter.a();
        if (j == 1) {
          bool1 = true;
        }
        paramFromServiceMsg.b(GamePlayObserver.class, 16, true, new Object[] { Integer.valueOf(i), paramToServiceMsg, Boolean.valueOf(bool1), paramArrayOfByte, Integer.valueOf(k) });
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleSendAnswerQuestionReqNew ");
        paramFromServiceMsg.append(i);
        paramFromServiceMsg.append(" ");
        paramFromServiceMsg.append(paramToServiceMsg);
        QLog.i("avgame_logic.GamePlayHandler", 2, paramFromServiceMsg.toString());
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleSendAnswerQuestionReqNew. parse pb failed. err2 = ");
        paramFromServiceMsg.append(paramToServiceMsg);
        QLog.e("avgame_logic.GamePlayHandler", 1, paramFromServiceMsg.toString());
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleSendAnswerQuestionReqNew. parse pb failed. err = ");
        paramFromServiceMsg.append(paramToServiceMsg);
        QLog.e("avgame_logic.GamePlayHandler", 1, paramFromServiceMsg.toString());
        return;
      }
    }
    ObserverCenter.a().b(GamePlayObserver.class, 16, true, new Object[] { "", Integer.valueOf(2147483647), Boolean.valueOf(false), null, Integer.valueOf(0) });
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    String str = paramToServiceMsg.extraData.getString("gameId");
    long l = paramToServiceMsg.extraData.getLong("roomId");
    ObserverCenter.a().b(GamePlayObserver.class, 17, false, new Object[0]);
    int i;
    if (paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg = new AvGameQuestionInfo.CmdAnswerQuestionRsp();
      try
      {
        paramToServiceMsg.mergeFrom(paramArrayOfByte);
        i = ((AvGameCommon.Result)paramToServiceMsg.res.get()).errcode.get();
        paramToServiceMsg = ((AvGameCommon.Result)paramToServiceMsg.res.get()).errmsg.get().toStringUtf8();
      }
      catch (Exception paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleAnswerQuestionRsp. parse pb failed. err2 = ");
        paramFromServiceMsg.append(paramToServiceMsg);
        QLog.e("avgame_logic.GamePlayHandler", 1, paramFromServiceMsg.toString());
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleAnswerQuestionRsp. parse pb failed. err = ");
        paramFromServiceMsg.append(paramToServiceMsg);
        QLog.e("avgame_logic.GamePlayHandler", 1, paramFromServiceMsg.toString());
        return;
      }
    }
    else
    {
      i = -2147483648;
      paramToServiceMsg = "";
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleAnswerQuestionRsp. gameId = ");
      paramFromServiceMsg.append(str);
      paramFromServiceMsg.append(", roomId = ");
      paramFromServiceMsg.append(l);
      paramFromServiceMsg.append(", errCode = ");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(", errMsg = ");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.d("avgame_logic.GamePlayHandler", 2, paramFromServiceMsg.toString());
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
    if (IGameEngine.I().A())
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pullTopics() fromStart=");
    localStringBuilder.append(paramBoolean);
    a(paramString1, paramLong, paramString2, 1, localStringBuilder.toString());
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
    String str1;
    if (!IGameEngine.J())
    {
      str1 = IGameEngine.I().s().n();
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("avgame_logic.GamePlayHandler", 2, "IGameEngine = null");
      }
      str1 = "";
    }
    if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (!str1.equals(str2))) {
      AVGameExceptionReporter.a().a(str2, i);
    }
    if (i != 201)
    {
      switch (i)
      {
      default: 
        return;
      case 110: 
        paramNotifyMsg = (AvGameNotify.NotifyGameOverS2CReq)paramNotifyMsg.game_over_req.get();
        GameUtil.a("avgame_logic.GamePlayHandler", "NT_GAME_OVER", null, new MessageMicro[] { paramNotifyMsg });
        a(l1, l2, str2, paramNotifyMsg, l3);
        return;
      case 109: 
        paramNotifyMsg = (AvGameNotify.NotifyAnswerFinishS2cReq)paramNotifyMsg.answer_finish_req.get();
        GameUtil.a("avgame_logic.GamePlayHandler", "NT_ALL_ANSWER_FINISH", null, new MessageMicro[] { paramNotifyMsg });
        a(l1, l2, str2, paramNotifyMsg, l3);
        return;
      case 108: 
        paramNotifyMsg = (AvGameNotify.NotifyActorGiveOutAnswerS2CReq)paramNotifyMsg.actor_giveout_answer_req.get();
        GameUtil.a("avgame_logic.GamePlayHandler", "NT_ACTOR_GIVEOUT_ANSWER", null, new MessageMicro[] { paramNotifyMsg });
        a(l1, l2, str2, paramNotifyMsg, l3);
        return;
      case 107: 
        paramNotifyMsg = (AvGameNotify.NotifyChangeActorS2CReq)paramNotifyMsg.change_actor_req.get();
        GameUtil.a("avgame_logic.GamePlayHandler", "NT_ACTOR_CHANGE", null, new MessageMicro[] { paramNotifyMsg });
        a(l1, l2, str2, paramNotifyMsg, l3);
        return;
      case 106: 
        paramNotifyMsg = (AvGameNotify.NotifyNextActorTipsS2CReq)paramNotifyMsg.next_actor_tips_req.get();
        GameUtil.a("avgame_logic.GamePlayHandler", "NT_NEXT_ACTOR_TIPS", null, new MessageMicro[] { paramNotifyMsg });
        a(l1, l2, str2, paramNotifyMsg, l3);
        return;
      case 105: 
        paramNotifyMsg = (AvGameNotify.NotifyChangeQuestionS2CReq)paramNotifyMsg.change_question_req.get();
        GameUtil.a("avgame_logic.GamePlayHandler", "NT_TOPIC_CHANGE", null, new MessageMicro[] { paramNotifyMsg });
        a(l1, l2, str2, paramNotifyMsg, l3);
        return;
      case 104: 
        paramNotifyMsg = (AvGameNotify.NotifyQuestionTimeoutS2CReq)paramNotifyMsg.question_timeout_req.get();
        GameUtil.a("avgame_logic.GamePlayHandler", "NT_TOPIC_TIMEOUT", null, new MessageMicro[] { paramNotifyMsg });
        a(l1, l2, str2, paramNotifyMsg, l3);
        return;
      case 103: 
        paramNotifyMsg = (AvGameNotify.NotifyAnswerRightS2CReq)paramNotifyMsg.answer_right_req.get();
        GameUtil.a("avgame_logic.GamePlayHandler", "NT_ANSWER_RIGHT", null, new MessageMicro[] { paramNotifyMsg });
        a(l1, l2, str2, paramNotifyMsg, l3);
        return;
      }
      paramNotifyMsg = (AvGameNotify.RoomOwnerStartGameS2CReq)paramNotifyMsg.start_game_req.get();
      GameUtil.a("avgame_logic.GamePlayHandler", "NT_GAME_START", null, new MessageMicro[] { paramNotifyMsg });
      a(l1, l2, str2, paramNotifyMsg, l3);
      return;
    }
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
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return GamePlayObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("qqvgame.GameManager-StartGame".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("qqvgame.QuestionManager-GetQuestion".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      int i = paramToServiceMsg.extraData.getInt("reqType");
      if (i == 0)
      {
        a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject, "handleSwitchTopicReq()", 1);
        return;
      }
      if (i == 1) {
        a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject, "handlePullTopics()", 13);
      }
    }
    else
    {
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
      if ("qqvgame.GameManager-AnswerQuestion".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.handler.GamePlayHandler
 * JD-Core Version:    0.7.0.1
 */