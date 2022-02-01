package com.tencent.av.business.manager;

import android.util.SparseArray;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class EffectMutexManager
  extends BusinessManager
{
  private volatile SparseArray<EffectMutexManager.IMutexItem> d = null;
  
  protected EffectMutexManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  protected void a() {}
  
  public void a(int paramInt, EffectMutexManager.IMutexItem paramIMutexItem)
  {
    if (paramIMutexItem == null) {
      return;
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("registerMutexItem, key[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w("EffectMutexManager", 1, localStringBuilder.toString());
    }
    this.d.remove(paramInt);
    this.d.put(paramInt, paramIMutexItem);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyMutex, fromMuteKey[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], data[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.w("EffectMutexManager", 1, localStringBuilder.toString());
    }
    this.c.runOnUiThread(new EffectMutexManager.1(this, paramInt, paramString));
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectMutexManager
 * JD-Core Version:    0.7.0.1
 */