package com.tencent.avgame.util;

import com.tencent.avgame.business.handler.HandlerFactory;
import java.util.Map;

public class AVGameCmdUtil
{
  public static final String[] a = { "qqvgame.RoomManager-RoomInfoGet", "qqvgame.GameManager-SelectGame", "qqvgame.GameList-GetGameList", "qqvgame.RoomManager-RoomLeave", "qqvgame.RoomManager-RoomUserStatusChange", "qqvgame.UserHeartBeat-UserHeartBeat", "qqvgame.Share-GetShareLink", "qqvgame.GameList-GetQuestionClass", "qqvgame.ActivityCenter-GetActivitys", "qqvgame.ActivityCenter-SyncShareGame", "qqvgame.StrangerMatch-AddMatchRoom", "qqvgame.StrangerMatch-DelMatchRoom", "qqvgame.PKManager-PKOperation", "qqvgame.PKManager-GetPKInfo", "qqvgame.RoomManager-RoomCreate", "qqvgame.RoomManager-RoomEnter", "qqvgame.StrangerMatchV2-AddMatchRoom", "qqvgame.StrangerMatchV2-DelMatchRoom" };
  public static final String[] b = { "qqvgame.GameManager-StartGame", "qqvgame.QuestionManager-GetQuestion", "qqvgame.GameRanking-GetRankingList", "qqvgame.QuestionManager-AnswerQuestion", "qqvgame.GameManager-AnswerQuestion" };
  public static final String[] c = { "OnlinePush.ReqPush" };
  public static final String[] d = { "OidbSvc.0x5eb_20002" };
  
  public static void a(Map<String, String[]> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    String[] arrayOfString = b;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramMap.put(arrayOfString[i], new String[] { HandlerFactory.c });
      i += 1;
    }
    arrayOfString = a;
    j = arrayOfString.length;
    i = 0;
    while (i < j)
    {
      paramMap.put(arrayOfString[i], new String[] { HandlerFactory.a });
      i += 1;
    }
    arrayOfString = c;
    j = arrayOfString.length;
    i = 0;
    while (i < j)
    {
      paramMap.put(arrayOfString[i], new String[] { HandlerFactory.d });
      i += 1;
    }
    arrayOfString = d;
    j = arrayOfString.length;
    i = 0;
    while (i < j)
    {
      paramMap.put(arrayOfString[i], new String[] { HandlerFactory.b });
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.util.AVGameCmdUtil
 * JD-Core Version:    0.7.0.1
 */