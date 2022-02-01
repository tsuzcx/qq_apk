package com.tencent.comic;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.comic.utils.AppHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
import mqq.app.AppRuntime;

public class VipComicRemoteCommand
  extends RemoteCommand
{
  private static Bundle jdField_a_of_type_AndroidOsBundle;
  boolean jdField_a_of_type_Boolean;
  
  public VipComicRemoteCommand(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static Bundle a(Bundle paramBundle)
  {
    try
    {
      Bundle localBundle = jdField_a_of_type_AndroidOsBundle;
      jdField_a_of_type_AndroidOsBundle = paramBundle;
      return localBundle;
    }
    finally
    {
      paramBundle = finally;
      throw paramBundle;
    }
  }
  
  public static void a()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler != null) {
      localPluginCommunicationHandler.register(new VipComicRemoteCommand("cacomicetinfo", true));
    }
  }
  
  private void a(AppInterface paramAppInterface, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.addFlags(268435456);
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).gotoProfile(localIntent, paramAppInterface, BaseApplication.getContext(), paramString, -1);
  }
  
  private boolean a(AppInterface paramAppInterface, String paramString)
  {
    paramAppInterface = (IPublicAccountDataManager)paramAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAppInterface != null)
    {
      bool1 = bool2;
      if (paramAppInterface.findPublicAccountInfo(paramString) != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private Bundle b(Bundle paramBundle)
  {
    Object localObject = AppHelper.a();
    if (!(localObject instanceof BaseQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicRemoteCommand", 2, "onRemoteInvoke cannot get QQAppInterface");
      }
      return null;
    }
    localObject = (BaseQQAppInterface)localObject;
    String str = paramBundle.getString("cacomicetinfo");
    if ("Remotecall_getPublicAccountState".equals(str))
    {
      paramBundle = paramBundle.getString("uin");
      if (!TextUtils.isEmpty(paramBundle))
      {
        boolean bool = a((AppInterface)localObject, paramBundle);
        paramBundle = new Bundle();
        paramBundle.putBoolean("state", bool);
        return paramBundle;
      }
    }
    else if ("Remotecall_showPublicAccountDetail".equals(str))
    {
      paramBundle = paramBundle.getString("uin");
      if (!TextUtils.isEmpty(paramBundle))
      {
        a((AppInterface)localObject, paramBundle);
        return null;
      }
    }
    else
    {
      if ("Remotecall_getUserStatus".equals(str))
      {
        paramBundle = new Bundle();
        if (VasUtil.a((AppRuntime)localObject).getVipStatus().isSVip())
        {
          paramBundle.putInt("userStatus", 3);
          return paramBundle;
        }
        if (VasUtil.a((AppRuntime)localObject).getVipStatus().isVip())
        {
          paramBundle.putInt("userStatus", 2);
          return paramBundle;
        }
        paramBundle.putInt("userStatus", 1);
        return paramBundle;
      }
      if ("Remotecall_initQbPlugin".equals(str)) {
        try
        {
          ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).preloadQWallet((AppInterface)localObject);
          if (QLog.isColorLevel()) {
            QLog.i("VipComicRemoteCommand", 2, "preloadQWallet()");
          }
          paramBundle = new Bundle();
          paramBundle.putBoolean("success", true);
          return paramBundle;
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
          return null;
        }
      }
      if ("Remotecall_showComicBar".equals(str))
      {
        a(paramBundle);
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipComicRemoteCommand", 2, "onRemoteInvoke unknow invokeCmd");
      }
    }
    return null;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    paramBundle = b(paramBundle);
    if (paramOnInvokeFinishLinstener != null) {
      paramOnInvokeFinishLinstener.onInvokeFinish(paramBundle);
    }
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.VipComicRemoteCommand
 * JD-Core Version:    0.7.0.1
 */