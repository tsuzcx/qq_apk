package com.tencent.mobileqq.activity.aio.forward;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

abstract class ForwardOrder
{
  int a;
  Set<Long> b;
  Set<Long> c;
  String d;
  SessionInfo e;
  HashMap<Long, Long> f = new HashMap();
  long g;
  
  long a(Set<Long> paramSet)
  {
    if ((paramSet != null) && (paramSet.size() > 0))
    {
      paramSet = paramSet.toArray();
      if ((paramSet != null) && (paramSet.length > 0))
      {
        paramSet = paramSet[0];
        if ((paramSet instanceof Long)) {
          return ((Long)paramSet).longValue();
        }
      }
    }
    return 0L;
  }
  
  ForwardOrder a(SessionInfo paramSessionInfo, String paramString, List<Long> paramList, int paramInt)
  {
    this.a = paramInt;
    this.e = paramSessionInfo;
    this.d = paramString;
    if (paramList != null)
    {
      this.b = new HashSet(paramList);
      this.c = new HashSet(paramList);
      if (QLog.isColorLevel())
      {
        paramSessionInfo = new StringBuilder();
        paramSessionInfo.append("Forward order onPreForward mChatMsgListAfter.size() -> ");
        paramSessionInfo.append(this.b.size());
        paramSessionInfo.append(", mChatMsgListBefore.size() -> ");
        paramSessionInfo.append(this.c.size());
        paramSessionInfo.append(", ForwardID -> ");
        paramSessionInfo.append(paramInt);
        QLog.d("ForwardOrderManager", 2, paramSessionInfo.toString());
      }
    }
    return this;
  }
  
  void a()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ForwardOrder onDestroy forward id -> ");
        localStringBuilder.append(this.a);
        QLog.d("ForwardOrderManager", 2, localStringBuilder.toString());
      }
      this.e = null;
      this.d = "";
      this.g = 0L;
      if (this.b != null)
      {
        this.b.clear();
        this.b = null;
      }
      if (this.c != null)
      {
        this.c.clear();
        this.c = null;
      }
      if (this.f != null)
      {
        this.f.clear();
        this.f = null;
      }
      return;
    }
    finally {}
  }
  
  void a(long paramLong)
  {
    try
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ForwardOrder msgIDToSend id -> ");
        localStringBuilder.append(paramLong);
        QLog.d("ForwardOrderManager", 2, localStringBuilder.toString());
      }
      if (this.b != null)
      {
        this.b.add(Long.valueOf(paramLong));
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ForwardOrder mChatMsgListAfter add id -> ");
          localStringBuilder.append(paramLong);
          QLog.d("ForwardOrderManager", 2, localStringBuilder.toString());
        }
      }
      if (this.c != null)
      {
        this.c.add(Long.valueOf(paramLong));
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ForwardOrder mChatMsgListBefore add id -> ");
          localStringBuilder.append(paramLong);
          QLog.d("ForwardOrderManager", 2, localStringBuilder.toString());
        }
      }
      return;
    }
    finally {}
  }
  
  abstract void a(long paramLong1, long paramLong2);
  
  abstract void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord);
  
  boolean a(long paramLong, Set<Long> paramSet)
  {
    if (paramSet != null) {}
    try
    {
      if (!paramSet.isEmpty())
      {
        paramSet = paramSet.iterator();
        while (paramSet.hasNext()) {
          if (((Long)paramSet.next()).longValue() == paramLong) {
            return true;
          }
        }
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramSet;
    }
  }
  
  abstract boolean a(long paramLong, boolean paramBoolean);
  
  abstract boolean a(QQAppInterface paramQQAppInterface, long paramLong);
  
  void b(long paramLong1, long paramLong2)
  {
    try
    {
      if ((this.b != null) && (this.b.size() > 0) && (this.b.contains(Long.valueOf(paramLong1))))
      {
        this.b.remove(Long.valueOf(paramLong1));
        this.b.add(Long.valueOf(paramLong2));
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Forward order replaceOriginChatMsg mChatMsgListAfter.size() -> ");
          localStringBuilder.append(this.b.size());
          localStringBuilder.append(", mChatMsgListAfter remove uniSeq -> ");
          localStringBuilder.append(paramLong1);
          localStringBuilder.append(", mChatMsgListAfter add uniSeq -> ");
          localStringBuilder.append(paramLong2);
          localStringBuilder.append(", ForwardID -> ");
          localStringBuilder.append(this.a);
          QLog.d("ForwardOrderManager", 2, localStringBuilder.toString());
        }
      }
      if ((this.c != null) && (this.c.size() > 0) && (this.c.contains(Long.valueOf(paramLong1))))
      {
        this.c.remove(Long.valueOf(paramLong1));
        this.c.add(Long.valueOf(paramLong2));
      }
      return;
    }
    finally {}
  }
  
  void b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      if ((this.c != null) && (this.c.size() > 0))
      {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext()) {
          if (((Long)localIterator.next()).longValue() == paramLong) {
            localIterator.remove();
          }
        }
        if ((this.c.size() <= 0) && (!TextUtils.isEmpty(this.d)) && (this.e != null))
        {
          paramQQAppInterface = ChatActivityFacade.c(paramQQAppInterface, this.e, this.d);
          this.d = "";
          if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 0)) {
            this.g = paramQQAppInterface[0];
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramQQAppInterface;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.forward.ForwardOrder
 * JD-Core Version:    0.7.0.1
 */