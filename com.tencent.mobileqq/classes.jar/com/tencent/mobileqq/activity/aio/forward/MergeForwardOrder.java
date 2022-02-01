package com.tencent.mobileqq.activity.aio.forward;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class MergeForwardOrder
  extends ForwardOrder
{
  void a(long paramLong1, long paramLong2)
  {
    try
    {
      if (this.c == null) {
        this.c = new HashSet();
      } else {
        this.c.clear();
      }
      this.c.add(Long.valueOf(paramLong1));
      if (this.b == null) {
        this.b = new HashSet();
      } else {
        this.b.clear();
      }
      this.b.add(Long.valueOf(paramLong1));
      return;
    }
    finally {}
  }
  
  void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((this.c != null) && (this.c.size() > 0) && (a(this.b) == paramMessageRecord.uniseq) && (!TextUtils.isEmpty(this.d)) && (this.e != null))
    {
      paramQQAppInterface = ChatActivityFacade.c(paramQQAppInterface, this.e, this.d);
      this.d = "";
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 0)) {
        this.g = paramQQAppInterface[0];
      }
    }
  }
  
  boolean a(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      Object localObject1 = this.c;
      break label21;
      localObject1 = this.b;
      label21:
      if ((localObject1 != null) && (((Set)localObject1).size() > 0))
      {
        localObject1 = ((Set)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          long l = ((Long)((Iterator)localObject1).next()).longValue();
          if (l == paramLong) {
            return true;
          }
        }
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if ((this.b != null) && (this.b.size() > 0) && (a(this.b) == paramLong) && (a(this.b) == paramLong) && (this.e != null) && (this.g > 0L))
    {
      MessageRecord localMessageRecord = paramQQAppInterface.getMessageFacade().b(this.e.b, this.e.a, this.g);
      if (localMessageRecord != null) {
        paramQQAppInterface.getMessageFacade().b(localMessageRecord, null, false);
      }
      this.g = 0L;
      a();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.forward.MergeForwardOrder
 * JD-Core Version:    0.7.0.1
 */