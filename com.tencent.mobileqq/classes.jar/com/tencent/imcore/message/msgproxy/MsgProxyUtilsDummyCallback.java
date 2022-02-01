package com.tencent.imcore.message.msgproxy;

import com.tencent.imcore.message.MsgProxyUtils.Callback;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class MsgProxyUtilsDummyCallback
  implements MsgProxyUtils.Callback
{
  public int a()
  {
    return 0;
  }
  
  public MessageRecord a(ArrayList<MessageRecord> paramArrayList)
  {
    return null;
  }
  
  public void a(Exception paramException, List<MessageRecord> paramList) {}
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return false;
  }
  
  public boolean a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return false;
  }
  
  public boolean a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, String paramString1, String paramString2)
  {
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord)
  {
    return false;
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    return false;
  }
  
  public boolean c(MessageRecord paramMessageRecord)
  {
    return false;
  }
  
  public boolean d(MessageRecord paramMessageRecord)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.imcore.message.msgproxy.MsgProxyUtilsDummyCallback
 * JD-Core Version:    0.7.0.1
 */