package com.tencent.avbiz;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class DefaultModule
  implements IModule
{
  private static final String TAG = "DefaultModule";
  IModule mIPCProxy;
  String mName;
  
  DefaultModule(String paramString1, String paramString2)
  {
    this.mName = paramString1;
    if (!"com.tencent.mobileqq".equals(paramString2)) {
      this.mIPCProxy = new AVBizClientQIPCModule(paramString1, paramString2);
    }
  }
  
  public void abandonAVFocus()
  {
    QLog.e(TAG, 1, "default module abandonAVFocus");
  }
  
  public String checkAVFocus()
  {
    HashMap localHashMap = getFocusBusiness();
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      if (("默认".equals(this.mName)) || ((l == 1L) && ("默认音频".equals(this.mName))) || ((l == 2L) && ("默认相机".equals(this.mName)))) {
        return (String)localHashMap.get(Long.valueOf(l));
      }
    }
    return "true";
  }
  
  public HashMap<Long, String> getFocusBusiness()
  {
    IModule localIModule = this.mIPCProxy;
    if (localIModule != null) {
      return localIModule.getFocusBusiness();
    }
    return AVBizPriorityManager.getInstance().getFocusBusiness();
  }
  
  public HashSet<String> getInQueueBusiness()
  {
    IModule localIModule = this.mIPCProxy;
    if (localIModule != null) {
      return localIModule.getInQueueBusiness();
    }
    return AVBizPriorityManager.getInstance().getInQueueBusiness();
  }
  
  public String requestAVFocus()
  {
    QLog.e(TAG, 1, "default module requestAVFocus");
    return "";
  }
  
  public void setListener(IModule.FocusChangeListener paramFocusChangeListener)
  {
    QLog.e(TAG, 1, "default module setListener");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.DefaultModule
 * JD-Core Version:    0.7.0.1
 */