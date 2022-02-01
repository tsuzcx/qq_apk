package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;

public abstract interface IRoamMsgFetcher
{
  public abstract boolean a(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext, ArrayList<MessageRecord> paramArrayList, MessageRecord paramMessageRecord, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.IRoamMsgFetcher
 * JD-Core Version:    0.7.0.1
 */