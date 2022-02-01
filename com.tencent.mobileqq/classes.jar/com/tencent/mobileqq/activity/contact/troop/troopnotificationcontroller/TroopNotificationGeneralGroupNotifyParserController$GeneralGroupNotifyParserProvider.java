package com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller;

import com.tencent.mobileqq.activity.contact.troop.generalgroupnotifyparser.AllianceGeneralGroupNotifyParser;
import com.tencent.mobileqq.activity.contact.troop.generalgroupnotifyparser.GeneralGroupNotifyParser;
import com.tencent.mobileqq.activity.contact.troop.generalgroupnotifyparser.InviteJoinGroupSecFrontParser;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class TroopNotificationGeneralGroupNotifyParserController$GeneralGroupNotifyParserProvider
{
  private Map<Integer, GeneralGroupNotifyParser> a = new ConcurrentHashMap();
  
  public static GeneralGroupNotifyParserProvider a()
  {
    return TroopNotificationGeneralGroupNotifyParserController.GeneralGroupNotifyParserProvider.SingletonHolder.a();
  }
  
  private GeneralGroupNotifyParser b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 91: 
      return new AllianceGeneralGroupNotifyParser();
    }
    return new InviteJoinGroupSecFrontParser();
  }
  
  public GeneralGroupNotifyParser a(int paramInt)
  {
    Object localObject = (GeneralGroupNotifyParser)this.a.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      try
      {
        GeneralGroupNotifyParser localGeneralGroupNotifyParser2 = (GeneralGroupNotifyParser)this.a.get(Integer.valueOf(paramInt));
        localObject = localGeneralGroupNotifyParser2;
        if (localGeneralGroupNotifyParser2 == null)
        {
          localGeneralGroupNotifyParser2 = b(paramInt);
          localObject = localGeneralGroupNotifyParser2;
          if (localGeneralGroupNotifyParser2 != null)
          {
            this.a.put(Integer.valueOf(paramInt), localGeneralGroupNotifyParser2);
            localObject = localGeneralGroupNotifyParser2;
          }
        }
        return localObject;
      }
      finally {}
    }
    return localGeneralGroupNotifyParser1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller.TroopNotificationGeneralGroupNotifyParserController.GeneralGroupNotifyParserProvider
 * JD-Core Version:    0.7.0.1
 */