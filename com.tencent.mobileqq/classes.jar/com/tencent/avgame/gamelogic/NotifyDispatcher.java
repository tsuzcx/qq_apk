package com.tencent.avgame.gamelogic;

import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.gamelogic.handler.GamePlayHandler;
import com.tencent.avgame.gamelogic.handler.GameRoomHandler;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.pb.PBEnumField;
import java.util.HashMap;
import java.util.Map;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyMsg;

public class NotifyDispatcher
{
  private static Map<Integer, Integer> a = new HashMap(16);
  
  static
  {
    Map localMap = a;
    Integer localInteger1 = Integer.valueOf(1);
    localMap.put(localInteger1, localInteger1);
    localMap = a;
    Integer localInteger2 = Integer.valueOf(2);
    localMap.put(localInteger2, localInteger1);
    a.put(Integer.valueOf(3), localInteger1);
    a.put(Integer.valueOf(4), localInteger1);
    a.put(Integer.valueOf(101), localInteger1);
    a.put(Integer.valueOf(102), localInteger2);
    a.put(Integer.valueOf(103), localInteger2);
    a.put(Integer.valueOf(104), localInteger2);
    a.put(Integer.valueOf(105), localInteger2);
    a.put(Integer.valueOf(106), localInteger2);
    a.put(Integer.valueOf(107), localInteger2);
    a.put(Integer.valueOf(108), localInteger2);
    a.put(Integer.valueOf(110), localInteger2);
    a.put(Integer.valueOf(201), localInteger2);
    a.put(Integer.valueOf(109), localInteger2);
    a.put(Integer.valueOf(403), localInteger1);
    a.put(Integer.valueOf(501), localInteger1);
    a.put(Integer.valueOf(502), localInteger1);
    a.put(Integer.valueOf(503), localInteger1);
    a.put(Integer.valueOf(504), localInteger1);
    a.put(Integer.valueOf(505), localInteger1);
    a.put(Integer.valueOf(506), localInteger1);
    a.put(Integer.valueOf(507), localInteger1);
    a.put(Integer.valueOf(508), localInteger1);
    a.put(Integer.valueOf(509), localInteger1);
  }
  
  private static BusinessHandler a(BaseAVGameAppInterface paramBaseAVGameAppInterface, int paramInt)
  {
    BusinessHandler localBusinessHandler = null;
    if (paramBaseAVGameAppInterface == null) {
      return null;
    }
    paramInt = ((Integer)a.get(Integer.valueOf(paramInt))).intValue();
    if (paramInt == 1) {
      return paramBaseAVGameAppInterface.getBusinessHandler(HandlerFactory.a);
    }
    if (paramInt == 2) {
      localBusinessHandler = paramBaseAVGameAppInterface.getBusinessHandler(HandlerFactory.c);
    }
    return localBusinessHandler;
  }
  
  public static void a(BaseAVGameAppInterface paramBaseAVGameAppInterface, AvGameNotify.NotifyMsg paramNotifyMsg)
  {
    paramBaseAVGameAppInterface = a(paramBaseAVGameAppInterface, paramNotifyMsg.type.get());
    if (paramBaseAVGameAppInterface != null)
    {
      if ((paramBaseAVGameAppInterface instanceof GameRoomHandler))
      {
        ((GameRoomHandler)paramBaseAVGameAppInterface).a(paramNotifyMsg);
        return;
      }
      if ((paramBaseAVGameAppInterface instanceof GamePlayHandler)) {
        ((GamePlayHandler)paramBaseAVGameAppInterface).a(paramNotifyMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.NotifyDispatcher
 * JD-Core Version:    0.7.0.1
 */