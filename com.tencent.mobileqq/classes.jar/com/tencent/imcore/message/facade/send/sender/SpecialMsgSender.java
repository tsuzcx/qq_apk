package com.tencent.imcore.message.facade.send.sender;

import com.tencent.imcore.message.facade.IMessageSender;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.Arrays;

class SpecialMsgSender
  implements IMessageSender<QQAppInterface>
{
  private final ArrayList<Integer> a = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(-2011), Integer.valueOf(-2007), Integer.valueOf(-2002), Integer.valueOf(-2000), Integer.valueOf(-2020), Integer.valueOf(-2022), Integer.valueOf(-2039), Integer.valueOf(-5008), Integer.valueOf(-5012), Integer.valueOf(-5018), Integer.valueOf(-1051), Integer.valueOf(-2051), Integer.valueOf(-1035), Integer.valueOf(-2056), Integer.valueOf(-2057), Integer.valueOf(-2058), Integer.valueOf(-7001), Integer.valueOf(-5013), Integer.valueOf(-5014), Integer.valueOf(-5016), Integer.valueOf(-5017), Integer.valueOf(-7002), Integer.valueOf(-7005) }));
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    paramQQAppInterface.getMsgHandler().a(paramMessageRecord, paramBusinessObserver, paramBoolean);
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return this.a.contains(Integer.valueOf(paramMessageRecord.msgtype));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.send.sender.SpecialMsgSender
 * JD-Core Version:    0.7.0.1
 */