package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IReloadFilter;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.jubao.JubaoHelper;
import java.util.List;

public class JubaoReloadFilter
  implements IReloadFilter
{
  public List<ChatMessage> a(AIOContext paramAIOContext, List<ChatMessage> paramList)
  {
    Object localObject = paramList;
    if (paramAIOContext.b()) {
      localObject = JubaoHelper.a(paramList);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.JubaoReloadFilter
 * JD-Core Version:    0.7.0.1
 */