package com.qwallet.temp.impl;

import Wallet.GetPasswordReq;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.qwallet.temp.IQWalletApiProxy;
import com.qwallet.temp.IQWalletApiProxy.OnDecodeListener;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QWalletAuthHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.PatternLockUtils;
import cooperation.qwallet.plugin.QWalletPicHelper;
import cooperation.qwallet.plugin.ipc.TickReq;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class QWalletApiProxyImpl
  implements IQWalletApiProxy
{
  private static final String TAG = "QwalletApiProxyImpl";
  
  public void decodeDrawable(Drawable paramDrawable, IQWalletApiProxy.OnDecodeListener paramOnDecodeListener)
  {
    if ((paramDrawable instanceof URLDrawable))
    {
      paramDrawable = (URLDrawable)paramDrawable;
      if (paramDrawable.getStatus() == 1)
      {
        if (paramOnDecodeListener != null) {
          paramOnDecodeListener.a(true, paramDrawable);
        }
      }
      else {
        ThreadManager.excute(new QWalletApiProxyImpl.1(this, paramDrawable, paramOnDecodeListener), 16, null, false);
      }
    }
    else if (paramOnDecodeListener != null)
    {
      paramOnDecodeListener.a(true, paramDrawable);
    }
  }
  
  public boolean getAppForground(Context paramContext)
  {
    return GesturePWDUtils.getAppForground(paramContext);
  }
  
  public Drawable getDrawableForWallet(String paramString, Drawable paramDrawable, Bundle paramBundle)
  {
    paramString = QWalletPicHelper.getDrawableInner(paramString, paramString, paramDrawable, paramDrawable, new int[] { 26 }, paramBundle);
    ApngImage.playByTag(26);
    return paramString;
  }
  
  public boolean launchPlugin(Context paramContext, Bundle paramBundle)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((paramContext != null) && (paramBundle != null))
    {
      if (localAppRuntime == null) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("launchPlugin comeFrom = ");
        localStringBuilder.append(paramBundle.getInt("comeForm"));
        QLog.i("QwalletApiProxyImpl", 2, localStringBuilder.toString());
      }
      ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).launchPayService(paramContext, localAppRuntime, paramBundle);
      if ((paramBundle.getInt("launch_type", 0) == 0) && ((paramContext instanceof Activity)))
      {
        paramContext = (Activity)paramContext;
        ThreadManager.getSubThreadHandler().post(new QWalletApiProxyImpl.2(this, localAppRuntime, paramContext));
      }
      return true;
    }
    return false;
  }
  
  public void onPubAcc(String paramString)
  {
    AppRuntime localAppRuntime = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getRuntime();
    if ((localAppRuntime != null) && (!TextUtils.isEmpty(paramString)) && ((localAppRuntime instanceof AppInterface))) {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).followUin((AppInterface)localAppRuntime, localAppRuntime.getApp(), paramString, null, false);
    }
  }
  
  public void onSetBaseActivityUnlockSuceess()
  {
    com.tencent.mobileqq.app.BaseActivity.isUnLockSuccess = true;
  }
  
  public void setLastExitWalletTime(long paramLong, TickReq paramTickReq)
  {
    try
    {
      Context localContext = BaseApplicationImpl.getContext().getApplicationContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(BaseApplicationImpl.sApplication.getRuntime().getLongAccountUin());
      localStringBuilder.append("");
      PatternLockUtils.setLastExitWalletTime(localContext, localStringBuilder.toString(), paramTickReq.exitQWalletTime);
      return;
    }
    catch (Throwable paramTickReq) {}
  }
  
  public void syncQWalletPatternLock(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (PatternLockUtils.getSyncPatternLockState(paramBaseQQAppInterface.getApp(), paramBaseQQAppInterface.getCurrentUin()))
    {
      GetPasswordReq localGetPasswordReq = new GetPasswordReq();
      localGetPasswordReq.MQOS = "Android";
      localGetPasswordReq.MQVersion = DeviceInfoUtil.a(paramBaseQQAppInterface.getApp());
      ((QWalletAuthHandler)paramBaseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QWALLET_AUTH_HANDLER)).a(localGetPasswordReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.qwallet.temp.impl.QWalletApiProxyImpl
 * JD-Core Version:    0.7.0.1
 */