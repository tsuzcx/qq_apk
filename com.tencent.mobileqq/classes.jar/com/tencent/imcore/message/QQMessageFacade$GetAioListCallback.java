package com.tencent.imcore.message;

import com.tencent.mobileqq.data.ChatMessage;
import java.util.List;

public abstract interface QQMessageFacade$GetAioListCallback
{
  public abstract void onGetAioList(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, List<ChatMessage> paramList, QQMessageFacade paramQQMessageFacade);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.QQMessageFacade.GetAioListCallback
 * JD-Core Version:    0.7.0.1
 */