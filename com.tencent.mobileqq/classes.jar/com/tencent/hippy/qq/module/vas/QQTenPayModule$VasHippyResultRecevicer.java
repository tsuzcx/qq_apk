package com.tencent.hippy.qq.module.vas;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;

public class QQTenPayModule$VasHippyResultRecevicer
  extends ResultReceiver
{
  private final Promise mPromise;
  
  public QQTenPayModule$VasHippyResultRecevicer(Promise paramPromise, Handler paramHandler)
  {
    super(paramHandler);
    this.mPromise = paramPromise;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("VasHippyResultReceiver receive = ");
      ((StringBuilder)localObject).append(this);
      QLog.i("QQTenPayModule", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resultCode = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" resultData = ");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.i("QQTenPayModule", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.mPromise != null) && (paramBundle != null))
    {
      if ((paramInt == 7) || (paramInt == 4) || (paramInt == 14))
      {
        localObject = paramBundle.getString("callbackSn");
        paramBundle = paramBundle.getString("result");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(this.mPromise.getCallId()))) {
          this.mPromise.resolve(paramBundle);
        }
      }
      else
      {
        return;
      }
      paramBundle = new StringBuilder();
      paramBundle.append("callbackSn wrong, callbackSn= ");
      paramBundle.append((String)localObject);
      QLog.e("QQTenPayModule", 1, paramBundle.toString());
      this.mPromise.reject("callbackSn wrong");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handle result error, promise = ");
    ((StringBuilder)localObject).append(this.mPromise);
    ((StringBuilder)localObject).append(" resultData = ");
    ((StringBuilder)localObject).append(paramBundle);
    QLog.e("QQTenPayModule", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.vas.QQTenPayModule.VasHippyResultRecevicer
 * JD-Core Version:    0.7.0.1
 */