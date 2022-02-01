package com.tencent.avbiz;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCServer;
import java.util.HashMap;
import java.util.HashSet;

public class AVBizServerQIPCModule
  extends QIPCModule
{
  private static volatile AVBizServerQIPCModule a;
  
  private AVBizServerQIPCModule(String paramString)
  {
    super(paramString);
    a();
  }
  
  private Bundle a()
  {
    HashMap localHashMap = AVBizPriorityManager.a().a();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("get_focus_biz_result", localHashMap);
    return localBundle;
  }
  
  private Bundle a(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("module_name");
    paramBundle = paramBundle.getString("process_name");
    paramBundle = AVBizPriorityManager.a().a((String)localObject, paramBundle);
    localObject = new Bundle();
    ((Bundle)localObject).putString("request_focus_result", paramBundle);
    return localObject;
  }
  
  public static AVBizServerQIPCModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new AVBizServerQIPCModule("AVBizServerQIPCModule");
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a()
  {
    QIPCServerHelper.getInstance().getServer().addListener(new AVBizServerQIPCModule.1(this));
  }
  
  private void a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("module_name");
    AVBizPriorityManager.a().a(paramBundle);
  }
  
  private Bundle b()
  {
    HashSet localHashSet = AVBizPriorityManager.a().a();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("get_in_queue_biz_result", localHashSet);
    return localBundle;
  }
  
  private Bundle b(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("module_name");
    paramBundle = AVBizPriorityManager.a().a(paramBundle);
    Bundle localBundle = new Bundle();
    localBundle.putString("check_focus_result", paramBundle);
    return localBundle;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPhoneStatusChange, isCalling[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i("AVBizServerQIPCModule", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      AVBizPriorityManager.a().a("系统通话", "");
      return;
    }
    AVBizPriorityManager.a().a("系统通话");
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCall, action[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("AVBizServerQIPCModule", 4, localStringBuilder.toString());
    }
    if ("request_av_focus".equals(paramString)) {
      return EIPCResult.createSuccessResult(a(paramBundle));
    }
    if ("check_av_focus".equals(paramString)) {
      return EIPCResult.createSuccessResult(b(paramBundle));
    }
    if ("abandon_av_focus".equals(paramString))
    {
      a(paramBundle);
    }
    else
    {
      if ("get_focus_business".equals(paramString)) {
        return EIPCResult.createSuccessResult(a());
      }
      if ("get_in_queue_business".equals(paramString)) {
        return EIPCResult.createSuccessResult(b());
      }
    }
    return EIPCResult.UNKNOW_RESULT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.AVBizServerQIPCModule
 * JD-Core Version:    0.7.0.1
 */