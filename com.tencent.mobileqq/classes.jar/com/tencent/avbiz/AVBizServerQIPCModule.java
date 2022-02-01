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
  public static final String NAME = "AVBizServerQIPCModule";
  private static final String TAG = "AVBizServerQIPCModule";
  private static volatile AVBizServerQIPCModule sInstance;
  
  private AVBizServerQIPCModule(String paramString)
  {
    super(paramString);
    initBinderListener();
  }
  
  public static AVBizServerQIPCModule getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new AVBizServerQIPCModule("AVBizServerQIPCModule");
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private void handleAbandonAVFocus(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("module_name");
    AVBizPriorityManager.getInstance().abandonAVFocus(paramBundle);
  }
  
  private Bundle handleCheckAVFocus(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("module_name");
    paramBundle = AVBizPriorityManager.getInstance().checkAVFocus(paramBundle);
    Bundle localBundle = new Bundle();
    localBundle.putString("check_focus_result", paramBundle);
    return localBundle;
  }
  
  private Bundle handleGetFocusBusiness()
  {
    HashMap localHashMap = AVBizPriorityManager.getInstance().getFocusBusiness();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("get_focus_biz_result", localHashMap);
    return localBundle;
  }
  
  private Bundle handleGetInQueueBusiness()
  {
    HashSet localHashSet = AVBizPriorityManager.getInstance().getInQueueBusiness();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("get_in_queue_biz_result", localHashSet);
    return localBundle;
  }
  
  private Bundle handleRequestAVFocus(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("module_name");
    paramBundle = paramBundle.getString("process_name");
    paramBundle = AVBizPriorityManager.getInstance().requestAVFocus((String)localObject, paramBundle);
    localObject = new Bundle();
    ((Bundle)localObject).putString("request_focus_result", paramBundle);
    return localObject;
  }
  
  private void initBinderListener()
  {
    QIPCServerHelper.getInstance().getServer().addListener(new AVBizServerQIPCModule.1(this));
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
      return EIPCResult.createSuccessResult(handleRequestAVFocus(paramBundle));
    }
    if ("check_av_focus".equals(paramString)) {
      return EIPCResult.createSuccessResult(handleCheckAVFocus(paramBundle));
    }
    if ("abandon_av_focus".equals(paramString))
    {
      handleAbandonAVFocus(paramBundle);
    }
    else
    {
      if ("get_focus_business".equals(paramString)) {
        return EIPCResult.createSuccessResult(handleGetFocusBusiness());
      }
      if ("get_in_queue_business".equals(paramString)) {
        return EIPCResult.createSuccessResult(handleGetInQueueBusiness());
      }
    }
    return EIPCResult.UNKNOW_RESULT;
  }
  
  public void onSystemPhoneStatusChange(boolean paramBoolean)
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
      AVBizPriorityManager.getInstance().requestAVFocus("系统通话", "");
      return;
    }
    AVBizPriorityManager.getInstance().abandonAVFocus("系统通话");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.AVBizServerQIPCModule
 * JD-Core Version:    0.7.0.1
 */