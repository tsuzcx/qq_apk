package com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller;

import com.tencent.mobileqq.activity.contact.troop.generalgroupnotifyparser.GeneralGroupNotifyParser;
import com.tencent.mobileqq.app.QQAppInterface;

public class TroopNotificationGeneralGroupNotifyParserController
  extends ITroopNotificationController
{
  public TroopNotificationGeneralGroupNotifyParserController(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public GeneralGroupNotifyParser a(int paramInt)
  {
    return TroopNotificationGeneralGroupNotifyParserController.GeneralGroupNotifyParserProvider.a().a(paramInt);
  }
  
  public void a() {}
  
  public void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller.TroopNotificationGeneralGroupNotifyParserController
 * JD-Core Version:    0.7.0.1
 */