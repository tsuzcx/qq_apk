package com.tencent.avbiz;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import mqq.util.WeakReference;

class AVBizClientQIPCModule
  extends QIPCModule
  implements IModule, IModule.FocusChangeListener
{
  private static String jdField_a_of_type_JavaLangString = "AVBizClientQIPCModule";
  private WeakReference<IModule.FocusChangeListener> jdField_a_of_type_MqqUtilWeakReference = new WeakReference(null);
  private final String b;
  
  AVBizClientQIPCModule(String paramString1, String paramString2)
  {
    super(paramString1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.b = paramString2;
  }
  
  public String a()
  {
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("module requestAVFocus, name[");
      localStringBuilder.append(this.name);
      localStringBuilder.append("], mProcessName[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("module_name", this.name);
    ((Bundle)localObject).putString("process_name", this.b);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("AVBizServerQIPCModule", "request_av_focus", (Bundle)localObject).data;
    if (localObject != null) {
      return ((Bundle)localObject).getString("request_focus_result");
    }
    return "IPC调用出错，返回数据为空";
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
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
  
  public void a(IModule.FocusChangeListener paramFocusChangeListener)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramFocusChangeListener);
  }
  
  public String b()
  {
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
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
  
  public void b()
  {
    IModule.FocusChangeListener localFocusChangeListener = (IModule.FocusChangeListener)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localFocusChangeListener != null) {
      localFocusChangeListener.b();
    }
  }
  
  public void c()
  {
    IModule.FocusChangeListener localFocusChangeListener = (IModule.FocusChangeListener)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localFocusChangeListener != null) {
      localFocusChangeListener.c();
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      paramBundle = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCall, action[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i(paramBundle, 4, localStringBuilder.toString());
    }
    if ("notify_focus_loss".equals(paramString)) {
      b();
    } else if ("notify_focus_gain".equals(paramString)) {
      c();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.AVBizClientQIPCModule
 * JD-Core Version:    0.7.0.1
 */