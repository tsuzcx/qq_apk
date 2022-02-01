package com.tencent.avbiz;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCServer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

class AVBusiness
{
  private static long SEQ = 0L;
  private static final String TAG = "AVBusiness";
  private final String mName;
  private final HashMap<Long, Integer> mPriorityMap;
  private final String mProcessName;
  private final long mRequestType;
  private final long mSeq;
  
  AVBusiness(String paramString1, String paramString2)
  {
    this.mName = paramString1;
    this.mProcessName = paramString2;
    this.mRequestType = ((Long)Constants.REQUEST_DEVICE_MAP.get(paramString1)).longValue();
    this.mPriorityMap = initPriorityMap(paramString1, this.mRequestType);
    if (("音视频通话".equals(paramString1)) && (paramString2 != null) && (!paramString2.isEmpty()))
    {
      this.mSeq = 0L;
      return;
    }
    long l = SEQ;
    SEQ = 1L + l;
    this.mSeq = l;
  }
  
  private static HashMap<Long, Integer> initPriorityMap(String paramString, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    long l2 = 1L;
    long l1 = paramLong;
    Object localObject;
    for (paramLong = l2; l1 != 0L; paramLong <<= 1)
    {
      if ((l1 & 1L) != 0L)
      {
        localObject = (List)Constants.Priority.PRIORITY_MAP.get(Long.valueOf(paramLong));
        int i = 0;
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          if (((HashSet)((Iterator)localObject).next()).contains(paramString))
          {
            localHashMap.put(Long.valueOf(paramLong), Integer.valueOf(i));
            break;
          }
          i += 1;
        }
      }
      l1 >>= 1;
    }
    if (QLog.isColorLevel())
    {
      paramString = localHashMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        localObject = (Map.Entry)paramString.next();
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mPriorityMap, type[");
        localStringBuilder.append(((Map.Entry)localObject).getKey());
        localStringBuilder.append("], priority[");
        localStringBuilder.append(((Map.Entry)localObject).getValue());
        localStringBuilder.append("]");
        QLog.i(str, 2, localStringBuilder.toString());
      }
    }
    return localHashMap;
  }
  
  public boolean comparePriority(AVBusiness paramAVBusiness)
  {
    long l2 = getRequestType() & paramAVBusiness.getRequestType();
    boolean bool2;
    for (long l1 = 1L;; l1 <<= 1)
    {
      bool2 = false;
      bool1 = false;
      if (l2 == 0L) {
        break;
      }
      if ((l2 & 1L) != 0L)
      {
        int i = ((Integer)this.mPriorityMap.get(Long.valueOf(l1))).intValue();
        int j = ((Integer)paramAVBusiness.mPriorityMap.get(Long.valueOf(l1))).intValue();
        if (i < j) {
          return true;
        }
        if (i > j) {
          return false;
        }
      }
      l2 >>= 1;
    }
    if ((Constants.AUDIO_PLAYER_BUSINESS.contains(getName())) && (Constants.AUDIO_PLAYER_BUSINESS.contains(paramAVBusiness.getName())))
    {
      if (this.mSeq > paramAVBusiness.mSeq) {
        bool1 = true;
      }
      return bool1;
    }
    boolean bool1 = bool2;
    if (this.mSeq < paramAVBusiness.mSeq) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof AVBusiness))
    {
      String str = this.mName;
      if (str != null)
      {
        paramObject = (AVBusiness)paramObject;
        if (str.equals(paramObject.mName))
        {
          str = this.mProcessName;
          if ((str != null) && (str.equals(paramObject.mProcessName)) && (this.mRequestType == paramObject.mRequestType) && (this.mSeq == paramObject.mSeq)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public void gainFocus()
  {
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gainFocus, business[");
      localStringBuilder.append(this.mName);
      localStringBuilder.append("], process[");
      localStringBuilder.append(this.mProcessName);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.mProcessName;
    if ((localObject != null) && (!((String)localObject).isEmpty()) && (!"com.tencent.mobileqq".equals(this.mProcessName)))
    {
      QIPCServerHelper.getInstance().getServer().callClient(this.mProcessName, 1, this.mName, "notify_focus_gain", new Bundle(), null);
      return;
    }
    localObject = AVBizModuleFactory.getModuleByName(this.mName);
    if ((localObject instanceof IModule.FocusChangeListener)) {
      ((IModule.FocusChangeListener)localObject).onFocusGain();
    }
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public long getRequestType()
  {
    return this.mRequestType;
  }
  
  public void lossFocus()
  {
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("lossFocus, business[");
      localStringBuilder.append(this.mName);
      localStringBuilder.append("], process[");
      localStringBuilder.append(this.mProcessName);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.mProcessName;
    if ((localObject != null) && (!((String)localObject).isEmpty()) && (!"com.tencent.mobileqq".equals(this.mProcessName)))
    {
      QIPCServerHelper.getInstance().getServer().callClient(this.mProcessName, 1, this.mName, "notify_focus_loss", new Bundle(), null);
      return;
    }
    localObject = AVBizModuleFactory.getModuleByName(this.mName);
    if ((localObject instanceof IModule.FocusChangeListener)) {
      ((IModule.FocusChangeListener)localObject).onFocusLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.AVBusiness
 * JD-Core Version:    0.7.0.1
 */