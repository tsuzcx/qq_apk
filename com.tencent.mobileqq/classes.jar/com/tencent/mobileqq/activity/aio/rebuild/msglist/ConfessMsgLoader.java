package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import androidx.annotation.NonNull;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.BaseMsgLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ConfessMsgLoader
  extends BaseMsgLoader
{
  @NonNull
  private List<ChatMessage> a(List<ChatMessage> paramList, BaseSessionInfo paramBaseSessionInfo)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      if (((ChatMessage)paramList.get(i)).getConfessTopicId() == paramBaseSessionInfo.e)
      {
        localArrayList.add(paramList.get(i));
        if ((((ChatMessage)paramList.get(i)).msgtype == 1032) && (QLog.isColorLevel())) {
          QLog.i("ConfessMsgLoader", 2, "ConfessChatPie has illegal msgType!");
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public List<ChatMessage> a(@NonNull AIOContext paramAIOContext)
  {
    return a(a(paramAIOContext, false), paramAIOContext.a());
  }
  
  public List<ChatMessage> a(@NonNull AIOContext paramAIOContext, boolean paramBoolean)
  {
    BaseSessionInfo localBaseSessionInfo = paramAIOContext.a();
    return a(paramAIOContext.a().getMessageFacade().a(localBaseSessionInfo.jdField_a_of_type_JavaLangString, localBaseSessionInfo.jdField_a_of_type_Int, -1L, localBaseSessionInfo.e, paramBoolean), localBaseSessionInfo);
  }
  
  public void a(@NonNull AIOContext paramAIOContext)
  {
    ThreadManager.post(new ConfessMsgLoader.1(this, paramAIOContext), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.ConfessMsgLoader
 * JD-Core Version:    0.7.0.1
 */