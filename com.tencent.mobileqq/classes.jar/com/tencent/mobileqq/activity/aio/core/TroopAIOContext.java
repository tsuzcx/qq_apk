package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.data.ChatMessage;
import java.util.List;

public class TroopAIOContext
  extends BaseTroopAIOContext
{
  public List<ChatMessage> a(List<ChatMessage> paramList)
  {
    return ((TroopChatPie)this.a).a(paramList);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    ((TroopChatPie)this.a).a(paramString1, paramString2, paramBoolean, paramInt);
  }
  
  public boolean a(boolean paramBoolean)
  {
    return ((TroopChatPie)this.a).b(paramBoolean);
  }
  
  public void g()
  {
    ((TroopChatPie)this.a).aD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopAIOContext
 * JD-Core Version:    0.7.0.1
 */