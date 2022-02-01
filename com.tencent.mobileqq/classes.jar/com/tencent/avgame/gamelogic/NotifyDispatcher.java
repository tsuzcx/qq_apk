package com.tencent.avgame.gamelogic;

import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.gamelogic.handler.GamePlayHandler;
import com.tencent.avgame.gamelogic.handler.GameRoomHandler;
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
    a.put(Integer.valueOf(1), Integer.valueOf(1));
    a.put(Integer.valueOf(2), Integer.valueOf(1));
    a.put(Integer.valueOf(3), Integer.valueOf(1));
    a.put(Integer.valueOf(4), Integer.valueOf(1));
    a.put(Integer.valueOf(101), Integer.valueOf(1));
    a.put(Integer.valueOf(102), Integer.valueOf(2));
    a.put(Integer.valueOf(103), Integer.valueOf(2));
    a.put(Integer.valueOf(104), Integer.valueOf(2));
    a.put(Integer.valueOf(105), Integer.valueOf(2));
    a.put(Integer.valueOf(106), Integer.valueOf(2));
    a.put(Integer.valueOf(107), Integer.valueOf(2));
    a.put(Integer.valueOf(108), Integer.valueOf(2));
    a.put(Integer.valueOf(110), Integer.valueOf(2));
    a.put(Integer.valueOf(201), Integer.valueOf(2));
    a.put(Integer.valueOf(109), Integer.valueOf(2));
    a.put(Integer.valueOf(403), Integer.valueOf(1));
    a.put(Integer.valueOf(501), Integer.valueOf(1));
    a.put(Integer.valueOf(502), Integer.valueOf(1));
    a.put(Integer.valueOf(503), Integer.valueOf(1));
    a.put(Integer.valueOf(504), Integer.valueOf(1));
    a.put(Integer.valueOf(505), Integer.valueOf(1));
    a.put(Integer.valueOf(506), Integer.valueOf(1));
    a.put(Integer.valueOf(507), Integer.valueOf(1));
    a.put(Integer.valueOf(508), Integer.valueOf(1));
    a.put(Integer.valueOf(509), Integer.valueOf(1));
  }
  
  private static BusinessHandler a(AVGameAppInterface paramAVGameAppInterface, int paramInt)
  {
    if (paramAVGameAppInterface == null) {
      return null;
    }
    paramInt = ((Integer)a.get(Integer.valueOf(paramInt))).intValue();
    if (paramInt == 1) {
      paramAVGameAppInterface = paramAVGameAppInterface.getBusinessHandler(HandlerFactory.a);
    }
    for (;;)
    {
      return paramAVGameAppInterface;
      if (paramInt == 2) {
        paramAVGameAppInterface = paramAVGameAppInterface.getBusinessHandler(HandlerFactory.c);
      } else {
        paramAVGameAppInterface = null;
      }
    }
  }
  
  public static void a(AVGameAppInterface paramAVGameAppInterface, AvGameNotify.NotifyMsg paramNotifyMsg)
  {
    paramAVGameAppInterface = a(paramAVGameAppInterface, paramNotifyMsg.type.get());
    if (paramAVGameAppInterface != null)
    {
      if (!(paramAVGameAppInterface instanceof GameRoomHandler)) {
        break label32;
      }
      ((GameRoomHandler)paramAVGameAppInterface).a(paramNotifyMsg);
    }
    label32:
    while (!(paramAVGameAppInterface instanceof GamePlayHandler)) {
      return;
    }
    ((GamePlayHandler)paramAVGameAppInterface).a(paramNotifyMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.NotifyDispatcher
 * JD-Core Version:    0.7.0.1
 */