package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import mqq.app.AppRuntime;

public abstract interface GetAioListCallback
{
  public abstract void a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, List<MessageRecord> paramList, AppRuntime paramAppRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.GetAioListCallback
 * JD-Core Version:    0.7.0.1
 */