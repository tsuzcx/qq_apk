package com.tencent.biz.qqstory.settings;

import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class QQStoryShieldListActivity$1$1
  implements Runnable
{
  QQStoryShieldListActivity$1$1(QQStoryShieldListActivity.1 param1, List paramList) {}
  
  public void run()
  {
    if (this.b.a.f == null) {
      return;
    }
    Object localObject = this.b.a.f;
    boolean bool;
    if (this.b.a.a == 2) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = ((QQStoryManager)localObject).k(bool).iterator();
    QQStoryUserInfo localQQStoryUserInfo;
    while (((Iterator)localObject).hasNext())
    {
      localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject).next();
      if (this.b.a.f.i != null) {
        this.b.a.f.i.remove(localQQStoryUserInfo);
      }
    }
    localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject).next();
      if (this.b.a.f.i != null) {
        this.b.a.f.i.persistOrReplace(localQQStoryUserInfo);
      }
      if (this.b.a.f.A != null) {
        this.b.a.f.A.put(localQQStoryUserInfo.uin, localQQStoryUserInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldListActivity.1.1
 * JD-Core Version:    0.7.0.1
 */