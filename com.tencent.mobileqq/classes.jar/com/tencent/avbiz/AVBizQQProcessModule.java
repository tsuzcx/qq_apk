package com.tencent.avbiz;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import mqq.util.WeakReference;

class AVBizQQProcessModule
  implements IModule, IModule.FocusChangeListener
{
  private static final String TAG = "AVBizQQProcessModule";
  private WeakReference<IModule.FocusChangeListener> mListenerWeakRef = new WeakReference(null);
  private final String mName;
  
  AVBizQQProcessModule(String paramString)
  {
    this.mName = paramString;
  }
  
  public void abandonAVFocus()
  {
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("module abandonAVFocus, name[");
      localStringBuilder.append(this.mName);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    AVBizPriorityManager.getInstance().abandonAVFocus(this.mName);
  }
  
  public String checkAVFocus()
  {
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("module checkAVFocus, name[");
      localStringBuilder.append(this.mName);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    return AVBizPriorityManager.getInstance().checkAVFocus(this.mName);
  }
  
  public HashMap<Long, String> getFocusBusiness()
  {
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("module getFocusBusiness, name[");
      localStringBuilder.append(this.mName);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    return AVBizPriorityManager.getInstance().getFocusBusiness();
  }
  
  public HashSet<String> getInQueueBusiness()
  {
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("module getFocusBusiness, name[");
      localStringBuilder.append(this.mName);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    return AVBizPriorityManager.getInstance().getInQueueBusiness();
  }
  
  public void onFocusGain()
  {
    IModule.FocusChangeListener localFocusChangeListener = (IModule.FocusChangeListener)this.mListenerWeakRef.get();
    if (localFocusChangeListener != null) {
      localFocusChangeListener.onFocusGain();
    }
  }
  
  public void onFocusLoss()
  {
    IModule.FocusChangeListener localFocusChangeListener = (IModule.FocusChangeListener)this.mListenerWeakRef.get();
    if (localFocusChangeListener != null) {
      localFocusChangeListener.onFocusLoss();
    }
  }
  
  public String requestAVFocus()
  {
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("module requestAVFocus, name[");
      localStringBuilder.append(this.mName);
      localStringBuilder.append("], processName[");
      localStringBuilder.append("com.tencent.mobileqq");
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    return AVBizPriorityManager.getInstance().requestAVFocus(this.mName, "com.tencent.mobileqq");
  }
  
  public void setListener(IModule.FocusChangeListener paramFocusChangeListener)
  {
    this.mListenerWeakRef = new WeakReference(paramFocusChangeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.AVBizQQProcessModule
 * JD-Core Version:    0.7.0.1
 */