package com.tencent.imcore.message.facade.msg;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.ILastMsgGetter;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

class LastMsgGetterProvider$1
  extends HashMap<Integer, ILastMsgGetter<QQMessageFacade, QQAppInterface>>
{
  LastMsgGetterProvider$1(LastMsgGetterProvider paramLastMsgGetterProvider)
  {
    put(Integer.valueOf(0), new CommonLastMsgGetter());
    put(Integer.valueOf(1), new ConfessLastMsgGetter());
    put(Integer.valueOf(2), new LoadIfNotExistLastMsgGetter());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.msg.LastMsgGetterProvider.1
 * JD-Core Version:    0.7.0.1
 */