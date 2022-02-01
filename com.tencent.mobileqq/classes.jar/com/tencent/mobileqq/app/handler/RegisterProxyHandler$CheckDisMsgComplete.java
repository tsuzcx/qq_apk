package com.tencent.mobileqq.app.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class RegisterProxyHandler$CheckDisMsgComplete
{
  private StringBuilder b;
  private int c;
  private int d;
  
  public RegisterProxyHandler$CheckDisMsgComplete(RegisterProxyHandler paramRegisterProxyHandler, StringBuilder paramStringBuilder, int paramInt)
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
  
  public CheckDisMsgComplete c()
  {
    ArrayList localArrayList = new ArrayList();
    this.d = this.a.w.size();
    MessageCache localMessageCache = (MessageCache)RegisterProxyHandler.a(this.a).b().getMsgCache();
    Iterator localIterator = this.a.w.keySet().iterator();
    int i;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      i = 0;
      if (!bool) {
        break;
      }
      String str = (String)localIterator.next();
      long l2 = localMessageCache.L(str);
      Object localObject = localMessageCache.A(str);
      long l1;
      if ((localObject != null) && (localObject.length > 0)) {
        l1 = ((Long)localObject[1]).longValue();
      } else {
        l1 = 0L;
      }
      if (((localMessageCache.d(false)) || (((Boolean)this.a.w.get(str)).booleanValue())) && (l2 < l1))
      {
        if (QLog.isColorLevel())
        {
          this.b.setLength(0);
          localObject = this.b;
          ((StringBuilder)localObject).append("---------checkGroupMsgComplete needToPullDiscuss discussUin: ");
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
      this.a.i = new String[this.c];
      while (i < this.c)
      {
        this.a.i[i] = ((String)localArrayList.get(i));
        i += 1;
      }
    }
    this.a.w.clear();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.RegisterProxyHandler.CheckDisMsgComplete
 * JD-Core Version:    0.7.0.1
 */