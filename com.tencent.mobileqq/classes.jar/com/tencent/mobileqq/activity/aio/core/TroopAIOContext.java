package com.tencent.mobileqq.activity.aio.core;

import android.view.View;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.List;

public class TroopAIOContext
  extends BaseTroopAIOContext
{
  public void Q()
  {
    ((TroopChatPie)this.c).bV();
  }
  
  public View R()
  {
    return this.c.aP;
  }
  
  public View S()
  {
    return this.c.aQ;
  }
  
  public int T()
  {
    return this.c.aR;
  }
  
  public int U()
  {
    return this.c.aS;
  }
  
  public List<ChatMessage> a(List<ChatMessage> paramList)
  {
    return ((TroopChatPie)this.c).b(paramList);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    ((TroopChatPie)this.c).a(paramString1, paramString2, paramBoolean, paramInt);
  }
  
  public boolean d(boolean paramBoolean)
  {
    return ((TroopChatPie)this.c).r(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopAIOContext
 * JD-Core Version:    0.7.0.1
 */