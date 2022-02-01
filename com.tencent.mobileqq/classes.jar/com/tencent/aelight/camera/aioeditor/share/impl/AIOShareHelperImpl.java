package com.tencent.aelight.camera.aioeditor.share.impl;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.aelight.camera.aioeditor.share.AIOShareObject;
import com.tencent.aelight.camera.aioeditor.share.IAIOShareHelper;
import com.tencent.aelight.camera.aioeditor.share.IAIOShareHelper.AIOWXShareListener;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import mqq.os.MqqHandler;

public class AIOShareHelperImpl
  implements IAIOShareHelper
{
  private static final String TAG = "AIOShareHelperImpl";
  private QQProgressDialog mLoadingDialog;
  
  private boolean isUIThread()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  public void dismissLoading()
  {
    AIOShareHelperImpl.7 local7 = new AIOShareHelperImpl.7(this);
    if (isUIThread())
    {
      local7.run();
      return;
    }
    ThreadManager.getUIHandler().post(local7);
  }
  
  public void shareToQQ(@NonNull Activity paramActivity, int paramInt, @Nullable String paramString, @NonNull AIOShareObject paramAIOShareObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("real shareToQQ: uinType = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", uin = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", shareObj = ");
    ((StringBuilder)localObject).append(paramAIOShareObject);
    AEQLog.b("AIOShareHelperImpl", ((StringBuilder)localObject).toString());
    localObject = new Intent();
    paramString = new AIOShareHelperImpl.1(this, (Intent)localObject, paramActivity, paramString, paramInt, paramAIOShareObject);
    if (paramAIOShareObject.g())
    {
      ((Intent)localObject).putExtra("key_help_forward_pic", true);
      ((Intent)localObject).putExtra("forward_type", 1);
      ((Intent)localObject).setData(Uri.parse(paramAIOShareObject.b()));
      ThreadManager.getUIHandler().post(paramString);
      return;
    }
    if (paramAIOShareObject.h())
    {
      showLoading(paramActivity);
      paramActivity = new AIOShareHelperImpl.2(this, paramAIOShareObject, (Intent)localObject, paramString);
      ThreadManager.getFileThreadHandler().post(paramActivity);
    }
  }
  
  public void shareToQZone(@NonNull Activity paramActivity, @NonNull AIOShareObject paramAIOShareObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("real shareToQZone, shareObj = ");
    localStringBuilder.append(paramAIOShareObject);
    AEQLog.b("AIOShareHelperImpl", localStringBuilder.toString());
    ThreadManager.getUIHandler().post(new AIOShareHelperImpl.3(this, paramAIOShareObject, paramActivity));
  }
  
  public void shareToWX(@NonNull Activity paramActivity, int paramInt, String paramString, @NonNull AIOShareObject paramAIOShareObject, @Nullable IAIOShareHelper.AIOWXShareListener paramAIOWXShareListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("real shareToWX, shareType = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", transaction = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", shareObj = ");
    localStringBuilder.append(paramAIOShareObject);
    AEQLog.b("AIOShareHelperImpl", localStringBuilder.toString());
    if (!WXShareHelper.a().b())
    {
      AEQLog.d("AIOShareHelperImpl", "shareToWeChat error: wechat not install");
      QQToast.makeText(paramActivity, 1, 2131918154, 0).show();
      return;
    }
    if (!WXShareHelper.a().c())
    {
      AEQLog.d("AIOShareHelperImpl", "shareToWeChat error: wechat version not support");
      QQToast.makeText(paramActivity, 1, 2131918155, 0).show();
      return;
    }
    if (paramAIOWXShareListener != null) {
      WXShareHelper.a().a(new AIOShareHelperImpl.4(this, paramAIOWXShareListener, paramInt, paramString, paramAIOShareObject));
    }
    showLoading(paramActivity);
    paramActivity = new AIOShareHelperImpl.5(this, paramAIOShareObject, paramAIOWXShareListener, paramInt, paramString);
    ThreadManager.getFileThreadHandler().post(paramActivity);
  }
  
  public void showLoading(Activity paramActivity)
  {
    paramActivity = new AIOShareHelperImpl.6(this, paramActivity);
    if (isUIThread())
    {
      paramActivity.run();
      return;
    }
    ThreadManager.getUIHandler().post(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.share.impl.AIOShareHelperImpl
 * JD-Core Version:    0.7.0.1
 */