package com.tencent.mobileqq.app.handler;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.HashMap;
import java.util.List;

public abstract interface RegisterProxyHandler$Callback
{
  public abstract HashMap<Integer, String[]> a(int paramInt);
  
  public abstract List<String> a();
  
  public abstract void a(MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.RegisterProxyHandler.Callback
 * JD-Core Version:    0.7.0.1
 */