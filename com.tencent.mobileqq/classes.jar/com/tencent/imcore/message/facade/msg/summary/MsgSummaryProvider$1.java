package com.tencent.imcore.message.facade.msg.summary;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.IMsgSummaryCreator;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

class MsgSummaryProvider$1
  extends HashMap<Integer, IMsgSummaryCreator<QQMessageFacade, QQAppInterface>>
{
  MsgSummaryProvider$1(MsgSummaryProvider paramMsgSummaryProvider)
  {
    put(Integer.valueOf(0), new CommonMsgSummaryCreator());
    put(Integer.valueOf(1), new ConfessMsgSummaryCreator());
    put(Integer.valueOf(2), new TroopMsgSummaryCreator());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.msg.summary.MsgSummaryProvider.1
 * JD-Core Version:    0.7.0.1
 */