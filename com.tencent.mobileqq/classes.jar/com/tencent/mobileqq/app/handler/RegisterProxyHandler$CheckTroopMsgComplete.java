package com.tencent.mobileqq.app.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class RegisterProxyHandler$CheckTroopMsgComplete
{
  private StringBuilder b;
  private int c;
  private int d;
  
  public RegisterProxyHandler$CheckTroopMsgComplete(RegisterProxyHandler paramRegisterProxyHandler, StringBuilder paramStringBuilder, int paramInt)
  {
    this.b = paramStringBuilder;
    this.c = paramInt;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public CheckTroopMsgComplete c()
  {
    ArrayList localArrayList = new ArrayList();
    this.d = this.a.v.size();
    MessageCache localMessageCache = (MessageCache)RegisterProxyHandler.a(this.a).b().getMsgCache();
    Iterator localIterator = this.a.v.keySet().iterator();
    int i;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      i = 0;
      if (!bool) {
        break;
      }
      String str = (String)localIterator.next();
      long l2 = localMessageCache.M(str);
      Object localObject = localMessageCache.B(str);
      long l1;
      if ((localObject != null) && (localObject.length > 0)) {
        l1 = ((Long)localObject[1]).longValue();
      } else {
        l1 = 0L;
      }
      if (((localMessageCache.d(false)) || (((Boolean)this.a.v.get(str)).booleanValue())) && (l2 < l1))
      {
        if (QLog.isColorLevel())
        {
          this.b.setLength(0);
          localObject = this.b;
          ((StringBuilder)localObject).append("---------checkGroupMsgComplete needToPullTroop troopUin: ");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(",lastSeq:");
          ((StringBuilder)localObject).append(l2);
          ((StringBuilder)localObject).append(",svrSeq:");
          ((StringBuilder)localObject).append(l1);
          QLog.d("RegisterProxyHandler", 2, this.b.toString());
        }
        localArrayList.add(str);
      }
    }
    if (localArrayList.size() > 0)
    {
      this.c = localArrayList.size();
      this.a.h = new String[this.c];
      while (i < this.c)
      {
        this.a.h[i] = ((String)localArrayList.get(i));
        i += 1;
      }
    }
    this.a.v.clear();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.RegisterProxyHandler.CheckTroopMsgComplete
 * JD-Core Version:    0.7.0.1
 */