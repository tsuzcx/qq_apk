package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class GetJoinedHotChatListMessageStep
  extends AsyncStep
{
  public int a()
  {
    if (HotChatManager.a(this.a.app))
    {
      HotChatManager localHotChatManager = (HotChatManager)this.a.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      Object localObject = localHotChatManager.b();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(50);
        localStringBuilder.append("troopUin: ");
        Iterator localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext()) {
          localStringBuilder.append(((HotChatInfo)localIterator.next()).troopUin).append("  ");
        }
        QLog.d("GetJoinedHotChatListMessage", 2, localStringBuilder.toString());
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localHotChatManager.b((HotChatInfo)((Iterator)localObject).next(), 0);
      }
    }
    return 7;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListMessageStep
 * JD-Core Version:    0.7.0.1
 */