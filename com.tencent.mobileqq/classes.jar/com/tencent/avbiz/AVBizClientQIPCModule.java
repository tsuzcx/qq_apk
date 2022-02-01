package com.tencent.avbiz;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.HashMap;
import java.util.HashSet;
import mqq.util.WeakReference;

class AVBizClientQIPCModule
  extends QIPCModule
  implements IModule, IModule.FocusChangeListener
{
  private static final String TAG = "AVBizClientQIPCModule";
  private WeakReference<IModule.FocusChangeListener> mListenerWeakRef = new WeakReference(null);
  private final String mProcessName;
  
  AVBizClientQIPCModule(String paramString1, String paramString2)
  {
    super(paramString1);
    this.mProcessName = paramString2;
  }
  
  public void abandonAVFocus()
  {
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("module abandonAVFocus, name[");
      localStringBuilder.append(this.name);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("module_name", this.name);
    QIPCClientHelper.getInstance().getClient().callServer("AVBizServerQIPCModule", "abandon_av_focus", (Bundle)localObject);
  }
  
  public String checkAVFocus()
  {
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("module checkAVFocus, name[");
      localStringBuilder.append(this.name);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("module_name", this.name);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("AVBizServerQIPCModule", "check_av_focus", (Bundle)localObject).data;
    if (localObject != null) {
      return ((Bundle)localObject).getString("check_focus_result");
    }
    return "IPC调用出错，返回数据为空";
  }
  
  public HashMap<Long, String> getFocusBusiness()
  {
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("module getFocusBusiness, name[");
      localStringBuilder.append(this.name);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = QIPCClientHelper.getInstance().getClient().callServer("AVBizServerQIPCModule", "get_focus_business", new Bundle()).data;
    if (localObject != null) {
      return (HashMap)((Bundle)localObject).getSerializable("get_focus_biz_result");
    }
    return null;
  }
  
  public HashSet<String> getInQueueBusiness()
  {
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("module getInQueueBusiness, name[");
      localStringBuilder.append(this.name);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = QIPCClientHelper.getInstance().getClient().callServer("AVBizServerQIPCModule", "get_in_queue_business", new Bundle()).data;
    if (localObject != null) {
      return (HashSet)((Bundle)localObject).getSerializable("get_in_queue_biz_result");
    }
    return null;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      paramBundle = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCall, name[");
      localStringBuilder.append(this.name);
      localStringBuilder.append("], action[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i(paramBundle, 4, localStringBuilder.toString());
    }
    if ("notify_focus_loss".equals(paramString)) {
      onFocusLoss();
    } else if ("notify_focus_gain".equals(paramString)) {
      onFocusGain();
    }
    return null;
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
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("module requestAVFocus, name[");
      localStringBuilder.append(this.name);
      localStringBuilder.append("], mProcessName[");
      localStringBuilder.append(this.mProcessName);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("module_name", this.name);
    ((Bundle)localObject).putString("process_name", this.mProcessName);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("AVBizServerQIPCModule", "request_av_focus", (Bundle)localObject).data;
    if (localObject != null) {
      return ((Bundle)localObject).getString("request_focus_result");
    }
    return "IPC调用出错，返回数据为空";
  }
  
  public void setListener(IModule.FocusChangeListener paramFocusChangeListener)
  {
    this.mListenerWeakRef = new WeakReference(paramFocusChangeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.AVBizClientQIPCModule
 * JD-Core Version:    0.7.0.1
 */