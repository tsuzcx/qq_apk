package com.tencent.mobileqq.app.proxy;

import com.tencent.mobileqq.persistence.EntityManager;

class DataLineMsgProxy$1
  implements Runnable
{
  DataLineMsgProxy$1(DataLineMsgProxy paramDataLineMsgProxy, EntityManager paramEntityManager, String paramString) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create index if not exists ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("_index ON ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("(groupId, msgId)");
    localEntityManager.execSQL(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.1
 * JD-Core Version:    0.7.0.1
 */