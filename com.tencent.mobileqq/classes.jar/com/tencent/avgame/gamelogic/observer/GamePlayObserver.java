package com.tencent.avgame.gamelogic.observer;

import android.os.SystemClock;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.AnswerInfo;
import com.tencent.avgame.gamelogic.data.GameInfo;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.UserScore;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public abstract class GamePlayObserver
  implements BusinessObserver
{
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "NT_CMD_GAME_PLAY_START_REQ";
    case 1: 
      return "NT_CMD_GAME_PLAY_SWITCH_TOPIC_REQ";
    case 2: 
      return "NT_PUSH_GAME_PLAY_START";
    case 3: 
      return "NT_PUSH_GAME_PLAY_OVER";
    case 4: 
      return "NT_PUSH_GAME_PLAY_PLAYER_CHANGE";
    case 5: 
      return "NT_PUSH_GAME_PLAY_TOPIC_CHANGE";
    case 6: 
      return "NT_PUSH_GAME_PLAY_NEXT_PLAYER_TIP";
    case 7: 
      return "NT_PUSH_GAME_PLAY_ANSWER_RIGHT";
    case 8: 
      return "NT_PUSH_GAME_PLAY_ANSWER_TIMEOUT";
    case 9: 
      return "NT_PUSH_GAME_PLAY_ANSWER_GIVEOUT_BYPLAYER";
    case 10: 
      return "NT_CMD_GAME_PLAY_GET_RANKING_REQ";
    case 11: 
      return "NT_RC_GAME_RESULT_UPLOAD";
    case 12: 
      return "NT_PUSH_GAME_PLAY_TRANSLATION_INFO";
    case 13: 
      return "NT_CMD_GAME_PLAY_PULL_TOPICS_REQ";
    case 14: 
      return "NT_CMD_GAME_SEND_CLICK_ANSWER";
    case 15: 
      return "NT_CMD_GAME_ANSWER_FINISH";
    case 16: 
      return "NT_CMD_GAME_SEND_VOICE_ANSWER";
    }
    return "NT_CMD_GAME_SEND_NORMAL_VOICE_ANSWER";
  }
  
  protected void a() {}
  
  public abstract void a(long paramLong1, long paramLong2, String paramString);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2, ITopic paramITopic, Player paramPlayer, long paramLong3, AnswerInfo paramAnswerInfo);
  
  protected void a(long paramLong1, long paramLong2, String paramString1, long paramLong3, int paramInt, String paramString2, String paramString3) {}
  
  public abstract void a(long paramLong1, long paramLong2, String paramString, ITopic paramITopic);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString, ITopic paramITopic, Player paramPlayer);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString1, ITopic paramITopic, String paramString2);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString, GameInfo paramGameInfo, Player paramPlayer, ITopic paramITopic);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString1, String paramString2, ITopic paramITopic);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString1, String paramString2, Player paramPlayer);
  
  protected void a(long paramLong1, long paramLong2, String paramString, List<AnswerInfo> paramList, ITopic paramITopic, int paramInt) {}
  
  public abstract void a(long paramLong1, String paramString, long paramLong2, ITopic paramITopic);
  
  public abstract void a(long paramLong, String paramString1, String paramString2);
  
  public abstract void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, RoomInfo paramRoomInfo, List<Long> paramList);
  
  public abstract void a(String paramString1, long paramLong1, int paramInt, long paramLong2, String paramString2, GameInfo paramGameInfo, Player paramPlayer, ITopic paramITopic);
  
  public abstract void a(String paramString1, String paramString2, String paramString3);
  
  public abstract void a(String paramString1, String paramString2, List<UserScore> paramList);
  
  protected void a(boolean paramBoolean1, int paramInt1, String paramString1, boolean paramBoolean2, String paramString2, int paramInt2) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2) {}
  
  public abstract void b(long paramLong1, String paramString, long paramLong2, ITopic paramITopic);
  
  public abstract void b(long paramLong, String paramString1, String paramString2);
  
  protected void b(boolean paramBoolean1, int paramInt1, String paramString1, boolean paramBoolean2, String paramString2, int paramInt2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    paramObject = (Object[])paramObject;
    long l2 = SystemClock.elapsedRealtime();
    if (paramInt == 0) {
      if (paramBoolean)
      {
        a((String)paramObject[0], ((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Long)paramObject[3]).longValue(), (String)paramObject[4], (GameInfo)paramObject[5], (Player)paramObject[6], (ITopic)paramObject[7]);
        l1 = 0L;
        if (QLog.isColorLevel())
        {
          paramObject = a(paramInt);
          if (l1 <= 0L) {
            break label1259;
          }
        }
      }
    }
    label1259:
    for (long l1 = l2 - l1;; l1 = 0L)
    {
      QLog.i("GamePlayObserver.cost", 2, String.format("onUpdate()=[%s] pushCost=[%dms] handleCost=[%dms]", new Object[] { paramObject, Long.valueOf(l1), Long.valueOf(SystemClock.elapsedRealtime() - l2) }));
      return;
      a((String)paramObject[0], ((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), (String)paramObject[4], (RoomInfo)paramObject[5], (List)paramObject[6]);
      l1 = 0L;
      break;
      if (paramInt == 1)
      {
        if (paramBoolean)
        {
          a(((Long)paramObject[0]).longValue(), (String)paramObject[1], ((Long)paramObject[2]).longValue(), (ITopic)paramObject[3]);
          l1 = 0L;
          break;
        }
        a(((Long)paramObject[0]).longValue(), (String)paramObject[1], (String)paramObject[2]);
        l1 = 0L;
        break;
      }
      if (paramInt == 2)
      {
        l1 = ((Long)paramObject[6]).longValue();
        a(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), (String)paramObject[2], (GameInfo)paramObject[3], (Player)paramObject[4], (ITopic)paramObject[5]);
        break;
      }
      if (paramInt == 3)
      {
        l1 = ((Long)paramObject[3]).longValue();
        a(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), (String)paramObject[2]);
        break;
      }
      if (paramInt == 6)
      {
        l1 = ((Long)paramObject[5]).longValue();
        a(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), (String)paramObject[2], (String)paramObject[3], (Player)paramObject[4]);
        break;
      }
      if (paramInt == 4)
      {
        l1 = ((Long)paramObject[5]).longValue();
        a(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), (String)paramObject[2], (ITopic)paramObject[3], (Player)paramObject[4]);
        break;
      }
      if (paramInt == 5)
      {
        l1 = ((Long)paramObject[5]).longValue();
        a(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), (String)paramObject[2], (ITopic)paramObject[3], (String)paramObject[4]);
        break;
      }
      if (paramInt == 7)
      {
        l1 = ((Long)paramObject[9]).longValue();
        a(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), (String)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), (ITopic)paramObject[5], (Player)paramObject[6], ((Long)paramObject[7]).longValue(), (AnswerInfo)paramObject[8]);
        break;
      }
      if (paramInt == 8)
      {
        l1 = ((Long)paramObject[4]).longValue();
        a(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), (String)paramObject[2], (ITopic)paramObject[3]);
        break;
      }
      if (paramInt == 9)
      {
        l1 = ((Long)paramObject[5]).longValue();
        a(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), (String)paramObject[2], (String)paramObject[3], (ITopic)paramObject[4]);
        break;
      }
      if (paramInt == 10)
      {
        if (paramBoolean)
        {
          a((String)paramObject[0], (String)paramObject[1], (List)paramObject[2]);
          l1 = 0L;
          break;
        }
        a((String)paramObject[0], (String)paramObject[1], (String)paramObject[2]);
        l1 = 0L;
        break;
      }
      if (paramInt == 11)
      {
        a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
        l1 = 0L;
        break;
      }
      if (paramInt == 12)
      {
        l1 = ((Long)paramObject[7]).longValue();
        a(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), (String)paramObject[2], ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), (String)paramObject[5], (String)paramObject[6]);
        break;
      }
      if (paramInt == 13)
      {
        if (paramBoolean)
        {
          b(((Long)paramObject[0]).longValue(), (String)paramObject[1], ((Long)paramObject[2]).longValue(), (ITopic)paramObject[3]);
          l1 = 0L;
          break;
        }
        b(((Long)paramObject[0]).longValue(), (String)paramObject[1], (String)paramObject[2]);
        l1 = 0L;
        break;
      }
      if (paramInt == 14)
      {
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], ((Boolean)paramObject[2]).booleanValue(), (String)paramObject[3], ((Integer)paramObject[4]).intValue());
        l1 = 0L;
        break;
      }
      if (paramInt == 15)
      {
        l1 = ((Long)paramObject[6]).longValue();
        a(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), (String)paramObject[2], (List)paramObject[3], (ITopic)paramObject[4], ((Integer)paramObject[5]).intValue());
        break;
      }
      if (paramInt == 16)
      {
        b(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], ((Boolean)paramObject[2]).booleanValue(), (String)paramObject[3], ((Integer)paramObject[4]).intValue());
        l1 = 0L;
        break;
      }
      if (paramInt == 17) {
        a();
      }
      l1 = 0L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.observer.GamePlayObserver
 * JD-Core Version:    0.7.0.1
 */