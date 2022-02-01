package com.tencent.avgame.gamelogic;

import android.support.annotation.Nullable;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.Topic;
import com.tencent.avgame.gamelogic.data.TopicActGuess;
import com.tencent.avgame.gamelogic.data.TopicMosaicGuess;
import com.tencent.avgame.gamelogic.data.TopicOperGuessVideo;
import com.tencent.avgame.gamelogic.data.TopicSongGuess;
import com.tencent.avgame.gamelogic.data.TopicTextGuess;
import com.tencent.avgame.gamelogic.data.UserScore;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.RoomInfo;
import trpc.qq_vgame.game_ranking.AvGameRanking.GetRankingListRsp;
import trpc.qq_vgame.game_ranking.AvGameRanking.UserScoreInfo;

public class GameUtil
{
  static HashMap<Integer, Class<? extends Topic>> a = new HashMap(5);
  
  static
  {
    a.put(Integer.valueOf(1), TopicActGuess.class);
    a.put(Integer.valueOf(2), TopicMosaicGuess.class);
    a.put(Integer.valueOf(3), TopicOperGuessVideo.class);
    a.put(Integer.valueOf(4), TopicSongGuess.class);
    a.put(Integer.valueOf(5), TopicTextGuess.class);
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 2) {
      return 2;
    }
    if ((paramInt >= 3) && (paramInt <= 102)) {
      return 3;
    }
    if ((paramInt >= 103) && (paramInt <= 202)) {
      return 2;
    }
    if ((paramInt >= 300) && (paramInt <= 399)) {
      return 5;
    }
    if ((paramInt >= 400) && (paramInt <= 499)) {
      return 4;
    }
    return 0;
  }
  
  /* Error */
  @Nullable
  public static IGame a(trpc.qq_vgame.common.AvGameCommon.GameStatusInfo paramGameStatusInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 47	com/tencent/avgame/gamelogic/data/Game
    //   9: dup
    //   10: invokespecial 48	com/tencent/avgame/gamelogic/data/Game:<init>	()V
    //   13: astore_1
    //   14: aload_1
    //   15: aload_0
    //   16: invokeinterface 53 2 0
    //   21: aload_1
    //   22: areturn
    //   23: astore_2
    //   24: aload_1
    //   25: astore_0
    //   26: aload_2
    //   27: astore_1
    //   28: goto +6 -> 34
    //   31: astore_1
    //   32: aconst_null
    //   33: astore_0
    //   34: ldc 55
    //   36: iconst_1
    //   37: iconst_3
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: ldc 57
    //   45: aastore
    //   46: dup
    //   47: iconst_1
    //   48: aload_1
    //   49: invokevirtual 61	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   52: aastore
    //   53: dup
    //   54: iconst_2
    //   55: aload_1
    //   56: aastore
    //   57: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   60: aload_0
    //   61: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	paramGameStatusInfo	trpc.qq_vgame.common.AvGameCommon.GameStatusInfo
    //   13	15	1	localObject	Object
    //   31	25	1	localException1	Exception
    //   23	4	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   14	21	23	java/lang/Exception
    //   6	14	31	java/lang/Exception
  }
  
  public static ITopic a(AvGameCommon.GameQuestionInfo paramGameQuestionInfo, boolean paramBoolean)
  {
    if (paramGameQuestionInfo == null) {
      return null;
    }
    int i = a(paramGameQuestionInfo.type.get());
    Object localObject = (Class)a.get(Integer.valueOf(i));
    if (localObject == null) {
      return null;
    }
    localObject = (ITopic)((Class)localObject).newInstance();
    ((ITopic)localObject).a(paramBoolean);
    ((ITopic)localObject).a(paramGameQuestionInfo);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameUtil", 2, String.format("parseTopic {\n%s\n}", new Object[] { localObject }));
    }
    return localObject;
  }
  
  @Nullable
  public static RoomInfo a(AvGameCommon.RoomInfo paramRoomInfo)
  {
    if (paramRoomInfo != null)
    {
      RoomInfo localRoomInfo = new RoomInfo();
      localRoomInfo.parseFrom(paramRoomInfo);
      return localRoomInfo;
    }
    return null;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 201)
            {
              if (paramInt != 403)
              {
                switch (paramInt)
                {
                default: 
                  return String.valueOf(paramInt);
                case 109: 
                  return "NT_ALL_ANSWER_FINISH";
                case 108: 
                  return "NT_ACTOR_GIVEOUT_ANSWER";
                case 107: 
                  return "NT_ACTOR_CHANGE";
                case 106: 
                  return "NT_NEXT_ACTOR_TIPS";
                case 105: 
                  return "NT_TOPIC_CHANGE";
                case 104: 
                  return "NT_TOPIC_TIMEOUT";
                case 103: 
                  return "NT_ANSWER_RIGHT";
                case 102: 
                  return "NT_GAME_START";
                }
                return "NT_GAME_CHANGE";
              }
              return "NT_MATCH_STATUS";
            }
            return "NT_TRANSLATE_INFO";
          }
          return "NT_ROOM_USER_CHANGE_STATUS";
        }
        return "NT_ROOM_DESTORY";
      }
      return "NT_ROOM_LEAVE";
    }
    return "NT_ROOM_ENTER";
  }
  
  public static <F, S> String a(List<Pair<F, S>> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Pair localPair = (Pair)paramList.next();
      localStringBuilder.append("\n");
      localStringBuilder.append("[");
      localStringBuilder.append(localPair.first);
      localStringBuilder.append(",");
      localStringBuilder.append(localPair.second);
      localStringBuilder.append("]");
    }
    return localStringBuilder.toString();
  }
  
  public static List<UserScore> a(AvGameRanking.GetRankingListRsp paramGetRankingListRsp)
  {
    ArrayList localArrayList = new ArrayList();
    paramGetRankingListRsp = paramGetRankingListRsp.ranking_list.get();
    if ((paramGetRankingListRsp != null) && (paramGetRankingListRsp.size() > 0))
    {
      int i = 0;
      while (i < paramGetRankingListRsp.size())
      {
        UserScore localUserScore = new UserScore();
        localUserScore.parseFrom((AvGameRanking.UserScoreInfo)paramGetRankingListRsp.get(i));
        localArrayList.add(localUserScore);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static void a(String paramString1, String paramString2, String[] paramArrayOfString, MessageMicro... paramVarArgs)
  {
    new StringBuilder(1024);
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 1;
  }
  
  public static boolean a(GameItem paramGameItem)
  {
    if ((paramGameItem.a != 2) && (paramGameItem.a != 300))
    {
      if (paramGameItem.a == 400) {
        return false;
      }
      int i = a(paramGameItem.a);
      return (i == 3) || (i == 5) || (i == 4) || (i == 2);
    }
    return false;
  }
  
  @Nullable
  public static ITopic b(AvGameCommon.GameQuestionInfo paramGameQuestionInfo, boolean paramBoolean)
  {
    try
    {
      paramGameQuestionInfo = a(paramGameQuestionInfo, paramBoolean);
      return paramGameQuestionInfo;
    }
    catch (Exception paramGameQuestionInfo)
    {
      QLog.d("avgame_logic.GameUtil", 1, new Object[] { "getTopic ex=", paramGameQuestionInfo.getMessage(), paramGameQuestionInfo });
    }
    catch (IllegalAccessException paramGameQuestionInfo)
    {
      QLog.d("avgame_logic.GameUtil", 1, new Object[] { "getTopic ex=", paramGameQuestionInfo.getMessage(), paramGameQuestionInfo });
    }
    catch (InstantiationException paramGameQuestionInfo)
    {
      QLog.d("avgame_logic.GameUtil", 1, new Object[] { "getTopic ex=", paramGameQuestionInfo.getMessage(), paramGameQuestionInfo });
    }
    return null;
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4);
  }
  
  public static boolean b(GameItem paramGameItem)
  {
    boolean bool2 = false;
    if (paramGameItem == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (a(paramGameItem))
    {
      bool1 = bool2;
      if (paramGameItem.b == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean c(int paramInt)
  {
    return paramInt == 3;
  }
  
  public static boolean d(int paramInt)
  {
    return (paramInt > 0) && (paramInt <= 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.GameUtil
 * JD-Core Version:    0.7.0.1
 */