package com.tencent.mobileqq.app;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.relationx.friendclue.FriendClueManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.ProfileCardUtil.AvatarUploadResult;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

public class CommonModule
  extends QIPCModule
{
  public static CommonModule a;
  
  private CommonModule()
  {
    super("CommonModule");
  }
  
  public static CommonModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new CommonModule();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(Intent paramIntent)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSetAvatarBackResult， intent=");
      ((StringBuilder)localObject).append(paramIntent);
      QLog.d("CommonModule", 2, ((StringBuilder)localObject).toString());
    }
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("param_callback_id", -1);
      int j = paramIntent.getIntExtra("param_result_code", -99999);
      paramIntent = paramIntent.getStringExtra("param_result_desc");
      if (i > 0)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("param_result_code", j);
        ((Bundle)localObject).putString("param_result_desc", paramIntent);
        ((Bundle)localObject).putString("param_action", "set_avatar");
        callbackResult(i, EIPCResult.createSuccessResult((Bundle)localObject));
      }
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("action = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", params = ");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.d("CommonModule", 2, ((StringBuilder)localObject).toString());
    }
    Bundle localBundle = new Bundle();
    boolean bool = "getPhoneBindState".equals(paramString);
    Object localObject = "";
    if (bool)
    {
      paramString = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramString instanceof QQAppInterface))
      {
        localBundle.putInt("selfBindState", ((IPhoneContactService)paramString.getRuntimeService(IPhoneContactService.class, "")).getSelfBindState());
        return EIPCResult.createSuccessResult(localBundle);
      }
    }
    else if ("set_avatar".equals(paramString))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface))
      {
        paramString = (String)localObject;
        if (paramBundle != null) {
          paramString = paramBundle.getString("param_avatar_path");
        }
        paramBundle = new Intent();
        paramBundle.putExtra("PhotoConst.SOURCE_FROM", "FROM_MINI_APP");
        paramBundle.putExtra("param_callback_id", paramInt);
        paramString = ProfileCardUtil.a((QQAppInterface)localAppRuntime, paramString, paramBundle);
        if (paramString.jdField_a_of_type_Int != 0)
        {
          localBundle.putInt("param_result_code", paramString.jdField_a_of_type_Int);
          localBundle.putString("param_result_desc", paramString.jdField_a_of_type_JavaLangString);
          localBundle.putString("param_action", "set_avatar");
          callbackResult(paramInt, EIPCResult.createSuccessResult(localBundle));
        }
        else
        {
          return null;
        }
      }
    }
    else if ("jumpToCommonGroup".equals(paramString))
    {
      paramString = BaseApplicationImpl.getApplication().getRuntime();
      if (((paramString instanceof QQAppInterface)) && (paramBundle != null))
      {
        paramBundle = paramBundle.getString("cur_friend_uin");
        ((FriendClueManager)paramString.getManager(QQManagerFactory.FRIEND_CLUE_MANAGER)).b(paramBundle);
      }
    }
    else if ("jumpToRemarkEdit".equals(paramString))
    {
      paramString = BaseApplicationImpl.getApplication().getRuntime();
      if (((paramString instanceof QQAppInterface)) && (paramBundle != null))
      {
        paramBundle = paramBundle.getString("cur_friend_uin");
        ((FriendClueManager)paramString.getManager(QQManagerFactory.FRIEND_CLUE_MANAGER)).a(paramBundle);
      }
    }
    return EIPCResult.createSuccessResult(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.CommonModule
 * JD-Core Version:    0.7.0.1
 */