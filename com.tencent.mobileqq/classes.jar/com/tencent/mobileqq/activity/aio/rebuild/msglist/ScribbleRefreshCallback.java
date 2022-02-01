package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.core.msglist.IRefreshCallback;
import com.tencent.mobileqq.activity.aio.doodle.PlayLastLogic;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.List;

public class ScribbleRefreshCallback
  implements IRefreshCallback
{
  public void a(List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    PlayLastLogic.a().a(paramList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.ScribbleRefreshCallback
 * JD-Core Version:    0.7.0.1
 */