package com.tencent.mobileqq.apollo.persistence.api.impl;

import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class ApolloDaoManagerServiceImpl$1
  extends QQLruCache<String, ApolloBaseInfo>
{
  ApolloDaoManagerServiceImpl$1(ApolloDaoManagerServiceImpl paramApolloDaoManagerServiceImpl, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public ApolloBaseInfo a(String paramString, ApolloBaseInfo paramApolloBaseInfo)
  {
    if (paramApolloBaseInfo != null) {
      try
      {
        ApolloDaoManagerServiceImpl.access$000(this.a).remove(Long.valueOf(Long.parseLong(paramApolloBaseInfo.uin)));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e("[cmshow]ApolloDaoManager", 1, localNumberFormatException, new Object[0]);
      }
    }
    return (ApolloBaseInfo)super.put(paramString, paramApolloBaseInfo);
  }
  
  protected void a(boolean paramBoolean, String paramString, ApolloBaseInfo paramApolloBaseInfo1, ApolloBaseInfo paramApolloBaseInfo2)
  {
    super.entryRemoved(paramBoolean, paramString, paramApolloBaseInfo1, paramApolloBaseInfo2);
    if (paramApolloBaseInfo1 != null) {
      try
      {
        if (ApolloDaoManagerServiceImpl.access$000(this.a).size() < 1024)
        {
          ApolloDaoManagerServiceImpl.access$000(this.a).add(Long.valueOf(Long.parseLong(paramApolloBaseInfo1.uin)));
          return;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        QLog.e("[cmshow]ApolloDaoManager", 1, paramString, new Object[0]);
        return;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("[cmshow]ApolloDaoManager", 1, paramString, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */